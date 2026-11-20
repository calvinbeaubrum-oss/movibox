package ja;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.utils.p;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f67971a = "";

    public static boolean a() {
        try {
            if (TextUtils.isEmpty(f67971a)) {
                d();
            }
            return (f67971a.contains("windows NT") || f67971a.contains("Macintosh") || f67971a.contains("Dalvik")) ? false : true;
        } catch (Throwable th2) {
            p.c("ad", "checkAgent is error , error msg is :=" + Log.getStackTraceString(th2));
            return false;
        }
    }

    public static String b() {
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str3);
        }
        return String.format("Mozilla/5.0 (Linux; Android %s;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36", stringBuffer);
    }

    public static String c() {
        try {
            return a() ? f67971a : "";
        } catch (Throwable th2) {
            p.c("ad", "UserAgentUtil getUserAgent is error , error infor is :=" + Log.getStackTraceString(th2));
            return "";
        }
    }

    public static void d() {
        try {
            if (TextUtils.isEmpty(f67971a)) {
                f67971a = b();
            }
        } catch (Throwable th2) {
            p.c("ad", "init is error , error infor is :=" + Log.getStackTraceString(th2));
        }
    }
}
