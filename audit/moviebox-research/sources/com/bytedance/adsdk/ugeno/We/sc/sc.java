package com.bytedance.adsdk.ugeno.We.sc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private volatile Map<String, zY> f26381sc = new HashMap();

    public zY sc(String str) {
        if (this.f26381sc.containsKey(str) && this.f26381sc.get(str) != null) {
            return this.f26381sc.get(str);
        }
        pFF pff = new pFF();
        this.f26381sc.put(str, pff);
        return pff;
    }

    public void sc(String str, zY zYVar) {
        if (!this.f26381sc.containsKey(str) || this.f26381sc.get(str) == null) {
            this.f26381sc.put(str, zYVar);
        }
    }
}
