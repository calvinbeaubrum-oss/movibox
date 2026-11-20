package com.cloud.tmc.kernel.utils;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static final boolean a(List list) {
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    public static final boolean b(Map map) {
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }
}
