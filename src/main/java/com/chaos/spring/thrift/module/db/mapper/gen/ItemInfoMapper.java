package com.chaos.spring.thrift.module.db.mapper.gen;

import com.chaos.spring.thrift.module.db.model.gen.ItemInfo;
import com.chaos.spring.thrift.module.db.model.gen.ItemInfoExample;
import com.chaos.spring.thrift.module.db.model.gen.ItemInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    long countByExample(ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int deleteByExample(ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int deleteByPrimaryKey(String itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int insert(ItemInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int insertSelective(ItemInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    List<ItemInfoWithBLOBs> selectByExampleWithBLOBs(ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    List<ItemInfo> selectByExample(ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    ItemInfoWithBLOBs selectByPrimaryKey(String itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int updateByExampleSelective(@Param("record") ItemInfoWithBLOBs record, @Param("example") ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") ItemInfoWithBLOBs record, @Param("example") ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int updateByExample(@Param("record") ItemInfo record, @Param("example") ItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int updateByPrimaryKeySelective(ItemInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(ItemInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_info
     *
     * @mbg.generated Fri Apr 28 09:06:15 CST 2017
     */
    int updateByPrimaryKey(ItemInfo record);
}