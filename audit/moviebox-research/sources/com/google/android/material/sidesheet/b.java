package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f37497a;

    public b(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f37497a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    public int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public float b(int i11) {
        float fE = e();
        return (fE - i11) / (fE - d());
    }

    @Override // com.google.android.material.sidesheet.d
    public int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public int d() {
        return Math.max(0, (e() - this.f37497a.Z()) - this.f37497a.g0());
    }

    @Override // com.google.android.material.sidesheet.d
    public int e() {
        return this.f37497a.j0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int f() {
        return this.f37497a.j0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.d
    public <V extends View> int h(@NonNull V v11) {
        return v11.getLeft() - this.f37497a.g0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.d
    public int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean k(float f11) {
        return f11 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean l(@NonNull View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean m(float f11, float f12) {
        return e.a(f11, f12) && Math.abs(f11) > ((float) this.f37497a.k0());
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean n(@NonNull View view, float f11) {
        return Math.abs(((float) view.getRight()) + (f11 * this.f37497a.e0())) > this.f37497a.f0();
    }

    @Override // com.google.android.material.sidesheet.d
    public void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        marginLayoutParams.rightMargin = i11;
    }

    @Override // com.google.android.material.sidesheet.d
    public void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
        int iJ0 = this.f37497a.j0();
        if (i11 <= iJ0) {
            marginLayoutParams.rightMargin = iJ0 - i11;
        }
    }
}
