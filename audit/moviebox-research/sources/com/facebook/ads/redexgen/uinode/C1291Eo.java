package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1291Eo {
    public static String[] A04 = {"TJGXeByBmTHQPhxlQWaLs9WTuhAPsvDn", "cTyjqlp8UNOQyLJMZAg4XzmxFMTsV66P", "jpK43NGJIXClE5ie7D0g7Fa1Rpa7kANX", "QOLMQ2OzOpXdQRVqr", "8HaEwRmcLljD6jWZTmAaPx2QrUAiOCOo", "DwqRJ6bMYzXyiD2Eugn3dkRE0I23BFLv", "IP6wvLF5I09xjY7fYX", "9PCiAf0"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;

    public C1291Eo(int i11) {
        this(i11, -1L);
    }

    public C1291Eo(int i11, int i12, int i13, long j11) {
        this.A02 = i11;
        this.A00 = i12;
        this.A01 = i13;
        this.A03 = j11;
    }

    public C1291Eo(int i11, long j11) {
        this(i11, -1, -1, j11);
    }

    public final C1291Eo A00(int i11) {
        return this.A02 == i11 ? this : new C1291Eo(i11, this.A00, this.A01, this.A03);
    }

    public final boolean A01() {
        return this.A00 != -1;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[ORIG_RETURN, RETURN] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1291Eo c1291Eo = (C1291Eo) obj;
        int i11 = this.A02;
        int i12 = c1291Eo.A02;
        if (A04[5].charAt(6) == 'n') {
            throw new RuntimeException();
        }
        A04[5] = "1RYqQKBI4tHo2l91LJlKc5yEyLaxvrL0";
        if (i11 == i12 && this.A00 == c1291Eo.A00) {
            int i13 = this.A01;
            if (A04[6].length() != 3) {
                A04[3] = "Mb83VhRFw0YfLpvsGxQ6UEzyZMUp7";
                if (i13 == c1291Eo.A01) {
                    if (this.A03 == c1291Eo.A03) {
                        return true;
                    }
                }
            } else if (i13 == c1291Eo.A01) {
                if (this.A03 == c1291Eo.A03) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((17 * 31) + this.A02) * 31) + this.A00) * 31) + this.A01) * 31) + ((int) this.A03);
    }
}
