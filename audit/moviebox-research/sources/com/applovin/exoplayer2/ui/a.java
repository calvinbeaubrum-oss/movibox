package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.impl.b5;
import com.applovin.impl.x2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f17261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f17262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17264d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private x2 f17265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f17266g;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17261a = new ArrayList();
        this.f17262b = Collections.emptyList();
        this.f17263c = 0;
        this.f17264d = 0.0533f;
        this.f17265f = x2.f24204g;
        this.f17266g = 0.08f;
    }

    private static b5 a(b5 b5Var) {
        b5.b bVarB = b5Var.a().b(-3.4028235E38f).b(Integer.MIN_VALUE).b((Layout.Alignment) null);
        if (b5Var.f17837g == 0) {
            bVarB.a(1.0f - b5Var.f17836f, 0);
        } else {
            bVarB.a((-b5Var.f17836f) - 1.0f, 1);
        }
        int i11 = b5Var.f17838h;
        if (i11 == 0) {
            bVarB.a(2);
        } else if (i11 == 2) {
            bVarB.a(0);
        }
        return bVarB.a();
    }

    @Override // com.applovin.exoplayer2.ui.SubtitleView.a
    public void a(List list, x2 x2Var, float f11, int i11, float f12) {
        this.f17262b = list;
        this.f17265f = x2Var;
        this.f17264d = f11;
        this.f17263c = i11;
        this.f17266g = f12;
        while (this.f17261a.size() < list.size()) {
            this.f17261a.add(new g(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.f17262b;
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
        float fA = h.a(this.f17263c, this.f17264d, height, i11);
        if (fA <= 0.0f) {
            return;
        }
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            b5 b5VarA = (b5) list.get(i12);
            if (b5VarA.f17847q != Integer.MIN_VALUE) {
                b5VarA = a(b5VarA);
            }
            b5 b5Var = b5VarA;
            int i13 = paddingBottom;
            ((g) this.f17261a.get(i12)).a(b5Var, this.f17265f, fA, h.a(b5Var.f17845o, b5Var.f17846p, height, i11), this.f17266g, canvas, paddingLeft, paddingTop, width, i13);
            i12++;
            size = size;
            i11 = i11;
            paddingBottom = i13;
            width = width;
        }
    }
}
