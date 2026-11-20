package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h<S extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f37304a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f37305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f37306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f37308d;
    }

    public h(S s11) {
        this.f37304a = s11;
    }

    public abstract void a(@NonNull Canvas canvas, @NonNull Rect rect, float f11, boolean z11, boolean z12);

    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, int i11, int i12);

    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull a aVar, int i11);

    public abstract void d(@NonNull Canvas canvas, @NonNull Paint paint, float f11, float f12, int i11, int i12, int i13);

    public abstract int e();

    public abstract int f();

    public void g(@NonNull Canvas canvas, @NonNull Rect rect, float f11, boolean z11, boolean z12) {
        this.f37304a.e();
        a(canvas, rect, f11, z11, z12);
    }
}
