package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class gh extends ki {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o2.a f19228c = new o2.a() { // from class: com.applovin.impl.vx
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return gh.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f19229b;

    public gh() {
        this.f19229b = -1.0f;
    }

    public gh(float f11) {
        b1.a(f11 >= 0.0f && f11 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f19229b = f11;
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static gh b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 1);
        float f11 = bundle.getFloat(a(1), -1.0f);
        return f11 == -1.0f ? new gh() : new gh(f11);
    }

    public boolean equals(Object obj) {
        return (obj instanceof gh) && this.f19229b == ((gh) obj).f19229b;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f19229b));
    }
}
