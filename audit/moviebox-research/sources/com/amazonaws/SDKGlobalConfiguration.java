package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SDKGlobalConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f15655a = new AtomicInteger(0);

    public static int a() {
        return f15655a.get();
    }

    public static void b(int i11) {
        f15655a.set(i11);
    }
}
