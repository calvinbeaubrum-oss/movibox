package com.google.common.base;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static void a(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new VerifyException(p.c(str, objArr));
        }
    }
}
