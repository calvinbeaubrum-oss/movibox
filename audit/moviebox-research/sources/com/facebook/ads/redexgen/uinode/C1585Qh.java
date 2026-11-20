package com.facebook.ads.redexgen.uinode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.widget.Button;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1585Qh extends Button {
    public static byte[] A07;
    public String A00;
    public String A01;
    public boolean A02;
    public final Paint A03;
    public final Path A04;
    public final Path A05;
    public final Path A06;

    static {
        A02();
    }

    public C1585Qh(C1795Yn c1795Yn) {
        this(c1795Yn, false);
    }

    public C1585Qh(C1795Yn c1795Yn, boolean z11) {
        super(c1795Yn);
        this.A02 = false;
        this.A01 = A00(5, 4, 34);
        this.A00 = A00(0, 5, 13);
        this.A04 = new Path();
        this.A05 = new Path();
        this.A06 = new Path();
        this.A03 = new C1584Qg(this, z11);
        A01();
        setClickable(true);
        AbstractC1462Lo.A0M(this, 0);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() {
        setContentDescription(this.A02 ? this.A01 : this.A00);
    }

    public static void A02() {
        A07 = new byte[]{89, 104, 124, 122, 108, 118, 74, 71, 95};
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
            setLayerType(1, null);
        }
        float fMax = Math.max(canvas.getWidth(), canvas.getHeight()) / 100.0f;
        if (this.A02) {
            this.A06.rewind();
            this.A06.moveTo(fMax * 26.5f, fMax * 15.5f);
            this.A06.lineTo(fMax * 26.5f, 84.5f * fMax);
            this.A06.lineTo(90.0f * fMax, 50.0f * fMax);
            this.A06.lineTo(26.5f * fMax, 15.5f * fMax);
            this.A06.close();
            canvas.drawPath(this.A06, this.A03);
        } else {
            this.A04.rewind();
            this.A04.moveTo(fMax * 29.0f, fMax * 21.0f);
            this.A04.lineTo(fMax * 29.0f, fMax * 79.0f);
            this.A04.lineTo(fMax * 45.0f, fMax * 79.0f);
            this.A04.lineTo(45.0f * fMax, fMax * 21.0f);
            this.A04.lineTo(29.0f * fMax, fMax * 21.0f);
            this.A04.close();
            this.A05.rewind();
            this.A05.moveTo(fMax * 55.0f, fMax * 21.0f);
            this.A05.lineTo(fMax * 55.0f, fMax * 79.0f);
            this.A05.lineTo(fMax * 71.0f, 79.0f * fMax);
            this.A05.lineTo(71.0f * fMax, fMax * 21.0f);
            this.A05.lineTo(55.0f * fMax, 21.0f * fMax);
            this.A05.close();
            canvas.drawPath(this.A04, this.A03);
            canvas.drawPath(this.A05, this.A03);
        }
        super.onDraw(canvas);
    }

    public void setChecked(boolean z11) {
        this.A02 = z11;
        A01();
        refreshDrawableState();
        invalidate();
    }

    public void setPauseAccessibilityLabel(String str) {
        if (str != null) {
            this.A00 = str;
            A01();
        }
    }

    public void setPlayAccessibilityLabel(String str) {
        if (str != null) {
            this.A01 = str;
            A01();
        }
    }
}
