package com.youran.common.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Title:分页查询dto
 * Description:
 * Author: cbb
 * Create Time:2017/5/12 21:26
 */
public class PageQueryDTO extends AbstractDTO {

    public static final int DEFAULT_PAGE_NO = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;

    @ApiModelProperty(notes = "分页参数，每页的条数", example = "20")
    @Max(value = 1000, message = "pageSize不能大于1000")
    private Integer pageSize = 20;//默认20条每页

    @ApiModelProperty(notes = "分页参数，第几页", example = "1")
    @Min(value = 1, message = "pageNo不能小于1")
    private Integer pageNo = 1;//默认第一页

    public PageQueryDTO() {
        this(null, null);
    }

    public PageQueryDTO(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            pageNo = DEFAULT_PAGE_NO;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public int getStartIndex(){
        return (pageNo - 1) * pageSize;
    }
    public int getEndIndex(){
        return pageNo * pageSize;
    }

}
