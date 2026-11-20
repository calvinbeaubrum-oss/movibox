package yk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f81503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f81504b;

    public T a() {
        return this.f81504b;
    }

    public Class<T> b() {
        return this.f81503a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f81503a, this.f81504b);
    }
}
