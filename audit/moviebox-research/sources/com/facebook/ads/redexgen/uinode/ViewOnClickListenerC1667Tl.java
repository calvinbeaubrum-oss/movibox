package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ViewOnClickListenerC1667Tl extends AbstractC1521Nv implements View.OnClickListener {
    public static byte[] A0D;
    public static String[] A0E = {"idQnrwKrPQs0c3zYYHT6WTvW1aXoRMqQ", "Gekt1WHQiHnIJqxdwB9j8FzDtIJy1cfJ", "sF2V", "CdtBVDHmuEaNC9R8", "jtmNaJ8NDkAfiILRFeCM3WK", "aXO2Ks7stxeTyHMnCxwSATKtkmhK3bmt", "xmLEl9t0StR", ""};
    public static final int A0F;
    public int A00;
    public int A01;
    public Bitmap A02;
    public Paint A03;
    public Rect A04;
    public C1795Yn A05;
    public L9 A06;
    public C1669Tn A07;
    public String A08;
    public String A09;
    public boolean A0A;
    public final C1517Nr A0B;
    public final Map<String, String> A0C;

    static {
        A07();
        A0F = (int) (LD.A02 * 24.0f);
    }

    public ViewOnClickListenerC1667Tl(C1795Yn c1795Yn, AbstractC1898b5 abstractC1898b5, C1P c1p, J2 j11, MC mc2, RE re2, C1454Lg c1454Lg) {
        this(c1795Yn, abstractC1898b5.A0L(), c1p, abstractC1898b5.A0x().A0F().A06(), j11, mc2, re2, c1454Lg, abstractC1898b5.A0y());
        this.A0B.A04(abstractC1898b5);
    }

    public ViewOnClickListenerC1667Tl(C1795Yn c1795Yn, String str, C1P c1p, J2 j11, MC mc2, RE re2, C1454Lg c1454Lg, C1U c1u) {
        this(c1795Yn, str, c1p, false, j11, mc2, re2, c1454Lg, c1u);
    }

    public ViewOnClickListenerC1667Tl(C1795Yn c1795Yn, String str, C1P c1p, boolean z11, J2 j11, MC mc2, RE re2, C1454Lg c1454Lg, C1U c1u) {
        super(c1795Yn, c1p);
        this.A0C = new HashMap();
        this.A05 = c1795Yn;
        this.A0A = z11;
        this.A0B = new C1517Nr(c1795Yn, str, re2, c1454Lg, j11, c1u, mc2);
        setOnClickListener(this);
        AbstractC1462Lo.A0G(1001, this);
    }

    public static Bitmap A03(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = bArrCopyOfRange[i14] ^ i13;
            if (A0E[2].length() != 4) {
                throw new RuntimeException();
            }
            A0E[3] = "DG";
            bArrCopyOfRange[i14] = (byte) (i15 ^ 83);
        }
        return new String(bArrCopyOfRange);
    }

    private void A05() {
        String str;
        if (!this.A0A || (str = this.A09) == null) {
            return;
        }
        this.A02 = A03(AbstractC1471Lx.A03(this.A05, str.contains(A04(12, 12, 61)) ? EnumC1470Lw.MESSENGER : EnumC1470Lw.WHATSAPP));
        this.A03 = new Paint();
        int i11 = A0F;
        setPadding(i11, 0, i11, 0);
    }

    private void A06() {
        L9 l11 = this.A06;
        if (l11 != null) {
            l11.A06();
        }
        C1669Tn c1669Tn = this.A07;
        if (c1669Tn != null) {
            c1669Tn.A04();
        }
    }

    public static void A07() {
        A0D = new byte[]{3, Ascii.FF, 9, 3, Ascii.VT, Utf8.REPLACEMENT_BYTE, 19, Ascii.SI, Ascii.NAK, Ascii.DC2, 3, 5, 8, Ascii.FF, 67, 3, Ascii.VT, Ascii.GS, Ascii.GS, Ascii.VT, 0, 9, Ascii.VT, Ascii.FS, Ascii.DEL, 121, 111, 120, 105, 102, 99, 105, 97};
    }

    public static boolean A08(AbstractC1898b5 abstractC1898b5) {
        return ((long) abstractC1898b5.A0u()) > 0 && abstractC1898b5.A0s() >= 0;
    }

    public final void A09(String str) {
        if (TextUtils.isEmpty(this.A08) || TextUtils.isEmpty(this.A09)) {
            return;
        }
        A06();
        this.A0C.put(A04(0, 12, 51), str);
        this.A0B.A07(this.A08, this.A09, this.A0C);
    }

    public final boolean A0A(AbstractC1898b5 abstractC1898b5, MB mb2) {
        if (this.A06 != null || !A08(abstractC1898b5) || abstractC1898b5.A11().A01() == null || abstractC1898b5.A11().A00() == null) {
            return false;
        }
        this.A07 = new C1669Tn(abstractC1898b5.A0s(), abstractC1898b5.A0u(), abstractC1898b5.A0t(), abstractC1898b5.A11().A01(), abstractC1898b5.A11().A00(), mb2, this);
        L9 l11 = new L9(abstractC1898b5.A0u(), this.A07);
        this.A06 = l11;
        l11.A07();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A09(A04(24, 9, 89));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A06();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A02 != null) {
            this.A04 = new Rect(0, 0, this.A02.getWidth(), this.A02.getHeight());
            int width = this.A02.getWidth();
            this.A01 = width;
            this.A00 = 12;
            canvas.save();
            canvas.translate((width + 12) / 2, 0.0f);
        }
        super.onDraw(canvas);
        if (this.A02 != null) {
            int width2 = (int) ((((getWidth() / 2.0f) - ((getPaint().measureText((String) getText()) + 10.0f) / 2.0f)) - this.A01) - this.A00);
            int height = (getHeight() / 2) - (this.A01 / 2);
            int i11 = this.A01;
            canvas.drawBitmap(this.A02, this.A04, new Rect(width2, height, width2 + i11, i11 + height), this.A03);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            A06();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            return;
        }
        A06();
    }

    public void setCreativeAsCtaLoggingHelper(OG og2) {
        this.A0B.A06(og2);
    }

    public void setCta(C1Q c1q, String str, Map<String, String> map) {
        setCta(c1q, str, map, null);
    }

    public void setCta(C1Q c1q, String str, Map<String, String> map, InterfaceC1516Nq interfaceC1516Nq) {
        this.A08 = str;
        this.A09 = c1q.A05();
        this.A0C.putAll(map);
        this.A0B.A05(interfaceC1516Nq);
        String strA04 = c1q.A04();
        if (TextUtils.isEmpty(strA04) || TextUtils.isEmpty(this.A09)) {
            setVisibility(8);
        } else {
            setText(strA04);
            A05();
        }
    }

    public void setIsInAppBrowser(boolean z11) {
        this.A0B.A08(z11);
    }
}
