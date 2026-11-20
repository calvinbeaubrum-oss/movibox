package com.google.common.math;

import com.google.android.gms.common.api.Api;
import com.google.common.base.m;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.transsion.gslb.Worker;
import java.math.RoundingMode;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f38773a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f38774b = {1, 10, 100, 1000, 10000, DefaultOggSeeker.MATCH_BYTE_RANGE, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f38775c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Api.BaseClientBuilder.API_PRIORITY_OTHER};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f38776d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int[] f38777e = {Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, 65536, 2345, 477, 193, Worker.WHAT_QUIT, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38778a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f38778a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38778a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38778a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38778a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38778a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38778a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38778a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38778a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i11, int i12) {
        long j11 = ((long) i11) + ((long) i12);
        int i13 = (int) j11;
        g.b(j11 == ((long) i13), "checkedAdd", i11, i12);
        return i13;
    }

    public static int b(int i11, int i12) {
        long j11 = ((long) i11) * ((long) i12);
        int i13 = (int) j11;
        g.b(j11 == ((long) i13), "checkedMultiply", i11, i12);
        return i13;
    }

    public static int c(int i11, int i12, RoundingMode roundingMode) {
        m.p(roundingMode);
        if (i12 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i13 = i11 / i12;
        int i14 = i11 - (i12 * i13);
        if (i14 == 0) {
            return i13;
        }
        int i15 = ((i11 ^ i12) >> 31) | 1;
        switch (a.f38778a[roundingMode.ordinal()]) {
            case 1:
                g.f(i14 == 0);
                return i13;
            case 2:
                return i13;
            case 3:
                if (i15 >= 0) {
                    return i13;
                }
                break;
            case 4:
                break;
            case 5:
                if (i15 <= 0) {
                    return i13;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i14);
                int iAbs2 = iAbs - (Math.abs(i12) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i13 & 1) != 0))) {
                            return i13;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i13;
                }
            default:
                throw new AssertionError();
        }
        return i13 + i15;
    }

    public static boolean d(int i11) {
        return (i11 > 0) & ((i11 & (i11 + (-1))) == 0);
    }

    public static int e(int i11, int i12) {
        return (~(~(i11 - i12))) >>> 31;
    }

    public static int f(int i11, RoundingMode roundingMode) {
        g.e("x", i11);
        switch (a.f38778a[roundingMode.ordinal()]) {
            case 1:
                g.f(d(i11));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i11 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i11);
                return (31 - iNumberOfLeadingZeros) + e((-1257966797) >>> iNumberOfLeadingZeros, i11);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i11);
    }

    public static int g(int i11, int i12) {
        if (i12 > 0) {
            int i13 = i11 % i12;
            return i13 >= 0 ? i13 : i13 + i12;
        }
        throw new ArithmeticException("Modulus " + i12 + " must be > 0");
    }

    public static int h(int i11, int i12) {
        return Ints.l(((long) i11) + ((long) i12));
    }

    public static int i(int i11, int i12) {
        return Ints.l(((long) i11) * ((long) i12));
    }
}
