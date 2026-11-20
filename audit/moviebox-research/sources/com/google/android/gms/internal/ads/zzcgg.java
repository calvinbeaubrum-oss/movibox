package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgg implements Runnable {
    public zzcgg(zzcgi zzcgiVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
