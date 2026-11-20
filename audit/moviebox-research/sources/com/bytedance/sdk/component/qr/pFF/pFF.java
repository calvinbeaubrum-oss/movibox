package com.bytedance.sdk.component.qr.pFF;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.TRI;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.component.pFF.sc.dE;
import com.bytedance.sdk.component.pFF.sc.qr;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends zY {
    private Map<String, String> Tf;
    private boolean UFX;
    private com.bytedance.sdk.component.pFF.sc.sc WH;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final com.bytedance.sdk.component.pFF.sc.sc f26972sc = new com.bytedance.sdk.component.pFF.sc.sc.C0262sc().sc().pFF();
    public static final com.bytedance.sdk.component.pFF.sc.sc pFF = new com.bytedance.sdk.component.pFF.sc.sc.C0262sc().pFF();

    public pFF(UFX ufx) {
        super(ufx);
        this.WH = f26972sc;
        this.UFX = false;
        this.Tf = new HashMap();
    }

    public com.bytedance.sdk.component.qr.pFF sc() {
        try {
            Ql.sc scVar = new Ql.sc();
            if (this.UFX) {
                scVar.pFF(this.Qj);
            } else {
                qr.sc scVar2 = new qr.sc();
                Uri uri = Uri.parse(this.Qj);
                scVar2.sc(uri.getScheme());
                scVar2.pFF(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    scVar2.zY(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.Tf.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.Tf.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        scVar2.sc(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                scVar.sc(scVar2.pFF());
            }
            sc(scVar);
            scVar.sc(this.WH);
            scVar.sc((Object) zY());
            BT btPFF = this.zY.sc(scVar.sc().pFF()).pFF();
            if (btPFF == null) {
                return null;
            }
            HashMap map = new HashMap();
            TRI triQr = btPFF.qr();
            if (triQr != null) {
                for (int i11 = 0; i11 < triQr.sc(); i11++) {
                    map.put(triQr.sc(i11), triQr.pFF(i11));
                }
            }
            dE dEVarTRI = btPFF.TRI();
            return new com.bytedance.sdk.component.qr.pFF(btPFF.We(), btPFF.zY(), btPFF.ExN(), map, dEVarTRI != null ? dEVarTRI.pFF() : "", btPFF.pFF(), btPFF.sc());
        } catch (Throwable unused) {
            return null;
        }
    }

    public void sc(final com.bytedance.sdk.component.qr.sc.sc scVar) {
        try {
            Ql.sc scVar2 = new Ql.sc();
            if (this.UFX) {
                scVar2.pFF(this.Qj);
            } else {
                qr.sc scVar3 = new qr.sc();
                Uri uri = Uri.parse(this.Qj);
                scVar3.sc(uri.getScheme());
                scVar3.pFF(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    scVar3.zY(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.Tf.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.Tf.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        scVar3.sc(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                scVar2.sc(scVar3.pFF());
            }
            sc(scVar2);
            scVar2.sc(this.WH);
            scVar2.sc((Object) zY());
            if (!TextUtils.isEmpty(this.ExN)) {
                scVar2.sc(this.ExN);
            }
            int i11 = this.TRI;
            if (i11 > 0) {
                scVar2.sc(i11);
            }
            this.zY.sc(scVar2.sc().pFF()).sc(new com.bytedance.sdk.component.pFF.sc.zY() { // from class: com.bytedance.sdk.component.qr.pFF.pFF.1
                @Override // com.bytedance.sdk.component.pFF.sc.zY
                public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff, BT bt2) throws IOException {
                    if (scVar != null) {
                        HashMap map = new HashMap();
                        if (bt2 != null) {
                            TRI triQr = bt2.qr();
                            if (triQr != null) {
                                for (int i12 = 0; i12 < triQr.sc(); i12++) {
                                    map.put(triQr.sc(i12), triQr.pFF(i12));
                                }
                            }
                            dE dEVarTRI = bt2.TRI();
                            scVar.sc(pFF.this, new com.bytedance.sdk.component.qr.pFF(bt2.We(), bt2.zY(), bt2.ExN(), map, dEVarTRI == null ? "" : dEVarTRI.pFF(), bt2.pFF(), bt2.sc()));
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.pFF.sc.zY
                public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff, IOException iOException) {
                    com.bytedance.sdk.component.qr.sc.sc scVar4 = scVar;
                    if (scVar4 != null) {
                        scVar4.sc(pFF.this, iOException);
                    }
                }
            });
        } catch (Throwable th2) {
            if (scVar != null) {
                scVar.sc(this, new IOException(th2.getMessage()));
            }
        }
    }

    public void sc(String str, String str2) {
        if (str == null) {
            return;
        }
        this.Tf.put(str, str2);
    }

    public void sc(boolean z11) {
        this.UFX = z11;
    }
}
