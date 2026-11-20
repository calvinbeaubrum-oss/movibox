package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1314Fn {
    public final float A00;
    public final float A01;
    public final float A02;
    public final float A03;
    public final float A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final Bitmap A0A;
    public final Layout.Alignment A0B;
    public final CharSequence A0C;
    public final boolean A0D;

    public C1314Fn(Bitmap bitmap, float f11, int i11, float f12, int i12, float f13, float f14) {
        this(null, null, bitmap, f12, 0, i12, f11, i11, Integer.MIN_VALUE, Float.MIN_VALUE, f13, f14, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public C1314Fn(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public C1314Fn(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13) {
        this(charSequence, alignment, f11, i11, i12, f12, i13, f13, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public C1314Fn(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, int i14, float f14) {
        this(charSequence, alignment, null, f11, i11, i12, f12, i13, i14, f14, f13, Float.MIN_VALUE, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public C1314Fn(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z11, int i14) {
        this(charSequence, alignment, null, f11, i11, i12, f12, i13, Integer.MIN_VALUE, Float.MIN_VALUE, f13, Float.MIN_VALUE, z11, i14);
    }

    public C1314Fn(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z11, int i15) {
        this.A0C = charSequence;
        this.A0B = alignment;
        this.A0A = bitmap;
        this.A01 = f11;
        this.A06 = i11;
        this.A05 = i12;
        this.A02 = f12;
        this.A07 = i13;
        this.A03 = f14;
        this.A00 = f15;
        this.A0D = z11;
        this.A09 = i15;
        this.A08 = i14;
        this.A04 = f13;
    }
}
