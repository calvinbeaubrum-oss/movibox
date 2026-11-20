package com.applovin.impl;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class na extends ki {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f21304d = new o2.a() { // from class: com.applovin.impl.h00
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return na.b(bundle);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21306c;

    public na() {
        this.f21305b = false;
        this.f21306c = false;
    }

    public na(boolean z11) {
        this.f21305b = true;
        this.f21306c = z11;
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static na b(Bundle bundle) {
        b1.a(bundle.getInt(a(0), -1) == 0);
        return bundle.getBoolean(a(1), false) ? new na(bundle.getBoolean(a(2), false)) : new na();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof na)) {
            return false;
        }
        na naVar = (na) obj;
        return this.f21306c == naVar.f21306c && this.f21305b == naVar.f21305b;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f21305b), Boolean.valueOf(this.f21306c));
    }
}
