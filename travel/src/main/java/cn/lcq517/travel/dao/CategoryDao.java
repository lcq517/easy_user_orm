package cn.lcq517.travel.dao;

import cn.lcq517.travel.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
