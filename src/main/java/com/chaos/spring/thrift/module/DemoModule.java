package com.chaos.spring.thrift.module;

import com.chaos.spring.thrift.module.db.mapper.gen.ItemInfoMapper;
import com.chaos.spring.thrift.module.db.model.gen.ItemInfoExample;
import com.chaos.spring.thrift.module.db.model.gen.ItemInfoWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
@Component
public class DemoModule {
    private final ItemInfoMapper infoMapper;

    @Autowired
    public DemoModule(ItemInfoMapper infoMapper) {
        this.infoMapper = infoMapper;
    }

    public String hello () {
        ItemInfoExample example = new ItemInfoExample();
        example.or().andCreateTimeIsNotNull();

        return infoMapper.selectByExampleWithBLOBs(example).get(0).getItemName();
    }
}
