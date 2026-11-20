package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NP extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"c3XyMVVK2ZPeOt0e4CLBNBDbK", "DsCUYZfHfFO6YC0ZUz1", "eLhkJXERmPgt", "", "", "5cC1cV814bBflaO82eB2FX5nm", "", "kS5kSd3yRJfI"};
    public Drawable A00;
    public TextView A01;
    public TextView A02;
    public final C1795Yn A03;

    static {
        A02();
    }

    public NP(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A03 = c1795Yn;
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        float f11 = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.A02.setTextSize(2, 20.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        this.A02.setGravity(17);
        addView(this.A02, layoutParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.A01.setTextSize(2, 15.0f);
        this.A01.setCompoundDrawablePadding((int) (5.0f * f11));
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        this.A01.setGravity(17);
        addView(this.A01, layoutParams2);
        if (C1384Ih.A2N(this.A03)) {
            this.A02.setVisibility(4);
            this.A01.setVisibility(4);
        }
    }

    public static void A02() {
        byte[] bArr = {7, Ascii.ESC, Ascii.ESC, Ascii.US, Ascii.FS};
        if (A05[4].length() != 0) {
            throw new RuntimeException();
        }
        A05[1] = "lhzBP3Bo4mEfv1CoOUdrfuIGeogVZlJ";
        A04 = bArr;
    }

    private Drawable getPadlockDrawable() {
        if (this.A00 == null) {
            this.A00 = AbstractC1471Lx.A03(this.A03, EnumC1470Lw.BROWSER_PADLOCK);
        }
        return this.A00;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A01.setText((CharSequence) null);
            this.A01.setVisibility(4);
        } else {
            Uri uriA00 = AbstractC1446Ky.A00(str);
            this.A01.setText(uriA00.getHost());
            this.A01.setCompoundDrawablesRelativeWithIntrinsicBounds(A00(0, 5, 24).equals(uriA00.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.A01.setVisibility(0);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A02.setText(str);
            this.A02.setVisibility(0);
            return;
        }
        this.A02.setText((CharSequence) null);
        String[] strArr = A05;
        if (strArr[6].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        A05[4] = "";
        this.A02.setVisibility(4);
    }
}
