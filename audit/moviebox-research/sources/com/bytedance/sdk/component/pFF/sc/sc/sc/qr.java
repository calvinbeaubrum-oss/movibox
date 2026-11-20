package com.bytedance.sdk.component.pFF.sc.sc.sc;

import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.Tf;
import com.bytedance.sdk.component.pFF.sc.WH;
import com.bytedance.sdk.component.pFF.sc.dE;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends BT {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f26961sc = -1;
    String ExN;
    int We;
    HttpURLConnection pFF;
    Ql zY;

    public qr(int i11, String str, Ql ql2) {
        this.ExN = str;
        this.zY = ql2;
        this.We = i11;
    }

    public qr(HttpURLConnection httpURLConnection, Ql ql2) {
        this.We = f26961sc;
        this.pFF = httpURLConnection;
        this.zY = ql2;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public String ExN() throws IOException {
        return !TextUtils.isEmpty(this.ExN) ? this.ExN : this.pFF.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public WH Ol() {
        if (WH() == null || WH().pFF == null) {
            return null;
        }
        return new WH(WH().pFF);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public Tf Qj() {
        return Tf.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public dE TRI() {
        Qj qj2;
        com.bytedance.sdk.component.zY.sc.sc scVar;
        com.bytedance.sdk.component.zY.sc.sc scVar2;
        Ql ql2 = this.zY;
        if (ql2 != null && (scVar2 = ql2.pFF) != null) {
            scVar2.UFX();
        }
        try {
            try {
                qj2 = new Qj(this.pFF);
            } catch (Exception unused) {
                HttpURLConnection httpURLConnection = this.pFF;
                qj2 = new Qj(httpURLConnection, httpURLConnection.getErrorStream());
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
            qj2 = null;
        }
        Ql ql3 = this.zY;
        if (ql3 != null && (scVar = ql3.pFF) != null) {
            scVar.Ql();
        }
        return qj2;
    }

    public Ql WH() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public boolean We() {
        return zY() >= 200 && zY() < 300;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            TRI().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public long pFF() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public com.bytedance.sdk.component.pFF.sc.TRI qr() {
        if (this.pFF == null) {
            return new com.bytedance.sdk.component.pFF.sc.TRI(new String[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.pFF.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || zY() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.pFF.sc.TRI((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public long sc() {
        return 0L;
    }

    public String sc(String str) {
        HttpURLConnection httpURLConnection = this.pFF;
        return httpURLConnection == null ? "" : httpURLConnection.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public String sc(String str, String str2) {
        return !TextUtils.isEmpty(sc(str)) ? sc(str) : str2;
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.pFF.sc.BT
    public int zY() {
        try {
            return this.pFF.getResponseCode();
        } catch (Exception unused) {
            return this.We;
        }
    }
}
