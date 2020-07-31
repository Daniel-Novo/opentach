/*
 * Volvo Group Tachograph Files API Volvo Group Tachograph Files API The version of the OpenAPI document: 1.0.0 NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit the class manually.
 */

package com.opentach.server.remotevehicle.provider.volvo.client.model;

import java.util.Objects;

import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * TachoFileResponseObject
 */
@JsonPropertyOrder({ TachoFileResponseObject.JSON_PROPERTY_TACHO_FILES_RESPONSE, TachoFileResponseObject.JSON_PROPERTY_MORE_DATA_AVAILABLE, TachoFileResponseObject.JSON_PROPERTY_MORE_DATA_AVAILABLE_LINK, TachoFileResponseObject.JSON_PROPERTY_REQUEST_SERVER_DATE_TIME })
public class TachoFileResponseObject {
	public static final String							JSON_PROPERTY_TACHO_FILES_RESPONSE		= "tachoFilesResponse";
	private TachoFileResponseObjectTachoFilesResponse	tachoFilesResponse;

	public static final String							JSON_PROPERTY_MORE_DATA_AVAILABLE		= "moreDataAvailable";
	private Boolean										moreDataAvailable;

	public static final String							JSON_PROPERTY_MORE_DATA_AVAILABLE_LINK	= "moreDataAvailableLink";
	private String										moreDataAvailableLink;

	public static final String							JSON_PROPERTY_REQUEST_SERVER_DATE_TIME	= "requestServerDateTime";
	private OffsetDateTime								requestServerDateTime;

	public TachoFileResponseObject tachoFilesResponse(TachoFileResponseObjectTachoFilesResponse tachoFilesResponse) {

		this.tachoFilesResponse = tachoFilesResponse;
		return this;
	}

	/**
	 * Get tachoFilesResponse
	 *
	 * @return tachoFilesResponse
	 **/
	@JsonProperty(TachoFileResponseObject.JSON_PROPERTY_TACHO_FILES_RESPONSE)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public TachoFileResponseObjectTachoFilesResponse getTachoFilesResponse() {
		return this.tachoFilesResponse;
	}

	public void setTachoFilesResponse(TachoFileResponseObjectTachoFilesResponse tachoFilesResponse) {
		this.tachoFilesResponse = tachoFilesResponse;
	}

	public TachoFileResponseObject moreDataAvailable(Boolean moreDataAvailable) {

		this.moreDataAvailable = moreDataAvailable;
		return this;
	}

	/**
	 * This will be set to true if the result set was too large to be sent back in one reply. A new request must be done to get the rest of the tachograph files, where the
	 * starttime parameter must be supplied. The starttime should be set to the latest ReceivedDateTime + 1 second, in the result set of this message. It is important to check both
	 * the driver card files and the tachograph files to get the latest ReceivedDateTime.
	 *
	 * @return moreDataAvailable
	 **/
	@JsonProperty(TachoFileResponseObject.JSON_PROPERTY_MORE_DATA_AVAILABLE)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public Boolean getMoreDataAvailable() {
		return this.moreDataAvailable;
	}

	public void setMoreDataAvailable(Boolean moreDataAvailable) {
		this.moreDataAvailable = moreDataAvailable;
	}

	public TachoFileResponseObject moreDataAvailableLink(String moreDataAvailableLink) {

		this.moreDataAvailableLink = moreDataAvailableLink;
		return this;
	}

	/**
	 * Populated with the link to the next part of the result when moreDataAvailable is true. The link is relative, i.e. starts with /tacho/tachofiles, and preserves any query
	 * parameters from the original request.
	 *
	 * @return moreDataAvailableLink
	 **/
	@JsonProperty(TachoFileResponseObject.JSON_PROPERTY_MORE_DATA_AVAILABLE_LINK)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getMoreDataAvailableLink() {
		return this.moreDataAvailableLink;
	}

	public void setMoreDataAvailableLink(String moreDataAvailableLink) {
		this.moreDataAvailableLink = moreDataAvailableLink;
	}

	public TachoFileResponseObject requestServerDateTime(OffsetDateTime requestServerDateTime) {

		this.requestServerDateTime = requestServerDateTime;
		return this;
	}

	/**
	 * Time in UTC to be used to ask for historical data (for starttime), to solve the problem of having different times at server and clients. This is the time at the server when
	 * this request was received. To avoid losing any messages or get duplicates, this is the time that should be supplied in the startTime parameter in the next request.
	 *
	 * @return requestServerDateTime
	 **/
	@JsonProperty(TachoFileResponseObject.JSON_PROPERTY_REQUEST_SERVER_DATE_TIME)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public OffsetDateTime getRequestServerDateTime() {
		return this.requestServerDateTime;
	}

	public void setRequestServerDateTime(OffsetDateTime requestServerDateTime) {
		this.requestServerDateTime = requestServerDateTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}
		TachoFileResponseObject tachoFileResponseObject = (TachoFileResponseObject) o;
		return Objects.equals(this.tachoFilesResponse, tachoFileResponseObject.tachoFilesResponse) && Objects.equals(this.moreDataAvailable,
				tachoFileResponseObject.moreDataAvailable) && Objects.equals(this.moreDataAvailableLink,
						tachoFileResponseObject.moreDataAvailableLink) && Objects.equals(this.requestServerDateTime, tachoFileResponseObject.requestServerDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.tachoFilesResponse, this.moreDataAvailable, this.moreDataAvailableLink, this.requestServerDateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TachoFileResponseObject {\n");
		sb.append("    tachoFilesResponse: ").append(this.toIndentedString(this.tachoFilesResponse)).append("\n");
		sb.append("    moreDataAvailable: ").append(this.toIndentedString(this.moreDataAvailable)).append("\n");
		sb.append("    moreDataAvailableLink: ").append(this.toIndentedString(this.moreDataAvailableLink)).append("\n");
		sb.append("    requestServerDateTime: ").append(this.toIndentedString(this.requestServerDateTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
