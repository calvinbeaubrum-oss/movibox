package com.transsion.infra.gateway.core.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectLogUtils {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final char[] f52888o = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f52889p = System.getProperty("file.separator");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f52890q = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f52891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f52892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f52893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f52894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f52895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f52896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f52897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f52898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Format f52899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f52900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f52901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f52902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f52903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f52904n;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f52905a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f52906b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f52907c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f52908d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f52909e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f52910f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f52911g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f52912h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f52913i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f52914j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f52915k;

        public ObjectLogUtils m() {
            return new ObjectLogUtils(this);
        }

        public a n(boolean z11) {
            this.f52911g = z11;
            return this;
        }

        public a o(String str) {
            if (ObjectLogUtils.q(str)) {
                this.f52907c = "";
                this.f52908d = true;
            } else {
                this.f52907c = str;
                this.f52908d = false;
            }
            return this;
        }

        public a p(boolean z11) {
            this.f52909e = z11;
            return this;
        }

        public a q(boolean z11) {
            this.f52905a = z11;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("switch: ");
            sb2.append(this.f52905a);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("console: ");
            sb2.append(this.f52906b);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("tag: ");
            sb2.append(this.f52908d ? "null" : this.f52907c);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("head: ");
            sb2.append(this.f52909e);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("file: ");
            sb2.append(this.f52910f);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("dir: ");
            String str = this.f52915k;
            if (str == null) {
                str = this.f52914j;
            }
            sb2.append(str);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("border: ");
            sb2.append(this.f52911g);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("consoleFilter: ");
            sb2.append(ObjectLogUtils.f52888o[this.f52912h - 2]);
            sb2.append(ObjectLogUtils.f52890q);
            sb2.append("fileFilter: ");
            sb2.append(ObjectLogUtils.f52888o[this.f52913i - 2]);
            return sb2.toString();
        }
    }

    public ObjectLogUtils(a aVar) {
        this.f52891a = 16;
        this.f52892b = 32;
        this.f52893c = 48;
        this.f52895e = "|---------------------------------------------------------------------------------------------------";
        this.f52896f = "| ";
        this.f52897g = "|---------------------------------------------------------------------------------------------------";
        this.f52898h = 4000;
        this.f52899i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f52900j = "Log with null object.";
        this.f52901k = "null";
        this.f52902l = "args";
        new a();
        this.f52904n = 0;
        this.f52903m = aVar;
    }

    public static boolean e(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean f(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!e(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static String k(String str) {
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

    public static File n(Context context) {
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(new Environment())) {
                return null;
            }
            try {
                return context.getExternalCacheDir();
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean q(String str) {
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

    public static void t(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    public void A(String str, Object... objArr) {
        s(5, str, objArr);
    }

    public final String d(String str) {
        if (!this.f52903m.f52911g) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f52890q)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(f52890q);
        }
        return sb2.toString();
    }

    public void g(Object obj) {
        s(3, this.f52903m.f52907c, obj);
    }

    public void h(String str, Object... objArr) {
        s(3, str, objArr);
    }

    public void i(Object obj) {
        s(6, this.f52903m.f52907c, obj);
    }

    public void j(String str, Object... objArr) {
        s(6, str, objArr);
    }

    public final String l(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f52890q);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public a m() {
        return this.f52903m;
    }

    public void o(Object obj) {
        s(4, this.f52903m.f52907c, obj);
    }

    public void p(String str, Object... objArr) {
        s(4, str, objArr);
    }

    public void r(String str, String str2) {
        s(35, str, str2);
    }

    public final void s(int i11, String str, Object... objArr) {
        if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
            if (!this.f52903m.f52905a) {
                return;
            }
            if (!this.f52903m.f52906b && !this.f52903m.f52910f) {
                return;
            }
        }
        int i12 = i11 & 15;
        int i13 = i11 & 240;
        if (i12 >= this.f52903m.f52912h || i12 >= this.f52903m.f52913i) {
            String[] strArrX = x(str);
            String strW = w(i13, objArr);
            if (this.f52903m.f52906b && i12 >= this.f52903m.f52912h) {
                u(i12, strArrX[0], strArrX[1], strW);
            }
            if ((this.f52903m.f52910f || i13 == 16) && i12 >= this.f52903m.f52913i) {
                v(i12, strArrX[0], strArrX[2] + strW);
            }
        }
    }

    public final void u(int i11, String str, String str2, String str3) {
        if (this.f52903m.f52909e) {
            t(i11, str, "\n" + str2);
        } else {
            t(i11, str, " \n");
        }
        if (this.f52903m.f52911g) {
            t(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = d(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            t(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String strSubstring = str3.substring(i13, i15);
                if (this.f52903m.f52911g) {
                    strSubstring = "| " + strSubstring;
                }
                t(i11, str, strSubstring);
                i14++;
                i13 = i15;
            }
            String strSubstring2 = str3.substring(i13, length);
            if (this.f52903m.f52911g) {
                strSubstring2 = "| " + strSubstring2;
            }
            t(i11, str, strSubstring2);
        } else {
            t(i11, str, str3);
        }
        if (this.f52903m.f52911g) {
            t(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    public final void v(int i11, final String str, String str2) {
        String str3 = this.f52899i.format(new Date(System.currentTimeMillis()));
        String strSubstring = str3.substring(0, 5);
        String strSubstring2 = str3.substring(6);
        if (this.f52903m.f52914j == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || n(com.transsion.infra.gateway.core.utils.a.a()) == null) {
                a aVar = this.f52903m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.transsion.infra.gateway.core.utils.a.a().getCacheDir());
                String str4 = f52889p;
                sb2.append(str4);
                sb2.append("log");
                sb2.append(str4);
                aVar.f52914j = sb2.toString();
            } else {
                a aVar2 = this.f52903m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(n(com.transsion.infra.gateway.core.utils.a.a()));
                String str5 = f52889p;
                sb3.append(str5);
                sb3.append("log");
                sb3.append(str5);
                aVar2.f52914j = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f52903m.f52915k == null ? this.f52903m.f52914j : this.f52903m.f52915k);
        sb4.append(strSubstring);
        sb4.append(".txt");
        final String string = sb4.toString();
        if (!f(string)) {
            Log.e(str, "log to " + string + " failed!");
            return;
        }
        final String str6 = strSubstring2 + f52888o[i11 - 2] + "/" + str + str2 + f52890q;
        if (this.f52894d == null) {
            this.f52894d = Executors.newSingleThreadExecutor();
        }
        this.f52894d.execute(new Runnable() { // from class: com.transsion.infra.gateway.core.utils.ObjectLogUtils.1
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
                                bufferedWriter.write(str6);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("log to ");
                                sb5.append(string);
                                sb5.append(" success!");
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

    public final String w(int i11, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String string = obj != null ? obj.toString() : "null";
            if (i11 == 32) {
                return k(string);
            }
            return i11 == 48 ? l(string) : string;
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
            sb2.append(f52890q);
        }
        return sb2.toString();
    }

    public final String[] x(String str) {
        if (this.f52903m.f52908d || this.f52903m.f52909e) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f52904n + 5];
            String className = stackTraceElement.getClassName();
            String[] strArrSplit = className.split("\\.");
            if (strArrSplit.length > 0) {
                className = strArrSplit[strArrSplit.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.f52903m.f52908d && q(str)) {
                str = className;
            }
            if (this.f52903m.f52909e) {
                String string = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, string + f52890q, " [" + string + "]: "};
            }
        } else {
            str = this.f52903m.f52907c;
        }
        return new String[]{str, "", ": "};
    }

    public void y(int i11) {
        this.f52904n = i11;
    }

    public void z(String str, Object... objArr) {
        s(2, str, objArr);
    }
}
