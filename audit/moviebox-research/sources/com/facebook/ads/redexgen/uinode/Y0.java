package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Y0 implements InterfaceC1212Ax {
    public final C1776Xu A00;
    public final C1775Xt A01;
    public final InterfaceC1190Ab[] A02;

    public Y0(InterfaceC1190Ab... interfaceC1190AbArr) {
        InterfaceC1190Ab[] interfaceC1190AbArr2 = (InterfaceC1190Ab[]) Arrays.copyOf(interfaceC1190AbArr, interfaceC1190AbArr.length + 2);
        this.A02 = interfaceC1190AbArr2;
        C1776Xu c1776Xu = new C1776Xu();
        this.A00 = c1776Xu;
        C1775Xt c1775Xt = new C1775Xt();
        this.A01 = c1775Xt;
        interfaceC1190AbArr2[interfaceC1190AbArr.length] = c1776Xu;
        interfaceC1190AbArr2[interfaceC1190AbArr.length + 1] = c1775Xt;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1212Ax
    public final C11869x A3b(C11869x c11869x) {
        this.A00.A0B(c11869x.A02);
        return new C11869x(this.A01.A01(c11869x.A01), this.A01.A00(c11869x.A00), c11869x.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1212Ax
    public final InterfaceC1190Ab[] A64() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1212Ax
    public final long A7O(long j11) {
        return this.A01.A02(j11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1212Ax
    public final long A80() {
        return this.A00.A0A();
    }
}
