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
public class LecturerExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final String LIKE_FORMAT = "%%%s%%";

    /**
     * @Fields lecId 讲师主键
     */
    @ApiModelProperty("lecId")
    private IntegerCriteria lecId;

    /**
     * @Fields lecName 讲师姓名
     */
    @ApiModelProperty("lecName")
    private StringCriteria lecName;

    /**
     * @Fields dId 部门id，外键
     */
    @ApiModelProperty("dId")
    private IntegerCriteria dId;

    /**
     * @Fields pId 岗位id，外键
     */
    @ApiModelProperty("pId")
    private IntegerCriteria pId;

    /**
     * @Fields telephone 电话
     */
    @ApiModelProperty("telephone")
    private StringCriteria telephone;

    public LecturerExample() {
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

    public IntegerCriteria getLecId() {
        return lecId;
    }

    public void setLecId(IntegerCriteria lecId) {
        this. lecId = lecId;
    }

    private void buildLecIdCriteria(Criteria criteria) {
        if (this.getLecId() == null) {
            return;
        }
        if (this.getLecId().getEquals() != null) {
            criteria.andLecIdEqualTo(this.getLecId().getEquals());
        } else {
            if (this.getLecId().getGreaterOrEqualThan() != null) {
                criteria.andLecIdGreaterThanOrEqualTo(this.getLecId().getGreaterOrEqualThan());
            }
            if (this.getLecId().getLessOrEqualThan() != null) {
                criteria.andLecIdLessThanOrEqualTo(this.getLecId().getLessOrEqualThan());
            }
        }
    }

    public StringCriteria getLecName() {
        return lecName;
    }

    public void setLecName(StringCriteria lecName) {
        this. lecName = lecName;
    }

    private void buildLecNameCriteria(Criteria criteria) {
        if (this.getLecName() == null) {
            return;
        }
        if (this.getLecName().getEquals() != null) {
            criteria.andLecNameEqualTo(this.getLecName().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getLecName().getContains())) {
                criteria.andLecNameLike(String.format(LIKE_FORMAT, this.getLecName().getContains()));
            }
        }
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

    public StringCriteria getTelephone() {
        return telephone;
    }

    public void setTelephone(StringCriteria telephone) {
        this. telephone = telephone;
    }

    private void buildTelephoneCriteria(Criteria criteria) {
        if (this.getTelephone() == null) {
            return;
        }
        if (this.getTelephone().getEquals() != null) {
            criteria.andTelephoneEqualTo(this.getTelephone().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getTelephone().getContains())) {
                criteria.andTelephoneLike(String.format(LIKE_FORMAT, this.getTelephone().getContains()));
            }
        }
    }

    @Override
    public Object buildCriteria() {
        Criteria criteria = this.createCriteria();
        this.buildLecIdCriteria(criteria);
        this.buildLecNameCriteria(criteria);
        this.buildDIdCriteria(criteria);
        this.buildPIdCriteria(criteria);
        this.buildTelephoneCriteria(criteria);
        return criteria;
    }

    /**
     * lecturer 
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

        public Criteria andLecIdIsNull() {
            addCriterion("lec_id is null");
            return (Criteria) this;
        }

        public Criteria andLecIdIsNotNull() {
            addCriterion("lec_id is not null");
            return (Criteria) this;
        }

        public Criteria andLecIdEqualTo(Integer value) {
            addCriterion("lec_id =", value, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdNotEqualTo(Integer value) {
            addCriterion("lec_id <>", value, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdGreaterThan(Integer value) {
            addCriterion("lec_id >", value, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lec_id >=", value, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdLessThan(Integer value) {
            addCriterion("lec_id <", value, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdLessThanOrEqualTo(Integer value) {
            addCriterion("lec_id <=", value, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdIn(List<Integer> values) {
            addCriterion("lec_id in", values, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdNotIn(List<Integer> values) {
            addCriterion("lec_id not in", values, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdBetween(Integer value1, Integer value2) {
            addCriterion("lec_id between", value1, value2, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lec_id not between", value1, value2, "lecId");
            return (Criteria) this;
        }

        public Criteria andLecNameIsNull() {
            addCriterion("lec_name is null");
            return (Criteria) this;
        }

        public Criteria andLecNameIsNotNull() {
            addCriterion("lec_name is not null");
            return (Criteria) this;
        }

        public Criteria andLecNameEqualTo(String value) {
            addCriterion("lec_name =", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameNotEqualTo(String value) {
            addCriterion("lec_name <>", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameGreaterThan(String value) {
            addCriterion("lec_name >", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameGreaterThanOrEqualTo(String value) {
            addCriterion("lec_name >=", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameLessThan(String value) {
            addCriterion("lec_name <", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameLessThanOrEqualTo(String value) {
            addCriterion("lec_name <=", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameLike(String value) {
            addCriterion("lec_name like", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameNotLike(String value) {
            addCriterion("lec_name not like", value, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameIn(List<String> values) {
            addCriterion("lec_name in", values, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameNotIn(List<String> values) {
            addCriterion("lec_name not in", values, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameBetween(String value1, String value2) {
            addCriterion("lec_name between", value1, value2, "lecName");
            return (Criteria) this;
        }

        public Criteria andLecNameNotBetween(String value1, String value2) {
            addCriterion("lec_name not between", value1, value2, "lecName");
            return (Criteria) this;
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

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * lecturer 
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