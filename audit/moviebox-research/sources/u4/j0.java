package u4;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f78308a = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f78309b = {44100, 48000, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f78310c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f78311d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f78312e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f78313f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f78314g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f78315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f78316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f78317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f78318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f78319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f78320f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f78321g;

        public boolean a(int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (!j0.l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
                return false;
            }
            this.f78315a = i12;
            this.f78316b = j0.f78308a[3 - i13];
            int i16 = j0.f78309b[i15];
            this.f78318d = i16;
            if (i12 == 2) {
                this.f78318d = i16 / 2;
            } else if (i12 == 0) {
                this.f78318d = i16 / 4;
            }
            int i17 = (i11 >>> 9) & 1;
            this.f78321g = j0.k(i12, i13);
            if (i13 == 3) {
                int i18 = i12 == 3 ? j0.f78310c[i14 - 1] : j0.f78311d[i14 - 1];
                this.f78320f = i18;
                this.f78317c = (((i18 * 12) / this.f78318d) + i17) * 4;
            } else {
                if (i12 == 3) {
                    int i19 = i13 == 2 ? j0.f78312e[i14 - 1] : j0.f78313f[i14 - 1];
                    this.f78320f = i19;
                    this.f78317c = ((i19 * 144) / this.f78318d) + i17;
                } else {
                    int i21 = j0.f78314g[i14 - 1];
                    this.f78320f = i21;
                    this.f78317c = (((i13 == 1 ? 72 : 144) * i21) / this.f78318d) + i17;
                }
            }
            this.f78319e = ((i11 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (!l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return -1;
        }
        int i17 = f78309b[i15];
        if (i12 == 2) {
            i17 /= 2;
        } else if (i12 == 0) {
            i17 /= 4;
        }
        int i18 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            return ((((i12 == 3 ? f78310c[i14 - 1] : f78311d[i14 - 1]) * 12) / i17) + i18) * 4;
        }
        if (i12 == 3) {
            i16 = i13 == 2 ? f78312e[i14 - 1] : f78313f[i14 - 1];
        } else {
            i16 = f78314g[i14 - 1];
        }
        if (i12 == 3) {
            return ((i16 * 144) / i17) + i18;
        }
        return (((i13 == 1 ? 72 : 144) * i16) / i17) + i18;
    }

    public static int k(int i11, int i12) {
        if (i12 == 1) {
            return i11 == 3 ? 1152 : 576;
        }
        if (i12 == 2) {
            return 1152;
        }
        if (i12 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    public static boolean l(int i11) {
        return (i11 & (-2097152)) == -2097152;
    }

    public static int m(int i11) {
        int i12;
        int i13;
        if (!l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0) {
            return -1;
        }
        int i14 = (i11 >>> 12) & 15;
        int i15 = (i11 >>> 10) & 3;
        if (i14 == 0 || i14 == 15 || i15 == 3) {
            return -1;
        }
        return k(i12, i13);
    }
}
