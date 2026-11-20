package com.bytedance.sdk.component.TRI.sc;

import android.content.Context;
import com.hisavana.common.constant.ComConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private static Qj Ql;
    private static volatile com.bytedance.sdk.component.TRI.sc.ExN.sc WH;
    private long BT;
    private volatile com.bytedance.sdk.component.TRI.sc.We.pFF.sc ExN;
    private volatile ExN Ol;
    private volatile boolean Qj;
    private final AtomicBoolean SR = new AtomicBoolean(false);
    private volatile com.bytedance.sdk.component.TRI.sc.We.pFF.sc TRI;
    private volatile Map<Integer, com.bytedance.sdk.component.TRI.sc.pFF.zY> Tf;
    private volatile com.bytedance.sdk.component.TRI.sc.pFF.zY UFX;
    private volatile com.bytedance.sdk.component.TRI.sc.We.pFF.sc We;
    private volatile com.bytedance.sdk.component.TRI.sc.We.pFF.sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private volatile com.bytedance.sdk.component.TRI.sc.sc.ExN f26584qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private volatile Context f26585sc;
    private volatile com.bytedance.sdk.component.TRI.sc.We.pFF.sc zY;

    private Qj() {
    }

    public static com.bytedance.sdk.component.TRI.sc.ExN.sc ExN() {
        if (WH == null) {
            synchronized (Qj.class) {
                try {
                    if (WH == null) {
                        WH = new com.bytedance.sdk.component.TRI.sc.ExN.pFF();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return WH;
    }

    public static synchronized Qj qr() {
        try {
            if (Ql == null) {
                Ql = new Qj();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return Ql;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc BT() {
        return this.ExN;
    }

    public void ExN(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        this.ExN = scVar;
    }

    public void Ol() {
        com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.pFF();
    }

    public com.bytedance.sdk.component.TRI.sc.pFF.zY Qj() {
        return this.UFX;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc Ql() {
        return this.zY;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc SR() {
        return this.We;
    }

    public Context TRI() {
        return this.f26585sc;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc Tf() {
        return this.pFF;
    }

    public void UFX() {
        com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.zY();
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc WH() {
        return this.TRI;
    }

    public com.bytedance.sdk.component.TRI.sc.sc.ExN We() {
        return this.f26584qr;
    }

    public void We(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        this.We = scVar;
    }

    public long Xc() {
        return this.BT * ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
    }

    public ExN dE() {
        return this.Ol;
    }

    public void pFF(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        this.pFF = scVar;
    }

    public void pFF(boolean z11) {
        this.Qj = z11;
    }

    public boolean pFF() {
        return this.Qj;
    }

    public void sc(long j11) {
        this.BT = j11;
    }

    public void sc(Context context) {
        this.f26585sc = context;
    }

    public void sc(ExN exN) {
        this.Ol = exN;
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        this.TRI = scVar;
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.We.sc scVar) {
        if (scVar == null) {
            return;
        }
        scVar.sc(System.currentTimeMillis());
        com.bytedance.sdk.component.TRI.sc.pFF.We.f26609sc.sc(scVar, scVar.We());
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.pFF.zY zYVar) {
        this.UFX = zYVar;
    }

    public void sc(com.bytedance.sdk.component.TRI.sc.sc.ExN exN) {
        this.f26584qr = exN;
    }

    public void sc(String str, List<String> list, boolean z11, Map<String, String> map, int i11, String str2) {
        com.bytedance.sdk.component.TRI.sc.TRI.sc.sc().sc(str, list, z11, map, i11, str2);
    }

    public void sc(String str, boolean z11) {
        com.bytedance.sdk.component.TRI.sc.TRI.sc.sc().sc(str, z11);
    }

    public void sc(boolean z11) {
        this.SR.set(z11);
    }

    public boolean sc() {
        return this.SR.get();
    }

    public Map<Integer, com.bytedance.sdk.component.TRI.sc.pFF.zY> zY() {
        return this.Tf;
    }

    public void zY(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
        this.zY = scVar;
    }
}
