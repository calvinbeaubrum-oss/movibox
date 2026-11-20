package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcek extends ScheduledThreadPoolExecutor {
    public zzcek(int i11, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
