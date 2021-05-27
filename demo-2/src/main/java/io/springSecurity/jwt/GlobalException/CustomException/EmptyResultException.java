package io.springSecurity.jwt.GlobalException.CustomException;

public class EmptyResultException extends RuntimeException {
private String errorCode;
private String erroMessage;
public EmptyResultException(String errorCode, String erroMessage) {
	this.errorCode = errorCode;
	this.erroMessage = erroMessage;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getErroMessage() {
	return erroMessage;
}
public void setErroMessage(String erroMessage) {
	this.erroMessage = erroMessage;
}

}
