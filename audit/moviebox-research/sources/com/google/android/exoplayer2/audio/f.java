package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g1;
import com.google.common.primitives.Ints;
import com.vungle.warren.error.VungleException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f32832c = new f(new int[]{2}, 8);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f32833d = new f(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ImmutableMap<Integer, Integer> f32834e = new ImmutableMap.b().g(5, 6).g(17, 6).g(7, 6).g(18, 6).g(6, 8).g(8, 8).g(14, 8).d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f32835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32836b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioAttributes f32837a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        /* JADX WARN: Multi-variable type inference failed */
        public static int[] a() {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            g1 it = f.f32834e.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), f32837a)) {
                    aVarBuilder.a(Integer.valueOf(iIntValue));
                }
            }
            aVarBuilder.a(2);
            return Ints.m(aVarBuilder.m());
        }

        public static int b(int i11, int i12) {
            for (int i13 = 8; i13 > 0; i13--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(o0.G(i13)).build(), f32837a)) {
                    return i13;
                }
            }
            return 0;
        }
    }

    public f(@Nullable int[] iArr, int i11) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f32835a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f32835a = new int[0];
        }
        this.f32836b = i11;
    }

    public static boolean b() {
        if (o0.f35608a >= 17) {
            String str = o0.f35610c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static f c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    public static f d(Context context, @Nullable Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f32833d;
        }
        if (o0.f35608a < 29 || !(o0.x0(context) || o0.s0(context))) {
            return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f32832c : new f(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return new f(a.a(), 8);
    }

    public static int e(int i11) {
        int i12 = o0.f35608a;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(o0.f35609b) && i11 == 1) {
            i11 = 2;
        }
        return o0.G(i11);
    }

    public static int g(int i11, int i12) {
        return o0.f35608a >= 29 ? a.b(i11, i12) : ((Integer) com.google.android.exoplayer2.util.a.e(f32834e.getOrDefault(Integer.valueOf(i11), 0))).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Arrays.equals(this.f32835a, fVar.f32835a) && this.f32836b == fVar.f32836b;
    }

    @Nullable
    public Pair<Integer, Integer> f(m1 m1Var) {
        int iF = com.google.android.exoplayer2.util.w.f((String) com.google.android.exoplayer2.util.a.e(m1Var.f33445m), m1Var.f33442j);
        if (!f32834e.containsKey(Integer.valueOf(iF))) {
            return null;
        }
        if (iF == 18 && !i(18)) {
            iF = 6;
        } else if (iF == 8 && !i(8)) {
            iF = 7;
        }
        if (!i(iF)) {
            return null;
        }
        int iG = m1Var.f33458z;
        if (iG == -1 || iF == 18) {
            int i11 = m1Var.A;
            if (i11 == -1) {
                i11 = 48000;
            }
            iG = g(iF, i11);
        } else if (iG > this.f32836b) {
            return null;
        }
        int iE = e(iG);
        if (iE == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iE));
    }

    public boolean h(m1 m1Var) {
        return f(m1Var) != null;
    }

    public int hashCode() {
        return this.f32836b + (Arrays.hashCode(this.f32835a) * 31);
    }

    public boolean i(int i11) {
        return Arrays.binarySearch(this.f32835a, i11) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f32836b + ", supportedEncodings=" + Arrays.toString(this.f32835a) + "]";
    }
}
