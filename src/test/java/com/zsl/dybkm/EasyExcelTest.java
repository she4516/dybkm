package com.zsl.dybkm;


import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zsl.dybkm.common.listener.ExcelReadContentListener;
import com.zsl.dybkm.common.listener.ExcelReadMainLstener;
import com.zsl.dybkm.exception.BizException;
import com.zsl.dybkm.sys.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EasyExcelTest {

    private String baseDir="D:\\BaiduNetdiskDownload\\文件文档\\数据检测工具-V0.17";

    private String module = "应用模型初始化";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void readExcel2Test(){
        String fileName = baseDir+"\\template\\应用初始化\\"+module+".xlsx";
        // 读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, new AnalysisEventListener<Map<Integer, String>>() {
            @Override
            public void invoke(Map<Integer, String> map1, AnalysisContext analysisContext) {
                if (Objects.equals(map1.get(4),"√") && validTableExist(map1.get(1))){
                    log.info("start insert "+map1.get(1));
                    EasyExcel.read(fileName, new AnalysisEventListener<Map<Integer, String>>() {

                        private Map<Integer, String> currentHeadMap = new HashMap<>();

                        private int i = 1;

                        @Override
                        public void invoke(Map<Integer, String> map2, AnalysisContext analysisContext) {
                            Map<String, String> rMap = new HashMap<>();
                            String tableName = map1.get(1);
                            String sheetName = map1.get(2);
                            map2.keySet().stream().forEach(f -> {
                                rMap.put(currentHeadMap.get(f),map2.get(f));
                            });
                            boolean insertFlag = readFiled(tableName, sheetName,rMap);
                            if (insertFlag){
                                log.info("已经插入"+i+"条");
                                i++;
                                return;
                            }
                            log.error(tableName +"insert error","第"+i+"条插入失败!");
                        }

                        @Override
                        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
                            currentHeadMap = headMap;

                        }

                        @Override
                        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                            log.info("end insert "+map1.get(1));
                        }
                    }).sheet(map1.get(2)).doRead();
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet().doRead();
    }


    private boolean validTableExist(String tableName){
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            DatabaseMetaData dmd = conn.getMetaData();
            ResultSet rs = dmd.getTables(conn.getCatalog(), null, tableName, null);
            if (rs.next()) {
                //开始清空数据
                String deleteSql="truncate table "+tableName;
                jdbcTemplate.execute(deleteSql);
                return true;
            }
            log.error(tableName+"表不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean readFiled(String tableName,String sheetName,Map<String, String> rMap){
        try {
            String fileName = baseDir+"\\data\\ana_map\\"+module+"\\"+module+"&L##V&"+sheetName+"&L##V&"+tableName;
            if (!FileUtil.exist(fileName)){
                throw new BizException(fileName+"文件不存在!");
            }
            List<String> lines = FileUtil.readLines(fileName, Charset.defaultCharset());
            if (CollectionUtils.isEmpty(lines) || lines.size()!=2){
                throw new BizException(fileName+"内容读取有误!");
            }
            List<String> headerList =  Stream.of(lines.get(0).split("&L##V&")).collect(Collectors.toList());
            List<String> filedList =  Stream.of(lines.get(1).split("&L##V&")).collect(Collectors.toList());
            if(headerList.size()!=filedList.size()){
                throw new BizException(fileName+"长度不匹配!");
            }
            List<String> data = getData(headerList, rMap);
            String sql = buildInsertSql(tableName, filedList, data);
            jdbcTemplate.execute(sql);
            return true;
        }catch (BizException e){
            log.error("插入"+tableName+"失败,"+e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            log.error("插入"+tableName+"失败");
        }
        return false;
    }



    private List<String> getData(List<String> data,Map<String, String> rMap){
        return data.stream().map(f->rMap.get(f)).collect(Collectors.toList());
    }

    private String buildInsertSql(String tableName,List<String> filedList,List<String> data){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO "+tableName );
        sqlBuilder.append("(");
        sqlBuilder.append(filedList.stream()
                .map(s->(StringUtils.isBlank(s)||Objects.equals("null",s))?"":s)
                .map(s->"`"+s+"`")
                .collect(Collectors.joining(",")));
        sqlBuilder.append(")");
        sqlBuilder.append("VALUES");
        sqlBuilder.append("(");
        sqlBuilder.append(data.stream()
                .map(s->(StringUtils.isBlank(s)||Objects.equals("null",s))?"":s)
                .map(s->"'"+s+"'").collect(Collectors.joining(",")));
        sqlBuilder.append(")");
        return sqlBuilder.toString();
    }
}
