package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TagSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f16111a;

    public TagSet() {
        this.f16111a = new HashMap(1);
    }

    public TagSet(Map<String, String> map) {
        HashMap map2 = new HashMap(1);
        this.f16111a = map2;
        map2.putAll(map);
    }

    public Map<String, String> a() {
        return this.f16111a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
