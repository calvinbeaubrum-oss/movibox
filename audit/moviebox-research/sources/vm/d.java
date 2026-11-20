package vm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f79017e = -1;

    public d(int i11, int i12, int i13, int i14) {
        this.f79013a = i11;
        this.f79014b = i12;
        this.f79015c = i13;
        this.f79016d = i14;
    }

    public int a() {
        return this.f79015c;
    }

    public int b() {
        return this.f79014b;
    }

    public int c() {
        return this.f79017e;
    }

    public int d() {
        return this.f79013a;
    }

    public int e() {
        return this.f79016d;
    }

    public int f() {
        return this.f79014b - this.f79013a;
    }

    public boolean g() {
        return h(this.f79017e);
    }

    public boolean h(int i11) {
        return i11 != -1 && this.f79015c == (i11 % 3) * 3;
    }

    public void i(int i11) {
        this.f79017e = i11;
    }

    public void j() {
        this.f79017e = ((this.f79016d / 30) * 3) + (this.f79015c / 3);
    }

    public String toString() {
        return this.f79017e + "|" + this.f79016d;
    }
}
