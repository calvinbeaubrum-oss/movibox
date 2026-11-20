package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.63, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass63 extends EM implements Handler.Callback {
    public static String[] A0D = {"gjDhtLri4FaGEAWjRmzGOIMLbPPteIUr", "gp3Mr1PqMY6rayIsxO9yJntmkSBHR7UD", "5ZPDaEp5A16UYvNfALSoSfbuhC4Pwik1", "wt", "uAQVQjgSUgDp2O8dWeXQS6qYbl", "Gm3ZCOzsQkh90YHushfajnERb16f", "RaSLUB1F0sju8CZYqMhotlzh76Y2FLCY", "Ujo7akDRrtwDl4IVTi3qcCtKoi2"};
    public int A00;
    public int A01;
    public Format A02;
    public WL A03;
    public C5 A04;
    public AbstractC1232Br A05;
    public AbstractC1232Br A06;
    public boolean A07;
    public boolean A08;
    public final Handler A09;
    public final C11789p A0A;
    public final InterfaceC1317Fq A0B;
    public final InterfaceC1318Fr A0C;

    public AnonymousClass63(InterfaceC1318Fr interfaceC1318Fr, Looper looper) {
        this(interfaceC1318Fr, looper, InterfaceC1317Fq.A00);
    }

    public AnonymousClass63(InterfaceC1318Fr interfaceC1318Fr, Looper looper, InterfaceC1317Fq interfaceC1317Fq) {
        super(3);
        this.A0C = (InterfaceC1318Fr) AbstractC1351Ha.A01(interfaceC1318Fr);
        this.A09 = looper == null ? null : new Handler(looper, this);
        this.A0B = interfaceC1317Fq;
        this.A0A = new C11789p();
    }

    private long A00() {
        int i11 = this.A01;
        if (i11 == -1 || i11 >= this.A06.A71()) {
            return Long.MAX_VALUE;
        }
        return this.A06.A70(this.A01);
    }

    private void A01() {
        A06(Collections.emptyList());
    }

    private void A02() {
        this.A04 = null;
        this.A01 = -1;
        AbstractC1232Br abstractC1232Br = this.A06;
        if (abstractC1232Br != null) {
            abstractC1232Br.A08();
            this.A06 = null;
        }
        AbstractC1232Br abstractC1232Br2 = this.A05;
        if (abstractC1232Br2 != null) {
            abstractC1232Br2.A08();
            this.A05 = null;
        }
    }

    private void A03() {
        A02();
        this.A03.AEV();
        this.A03 = null;
        this.A00 = 0;
    }

    private void A04() {
        A03();
        this.A03 = this.A0B.A4Z(this.A02);
    }

    private void A05(List<C1314Fn> list) {
        this.A0C.ABF(list);
    }

    private void A06(List<C1314Fn> list) {
        Handler handler = this.A09;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            A05(list);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public final void A15() {
        this.A02 = null;
        A01();
        A03();
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public final void A16(long j11, boolean z11) {
        A01();
        this.A07 = false;
        this.A08 = false;
        if (this.A00 != 0) {
            A04();
        } else {
            A02();
            this.A03.flush();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public final void A18(Format[] formatArr, long j11) throws C11669c {
        Format format = formatArr[0];
        this.A02 = format;
        if (this.A03 != null) {
            this.A00 = 1;
        } else {
            this.A03 = this.A0B.A4Z(format);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.Y5
    public final boolean A91() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.uinode.Y5
    public final boolean A9C() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    @Override // com.facebook.ads.redexgen.uinode.Y5
    public final void AFB(long j11, long j12) throws Exception {
        if (this.A08) {
            return;
        }
        if (this.A05 == null) {
            this.A03.AGB(j11);
            try {
                this.A05 = this.A03.A55();
            } catch (C1316Fp e11) {
                throw C11669c.A01(e11, A0z());
            }
        }
        if (A81() != 2) {
            return;
        }
        boolean z11 = false;
        if (this.A06 != null) {
            long jA00 = A00();
            while (jA00 <= j11) {
                this.A01++;
                jA00 = A00();
                z11 = true;
            }
        }
        AbstractC1232Br abstractC1232Br = this.A05;
        if (A0D[5].length() == 31) {
            throw new RuntimeException();
        }
        A0D[3] = "KD";
        if (abstractC1232Br != null) {
            if (abstractC1232Br.A04()) {
                if (!z11) {
                    long jA01 = A00();
                    String[] strArr = A0D;
                    if (strArr[2].charAt(19) != strArr[6].charAt(19)) {
                        String[] strArr2 = A0D;
                        strArr2[2] = "xJP4O1R5iBehlF3gjm9oxj2d0if1stmE";
                        strArr2[6] = "mrFlrw4gjycn3JZxSawox6A5ZMqGzaMP";
                        if (jA01 == Long.MAX_VALUE) {
                            if (this.A00 == 2) {
                                A04();
                            } else {
                                A02();
                                this.A08 = true;
                            }
                        }
                    } else {
                        String[] strArr3 = A0D;
                        strArr3[1] = "j9HNvuqeLVtstiy16y9LH7E8URqfplUR";
                        strArr3[0] = "4Jhirnf8T6FRv4glusNGUbVI8l7wWqUm";
                        if (jA01 == Long.MAX_VALUE) {
                            if (this.A00 == 2) {
                                A04();
                            } else {
                                A02();
                                this.A08 = true;
                            }
                        }
                    }
                }
            } else if (((AbstractC1772Xq) this.A05).A01 <= j11) {
                AbstractC1232Br abstractC1232Br2 = this.A06;
                if (abstractC1232Br2 != null) {
                    abstractC1232Br2.A08();
                }
                AbstractC1232Br abstractC1232Br3 = this.A05;
                this.A06 = abstractC1232Br3;
                this.A05 = null;
                this.A01 = abstractC1232Br3.A7T(j11);
                z11 = true;
            }
        }
        if (z11) {
            A06(this.A06.A6Z(j11));
        }
        if (this.A00 == 2) {
            return;
        }
        while (!this.A07) {
            try {
                if (this.A04 == null) {
                    C5 c5A54 = this.A03.A54();
                    this.A04 = c5A54;
                    if (c5A54 == null) {
                        return;
                    }
                }
                if (this.A00 == 1) {
                    this.A04.A02(4);
                    this.A03.AEG(this.A04);
                    this.A04 = null;
                    this.A00 = 2;
                    return;
                }
                int iA11 = A11(this.A0A, this.A04, false);
                if (A0D[3].length() != 2) {
                    throw new RuntimeException();
                }
                A0D[5] = "w0qgeVmaHT9zi92RU59iiGmHeY";
                if (iA11 == -4) {
                    if (this.A04.A04()) {
                        this.A07 = true;
                    } else {
                        this.A04.A00 = this.A0A.A00.A0G;
                        this.A04.A08();
                    }
                    this.A03.AEG(this.A04);
                    this.A04 = null;
                } else if (iA11 == -3) {
                    return;
                }
            } catch (C1316Fp e12) {
                throw C11669c.A01(e12, A0z());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AA
    public final int AGe(Format format) {
        if (this.A0B.AGf(format)) {
            return EM.A0y(null, format.A0H) ? 4 : 2;
        }
        return AbstractC1369Hs.A0A(format.A0O) ? 1 : 0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A05((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
