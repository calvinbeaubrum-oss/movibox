package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DO {
    public final String A00;
    public final boolean A01;

    public DO(String str, boolean z11) {
        this.A00 = str;
        this.A01 = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != DO.class) {
            return false;
        }
        DO r11 = (DO) obj;
        return TextUtils.equals(this.A00, r11.A00) && this.A01 == r11.A01;
    }

    public final int hashCode() {
        int i11 = 1 * 31;
        String str = this.A00;
        return ((i11 + (str == null ? 0 : str.hashCode())) * 31) + (this.A01 ? 1231 : 1237);
    }
}
