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
@ApiModel(description = "Positions")
public class Positions implements Serializable {
    /**
     * @Fields pId id
     */
    @ApiModelProperty("pId")
    @AutoId(primaryKey = "p_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer pId;

    /**
     * @Fields pName 岗位名称
     */
    @ApiModelProperty("pName")
    private String pName;

    /**
     * @Fields pDuty 岗位描述
     */
    @ApiModelProperty("pDuty")
    private String pDuty;

    private static final long serialVersionUID = 1L;

    /** 
     * @return p_id id
     */
    public Integer getPId() {
        return pId;
    }

    /**
     * @param pId id
     */
    public void setPId(Integer pId) {
        this.pId = pId;
    }

    /** 
     * @return p_name 岗位名称
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName 岗位名称
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /** 
     * @return p_duty 岗位描述
     */
    public String getpDuty() {
        return pDuty;
    }

    /**
     * @param pDuty 岗位描述
     */
    public void setpDuty(String pDuty) {
        this.pDuty = pDuty == null ? null : pDuty.trim();
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
        Positions other = (Positions) that;
        return (this.getPId() == null ? other.getPId() == null :
				 this.getPId().equals(other.getPId()))
            && (this.getpName() == null ? other.getpName() == null :
				 this.getpName().equals(other.getpName()))
            && (this.getpDuty() == null ? other.getpDuty() == null :
				 this.getpDuty().equals(other.getpDuty()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPId() == null) ? 0 : getPId().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        result = prime * result + ((getpDuty() == null) ? 0 : getpDuty().hashCode());
        return result;
    }
}