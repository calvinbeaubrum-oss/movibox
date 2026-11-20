package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1333Gh {
    public int A00;
    public final int A01;
    public final InterfaceC1332Gg[] A02;

    public C1333Gh(InterfaceC1332Gg... interfaceC1332GgArr) {
        this.A02 = interfaceC1332GgArr;
        this.A01 = interfaceC1332GgArr.length;
    }

    public final InterfaceC1332Gg A00(int i11) {
        return this.A02[i11];
    }

    public final InterfaceC1332Gg[] A01() {
        return (InterfaceC1332Gg[]) this.A02.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.A02, ((C1333Gh) obj).A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        return this.A00;
    }
}
