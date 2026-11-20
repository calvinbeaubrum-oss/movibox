package com.facebook.ads.redexgen.uinode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10152t<T> implements Iterator<T> {
    public int A00;
    public int A01;
    public boolean A02 = false;
    public final int A03;
    public final /* synthetic */ AbstractC10202y A04;

    public C10152t(AbstractC10202y abstractC10202y, int i11) {
        this.A04 = abstractC10202y;
        this.A03 = i11;
        this.A01 = abstractC10202y.A04();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 < this.A01;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T t11 = (T) this.A04.A0B(this.A00, this.A03);
        this.A00++;
        this.A02 = true;
        return t11;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.A02) {
            throw new IllegalStateException();
        }
        int i11 = this.A00 - 1;
        this.A00 = i11;
        this.A01--;
        this.A02 = false;
        this.A04.A0E(i11);
    }
}
