package com.bytedance.sdk.component.adexpress.dynamic.We;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private float ExN;
    private ExN Ol;
    private float Qj;
    private String Ql;
    private boolean SR;
    private float TRI;
    private List<List<Qj>> Tf;
    private Qj UFX;
    private List<Qj> WH;
    private float We;
    private float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26749qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26750sc;
    private float zY;
    private Map<String, String> BT = new HashMap();
    private Map<Integer, String> dE = new HashMap();

    public float BT() {
        TRI triExN = this.Ol.ExN();
        return Ql() + triExN.BT() + triExN.dE() + (triExN.Tf() * 2.0f);
    }

    public void Dl() {
        List<List<Qj>> list = this.Tf;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<Qj> list2 : this.Tf) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.Tf = arrayList;
    }

    public float ExN() {
        return this.ExN;
    }

    public void ExN(float f11) {
        this.TRI = f11;
    }

    public boolean FI() {
        return this.Ol.ExN().gsl() < 0 || this.Ol.ExN().QST() < 0 || this.Ol.ExN().IEI() < 0 || this.Ol.ExN().PPh() < 0;
    }

    public String JPJ() {
        return this.Ol.ExN().JPJ();
    }

    public float Ol() {
        return this.f26749qr;
    }

    public float Qj() {
        return this.TRI;
    }

    public int Ql() {
        TRI triExN = this.Ol.ExN();
        return triExN.yL() + triExN.Yhz();
    }

    public int SR() {
        TRI triExN = this.Ol.ExN();
        return triExN.QLv() + triExN.eo();
    }

    public boolean Sfl() {
        return this.SR;
    }

    public float TRI() {
        return this.pFF;
    }

    public void TRI(float f11) {
        this.f26749qr = f11;
    }

    public Qj Tf() {
        return this.UFX;
    }

    public List<Qj> UFX() {
        return this.WH;
    }

    public ExN WH() {
        return this.Ol;
    }

    public float We() {
        return this.We;
    }

    public void We(float f11) {
        this.zY = f11;
    }

    public List<List<Qj>> Xc() {
        return this.Tf;
    }

    public Map<String, String> YIK() {
        return this.BT;
    }

    public float dE() {
        TRI triExN = this.Ol.ExN();
        return SR() + triExN.Xc() + triExN.SR() + (triExN.Tf() * 2.0f);
    }

    public Map<Integer, String> pFF() {
        return this.dE;
    }

    public void pFF(float f11) {
        this.ExN = f11;
    }

    public void pFF(String str) {
        this.f26750sc = str;
    }

    public void pFF(List<List<Qj>> list) {
        this.Tf = list;
    }

    public float qr() {
        return this.zY;
    }

    public void qr(float f11) {
        this.Qj = f11;
    }

    public String sc() {
        return this.Ql;
    }

    public String sc(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.Ol.pFF());
        sb2.append(":");
        sb2.append(this.f26750sc);
        if (this.Ol.ExN() != null) {
            sb2.append(":");
            sb2.append(this.Ol.ExN().VZ());
        }
        sb2.append(":");
        sb2.append(i11);
        return sb2.toString();
    }

    public void sc(float f11) {
        this.We = f11;
    }

    public void sc(ExN exN) {
        this.Ol = exN;
    }

    public void sc(Qj qj2) {
        this.UFX = qj2;
    }

    public void sc(String str) {
        this.Ql = str;
    }

    public void sc(String str, String str2) {
        this.BT.put(str, str2);
    }

    public void sc(List<Qj> list) {
        this.WH = list;
    }

    public void sc(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    this.dE.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void sc(boolean z11) {
        this.SR = z11;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.f26750sc + "', x=" + this.pFF + ", y=" + this.zY + ", width=" + this.TRI + ", height=" + this.f26749qr + ", remainWidth=" + this.Qj + ", rootBrick=" + this.Ol + ", childrenBrickUnits=" + this.WH + '}';
    }

    public boolean uEA() {
        return TextUtils.equals(this.Ol.ExN().McK(), "flex");
    }

    public boolean wjp() {
        List<Qj> list = this.WH;
        return list == null || list.size() <= 0;
    }

    public String zY() {
        return this.f26750sc;
    }

    public void zY(float f11) {
        this.pFF = f11;
    }

    public void zY(String str) {
        this.Ol.ExN().TRI(str);
    }
}
