package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class rg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference f22102a = new AtomicReference();

    public static String a() {
        return "iabtechlab-Applovin";
    }

    /* JADX WARN: Code duplicated, block: B:53:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(com.applovin.impl.sdk.j jVar) {
        InputStream inputStreamA;
        String str = (String) f22102a.get();
        if (StringUtils.isValidString(str)) {
            return str;
        }
        URL urlB = b();
        BufferedReader bufferedReader = null;
        if (urlB == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (((Boolean) jVar.a(sj.F)).booleanValue()) {
            try {
                InputStream inputStreamA2 = jVar.B().a(urlB.toString(), (List) null, false, new u2());
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamA2));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                            sb2.append("\n");
                        } catch (Throwable th2) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                        if (inputStreamA2 != null) {
                            try {
                                inputStreamA2.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        }
                        throw th;
                    }
                    bufferedReader2.close();
                    if (inputStreamA2 != null) {
                        inputStreamA2.close();
                    }
                } catch (Throwable th5) {
                    if (inputStreamA2 != null) {
                        inputStreamA2.close();
                    }
                    throw th5;
                }
            } catch (Throwable th6) {
                jVar.J().a("OpenMeasurementTestParameters", th6);
                jVar.E().a("OpenMeasurementTestParameters", "getTestValidationJavaScriptContent", th6);
            }
        } else {
            try {
                inputStreamA = jVar.B().a(urlB.toString(), (List) null, false, new u2());
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStreamA));
                    while (true) {
                        try {
                            String line2 = bufferedReader3.readLine();
                            if (line2 == null) {
                                break;
                            }
                            sb2.append(line2);
                            sb2.append("\n");
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader3;
                            yp.a(inputStreamA, jVar);
                            yp.a(bufferedReader, jVar);
                        }
                    }
                    yp.a(inputStreamA, jVar);
                    yp.a(bufferedReader3, jVar);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                inputStreamA = null;
            }
        }
        String string = sb2.toString();
        f22102a.set(string);
        return string;
    }

    public static URL b() {
        try {
            return new URL("https://compliance.iabtechnologylab.com/compliance-js/omid-validation-verification-script-v1-APPLOVIN-01102024.js");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        return "iabtechlab.com-omid";
    }
}
