package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR {
    private static volatile SR zY;
    private Context We;
    private volatile boolean pFF = false;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Map<String, String> f27028sc;

    private SR(Context context) {
        if (context != null && this.We == null) {
            this.We = context.getApplicationContext();
            sc();
        }
        this.We = context;
    }

    private static String ExN(String str) {
        int iIndexOf;
        return (str == null || str.isEmpty() || (iIndexOf = str.indexOf(46)) < 0 || iIndexOf >= str.length() + (-1)) ? "" : str.substring(iIndexOf + 1);
    }

    private void TRI(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.charAt(0) == '#') {
            return;
        }
        String strReplaceAll = strTrim.replaceAll("\\s*#.*", "");
        if (strReplaceAll.indexOf(61) <= 0) {
            String[] strArrSplit = strReplaceAll.split("\\s+");
            for (int i11 = 1; i11 < strArrSplit.length; i11++) {
                sc(strArrSplit[i11], strArrSplit[0]);
            }
            return;
        }
        Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(strReplaceAll);
        if (matcher.find()) {
            String strSubstring = matcher.group().substring(5);
            if (strSubstring.charAt(0) == '\"') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
            Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(strReplaceAll);
            if (matcher2.find()) {
                String strSubstring2 = matcher2.group().substring(5);
                if (strSubstring2.charAt(0) == '\"') {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                }
                for (String str2 : strSubstring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                    sc(str2, strSubstring);
                }
            }
        }
    }

    private String We(String str) {
        String str2;
        String strExN = ExN(str);
        if (strExN.isEmpty()) {
            return null;
        }
        sc();
        Map<String, String> map = this.f27028sc;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.f27028sc.get(strExN);
            if (str2 == null) {
                strExN = ExN(strExN);
            }
            if (str2 != null) {
                break;
            }
        } while (!strExN.isEmpty());
        return str2;
    }

    private static String pFF(String str) {
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        String strTrim = str.substring(0, iIndexOf).trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = strTrim.toLowerCase(locale);
        if (!zY(lowerCase)) {
            return null;
        }
        int i11 = iIndexOf + 1;
        String lowerCase2 = (iIndexOf2 < 0 ? str.substring(i11) : str.substring(i11, iIndexOf2)).trim().toLowerCase(locale);
        if (!zY(lowerCase2)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb2.append(lowerCase);
        sb2.append('/');
        sb2.append(lowerCase2);
        return sb2.toString();
    }

    public static SR sc(Context context) {
        if (zY == null) {
            synchronized (SR.class) {
                try {
                    if (zY == null) {
                        zY = new SR(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return zY;
    }

    public static String sc(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return sc(context).sc(str);
    }

    private void sc() {
        if (this.We == null || this.pFF) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.pFF) {
                    List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.component.utils.SR.1
                        @Override // java.security.PrivilegedAction
                        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                        public List<String> run() {
                            BufferedReader bufferedReader;
                            InputStream inputStream = null;
                            try {
                                ArrayList arrayList = new ArrayList();
                                InputStream inputStreamOpen = SR.this.We.getAssets().open("tt_mime_type.pro");
                                try {
                                    bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                                    while (true) {
                                        try {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            if (!TextUtils.isEmpty(line)) {
                                                arrayList.add(line);
                                            }
                                        } catch (Throwable unused) {
                                            inputStream = inputStreamOpen;
                                            try {
                                                return Collections.emptyList();
                                            } finally {
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                                if (bufferedReader != null) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (Throwable unused3) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (inputStreamOpen != null) {
                                        try {
                                            inputStreamOpen.close();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused5) {
                                    }
                                    return arrayList;
                                } catch (Throwable unused6) {
                                    bufferedReader = null;
                                }
                            } catch (Throwable unused7) {
                                bufferedReader = null;
                            }
                        }
                    });
                    this.f27028sc = new HashMap(list.size());
                    String strSubstring = "";
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = strSubstring + ((String) it.next());
                        if (str.endsWith("\\")) {
                            strSubstring = str.substring(0, str.length() - 1);
                        } else {
                            TRI(str);
                            strSubstring = "";
                        }
                    }
                    if (!strSubstring.isEmpty()) {
                        TRI(strSubstring);
                    }
                    this.pFF = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void sc(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.f27028sc.containsKey(str)) {
            return;
        }
        this.f27028sc.put(str, str2);
    }

    private static boolean sc(char c11) {
        return c11 > ' ' && c11 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c11) < 0;
    }

    private static boolean zY(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (!sc(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public final String sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strWe = We(str);
        if (TextUtils.isEmpty(strWe)) {
            return null;
        }
        return pFF(strWe);
    }
}
