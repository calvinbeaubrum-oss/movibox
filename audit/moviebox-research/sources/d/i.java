package d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i {
    public static String a() {
        int iC = com.transsion.core.utils.d.c();
        if (iC == -101) {
            return "wifi";
        }
        if (iC == -1 || iC == 0) {
            return "";
        }
        if (iC == 1) {
            return "2G";
        }
        if (iC != 2) {
            return iC != 3 ? "" : "4G";
        }
        return "3G";
    }

    public static String b() {
        String strA = a();
        if ("wifi".equals(strA)) {
            return "wifi";
        }
        return "".equals(strA) ? "no_network" : "mobile";
    }

    public static boolean c() {
        return "wifi".equals(a());
    }
}
