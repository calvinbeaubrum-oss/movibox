package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class UE implements InterfaceC1576Py {
    public static byte[] A01;
    public final /* synthetic */ UD A00;

    static {
        A01();
    }

    public UE(UD ud2) {
        this.A00 = ud2;
    }

    public /* synthetic */ UE(UD ud2, UK uk2) {
        this(ud2);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.GS, Ascii.ESC, Ascii.CR, Ascii.SUB, Ascii.VT, 4, 1, Ascii.VT, 3};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1576Py
    public final void ABD() {
        this.A00.A0U(true, A00(0, 9, 55));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1576Py
    public final void ABj() {
        if (!TextUtils.isEmpty(this.A00.A0F.A12())) {
            this.A00.A0J.A9g(this.A00.A0F.A12(), new C1508Ni().A03(this.A00.A07.getViewabilityChecker()).A02(this.A00.A07.getTouchDataRecorder()).A05());
            C1U.A07(this.A00.A0F.A0y(), this.A00.A0I);
            C2O.A00(this.A00.A0F.A0N());
            this.A00.A0I.A0E().A2k();
        }
        this.A00.A0N.A43(this.A00.A0O.A7B());
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1576Py
    public final void AC4() {
        this.A00.A0N.A43(this.A00.A0O.A6y());
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1576Py
    public final void ADj() {
        this.A00.A0N.AB0(15);
    }
}
