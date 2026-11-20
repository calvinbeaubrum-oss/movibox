package org.brotli.dec;

import okhttp3.internal.http2.Settings;
import z20.f;
import z20.g;
import z20.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f73029a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f73030b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f73031c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f73032d = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    public static void a(d dVar) {
        a aVar = dVar.f73035c;
        byte[] bArr = dVar.f73036d;
        int i11 = dVar.f73039g;
        if (i11 <= 0) {
            a.k(aVar);
            dVar.f73033a = 1;
            return;
        }
        int iMin = Math.min(dVar.Q - dVar.f73050r, i11);
        a.c(aVar, bArr, dVar.f73050r, iMin);
        dVar.f73039g -= iMin;
        int i12 = dVar.f73050r + iMin;
        dVar.f73050r = i12;
        int i13 = dVar.Q;
        if (i12 != i13) {
            a.k(aVar);
            dVar.f73033a = 1;
        } else {
            dVar.f73034b = 5;
            dVar.Y = i13;
            dVar.X = 0;
            dVar.f73033a = 12;
        }
    }

    public static void b(d dVar, int i11) {
        int i12;
        a aVar = dVar.f73035c;
        int[] iArr = dVar.f73048p;
        int i13 = i11 * 2;
        a.d(aVar);
        int i14 = i11 * 1080;
        int iR = r(dVar.f73037e, i14, aVar);
        dVar.f73046n[i11] = m(dVar.f73038f, i14, aVar);
        if (iR == 1) {
            i12 = iArr[i13 + 1] + 1;
        } else {
            i12 = iR == 0 ? iArr[i13] : iR - 2;
        }
        int i15 = dVar.f73047o[i11];
        if (i12 >= i15) {
            i12 -= i15;
        }
        int i16 = i13 + 1;
        iArr[i13] = iArr[i16];
        iArr[i16] = i12;
    }

    public static void c(d dVar) {
        b(dVar, 1);
        dVar.F = dVar.f73044l.f81736c[dVar.f73048p[3]];
    }

    public static int d(int i11, byte[] bArr, a aVar) {
        a.j(aVar);
        int iH = h(aVar) + 1;
        if (iH == 1) {
            h.a(bArr, 0, i11);
            return iH;
        }
        int i12 = a.i(aVar, 1) == 1 ? a.i(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        n(iH + i12, iArr, 0, aVar);
        int i13 = 0;
        while (i13 < i11) {
            a.j(aVar);
            a.d(aVar);
            int iR = r(iArr, 0, aVar);
            if (iR == 0) {
                bArr[i13] = 0;
            } else if (iR <= i12) {
                for (int i14 = (1 << iR) + a.i(aVar, iR); i14 != 0; i14--) {
                    if (i13 >= i11) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i13] = 0;
                    i13++;
                }
            } else {
                bArr[i13] = (byte) (iR - i12);
            }
            i13++;
        }
        if (a.i(aVar, 1) == 1) {
            j(bArr, i11);
        }
        return iH;
    }

    public static void e(d dVar) {
        b(dVar, 2);
        dVar.C = dVar.f73048p[5] << 2;
    }

    public static void f(d dVar) {
        b(dVar, 0);
        int i11 = dVar.f73048p[1];
        int i12 = i11 << 6;
        dVar.B = i12;
        int i13 = dVar.A[i12] & 255;
        dVar.f73054v = i13;
        dVar.f73055w = dVar.f73043k.f81736c[i13];
        byte b11 = dVar.f73058z[i11];
        int[] iArr = z20.a.f81730b;
        dVar.D = iArr[b11];
        dVar.E = iArr[b11 + 1];
    }

    public static void g(a aVar, d dVar) {
        boolean z11 = a.i(aVar, 1) == 1;
        dVar.f73040h = z11;
        dVar.f73039g = 0;
        dVar.f73041i = false;
        dVar.f73042j = false;
        if (!z11 || a.i(aVar, 1) == 0) {
            int i11 = a.i(aVar, 2) + 4;
            if (i11 == 7) {
                dVar.f73042j = true;
                if (a.i(aVar, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int i12 = a.i(aVar, 2);
                if (i12 == 0) {
                    return;
                }
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = a.i(aVar, 8);
                    if (i14 == 0 && i13 + 1 == i12 && i12 > 1) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    dVar.f73039g = (i14 << (i13 * 8)) | dVar.f73039g;
                }
            } else {
                for (int i15 = 0; i15 < i11; i15++) {
                    int i16 = a.i(aVar, 4);
                    if (i16 == 0 && i15 + 1 == i11 && i11 > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    dVar.f73039g = (i16 << (i15 * 4)) | dVar.f73039g;
                }
            }
            dVar.f73039g++;
            if (dVar.f73040h) {
                return;
            }
            dVar.f73041i = a.i(aVar, 1) == 1;
        }
    }

    public static int h(a aVar) {
        if (a.i(aVar, 1) == 0) {
            return 0;
        }
        int i11 = a.i(aVar, 3);
        if (i11 == 0) {
            return 1;
        }
        return a.i(aVar, i11) + (1 << i11);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:103:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:111:0x02df  */
    /* JADX WARN: Code duplicated, block: B:161:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x01ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x028b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:? A[LOOP:2: B:48:0x013c->B:191:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x02f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:? A[LOOP:4: B:109:0x02d9->B:196:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:44:0x0100  */
    /* JADX WARN: Code duplicated, block: B:48:0x013c A[LOOP:2: B:48:0x013c->B:191:?, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:50:0x0142  */
    /* JADX WARN: Code duplicated, block: B:52:0x014b  */
    /* JADX WARN: Code duplicated, block: B:56:0x017f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0194  */
    /* JADX WARN: Code duplicated, block: B:61:0x019d  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e7 A[LOOP:5: B:57:0x018e->B:65:0x01e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x0207  */
    /* JADX WARN: Code duplicated, block: B:76:0x0211  */
    /* JADX WARN: Code duplicated, block: B:79:0x022d  */
    /* JADX WARN: Code duplicated, block: B:80:0x022f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0242  */
    /* JADX WARN: Code duplicated, block: B:86:0x026e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0274  */
    /* JADX WARN: Code duplicated, block: B:91:0x027b  */
    /* JADX WARN: Code duplicated, block: B:97:0x028f  */
    public static void i(d dVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iR;
        int i18;
        int i19;
        int iT;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int iR2;
        int i26;
        int i27;
        int i28;
        int i29 = dVar.f73033a;
        if (i29 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i29 == 11) {
            throw new IllegalStateException("Can't decompress after close");
        }
        a aVar = dVar.f73035c;
        int i31 = dVar.Q - 1;
        byte[] bArr = dVar.f73036d;
        while (true) {
            int i32 = dVar.f73033a;
            if (i32 == 10) {
                if (i32 == 10) {
                    if (dVar.f73039g < 0) {
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    a.g(aVar);
                    a.a(dVar.f73035c, true);
                    return;
                }
                return;
            }
            if (i32 != 12) {
                int i33 = 0;
                switch (i32) {
                    case 1:
                        if (dVar.f73039g < 0) {
                            throw new BrotliRuntimeException("Invalid metablock length");
                        }
                        q(dVar);
                        i31 = dVar.Q - 1;
                        bArr = dVar.f73036d;
                        break;
                        break;
                    case 2:
                        p(dVar);
                        dVar.f73033a = 3;
                        if (dVar.f73039g <= 0) {
                            dVar.f73033a = 1;
                        } else {
                            a.j(aVar);
                            if (dVar.f73046n[1] == 0) {
                                c(dVar);
                            }
                            int[] iArr = dVar.f73046n;
                            iArr[1] = iArr[1] - 1;
                            a.d(aVar);
                            int iR3 = r(dVar.f73044l.f81735b, dVar.F, aVar);
                            i28 = iR3 >>> 6;
                            dVar.G = 0;
                            if (i28 >= 2) {
                                i28 -= 2;
                                dVar.G = -1;
                            }
                            int i34 = f.f81745g[i28] + ((iR3 >>> 3) & 7);
                            int i35 = f.f81746h[i28] + (iR3 & 7);
                            dVar.f73057y = f.f81741c[i34] + a.i(aVar, f.f81742d[i34]);
                            dVar.M = f.f81743e[i35] + a.i(aVar, f.f81744f[i35]);
                            dVar.f73056x = 0;
                            dVar.f73033a = 6;
                            if (dVar.f73053u) {
                                while (dVar.f73056x < dVar.f73057y) {
                                    a.j(aVar);
                                    if (dVar.f73046n[0] == 0) {
                                        f(dVar);
                                    }
                                    int[] iArr2 = dVar.f73046n;
                                    iArr2[0] = iArr2[0] - 1;
                                    a.d(aVar);
                                    bArr[dVar.f73050r] = (byte) r(dVar.f73043k.f81735b, dVar.f73055w, aVar);
                                    dVar.f73056x++;
                                    i27 = dVar.f73050r;
                                    dVar.f73050r = i27 + 1;
                                    if (i27 == i31) {
                                        dVar.f73034b = 6;
                                        dVar.Y = dVar.Q;
                                        dVar.X = 0;
                                        dVar.f73033a = 12;
                                    }
                                }
                            } else {
                                int i36 = dVar.f73050r;
                                i16 = bArr[(i36 - 1) & i31] & 255;
                                i17 = bArr[(i36 - 2) & i31] & 255;
                                while (dVar.f73056x < dVar.f73057y) {
                                    a.j(aVar);
                                    if (dVar.f73046n[0] == 0) {
                                        f(dVar);
                                    }
                                    byte[] bArr2 = dVar.A;
                                    int i37 = dVar.B;
                                    int[] iArr3 = z20.a.f81729a;
                                    int i38 = bArr2[i37 + (iArr3[dVar.E + i17] | iArr3[dVar.D + i16])] & 255;
                                    int[] iArr4 = dVar.f73046n;
                                    iArr4[0] = iArr4[0] - 1;
                                    a.d(aVar);
                                    z20.d dVar2 = dVar.f73043k;
                                    iR = r(dVar2.f81735b, dVar2.f81736c[i38], aVar);
                                    i18 = dVar.f73050r;
                                    bArr[i18] = (byte) iR;
                                    dVar.f73056x++;
                                    dVar.f73050r = i18 + 1;
                                    if (i18 == i31) {
                                        dVar.f73034b = 6;
                                        dVar.Y = dVar.Q;
                                        dVar.X = 0;
                                        dVar.f73033a = 12;
                                    } else {
                                        int i39 = i16;
                                        i16 = iR;
                                        i17 = i39;
                                    }
                                }
                            }
                            if (dVar.f73033a != 6) {
                                continue;
                            } else {
                                i19 = dVar.f73039g - dVar.f73057y;
                                dVar.f73039g = i19;
                                if (i19 <= 0) {
                                    dVar.f73033a = 3;
                                } else {
                                    if (dVar.G < 0) {
                                        a.j(aVar);
                                        if (dVar.f73046n[2] == 0) {
                                            e(dVar);
                                        }
                                        int[] iArr5 = dVar.f73046n;
                                        iArr5[2] = iArr5[2] - 1;
                                        a.d(aVar);
                                        z20.d dVar3 = dVar.f73045m;
                                        int[] iArr6 = dVar3.f81735b;
                                        int[] iArr7 = dVar3.f81736c;
                                        byte[] bArr3 = dVar.H;
                                        int i40 = dVar.C;
                                        i24 = dVar.M;
                                        if (i24 > 4) {
                                            i25 = 3;
                                        } else {
                                            i25 = i24 - 2;
                                        }
                                        iR2 = r(iArr6, iArr7[bArr3[i40 + i25] & 255], aVar);
                                        dVar.G = iR2;
                                        i26 = dVar.I;
                                        if (iR2 >= i26) {
                                            int i41 = iR2 - i26;
                                            int i42 = dVar.J & i41;
                                            int i43 = i41 >>> dVar.K;
                                            dVar.G = i43;
                                            int i44 = (i43 >>> 1) + 1;
                                            dVar.G = i26 + i42 + ((((((i43 & 1) + 2) << i44) - 4) + a.i(aVar, i44)) << dVar.K);
                                        }
                                    }
                                    iT = t(dVar.G, dVar.f73049q, dVar.f73052t);
                                    dVar.L = iT;
                                    if (iT < 0) {
                                        throw new BrotliRuntimeException("Negative distance");
                                    }
                                    i21 = dVar.f73051s;
                                    i22 = dVar.O;
                                    if (i21 != i22 || (i23 = dVar.f73050r) >= i22) {
                                        dVar.f73051s = i22;
                                    } else {
                                        dVar.f73051s = i23;
                                    }
                                    dVar.N = dVar.f73050r;
                                    if (iT > dVar.f73051s) {
                                        dVar.f73033a = 9;
                                    } else {
                                        if (dVar.G > 0) {
                                            int[] iArr8 = dVar.f73049q;
                                            int i45 = dVar.f73052t;
                                            iArr8[i45 & 3] = iT;
                                            dVar.f73052t = i45 + 1;
                                        }
                                        if (dVar.M > dVar.f73039g) {
                                            throw new BrotliRuntimeException("Invalid backward reference");
                                        }
                                        dVar.f73056x = 0;
                                        dVar.f73033a = 7;
                                        int i46 = dVar.f73050r;
                                        i11 = (i46 - dVar.L) & i31;
                                        i12 = dVar.M - dVar.f73056x;
                                        if (i11 + i12 < i31 || i46 + i12 >= i31) {
                                            while (true) {
                                                i13 = dVar.f73056x;
                                                if (i13 < dVar.M) {
                                                    i14 = dVar.f73050r;
                                                    bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                                    dVar.f73039g--;
                                                    dVar.f73056x = i13 + 1;
                                                    dVar.f73050r = i14 + 1;
                                                    if (i14 == i31) {
                                                        i15 = 7;
                                                        dVar.f73034b = 7;
                                                        dVar.Y = dVar.Q;
                                                        dVar.X = 0;
                                                        dVar.f73033a = 12;
                                                    }
                                                }
                                            }
                                            if (dVar.f73033a == i15) {
                                                dVar.f73033a = 3;
                                            }
                                        } else {
                                            while (i33 < i12) {
                                                bArr[i46] = bArr[i11];
                                                i33++;
                                                i46++;
                                                i11++;
                                            }
                                            dVar.f73056x += i12;
                                            dVar.f73039g -= i12;
                                            dVar.f73050r += i12;
                                        }
                                        i15 = 7;
                                        if (dVar.f73033a == i15) {
                                            dVar.f73033a = 3;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        if (dVar.f73039g <= 0) {
                            dVar.f73033a = 1;
                        } else {
                            a.j(aVar);
                            if (dVar.f73046n[1] == 0) {
                                c(dVar);
                            }
                            int[] iArr9 = dVar.f73046n;
                            iArr9[1] = iArr9[1] - 1;
                            a.d(aVar);
                            int iR4 = r(dVar.f73044l.f81735b, dVar.F, aVar);
                            i28 = iR4 >>> 6;
                            dVar.G = 0;
                            if (i28 >= 2) {
                                i28 -= 2;
                                dVar.G = -1;
                            }
                            int i310 = f.f81745g[i28] + ((iR4 >>> 3) & 7);
                            int i311 = f.f81746h[i28] + (iR4 & 7);
                            dVar.f73057y = f.f81741c[i310] + a.i(aVar, f.f81742d[i310]);
                            dVar.M = f.f81743e[i311] + a.i(aVar, f.f81744f[i311]);
                            dVar.f73056x = 0;
                            dVar.f73033a = 6;
                            if (dVar.f73053u) {
                                while (dVar.f73056x < dVar.f73057y) {
                                    a.j(aVar);
                                    if (dVar.f73046n[0] == 0) {
                                        f(dVar);
                                    }
                                    int[] iArr10 = dVar.f73046n;
                                    iArr10[0] = iArr10[0] - 1;
                                    a.d(aVar);
                                    bArr[dVar.f73050r] = (byte) r(dVar.f73043k.f81735b, dVar.f73055w, aVar);
                                    dVar.f73056x++;
                                    i27 = dVar.f73050r;
                                    dVar.f73050r = i27 + 1;
                                    if (i27 == i31) {
                                        dVar.f73034b = 6;
                                        dVar.Y = dVar.Q;
                                        dVar.X = 0;
                                        dVar.f73033a = 12;
                                    }
                                }
                            } else {
                                int i312 = dVar.f73050r;
                                i16 = bArr[(i312 - 1) & i31] & 255;
                                i17 = bArr[(i312 - 2) & i31] & 255;
                                while (dVar.f73056x < dVar.f73057y) {
                                    a.j(aVar);
                                    if (dVar.f73046n[0] == 0) {
                                        f(dVar);
                                    }
                                    byte[] bArr4 = dVar.A;
                                    int i313 = dVar.B;
                                    int[] iArr11 = z20.a.f81729a;
                                    int i314 = bArr4[i313 + (iArr11[dVar.E + i17] | iArr11[dVar.D + i16])] & 255;
                                    int[] iArr12 = dVar.f73046n;
                                    iArr12[0] = iArr12[0] - 1;
                                    a.d(aVar);
                                    z20.d dVar4 = dVar.f73043k;
                                    iR = r(dVar4.f81735b, dVar4.f81736c[i314], aVar);
                                    i18 = dVar.f73050r;
                                    bArr[i18] = (byte) iR;
                                    dVar.f73056x++;
                                    dVar.f73050r = i18 + 1;
                                    if (i18 == i31) {
                                        dVar.f73034b = 6;
                                        dVar.Y = dVar.Q;
                                        dVar.X = 0;
                                        dVar.f73033a = 12;
                                    } else {
                                        int i315 = i16;
                                        i16 = iR;
                                        i17 = i315;
                                    }
                                }
                            }
                            if (dVar.f73033a != 6) {
                                continue;
                            } else {
                                i19 = dVar.f73039g - dVar.f73057y;
                                dVar.f73039g = i19;
                                if (i19 <= 0) {
                                    dVar.f73033a = 3;
                                } else {
                                    if (dVar.G < 0) {
                                        a.j(aVar);
                                        if (dVar.f73046n[2] == 0) {
                                            e(dVar);
                                        }
                                        int[] iArr13 = dVar.f73046n;
                                        iArr13[2] = iArr13[2] - 1;
                                        a.d(aVar);
                                        z20.d dVar5 = dVar.f73045m;
                                        int[] iArr14 = dVar5.f81735b;
                                        int[] iArr15 = dVar5.f81736c;
                                        byte[] bArr5 = dVar.H;
                                        int i47 = dVar.C;
                                        i24 = dVar.M;
                                        if (i24 > 4) {
                                            i25 = 3;
                                        } else {
                                            i25 = i24 - 2;
                                        }
                                        iR2 = r(iArr14, iArr15[bArr5[i47 + i25] & 255], aVar);
                                        dVar.G = iR2;
                                        i26 = dVar.I;
                                        if (iR2 >= i26) {
                                            int i48 = iR2 - i26;
                                            int i49 = dVar.J & i48;
                                            int i410 = i48 >>> dVar.K;
                                            dVar.G = i410;
                                            int i411 = (i410 >>> 1) + 1;
                                            dVar.G = i26 + i49 + ((((((i410 & 1) + 2) << i411) - 4) + a.i(aVar, i411)) << dVar.K);
                                        }
                                    }
                                    iT = t(dVar.G, dVar.f73049q, dVar.f73052t);
                                    dVar.L = iT;
                                    if (iT < 0) {
                                        throw new BrotliRuntimeException("Negative distance");
                                    }
                                    i21 = dVar.f73051s;
                                    i22 = dVar.O;
                                    if (i21 != i22) {
                                        dVar.f73051s = i22;
                                    } else {
                                        dVar.f73051s = i22;
                                    }
                                    dVar.N = dVar.f73050r;
                                    if (iT > dVar.f73051s) {
                                        dVar.f73033a = 9;
                                    } else {
                                        if (dVar.G > 0) {
                                            int[] iArr16 = dVar.f73049q;
                                            int i412 = dVar.f73052t;
                                            iArr16[i412 & 3] = iT;
                                            dVar.f73052t = i412 + 1;
                                        }
                                        if (dVar.M > dVar.f73039g) {
                                            throw new BrotliRuntimeException("Invalid backward reference");
                                        }
                                        dVar.f73056x = 0;
                                        dVar.f73033a = 7;
                                        int i413 = dVar.f73050r;
                                        i11 = (i413 - dVar.L) & i31;
                                        i12 = dVar.M - dVar.f73056x;
                                        if (i11 + i12 < i31) {
                                            while (true) {
                                                i13 = dVar.f73056x;
                                                if (i13 < dVar.M) {
                                                    i14 = dVar.f73050r;
                                                    bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                                    dVar.f73039g--;
                                                    dVar.f73056x = i13 + 1;
                                                    dVar.f73050r = i14 + 1;
                                                    if (i14 == i31) {
                                                        i15 = 7;
                                                        dVar.f73034b = 7;
                                                        dVar.Y = dVar.Q;
                                                        dVar.X = 0;
                                                        dVar.f73033a = 12;
                                                    }
                                                } else {
                                                    i15 = 7;
                                                }
                                            }
                                        } else {
                                            while (true) {
                                                i13 = dVar.f73056x;
                                                if (i13 < dVar.M) {
                                                    i14 = dVar.f73050r;
                                                    bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                                    dVar.f73039g--;
                                                    dVar.f73056x = i13 + 1;
                                                    dVar.f73050r = i14 + 1;
                                                    if (i14 == i31) {
                                                        i15 = 7;
                                                        dVar.f73034b = 7;
                                                        dVar.Y = dVar.Q;
                                                        dVar.X = 0;
                                                        dVar.f73033a = 12;
                                                    }
                                                } else {
                                                    i15 = 7;
                                                }
                                            }
                                        }
                                        if (dVar.f73033a == i15) {
                                            dVar.f73033a = 3;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        while (dVar.f73039g > 0) {
                            a.j(aVar);
                            a.i(aVar, 8);
                            dVar.f73039g--;
                        }
                        dVar.f73033a = 1;
                        break;
                    case 5:
                        a(dVar);
                        break;
                    case 6:
                        if (dVar.f73053u) {
                            while (dVar.f73056x < dVar.f73057y) {
                                a.j(aVar);
                                if (dVar.f73046n[0] == 0) {
                                    f(dVar);
                                }
                                int[] iArr17 = dVar.f73046n;
                                iArr17[0] = iArr17[0] - 1;
                                a.d(aVar);
                                bArr[dVar.f73050r] = (byte) r(dVar.f73043k.f81735b, dVar.f73055w, aVar);
                                dVar.f73056x++;
                                i27 = dVar.f73050r;
                                dVar.f73050r = i27 + 1;
                                if (i27 == i31) {
                                    dVar.f73034b = 6;
                                    dVar.Y = dVar.Q;
                                    dVar.X = 0;
                                    dVar.f73033a = 12;
                                }
                            }
                        } else {
                            int i316 = dVar.f73050r;
                            i16 = bArr[(i316 - 1) & i31] & 255;
                            i17 = bArr[(i316 - 2) & i31] & 255;
                            while (dVar.f73056x < dVar.f73057y) {
                                a.j(aVar);
                                if (dVar.f73046n[0] == 0) {
                                    f(dVar);
                                }
                                byte[] bArr6 = dVar.A;
                                int i317 = dVar.B;
                                int[] iArr18 = z20.a.f81729a;
                                int i318 = bArr6[i317 + (iArr18[dVar.E + i17] | iArr18[dVar.D + i16])] & 255;
                                int[] iArr19 = dVar.f73046n;
                                iArr19[0] = iArr19[0] - 1;
                                a.d(aVar);
                                z20.d dVar6 = dVar.f73043k;
                                iR = r(dVar6.f81735b, dVar6.f81736c[i318], aVar);
                                i18 = dVar.f73050r;
                                bArr[i18] = (byte) iR;
                                dVar.f73056x++;
                                dVar.f73050r = i18 + 1;
                                if (i18 == i31) {
                                    dVar.f73034b = 6;
                                    dVar.Y = dVar.Q;
                                    dVar.X = 0;
                                    dVar.f73033a = 12;
                                } else {
                                    int i319 = i16;
                                    i16 = iR;
                                    i17 = i319;
                                }
                            }
                        }
                        if (dVar.f73033a != 6) {
                            continue;
                        } else {
                            i19 = dVar.f73039g - dVar.f73057y;
                            dVar.f73039g = i19;
                            if (i19 <= 0) {
                                dVar.f73033a = 3;
                            } else {
                                if (dVar.G < 0) {
                                    a.j(aVar);
                                    if (dVar.f73046n[2] == 0) {
                                        e(dVar);
                                    }
                                    int[] iArr110 = dVar.f73046n;
                                    iArr110[2] = iArr110[2] - 1;
                                    a.d(aVar);
                                    z20.d dVar7 = dVar.f73045m;
                                    int[] iArr111 = dVar7.f81735b;
                                    int[] iArr112 = dVar7.f81736c;
                                    byte[] bArr7 = dVar.H;
                                    int i414 = dVar.C;
                                    i24 = dVar.M;
                                    if (i24 > 4) {
                                        i25 = 3;
                                    } else {
                                        i25 = i24 - 2;
                                    }
                                    iR2 = r(iArr111, iArr112[bArr7[i414 + i25] & 255], aVar);
                                    dVar.G = iR2;
                                    i26 = dVar.I;
                                    if (iR2 >= i26) {
                                        int i415 = iR2 - i26;
                                        int i416 = dVar.J & i415;
                                        int i417 = i415 >>> dVar.K;
                                        dVar.G = i417;
                                        int i418 = (i417 >>> 1) + 1;
                                        dVar.G = i26 + i416 + ((((((i417 & 1) + 2) << i418) - 4) + a.i(aVar, i418)) << dVar.K);
                                    }
                                }
                                iT = t(dVar.G, dVar.f73049q, dVar.f73052t);
                                dVar.L = iT;
                                if (iT < 0) {
                                    throw new BrotliRuntimeException("Negative distance");
                                }
                                i21 = dVar.f73051s;
                                i22 = dVar.O;
                                if (i21 != i22) {
                                    dVar.f73051s = i22;
                                } else {
                                    dVar.f73051s = i22;
                                }
                                dVar.N = dVar.f73050r;
                                if (iT > dVar.f73051s) {
                                    dVar.f73033a = 9;
                                } else {
                                    if (dVar.G > 0) {
                                        int[] iArr113 = dVar.f73049q;
                                        int i419 = dVar.f73052t;
                                        iArr113[i419 & 3] = iT;
                                        dVar.f73052t = i419 + 1;
                                    }
                                    if (dVar.M > dVar.f73039g) {
                                        throw new BrotliRuntimeException("Invalid backward reference");
                                    }
                                    dVar.f73056x = 0;
                                    dVar.f73033a = 7;
                                    int i4110 = dVar.f73050r;
                                    i11 = (i4110 - dVar.L) & i31;
                                    i12 = dVar.M - dVar.f73056x;
                                    if (i11 + i12 < i31) {
                                        while (true) {
                                            i13 = dVar.f73056x;
                                            if (i13 < dVar.M) {
                                                i14 = dVar.f73050r;
                                                bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                                dVar.f73039g--;
                                                dVar.f73056x = i13 + 1;
                                                dVar.f73050r = i14 + 1;
                                                if (i14 == i31) {
                                                    i15 = 7;
                                                    dVar.f73034b = 7;
                                                    dVar.Y = dVar.Q;
                                                    dVar.X = 0;
                                                    dVar.f73033a = 12;
                                                }
                                            } else {
                                                i15 = 7;
                                            }
                                        }
                                    } else {
                                        while (true) {
                                            i13 = dVar.f73056x;
                                            if (i13 < dVar.M) {
                                                i14 = dVar.f73050r;
                                                bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                                dVar.f73039g--;
                                                dVar.f73056x = i13 + 1;
                                                dVar.f73050r = i14 + 1;
                                                if (i14 == i31) {
                                                    i15 = 7;
                                                    dVar.f73034b = 7;
                                                    dVar.Y = dVar.Q;
                                                    dVar.X = 0;
                                                    dVar.f73033a = 12;
                                                }
                                            } else {
                                                i15 = 7;
                                            }
                                        }
                                    }
                                    if (dVar.f73033a == i15) {
                                        dVar.f73033a = 3;
                                    }
                                }
                            }
                        }
                        break;
                    case 7:
                        int i4111 = dVar.f73050r;
                        i11 = (i4111 - dVar.L) & i31;
                        i12 = dVar.M - dVar.f73056x;
                        if (i11 + i12 < i31) {
                            while (true) {
                                i13 = dVar.f73056x;
                                if (i13 < dVar.M) {
                                    i14 = dVar.f73050r;
                                    bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                    dVar.f73039g--;
                                    dVar.f73056x = i13 + 1;
                                    dVar.f73050r = i14 + 1;
                                    if (i14 == i31) {
                                        i15 = 7;
                                        dVar.f73034b = 7;
                                        dVar.Y = dVar.Q;
                                        dVar.X = 0;
                                        dVar.f73033a = 12;
                                    }
                                } else {
                                    i15 = 7;
                                }
                            }
                        } else {
                            while (true) {
                                i13 = dVar.f73056x;
                                if (i13 < dVar.M) {
                                    i14 = dVar.f73050r;
                                    bArr[i14] = bArr[(i14 - dVar.L) & i31];
                                    dVar.f73039g--;
                                    dVar.f73056x = i13 + 1;
                                    dVar.f73050r = i14 + 1;
                                    if (i14 == i31) {
                                        i15 = 7;
                                        dVar.f73034b = 7;
                                        dVar.Y = dVar.Q;
                                        dVar.X = 0;
                                        dVar.f73033a = 12;
                                    }
                                } else {
                                    i15 = 7;
                                }
                            }
                        }
                        if (dVar.f73033a == i15) {
                            dVar.f73033a = 3;
                        }
                        break;
                    case 8:
                        int i50 = dVar.Q;
                        System.arraycopy(bArr, i50, bArr, 0, dVar.N - i50);
                        dVar.f73033a = 3;
                        break;
                    case 9:
                        int i51 = dVar.M;
                        if (i51 < 4 || i51 > 24) {
                            throw new BrotliRuntimeException("Invalid backward reference");
                        }
                        int i52 = z20.b.f81731a[i51];
                        int i53 = (dVar.L - dVar.f73051s) - 1;
                        int i54 = z20.b.f81732b[i51];
                        int i55 = ((1 << i54) - 1) & i53;
                        int i56 = i53 >>> i54;
                        int i57 = i52 + (i55 * i51);
                        g[] gVarArr = g.f81747d;
                        if (i56 >= gVarArr.length) {
                            throw new BrotliRuntimeException("Invalid backward reference");
                        }
                        int iB = g.b(bArr, dVar.N, z20.b.a(), i57, dVar.M, gVarArr[i56]);
                        int i58 = dVar.N + iB;
                        dVar.N = i58;
                        dVar.f73050r += iB;
                        dVar.f73039g -= iB;
                        int i59 = dVar.Q;
                        if (i58 < i59) {
                            dVar.f73033a = 3;
                        } else {
                            dVar.f73034b = 8;
                            dVar.Y = i59;
                            dVar.X = 0;
                            dVar.f73033a = 12;
                        }
                        break;
                        break;
                    default:
                        throw new BrotliRuntimeException("Unexpected state " + dVar.f73033a);
                }
            } else {
                if (!u(dVar)) {
                    return;
                }
                int i60 = dVar.f73050r;
                int i61 = dVar.O;
                if (i60 >= i61) {
                    dVar.f73051s = i61;
                }
                dVar.f73050r = i60 & i31;
                dVar.f73033a = dVar.f73034b;
            }
        }
    }

    public static void j(byte[] bArr, int i11) {
        int[] iArr = new int[256];
        for (int i12 = 0; i12 < 256; i12++) {
            iArr[i12] = i12;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = bArr[i13] & 255;
            bArr[i13] = (byte) iArr[i14];
            if (i14 != 0) {
                l(iArr, i14);
            }
        }
    }

    public static void k(d dVar) {
        int i11;
        int i12 = dVar.P;
        long j11 = i12;
        long j12 = dVar.R;
        if (j11 > j12) {
            while (true) {
                int i13 = i12 >> 1;
                if (i13 <= ((int) j12) + dVar.S.length) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            if (!dVar.f73040h && i12 < 16384 && dVar.P >= 16384) {
                i12 = 16384;
            }
        }
        int i14 = dVar.Q;
        if (i12 <= i14) {
            return;
        }
        byte[] bArr = new byte[i12 + 37];
        byte[] bArr2 = dVar.f73036d;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, i14);
        } else {
            byte[] bArr3 = dVar.S;
            if (bArr3.length != 0) {
                int length = bArr3.length;
                int i15 = dVar.O;
                if (length > i15) {
                    i11 = length - i15;
                } else {
                    i15 = length;
                    i11 = 0;
                }
                System.arraycopy(bArr3, i11, bArr, 0, i15);
                dVar.f73050r = i15;
                dVar.T = i15;
            }
        }
        dVar.f73036d = bArr;
        dVar.Q = i12;
    }

    public static void l(int[] iArr, int i11) {
        int i12 = iArr[i11];
        while (i11 > 0) {
            iArr[i11] = iArr[i11 - 1];
            i11--;
        }
        iArr[0] = i12;
    }

    public static int m(int[] iArr, int i11, a aVar) {
        a.d(aVar);
        int iR = r(iArr, i11, aVar);
        return f.f81739a[iR] + a.i(aVar, f.f81740b[iR]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
    
        if (r4 != r3) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bd, code lost:
    
        if (r8 != false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i11, int[] iArr, int i12, a aVar) {
        boolean z11;
        boolean z12;
        int i13;
        int i14;
        a.j(aVar);
        int[] iArr2 = new int[i11];
        int i15 = a.i(aVar, 2);
        if (i15 == 1) {
            int i16 = i11 - 1;
            int[] iArr3 = new int[4];
            int i17 = a.i(aVar, 2) + 1;
            int i18 = 0;
            while (i16 != 0) {
                i16 >>= 1;
                i18++;
            }
            for (int i19 = 0; i19 < i17; i19++) {
                int i21 = a.i(aVar, i18) % i11;
                iArr3[i19] = i21;
                iArr2[i21] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i17 != 1) {
                if (i17 == 2) {
                    int i22 = iArr3[0];
                    int i23 = iArr3[1];
                    z11 = i22 != i23;
                    iArr2[i23] = 1;
                } else {
                    if (i17 == 3) {
                        int i24 = iArr3[0];
                        int i25 = iArr3[1];
                        if (i24 != i25) {
                            int i26 = iArr3[2];
                            if (i24 != i26) {
                            }
                        }
                        throw new BrotliRuntimeException("Can't readHuffmanCode");
                    }
                    int i27 = iArr3[0];
                    int i28 = iArr3[1];
                    z12 = (i27 == i28 || i27 == (i13 = iArr3[2]) || i27 == (i14 = iArr3[3]) || i28 == i13 || i28 == i14 || i13 == i14) ? false : true;
                    if (a.i(aVar, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                }
            }
            z20.c.a(iArr, i12, 8, iArr2, i11);
            return;
        }
        int[] iArr4 = new int[18];
        int i29 = 32;
        int i31 = 0;
        while (i15 < 18 && i29 > 0) {
            int i32 = f73029a[i15];
            a.d(aVar);
            long j11 = aVar.f73021f;
            int i33 = aVar.f73022g;
            int i34 = f73032d[((int) (j11 >>> i33)) & 15];
            aVar.f73022g = i33 + (i34 >> 16);
            int i35 = i34 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            iArr4[i32] = i35;
            if (i35 != 0) {
                i29 -= 32 >> i35;
                i31++;
            }
            i15++;
        }
        z11 = i31 == 1 || i29 == 0;
        o(iArr4, i11, iArr2, aVar);
        z12 = z11;
    }

    public static void o(int[] iArr, int i11, int[] iArr2, a aVar) {
        int i12;
        int[] iArr3 = new int[32];
        z20.c.a(iArr3, 0, 5, iArr, 18);
        int i13 = 8;
        int i14 = 0;
        int i15 = 32768;
        int i16 = 0;
        loop0: while (true) {
            int i17 = 0;
            while (true) {
                if (i14 >= i11 || i15 <= 0) {
                    break loop0;
                }
                a.j(aVar);
                a.d(aVar);
                long j11 = aVar.f73021f;
                int i18 = aVar.f73022g;
                int i19 = iArr3[((int) (j11 >>> i18)) & 31];
                aVar.f73022g = i18 + (i19 >> 16);
                i12 = i19 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                if (i12 < 16) {
                    break;
                }
                int i21 = i12 - 14;
                int i22 = i12 == 16 ? i13 : 0;
                if (i16 != i22) {
                    i16 = i22;
                    i17 = 0;
                }
                int i23 = (i17 > 0 ? (i17 - 2) << i21 : i17) + a.i(aVar, i21) + 3;
                int i24 = i23 - i17;
                if (i14 + i24 > i11) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i25 = 0;
                while (i25 < i24) {
                    iArr2[i14] = i16;
                    i25++;
                    i14++;
                }
                if (i16 != 0) {
                    i15 -= i24 << (15 - i16);
                }
                i17 = i23;
            }
            i14++;
            iArr2[i14] = i12;
            if (i12 != 0) {
                i15 -= 32768 >> i12;
                i13 = i12;
            }
        }
        if (i15 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        h.b(iArr2, i14, i11 - i14);
    }

    public static void p(d dVar) {
        int i11;
        int[] iArr;
        a aVar = dVar.f73035c;
        for (int i12 = 0; i12 < 3; i12++) {
            dVar.f73047o[i12] = h(aVar) + 1;
            dVar.f73046n[i12] = 268435456;
            int i13 = dVar.f73047o[i12];
            if (i13 > 1) {
                int i14 = i12 * 1080;
                n(i13 + 2, dVar.f73037e, i14, aVar);
                n(26, dVar.f73038f, i14, aVar);
                dVar.f73046n[i12] = m(dVar.f73038f, i14, aVar);
            }
        }
        a.j(aVar);
        dVar.K = a.i(aVar, 2);
        int i15 = a.i(aVar, 4);
        int i16 = dVar.K;
        int i17 = (i15 << i16) + 16;
        dVar.I = i17;
        dVar.J = (1 << i16) - 1;
        int i18 = i17 + (48 << i16);
        dVar.f73058z = new byte[dVar.f73047o[0]];
        int i19 = 0;
        while (true) {
            i11 = dVar.f73047o[0];
            if (i19 >= i11) {
                break;
            }
            int iMin = Math.min(i19 + 96, i11);
            while (i19 < iMin) {
                dVar.f73058z[i19] = (byte) (a.i(aVar, 2) << 1);
                i19++;
            }
            a.j(aVar);
        }
        byte[] bArr = new byte[i11 << 6];
        dVar.A = bArr;
        int iD = d(i11 << 6, bArr, aVar);
        dVar.f73053u = true;
        int i21 = 0;
        while (true) {
            iArr = dVar.f73047o;
            if (i21 >= (iArr[0] << 6)) {
                break;
            }
            if (dVar.A[i21] != (i21 >> 6)) {
                dVar.f73053u = false;
                break;
            }
            i21++;
        }
        int i22 = iArr[2];
        byte[] bArr2 = new byte[i22 << 2];
        dVar.H = bArr2;
        int iD2 = d(i22 << 2, bArr2, aVar);
        z20.d.b(dVar.f73043k, 256, iD);
        z20.d.b(dVar.f73044l, 704, dVar.f73047o[1]);
        z20.d.b(dVar.f73045m, i18, iD2);
        z20.d.a(dVar.f73043k, aVar);
        z20.d.a(dVar.f73044l, aVar);
        z20.d.a(dVar.f73045m, aVar);
        dVar.B = 0;
        dVar.C = 0;
        int[] iArr2 = z20.a.f81730b;
        byte b11 = dVar.f73058z[0];
        dVar.D = iArr2[b11];
        dVar.E = iArr2[b11 + 1];
        dVar.f73054v = 0;
        dVar.f73055w = dVar.f73043k.f81736c[0];
        dVar.F = dVar.f73044l.f81736c[0];
        int[] iArr3 = dVar.f73048p;
        iArr3[4] = 1;
        iArr3[2] = 1;
        iArr3[0] = 1;
        iArr3[5] = 0;
        iArr3[3] = 0;
        iArr3[1] = 0;
    }

    public static void q(d dVar) {
        a aVar = dVar.f73035c;
        if (dVar.f73040h) {
            dVar.f73034b = 10;
            dVar.Y = dVar.f73050r;
            dVar.X = 0;
            dVar.f73033a = 12;
            return;
        }
        z20.d dVar2 = dVar.f73043k;
        dVar2.f81735b = null;
        dVar2.f81736c = null;
        z20.d dVar3 = dVar.f73044l;
        dVar3.f81735b = null;
        dVar3.f81736c = null;
        z20.d dVar4 = dVar.f73045m;
        dVar4.f81735b = null;
        dVar4.f81736c = null;
        a.j(aVar);
        g(aVar, dVar);
        if (dVar.f73039g != 0 || dVar.f73042j) {
            if (dVar.f73041i || dVar.f73042j) {
                a.g(aVar);
                dVar.f73033a = dVar.f73042j ? 4 : 5;
            } else {
                dVar.f73033a = 2;
            }
            if (dVar.f73042j) {
                return;
            }
            dVar.R += (long) dVar.f73039g;
            if (dVar.Q < dVar.P) {
                k(dVar);
            }
        }
    }

    public static int r(int[] iArr, int i11, a aVar) {
        long j11 = aVar.f73021f;
        int i12 = aVar.f73022g;
        int i13 = (int) (j11 >>> i12);
        int i14 = i11 + (i13 & 255);
        int i15 = iArr[i14];
        int i16 = i15 >> 16;
        int i17 = i15 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i16 <= 8) {
            aVar.f73022g = i12 + i16;
            return i17;
        }
        int i18 = iArr[i14 + i17 + ((i13 & ((1 << i16) - 1)) >>> 8)];
        aVar.f73022g = i12 + (i18 >> 16) + 8;
        return i18 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public static void s(d dVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        dVar.S = bArr;
    }

    public static int t(int i11, int[] iArr, int i12) {
        return i11 < 16 ? iArr[(i12 + f73030b[i11]) & 3] + f73031c[i11] : i11 - 15;
    }

    public static boolean u(d dVar) {
        int i11 = dVar.T;
        if (i11 != 0) {
            dVar.X += i11;
            dVar.T = 0;
        }
        int iMin = Math.min(dVar.V - dVar.W, dVar.Y - dVar.X);
        if (iMin != 0) {
            System.arraycopy(dVar.f73036d, dVar.X, dVar.Z, dVar.U + dVar.W, iMin);
            dVar.W += iMin;
            dVar.X += iMin;
        }
        return dVar.W < dVar.V;
    }
}
