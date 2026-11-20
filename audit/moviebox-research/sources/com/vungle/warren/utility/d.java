package com.vungle.warren.utility;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f62595a = TimeUnit.SECONDS.toMillis(4);

    @Override // com.vungle.warren.utility.u
    public long a() {
        if (t.a()) {
            return f62595a;
        }
        return Long.MAX_VALUE;
    }
}
