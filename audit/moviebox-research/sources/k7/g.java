package k7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68471b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f68474e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f68473d = new StringBuilder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68472c = 0;

    public g(int i11, int i12) {
        this.f68471b = i11;
        this.f68470a = i12;
        this.f68474e = i12 == 0;
    }

    public String a() {
        return this.f68473d.length() != 0 ? this.f68473d.substring(1) : "";
    }

    public void b(String str, int i11) {
        int i12 = this.f68471b;
        if (i11 < i12 || i11 >= i12 + this.f68470a) {
            return;
        }
        if (!str.equals("arg" + this.f68472c)) {
            this.f68474e = true;
        }
        this.f68473d.append(',');
        this.f68473d.append(str);
        this.f68472c++;
    }
}
