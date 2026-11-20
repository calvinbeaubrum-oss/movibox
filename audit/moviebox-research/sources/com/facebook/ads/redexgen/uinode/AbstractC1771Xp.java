package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.redexgen.uinode.AbstractC1772Xq;
import com.facebook.ads.redexgen.uinode.C1773Xr;
import java.lang.Exception;
import java.util.ArrayDeque;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1771Xp<I extends C1773Xr, O extends AbstractC1772Xq, E extends Exception> implements BB<I, O, E> {
    public int A00;
    public int A01;
    public int A02;
    public I A03;
    public E A04;
    public boolean A05;
    public boolean A06;
    public final Thread A08;
    public final I[] A0B;
    public final O[] A0C;
    public final Object A07 = new Object();
    public final ArrayDeque<I> A09 = new ArrayDeque<>();
    public final ArrayDeque<O> A0A = new ArrayDeque<>();

    public AbstractC1771Xp(I[] iArr, O[] oArr) {
        this.A0B = iArr;
        this.A00 = iArr.length;
        for (int i11 = 0; i11 < this.A00; i11++) {
            ((I[]) this.A0B)[i11] = A0T();
        }
        this.A0C = oArr;
        this.A01 = oArr.length;
        for (int i12 = 0; i12 < this.A01; i12++) {
            ((O[]) this.A0C)[i12] = A0V();
        }
        BE be2 = new BE(this);
        this.A08 = be2;
        be2.start();
    }

    private void A0K() {
        if (A0Q()) {
            this.A07.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    private void A0L() throws Exception {
        E e11 = this.A04;
        if (e11 != null) {
            throw e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (A0R());
    }

    private void A0N(I i11) {
        i11.A07();
        I[] iArr = this.A0B;
        int i12 = this.A00;
        this.A00 = i12 + 1;
        iArr[i12] = i11;
    }

    private void A0O(O o11) {
        o11.A07();
        O[] oArr = this.A0C;
        int i11 = this.A01;
        this.A01 = i11 + 1;
        oArr[i11] = o11;
    }

    private boolean A0Q() {
        return !this.A09.isEmpty() && this.A01 > 0;
    }

    private boolean A0R() throws InterruptedException {
        synchronized (this.A07) {
            while (!this.A06 && !A0Q()) {
                this.A07.wait();
            }
            if (this.A06) {
                return false;
            }
            I iRemoveFirst = this.A09.removeFirst();
            O[] oArr = this.A0C;
            int i11 = this.A01 - 1;
            this.A01 = i11;
            O o11 = oArr[i11];
            boolean z11 = this.A05;
            this.A05 = false;
            if (iRemoveFirst.A04()) {
                o11.A00(4);
            } else {
                if (iRemoveFirst.A03()) {
                    o11.A00(Integer.MIN_VALUE);
                }
                try {
                    this.A04 = A0W(iRemoveFirst, o11, z11);
                } catch (OutOfMemoryError e11) {
                    this.A04 = (E) A0X(e11);
                } catch (RuntimeException e12) {
                    this.A04 = (E) A0X(e12);
                }
                if (this.A04 != null) {
                    synchronized (this.A07) {
                    }
                    return false;
                }
            }
            synchronized (this.A07) {
                if (this.A05) {
                    A0O(o11);
                } else if (o11.A03()) {
                    this.A02++;
                    A0O(o11);
                } else {
                    o11.A00 = this.A02;
                    this.A02 = 0;
                    this.A0A.addLast(o11);
                }
                A0N(iRemoveFirst);
            }
            return true;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    /* JADX INFO: renamed from: A0S, reason: merged with bridge method [inline-methods] */
    public final I A54() throws Exception {
        I i11;
        synchronized (this.A07) {
            A0L();
            AbstractC1351Ha.A04(this.A03 == null);
            int i12 = this.A00;
            if (i12 == 0) {
                i11 = null;
            } else {
                I[] iArr = this.A0B;
                int i13 = i12 - 1;
                this.A00 = i13;
                i11 = iArr[i13];
            }
            this.A03 = i11;
        }
        return i11;
    }

    public abstract I A0T();

    @Override // com.facebook.ads.redexgen.uinode.BB
    /* JADX INFO: renamed from: A0U, reason: merged with bridge method [inline-methods] */
    public final O A55() throws Exception {
        synchronized (this.A07) {
            A0L();
            if (this.A0A.isEmpty()) {
                return null;
            }
            return this.A0A.removeFirst();
        }
    }

    public abstract O A0V();

    public abstract E A0W(I i11, O o11, boolean z11);

    public abstract E A0X(Throwable th2);

    public final void A0Y(int i11) {
        AbstractC1351Ha.A04(this.A00 == this.A0B.length);
        for (I i12 : this.A0B) {
            i12.A09(i11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    /* JADX INFO: renamed from: A0Z, reason: merged with bridge method [inline-methods] */
    public final void AEG(I i11) throws Exception {
        synchronized (this.A07) {
            A0L();
            AbstractC1351Ha.A03(i11 == this.A03);
            this.A09.addLast(i11);
            A0K();
            this.A03 = null;
        }
    }

    public void A0a(O o11) {
        synchronized (this.A07) {
            A0O(o11);
            A0K();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    public final void AEV() {
        synchronized (this.A07) {
            this.A06 = true;
            this.A07.notify();
        }
        try {
            this.A08.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    public final void flush() {
        synchronized (this.A07) {
            this.A05 = true;
            this.A02 = 0;
            I i11 = this.A03;
            if (i11 != null) {
                A0N(i11);
                this.A03 = null;
            }
            while (!this.A09.isEmpty()) {
                A0N(this.A09.removeFirst());
            }
            while (!this.A0A.isEmpty()) {
                A0O(this.A0A.removeFirst());
            }
        }
    }
}
