package com.google.android.play.core.appupdate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f38035b;

    public /* synthetic */ a0(int i11, boolean z11, z zVar) {
        this.f38034a = i11;
        this.f38035b = z11;
    }

    @Override // com.google.android.play.core.appupdate.d
    public final boolean a() {
        return this.f38035b;
    }

    @Override // com.google.android.play.core.appupdate.d
    public final int b() {
        return this.f38034a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f38034a == dVar.b() && this.f38035b == dVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f38034a ^ 1000003) * 1000003) ^ (true != this.f38035b ? 1237 : 1231);
    }

    public final String toString() {
        return "AppUpdateOptions{appUpdateType=" + this.f38034a + ", allowAssetPackDeletion=" + this.f38035b + "}";
    }
}
