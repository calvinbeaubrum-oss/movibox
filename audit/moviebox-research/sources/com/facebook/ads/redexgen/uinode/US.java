package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class US extends AbstractC10664t {
    public static String[] A01 = {"8Yn2PgyedH1iX", "R67HljoZMbsPm0e6EtybvG", "", "R8Pp2uuVTku92bGxcvFWCvwfHASfPd1y", "2y5E80sPhAjkTDK", "Itturke", "abRBLy2wdT4xlnoMDCf2vtSzdY3x1mV2", "QG421Xj1ReSIzqeVHucrcoJTP843GzsJ"};
    public final /* synthetic */ C10393r A00;

    public US(C10393r c10393r) {
        this.A00 = c10393r;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10664t
    public final void A0L(C1278Eb c1278Eb, int i11) {
        int iA23;
        super.A0L(c1278Eb, i11);
        C1821Zo layoutManager = this.A00.getLayoutManager();
        if (layoutManager != null && (iA23 = layoutManager.A23()) >= 0 && this.A00.getAdapter() != null && iA23 < this.A00.getAdapter().A0E()) {
            MJ mj2 = (MJ) c1278Eb.A1F(iA23);
            if (A01[1].length() == 0) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[5] = "EBOsosi";
            strArr[2] = "";
            if (mj2 == null) {
                return;
            }
            mj2.AFr();
        }
    }
}
