package x2;

import androidx.constraintlayout.core.motion.utils.j;
import androidx.constraintlayout.core.motion.utils.l;
import androidx.constraintlayout.core.motion.utils.m;
import androidx.constraintlayout.motion.widget.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f79840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f79841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f79842c;

    public b() {
        m mVar = new m();
        this.f79840a = mVar;
        this.f79842c = mVar;
    }

    @Override // androidx.constraintlayout.motion.widget.n
    public float a() {
        return this.f79842c.b();
    }

    public void b(float f11, float f12, float f13, float f14, float f15, float f16) {
        m mVar = this.f79840a;
        this.f79842c = mVar;
        mVar.d(f11, f12, f13, f14, f15, f16);
    }

    public boolean c() {
        return this.f79842c.a();
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        if (this.f79841b == null) {
            this.f79841b = new j();
        }
        j jVar = this.f79841b;
        this.f79842c = jVar;
        jVar.d(f11, f12, f13, f14, f15, f16, f17, i11);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        return this.f79842c.getInterpolation(f11);
    }
}
