package com.bytedance.adsdk.ugeno.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static Map<String, pFF> f26396sc = new HashMap();

    public static pFF sc(String str) {
        return f26396sc.get(str);
    }

    public static void sc(List<pFF> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (pFF pff : list) {
            if (pff != null) {
                f26396sc.put(pff.sc(), pff);
            }
        }
    }
}
