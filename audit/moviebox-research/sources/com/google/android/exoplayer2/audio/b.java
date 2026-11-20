package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f32774a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f32775b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f32776c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f32777d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f32778e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f32779f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: com.google.android.exoplayer2.audio.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0358b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f32780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f32784e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f32785f;

        public C0358b(@Nullable String str, int i11, int i12, int i13, int i14, int i15) {
            this.f32780a = str;
            this.f32781b = i11;
            this.f32783d = i12;
            this.f32782c = i13;
            this.f32784e = i14;
            this.f32785f = i15;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i11 = iPosition; i11 <= iLimit; i11++) {
            if ((o0.I(byteBuffer, i11 + 4) & (-2)) == -126718022) {
                return i11 - iPosition;
            }
        }
        return -1;
    }

    public static int b(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0) {
            return -1;
        }
        int[] iArr = f32775b;
        if (i11 >= iArr.length || i12 < 0) {
            return -1;
        }
        int[] iArr2 = f32779f;
        if (i13 >= iArr2.length) {
            return -1;
        }
        int i14 = iArr[i11];
        if (i14 == 44100) {
            return (iArr2[i13] + (i12 % 2)) * 2;
        }
        int i15 = f32778e[i13];
        return i14 == 32000 ? i15 * 6 : i15 * 4;
    }

    public static m1 c(com.google.android.exoplayer2.util.c0 c0Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        int i11 = f32775b[(c0Var.D() & PsExtractor.AUDIO_STREAM) >> 6];
        int iD = c0Var.D();
        int i12 = f32777d[(iD & 56) >> 3];
        if ((iD & 4) != 0) {
            i12++;
        }
        return new m1.b().S(str).e0(MimeTypes.AUDIO_AC3).H(i12).f0(i11).M(drmInitData).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f32774a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0358b e(com.google.android.exoplayer2.util.b0 b0Var) {
        String str;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iH;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int iE = b0Var.e();
        b0Var.r(40);
        boolean z11 = b0Var.h(5) > 10;
        b0Var.p(iE);
        int i22 = -1;
        if (z11) {
            b0Var.r(16);
            int iH2 = b0Var.h(2);
            if (iH2 == 0) {
                i22 = 0;
            } else if (iH2 == 1) {
                i22 = 1;
            } else if (iH2 == 2) {
                i22 = 2;
            }
            b0Var.r(3);
            int iH3 = (b0Var.h(11) + 1) * 2;
            int iH4 = b0Var.h(2);
            if (iH4 == 3) {
                i17 = f32776c[b0Var.h(2)];
                iH = 3;
                i16 = 6;
            } else {
                iH = b0Var.h(2);
                i16 = f32774a[iH];
                i17 = f32775b[iH4];
            }
            int i23 = i16 * 256;
            int iH5 = b0Var.h(3);
            boolean zG = b0Var.g();
            int i24 = f32777d[iH5] + (zG ? 1 : 0);
            b0Var.r(10);
            if (b0Var.g()) {
                b0Var.r(8);
            }
            if (iH5 == 0) {
                b0Var.r(5);
                if (b0Var.g()) {
                    b0Var.r(8);
                }
            }
            if (i22 == 1 && b0Var.g()) {
                b0Var.r(16);
            }
            if (b0Var.g()) {
                if (iH5 > 2) {
                    b0Var.r(2);
                }
                if ((iH5 & 1) == 0 || iH5 <= 2) {
                    i19 = 6;
                } else {
                    i19 = 6;
                    b0Var.r(6);
                }
                if ((iH5 & 4) != 0) {
                    b0Var.r(i19);
                }
                if (zG && b0Var.g()) {
                    b0Var.r(5);
                }
                if (i22 == 0) {
                    if (b0Var.g()) {
                        i21 = 6;
                        b0Var.r(6);
                    } else {
                        i21 = 6;
                    }
                    if (iH5 == 0 && b0Var.g()) {
                        b0Var.r(i21);
                    }
                    if (b0Var.g()) {
                        b0Var.r(i21);
                    }
                    int iH6 = b0Var.h(2);
                    if (iH6 == 1) {
                        b0Var.r(5);
                    } else if (iH6 == 2) {
                        b0Var.r(12);
                    } else if (iH6 == 3) {
                        int iH7 = b0Var.h(5);
                        if (b0Var.g()) {
                            b0Var.r(5);
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                b0Var.r(4);
                            }
                            if (b0Var.g()) {
                                if (b0Var.g()) {
                                    b0Var.r(4);
                                }
                                if (b0Var.g()) {
                                    b0Var.r(4);
                                }
                            }
                        }
                        if (b0Var.g()) {
                            b0Var.r(5);
                            if (b0Var.g()) {
                                b0Var.r(7);
                                if (b0Var.g()) {
                                    b0Var.r(8);
                                }
                            }
                        }
                        b0Var.r((iH7 + 2) * 8);
                        b0Var.c();
                    }
                    if (iH5 < 2) {
                        if (b0Var.g()) {
                            b0Var.r(14);
                        }
                        if (iH5 == 0 && b0Var.g()) {
                            b0Var.r(14);
                        }
                    }
                    if (b0Var.g()) {
                        if (iH == 0) {
                            b0Var.r(5);
                        } else {
                            for (int i25 = 0; i25 < i16; i25++) {
                                if (b0Var.g()) {
                                    b0Var.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (b0Var.g()) {
                b0Var.r(5);
                if (iH5 == 2) {
                    b0Var.r(4);
                }
                if (iH5 >= 6) {
                    b0Var.r(2);
                }
                if (b0Var.g()) {
                    b0Var.r(8);
                }
                if (iH5 == 0 && b0Var.g()) {
                    b0Var.r(8);
                }
                if (iH4 < 3) {
                    b0Var.q();
                }
            }
            if (i22 == 0 && iH != 3) {
                b0Var.q();
            }
            if (i22 == 2 && (iH == 3 || b0Var.g())) {
                i18 = 6;
                b0Var.r(6);
            } else {
                i18 = 6;
            }
            str = (b0Var.g() && b0Var.h(i18) == 1 && b0Var.h(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i14 = i22;
            i15 = i23;
            i11 = iH3;
            i12 = i17;
            i13 = i24;
        } else {
            b0Var.r(32);
            int iH8 = b0Var.h(2);
            String str2 = iH8 == 3 ? null : MimeTypes.AUDIO_AC3;
            int iB = b(iH8, b0Var.h(6));
            b0Var.r(8);
            int iH9 = b0Var.h(3);
            if ((iH9 & 1) != 0 && iH9 != 1) {
                b0Var.r(2);
            }
            if ((iH9 & 4) != 0) {
                b0Var.r(2);
            }
            if (iH9 == 2) {
                b0Var.r(2);
            }
            int[] iArr = f32775b;
            str = str2;
            i11 = iB;
            i12 = iH8 < iArr.length ? iArr[iH8] : -1;
            i13 = f32777d[iH9] + (b0Var.g() ? 1 : 0);
            i14 = -1;
            i15 = 1536;
        }
        return new C0358b(str, i14, i13, i12, i11, i15);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b11 = bArr[4];
        return b((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
    }

    public static m1 g(com.google.android.exoplayer2.util.c0 c0Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        c0Var.Q(2);
        int i11 = f32775b[(c0Var.D() & PsExtractor.AUDIO_STREAM) >> 6];
        int iD = c0Var.D();
        int i12 = f32777d[(iD & 14) >> 1];
        if ((iD & 1) != 0) {
            i12++;
        }
        if (((c0Var.D() & 30) >> 1) > 0 && (2 & c0Var.D()) != 0) {
            i12 += 2;
        }
        return new m1.b().S(str).e0((c0Var.a() <= 0 || (c0Var.D() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC).H(i12).f0(i11).M(drmInitData).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i11) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i11) + ((byteBuffer.get((byteBuffer.position() + i11) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b11 = bArr[7];
            if ((b11 & 254) == 186) {
                return 40 << ((bArr[(b11 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
