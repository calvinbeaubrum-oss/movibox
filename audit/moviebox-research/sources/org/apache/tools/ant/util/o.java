package org.apache.tools.ant.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f72991a = d.k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x20.c f72992b = new x20.b(new x20.a());

    public static int a(t tVar, t tVar2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        int i11;
        int i12;
        int i13;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(tVar.c());
            try {
                bufferedInputStream = new BufferedInputStream(tVar2.c());
                do {
                    try {
                        i11 = bufferedInputStream3.read();
                        if (i11 == -1) {
                            i12 = bufferedInputStream.read() == -1 ? 0 : -1;
                            d.b(bufferedInputStream3);
                            d.b(bufferedInputStream);
                            return i12;
                        }
                        i13 = bufferedInputStream.read();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream3;
                        d.b(bufferedInputStream2);
                        d.b(bufferedInputStream);
                        throw th;
                    }
                } while (i11 == i13);
                i12 = i11 > i13 ? 1 : -1;
                d.b(bufferedInputStream3);
                d.b(bufferedInputStream);
                return i12;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public static int b(t tVar, t tVar2, boolean z11) throws IOException {
        if (tVar.equals(tVar2)) {
            return 0;
        }
        boolean zM = tVar.m();
        boolean zM2 = tVar2.m();
        if (!zM && !zM2) {
            return 0;
        }
        if (zM != zM2) {
            return zM ? 1 : -1;
        }
        boolean zL = tVar.l();
        boolean zL2 = tVar2.l();
        if (zL && zL2) {
            return 0;
        }
        if (zL || zL2) {
            return zL ? -1 : 1;
        }
        return z11 ? c(tVar, tVar2) : a(tVar, tVar2);
    }

    public static int c(t tVar, t tVar2) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(tVar.c()));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(tVar2.c()));
                try {
                    for (String line = bufferedReader3.readLine(); line != null; line = bufferedReader3.readLine()) {
                        String line2 = bufferedReader.readLine();
                        if (!line.equals(line2)) {
                            int iCompareTo = line.compareTo(line2);
                            d.d(bufferedReader3);
                            d.d(bufferedReader);
                            return iCompareTo;
                        }
                    }
                    int i11 = bufferedReader.readLine() == null ? 0 : -1;
                    d.d(bufferedReader3);
                    d.d(bufferedReader);
                    return i11;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader3;
                    d.d(bufferedReader2);
                    d.d(bufferedReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }
}
