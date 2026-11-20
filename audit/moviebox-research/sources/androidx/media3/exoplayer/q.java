package androidx.media3.exoplayer;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.h f10954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f10962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10964k;

    public q() {
        this(new androidx.media3.exoplayer.upstream.h(true, 65536), DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, false, 0, false);
    }

    public q(androidx.media3.exoplayer.upstream.h hVar, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16, boolean z12) {
        d(i13, 0, "bufferForPlaybackMs", "0");
        d(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
        d(i11, i13, "minBufferMs", "bufferForPlaybackMs");
        d(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        d(i12, i11, "maxBufferMs", "minBufferMs");
        d(i16, 0, "backBufferDurationMs", "0");
        this.f10954a = hVar;
        this.f10955b = z3.u0.S0(i11);
        this.f10956c = z3.u0.S0(i12);
        this.f10957d = z3.u0.S0(i13);
        this.f10958e = z3.u0.S0(i14);
        this.f10959f = i15;
        this.f10963j = i15 == -1 ? C.DEFAULT_VIDEO_BUFFER_SIZE : i15;
        this.f10960g = z11;
        this.f10961h = z3.u0.S0(i16);
        this.f10962i = z12;
    }

    public static void d(int i11, int i12, String str, String str2) {
        z3.a.b(i11 >= i12, str + " cannot be less than " + str2);
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

    @Override // androidx.media3.exoplayer.v1
    public boolean a(long j11, long j12, float f11) {
        boolean z11 = true;
        boolean z12 = this.f10954a.c() >= this.f10963j;
        long jMin = this.f10955b;
        if (f11 > 1.0f) {
            jMin = Math.min(z3.u0.h0(jMin, f11), this.f10956c);
        }
        if (j12 < Math.max(jMin, 500000L)) {
            if (!this.f10960g && z12) {
                z11 = false;
            }
            this.f10964k = z11;
            if (!z11 && j12 < 500000) {
                z3.o.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.f10956c || z12) {
            this.f10964k = false;
        }
        return this.f10964k;
    }

    @Override // androidx.media3.exoplayer.v1
    public void b(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, w2[] w2VarArr, p4.k0 k0Var, s4.z[] zVarArr) {
        int iE = this.f10959f;
        if (iE == -1) {
            iE = e(w2VarArr, zVarArr);
        }
        this.f10963j = iE;
        this.f10954a.e(iE);
    }

    @Override // androidx.media3.exoplayer.v1
    public boolean c(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, long j11, float f11, boolean z11, long j12) {
        long jM0 = z3.u0.m0(j11, f11);
        long jMin = z11 ? this.f10958e : this.f10957d;
        if (j12 != C.TIME_UNSET) {
            jMin = Math.min(j12 / 2, jMin);
        }
        return jMin <= 0 || jM0 >= jMin || (!this.f10960g && this.f10954a.c() >= this.f10963j);
    }

    public int e(w2[] w2VarArr, s4.z[] zVarArr) {
        int iF = 0;
        for (int i11 = 0; i11 < w2VarArr.length; i11++) {
            if (zVarArr[i11] != null) {
                iF += f(w2VarArr[i11].getTrackType());
            }
        }
        return Math.max(C.DEFAULT_VIDEO_BUFFER_SIZE, iF);
    }

    public final void g(boolean z11) {
        int i11 = this.f10959f;
        if (i11 == -1) {
            i11 = C.DEFAULT_VIDEO_BUFFER_SIZE;
        }
        this.f10963j = i11;
        this.f10964k = false;
        if (z11) {
            this.f10954a.d();
        }
    }

    @Override // androidx.media3.exoplayer.v1
    public androidx.media3.exoplayer.upstream.b getAllocator() {
        return this.f10954a;
    }

    @Override // androidx.media3.exoplayer.v1
    public long getBackBufferDurationUs() {
        return this.f10961h;
    }

    @Override // androidx.media3.exoplayer.v1
    public void onPrepared() {
        g(false);
    }

    @Override // androidx.media3.exoplayer.v1
    public void onReleased() {
        g(true);
    }

    @Override // androidx.media3.exoplayer.v1
    public void onStopped() {
        g(true);
    }

    @Override // androidx.media3.exoplayer.v1
    public boolean retainBackBufferFromKeyframe() {
        return this.f10962i;
    }
}
