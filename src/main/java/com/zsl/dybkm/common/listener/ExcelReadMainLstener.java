package com.zsl.dybkm.common.listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;
import java.util.Objects;

public class ExcelReadMainLstener extends AnalysisEventListener<Map<Integer, String>> {
    @Override
    public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
        //读取到的每行数据,其key是以0开始的索引
        System.out.println(map);
        if (Objects.equals(map.get(4),"√")){
            String fileName = "D:\\BaiduNetdiskDownload\\文件文档\\" +
                    "数据检测工具-V0.17\\template\\应用初始化\\应用一次性初始化.xlsx";
            // 读取第一个sheet 文件流会自动关闭
            EasyExcel.read(fileName,new ExcelReadContentListener()).sheet(map.get(2)).doRead();
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
