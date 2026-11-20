package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1826Zt implements InterfaceC10463z {
    public final /* synthetic */ C1282Ef A00;
    public final /* synthetic */ C10423u A01;

    public C1826Zt(C1282Ef c1282Ef, C10423u c10423u) {
        this.A00 = c1282Ef;
        this.A01 = c10423u;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10463z
    public final Object A4W(int i11) {
        C10403s c10403sA00 = this.A01.A00(i11);
        if (c10403sA00 == null) {
            return null;
        }
        return c10403sA00.A0M();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10463z
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

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10463z
    public final Object A5i(int i11) {
        C10403s c10403sA01 = this.A01.A01(i11);
        if (c10403sA01 == null) {
            return null;
        }
        return c10403sA01.A0M();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10463z
    public final boolean ADx(int i11, int i12, Bundle bundle) {
        return this.A01.A04(i11, i12, bundle);
    }
}
