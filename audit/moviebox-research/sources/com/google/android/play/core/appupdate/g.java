package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f38043a;

    public /* synthetic */ g(f fVar) {
    }

    public final e a() {
        n nVar = this.f38043a;
        if (nVar != null) {
            return new c0(nVar, null);
        }
        throw new IllegalStateException(String.valueOf(n.class.getCanonicalName()).concat(" must be set"));
    }

    public final g b(n nVar) {
        this.f38043a = nVar;
        return this;
    }
}
