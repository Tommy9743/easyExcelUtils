package cn.tommy.excel.read.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 读取配置类
 *
 * @author Tommy
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadConfig {

    /**
     * 跳过行数
     */
    private Integer skipRow;

    /**
     * 表
     */
    private Integer sheetNum;

}
