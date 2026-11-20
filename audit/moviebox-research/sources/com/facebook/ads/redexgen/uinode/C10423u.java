package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10423u {
    public static final InterfaceC10413t A01;
    public final Object A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A01 = new C1282Ef();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A01 = new C1283Eg();
        } else {
            A01 = new C1825Zs();
        }
    }

    public C10423u() {
        this.A00 = A01.AAW(this);
    }

    public C10423u(Object obj) {
        this.A00 = obj;
    }

    public final C10403s A00(int i11) {
        return null;
    }

    public final C10403s A01(int i11) {
        return null;
    }

    public final Object A02() {
        return this.A00;
    }

    public final List<C10403s> A03(String str, int i11) {
        return null;
    }

    public final boolean A04(int i11, int i12, Bundle bundle) {
        return false;
    }
}
