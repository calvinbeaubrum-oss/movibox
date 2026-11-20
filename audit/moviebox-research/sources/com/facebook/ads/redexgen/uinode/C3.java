package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3 {
    public static String[] A04 = {"h73SRN04xx9GKM0Q116IBzLVfoAHdt6S", "61WNQ6jcFYZeo4haiLT", "EyZhmJMsuDDThnYHJcpUVdPGrs5jP", "TnJHvhzl2eIFPCvspzGh2UrXG1fvsdQe", "l4BIQ9QQurpAuznw483RtfLanfJA913P", "gUiFEUth", "CESv2iJEZOXF88qxXwTFJw16ZR0ZYHcV", "lPNbV4orIJCU5KxXMzdOHz5Kw4N4woU7"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final byte[] A03;

    public C3(int i11, byte[] bArr, int i12, int i13) {
        this.A01 = i11;
        this.A03 = bArr;
        this.A02 = i12;
        this.A00 = i13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            if (A04[5].length() == 24) {
                throw new RuntimeException();
            }
            A04[5] = "ISIjD6Kq";
            if (cls == obj.getClass()) {
                C3 c11 = (C3) obj;
                return this.A01 == c11.A01 && this.A02 == c11.A02 && this.A00 == c11.A00 && Arrays.equals(this.A03, c11.A03);
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.A01 * 31) + Arrays.hashCode(this.A03)) * 31) + this.A02) * 31) + this.A00;
    }
}
