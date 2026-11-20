package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f37496a;

    public a(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f37496a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    public int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public float b(int i11) {
        float fE = e();
        return (i11 - fE) / (d() - fE);
    }

    @Override // com.google.android.material.sidesheet.d
    public int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public int d() {
        return Math.max(0, this.f37496a.i0() + this.f37496a.g0());
    }

    @Override // com.google.android.material.sidesheet.d
    public int e() {
        return (-this.f37496a.Z()) - this.f37496a.g0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int f() {
        return this.f37496a.g0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int g() {
        return -this.f37496a.Z();
    }

    @Override // com.google.android.material.sidesheet.d
    public <V extends View> int h(@NonNull V v11) {
        return v11.getRight() + this.f37496a.g0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.d
    public int j() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean k(float f11) {
        return f11 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean l(@NonNull View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean m(float f11, float f12) {
        return e.a(f11, f12) && Math.abs(f11) > ((float) this.f37496a.k0());
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean n(@NonNull View view, float f11) {
        return Math.abs(((float) view.getLeft()) + (f11 * this.f37496a.e0())) > this.f37496a.f0();
    }

    @Override // com.google.android.material.sidesheet.d
    public void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        marginLayoutParams.leftMargin = i11;
    }

    @Override // com.google.android.material.sidesheet.d
    public void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
        if (i11 <= this.f37496a.j0()) {
            marginLayoutParams.leftMargin = i12;
        }
    }
}
