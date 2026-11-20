package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto;
import com.facebook.ads.internal.exoplayer2.thirdparty.video.DummySurface;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.Worker;
import com.vungle.warren.error.VungleException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3F extends AbstractC11066j {
    public static boolean A0b;
    public static boolean A0c;
    public static byte[] A0d;
    public static String[] A0e = {"1acRM6Cf6EhxOJODmj0H0eP8VC35ZmTt", "cV9GjlkLQwwiHa", "i1c6IC1hwgIn8DthxqNi0XpoGO8BN4qE", "gFn4mUSFpSKHUauCdH5nTsZh8y8bn5UZ", "9nkQNk0PAkkX03QPU4alH8fTsKo9h28D", "s2uNxYIY6duU338ylAtcR72UhbPyFCsP", "VOm8bC2ft6X0ZlQ", "HWs0n0OHt4vGmZ"};
    public static final int[] A0f;
    public IQ A00;
    public float A01;
    public float A02;
    public float A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public Surface A0N;
    public Surface A0O;
    public IP A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public final int A0T;
    public final long A0U;
    public final Context A0V;
    public final IT A0W;
    public final C1379Ic A0X;
    public final boolean A0Y;
    public final long[] A0Z;
    public final long[] A0a;

    static {
        A0D();
        A0f = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    }

    public C3F(Context context, DM dm2, long j11, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, boolean z11, Handler handler, InterfaceC1380Id interfaceC1380Id, int i11) {
        super(2, dm2, interfaceC1217Bc, z11);
        this.A0U = j11;
        this.A0T = i11;
        Context applicationContext = context.getApplicationContext();
        this.A0V = applicationContext;
        this.A0W = new IT(applicationContext);
        this.A0X = new C1379Ic(handler, interfaceC1380Id);
        this.A0Y = A0M();
        this.A0Z = new long[10];
        this.A0a = new long[10];
        this.A0M = C.TIME_UNSET;
        this.A0K = C.TIME_UNSET;
        this.A0J = C.TIME_UNSET;
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0F = 1;
        A07();
    }

    public static int A00(DG dg2, Format format) {
        if (format.A09 == -1) {
            return A01(dg2, format.A0O, format.A0F, format.A08);
        }
        int length = 0;
        int size = format.A0P.size();
        for (int i11 = 0; i11 < size; i11++) {
            length += format.A0P.get(i11).length;
        }
        int i12 = format.A09;
        if (A0e[4].charAt(25) == 'e') {
            throw new RuntimeException();
        }
        A0e[5] = "PFjSJxahL7zuosjl0ltO07DmFDIUFrxC";
        return i12 + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x000d  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
    
        if (r5.A05 != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(DG dg2, String str, int i11, int i12) {
        byte b11;
        int i13;
        int i14;
        if (i11 == -1 || i12 == -1) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (!str.equals(A05(1267, 10, 17))) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case -1662541442:
                if (!str.equals(A05(1286, 10, 47))) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case 1187890754:
                if (!str.equals(A05(1296, 13, 9))) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 1331836730:
                if (!str.equals(A05(1277, 9, 24))) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case 1599127256:
                if (!str.equals(A05(1309, 19, 107))) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 1599127257:
                if (!str.equals(A05(1328, 19, 29))) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
            case 1:
                i13 = i11 * i12;
                i14 = 2;
                break;
            case 2:
                if (!A05(111, 14, 56).equals(IF.A06)) {
                    if (A05(76, 6, 82).equals(IF.A05)) {
                        if (!A05(495, 6, 4).equals(IF.A06)) {
                            if (A05(72, 4, 64).equals(IF.A06)) {
                            }
                        }
                    }
                    int iA04 = IF.A04(i11, 16);
                    int iA05 = IF.A04(i12, 16);
                    if (A0e[6].length() == 11) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0e;
                    strArr[0] = "x2yMHKGTgYRqVR8BBJa50R3gpwcpbPk7";
                    strArr[2] = "MDbyzLCCUwawERMs5O7i0Z9U5SWznnDD";
                    i13 = iA04 * iA05 * 16 * 16;
                    i14 = 2;
                    break;
                }
                return -1;
            case 3:
                i13 = i11 * i12;
                i14 = 2;
                break;
            case 4:
            case 5:
                i13 = i11 * i12;
                i14 = 4;
                break;
            default:
                return -1;
        }
        return (i13 * 3) / (i14 * 2);
    }

    public static Point A02(DG dg2, Format format) throws DP {
        boolean z11 = format.A08 > format.A0F;
        int i11 = z11 ? format.A08 : format.A0F;
        int i12 = z11 ? format.A0F : format.A08;
        float f11 = i12 / i11;
        for (int i13 : A0f) {
            int i14 = (int) (i13 * f11);
            if (i13 <= i11 || i14 <= i12) {
                return null;
            }
            if (IF.A02 >= 21) {
                int i15 = z11 ? i14 : i13;
                if (!z11) {
                    i13 = i14;
                }
                Point pointA0E = dg2.A0E(i15, i13);
                if (dg2.A0H(pointA0E.x, pointA0E.y, format.A01)) {
                    return pointA0E;
                }
            } else {
                int iA04 = IF.A04(i13, 16) * 16;
                int iA05 = IF.A04(i14, 16) * 16;
                if (iA04 * iA05 <= DR.A00()) {
                    int i16 = z11 ? iA05 : iA04;
                    if (!z11) {
                        iA04 = iA05;
                    }
                    return new Point(i16, iA04);
                }
            }
        }
        return null;
    }

    private final MediaFormat A03(Format format, IP ip2, boolean z11, int i11) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A05(1094, 4, 120), format.A0O);
        mediaFormat.setInteger(A05(1359, 5, 19), format.A0F);
        mediaFormat.setInteger(A05(971, 6, 26), format.A08);
        DS.A06(mediaFormat, format.A0P);
        DS.A03(mediaFormat, A05(954, 10, 18), format.A01);
        DS.A04(mediaFormat, A05(1180, 16, 48), format.A0B);
        DS.A02(mediaFormat, format.A0J);
        mediaFormat.setInteger(A05(1079, 9, 25), ip2.A02);
        mediaFormat.setInteger(A05(1055, 10, 13), ip2.A00);
        DS.A04(mediaFormat, A05(1065, 14, 39), ip2.A01);
        if (IF.A02 >= 23) {
            mediaFormat.setInteger(A05(1153, 8, 122), 0);
        }
        if (z11) {
            String strA05 = A05(875, 8, 49);
            if (A0e[5].charAt(18) != 't') {
                throw new RuntimeException();
            }
            A0e[5] = "LIFMuRLmQz6XdmDBeptCblAg9hMw0FnF";
            mediaFormat.setInteger(strA05, 0);
        }
        if (i11 != 0) {
            A0K(mediaFormat, i11);
        }
        return mediaFormat;
    }

    private final IP A04(DG dg2, Format format, Format[] formatArr) throws DP {
        int iMax = format.A0F;
        int iMax2 = format.A08;
        int iA00 = A00(dg2, format);
        if (formatArr.length == 1) {
            return new IP(iMax, iMax2, iA00);
        }
        boolean z11 = false;
        for (Format format2 : formatArr) {
            if (A0V(dg2.A03, format, format2)) {
                z11 |= format2.A0F == -1 || format2.A08 == -1;
                iMax = Math.max(iMax, format2.A0F);
                iMax2 = Math.max(iMax2, format2.A08);
                iA00 = Math.max(iA00, A00(dg2, format2));
            }
        }
        if (z11) {
            StringBuilder sbAppend = new StringBuilder().append(A05(683, 43, 125)).append(iMax);
            String strA05 = A05(1379, 1, 98);
            String string = sbAppend.append(strA05).append(iMax2).toString();
            String strA06 = A05(522, 23, 33);
            Log.w(strA06, string);
            Point pointA02 = A02(dg2, format);
            if (pointA02 != null) {
                iMax = Math.max(iMax, pointA02.x);
                iMax2 = Math.max(iMax2, pointA02.y);
                iA00 = Math.max(iA00, A01(dg2, format.A0O, iMax, iMax2));
                Log.w(strA06, A05(164, 34, 75) + iMax + strA05 + iMax2);
            }
        }
        return new IP(iMax, iMax2, iA00);
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0d, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    private void A06() {
        MediaCodec mediaCodecA1D;
        this.A0R = false;
        if (IF.A02 < 23 || !this.A0S || (mediaCodecA1D = A1D()) == null) {
            return;
        }
        this.A00 = new IQ(this, mediaCodecA1D);
    }

    private void A07() {
        this.A0E = -1;
        this.A0C = -1;
        this.A03 = -1.0f;
        this.A0D = -1;
    }

    private void A08() {
        if (this.A09 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.A0X.A02(this.A09, jElapsedRealtime - this.A0H);
            this.A09 = 0;
            this.A0H = jElapsedRealtime;
        }
    }

    private void A09() {
        int i11 = this.A08;
        if (i11 == -1 && this.A06 == -1) {
            return;
        }
        if (this.A0E == i11 && this.A0C == this.A06 && this.A0D == this.A07 && this.A03 == this.A01) {
            return;
        }
        this.A0X.A01(i11, this.A06, this.A07, this.A01);
        this.A0E = this.A08;
        this.A0C = this.A06;
        this.A0D = this.A07;
        this.A03 = this.A01;
    }

    private void A0A() {
        if (this.A0R) {
            this.A0X.A03(this.A0O);
        }
    }

    private void A0B() {
        int i11 = this.A0E;
        if (i11 == -1) {
            int i12 = this.A0C;
            String[] strArr = A0e;
            if (strArr[0].charAt(20) != strArr[2].charAt(20)) {
                throw new RuntimeException();
            }
            A0e[6] = "GSr0Qxmd2Qhu1M0N5tyB3p9H4Vler7W";
            if (i12 == -1) {
                return;
            }
        }
        this.A0X.A01(i11, this.A0C, this.A0D, this.A03);
    }

    private void A0C() {
        this.A0J = this.A0U > 0 ? SystemClock.elapsedRealtime() + this.A0U : C.TIME_UNSET;
    }

    public static void A0D() {
        A0d = new byte[]{10, Ascii.CR, Ascii.VT, 10, 93, 91, 93, 95, 112, 118, 112, 117, 6, 118, 119, 106, 112, 119, 1, 108, Ascii.FS, Ascii.ESC, Ascii.GS, Ascii.FS, 126, Ascii.CR, Ascii.SI, Ascii.SO, 9, 94, Ascii.VT, Ascii.SI, 76, 58, 61, 61, 61, 32, 108, 49, 71, 64, 64, 64, 0, Ascii.FS, 5, 3, 64, 54, 49, 48, 49, 96, 53, 57, 64, 54, 49, 51, 49, 96, 53, 57, 81, 86, 68, 81, 82, 85, 71, 93, 88, 95, 77, 74, 74, 102, 106, 113, 100, 101, Ascii.CAN, 40, 44, 56, 9, 54, 46, 60, 43, Ascii.DC4, 80, 100, 99, 112, 78, 95, 126, 101, 116, 78, 35, 9, 7, 10, 8, 0, 102, 122, 19, 35, 51, 32, 55, 40, 32, 65, 85, 42, 65, 83, 81, 80, 84, 61, 45, 62, 41, 54, 62, 32, 62, 43, 41, 77, 51, 65, 55, 36, 76, 66, 67, 66, 43, 61, 68, 70, 103, 116, 108, Ascii.NAK, Ascii.DC2, Ascii.DC4, Ascii.GS, 85, 70, 79, 46, 37, 73, 95, 38, 38, 81, 125, 118, 119, 113, 50, Ascii.DEL, 115, 106, 50, 96, 119, 97, 125, 126, 103, 102, 123, 125, 124, 50, 115, 118, 120, 103, 97, 102, 119, 118, 50, 102, 125, 40, 50, 104, 68, 70, 66, 68, 120, Ascii.SUB, Ascii.SI, Ascii.DEL, 124, 126, 121, 122, 115, 106, 120, 126, 96, 126, Ascii.FF, 96, 111, 77, 80, 124, 117, 108, 126, 120, 102, 119, 86, 77, 92, 43, 34, 59, 41, 47, 49, 62, Ascii.FS, 7, 3, 44, 37, 60, 46, 40, 54, 59, 8, Ascii.DLE, 54, 49, 67, 112, 99, 116, 85, 114, 103, 116, 89, 85, Ascii.RS, 107, 105, 105, 105, 43, 94, 92, 92, 94, Ascii.VT, 126, 124, 124, 123, Ascii.DEL, 10, Ascii.VT, 8, 8, 64, 53, 52, 55, 53, 90, 47, 46, 45, 41, Ascii.RS, 107, 107, 105, 105, Ascii.EM, 62, 51, 44, 58, Ascii.FS, 55, 58, 60, 52, Ascii.DEL, 4, 51, 58, 56, 62, 60, 38, Ascii.EM, 45, 62, 50, 58, Ascii.FF, 54, 37, 58, 115, Ascii.DEL, 40, 38, 32, 33, 42, 42, 48, 40, 45, 35, 88, 92, 89, 95, 42, 36, 34, 35, 40, 40, 50, 62, 58, 58, 92, 91, 93, 84, 33, 47, 41, 40, 35, 35, 57, 53, 49, 49, 87, 80, 84, 81, Ascii.SYN, Ascii.CAN, Ascii.RS, Ascii.US, Ascii.DC4, Ascii.DC4, Ascii.SO, 2, 6, 6, 96, 103, 98, 96, 84, 90, 92, 93, 86, 86, 76, 68, 81, 95, 38, 36, 35, 43, Ascii.DEL, 113, 119, 118, 125, 125, 103, 111, 122, 116, Ascii.SI, Ascii.VT, Ascii.SO, Ascii.CR, 58, 52, 50, 51, 56, 56, 34, 42, Utf8.REPLACEMENT_BYTE, 49, 74, 72, 76, 68, Ascii.FF, 34, 4, 5, Ascii.SO, Ascii.SO, Ascii.DC4, 8, 9, 7, 124, 126, 122, 120, 75, 101, 67, 66, 73, 73, 83, 75, 78, 64, 59, Utf8.REPLACEMENT_BYTE, 61, 53, 44, 51, 38, 40, 42, 73, 44, 97, 126, 106, 104, 100, 4, 97, 9, Ascii.SYN, Ascii.ETB, Ascii.SI, Ascii.DC2, 108, 9, 119, 80, 88, 87, 80, 87, 70, 19, 102, Ascii.VT, 9, Ascii.FF, 0, Ascii.CR, Ascii.DLE, 72, 54, 51, 98, 55, 51, Ascii.SYN, Ascii.ESC, Ascii.SO, Ascii.DC2, 10, Ascii.DC4, 4, Ascii.ESC, 101, 125, 120, 121, Ascii.DEL, 8, 112, 38, 62, 54, 58, 41, 38, 44, 62, 70, 76, 89, 55, 53, Ascii.GS, Ascii.FS, 17, Ascii.EM, 59, Ascii.ETB, Ascii.FS, Ascii.GS, Ascii.ESC, 46, 17, Ascii.FS, Ascii.GS, Ascii.ETB, 42, Ascii.GS, Ascii.SYN, Ascii.FS, Ascii.GS, 10, Ascii.GS, 10, 114, 106, 117, 120, 117, 125, Ascii.RS, 8, 101, 100, 97, Ascii.SUB, 115, 101, 8, 10, Ascii.SO, 119, 40, 42, Utf8.REPLACEMENT_BYTE, 73, 0, 8, 8, 0, Ascii.VT, 2, 44, Ascii.CR, 6, 51, Ascii.SI, Ascii.SYN, Ascii.DLE, 86, 55, 41, 79, 65, 72, 96, 8, 5, 50, 32, 80, 79, 84, 85, 82, 47, 35, 52, 61, 70, 65, 75, 42, 61, 52, 76, 75, 74, 55, 32, 41, 81, 86, 86, 69, 89, 80, 124, 126, 99, Ascii.ESC, Ascii.DEL, Ascii.DLE, 40, 33, 46, 52, 47, 45, 118, 88, 97, 112, 97, 60, 37, Utf8.REPLACEMENT_BYTE, 87, 59, 79, 45, Ascii.DC4, 5, Ascii.DC4, 72, 80, 76, 77, 34, 73, 58, 3, 97, 103, 98, 109, 8, Ascii.SO, 10, Ascii.FF, 52, 81, 87, 82, 120, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.EM, 119, 19, 81, 77, 49, 54, 88, 69, 95, 85, Ascii.EM, Ascii.DLE, 121, 118, 65, 87, 75, 72, 81, 80, 77, 75, 74, 87, 4, 81, 74, 79, 74, 75, 83, 74, 10, 4, 103, 75, 64, 65, 71, 4, 73, 69, 92, 4, 86, 65, 87, 75, 72, 81, 80, 77, 75, 74, Ascii.RS, 4, Ascii.ESC, Ascii.RS, Ascii.CAN, 101, Ascii.FF, Ascii.FS, Ascii.RS, 121, 125, 68, 123, 118, 99, 114, 72, 71, 101, 120, 107, 125, Ascii.FF, Ascii.DC2, 8, Ascii.FF, Ascii.SI, 121, 1, Ascii.ETB, 102, 120, 98, 102, 101, Ascii.CR, 51, 37, 84, 74, 95, 82, 87, 33, 68, 82, 35, 61, 40, 37, 32, 93, Ascii.SI, 52, 52, 123, 54, 58, 53, 34, 123, 40, 47, 41, 62, 58, 54, 123, 56, 51, 58, 53, 60, 62, 40, 119, 123, 40, 52, 123, Utf8.REPLACEMENT_BYTE, 41, 52, 43, 43, 50, 53, 60, 123, 52, 61, 61, 40, 62, 47, 97, 123, 67, 36, 64, 36, 37, 81, 84, 55, 84, 44, 71, 43, 60, Utf8.REPLACEMENT_BYTE, Ascii.FF, 17, 102, Ascii.FF, Ascii.ESC, Ascii.ETB, 114, 117, 117, 112, 86, 61, 62, 83, 92, 94, 67, Ascii.SO, 108, 100, Ascii.EM, 93, 32, 91, 66, 86, 71, 74, 76, Ascii.SO, 80, 70, 80, 80, 74, 76, 77, Ascii.SO, 74, 71, 9, Ascii.GS, Ascii.FS, 7, 69, Ascii.SO, Ascii.SUB, Ascii.VT, Ascii.GS, Ascii.FF, 17, Ascii.SO, 83, Ascii.FS, 17, 10, 10, 17, 19, Ascii.VT, Ascii.SUB, 7, Ascii.CAN, 69, 4, Ascii.CR, Ascii.SO, Ascii.FS, 32, 49, 44, 51, 110, 49, 42, 36, 43, 55, 95, 78, 83, 76, 17, 72, 83, 76, 103, 114, 53, 58, 47, 106, Ascii.RS, Ascii.US, Ascii.CAN, 96, 118, 107, 116, 82, 109, 96, 97, 107, 70, 113, 98, 98, 97, 118, 107, 97, 98, 10, 3, Ascii.US, Ascii.CAN, 9, Ascii.RS, 45, 57, 42, 38, 46, 102, 57, 42, Utf8.REPLACEMENT_BYTE, 46, 126, 107, 112, Ascii.DEL, Ascii.DEL, 112, 119, 43, 38, 42, 36, 43, 55, 54, 42, 61, 1, 59, 107, 104, 51, 50, 1, 58, 42, 43, 50, 59, 36, Ascii.DC2, Ascii.US, Ascii.SYN, 126, Ascii.ESC, 120, 115, 
        112, 125, 125, 41, 38, 34, 36, 78, 40, 41, 33, 39, 84, 79, 84, 78, Ascii.VT, Ascii.CR, Ascii.CR, Ascii.DLE, 1, 8, 59, 55, 80, 85, 64, Ascii.CAN, 82, 70, 94, 79, 67, 68, 89, 111, 102, 92, 123, 53, 55, 59, 52, 52, 51, 52, 61, 123, 119, 100, Ascii.DEL, 120, 121, 73, 112, 57, 53, 44, 121, 60, 49, 61, 51, 60, 32, 19, Ascii.US, 6, 83, Ascii.ETB, Ascii.DLE, Ascii.SO, Ascii.VT, 10, 83, Ascii.CR, Ascii.ETB, 4, Ascii.ESC, 45, 33, 56, 109, 55, 41, 36, 52, 40, 54, 51, 109, 105, 100, 111, 76, 72, 76, 68, 96, 111, 99, 111, 122, 102, Ascii.DC2, Ascii.NAK, Ascii.US, Ascii.ETB, Ascii.DLE, Ascii.GS, 9, Ascii.SI, 35, Ascii.SUB, 79, Ascii.CR, Ascii.SO, Ascii.CR, 56, 41, 38, 45, 36, 36, Ascii.ETB, 44, 50, 35, 44, 39, 46, 46, Ascii.GS, 38, 46, 90, 75, 68, 79, 70, 70, 117, 78, 89, 112, 97, 110, 101, 108, 108, 95, 100, 116, 83, 81, 74, 76, 81, 74, 87, 90, 70, 81, 88, 81, 85, 71, 81, 123, 65, 64, 68, 65, 64, 118, 65, 82, 82, 81, 70, Ascii.ESC, 6, Ascii.GS, 8, Ascii.GS, 0, 6, 7, 68, Ascii.CR, Ascii.FF, Ascii.SO, Ascii.ESC, Ascii.FF, Ascii.FF, Ascii.SUB, 113, 59, 50, 55, 122, 50, 51, 58, 65, 83, 92, 70, 93, 92, 91, 110, 118, 116, 109, 75, 116, 121, 120, 114, 95, 104, 123, 123, 120, 111, 71, 82, 90, 87, 92, 108, 65, 92, 68, 74, 93, 82, 97, 91, 75, Ascii.FF, Ascii.CR, Ascii.SYN, Ascii.SYN, Ascii.GS, Ascii.DC4, Ascii.GS, Ascii.FS, 85, 8, Ascii.DC4, Ascii.EM, 1, Ascii.SUB, Ascii.EM, Ascii.ESC, 19, Ascii.GS, Ascii.SO, Ascii.EM, 5, Ascii.SO, Ascii.SO, 52, 38, 94, 62, 33, 44, 45, 39, 103, 123, 47, 56, 56, 55, 40, 37, 36, 46, 110, 32, 55, 34, 0, Ascii.US, Ascii.DC2, 19, Ascii.EM, 89, Ascii.RS, 19, 0, Ascii.NAK, 38, 57, 52, 53, Utf8.REPLACEMENT_BYTE, Ascii.DEL, 61, 32, 100, 38, 125, 53, 35, 68, 91, 86, 87, 93, Ascii.GS, 74, Ascii.US, 68, 92, 86, Ascii.FS, 93, 92, 0, Ascii.FS, 68, 66, 10, 50, 45, 32, 33, 43, 107, 60, 105, 50, 42, 32, 106, 43, 42, 118, 106, 50, 52, 125, 97, 119, 98, 101, 121, 120, 110, 113, 96, 107, 124, 125, 61, 35, 46, 62, 34, Ascii.SI, Ascii.ETB, Ascii.ETB, Ascii.FS, Ascii.VT, 39, Ascii.RS, 115, 107, 107, 96, 119, 91, 98, 106, 67};
    }

    private final void A0E(int i11) {
        super.A0U.A02 += i11;
        this.A09 += i11;
        this.A05 += i11;
        super.A0U.A05 = Math.max(this.A05, super.A0U.A05);
        if (this.A09 >= this.A0T) {
            A08();
        }
    }

    private final void A0F(MediaCodec mediaCodec, int i11, long j11) {
        IC.A02(A05(930, 15, 93));
        mediaCodec.releaseOutputBuffer(i11, false);
        IC.A00();
        A0E(1);
    }

    private final void A0G(MediaCodec mediaCodec, int i11, long j11) {
        A09();
        IC.A02(A05(1161, 19, 109));
        mediaCodec.releaseOutputBuffer(i11, true);
        IC.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1S();
    }

    private final void A0H(MediaCodec mediaCodec, int i11, long j11) {
        IC.A02(A05(1211, 15, 68));
        mediaCodec.releaseOutputBuffer(i11, false);
        IC.A00();
        super.A0U.A08++;
    }

    private final void A0I(MediaCodec mediaCodec, int i11, long j11, long j12) {
        A09();
        IC.A02(A05(1161, 19, 109));
        mediaCodec.releaseOutputBuffer(i11, j12);
        IC.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1S();
    }

    public static void A0J(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    public static void A0K(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled(A05(1241, 17, 33), true);
        mediaFormat.setInteger(A05(859, 16, 122), i11);
    }

    private void A0L(Surface surface) throws C11669c {
        if (surface == null) {
            if (this.A0N != null) {
                surface = this.A0N;
            } else {
                DG dgA1E = A1E();
                if (dgA1E != null && A0T(dgA1E)) {
                    this.A0N = DummySurface.A01(this.A0V, dgA1E.A05);
                    surface = this.A0N;
                }
            }
        }
        if (this.A0O == surface) {
            if (surface != null) {
                Surface surface2 = this.A0N;
                String[] strArr = A0e;
                if (strArr[1].length() == strArr[7].length()) {
                    String[] strArr2 = A0e;
                    strArr2[1] = "4gXhdQ7K18codO";
                    strArr2[7] = "dCZzuzcRJjaMd3";
                    if (surface == surface2) {
                        return;
                    }
                } else if (surface == surface2) {
                    return;
                }
                A0B();
                A0A();
                return;
            }
            return;
        }
        this.A0O = surface;
        if (A0e[3].charAt(22) != 'Z') {
            throw new RuntimeException();
        }
        A0e[5] = "451d0u4cD9rJ2w2guGtx9AsvugCig8Nc";
        int iA81 = A81();
        if (iA81 == 1 || iA81 == 2) {
            MediaCodec mediaCodecA1D = A1D();
            if (IF.A02 < 23 || mediaCodecA1D == null || surface == null || this.A0Q) {
                A1H();
                A1J();
            } else {
                A0J(mediaCodecA1D, surface);
            }
        }
        if (surface != null && surface != this.A0N) {
            A0B();
            A06();
            if (iA81 == 2) {
                A0C();
                return;
            }
            return;
        }
        A07();
        if (A0e[5].charAt(18) != 't') {
            A06();
        } else {
            A0e[3] = "pSIGciD2qJewSpKsBqH446Zc9mkVUpAR";
            A06();
        }
    }

    public static boolean A0M() {
        return IF.A02 <= 22 && A05(948, 6, 53).equals(IF.A03) && A05(545, 6, 101).equals(IF.A05);
    }

    public static boolean A0N(long j11) {
        return j11 < -30000;
    }

    public static boolean A0O(long j11) {
        return j11 < -500000;
    }

    private final boolean A0P(long j11, long j12) {
        return A0O(j11);
    }

    private final boolean A0Q(long j11, long j12) {
        return A0N(j11);
    }

    private final boolean A0R(long j11, long j12) {
        return A0N(j11) && j12 > 100000;
    }

    private final boolean A0S(MediaCodec mediaCodec, int i11, long j11, long j12) throws C11669c {
        int iA10 = A10(j12);
        if (iA10 == 0) {
            return false;
        }
        super.A0U.A03++;
        A0E(this.A04 + iA10);
        A1G();
        return true;
    }

    private boolean A0T(DG dg2) {
        return IF.A02 >= 23 && !this.A0S && !A0U(dg2.A02) && (!dg2.A05 || DummySurface.A05(this.A0V));
    }

    /* JADX WARN: Code duplicated, block: B:368:0x0905  */
    /* JADX WARN: Code duplicated, block: B:382:0x093a  */
    private final boolean A0U(String str) {
        int i11 = IF.A02;
        byte b11 = 0;
        byte b12 = Ascii.ESC;
        if (i11 >= 27 || str.startsWith(A05(563, 10, 62))) {
            return false;
        }
        synchronized (C3F.class) {
            if (!A0c) {
                String str2 = IF.A03;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (!str2.equals(A05(341, 14, 52))) {
                            b12 = -1;
                        } else {
                            b12 = 39;
                        }
                        break;
                    case -2144781185:
                        if (!str2.equals(A05(355, 14, 63))) {
                            b12 = -1;
                        } else {
                            b12 = 40;
                        }
                        break;
                    case -2144781160:
                        if (!str2.equals(A05(369, 14, 8))) {
                            b12 = -1;
                        } else {
                            b12 = 41;
                        }
                        break;
                    case -2097309513:
                        if (!str2.equals(A05(489, 6, 90))) {
                            b12 = -1;
                        } else {
                            b12 = 57;
                        }
                        break;
                    case -2022874474:
                        if (!str2.equals(A05(TsExtractor.TS_STREAM_TYPE_DTS, 10, 45))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.DLE;
                        }
                        break;
                    case -1978993182:
                        if (!str2.equals(A05(551, 6, 9))) {
                            b12 = -1;
                        } else {
                            b12 = 69;
                        }
                        break;
                    case -1978990237:
                        if (!str2.equals(A05(557, 6, 100))) {
                            b12 = -1;
                        } else {
                            b12 = 70;
                        }
                        break;
                    case -1936688988:
                        if (!str2.equals(A05(597, 6, 42))) {
                            b12 = -1;
                        } else {
                            b12 = 80;
                        }
                        break;
                    case -1936688066:
                        if (!str2.equals(A05(603, 6, 35))) {
                            b12 = -1;
                        } else {
                            b12 = 81;
                        }
                        break;
                    case -1936688065:
                        if (!str2.equals(A05(609, 6, 62))) {
                            b12 = -1;
                        } else {
                            b12 = 82;
                        }
                        break;
                    case -1931988508:
                        if (!str2.equals(A05(82, 10, 0))) {
                            b12 = -1;
                        } else {
                            b12 = 10;
                        }
                        break;
                    case -1696512866:
                        if (!str2.equals(A05(839, 6, 26))) {
                            b12 = -1;
                        } else {
                            b12 = 115;
                        }
                        break;
                    case -1680025915:
                        if (!str2.equals(A05(198, 7, 114))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.SI;
                        }
                        break;
                    case -1615810839:
                        if (!str2.equals(A05(623, 8, 25))) {
                            b12 = -1;
                        } else {
                            b12 = 83;
                        }
                        break;
                    case -1554255044:
                        if (!str2.equals(A05(1258, 9, 50))) {
                            b12 = -1;
                        } else {
                            b12 = 108;
                        }
                        break;
                    case -1481772737:
                        if (!str2.equals(A05(1126, 9, 27))) {
                            b12 = -1;
                        } else {
                            b12 = 76;
                        }
                        break;
                    case -1481772730:
                        if (!str2.equals(A05(1135, 9, 115))) {
                            b12 = -1;
                        } else {
                            b12 = 77;
                        }
                        break;
                    case -1481772729:
                        if (!str2.equals(A05(1144, 9, 89))) {
                            b12 = -1;
                        } else {
                            b12 = 78;
                        }
                        break;
                    case -1320080169:
                        if (!str2.equals(A05(439, 14, 85))) {
                            b12 = -1;
                        } else {
                            b12 = 37;
                        }
                        break;
                    case -1217592143:
                        if (!str2.equals(A05(125, 11, 38))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.CR;
                        }
                        break;
                    case -1180384755:
                        if (!str2.equals(A05(1012, 6, 100))) {
                            b12 = -1;
                        } else {
                            b12 = 53;
                        }
                        break;
                    case -1139198265:
                        if (!str2.equals(A05(735, 9, 78))) {
                            b12 = -1;
                        } else {
                            b12 = 96;
                        }
                        break;
                    case -1052835013:
                        if (!str2.equals(A05(1098, 6, 87))) {
                            b12 = -1;
                        } else {
                            b12 = 67;
                        }
                        break;
                    case -993250464:
                        if (!str2.equals(A05(12, 7, 30))) {
                            b12 = -1;
                        } else {
                            b12 = 3;
                        }
                        break;
                    case -965403638:
                        if (!str2.equals(A05(1196, 8, 91))) {
                            b12 = -1;
                        } else {
                            b12 = 98;
                        }
                        break;
                    case -958336948:
                        if (!str2.equals(A05(242, 11, 48))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.SUB;
                        }
                        break;
                    case -879245230:
                        if (!str2.equals(A05(1235, 6, Worker.WHAT_SYNC_DATA))) {
                            b12 = -1;
                        } else {
                            b12 = 104;
                        }
                        break;
                    case -842500323:
                        if (!str2.equals(A05(1104, 10, 37))) {
                            b12 = -1;
                        } else {
                            b12 = 68;
                        }
                        break;
                    case -821392978:
                        if (!str2.equals(A05(32, 7, 84))) {
                            b12 = -1;
                        } else {
                            b12 = 6;
                        }
                        break;
                    case -797483286:
                        if (!str2.equals(A05(726, 9, 17))) {
                            b12 = -1;
                        } else {
                            b12 = 97;
                        }
                        break;
                    case -794946968:
                        if (!str2.equals(A05(1347, 6, 79))) {
                            b12 = -1;
                        } else {
                            b12 = 109;
                        }
                        break;
                    case -788334647:
                        if (!str2.equals(A05(1353, 6, 64))) {
                            b12 = -1;
                        } else {
                            b12 = 110;
                        }
                        break;
                    case -782144577:
                        if (!str2.equals(A05(573, 9, 58))) {
                            b12 = -1;
                        } else {
                            b12 = 71;
                        }
                        break;
                    case -575125681:
                        if (!str2.equals(A05(425, 14, 18))) {
                            b12 = -1;
                        } else {
                            b12 = 36;
                        }
                        break;
                    case -521118391:
                        if (!str2.equals(A05(327, 14, 54))) {
                            b12 = -1;
                        } else {
                            b12 = 38;
                        }
                        break;
                    case -430914369:
                        if (!str2.equals(A05(631, 10, 81))) {
                            b12 = -1;
                        } else {
                            b12 = 84;
                        }
                        break;
                    case -290434366:
                        if (!str2.equals(A05(1226, 9, 106))) {
                            b12 = -1;
                        } else {
                            b12 = 99;
                        }
                        break;
                    case -282781963:
                        if (!str2.equals(A05(Worker.WHAT_SYNC_DATA, 8, 18))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.FF;
                        }
                        break;
                    case -277133239:
                        if (!str2.equals(A05(845, 7, 85))) {
                            b12 = -1;
                        } else {
                            b12 = 116;
                        }
                        break;
                    case -173639913:
                        if (!str2.equals(A05(210, 12, 102))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.ETB;
                        }
                        break;
                    case -56598463:
                        if (!str2.equals(A05(1371, 8, 93))) {
                            b12 = -1;
                        } else {
                            b12 = 112;
                        }
                        break;
                    case 2126:
                        if (!str2.equals(A05(136, 2, 41))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.SO;
                        }
                        break;
                    case 2564:
                        if (!str2.equals(A05(670, 2, 127))) {
                            b12 = -1;
                        } else {
                            b12 = 92;
                        }
                        break;
                    case 2715:
                        if (!str2.equals(A05(821, 2, 76))) {
                            b12 = -1;
                        } else {
                            b12 = 105;
                        }
                        break;
                    case 2719:
                        if (!str2.equals(A05(828, 2, 56))) {
                            b12 = -1;
                        } else {
                            b12 = 107;
                        }
                        break;
                    case 3483:
                        if (!str2.equals(A05(1088, 2, 2))) {
                            b12 = -1;
                        } else {
                            b12 = 64;
                        }
                        break;
                    case 73405:
                        if (!str2.equals(A05(486, 3, 19))) {
                            b12 = -1;
                        } else {
                            b12 = 56;
                        }
                        break;
                    case 75739:
                        if (!str2.equals(A05(DownloadException.EXCEPTION_IO_MALFORMED_URL, 3, 28))) {
                            b12 = -1;
                        } else {
                            b12 = 60;
                        }
                        break;
                    case 76779:
                        if (!str2.equals(A05(519, 3, 88))) {
                            b12 = -1;
                        } else {
                            b12 = 66;
                        }
                        break;
                    case 78669:
                        if (!str2.equals(A05(586, 3, 105))) {
                            b12 = -1;
                        } else {
                            b12 = 74;
                        }
                        break;
                    case 79305:
                        if (!str2.equals(A05(615, 3, 76))) {
                            b12 = -1;
                        } else {
                            b12 = 86;
                        }
                        break;
                    case 80618:
                        if (!str2.equals(A05(680, 3, 17))) {
                            b12 = -1;
                        } else {
                            b12 = 94;
                        }
                        break;
                    case 88274:
                        if (!str2.equals(A05(852, 3, 13))) {
                            b12 = -1;
                        } else {
                            b12 = 117;
                        }
                        break;
                    case 98846:
                        if (!str2.equals(A05(921, 3, 93))) {
                            b12 = -1;
                        } else {
                            b12 = 19;
                        }
                        break;
                    case 98848:
                        if (!str2.equals(A05(924, 3, 0))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.DC4;
                        }
                        break;
                    case 99329:
                        if (!str2.equals(A05(927, 3, 35))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.NAK;
                        }
                        break;
                    case 101481:
                        if (!str2.equals(A05(945, 3, 84))) {
                            b12 = -1;
                        } else {
                            b12 = 35;
                        }
                        break;
                    case 1513190:
                        if (!str2.equals(A05(0, 4, 98))) {
                            b12 = -1;
                        } else {
                            b12 = 0;
                        }
                        break;
                    case 1514184:
                        if (!str2.equals(A05(4, 4, 53))) {
                            b12 = -1;
                        } else {
                            b12 = 1;
                        }
                        break;
                    case 1514185:
                        if (!str2.equals(A05(8, 4, 24))) {
                            b12 = -1;
                        } else {
                            b12 = 2;
                        }
                        break;
                    case 2436959:
                        if (!str2.equals(A05(582, 4, 32))) {
                            b12 = -1;
                        } else {
                            b12 = 73;
                        }
                        break;
                    case 2463773:
                        if (!str2.equals(A05(652, 4, 11))) {
                            b12 = -1;
                        } else {
                            b12 = 88;
                        }
                        break;
                    case 2464648:
                        if (!str2.equals(A05(661, 4, 60))) {
                            b12 = -1;
                        } else {
                            b12 = 90;
                        }
                        break;
                    case 2689555:
                        if (!str2.equals(A05(835, 4, 13))) {
                            b12 = -1;
                        } else {
                            b12 = 114;
                        }
                        break;
                    case 3351335:
                        if (!str2.equals(A05(1090, 4, 89))) {
                            b12 = -1;
                        } else {
                            b12 = 65;
                        }
                        break;
                    case 3386211:
                        if (!str2.equals(A05(1114, 4, 102))) {
                            b12 = -1;
                        } else {
                            b12 = 72;
                        }
                        break;
                    case 41325051:
                        if (!str2.equals(A05(511, 8, 42))) {
                            b12 = -1;
                        } else {
                            b12 = Utf8.REPLACEMENT_BYTE;
                        }
                        break;
                    case 55178625:
                        if (!str2.equals(A05(92, 11, 72))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.VT;
                        }
                        break;
                    case 61542055:
                        if (!str2.equals(A05(19, 5, 116))) {
                            b12 = -1;
                        } else {
                            b12 = 4;
                        }
                        break;
                    case 65355429:
                        if (!str2.equals(A05(205, 5, 19))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.SYN;
                        }
                        break;
                    case 66214468:
                        if (!str2.equals(A05(263, 5, 1))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.FS;
                        }
                        break;
                    case 66214470:
                        if (!str2.equals(A05(268, 5, 52))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.GS;
                        }
                        break;
                    case 66214473:
                        if (!str2.equals(A05(273, 5, 20))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.RS;
                        }
                        break;
                    case 66215429:
                        if (!str2.equals(A05(278, 5, 96))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.US;
                        }
                        break;
                    case 66215431:
                        if (!str2.equals(A05(283, 5, 95))) {
                            b12 = -1;
                        } else {
                            b12 = 32;
                        }
                        break;
                    case 66215433:
                        if (!str2.equals(A05(288, 5, 69))) {
                            b12 = -1;
                        } else {
                            b12 = 33;
                        }
                        break;
                    case 66216390:
                        if (!str2.equals(A05(293, 5, 1))) {
                            b12 = -1;
                        } else {
                            b12 = 34;
                        }
                        break;
                    case 76402249:
                        if (!str2.equals(A05(618, 5, 117))) {
                            b12 = -1;
                        } else {
                            b12 = 87;
                        }
                        break;
                    case 76404105:
                        if (!str2.equals(A05(656, 5, 101))) {
                            b12 = -1;
                        } else {
                            b12 = 89;
                        }
                        break;
                    case 76404911:
                        if (!str2.equals(A05(665, 5, 112))) {
                            b12 = -1;
                        } else {
                            b12 = 91;
                        }
                        break;
                    case 80963634:
                        if (!str2.equals(A05(823, 5, 79))) {
                            b12 = -1;
                        } else {
                            b12 = 106;
                        }
                        break;
                    case 82882791:
                        if (!str2.equals(A05(830, 5, 45))) {
                            b12 = -1;
                        } else {
                            b12 = 113;
                        }
                        break;
                    case 102844228:
                        if (!str2.equals(A05(1035, 5, 90))) {
                            b12 = -1;
                        } else {
                            b12 = 58;
                        }
                        break;
                    case 165221241:
                        if (!str2.equals(A05(24, 8, 102))) {
                            b12 = -1;
                        } else {
                            b12 = 5;
                        }
                        break;
                    case 182191441:
                        if (!str2.equals(A05(155, 9, 79))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.DC2;
                        }
                        break;
                    case 245388979:
                        if (!str2.equals(A05(1047, 8, 79))) {
                            b12 = -1;
                        } else {
                            b12 = 62;
                        }
                        break;
                    case 287431619:
                        if (!str2.equals(A05(964, 7, 64))) {
                            b12 = -1;
                        } else {
                            b12 = 45;
                        }
                        break;
                    case 307593612:
                        if (!str2.equals(A05(48, 8, 88))) {
                            b12 = -1;
                        } else {
                            b12 = 8;
                        }
                        break;
                    case 308517133:
                        if (!str2.equals(A05(56, 8, 88))) {
                            b12 = -1;
                        } else {
                            b12 = 9;
                        }
                        break;
                    case 316215098:
                        if (!str2.equals(A05(744, 8, 102))) {
                            b12 = -1;
                        } else {
                            b12 = 100;
                        }
                        break;
                    case 316215116:
                        if (!str2.equals(A05(752, 8, 12))) {
                            b12 = -1;
                        } else {
                            b12 = 101;
                        }
                        break;
                    case 316246811:
                        if (!str2.equals(A05(760, 8, 62))) {
                            b12 = -1;
                        } else {
                            b12 = 102;
                        }
                        break;
                    case 316246818:
                        if (!str2.equals(A05(768, 8, 73))) {
                            b12 = -1;
                        } else {
                            b12 = 103;
                        }
                        break;
                    case 407160593:
                        if (!str2.equals(A05(641, 11, 36))) {
                            b12 = -1;
                        } else {
                            b12 = 85;
                        }
                        break;
                    case 507412548:
                        if (!str2.equals(A05(672, 8, 89))) {
                            b12 = -1;
                        } else {
                            b12 = 93;
                        }
                        break;
                    case 793982701:
                        if (!str2.equals(A05(383, 14, 74))) {
                            b12 = -1;
                        } else {
                            b12 = 42;
                        }
                        break;
                    case 794038622:
                        if (!str2.equals(A05(397, 14, 97))) {
                            b12 = -1;
                        } else {
                            b12 = 43;
                        }
                        break;
                    case 794040393:
                        if (!str2.equals(A05(TTAdConstant.IMAGE_CODE, 14, 36))) {
                            b12 = -1;
                        } else {
                            b12 = 44;
                        }
                        break;
                    case 835649806:
                        if (!str2.equals(A05(1040, 7, 3))) {
                            b12 = -1;
                        } else {
                            b12 = 61;
                        }
                        break;
                    case 917340916:
                        if (!str2.equals(A05(39, 9, 41))) {
                            b12 = -1;
                        } else {
                            b12 = 7;
                        }
                        break;
                    case 958008161:
                        if (!str2.equals(A05(1026, 9, 115))) {
                            b12 = -1;
                        } else {
                            b12 = 55;
                        }
                        break;
                    case 1060579533:
                        if (!str2.equals(A05(1118, 8, 17))) {
                            b12 = -1;
                        } else {
                            b12 = 75;
                        }
                        break;
                    case 1150207623:
                        if (!str2.equals(A05(501, 7, 17))) {
                            b12 = -1;
                        } else {
                            b12 = 59;
                        }
                        break;
                    case 1176899427:
                        if (!str2.equals(A05(PointerIconCompat.TYPE_ZOOM_IN, 8, 61))) {
                            b12 = -1;
                        } else {
                            b12 = 54;
                        }
                        break;
                    case 1280332038:
                        if (!str2.equals(A05(991, 7, 10))) {
                            b12 = -1;
                        } else {
                            b12 = 47;
                        }
                        break;
                    case 1306947716:
                        if (!str2.equals(A05(253, 10, 95))) {
                            b12 = -1;
                        }
                        break;
                    case 1349174697:
                        if (!str2.equals(A05(977, 14, 7))) {
                            b12 = -1;
                        } else {
                            b12 = 46;
                        }
                        break;
                    case 1522194893:
                        if (!str2.equals(A05(1364, 7, 33))) {
                            b12 = -1;
                        } else {
                            b12 = 111;
                        }
                        break;
                    case 1691543273:
                        if (!str2.equals(A05(148, 7, 125))) {
                            b12 = -1;
                        } else {
                            b12 = 17;
                        }
                        break;
                    case 1709443163:
                        if (!str2.equals(A05(998, 14, 72))) {
                            b12 = -1;
                        } else {
                            b12 = 51;
                        }
                        break;
                    case 1865889110:
                        if (!str2.equals(A05(1204, 7, 107))) {
                            b12 = -1;
                        } else {
                            b12 = 95;
                        }
                        break;
                    case 1906253259:
                        if (!str2.equals(A05(589, 8, 59))) {
                            b12 = -1;
                        } else {
                            b12 = 79;
                        }
                        break;
                    case 1977196784:
                        if (!str2.equals(A05(474, 12, Worker.WHAT_SYNC_DATA))) {
                            b12 = -1;
                        } else {
                            b12 = 52;
                        }
                        break;
                    case 2029784656:
                        if (!str2.equals(A05(453, 7, 61))) {
                            b12 = -1;
                        } else {
                            b12 = 48;
                        }
                        break;
                    case 2030379515:
                        if (!str2.equals(A05(460, 7, 112))) {
                            b12 = -1;
                        } else {
                            b12 = 49;
                        }
                        break;
                    case 2047190025:
                        if (!str2.equals(A05(222, 10, 96))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.CAN;
                        }
                        break;
                    case 2047252157:
                        if (!str2.equals(A05(232, 10, 55))) {
                            b12 = -1;
                        } else {
                            b12 = Ascii.EM;
                        }
                        break;
                    case 2048319463:
                        if (!str2.equals(A05(467, 7, 24))) {
                            b12 = -1;
                        } else {
                            b12 = 50;
                        }
                        break;
                    default:
                        b12 = -1;
                        break;
                }
                switch (b12) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    case 30:
                    case VungleException.WEB_CRASH /* 31 */:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    case 66:
                    case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case ModuleDescriptor.MODULE_VERSION /* 86 */:
                    case 87:
                    case 88:
                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case Worker.WHAT_SYNC_DATA /* 103 */:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case Worker.WHAT_QUIT /* 110 */:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                        A0b = true;
                        break;
                }
                String str3 = IF.A06;
                switch (str3.hashCode()) {
                    case 2006354:
                        if (!str3.equals(A05(64, 4, 73))) {
                            b11 = -1;
                        }
                        break;
                    case 2006367:
                        if (!str3.equals(A05(68, 4, 74))) {
                            b11 = -1;
                        } else {
                            b11 = 1;
                        }
                        break;
                    default:
                        b11 = -1;
                        break;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        A0b = true;
                        break;
                }
                A0c = true;
            }
        }
        return A0b;
    }

    public static boolean A0V(boolean z11, Format format, Format format2) {
        return format.A0O.equals(format2.A0O) && format.A0B == format2.A0B && (z11 || (format.A0F == format2.A0F && format.A08 == format2.A08)) && IF.A0g(format.A0J, format2.A0J);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A13() {
        super.A13();
        this.A09 = 0;
        this.A0H = SystemClock.elapsedRealtime();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A14() {
        this.A0J = C.TIME_UNSET;
        A08();
        super.A14();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A15() {
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0M = C.TIME_UNSET;
        this.A0K = C.TIME_UNSET;
        this.A0A = 0;
        A07();
        A06();
        this.A0W.A08();
        this.A00 = null;
        this.A0S = false;
        try {
            super.A15();
        } finally {
            super.A0U.A00();
            this.A0X.A05(super.A0U);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A16(long j11, boolean z11) throws C11669c {
        super.A16(j11, z11);
        A06();
        this.A0I = C.TIME_UNSET;
        this.A05 = 0;
        this.A0K = C.TIME_UNSET;
        int i11 = this.A0A;
        if (i11 != 0) {
            this.A0M = this.A0Z[i11 - 1];
            this.A0A = 0;
        }
        if (z11) {
            A0C();
        } else {
            this.A0J = C.TIME_UNSET;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A17(boolean z11) throws C11669c {
        super.A17(z11);
        int i11 = A12().A00;
        this.A0G = i11;
        this.A0S = i11 != 0;
        this.A0X.A06(super.A0U);
        this.A0W.A09();
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public final void A18(Format[] formatArr, long j11) throws C11669c {
        if (this.A0M == C.TIME_UNSET) {
            this.A0M = j11;
        } else {
            int i11 = this.A0A;
            if (i11 == this.A0Z.length) {
                Log.w(A05(522, 23, 33), A05(776, 45, 2) + this.A0Z[this.A0A - 1]);
            } else {
                int i12 = i11 + 1;
                String[] strArr = A0e;
                if (strArr[1].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A0e[4] = "ShVF99lXvOUYr05H2Tvsc9mrs3vvqIZt";
                this.A0A = i12;
            }
            long[] jArr = this.A0Z;
            int i13 = this.A0A;
            jArr[i13 - 1] = j11;
            this.A0a[i13 - 1] = this.A0K;
        }
        super.A18(formatArr, j11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final int A1B(MediaCodec mediaCodec, DG dg2, Format format, Format format2) {
        if (!A0V(dg2.A03, format, format2) || format2.A0F > this.A0P.A02 || format2.A08 > this.A0P.A00 || A00(dg2, format2) > this.A0P.A01) {
            return 0;
        }
        return format.A0K(format2) ? 1 : 3;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010e  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final int A1C(DM dm2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, Format format) throws DP {
        String str = format.A0O;
        if (!AbstractC1369Hs.A0B(str)) {
            return 0;
        }
        boolean z11 = false;
        DrmInitData drmInitData = format.A0H;
        if (drmInitData != null) {
            for (int i11 = 0; i11 < drmInitData.A01; i11++) {
                z11 |= drmInitData.A01(i11).A03;
            }
        }
        DG dgA6m = dm2.A6m(str, z11);
        boolean z12 = true;
        if (dgA6m == null) {
            if (z11) {
                DG dgA6m2 = dm2.A6m(str, false);
                if (A0e[4].charAt(25) == 'e') {
                    throw new RuntimeException();
                }
                A0e[4] = "FpKuVec84vIeJrb9OhgIMf2bfNz9gMiE";
                if (dgA6m2 != null) {
                    return 2;
                }
            }
            return 1;
        }
        if (!EM.A0y(interfaceC1217Bc, drmInitData)) {
            return 2;
        }
        boolean zA0I = dgA6m.A0I(format.A0K);
        if (zA0I && format.A0F > 0 && format.A08 > 0) {
            if (IF.A02 >= 21) {
                zA0I = dgA6m.A0H(format.A0F, format.A08, format.A01);
            } else {
                int i12 = format.A0F * format.A08;
                if (A0e[3].charAt(22) != 'Z') {
                    A0e[5] = "UMjIK9RMnUz7WxxIT7tVkIDt0MZGN20Y";
                    if (i12 > DR.A00()) {
                        z12 = false;
                    }
                } else {
                    A0e[6] = "1pvxbUpXZPSG1GOfk2zj";
                    if (i12 > DR.A00()) {
                        z12 = false;
                    }
                }
                zA0I = z12;
                if (!zA0I) {
                    String str2 = A05(298, 29, 6) + format.A0F + A05(1379, 1, 98) + format.A08 + A05(856, 3, 89) + IF.A04 + A05(855, 1, 29);
                }
            }
        }
        return (dgA6m.A03 ? 16 : 8) | (dgA6m.A06 ? 32 : 0) | (zA0I ? 4 : 3);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1G() throws C11669c {
        super.A1G();
        this.A04 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1H() {
        try {
            super.A1H();
            this.A04 = 0;
            Surface surface = this.A0N;
            if (surface != null) {
                Surface surface2 = this.A0O;
                String[] strArr = A0e;
                if (strArr[1].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A0e[5] = "XHzJ2HWKwUKgXdkRP5t1s0JJnuLP0pfM";
                if (surface2 == surface) {
                    this.A0O = null;
                }
                surface.release();
                this.A0N = null;
            }
        } catch (Throwable th2) {
            this.A04 = 0;
            if (this.A0N != null) {
                Surface surface3 = this.A0O;
                Surface surface4 = this.A0N;
                if (surface3 == surface4) {
                    this.A0O = null;
                }
                surface4.release();
                this.A0N = null;
            }
            throw th2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1K(long j11) {
        this.A04--;
        while (true) {
            int i11 = this.A0A;
            if (i11 == 0) {
                return;
            }
            long j12 = this.A0a[0];
            if (A0e[4].charAt(25) == 'e') {
                throw new RuntimeException();
            }
            A0e[6] = "welnO5ckQSDvaPJP3GxM6gJ3";
            if (j11 < j12) {
                return;
            }
            long[] jArr = this.A0Z;
            this.A0M = jArr[0];
            int i12 = i11 - 1;
            this.A0A = i12;
            System.arraycopy(jArr, 1, jArr, 0, i12);
            long[] jArr2 = this.A0a;
            System.arraycopy(jArr2, 1, jArr2, 0, this.A0A);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0086  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1L(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        String strA05 = A05(903, 10, 26);
        boolean zContainsKey = mediaFormat.containsKey(strA05);
        String strA06 = A05(913, 8, 101);
        String strA07 = A05(883, 11, 39);
        String strA08 = A05(894, 9, 49);
        boolean z11 = zContainsKey && mediaFormat.containsKey(strA08) && mediaFormat.containsKey(strA07) && mediaFormat.containsKey(strA06);
        this.A08 = z11 ? (mediaFormat.getInteger(strA05) - mediaFormat.getInteger(strA08)) + 1 : mediaFormat.getInteger(A05(1359, 5, 19));
        this.A06 = z11 ? (mediaFormat.getInteger(strA07) - mediaFormat.getInteger(strA06)) + 1 : mediaFormat.getInteger(A05(971, 6, 26));
        this.A01 = this.A02;
        if (IF.A02 >= 21) {
            int i11 = this.A0B;
            if (i11 == 90) {
                int i12 = this.A08;
                this.A08 = this.A06;
                this.A06 = i12;
                this.A01 = 1.0f / this.A01;
            } else {
                if (A0e[6].length() == 11) {
                    throw new RuntimeException();
                }
                A0e[4] = "tMLsScMJVvSfEldK2kkn5FelCETUa7Eh";
                if (i11 == 270) {
                    int i13 = this.A08;
                    this.A08 = this.A06;
                    this.A06 = i13;
                    this.A01 = 1.0f / this.A01;
                }
            }
        } else {
            int i14 = this.A0B;
            if (A0e[4].charAt(25) != 'e') {
                A0e[5] = "YnEjoYuo9QDNkry4zztMBrHkotN6qawB";
                this.A07 = i14;
            } else {
                this.A07 = i14;
            }
        }
        mediaCodec.setVideoScalingMode(this.A0F);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1M(Format format) throws C11669c {
        super.A1M(format);
        this.A0X.A04(format);
        this.A02 = format.A02;
        this.A0B = format.A0B;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1N(C1773Xr c1773Xr) {
        this.A04++;
        this.A0K = Math.max(c1773Xr.A00, this.A0K);
        if (IF.A02 >= 23 || !this.A0S) {
            return;
        }
        A1S();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1O(DG dg2, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws DP {
        IP ipA04 = A04(dg2, format, A1A());
        this.A0P = ipA04;
        MediaFormat mediaFormatA03 = A03(format, ipA04, this.A0Y, this.A0G);
        if (this.A0O == null) {
            AbstractC1351Ha.A04(A0T(dg2));
            if (this.A0N == null) {
                this.A0N = DummySurface.A01(this.A0V, dg2.A05);
            }
            this.A0O = this.A0N;
        }
        mediaCodec.configure(mediaFormatA03, this.A0O, mediaCrypto, 0);
        if (IF.A02 < 23 || !this.A0S) {
            return;
        }
        this.A00 = new IQ(this, mediaCodec);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1P(String str, long j11, long j12) {
        this.A0X.A07(str, j11, j12);
        this.A0Q = A0U(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d6, code lost:
    
        if (r9 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d9, code lost:
    
        if (r9 != false) goto L45;
     */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A1Q(long j11, long j12, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i11, int i12, long j13, boolean z11) throws C11669c {
        if (this.A0I == C.TIME_UNSET) {
            this.A0I = j11;
        }
        long j14 = j13 - this.A0M;
        if (z11) {
            A0H(mediaCodec, i11, j14);
            return true;
        }
        long j15 = j13 - j11;
        if (this.A0O == this.A0N) {
            if (!A0N(j15)) {
                return false;
            }
            A0H(mediaCodec, i11, j14);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        boolean z12 = A81() == 2;
        if (!this.A0R || (z12 && A0R(j15, jElapsedRealtime - this.A0L))) {
            int i13 = IF.A02;
            if (A0e[3].charAt(22) != 'Z') {
                throw new RuntimeException();
            }
            A0e[6] = "Ps";
            if (i13 >= 21) {
                A0I(mediaCodec, i11, j14, System.nanoTime());
                return true;
            }
            A0G(mediaCodec, i11, j14);
            return true;
        }
        if (!z12 || j11 == this.A0I) {
            return false;
        }
        long jNanoTime = System.nanoTime();
        long jA07 = this.A0W.A07(j13, jNanoTime + ((j15 - (jElapsedRealtime - j12)) * 1000));
        long j16 = (jA07 - jNanoTime) / 1000;
        if (A0P(j16, j12)) {
            boolean zA0S = A0S(mediaCodec, i11, j14, j11);
            if (A0e[6].length() != 11) {
                A0e[6] = "4";
            }
        }
        if (A0Q(j16, j12)) {
            A0F(mediaCodec, i11, j14);
            return true;
        }
        if (IF.A02 >= 21) {
            if (j16 < 50000) {
                A0I(mediaCodec, i11, j14, jA07);
                return true;
            }
        } else if (j16 < 30000) {
            if (j16 > 11000) {
                try {
                    Thread.sleep((j16 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            A0G(mediaCodec, i11, j14);
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final boolean A1R(DG dg2) {
        return this.A0O != null || A0T(dg2);
    }

    public final void A1S() {
        if (this.A0R) {
            return;
        }
        this.A0R = true;
        this.A0X.A03(this.A0O);
    }

    @Override // com.facebook.ads.redexgen.uinode.EM, com.facebook.ads.redexgen.uinode.A7
    public final void A8V(int i11, Object obj) throws C11669c {
        if (i11 == 1) {
            A0L((Surface) obj);
            return;
        }
        if (i11 != 4) {
            super.A8V(i11, obj);
            return;
        }
        this.A0F = ((Integer) obj).intValue();
        MediaCodec mediaCodecA1D = A1D();
        if (mediaCodecA1D != null) {
            int i12 = this.A0F;
            if (A0e[6].length() == 11) {
                throw new RuntimeException();
            }
            A0e[4] = "ynW9njiEKJeSgaNYH6SlaayD7qz19oDR";
            mediaCodecA1D.setVideoScalingMode(i12);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r9.A0S == false) goto L20;
     */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.Y5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A9C() {
        Surface surface;
        if (super.A9C()) {
            if (!this.A0R && ((surface = this.A0N) == null || this.A0O != surface)) {
                MediaCodec mediaCodecA1D = A1D();
                if (A0e[6].length() == 11) {
                    throw new RuntimeException();
                }
                A0e[6] = "3hQTJaHLIy4JZfUSwiFMMfqMh";
                if (mediaCodecA1D != null) {
                }
            }
            this.A0J = C.TIME_UNSET;
            return true;
        }
        if (this.A0J == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.A0J) {
            return true;
        }
        this.A0J = C.TIME_UNSET;
        return false;
    }
}
