package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f36186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36191f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36192g = true;

    public k(View view) {
        this.f36186a = view;
    }

    public void a() {
        View view = this.f36186a;
        ViewCompat.offsetTopAndBottom(view, this.f36189d - (view.getTop() - this.f36187b));
        View view2 = this.f36186a;
        ViewCompat.offsetLeftAndRight(view2, this.f36190e - (view2.getLeft() - this.f36188c));
    }

    public int b() {
        return this.f36187b;
    }

    public int c() {
        return this.f36189d;
    }

    public void d() {
        this.f36187b = this.f36186a.getTop();
        this.f36188c = this.f36186a.getLeft();
    }

    public boolean e(int i11) {
        if (!this.f36192g || this.f36190e == i11) {
            return false;
        }
        this.f36190e = i11;
        a();
        return true;
    }

    public boolean f(int i11) {
        if (!this.f36191f || this.f36189d == i11) {
            return false;
        }
        this.f36189d = i11;
        a();
        return true;
    }
}
