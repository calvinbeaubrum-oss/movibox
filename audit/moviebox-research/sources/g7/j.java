package g7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f65454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f65455b;

    public void a(float f11) {
        float f12 = this.f65454a + f11;
        this.f65454a = f12;
        int i11 = this.f65455b + 1;
        this.f65455b = i11;
        if (i11 == Integer.MAX_VALUE) {
            this.f65454a = f12 / 2.0f;
            this.f65455b = i11 / 2;
        }
    }
}
