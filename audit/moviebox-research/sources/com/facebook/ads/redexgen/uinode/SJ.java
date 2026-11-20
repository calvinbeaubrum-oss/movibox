package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SJ implements InterfaceC1607Rd {
    public static String[] A01 = {"uB1RC", "E7rLPB8klTW5J9FjuULp7NzB4AWE19Zm", "BGfRoGqubHgomR1aknLAm7BQoVqY9Rjo", "2aqRDajB7mkFiu8JUeuEjEkcXKsGj4gd", "YPIu8FWl8tmTV", "O2dNNTCX3dr0fdBVB7HhwqWACslxe6aK", "WKmspm9NaQlidgYEldSczPSkp8W1cJlS", "CDbKVWoo3Luj5aOlcVCk0HC1kDrFWNgV"};
    public final /* synthetic */ Q7 A00;

    public SJ(Q7 q11) {
        this.A00 = q11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1607Rd
    public final void AEA() {
        if (this.A00.A02 != null) {
            Q7 q11 = this.A00;
            if (A01[3].charAt(8) == 'm') {
                throw new RuntimeException();
            }
            A01[3] = "G62o5XZ8JRlbj2NUyH9KkdSeUCUXeXTA";
            q11.A02.A43(this.A00.A03.A7w());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1607Rd
    public final void AEC(C1609Rf c1609Rf) {
        if (this.A00.A02 == null) {
            return;
        }
        if (c1609Rf == null || !c1609Rf.A00()) {
            this.A00.A02.A43(this.A00.A03.A7w());
            return;
        }
        MC mc2 = this.A00.A02;
        Q7 q11 = this.A00;
        if (A01[5].length() == 14) {
            throw new RuntimeException();
        }
        A01[1] = "MYgqySdSEunU6EGhIZ8lv2VKjJmAUpiH";
        mc2.A43(q11.A03.A7x());
    }
}
