package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class v implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f37104a;

    public v(@NonNull TimeInterpolator timeInterpolator) {
        this.f37104a = timeInterpolator;
    }

    @NonNull
    public static TimeInterpolator a(boolean z11, @NonNull TimeInterpolator timeInterpolator) {
        return z11 ? timeInterpolator : new v(timeInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        return 1.0f - this.f37104a.getInterpolation(f11);
    }
}
