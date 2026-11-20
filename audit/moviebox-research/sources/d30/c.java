package d30;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f62925a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f62926b = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder(8192);
        }
    }

    public static void a(StringBuilder sb2, String str, boolean z11) {
        int length = str.length();
        int iCharCount = 0;
        boolean z12 = false;
        boolean z13 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (d(iCodePointAt)) {
                if ((!z11 || z12) && !z13) {
                    sb2.append(' ');
                    z13 = true;
                }
            } else if (!f(iCodePointAt)) {
                sb2.appendCodePoint(iCodePointAt);
                z12 = true;
                z13 = false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    public static boolean b(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean d(int i11) {
        return i11 == 32 || i11 == 9 || i11 == 10 || i11 == 12 || i11 == 13 || i11 == 160;
    }

    public static boolean e(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (!h(str.codePointAt(i11))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean f(int i11) {
        return Character.getType(i11) == 16 && (i11 == 8203 || i11 == 8204 || i11 == 8205 || i11 == 173);
    }

    public static boolean g(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isDigit(str.codePointAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(int i11) {
        return i11 == 32 || i11 == 9 || i11 == 10 || i11 == 12 || i11 == 13;
    }

    public static String i(Collection collection, String str) {
        return j(collection.iterator(), str);
    }

    public static String j(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String string = it.next().toString();
        if (!it.hasNext()) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(string);
        while (it.hasNext()) {
            sb2.append(str);
            sb2.append(it.next());
        }
        return sb2.toString();
    }

    public static String k(String str) {
        StringBuilder sbO = o();
        a(sbO, str, false);
        return sbO.toString();
    }

    public static String l(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        String[] strArr = f62925a;
        if (i11 < strArr.length) {
            return strArr[i11];
        }
        char[] cArr = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = ' ';
        }
        return String.valueOf(cArr);
    }

    public static String m(String str, String str2) {
        try {
            try {
                return n(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return new URL(str2).toExternalForm();
            }
        } catch (MalformedURLException unused2) {
            return "";
        }
    }

    public static URL n(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            url = new URL(url.getProtocol(), url.getHost(), url.getPort(), "/" + url.getFile());
        }
        return new URL(url, str);
    }

    public static StringBuilder o() {
        ThreadLocal<StringBuilder> threadLocal = f62926b;
        StringBuilder sb2 = threadLocal.get();
        if (sb2.length() <= 8192) {
            sb2.delete(0, sb2.length());
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder(8192);
        threadLocal.set(sb3);
        return sb3;
    }
}
