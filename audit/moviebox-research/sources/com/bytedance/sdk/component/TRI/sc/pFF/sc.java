package com.bytedance.sdk.component.TRI.sc.pFF;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.bytedance.sdk.component.TRI.sc.sc.ExN;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    public static boolean ExN() {
        ExN exNWe = Qj.qr().We();
        return (exNWe == null || TextUtils.isEmpty(exNWe.zY())) ? false : true;
    }

    public static boolean TRI() {
        ExN exNWe = Qj.qr().We();
        return (exNWe == null || TextUtils.isEmpty(exNWe.TRI())) ? false : true;
    }

    public static boolean We() {
        ExN exNWe = Qj.qr().We();
        return (exNWe == null || TextUtils.isEmpty(exNWe.ExN())) ? false : true;
    }

    private static long pFF(int i11, Context context) {
        if (context == null) {
            return i11;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long jMaxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            return jFreeMemory <= 10 ? Math.min(i11, 10) : Math.min((jFreeMemory / 2) * 10, i11);
        }
        long j11 = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j11 <= 2) {
            return 1L;
        }
        return j11 <= 10 ? Math.min(i11, 10) : Math.min(j11 * 10, i11);
    }

    public static boolean pFF() {
        ExN exNWe = Qj.qr().We();
        return (exNWe == null || TextUtils.isEmpty(exNWe.pFF())) ? false : true;
    }

    public static long sc(int i11, Context context) {
        return pFF(i11, context);
    }

    public static boolean sc() {
        ExN exNWe = Qj.qr().We();
        return (exNWe == null || TextUtils.isEmpty(exNWe.sc())) ? false : true;
    }

    public static boolean zY() {
        ExN exNWe = Qj.qr().We();
        return (exNWe == null || TextUtils.isEmpty(exNWe.We())) ? false : true;
    }
}
