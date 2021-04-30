package cn.tommy.excel;

import cn.tommy.excel.read.ReadUtils;

/**
 * easyExcel工具类
 *
 * @author Tommy
 */
public class EasyExcelUtils {

    /**
     * 读取相关
     *
     * @return 读取工具类
     */
    public static ReadUtils read () {
        return new ReadUtils();
    }

    /**
     * 填充相关
     *
     * @return 填充工具类
     */
    public static ReadUtils fill () {
        return new ReadUtils();
    }

    /**
     * 读取相关
     *
     * @return 读取工具类
     */
    public static ReadUtils write () {
        return new ReadUtils();
    }

}
