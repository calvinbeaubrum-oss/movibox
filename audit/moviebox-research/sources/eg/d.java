package eg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f64134a;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f64135a;

        @Override // eg.j.a
        public j a() {
            return new d(this.f64135a);
        }

        @Override // eg.j.a
        public j.a b(@Nullable Integer num) {
            this.f64135a = num;
            return this;
        }
    }

    public d(@Nullable Integer num) {
        this.f64134a = num;
    }

    @Override // eg.j
    @Nullable
    public Integer b() {
        return this.f64134a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        Integer num = this.f64134a;
        Integer numB = ((j) obj).b();
        if (num == null) {
            return numB == null;
        }
        return num.equals(numB);
    }

    public int hashCode() {
        Integer num = this.f64134a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f64134a + "}";
    }
}
