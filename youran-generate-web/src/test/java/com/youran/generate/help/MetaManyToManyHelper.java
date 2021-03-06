package com.youran.generate.help;


import com.youran.common.util.SafeUtil;
import com.youran.generate.pojo.dto.MetaManyToManyAddDTO;
import com.youran.generate.pojo.dto.MetaManyToManyUpdateDTO;
import com.youran.generate.pojo.dto.MetaMtmFeatureDTO;
import com.youran.generate.pojo.po.MetaManyToManyPO;

import static com.youran.generate.pojo.example.MetaManyToManyExample.*;

/**
 * 测试数据
 *
 * @author: cbb
 * @date: 2017/5/12
 */
public class MetaManyToManyHelper {

    /**
     * 生成add测试数据
     *
     * @return
     */
    public static MetaManyToManyAddDTO getAddDTO(Integer projectId, Integer entityId1, Integer entityId2) {
        MetaManyToManyAddDTO dto = new MetaManyToManyAddDTO();
        dto.setProjectId(projectId);
        dto.setEntityId1(entityId1);
        dto.setEntityId2(entityId2);
        dto.setHoldRefer1(true);
        dto.setHoldRefer2(true);
        dto.setTableName(E_TABLENAME);
        dto.setSchemaName(E_SCHEMANAME);
        dto.setDesc(E_DESC);
        dto.setEntityIdField1(E_ENTITYIDFIELD1);
        dto.setEntityIdField2(E_ENTITYIDFIELD2);
        dto.setNeedId(SafeUtil.getBoolean(E_NEEDID));
        dto.setBigId(SafeUtil.getBoolean(E_BIGID));
        dto.setFeature(new MetaMtmFeatureDTO());
        return dto;
    }


    /**
     * 生成update测试数据
     *
     * @return
     */
    public static MetaManyToManyUpdateDTO getUpdateDTO(MetaManyToManyPO metaManyToMany) {
        MetaManyToManyUpdateDTO dto = new MetaManyToManyUpdateDTO();
        dto.setMtmId(metaManyToMany.getMtmId());
        dto.setHoldRefer2(metaManyToMany.getHoldRefer2());
        dto.setProjectId(metaManyToMany.getProjectId());
        dto.setEntityId1(metaManyToMany.getEntityId1());
        dto.setEntityId2(metaManyToMany.getEntityId2());
        dto.setHoldRefer1(metaManyToMany.getHoldRefer1());
        dto.setTableName(metaManyToMany.getTableName());
        dto.setSchemaName(metaManyToMany.getSchemaName());
        dto.setDesc(metaManyToMany.getDesc());
        dto.setEntityIdField1(metaManyToMany.getEntityIdField1());
        dto.setEntityIdField2(metaManyToMany.getEntityIdField2());
        dto.setNeedId(metaManyToMany.getNeedId());
        dto.setBigId(metaManyToMany.getBigId());
        dto.setFeature(new MetaMtmFeatureDTO());
        return dto;
    }

}
