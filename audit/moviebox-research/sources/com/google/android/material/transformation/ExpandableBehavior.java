package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37986a;

    /* JADX INFO: compiled from: source.java */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f37987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f37988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ qi.a f37989c;

        public a(View view, int i11, qi.a aVar) {
            this.f37987a = view;
            this.f37988b = i11;
            this.f37989c = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f37987a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f37986a == this.f37988b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                qi.a aVar = this.f37989c;
                expandableBehavior.H((View) aVar, this.f37987a, aVar.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f37986a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37986a = 0;
    }

    public final boolean F(boolean z11) {
        if (!z11) {
            return this.f37986a == 1;
        }
        int i11 = this.f37986a;
        return i11 == 0 || i11 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public qi.a G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view2 = dependencies.get(i11);
            if (e(coordinatorLayout, view, view2)) {
                return (qi.a) view2;
            }
        }
        return null;
    }

    public abstract boolean H(View view, View view2, boolean z11, boolean z12);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @CallSuper
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        qi.a aVar = (qi.a) view2;
        if (!F(aVar.isExpanded())) {
            return false;
        }
        this.f37986a = aVar.isExpanded() ? 1 : 2;
        return H((View) aVar, view, aVar.isExpanded(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @CallSuper
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i11) {
        qi.a aVarG;
        if (ViewCompat.isLaidOut(view) || (aVarG = G(coordinatorLayout, view)) == null || !F(aVarG.isExpanded())) {
            return false;
        }
        int i12 = aVarG.isExpanded() ? 1 : 2;
        this.f37986a = i12;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i12, aVarG));
        return false;
    }
}
