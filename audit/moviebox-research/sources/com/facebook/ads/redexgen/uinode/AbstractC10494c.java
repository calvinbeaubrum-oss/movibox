package com.facebook.ads.redexgen.uinode;

import android.view.ViewGroup;
import com.facebook.ads.redexgen.uinode.AnonymousClass56;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10494c<VH extends AnonymousClass56> {
    public static byte[] A02;
    public static String[] A03 = {"W324oDAhe3QD27ZyNAxx1dE4409WhTwA", "Ikg10MzvREcGgl38", "tAS262iMJzRr57vvpxPoG7SYxewns3xN", "rCt", "3uu7", "cbDGC8uMMSmc1mSYy17nilWnTwttZfvA", "2T", "U5f6pdP97"};
    public final C10504d A01 = new C10504d();
    public boolean A00 = false;

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[2].charAt(21) != '7') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "WHsKZN6zyncpMK6d";
            strArr[4] = "wlW4";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 32);
            i14++;
        }
    }

    public static void A01() {
        A02 = new byte[]{-48, -44, -98, -63, -16, -29, -33, -14, -29, -44, -25, -29, -11, -54, -50, -104, -57, -26, -70, -31, -26, -36, -50, -31, -35, -17};
    }

    private final void A02(VH vh2, int i11, List<Object> list) {
        A0D(vh2, i11);
    }

    public final int A03(int i11) {
        return 0;
    }

    public final long A04(int i11) {
        return -1L;
    }

    public final VH A05(ViewGroup viewGroup, int i11) {
        AbstractC10122q.A01(A00(0, 13, 94));
        VH vh2 = (VH) A0C(viewGroup, i11);
        vh2.A00 = i11;
        AbstractC10122q.A00();
        return vh2;
    }

    public final void A06() {
        this.A01.A00();
    }

    public final void A07(AbstractC10514e abstractC10514e) {
        this.A01.registerObserver(abstractC10514e);
    }

    public final void A08(AbstractC10514e abstractC10514e) {
        this.A01.unregisterObserver(abstractC10514e);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0074  */
    /* JADX WARN: Code duplicated, block: B:9:0x0053  */
    public final void A09(VH vh2, int i11) {
        ViewGroup.LayoutParams layoutParams;
        String[] strArr;
        vh2.A03 = i11;
        if (A0A()) {
            long jA04 = A04(i11);
            String[] strArr2 = A03;
            if (strArr2[7].length() != strArr2[6].length()) {
                String[] strArr3 = A03;
                strArr3[7] = "OgtetI94x";
                strArr3[6] = "QU";
                vh2.A05 = jA04;
                vh2.A0U(1, 519);
                AbstractC10122q.A01(A00(13, 13, 88));
                A02(vh2, i11, vh2.A0L());
                vh2.A0N();
                layoutParams = vh2.A0H.getLayoutParams();
                if (layoutParams instanceof C10624p) {
                    ((C10624p) layoutParams).A01 = true;
                }
                AbstractC10122q.A00();
                strArr = A03;
                if (strArr[5].charAt(31) == strArr[0].charAt(31)) {
                    String[] strArr4 = A03;
                    strArr4[7] = "GQKIQ0ZEK";
                    strArr4[6] = "Zf";
                    return;
                }
            }
        } else {
            vh2.A0U(1, 519);
            AbstractC10122q.A01(A00(13, 13, 88));
            A02(vh2, i11, vh2.A0L());
            vh2.A0N();
            layoutParams = vh2.A0H.getLayoutParams();
            if (layoutParams instanceof C10624p) {
                ((C10624p) layoutParams).A01 = true;
            }
            AbstractC10122q.A00();
            strArr = A03;
            if (strArr[5].charAt(31) == strArr[0].charAt(31)) {
                String[] strArr5 = A03;
                strArr5[7] = "GQKIQ0ZEK";
                strArr5[6] = "Zf";
                return;
            }
        }
        throw new RuntimeException();
    }

    public final boolean A0A() {
        return this.A00;
    }

    public final boolean A0B(VH vh2) {
        return false;
    }

    public abstract VH A0C(ViewGroup viewGroup, int i11);

    public abstract void A0D(VH vh2, int i11);

    public abstract int A0E();
}
