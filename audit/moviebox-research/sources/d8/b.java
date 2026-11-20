package d8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements ue.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62947b;

    public b(int i11, int i12) {
        this.f62946a = i11;
        this.f62947b = i12;
    }

    @Override // ue.a
    public int a() {
        return (this.f62947b - this.f62946a) + 1;
    }

    @Override // ue.a
    public Object getItem(int i11) {
        if (i11 < 0 || i11 >= a()) {
            return 0;
        }
        return Integer.valueOf(this.f62946a + i11);
    }
}
