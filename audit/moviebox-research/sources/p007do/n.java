package p007do;

import android.content.Context;
import io.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f63487b;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a<M extends n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f63488a;

        public a(Class<? extends M> cls) {
            this.f63488a = cls;
        }

        public final Class a() {
            return this.f63488a;
        }

        public abstract M b(m mVar, Context context);
    }

    public n(String str, m mVar) {
        this.f63486a = getClass().getName() + "[" + str + "]";
        this.f63487b = mVar;
    }

    public void a() {
    }

    public final String b() {
        return this.f63486a;
    }

    public final void c(l lVar) {
        this.f63487b.g(this, lVar);
    }

    public final m d() {
        return this.f63487b;
    }

    public void e(Context context) throws Exception {
    }

    public String toString() {
        return this.f63486a;
    }
}
