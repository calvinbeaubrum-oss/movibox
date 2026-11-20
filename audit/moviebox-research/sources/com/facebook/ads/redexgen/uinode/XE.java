package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XE extends AbstractC1252Co {
    public static byte[] A01;
    public static String[] A02 = {"sf1snlIsJ6W0T2FnClxHrZdECoWprGfm", "N", "", "r2HEyqcTBk5ynLpIwHNeKGT5pvsr0hUz", "VJBF4MChRorpvGWaO0TH3IkbIinT6ci", "gVX", "V2gxFGplaBAwDTpDKBzIrO8nmlXbG3Ru", "XRqJkaMKHgiwUJro7qWKl9bCL3sckU6K"};
    public static final int A03;
    public static final byte[] A04;
    public boolean A00;

    static {
        A02();
        A03 = IF.A08(A01(0, 4, 111));
        A04 = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
    }

    private long A00(byte[] bArr) {
        int i11;
        int i12;
        int i13 = bArr[0] & 255;
        switch (i13 & 3) {
            case 0:
                i11 = 1;
                break;
            case 1:
            case 2:
                i11 = 2;
                break;
            default:
                i11 = bArr[1] & Utf8.REPLACEMENT_BYTE;
                break;
        }
        int i14 = i13 >> 3;
        int i15 = i14 & 3;
        if (i14 >= 16) {
            if (A02[5].length() != 3) {
                throw new RuntimeException();
            }
            A02[5] = "Fg3";
            i12 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i15;
        } else if (i14 >= 12) {
            i12 = 10000 << (i15 & 1);
        } else {
            if (A02[2].length() == 12) {
                throw new RuntimeException();
            }
            A02[2] = "pnsJXiCpejNcXc3iNsNdzofu9hZ";
            i12 = i15 == 3 ? 60000 : 10000 << i15;
        }
        return ((long) i11) * ((long) i12);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{42, Ascii.NAK, Ascii.DLE, Ascii.SYN, 79, 91, 74, 71, 65, 1, 65, 94, 91, 93};
    }

    private void A03(List<byte[]> list, int i11) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i11) * C.NANOS_PER_SECOND) / 48000).array());
    }

    public static boolean A04(C1376Hz c1376Hz) {
        int iA04 = c1376Hz.A04();
        byte[] bArr = A04;
        if (iA04 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        c1376Hz.A0c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final long A07(C1376Hz c1376Hz) {
        return A04(A00(c1376Hz.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final void A09(boolean z11) {
        super.A09(z11);
        if (z11) {
            this.A00 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final boolean A0A(C1376Hz c1376Hz, long j11, C1251Cn c1251Cn) throws InterruptedException, IOException {
        if (this.A00) {
            boolean z11 = c1376Hz.A08() == A03;
            c1376Hz.A0Y(0);
            return z11;
        }
        byte[] bArrCopyOf = Arrays.copyOf(c1376Hz.A00, c1376Hz.A07());
        int i11 = bArrCopyOf[9] & 255;
        int i12 = ((bArrCopyOf[11] & 255) << 8) | (bArrCopyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArrCopyOf);
        A03(arrayList, i12);
        A03(arrayList, 3840);
        c1251Cn.A00 = Format.A07(null, A01(4, 10, 36), null, -1, -1, i11, 48000, arrayList, null, 0, null);
        this.A00 = true;
        return true;
    }
}
