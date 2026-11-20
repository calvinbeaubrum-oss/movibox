package athena;

import com.transsion.core.log.ObjectLogUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObjectLogUtils f13598a = new ObjectLogUtils.a().p("Athena").q(true).n(false).m();

    public static void a(String str) {
        String str2 = "%s";
        if (str != null && str.length() != 0) {
            str2 = String.format("%s", str);
        }
        ObjectLogUtils objectLogUtils = f13598a;
        objectLogUtils.x(1);
        objectLogUtils.g(str2);
    }

    public static void b(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        ObjectLogUtils objectLogUtils = f13598a;
        objectLogUtils.x(1);
        objectLogUtils.g(str);
    }

    public static void c(String str) {
        String str2 = "%s";
        if (str != null && str.length() != 0) {
            str2 = String.format("%s", str);
        }
        ObjectLogUtils objectLogUtils = f13598a;
        objectLogUtils.x(1);
        objectLogUtils.i(str2);
    }

    public static void d(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        ObjectLogUtils objectLogUtils = f13598a;
        objectLogUtils.x(1);
        objectLogUtils.i(str);
    }

    public static void e(String str) {
        String str2 = "%s";
        if (str != null && str.length() != 0) {
            str2 = String.format("%s", str);
        }
        ObjectLogUtils objectLogUtils = f13598a;
        objectLogUtils.x(1);
        objectLogUtils.n(str2);
    }

    public static void f(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        ObjectLogUtils objectLogUtils = f13598a;
        objectLogUtils.x(1);
        objectLogUtils.n(str);
    }
}
