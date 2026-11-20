package com.cloud.sdk.commonutil.util;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f30311a = "";

    public static String a() {
        return WebSettings.getDefaultUserAgent(f.a());
    }

    public static String b() {
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String strReplace = Build.VERSION.RELEASE.replace(";", "");
        if (strReplace.length() > 0) {
            stringBuffer.append(strReplace);
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
            String str = Build.MODEL;
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str2);
        }
        return String.format("Mozilla/5.0 (Linux; Android %s;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36", stringBuffer);
    }

    public static String c() {
        try {
            if (d(f30311a)) {
                return f30311a;
            }
            String strI = da.a.d().i("user_agent");
            f30311a = strI;
            if (d(strI)) {
                return f30311a;
            }
            String strA = a();
            f30311a = strA;
            if (d(strA)) {
                da.a.d().p("user_agent", f30311a);
                return f30311a;
            }
            String strB = b();
            f30311a = strB;
            if (!d(strB)) {
                return "";
            }
            da.a.d().p("user_agent", f30311a);
            return f30311a;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean d(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 10 || str.contains("windows NT") || str.contains("Macintosh") || str.contains("Dalvik")) ? false : true;
    }
}
