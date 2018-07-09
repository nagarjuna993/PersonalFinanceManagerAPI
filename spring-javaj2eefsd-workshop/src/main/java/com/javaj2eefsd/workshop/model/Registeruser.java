package com.javaj2eefsd.workshop.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Registeruser
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document(collection="user")
public class Registeruser   {
	
	@Id
	@JsonProperty("userId")
	private String userId = null;
	
	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;
	
	@Indexed(unique=true)
	@JsonProperty("emailId")
	private String emailId = null;

	@JsonProperty("password")
	private String password = null;

	@Indexed(unique=true)
	@JsonProperty("mobileNumber")
	private BigDecimal mobileNumber = null;

	@JsonProperty("otp")
	private int otp;

	@JsonProperty("userStatus")
	private boolean userStatus=false;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Registeruser firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * @return firstName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Registeruser lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * @return lastName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Registeruser emailId(String emailId) {
		this.emailId = emailId;
		return this;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * Get emailId
	 * @return emailId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull




	public Registeruser password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * @return password
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Registeruser mobileNumber(BigDecimal mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	/**
	 * Get mobileNumber
	 * @return mobileNumber
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public BigDecimal getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigDecimal mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Registeruser otp(int otp) {
		this.otp=otp;
		return this;
	}

	/**
	 * Get mobileNumber
	 * @return mobileNumber
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	public Registeruser userStatus(boolean userStatus) {
		this.userStatus=userStatus;
		return this;
	}

	/**
	 * Get mobileNumber
	 * @return mobileNumber
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid

	public boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Registeruser registeruser = (Registeruser) o;
		return Objects.equals(this.firstName, registeruser.firstName) &&
				Objects.equals(this.lastName, registeruser.lastName) &&
				Objects.equals(this.emailId, registeruser.emailId) &&
				Objects.equals(this.password, registeruser.password) &&
				Objects.equals(this.mobileNumber, registeruser.mobileNumber) &&
				Objects.equals(this.otp, registeruser.otp) &&
				Objects.equals(this.userStatus, registeruser.userStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, emailId, password, mobileNumber,otp, userStatus);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Registeruser {\n");

		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
		sb.append("    otp: ").append(toIndentedString(otp)).append("\n");
		sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
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

