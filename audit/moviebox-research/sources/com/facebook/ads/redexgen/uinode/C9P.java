package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9P extends UL {
    public static byte[] A0F;
    public static String[] A0G = {"hEO5MspmmQwWZDjfO9hYkGtE8t8ljCUN", "895GOd6GqHS2SDNwtQvAqIE", "zBXblOu1CdgXx49mdyV8flA", "GxqIbNjcrUQMSJiuMkyJv1mwkudVYaGP", "be3ZgXhlaup3yXbKLr41yKjcTusIQNjx", "HLi8FTj59ZkYUe8FmXrpO0CEflvtIm0o", "7bereGXxKpIS6kk2UNHV0kt11i4QSfeP", "LRvrjmvhZNKPrr4qRukG9JYrfPQqD7wd"};
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public static final int A0L;
    public int A00;
    public int A01;
    public LinearLayout A02;
    public AbstractC1898b5 A03;
    public C11006c A04;
    public C10393r A05;
    public O2 A06;
    public C1631Sb A07;
    public RD A08;
    public RE A09;
    public String A0A;
    public List<C1567Pp> A0B;
    public boolean A0C;
    public final C1795Yn A0D;
    public final C1454Lg A0E;

    static {
        A0B();
        A0H = (int) (LD.A02 * 48.0f);
        A0I = (int) (LD.A02 * 8.0f);
        A0J = (int) (LD.A02 * 8.0f);
        A0L = (int) (LD.A02 * 56.0f);
        A0K = (int) (LD.A02 * 12.0f);
    }

    public C9P(C1795Yn c1795Yn, J2 j11, C11006c c11006c, MC mc2, FS fs2) {
        super(c1795Yn, j11, mc2, fs2);
        this.A0E = new C1454Lg();
        this.A0C = false;
        super.A07 = true;
        super.A06 = new Q7(c1795Yn, new U8(), super.A0A.A0T(), mc2);
        this.A04 = c11006c;
        this.A0D = c1795Yn;
    }

    public C9P(C1795Yn c1795Yn, J2 j11, C11006c c11006c, MC mc2, FU fu2) {
        super(c1795Yn, j11, mc2, fu2);
        this.A0E = new C1454Lg();
        this.A0C = false;
        this.A04 = c11006c;
        this.A0D = c1795Yn;
    }

    private AbstractC1898b5 A00(Intent intent) {
        return super.A07 ? (AbstractC1898b5) intent.getSerializableExtra(A09(14, 25, 77)) : (AbstractC1898b5) intent.getSerializableExtra(A09(0, 14, 93));
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0G;
            if (strArr[0].charAt(22) != strArr[6].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[5] = "I427OJiZERIl1pgFYs7VIJxgJMuHqTWY";
            strArr2[4] = "m1VK8a3APoHjuOOKlTc7gi9yCeUy6Tbh";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 74);
            i14++;
        }
    }

    public static void A0B() {
        A0F = new byte[]{118, 115, 72, 115, 118, 99, 118, 72, 117, 98, 121, 115, 123, 114, 117, 98, 112, 102, 117, 99, 98, 99, 81, 110, 99, 98, 104, 70, 99, 67, 102, 115, 102, 69, 114, 105, 99, 107, 98};
    }

    private final void A0C() {
        LinearLayout linearLayout = this.A02;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.A02 = null;
        }
        C10393r c10393r = this.A05;
        if (c10393r != null) {
            c10393r.removeAllViews();
            this.A05.A1Q();
            this.A05 = null;
        }
        O2 o11 = this.A06;
        if (o11 != null) {
            o11.removeAllViews();
            this.A06 = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0130  */
    private final void A0D(int i11, Bundle bundle) {
        int iMin;
        int i12;
        int i13;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.A02 = linearLayout;
        if (i11 == 1) {
            linearLayout.setGravity(17);
        } else {
            linearLayout.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i14 = LD.A03.widthPixels;
        int i15 = LD.A03.heightPixels;
        if (i11 == 1) {
            iMin = Math.min(i14 - (A0I * 4), i15 / 2);
            i12 = (i14 - iMin) / 8;
            i13 = i12 * 4;
        } else {
            iMin = i15 - ((A0L + A0H) + (A0I * 4));
            i12 = A0I;
            i13 = i12 * 2;
        }
        this.A08 = new SS(this);
        RE re2 = new RE(this, 1, new WeakReference(this.A08), this.A0D);
        this.A09 = re2;
        re2.A0W(this.A00);
        this.A09.A0X(this.A01);
        C10393r c10393r = new C10393r(this.A0D);
        this.A05 = c10393r;
        c10393r.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A07 = new C1631Sb(this.A05, i11, this.A0B, this.A09, bundle);
        int i16 = iMin;
        this.A05.setAdapter(new ST(this.A0D, this.A0B, this.A03, super.A0C, this.A04, this.A09, this.A0E, getAudienceNetworkListener(), this.A0A, i16, i12, i13, i11, this.A07, super.A0E));
        C10393r c10393r2 = this.A05;
        c10393r2.A1f(c10393r2.getOnScrollListener());
        if (i11 == 1) {
            A0F(this.A07);
        }
        LinearLayout linearLayout2 = this.A02;
        C10393r c10393r3 = this.A05;
        if (A0G[7].charAt(26) == 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[0] = "pS0yYjaDPNGuTrfnUmeGhxtdEtLadoEJ";
        strArr[6] = "mwC7eMAbLdHre0yQkkMBVztsNAF33a9m";
        linearLayout2.addView(c10393r3);
        O2 o11 = this.A06;
        if (o11 != null) {
            LinearLayout linearLayout3 = this.A02;
            String[] strArr2 = A0G;
            if (strArr2[5].charAt(16) == strArr2[4].charAt(16)) {
                throw new RuntimeException();
            }
            A0G[3] = "7ZjVpxQcOo2BFfYt51qxyVC8jdlns0bj";
            linearLayout3.addView(o11);
        }
        boolean zA1W = C1384Ih.A1W(this.A0D);
        String[] strArr3 = A0G;
        if (strArr3[0].charAt(22) == strArr3[6].charAt(22)) {
            A0G[3] = "nKvQ299cRrmi8SltfoUYXILZ1CbfqCSq";
            if (zA1W) {
                this.A0D.A0A().AGv(this.A05, super.A0A.A12(), false);
            }
        } else if (zA1W) {
            this.A0D.A0A().AGv(this.A05, super.A0A.A12(), false);
        }
        A0U(this.A02, false, i11);
    }

    private void A0E(AbstractC1898b5 abstractC1898b5) {
        this.A03 = abstractC1898b5;
        this.A0A = abstractC1898b5.A12();
        this.A00 = this.A03.A0C();
        this.A01 = this.A03.A0D();
        List<C1G> listA14 = this.A03.A14();
        this.A0B = new ArrayList(listA14.size());
        int i11 = 0;
        while (true) {
            int size = listA14.size();
            String[] strArr = A0G;
            if (strArr[5].charAt(16) == strArr[4].charAt(16)) {
                throw new RuntimeException();
            }
            A0G[3] = "1AHb04hcylshFNuVFPVd0IA840Fx90m0";
            if (i11 >= size) {
                return;
            }
            this.A0B.add(new C1567Pp(i11, listA14.size(), listA14.get(i11)));
            i11++;
        }
    }

    private void A0F(C1631Sb c1631Sb) {
        new C1279Ec().A0G(this.A05);
        c1631Sb.A0Y(new SR(this));
        this.A06 = new O2(this.A0D, super.A05.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0J);
        layoutParams.setMargins(0, A0K, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.UL
    public final boolean A0a() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        AbstractC1898b5 abstractC1898b5A00 = A00(intent);
        A0V(c5v);
        A0E(abstractC1898b5A00);
        A0D(c5v.A0J().getResources().getConfiguration().orientation, bundle);
        c5v.A0N(new SQ(this, c5v));
        int iA03 = super.A0A.A0x().A0D().A03();
        if (super.A07) {
            iA03 = super.A0A.A0x().A0D().A02();
        }
        if (iA03 > 0) {
            A0T(iA03);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.UL, com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
        super.ACW(z11);
        C1631Sb c1631Sb = this.A07;
        if (c1631Sb != null) {
            c1631Sb.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.UL, com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
        super.ACu(z11);
        this.A07.A0R();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
        C1631Sb c1631Sb = this.A07;
        if (c1631Sb != null) {
            c1631Sb.A0W(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.UL
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        AFT(bundle);
        A0C();
        A0D(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.uinode.UL, com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
        super.onDestroy();
        if (C1384Ih.A1W(this.A0D)) {
            this.A0D.A0A().AGk(this.A05);
        }
        if (!TextUtils.isEmpty(this.A0A)) {
            super.A0C.A9X(this.A0A, new C1508Ni().A03(this.A09).A02(this.A0E).A05());
        }
        A0C();
        this.A09.A0V();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0E.A06(this.A0D, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
