package jk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f68040b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nk.f f68041a;

    /* JADX INFO: compiled from: source.java */
    public class a extends JSONObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f68042a;

        public a(String str) throws JSONException {
            this.f68042a = str;
            put("userId", str);
        }
    }

    public d(nk.f fVar) {
        this.f68041a = fVar;
    }

    public static Map<String, String> d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, k(jSONObject, next));
        }
        return map;
    }

    public static String f(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    public static void i(File file) {
        if (file.exists() && file.delete()) {
            gk.f.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    public static String j(String str) throws JSONException {
        return new a(str).toString();
    }

    public static String k(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    @NonNull
    public File a(String str) {
        return this.f68041a.o(str, "internal-keys");
    }

    @NonNull
    public File b(String str) {
        return this.f68041a.o(str, "keys");
    }

    @NonNull
    public File c(String str) {
        return this.f68041a.o(str, "user-data");
    }

    @Nullable
    public final String e(String str) throws JSONException {
        return k(new JSONObject(str), "userId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    public Map<String, String> g(String str, boolean z11) throws Throwable {
        FileInputStream fileInputStream;
        Exception e11;
        File fileA = z11 ? a(str) : b(str);
        if (fileA.exists()) {
            ?? length = fileA.length();
            if (length != 0) {
                ?? r11 = 0;
                try {
                    try {
                        fileInputStream = new FileInputStream(fileA);
                        try {
                            Map<String, String> mapD = d(CommonUtils.C(fileInputStream));
                            CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                            return mapD;
                        } catch (Exception e12) {
                            e11 = e12;
                            gk.f.f().l("Error deserializing user metadata.", e11);
                            i(fileA);
                            CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                            return Collections.emptyMap();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r11 = length;
                        CommonUtils.e(r11, "Failed to close user metadata file.");
                        throw th;
                    }
                } catch (Exception e13) {
                    fileInputStream = null;
                    e11 = e13;
                } catch (Throwable th3) {
                    th = th3;
                    CommonUtils.e(r11, "Failed to close user metadata file.");
                    throw th;
                }
            }
        }
        i(fileA);
        return Collections.emptyMap();
    }

    @Nullable
    public String h(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileC = c(str);
        FileInputStream fileInputStream2 = null;
        if (!fileC.exists() || fileC.length() == 0) {
            gk.f.f().b("No userId set for session " + str);
            i(fileC);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileC);
            try {
                try {
                    String strE = e(CommonUtils.C(fileInputStream));
                    gk.f.f().b("Loaded userId " + strE + " for session " + str);
                    CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                    return strE;
                } catch (Exception e11) {
                    e = e11;
                    gk.f.f().l("Error deserializing user metadata.", e);
                    i(fileC);
                    CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void l(String str, Map<String, String> map, boolean z11) throws Throwable {
        File fileA = z11 ? a(str) : b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strF = f(map);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), f68040b));
                try {
                    bufferedWriter2.write(strF);
                    bufferedWriter2.flush();
                    CommonUtils.e(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e11) {
                    e = e11;
                    bufferedWriter = bufferedWriter2;
                    gk.f.f().l("Error serializing key/value metadata.", e);
                    i(fileA);
                    CommonUtils.e(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.e(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public void m(String str, String str2) throws Throwable {
        File fileC = c(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strJ = j(str2);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), f68040b));
                try {
                    bufferedWriter2.write(strJ);
                    bufferedWriter2.flush();
                    CommonUtils.e(bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e11) {
                    e = e11;
                    bufferedWriter = bufferedWriter2;
                    gk.f.f().l("Error serializing user metadata.", e);
                    CommonUtils.e(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.e(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
