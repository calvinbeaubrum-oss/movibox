package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.reward.pFF.qr;
import com.bytedance.sdk.openadsdk.component.reward.sc.UFX;
import com.bytedance.sdk.openadsdk.component.reward.sc.Xc;
import com.bytedance.sdk.openadsdk.component.reward.view.Qj;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sc extends TRI implements FI.sc, com.bytedance.sdk.openadsdk.component.reward.sc.ExN.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF {
    private boolean BT;
    private final AtomicBoolean ExN;
    private int Ql;
    private boolean SR;
    private int TRI;
    protected int We;

    @Nullable
    protected com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Bundle f27637qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final FI f27638sc;
    protected com.bytedance.sdk.openadsdk.component.reward.sc.sc zY;

    public sc(pFF pff, Sfl sfl, int i11) {
        super(pff, sfl, i11);
        this.f27638sc = new FI(Looper.getMainLooper(), this);
        this.ExN = new AtomicBoolean(false);
        this.TRI = 1;
        this.Ql = 0;
        this.SR = false;
    }

    private void Cb() {
        if (this.Qj.sc() && !this.SR) {
            this.SR = true;
            sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.sc.2
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    sc scVar = sc.this;
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = scVar.zY;
                    com.bytedance.sdk.openadsdk.component.reward.sc.TRI tri = scVar2.HJN;
                    float[] fArrSc = scVar2.II.sc(scVar.TRI);
                    sc scVar3 = sc.this;
                    tri.sc(fArrSc, scVar3, scVar3.pFF);
                }
            });
        }
    }

    private void Gb() {
        this.pFF.sc(this.Tf);
        this.We = (int) this.zY.JPJ.McK();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar.otH) {
            sc(scVar.McK.ExN());
            sc(this.zY.McK.We());
        }
        zY();
        OXF();
        if (this.zY.pFF.GOt() == null || this.zY.pFF.GOt().sc() == null) {
            return;
        }
        this.zY.pFF.GOt().sc().sc(0L);
    }

    private void JPJ() {
        this.zY.JoC.sc(this.pFF);
        this.pFF.sc(this, this.f27638sc);
        this.pFF.UFX();
    }

    private void OXF() {
        if (this.Qj.sc()) {
            return;
        }
        if (JPJ.wjp(this.zY.pFF)) {
            sc(false, com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.zY);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff != null) {
            pff.sc(this.zY.BR.TRI());
            this.pFF.cvk();
        }
    }

    private boolean cD() {
        if (this.zY.WH.get() && this.zY.f27912qr) {
            return false;
        }
        if (this.Qj.sc()) {
            return this.zY.WH.get();
        }
        return true;
    }

    private void sc(Sfl sfl, Bundle bundle) {
        Activity activityWP = WP();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = new com.bytedance.sdk.openadsdk.component.reward.sc.sc(activityWP, this.f27638sc, sfl, this, 1);
        this.zY = scVar;
        scVar.otH = FI().sc();
        this.zY.mD = FI().Qj();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
        scVar2.dix = this;
        scVar2.cD = FI().wjp();
        Intent intent = activityWP.getIntent();
        com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(this.zY, intent, bundle);
        if (intent != null) {
            com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(intent, this.zY);
            sfl.sc(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.zY.fT) {
            pFF();
        }
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pffSc = qr.sc(this.zY);
        this.pFF = pffSc;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.zY;
        scVar3.kDg = pffSc;
        scVar3.kX.sc(this);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.zY;
        if (scVar4.otH) {
            scVar4.JPJ.sc(new com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc() { // from class: com.bytedance.sdk.openadsdk.activity.sc.1
                @Override // com.bytedance.sdk.openadsdk.core.Ql.We.sc.InterfaceC0288sc
                public void sc(int i11) {
                    pFF pffFI = sc.this.FI();
                    if (pffFI == null) {
                        return;
                    }
                    pffFI.sc(i11);
                }
            });
            FI().Qj().setShowSound(Sfl.ExN(sfl));
        }
        Ql.sc(this.zY);
        Objects.toString(this.pFF);
    }

    private void sc(com.bytedance.sdk.openadsdk.core.pFF.pFF pff) {
        if (pff != null) {
            HashMap map = new HashMap();
            map.put("ad_show_order", Integer.valueOf(this.Ol + 1));
            pff.sc(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void BT() {
        super.BT();
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff == null) {
            return;
        }
        pff.uEA();
    }

    public void Dl() {
        FI().sc(this, pFF(com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.pFF));
    }

    public final void ExN() {
        Message message = new Message();
        message.what = LogSeverity.WARNING_VALUE;
        if (this.Qj.xP()) {
            sc(10000);
        }
        this.f27638sc.sendMessageDelayed(message, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final void ExN(Activity activity) {
        super.ExN(activity);
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff == null) {
            return;
        }
        pff.YIK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void Ol() {
        this.zY.JPJ.HJN();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void Qj() {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff == null) {
            return;
        }
        pff.Ql();
    }

    public final void Ql() {
        this.f27638sc.removeMessages(LogSeverity.WARNING_VALUE);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void SR() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public boolean Sfl() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        return scVar != null && scVar.JPJ.FI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void TRI() {
        if (this.ExN.compareAndSet(false, true)) {
            Dl.sc("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            qr();
        }
    }

    public void Tf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void UFX() {
        if (!this.zY.SR.getAndSet(true) || JPJ.zY(this.zY.pFF)) {
            this.zY.McK.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final View WH() {
        return this.zY.JPJ.Gb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void We() {
        HJN();
        this.zY.pFF.pXW();
        this.zY.pFF.sc(true);
        if (Sfl.ExN(this.zY.pFF)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
            Sfl sfl = scVar.pFF;
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, scVar.ExN, sfl.ap());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final void We(Activity activity) {
        super.We(activity);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar == null) {
            return;
        }
        scVar.Cb.Cb();
        com.bytedance.sdk.openadsdk.utils.zY.sc(activity, this.zY.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void Xc() {
        super.Xc();
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff != null) {
            pff.JPJ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public String YIK() {
        return this.zY.QLv;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.ExN.sc
    public void dE() {
        zY zYVarExN;
        pFF pffFI = FI();
        if (pffFI == null || (zYVarExN = pffFI.ExN()) == null) {
            return;
        }
        zYVarExN.ExN();
    }

    public pFF.ExN pFF(int i11) {
        pFF.ExN exN = new pFF.ExN(i11, this.zY);
        exN.We = this.zY.f27908eo;
        return exN;
    }

    public abstract void pFF();

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final void pFF(Activity activity) {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff;
        super.pFF(activity);
        if (this.zY == null || (pff = this.pFF) == null) {
            return;
        }
        pff.Xc();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        scVar.yL = true;
        scVar.II.pFF(this.f27638sc);
        if (cD()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
            scVar2.cJ.sc(scVar2.pFF.vYl());
        }
        this.zY.BR.BT();
        this.zY.Cb.uEA();
        this.zY.WP.Ql();
        if (this.pFF.pFF()) {
            this.zY.JPJ.sc(this.pFF);
            this.zY.JPJ.sc(false, this, this.Ql != 0);
        }
        this.Ql++;
        Cb();
        Qj qj2 = this.zY.cvk;
        if (qj2 != null) {
            qj2.qr();
        }
        this.zY.II.sc(this.f27638sc);
        this.pFF.Sfl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void pFF(boolean z11) {
        UFX ufx;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar != null && (ufx = scVar.McK) != null) {
            ufx.pFF(z11);
            this.zY.McK.zY(z11);
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
        if (scVar2 != null) {
            com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = scVar2.kDg;
            if (pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) {
                ((com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) pff).pFF(z11);
            }
        }
    }

    public abstract void qr();

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final View sc() {
        return this.zY.JoC;
    }

    public void sc(float f11) {
        pFF pffFI = FI();
        if (pffFI == null) {
            return;
        }
        pffFI.sc(f11);
        if (this.BT || f11 < this.Qj.Bjf() / 100.0f) {
            return;
        }
        this.BT = true;
        TRI triOl = pffFI.Ol();
        if (triOl instanceof sc) {
            ((sc) triOl).wjp();
        }
    }

    public void sc(int i11) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void sc(Activity activity) {
        super.sc(activity);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar == null) {
            return;
        }
        scVar.II.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final void sc(Activity activity, Bundle bundle) {
        this.f27637qr = bundle;
        super.sc(activity, bundle);
        sc(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void sc(Activity activity, pFF.ExN exN) {
        super.sc(activity, exN);
        this.TRI = this.Qj.gx();
        sc(this.Qj, this.f27637qr);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar.otH && this.Ol > 0) {
            scVar.f27908eo = exN.We;
        }
        try {
            JPJ();
            Gb();
        } catch (Throwable th2) {
            Tf.sc("TTAD.AdScene", "onCreate: ", th2);
            com.bytedance.sdk.openadsdk.SR.zY.pFF();
            cvk();
        }
    }

    public abstract void sc(Bundle bundle);

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public final void sc(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff == null) {
            return;
        }
        pff.sc(message);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void sc(TRI tri, TRI tri2, pFF.ExN exN) {
        super.sc(tri, tri2, exN);
        if (tri == this && (tri2 instanceof zY)) {
            int i11 = exN.pFF;
            if (i11 == 3) {
                Xc xc2 = this.zY.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, 2);
            } else if (i11 == 6) {
                Xc xc3 = this.zY.JPJ;
                xc3.sc(!xc3.II() ? 1 : 0, !this.zY.JPJ.II() ? 1 : 0);
            } else if (i11 == 5 && !Sfl.ExN(this.zY.pFF) && exN.ExN) {
                this.zY.JPJ.sc("skip", true);
            }
            this.zY.cJ.sc(false);
            this.zY.cJ.We(false);
        }
        if (tri2.Ol != 0 || this.Ol == 0) {
            return;
        }
        this.Qj.Ol("0");
        Map<String, Object> mapEoh = this.Qj.eoh();
        if (mapEoh != null) {
            mapEoh.put(BidResponsed.KEY_PRICE, "0");
        }
    }

    public void sc(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || FI() == null) {
            return;
        }
        FI().pFF(this, pFF(7));
    }

    public void sc(boolean z11) {
    }

    public final void sc(boolean z11, int i11) {
        sc(z11, false, i11);
    }

    public final void sc(boolean z11, boolean z12, int i11) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        scVar.kX.sc(z11, z12, false, scVar.kDg, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.ExN.sc
    public void sc(boolean z11, boolean z12, boolean z13, com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff, int i11) {
        sc(z11, z12, z13, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public com.bytedance.sdk.openadsdk.component.reward.sc.sc uEA() {
        return this.zY;
    }

    public void wjp() {
        com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(CacheDirFactory.getICacheDir(this.Qj.Flm()).sc(), this.Qj);
        pffSc.sc("material_meta", this.Qj);
        pffSc.sc("ad_slot", this.Qj.Cb());
        com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new r8.a() { // from class: com.bytedance.sdk.openadsdk.activity.sc.3
            @Override // r8.b.a
            public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11) {
            }

            @Override // r8.b.a
            public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar, int i11, String str) {
            }
        });
    }

    public abstract void zY();

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void zY(Activity activity) {
        super.zY(activity);
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff == null) {
            return;
        }
        pff.Dl();
    }
}
