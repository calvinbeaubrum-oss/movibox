package com.bytedance.adsdk.ugeno.We;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static Map<String, zY> f26372sc = new HashMap();

    public static zY sc(String str) {
        return f26372sc.get(str);
    }

    public static void sc(List<zY> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (zY zYVar : list) {
            if (zYVar != null) {
                f26372sc.put(zYVar.sc(), zYVar);
            }
        }
    }
}
