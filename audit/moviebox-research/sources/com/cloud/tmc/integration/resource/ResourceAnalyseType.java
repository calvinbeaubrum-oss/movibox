package com.cloud.tmc.integration.resource;

import com.cloud.tmc.kernel.proxy.performanceanalyse.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum ResourceAnalyseType implements c {
    INTERCEPT_RESOURCE("[Render]:替换资源:");

    String des;

    ResourceAnalyseType(String str) {
        this.des = str;
    }

    public String getDes() {
        return this.des;
    }
}
