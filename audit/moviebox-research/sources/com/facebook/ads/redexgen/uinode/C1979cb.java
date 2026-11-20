package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1979cb<ModelType, StateType> {
    public final ModelType A02;
    public final StateType A03;
    public final String A04;
    public List<InterfaceC1981cd<ModelType, StateType>> A01 = null;
    public C1978ca A00 = C1978ca.A08;

    public C1979cb(ModelType modeltype, StateType statetype, String str) {
        this.A02 = modeltype;
        this.A03 = statetype;
        this.A04 = str;
    }

    public final C1979cb<ModelType, StateType> A05(InterfaceC1981cd<ModelType, StateType> interfaceC1981cd) {
        if (this.A01 == null) {
            this.A01 = new ArrayList();
        }
        this.A01.add(interfaceC1981cd);
        return this;
    }

    public final C1978ca<ModelType, StateType> A06() {
        return new C1978ca<>(this);
    }
}
