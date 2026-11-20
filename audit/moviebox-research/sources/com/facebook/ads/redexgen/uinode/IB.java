package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IB {
    public long A00;
    public long A01;
    public volatile long A02 = C.TIME_UNSET;

    public IB(long j11) {
        A02(j11);
    }

    public static long A00(long j11) {
        return (1000000 * j11) / 90000;
    }

    public static long A01(long j11) {
        return (90000 * j11) / 1000000;
    }

    private final synchronized void A02(long j11) {
        AbstractC1351Ha.A04(this.A02 == C.TIME_UNSET);
        this.A00 = j11;
    }

    public final long A03() {
        return this.A00;
    }

    public final long A04() {
        if (this.A02 != C.TIME_UNSET) {
            return this.A01 + this.A02;
        }
        long j11 = this.A00;
        return j11 != Long.MAX_VALUE ? j11 : C.TIME_UNSET;
    }

    public final long A05() {
        if (this.A00 == Long.MAX_VALUE) {
            return 0L;
        }
        return this.A02 == C.TIME_UNSET ? C.TIME_UNSET : this.A01;
    }

    public final long A06(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.A02 != C.TIME_UNSET) {
            this.A02 = j11;
        } else {
            long j12 = this.A00;
            if (j12 != Long.MAX_VALUE) {
                this.A01 = j12 - j11;
            }
            synchronized (this) {
                this.A02 = j11;
                notifyAll();
            }
        }
        return this.A01 + j11;
    }

    public final long A07(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.A02 != C.TIME_UNSET) {
            long jA01 = A01(this.A02);
            long j12 = (4294967296L + jA01) / 8589934592L;
            long j13 = ((j12 - 1) * 8589934592L) + j11;
            long j14 = (8589934592L * j12) + j11;
            if (Math.abs(j13 - jA01) >= Math.abs(j14 - jA01)) {
                j13 = j14;
            }
            j11 = j13;
        }
        return A06(A00(j11));
    }

    public final void A08() {
        this.A02 = C.TIME_UNSET;
    }
}
