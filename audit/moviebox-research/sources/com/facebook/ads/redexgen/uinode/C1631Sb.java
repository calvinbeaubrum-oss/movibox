package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1631Sb extends AbstractC10664t {
    public static byte[] A0H;
    public static String[] A0I = {"vVts3290hN8iYOphvTtUHsw8p", "g", "QXZRYfiopoOIgyOb", "uRY3EBcOhcPzIFCW", "1yhQGC5wOot73mjsntHrCCOy6H7", "ngPHprqJPXgJBcmGEhNrmzVf2B4dA5Oh", "DCeBbFrEMIUsiq6", "addqTveDrmk"};
    public InterfaceC1541Op A02;
    public RE A04;
    public List<C1567Pp> A05;
    public boolean A09;
    public final int A0A;
    public final Context A0B;
    public final C1821Zo A0C;
    public final AnonymousClass51 A0D;
    public final Set<Integer> A0G = new HashSet();
    public boolean A08 = true;
    public boolean A06 = true;
    public boolean A07 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final InterfaceC1545Ot A0F = new C1634Se(this);
    public InterfaceC1543Or A03 = new C1633Sd(this);
    public final InterfaceC1544Os A0E = new C1632Sc(this);

    static {
        A08();
    }

    public C1631Sb(C10393r c10393r, int i11, List<C1567Pp> list, RE re2, Bundle bundle) {
        this.A0C = c10393r.getLayoutManager();
        this.A0A = i11;
        this.A05 = list;
        this.A04 = re2;
        this.A0D = new C1820Zn(c10393r.getContext());
        this.A0B = c10393r.getContext();
        c10393r.A1f(this);
        A0D(bundle);
    }

    private TS A03(int i11, int i12) {
        return A04(i11, i12, true);
    }

    private TS A04(int i11, int i12, boolean z11) {
        TS ts2 = null;
        while (i11 <= i12) {
            TS ts3 = (TS) this.A0C.A1m(i11);
            if (ts3 == null || ts3.A17()) {
                return null;
            }
            boolean zA0a = A0a(ts3);
            if (A0I[2].length() != 16) {
                throw new RuntimeException();
            }
            A0I[0] = "";
            if (ts2 == null && ts3.A18() && zA0a && !this.A0G.contains(Integer.valueOf(i11)) && (!z11 || A0I(ts3, this.A0A))) {
                ts2 = ts3;
            }
            if (ts3.A18() && !zA0a) {
                A0C(i11, false);
            }
            i11++;
        }
        return ts2;
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 126);
        }
        return new String(bArrCopyOfRange);
    }

    private void A06() {
        TS tsA03;
        if (this.A07 && (tsA03 = A03(this.A0C.A24(), this.A0C.A25())) != null) {
            tsA03.A15();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int iA23 = this.A0C.A23();
        if (iA23 == -1 || iA23 >= this.A05.size() - 1) {
            return;
        }
        A0U(iA23 + 1);
    }

    public static void A08() {
        A0H = new byte[]{-26, -6, -7, -12, 4, -11, -15, -26, -2, 4, -22, -13, -26, -25, -15, -22, -23, 4, -11, -26, -9, -26, -14, 7, 17, Ascii.GS, 4, 7, Ascii.DLE, 17, Ascii.DC2, Ascii.GS, Ascii.DC4, 7, 2, 3, Ascii.CR, Ascii.GS, Ascii.SO, -1, Ascii.DLE, -1, Ascii.VT, -5, -12, -15, -6, -14, -22, 4, -15, -22, -5, -22, -15, 4, -11, -26, -9, -26, -14};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(int i11) {
        TS tsA04 = A04(i11 + 1, this.A0C.A25(), false);
        if (tsA04 != null) {
            tsA04.A15();
            A0U(((Integer) tsA04.getTag(-1593835536)).intValue());
        }
    }

    private void A0A(int i11, int i12) {
        while (i11 <= i12) {
            A0T(i11);
            i11++;
        }
    }

    private final void A0B(int i11, int i12) {
        A0S(i11);
        A0S(i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i11, boolean z11) {
        if (z11) {
            this.A0G.add(Integer.valueOf(i11));
        } else {
            this.A0G.remove(Integer.valueOf(i11));
        }
    }

    private void A0D(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 39), 0.0f);
        this.A07 = bundle.getBoolean(A05(0, 23, 39), true);
        this.A08 = bundle.getBoolean(A05(23, 20, 64), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H() {
        return this.A0A == 1;
    }

    public static boolean A0I(OL ol2, int i11) {
        int width;
        if (i11 == 2) {
            int i12 = LD.A03.widthPixels;
            if (A0I[5].charAt(29) != '5') {
                throw new RuntimeException();
            }
            A0I[0] = "Sny8hSa0LYjBAej7q";
            width = i12 - 1;
        } else {
            width = (int) (((ol2.getWidth() + LD.A03.widthPixels) * 1.3f) / 2.0f);
        }
        return ((int) (ol2.getX() + ((float) ol2.getWidth()))) <= width && ol2.getX() >= ((float) (i11 == 2 ? 1 : (int) ((((float) (LD.A03.widthPixels - ol2.getWidth())) * 0.7f) / 2.0f)));
    }

    private boolean A0J(TS ts2) {
        if (!this.A08 || !ts2.A18()) {
            return false;
        }
        this.A08 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10664t
    public void A0L(C1278Eb c1278Eb, int i11) {
        super.A0L(c1278Eb, i11);
        if (i11 == 0) {
            this.A09 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10664t
    public void A0M(C1278Eb c1278Eb, int i11, int i12) {
        super.A0M(c1278Eb, i11, i12);
        this.A09 = false;
        if (this.A06) {
            this.A09 = true;
            A06();
            this.A06 = false;
        }
        int iA24 = this.A0C.A24();
        int iA25 = this.A0C.A25();
        A0B(iA24, iA25);
        A0A(iA24, iA25);
        A0V(iA24, iA25, i11);
    }

    public final InterfaceC1543Or A0N() {
        return this.A03;
    }

    public final InterfaceC1544Os A0O() {
        return this.A0E;
    }

    public final InterfaceC1545Ot A0P() {
        return this.A0F;
    }

    public final void A0Q() {
        this.A01 = -1;
        int iA25 = this.A0C.A25();
        for (int iA24 = this.A0C.A24(); iA24 <= iA25 && iA24 >= 0; iA24++) {
            TS ts2 = (TS) this.A0C.A1m(iA24);
            if (ts2 != null && ts2.A17()) {
                this.A01 = iA24;
                ts2.A14();
                return;
            }
        }
    }

    public final void A0R() {
        TS ts2 = (TS) this.A0C.A1m(this.A01);
        if (ts2 == null || this.A01 < 0) {
            return;
        }
        ts2.A15();
    }

    public final void A0S(int i11) {
        TS ts2 = (TS) this.A0C.A1m(i11);
        if (ts2 == null || A0a(ts2)) {
            return;
        }
        String[] strArr = A0I;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0I[0] = "Vxamqv9qm4zlsVVB8";
        A0Z(ts2, false);
    }

    public final void A0T(int i11) {
        List<C1567Pp> list;
        TS ts2 = (TS) this.A0C.A1m(i11);
        if (ts2 == null) {
            return;
        }
        if (A0a(ts2)) {
            A0Z(ts2, true);
        }
        if (!A0J(ts2) || (list = this.A05) == null) {
            return;
        }
        this.A0F.setVolume(list.get(((Integer) ts2.getTag(-1593835536)).intValue()).A03().A0D().A09() ? 0.0f : 1.0f);
    }

    public final void A0U(int i11) {
        this.A0D.A0A(i11);
        this.A0C.A1L(this.A0D);
    }

    public final void A0V(int i11, int i12, int i13) {
        if (!A0H() || this.A02 == null) {
            return;
        }
        int iA23 = this.A0C.A23();
        if (iA23 == -1) {
            iA23 = i13 < 0 ? i11 : i12;
        }
        this.A02.AGp(iA23);
    }

    public final void A0W(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 39), this.A00);
        bundle.putBoolean(A05(0, 23, 39), this.A07);
        bundle.putBoolean(A05(23, 20, 64), this.A08);
    }

    public void A0X(View view, boolean z11) {
        view.setAlpha(z11 ? 1.0f : 0.5f);
    }

    public final void A0Y(InterfaceC1541Op interfaceC1541Op) {
        this.A02 = interfaceC1541Op;
    }

    public void A0Z(TS ts2, boolean z11) {
        if (A0H()) {
            A0X(ts2, z11);
        }
        if (z11) {
            return;
        }
        boolean zA17 = ts2.A17();
        String[] strArr = A0I;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0I[2] = "slnyAJQBNPORwedJ";
        if (zA17) {
            ts2.A14();
        }
    }

    public boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }
}
