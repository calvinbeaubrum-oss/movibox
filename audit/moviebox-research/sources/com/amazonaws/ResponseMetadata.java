package com.amazonaws;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResponseMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f15654a;

    public ResponseMetadata(Map<String, String> map) {
        this.f15654a = map;
    }

    public String a() {
        return this.f15654a.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map<String, String> map = this.f15654a;
        return map == null ? "{}" : map.toString();
    }
}
