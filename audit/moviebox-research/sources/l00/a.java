package l00;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f69749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f69750b = false;

    public a(T t11) {
        if (t11 == null) {
            throw new IllegalArgumentException("null values in Event are not allowed.");
        }
        this.f69749a = t11;
    }

    public T a() {
        if (this.f69750b) {
            return null;
        }
        this.f69750b = true;
        return this.f69749a;
    }
}
