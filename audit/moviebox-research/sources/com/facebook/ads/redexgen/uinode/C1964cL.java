package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1964cL {
    public final InterfaceC1968cP A00;
    public final String A01;
    public final Collection<C1978ca> A02;
    public final Collection<C1978ca> A03;
    public final List<Rect> A04;

    public C1964cL(String str, InterfaceC1968cP interfaceC1968cP, List<Rect> list, Collection<C1978ca> collection, Collection<C1978ca> collection2) {
        this.A01 = str;
        this.A00 = interfaceC1968cP;
        this.A04 = new ArrayList(list);
        this.A02 = collection;
        this.A03 = collection2;
    }
}
