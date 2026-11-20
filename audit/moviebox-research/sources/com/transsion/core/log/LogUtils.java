package com.transsion.core.log;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ws.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class LogUtils {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f51788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f51789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f51790d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f51787a = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f51791e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f51792f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f51793g = "TAG";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f51794h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f51795i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f51796j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f51797k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f51798l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f51799m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f51800n = System.getProperty("file.separator");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f51801o = System.getProperty("line.separator");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Format f51802p = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());

    public static String a(String str) {
        if (!f51797k) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f51801o)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(f51801o);
        }
        return sb2.toString();
    }

    public static boolean b(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean c(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void d(String str, Object... objArr) throws JSONException, TransformerException, IOException {
        j(3, str, objArr);
    }

    public static String e(String str) throws JSONException {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return str;
    }

    public static String f(String str) throws TransformerException {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f51801o);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static void g(Object obj) throws JSONException, TransformerException, IOException {
        j(4, f51793g, obj);
    }

    public static void h(String str, Object... objArr) throws JSONException, TransformerException, IOException {
        j(4, str, objArr);
    }

    public static boolean i(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static void j(int i11, String str, Object... objArr) throws JSONException, TransformerException, IOException {
        String strSubstring = str.length() > 23 ? str.substring(0, 23) : str;
        if (!a.d() && !Log.isLoggable(strSubstring, 3)) {
            if (!f51791e) {
                return;
            }
            if (!f51792f && !f51796j) {
                return;
            }
        }
        int i12 = i11 & 15;
        int i13 = i11 & 240;
        if (i12 >= f51798l || i12 >= f51799m) {
            String[] strArrO = o(str);
            String strN = n(i13, objArr);
            if (f51792f && i12 >= f51798l) {
                l(i12, strArrO[0], strArrO[1], strN);
            }
            if ((f51796j || i13 == 16) && i12 >= f51799m) {
                m(i12, strArrO[0], strArrO[2] + strN);
            }
        }
    }

    public static void k(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    public static void l(int i11, String str, String str2, String str3) {
        if (f51795i) {
            k(i11, str, "\n" + str2);
        } else {
            k(i11, str, " \n");
        }
        if (f51797k) {
            k(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = a(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            k(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String strSubstring = str3.substring(i13, i15);
                if (f51797k) {
                    strSubstring = "| " + strSubstring;
                }
                k(i11, str, strSubstring);
                i14++;
                i13 = i15;
            }
            String strSubstring2 = str3.substring(i13, length);
            if (f51797k) {
                strSubstring2 = "| " + strSubstring2;
            }
            k(i11, str, strSubstring2);
        } else {
            k(i11, str, str3);
        }
        if (f51797k) {
            k(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    public static void m(int i11, final String str, String str2) throws IOException {
        String str3 = f51802p.format(new Date(System.currentTimeMillis()));
        String strSubstring = str3.substring(0, 5);
        String strSubstring2 = str3.substring(6);
        StringBuilder sb2 = new StringBuilder();
        String str4 = f51790d;
        if (str4 == null) {
            str4 = f51789c;
        }
        sb2.append(str4);
        sb2.append(strSubstring);
        sb2.append(".txt");
        final String string = sb2.toString();
        if (!c(string)) {
            Log.e(str, "log to " + string + " failed!");
            return;
        }
        final String str5 = strSubstring2 + f51787a[i11 - 2] + "/" + str + str2 + f51801o;
        if (f51788b == null) {
            f51788b = Executors.newSingleThreadExecutor();
        }
        f51788b.execute(new Runnable() { // from class: com.transsion.core.log.LogUtils.1
            /* JADX WARN: Code duplicated, block: B:30:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                BufferedWriter bufferedWriter;
                IOException e11;
                BufferedWriter bufferedWriter2 = null;
                try {
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(string, true));
                            try {
                                bufferedWriter.write(str5);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("log to ");
                                sb3.append(string);
                                sb3.append(" success!");
                                bufferedWriter.close();
                            } catch (IOException e12) {
                                e11 = e12;
                                e11.printStackTrace();
                                Log.e(str, "log to " + string + " failed!");
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e14) {
                        bufferedWriter = null;
                        e11 = e14;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                        throw th;
                    }
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
        });
    }

    public static String n(int i11, Object... objArr) throws JSONException, TransformerException {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String string = obj != null ? obj.toString() : "null";
            if (i11 == 32) {
                return e(string);
            }
            return i11 == 48 ? f(string) : string;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            Object obj2 = objArr[i12];
            sb2.append("args");
            sb2.append("[");
            sb2.append(i12);
            sb2.append("]");
            sb2.append(" = ");
            sb2.append(obj2 == null ? "null" : obj2.toString());
            sb2.append(f51801o);
        }
        return sb2.toString();
    }

    public static String[] o(String str) {
        if (f51794h || f51795i) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            String className = stackTraceElement.getClassName();
            String[] strArrSplit = className.split("\\.");
            if (strArrSplit.length > 0) {
                className = strArrSplit[strArrSplit.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (f51794h && i(str)) {
                str = className;
            }
            if (f51795i) {
                String string = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, string + f51801o, " [" + string + "]: "};
            }
        } else {
            str = f51793g;
        }
        return new String[]{str, "", ": "};
    }
}
