package com.apm.insight.k;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f16920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f16923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private k f16924f;

    public i(String str, String str2, boolean z11) throws IOException {
        this.f16921c = str2;
        this.f16922d = z11;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f16919a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        this.f16920b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f16920b.setDoOutput(true);
        this.f16920b.setDoInput(true);
        this.f16920b.setRequestMethod("POST");
        this.f16920b.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + str3);
        if (!z11) {
            this.f16923e = new f(this.f16920b.getOutputStream());
        } else {
            this.f16920b.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
            this.f16924f = new k(this.f16920b.getOutputStream());
        }
    }

    public final String a() throws IOException {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f16919a + "--\r\n").getBytes();
        if (this.f16922d) {
            this.f16924f.write(bytes);
            this.f16924f.b();
            this.f16924f.a();
        } else {
            this.f16923e.write(bytes);
            this.f16923e.flush();
            this.f16923e.a();
        }
        int responseCode = this.f16920b.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: ".concat(String.valueOf(responseCode)));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f16920b.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        bufferedReader.close();
        this.f16920b.disconnect();
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
        }
        return sb2.toString();
    }

    public final void a(String str, File file, Map<String, String> map) throws IOException {
        String name = file.getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--");
        sb2.append(this.f16919a);
        sb2.append("\r\nContent-Disposition: form-data; name=\"");
        sb2.append(str);
        sb2.append("\"; filename=\"");
        sb2.append(name);
        sb2.append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb2.append("; ");
            sb2.append(entry.getKey());
            sb2.append("=\"");
            sb2.append(entry.getValue());
            sb2.append("\"");
        }
        sb2.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f16922d) {
            this.f16924f.write(sb2.toString().getBytes());
        } else {
            this.f16923e.write(sb2.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i11 = fileInputStream.read(bArr);
            if (i11 == -1) {
                break;
            } else if (this.f16922d) {
                this.f16924f.write(bArr, 0, i11);
            } else {
                this.f16923e.write(bArr, 0, i11);
            }
        }
        fileInputStream.close();
        if (this.f16922d) {
            this.f16924f.write("\r\n".getBytes());
        } else {
            this.f16923e.write("\r\n".getBytes());
            this.f16923e.flush();
        }
    }

    public final void a(String str, String str2) {
        b(str, str2);
    }

    public final void a(String str, File... fileArr) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--");
        sb2.append(this.f16919a);
        sb2.append("\r\nContent-Disposition: form-data; name=\"");
        sb2.append(str);
        sb2.append("\"; filename=\"");
        sb2.append(str);
        sb2.append("\"\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f16922d) {
            this.f16924f.write(sb2.toString().getBytes());
        } else {
            this.f16923e.write(sb2.toString().getBytes());
        }
        if (this.f16922d) {
            com.apm.insight.l.f.a(this.f16924f, fileArr);
        } else {
            com.apm.insight.l.f.a(this.f16923e, fileArr);
        }
        if (this.f16922d) {
            this.f16924f.write("\r\n".getBytes());
        } else {
            this.f16923e.write("\r\n".getBytes());
            this.f16923e.flush();
        }
    }

    public final void b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--");
        sb2.append(this.f16919a);
        sb2.append("\r\nContent-Disposition: form-data; name=\"");
        sb2.append(str);
        sb2.append("\"\r\nContent-Type: text/plain; charset=");
        sb2.append(this.f16921c);
        sb2.append("\r\n\r\n");
        try {
            if (this.f16922d) {
                this.f16924f.write(sb2.toString().getBytes());
            } else {
                this.f16923e.write(sb2.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        try {
            if (this.f16922d) {
                this.f16924f.write(bytes);
                this.f16924f.write("\r\n".getBytes());
            } else {
                this.f16923e.write(bytes);
                this.f16923e.write("\r\n".getBytes());
            }
        } catch (IOException unused2) {
        }
    }
}
