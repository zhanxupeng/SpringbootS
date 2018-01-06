package com.mybatis.test.controller.business.customer.viewmodel;

public class CustomerIndexVM {
    private int myDynamicCount;
    private int myCollectionCount;

    public int getMyDynamicCount() {
        return myDynamicCount;
    }

    public void setMyDynamicCount(int myDynamicCount) {
        this.myDynamicCount = myDynamicCount;
    }

    public int getMyCollectionCount() {
        return myCollectionCount;
    }

    public void setMyCollectionCount(int myCollectionCount) {
        this.myCollectionCount = myCollectionCount;
    }
}
