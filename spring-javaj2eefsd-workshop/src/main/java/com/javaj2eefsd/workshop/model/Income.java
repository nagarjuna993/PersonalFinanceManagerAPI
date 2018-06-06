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
 * Income
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

public class Income   {
  @JsonProperty("incomeId")
  private String incomeId = null;

  @JsonProperty("incomeAmount")
  private Double incomeAmount = null;

  @JsonProperty("incomeType")
  private String incomeType = null;

  @JsonProperty("incomeDate")
  private OffsetDateTime incomeDate = null;

  public Income incomeId(String incomeId) {
    this.incomeId = incomeId;
    return this;
  }

  /**
   * Get incomeId
   * @return incomeId
  **/
  @ApiModelProperty(value = "")


  public String getIncomeId() {
    return incomeId;
  }

  public void setIncomeId(String incomeId) {
    this.incomeId = incomeId;
  }

  public Income incomeAmount(Double incomeAmount) {
    this.incomeAmount = incomeAmount;
    return this;
  }

  /**
   * Get incomeAmount
   * @return incomeAmount
  **/
  @ApiModelProperty(value = "")


  public Double getIncomeAmount() {
    return incomeAmount;
  }

  public void setIncomeAmount(Double incomeAmount) {
    this.incomeAmount = incomeAmount;
  }

  public Income incomeType(String incomeType) {
    this.incomeType = incomeType;
    return this;
  }

  /**
   * Get incomeType
   * @return incomeType
  **/
  @ApiModelProperty(value = "")


  public String getIncomeType() {
    return incomeType;
  }

  public void setIncomeType(String incomeType) {
    this.incomeType = incomeType;
  }

  public Income incomeDate(OffsetDateTime incomeDate) {
    this.incomeDate = incomeDate;
    return this;
  }

  /**
   * Get incomeDate
   * @return incomeDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getIncomeDate() {
    return incomeDate;
  }

  public void setIncomeDate(OffsetDateTime incomeDate) {
    this.incomeDate = incomeDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Income income = (Income) o;
    return Objects.equals(this.incomeId, income.incomeId) &&
        Objects.equals(this.incomeAmount, income.incomeAmount) &&
        Objects.equals(this.incomeType, income.incomeType) &&
        Objects.equals(this.incomeDate, income.incomeDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(incomeId, incomeAmount, incomeType, incomeDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Income {\n");
    
    sb.append("    incomeId: ").append(toIndentedString(incomeId)).append("\n");
    sb.append("    incomeAmount: ").append(toIndentedString(incomeAmount)).append("\n");
    sb.append("    incomeType: ").append(toIndentedString(incomeType)).append("\n");
    sb.append("    incomeDate: ").append(toIndentedString(incomeDate)).append("\n");
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

