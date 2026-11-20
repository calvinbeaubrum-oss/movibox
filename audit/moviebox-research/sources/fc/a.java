package fc;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements uc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f64850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f64851c;

    public a(String str) {
        this.f64849a = str;
    }

    @Override // uc.a
    public String b() {
        return this.f64851c;
    }

    @Override // uc.a
    public void c(Map<String, Object> map) {
        this.f64850b = map;
    }

    @Override // uc.a
    public void d(String str) {
        this.f64851c = str;
    }

    @Override // uc.a
    public Map<String, Object> getData() {
        return this.f64850b;
    }

    @Override // uc.a
    public String getName() {
        return this.f64849a;
    }
}
