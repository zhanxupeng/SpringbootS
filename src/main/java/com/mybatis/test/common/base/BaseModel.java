package com.mybatis.test.common.base;


import com.mybatis.test.common.util.DateUtil;

import java.util.Date;

public abstract class BaseModel {
    //主键Id
    protected String id;

    //创建者
    protected String createBy;

    //创建日期
    protected Date createDate;

    //更新者
    protected String updateBy;

    //更新日期
    protected Date updateDate;

    //备注
    protected String remarks;

    //删除标志
    protected String delFlag;

    public void init() {
        id = IdGen.uuid();
        delFlag = "0";
        remarks = "";
        createBy = "0";
        updateBy = "0";
        createDate = DateUtil.getCurrentDate();
        updateDate = DateUtil.getCurrentDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
