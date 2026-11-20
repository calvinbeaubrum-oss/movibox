package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.az, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1892az implements InterfaceC09771h {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC1898b5 A01;
    public final /* synthetic */ C1896b3 A02;
    public final /* synthetic */ InterfaceC09771h A03;
    public final /* synthetic */ C09781i A04;
    public final /* synthetic */ C1795Yn A05;
    public final /* synthetic */ EnumSet A06;

    public C1892az(C09781i c09781i, C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, C1896b3 c1896b3, int i11, InterfaceC09771h interfaceC09771h, EnumSet enumSet) {
        this.A04 = c09781i;
        this.A05 = c1795Yn;
        this.A01 = abstractC1898b5;
        this.A02 = c1896b3;
        this.A00 = i11;
        this.A03 = interfaceC09771h;
        this.A06 = enumSet;
    }

    private final void A00() {
        if (this.A00 + 1 >= this.A02.A0s()) {
            return;
        }
        C09781i c09781i = this.A04;
        C1795Yn c1795Yn = this.A05;
        EnumSet enumSet = this.A06;
        C1896b3 c1896b3 = this.A02;
        c09781i.A0A(c1795Yn, enumSet, c1896b3, c1896b3.A0v(this.A00 + 1), this.A00 + 1, this.A03);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09771h
    public final void AAe(AdError adError) {
        if (this.A00 == 0) {
            this.A03.AAe(adError);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09771h
    public final void AAf() {
        this.A05.A00().AFq(this.A01.A12(), this.A02.A0w());
        if (this.A00 == 0) {
            this.A03.AAf();
        }
        A00();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09771h
    public final void AES() {
        if (this.A00 == 0) {
            this.A03.AES();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09771h
    public final void AGm() {
        if (this.A00 == 0) {
            this.A03.AGm();
        }
    }
}
