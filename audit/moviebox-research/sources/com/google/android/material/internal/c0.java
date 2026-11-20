package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(18)
public class c0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f37029a;

    public c0(@NonNull View view) {
        this.f37029a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.d0
    public void a(@NonNull Drawable drawable) {
        this.f37029a.add(drawable);
    }

    @Override // com.google.android.material.internal.d0
    public void b(@NonNull Drawable drawable) {
        this.f37029a.remove(drawable);
    }
}
