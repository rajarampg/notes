/**
 * 
 */
package org.rg.notesapp.utilities;

/**
 * @author RG
 *
 */
public class ServiceException extends Exception {
	
	 private static final long serialVersionUID = 6520984618289381930L;

	 protected String errorCode;

	  protected String message;

	  public ServiceException (String errorCode,String message){
	  super(message);
	  this.errorCode = errorCode;
	  this.message = message;
	  }

	  public ServiceException (Throwable exception){
	  super(exception);
	  }


	  public Integer getErrorCode(){
	  return Integer.parseInt(errorCode);
	  }

	  @Override
	  public String toString() {

	  return "[ " + this.getClass().getSimpleName() + " : ErrorCode :"+errorCode +" Message "+ message +"]";
	 }

	  @Override
	  public String getMessage() {
	  return message;
	  }

}
