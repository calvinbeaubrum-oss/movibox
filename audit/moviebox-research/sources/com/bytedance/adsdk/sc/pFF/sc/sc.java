package com.bytedance.adsdk.sc.pFF.sc;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private Object[] pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26310sc;

    public Object[] pFF() {
        return this.pFF;
    }

    public String sc() {
        return this.f26310sc;
    }

    public void sc(String str) {
        this.f26310sc = str;
    }

    public void sc(Object[] objArr) {
        this.pFF = objArr;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.f26310sc + "', args=" + Arrays.toString(this.pFF) + '}';
    }
}
