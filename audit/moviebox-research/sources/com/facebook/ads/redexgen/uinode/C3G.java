package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3G extends AbstractC11066j implements InterfaceC1367Hq {
    public static byte[] A0E;
    public static String[] A0F = {"2QlMa6qwn7PgdSN4l85jvs7nWajl1MES", "7IDLWOxlh1sFSIB31zRzFYQ7PMnWp72Y", "sIqK", "BoflpFUQeBwwM6pd17Qd", "rQg4TubfQMsXj8fsx3Kc9qFAo71Wl6cI", "0mBM", "Xb0wUTlMwSXhcbJOEuklFsawZUYnk", "6gVYRFlBQUgMJoz7eJC1LBuasB8Ybt5d"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaFormat A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final Context A0B;
    public final C1197Ai A0C;
    public final InterfaceC1203Ao A0D;

    static {
        A06();
    }

    public C3G(Context context, DM dm2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, boolean z11, Handler handler, InterfaceC1198Aj interfaceC1198Aj, AU au2, InterfaceC1190Ab... interfaceC1190AbArr) {
        this(context, dm2, interfaceC1217Bc, z11, handler, interfaceC1198Aj, new C1780Xy(au2, interfaceC1190AbArr));
    }

    public C3G(Context context, DM dm2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, boolean z11, Handler handler, InterfaceC1198Aj interfaceC1198Aj, InterfaceC1203Ao interfaceC1203Ao) {
        super(1, dm2, interfaceC1217Bc, z11);
        this.A0B = context.getApplicationContext();
        this.A0D = interfaceC1203Ao;
        this.A0C = new C1197Ai(handler, interfaceC1198Aj);
        interfaceC1203Ao.AG4(new C1778Xw(this));
    }

    private int A00(DG dg2, Format format) {
        PackageManager packageManager;
        if (IF.A02 < 24 && A04(15, 22, 10).equals(dg2.A02)) {
            boolean z11 = true;
            if (IF.A02 == 23 && (packageManager = this.A0B.getPackageManager()) != null && packageManager.hasSystemFeature(A04(37, 25, 77))) {
                z11 = false;
            }
            if (z11) {
                return -1;
            }
        }
        return format.A09;
    }

    private final int A01(DG dg2, Format format, Format[] formatArr) {
        return A00(dg2, format);
    }

    private final MediaFormat A02(Format format, String str, int i11) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A04(113, 4, 45), str);
        mediaFormat.setInteger(A04(71, 13, 29), format.A05);
        mediaFormat.setInteger(A04(125, 11, 77), format.A0C);
        DS.A06(mediaFormat, format.A0P);
        DS.A04(mediaFormat, A04(99, 14, 124), i11);
        if (IF.A02 >= 23) {
            mediaFormat.setInteger(A04(117, 8, 28), 0);
        }
        return mediaFormat;
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    private void A05() {
        long jA6e = this.A0D.A6e(A91());
        if (jA6e != Long.MIN_VALUE) {
            if (!this.A08) {
                jA6e = Math.max(this.A05, jA6e);
            }
            this.A05 = jA6e;
            this.A08 = false;
        }
    }

    public static void A06() {
        A0E = new byte[]{37, 39, 50, 68, 57, 47, 41, 68, Ascii.VT, Ascii.VT, 9, 68, Ascii.SO, Ascii.SI, 9, 6, 4, 17, 103, 46, 38, 38, 46, 37, 44, 103, 59, 40, 62, 103, 45, 44, 42, 38, 45, 44, 59, 111, 96, 106, 124, 97, 103, 106, 32, 125, 97, 104, 122, 121, 111, 124, 107, 32, 98, 107, 111, 96, 108, 111, 109, 101, 108, 120, 105, 100, 98, 34, Ascii.DEL, 108, 122, 61, 54, Utf8.REPLACEMENT_BYTE, 48, 48, 59, 50, 115, 61, 49, 43, 48, 42, 59, 54, 33, 60, Utf8.REPLACEMENT_BYTE, 39, 54, Ascii.CR, 0, Ascii.ETB, 10, Ascii.DC4, 9, 17, 0, 82, 94, 71, Ascii.DC2, 86, 81, 79, 74, 75, Ascii.DC2, 76, 86, 69, 90, 3, 7, 3, Ascii.VT, 47, 45, 54, 48, 45, 54, 43, 38, 125, 111, 99, 126, 98, 107, 35, 124, 111, 122, 107, Ascii.GS, Ascii.SI, 3, Ascii.GS, Ascii.ESC, 0, 9, 72, 87, 64, 93, 84, 94, 70, 87};
    }

    public static boolean A08(String str) {
        if (IF.A02 < 24 && A04(0, 15, 41).equals(str)) {
            if (A04(136, 7, 45).equals(IF.A05)) {
                if (!IF.A03.startsWith(A04(143, 8, 113)) && !IF.A03.startsWith(A04(84, 7, 16))) {
                    boolean zStartsWith = IF.A03.startsWith(A04(91, 8, 38));
                    if (A0F[0].charAt(11) == 'E') {
                        throw new RuntimeException();
                    }
                    A0F[7] = "opGrTNmI0QvRBzLgsKXfoISibxDPDheH";
                    if (zStartsWith) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean A09(String str) {
        int iA00 = AbstractC1369Hs.A00(str);
        return iA00 != 0 && this.A0D.A90(iA00);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A13() {
        super.A13();
        this.A0D.AE2();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A14() {
        A05();
        this.A0D.pause();
        super.A14();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A15() {
        try {
            this.A0D.AEV();
            try {
                super.A15();
                this.A0U.A00();
                this.A0C.A04(this.A0U);
                String[] strArr = A0F;
                if (strArr[5].length() != strArr[2].length()) {
                    throw new RuntimeException();
                }
                A0F[0] = "oD9vMZ2y7vvHJ8P8Vn8jWHJMMQFHYWzQ";
            } catch (Throwable th2) {
                this.A0U.A00();
                this.A0C.A04(this.A0U);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                super.A15();
                throw th3;
            } finally {
                this.A0U.A00();
                this.A0C.A04(this.A0U);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A16(long j11, boolean z11) throws C11669c {
        super.A16(j11, z11);
        this.A0D.reset();
        this.A05 = j11;
        this.A07 = true;
        this.A08 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.EM
    public final void A17(boolean z11) throws C11669c {
        super.A17(z11);
        this.A0C.A05(this.A0U);
        int i11 = A12().A00;
        if (i11 != 0) {
            this.A0D.A5W(i11);
        } else {
            this.A0D.A59();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final int A1B(MediaCodec mediaCodec, DG dg2, Format format, Format format2) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00bd A[PHI: r0
  0x00bd: PHI (r0v18 int) = (r0v14 int), (r0v21 int) binds: [B:61:0x00db, B:48:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d1  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final int A1C(DM dm2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, Format format) throws DP {
        int i11;
        String str = format.A0O;
        boolean z11 = false;
        if (!AbstractC1369Hs.A09(str)) {
            return 0;
        }
        int i12 = IF.A02 >= 21 ? 32 : 0;
        boolean zA0y = EM.A0y(interfaceC1217Bc, format.A0H);
        if (zA0y) {
            boolean zA09 = A09(str);
            if (A0F[0].charAt(11) == 'E') {
                throw new RuntimeException();
            }
            A0F[7] = "6sleKLNQpbvHoKVWyK7EUP7qImvC8hiJ";
            if (zA09 && dm2.A7c() != null) {
                return i12 | 8 | 4;
            }
        }
        if ((A04(62, 9, 78).equals(str) && !this.A0D.A90(format.A0A)) || !this.A0D.A90(2)) {
            return 1;
        }
        boolean z12 = false;
        DrmInitData drmInitData = format.A0H;
        if (drmInitData != null) {
            for (int i13 = 0; i13 < drmInitData.A01; i13++) {
                z12 |= drmInitData.A01(i13).A03;
            }
        }
        DG dgA6m = dm2.A6m(str, z12);
        if (dgA6m == null) {
            return (!z12 || dm2.A6m(str, false) == null) ? 1 : 2;
        }
        if (!zA0y) {
            return 2;
        }
        if (IF.A02 >= 21) {
            int i14 = format.A0C;
            if (A0F[7].charAt(27) != '3') {
                String[] strArr = A0F;
                strArr[6] = "YbsTws3ypMFNM7ai4KKw1OCVUgQ1r";
                strArr[3] = "Svs1q3oiD8cOh72XtRNv";
                i11 = -1;
                if (i14 != -1) {
                    if (dgA6m.A0G(format.A0C)) {
                    }
                }
            } else {
                i11 = -1;
                if (i14 != -1) {
                    if (dgA6m.A0G(format.A0C)) {
                    }
                }
            }
            if (format.A05 == i11 || dgA6m.A0F(format.A05)) {
                z11 = true;
            }
        } else {
            z11 = true;
        }
        return i12 | 8 | (z11 ? 4 : 3);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final DG A1F(DM dm2, Format format, boolean z11) throws DP {
        DG dgA7c;
        return (!A09(format.A0O) || (dgA7c = dm2.A7c()) == null) ? super.A1F(dm2, format, z11) : dgA7c;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1I() throws C11669c {
        try {
            this.A0D.AE3();
        } catch (C1202An e11) {
            throw C11669c.A01(e11, A0z());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1L(MediaCodec mediaCodec, MediaFormat mediaFormat) throws C11669c {
        int iA00;
        int[] iArr;
        int i11;
        MediaFormat mediaFormat2 = this.A06;
        if (mediaFormat2 != null) {
            String string = mediaFormat2.getString(A04(113, 4, 45));
            String[] strArr = A0F;
            if (strArr[5].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "rkxX";
            strArr2[2] = "9ODr";
            iA00 = AbstractC1369Hs.A00(string);
            mediaFormat = this.A06;
        } else {
            iA00 = this.A04;
        }
        int integer = mediaFormat.getInteger(A04(71, 13, 29));
        int integer2 = mediaFormat.getInteger(A04(125, 11, 77));
        if (this.A09 && integer == 6 && (i11 = this.A00) < 6) {
            iArr = new int[i11];
            for (int i12 = 0; i12 < this.A00; i12++) {
                iArr[i12] = i12;
            }
        } else {
            iArr = null;
        }
        try {
            this.A0D.A4P(iA00, integer, integer2, 0, iArr, this.A02, this.A03);
        } catch (C1199Ak e11) {
            throw C11669c.A01(e11, A0z());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1M(Format format) throws C11669c {
        super.A1M(format);
        this.A0C.A03(format);
        this.A04 = A04(62, 9, 78).equals(format.A0O) ? format.A0A : 2;
        this.A00 = format.A05;
        this.A02 = format.A06;
        this.A03 = format.A07;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1N(C1773Xr c1773Xr) {
        if (!this.A07 || c1773Xr.A03()) {
            return;
        }
        if (Math.abs(c1773Xr.A00 - this.A05) > 500000) {
            this.A05 = c1773Xr.A00;
        }
        this.A07 = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1O(DG dg2, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.A01 = A01(dg2, format, A1A());
        this.A09 = A08(dg2.A02);
        this.A0A = dg2.A04;
        MediaFormat mediaFormatA02 = A02(format, dg2.A01 == null ? A04(62, 9, 78) : dg2.A01, this.A01);
        mediaCodec.configure(mediaFormatA02, (Surface) null, mediaCrypto, 0);
        if (!this.A0A) {
            this.A06 = null;
        } else {
            this.A06 = mediaFormatA02;
            mediaFormatA02.setString(A04(113, 4, 45), format.A0O);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final void A1P(String str, long j11, long j12) {
        this.A0C.A06(str, j11, j12);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j
    public final boolean A1Q(long j11, long j12, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i11, int i12, long j13, boolean z11) throws C11669c {
        if (this.A0A && (i12 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i11, false);
            return true;
        }
        if (z11) {
            mediaCodec.releaseOutputBuffer(i11, false);
            this.A0U.A08++;
            this.A0D.A8U();
            return true;
        }
        try {
            if (!this.A0D.A8R(byteBuffer, j13)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i11, false);
            this.A0U.A06++;
            return true;
        } catch (C1200Al | C1202An e11) {
            throw C11669c.A01(e11, A0z());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.EM, com.facebook.ads.redexgen.uinode.Y5
    public final InterfaceC1367Hq A7N() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1367Hq
    public final C11869x A7h() {
        return this.A0D.A7h();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1367Hq
    public final long A7k() {
        if (A81() == 2) {
            A05();
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.uinode.EM, com.facebook.ads.redexgen.uinode.A7
    public final void A8V(int i11, Object obj) throws C11669c {
        switch (i11) {
            case 2:
                this.A0D.setVolume(((Float) obj).floatValue());
                break;
            case 3:
                this.A0D.AFs((AT) obj);
                break;
            default:
                super.A8V(i11, obj);
                break;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.Y5
    public final boolean A91() {
        return super.A91() && this.A0D.A91();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11066j, com.facebook.ads.redexgen.uinode.Y5
    public final boolean A9C() {
        return this.A0D.A8Z() || super.A9C();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1367Hq
    public final C11869x AGA(C11869x c11869x) {
        return this.A0D.AGA(c11869x);
    }
}
