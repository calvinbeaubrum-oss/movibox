package rm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75627b;

    public b(int i11, int i12) {
        this.f75626a = i11;
        this.f75627b = i12;
    }

    public final int a() {
        return this.f75627b;
    }

    public final int b() {
        return this.f75626a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f75626a == bVar.f75626a && this.f75627b == bVar.f75627b;
    }

    public final int hashCode() {
        return this.f75626a ^ this.f75627b;
    }

    public final String toString() {
        return this.f75626a + "(" + this.f75627b + ')';
    }
}
