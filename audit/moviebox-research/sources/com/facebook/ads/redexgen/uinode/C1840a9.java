package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.res.ColorStateList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1840a9 implements InterfaceC10022g {
    private C10032h A00(InterfaceC10012f interfaceC10012f) {
        return (C10032h) interfaceC10012f.A6J();
    }

    public final void A01(InterfaceC10012f interfaceC10012f) {
        if (!interfaceC10012f.A8G()) {
            interfaceC10012f.AGE(0, 0, 0, 0);
            return;
        }
        float fA7M = A7M(interfaceC10012f);
        float fA7m = A7m(interfaceC10012f);
        int iCeil = (int) Math.ceil(C10052j.A00(fA7M, fA7m, interfaceC10012f.A7l()));
        int iCeil2 = (int) Math.ceil(C10052j.A01(fA7M, fA7m, interfaceC10012f.A7l()));
        interfaceC10012f.AGE(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final ColorStateList A66(InterfaceC10012f interfaceC10012f) {
        return A00(interfaceC10012f).A05();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A6t(InterfaceC10012f interfaceC10012f) {
        return interfaceC10012f.A6K().getElevation();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7M(InterfaceC10012f interfaceC10012f) {
        return A00(interfaceC10012f).A03();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7R(InterfaceC10012f interfaceC10012f) {
        return A7m(interfaceC10012f) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7S(InterfaceC10012f interfaceC10012f) {
        return A7m(interfaceC10012f) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7m(InterfaceC10012f interfaceC10012f) {
        return A00(interfaceC10012f).A04();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void A8r() {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void A8s(InterfaceC10012f interfaceC10012f, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        interfaceC10012f.AFu(new C10032h(colorStateList, f11));
        AbstractC10002e abstractC10002eA6K = interfaceC10012f.A6K();
        abstractC10002eA6K.setClipToOutline(true);
        abstractC10002eA6K.setElevation(f12);
        AG6(interfaceC10012f, f13);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AB7(InterfaceC10012f interfaceC10012f) {
        AG6(interfaceC10012f, A7M(interfaceC10012f));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void ACk(InterfaceC10012f interfaceC10012f) {
        AG6(interfaceC10012f, A7M(interfaceC10012f));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AFt(InterfaceC10012f interfaceC10012f, ColorStateList colorStateList) {
        A00(interfaceC10012f).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AFz(InterfaceC10012f interfaceC10012f, float f11) {
        interfaceC10012f.A6K().setElevation(f11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AG6(InterfaceC10012f interfaceC10012f, float f11) {
        A00(interfaceC10012f).A07(f11, interfaceC10012f.A8G(), interfaceC10012f.A7l());
        A01(interfaceC10012f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AGC(InterfaceC10012f interfaceC10012f, float f11) {
        A00(interfaceC10012f).A06(f11);
    }
}
