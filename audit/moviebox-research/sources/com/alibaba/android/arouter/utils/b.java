package com.alibaba.android.arouter.utils;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean b(Map<?, ?> map) {
        return !a(map);
    }
}
