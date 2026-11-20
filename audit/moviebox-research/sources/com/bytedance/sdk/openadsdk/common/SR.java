package com.bytedance.sdk.openadsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public class SR extends View {
    private View pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f27690sc;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        View sc(Context context);
    }

    public SR(Context context, sc scVar) {
        super(context);
        this.f27690sc = scVar;
        sc();
    }

    private View pFF() {
        sc scVar;
        if (this.pFF == null && (scVar = this.f27690sc) != null) {
            this.pFF = scVar.sc(getContext());
            sc(this.pFF, (ViewGroup) getParent());
        }
        return this.pFF;
    }

    private void sc() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    private void sc(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        View view = this.pFF;
        if (view != null) {
            view.setVisibility(i11);
            return;
        }
        super.setVisibility(i11);
        if (i11 == 0 || i11 == 4) {
            pFF();
        }
    }
}
