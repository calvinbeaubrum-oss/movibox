package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewParent;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C10303i {
    public static byte[] A00;
    public static String[] A01 = {"Xrw23x", "7zPMnydgs3TxzLPidxoXPZBjc3W6JcCM", "VSpvz3ms1TmmGNHPZhiUX8aR3VKIqH3F", "EaUoYVziD6tZiyhi6MmXXr0L0WyyrmGO", "9W1llKphA1b", "WQVWtmgxG", "pfsLxZCw3", "djLiMbltlOZxr4Y20a1py0MoB6XUOCsc"};

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[4].length() == 2) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "srEyXaBrGYJEdyGE0emXwaTG9JSL50Tx";
            strArr[3] = "2nDKISaqZLGgZgCCbZWXnJ7EV4EzVcvR";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 63);
            i14++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-65, -66, -98, -75, -61, -60, -75, -76, -106, -68, -71, -66, -73, -59, -60, -92, -69, -55, -54, -69, -70, -90, -56, -69, -100, -62, -65, -60, -67, Ascii.SUB, Ascii.EM, -7, Ascii.DLE, Ascii.RS, Ascii.US, Ascii.DLE, Ascii.SI, -5, Ascii.GS, Ascii.DLE, -2, Ascii.SO, Ascii.GS, Ascii.SUB, Ascii.ETB, Ascii.ETB, -26, -27, -59, -36, -22, -21, -36, -37, -54, -38, -23, -26, -29, -29, Ascii.FS, Ascii.ESC, -5, Ascii.DC2, 32, 33, Ascii.DC2, 17, 0, Ascii.DLE, Ascii.US, Ascii.FS, Ascii.EM, Ascii.EM, -18, Ascii.DLE, Ascii.DLE, Ascii.DC2, Ascii.GS, 33, Ascii.DC2, 17, -50, -51, -78, -45, -64, -47, -45, -83, -60, -46, -45, -60, -61, -78, -62, -47, -50, -53, -53, 45, 44, 17, 50, 45, 46, Ascii.FF, 35, 49, 50, 35, 34, 17, 33, 48, 45, 42, 42};
    }

    public void A03(ViewParent viewParent, View view) {
        if (0 != 0) {
            throw new NullPointerException(A00(101, 18, 127));
        }
    }

    public void A04(ViewParent viewParent, View view, int i11, int i12, int i13, int i14) {
        if (0 != 0) {
            throw new NullPointerException(A00(46, 14, 56));
        }
    }

    public void A05(ViewParent viewParent, View view, int i11, int i12, int[] iArr) {
        if (0 != 0) {
            throw new NullPointerException(A00(29, 17, 108));
        }
    }

    public void A06(ViewParent viewParent, View view, View view2, int i11) {
        if (0 != 0) {
            throw new NullPointerException(A00(60, 22, Worker.WHAT_QUIT));
        }
    }

    public boolean A07(ViewParent viewParent, View view, float f11, float f12) {
        if (0 != 0) {
            throw new NullPointerException(A00(13, 16, 23));
        }
        String[] strArr = A01;
        if (strArr[1].charAt(19) != strArr[3].charAt(19)) {
            throw new RuntimeException();
        }
        A01[2] = "2JlvdJxfzc676EJF51BR6DiplsSASM3N";
        return false;
    }

    public boolean A08(ViewParent viewParent, View view, float f11, float f12, boolean z11) {
        if (0 != 0) {
            throw new NullPointerException(A00(0, 13, 17));
        }
        return false;
    }

    public boolean A09(ViewParent viewParent, View view, View view2, int i11) {
        if (0 != 0) {
            throw new NullPointerException(A00(82, 19, 32));
        }
        return false;
    }
}
