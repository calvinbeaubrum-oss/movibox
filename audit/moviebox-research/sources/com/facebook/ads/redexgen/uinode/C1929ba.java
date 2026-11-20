package com.facebook.ads.redexgen.uinode;

import java.util.Collection;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ba, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1929ba implements InterfaceC09550k {
    public final /* synthetic */ C1795Yn A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C1929ba(JSONObject jSONObject, C1795Yn c1795Yn, String str) {
        this.A02 = jSONObject;
        this.A00 = c1795Yn;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final String A6T() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final Collection<String> A6n() {
        return AbstractC09560l.A03(this.A00, this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final EnumC09540j A7E() {
        return AbstractC09560l.A00(this.A02);
    }
}
