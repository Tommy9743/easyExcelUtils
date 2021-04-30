/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.tommy.excel.read;

import cn.hutool.core.io.FileUtil;
import cn.tommy.excel.read.base.BaseExcelDataListener;
import cn.tommy.excel.read.base.BaseExcelReadModel;
import cn.tommy.excel.read.config.ReadConfig;
import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 读取相关
 *
 * @author Tommy
 */
@Slf4j
public class ReadUtils {


    /**
     * 转化excel
     *
     * @param file     文件
     * @param dataType 数据类型
     * @param listener 数据listener
     * @param <T>      excel解析类
     * @param <M>      easyExcel数据listener
     *
     * @return 解析结果
     */
    public <T extends BaseExcelReadModel, M extends BaseExcelDataListener<T>> List<T> parseExcel (File file, Class<T> dataType, Class<M> listener) {
        try {
            InputStream inputStream = FileUtil.getInputStream(file);
            M m = listener.newInstance();
            EasyExcel.read(inputStream, dataType, m).headRowNumber(0).sheet(0).doRead();
            return m.getResult();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("excel读取出错", e);
        }
        return Lists.newArrayList();
    }

    /**
     * 转化excel
     *
     * @param inputStream 文件输入流
     * @param dataType    数据类型
     * @param listener    数据listener
     * @param <T>         excel解析类
     * @param <M>         easyExcel数据listener
     *
     * @return 解析结果
     */
    public <T extends BaseExcelReadModel, M extends BaseExcelDataListener<T>> List<T> parseExcel (InputStream inputStream, Class<T> dataType, Class<M> listener) {
        try {
            M m = listener.newInstance();
            EasyExcel.read(inputStream, dataType, m).headRowNumber(0).sheet(0).doRead();
            return m.getResult();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("excel读取出错", e);
        }
        return Lists.newArrayList();
    }


    /**
     * 转化excel
     *
     * @param inputStream 文件输入流
     * @param dataType    数据类型
     * @param listener    数据listener
     * @param <T>         excel解析类
     * @param <M>         easyExcel数据listener
     * @param config      读取配置
     *
     * @return 解析结果
     */
    public <T extends BaseExcelReadModel, M extends BaseExcelDataListener<T>> List<T> parseExcel (InputStream inputStream, Class<T> dataType, Class<M> listener, ReadConfig config) {
        try {
            M m = listener.newInstance();
            if (config != null) {
                Integer skipRow = config.getSkipRow();
                Integer sheet = config.getSheetNum();
                EasyExcel.read(inputStream, dataType, m).headRowNumber(skipRow == null ? 0 : skipRow).sheet(sheet == null ? 0 : sheet).doRead();
                return m.getResult();
            }
            EasyExcel.read(inputStream, dataType, m).headRowNumber(0).sheet(0).doRead();
            return m.getResult();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("excel读取出错", e);
        }
        return Lists.newArrayList();
    }
}
