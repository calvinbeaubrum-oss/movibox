package com.facebook.ads.redexgen.uinode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1231Bq implements WL {
    public static String[] A06 = {"KcRMvDVLZNgc0ooVkhN4ahdKcengok4t", "7pRgSHJJ", "GNHbGuKbKosn0JAz4xkib8iBcGb5WNz5", "hJNyShuwv1tZ2cTKHVoLW9isLSOVhBhj", "H7WHQ", "6cZmXLfi2DPGYj7ZmxIdQ5A", "b2Hmg2LD", "cSsJl4a3bVOvbO76ENMD9MAL1lcw3B"};
    public long A00;
    public long A01;
    public C10634q A02;
    public final ArrayDeque<C10634q> A03 = new ArrayDeque<>();
    public final ArrayDeque<AbstractC1232Br> A04;
    public final PriorityQueue<C10634q> A05;

    public AbstractC1231Bq() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.A03.add(new C10634q());
        }
        this.A04 = new ArrayDeque<>();
        for (int i12 = 0; i12 < 2; i12++) {
            this.A04.add(new C10604n(this));
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0K(C10634q c10634q) {
        c10634q.A07();
        this.A03.add(c10634q);
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    /* JADX INFO: renamed from: A0L, reason: merged with bridge method [inline-methods] */
    public C5 A54() throws C1316Fp {
        AbstractC1351Ha.A04(this.A02 == null);
        boolean zIsEmpty = this.A03.isEmpty();
        if (A06[4].length() != 5) {
            throw new RuntimeException();
        }
        A06[4] = "MSCQz";
        if (zIsEmpty) {
            return null;
        }
        C10634q c10634qPollFirst = this.A03.pollFirst();
        this.A02 = c10634qPollFirst;
        return c10634qPollFirst;
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public AbstractC1232Br A55() throws C1316Fp {
        if (this.A04.isEmpty()) {
            return null;
        }
        while (!this.A05.isEmpty() && ((C1773Xr) this.A05.peek()).A00 <= this.A00) {
            C10634q c10634qPoll = this.A05.poll();
            if (c10634qPoll.A04()) {
                AbstractC1232Br abstractC1232BrPollFirst = this.A04.pollFirst();
                abstractC1232BrPollFirst.A00(4);
                A0K(c10634qPoll);
                String[] strArr = A06;
                if (strArr[1].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A06;
                strArr2[2] = "Z7l20gfPvvtRCAhrDUNIN8ivECfXDju3";
                strArr2[3] = "MHWMj6Fd4O5yELPFkyyjrniha9DdnabU";
                return abstractC1232BrPollFirst;
            }
            A0P(c10634qPoll);
            if (A0R()) {
                WI wiA0N = A0N();
                if (!c10634qPoll.A03()) {
                    AbstractC1232Br abstractC1232BrPollFirst2 = this.A04.pollFirst();
                    abstractC1232BrPollFirst2.A09(((C1773Xr) c10634qPoll).A00, wiA0N, Long.MAX_VALUE);
                    A0K(c10634qPoll);
                    return abstractC1232BrPollFirst2;
                }
            }
            A0K(c10634qPoll);
        }
        return null;
    }

    public abstract WI A0N();

    @Override // com.facebook.ads.redexgen.uinode.BB
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public void AEG(C5 c11) throws C1316Fp {
        AbstractC1351Ha.A03(c11 == this.A02);
        if (A06[0].charAt(9) != 'N') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "h6rCbn8hi0Qg5CvGAi8vHFDPjl0uqV";
        strArr[5] = "6Me2Lvii1P8K0tFjrCRJacm";
        if (c11.A03()) {
            A0K(this.A02);
        } else {
            C10634q c10634q = this.A02;
            long j11 = this.A01;
            this.A01 = 1 + j11;
            c10634q.A00 = j11;
            this.A05.add(this.A02);
        }
        this.A02 = null;
    }

    public abstract void A0P(C5 c11);

    public final void A0Q(AbstractC1232Br abstractC1232Br) {
        abstractC1232Br.A07();
        this.A04.add(abstractC1232Br);
    }

    public abstract boolean A0R();

    @Override // com.facebook.ads.redexgen.uinode.BB
    public void AEV() {
    }

    @Override // com.facebook.ads.redexgen.uinode.WL
    public void AGB(long j11) {
        this.A00 = j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.BB
    public void flush() {
        this.A01 = 0L;
        this.A00 = 0L;
        while (!this.A05.isEmpty()) {
            A0K(this.A05.poll());
        }
        C10634q c10634q = this.A02;
        if (c10634q != null) {
            A0K(c10634q);
            this.A02 = null;
        }
    }
}
