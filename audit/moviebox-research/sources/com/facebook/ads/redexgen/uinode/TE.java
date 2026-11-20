package com.facebook.ads.redexgen.uinode;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TE extends NY {
    public static byte[] A01;
    public final /* synthetic */ PB A00;

    static {
        A04();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TE(PB pb2, C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A00 = pb2;
        getSettings().setAllowFileAccess(true);
        setBackgroundColor(0);
    }

    private int A01(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i13);
        int size = View.MeasureSpec.getSize(i13);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i11, size), i12);
            case 0:
                return Math.min(i11, i12);
            case 1073741824:
                return size;
            default:
                return i11;
        }
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{5, Ascii.CAN, Ascii.SI, 0, Ascii.FF, 8, 2, 62, Ascii.DC2, 5, 10, 62, Ascii.CR, 0, Ascii.CAN, 4, 19, 62, 2, Ascii.SO, Ascii.SI, Ascii.NAK, 4, Ascii.SI, Ascii.NAK, 62, 9, 4, 8, 6, 9, Ascii.NAK, Ascii.FF, 17, 6, 9, 5, 1, Ascii.VT, 55, Ascii.ESC, Ascii.FF, 3, 55, 4, 9, 17, Ascii.CR, Ascii.SUB, 55, Ascii.VT, 7, 6, Ascii.FS, Ascii.CR, 6, Ascii.FS, 55, Ascii.US, 1, Ascii.FF, Ascii.FS, 0};
    }

    private int getDynamicWebViewHeight() {
        return this.A00.A09.A0V().optInt(A03(0, 32, 19));
    }

    private int getDynamicWebViewWidth() {
        return this.A00.A09.A0V().optInt(A03(32, 31, 26));
    }

    @Override // com.facebook.ads.redexgen.uinode.NY
    public final WebChromeClient A0D() {
        return new P6(this.A00);
    }

    @Override // com.facebook.ads.redexgen.uinode.NY
    public final WebViewClient A0E() {
        return new P7(this.A00);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int i11, int i12) {
        int dynamicWebViewWidth = getDynamicWebViewWidth();
        int dynamicWebViewHeight = getDynamicWebViewHeight();
        if (dynamicWebViewWidth <= 0 || dynamicWebViewHeight <= 0) {
            super.onMeasure(i11, i12);
            return;
        }
        float f11 = dynamicWebViewWidth / dynamicWebViewHeight;
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        boolean z11 = mode != 1073741824;
        boolean z12 = mode2 != 1073741824;
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int width2 = viewGroup.getWidth();
            height = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            width = width2 != 0 ? viewGroup.getWidth() : Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (viewGroup.getHeight() != 0) {
                height = viewGroup.getHeight();
            }
        }
        int iA01 = A01(dynamicWebViewWidth, width, i11);
        int iA02 = A01(dynamicWebViewHeight, height, i12);
        if ((z12 || z11) && Math.abs((iA01 / iA02) - f11) > 1.0E-7d) {
            boolean z13 = false;
            if (z12) {
                iA02 = (int) (iA01 / f11);
                z13 = true;
            }
            if (!z13 && z11) {
                iA01 = (int) (iA02 * f11);
            }
        }
        setMeasuredDimension(iA01, iA02);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.A00.A02 != null) {
            this.A00.A02.ADL(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }
}
