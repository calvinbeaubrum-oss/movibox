package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AK {
    public final int A00;
    public final C1291Eo A01;

    public AK(int i11, C1291Eo c1291Eo) {
        this.A00 = i11;
        this.A01 = c1291Eo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AK ak2 = (AK) obj;
        return this.A00 == ak2.A00 && this.A01.equals(ak2.A01);
    }

    public final int hashCode() {
        return (this.A00 * 31) + this.A01.hashCode();
    }
}
