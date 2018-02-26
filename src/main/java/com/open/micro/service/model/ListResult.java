package com.open.micro.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaguang on 7/11/16.
 */
public class ListResult<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8409667412682157085L;
	private List<T> list = new ArrayList<T>();
    private Boolean success = false;
    private String msg;
    private String traceId;
    private Long totalCount;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageNo;

    public ListResult() {
        this.success = false;
    }

    public ListResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ListResult(List<T> list, Boolean success, String msg, Long totalCount, Integer totalPages, Integer pageSize, Integer pageNo) {
        this.list = list;
        this.success = success;
        this.msg = msg;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
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

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	
}
