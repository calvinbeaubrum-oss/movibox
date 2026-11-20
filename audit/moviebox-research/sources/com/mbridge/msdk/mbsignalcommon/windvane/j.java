package com.mbridge.msdk.mbsignalcommon.windvane;

import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f45806a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f45807b = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f45808c = Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f45809d = Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f45810e = Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, String> f45811f = new HashMap();

    static {
        for (e eVar : e.values()) {
            f45811f.put(eVar.a(), eVar.b());
        }
    }

    public static boolean a(String str) {
        for (String str2 : f45806a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Pattern b(String str) {
        if ("wv_hybrid:".equals(str)) {
            return f45810e;
        }
        if ("mraid:".equals(str)) {
            return f45808c;
        }
        if ("ssp:".equals(str)) {
            return f45809d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return f45810e;
        }
        return null;
    }

    public static String c(String str) {
        char[] cArr = {'\'', '\\'};
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt <= 255) {
                int i12 = 0;
                while (true) {
                    if (i12 >= 2) {
                        stringBuffer.append(cCharAt);
                        break;
                    }
                    if (cArr[i12] == cCharAt) {
                        stringBuffer.append("\\" + cCharAt);
                        break;
                    }
                    i12++;
                }
            } else {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(cCharAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(cCharAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            }
        }
        return new String(stringBuffer);
    }

    public static boolean d(String str) {
        return e(str).startsWith("image");
    }

    public static String e(String str) {
        String str2 = f45811f.get(f(str));
        return str2 == null ? "" : str2;
    }

    private static String f(String str) {
        String path;
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (iLastIndexOf = path.lastIndexOf(InstructionFileId.DOT)) == -1) ? "" : path.substring(iLastIndexOf + 1);
    }
}
