package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1914bL extends KT {
    public final /* synthetic */ C1913bK A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public C1914bL(C1913bK c1913bK, Map map, Map map2) {
        this.A00 = c1913bK;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (TextUtils.isEmpty(this.A00.A01.A0Y())) {
            return;
        }
        HashMap map = new HashMap();
        map.putAll(this.A02);
        map.putAll(this.A01);
        this.A00.A0A.A09().AA4(this.A00.A01.A0Y(), map);
    }
}
