package com.template.vo;

import com.template.enums.ResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * Date: Created in 2018-12-17 11:05
 * Utils: Intellij Idea
 * Description: 固定返回格式
 */
@Data
@ApiModel("固定返回格式")
public class ResultVo {

    /**
     * 错误码
     */
    @ApiModelProperty("错误码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;

    /**
     * 具体的内容
     */
    @ApiModelProperty("响应数据")
    private Object data;

    public ResultVo() {
    }

    public ResultVo(Integer code) {
        this.code = code;
    }

    public ResultVo(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultVo success() {
        return new ResultVo(ResultEnum.SUCCESS.getCode());
    }

    public static ResultVo success(Object o) {
        return new ResultVo(ResultEnum.SUCCESS.getCode(), "", o);
    }

    public static ResultVo error(ResultEnum resultEnum, Object o) {
        return new ResultVo(resultEnum.getCode(), resultEnum.getMsg(), o);
    }

}
