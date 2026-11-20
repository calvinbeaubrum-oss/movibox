package com.facebook.ads.redexgen.uinode;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10745c {
    public static C0S A00(Context context, InterfaceC11247h interfaceC11247h) {
        return A01(context, interfaceC11247h, null);
    }

    public static C0S A01(Context context, InterfaceC11247h interfaceC11247h, String str) {
        C0W c0wA77 = interfaceC11247h.A77(A09(context));
        if (c0wA77 != null) {
            return str != null ? c0wA77.AAJ(str) : c0wA77.AAI();
        }
        return new C1930bb();
    }

    public static C1795Yn A02(Activity activity) {
        return new C1795Yn(activity, (InterfaceC11247h) A0A(), A00(activity, A0A()));
    }

    public static C1795Yn A03(Context context) {
        return new C1795Yn(context, A0A(), new C1930bb());
    }

    public static C1795Yn A04(Context context) {
        return C1384Ih.A0r(context) ? new C1795Yn(context, A0A(), A00(context, A0A())) : A03(context);
    }

    public static C1795Yn A05(Context context, String str) {
        return new C1795Yn(context, A0A(), A01(context, A0A(), str));
    }

    public static C1795Yn A06(Context context, String str) {
        return new C1795Yn(context, A0A(), A01(context, A0A(), str));
    }

    public static C1795Yn A07(Context context, String str) {
        return new C1795Yn(context, A0A(), A01(context, A0A(), str));
    }

    public static EQ A08(Context context) {
        return new EQ(context, A0A(), A0A().A77(A09(context)));
    }

    public static C1794Ym A09(Context context) {
        return new C1794Ym(context, A0A());
    }

    public static synchronized YL A0A() {
        return YL.A02();
    }
}
