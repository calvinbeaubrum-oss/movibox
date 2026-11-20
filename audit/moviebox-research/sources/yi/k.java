package yi;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f81419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f81420b;

    public k(@NonNull g gVar, float f11) {
        this.f81419a = gVar;
        this.f81420b = f11;
    }

    @Override // yi.g
    public boolean a() {
        return this.f81419a.a();
    }

    @Override // yi.g
    public void b(float f11, float f12, float f13, @NonNull p pVar) {
        this.f81419a.b(f11, f12 - this.f81420b, f13, pVar);
    }
}
