package com.cloud.tmc.integration.permission;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface TmcNativePermissionRequestProxy {
    void addPermRequestCallback(int i11, IPermissionRequestCallback iPermissionRequestCallback);

    int getRequestCode();

    void onRequestPermissionResult(int i11, String[] strArr, int[] iArr);
}
