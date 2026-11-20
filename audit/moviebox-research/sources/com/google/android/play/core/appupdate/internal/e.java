package com.google.android.play.core.appupdate.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f38048c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile g f38049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f38050b = f38048c;

    public e(g gVar) {
        this.f38049a = gVar;
    }

    public static g a(g gVar) {
        gVar.getClass();
        return gVar instanceof e ? gVar : new e(gVar);
    }

    @Override // com.google.android.play.core.appupdate.internal.g
    public final Object zza() {
        Object objZza = this.f38050b;
        Object obj = f38048c;
        if (objZza == obj) {
            synchronized (this) {
                try {
                    objZza = this.f38050b;
                    if (objZza == obj) {
                        objZza = this.f38049a.zza();
                        Object obj2 = this.f38050b;
                        if (obj2 != obj && obj2 != objZza) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZza + ". This is likely due to a circular dependency.");
                        }
                        this.f38050b = objZza;
                        this.f38049a = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return objZza;
    }
}
