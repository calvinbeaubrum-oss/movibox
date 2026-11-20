package k20;

import com.transsion.gslb.GslbSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f68227c = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f68228a = "https://ire-oneid.shalltry.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f68229b = "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";

    public static l d() {
        return f68227c;
    }

    public String a() {
        return GslbSdk.getDomain(this.f68228a, true) + "/one/v1/change";
    }

    public String b() {
        return this.f68229b;
    }

    public String c() {
        return this.f68228a;
    }

    public String e() {
        return GslbSdk.getDomain(this.f68228a, true) + "/one/v1/log";
    }

    public String f() {
        return GslbSdk.getDomain(this.f68228a, true) + "/one/v1/odid";
    }
}
