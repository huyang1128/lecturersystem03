package com.huan.domain;

import com.ctsi.ssdc.criteria.IntegerCriteria;
import com.ctsi.ssdc.criteria.StringCriteria;
import com.ctsi.ssdc.example.BaseExample;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ctsi-biyi-generator
*/
public class DepartmentsExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final String LIKE_FORMAT = "%%%s%%";

    /**
     * @Fields dId id
     */
    @ApiModelProperty("dId")
    private IntegerCriteria dId;

    /**
     * @Fields dName 部门名称
     */
    @ApiModelProperty("dName")
    private StringCriteria dName;

    /**
     * @Fields dRemark 备注
     */
    @ApiModelProperty("dRemark")
    private StringCriteria dRemark;

    public DepartmentsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public IntegerCriteria getDId() {
        return dId;
    }

    public void setDId(IntegerCriteria dId) {
        this. dId = dId;
    }

    private void buildDIdCriteria(Criteria criteria) {
        if (this.getDId() == null) {
            return;
        }
        if (this.getDId().getEquals() != null) {
            criteria.andDIdEqualTo(this.getDId().getEquals());
        } else {
            if (this.getDId().getGreaterOrEqualThan() != null) {
                criteria.andDIdGreaterThanOrEqualTo(this.getDId().getGreaterOrEqualThan());
            }
            if (this.getDId().getLessOrEqualThan() != null) {
                criteria.andDIdLessThanOrEqualTo(this.getDId().getLessOrEqualThan());
            }
        }
    }

    public StringCriteria getDName() {
        return dName;
    }

    public void setDName(StringCriteria dName) {
        this. dName = dName;
    }

    private void buildDNameCriteria(Criteria criteria) {
        if (this.getDName() == null) {
            return;
        }
        if (this.getDName().getEquals() != null) {
            criteria.andDNameEqualTo(this.getDName().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getDName().getContains())) {
                criteria.andDNameLike(String.format(LIKE_FORMAT, this.getDName().getContains()));
            }
        }
    }

    public StringCriteria getDRemark() {
        return dRemark;
    }

    public void setDRemark(StringCriteria dRemark) {
        this. dRemark = dRemark;
    }

    private void buildDRemarkCriteria(Criteria criteria) {
        if (this.getDRemark() == null) {
            return;
        }
        if (this.getDRemark().getEquals() != null) {
            criteria.andDRemarkEqualTo(this.getDRemark().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getDRemark().getContains())) {
                criteria.andDRemarkLike(String.format(LIKE_FORMAT, this.getDRemark().getContains()));
            }
        }
    }

    @Override
    public Object buildCriteria() {
        Criteria criteria = this.createCriteria();
        this.buildDIdCriteria(criteria);
        this.buildDNameCriteria(criteria);
        this.buildDRemarkCriteria(criteria);
        return criteria;
    }

    /**
     * departments 
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDNameIsNull() {
            addCriterion("d_name is null");
            return (Criteria) this;
        }

        public Criteria andDNameIsNotNull() {
            addCriterion("d_name is not null");
            return (Criteria) this;
        }

        public Criteria andDNameEqualTo(String value) {
            addCriterion("d_name =", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotEqualTo(String value) {
            addCriterion("d_name <>", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameGreaterThan(String value) {
            addCriterion("d_name >", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameGreaterThanOrEqualTo(String value) {
            addCriterion("d_name >=", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameLessThan(String value) {
            addCriterion("d_name <", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameLessThanOrEqualTo(String value) {
            addCriterion("d_name <=", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameLike(String value) {
            addCriterion("d_name like", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotLike(String value) {
            addCriterion("d_name not like", value, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameIn(List<String> values) {
            addCriterion("d_name in", values, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotIn(List<String> values) {
            addCriterion("d_name not in", values, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameBetween(String value1, String value2) {
            addCriterion("d_name between", value1, value2, "dName");
            return (Criteria) this;
        }

        public Criteria andDNameNotBetween(String value1, String value2) {
            addCriterion("d_name not between", value1, value2, "dName");
            return (Criteria) this;
        }

        public Criteria andDRemarkIsNull() {
            addCriterion("d_remark is null");
            return (Criteria) this;
        }

        public Criteria andDRemarkIsNotNull() {
            addCriterion("d_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDRemarkEqualTo(String value) {
            addCriterion("d_remark =", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkNotEqualTo(String value) {
            addCriterion("d_remark <>", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkGreaterThan(String value) {
            addCriterion("d_remark >", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("d_remark >=", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkLessThan(String value) {
            addCriterion("d_remark <", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkLessThanOrEqualTo(String value) {
            addCriterion("d_remark <=", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkLike(String value) {
            addCriterion("d_remark like", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkNotLike(String value) {
            addCriterion("d_remark not like", value, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkIn(List<String> values) {
            addCriterion("d_remark in", values, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkNotIn(List<String> values) {
            addCriterion("d_remark not in", values, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkBetween(String value1, String value2) {
            addCriterion("d_remark between", value1, value2, "dRemark");
            return (Criteria) this;
        }

        public Criteria andDRemarkNotBetween(String value1, String value2) {
            addCriterion("d_remark not between", value1, value2, "dRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * departments 
     */
    public static class Criterion {
        @ApiParam(hidden=true)
        private String condition;

        @ApiParam(hidden=true)
        private Object value;

        @ApiParam(hidden=true)
        private Object secondValue;

        @ApiParam(hidden=true)
        private boolean noValue;

        @ApiParam(hidden=true)
        private boolean singleValue;

        @ApiParam(hidden=true)
        private boolean betweenValue;

        @ApiParam(hidden=true)
        private boolean listValue;

        @ApiParam(hidden=true)
        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}