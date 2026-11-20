package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.applovin.impl.b5;
import com.applovin.impl.bf;
import com.applovin.impl.c20;
import com.applovin.impl.d20;
import com.applovin.impl.fo;
import com.applovin.impl.nh;
import com.applovin.impl.ph;
import com.applovin.impl.po;
import com.applovin.impl.qh;
import com.applovin.impl.r6;
import com.applovin.impl.td;
import com.applovin.impl.to;
import com.applovin.impl.vd;
import com.applovin.impl.x2;
import com.applovin.impl.xp;
import com.applovin.impl.xq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements qh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f17251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x2 f17252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17254d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f17259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f17260k;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(List list, x2 x2Var, float f11, int i11, float f12);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17251a = Collections.emptyList();
        this.f17252b = x2.f24204g;
        this.f17253c = 0;
        this.f17254d = 0.0533f;
        this.f17255f = 0.08f;
        this.f17256g = true;
        this.f17257h = true;
        com.applovin.exoplayer2.ui.a aVar = new com.applovin.exoplayer2.ui.a(context);
        this.f17259j = aVar;
        this.f17260k = aVar;
        addView(aVar);
        this.f17258i = 1;
    }

    private b5 a(b5 b5Var) {
        b5.b bVarA = b5Var.a();
        if (!this.f17256g) {
            h.a(bVarA);
        } else if (!this.f17257h) {
            h.b(bVarA);
        }
        return bVarA.a();
    }

    private void a(int i11, float f11) {
        this.f17253c = i11;
        this.f17254d = f11;
        e();
    }

    private void e() {
        this.f17259j.a(getCuesWithStylingPreferencesApplied(), this.f17252b, this.f17254d, this.f17253c, this.f17255f);
    }

    private List<b5> getCuesWithStylingPreferencesApplied() {
        if (this.f17256g && this.f17257h) {
            return this.f17251a;
        }
        ArrayList arrayList = new ArrayList(this.f17251a.size());
        for (int i11 = 0; i11 < this.f17251a.size(); i11++) {
            arrayList.add(a((b5) this.f17251a.get(i11)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (xp.f24372a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private x2 getUserCaptionStyle() {
        if (xp.f24372a < 19 || isInEditMode()) {
            return x2.f24204g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? x2.f24204g : x2.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t11) {
        removeView(this.f17260k);
        View view = this.f17260k;
        if (view instanceof j) {
            ((j) view).a();
        }
        this.f17260k = t11;
        this.f17259j = t11;
        addView(t11);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a() {
        d20.a(this);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(float f11) {
        d20.b(this, f11);
    }

    public void a(float f11, boolean z11) {
        a(z11 ? 1 : 0, f11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(int i11) {
        d20.c(this, i11);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(int i11, int i12) {
        d20.d(this, i11, i12);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(bf bfVar) {
        d20.e(this, bfVar);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(fo foVar, int i11) {
        d20.f(this, foVar, i11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(nh nhVar) {
        d20.g(this, nhVar);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(ph phVar) {
        d20.h(this, phVar);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(po poVar, to toVar) {
        d20.i(this, poVar, toVar);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(qh.b bVar) {
        d20.j(this, bVar);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(qh.f fVar, qh.f fVar2, int i11) {
        d20.k(this, fVar, fVar2, i11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(qh qhVar, qh.d dVar) {
        d20.l(this, qhVar, dVar);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(r6 r6Var) {
        d20.m(this, r6Var);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(td tdVar, int i11) {
        d20.n(this, tdVar, i11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(vd vdVar) {
        d20.o(this, vdVar);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(xq xqVar) {
        d20.p(this, xqVar);
    }

    @Override // com.applovin.impl.qh.e
    public void a(List list) {
        setCues(list);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(boolean z11) {
        d20.r(this, z11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(boolean z11, int i11) {
        d20.s(this, z11, i11);
    }

    @Override // com.applovin.impl.qh.c
    public /* synthetic */ void b() {
        c20.l(this);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void b(int i11) {
        d20.t(this, i11);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void b(int i11, boolean z11) {
        d20.u(this, i11, z11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void b(nh nhVar) {
        d20.v(this, nhVar);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void b(boolean z11) {
        d20.w(this, z11);
    }

    @Override // com.applovin.impl.qh.c
    public /* synthetic */ void b(boolean z11, int i11) {
        c20.o(this, z11, i11);
    }

    public void c() {
        setStyle(getUserCaptionStyle());
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void c(int i11) {
        d20.x(this, i11);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void c(boolean z11) {
        d20.y(this, z11);
    }

    public void d() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void d(boolean z11) {
        d20.z(this, z11);
    }

    @Override // com.applovin.impl.qh.c
    public /* synthetic */ void e(int i11) {
        c20.s(this, i11);
    }

    @Override // com.applovin.impl.qh.c
    public /* synthetic */ void e(boolean z11) {
        c20.t(this, z11);
    }

    public void setApplyEmbeddedFontSizes(boolean z11) {
        this.f17257h = z11;
        e();
    }

    public void setApplyEmbeddedStyles(boolean z11) {
        this.f17256g = z11;
        e();
    }

    public void setBottomPaddingFraction(float f11) {
        this.f17255f = f11;
        e();
    }

    public void setCues(@Nullable List<b5> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f17251a = list;
        e();
    }

    public void setFractionalTextSize(float f11) {
        a(f11, false);
    }

    public void setStyle(x2 x2Var) {
        this.f17252b = x2Var;
        e();
    }

    public void setViewType(int i11) {
        if (this.f17258i == i11) {
            return;
        }
        if (i11 == 1) {
            setView(new com.applovin.exoplayer2.ui.a(getContext()));
        } else {
            if (i11 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new j(getContext()));
        }
        this.f17258i = i11;
    }
}
