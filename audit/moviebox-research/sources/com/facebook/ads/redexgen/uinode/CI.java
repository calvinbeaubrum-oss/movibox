package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CI implements WP, WQ {
    public static String[] A06 = {"ZtwyXb21lqsDJdKT2ajh9JxAXgW69QuB", "FrcJuXyaSLrnc8pAXv2TAxnFyZgF4qHK", "0iGJizGlWH9", "qhteMkWWDojgH5n0mIn7zojGTGtfRfRL", "S4vRLIoihFPQ", "xoDrhUfozcoi1lbYtymgci4hovtTAG3t", "yhmtadr4WKeMx7Xbvtz69UkymvwaYHjB", "iiLQKF6aVsd0mv8Gzt0Boeru5TAZQ446"};
    public long A00;
    public long A01;
    public long A02;
    public WQ A03;
    public WV[] A04 = new WV[0];
    public final WP A05;

    public CI(WP wp2, boolean z11, long j11, long j12) {
        this.A05 = wp2;
        this.A02 = z11 ? j11 : C.TIME_UNSET;
        this.A01 = j11;
        this.A00 = j12;
    }

    private AD A00(long j11, AD ad2) {
        long jA0E = IF.A0E(ad2.A01, 0L, j11 - this.A01);
        long j12 = ad2.A00;
        long j13 = this.A00;
        long jA0E2 = IF.A0E(j12, 0L, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11);
        return (jA0E == ad2.A01 && jA0E2 == ad2.A00) ? ad2 : new AD(jA0E, jA0E2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.FC
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void ABC(WP wp2) {
        this.A03.ABC(this);
    }

    public static boolean A02(long j11, InterfaceC1332Gg[] interfaceC1332GgArr) {
        if (j11 != 0) {
            for (InterfaceC1332Gg interfaceC1332Gg : interfaceC1332GgArr) {
                if (interfaceC1332Gg != null && !AbstractC1369Hs.A09(interfaceC1332Gg.A7u().A0O)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != C.TIME_UNSET;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final boolean A4T(long j11) {
        return this.A05.A4T(j11);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void A5A(long j11, boolean z11) {
        this.A05.A5A(j11, z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long A5x(long j11, AD ad2) {
        long j12 = this.A01;
        if (j11 == j12) {
            return j12;
        }
        return this.A05.A5x(j11, A00(j11, ad2));
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long A6D() {
        long jA6D = this.A05.A6D();
        if (jA6D != Long.MIN_VALUE) {
            long j11 = this.A00;
            if (j11 != Long.MIN_VALUE) {
                if (A06[2].length() == 17) {
                    throw new RuntimeException();
                }
                A06[5] = "DtDan6JMsc2D9dL8KrRs9GVt0cLu7T4O";
                if (jA6D >= j11) {
                }
            }
            return jA6D;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long A7U() {
        long jA7U = this.A05.A7U();
        if (jA7U != Long.MIN_VALUE) {
            long j11 = this.A00;
            if (j11 == Long.MIN_VALUE || jA7U < j11) {
                return jA7U;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final TrackGroupArray A8B() {
        return this.A05.A8B();
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void AAN() throws IOException {
        this.A05.AAN();
    }

    @Override // com.facebook.ads.redexgen.uinode.WQ
    public final void ACj(WP wp2) {
        this.A03.ACj(this);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void AE4(WQ wq2, long j11) {
        this.A03 = wq2;
        this.A05.AE4(this, j11);
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long AEL() {
        if (A03()) {
            long j11 = this.A02;
            if (A06[4].length() != 12) {
                throw new RuntimeException();
            }
            A06[6] = "LhyfL76jA11YYofpKqTom8Rw5oMGbfG9";
            this.A02 = C.TIME_UNSET;
            long jAEL = AEL();
            return jAEL != C.TIME_UNSET ? jAEL : j11;
        }
        long jAEL2 = this.A05.AEL();
        if (jAEL2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z11 = true;
        AbstractC1351Ha.A04(jAEL2 >= this.A01);
        long j12 = this.A00;
        if (j12 != Long.MIN_VALUE && jAEL2 > j12) {
            z11 = false;
        }
        AbstractC1351Ha.A04(z11);
        return jAEL2;
    }

    @Override // com.facebook.ads.redexgen.uinode.WP
    public final void AER(long j11) {
        this.A05.AER(j11);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long AFl(long j11) {
        this.A02 = C.TIME_UNSET;
        boolean z11 = false;
        for (WV wv2 : this.A04) {
            if (wv2 != null) {
                wv2.A00();
            }
        }
        long jAFl = this.A05.AFl(j11);
        if (jAFl == j11) {
            z11 = true;
        } else if (jAFl >= this.A01) {
            long j12 = this.A00;
            if (j12 == Long.MIN_VALUE) {
                z11 = true;
            } else {
                if (A06[0].charAt(28) != '9') {
                    throw new RuntimeException();
                }
                A06[2] = "Q";
                if (jAFl <= j12) {
                    z11 = true;
                }
            }
        }
        AbstractC1351Ha.A04(z11);
        return jAFl;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:38:0x008e  */
    @Override // com.facebook.ads.redexgen.uinode.WP
    public final long AFm(InterfaceC1332Gg[] interfaceC1332GgArr, boolean[] zArr, FB[] fbArr, boolean[] zArr2, long j11) {
        long j12;
        boolean z11;
        this.A04 = new WV[fbArr.length];
        FB[] fbArr2 = new FB[fbArr.length];
        int i11 = 0;
        while (true) {
            FB fb2 = null;
            if (i11 >= fbArr.length) {
                break;
            }
            WV[] wvArr = this.A04;
            WV wv2 = (WV) fbArr[i11];
            wvArr[i11] = wv2;
            if (wv2 != null) {
                fb2 = wv2.A01;
            }
            fbArr2[i11] = fb2;
            i11++;
        }
        long jAFm = this.A05.AFm(interfaceC1332GgArr, zArr, fbArr2, zArr2, j11);
        if (A03()) {
            long j13 = this.A01;
            if (j11 == j13 && A02(j13, interfaceC1332GgArr)) {
                j12 = jAFm;
            } else {
                j12 = C.TIME_UNSET;
            }
        } else {
            j12 = C.TIME_UNSET;
        }
        this.A02 = j12;
        if (jAFm != j11) {
            if (jAFm >= this.A01) {
                long j14 = this.A00;
                z11 = j14 == Long.MIN_VALUE || jAFm <= j14;
            }
        }
        AbstractC1351Ha.A04(z11);
        for (int i12 = 0; i12 < fbArr.length; i12++) {
            if (fbArr2[i12] == null) {
                this.A04[i12] = null;
            } else if (fbArr[i12] == null || this.A04[i12].A01 != fbArr2[i12]) {
                this.A04[i12] = new WV(this, fbArr2[i12]);
            }
            fbArr[i12] = this.A04[i12];
        }
        return jAFm;
    }
}
