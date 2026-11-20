package com.alibaba.fastjson.util;

import okhttp3.internal.http2.Http2Connection;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f15598a = {new int[]{ASTNode.DISCARD, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, ASTNode.DEOP}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f15599b = {new int[]{ASTNode.DEOP, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static int a(float f11, char[] cArr, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11;
        int i16;
        boolean z12;
        int i17;
        int i18;
        boolean z13;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        if (!Float.isNaN(f11)) {
            if (f11 == Float.POSITIVE_INFINITY) {
                cArr[i11] = 'I';
                cArr[i11 + 1] = 'n';
                cArr[i11 + 2] = 'f';
                cArr[i11 + 3] = 'i';
                cArr[i11 + 4] = 'n';
                cArr[i11 + 5] = 'i';
                cArr[i11 + 6] = 't';
                i23 = i11 + 8;
                cArr[i11 + 7] = 'y';
            } else if (f11 == Float.NEGATIVE_INFINITY) {
                cArr[i11] = '-';
                cArr[i11 + 1] = 'I';
                cArr[i11 + 2] = 'n';
                cArr[i11 + 3] = 'f';
                cArr[i11 + 4] = 'i';
                cArr[i11 + 5] = 'n';
                cArr[i11 + 6] = 'i';
                cArr[i11 + 7] = 't';
                i24 = i11 + 9;
                cArr[i11 + 8] = 'y';
            } else {
                int iFloatToIntBits = Float.floatToIntBits(f11);
                if (iFloatToIntBits == 0) {
                    cArr[i11] = '0';
                    cArr[i11 + 1] = '.';
                    i24 = i11 + 3;
                    cArr[i11 + 2] = '0';
                } else {
                    if (iFloatToIntBits != Integer.MIN_VALUE) {
                        int i25 = (iFloatToIntBits >> 23) & 255;
                        int i26 = 8388607 & iFloatToIntBits;
                        if (i25 == 0) {
                            i12 = -149;
                        } else {
                            i12 = i25 - 150;
                            i26 |= 8388608;
                        }
                        boolean z14 = iFloatToIntBits < 0;
                        boolean z15 = (i26 & 1) == 0;
                        int i27 = i26 * 4;
                        int i28 = i27 + 2;
                        int i29 = i27 - ((((long) i26) != 8388608 || i25 <= 1) ? 2 : 1);
                        int i31 = i12 - 2;
                        if (i31 >= 0) {
                            i18 = (int) ((((long) i31) * 3010299) / 10000000);
                            int i32 = i18 == 0 ? 1 : (int) (((((long) i18) * 23219280) + 9999999) / 10000000);
                            int i33 = (-i31) + i18;
                            int[][] iArr = f15599b;
                            int[] iArr2 = iArr[i18];
                            long j11 = iArr2[0];
                            long j12 = iArr2[1];
                            long j13 = i27;
                            int i34 = ((i32 + 58) + i33) - 31;
                            int i35 = i27;
                            i13 = (int) (((j13 * j11) + ((j13 * j12) >> 31)) >> i34);
                            long j14 = i28;
                            i16 = (int) (((j14 * j11) + ((j14 * j12) >> 31)) >> i34);
                            long j15 = i29;
                            i17 = (int) (((j11 * j15) + ((j15 * j12) >> 31)) >> i34);
                            if (i18 == 0 || (i16 - 1) / 10 > i17 / 10) {
                                i15 = 0;
                            } else {
                                int i36 = i18 - 1;
                                int i37 = (i33 - 1) + (i36 == 0 ? 1 : (int) (((((long) i36) * 23219280) + 9999999) / 10000000)) + 58;
                                int[] iArr3 = iArr[i36];
                                i15 = (int) ((((j13 * ((long) iArr3[0])) + ((((long) iArr3[1]) * j13) >> 31)) >> (i37 - 31)) % 10);
                            }
                            int i38 = 0;
                            while (i28 > 0 && i28 % 5 == 0) {
                                i28 /= 5;
                                i38++;
                            }
                            int i39 = 0;
                            while (i35 > 0 && i35 % 5 == 0) {
                                i35 /= 5;
                                i39++;
                            }
                            int i40 = 0;
                            while (i29 > 0 && i29 % 5 == 0) {
                                i29 /= 5;
                                i40++;
                            }
                            z11 = i38 >= i18;
                            z13 = i39 >= i18;
                            z12 = i40 >= i18;
                            i14 = 0;
                        } else {
                            int i41 = -i31;
                            int i42 = (int) ((((long) i41) * 6989700) / 10000000);
                            int i43 = i41 - i42;
                            int i44 = i43 == 0 ? 1 : (int) (((((long) i43) * 23219280) + 9999999) / 10000000);
                            int[][] iArr4 = f15598a;
                            int[] iArr5 = iArr4[i43];
                            long j16 = iArr5[0];
                            long j17 = iArr5[1];
                            int i45 = (i42 - (i44 - 61)) - 31;
                            long j18 = i27;
                            i13 = (int) (((j18 * j16) + ((j18 * j17) >> 31)) >> i45);
                            long j19 = i28;
                            int i46 = (int) (((j19 * j16) + ((j19 * j17) >> 31)) >> i45);
                            long j21 = i29;
                            int i47 = (int) (((j16 * j21) + ((j21 * j17) >> 31)) >> i45);
                            if (i42 == 0 || (i46 - 1) / 10 > i47 / 10) {
                                i14 = 0;
                                i15 = 0;
                            } else {
                                int i48 = i43 + 1;
                                int i49 = (i42 - 1) - ((i48 == 0 ? 1 : (int) (((((long) i48) * 23219280) + 9999999) / 10000000)) - 61);
                                int[] iArr6 = iArr4[i48];
                                i14 = 0;
                                i15 = (int) ((((j18 * ((long) iArr6[0])) + ((((long) iArr6[1]) * j18) >> 31)) >> (i49 - 31)) % 10);
                            }
                            int i50 = i31 + i42;
                            boolean z16 = 1 >= i42;
                            boolean z17 = i42 < 23 && (i27 & ((1 << (i42 + (-1))) - 1)) == 0;
                            boolean z18 = (i29 % 2 == 1 ? 0 : 1) >= i42;
                            z11 = z16;
                            i16 = i46;
                            boolean z19 = z17;
                            z12 = z18;
                            i17 = i47;
                            i18 = i50;
                            z13 = z19;
                        }
                        int i51 = Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
                        int i52 = 10;
                        while (i52 > 0 && i16 < i51) {
                            i51 /= 10;
                            i52--;
                        }
                        int i53 = i18 + i52;
                        int i54 = i53 - 1;
                        boolean z21 = i54 < -3 || i54 >= 7;
                        if (z11 && !z15) {
                            i16--;
                        }
                        int i55 = 0;
                        while (true) {
                            int i56 = i16 / 10;
                            int i57 = i17 / 10;
                            if (i56 <= i57 || (i16 < 100 && z21)) {
                                break;
                            }
                            z12 &= i17 % 10 == 0;
                            i15 = i13 % 10;
                            i13 /= 10;
                            i55++;
                            i16 = i56;
                            i17 = i57;
                        }
                        if (z12 && z15 != 0) {
                            while (i17 % 10 == 0 && (i16 >= 100 || !z21)) {
                                i16 /= 10;
                                i15 = i13 % 10;
                                i13 /= 10;
                                i17 /= 10;
                                i55++;
                            }
                        }
                        int i58 = i13;
                        if (z13 && i15 == 5 && i58 % 2 == 0) {
                            i15 = 4;
                        }
                        int i59 = i58 + (((i58 != i17 || (z12 && z15 != 0)) && i15 < 5) ? 0 : 1);
                        int i60 = i52 - i55;
                        if (z14) {
                            i19 = i11 + 1;
                            cArr[i11] = '-';
                        } else {
                            i19 = i11;
                        }
                        if (z21) {
                            while (i14 < i60 - 1) {
                                int i61 = i59 % 10;
                                i59 /= 10;
                                cArr[(i19 + i60) - i14] = (char) (i61 + 48);
                                i14++;
                            }
                            cArr[i19] = (char) ((i59 % 10) + 48);
                            cArr[i19 + 1] = '.';
                            int i62 = i19 + i60 + 1;
                            if (i60 == 1) {
                                cArr[i62] = '0';
                                i62++;
                            }
                            int i63 = i62 + 1;
                            cArr[i62] = 'E';
                            if (i54 < 0) {
                                cArr[i63] = '-';
                                i54 = -i54;
                                i63 = i62 + 2;
                            }
                            if (i54 >= 10) {
                                i22 = 48;
                                cArr[i63] = (char) ((i54 / 10) + 48);
                                i63++;
                            } else {
                                i22 = 48;
                            }
                            i21 = i63 + 1;
                            cArr[i63] = (char) ((i54 % 10) + i22);
                        } else if (i54 < 0) {
                            int i64 = i19 + 1;
                            cArr[i19] = '0';
                            int i65 = i19 + 2;
                            cArr[i64] = '.';
                            int i66 = -1;
                            while (i66 > i54) {
                                cArr[i65] = '0';
                                i66--;
                                i65++;
                            }
                            int i67 = i65;
                            while (i14 < i60) {
                                cArr[((i65 + i60) - i14) - 1] = (char) ((i59 % 10) + 48);
                                i59 /= 10;
                                i67++;
                                i14++;
                            }
                            i21 = i67;
                        } else if (i53 >= i60) {
                            while (i14 < i60) {
                                cArr[((i19 + i60) - i14) - 1] = (char) ((i59 % 10) + 48);
                                i59 /= 10;
                                i14++;
                            }
                            int i68 = i19 + i60;
                            while (i60 < i53) {
                                cArr[i68] = '0';
                                i60++;
                                i68++;
                            }
                            int i69 = i68 + 1;
                            cArr[i68] = '.';
                            i21 = i68 + 2;
                            cArr[i69] = '0';
                        } else {
                            int i70 = i19 + 1;
                            while (i14 < i60) {
                                if ((i60 - i14) - 1 == i54) {
                                    cArr[((i70 + i60) - i14) - 1] = '.';
                                    i70--;
                                }
                                cArr[((i70 + i60) - i14) - 1] = (char) ((i59 % 10) + 48);
                                i59 /= 10;
                                i14++;
                            }
                            i21 = i19 + i60 + 1;
                        }
                        return i21 - i11;
                    }
                    cArr[i11] = '-';
                    cArr[i11 + 1] = '0';
                    cArr[i11 + 2] = '.';
                    i23 = i11 + 4;
                    cArr[i11 + 3] = '0';
                }
            }
            return i23 - i11;
        }
        cArr[i11] = 'N';
        cArr[i11 + 1] = 'a';
        i24 = i11 + 3;
        cArr[i11 + 2] = 'N';
        return i24 - i11;
    }

    public static String b(float f11) {
        char[] cArr = new char[15];
        return new String(cArr, 0, a(f11, cArr, 0));
    }
}
