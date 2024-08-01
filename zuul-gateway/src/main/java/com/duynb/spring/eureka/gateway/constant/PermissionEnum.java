package com.duynb.spring.eureka.gateway.constant;

import org.springframework.http.HttpMethod;

public enum PermissionEnum {
    PERMISSION_UPDATE_CAU_THU("/cau-thu", HttpMethod.PUT),
    PERMISSION_GET_CAU_THU_BY_CLB("/cau-thu/search?**", HttpMethod.GET),
    PERMISSION_GET_CAU_THU_BY_ID("/cau-thu/**", HttpMethod.GET);
    private final String endPoint;
    private final HttpMethod httpMethod;

    PermissionEnum(String endPoint, HttpMethod httpMethod) {
        this.endPoint = endPoint;
        this.httpMethod = httpMethod;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
