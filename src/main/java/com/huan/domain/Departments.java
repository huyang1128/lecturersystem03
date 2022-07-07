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
@ApiModel(description = "Departments")
public class Departments implements Serializable {
    /**
     * @Fields dId id
     */
    @ApiModelProperty("dId")
    @AutoId(primaryKey = "d_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer dId;

    /**
     * @Fields dName 部门名称
     */
    @ApiModelProperty("dName")
    private String dName;

    /**
     * @Fields dRemark 备注
     */
    @ApiModelProperty("dRemark")
    private String dRemark;

    private static final long serialVersionUID = 1L;

    /** 
     * @return d_id id
     */
    public Integer getDId() {
        return dId;
    }

    /**
     * @param dId id
     */
    public void setDId(Integer dId) {
        this.dId = dId;
    }

    /** 
     * @return d_name 部门名称
     */
    public String getdName() {
        return dName;
    }

    /**
     * @param dName 部门名称
     */
    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    /** 
     * @return d_remark 备注
     */
    public String getdRemark() {
        return dRemark;
    }

    /**
     * @param dRemark 备注
     */
    public void setdRemark(String dRemark) {
        this.dRemark = dRemark == null ? null : dRemark.trim();
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
        Departments other = (Departments) that;
        return (this.getDId() == null ? other.getDId() == null :
				 this.getDId().equals(other.getDId()))
            && (this.getdName() == null ? other.getdName() == null :
				 this.getdName().equals(other.getdName()))
            && (this.getdRemark() == null ? other.getdRemark() == null :
				 this.getdRemark().equals(other.getdRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDId() == null) ? 0 : getDId().hashCode());
        result = prime * result + ((getdName() == null) ? 0 : getdName().hashCode());
        result = prime * result + ((getdRemark() == null) ? 0 : getdRemark().hashCode());
        return result;
    }
}