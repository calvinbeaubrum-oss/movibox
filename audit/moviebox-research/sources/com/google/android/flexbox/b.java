package com.google.android.flexbox;

import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f36052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f36053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f36054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f36055m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36057o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f36058p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f36059q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f36060r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36043a = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36044b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36045c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36046d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Integer> f36056n = new ArrayList();

    public int a() {
        return this.f36049g;
    }

    public int b() {
        return this.f36050h;
    }

    public int c() {
        return this.f36050h - this.f36051i;
    }

    public void d(View view, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f36043a = Math.min(this.f36043a, (view.getLeft() - flexItem.getMarginLeft()) - i11);
        this.f36044b = Math.min(this.f36044b, (view.getTop() - flexItem.getMarginTop()) - i12);
        this.f36045c = Math.max(this.f36045c, view.getRight() + flexItem.getMarginRight() + i13);
        this.f36046d = Math.max(this.f36046d, view.getBottom() + flexItem.getMarginBottom() + i14);
    }
}
