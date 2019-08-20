package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();

    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    List<BaseAttrValue> getAttrValueList(String attrId);

    BaseAttrInfo getAttrInfo(String attrId);

    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);

    //查询基本的销售属性
    List<BaseSaleAttr> getBaseSaleAttrList();

    //保存spu的接口
    public void saveSpuInfo(SpuInfo spuInfo);

     /*
    http://localhost:8082/spuSaleAttrList?spuId=59
    http://localhost:8082/spuImageList?spuId=59
     */
    //根据spuId来获取spu中的所有的图片
    public List<SpuImage> getSpuImageList(String spuId);

    //获取所有的sku
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    //sku属性集合保存
    public void saveSkuInfo(SkuInfo skuInfo);
}
