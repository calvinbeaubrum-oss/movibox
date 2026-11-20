package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class OM {
    public static byte[] A00;
    public static String[] A01 = {"zHQaRI8Z04iZfuq60cOZ3MtOUQtnyLXk", "Py81lTfXTPvOohagzwztlFMwKgIeaa04", "ZBx", "ff4Sljy7OS0rEQC0yVPpTgSrr8dBXGgO", "WJ7E7dTZMlxiqC9ofw7stZL7dYzOgEyn", "lEp0yqe8iFuZgqtiF5MEL7dQIxoaDf7o", "1LQBU", "K3MGC9Pem9CSlPJADsZARPOkTW1wXgVW"};

    static {
        A02();
    }

    public static OL A00(OP op2, Bundle bundle, boolean z11) {
        OL c1658Tc;
        op2.A05().A0F().A00(false);
        C1G c1gA0x = op2.A04().A0x();
        double dA00 = OI.A00(c1gA0x);
        boolean zA0N = op2.A04().A0x().A0N();
        boolean zA06 = OI.A06(op2.A00(), op2.A01(), dA00);
        AbstractC09520h abstractC09520hA00 = C09530i.A00(op2.A05(), op2.A06(), A01(0, 0, 67), AbstractC1446Ky.A00(op2.A04().A0x().A0F().A05()), new HashMap(), op2.A04().A0y());
        boolean z12 = !TextUtils.isEmpty(c1gA0x.A0D().A08());
        if (C1384Ih.A1W(op2.A05())) {
            op2.A05().A0A().AGv(op2.A02(), op2.A04().A12(), z12);
        }
        boolean zA03 = A03(op2, z12);
        if ((zA0N && (abstractC09520hA00 instanceof C1307Fe)) || zA03) {
            c1658Tc = new TT(op2, zA03);
        } else if (z12) {
            c1658Tc = new BI(op2);
        } else if (!z12 && C1384Ih.A2A(op2.A05())) {
            c1658Tc = new BJ(op2, zA06);
        } else if (zA06) {
            int iA00 = op2.A00();
            if (A01[2].length() != 3) {
                throw new RuntimeException();
            }
            A01[6] = "JelR9";
            c1658Tc = new C1661Tf(op2, iA00 == 2);
        } else {
            c1658Tc = new C1658Tc(op2, OI.A04(dA00));
        }
        if (z11) {
            c1658Tc.A10(c1gA0x, op2.A04().A12(), dA00, bundle);
        }
        return c1658Tc;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{8, 97, 91, 8, 97, 70, 91, 92, 73, 70, 92, 8, 79, 73, 69, 77, 91, 8, 73, 68, 68, 71, 95, 77, 76, Ascii.DC2, 8, 64, 41, 19, 64, 41, Ascii.SO, 19, Ascii.DC4, 1, Ascii.SO, Ascii.DC4, 64, 7, 1, Ascii.CR, 5, 19, 90, 64, 77, 10, 2, 2, 10, 1, 8, 77, Ascii.VT, Ascii.FF, 1, 1, Ascii.SI, Ascii.FF, Ascii.SO, 6, 77, Ascii.CAN, Ascii.US, 1, 77, Ascii.FF, Ascii.ESC, Ascii.FF, 4, 1, Ascii.FF, Ascii.SI, 1, 8, 87, 77, 119, 62, 36, 4, 35, 56, 37, 50, 109, 119, 124, 108, 58, 37, 40, 41, 35, 108, 57, 62, 32, 108, 37, Utf8.REPLACEMENT_BYTE, 108, 34, 57, 32, 32, 118, 108, 94, 82, 80, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 86, 92, 73, 92, 83, 92, 74, 77, 86, 75, 92, 120, Ascii.DEL, 100, 121, 110, 84, 126, 121, 103, 84, 124, 110, 105, 84, 109, 106, 103, 103, 105, 106, 104, 96, 69, 90, 87, 86, 92, 108, 70, 65, 95};
    }

    public static boolean A03(OP op2, boolean z11) {
        boolean z12 = false;
        if (!op2.A04().A0p() || !z11) {
            return false;
        }
        Uri uriA00 = AbstractC1446Ky.A00(op2.A04().A0x().A0F().A05());
        String authority = uriA00.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            op2.A05().A0E().AAF();
            return false;
        }
        boolean zEquals = authority.equals(A01(128, 5, WebSocketProtocol.PAYLOAD_SHORT));
        boolean z13 = uriA00.getQueryParameter(A01(155, 9, 116)) == null;
        String queryParameter = uriA00.getQueryParameter(A01(133, 22, 76));
        boolean z14 = !TextUtils.isEmpty(queryParameter) && queryParameter.contains(op2.A04().A0Q());
        boolean zEquals2 = op2.A05().getPackageName().equals(A01(109, 19, 122));
        boolean zA0q = op2.A04().A0q();
        if (zEquals && z13 && z14 && (!zEquals2 || zA0q)) {
            z12 = true;
        }
        if (!z12) {
            int i11 = Build.VERSION.SDK_INT;
            if (A01[2].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "ixVJz4LKAvkUhWpfUwnrm68OXA5reQsq";
            strArr[1] = "n4hyezKFC81nHjNiPwRfUtRp762j8aVq";
            if (i11 >= 24) {
                op2.A05().A0E().AAE(A01(78, 11, 16) + zEquals + A01(89, 20, 11) + z13 + A01(46, 32, 42) + z14 + A01(27, 19, 39) + zEquals2 + A01(0, 27, 111) + zA0q);
            }
        }
        return z12;
    }
}
