package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzatw implements Runnable {
    private zzatw() {
    }

    public /* synthetic */ zzatw(zzatv zzatvVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzatx.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzatx.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzatx.zzb;
        } catch (Throwable th2) {
            zzatx.zzb.countDown();
            throw th2;
        }
        countDownLatch.countDown();
    }
}
