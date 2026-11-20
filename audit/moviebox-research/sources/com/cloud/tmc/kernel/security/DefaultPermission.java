package com.cloud.tmc.kernel.security;

import dd.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum DefaultPermission implements f {
    ALL("all", "") { // from class: com.cloud.tmc.kernel.security.DefaultPermission.1
    };

    private String authority;
    private String description;

    DefaultPermission(String str, String str2) {
        this.authority = str;
        this.description = str2;
    }

    @Override // dd.f
    public String authority() {
        return this.authority;
    }

    public String description() {
        return this.description;
    }
}
