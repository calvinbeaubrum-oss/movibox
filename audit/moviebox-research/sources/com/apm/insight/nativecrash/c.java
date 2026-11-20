package com.apm.insight.nativecrash;

import com.apm.insight.l.j;
import com.apm.insight.runtime.k;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f16996i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f16997j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f16998k = Pattern.compile("^Abort message: (.*)$");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f16999l = Pattern.compile("^Crash message: (.*)$");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f17000m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f17007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f17008h = new HashMap();

    public c(File file) {
        c(j.b(file));
    }

    private void c(File file) {
        if (!file.exists() || file.length() == 0) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i11 = 0;
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null || i11 >= 64) {
                        break;
                    }
                    if (this.f17001a == null && line.startsWith("pid: ")) {
                        Matcher matcher = f16996i.matcher(line);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            this.f17001a = matcher.group(1);
                            this.f17002b = matcher.group(2);
                            this.f17004d = matcher.group(3);
                            this.f17003c = matcher.group(4);
                        }
                    } else if (this.f17005e == null && line.startsWith("signal ")) {
                        Matcher matcher2 = f16997j.matcher(line);
                        if (matcher2.find() && matcher2.groupCount() == 3) {
                            String strReplace = matcher2.group(1).replace(" ", "");
                            String strReplace2 = matcher2.group(2).replace(" ", "");
                            int iIndexOf = strReplace2.indexOf("frompid");
                            if (iIndexOf > 0) {
                                strReplace2 = strReplace2.substring(0, iIndexOf) + ")";
                            }
                            this.f17005e = "Signal " + strReplace + ", Code " + strReplace2 + "\n";
                        }
                    } else if (this.f17006f == null && line.startsWith("Abort ")) {
                        Matcher matcher3 = f16998k.matcher(line);
                        if (matcher3.find() && matcher3.groupCount() == 1) {
                            this.f17006f = "abort message: " + matcher3.group(1) + "\n";
                        }
                    } else if (this.f17006f == null && line.startsWith("Crash ")) {
                        Matcher matcher4 = f16999l.matcher(line);
                        if (matcher4.find() && matcher4.groupCount() == 1) {
                            this.f17006f = "crash message: " + matcher4.group(1) + "\n";
                        }
                    } else if (this.f17007g == null && line.startsWith("backtrace:")) {
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null || !line2.startsWith("    #")) {
                                break;
                            }
                            sb2.append(line2.substring(4));
                            sb2.append('\n');
                        }
                        i11++;
                        this.f17007g = sb2.toString();
                    } else if (this.f17008h.isEmpty() && line.startsWith("build id:")) {
                        while (true) {
                            String line3 = bufferedReader2.readLine();
                            if (line3 == null || !line3.contains("BuildId:")) {
                                break;
                            }
                            Matcher matcher5 = f17000m.matcher(line3);
                            if (matcher5.find()) {
                                String strGroup = matcher5.group(1);
                                String strGroup2 = matcher5.group(2);
                                String strGroup3 = matcher5.group(3);
                                if (strGroup.equals("data")) {
                                    this.f17008h.put(strGroup2, strGroup3);
                                }
                            }
                        }
                    }
                    i11++;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    try {
                        com.apm.insight.c.a();
                        k.a(th, "NPTH_CATCH");
                        return;
                    } finally {
                        com.apm.insight.a.a((Closeable) bufferedReader);
                    }
                }
            }
            com.apm.insight.a.a((Closeable) bufferedReader2);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final String a() {
        return this.f17007g;
    }

    public final void a(File file) {
        File fileB = j.b(file);
        if (fileB.exists()) {
            fileB.renameTo(new File(fileB.getAbsoluteFile() + ".old"));
        }
        NativeImpl.a(file);
        c(j.b(file));
    }

    public final Map<String, String> b() {
        return this.f17008h;
    }

    public final void b(File file) {
        c(j.b(file));
    }

    public final String c() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f17005e;
        if (str != null) {
            sb2.append(str);
        }
        String str2 = this.f17006f;
        if (str2 != null) {
            sb2.append(str2);
        }
        String str3 = this.f17007g;
        if (str3 != null) {
            sb2.append(str3);
        }
        return sb2.toString();
    }
}
