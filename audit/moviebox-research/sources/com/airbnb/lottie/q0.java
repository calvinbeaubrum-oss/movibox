package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final V f15317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Throwable f15318b;

    public q0(V v11) {
        this.f15317a = v11;
        this.f15318b = null;
    }

    public q0(Throwable th2) {
        this.f15318b = th2;
        this.f15317a = null;
    }

    @Nullable
    public Throwable a() {
        return this.f15318b;
    }

    @Nullable
    public V b() {
        return this.f15317a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        if (b() != null && b().equals(q0Var.b())) {
            return true;
        }
        if (a() == null || q0Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }
}
