package com.huan.domain;

import com.ctsi.ssdc.annotation.AutoId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author ctsi-biyi-generator
*/
@ApiModel(description = "Manager")
public class Manager implements Serializable {
    /**
     * @Fields mId id
     */
    @ApiModelProperty("mId")
    @AutoId(primaryKey = "m_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer mId;

    /**
     * @Fields mAccount 账号
     */
    @ApiModelProperty("mAccount")
    private String mAccount;

    /**
     * @Fields mPassword 密码
     */
    @ApiModelProperty("mPassword")
    private String mPassword;

    private static final long serialVersionUID = 1L;

    /** 
     * @return m_id id
     */
    public Integer getMId() {
        return mId;
    }

    /**
     * @param mId id
     */
    public void setMId(Integer mId) {
        this.mId = mId;
    }

    /** 
     * @return m_account 账号
     */
    public String getmAccount() {
        return mAccount;
    }

    /**
     * @param mAccount 账号
     */
    public void setmAccount(String mAccount) {
        this.mAccount = mAccount == null ? null : mAccount.trim();
    }

    /** 
     * @return m_password 密码
     */
    public String getmPassword() {
        return mPassword;
    }

    /**
     * @param mPassword 密码
     */
    public void setmPassword(String mPassword) {
        this.mPassword = mPassword == null ? null : mPassword.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Manager other = (Manager) that;
        return (this.getMId() == null ? other.getMId() == null :
				 this.getMId().equals(other.getMId()))
            && (this.getmAccount() == null ? other.getmAccount() == null :
				 this.getmAccount().equals(other.getmAccount()))
            && (this.getmPassword() == null ? other.getmPassword() == null :
				 this.getmPassword().equals(other.getmPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMId() == null) ? 0 : getMId().hashCode());
        result = prime * result + ((getmAccount() == null) ? 0 : getmAccount().hashCode());
        result = prime * result + ((getmPassword() == null) ? 0 : getmPassword().hashCode());
        return result;
    }
}