package sn;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f76428b;

    public d(String str, String str2) {
        this.f76427a = str;
        this.f76428b = str2;
    }

    public static d a(String str, String str2) {
        un.e.e(str, "Name is null or empty");
        un.e.e(str2, "Version is null or empty");
        return new d(str, str2);
    }

    public String b() {
        return this.f76427a;
    }

    public String c() {
        return this.f76428b;
    }
}
