package com.bytedance.sdk.openadsdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {
    static float pFF = 0.0f;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static int f28728sc = -1;
    private static long zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public final float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final int f28729sc;

        public sc(int i11, float f11) {
            this.f28729sc = i11;
            this.pFF = f11;
        }
    }

    @NonNull
    public static sc sc() {
        if (zY == 0 || SystemClock.elapsedRealtime() - zY > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            Intent intentRegisterReceiver = com.bytedance.sdk.openadsdk.core.Xc.sc().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            "obtainCurrentState: registerReceiver result is ".concat(String.valueOf(intentRegisterReceiver));
            if (intentRegisterReceiver != null) {
                sc(intentRegisterReceiver);
                zY = SystemClock.elapsedRealtime();
            }
        }
        return new sc(f28728sc, pFF);
    }

    private static void sc(Intent intent) {
        if (intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1) == 2) {
            f28728sc = 1;
        } else {
            f28728sc = 0;
        }
        pFF = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
    }
}
