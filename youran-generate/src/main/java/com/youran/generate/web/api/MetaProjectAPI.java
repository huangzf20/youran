package com.youran.generate.web.api;

import com.youran.common.pojo.vo.PageVO;
import com.youran.common.pojo.vo.ReplyVO;
import com.youran.generate.pojo.dto.MetaProjectAddDTO;
import com.youran.generate.pojo.dto.MetaProjectQueryDTO;
import com.youran.generate.pojo.dto.MetaProjectUpdateDTO;
import com.youran.generate.pojo.vo.MetaProjectListVO;
import com.youran.generate.pojo.vo.MetaProjectShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Title:元数据项目api
 * Description:
 * Author: cbb
 * Create Time:2017/5/24
 */
@Api(tags = "MetaProjectPO", description = "元数据项目")
public interface MetaProjectAPI {

    /**
     * 新增元数据项目
     *
     * @param metaProjectAddDTO
     * @return
     */
    @ApiOperation(value = "新增元数据项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "metaProjectAddDTO", dataType = "MetaProjectAddDTO", value = "新增项目参数", paramType = "body"),
    })
    ReplyVO<Integer> save(MetaProjectAddDTO metaProjectAddDTO);

    /**
     * 修改元数据项目
     *
     * @param metaProjectUpdateDTO
     */
    @ApiOperation(value = "修改元数据项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "metaProjectUpdateDTO", dataType = "MetaProjectUpdateDTO", value = "修改项目参数", paramType = "body"),
    })
    ReplyVO<Void> update(MetaProjectUpdateDTO metaProjectUpdateDTO);

    /**
     * 分页查询项目
     *
     * @param metaProjectQueryDTO
     */
    @ApiOperation(value = "分页查询项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "metaProjectQueryDTO", dataType = "MetaProjectQueryDTO", value = "分页查询参数", paramType = "body"),
    })
    ReplyVO<PageVO<MetaProjectListVO>> list(MetaProjectQueryDTO metaProjectQueryDTO);

    /**
     * 查看项目详情
     *
     * @param projectId
     */
    @ApiOperation(value = "查看项目详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", dataType = "int", value = "项目id", paramType = "path"),
    })
    ReplyVO<MetaProjectShowVO> show(Integer projectId);


    /**
     * 删除项目
     *
     * @param projectId
     */
    @ApiOperation(value = "删除项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", dataType = "int", value = "项目id", paramType = "path"),
    })
    ReplyVO<Integer> delete(Integer projectId);

    /**
     * 批量删除项目
     *
     * @param projectId
     */
    @ApiOperation(value = "批量删除项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", dataType = "int", value = "项目id数组", paramType = "body"),
    })
    ReplyVO<Integer> deleteBatch(Integer[] projectId);


}
