package com.bytedance.sdk.component.TRI.sc.We.sc;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements com.bytedance.sdk.component.TRI.sc.We.sc {
    private long ExN;
    private String Ol;
    private String Qj;
    private long TRI;
    private int Tf;
    private String UFX;
    private byte WH;
    private byte We;
    private pFF pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f26605qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected JSONObject f26606sc;
    private byte zY;

    private sc() {
    }

    public sc(String str, pFF pff) {
        this.Ol = str;
        this.pFF = pff;
    }

    public sc(String str, JSONObject jSONObject) {
        this.Ol = str;
        this.f26606sc = jSONObject;
    }

    public static com.bytedance.sdk.component.TRI.sc.We.sc zY(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt(TrackingKey.PRIORITY);
            sc scVar = new sc();
            scVar.sc((byte) iOptInt);
            scVar.pFF((byte) iOptInt2);
            scVar.sc(jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            scVar.sc(jSONObject.optString("localId"));
            scVar.pFF(jSONObject.optString("genTime"));
            scVar.sc(jSONObject.optInt("channel"));
            return scVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public byte ExN() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public long Ol() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public long Qj() {
        return this.ExN;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public String TRI() {
        if (TextUtils.isEmpty(this.Ol)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.Ol);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, qr());
            jSONObject.put("genTime", Tf());
            jSONObject.put(TrackingKey.PRIORITY, (int) this.We);
            jSONObject.put("type", (int) this.zY);
            jSONObject.put("channel", this.Tf);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String Tf() {
        return this.Qj;
    }

    public String UFX() {
        return this.UFX;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public int WH() {
        return this.Tf;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public byte We() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public byte pFF() {
        return this.WH;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void pFF(byte b11) {
        this.We = b11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void pFF(long j11) {
        this.TRI = j11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void pFF(String str) {
        this.Qj = str;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public synchronized JSONObject qr() {
        pFF pff;
        try {
            if (this.f26606sc == null && (pff = this.pFF) != null) {
                this.f26606sc = pff.sc(UFX());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f26606sc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public pFF sc() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void sc(byte b11) {
        this.zY = b11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void sc(int i11) {
        this.Tf = i11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void sc(long j11) {
        this.ExN = j11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void sc(String str) {
        this.Ol = str;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void sc(JSONObject jSONObject) {
        this.f26606sc = jSONObject;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public String zY() {
        return this.Ol;
    }

    public void zY(byte b11) {
        this.WH = b11;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.We.sc
    public void zY(long j11) {
        this.f26605qr = j11;
    }
}
