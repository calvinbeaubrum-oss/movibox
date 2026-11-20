package com.facebook.ads.redexgen.uinode;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ow, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1548Ow implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"MJZy3ru3ObFHqr", "IunSRocQz0vvNYqEQ6WXTBnuSQec0c7U", "iH4ooasOMZZ6EfnAKOxgPsEqW16lVkcC", "wQIWWSQp6aRcfY56FQGu2w3P9Sd9Rhog", "BeeZAa4D7z23VAiIiGM8IqY8zAew", "Zsw5t3FoKlBodSgf81TTJaZ87jgffbRR", "mBHzM8IKglqg77ZKWneYLvMdHmmr5BMp", "coiV8pY9OkYcSw3BWiptzGAPEmgTqyca"};
    public final /* synthetic */ B4 A00;

    static {
        A01();
    }

    public ViewOnClickListenerC1548Ow(B4 b11) {
        this.A00 = b11;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 64);
            String[] strArr = A02;
            if (strArr[3].charAt(0) == strArr[5].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[4] = "Zi88no4MMwuxGf1zzv2w2xAR9ETp";
            strArr2[0] = "yxj8C30kQopYdL";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-57, -70, -75, -74, -64};
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A09(A00(0, 5, 17));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}
