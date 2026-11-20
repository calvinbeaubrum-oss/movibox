package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10142s<E> implements Cloneable {
    public static byte[] A04;
    public static final Object A05;
    public int A00;
    public boolean A01;
    public long[] A02;
    public Object[] A03;

    static {
        A05();
        A05 = new Object();
    }

    public C10142s() {
        this(10);
    }

    public C10142s(int i11) {
        this.A01 = false;
        if (i11 == 0) {
            this.A02 = AbstractC10132r.A01;
            this.A03 = AbstractC10132r.A02;
        } else {
            int iA00 = AbstractC10132r.A00(i11);
            this.A02 = new long[iA00];
            this.A03 = new Object[iA00];
        }
        this.A00 = 0;
    }

    private final long A00(int i11) {
        if (this.A01) {
            A04();
        }
        return this.A02[i11];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C10142s<E> clone() {
        C10142s<E> c10142s = null;
        try {
            c10142s = (C10142s) super.clone();
            c10142s.A02 = (long[]) this.A02.clone();
            c10142s.A03 = (Object[]) this.A03.clone();
            return c10142s;
        } catch (CloneNotSupportedException unused) {
            return c10142s;
        }
    }

    private final E A02(long j11, E e11) {
        E e12;
        int iA03 = AbstractC10132r.A03(this.A02, this.A00, j11);
        return (iA03 < 0 || (e12 = (E) this.A03[iA03]) == A05) ? e11 : e12;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    private void A04() {
        int i11 = this.A00;
        int i12 = 0;
        long[] jArr = this.A02;
        Object[] objArr = this.A03;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != A05) {
                if (i13 != i12) {
                    jArr[i12] = jArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        this.A01 = false;
        this.A00 = i12;
    }

    public static void A05() {
        A04 = new byte[]{19, 79, 83, 82, 72, Ascii.ESC, 118, 90, 75, Ascii.DC2, 91, 87, 51, 53};
    }

    public final int A06() {
        if (this.A01) {
            A04();
        }
        return this.A00;
    }

    public final E A07(int i11) {
        if (this.A01) {
            A04();
        }
        return (E) this.A03[i11];
    }

    public final E A08(long j11) {
        return A02(j11, null);
    }

    public final void A09() {
        int i11 = this.A00;
        Object[] objArr = this.A03;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.A00 = 0;
        this.A01 = false;
    }

    public final void A0A(int i11) {
        Object[] objArr = this.A03;
        Object obj = objArr[i11];
        Object obj2 = A05;
        if (obj != obj2) {
            objArr[i11] = obj2;
            this.A01 = true;
        }
    }

    public final void A0B(long j11, E e11) {
        int iA03 = AbstractC10132r.A03(this.A02, this.A00, j11);
        if (iA03 >= 0) {
            this.A03[iA03] = e11;
            return;
        }
        int iA04 = iA03 ^ (-1);
        int i11 = this.A00;
        if (iA04 < i11) {
            Object[] objArr = this.A03;
            if (objArr[iA04] == A05) {
                this.A02[iA04] = j11;
                objArr[iA04] = e11;
                return;
            }
        }
        if (this.A01 && i11 >= this.A02.length) {
            A04();
            iA04 = AbstractC10132r.A03(this.A02, this.A00, j11) ^ (-1);
        }
        int i12 = this.A00;
        if (i12 >= this.A02.length) {
            int iA00 = AbstractC10132r.A00(i12 + 1);
            long[] jArr = new long[iA00];
            Object[] objArr2 = new Object[iA00];
            long[] jArr2 = this.A02;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.A03;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.A02 = jArr;
            this.A03 = objArr2;
        }
        int i13 = this.A00;
        if (i13 - iA04 != 0) {
            long[] jArr3 = this.A02;
            System.arraycopy(jArr3, iA04, jArr3, iA04 + 1, i13 - iA04);
            Object[] objArr4 = this.A03;
            System.arraycopy(objArr4, iA04, objArr4, iA04 + 1, this.A00 - iA04);
        }
        this.A02[iA04] = j11;
        this.A03[iA04] = e11;
        this.A00++;
    }

    public final String toString() {
        if (A06() <= 0) {
            return A03(12, 2, WebSocketProtocol.PAYLOAD_SHORT);
        }
        StringBuilder sb2 = new StringBuilder(this.A00 * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.A00; i11++) {
            if (i11 > 0) {
                sb2.append(A03(10, 2, 65));
            }
            sb2.append(A00(i11));
            sb2.append('=');
            E eA07 = A07(i11);
            if (eA07 != this) {
                sb2.append(eA07);
            } else {
                sb2.append(A03(0, 10, 13));
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
