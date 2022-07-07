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
@ApiModel(description = "Lecturer")
public class Lecturer implements Serializable {
    /**
     * @Fields lecId 讲师主键
     */
    @ApiModelProperty("lecId")
    @AutoId(primaryKey = "lec_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer lecId;

    /**
     * @Fields lecName 讲师姓名
     */
    @ApiModelProperty("lecName")
    private String lecName;

    /**
     * @Fields dId 部门id，外键
     */
    @ApiModelProperty("dId")
    private Integer dId;

    /**
     * @Fields pId 岗位id，外键
     */
    @ApiModelProperty("pId")
    private Integer pId;

    /**
     * @Fields telephone 电话
     */
    @ApiModelProperty("telephone")
    private String telephone;

    private static final long serialVersionUID = 1L;

    /** 
     * @return lec_id 讲师主键
     */
    public Integer getLecId() {
        return lecId;
    }

    /**
     * @param lecId 讲师主键
     */
    public void setLecId(Integer lecId) {
        this.lecId = lecId;
    }

    /** 
     * @return lec_name 讲师姓名
     */
    public String getLecName() {
        return lecName;
    }

    /**
     * @param lecName 讲师姓名
     */
    public void setLecName(String lecName) {
        this.lecName = lecName == null ? null : lecName.trim();
    }

    /** 
     * @return d_id 部门id，外键
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * @param dId 部门id，外键
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    /** 
     * @return p_id 岗位id，外键
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * @param pId 岗位id，外键
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /** 
     * @return telephone 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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
        Lecturer other = (Lecturer) that;
        return (this.getLecId() == null ? other.getLecId() == null :
				 this.getLecId().equals(other.getLecId()))
            && (this.getLecName() == null ? other.getLecName() == null :
				 this.getLecName().equals(other.getLecName()))
            && (this.getdId() == null ? other.getdId() == null :
				 this.getdId().equals(other.getdId()))
            && (this.getpId() == null ? other.getpId() == null :
				 this.getpId().equals(other.getpId()))
            && (this.getTelephone() == null ? other.getTelephone() == null :
				 this.getTelephone().equals(other.getTelephone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLecId() == null) ? 0 : getLecId().hashCode());
        result = prime * result + ((getLecName() == null) ? 0 : getLecName().hashCode());
        result = prime * result + ((getdId() == null) ? 0 : getdId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        return result;
    }
}