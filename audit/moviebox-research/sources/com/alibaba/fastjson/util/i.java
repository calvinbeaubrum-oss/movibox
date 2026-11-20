package com.alibaba.fastjson.util;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15595a = false;

    static {
        try {
            Class.forName("java.sql.Time");
            f15595a = true;
        } catch (Throwable unused) {
            f15595a = false;
        }
    }

    public static <T, U, R> R a(c<T, U, R> cVar, T t11, U u11) {
        if (f15595a) {
            return cVar.apply(t11, u11);
        }
        return null;
    }

    public static <ARG, T> T b(e<ARG, T> eVar, ARG arg) {
        if (f15595a) {
            return eVar.apply(arg);
        }
        return null;
    }

    public static <T> T c(Callable<T> callable) {
        if (!f15595a) {
            return null;
        }
        try {
            return callable.call();
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }
}
