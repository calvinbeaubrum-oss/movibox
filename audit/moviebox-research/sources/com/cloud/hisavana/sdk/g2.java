package com.cloud.hisavana.sdk;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f29723a = new AtomicInteger();

    public static String a() {
        String strValueOf = String.valueOf(f29723a.incrementAndGet());
        String strValueOf2 = String.valueOf((int) (((new SecureRandom().nextDouble() * 9.0d) + 1.0d) * 100000.0d));
        return strValueOf + String.valueOf(System.currentTimeMillis()) + strValueOf2;
    }
}
