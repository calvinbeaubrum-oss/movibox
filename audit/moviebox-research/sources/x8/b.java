package x8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f80440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f80441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f80442c;

    public b(int i11, int i12) {
        this.f80440a = i11;
        this.f80441b = i12;
    }

    public b(int i11, int i12, String str) {
        this.f80440a = i11;
        this.f80441b = i12;
        this.f80442c = str;
    }

    public int a() {
        return this.f80441b;
    }

    public int b() {
        return this.f80440a;
    }

    public void c(String str) {
        this.f80442c = str;
    }

    public String d() {
        return this.f80442c;
    }
}
