package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Expense
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

public class Expense   {
  @JsonProperty("expenseId")
  private String expenseId = null;

  @JsonProperty("expenseAmount")
  private Double expenseAmount = null;

  @JsonProperty("expenseType")
  private String expenseType = null;

  @JsonProperty("expenseDate")
  private OffsetDateTime expenseDate = null;

  @JsonProperty("created_date")
  private OffsetDateTime createdDate = null;

  @JsonProperty("updated_date")
  private OffsetDateTime updatedDate = null;

  @JsonProperty("is_delete")
  private Boolean isDelete = null;

  @JsonProperty("create_by")
  private String createBy = null;

  @JsonProperty("upd_by")
  private String updBy = null;

  @JsonProperty("login_id")
  private String loginId = null;

  @JsonProperty("expense_name")
  private String expenseName = null;

  public Expense expenseId(String expenseId) {
    this.expenseId = expenseId;
    return this;
  }

  /**
   * Get expenseId
   * @return expenseId
  **/
  @ApiModelProperty(value = "")


  public String getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(String expenseId) {
    this.expenseId = expenseId;
  }

  public Expense expenseAmount(Double expenseAmount) {
    this.expenseAmount = expenseAmount;
    return this;
  }

  /**
   * Get expenseAmount
   * @return expenseAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getExpenseAmount() {
    return expenseAmount;
  }

  public void setExpenseAmount(Double expenseAmount) {
    this.expenseAmount = expenseAmount;
  }

  public Expense expenseType(String expenseType) {
    this.expenseType = expenseType;
    return this;
  }

  /**
   * Get expenseType
   * @return expenseType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getExpenseType() {
    return expenseType;
  }

  public void setExpenseType(String expenseType) {
    this.expenseType = expenseType;
  }

  public Expense expenseDate(OffsetDateTime expenseDate) {
    this.expenseDate = expenseDate;
    return this;
  }

  /**
   * Get expenseDate
   * @return expenseDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getExpenseDate() {
    return expenseDate;
  }

  public void setExpenseDate(OffsetDateTime expenseDate) {
    this.expenseDate = expenseDate;
  }

  public Expense createdDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Expense updatedDate(OffsetDateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(OffsetDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Expense isDelete(Boolean isDelete) {
    this.isDelete = isDelete;
    return this;
  }

  /**
   * Get isDelete
   * @return isDelete
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsDelete() {
    return isDelete;
  }

  public void setIsDelete(Boolean isDelete) {
    this.isDelete = isDelete;
  }

  public Expense createBy(String createBy) {
    this.createBy = createBy;
    return this;
  }

  /**
   * Get createBy
   * @return createBy
  **/
  @ApiModelProperty(value = "")


  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public Expense updBy(String updBy) {
    this.updBy = updBy;
    return this;
  }

  /**
   * Get updBy
   * @return updBy
  **/
  @ApiModelProperty(value = "")


  public String getUpdBy() {
    return updBy;
  }

  public void setUpdBy(String updBy) {
    this.updBy = updBy;
  }

  public Expense loginId(String loginId) {
    this.loginId = loginId;
    return this;
  }

  /**
   * Get loginId
   * @return loginId
  **/
  @ApiModelProperty(value = "")


  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public Expense expenseName(String expenseName) {
    this.expenseName = expenseName;
    return this;
  }

  /**
   * Get expenseName
   * @return expenseName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getExpenseName() {
    return expenseName;
  }

  public void setExpenseName(String expenseName) {
    this.expenseName = expenseName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Expense expense = (Expense) o;
    return Objects.equals(this.expenseId, expense.expenseId) &&
        Objects.equals(this.expenseAmount, expense.expenseAmount) &&
        Objects.equals(this.expenseType, expense.expenseType) &&
        Objects.equals(this.expenseDate, expense.expenseDate) &&
        Objects.equals(this.createdDate, expense.createdDate) &&
        Objects.equals(this.updatedDate, expense.updatedDate) &&
        Objects.equals(this.isDelete, expense.isDelete) &&
        Objects.equals(this.createBy, expense.createBy) &&
        Objects.equals(this.updBy, expense.updBy) &&
        Objects.equals(this.loginId, expense.loginId) &&
        Objects.equals(this.expenseName, expense.expenseName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expenseId, expenseAmount, expenseType, expenseDate, createdDate, updatedDate, isDelete, createBy, updBy, loginId, expenseName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Expense {\n");
    
    sb.append("    expenseId: ").append(toIndentedString(expenseId)).append("\n");
    sb.append("    expenseAmount: ").append(toIndentedString(expenseAmount)).append("\n");
    sb.append("    expenseType: ").append(toIndentedString(expenseType)).append("\n");
    sb.append("    expenseDate: ").append(toIndentedString(expenseDate)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
    sb.append("    isDelete: ").append(toIndentedString(isDelete)).append("\n");
    sb.append("    createBy: ").append(toIndentedString(createBy)).append("\n");
    sb.append("    updBy: ").append(toIndentedString(updBy)).append("\n");
    sb.append("    loginId: ").append(toIndentedString(loginId)).append("\n");
    sb.append("    expenseName: ").append(toIndentedString(expenseName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

