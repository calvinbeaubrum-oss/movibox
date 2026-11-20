package com.facebook.ads.redexgen.uinode;

import com.transsion.gslb.Worker;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JZ {
    public final JX A0B;
    public final boolean A0F;
    public final String A0C = JZ.class.getSimpleName();
    public final int A07 = 101;
    public final int A0A = 102;
    public final int A08 = Worker.WHAT_SYNC_DATA;
    public final int A03 = 104;
    public final int A09 = 105;
    public final int A02 = 106;
    public final int A04 = 107;
    public final int A05 = 108;
    public final int A06 = 109;
    public final int A01 = Worker.WHAT_QUIT;
    public final boolean A0E = false;
    public long A00 = -1;
    public final List<JY> A0D = new LinkedList();

    public JZ(C11237f c11237f, JX jx2) {
        int iA0D = Ij.A0D(c11237f);
        if (iA0D < 1) {
            this.A0F = false;
        } else {
            this.A0F = c11237f.A08().A00() < 1.0d / ((double) iA0D);
        }
        this.A0B = jx2;
    }

    private int A00() {
        return this.A0B.A6c();
    }

    private int A01() {
        if (this.A00 > 0) {
            return (int) (System.currentTimeMillis() - this.A00);
        }
        return -1;
    }

    private void A03(JY jy2) {
        synchronized (this.A0D) {
            this.A0D.add(jy2);
        }
    }

    public final void A04() {
        if (this.A0F) {
            A03(new JY(A01(), Worker.WHAT_QUIT, A00(), null));
        }
    }

    public final void A05() {
        if (this.A0F) {
            A03(new JY(A01(), 106, A00(), null));
        }
    }

    public final void A06() {
        if (this.A0F) {
            A03(new JY(A01(), 104, A00(), null));
        }
    }

    public final void A07() {
        if (this.A0F) {
            A03(new JY(A01(), 109, -1, null));
        }
    }

    public final void A08() {
        if (this.A0F) {
            A03(new JY(A01(), 108, A00(), null));
        }
    }

    public final void A09() {
        if (this.A0F) {
            this.A00 = System.currentTimeMillis();
            A03(new JY(0, 101, -1, null));
        }
    }

    public final void A0A() {
        if (this.A0F) {
            A03(new JY(A01(), 105, A00(), null));
        }
    }

    public final void A0B() {
        if (this.A0F) {
            A03(new JY(A01(), 102, A00(), null));
        }
    }

    public final void A0C(C11237f c11237f, String str) {
        if (this.A0F) {
            A03(new JY(A01(), Worker.WHAT_SYNC_DATA, A00(), null));
            ExecutorC1467Lt.A06.execute(new JW(this, str, c11237f));
        }
    }
}
