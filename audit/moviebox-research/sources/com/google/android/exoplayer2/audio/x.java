package com.google.android.exoplayer2.audio;

import androidx.media3.common.PlaybackException;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class x implements DefaultAudioSink.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f32960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f32961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f32962g;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32963a = 250000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f32964b = 750000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32965c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f32966d = 250000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32967e = 50000000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f32968f = 2;

        public x g() {
            return new x(this);
        }
    }

    public x(a aVar) {
        this.f32957b = aVar.f32963a;
        this.f32958c = aVar.f32964b;
        this.f32959d = aVar.f32965c;
        this.f32960e = aVar.f32966d;
        this.f32961f = aVar.f32967e;
        this.f32962g = aVar.f32968f;
    }

    public static int b(int i11, int i12, int i13) {
        return Ints.d(((((long) i11) * ((long) i12)) * ((long) i13)) / 1000000);
    }

    public static int d(int i11) {
        switch (i11) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return DefaultOggSeeker.MATCH_BYTE_RANGE;
            case 11:
                return 16000;
            case 12:
                return PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
    public int a(int i11, int i12, int i13, int i14, int i15, double d11) {
        return (((Math.max(i11, (int) (((double) c(i11, i12, i13, i14, i15)) * d11)) + i14) - 1) / i14) * i14;
    }

    public int c(int i11, int i12, int i13, int i14, int i15) {
        if (i13 == 0) {
            return g(i11, i15, i14);
        }
        if (i13 == 1) {
            return e(i12);
        }
        if (i13 == 2) {
            return f(i12);
        }
        throw new IllegalArgumentException();
    }

    public int e(int i11) {
        return Ints.d((((long) this.f32961f) * ((long) d(i11))) / 1000000);
    }

    public int f(int i11) {
        int i12 = this.f32960e;
        if (i11 == 5) {
            i12 *= this.f32962g;
        }
        return Ints.d((((long) i12) * ((long) d(i11))) / 1000000);
    }

    public int g(int i11, int i12, int i13) {
        return o0.q(i11 * this.f32959d, b(this.f32957b, i12, i13), b(this.f32958c, i12, i13));
    }
}
