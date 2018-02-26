package com.open.micro.service.model;

import java.io.Serializable;

import com.open.micro.service.config.interceptors.TraceIdHelper;

/**
 * Created by jiaguang on 7/11/16.
 */
public class Result implements Serializable{
	private static final long serialVersionUID = 642651043174947736L;
	
	public static final String CODE_SUCCESS = "200";
	public static final String CODE_FAIL = "500";
	public static final String CODE_NOT_FOUND = "404";
	
	private String code = CODE_FAIL;
	private Object data;
    private Boolean success = false;
    private String msg;
    private String traceId;

    public Result() {
        this.success = false;
    }

    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(Object data, Boolean success, String msg) {
        this.data = data;
        this.success = success;
        this.msg = msg;
    }
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}
	
	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public static Result createSuccess() {
		Result result = new Result();
		result.setSuccess(true);
		result.setCode( CODE_SUCCESS );
		result.setTraceId( TraceIdHelper.getTraceId() );
		return result;
	}
	
	public static Result createFail( String err ) {
		Result result = new Result();
		result.setMsg( err );
		result.setTraceId( TraceIdHelper.getTraceId() );
		return result;
	}
	
	
}
