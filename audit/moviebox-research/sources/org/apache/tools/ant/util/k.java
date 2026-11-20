package org.apache.tools.ant.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f72980a = d.k();

    public static ClassLoader a() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static boolean b() {
        return true;
    }

    public static void c(ClassLoader classLoader) {
        Thread.currentThread().setContextClassLoader(classLoader);
    }
}
