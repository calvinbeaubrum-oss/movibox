package com.google.android.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class j implements s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.o f33293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f33297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f33298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f33300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f33302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f33303k;

    public j() {
        this(new com.google.android.exoplayer2.upstream.o(true, 65536), DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, false, 0, false);
    }

    public j(com.google.android.exoplayer2.upstream.o oVar, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16, boolean z12) {
        d(i13, 0, "bufferForPlaybackMs", "0");
        d(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
        d(i11, i13, "minBufferMs", "bufferForPlaybackMs");
        d(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        d(i12, i11, "maxBufferMs", "minBufferMs");
        d(i16, 0, "backBufferDurationMs", "0");
        this.f33293a = oVar;
        this.f33294b = com.google.android.exoplayer2.util.o0.C0(i11);
        this.f33295c = com.google.android.exoplayer2.util.o0.C0(i12);
        this.f33296d = com.google.android.exoplayer2.util.o0.C0(i13);
        this.f33297e = com.google.android.exoplayer2.util.o0.C0(i14);
        this.f33298f = i15;
        this.f33302j = i15 == -1 ? C.DEFAULT_VIDEO_BUFFER_SIZE : i15;
        this.f33299g = z11;
        this.f33300h = com.google.android.exoplayer2.util.o0.C0(i16);
        this.f33301i = z12;
    }

    public static void d(int i11, int i12, String str, String str2) {
        com.google.android.exoplayer2.util.a.b(i11 >= i12, str + " cannot be less than " + str2);
    }

    public static int f(int i11) {
        switch (i11) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return C.DEFAULT_VIDEO_BUFFER_SIZE;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    @Override // com.google.android.exoplayer2.s1
    public boolean a(long j11, long j12, float f11) {
        boolean z11 = true;
        boolean z12 = this.f33293a.c() >= this.f33302j;
        long jMin = this.f33294b;
        if (f11 > 1.0f) {
            jMin = Math.min(com.google.android.exoplayer2.util.o0.a0(jMin, f11), this.f33295c);
        }
        if (j12 < Math.max(jMin, 500000L)) {
            if (!this.f33299g && z12) {
                z11 = false;
            }
            this.f33303k = z11;
            if (!z11 && j12 < 500000) {
                com.google.android.exoplayer2.util.s.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.f33295c || z12) {
            this.f33303k = false;
        }
        return this.f33303k;
    }

    @Override // com.google.android.exoplayer2.s1
    public boolean b(long j11, float f11, boolean z11, long j12) {
        long jF0 = com.google.android.exoplayer2.util.o0.f0(j11, f11);
        long jMin = z11 ? this.f33297e : this.f33296d;
        if (j12 != C.TIME_UNSET) {
            jMin = Math.min(j12 / 2, jMin);
        }
        return jMin <= 0 || jF0 >= jMin || (!this.f33299g && this.f33293a.c() >= this.f33302j);
    }

    @Override // com.google.android.exoplayer2.s1
    public void c(w2[] w2VarArr, nh.k0 k0Var, fi.s[] sVarArr) {
        int iE = this.f33298f;
        if (iE == -1) {
            iE = e(w2VarArr, sVarArr);
        }
        this.f33302j = iE;
        this.f33293a.e(iE);
    }

    public int e(w2[] w2VarArr, fi.s[] sVarArr) {
        int iF = 0;
        for (int i11 = 0; i11 < w2VarArr.length; i11++) {
            if (sVarArr[i11] != null) {
                iF += f(w2VarArr[i11].getTrackType());
            }
        }
        return Math.max(C.DEFAULT_VIDEO_BUFFER_SIZE, iF);
    }

    public final void g(boolean z11) {
        int i11 = this.f33298f;
        if (i11 == -1) {
            i11 = C.DEFAULT_VIDEO_BUFFER_SIZE;
        }
        this.f33302j = i11;
        this.f33303k = false;
        if (z11) {
            this.f33293a.d();
        }
    }

    @Override // com.google.android.exoplayer2.s1
    public com.google.android.exoplayer2.upstream.b getAllocator() {
        return this.f33293a;
    }

    @Override // com.google.android.exoplayer2.s1
    public long getBackBufferDurationUs() {
        return this.f33300h;
    }

    @Override // com.google.android.exoplayer2.s1
    public void onPrepared() {
        g(false);
    }

    @Override // com.google.android.exoplayer2.s1
    public void onReleased() {
        g(true);
    }

    @Override // com.google.android.exoplayer2.s1
    public void onStopped() {
        g(true);
    }

    @Override // com.google.android.exoplayer2.s1
    public boolean retainBackBufferFromKeyframe() {
        return this.f33301i;
    }
}
