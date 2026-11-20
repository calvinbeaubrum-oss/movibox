package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class cl extends ki {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f18257d = new o2.a() { // from class: com.applovin.impl.uu
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return cl.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f18259c;

    public cl(int i11) {
        b1.a(i11 > 0, "maxStars must be a positive integer");
        this.f18258b = i11;
        this.f18259c = -1.0f;
    }

    public cl(int i11, float f11) {
        b1.a(i11 > 0, "maxStars must be a positive integer");
        b1.a(f11 >= 0.0f && f11 <= ((float) i11), "starRating is out of range [0, maxStars]");
        this.f18258b = i11;
        this.f18259c = f11;
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cl b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 2);
        int i11 = bundle.getInt(a(1), 5);
        float f11 = bundle.getFloat(a(2), -1.0f);
        return f11 == -1.0f ? new cl(i11) : new cl(i11, f11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cl)) {
            return false;
        }
        cl clVar = (cl) obj;
        return this.f18258b == clVar.f18258b && this.f18259c == clVar.f18259c;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f18258b), Float.valueOf(this.f18259c));
    }
}
