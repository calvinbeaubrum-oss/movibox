package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1827Zu implements InterfaceC10443w {
    public final /* synthetic */ C1283Eg A00;
    public final /* synthetic */ C10423u A01;

    public C1827Zu(C1283Eg c1283Eg, C10423u c10423u) {
        this.A00 = c1283Eg;
        this.A01 = c10423u;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10443w
    public final Object A4W(int i11) {
        C10403s c10403sA00 = this.A01.A00(i11);
        if (c10403sA00 == null) {
            return null;
        }
        return c10403sA00.A0M();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10443w
    public final List<Object> A5h(String str, int i11) {
        List<C10403s> listA03 = this.A01.A03(str, i11);
        if (listA03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = listA03.size();
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(listA03.get(i12).A0M());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10443w
    public final boolean ADx(int i11, int i12, Bundle bundle) {
        return this.A01.A04(i11, i12, bundle);
    }
}
