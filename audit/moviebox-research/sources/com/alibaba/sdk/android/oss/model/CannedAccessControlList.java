package com.alibaba.sdk.android.oss.model;

import com.cloud.tmc.integration.core.TmcEngineFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum CannedAccessControlList {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default(TmcEngineFactory.ENGINE_TYPE_DEFAULT);

    private String ACLString;

    CannedAccessControlList(String str) {
        this.ACLString = str;
    }

    public static CannedAccessControlList parseACL(String str) {
        for (CannedAccessControlList cannedAccessControlList : values()) {
            if (cannedAccessControlList.toString().equals(str)) {
                return cannedAccessControlList;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ACLString;
    }
}
