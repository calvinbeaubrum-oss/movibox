package com.facebook.ads.redexgen.uinode;

import android.app.Activity;
import android.app.KeyguardManager;
import android.util.Log;
import android.view.Window;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M6 {
    public static byte[] A00;
    public static String[] A01 = {"75", "", "84T1cPcVhFaG3gZ5iFCuz5VGfvW435Ys", "hmgtvPST3LKdfFpjmmFZYvFoyIGtsiKE", "1o0hQSlG2MREJWQYXtVsar2Zo68mKpVL", "LjPyS32kIH6YipP2gsYrsbvo7R8K", "pRhgJcRZc8j2ATnbWVmWTgInp0JNCNsL", "EpPf5pm3Rz1UtI6LaI9QQC8GFK2ymH0S"};
    public static final String A02;

    static {
        A02();
        A02 = M6.class.getSimpleName();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static Map<String, String> A01(C1795Yn c1795Yn) {
        Window window;
        HashMap map = new HashMap();
        if (c1795Yn == null) {
            return map;
        }
        try {
            map.put(A00(40, 3, 111), String.valueOf(A04(c1795Yn)));
            Activity activityA0D = c1795Yn.A0D();
            if (activityA0D != null && (window = activityA0D.getWindow()) != null) {
                int i11 = window.getAttributes().flags;
                map.put(A00(58, 2, 94), Integer.toString(window.getAttributes().type));
                int i12 = 4194304 & i11;
                String strA00 = A00(1, 1, Worker.WHAT_QUIT);
                String strA01 = A00(0, 1, 8);
                map.put(A00(48, 5, 14), i12 > 0 ? strA00 : strA01);
                if (A01[1].length() == 23) {
                    throw new RuntimeException();
                }
                A01[7] = "fwmMHJhcrVWyeAGw8Re8ymmckApbJBDL";
                if ((524288 & i11) <= 0) {
                    strA00 = strA01;
                }
                map.put(A00(53, 5, 18), strA00);
            }
        } catch (Exception e11) {
            Log.e(A02, A00(2, 30, 72), e11);
            c1795Yn.A07().A9a(A00(43, 5, 114), C8A.A2T, new C8B(e11));
        }
        return map;
    }

    public static void A02() {
        A00 = new byte[]{75, 44, 126, 67, 88, 94, 75, 79, 82, 84, 85, Ascii.ESC, 82, 85, Ascii.ESC, 76, 82, 85, 95, 84, 76, Ascii.ESC, 82, 85, 93, 84, Ascii.ESC, 88, 83, 94, 88, 80, Ascii.FS, Ascii.DC2, Ascii.SO, Ascii.DLE, 2, Ascii.SYN, 5, 19, 119, 123, 110, 115, 104, 114, 106, 120, 10, Ascii.ESC, Ascii.EM, Ascii.SYN, Ascii.SUB, Ascii.SYN, 7, Ascii.DC2, Ascii.SYN, Ascii.CR, 90, 89};
    }

    public static boolean A03(C1795Yn c1795Yn) {
        return !C1463Lp.A04(A01(c1795Yn));
    }

    public static boolean A04(C1795Yn c1795Yn) {
        KeyguardManager keyguardManager = (KeyguardManager) c1795Yn.getSystemService(A00(32, 8, 4));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }
}
