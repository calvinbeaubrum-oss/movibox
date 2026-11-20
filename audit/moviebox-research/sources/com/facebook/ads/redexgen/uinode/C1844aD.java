package com.facebook.ads.redexgen.uinode;

import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1844aD implements C2X {
    public final SharedPreferences.Editor A00;

    public C1844aD(SharedPreferences.Editor editor) {
        this.A00 = editor;
    }

    public final C1844aD A00(String str, long j11) {
        this.A00.putLong(str, j11);
        return this;
    }

    public final C1844aD A01(String str, String str2) {
        this.A00.putString(str, str2);
        return this;
    }

    public final void A02() {
        this.A00.apply();
    }
}
