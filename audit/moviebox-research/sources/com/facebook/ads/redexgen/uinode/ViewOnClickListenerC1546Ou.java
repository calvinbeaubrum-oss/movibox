package com.facebook.ads.redexgen.uinode;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1546Ou implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"RlzIrkXQUMxOBA0f8ntZcWMgp1uQyBL3", "nfM1dm9yUJ1maOB1", "3Svkd2lvdRmofYAbs9dZJwxmjeUnr2xh", "sPY6jFiS09X65Brr28D6Svz4lO8XBbuT", "PIj7hiNW37fJivrisJGHqPiIf6kz6TA8", "QVlKdLc7hyZZsm", "AmJ5hR6WJTTjUY", "rwvyjD2ChM6DiqOHsUU0Xk1O1i7dVZAR"};
    public final /* synthetic */ B4 A00;

    static {
        A01();
    }

    public ViewOnClickListenerC1546Ou(B4 b11) {
        this.A00 = b11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A02[7] = "lANcDcBPHZozyZY8XltfLEaPbGbTaXPo";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 66);
            i14++;
        }
    }

    public static void A01() {
        A01 = new byte[]{123, 121, 106, 119, 109, 107, 125, 116, 71, 123, 121, 106, 124};
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A09(A00(0, 13, 90));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
