/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.tommy.excel.base.listener;

import cn.tommy.excel.base.model.BaseExcelReadModel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 解析监听器基类
 *
 * @author Tommy
 */
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public abstract class BaseExcelDataListener<T extends BaseExcelReadModel>
        extends AnalysisEventListener<T> {

    private List<T> result = Lists.newArrayList();

    @Override
    public void invoke (T data, AnalysisContext context) {
        result.add(data);
    }

    @Override
    public void doAfterAllAnalysed (AnalysisContext context) {
        log.info("sheet:{},共计:{}行" + "解析完成！", + context.getCurrentSheet().getSheetNo(), + context.getCurrentRowNum());
    }
}
