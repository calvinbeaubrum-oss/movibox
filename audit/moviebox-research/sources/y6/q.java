package y6;

import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q<K, A> extends a<K, A> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final A f81298i;

    public q(h7.c<A> cVar) {
        this(cVar, null);
    }

    public q(h7.c<A> cVar, @Nullable A a11) {
        super(Collections.emptyList());
        o(cVar);
        this.f81298i = a11;
    }

    @Override // y6.a
    public float c() {
        return 1.0f;
    }

    @Override // y6.a
    public A h() {
        h7.c<A> cVar = this.f81231e;
        A a11 = this.f81298i;
        return cVar.b(0.0f, 0.0f, a11, a11, f(), f(), f());
    }

    @Override // y6.a
    public A i(h7.a<K> aVar, float f11) {
        return h();
    }

    @Override // y6.a
    public void l() {
        if (this.f81231e != null) {
            super.l();
        }
    }

    @Override // y6.a
    public void n(float f11) {
        this.f81230d = f11;
    }
}
