package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j0> f35087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<vh.b> f35088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f35090d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f35091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f35092g;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35087a = new ArrayList();
        this.f35088b = Collections.emptyList();
        this.f35089c = 0;
        this.f35090d = 0.0533f;
        this.f35091f = c.f35094g;
        this.f35092g = 0.08f;
    }

    public static vh.b b(vh.b bVar) {
        vh.b.C0875b c0875bP = bVar.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (bVar.f78823g == 0) {
            c0875bP.h(1.0f - bVar.f78822f, 0);
        } else {
            c0875bP.h((-bVar.f78822f) - 1.0f, 1);
        }
        int i11 = bVar.f78824h;
        if (i11 == 0) {
            c0875bP.i(2);
        } else if (i11 == 2) {
            c0875bP.i(0);
        }
        return c0875bP.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<vh.b> list, c cVar, float f11, int i11, float f12) {
        this.f35088b = list;
        this.f35091f = cVar;
        this.f35090d = f11;
        this.f35089c = i11;
        this.f35092g = f12;
        while (this.f35087a.size() < list.size()) {
            this.f35087a.add(new j0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<vh.b> list = this.f35088b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i11 = paddingBottom - paddingTop;
        float fH = m0.h(this.f35089c, this.f35090d, height, i11);
        if (fH <= 0.0f) {
            return;
        }
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            vh.b bVarB = list.get(i12);
            if (bVarB.f78833q != Integer.MIN_VALUE) {
                bVarB = b(bVarB);
            }
            vh.b bVar = bVarB;
            int i13 = paddingBottom;
            this.f35087a.get(i12).b(bVar, this.f35091f, fH, m0.h(bVar.f78831o, bVar.f78832p, height, i11), this.f35092g, canvas, paddingLeft, paddingTop, width, i13);
            i12++;
            size = size;
            i11 = i11;
            paddingBottom = i13;
            width = width;
        }
    }
}
