package com.duynb.spring.eureka.gateway.constant;

import org.springframework.http.HttpMethod;

import java.util.*;

public class PermissionConstants {

    // thêm permission cho từng role
    public static final Map<String, List<PermissionEnum>> ROLE_PERMISSIONS = new HashMap<>();

    static {
        ROLE_PERMISSIONS.put("USER", Arrays.asList(PermissionEnum.PERMISSION_GET_CAU_THU_BY_CLB, PermissionEnum.PERMISSION_GET_CAU_THU_BY_ID));
        ROLE_PERMISSIONS.put("ADMIN", Arrays.asList(PermissionEnum.PERMISSION_UPDATE_CAU_THU));
        // Add more roles and their permissions here
    }
}
