package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZZ extends AbstractC10664t {
    public static String[] A02 = {"mAEXsU", "ynqBxBOImfiaim2rOjt4gNln3IJjMmAs", "wywpOwDcOClPwSqhh8hqnS4LzA6xmBGs", "SzqLf2", "g6", "3b", "2rYsw0AU9P5CKqqKD8yWz2y811Q4TNqs", "g7NtZwf9Cfcv4ky8xJWe0WMsxKKUH5F1"};
    public boolean A00 = false;
    public final /* synthetic */ ZY A01;

    public ZZ(ZY zy2) {
        this.A01 = zy2;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10664t
    public final void A0L(C1278Eb c1278Eb, int i11) {
        super.A0L(c1278Eb, i11);
        if (i11 == 0 && this.A00) {
            this.A00 = false;
            this.A01.A0F();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10664t
    public final void A0M(C1278Eb c1278Eb, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return;
        }
        String[] strArr = A02;
        if (strArr[5].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        A02[1] = "WMOmT1QQvzwg3wEMb9eL1K1wBJkCMN2D";
        this.A00 = true;
    }
}
