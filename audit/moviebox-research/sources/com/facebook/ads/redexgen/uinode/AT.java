package com.facebook.ads.redexgen.uinode;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AT {
    public static final AT A04 = new AS().A00();
    public AudioAttributes A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public AT(int i11, int i12, int i13) {
        this.A01 = i11;
        this.A02 = i12;
        this.A03 = i13;
    }

    public final AudioAttributes A00() {
        if (this.A00 == null) {
            this.A00 = new AudioAttributes.Builder().setContentType(this.A01).setFlags(this.A02).setUsage(this.A03).build();
        }
        return this.A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AT at2 = (AT) obj;
        return this.A01 == at2.A01 && this.A02 == at2.A02 && this.A03 == at2.A03;
    }

    public final int hashCode() {
        return (((((17 * 31) + this.A01) * 31) + this.A02) * 31) + this.A03;
    }
}
