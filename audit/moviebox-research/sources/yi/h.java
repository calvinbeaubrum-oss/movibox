package yi;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f81368a;

    public h(float f11) {
        this.f81368a = f11 - 0.001f;
    }

    @Override // yi.g
    public boolean a() {
        return true;
    }

    @Override // yi.g
    public void b(float f11, float f12, float f13, @NonNull p pVar) {
        float fSqrt = (float) ((((double) this.f81368a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.f81368a, 2.0d) - Math.pow(fSqrt, 2.0d));
        pVar.n(f12 - fSqrt, ((float) (-((((double) this.f81368a) * Math.sqrt(2.0d)) - ((double) this.f81368a)))) + fSqrt2);
        pVar.m(f12, (float) (-((((double) this.f81368a) * Math.sqrt(2.0d)) - ((double) this.f81368a))));
        pVar.m(f12 + fSqrt, ((float) (-((((double) this.f81368a) * Math.sqrt(2.0d)) - ((double) this.f81368a)))) + fSqrt2);
    }
}
