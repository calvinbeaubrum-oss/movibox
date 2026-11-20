package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.So, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1644So extends FrameLayout implements MD {
    public static byte[] A0L;
    public static String[] A0M = {"n8b1XAz0kHAkpiWEmzC3t1pF5U", "eWK394xXCAUBfgpESuKIG56NqbrNFWJq", "5CdOn8t3diym6HDjOq5Y6uNvOx4lt5g3", "HN0pIlpAYl374dQUYji0gU", "nPJn2NzIeBIJ0ob92wkGV5", "7vv965TmOe", "OL6PAd", "N5PSCRASy1"};
    public static final RelativeLayout.LayoutParams A0N;
    public int A00;
    public int A01;
    public int A02;
    public C1520Nu A03;
    public PQ A04;
    public Q7 A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C1896b3 A0A;
    public final C5T A0B;
    public final C11006c A0C;
    public final C1795Yn A0D;
    public final J2 A0E;
    public final JA A0F;
    public final ViewOnSystemUiVisibilityChangeListenerC1449Lb A0G;
    public final MC A0H;
    public final FullScreenAdToolbar A0I;
    public final InterfaceC1483Mj A0J;
    public final ArrayList<C1554Pc> A0K;

    static {
        A0D();
        A0N = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C1644So(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, J2 j11, C1896b3 c1896b3, C11006c c11006c, MC mc2) {
        super(c1795Yn);
        this.A0K = new ArrayList<>();
        this.A09 = false;
        this.A07 = false;
        this.A08 = false;
        this.A06 = true;
        this.A02 = 1;
        this.A00 = 0;
        this.A01 = 0;
        this.A0B = new C1647Sr(this);
        this.A0D = c1795Yn;
        this.A0J = interfaceC1483Mj;
        this.A0E = j11;
        this.A0A = c1896b3;
        this.A0C = c11006c;
        this.A0H = mc2;
        this.A0F = new JA(c1896b3.A0v(0).A12(), j11);
        ViewOnSystemUiVisibilityChangeListenerC1449Lb viewOnSystemUiVisibilityChangeListenerC1449Lb = new ViewOnSystemUiVisibilityChangeListenerC1449Lb(this);
        this.A0G = viewOnSystemUiVisibilityChangeListenerC1449Lb;
        viewOnSystemUiVisibilityChangeListenerC1449Lb.A05(EnumC1448La.A03);
        this.A05 = new Q7(c1795Yn, interfaceC1483Mj, c1896b3.A0T(), mc2);
        FullScreenAdToolbar fullScreenAdToolbarA05 = A05();
        this.A0I = fullScreenAdToolbarA05;
        addView(fullScreenAdToolbarA05, new FrameLayout.LayoutParams(-1, fullScreenAdToolbarA05.getToolbarHeight()));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080  */
    private int A00() {
        if (!this.A09) {
            PQ pq2 = this.A04;
            if (pq2 == null || !pq2.A15() || this.A0A.A0r() != 1) {
                return 0;
            }
            int i11 = this.A02;
            String[] strArr = A0M;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0M[1] = "h3DELnp0sNRc9bbpqXLt3U6CPzizCup7";
            A0R(false, i11);
            return 1;
        }
        if (A0S()) {
            PQ pq3 = this.A04;
            String[] strArr2 = A0M;
            if (strArr2[6].length() != strArr2[0].length()) {
                A0M[2] = "PfeCIYv3PZ6V9ed6Ac8a5BK1jHBlhn63";
                if (pq3 != null) {
                    if (!pq3.A15() || this.A0A.A0r() == 2 || !this.A04.A14()) {
                        if (!this.A0A.A14()) {
                            this.A08 = true;
                        }
                        A0R(false, this.A02);
                        return 2;
                    }
                }
            } else {
                String[] strArr3 = A0M;
                strArr3[7] = "uk3hUwbnz5";
                strArr3[5] = "FBSNZaACy9";
                if (pq3 != null) {
                    if (!pq3.A15()) {
                    }
                    if (!this.A0A.A14()) {
                        this.A08 = true;
                    }
                    A0R(false, this.A02);
                    return 2;
                }
            }
        }
        PQ pq4 = this.A04;
        if (pq4 != null && pq4.A14()) {
            FullScreenAdToolbar fullScreenAdToolbar = this.A0I;
            String[] strArr4 = A0M;
            if (strArr4[7].length() != strArr4[5].length()) {
                String[] strArr5 = A0M;
                strArr5[6] = "XNlvih";
                strArr5[0] = "F6xo912A6Q9UlQk1GkOWqLDA82";
                fullScreenAdToolbar.setToolbarActionMode(0);
                this.A0D.A0E().A4F();
                this.A04.A10();
                return 0;
            }
            String[] strArr6 = A0M;
            strArr6[7] = "jW6HqSaxZ9";
            strArr6[5] = "bsBLZCHN0w";
            fullScreenAdToolbar.setToolbarActionMode(0);
            this.A0D.A0E().A4F();
            this.A04.A10();
            return 3;
        }
        if (A0T()) {
            boolean zA0U = A0U();
            String[] strArr7 = A0M;
            if (strArr7[6].length() == strArr7[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr8 = A0M;
            strArr8[6] = "4cWKRp";
            strArr8[0] = "mDqcFWF9PWFdOJ8RIxKoy3CWob";
            if (!zA0U) {
                A0C();
                return 4;
            }
        }
        if ((this.A04 instanceof T8) && A0S()) {
            A0R(false, this.A02);
            return 5;
        }
        JA ja2 = this.A0F;
        if (A0M[2].charAt(7) != '3') {
            ja2.A04(J9.A07, null);
            A0H(4);
            return 6;
        }
        String[] strArr9 = A0M;
        strArr9[6] = "m8cXZ3";
        strArr9[0] = "vuCqBh4GGcmIEOdpzcwHlLdLjb";
        ja2.A04(J9.A07, null);
        A0H(4);
        return 6;
    }

    private int A01(int i11) {
        return (!this.A0A.A14() || i11 >= this.A0A.A0z().size() || i11 < 0) ? this.A0A.A0G() : this.A0A.A0z().get(i11).intValue();
    }

    public static /* synthetic */ int A02(C1644So c1644So, int i11) {
        int i12 = c1644So.A01 + i11;
        c1644So.A01 = i12;
        return i12;
    }

    private FullScreenAdToolbar A05() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A0D, this.A0H, this.A0F, 2);
        fullScreenAdToolbar.setFullscreen(true);
        fullScreenAdToolbar.setToolbarListener(new C1645Sp(this));
        return fullScreenAdToolbar;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0034  */
    private PQ A08(boolean z11, int i11) {
        boolean z12;
        C1646Sq c1646Sq = new C1646Sq(this, i11);
        AbstractC1898b5 abstractC1898b5A0v = this.A0A.A0v(this.A00);
        if (this.A0A.A13()) {
            int i12 = this.A00;
            String[] strArr = A0M;
            if (strArr[3].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            A0M[2] = "bDB0WKM3tjeRkIfEXbhmbXqmjWoJ3lp1";
            if (i12 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            z12 = false;
        }
        boolean z13 = this.A0A.A12() && this.A00 > 0;
        String strA0x = this.A0A.A0x();
        if (A0V(abstractC1898b5A0v)) {
            int iA01 = A01(this.A00);
            if (iA01 == 0) {
                this.A09 = true;
            }
            this.A0D.A0E().AGG(EnumC09490e.A05);
            this.A0D.A0E().AFv(this.A00);
            this.A0D.A0E().A4D(strA0x);
            return new T8(this.A0D, this.A0J, this.A00, this.A0E, abstractC1898b5A0v, this.A0H, this.A0I, z12, z13, c1646Sq, iA01);
        }
        if (abstractC1898b5A0v.A0x().A0N()) {
            this.A0D.A0E().AGG(EnumC09490e.A06);
            this.A0D.A0E().AFv(this.A00);
            this.A0D.A0E().A4D(strA0x);
            return new C1653Sx(this.A0D, this.A0E, this.A0I, abstractC1898b5A0v, this.A0C, this.A0J, this.A00, this.A0H, this.A0F, i11, z12, z13, c1646Sq);
        }
        this.A0D.A0E().AGG(EnumC09490e.A06);
        this.A0D.A0E().AFv(this.A00);
        this.A0D.A0E().A4D(strA0x);
        return new T4(this.A0D, this.A0E, abstractC1898b5A0v, this.A0C, this.A0J, this.A00, this.A0H, this.A0F, this.A0A.A0G(), i11, this.A0A.A0r(), z11, this.A0A.A0t(), this.A0A.A14(), z12, z13, c1646Sq);
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        int iA00 = A00();
        if (iA00 != 0) {
            this.A0D.A0E().A4G(iA00);
        }
    }

    private void A0B() {
        int i11 = this.A00;
        if (i11 <= 0 || TextUtils.isEmpty(this.A0A.A0v(i11 - 1).A12())) {
            return;
        }
        J2 j11 = this.A0E;
        String strA12 = this.A0A.A0v(this.A00 - 1).A12();
        C1508Ni c1508Ni = new C1508Ni();
        PQ pq2 = this.A04;
        C1508Ni c1508NiA03 = c1508Ni.A03(pq2 != null ? pq2.getAdViewabilityChecker() : null);
        PQ pq3 = this.A04;
        j11.A9X(strA12, c1508NiA03.A02(pq3 != null ? pq3.getTouchDataRecorder() : null).A05());
    }

    private void A0C() {
        this.A0D.A0E().A4E();
        this.A07 = true;
        this.A03 = new C1520Nu(this.A0D, this.A0A, this.A0E, this.A0H, this.A0I.getToolbarHeight(), this.A02);
        C1554Pc c1554Pc = null;
        Iterator<C1554Pc> it = this.A0K.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0M[1].charAt(22) == '6') {
                String[] strArr = A0M;
                strArr[7] = "ZPnrdglx3i";
                strArr[5] = "Z92DtyKnO3";
                if (!zHasNext) {
                    break;
                }
                C1554Pc next = it.next();
                if (next.A00 == C1554Pc.A06) {
                    c1554Pc = next;
                    break;
                }
            } else {
                throw new RuntimeException();
            }
        }
        if (c1554Pc != null) {
            A0I(this.A03, c1554Pc);
        } else if (!this.A0K.isEmpty()) {
            A0I(this.A03, this.A0K.get(0));
        }
        A0Q(true);
        this.A0I.setOnlyPageDetails(null);
        PQ pq2 = this.A04;
        if (pq2 != null) {
            AbstractC1462Lo.A0J(pq2);
            this.A04.A0z();
            this.A04 = null;
        }
        AbstractC1462Lo.A0J(this.A03);
        AbstractC1462Lo.A0G(1102, this.A03);
        addView(this.A03, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public static void A0D() {
        A0L = new byte[]{113, -64, -73, 113, -62, -27, -95};
        String[] strArr = A0M;
        if (strArr[3].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A0M[2] = "BvaU1dA3vF4hXYIjQV5InfWnSlZ4OmYy";
    }

    private final void A0E() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.A0G.A05(EnumC1448La.A04);
    }

    private synchronized void A0F() {
        this.A0H.A43(this.A0J.A5s());
        this.A05.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(float f11) {
        float fA01 = A01(this.A00 - 1);
        float f12 = fA01 > 0.0f ? ((this.A0A.A14() ? 0 : this.A01) + f11) / fA01 : 1.0f;
        if (this.A06 && this.A0A.A14()) {
            this.A06 = false;
            this.A0I.setProgressImmediate(0.0f);
        }
        this.A0I.setProgress(100.0f * f12);
        if (f12 < 1.0f || this.A09) {
            return;
        }
        this.A09 = true;
        this.A0I.setToolbarActionMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(int i11) {
        this.A0D.A0E().A4B(i11);
        this.A09 = true;
        A0F();
        A0B();
        this.A0H.A43(this.A0J.A6u());
    }

    private void A0I(ViewGroup viewGroup, C1554Pc c1554Pc) {
        if (c1554Pc.A00 != C1554Pc.A06 || c1554Pc.A03 == null) {
            AbstractC1462Lo.A0M(viewGroup, c1554Pc.A01);
        } else {
            OA.A00(this.A0D, viewGroup, c1554Pc.A03);
        }
        this.A0I.setFullscreen(c1554Pc.A05);
        this.A0I.A06(c1554Pc.A02, c1554Pc.A04);
    }

    private void A0J(AbstractC1898b5 abstractC1898b5) {
        if (A0V(abstractC1898b5)) {
            int i11 = this.A02;
            if (A0M[2].charAt(7) != '3') {
                throw new RuntimeException();
            }
            A0M[2] = "vyv5r133RkdgG8M1gH7WIgZDBjsgq9Je";
            if (i11 == 2) {
                this.A0I.setOnlyPageDetails(abstractC1898b5.A10());
                return;
            }
        }
        this.A0I.setOnlyPageDetails(null);
    }

    private final void A0K(C5V c5v) {
        c5v.A0N(this.A0B);
        int i11 = c5v.A0J().getResources().getConfiguration().orientation;
        this.A02 = i11;
        A0R(this.A0A.A11(), i11);
        A0E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Q(boolean z11) {
        boolean z12 = (!A0T() || A0S() || A0U()) ? false : true;
        boolean zA0S = A0S();
        if (A0M[1].charAt(22) != '6') {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[7] = "fhNsXNJVUA";
        strArr[5] = "wXa0tVX5fv";
        if (zA0S || z12) {
            this.A0I.setToolbarActionMode(1);
            return;
        }
        this.A09 = true;
        if (z11) {
            this.A0I.setToolbarActionMessage(A09(0, 0, 66));
        }
        this.A0I.setToolbarActionMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0R(boolean z11, int i11) {
        PQ pq2 = this.A04;
        if (pq2 != null) {
            pq2.A0z();
            PQ pq3 = this.A04;
            if (A0M[1].charAt(22) != '6') {
                throw new RuntimeException();
            }
            A0M[2] = "W3TlfOl3oEXDpQnuuCTH10eCcUmU4b3A";
            pq3.removeAllViews();
            AbstractC1462Lo.A0J(this.A04);
        }
        if (!A0S()) {
            this.A09 = true;
            if (A0T()) {
                A0C();
                return;
            } else {
                A0H(1);
                return;
            }
        }
        if (this.A0A.A14()) {
            this.A09 = false;
            this.A0I.setProgressImmediate(0.0f);
        }
        if (!this.A0D.A00().A8x(this.A0A.A0v(this.A00).A12(), this.A0A.A0w())) {
            this.A0D.A0E().A4C();
            A0H(2);
            return;
        }
        PQ pqA08 = A08(z11, i11);
        this.A04 = pqA08;
        setupToolbarForAd(pqA08);
        addView(this.A04, 0, A0N);
        this.A00++;
        this.A04.A11();
    }

    private boolean A0S() {
        return this.A00 < this.A0A.A0s();
    }

    private boolean A0T() {
        return this.A0A.A0r() == 2;
    }

    private final boolean A0U() {
        return this.A07;
    }

    public static boolean A0V(AbstractC1898b5 abstractC1898b5) {
        return TextUtils.isEmpty(abstractC1898b5.A0x().A0D().A08());
    }

    private void setupToolbarForAd(PQ pq2) {
        if (this.A0I == null) {
            return;
        }
        this.A06 = true;
        AbstractC1898b5 abstractC1898b5A0v = this.A0A.A0v(this.A00);
        this.A0I.A09(this.A0D, abstractC1898b5A0v.A0r());
        this.A0I.A08(abstractC1898b5A0v.A10(), abstractC1898b5A0v.A12(), A01(this.A00));
        C1554Pc fullScreenAdStyle = pq2.getFullScreenAdStyle();
        A0I(pq2, fullScreenAdStyle);
        this.A0K.add(fullScreenAdStyle);
        this.A0I.setToolbarActionMessage(A09(4, 3, 90) + (this.A00 + 1) + A09(0, 4, 42) + this.A0A.A0s());
        if (this.A08) {
            this.A0I.setToolbarActionMode(1);
        }
        A0J(abstractC1898b5A0v);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        this.A0H.A3U(this, A0N);
        A0K(c5v);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
        PQ pq2 = this.A04;
        if (pq2 != null) {
            pq2.A12(z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
        PQ pq2 = this.A04;
        if (pq2 != null) {
            pq2.A13(z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
    }

    public PQ getContentView() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public String getCurrentClientToken() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.A02 = configuration.orientation;
        PQ pq2 = this.A04;
        if (pq2 != null) {
            pq2.onConfigurationChanged(configuration);
        }
        PQ pq3 = this.A04;
        if (pq3 instanceof T8) {
            A0I(pq3, pq3.getFullScreenAdStyle());
            A0J(this.A04.getAdDataBundle());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
        PQ pq2 = this.A04;
        if (pq2 != null) {
            pq2.A0z();
            this.A04 = null;
        }
        this.A0D.A00().A4H(this.A0A.A0w());
        this.A0G.A03();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(MC mc2) {
    }

    public void setServerSideRewardHandler(Q7 q11) {
        this.A05 = q11;
    }
}
