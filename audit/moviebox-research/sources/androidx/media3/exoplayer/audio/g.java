package androidx.media3.exoplayer.audio;

import androidx.media3.common.PlaybackException;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.math.RoundingMode;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements DefaultAudioSink.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9988h;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9989a = 250000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9990b = 750000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9991c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9992d = 250000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9993e = 50000000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9994f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f9995g = 4;

        public g h() {
            return new g(this);
        }
    }

    public g(a aVar) {
        this.f9982b = aVar.f9989a;
        this.f9983c = aVar.f9990b;
        this.f9984d = aVar.f9991c;
        this.f9985e = aVar.f9992d;
        this.f9986f = aVar.f9993e;
        this.f9987g = aVar.f9994f;
        this.f9988h = aVar.f9995g;
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
            case 19:
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
            case 20:
                return 63750;
        }
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.e
    public int a(int i11, int i12, int i13, int i14, int i15, int i16, double d11) {
        return (((Math.max(i11, (int) (((double) c(i11, i12, i13, i14, i15, i16)) * d11)) + i14) - 1) / i14) * i14;
    }

    public int c(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i13 == 0) {
            return g(i11, i15, i14);
        }
        if (i13 == 1) {
            return e(i12);
        }
        if (i13 == 2) {
            return f(i12, i16);
        }
        throw new IllegalArgumentException();
    }

    public int e(int i11) {
        return Ints.d((((long) this.f9986f) * ((long) d(i11))) / 1000000);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0014  */
    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    public int f(int i11, int i12) {
        int i13;
        int iD;
        int i14 = this.f9985e;
        if (i11 != 5) {
            if (i11 == 8) {
                i13 = this.f9988h;
            }
            if (i12 != -1) {
                iD = com.google.common.math.d.c(i12, 8, RoundingMode.CEILING);
            } else {
                iD = d(i11);
            }
            return Ints.d((((long) i14) * ((long) iD)) / 1000000);
        }
        i13 = this.f9987g;
        i14 *= i13;
        if (i12 != -1) {
            iD = com.google.common.math.d.c(i12, 8, RoundingMode.CEILING);
        } else {
            iD = d(i11);
        }
        return Ints.d((((long) i14) * ((long) iD)) / 1000000);
    }

    public int g(int i11, int i12, int i13) {
        return u0.p(i11 * this.f9984d, b(this.f9982b, i12, i13), b(this.f9983c, i12, i13));
    }
}
