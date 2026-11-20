package kn;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68653b;

    public e(String str, String str2) {
        this.f68652a = str;
        this.f68653b = str2;
    }

    public static e a(String str, String str2) {
        nn.g.e(str, "Name is null or empty");
        nn.g.e(str2, "Version is null or empty");
        return new e(str, str2);
    }

    public String b() {
        return this.f68652a;
    }

    public String c() {
        return this.f68653b;
    }
}
