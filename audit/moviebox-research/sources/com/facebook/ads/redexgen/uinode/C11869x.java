package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11869x {
    public static final C11869x A04 = new C11869x(1.0f);
    public final float A00;
    public final float A01;
    public final boolean A02;
    public final int A03;

    public C11869x(float f11) {
        this(f11, 1.0f, false);
    }

    public C11869x(float f11, float f12, boolean z11) {
        AbstractC1351Ha.A03(f11 > 0.0f);
        AbstractC1351Ha.A03(f12 > 0.0f);
        this.A01 = f11;
        this.A00 = f12;
        this.A02 = z11;
        this.A03 = Math.round(1000.0f * f11);
    }

    public final long A00(long j11) {
        return ((long) this.A03) * j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C11869x c11869x = (C11869x) obj;
        return this.A01 == c11869x.A01 && this.A00 == c11869x.A00 && this.A02 == c11869x.A02;
    }

    public final int hashCode() {
        return (((((17 * 31) + Float.floatToRawIntBits(this.A01)) * 31) + Float.floatToRawIntBits(this.A00)) * 31) + (this.A02 ? 1 : 0);
    }
}
