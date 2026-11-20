package androidx.media3.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f12011g = new b(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Typeface f12017f;

    public b(int i11, int i12, int i13, int i14, int i15, @Nullable Typeface typeface) {
        this.f12012a = i11;
        this.f12013b = i12;
        this.f12014c = i13;
        this.f12015d = i14;
        this.f12016e = i15;
        this.f12017f = typeface;
    }

    @RequiresApi(19)
    public static b a(CaptioningManager.CaptionStyle captionStyle) {
        return u0.f81838a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    public static b b(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    public static b c(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f12011g.f12012a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f12011g.f12013b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f12011g.f12014c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f12011g.f12015d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f12011g.f12016e, captionStyle.getTypeface());
    }
}
