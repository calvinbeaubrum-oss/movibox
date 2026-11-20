package com.bytedance.adsdk.ugeno.yoga;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends ViewGroup {
    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof sc) {
            throw null;
        }
        Tf tfSc = Ql.sc();
        Qj.sc(new Qj.sc(layoutParams), tfSc, view);
        tfSc.sc(view);
        tfSc.sc((Ol) new Qj.pFF());
        throw null;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Qj.sc;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new Qj.sc(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new Qj.sc(layoutParams);
    }

    public Tf getYogaNode() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }
}
