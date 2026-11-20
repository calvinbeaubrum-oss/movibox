package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f78198a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f78199b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f78200c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f78201d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f78202e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f78203f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: u4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0861b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f78204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f78207d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f78208e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f78209f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f78210g;

        public C0861b(@Nullable String str, int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f78204a = str;
            this.f78205b = i11;
            this.f78207d = i12;
            this.f78206c = i13;
            this.f78208e = i14;
            this.f78209f = i15;
            this.f78210g = i16;
        }
    }

    public static int a(int i11, int i12, int i13) {
        return (i11 * i12) / (i13 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i11 = iPosition; i11 <= iLimit; i11++) {
            if ((z3.u0.O(byteBuffer, i11 + 4) & (-2)) == -126718022) {
                return i11 - iPosition;
            }
        }
        return -1;
    }

    public static int c(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0) {
            return -1;
        }
        int[] iArr = f78199b;
        if (i11 >= iArr.length || i12 < 0) {
            return -1;
        }
        int[] iArr2 = f78203f;
        if (i13 >= iArr2.length) {
            return -1;
        }
        int i14 = iArr[i11];
        if (i14 == 44100) {
            return (iArr2[i13] + (i12 % 2)) * 2;
        }
        int i15 = f78202e[i13];
        return i14 == 32000 ? i15 * 6 : i15 * 4;
    }

    public static androidx.media3.common.y d(z3.c0 c0Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        z3.b0 b0Var = new z3.b0();
        b0Var.m(c0Var);
        int i11 = f78199b[b0Var.h(2)];
        b0Var.r(8);
        int i12 = f78201d[b0Var.h(3)];
        if (b0Var.h(1) != 0) {
            i12++;
        }
        int i13 = f78202e[b0Var.h(5)] * 1000;
        b0Var.c();
        c0Var.U(b0Var.d());
        return new androidx.media3.common.y.b().X(str).k0(MimeTypes.AUDIO_AC3).L(i12).l0(i11).R(drmInitData).b0(str2).K(i13).f0(i13).I();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f78198a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0861b f(z3.b0 b0Var) {
        String str;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int iE = b0Var.e();
        b0Var.r(40);
        boolean z11 = b0Var.h(5) > 10;
        b0Var.p(iE);
        int i24 = -1;
        if (z11) {
            b0Var.r(16);
            int iH = b0Var.h(2);
            if (iH == 0) {
                i24 = 0;
            } else if (iH == 1) {
                i24 = 1;
            } else if (iH == 2) {
                i24 = 2;
            }
            b0Var.r(3);
            int iH2 = (b0Var.h(11) + 1) * 2;
            int iH3 = b0Var.h(2);
            if (iH3 == 3) {
                i18 = f78200c[b0Var.h(2)];
                i17 = 3;
                i19 = 6;
            } else {
                int iH4 = b0Var.h(2);
                int i25 = f78198a[iH4];
                i17 = iH4;
                i18 = f78199b[iH3];
                i19 = i25;
            }
            int i26 = i19 * 256;
            int iA = a(iH2, i18, i19);
            int iH5 = b0Var.h(3);
            boolean zG = b0Var.g();
            int i27 = f78201d[iH5] + (zG ? 1 : 0);
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
            if (i24 == 1 && b0Var.g()) {
                b0Var.r(16);
            }
            if (b0Var.g()) {
                if (iH5 > 2) {
                    b0Var.r(2);
                }
                if ((iH5 & 1) == 0 || iH5 <= 2) {
                    i22 = 6;
                } else {
                    i22 = 6;
                    b0Var.r(6);
                }
                if ((iH5 & 4) != 0) {
                    b0Var.r(i22);
                }
                if (zG && b0Var.g()) {
                    b0Var.r(5);
                }
                if (i24 == 0) {
                    if (b0Var.g()) {
                        i23 = 6;
                        b0Var.r(6);
                    } else {
                        i23 = 6;
                    }
                    if (iH5 == 0 && b0Var.g()) {
                        b0Var.r(i23);
                    }
                    if (b0Var.g()) {
                        b0Var.r(i23);
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
                        if (i17 == 0) {
                            b0Var.r(5);
                        } else {
                            for (int i28 = 0; i28 < i19; i28++) {
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
                if (iH3 < 3) {
                    b0Var.q();
                }
            }
            if (i24 == 0 && i17 != 3) {
                b0Var.q();
            }
            if (i24 == 2 && (i17 == 3 || b0Var.g())) {
                i21 = 6;
                b0Var.r(6);
            } else {
                i21 = 6;
            }
            str = (b0Var.g() && b0Var.h(i21) == 1 && b0Var.h(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i15 = i24;
            i16 = i26;
            i12 = iH2;
            i13 = i18;
            i11 = iA;
            i14 = i27;
        } else {
            b0Var.r(32);
            int iH8 = b0Var.h(2);
            String str2 = iH8 == 3 ? null : MimeTypes.AUDIO_AC3;
            int iH9 = b0Var.h(6);
            int i29 = f78202e[iH9 / 2] * 1000;
            int iC = c(iH8, iH9);
            b0Var.r(8);
            int iH10 = b0Var.h(3);
            if ((iH10 & 1) != 0 && iH10 != 1) {
                b0Var.r(2);
            }
            if ((iH10 & 4) != 0) {
                b0Var.r(2);
            }
            if (iH10 == 2) {
                b0Var.r(2);
            }
            int[] iArr = f78199b;
            str = str2;
            i11 = i29;
            i12 = iC;
            i13 = iH8 < iArr.length ? iArr[iH8] : -1;
            i14 = f78201d[iH10] + (b0Var.g() ? 1 : 0);
            i15 = -1;
            i16 = 1536;
        }
        return new C0861b(str, i15, i14, i13, i12, i16, i11);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b11 = bArr[4];
        return c((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    public static androidx.media3.common.y h(z3.c0 c0Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        String str3;
        z3.b0 b0Var = new z3.b0();
        b0Var.m(c0Var);
        int iH = b0Var.h(13) * 1000;
        b0Var.r(3);
        int i11 = f78199b[b0Var.h(2)];
        b0Var.r(10);
        int i12 = f78201d[b0Var.h(3)];
        if (b0Var.h(1) != 0) {
            i12++;
        }
        b0Var.r(3);
        int iH2 = b0Var.h(4);
        b0Var.r(1);
        if (iH2 > 0) {
            b0Var.r(6);
            if (b0Var.h(1) != 0) {
                i12 += 2;
            }
            b0Var.r(1);
        }
        if (b0Var.b() > 7) {
            b0Var.r(7);
            if (b0Var.h(1) != 0) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str3 = MimeTypes.AUDIO_E_AC3;
            }
        } else {
            str3 = MimeTypes.AUDIO_E_AC3;
        }
        b0Var.c();
        c0Var.U(b0Var.d());
        return new androidx.media3.common.y.b().X(str).k0(str3).L(i12).l0(i11).R(drmInitData).b0(str2).f0(iH).I();
    }

    public static int i(ByteBuffer byteBuffer, int i11) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i11) + ((byteBuffer.get((byteBuffer.position() + i11) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b11 = bArr[7];
            if ((b11 & 254) == 186) {
                return 40 << ((bArr[(b11 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
