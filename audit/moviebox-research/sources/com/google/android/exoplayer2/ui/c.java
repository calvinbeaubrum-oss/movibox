package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f35094g = new c(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f35099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Typeface f35100f;

    public c(int i11, int i12, int i13, int i14, int i15, @Nullable Typeface typeface) {
        this.f35095a = i11;
        this.f35096b = i12;
        this.f35097c = i13;
        this.f35098d = i14;
        this.f35099e = i15;
        this.f35100f = typeface;
    }

    @RequiresApi(19)
    public static c a(CaptioningManager.CaptionStyle captionStyle) {
        return com.google.android.exoplayer2.util.o0.f35608a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    public static c b(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    public static c c(CaptioningManager.CaptionStyle captionStyle) {
        return new c(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f35094g.f35095a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f35094g.f35096b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f35094g.f35097c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f35094g.f35098d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f35094g.f35099e, captionStyle.getTypeface());
    }
}
