package com.cloud.tmc.kernel.security;

import dd.d;
import dd.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum DefaultGroup implements d {
    INTERNAL("internal", "first party"),
    PARTNER("partner", "second party"),
    EXTERNAL("external", "third party");

    private String description;
    private String groupName;
    private List<f> permissions;

    DefaultGroup(String str, String str2) {
        this.groupName = str;
        this.description = str2;
    }

    public void assignPermissions(List<? extends f> list) {
        if (this.permissions == null) {
            this.permissions = new ArrayList();
        }
        this.permissions.addAll(list);
    }

    public void clearPermissions() {
        List<f> list = this.permissions;
        if (list != null) {
            list.clear();
        }
    }

    public String description() {
        return this.description;
    }

    @Override // dd.d
    public String groupName() {
        return this.groupName;
    }

    public List<? extends f> permissions() {
        return this.permissions;
    }
}
