package k7;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f68457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f68460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f68461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f68462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f68463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f68464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f68465i;

    public e() {
    }

    public e(int i11, e eVar) {
        this.f68457a = i11;
        this.f68458b = eVar.f68458b;
        this.f68459c = eVar.f68459c;
        this.f68460d = eVar.f68460d;
        this.f68461e = eVar.f68461e;
        this.f68462f = eVar.f68462f;
        this.f68463g = eVar.f68463g;
        this.f68464h = eVar.f68464h;
    }

    public boolean a(e eVar) {
        int i11 = this.f68458b;
        if (i11 != 1) {
            if (i11 != 15) {
                if (i11 == 12) {
                    return eVar.f68461e.equals(this.f68461e) && eVar.f68462f.equals(this.f68462f);
                }
                if (i11 != 13) {
                    switch (i11) {
                        case 3:
                        case 4:
                            return eVar.f68459c == this.f68459c;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return eVar.f68461e.equals(this.f68461e) && eVar.f68462f.equals(this.f68462f) && eVar.f68463g.equals(this.f68463g);
                    }
                }
            }
            return eVar.f68460d == this.f68460d;
        }
        return eVar.f68461e.equals(this.f68461e);
    }

    public void b(int i11) {
        this.f68458b = 3;
        this.f68459c = i11;
        this.f68464h = (3 + i11) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public void c(int i11, String str, String str2, String str3) {
        this.f68458b = i11;
        this.f68461e = str;
        this.f68462f = str2;
        this.f68463g = str3;
        if (i11 != 1 && i11 != 7 && i11 != 8) {
            if (i11 == 12) {
                this.f68464h = (i11 + (str.hashCode() * str2.hashCode())) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                return;
            } else if (i11 != 13) {
                this.f68464h = (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                return;
            }
        }
        this.f68464h = (i11 + str.hashCode()) & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
