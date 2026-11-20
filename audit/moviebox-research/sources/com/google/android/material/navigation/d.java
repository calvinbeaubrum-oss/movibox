package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends androidx.appcompat.view.menu.f {

    @NonNull
    public final Class<?> B;
    public final int C;

    public d(@NonNull Context context, @NonNull Class<?> cls, int i11) {
        super(context);
        this.B = cls;
        this.C = i11;
    }

    @Override // androidx.appcompat.view.menu.f
    @NonNull
    public MenuItem a(int i11, int i12, int i13, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.C) {
            i0();
            MenuItem menuItemA = super.a(i11, i12, i13, charSequence);
            if (menuItemA instanceof h) {
                ((h) menuItemA).t(true);
            }
            h0();
            return menuItemA;
        }
        String simpleName = this.B.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.C + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i11, int i12, int i13, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.B.getSimpleName() + " does not support submenus");
    }
}
