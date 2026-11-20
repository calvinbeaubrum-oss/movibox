package jk;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f68034a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68036c;

    public b(int i11, int i12) {
        this.f68035b = i11;
        this.f68036c = i12;
    }

    public static String c(String str, int i11) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i11 ? strTrim.substring(0, i11) : strTrim;
    }

    @NonNull
    public synchronized Map<String, String> a() {
        return Collections.unmodifiableMap(new HashMap(this.f68034a));
    }

    public final String b(String str) {
        if (str != null) {
            return c(str, this.f68036c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public synchronized boolean d(String str, String str2) {
        String strB = b(str);
        if (this.f68034a.size() >= this.f68035b && !this.f68034a.containsKey(strB)) {
            gk.f.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f68035b);
            return false;
        }
        String strC = c(str2, this.f68036c);
        if (CommonUtils.A(this.f68034a.get(strB), strC)) {
            return false;
        }
        Map<String, String> map = this.f68034a;
        if (str2 == null) {
            strC = "";
        }
        map.put(strB, strC);
        return true;
    }

    public synchronized void e(Map<String, String> map) {
        try {
            int i11 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String strB = b(entry.getKey());
                if (this.f68034a.size() < this.f68035b || this.f68034a.containsKey(strB)) {
                    String value = entry.getValue();
                    this.f68034a.put(strB, value == null ? "" : c(value, this.f68036c));
                } else {
                    i11++;
                }
            }
            if (i11 > 0) {
                gk.f.f().k("Ignored " + i11 + " entries when adding custom keys. Maximum allowable: " + this.f68035b);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
