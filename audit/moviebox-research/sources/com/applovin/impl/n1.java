package com.applovin.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n1 f21218c = new n1(new int[]{2}, 8);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final n1 f21219d = new n1(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f21220e = {5, 6, 18, 17, 14, 7, 8};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f21221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21222b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static int[] a() {
            eb.a aVarF = eb.f();
            for (int i11 : n1.f21220e) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i11).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    aVarF.b(Integer.valueOf(i11));
                }
            }
            aVarF.b(2);
            return ub.a(aVarF.a());
        }
    }

    public n1(int[] iArr, int i11) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f21221a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f21221a = new int[0];
        }
        this.f21222b = i11;
    }

    public static n1 a(Context context) {
        return a(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public static n1 a(Context context, Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f21219d;
        }
        if (xp.f24372a < 29 || !xp.d(context)) {
            return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f21218c : new n1(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return new n1(a.a(), 8);
    }

    private static boolean b() {
        if (xp.f24372a >= 17) {
            String str = xp.f24374c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i11) {
        return Arrays.binarySearch(this.f21221a, i11) >= 0;
    }

    public int c() {
        return this.f21222b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return Arrays.equals(this.f21221a, n1Var.f21221a) && this.f21222b == n1Var.f21222b;
    }

    public int hashCode() {
        return this.f21222b + (Arrays.hashCode(this.f21221a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f21222b + ", supportedEncodings=" + Arrays.toString(this.f21221a) + "]";
    }
}
