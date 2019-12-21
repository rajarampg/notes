/**
 * 
 */
package org.rg.notesapp.utilities;

/**
 * @author RG
 *
 */
public class ResponseBody {

	private Integer statusCode;
	private String message;

	public Integer getResponseCode() {
		return statusCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.statusCode = responseCode;
	}

	public String getResponseMessage() {
		return message;
	}

	public void setResponseMessage(String responseMessage) {
		this.message = responseMessage;
	}

}
