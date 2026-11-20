package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f32348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f32349j;

    public e(a aVar) {
        super(aVar);
        this.f32349j = aVar;
    }

    public final String i(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final String j(d dVar) {
        char c11;
        String strI;
        int i11;
        String strI2;
        String strZ = this.f32349j.z();
        boolean z11 = !TextUtils.isEmpty(strZ);
        long jA = this.f32349j.A();
        long jG = this.f32349j.G();
        long j11 = dVar.f32346b;
        boolean z12 = jA >= 0;
        boolean z13 = dVar.f32347c;
        long j12 = z13 ? jA - j11 : jA;
        boolean z14 = z12 && z13;
        q.e("header， offset = " + j11 + ", rangeEnd = " + jG + ", totalSize = " + jA + ", contentLength = " + j12 + " , contentType = " + strZ);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dVar.f32347c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb2.append("Accept-Ranges: bytes\n");
        String strI3 = "";
        if (z12) {
            Object objValueOf = Long.valueOf(j12);
            c11 = 0;
            strI = i("Content-Length: %d\n", objValueOf);
        } else {
            c11 = 0;
            strI = "";
        }
        sb2.append(strI);
        if (z14) {
            Object[] objArr = new Object[3];
            objArr[c11] = Long.valueOf(j11);
            i11 = 1;
            objArr[1] = Long.valueOf(jG);
            objArr[2] = Long.valueOf(jA);
            strI2 = i("Content-Range: bytes %d-%d/%d\n", objArr);
        } else {
            i11 = 1;
            strI2 = "";
        }
        sb2.append(strI2);
        if (z11) {
            Object[] objArr2 = new Object[i11];
            objArr2[0] = strZ;
            strI3 = i("Content-Type: %s\n", objArr2);
        }
        sb2.append(strI3);
        sb2.append("\n");
        return sb2.toString();
    }

    public void k(d dVar, Socket socket) throws IOException, ProxyCacheException {
        long j11 = dVar.f32346b;
        q.f("processRequest， offset = " + j11 + "， threadName = " + Thread.currentThread().getName());
        a(j11);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(j(dVar).getBytes("UTF-8"));
        m(bufferedOutputStream, j11, n.b(dVar.f32345a));
    }

    public void l(b bVar) {
        this.f32348i = bVar;
    }

    public final void m(OutputStream outputStream, long j11, String str) throws IOException, ProxyCacheException {
        q.a("responseWithCache， offset = " + j11);
        byte[] bArr = new byte[8192];
        while (true) {
            int iD = d(bArr, j11, 8192, str);
            if (iD == -1 || this.f32374e) {
                break;
            }
            outputStream.write(bArr, 0, iD);
            j11 += (long) iD;
        }
        outputStream.flush();
        q.e("responseWithCache， --------------------end,offset = " + j11 + "， threadName = " + Thread.currentThread().getName());
    }
}
