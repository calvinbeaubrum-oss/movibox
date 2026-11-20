package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D5 {
    public int A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final InterfaceC1259Cy A05;
    public final C1375Hy A06 = new C1375Hy(new byte[64]);
    public final IB A07;

    public D5(InterfaceC1259Cy interfaceC1259Cy, IB ib2) {
        this.A05 = interfaceC1259Cy;
        this.A07 = ib2;
    }

    private void A00() {
        this.A06.A08(8);
        this.A03 = this.A06.A0F();
        this.A02 = this.A06.A0F();
        this.A06.A08(6);
        this.A00 = this.A06.A04(8);
    }

    private void A01() {
        this.A01 = 0L;
        if (this.A03) {
            this.A06.A08(4);
            long jA04 = ((long) this.A06.A04(3)) << 30;
            this.A06.A08(1);
            long jA05 = jA04 | ((long) (this.A06.A04(15) << 15));
            this.A06.A08(1);
            long jA06 = jA05 | ((long) this.A06.A04(15));
            this.A06.A08(1);
            if (!this.A04 && this.A02) {
                this.A06.A08(4);
                long jA07 = ((long) this.A06.A04(3)) << 30;
                this.A06.A08(1);
                long jA08 = jA07 | ((long) (this.A06.A04(15) << 15));
                this.A06.A08(1);
                long jA09 = jA08 | ((long) this.A06.A04(15));
                this.A06.A08(1);
                this.A07.A07(jA09);
                this.A04 = true;
            }
            this.A01 = this.A07.A07(jA06);
        }
    }

    public final void A02() {
        this.A04 = false;
        this.A05.AFg();
    }

    public final void A03(C1376Hz c1376Hz) throws C11849v {
        c1376Hz.A0c(this.A06.A00, 0, 3);
        this.A06.A07(0);
        A00();
        c1376Hz.A0c(this.A06.A00, 0, this.A00);
        this.A06.A07(0);
        A01();
        this.A05.ADt(this.A01, true);
        this.A05.A4R(c1376Hz);
        this.A05.ADs();
    }
}
