package aa;

import com.cloud.hisavana.sdk.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f468a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f469b = false;

    public static String a() {
        return b() != 0 ? "https://minproject.test.sunnbird.com/close-report/index.html" : "https://minproject.sunnbird.com/close-report/index.html";
    }

    public static int b() {
        return f468a;
    }

    public static String c() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/cloudcontrol/query/getCloudControlDataOffline";
    }

    public static String d() {
        int iB = b();
        if (iB == 0) {
            return "https://cc-api.hisavana.com";
        }
        if (iB == 2) {
            return "https://api-fat0101.eagllwin.com";
        }
        if (iB != 3) {
            return iB != 4 ? "https://api.test.hisavana.com" : "https://api.fat1.hisavana.com";
        }
        return "https://easymock.tmctool.com/mockurl/66f0d16c89ca3154e5a973ea";
    }

    public static String e() {
        return b() != 0 ? a0.f29085a.u() : a0.f29085a.s();
    }

    public static String f() {
        int iB = b();
        if (iB != 0) {
            return iB != 4 ? "https://api.test.eagllwin.com" : "https://api.fat1.eagllwin.com";
        }
        return "https://api.eagllwin.com";
    }

    public static String g() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/addispatch/query/hiTraffic";
    }

    public static String h() {
        return "/hisavana/traffic-dispatch/v1/consumer-not-login/addispatch/query/getAdData";
    }

    public static String i() {
        int iB = b();
        if (iB == 0) {
            return "https://api.hisavana.com";
        }
        if (iB == 2) {
            return "https://api-fat0101.eagllwin.com";
        }
        if (iB != 3) {
            return iB != 4 ? "https://api.test.hisavana.com" : "https://api.fat1.hisavana.com";
        }
        return "https://easymock.tmctool.com/mockurl/66f0d16c89ca3154e5a973ea";
    }

    public static boolean j() {
        return f469b;
    }
}
