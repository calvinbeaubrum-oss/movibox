package com.cloud.tmc.integration.permission;

import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface BizPermissionManager {
    boolean checkBizParamPermission(String str, String str2, JsonObject jsonObject);
}
