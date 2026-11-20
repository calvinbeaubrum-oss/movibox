package cg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f14785a;

    public b(@Nullable Integer num) {
        this.f14785a = num;
    }

    @Override // cg.e
    @Nullable
    public Integer a() {
        return this.f14785a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        Integer num = this.f14785a;
        Integer numA = ((e) obj).a();
        if (num == null) {
            return numA == null;
        }
        return num.equals(numA);
    }

    public int hashCode() {
        Integer num = this.f14785a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f14785a + "}";
    }
}
