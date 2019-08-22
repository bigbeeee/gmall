package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.SkuSaleAttrValue;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SkuSaleAttrValueMapper extends Mapper<SkuSaleAttrValue> {
    //获取商品的SkuID属性并跳转
    List<SkuSaleAttrValue> selectSkuSaleAttrValueListBySpu(String spuId);
}