package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class TS extends OL {
    public static byte[] A00;
    public static String[] A01 = {"tJRtfPKHoy7gQ0Hrrag4OkVDHQvHpM6e", "ntrk62ddU7J9c8B2GtO4dhepCrAVPpDV", "iQ54QNqjdD5kyZO2OLG", "4R7BJQoUCBFINf313UyvxR7fWPUp11Dk", "Ad2P", "mQFjJcGEaXO3GAoxmnr0yBCCZwtlhd6p", "65xONPI2i6gPpcf6kW2ve41HMoO1k057", "z69fhWo2iasYfVs3h6jnYZwontL4UpVs"};

    static {
        A0D();
    }

    public TS(OP op2, boolean z11) {
        super(op2, z11);
        if (C1384Ih.A0y(op2.A05())) {
            if (op2.A08() != null) {
                op2.A08().setCTAClickListener(getCtaButton());
            }
            getTitleDescContainer().setCTAClickListener(getCtaButton());
        }
    }

    public static String A0C(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 94);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A00 = new byte[]{43, 46, 46, 47, 62, 43, 51, 54, 61};
    }

    public final void A13() {
        if (!C1384Ih.A0y(this.A06.A05()) || this.A06.A08() == null) {
            return;
        }
        this.A06.A08().setCTAClickListener(getCtaButton());
    }

    public abstract void A14();

    public abstract void A15();

    public abstract void A16();

    public abstract boolean A17();

    public abstract boolean A18();

    public void setAdDetailsClickListener(AbstractC1514No abstractC1514No) {
        if (!C1384Ih.A0y(this.A06.A05()) || abstractC1514No == null) {
            return;
        }
        ViewOnClickListenerC1667Tl ctaButton = getCtaButton();
        if (A01[1].charAt(21) != 'h') {
            throw new RuntimeException();
        }
        A01[3] = "am5A0dIgunRuJRLaM18rzwVTPisxqXDR";
        abstractC1514No.setOnClickListener(OI.A03(ctaButton, A0C(0, 9, 108)));
    }

    public void setupNativeCtaExtension(C1567Pp c1567Pp) {
    }
}
