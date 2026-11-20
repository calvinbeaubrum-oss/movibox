package com.cloud.tmc.integration.permission.api;

import dd.d;
import dd.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum TmcGroup implements d {
    LEVEL_HIGH("level_high", "level_high"),
    LEVEL_ABOVE_MEDIUM("level_abovemedium", "level_abovemedium"),
    LEVEL_MEDIUM("level_medium", "level_medium"),
    LEVEL_LOW("level_low", "level_low"),
    LEVEL_NONE("level_none", "level_none"),
    LEVEL_APP_DEFAULT("level_app_default", "level_app_default"),
    LEVEL_EMPTY("level_empty", "level_empty");

    private String desc;
    private String level;
    private List<f> permissions;

    TmcGroup(String str, String str2) {
        this.level = str;
        this.desc = str2;
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
        return this.desc;
    }

    @Override // dd.d
    public String groupName() {
        return this.level;
    }

    public List<? extends f> permissions() {
        return this.permissions;
    }
}
