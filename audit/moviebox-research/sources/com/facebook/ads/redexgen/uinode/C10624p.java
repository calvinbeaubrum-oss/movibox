package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C10624p extends ViewGroup.MarginLayoutParams {
    public AnonymousClass56 A00;
    public boolean A01;
    public boolean A02;
    public final Rect A03;

    public C10624p(int i11, int i12) {
        super(i11, i12);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C10624p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C10624p(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C10624p(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C10624p(C10624p c10624p) {
        super((ViewGroup.LayoutParams) c10624p);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public final int A00() {
        return this.A00.A0I();
    }

    public final boolean A01() {
        return this.A00.A0d();
    }

    public final boolean A02() {
        return this.A00.A0a();
    }

    public final boolean A03() {
        return this.A00.A0Z();
    }
}
