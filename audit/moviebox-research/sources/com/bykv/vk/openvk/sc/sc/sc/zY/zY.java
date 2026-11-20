package com.bykv.vk.openvk.sc.sc.sc.zY;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
import q8.c;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements Serializable {
    private long BT;
    private a ExN;
    private int Ql;
    private String SR;
    private int Sfl;
    private a TRI;
    private int Tf;
    private String UFX;
    public int We;
    private boolean Xc;
    private boolean dE;
    public int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f26070qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public String f26071sc;
    private int wjp;
    private int Qj = 204800;
    private int Ol = 0;
    private int WH = 0;
    public final HashMap<String, Object> zY = new HashMap<>();
    private int YIK = 10000;
    private int Dl = 10000;
    private int uEA = 10000;
    private int JPJ = 0;
    private JSONObject FI = new JSONObject();

    public zY(String str, a aVar, a aVar2, int i11, int i12) {
        this.wjp = 0;
        this.Sfl = 0;
        this.f26070qr = str;
        this.ExN = aVar;
        this.TRI = aVar2;
        this.wjp = i11;
        this.Sfl = i12;
    }

    public int BT() {
        return this.wjp;
    }

    public a Dl() {
        return this.TRI;
    }

    public int ExN() {
        return this.Tf;
    }

    public synchronized Object ExN(String str) {
        return this.zY.get(str);
    }

    public void ExN(int i11) {
        this.Dl = i11;
    }

    public long Ol() {
        if (UFX()) {
            return this.TRI.c();
        }
        a aVar = this.ExN;
        if (aVar != null) {
            return aVar.c();
        }
        return 0L;
    }

    public boolean Qj() {
        return this.dE;
    }

    public String Ql() {
        if (UFX()) {
            return this.TRI.q();
        }
        a aVar = this.ExN;
        if (aVar != null) {
            return aVar.q();
        }
        return null;
    }

    public String SR() {
        if (UFX()) {
            return this.TRI.k();
        }
        a aVar = this.ExN;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public int Sfl() {
        return this.JPJ;
    }

    public int TRI() {
        return this.Ql;
    }

    public void TRI(int i11) {
        this.uEA = i11;
    }

    public float Tf() {
        if (UFX()) {
            return this.TRI.h();
        }
        a aVar = this.ExN;
        if (aVar != null) {
            return aVar.h();
        }
        return -1.0f;
    }

    public boolean UFX() {
        a aVar;
        if (this.Sfl == 1 && (aVar = this.TRI) != null && !TextUtils.isEmpty(aVar.q())) {
            if (c.b() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.wjp == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean WH() {
        if (UFX()) {
            return this.TRI.b();
        }
        a aVar = this.ExN;
        if (aVar != null) {
            return aVar.b();
        }
        return true;
    }

    public void We(int i11) {
        this.YIK = i11;
    }

    public void We(String str) {
        this.f26071sc = str;
    }

    public boolean We() {
        return this.Xc;
    }

    public int Xc() {
        return this.Dl;
    }

    public a YIK() {
        return this.ExN;
    }

    public int dE() {
        return this.YIK;
    }

    public String pFF() {
        return this.f26070qr;
    }

    public void pFF(int i11) {
        this.Ql = i11;
    }

    public void pFF(String str) {
        this.UFX = str;
    }

    public long qr() {
        return this.BT;
    }

    public void qr(int i11) {
        this.JPJ = i11;
    }

    public int sc() {
        return this.FI.optInt("pitaya_cache_size", 0);
    }

    public void sc(int i11) {
        this.Tf = i11;
    }

    public void sc(long j11) {
        this.BT = j11;
    }

    public void sc(String str) {
        this.f26070qr = str;
    }

    public synchronized void sc(String str, Object obj) {
        this.zY.put(str, obj);
    }

    public void sc(boolean z11) {
        this.dE = z11;
    }

    public int wjp() {
        return this.uEA;
    }

    public int zY() {
        if (UFX()) {
            return this.TRI.a();
        }
        a aVar = this.ExN;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public void zY(int i11) {
        this.pFF = i11;
    }

    public void zY(String str) {
        this.SR = str;
    }
}
