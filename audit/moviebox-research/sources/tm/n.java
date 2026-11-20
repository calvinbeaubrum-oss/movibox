package tm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f77239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f77241d;

    public n(int i11, String str) {
        super(i11);
        this.f77239b = str;
        this.f77241d = false;
        this.f77240c = 0;
    }

    public n(int i11, String str, int i12) {
        super(i11);
        this.f77241d = true;
        this.f77240c = i12;
        this.f77239b = str;
    }

    public String b() {
        return this.f77239b;
    }

    public int c() {
        return this.f77240c;
    }

    public boolean d() {
        return this.f77241d;
    }
}
