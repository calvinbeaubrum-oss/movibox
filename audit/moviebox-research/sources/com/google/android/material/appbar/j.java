package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f36183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36185c;

    public j() {
        this.f36184b = 0;
        this.f36185c = 0;
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36184b = 0;
        this.f36185c = 0;
    }

    public int E() {
        k kVar = this.f36183a;
        if (kVar != null) {
            return kVar.c();
        }
        return 0;
    }

    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        coordinatorLayout.onLayoutChild(v11, i11);
    }

    public boolean G(int i11) {
        k kVar = this.f36183a;
        if (kVar != null) {
            return kVar.f(i11);
        }
        this.f36184b = i11;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v11, int i11) {
        F(coordinatorLayout, v11, i11);
        if (this.f36183a == null) {
            this.f36183a = new k(v11);
        }
        this.f36183a.d();
        this.f36183a.a();
        int i12 = this.f36184b;
        if (i12 != 0) {
            this.f36183a.f(i12);
            this.f36184b = 0;
        }
        int i13 = this.f36185c;
        if (i13 == 0) {
            return true;
        }
        this.f36183a.e(i13);
        this.f36185c = 0;
        return true;
    }
}
