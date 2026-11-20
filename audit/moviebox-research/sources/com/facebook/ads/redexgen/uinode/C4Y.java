package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4Y {
    public static byte[] A03;
    public int A00;
    public final Rect A01;
    public final AbstractC10614o A02;

    static {
        A04();
    }

    public C4Y(AbstractC10614o abstractC10614o) {
        this.A00 = Integer.MIN_VALUE;
        this.A01 = new Rect();
        this.A02 = abstractC10614o;
    }

    public /* synthetic */ C4Y(AbstractC10614o abstractC10614o, C1819Zm c1819Zm) {
        this(abstractC10614o);
    }

    public static C1819Zm A00(AbstractC10614o abstractC10614o) {
        return new C1819Zm(abstractC10614o);
    }

    public static C1818Zl A01(AbstractC10614o abstractC10614o) {
        return new C1818Zl(abstractC10614o);
    }

    public static C4Y A02(AbstractC10614o abstractC10614o, int i11) {
        switch (i11) {
            case 0:
                return A00(abstractC10614o);
            case 1:
                return A01(abstractC10614o);
            default:
                throw new IllegalArgumentException(A03(0, 19, 11));
        }
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{84, 83, 75, 92, 81, 84, 89, Ascii.GS, 82, 79, 84, 88, 83, 73, 92, 73, 84, 82, 83};
    }

    public final int A05() {
        if (Integer.MIN_VALUE == this.A00) {
            return 0;
        }
        return A0B() - this.A00;
    }

    public abstract int A06();

    public abstract int A07();

    public abstract int A08();

    public abstract int A09();

    public abstract int A0A();

    public abstract int A0B();

    public abstract int A0C(View view);

    public abstract int A0D(View view);

    public abstract int A0E(View view);

    public abstract int A0F(View view);

    public abstract int A0G(View view);

    public abstract int A0H(View view);

    public final void A0I() {
        this.A00 = A0B();
    }

    public abstract void A0J(int i11);
}
