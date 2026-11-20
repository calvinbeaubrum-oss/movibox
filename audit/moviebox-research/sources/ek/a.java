package ek;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f64269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f64270b;

    public a() {
        this(null);
    }

    public a(c cVar) {
        this.f64270b = new ConcurrentHashMap();
        this.f64269a = cVar;
    }

    public String toString() {
        return this.f64270b.toString();
    }
}
