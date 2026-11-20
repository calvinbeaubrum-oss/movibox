package com.applovin.impl;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f20037a = {1, 2, 3, 6};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f20038b = {48000, 44100, 32000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f20039c = {24000, 22050, 16000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f20040d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f20041e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.AUDIO_STREAM, 224, 256, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f20042f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20047e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f20048f;

        private b(String str, int i11, int i12, int i13, int i14, int i15) {
            this.f20043a = str;
            this.f20044b = i11;
            this.f20046d = i12;
            this.f20045c = i13;
            this.f20047e = i14;
            this.f20048f = i15;
        }
    }

    private static int a(int i11, int i12) {
        int i13 = i12 / 2;
        if (i11 < 0) {
            return -1;
        }
        int[] iArr = f20038b;
        if (i11 >= iArr.length || i12 < 0) {
            return -1;
        }
        int[] iArr2 = f20042f;
        if (i13 >= iArr2.length) {
            return -1;
        }
        int i14 = iArr[i11];
        if (i14 == 44100) {
            return (iArr2[i13] + (i12 % 2)) * 2;
        }
        int i15 = f20041e[i13];
        return i14 == 32000 ? i15 * 6 : i15 * 4;
    }

    public static int a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i11 = iPosition; i11 <= iLimit; i11++) {
            if ((xp.a(byteBuffer, i11 + 4) & (-2)) == -126718022) {
                return i11 - iPosition;
            }
        }
        return -1;
    }

    public static int a(ByteBuffer byteBuffer, int i11) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i11) + ((byteBuffer.get((byteBuffer.position() + i11) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b11 = bArr[4];
        return a((b11 & 192) >> 6, b11 & Utf8.REPLACEMENT_BYTE);
    }

    public static f9 a(bh bhVar, String str, String str2, y6 y6Var) {
        int i11 = f20038b[(bhVar.w() & PsExtractor.AUDIO_STREAM) >> 6];
        int iW = bhVar.w();
        int i12 = f20040d[(iW & 56) >> 3];
        if ((iW & 4) != 0) {
            i12++;
        }
        return new f9.b().c(str).f(MimeTypes.AUDIO_AC3).c(i12).n(i11).a(y6Var).e(str2).a();
    }

    public static b a(ah ahVar) {
        String str;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iA;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int iE = ahVar.e();
        ahVar.d(40);
        boolean z11 = ahVar.a(5) > 10;
        ahVar.c(iE);
        int i22 = -1;
        if (z11) {
            ahVar.d(16);
            int iA2 = ahVar.a(2);
            if (iA2 == 0) {
                i22 = 0;
            } else if (iA2 == 1) {
                i22 = 1;
            } else if (iA2 == 2) {
                i22 = 2;
            }
            ahVar.d(3);
            int iA3 = (ahVar.a(11) + 1) * 2;
            int iA4 = ahVar.a(2);
            if (iA4 == 3) {
                i17 = f20039c[ahVar.a(2)];
                iA = 3;
                i16 = 6;
            } else {
                iA = ahVar.a(2);
                i16 = f20037a[iA];
                i17 = f20038b[iA4];
            }
            int i23 = i16 * 256;
            int iA5 = ahVar.a(3);
            boolean zF = ahVar.f();
            int i24 = f20040d[iA5] + (zF ? 1 : 0);
            ahVar.d(10);
            if (ahVar.f()) {
                ahVar.d(8);
            }
            if (iA5 == 0) {
                ahVar.d(5);
                if (ahVar.f()) {
                    ahVar.d(8);
                }
            }
            if (i22 == 1 && ahVar.f()) {
                ahVar.d(16);
            }
            if (ahVar.f()) {
                if (iA5 > 2) {
                    ahVar.d(2);
                }
                if ((iA5 & 1) == 0 || iA5 <= 2) {
                    i19 = 6;
                } else {
                    i19 = 6;
                    ahVar.d(6);
                }
                if ((iA5 & 4) != 0) {
                    ahVar.d(i19);
                }
                if (zF && ahVar.f()) {
                    ahVar.d(5);
                }
                if (i22 == 0) {
                    if (ahVar.f()) {
                        i21 = 6;
                        ahVar.d(6);
                    } else {
                        i21 = 6;
                    }
                    if (iA5 == 0 && ahVar.f()) {
                        ahVar.d(i21);
                    }
                    if (ahVar.f()) {
                        ahVar.d(i21);
                    }
                    int iA6 = ahVar.a(2);
                    if (iA6 == 1) {
                        ahVar.d(5);
                    } else if (iA6 == 2) {
                        ahVar.d(12);
                    } else if (iA6 == 3) {
                        int iA7 = ahVar.a(5);
                        if (ahVar.f()) {
                            ahVar.d(5);
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                ahVar.d(4);
                            }
                            if (ahVar.f()) {
                                if (ahVar.f()) {
                                    ahVar.d(4);
                                }
                                if (ahVar.f()) {
                                    ahVar.d(4);
                                }
                            }
                        }
                        if (ahVar.f()) {
                            ahVar.d(5);
                            if (ahVar.f()) {
                                ahVar.d(7);
                                if (ahVar.f()) {
                                    ahVar.d(8);
                                }
                            }
                        }
                        ahVar.d((iA7 + 2) * 8);
                        ahVar.c();
                    }
                    if (iA5 < 2) {
                        if (ahVar.f()) {
                            ahVar.d(14);
                        }
                        if (iA5 == 0 && ahVar.f()) {
                            ahVar.d(14);
                        }
                    }
                    if (ahVar.f()) {
                        if (iA == 0) {
                            ahVar.d(5);
                        } else {
                            for (int i25 = 0; i25 < i16; i25++) {
                                if (ahVar.f()) {
                                    ahVar.d(5);
                                }
                            }
                        }
                    }
                }
            }
            if (ahVar.f()) {
                ahVar.d(5);
                if (iA5 == 2) {
                    ahVar.d(4);
                }
                if (iA5 >= 6) {
                    ahVar.d(2);
                }
                if (ahVar.f()) {
                    ahVar.d(8);
                }
                if (iA5 == 0 && ahVar.f()) {
                    ahVar.d(8);
                }
                if (iA4 < 3) {
                    ahVar.g();
                }
            }
            if (i22 == 0 && iA != 3) {
                ahVar.g();
            }
            if (i22 == 2 && (iA == 3 || ahVar.f())) {
                i18 = 6;
                ahVar.d(6);
            } else {
                i18 = 6;
            }
            str = (ahVar.f() && ahVar.a(i18) == 1 && ahVar.a(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i14 = i22;
            i15 = i23;
            i11 = iA3;
            i12 = i17;
            i13 = i24;
        } else {
            ahVar.d(32);
            int iA8 = ahVar.a(2);
            String str2 = iA8 == 3 ? null : MimeTypes.AUDIO_AC3;
            int iA9 = a(iA8, ahVar.a(6));
            ahVar.d(8);
            int iA10 = ahVar.a(3);
            if ((iA10 & 1) != 0 && iA10 != 1) {
                ahVar.d(2);
            }
            if ((iA10 & 4) != 0) {
                ahVar.d(2);
            }
            if (iA10 == 2) {
                ahVar.d(2);
            }
            int[] iArr = f20038b;
            str = str2;
            i11 = iA9;
            i12 = iA8 < iArr.length ? iArr[iA8] : -1;
            i13 = f20040d[iA10] + (ahVar.f() ? 1 : 0);
            i14 = -1;
            i15 = 1536;
        }
        return new b(str, i14, i13, i12, i11, i15);
    }

    public static int b(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f20037a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int b(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b11 = bArr[7];
            if ((b11 & 254) == 186) {
                return 40 << ((bArr[(b11 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }

    public static f9 b(bh bhVar, String str, String str2, y6 y6Var) {
        bhVar.g(2);
        int i11 = f20038b[(bhVar.w() & PsExtractor.AUDIO_STREAM) >> 6];
        int iW = bhVar.w();
        int i12 = f20040d[(iW & 14) >> 1];
        if ((iW & 1) != 0) {
            i12++;
        }
        if (((bhVar.w() & 30) >> 1) > 0 && (2 & bhVar.w()) != 0) {
            i12 += 2;
        }
        return new f9.b().c(str).f((bhVar.a() <= 0 || (bhVar.w() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC).c(i12).n(i11).a(y6Var).e(str2).a();
    }
}
