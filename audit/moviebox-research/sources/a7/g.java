package a7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f437c;

    public g(String str, float f11, float f12) {
        this.f435a = str;
        this.f437c = f12;
        this.f436b = f11;
    }

    public boolean a(String str) {
        if (this.f435a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f435a.endsWith("\r")) {
            String str2 = this.f435a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
