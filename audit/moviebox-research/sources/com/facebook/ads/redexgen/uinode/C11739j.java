package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11739j implements Comparable<C11739j> {
    public int A00;
    public long A01;
    public Object A02;
    public final A8 A03;

    public C11739j(A8 a11) {
        this.A03 = a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C11739j c11739j) {
        Object obj = this.A02;
        if ((obj == null) != (c11739j.A02 == null)) {
            return obj != null ? -1 : 1;
        }
        if (obj == null) {
            return 0;
        }
        int i11 = this.A00 - c11739j.A00;
        return i11 != 0 ? i11 : IF.A07(this.A01, c11739j.A01);
    }

    public final void A01(int i11, long j11, Object obj) {
        this.A00 = i11;
        this.A01 = j11;
        this.A02 = obj;
    }
}
