package eg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f64136a;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f64137a;

        @Override // eg.k.a
        public k a() {
            return new e(this.f64137a);
        }

        @Override // eg.k.a
        public k.a b(@Nullable j jVar) {
            this.f64137a = jVar;
            return this;
        }
    }

    public e(@Nullable j jVar) {
        this.f64136a = jVar;
    }

    @Override // eg.k
    @Nullable
    public j b() {
        return this.f64136a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        j jVar = this.f64136a;
        j jVarB = ((k) obj).b();
        if (jVar == null) {
            return jVarB == null;
        }
        return jVar.equals(jVarB);
    }

    public int hashCode() {
        j jVar = this.f64136a;
        return (jVar == null ? 0 : jVar.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f64136a + "}";
    }
}
