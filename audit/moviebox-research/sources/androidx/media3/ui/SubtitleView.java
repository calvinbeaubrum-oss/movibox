package androidx.media3.ui;

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
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class SubtitleView extends FrameLayout {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<y3.a> f11978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f11979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11981d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f11982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f11986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f11987k;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(List<y3.a> list, b bVar, float f11, int i11, float f12);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11978a = Collections.emptyList();
        this.f11979b = b.f12011g;
        this.f11980c = 0;
        this.f11981d = 0.0533f;
        this.f11982f = 0.08f;
        this.f11983g = true;
        this.f11984h = true;
        androidx.media3.ui.a aVar = new androidx.media3.ui.a(context);
        this.f11986j = aVar;
        this.f11987k = aVar;
        addView(aVar);
        this.f11985i = 1;
    }

    private List<y3.a> getCuesWithStylingPreferencesApplied() {
        if (this.f11983g && this.f11984h) {
            return this.f11978a;
        }
        ArrayList arrayList = new ArrayList(this.f11978a.size());
        for (int i11 = 0; i11 < this.f11978a.size(); i11++) {
            arrayList.add(a(this.f11978a.get(i11)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (u0.f81838a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private b getUserCaptionStyle() {
        if (u0.f81838a < 19 || isInEditMode()) {
            return b.f12011g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? b.f12011g : b.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t11) {
        removeView(this.f11987k);
        View view = this.f11987k;
        if (view instanceof r0) {
            ((r0) view).g();
        }
        this.f11987k = t11;
        this.f11986j = t11;
        addView(t11);
    }

    public final y3.a a(y3.a aVar) {
        y3.a.b bVarA = aVar.a();
        if (!this.f11983g) {
            n0.e(bVarA);
        } else if (!this.f11984h) {
            n0.f(bVarA);
        }
        return bVarA.a();
    }

    public final void b(int i11, float f11) {
        this.f11980c = i11;
        this.f11981d = f11;
        c();
    }

    public final void c() {
        this.f11986j.a(getCuesWithStylingPreferencesApplied(), this.f11979b, this.f11981d, this.f11980c, this.f11982f);
    }

    public void setApplyEmbeddedFontSizes(boolean z11) {
        this.f11984h = z11;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z11) {
        this.f11983g = z11;
        c();
    }

    public void setBottomPaddingFraction(float f11) {
        this.f11982f = f11;
        c();
    }

    public void setCues(@Nullable List<y3.a> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f11978a = list;
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

    public void setStyle(b bVar) {
        this.f11979b = bVar;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i11) {
        if (this.f11985i == i11) {
            return;
        }
        if (i11 == 1) {
            setView(new androidx.media3.ui.a(getContext()));
        } else {
            if (i11 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new r0(getContext()));
        }
        this.f11985i = i11;
    }
}
