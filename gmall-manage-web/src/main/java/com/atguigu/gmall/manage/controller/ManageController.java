package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.xml.ws.RequestWrapper;
import java.io.Serializable;
import java.util.List;

@RestController
@CrossOrigin
public class ManageController {

    @Reference
    ManageService manageService;

   @RequestMapping(value = "index" )
    public String index(){
        return "index";
    }

    @RequestMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return  manageService.getCatalog1();
    }

    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return  manageService.getCatalog2(catalog1Id);
    }
    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return  manageService.getCatalog3(catalog2Id);
    }

    @RequestMapping("attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return  manageService.getAttrList(catalog3Id);
    }

    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
    }


    /**
     * 根据平台属性ID查询平台属性
     * @param attrId
     * @return
     */
   @RequestMapping("getAttrValueList")
   public List<BaseAttrValue> getAttrValueList(String attrId){

       BaseAttrInfo baseAttrInfo = manageService.getAttrInfo(attrId);
        //return manageService.getAttrValueList(attrId);
       return baseAttrInfo.getAttrValueList();
   }

//Request URL: http://localhost:8082/spuList?catalog3Id=1
    @RequestMapping("spuList")
    public List<SpuInfo> getSpuList(String catalog3Id){
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
       return manageService.getSpuInfoList(spuInfo);
    }

    //在manageController 中 完成'baseSaleAttrList'控制器
    @RequestMapping("baseSaleAttrList")
    public List<BaseSaleAttr> getBaseSaleAttrList(){
        return   manageService.getBaseSaleAttrList();
    }

    //保存商品属性
    //Request URL: http://localhost:8082/saveSpuInfo
    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.saveSpuInfo(spuInfo);
        return "success";
    }

    /*
    http://localhost:8082/spuSaleAttrList?spuId=59
    http://localhost:8082/spuImageList?spuId=59
     */


    //获取sku的图片列表
    @RequestMapping("spuImageList")
    public List<SpuImage> getSpuImageList(String spuId){
       return manageService.getSpuImageList(spuId);
    }
    //获取平台属性动态列表的值 http://localhost:8082/spuSaleAttrList?spuId=59
    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> getSpuSaleAttrList(String spuId){

        List<SpuSaleAttr> spuSaleAttrList = manageService.getSpuSaleAttrList(spuId);
        System.out.println(spuSaleAttrList+"哈哈哈哈哈哈哈");
        return spuSaleAttrList;
    }


    //http://localhost:8082/saveSkuInfo
    //最终的Sku保存
}
