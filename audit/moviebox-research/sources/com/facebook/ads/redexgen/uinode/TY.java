package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TY implements NS {
    public static byte[] A01;
    public static String[] A02 = {"BdhBL09M4Kf5pZVFq3hu", "RvApnOP5TrfSVKNiPYUqrJes", "fe7XFV8kXqba2R6pM5eLN8KkTFIqEiwl", "blbqgiQJp6cs", "NwOGI73VJjSa3U5NpZL78Ksqq7LFe", "B8ngslNEnR5wDlhREJljtiUu", "QAhn6ShnFRB2OsCPxSM", "0DHDykPyyqwhMMlodysb3VmSPsGurPgY"};
    public final /* synthetic */ TT A00;

    static {
        A01();
    }

    public TY(TT tt2) {
        this.A00 = tt2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{76, 74, 92, 75, 102, 87, 88, 79, 80, 94, 88, 77, 80, 86, 87, 102, 80, 88, 91};
    }

    @Override // com.facebook.ads.redexgen.uinode.NS
    public final void ACT(String str) {
        this.A00.A0U = false;
        this.A00.A0I.setProgress(100);
        AbstractC1462Lo.A0N(this.A00.A0I, 8);
        if (!this.A00.A0G.A0n() || this.A00.A0J == null) {
            return;
        }
        String strA0R = this.A00.A0G.A0R();
        if (TextUtils.isEmpty(strA0R)) {
            return;
        }
        this.A00.A0J.loadUrl(strA0R);
    }

    @Override // com.facebook.ads.redexgen.uinode.NS
    public final void ACV(String str) {
        this.A00.A0U = true;
        AbstractC1462Lo.A0N(this.A00.A0I, 0);
        this.A00.A0H.setUrl(str);
        if (!this.A00.A0T && this.A00.A01 > 1) {
            this.A00.A0T = true;
            this.A00.A0f(A00(0, 19, 51));
        }
        TT.A03(this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.NS
    public final void ACn(int i11) {
        if (this.A00.A0U) {
            NK nk2 = this.A00.A0I;
            String[] strArr = A02;
            if (strArr[6].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "QY4HeEjZ5INYif1SeRyocKWTC9N0iQjQ";
            strArr2[7] = "IhWprrJJT2Yl4c8tLv2o4taD3peu2qkx";
            nk2.setProgress(i11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.NS
    public final void ACq(String str) {
        this.A00.A0H.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.NS
    public final void ACs() {
        this.A00.A0L.A09().AB0(14);
    }
}
