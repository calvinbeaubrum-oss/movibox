package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f32786a = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f32787b = {44100, 48000, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f32788c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f32789d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f32790e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f32791f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f32792g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f32794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f32796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f32798f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f32799g;

        public boolean a(int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (!b0.l(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
                return false;
            }
            this.f32793a = i12;
            this.f32794b = b0.f32786a[3 - i13];
            int i16 = b0.f32787b[i15];
            this.f32796d = i16;
            if (i12 == 2) {
                this.f32796d = i16 / 2;
            } else if (i12 == 0) {
                this.f32796d = i16 / 4;
            }
            int i17 = (i11 >>> 9) & 1;
            this.f32799g = b0.k(i12, i13);
            if (i13 == 3) {
                int i18 = i12 == 3 ? b0.f32788c[i14 - 1] : b0.f32789d[i14 - 1];
                this.f32798f = i18;
                this.f32795c = (((i18 * 12) / this.f32796d) + i17) * 4;
            } else {
                if (i12 == 3) {
                    int i19 = i13 == 2 ? b0.f32790e[i14 - 1] : b0.f32791f[i14 - 1];
                    this.f32798f = i19;
                    this.f32795c = ((i19 * 144) / this.f32796d) + i17;
                } else {
                    int i21 = b0.f32792g[i14 - 1];
                    this.f32798f = i21;
                    this.f32795c = (((i13 == 1 ? 72 : 144) * i21) / this.f32796d) + i17;
                }
            }
            this.f32797e = ((i11 >> 6) & 3) == 3 ? 1 : 2;
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
        int i17 = f32787b[i15];
        if (i12 == 2) {
            i17 /= 2;
        } else if (i12 == 0) {
            i17 /= 4;
        }
        int i18 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            return ((((i12 == 3 ? f32788c[i14 - 1] : f32789d[i14 - 1]) * 12) / i17) + i18) * 4;
        }
        if (i12 == 3) {
            i16 = i13 == 2 ? f32790e[i14 - 1] : f32791f[i14 - 1];
        } else {
            i16 = f32792g[i14 - 1];
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
