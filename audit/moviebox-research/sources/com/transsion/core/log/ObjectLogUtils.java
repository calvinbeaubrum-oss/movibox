package com.transsion.core.log;

import android.os.Environment;
import android.util.Log;
import com.transsion.core.utils.b;
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
    public static final char[] f51803o = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f51804p = System.getProperty("file.separator");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f51805q = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f51809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f51810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f51811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f51812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f51813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Format f51814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f51815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f51816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f51817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f51818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f51819n;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f51820a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f51821b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f51822c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f51823d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f51824e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f51825f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f51826g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f51827h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f51828i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f51829j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f51830k;

        public ObjectLogUtils m() {
            return new ObjectLogUtils(this);
        }

        public a n(boolean z11) {
            this.f51826g = z11;
            return this;
        }

        public a o(boolean z11) {
            this.f51821b = z11;
            return this;
        }

        public a p(String str) {
            if (ObjectLogUtils.p(str)) {
                this.f51822c = "";
                this.f51823d = true;
            } else {
                this.f51822c = str;
                this.f51823d = false;
            }
            return this;
        }

        public a q(boolean z11) {
            this.f51824e = z11;
            return this;
        }

        public a r(boolean z11) {
            this.f51820a = z11;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("switch: ");
            sb2.append(this.f51820a);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("console: ");
            sb2.append(this.f51821b);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("tag: ");
            sb2.append(this.f51823d ? "null" : this.f51822c);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("head: ");
            sb2.append(this.f51824e);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("file: ");
            sb2.append(this.f51825f);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("dir: ");
            String str = this.f51830k;
            if (str == null) {
                str = this.f51829j;
            }
            sb2.append(str);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("border: ");
            sb2.append(this.f51826g);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("consoleFilter: ");
            sb2.append(ObjectLogUtils.f51803o[this.f51827h - 2]);
            sb2.append(ObjectLogUtils.f51805q);
            sb2.append("fileFilter: ");
            sb2.append(ObjectLogUtils.f51803o[this.f51828i - 2]);
            return sb2.toString();
        }
    }

    public ObjectLogUtils(a aVar) {
        this.f51806a = 16;
        this.f51807b = 32;
        this.f51808c = 48;
        this.f51810e = "|---------------------------------------------------------------------------------------------------";
        this.f51811f = "| ";
        this.f51812g = "|---------------------------------------------------------------------------------------------------";
        this.f51813h = 4000;
        this.f51814i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f51815j = "Log with null object.";
        this.f51816k = "null";
        this.f51817l = "args";
        new a();
        this.f51819n = 0;
        this.f51818m = aVar;
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

    public static boolean p(String str) {
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

    public static void s(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    public void A(String str, Object... objArr) {
        r(5, str, objArr);
    }

    public final String d(String str) {
        if (!this.f51818m.f51826g) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f51805q)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(f51805q);
        }
        return sb2.toString();
    }

    public void g(Object obj) {
        r(3, this.f51818m.f51822c, obj);
    }

    public void h(String str, Object... objArr) {
        r(3, str, objArr);
    }

    public void i(Object obj) {
        r(6, this.f51818m.f51822c, obj);
    }

    public void j(String str, Object... objArr) {
        r(6, str, objArr);
    }

    public final String l(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerNewTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f51805q);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public a m() {
        return this.f51818m;
    }

    public void n(Object obj) {
        r(4, this.f51818m.f51822c, obj);
    }

    public void o(String str, Object... objArr) {
        r(4, str, objArr);
    }

    public void q(String str, String str2) {
        r(35, str, str2);
    }

    public final void r(int i11, String str, Object... objArr) {
        if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
            if (!this.f51818m.f51820a) {
                return;
            }
            if (!this.f51818m.f51821b && !this.f51818m.f51825f) {
                return;
            }
        }
        int i12 = i11 & 15;
        int i13 = i11 & 240;
        if (i12 >= this.f51818m.f51827h || i12 >= this.f51818m.f51828i) {
            String[] strArrW = w(str);
            String strV = v(i13, objArr);
            if (this.f51818m.f51821b && i12 >= this.f51818m.f51827h) {
                t(i12, strArrW[0], strArrW[1], strV);
            }
            if ((this.f51818m.f51825f || i13 == 16) && i12 >= this.f51818m.f51828i) {
                u(i12, strArrW[0], strArrW[2] + strV);
            }
        }
    }

    public final void t(int i11, String str, String str2, String str3) {
        if (this.f51818m.f51824e) {
            s(i11, str, "\n" + str2);
        } else {
            s(i11, str, " \n");
        }
        if (this.f51818m.f51826g) {
            s(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = d(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            s(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String strSubstring = str3.substring(i13, i15);
                if (this.f51818m.f51826g) {
                    strSubstring = "| " + strSubstring;
                }
                s(i11, str, strSubstring);
                i14++;
                i13 = i15;
            }
            String strSubstring2 = str3.substring(i13, length);
            if (this.f51818m.f51826g) {
                strSubstring2 = "| " + strSubstring2;
            }
            s(i11, str, strSubstring2);
        } else {
            s(i11, str, str3);
        }
        if (this.f51818m.f51826g) {
            s(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    public final void u(int i11, final String str, String str2) {
        String str3 = this.f51814i.format(new Date(System.currentTimeMillis()));
        String strSubstring = str3.substring(0, 5);
        String strSubstring2 = str3.substring(6);
        if (this.f51818m.f51829j == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || b.a(ws.a.a()) == null) {
                a aVar = this.f51818m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ws.a.a().getCacheDir());
                String str4 = f51804p;
                sb2.append(str4);
                sb2.append("log");
                sb2.append(str4);
                aVar.f51829j = sb2.toString();
            } else {
                a aVar2 = this.f51818m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b.a(ws.a.a()));
                String str5 = f51804p;
                sb3.append(str5);
                sb3.append("log");
                sb3.append(str5);
                aVar2.f51829j = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f51818m.f51830k == null ? this.f51818m.f51829j : this.f51818m.f51830k);
        sb4.append(strSubstring);
        sb4.append(".txt");
        final String string = sb4.toString();
        if (!f(string)) {
            Log.e(str, "log to " + string + " failed!");
            return;
        }
        final String str6 = strSubstring2 + f51803o[i11 - 2] + "/" + str + str2 + f51805q;
        if (this.f51809d == null) {
            this.f51809d = Executors.newSingleThreadExecutor();
        }
        this.f51809d.execute(new Runnable() { // from class: com.transsion.core.log.ObjectLogUtils.1
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

    public final String v(int i11, Object... objArr) {
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
            sb2.append(f51805q);
        }
        return sb2.toString();
    }

    public final String[] w(String str) {
        if (this.f51818m.f51823d || this.f51818m.f51824e) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f51819n + 5];
            String className = stackTraceElement.getClassName();
            String[] strArrSplit = className.split("\\.");
            if (strArrSplit.length > 0) {
                className = strArrSplit[strArrSplit.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.f51818m.f51823d && p(str)) {
                str = className;
            }
            if (this.f51818m.f51824e) {
                String string = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, string + f51805q, " [" + string + "]: "};
            }
        } else {
            str = this.f51818m.f51822c;
        }
        return new String[]{str, "", ": "};
    }

    public void x(int i11) {
        this.f51819n = i11;
    }

    public void y(String str, Object... objArr) {
        r(2, str, objArr);
    }

    public void z(Object obj) {
        r(5, this.f51818m.f51822c, obj);
    }
}
