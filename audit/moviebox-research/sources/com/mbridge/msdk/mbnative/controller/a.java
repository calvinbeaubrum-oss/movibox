package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f45552a;

    public abstract void a(int i11, long j11, int i12, String str);

    public final synchronized void a(long j11, int i11, boolean z11, String str, String str2) {
        a(1, j11, i11, str2);
    }
}
