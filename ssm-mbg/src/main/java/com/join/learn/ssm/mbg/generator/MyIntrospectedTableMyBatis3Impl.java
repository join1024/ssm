/*
 * All rights Reserved, Designed By 农金圈
 * 
 * @date: 2016年9月13日 下午8:19:23
 */

package com.join.learn.ssm.mbg.generator;

import java.util.List;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * @Description:扩展实现根据前缀生成sub-package, 生成catalog.table
 * @author:
 */
public class MyIntrospectedTableMyBatis3Impl extends IntrospectedTableMyBatis3Impl {

    public MyIntrospectedTableMyBatis3Impl() {
        super();
    }

    @Override
    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings,
        ProgressCallback progressCallback) {
        super.calculateXmlMapperGenerator(javaClientGenerator, warnings, progressCallback);
    }

    @Override
    protected String calculateJavaModelPackage() {
        StringBuilder targetPackage = new StringBuilder();
        targetPackage.append(super.calculateJavaModelPackage());
        if (!"".equals(getPrefix())) {
            addMbgPackage(targetPackage);
            targetPackage.append(".");
            targetPackage.append(getPrefix());
        }
        return targetPackage.toString();
    }
    
    public void addMbgPackage(StringBuilder packageString) {
        String mbgPackage = getContext().getProperty("mbgPackage");
        if (mbgPackage != null && !"".equals(mbgPackage)) {
            packageString.append(".");
            packageString.append(mbgPackage);
        }
    }

    @Override
    protected String calculateSqlMapPackage() {
        StringBuilder targetPackage = new StringBuilder();
        targetPackage.append(super.calculateSqlMapPackage());
        if (!"".equals(getPrefix())) {
            addMbgPackage(targetPackage);
            targetPackage.append(".");
            targetPackage.append(getPrefix());
        }
        return targetPackage.toString();
    }

    @Override
    protected String calculateJavaClientInterfacePackage() {
        StringBuilder targetPackage = new StringBuilder();
        targetPackage.append(super.calculateJavaClientInterfacePackage());
        if (!"".equals(getPrefix())) {
            addMbgPackage(targetPackage);
            targetPackage.append(".");
            targetPackage.append(getPrefix());
        }
        return targetPackage.toString();
    }

    /**
     * <p>
     * 覆盖官方实现，为sql生成catalog.table格式
     * </p>
     * 
     * @return
     */
    @Override
    protected String calculateSqlMapFullyQualifiedRuntimeTableName() {
        StringBuilder s = new StringBuilder();
        if (StringUtility.stringHasValue(fullyQualifiedTable.getIntrospectedCatalog())) {
            s.append(fullyQualifiedTable.getIntrospectedCatalog());
            s.append(".");
        }
        s.append(fullyQualifiedTable.getIntrospectedTableName());
        return s.toString();
    }

    /**
     * <p>
     * 覆盖官方实现，官方实现有bug,<table>指定catalog则会生成catalog..table格式,应该为catalog.table格式
     * </p>
     * 
     * @return
     */
    @Override
    protected String calculateSqlMapAliasedFullyQualifiedRuntimeTableName() {
        StringBuilder s = new StringBuilder();
        if (StringUtility.stringHasValue(fullyQualifiedTable.getIntrospectedCatalog())) {
            s.append(fullyQualifiedTable.getIntrospectedCatalog());
            s.append(".");
        }
        s.append(fullyQualifiedTable.getIntrospectedTableName());
        if (StringUtility.stringHasValue(tableConfiguration.getAlias())) {
            s.append(" ");
            s.append(tableConfiguration.getAlias());
        }
        return s.toString();
    }

    private String getPrefix() {
        String[] strArr = tableConfiguration.getTableName().split("_");
        if (strArr.length == 1) {
            return "";
        } else {
            return strArr[0];
        }
    }

}
