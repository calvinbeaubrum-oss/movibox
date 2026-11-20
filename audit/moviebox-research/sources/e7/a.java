package e7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HttpURLConnection f64059a;

    public a(@NonNull HttpURLConnection httpURLConnection) {
        this.f64059a = httpURLConnection;
    }

    @Override // e7.c
    @NonNull
    public InputStream M() throws IOException {
        return this.f64059a.getInputStream();
    }

    public final String a(HttpURLConnection httpURLConnection) throws IOException {
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f64059a.disconnect();
    }

    @Override // e7.c
    @Nullable
    public String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f64059a.getURL() + ". Failed with " + this.f64059a.getResponseCode() + "\n" + a(this.f64059a);
        } catch (IOException e11) {
            g7.f.d("get error failed ", e11);
            return e11.getMessage();
        }
    }

    @Override // e7.c
    public boolean isSuccessful() {
        try {
            return this.f64059a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // e7.c
    @Nullable
    public String z() {
        return this.f64059a.getContentType();
    }
}
