package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i<T extends Animator> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f37309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h.a> f37310b = new ArrayList();

    public i(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            this.f37310b.add(new h.a());
        }
    }

    public abstract void a();

    public float b(int i11, int i12, int i13) {
        return (i11 - i12) / i13;
    }

    public abstract void c();

    public abstract void d(@NonNull l6.b bVar);

    public void e(@NonNull j jVar) {
        this.f37309a = jVar;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
