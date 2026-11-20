package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PN {
    public final String A00;
    public final ArrayList<String> A01;
    public final ArrayList<String> A02;
    public final ArrayList<String> A03;
    public final JSONObject A04;
    public final boolean A05;

    public PN(JSONObject jSONObject, String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, boolean z11) {
        this.A04 = jSONObject;
        this.A00 = str;
        this.A02 = arrayList;
        this.A03 = arrayList2;
        this.A01 = arrayList3;
        this.A05 = z11;
    }
}
