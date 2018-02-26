package com.open.micro.service.config.interceptors;

import com.google.common.base.Strings;

/**
 * Created by Harry
 */

/**
 * create traceId for every Thread
 */
public class TraceIdHelper {

    public static ThreadLocal<String> traceIdHolder = new ThreadLocal<String>();

    public static void setTraceId( String traceId ) {
        if ( Strings.isNullOrEmpty(traceId) ) return;
        traceIdHolder.set(traceId);
    }
    
    public static String getTraceId() {
		return traceIdHolder.get();
	}

	public static void clear() {
        traceIdHolder.remove();
    }
}
