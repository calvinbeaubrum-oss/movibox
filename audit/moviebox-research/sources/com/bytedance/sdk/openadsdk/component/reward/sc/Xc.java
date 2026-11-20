package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.logging.type.LogSeverity;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;
import q8.b;
import t8.c;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc {
    private FrameLayout Ol;
    private final com.bytedance.sdk.openadsdk.core.model.Sfl Qj;
    private String SR;
    private com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc Sfl;
    c TRI;
    private long Tf;
    private long UFX;
    private final String WH;
    final boolean We;
    private final sc Xc;
    private com.bytedance.sdk.openadsdk.We.qr YIK;
    private boolean dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Activity f27898qr;
    private boolean wjp;
    boolean zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected boolean f27899sc = false;
    boolean pFF = false;
    protected boolean ExN = false;
    private int Ql = -1;
    private HashSet<String> BT = new HashSet<>();

    public Xc(sc scVar) {
        this.Xc = scVar;
        this.f27898qr = scVar.CYO;
        this.Qj = scVar.pFF;
        this.We = scVar.We;
        this.WH = scVar.ExN;
    }

    private void OXF() {
        c cVar = this.TRI;
        if (cVar == null || cVar.Tf() == null) {
            return;
        }
        this.UFX = this.TRI.ExN();
        if (this.TRI.Tf().zY() || !this.TRI.Tf().pFF()) {
            this.TRI.sc();
            this.TRI.zY();
            this.f27899sc = true;
        }
    }

    private void pFF(long j11, long j12) {
        int iAbs = (int) Math.abs(((long) this.Ql) - j11);
        int i11 = this.Ql;
        if (i11 < 0 || iAbs > 500 || i11 > j12 || iAbs >= 500 || this.BT.contains(this.SR)) {
            return;
        }
        if (this.Ql > j11) {
            com.bytedance.sdk.openadsdk.core.SR.zY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Xc.1
                @Override // java.lang.Runnable
                public void run() {
                    Xc.this.cvk();
                    Xc.this.Xc.cvk.sc(Xc.this.Ql, Xc.this.SR);
                }
            }, iAbs);
        } else {
            cvk();
            this.Xc.cvk.sc(this.Ql, this.SR);
        }
        this.BT.add(this.SR);
    }

    private boolean sc(long j11, boolean z11) {
        if (this.TRI == null || this.Qj.GI() == null) {
            return false;
        }
        String strSc = CacheDirFactory.getICacheDir(this.Qj.Flm()).sc();
        File file = new File(strSc, this.Qj.GI().k());
        if (file.exists() && file.length() > 0) {
            this.pFF = true;
        }
        com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = com.bytedance.sdk.openadsdk.core.model.Sfl.sc(strSc, this.Qj);
        pffSc.pFF(this.Qj.kDg());
        pffSc.sc(this.Ol.getWidth());
        pffSc.pFF(this.Ol.getHeight());
        pffSc.zY(this.Qj.mD());
        pffSc.sc(j11);
        pffSc.sc(z11);
        if (this.Xc.pFF.sc() && !this.Xc.cvk.Qj() && com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.Qj)) {
            pffSc.We = 1;
        }
        return this.TRI.sc(pffSc);
    }

    public void BT() {
        c cVar = this.TRI;
        if (cVar != null) {
            cVar.sc();
        }
    }

    public void Cb() {
        c cVar = this.TRI;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
            ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) cVar).BR();
        }
    }

    public boolean Dl() {
        c cVar = this.TRI;
        if (cVar != null) {
            if (cVar.Tf() != null) {
                b bVarTf = this.TRI.Tf();
                if (bVarTf.qr() || bVarTf.Qj()) {
                    c cVar2 = this.TRI;
                    if (cVar2 instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
                        ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) cVar2).OXF();
                    }
                    return true;
                }
            } else if (TRI()) {
                sc(false);
                c cVar3 = this.TRI;
                if (cVar3 instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) cVar3).OXF();
                }
                return true;
            }
        }
        return false;
    }

    public boolean ExN() {
        c cVar = this.TRI;
        return cVar != null && cVar.dE();
    }

    public boolean FI() {
        return this.zY;
    }

    public View Gb() {
        c cVar = this.TRI;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
            return (View) ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) cVar).cJ();
        }
        return null;
    }

    public void HJN() {
        c cVar = this.TRI;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
            ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) cVar).Cb();
        }
    }

    public boolean II() {
        c cVar = this.TRI;
        if (cVar == null || cVar.Tf() == null) {
            return false;
        }
        return this.TRI.Tf().sc();
    }

    public boolean JPJ() {
        c cVar = this.TRI;
        return cVar != null && cVar.Tf() == null;
    }

    public double McK() {
        long jWe;
        com.bytedance.sdk.openadsdk.core.model.wjp wjpVarOl = this.Qj.Ol();
        if (com.bytedance.sdk.openadsdk.core.model.Xc.We(this.Qj) && wjpVarOl != null) {
            jWe = wjpVarOl.pFF();
        } else {
            if (!com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.Qj) || wjpVarOl == null) {
                a aVarGI = this.Qj.GI();
                if (aVarGI != null) {
                    return aVarGI.m() * ((double) aVarGI.J());
                }
                return 0.0d;
            }
            jWe = wjpVarOl.We();
        }
        return jWe;
    }

    public long Ol() {
        return this.UFX;
    }

    public long Qj() {
        return this.Tf;
    }

    public void Ql() {
        c cVar = this.TRI;
        if (cVar != null) {
            cVar.We();
        }
    }

    public void SR() {
        c cVar = this.TRI;
        if (cVar != null) {
            cVar.pFF();
        }
    }

    public long Sfl() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar.Qj() + this.TRI.TRI();
        }
        return 0L;
    }

    public boolean TRI() {
        return this.f27899sc;
    }

    public void Tf() {
        c cVar = this.TRI;
        if (cVar == null) {
            return;
        }
        cVar.zY();
        this.TRI = null;
    }

    public long UFX() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar.TRI();
        }
        return 0L;
    }

    public void WH() {
        try {
            if (pFF()) {
                this.TRI.sc();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF("RewardFullVideoPlayerManager onPause throw Exception :" + th2.getMessage());
        }
    }

    public void WP() {
        Tf();
    }

    public void We(boolean z11) {
        this.wjp = z11;
        if (this.TRI instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
            if (z11) {
                ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) this.TRI).pFF(this.Qj.GI().J());
            } else {
                this.Qj.GI().s(1);
                ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) this.TRI).pFF(1);
            }
        }
    }

    public boolean We() {
        c cVar = this.TRI;
        return (cVar == null || cVar.Tf() == null || !this.TRI.Tf().qr()) ? false : true;
    }

    public int Xc() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar.WH();
        }
        return 0;
    }

    public long YIK() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar.Qj();
        }
        return 0L;
    }

    public void cD() {
        c cVar = this.TRI;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.Ql.We.sc) {
            ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) cVar).kX();
        }
    }

    public void cvk() {
        try {
            if (pFF()) {
                this.ExN = true;
                BT();
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e11.getMessage());
        }
    }

    public long dE() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar.Qj();
        }
        return 0L;
    }

    public void pFF(com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        if (!Dl() || pff == null) {
            return;
        }
        pff.sc(Ol(), true);
    }

    public void pFF(boolean z11) {
        c cVar = this.TRI;
        if (cVar != null) {
            cVar.pFF(z11);
        }
    }

    public boolean pFF() {
        c cVar = this.TRI;
        return (cVar == null || cVar.Tf() == null || !this.TRI.Tf().TRI()) ? false : true;
    }

    public long qr() {
        c cVar = this.TRI;
        return cVar != null ? cVar.ExN() : this.UFX;
    }

    public com.bytedance.sdk.openadsdk.We.qr sc() {
        return this.YIK;
    }

    public void sc(int i11, int i12) {
        if (this.TRI != null) {
            com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc scVar = new com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc();
            scVar.pFF(UFX());
            scVar.zY(Sfl());
            scVar.sc(qr());
            scVar.sc(i11);
            scVar.pFF(i12);
            com.bytedance.sdk.openadsdk.We.ExN.sc.sc.We(this.TRI.Ql(), scVar);
        }
    }

    public void sc(int i11, String str) {
        this.Ql = i11;
        this.SR = str;
    }

    public void sc(long j11) {
        this.UFX = j11;
    }

    public void sc(long j11, long j12) {
        this.Tf = j11;
        pFF(j11, j12);
    }

    public void sc(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.We.qr qrVar) {
        if (this.dE) {
            return;
        }
        this.dE = true;
        this.Ol = frameLayout;
        this.YIK = qrVar;
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.Qj)) {
            this.TRI = new com.bytedance.sdk.openadsdk.core.Ql.We.sc(this.f27898qr, this.Ol, this.Qj, qrVar);
            We(this.wjp);
            com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc interfaceC0288sc = this.Sfl;
            if (interfaceC0288sc != null) {
                ((com.bytedance.sdk.openadsdk.core.Ql.We.sc) this.TRI).sc(interfaceC0288sc);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.zY zYVar = new com.bytedance.sdk.openadsdk.component.reward.zY(this.Qj, qrVar);
        this.TRI = zYVar;
        com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc interfaceC0288sc2 = this.Sfl;
        if (interfaceC0288sc2 != null) {
            zYVar.sc(interfaceC0288sc2);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.We.qr qrVar) {
        this.YIK = qrVar;
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        if (this.Xc.WH.get()) {
            return;
        }
        sc scVar = this.Xc;
        if (!scVar.yL || JPJ.zY(scVar.pFF)) {
            return;
        }
        if ((!com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.Xc.pFF) && com.bytedance.sdk.openadsdk.core.Xc.We().Ql(String.valueOf(this.Xc.TRI)) == 1 && this.Xc.cvk.We()) || com.bytedance.sdk.openadsdk.core.model.Xc.We(this.Xc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.Xc.pFF) || this.ExN || !pff.TRI()) {
            return;
        }
        this.Xc.GI.removeMessages(LogSeverity.NOTICE_VALUE);
        Message messageObtain = Message.obtain();
        messageObtain.what = LogSeverity.NOTICE_VALUE;
        this.Xc.GI.sendMessageDelayed(messageObtain, 5000L);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        try {
            this.ExN = false;
            if (TRI()) {
                OXF();
                pFF(pff);
            } else if (We()) {
                SR();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th2.getMessage());
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc interfaceC0288sc) {
        this.Sfl = interfaceC0288sc;
    }

    public void sc(String str, boolean z11) {
        if (this.TRI != null) {
            long jQr = qr();
            if (this.Qj.Chh()) {
                jQr = this.Xc.zY();
            }
            long j11 = jQr;
            JSONObject jSONObjectSc = cJ.sc(this.Qj, this.TRI.TRI(), this.TRI.Tf());
            try {
                jSONObjectSc.put("auto_click", z11);
            } catch (Exception unused) {
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(this.Qj, this.WH, str, j11, Xc(), jSONObjectSc, this.YIK);
            Sfl();
            Xc();
        }
        cD();
    }

    public void sc(c.InterfaceC0849c interfaceC0849c) {
        c cVar = this.TRI;
        if (cVar != null) {
            cVar.sc(interfaceC0849c);
        }
    }

    public void sc(boolean z11) {
        this.f27899sc = z11;
    }

    public void sc(boolean z11, com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff, boolean z12) {
        if (!z12 || z11 || this.ExN) {
            return;
        }
        if (We()) {
            SR();
        } else {
            OXF();
            pFF(pff);
        }
    }

    public boolean sc(long j11, boolean z11, Map<String, Object> map, com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        boolean zSc = false;
        if (!uEA()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.model.Xc.We(this.Xc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.Xc.pFF)) {
            return true;
        }
        if (!z11 || !JPJ()) {
            sc(pff);
        }
        try {
            zSc = sc(j11, this.Xc.f27908eo);
        } catch (Exception e11) {
            Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e11);
        }
        if (zSc && !z11) {
            this.Xc.McK.sc(map);
        }
        return zSc;
    }

    public boolean uEA() {
        return this.TRI != null;
    }

    public int wjp() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar.qr();
        }
        return 0;
    }

    public u8.a zY() {
        c cVar = this.TRI;
        if (cVar != null) {
            return cVar instanceof com.bytedance.sdk.openadsdk.component.reward.zY ? ((com.bytedance.sdk.openadsdk.component.reward.zY) cVar).wjp() : cVar.Ql();
        }
        return null;
    }

    public void zY(boolean z11) {
        this.zY = z11;
    }
}
