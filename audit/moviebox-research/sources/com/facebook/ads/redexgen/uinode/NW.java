package com.facebook.ads.redexgen.uinode;

import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NW extends RelativeLayout {
    public static MC A05;
    public static byte[] A06;
    public static String[] A07 = {"CT308ms2RTF49ixw7iITcI5DvAIGWMXZ", "UVauKq3DlAHpB1vMyeeSD4Us6AaVXCYd", "G3Ivv2DNtSsvdOlvNnw6jHI40eb4uyYL", "qur6nZLrhU9XJET37yOODnXWYcrj37IJ", "OCLfHPrXkMpm02uq88EYR3Uw1JpI2kE3", "KopKmjllEHptdGx3", "mL4xXMXopKoNgp", "1VwEGJcTQNgN7iTbFc9O"};
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public ZY A00;
    public C1795Yn A01;
    public AnonymousClass38 A02;
    public C1681Tz A03;
    public O2 A04;

    static {
        A02();
        int i11 = (int) (LD.A02 * 8.0f);
        A09 = i11;
        A08 = i11 * 10;
        A0A = (int) (LD.A02 * 15.0f);
        A05 = new C1680Ty();
    }

    public NW(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A01 = c1795Yn;
        AnonymousClass38 anonymousClass38 = new AnonymousClass38(c1795Yn);
        this.A02 = anonymousClass38;
        AbstractC1462Lo.A0K(anonymousClass38);
        C1279Ec c1279Ec = new C1279Ec();
        this.A00 = c1279Ec;
        c1279Ec.A0G(this.A02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A07[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[2] = "hwjeWCnyrgrPOyFOaJyYR4Ki88uO9bQs";
            strArr[0] = "4m7NTkn57B9pIqsgccGzW0RoTzQfESBy";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 119);
            i14++;
        }
    }

    private ArrayList<C1567Pp> A01(AbstractC1898b5 abstractC1898b5) {
        if (abstractC1898b5 == null) {
            return new ArrayList<>();
        }
        List<C1G> listA14 = abstractC1898b5.A14();
        ArrayList<C1567Pp> arrayList = new ArrayList<>(listA14.size());
        for (int i11 = 0; i11 < listA14.size(); i11++) {
            arrayList.add(new C1567Pp(i11, listA14.size(), listA14.get(i11)));
        }
        return arrayList;
    }

    public static void A02() {
        A06 = new byte[]{-25, 5, Ascii.SYN, 19, Ascii.EM, Ascii.ETB, 9, Ascii.DLE, -60, -14, 5, Ascii.CAN, Ascii.CR, Ascii.SUB, 9, -60, Ascii.SUB, Ascii.CR, 9, Ascii.ESC, -60, 5, 8, 9, Ascii.DC4, Ascii.CAN, 9, Ascii.SYN, -60, Ascii.CR, Ascii.ETB, Ascii.DC2, -53, Ascii.CAN, -60, 7, Ascii.SYN, 9, 5, Ascii.CAN, 9, 8, -60, Ascii.DC4, Ascii.SYN, 19, Ascii.DC4, 9, Ascii.SYN, Ascii.DLE, Ascii.GS, -5, -7, 2, -7, 6, -3, -9};
    }

    public static MC getDummyListener() {
        return A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpLayoutForCardAtIndex(int i11) {
        O2 o11 = this.A04;
        if (o11 != null) {
            o11.A00(i11);
        }
    }

    private void setupDotsLayout(V2 v11, ArrayList<C1567Pp> arrayList) {
        this.A02.getCarouselCardBehaviorHelper().A0Y(new C1679Tx(this));
        O2 o11 = new O2(this.A01, v11.A0z().A0w().A01(), arrayList.size());
        this.A04 = o11;
        AbstractC1462Lo.A0K(o11);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A02.getId());
        layoutParams.setMargins(0, A0A, 0, 0);
        addView(this.A04, layoutParams);
    }

    public final void A04() {
        this.A02.setAdapter(null);
    }

    public final void A05(V2 v11, int i11) {
        ArrayList<C1567Pp> arrayListA01 = A01(v11.A0z());
        this.A02.setCardsInfo(arrayListA01);
        C1681Tz c1681Tz = new C1681Tz(this.A01, arrayListA01, v11.A0z(), this.A01.A01().A09(), v11, A05, v11.A0z().A12(), this.A02.getCarouselCardBehaviorHelper(), null);
        this.A03 = c1681Tz;
        this.A02.setAdapter(c1681Tz);
        this.A03.A0F(i11 - A08, 16, 0);
        this.A03.A06();
        setupDotsLayout(v11, arrayListA01);
    }

    public final void A06(RE re2) {
        C1681Tz c1681Tz = this.A03;
        if (c1681Tz != null) {
            c1681Tz.A0G(re2);
        } else {
            this.A01.A07().A9a(A00(51, 7, 29), C8A.A1v, new C8B(A00(0, 51, 45)));
        }
        this.A02.A1y(re2);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        C1681Tz c1681Tz;
        if (z11 && (c1681Tz = this.A03) != null) {
            c1681Tz.A0F((i13 - i11) - A08, 16, 0);
        }
        super.onLayout(z11, i11, i12, i13, i14);
    }
}
