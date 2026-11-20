package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class si {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final si f22909b = new si(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22910a;

    public si(boolean z11) {
        this.f22910a = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && si.class == obj.getClass() && this.f22910a == ((si) obj).f22910a;
    }

    public int hashCode() {
        return !this.f22910a ? 1 : 0;
    }
}
