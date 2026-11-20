package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GW {
    public final int A00;
    public final int A01;
    public final String A02;

    public GW(int i11, int i12, String str) {
        this.A00 = i11;
        this.A01 = i12;
        this.A02 = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GW gw2 = (GW) obj;
        return this.A00 == gw2.A00 && this.A01 == gw2.A01 && TextUtils.equals(this.A02, gw2.A02);
    }

    public final int hashCode() {
        int i11 = ((this.A00 * 31) + this.A01) * 31;
        String str = this.A02;
        return i11 + (str != null ? str.hashCode() : 0);
    }
}
