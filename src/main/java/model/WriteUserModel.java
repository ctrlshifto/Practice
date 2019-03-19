package model;


import java.util.List;

/**
 * @Author:WhomHim
 * @Description:
 * @Date: Create in 2019/3/19 11:26
 * @Modified by:
 */
public class WriteUserModel {

    /**
     * 用户名
     */
    private String name;

    /**
     * 账号类型：1=邮箱；2=手机号
     */
    private Integer accountType;

    /**
     * 组织id
     */
    private Integer orgId;

    /**
     * 职级
     */
    private Integer level;

    /**
     * 角色id
     */
    private List<Integer> roles;

    /**
     * 用户状态
     */
    private Integer status;

    public WriteUserModel(String name, Integer accountType, Integer orgId, Integer level, List<Integer> roles, Integer status) {
        this.name = name;
        this.accountType = accountType;
        this.orgId = orgId;
        this.level = level;
        this.roles = roles;
        this.status = status;
    }

    public WriteUserModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
    }
}

