package fg;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f64863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final og.a f64864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final og.a f64865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64866d;

    public b(Context context, og.a aVar, og.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f64863a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f64864b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f64865c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f64866d = str;
    }

    @Override // fg.f
    public Context b() {
        return this.f64863a;
    }

    @Override // fg.f
    @NonNull
    public String c() {
        return this.f64866d;
    }

    @Override // fg.f
    public og.a d() {
        return this.f64865c;
    }

    @Override // fg.f
    public og.a e() {
        return this.f64864b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f64863a.equals(fVar.b()) && this.f64864b.equals(fVar.e()) && this.f64865c.equals(fVar.d()) && this.f64866d.equals(fVar.c());
    }

    public int hashCode() {
        return ((((((this.f64863a.hashCode() ^ 1000003) * 1000003) ^ this.f64864b.hashCode()) * 1000003) ^ this.f64865c.hashCode()) * 1000003) ^ this.f64866d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f64863a + ", wallClock=" + this.f64864b + ", monotonicClock=" + this.f64865c + ", backendName=" + this.f64866d + "}";
    }
}
