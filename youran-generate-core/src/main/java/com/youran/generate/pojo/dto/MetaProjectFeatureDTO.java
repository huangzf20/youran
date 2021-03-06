package com.youran.generate.pojo.dto;

import com.youran.common.pojo.dto.AbstractDTO;
import com.youran.common.validator.Const;
import com.youran.generate.constant.FeatureConst;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 项目特性
 *
 * @author cbb
 * @date 2018/11/28
 */
public class MetaProjectFeatureDTO extends AbstractDTO {

    /**
     * spring-boot版本【1或2】
     */
    @ApiModelProperty(notes = "spring-boot版本【1或2】", example = "1")
    @NotNull
    @Const(constClass = FeatureConst.Boot.class)
    private Integer bootVersion = FeatureConst.Boot.BOOT_2;

    public Integer getBootVersion() {
        return bootVersion;
    }

    public void setBootVersion(Integer bootVersion) {
        this.bootVersion = bootVersion;
    }

}
