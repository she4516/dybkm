package com.zsl.dybkm.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelReadContentListener extends AnalysisEventListener<Map<Integer, String>> {

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
        System.out.println();
    }
}
