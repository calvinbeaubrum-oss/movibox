package cg;

import androidx.annotation.Nullable;
import com.google.android.datatransport.Priority;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f14781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f14782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Priority f14783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f14784d;

    public a(@Nullable Integer num, T t11, Priority priority, @Nullable e eVar) {
        this.f14781a = num;
        if (t11 == null) {
            throw new NullPointerException("Null payload");
        }
        this.f14782b = t11;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f14783c = priority;
        this.f14784d = eVar;
    }

    @Override // cg.d
    @Nullable
    public Integer a() {
        return this.f14781a;
    }

    @Override // cg.d
    public T b() {
        return this.f14782b;
    }

    @Override // cg.d
    public Priority c() {
        return this.f14783c;
    }

    @Override // cg.d
    @Nullable
    public e d() {
        return this.f14784d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Integer num = this.f14781a;
        if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
            if (this.f14782b.equals(dVar.b()) && this.f14783c.equals(dVar.c())) {
                e eVar = this.f14784d;
                if (eVar == null) {
                    if (dVar.d() == null) {
                        return true;
                    }
                } else if (eVar.equals(dVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f14781a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f14782b.hashCode()) * 1000003) ^ this.f14783c.hashCode()) * 1000003;
        e eVar = this.f14784d;
        return iHashCode ^ (eVar != null ? eVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{code=" + this.f14781a + ", payload=" + this.f14782b + ", priority=" + this.f14783c + ", productData=" + this.f14784d + "}";
    }
}
