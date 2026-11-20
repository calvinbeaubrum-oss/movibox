package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1244Cg {
    public static String[] A0J = {"Hx", "VutN6lGbTtI", "", "qYQ0MvWUv8Y", "S03PbS7CBB7Qa9LNqne809kWTfsCcOYT", "wkl2QKty73uWRgng3ylrY2sBCsabW7qE", "iu4lxNjBwDGgTbBIaWVT9T7j7cQi6zNN", "a5Fde8I7YqGVonU3ugZgHcMmcsmCDOtB"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public CP A07;
    public C1243Cf A08;
    public C1376Hz A09;
    public boolean A0A;
    public boolean A0B;
    public int[] A0C;
    public int[] A0D;
    public int[] A0E;
    public long[] A0F;
    public long[] A0G;
    public boolean[] A0H;
    public boolean[] A0I;

    public final long A00(int i11) {
        return this.A0F[i11] + ((long) this.A0C[i11]);
    }

    public final void A01() {
        this.A02 = 0;
        this.A06 = 0L;
        this.A0A = false;
        this.A0B = false;
        this.A08 = null;
    }

    public final void A02(int i11) {
        C1376Hz c1376Hz = this.A09;
        if (c1376Hz == null || c1376Hz.A07() < i11) {
            this.A09 = new C1376Hz(i11);
        }
        this.A01 = i11;
        this.A0A = true;
        this.A0B = true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    public final void A03(int i11, int i12) {
        int[] iArr;
        int i13;
        this.A02 = i11;
        this.A00 = i12;
        int[] iArr2 = this.A0E;
        if (iArr2 == null || iArr2.length < i11) {
            long[] jArr = new long[i11];
            if (A0J[2].length() == 0) {
                String[] strArr = A0J;
                strArr[4] = "ZgUWYZPBUUH4f5IflhoFXt9Z2beMZ7L4";
                strArr[5] = "VeOPEMocQkhcG8xqDUtsqj4H6GWeaBG3";
                this.A0G = jArr;
                this.A0E = new int[i11];
                iArr = this.A0D;
                if (iArr == null && iArr.length >= i12) {
                    return;
                }
                i13 = (i12 * 125) / 100;
                this.A0D = new int[i13];
                if (A0J[0].length() == 2) {
                    A0J[1] = "QhoZMJVE40X";
                    this.A0C = new int[i13];
                    this.A0F = new long[i13];
                    this.A0I = new boolean[i13];
                    this.A0H = new boolean[i13];
                    return;
                }
            }
        } else {
            iArr = this.A0D;
            if (iArr == null) {
            }
            i13 = (i12 * 125) / 100;
            this.A0D = new int[i13];
            if (A0J[0].length() == 2) {
                A0J[1] = "QhoZMJVE40X";
                this.A0C = new int[i13];
                this.A0F = new long[i13];
                this.A0I = new boolean[i13];
                this.A0H = new boolean[i13];
                return;
            }
        }
        throw new RuntimeException();
    }

    public final void A04(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.readFully(this.A09.A00, 0, this.A01);
        this.A09.A0Y(0);
        this.A0B = false;
    }

    public final void A05(C1376Hz c1376Hz) {
        c1376Hz.A0c(this.A09.A00, 0, this.A01);
        this.A09.A0Y(0);
        this.A0B = false;
    }
}
