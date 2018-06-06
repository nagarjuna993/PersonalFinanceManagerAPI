package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserCurrency
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

public class UserCurrency   {
  @JsonProperty("emailId")
  private String emailId = null;

  @JsonProperty("oldCurrency")
  private String oldCurrency = null;

  @JsonProperty("newCurrency")
  private String newCurrency = null;

  public UserCurrency emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }

  /**
   * Get emailId
   * @return emailId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public UserCurrency oldCurrency(String oldCurrency) {
    this.oldCurrency = oldCurrency;
    return this;
  }

  /**
   * Get oldCurrency
   * @return oldCurrency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getOldCurrency() {
    return oldCurrency;
  }

  public void setOldCurrency(String oldCurrency) {
    this.oldCurrency = oldCurrency;
  }

  public UserCurrency newCurrency(String newCurrency) {
    this.newCurrency = newCurrency;
    return this;
  }

  /**
   * Get newCurrency
   * @return newCurrency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNewCurrency() {
    return newCurrency;
  }

  public void setNewCurrency(String newCurrency) {
    this.newCurrency = newCurrency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCurrency userCurrency = (UserCurrency) o;
    return Objects.equals(this.emailId, userCurrency.emailId) &&
        Objects.equals(this.oldCurrency, userCurrency.oldCurrency) &&
        Objects.equals(this.newCurrency, userCurrency.newCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailId, oldCurrency, newCurrency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCurrency {\n");
    
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    oldCurrency: ").append(toIndentedString(oldCurrency)).append("\n");
    sb.append("    newCurrency: ").append(toIndentedString(newCurrency)).append("\n");
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

