package com.cloud.hisavana.net.utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CheckUtil {
    private CheckUtil() {
    }

    public static void a(boolean z11, String str) {
        if (!z11) {
            throw new AssertionError(str);
        }
    }
}
