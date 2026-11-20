package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class co extends ki {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f18267d = new o2.a() { // from class: com.applovin.impl.vu
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return co.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f18269c;

    public co() {
        this.f18268b = false;
        this.f18269c = false;
    }

    public co(boolean z11) {
        this.f18268b = true;
        this.f18269c = z11;
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static co b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 3);
        return bundle.getBoolean(a(1), false) ? new co(bundle.getBoolean(a(2), false)) : new co();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof co)) {
            return false;
        }
        co coVar = (co) obj;
        return this.f18269c == coVar.f18269c && this.f18268b == coVar.f18268b;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f18268b), Boolean.valueOf(this.f18269c));
    }
}
