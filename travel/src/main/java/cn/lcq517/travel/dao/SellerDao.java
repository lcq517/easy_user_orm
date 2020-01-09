package cn.lcq517.travel.dao;

import cn.lcq517.travel.domain.Seller;

public interface SellerDao {

    /**
     * 根据id查询商家信息
     * @param id
     * @return
     */
    public Seller findById(int id);
}
