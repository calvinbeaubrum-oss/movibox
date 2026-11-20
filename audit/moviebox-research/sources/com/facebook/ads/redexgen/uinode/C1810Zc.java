package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1810Zc extends AnonymousClass37 {
    public static String[] A01 = {"Aypyv0FACfsPQTq8B8UFxLSJIGYFzsCC", "O7nTze5knL3NcSr2rovnk7vqxWhLtUKF", "w8KDuB7m9FBYOy6hiJzio9ilRX5MSLSp", "Kqe5H6YPSeJrA9PRZ2BXFN4qonyjjTB9", "VPpNE9vsyh3HxU94PoFE47DnBqUfoC5Y", "VSW3ZMLcugYKNhiURlJ0g5uJ7Smp29SS", "AB", "JpT6Sbfy0irMNtnKFHDBnJ8tZotKHb"};
    public final C1809Zb A00;

    public C1810Zc(C1809Zb c1809Zb) {
        this.A00 = c1809Zb;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass37
    public final void A08(View view, C10403s c10403s) {
        super.A08(view, c10403s);
        if (this.A00.A0B() || this.A00.A01.getLayoutManager() == null) {
            return;
        }
        this.A00.A01.getLayoutManager().A1C(view, c10403s);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass37
    public final boolean A09(View view, int i11, Bundle bundle) {
        if (super.A09(view, i11, bundle)) {
            if (A01[2].charAt(3) == 'j') {
                throw new RuntimeException();
            }
            A01[6] = "SRS22nAnXgHfwC2qheyHP9Kgc2YZ";
            return true;
        }
        if (this.A00.A0B() || this.A00.A01.getLayoutManager() == null) {
            return false;
        }
        return this.A00.A01.getLayoutManager().A1X(view, i11, bundle);
    }
}
