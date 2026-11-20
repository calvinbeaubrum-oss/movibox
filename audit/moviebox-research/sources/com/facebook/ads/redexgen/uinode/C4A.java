package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4A {
    public static byte[] A02;
    public static String[] A03 = {"bULQ32o9JJN83aCucFVWf9xMaMFfdsau", "BEVDZxUetTHXZyMQk8onv0fPj1ZBZ1Qa", "0vYpub5LBkfCpAgXclsnPo1", "vVWBcEJQjEsfNalmzVe1r7miASaPIW1B", "LFkzDQh", "g5RhG8eWHWtWI7ENz9qYtKd", "50dEOoYhOQRa91fvkd77j3svvS12NHRj", "eQbNRdF"};
    public long A00 = 0;
    public C4A A01;

    static {
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 5);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        if (this.A01 == null) {
            this.A01 = new C4A();
        }
    }

    public static void A02() {
        A02 = new byte[]{-34, -34};
    }

    public final int A03(int i11) {
        C4A c4a = this.A01;
        if (c4a == null) {
            return i11 >= 64 ? Long.bitCount(this.A00) : Long.bitCount(this.A00 & ((1 << i11) - 1));
        }
        return i11 < 64 ? Long.bitCount(this.A00 & ((1 << i11) - 1)) : c4a.A03(i11 - 64) + Long.bitCount(this.A00);
    }

    public final void A04() {
        this.A00 = 0L;
        C4A c4a = this.A01;
        if (c4a != null) {
            c4a.A04();
        }
    }

    public final void A05(int i11) {
        if (i11 >= 64) {
            C4A c4a = this.A01;
            if (c4a != null) {
                c4a.A05(i11 - 64);
                return;
            }
            return;
        }
        long j11 = this.A00 & ((1 << i11) ^ (-1));
        if (A03[1].charAt(31) != 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "FQtQPqX5zshXn4VmNwTVsnzPJS3Krcw4";
        strArr[3] = "mEVd87EgPvtBoIzzDeJnjIPIOSUL2jIs";
        this.A00 = j11;
    }

    public final void A06(int i11) {
        if (i11 < 64) {
            this.A00 |= 1 << i11;
        } else {
            A01();
            this.A01.A06(i11 - 64);
        }
    }

    public final void A07(int i11, boolean z11) {
        if (i11 >= 64) {
            A01();
            this.A01.A07(i11 - 64, z11);
            return;
        }
        long j11 = this.A00;
        boolean z12 = (Long.MIN_VALUE & j11) != 0;
        long j12 = (1 << i11) - 1;
        this.A00 = (j11 & j12) | ((j11 & ((-1) ^ j12)) << 1);
        if (z11) {
            A06(i11);
        } else {
            A05(i11);
        }
        if (z12 || this.A01 != null) {
            A01();
            this.A01.A07(0, z12);
        }
    }

    public final boolean A08(int i11) {
        if (i11 < 64) {
            return (this.A00 & (1 << i11)) != 0;
        }
        A01();
        return this.A01.A08(i11 - 64);
    }

    public final boolean A09(int i11) {
        if (i11 >= 64) {
            A01();
            return this.A01.A09(i11 - 64);
        }
        long j11 = 1 << i11;
        long j12 = this.A00;
        boolean z11 = (j12 & j11) != 0;
        long j13 = j12 & (j11 ^ (-1));
        this.A00 = j13;
        long j14 = j11 - 1;
        this.A00 = (j13 & j14) | Long.rotateRight(j13 & ((-1) ^ j14), 1);
        C4A c4a = this.A01;
        if (c4a != null) {
            if (c4a.A08(0)) {
                A06(63);
            }
            this.A01.A09(0);
        }
        return z11;
    }

    public final String toString() {
        if (this.A01 != null) {
            return this.A01.toString() + A00(0, 2, 97) + Long.toBinaryString(this.A00);
        }
        long j11 = this.A00;
        if (A03[1].charAt(31) != 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[2] = "hJ9KUEYMHtIt6rT1Ez0KfdL";
        strArr[5] = "B6CHA8tZa8vt0H5l4hWvu9Y";
        return Long.toBinaryString(j11);
    }
}
