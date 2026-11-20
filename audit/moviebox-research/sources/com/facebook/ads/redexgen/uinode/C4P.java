package com.facebook.ads.redexgen.uinode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4P implements Runnable {
    public static Comparator<C4O> A04;
    public static byte[] A05;
    public static String[] A06 = {"C", "g", "thIgEQWd9nx", "UJ", "nKFIv9xSQBz", "WKzZJ6F0j2u08DpGCnjDR9E", "2Nt4JwZoKXCf4OpJNcF1oxTto7W5gJbD", "RW"};
    public static final ThreadLocal<C4P> A07;
    public long A00;
    public long A01;
    public ArrayList<C1278Eb> A02 = new ArrayList<>();
    public ArrayList<C4O> A03 = new ArrayList<>();

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new Comparator<C4O>() { // from class: com.facebook.ads.redexgen.X.4N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(C4O c4o, C4O c4o2) {
                if ((c4o.A03 == null) != (c4o2.A03 == null)) {
                    return c4o.A03 == null ? 1 : -1;
                }
                if (c4o.A04 != c4o2.A04) {
                    return c4o.A04 ? -1 : 1;
                }
                int i11 = c4o2.A02 - c4o.A02;
                if (i11 != 0) {
                    return i11;
                }
                int i12 = c4o.A00 - c4o2.A00;
                if (i12 != 0) {
                    return i12;
                }
                return 0;
            }
        };
    }

    private AnonymousClass56 A00(C1278Eb c1278Eb, int i11, long j11) {
        if (A08(c1278Eb, i11)) {
            return null;
        }
        C10684w c10684w = c1278Eb.A0r;
        try {
            c1278Eb.A1K();
            AnonymousClass56 anonymousClass56A0I = c10684w.A0I(i11, false, j11);
            if (anonymousClass56A0I != null) {
                if (!anonymousClass56A0I.A0Y() || anonymousClass56A0I.A0Z()) {
                    c10684w.A0Z(anonymousClass56A0I, false);
                } else {
                    c10684w.A0T(anonymousClass56A0I.A0H);
                }
            }
            return anonymousClass56A0I;
        } finally {
            c1278Eb.A1m(false);
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    private void A02() {
        C4O c4o;
        int size = this.A02.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            C1278Eb c1278Eb = this.A02.get(i12);
            if (c1278Eb.getWindowVisibility() == 0) {
                c1278Eb.A02.A04(c1278Eb, false);
                i11 += c1278Eb.A02.A00;
            }
        }
        this.A03.ensureCapacity(i11);
        int i13 = 0;
        String[] strArr = A06;
        if (strArr[3].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[3] = "OH";
        strArr2[7] = "7S";
        for (int i14 = 0; i14 < size; i14++) {
            C1278Eb c1278Eb2 = this.A02.get(i14);
            if (c1278Eb2.getWindowVisibility() == 0) {
                C1822Zp c1822Zp = c1278Eb2.A02;
                int iAbs = Math.abs(c1822Zp.A01) + Math.abs(c1822Zp.A02);
                for (int i15 = 0; i15 < c1822Zp.A00 * 2; i15 += 2) {
                    if (i13 >= this.A03.size()) {
                        c4o = new C4O();
                        this.A03.add(c4o);
                    } else {
                        c4o = this.A03.get(i13);
                    }
                    int i16 = c1822Zp.A03[i15 + 1];
                    c4o.A04 = i16 <= iAbs;
                    c4o.A02 = iAbs;
                    c4o.A00 = i16;
                    c4o.A03 = c1278Eb2;
                    c4o.A01 = c1822Zp.A03[i15];
                    i13++;
                }
            }
        }
        Collections.sort(this.A03, A04);
    }

    public static void A03() {
        A05 = new byte[]{97, 101, 47, 93, 116, -126, -125, 116, 115, 47, 95, -127, 116, 117, 116, -125, 114, 119, 92, 96, 42, 90, 124, 111, 112, 111, 126, 109, 114};
    }

    private void A04(long j11) {
        for (int i11 = 0; i11 < this.A03.size(); i11++) {
            C4O c4o = this.A03.get(i11);
            if (c4o.A03 == null) {
                return;
            }
            A06(c4o, j11);
            c4o.A00();
        }
    }

    private final void A05(long j11) {
        A02();
        A04(j11);
    }

    private void A06(C4O c4o, long j11) {
        AnonymousClass56 anonymousClass56A00 = A00(c4o.A03, c4o.A01, c4o.A04 ? Long.MAX_VALUE : j11);
        if (anonymousClass56A00 == null || anonymousClass56A00.A09 == null || !anonymousClass56A00.A0Y() || anonymousClass56A00.A0Z()) {
            return;
        }
        A07(anonymousClass56A00.A09.get(), j11);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0056  */
    /* JADX WARN: Code duplicated, block: B:19:0x0064 A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x006e, blocks: (B:13:0x0030, B:14:0x0043, B:19:0x0064), top: B:27:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0077 A[EDGE_INSN: B:29:0x0077->B:25:0x0077 BREAK  A[LOOP:0: B:14:0x0043->B:31:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private void A07(C1278Eb c1278Eb, long j11) {
        C1822Zp c1822Zp;
        int i11;
        int i12;
        if (c1278Eb == null) {
            return;
        }
        if (c1278Eb.A0C) {
            C4C c4c = c1278Eb.A01;
            if (A06[5].length() != 17) {
                A06[6] = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW";
                if (c4c.A06() != 0) {
                    c1278Eb.A1N();
                }
                c1822Zp = c1278Eb.A02;
                c1822Zp.A04(c1278Eb, true);
                if (c1822Zp.A00 != 0) {
                    return;
                }
                try {
                    AbstractC10122q.A01(A01(0, 18, 7));
                    c1278Eb.A0s.A05(c1278Eb.A04);
                    i11 = 0;
                    while (true) {
                        i12 = c1822Zp.A00 * 2;
                        if (A06[6].charAt(8) != 'I') {
                            break;
                        }
                        String[] strArr = A06;
                        strArr[3] = "nG";
                        strArr[7] = "TD";
                        if (i11 < i12) {
                            AbstractC10122q.A00();
                            return;
                        } else {
                            A00(c1278Eb, c1822Zp.A03[i11], j11);
                            i11 += 2;
                        }
                    }
                } catch (Throwable th2) {
                    AbstractC10122q.A00();
                    throw th2;
                }
            }
        } else {
            c1822Zp = c1278Eb.A02;
            c1822Zp.A04(c1278Eb, true);
            if (c1822Zp.A00 != 0) {
                return;
            }
            AbstractC10122q.A01(A01(0, 18, 7));
            c1278Eb.A0s.A05(c1278Eb.A04);
            i11 = 0;
            while (true) {
                i12 = c1822Zp.A00 * 2;
                if (A06[6].charAt(8) != 'I') {
                    break;
                    break;
                }
                String[] strArr2 = A06;
                strArr2[3] = "nG";
                strArr2[7] = "TD";
                if (i11 < i12) {
                    AbstractC10122q.A00();
                    return;
                } else {
                    A00(c1278Eb, c1822Zp.A03[i11], j11);
                    i11 += 2;
                }
            }
        }
        throw new RuntimeException();
    }

    public static boolean A08(C1278Eb c1278Eb, int i11) {
        int iA06 = c1278Eb.A01.A06();
        for (int i12 = 0; i12 < iA06; i12++) {
            AnonymousClass56 anonymousClass56A0F = C1278Eb.A0F(c1278Eb.A01.A0A(i12));
            if (anonymousClass56A0F.A03 == i11 && !anonymousClass56A0F.A0Z()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C1278Eb c1278Eb) {
        this.A02.add(c1278Eb);
    }

    public final void A0A(C1278Eb c1278Eb) {
        this.A02.remove(c1278Eb);
    }

    public final void A0B(C1278Eb c1278Eb, int i11, int i12) {
        if (c1278Eb.isAttachedToWindow() && this.A01 == 0) {
            this.A01 = c1278Eb.getNanoTime();
            c1278Eb.post(this);
        }
        c1278Eb.A02.A03(i11, i12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC10122q.A01(A01(18, 11, 2));
            if (this.A02.isEmpty()) {
                this.A01 = 0L;
                AbstractC10122q.A00();
                return;
            }
            int size = this.A02.size();
            long jMax = 0;
            for (int i11 = 0; i11 < size; i11++) {
                C1278Eb c1278Eb = this.A02.get(i11);
                if (c1278Eb.getWindowVisibility() == 0) {
                    jMax = Math.max(c1278Eb.getDrawingTime(), jMax);
                }
            }
            if (jMax != 0) {
                A05(TimeUnit.MILLISECONDS.toNanos(jMax) + this.A00);
                this.A01 = 0L;
                AbstractC10122q.A00();
            } else {
                this.A01 = 0L;
                if (A06[5].length() == 17) {
                    throw new RuntimeException();
                }
                A06[5] = "H4nD1dOrFb1";
                AbstractC10122q.A00();
            }
        } catch (Throwable th2) {
            this.A01 = 0L;
            AbstractC10122q.A00();
            throw th2;
        }
    }
}
