package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import com.mbridge.msdk.c.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f45553a;

    public abstract void a(int i11, long j11, int i12, k kVar, String str, String str2, com.mbridge.msdk.b.a.a aVar, boolean z11);

    public final synchronized void a(int i11, long j11, int i12, k kVar, String str, String str2, boolean z11, com.mbridge.msdk.b.a.a aVar) {
        try {
            a(i11, j11, i12, kVar, str, str2, aVar, z11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
