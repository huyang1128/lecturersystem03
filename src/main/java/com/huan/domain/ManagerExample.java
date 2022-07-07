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
public class ManagerExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final String LIKE_FORMAT = "%%%s%%";

    /**
     * @Fields mId id
     */
    @ApiModelProperty("mId")
    private IntegerCriteria mId;

    /**
     * @Fields mAccount 账号
     */
    @ApiModelProperty("mAccount")
    private StringCriteria mAccount;

    /**
     * @Fields mPassword 密码
     */
    @ApiModelProperty("mPassword")
    private StringCriteria mPassword;

    public ManagerExample() {
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

    public IntegerCriteria getMId() {
        return mId;
    }

    public void setMId(IntegerCriteria mId) {
        this. mId = mId;
    }

    private void buildMIdCriteria(Criteria criteria) {
        if (this.getMId() == null) {
            return;
        }
        if (this.getMId().getEquals() != null) {
            criteria.andMIdEqualTo(this.getMId().getEquals());
        } else {
            if (this.getMId().getGreaterOrEqualThan() != null) {
                criteria.andMIdGreaterThanOrEqualTo(this.getMId().getGreaterOrEqualThan());
            }
            if (this.getMId().getLessOrEqualThan() != null) {
                criteria.andMIdLessThanOrEqualTo(this.getMId().getLessOrEqualThan());
            }
        }
    }

    public StringCriteria getMAccount() {
        return mAccount;
    }

    public void setMAccount(StringCriteria mAccount) {
        this. mAccount = mAccount;
    }

    private void buildMAccountCriteria(Criteria criteria) {
        if (this.getMAccount() == null) {
            return;
        }
        if (this.getMAccount().getEquals() != null) {
            criteria.andMAccountEqualTo(this.getMAccount().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getMAccount().getContains())) {
                criteria.andMAccountLike(String.format(LIKE_FORMAT, this.getMAccount().getContains()));
            }
        }
    }

    public StringCriteria getMPassword() {
        return mPassword;
    }

    public void setMPassword(StringCriteria mPassword) {
        this. mPassword = mPassword;
    }

    private void buildMPasswordCriteria(Criteria criteria) {
        if (this.getMPassword() == null) {
            return;
        }
        if (this.getMPassword().getEquals() != null) {
            criteria.andMPasswordEqualTo(this.getMPassword().getEquals());
        } else {
            if (StringUtils.isNotBlank(this.getMPassword().getContains())) {
                criteria.andMPasswordLike(String.format(LIKE_FORMAT, this.getMPassword().getContains()));
            }
        }
    }

    @Override
    public Object buildCriteria() {
        Criteria criteria = this.createCriteria();
        this.buildMIdCriteria(criteria);
        this.buildMAccountCriteria(criteria);
        this.buildMPasswordCriteria(criteria);
        return criteria;
    }

    /**
     * manager 
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMAccountIsNull() {
            addCriterion("m_account is null");
            return (Criteria) this;
        }

        public Criteria andMAccountIsNotNull() {
            addCriterion("m_account is not null");
            return (Criteria) this;
        }

        public Criteria andMAccountEqualTo(String value) {
            addCriterion("m_account =", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotEqualTo(String value) {
            addCriterion("m_account <>", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountGreaterThan(String value) {
            addCriterion("m_account >", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountGreaterThanOrEqualTo(String value) {
            addCriterion("m_account >=", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountLessThan(String value) {
            addCriterion("m_account <", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountLessThanOrEqualTo(String value) {
            addCriterion("m_account <=", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountLike(String value) {
            addCriterion("m_account like", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotLike(String value) {
            addCriterion("m_account not like", value, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountIn(List<String> values) {
            addCriterion("m_account in", values, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotIn(List<String> values) {
            addCriterion("m_account not in", values, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountBetween(String value1, String value2) {
            addCriterion("m_account between", value1, value2, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMAccountNotBetween(String value1, String value2) {
            addCriterion("m_account not between", value1, value2, "mAccount");
            return (Criteria) this;
        }

        public Criteria andMPasswordIsNull() {
            addCriterion("m_password is null");
            return (Criteria) this;
        }

        public Criteria andMPasswordIsNotNull() {
            addCriterion("m_password is not null");
            return (Criteria) this;
        }

        public Criteria andMPasswordEqualTo(String value) {
            addCriterion("m_password =", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotEqualTo(String value) {
            addCriterion("m_password <>", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordGreaterThan(String value) {
            addCriterion("m_password >", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("m_password >=", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLessThan(String value) {
            addCriterion("m_password <", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLessThanOrEqualTo(String value) {
            addCriterion("m_password <=", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLike(String value) {
            addCriterion("m_password like", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotLike(String value) {
            addCriterion("m_password not like", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordIn(List<String> values) {
            addCriterion("m_password in", values, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotIn(List<String> values) {
            addCriterion("m_password not in", values, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordBetween(String value1, String value2) {
            addCriterion("m_password between", value1, value2, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotBetween(String value1, String value2) {
            addCriterion("m_password not between", value1, value2, "mPassword");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * manager 
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