package com.bytedance.adsdk.pFF.We;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class sc implements We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final HttpURLConnection f26165sc;

    public sc(HttpURLConnection httpURLConnection) {
        this.f26165sc = httpURLConnection;
    }

    private String sc(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb2.append(line);
                    sb2.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th2;
            }
        }
        bufferedReader.close();
        return sb2.toString();
    }

    @Override // com.bytedance.adsdk.pFF.We.We
    public String We() {
        try {
            if (sc()) {
                return null;
            }
            return "Unable to fetch " + this.f26165sc.getURL() + ". Failed with " + this.f26165sc.getResponseCode() + "\n" + sc(this.f26165sc);
        } catch (IOException e11) {
            return e11.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f26165sc.disconnect();
    }

    @Override // com.bytedance.adsdk.pFF.We.We
    public InputStream pFF() throws IOException {
        return this.f26165sc.getInputStream();
    }

    @Override // com.bytedance.adsdk.pFF.We.We
    public boolean sc() {
        try {
            return this.f26165sc.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.pFF.We.We
    public String zY() {
        return this.f26165sc.getContentType();
    }
}
