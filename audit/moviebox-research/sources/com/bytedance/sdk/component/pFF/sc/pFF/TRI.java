package com.bytedance.sdk.component.pFF.sc.pFF;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class TRI {
    static long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static ExN f26943sc;

    private TRI() {
    }

    public static ExN sc() {
        synchronized (TRI.class) {
            ExN exN = f26943sc;
            if (exN == null) {
                return new ExN();
            }
            f26943sc = exN.TRI;
            exN.TRI = null;
            pFF -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return exN;
        }
    }

    public static void sc(ExN exN) {
        if (exN.TRI != null || exN.f26940qr != null) {
            throw new IllegalArgumentException();
        }
        if (exN.We) {
            return;
        }
        synchronized (TRI.class) {
            try {
                long j11 = pFF;
                if (j11 + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                pFF = j11 + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                exN.TRI = f26943sc;
                exN.zY = 0;
                exN.pFF = 0;
                f26943sc = exN;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
