/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


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
