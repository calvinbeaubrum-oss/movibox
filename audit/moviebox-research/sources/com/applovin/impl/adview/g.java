package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f17604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17605b;

    public g(e.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        e eVarA = e.a(aVar, activity);
        this.f17604a = eVarA;
        addView(eVarA);
    }

    public void a(int i11, int i12, int i13, int i14) {
        this.f17605b = i11;
        int i15 = i12 + i11 + i13;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i15;
            layoutParams.width = i15;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i15, i15));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i11, i11, i14);
        layoutParams2.setMargins(i13, i13, i13, 0);
        this.f17604a.setLayoutParams(layoutParams2);
        this.f17604a.a(i11);
    }

    public void a(e.a aVar) {
        if (aVar == null || aVar == this.f17604a.getStyle()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f17604a.getLayoutParams();
        removeView(this.f17604a);
        e eVarA = e.a(aVar, getContext());
        this.f17604a = eVarA;
        addView(eVarA);
        this.f17604a.setLayoutParams(layoutParams);
        this.f17604a.a(this.f17605b);
    }
}
