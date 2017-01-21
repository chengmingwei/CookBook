package cookbook.cmw.com.cookbook.category.dao.impl;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;

import cookbook.cmw.com.cookbook.category.beans.Category;
import cookbook.cmw.com.cookbook.category.dao.inter.CategoryDao;
import cookbook.cmw.com.core.network.MyVolley;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

public class CategoryDaoImpl implements CategoryDao, MyVolley.CallBack {
    CategoryDao.CategoryDaoListener listener;

    @Override
    public void getCategory(Context ctx, CategoryDaoListener listener) {
        this.listener = listener;
        String url = "http://apis.juhe.cn/cook/category?parentid=&dtype=&key=b6af41d970ace9d6e21c353c92fca93f";
        MyVolley.getInstance().stringRequestGet(ctx, url,this);
    }

    @Override
    public void onResponse(String response) {
        JSONObject json = JSON.parseObject(response);
        Category c = JSON.parseObject(response, Category.class);
        this.listener.onSuccess(c);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.listener.onFailure(error);
    }
}
