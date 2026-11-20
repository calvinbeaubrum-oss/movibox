package com.applovin.impl;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ph implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ph f21775d = new ph(1.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o2.a f21776f = new o2.a() { // from class: com.applovin.impl.h10
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return ph.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f21777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f21778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21779c;

    public ph(float f11) {
        this(f11, 1.0f);
    }

    public ph(float f11, float f12) {
        b1.a(f11 > 0.0f);
        b1.a(f12 > 0.0f);
        this.f21777a = f11;
        this.f21778b = f12;
        this.f21779c = Math.round(f11 * 1000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ph a(Bundle bundle) {
        return new ph(bundle.getFloat(a(0), 1.0f), bundle.getFloat(a(1), 1.0f));
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    public long a(long j11) {
        return j11 * ((long) this.f21779c);
    }

    public ph a(float f11) {
        return new ph(f11, this.f21778b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ph.class != obj.getClass()) {
            return false;
        }
        ph phVar = (ph) obj;
        return this.f21777a == phVar.f21777a && this.f21778b == phVar.f21778b;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.f21777a) + 527) * 31) + Float.floatToRawIntBits(this.f21778b);
    }

    public String toString() {
        return xp.a("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f21777a), Float.valueOf(this.f21778b));
    }
}
