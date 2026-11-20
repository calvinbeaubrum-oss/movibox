package com.bytedance.sdk.component.pFF.sc.sc.sc;

import com.bytedance.sdk.component.pFF.sc.dE;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends dE {
    InputStream pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    HttpURLConnection f26956sc;

    public Qj(HttpURLConnection httpURLConnection) throws IOException {
        this.f26956sc = httpURLConnection;
        this.pFF = new TRI(httpURLConnection.getInputStream(), httpURLConnection);
    }

    public Qj(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.f26956sc = httpURLConnection;
        this.pFF = new TRI(inputStream, httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.dE
    public com.bytedance.sdk.component.pFF.sc.Ol ExN() {
        if (this.f26956sc.getContentType() != null) {
            return com.bytedance.sdk.component.pFF.sc.Ol.sc(this.f26956sc.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.dE
    public byte[] We() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i11 = this.pFF.read(bArr);
                if (i11 == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i11);
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.dE, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.pFF.close();
            this.f26956sc.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.dE
    public String pFF() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.pFF));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
                stringBuffer.append(line + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.dE
    public long sc() {
        try {
            return this.f26956sc.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.dE
    public InputStream zY() {
        return this.pFF;
    }
}
