package h7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f66375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f66376b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f11, float f12) {
        this.f66375a = f11;
        this.f66376b = f12;
    }

    public boolean a(float f11, float f12) {
        return this.f66375a == f11 && this.f66376b == f12;
    }

    public float b() {
        return this.f66375a;
    }

    public float c() {
        return this.f66376b;
    }

    public void d(float f11, float f12) {
        this.f66375a = f11;
        this.f66376b = f12;
    }

    public String toString() {
        return b() + "x" + c();
    }
}
