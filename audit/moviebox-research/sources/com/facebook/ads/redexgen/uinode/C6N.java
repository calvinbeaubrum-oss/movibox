package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6N {
    public static C6O A00;
    public static boolean A01;
    public static byte[] A02;

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        synchronized (C6N.class) {
            if (A00 == null) {
                return;
            }
            C8B c8b = new C8B(A00.AFE());
            c8b.A05(1);
            C1794Ym c1794YmA00 = AbstractC11227e.A00();
            if (c1794YmA00 != null) {
                c1794YmA00.A07().A9a(A00(0, 9, 109), 3401, c8b);
            }
            A00.reset();
        }
    }

    public static void A02() {
        A02 = new byte[]{-24, -21, -12, -23, -18, -13, -25, -8, -15};
    }

    public static void A03(final long j11) {
        if (j11 > 0) {
            A00 = new C1804Yw();
            new Thread(j11) { // from class: com.facebook.ads.redexgen.X.6P
                public final long A00;

                {
                    this.A00 = j11;
                    start();
                }

                /* JADX WARN: Bottom block not found for handler: all -> 0x0011 */
                @Override // java.lang.Thread, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    while (true) {
                        try {
                            Thread.sleep(this.A00);
                        } catch (InterruptedException unused) {
                        }
                        C6N.A01();
                    }
                }
            };
        }
    }
}
