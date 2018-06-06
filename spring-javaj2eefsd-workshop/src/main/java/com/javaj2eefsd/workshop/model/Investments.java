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
 * Investments
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

public class Investments   {
  @JsonProperty("investmentsId")
  private String investmentsId = null;

  @JsonProperty("investmentsAmount")
  private Double investmentsAmount = null;

  @JsonProperty("investmentsType")
  private String investmentsType = null;

  @JsonProperty("investmentsDate")
  private OffsetDateTime investmentsDate = null;

  public Investments investmentsId(String investmentsId) {
    this.investmentsId = investmentsId;
    return this;
  }

  /**
   * Get investmentsId
   * @return investmentsId
  **/
  @ApiModelProperty(value = "")


  public String getInvestmentsId() {
    return investmentsId;
  }

  public void setInvestmentsId(String investmentsId) {
    this.investmentsId = investmentsId;
  }

  public Investments investmentsAmount(Double investmentsAmount) {
    this.investmentsAmount = investmentsAmount;
    return this;
  }

  /**
   * Get investmentsAmount
   * @return investmentsAmount
  **/
  @ApiModelProperty(value = "")


  public Double getInvestmentsAmount() {
    return investmentsAmount;
  }

  public void setInvestmentsAmount(Double investmentsAmount) {
    this.investmentsAmount = investmentsAmount;
  }

  public Investments investmentsType(String investmentsType) {
    this.investmentsType = investmentsType;
    return this;
  }

  /**
   * Get investmentsType
   * @return investmentsType
  **/
  @ApiModelProperty(value = "")


  public String getInvestmentsType() {
    return investmentsType;
  }

  public void setInvestmentsType(String investmentsType) {
    this.investmentsType = investmentsType;
  }

  public Investments investmentsDate(OffsetDateTime investmentsDate) {
    this.investmentsDate = investmentsDate;
    return this;
  }

  /**
   * Get investmentsDate
   * @return investmentsDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getInvestmentsDate() {
    return investmentsDate;
  }

  public void setInvestmentsDate(OffsetDateTime investmentsDate) {
    this.investmentsDate = investmentsDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Investments investments = (Investments) o;
    return Objects.equals(this.investmentsId, investments.investmentsId) &&
        Objects.equals(this.investmentsAmount, investments.investmentsAmount) &&
        Objects.equals(this.investmentsType, investments.investmentsType) &&
        Objects.equals(this.investmentsDate, investments.investmentsDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(investmentsId, investmentsAmount, investmentsType, investmentsDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Investments {\n");
    
    sb.append("    investmentsId: ").append(toIndentedString(investmentsId)).append("\n");
    sb.append("    investmentsAmount: ").append(toIndentedString(investmentsAmount)).append("\n");
    sb.append("    investmentsType: ").append(toIndentedString(investmentsType)).append("\n");
    sb.append("    investmentsDate: ").append(toIndentedString(investmentsDate)).append("\n");
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

