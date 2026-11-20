package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y {
    public static void a(Object obj, long j11) {
        LockSupport.parkNanos(obj, Math.min(j11, 2147483647999999999L));
    }
}
