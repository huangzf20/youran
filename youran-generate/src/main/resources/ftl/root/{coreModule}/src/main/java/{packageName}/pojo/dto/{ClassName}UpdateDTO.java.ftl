<#include "/common.ftl">
<#--定义主体代码-->
<#assign code>
<@call this.addImport("${this.commonPackage}.pojo.dto.AbstractDTO")/>
<@call this.addImport("io.swagger.annotations.ApiModel")/>
<@call this.addImport("javax.validation.constraints.NotNull")/>
<@call this.addStaticImport("${this.packageName}.pojo.example.${this.classNameUpper}Example.*")/>
<@call this.printClassCom("修改【${this.title}】的参数")/>
@ApiModel(description = "修改【${this.title}】的参数")
public class ${this.classNameUpper}UpdateDTO extends AbstractDTO {

    <@call this.addImport("io.swagger.annotations.ApiModelProperty")/>
    @ApiModelProperty(notes = N_${this.pk.jfieldName?upperCase},example = E_${this.pk.jfieldName?upperCase},required = true)
    @NotNull
    <#if this.pk.jfieldType==JFieldType.STRING.getJavaType()>
        <@call this.addImport("org.hibernate.validator.constraints.Length")/>
    @Length(max = ${this.pk.fieldLength})
    </#if>
    private ${this.pk.jfieldType} ${this.pk.jfieldName};

<#list this.updateFields as field>
    <@call this.addImport("io.swagger.annotations.ApiModelProperty")/>
    @ApiModelProperty(notes = N_${field.jfieldName?upperCase},example = E_${field.jfieldName?upperCase}<#if isTrue(field.notNull)>,required = true</#if>)
    <#if isTrue(field.notNull)>
    @NotNull
    </#if>
    <#if field.dicType??>
        <@call this.addImport("${this.commonPackage}.validator.Const")/>
        <@call this.addConstImport(field.dicType)/>
    @Const(constClass = ${TemplateUtil.fetchClassName(field.dicType)}.class)
    <#elseIf field.jfieldType==JFieldType.STRING.getJavaType()>
        <@call this.addImport("org.hibernate.validator.constraints.Length")/>
    @Length(max = ${field.fieldLength})
    <#elseIf field.jfieldType==JFieldType.DATE.getJavaType()>
        <@call this.addImport("java.util.Date")/>
        <@call this.addImport("com.fasterxml.jackson.annotation.JsonFormat")/>
        <@call this.addImport("${this.commonPackage}.constant.JsonFieldConst")/>
    @JsonFormat(pattern=JsonFieldConst.DEFAULT_DATE_FORMAT,timezone="GMT+8")
    <#elseIf field.jfieldType==JFieldType.BIGDECIMAL.getJavaType()>
        <@call this.addImport("java.math.BigDecimal")/>
    </#if>
    private ${field.jfieldType} ${field.jfieldName};

</#list>
    <#list this.metaEntity.holds! as otherEntity,mtm>
        <@call this.addImport("java.util.List")/>
        <#assign otherPk=otherEntity.pkField>
        <#assign othercName=otherEntity.className?uncapFirst>
    private List<${otherPk.jfieldType}> ${othercName}List;

    </#list>

    <@call TemplateUtil.printGetterSetter(this.pk)/>
<#list this.updateFields as field>
    <@call TemplateUtil.printGetterSetter(field)/>
</#list>
    <#list this.metaEntity.holds! as otherEntity,mtm>
        <#assign otherPk=otherEntity.pkField>
        <#assign othercName=otherEntity.className?uncapFirst>
        <@call TemplateUtil.printGetterSetterList(othercName,otherPk.jfieldType)/>
    </#list>

}
</#assign>
<#--开始渲染代码-->
package ${this.packageName}.pojo.dto;

<@call this.printImport()/>

${code}
