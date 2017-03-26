package cookbook.cmw.com.cookbook.category.dao.impl;

import android.content.Context;

import com.android.volley.VolleyError;

import cookbook.cmw.com.cookbook.category.beans.Category;
import cookbook.cmw.com.cookbook.category.dao.inter.CategoryDao;
import cookbook.cmw.com.cookbook.category.dao.inter.CategoryPresenter;
import cookbook.cmw.com.cookbook.category.dao.inter.CategoryView;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

public class CategoryPresenterImpl implements CategoryPresenter,CategoryDao.CategoryDaoListener {
    CategoryView categoryView;
    CategoryDao dao;
    Context ctx;

    public CategoryPresenterImpl(CategoryView categoryView, CategoryDao dao, Context ctx) {
        this.categoryView = categoryView;
        this.dao = dao;
        this.ctx = ctx;
    }

    @Override
    public void getCategory() {
        dao.getCategory(ctx, this);
    }

    @Override
    public void onSuccess(Category category) {
        categoryView.setCategory(category);
    }

    @Override
    public void onFailure(VolleyError error) {
        categoryView.setFail();
    }


}
