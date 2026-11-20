package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class z2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z2 f35981b = new z2(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f35982a;

    public z2(boolean z11) {
        this.f35982a = z11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && z2.class == obj.getClass() && this.f35982a == ((z2) obj).f35982a;
    }

    public int hashCode() {
        return !this.f35982a ? 1 : 0;
    }
}
