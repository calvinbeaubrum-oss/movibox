package com.bytedance.sdk.component.qr.pFF;

import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.UFX;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zY {
    String ExN;
    int TRI;
    protected UFX zY;
    protected String We = null;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected final Map<String, String> f26976qr = new HashMap();
    protected String Qj = null;
    protected boolean Ol = false;

    public zY(UFX ufx) {
        this.zY = ufx;
        try {
            zY(UUID.randomUUID().toString());
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public void We(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f26976qr.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void pFF() {
        UFX ufx;
        if (this.We == null || (ufx = this.zY) == null) {
            return;
        }
        com.bytedance.sdk.component.pFF.sc.We weSc = ufx.sc();
        synchronized (weSc) {
            try {
                for (com.bytedance.sdk.component.pFF.sc.pFF pff : weSc.zY()) {
                    if (this.We.equals(pff.sc().sc())) {
                        pff.zY();
                    }
                }
                for (com.bytedance.sdk.component.pFF.sc.pFF pff2 : weSc.We()) {
                    if (this.We.equals(pff2.sc().sc())) {
                        pff2.zY();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void pFF(String str) {
        this.Qj = str;
    }

    public void pFF(String str, String str2) {
        this.f26976qr.put(str, str2);
    }

    public void sc(int i11) {
        this.TRI = i11;
    }

    public void sc(Ql.sc scVar) {
        if (scVar != null && this.f26976qr.size() > 0) {
            for (Map.Entry<String, String> entry : this.f26976qr.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    scVar.pFF(key, value);
                }
            }
        }
    }

    public void sc(String str) {
        this.ExN = str;
    }

    public String zY() {
        return this.We;
    }

    public void zY(String str) {
        this.We = str;
    }
}
