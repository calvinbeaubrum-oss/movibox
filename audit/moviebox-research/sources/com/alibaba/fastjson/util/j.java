package com.alibaba.fastjson.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Array;
import java.math.BigInteger;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f15596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f15597b;

    static {
        Class cls = Integer.TYPE;
        f15596a = (int[][]) Array.newInstance((Class<?>) cls, 326, 4);
        f15597b = (int[][]) Array.newInstance((Class<?>) cls, 291, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger bigIntegerSubtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i11 = 0;
        while (i11 < 326) {
            BigInteger bigIntegerPow = BigInteger.valueOf(5L).pow(i11);
            int iBitLength = bigIntegerPow.bitLength();
            int i12 = i11 == 0 ? 1 : (int) (((((long) i11) * 23219280) + 9999999) / 10000000);
            if (i12 != iBitLength) {
                throw new IllegalStateException(iBitLength + " != " + i12);
            }
            if (i11 < f15596a.length) {
                for (int i13 = 0; i13 < 4; i13++) {
                    f15596a[i11][i13] = bigIntegerPow.shiftRight((iBitLength - 121) + ((3 - i13) * 31)).and(bigIntegerSubtract).intValue();
                }
            }
            if (i11 < f15597b.length) {
                BigInteger bigInteger2 = BigInteger.ONE;
                BigInteger bigIntegerAdd = bigInteger2.shiftLeft(iBitLength + 121).divide(bigIntegerPow).add(bigInteger2);
                for (int i14 = 0; i14 < 4; i14++) {
                    if (i14 == 0) {
                        f15597b[i11][i14] = bigIntegerAdd.shiftRight((3 - i14) * 31).intValue();
                    } else {
                        f15597b[i11][i14] = bigIntegerAdd.shiftRight((3 - i14) * 31).and(bigIntegerSubtract2).intValue();
                    }
                }
            }
            i11++;
        }
    }

    public static int a(double d11, char[] cArr, int i11) {
        int i12;
        boolean z11;
        long j11;
        long j12;
        boolean z12;
        boolean z13;
        int i13;
        long j13;
        long j14;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z14;
        boolean z15;
        int i19;
        int i21;
        int i22;
        int i23;
        if (!Double.isNaN(d11)) {
            if (d11 == Double.POSITIVE_INFINITY) {
                cArr[i11] = 'I';
                cArr[i11 + 1] = 'n';
                cArr[i11 + 2] = 'f';
                cArr[i11 + 3] = 'i';
                cArr[i11 + 4] = 'n';
                cArr[i11 + 5] = 'i';
                cArr[i11 + 6] = 't';
                i18 = i11 + 8;
                cArr[i11 + 7] = 'y';
            } else if (d11 == Double.NEGATIVE_INFINITY) {
                cArr[i11] = '-';
                cArr[i11 + 1] = 'I';
                cArr[i11 + 2] = 'n';
                cArr[i11 + 3] = 'f';
                cArr[i11 + 4] = 'i';
                cArr[i11 + 5] = 'n';
                cArr[i11 + 6] = 'i';
                cArr[i11 + 7] = 't';
                i23 = i11 + 9;
                cArr[i11 + 8] = 'y';
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(d11);
                if (jDoubleToLongBits == 0) {
                    cArr[i11] = '0';
                    cArr[i11 + 1] = '.';
                    i23 = i11 + 3;
                    cArr[i11 + 2] = '0';
                } else if (jDoubleToLongBits == Long.MIN_VALUE) {
                    cArr[i11] = '-';
                    cArr[i11 + 1] = '0';
                    cArr[i11 + 2] = '.';
                    i18 = i11 + 4;
                    cArr[i11 + 3] = '0';
                } else {
                    int i24 = (int) ((jDoubleToLongBits >>> 52) & 2047);
                    long j15 = jDoubleToLongBits & 4503599627370495L;
                    if (i24 == 0) {
                        i12 = -1074;
                    } else {
                        i12 = i24 - 1075;
                        j15 |= 4503599627370496L;
                    }
                    boolean z16 = jDoubleToLongBits < 0;
                    boolean z17 = (j15 & 1) == 0;
                    long j16 = 4 * j15;
                    long j17 = j16 + 2;
                    int i25 = (j15 != 4503599627370496L || i24 <= 1) ? 1 : 0;
                    long j18 = (j16 - 1) - ((long) i25);
                    int i26 = i12 - 2;
                    int i27 = 3;
                    if (i26 >= 0) {
                        int iMax = Math.max(0, ((int) ((((long) i26) * 3010299) / 10000000)) - 1);
                        int i28 = (((-i26) + iMax) + ((iMax == 0 ? 1 : (int) (((((long) iMax) * 23219280) + 9999999) / 10000000)) + 121)) - 114;
                        if (i28 < 0) {
                            throw new IllegalArgumentException("" + i28);
                        }
                        int[] iArr = f15597b[iMax];
                        long j19 = j16 >>> 31;
                        long j21 = j16 & 2147483647L;
                        int i29 = iArr[0];
                        int i31 = iArr[1];
                        int i32 = iArr[2];
                        z11 = z17;
                        int i33 = iArr[3];
                        long j22 = ((((((((((((j21 * ((long) i33)) >>> 31) + (((long) i32) * j21)) + (((long) i33) * j19)) >>> 31) + (((long) i31) * j21)) + (((long) i32) * j19)) >>> 31) + (((long) i29) * j21)) + (((long) i31) * j19)) >>> 21) + ((((long) i29) * j19) << 10)) >>> i28;
                        long j23 = j17 >>> 31;
                        long j24 = j17 & 2147483647L;
                        long j25 = ((((((((((((j24 * ((long) i33)) >>> 31) + (((long) i32) * j24)) + (j23 * ((long) i33))) >>> 31) + (((long) i31) * j24)) + (((long) i32) * j23)) >>> 31) + (((long) i29) * j24)) + (((long) i31) * j23)) >>> 21) + ((((long) i29) * j23) << 10)) >>> i28;
                        long j26 = j18 >>> 31;
                        long j27 = j18 & 2147483647L;
                        j12 = j25;
                        long j28 = ((((((((((((j27 * ((long) i33)) >>> 31) + (((long) i32) * j27)) + (j26 * ((long) i33))) >>> 31) + (((long) i31) * j27)) + (((long) i32) * j26)) >>> 31) + (((long) i29) * j27)) + (((long) i31) * j26)) >>> 21) + ((((long) i29) * j26) << 10)) >>> i28;
                        if (iMax <= 21) {
                            long j29 = j16 % 5;
                            if (j29 == 0) {
                                if (j29 != 0) {
                                    i22 = 0;
                                } else if (j16 % 25 != 0) {
                                    i22 = 1;
                                } else if (j16 % 125 != 0) {
                                    i22 = 2;
                                } else if (j16 % 625 != 0) {
                                    i22 = 3;
                                } else {
                                    long j31 = j16 / 625;
                                    int i34 = 4;
                                    for (long j32 = 0; j31 > j32 && j31 % 5 == j32; j32 = 0) {
                                        j31 /= 5;
                                        i34++;
                                    }
                                    i22 = i34;
                                }
                                z15 = i22 >= iMax;
                                z14 = false;
                            } else {
                                if (z11) {
                                    if (j18 % 5 != 0) {
                                        i21 = 0;
                                    } else if (j18 % 25 != 0) {
                                        i21 = 1;
                                    } else if (j18 % 125 != 0) {
                                        i21 = 2;
                                    } else if (j18 % 625 != 0) {
                                        i21 = 3;
                                    } else {
                                        long j33 = j18 / 625;
                                        int i35 = 4;
                                        for (long j34 = 0; j33 > j34 && j33 % 5 == j34; j34 = 0) {
                                            j33 /= 5;
                                            i35++;
                                        }
                                        i21 = i35;
                                    }
                                    z14 = i21 >= iMax;
                                } else {
                                    if (j17 % 5 != 0) {
                                        i19 = 0;
                                    } else if (j17 % 25 != 0) {
                                        i19 = 1;
                                    } else if (j17 % 125 != 0) {
                                        i19 = 2;
                                    } else if (j17 % 625 != 0) {
                                        i19 = 3;
                                    } else {
                                        long j35 = j17 / 625;
                                        int i36 = 4;
                                        for (long j36 = 0; j35 > j36 && j35 % 5 == j36; j36 = 0) {
                                            j35 /= 5;
                                            i36++;
                                        }
                                        i19 = i36;
                                    }
                                    if (i19 >= iMax) {
                                        j12--;
                                    }
                                    z14 = false;
                                }
                                z15 = false;
                            }
                        } else {
                            z14 = false;
                            z15 = false;
                        }
                        j11 = j22;
                        boolean z18 = z15;
                        z13 = z14;
                        j13 = j28;
                        i13 = iMax;
                        z12 = z18;
                    } else {
                        z11 = z17;
                        int i37 = -i26;
                        int iMax2 = Math.max(0, ((int) ((((long) i37) * 6989700) / 10000000)) - 1);
                        int i38 = i37 - iMax2;
                        int i39 = (iMax2 - ((i38 == 0 ? 1 : (int) (((((long) i38) * 23219280) + 9999999) / 10000000)) - 121)) - 114;
                        if (i39 < 0) {
                            throw new IllegalArgumentException("" + i39);
                        }
                        int[] iArr2 = f15596a[i38];
                        long j37 = j16 >>> 31;
                        long j38 = j16 & 2147483647L;
                        int i40 = iArr2[0];
                        int i41 = iArr2[1];
                        int i42 = i25;
                        int i43 = iArr2[2];
                        int i44 = iArr2[3];
                        long j39 = ((((((((((((j38 * ((long) i44)) >>> 31) + (((long) i43) * j38)) + (j37 * ((long) i44))) >>> 31) + (((long) i41) * j38)) + (((long) i43) * j37)) >>> 31) + (((long) i40) * j38)) + (((long) i41) * j37)) >>> 21) + ((((long) i40) * j37) << 10)) >>> i39;
                        long j40 = j17 >>> 31;
                        long j41 = j17 & 2147483647L;
                        j11 = j39;
                        j12 = ((((((((((((j41 * ((long) i44)) >>> 31) + (((long) i43) * j41)) + (j40 * ((long) i44))) >>> 31) + (((long) i41) * j41)) + (((long) i43) * j40)) >>> 31) + (((long) i40) * j41)) + (((long) i41) * j40)) >>> 21) + ((((long) i40) * j40) << 10)) >>> i39;
                        long j42 = j18 >>> 31;
                        long j43 = j18 & 2147483647L;
                        long j44 = ((((((((((((j43 * ((long) i44)) >>> 31) + (((long) i43) * j43)) + (j42 * ((long) i44))) >>> 31) + (((long) i41) * j43)) + (((long) i43) * j42)) >>> 31) + (((long) i40) * j43)) + (((long) i41) * j42)) >>> 21) + ((((long) i40) * j42) << 10)) >>> i39;
                        int i45 = iMax2 + i26;
                        z12 = true;
                        if (iMax2 > 1) {
                            z12 = iMax2 < 63 && (j16 & ((1 << (iMax2 - 1)) - 1)) == 0;
                        } else if (z11) {
                            z13 = i42 == 1;
                            i13 = i45;
                            j13 = j44;
                        } else {
                            j12--;
                        }
                        i13 = i45;
                        j13 = j44;
                    }
                    if (j12 >= 1000000000000000000L) {
                        i27 = 19;
                    } else if (j12 >= 100000000000000000L) {
                        i27 = 18;
                    } else if (j12 >= 10000000000000000L) {
                        i27 = 17;
                    } else if (j12 >= 1000000000000000L) {
                        i27 = 16;
                    } else if (j12 >= 100000000000000L) {
                        i27 = 15;
                    } else if (j12 >= 10000000000000L) {
                        i27 = 14;
                    } else if (j12 >= 1000000000000L) {
                        i27 = 13;
                    } else if (j12 >= 100000000000L) {
                        i27 = 12;
                    } else if (j12 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                        i27 = 11;
                    } else if (j12 >= C.NANOS_PER_SECOND) {
                        i27 = 10;
                    } else if (j12 >= 100000000) {
                        i27 = 9;
                    } else if (j12 >= 10000000) {
                        i27 = 8;
                    } else if (j12 >= 1000000) {
                        i27 = 7;
                    } else if (j12 >= 100000) {
                        i27 = 6;
                    } else if (j12 >= 10000) {
                        i27 = 5;
                    } else if (j12 >= 1000) {
                        i27 = 4;
                    } else if (j12 < 100) {
                        i27 = j12 >= 10 ? 2 : 1;
                    }
                    int i46 = i13 + i27;
                    int i47 = i46 - 1;
                    boolean z19 = i47 < -3 || i47 >= 7;
                    if (z13 || z12) {
                        int i48 = 0;
                        int i49 = 0;
                        while (true) {
                            long j45 = j12 / 10;
                            long j46 = j13 / 10;
                            if (j45 <= j46 || (j12 < 100 && z19)) {
                                break;
                            }
                            z13 &= j13 % 10 == 0;
                            z12 &= i48 == 0;
                            i48 = (int) (j11 % 10);
                            j11 /= 10;
                            i49++;
                            j12 = j45;
                            j13 = j46;
                        }
                        if (z13 && z11) {
                            while (j13 % 10 == 0 && (j12 >= 100 || !z19)) {
                                z12 &= i48 == 0;
                                i48 = (int) (j11 % 10);
                                j12 /= 10;
                                j11 /= 10;
                                j13 /= 10;
                                i49++;
                            }
                        }
                        if (z12 && i48 == 5 && j11 % 2 == 0) {
                            i48 = 4;
                        }
                        j14 = j11 + ((long) (((j11 != j13 || (z13 && z11)) && i48 < 5) ? 0 : 1));
                        i14 = i49;
                    } else {
                        i14 = 0;
                        int i50 = 0;
                        while (true) {
                            long j47 = j12 / 10;
                            long j48 = j13 / 10;
                            if (j47 <= j48 || (j12 < 100 && z19)) {
                                break;
                            }
                            i50 = (int) (j11 % 10);
                            j11 /= 10;
                            i14++;
                            j12 = j47;
                            j13 = j48;
                        }
                        j14 = j11 + ((long) ((j11 == j13 || i50 >= 5) ? 1 : 0));
                    }
                    int i51 = i27 - i14;
                    if (z16) {
                        i15 = i11 + 1;
                        cArr[i11] = '-';
                    } else {
                        i15 = i11;
                    }
                    if (!z19) {
                        char c11 = '0';
                        if (i47 < 0) {
                            int i52 = i15 + 1;
                            cArr[i15] = '0';
                            int i53 = i15 + 2;
                            cArr[i52] = '.';
                            int i54 = -1;
                            while (i54 > i47) {
                                cArr[i53] = c11;
                                i54--;
                                i53++;
                                c11 = '0';
                            }
                            i16 = i53;
                            for (int i55 = 0; i55 < i51; i55++) {
                                cArr[((i53 + i51) - i55) - 1] = (char) ((j14 % 10) + 48);
                                j14 /= 10;
                                i16++;
                            }
                        } else if (i46 >= i51) {
                            for (int i56 = 0; i56 < i51; i56++) {
                                cArr[((i15 + i51) - i56) - 1] = (char) ((j14 % 10) + 48);
                                j14 /= 10;
                            }
                            int i57 = i15 + i51;
                            while (i51 < i46) {
                                cArr[i57] = '0';
                                i51++;
                                i57++;
                            }
                            cArr[i57] = '.';
                            i16 = i57 + 2;
                            cArr[i57 + 1] = '0';
                        } else {
                            int i58 = i15 + 1;
                            for (int i59 = 0; i59 < i51; i59++) {
                                if ((i51 - i59) - 1 == i47) {
                                    cArr[((i58 + i51) - i59) - 1] = '.';
                                    i58--;
                                }
                                cArr[((i58 + i51) - i59) - 1] = (char) ((j14 % 10) + 48);
                                j14 /= 10;
                            }
                            i16 = i15 + i51 + 1;
                        }
                        return i16 - i11;
                    }
                    for (int i60 = 0; i60 < i51 - 1; i60++) {
                        int i61 = (int) (j14 % 10);
                        j14 /= 10;
                        cArr[(i15 + i51) - i60] = (char) (i61 + 48);
                    }
                    cArr[i15] = (char) ((j14 % 10) + 48);
                    cArr[i15 + 1] = '.';
                    int i62 = i15 + i51 + 1;
                    if (i51 == 1) {
                        cArr[i62] = '0';
                        i62++;
                    }
                    int i63 = i62 + 1;
                    cArr[i62] = 'E';
                    if (i47 < 0) {
                        cArr[i63] = '-';
                        i47 = -i47;
                        i63 = i62 + 2;
                    }
                    if (i47 >= 100) {
                        int i64 = i63 + 1;
                        i17 = 48;
                        cArr[i63] = (char) ((i47 / 100) + 48);
                        i47 %= 100;
                        i63 += 2;
                        cArr[i64] = (char) ((i47 / 10) + 48);
                    } else {
                        i17 = 48;
                        if (i47 >= 10) {
                            cArr[i63] = (char) ((i47 / 10) + 48);
                            i63++;
                        }
                    }
                    i18 = i63 + 1;
                    cArr[i63] = (char) ((i47 % 10) + i17);
                }
            }
            return i18 - i11;
        }
        cArr[i11] = 'N';
        cArr[i11 + 1] = 'a';
        i23 = i11 + 3;
        cArr[i11 + 2] = 'N';
        return i23 - i11;
    }

    public static String b(double d11) {
        char[] cArr = new char[24];
        return new String(cArr, 0, a(d11, cArr, 0));
    }
}
