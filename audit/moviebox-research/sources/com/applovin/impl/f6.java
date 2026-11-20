package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f6 implements lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r5 f18868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f18874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f18875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f18876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18878k;

    public f6() {
        this(new r5(true, 65536), DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, false, 0, false);
    }

    public f6(r5 r5Var, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16, boolean z12) {
        a(i13, 0, "bufferForPlaybackMs", "0");
        a(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i11, i13, "minBufferMs", "bufferForPlaybackMs");
        a(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i12, i11, "maxBufferMs", "minBufferMs");
        a(i16, 0, "backBufferDurationMs", "0");
        this.f18868a = r5Var;
        this.f18869b = t2.a(i11);
        this.f18870c = t2.a(i12);
        this.f18871d = t2.a(i13);
        this.f18872e = t2.a(i14);
        this.f18873f = i15;
        this.f18877j = i15 == -1 ? C.DEFAULT_VIDEO_BUFFER_SIZE : i15;
        this.f18874g = z11;
        this.f18875h = t2.a(i16);
        this.f18876i = z12;
    }

    private static int a(int i11) {
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

    private static void a(int i11, int i12, String str, String str2) {
        b1.a(i11 >= i12, str + " cannot be less than " + str2);
    }

    private void a(boolean z11) {
        int i11 = this.f18873f;
        if (i11 == -1) {
            i11 = C.DEFAULT_VIDEO_BUFFER_SIZE;
        }
        this.f18877j = i11;
        this.f18878k = false;
        if (z11) {
            this.f18868a.e();
        }
    }

    public int a(qi[] qiVarArr, h8[] h8VarArr) {
        int iA = 0;
        for (int i11 = 0; i11 < qiVarArr.length; i11++) {
            if (h8VarArr[i11] != null) {
                iA += a(qiVarArr[i11].e());
            }
        }
        return Math.max(C.DEFAULT_VIDEO_BUFFER_SIZE, iA);
    }

    @Override // com.applovin.impl.lc
    public void a(qi[] qiVarArr, po poVar, h8[] h8VarArr) {
        int iA = this.f18873f;
        if (iA == -1) {
            iA = a(qiVarArr, h8VarArr);
        }
        this.f18877j = iA;
        this.f18868a.a(iA);
    }

    @Override // com.applovin.impl.lc
    public boolean a() {
        return this.f18876i;
    }

    @Override // com.applovin.impl.lc
    public boolean a(long j11, float f11, boolean z11, long j12) {
        long jB = xp.b(j11, f11);
        long jMin = z11 ? this.f18872e : this.f18871d;
        if (j12 != C.TIME_UNSET) {
            jMin = Math.min(j12 / 2, jMin);
        }
        return jMin <= 0 || jB >= jMin || (!this.f18874g && this.f18868a.d() >= this.f18877j);
    }

    @Override // com.applovin.impl.lc
    public boolean a(long j11, long j12, float f11) {
        boolean z11 = true;
        boolean z12 = this.f18868a.d() >= this.f18877j;
        long jMin = this.f18869b;
        if (f11 > 1.0f) {
            jMin = Math.min(xp.a(jMin, f11), this.f18870c);
        }
        if (j12 < Math.max(jMin, 500000L)) {
            if (!this.f18874g && z12) {
                z11 = false;
            }
            this.f18878k = z11;
            if (!z11 && j12 < 500000) {
                pc.d("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.f18870c || z12) {
            this.f18878k = false;
        }
        return this.f18878k;
    }

    @Override // com.applovin.impl.lc
    public n0 b() {
        return this.f18868a;
    }

    @Override // com.applovin.impl.lc
    public void c() {
        a(true);
    }

    @Override // com.applovin.impl.lc
    public long d() {
        return this.f18875h;
    }

    @Override // com.applovin.impl.lc
    public void e() {
        a(true);
    }

    @Override // com.applovin.impl.lc
    public void f() {
        a(false);
    }
}
