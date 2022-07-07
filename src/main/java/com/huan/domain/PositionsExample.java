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
public class PositionsExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final String LIKE_FORMAT = "%%%s%%";

    /**
     * @Fields pId id
     */
    @ApiModelProperty("pId")
    private IntegerCriteria pId;

    /**
     * @Fields pName 岗位名称
     */
    @ApiModelProperty("pName")
    private StringCriteria pName;

    /**
     * @Fields pDuty 岗位描述
     */
    @ApiModelProperty("pDuty")
    private StringCriteria pDuty;

    public PositionsExample() {
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

    public IntegerCriteria getPId() {
        return pId;
    }

    public void setPId(IntegerCriteria pId) {
        this. pId = pId;
    }

    private void buildPIdCriteria(Criteria criteria) {
        if (this.getPId() == null) {
            return;
        }
        if (this.getPId().getEquals() != null) {
            criteria.andPIdEqualTo(this.getPId().getEquals());
        } else {
            if (this.getPId().getGreaterOrEqualThan() != null) {
                criteria.andPIdGreaterThanOrEqualTo(this.getPId().getGreaterOrEqualThan());
            }
            if (this.getPId().getLessOrEqualThan() != null) {
                criteria.andPIdLessThanOrEqualTo(this.getPId().getLessOrEqualThan());
            }
        }
    }

    public StringCriteria getPName() {
        return pName;
    }

    public void setPName(StringCriteria pName) {
        this. pName = pName;
    }

    private void buildPNameCriteria(Criteria criteria) {
        if (this.getPName() == null) {
            return;
        }
        if (this.getPName().getEquals() != null) {
            criteria.andPNameEqualTo(this.getPName().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getPName().getContains())) {
                criteria.andPNameLike(String.format(LIKE_FORMAT, this.getPName().getContains()));
            }
        }
    }

    public StringCriteria getPDuty() {
        return pDuty;
    }

    public void setPDuty(StringCriteria pDuty) {
        this. pDuty = pDuty;
    }

    private void buildPDutyCriteria(Criteria criteria) {
        if (this.getPDuty() == null) {
            return;
        }
        if (this.getPDuty().getEquals() != null) {
            criteria.andPDutyEqualTo(this.getPDuty().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getPDuty().getContains())) {
                criteria.andPDutyLike(String.format(LIKE_FORMAT, this.getPDuty().getContains()));
            }
        }
    }

    @Override
    public Object buildCriteria() {
        Criteria criteria = this.createCriteria();
        this.buildPIdCriteria(criteria);
        this.buildPNameCriteria(criteria);
        this.buildPDutyCriteria(criteria);
        return criteria;
    }

    /**
     * positions 
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPDutyIsNull() {
            addCriterion("p_duty is null");
            return (Criteria) this;
        }

        public Criteria andPDutyIsNotNull() {
            addCriterion("p_duty is not null");
            return (Criteria) this;
        }

        public Criteria andPDutyEqualTo(String value) {
            addCriterion("p_duty =", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyNotEqualTo(String value) {
            addCriterion("p_duty <>", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyGreaterThan(String value) {
            addCriterion("p_duty >", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyGreaterThanOrEqualTo(String value) {
            addCriterion("p_duty >=", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyLessThan(String value) {
            addCriterion("p_duty <", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyLessThanOrEqualTo(String value) {
            addCriterion("p_duty <=", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyLike(String value) {
            addCriterion("p_duty like", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyNotLike(String value) {
            addCriterion("p_duty not like", value, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyIn(List<String> values) {
            addCriterion("p_duty in", values, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyNotIn(List<String> values) {
            addCriterion("p_duty not in", values, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyBetween(String value1, String value2) {
            addCriterion("p_duty between", value1, value2, "pDuty");
            return (Criteria) this;
        }

        public Criteria andPDutyNotBetween(String value1, String value2) {
            addCriterion("p_duty not between", value1, value2, "pDuty");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * positions 
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