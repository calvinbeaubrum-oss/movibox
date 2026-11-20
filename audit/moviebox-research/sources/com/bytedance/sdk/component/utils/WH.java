package com.bytedance.sdk.component.utils;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {
    public static boolean pFF(List<?> list) {
        return !sc(list);
    }

    public static boolean sc(List<?> list) {
        return list == null || list.size() == 0;
    }
}
