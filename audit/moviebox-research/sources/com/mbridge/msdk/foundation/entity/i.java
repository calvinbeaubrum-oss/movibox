package com.mbridge.msdk.foundation.entity;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f44298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f44299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f44300c;

    public i(String str, String str2, int i11) {
        this.f44299b = str;
        this.f44300c = str2;
        this.f44298a = i11;
    }

    public final String a() {
        return this.f44299b;
    }

    public final String b() {
        return this.f44300c;
    }
}
