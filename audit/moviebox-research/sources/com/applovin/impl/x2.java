package com.applovin.impl;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x2 f24204g = new x2(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Typeface f24210f;

    public x2(int i11, int i12, int i13, int i14, int i15, Typeface typeface) {
        this.f24205a = i11;
        this.f24206b = i12;
        this.f24207c = i13;
        this.f24208d = i14;
        this.f24209e = i15;
        this.f24210f = typeface;
    }

    public static x2 a(CaptioningManager.CaptionStyle captionStyle) {
        return xp.f24372a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static x2 b(CaptioningManager.CaptionStyle captionStyle) {
        return new x2(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static x2 c(CaptioningManager.CaptionStyle captionStyle) {
        return new x2(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f24204g.f24205a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f24204g.f24206b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f24204g.f24207c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f24204g.f24208d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f24204g.f24209e, captionStyle.getTypeface());
    }
}
