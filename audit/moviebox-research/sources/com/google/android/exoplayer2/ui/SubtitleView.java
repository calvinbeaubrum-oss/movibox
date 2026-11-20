package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SubtitleView extends FrameLayout {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<vh.b> f35057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f35058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f35060d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f35061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f35062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f35063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f35064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f35065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f35066k;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(List<vh.b> list, c cVar, float f11, int i11, float f12);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35057a = Collections.emptyList();
        this.f35058b = c.f35094g;
        this.f35059c = 0;
        this.f35060d = 0.0533f;
        this.f35061f = 0.08f;
        this.f35062g = true;
        this.f35063h = true;
        b bVar = new b(context);
        this.f35065j = bVar;
        this.f35066k = bVar;
        addView(bVar);
        this.f35064i = 1;
    }

    private List<vh.b> getCuesWithStylingPreferencesApplied() {
        if (this.f35062g && this.f35063h) {
            return this.f35057a;
        }
        ArrayList arrayList = new ArrayList(this.f35057a.size());
        for (int i11 = 0; i11 < this.f35057a.size(); i11++) {
            arrayList.add(a(this.f35057a.get(i11)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (com.google.android.exoplayer2.util.o0.f35608a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        if (com.google.android.exoplayer2.util.o0.f35608a < 19 || isInEditMode()) {
            return c.f35094g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? c.f35094g : c.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t11) {
        removeView(this.f35066k);
        View view = this.f35066k;
        if (view instanceof q0) {
            ((q0) view).g();
        }
        this.f35066k = t11;
        this.f35065j = t11;
        addView(t11);
    }

    public final vh.b a(vh.b bVar) {
        vh.b.C0875b c0875bB = bVar.b();
        if (!this.f35062g) {
            m0.e(c0875bB);
        } else if (!this.f35063h) {
            m0.f(c0875bB);
        }
        return c0875bB.a();
    }

    public final void b(int i11, float f11) {
        this.f35059c = i11;
        this.f35060d = f11;
        c();
    }

    public final void c() {
        this.f35065j.a(getCuesWithStylingPreferencesApplied(), this.f35058b, this.f35060d, this.f35059c, this.f35061f);
    }

    public void setApplyEmbeddedFontSizes(boolean z11) {
        this.f35063h = z11;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z11) {
        this.f35062g = z11;
        c();
    }

    public void setBottomPaddingFraction(float f11) {
        this.f35061f = f11;
        c();
    }

    public void setCues(@Nullable List<vh.b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f35057a = list;
        c();
    }

    public void setFixedTextSize(int i11, float f11) {
        Context context = getContext();
        b(2, TypedValue.applyDimension(i11, f11, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f11) {
        setFractionalTextSize(f11, false);
    }

    public void setFractionalTextSize(float f11, boolean z11) {
        b(z11 ? 1 : 0, f11);
    }

    public void setStyle(c cVar) {
        this.f35058b = cVar;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i11) {
        if (this.f35064i == i11) {
            return;
        }
        if (i11 == 1) {
            setView(new b(getContext()));
        } else {
            if (i11 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new q0(getContext()));
        }
        this.f35064i = i11;
    }
}
