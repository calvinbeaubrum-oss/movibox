package com.bytedance.sdk.component.pFF.sc.sc.sc;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.SR;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements com.bytedance.sdk.component.pFF.sc.pFF {
    com.bytedance.sdk.component.pFF.sc.We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Ql f26958sc;
    private AtomicBoolean zY = new AtomicBoolean(false);

    public pFF(Ql ql2, com.bytedance.sdk.component.pFF.sc.We we2) {
        this.f26958sc = ql2;
        this.pFF = we2;
    }

    private boolean ExN() {
        if (this.f26958sc.We() == null) {
            return false;
        }
        return this.f26958sc.We().containsKey(HttpHeaders.CONTENT_TYPE);
    }

    private boolean pFF(SR sr2) {
        Ql ql2;
        return (sr2 == null || (ql2 = this.f26958sc) == null || !"POST".equalsIgnoreCase(ql2.zY()) || sr2.TRI != SR.sc.STRING_TYPE || TextUtils.isEmpty(sr2.We)) ? false : true;
    }

    private static void sc(HttpURLConnection httpURLConnection) {
        try {
            Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(httpURLConnection);
            Field declaredField2 = obj.getClass().getDeclaredField("client");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            obj2.getClass().getDeclaredMethod("setRetryOnConnectionFailure", Boolean.TYPE).invoke(obj2, Boolean.FALSE);
        } catch (Exception unused) {
        }
    }

    private boolean sc(SR sr2) {
        Ql ql2;
        byte[] bArr;
        return sr2 != null && (ql2 = this.f26958sc) != null && "POST".equalsIgnoreCase(ql2.zY()) && sr2.TRI == SR.sc.BYTE_ARRAY_TYPE && (bArr = sr2.ExN) != null && bArr.length > 0;
    }

    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.pFF.sc.pFF clone() {
        return new pFF(this.f26958sc, this.pFF);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF
    public BT pFF() throws IOException {
        List<com.bytedance.sdk.component.pFF.sc.Qj> list;
        com.bytedance.sdk.component.zY.sc.sc scVar;
        Ql ql2 = this.f26958sc;
        if (ql2 != null && (scVar = ql2.pFF) != null) {
            if (scVar.SR() == 0) {
                this.f26958sc.pFF.BT();
            }
            this.f26958sc.pFF.sc();
        }
        this.pFF.zY().remove(this);
        this.pFF.We().add(this);
        com.bytedance.sdk.component.pFF.sc.We we2 = this.pFF;
        if ((we2 instanceof ExN) && (we2.zY().size() + this.pFF.We().size() > this.pFF.sc() || this.zY.get())) {
            this.pFF.We().remove(this);
            return new qr(qr.f26961sc, "Maximum number of requests exceeded", this.f26958sc);
        }
        try {
            UFX ufx = this.f26958sc.f26928sc;
            if (ufx == null || (list = ufx.f26935sc) == null || list.size() <= 0) {
                return sc(this.f26958sc);
            }
            ArrayList arrayList = new ArrayList(this.f26958sc.f26928sc.f26935sc);
            arrayList.add(new com.bytedance.sdk.component.pFF.sc.Qj() { // from class: com.bytedance.sdk.component.pFF.sc.sc.sc.pFF.1
                @Override // com.bytedance.sdk.component.pFF.sc.Qj
                public BT sc(com.bytedance.sdk.component.pFF.sc.Qj.sc scVar2) throws IOException {
                    return pFF.this.sc(scVar2.sc());
                }
            });
            return ((com.bytedance.sdk.component.pFF.sc.Qj) arrayList.get(0)).sc(new zY(arrayList, this.f26958sc));
        } catch (Throwable th2) {
            throw new IOException(th2.getMessage());
        }
    }

    public BT sc(Ql ql2) throws IOException {
        HttpURLConnection httpURLConnection;
        Exception e11;
        String message;
        int responseCode = qr.f26961sc;
        try {
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(ql2.pFF().sc().toString()).openConnection()));
                try {
                    if (ql2.We() != null && ql2.We().size() > 0) {
                        for (Map.Entry<String, List<String>> entry : ql2.We().entrySet()) {
                            String key = entry.getKey();
                            for (String str : entry.getValue()) {
                                if ("_disable_retry".equals(key) && "1".equals(str)) {
                                    sc(httpURLConnection);
                                } else {
                                    httpURLConnection.addRequestProperty(key, str);
                                }
                            }
                        }
                    }
                    UFX ufx = ql2.f26928sc;
                    if (ufx != null) {
                        TimeUnit timeUnit = ufx.zY;
                        if (timeUnit != null) {
                            httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(ufx.pFF));
                        }
                        UFX ufx2 = ql2.f26928sc;
                        if (ufx2.zY != null) {
                            httpURLConnection.setReadTimeout((int) ufx2.ExN.toMillis(ufx2.We));
                        }
                    }
                    if (ql2.Qj() == null) {
                        httpURLConnection.setRequestMethod("GET");
                    } else {
                        if (!ExN() && ql2.Qj().zY != null) {
                            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_TYPE, ql2.Qj().zY.sc());
                        }
                        httpURLConnection.setRequestMethod(ql2.zY());
                        if ("POST".equalsIgnoreCase(ql2.zY())) {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            if (sc(ql2.Qj())) {
                                outputStream.write(ql2.Qj().ExN);
                            } else if (pFF(ql2.Qj())) {
                                outputStream.write(ql2.Qj().We.getBytes());
                            }
                            outputStream.flush();
                            outputStream.close();
                        }
                    }
                    com.bytedance.sdk.component.zY.sc.sc scVar = ql2.pFF;
                    if (scVar != null) {
                        scVar.pFF();
                    }
                    httpURLConnection.connect();
                    com.bytedance.sdk.component.zY.sc.sc scVar2 = ql2.pFF;
                    if (scVar2 != null) {
                        scVar2.zY();
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    com.bytedance.sdk.component.zY.sc.sc scVar3 = ql2.pFF;
                    if (scVar3 != null) {
                        scVar3.ExN();
                    }
                    if (!this.zY.get()) {
                        qr qrVar = new qr(httpURLConnection, ql2);
                        this.pFF.We().remove(this);
                        return qrVar;
                    }
                    httpURLConnection.disconnect();
                    this.pFF.We().remove(this);
                    message = "internal error";
                    return new qr(responseCode, message, ql2);
                } catch (Exception e12) {
                    e11 = e12;
                    try {
                        message = httpURLConnection.getErrorStream().toString();
                    } catch (Throwable unused) {
                        message = e11.getMessage();
                    }
                    this.pFF.We().remove(this);
                }
            } catch (Exception e13) {
                httpURLConnection = null;
                e11 = e13;
            }
        } catch (Throwable th2) {
            this.pFF.We().remove(this);
            throw th2;
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF
    public Ql sc() {
        return this.f26958sc;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF
    public void sc(final com.bytedance.sdk.component.pFF.sc.zY zYVar) {
        com.bytedance.sdk.component.zY.sc.sc scVar;
        Ql ql2 = this.f26958sc;
        if (ql2 != null && (scVar = ql2.pFF) != null) {
            scVar.BT();
        }
        this.pFF.pFF().submit(new com.bytedance.sdk.component.Qj.zY.pFF(this.f26958sc.qr(), this.f26958sc.TRI()) { // from class: com.bytedance.sdk.component.pFF.sc.sc.sc.pFF.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BT btPFF = pFF.this.pFF();
                    if (btPFF == null) {
                        zYVar.sc(pFF.this, new IOException("response is null"));
                    } else {
                        zYVar.sc(pFF.this, btPFF);
                    }
                } catch (IOException e11) {
                    zYVar.sc(pFF.this, e11);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF
    public void zY() {
        this.zY.set(true);
    }
}
