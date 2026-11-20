package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.aa;
import com.mbridge.msdk.e.a.z;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class h {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f43754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final z f43755b;

        private a(String str, z zVar) {
            this.f43754a = str;
            this.f43755b = zVar;
        }
    }

    public static byte[] a(InputStream inputStream, int i11, c cVar) throws Throwable {
        byte[] bArrA;
        j jVar = new j(cVar, i11);
        try {
            bArrA = cVar.a(1024);
            while (true) {
                try {
                    int i12 = inputStream.read(bArrA);
                    if (i12 == -1) {
                        break;
                    }
                    jVar.write(bArrA, 0, i12);
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            aa.a("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    cVar.a(bArrA);
                    jVar.close();
                    throw th;
                }
            }
            byte[] byteArray = jVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                aa.a("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.a(bArrA);
            jVar.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            bArrA = null;
        }
    }
}
