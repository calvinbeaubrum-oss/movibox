package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class ZY extends AbstractC10644r {
    public static byte[] A03;
    public static String[] A04 = {"WP5CpU5dCfM1vj2iCgRczyLeS833jqA7", "f0t6mABNpir4NiI1IJBR", "VMSqLwjWc3fXvu7D9B7JwatTJSWiKmSt", "2kGOlvpEajHcc9JJ5BV7kSrV8Uhb9VDh", "BGGgbgkg4NpzKA2XjpG6Q8iHB2GG9zH0", "ziOTckvigWpUqNYWulExTvMWDfbzI1Sq", "WkLWBkQ13lLgYVln8HDaQ7gYbGPRUWfj", "hZJ2tRP2pGaevCKAXmW2Fr9GhnOGACBf"};
    public C1278Eb A00;
    public Scroller A01;
    public final AbstractC10664t A02 = new ZZ(this);

    static {
        A09();
    }

    private final C1820Zn A05(AbstractC10614o abstractC10614o) {
        return A0E(abstractC10614o);
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    private void A07() {
        this.A00.A1g(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A08() throws IllegalStateException {
        if (this.A00.getOnFlingListener() != null) {
            throw new IllegalStateException(A06(0, 43, Worker.WHAT_SYNC_DATA));
        }
        this.A00.A1f(this.A02);
        this.A00.setOnFlingListener(this);
    }

    public static void A09() {
        byte[] bArr = {-35, 10, -68, 5, 10, Ascii.SI, Ascii.DLE, -3, 10, -1, 1, -68, Ascii.VT, 2, -68, -21, 10, -30, 8, 5, 10, 3, -24, 5, Ascii.SI, Ascii.DLE, 1, 10, 1, Ascii.SO, -68, -3, 8, Ascii.SO, 1, -3, 0, Ascii.NAK, -68, Ascii.SI, 1, Ascii.DLE, -54};
        if (A04[2].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[3] = "Gfsvb5V6ZkZ1EjPhJmDEOg0wCX37AMGK";
        strArr[5] = "BogmwpJuEiSgKohE6B9VLJKkNQC2pxlX";
        A03 = bArr;
    }

    private boolean A0A(AbstractC10614o abstractC10614o, int i11, int i12) {
        C1820Zn c1820ZnA05;
        if (!(abstractC10614o instanceof AnonymousClass50) || (c1820ZnA05 = A05(abstractC10614o)) == null) {
            return false;
        }
        int iA0C = A0C(abstractC10614o, i11, i12);
        String[] strArr = A04;
        if (strArr[0].charAt(25) == strArr[7].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "3QNQgzU1MIdfo8xP0zEWa1SfaSPVi8u7";
        strArr2[7] = "BhxrOivCOMjMD1hwED78TbVHZR3oyoMb";
        if (iA0C == -1) {
            return false;
        }
        c1820ZnA05.A0A(iA0C);
        abstractC10614o.A1L(c1820ZnA05);
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10644r
    public final boolean A0B(int i11, int i12) {
        AbstractC10614o layoutManager = this.A00.getLayoutManager();
        if (layoutManager == null || this.A00.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.A00.getMinFlingVelocity();
        return (Math.abs(i12) > minFlingVelocity || Math.abs(i11) > minFlingVelocity) && A0A(layoutManager, i11, i12);
    }

    public abstract int A0C(AbstractC10614o abstractC10614o, int i11, int i12);

    public abstract View A0D(AbstractC10614o abstractC10614o);

    @Deprecated
    public abstract C1820Zn A0E(AbstractC10614o abstractC10614o);

    public final void A0F() {
        AbstractC10614o layoutManager;
        View viewA0D;
        C1278Eb c1278Eb = this.A00;
        if (c1278Eb == null || (layoutManager = c1278Eb.getLayoutManager()) == null || (viewA0D = A0D(layoutManager)) == null) {
            return;
        }
        int[] iArrA0H = A0H(layoutManager, viewA0D);
        if (iArrA0H[0] == 0 && iArrA0H[1] == 0) {
            return;
        }
        this.A00.A1c(iArrA0H[0], iArrA0H[1]);
    }

    public final void A0G(C1278Eb c1278Eb) throws IllegalStateException {
        C1278Eb c1278Eb2 = this.A00;
        if (c1278Eb2 == c1278Eb) {
            return;
        }
        if (c1278Eb2 != null) {
            A07();
        }
        this.A00 = c1278Eb;
        if (c1278Eb != null) {
            A08();
            this.A01 = new Scroller(this.A00.getContext(), new DecelerateInterpolator());
            A0F();
        }
    }

    public abstract int[] A0H(AbstractC10614o abstractC10614o, View view);
}
