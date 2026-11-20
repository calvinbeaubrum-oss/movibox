package v20;

import java.util.Locale;
import org.apache.tools.ant.BuildException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f78700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f78701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f78702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f78703d;

    static {
        String property = System.getProperty("os.name");
        Locale locale = Locale.US;
        f78700a = property.toLowerCase(locale);
        f78701b = System.getProperty("os.arch").toLowerCase(locale);
        f78702c = System.getProperty("os.version").toLowerCase(locale);
        f78703d = System.getProperty("path.separator");
    }

    public static boolean a(String str) {
        return c(str, null, null, null);
    }

    public static boolean b(String str) {
        return c(null, str, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x005b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0140  */
    public static boolean c(String str, String str2, String str3, String str4) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (str == null && str2 == null && str3 == null && str4 == null) {
            return false;
        }
        if (str != null) {
            String str5 = f78700a;
            z11 = str5.indexOf("windows") > -1;
            if (z11) {
                z12 = str5.indexOf("95") >= 0 || str5.indexOf("98") >= 0 || str5.indexOf("me") >= 0 || str5.indexOf("ce") >= 0;
                z13 = !z12;
            } else {
                z12 = false;
                z13 = false;
            }
            if (!str.equals("windows")) {
                if (str.equals("win9x")) {
                    if (z11 && z12) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("winnt")) {
                    if (z11 && z13) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("os/2")) {
                    if (str5.indexOf("os/2") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("netware")) {
                    if (str5.indexOf("netware") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("dos")) {
                    if (!f78703d.equals(";") || a("netware")) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                } else if (str.equals("mac")) {
                    if (str5.indexOf("mac") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("tandem")) {
                    if (str5.indexOf("nonstop_kernel") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("unix")) {
                    if (!f78703d.equals(":") || a("openvms") || (a("mac") && !str5.endsWith("x"))) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                } else if (str.equals("z/os")) {
                    if (str5.indexOf("z/os") > -1 || str5.indexOf("os/390") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else if (str.equals("os/400")) {
                    if (str5.indexOf("os/400") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    if (!str.equals("openvms")) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Don't know how to detect os family \"");
                        stringBuffer.append(str);
                        stringBuffer.append("\"");
                        throw new BuildException(stringBuffer.toString());
                    }
                    if (str5.indexOf("openvms") > -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
            }
        } else {
            z11 = true;
        }
        return z11 && (str2 != null ? str2.equals(f78700a) : true) && (str3 != null ? str3.equals(f78701b) : true) && (str4 != null ? str4.equals(f78702c) : true);
    }
}
