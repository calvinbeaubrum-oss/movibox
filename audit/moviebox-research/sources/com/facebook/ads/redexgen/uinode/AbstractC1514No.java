package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.No, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1514No extends LinearLayout {
    public static byte[] A06;
    public static String[] A07 = {"cmzsI0MqV", "rmZj6bXGr2Mc3k6GGfUNTI8ab", "Oqa2BQOYUIgPEQnUKqUaSgjmS1hAy2aw", "VbR8t651F3u5xAC0yd", "KwIIB1PdAD0xOvkamO3Meu", "6KEr", "QBka00Gf2XeExLF7IYa6e3", ""};
    public static final LinearLayout.LayoutParams A08;
    public final int A00;
    public final View.OnClickListener A01;
    public final RelativeLayout A02;
    public final C1795Yn A03;
    public final ViewOnClickListenerC1667Tl A04;
    public final O3 A05;

    static {
        A01();
        A08 = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC1514No(C1795Yn c1795Yn, int i11, C1P c1p, boolean z11, String str, J2 j11, MC mc2, RE re2, C1454Lg c1454Lg, C1U c1u) {
        super(c1795Yn);
        AbstractC1462Lo.A0K(this);
        this.A03 = c1795Yn;
        this.A00 = i11;
        O3 o11 = new O3(c1795Yn);
        this.A05 = o11;
        AbstractC1462Lo.A0M(o11, 0);
        AbstractC1462Lo.A0K(o11);
        ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = new ViewOnClickListenerC1667Tl(c1795Yn, str, c1p, z11, j11, mc2, re2, c1454Lg, c1u);
        this.A04 = viewOnClickListenerC1667Tl;
        AbstractC1462Lo.A0G(1001, viewOnClickListenerC1667Tl);
        this.A01 = OI.A03(viewOnClickListenerC1667Tl, A00(0, 9, 119));
        RelativeLayout relativeLayout = new RelativeLayout(c1795Yn);
        this.A02 = relativeLayout;
        relativeLayout.setLayoutParams(A08);
        AbstractC1462Lo.A0K(relativeLayout);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {9, Ascii.FF, Ascii.FF, Ascii.CR, Ascii.FS, 9, 17, Ascii.DC4, Ascii.ESC};
        if (A07[1].length() != 25) {
            throw new RuntimeException();
        }
        A07[2] = "W8PIFEgMaUlhByfzvyeLgAFdtcDk8ZOz";
        A06 = bArr;
    }

    public void A09() {
        this.A05.setOnClickListener(this.A01);
    }

    public abstract void A0A(int i11);

    public final ViewOnClickListenerC1667Tl getCTAButton() {
        return this.A04;
    }

    public abstract View getExpandableLayout();

    public final ImageView getIconView() {
        return this.A05;
    }

    public void setInfo(C1N c1n, C1Q c1q, String str, String str2, InterfaceC1516Nq interfaceC1516Nq) {
        this.A04.setCta(c1q, str, new HashMap(), interfaceC1516Nq);
        AsyncTaskC1672Tq asyncTaskC1672Tq = new AsyncTaskC1672Tq(this.A05, this.A03);
        int i11 = this.A00;
        asyncTaskC1672Tq.A05(i11, i11).A07(str2);
    }

    public abstract void setTitleMaxLines(int i11);
}
