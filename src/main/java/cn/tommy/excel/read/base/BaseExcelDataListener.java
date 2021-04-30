package cn.tommy.excel.read.base;

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
public class BaseExcelDataListener<T extends BaseExcelReadModel>
        extends AnalysisEventListener<T> {

    private List<T> result = Lists.newArrayList();

    @Override
    public void invoke (T data, AnalysisContext context) {
        result.add(data);
    }

    @Override
    public void doAfterAllAnalysed (AnalysisContext context) {
        log.info("解析完成！");
    }
}
