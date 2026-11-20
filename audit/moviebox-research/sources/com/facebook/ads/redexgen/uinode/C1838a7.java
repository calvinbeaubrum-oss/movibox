package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1838a7 implements InterfaceC10022g {
    public final RectF A00 = new RectF();

    private C10052j A00(Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        return new C10052j(context.getResources(), colorStateList, f11, f12, f13);
    }

    private C10052j A01(InterfaceC10012f interfaceC10012f) {
        return (C10052j) interfaceC10012f.A6J();
    }

    public final void A02(InterfaceC10012f interfaceC10012f) {
        Rect rect = new Rect();
        A01(interfaceC10012f).A0K(rect);
        interfaceC10012f.AG7((int) Math.ceil(A7S(interfaceC10012f)), (int) Math.ceil(A7R(interfaceC10012f)));
        interfaceC10012f.AGE(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final ColorStateList A66(InterfaceC10012f interfaceC10012f) {
        return A01(interfaceC10012f).A0F();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A6t(InterfaceC10012f interfaceC10012f) {
        return A01(interfaceC10012f).A0E();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7M(InterfaceC10012f interfaceC10012f) {
        return A01(interfaceC10012f).A0B();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7R(InterfaceC10012f interfaceC10012f) {
        return A01(interfaceC10012f).A0C();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7S(InterfaceC10012f interfaceC10012f) {
        return A01(interfaceC10012f).A0D();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final float A7m(InterfaceC10012f interfaceC10012f) {
        return A01(interfaceC10012f).A0A();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public void A8r() {
        C10052j.A0G = new C1839a8(this);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void A8s(InterfaceC10012f interfaceC10012f, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        C10052j c10052jA00 = A00(context, colorStateList, f11, f12, f13);
        c10052jA00.A0L(interfaceC10012f.A7l());
        interfaceC10012f.AFu(c10052jA00);
        A02(interfaceC10012f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AB7(InterfaceC10012f interfaceC10012f) {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void ACk(InterfaceC10012f interfaceC10012f) {
        A01(interfaceC10012f).A0L(interfaceC10012f.A7l());
        A02(interfaceC10012f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AFt(InterfaceC10012f interfaceC10012f, ColorStateList colorStateList) {
        A01(interfaceC10012f).A0J(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AFz(InterfaceC10012f interfaceC10012f, float f11) {
        A01(interfaceC10012f).A0I(f11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AG6(InterfaceC10012f interfaceC10012f, float f11) {
        A01(interfaceC10012f).A0H(f11);
        A02(interfaceC10012f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10022g
    public final void AGC(InterfaceC10012f interfaceC10012f, float f11) {
        A01(interfaceC10012f).A0G(f11);
        A02(interfaceC10012f);
    }
}
