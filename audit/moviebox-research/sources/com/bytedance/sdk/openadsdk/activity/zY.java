package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.component.reward.pFF.qr;
import com.bytedance.sdk.openadsdk.component.reward.sc.UFX;
import com.bytedance.sdk.openadsdk.component.reward.view.Qj;
import com.bytedance.sdk.openadsdk.core.YIK;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends TRI implements FI.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF {
    private static String ExN;
    private static String Ql;
    private static String TRI;
    private static String We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static String f27642qr;
    private int BT;
    private Bundle SR;
    private String Sfl;
    private boolean Xc;
    private boolean YIK;
    private pFF.ExN dE;

    @Nullable
    protected com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final FI f27643sc;
    private String wjp;
    protected com.bytedance.sdk.openadsdk.component.reward.sc.sc zY;

    public zY(pFF pff, Sfl sfl, int i11) {
        super(pff, sfl, i11);
        this.f27643sc = new FI(Looper.getMainLooper(), this);
        this.BT = 0;
        this.YIK = true;
        sc(sfl, this.SR);
        try {
            dE();
        } catch (Throwable th2) {
            Tf.sc("TTAD.EndCardScene", "onCreate: ", th2);
            cvk();
        }
    }

    private void Dl() {
        final View viewWH = this.zY.BR.WH();
        if (viewWH != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.zY.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (zY.this.zY.Cb.cvk()) {
                        boolean zQl = zY.this.zY.OXF.Ql();
                        zY.this.zY.Cb.ExN(zQl);
                        zY.this.zY.BR.ExN(8);
                        View view2 = viewWH;
                        if (view2 instanceof com.bytedance.sdk.openadsdk.core.ExN.We) {
                            ((com.bytedance.sdk.openadsdk.core.ExN.We) view2).setImageResource(com.bytedance.sdk.component.utils.Sfl.We(zY.this.zY.f27911pc, "tt_close_btn"));
                        }
                        zY.this.zY.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 5000L);
                        if (!Sfl.zY(zY.this.zY.pFF)) {
                            return;
                        }
                        if (Sfl.zY(zY.this.zY.pFF) && zQl) {
                            return;
                        }
                    }
                    if (zY.this.zY.pFF.vzC()) {
                        if (zY.this.zY.pFF.ymG()) {
                            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = zY.this.zY;
                            if (scVar.kX != null) {
                                scVar.pFF.OXF(2);
                                if (zY.this.zY.kX.ExN()) {
                                    return;
                                }
                            }
                        } else if (zY.this.zY.pFF.Vb() == 0 && !zY.this.zY.Cb.Xc()) {
                            zY.this.zY.pFF.OXF(11);
                            if (zY.this.zY.Cb.We()) {
                                zY.this.zY.pFF.OXF(12);
                            }
                            try {
                                zY.this.zY.BR.Xc();
                                return;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    zY.this.zY.Cb.II();
                    zY.this.zY.OXF.UFX();
                    zY.this.zY.McK.TRI();
                    if (JPJ.We(zY.this.zY.pFF) && zY.this.sc(true, true)) {
                        return;
                    }
                    zY.this.cvk();
                }
            };
            viewWH.setOnClickListener(onClickListener);
            viewWH.setTag(viewWH.getId(), onClickListener);
        }
        this.zY.cJ.sc(new com.bytedance.sdk.openadsdk.component.reward.top.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.zY.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void We(View view) {
                View view2 = viewWH;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void pFF(View view) {
                com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = zY.this.pFF;
                if (pff != null && pff.We() != null) {
                    zY.this.pFF.We().sc(zY.this.zY.f27908eo);
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = zY.this.zY;
                scVar.f27908eo = !scVar.f27908eo;
                StringBuilder sb2 = new StringBuilder("will set is Mute ");
                sb2.append(zY.this.zY.f27908eo);
                sb2.append(" mLastVolume=");
                sb2.append(zY.this.zY.cD.sc());
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = zY.this.zY;
                scVar2.JPJ.pFF(scVar2.f27908eo);
                if (!JPJ.Sfl(zY.this.zY.pFF) || zY.this.zY.WH.get()) {
                    if (JPJ.qr(zY.this.zY.pFF)) {
                        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = zY.this.zY;
                        scVar3.cD.sc(scVar3.f27908eo, true);
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = zY.this.zY;
                    scVar4.Cb.We(scVar4.f27908eo);
                    Sfl sfl = zY.this.zY.pFF;
                    if (sfl != null && sfl.GOt() != null && zY.this.zY.pFF.GOt().sc() != null) {
                        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = zY.this.zY;
                        if (scVar5.JPJ != null) {
                            if (scVar5.f27908eo) {
                                scVar5.pFF.GOt().sc().Qj(zY.this.zY.JPJ.qr());
                            } else {
                                scVar5.pFF.GOt().sc().Ol(zY.this.zY.JPJ.qr());
                            }
                        }
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar6 = zY.this.zY;
                    scVar6.WP.TRI(scVar6.f27908eo);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void sc(View view) {
                zY zYVar = zY.this;
                if (zYVar.sc(JPJ.zY(zYVar.zY.pFF), false)) {
                    return;
                }
                if (JPJ.ExN(zY.this.zY.pFF)) {
                    if (JPJ.WH(zY.this.zY.pFF)) {
                        zY.this.zY.WP.Xc();
                        return;
                    }
                    View view2 = viewWH;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        zY.this.cvk();
                        return;
                    }
                }
                if (JPJ.Qj(zY.this.zY.pFF)) {
                    if (zY.this.zY.WP.sc()) {
                        zY.this.zY.WP.sc(5);
                        return;
                    } else {
                        zY.this.zY.Cb.Qj();
                        return;
                    }
                }
                if (!JPJ.wjp(zY.this.zY.pFF) && (!Xc.sc(zY.this.zY.pFF) || zY.this.zY.dE.get())) {
                    zY.this.cvk();
                    return;
                }
                if (!JPJ.Qj(zY.this.zY.pFF) && zY.this.zY.WP.sc()) {
                    zY.this.zY.WP.sc(4);
                }
                zY.this.cvk();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void zY(View view) {
                zY zYVar = zY.this;
                zYVar.zY.Gb.sc(zYVar.pFF);
            }
        });
    }

    private JSONObject Gb() {
        JSONObject jSONObject = new JSONObject();
        int iYIK = (int) this.zY.JPJ.YIK();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.zY.pFF.Dl());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.zY.pFF.uEA());
            jSONObject.put("network", BT.zY(this.zY.f27911pc));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iBR = this.zY.pFF.BR();
            String strZY = "unKnow";
            if (iBR == 2) {
                strZY = cJ.pFF();
            } else if (iBR == 1) {
                strZY = cJ.zY();
            }
            jSONObject.put("user_agent", strZY);
            jSONObject.put("extra", this.zY.pFF.jxU());
            jSONObject.put("media_extra", this.Sfl);
            jSONObject.put("video_duration", this.zY.pFF.GI().m());
            jSONObject.put("play_start_ts", 0);
            jSONObject.put("play_end_ts", 0);
            jSONObject.put("duration", iYIK);
            jSONObject.put("user_id", this.wjp);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.utils.JPJ.sc().replace("-", ""));
            return jSONObject;
        } catch (Throwable th2) {
            Tf.sc("TTAD.EndCardScene", "", th2);
            return null;
        }
    }

    private boolean JPJ() {
        if (this.zY.WH.get() && this.zY.f27912qr) {
            return false;
        }
        if (this.Qj.sc()) {
            return this.zY.WH.get();
        }
        return true;
    }

    private void dE() {
        this.zY.JoC.sc(this.pFF);
        this.pFF.sc(this, this.f27643sc);
        this.pFF.UFX();
    }

    private void sc(Sfl sfl, Bundle bundle) {
        Activity activityWP = WP();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = new com.bytedance.sdk.openadsdk.component.reward.sc.sc(activityWP, this.f27643sc, sfl, this, 2);
        this.zY = scVar;
        scVar.otH = FI().sc();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
        scVar2.dix = this;
        scVar2.cD = FI().wjp();
        com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(this.zY, activityWP.getIntent(), bundle);
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pffSc = qr.sc(this.zY);
        this.pFF = pffSc;
        this.zY.kDg = pffSc;
        Objects.toString(this.pFF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(final boolean z11, boolean z12) {
        if (!this.zY.We || FI().WH().getBoolean("reward_verify", false) || FI().SR()) {
            return false;
        }
        if (!z12 && FI().WH().getBoolean("user_has_give_up_reward", false)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.Xc.We().Qj(String.valueOf(this.zY.TRI))) {
            if (!z12) {
                return false;
            }
            if (z11) {
                cvk();
                return true;
            }
        }
        this.zY.YIK.set(true);
        if (z11) {
            this.zY.WP.SR();
        }
        final com.bytedance.sdk.openadsdk.core.widget.pFF pff = new com.bytedance.sdk.openadsdk.core.widget.pFF(this.zY.CYO);
        this.pFF.Ql = pff;
        if (z11) {
            pff.sc(We).pFF(ExN).zY(TRI);
        } else {
            pff.sc(f27642qr).pFF(Ql).zY(TRI);
        }
        this.pFF.Ql.sc(new com.bytedance.sdk.openadsdk.core.widget.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.activity.zY.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.pFF.sc
            public void pFF() {
                pff.dismiss();
                zY.this.FI().WH().putBoolean("user_has_give_up_reward", true);
                zY.this.zY.YIK.set(false);
                zY.this.zY.WP.TRI(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                if (z11) {
                    if (JPJ.Qj(zY.this.zY.pFF)) {
                        if (zY.this.zY.WP.sc()) {
                            zY.this.zY.WP.sc(5);
                            return;
                        } else {
                            zY.this.zY.Cb.Qj();
                            return;
                        }
                    }
                    zY.this.zY.McK.TRI();
                    if (zY.this.zY.WP.sc()) {
                        zY.this.zY.WP.sc(4);
                    }
                    zY.this.cvk();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pFF.sc
            public void sc() {
                if (z11) {
                    zY.this.zY.WP.ExN(1000);
                }
                pff.dismiss();
                zY.this.zY.YIK.set(false);
            }
        }).show();
        return true;
    }

    private void wjp() {
        if (this.Xc) {
            return;
        }
        this.Xc = true;
        this.pFF.sc(this.Tf);
        Dl();
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

    public void ExN() {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
        if (pff == null) {
            return;
        }
        pff.II();
        this.zY.kX.pFF();
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
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void Qj() {
        if (FI() == null) {
            return;
        }
        this.zY.kX.sc(this.dE.f27632sc.getBoolean("isSkip", false), this.dE.f27632sc.getBoolean("force", false), this.dE.f27632sc.getBoolean("isFromLandingPage", false), this.pFF, this.dE.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void SR() {
        boolean z11 = (1.0f - (this.zY.WP.pFF() / ((float) this.zY.pFF.ds()))) * 100.0f >= ((float) com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.zY.TRI)).TRI);
        int iSc = com.bytedance.sdk.openadsdk.core.Xc.We().sc(String.valueOf(this.zY.TRI));
        if (iSc == 0) {
            boolean zExN = this.zY.WP.zY() ? true : this.zY.Cb.Tf().ExN();
            if (!z11 || !zExN) {
                return;
            }
        } else if (iSc != 1 || !z11) {
            return;
        }
        zY();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public boolean Sfl() {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        return scVar != null && scVar.JPJ.FI();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void TRI() {
        McK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void Tf() {
        zY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void UFX() {
        if (!this.zY.SR.getAndSet(true) || JPJ.wjp(this.zY.pFF)) {
            this.zY.McK.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final View WH() {
        return null;
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

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public boolean a_() {
        return this.zY.We;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public String b_() {
        return this.zY.ExN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void c_() {
        HJN();
    }

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
        scVar.II.pFF(this.f27643sc);
        if (JPJ()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
            scVar2.cJ.sc(scVar2.pFF.vYl());
        }
        this.zY.BR.BT();
        this.zY.Cb.uEA();
        this.zY.WP.Ql();
        if (this.pFF.pFF()) {
            this.zY.JPJ.sc(this.pFF);
            this.zY.JPJ.sc(false, this, this.BT != 0);
        }
        this.BT++;
        Qj qj2 = this.zY.cvk;
        if (qj2 != null) {
            qj2.qr();
        }
        this.zY.II.sc(this.f27643sc);
        this.pFF.Sfl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void pFF(boolean z11) {
        UFX ufx;
        long j11 = this.YIK ? this.zY.YdT : 0L;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar != null && (ufx = scVar.McK) != null) {
            ufx.pFF(z11);
            this.zY.McK.zY(z11);
            if (z11 && j11 > 0) {
                this.zY.YdT = j11;
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
        if (scVar2 != null) {
            com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = scVar2.kDg;
            if (pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) {
                ((com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) pff).pFF(z11);
            }
        }
        if (z11) {
            this.YIK = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final View sc() {
        return this.zY.JoC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(int i11) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public final void sc(Activity activity, Bundle bundle) {
        this.SR = bundle;
        super.sc(activity, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public void sc(Activity activity, pFF.ExN exN) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar;
        super.sc(activity, exN);
        this.dE = exN;
        Intent intent = activity.getIntent();
        this.Sfl = intent.getStringExtra("media_extra");
        this.wjp = intent.getStringExtra("user_id");
        try {
            if (f27642qr == null) {
                f27642qr = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_reward_msg");
                We = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_msgPlayable");
                TRI = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_negtiveBtnBtnText");
                Ql = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_postiveBtnText");
                ExN = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th2) {
            Tf.sc("TTAD.EndCardScene", th2.getMessage());
        }
        if (exN != null && (scVar = exN.zY) != null) {
            this.zY.Ql.set(scVar.Ql.get());
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
            scVar2.YdT = scVar.YdT;
            scVar2.SR.set(scVar.SR.get());
            this.zY.JPJ.sc(scVar.JPJ.sc());
        }
        wjp();
        Qj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(Bundle bundle) {
    }

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
        if (tri != null || tri2 == this) {
            return;
        }
        if (JPJ.qr(this.zY.pFF) || com.bytedance.sdk.openadsdk.YIK.sc.sc("ivrv_new_arch_endcard_view_add_at_first", 0) == 1) {
            FI().sc(sc());
        }
        wjp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(boolean z11) {
        if (z11) {
            zY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public boolean sc(long j11, boolean z11) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public com.bytedance.sdk.openadsdk.component.reward.sc.sc uEA() {
        return this.zY;
    }

    public void zY() {
        if (FI().WH().getBoolean("reward_verify", false) || FI().SR()) {
            return;
        }
        FI().WH().putBoolean("reward_verify", true);
        if (com.bytedance.sdk.openadsdk.core.Xc.We().dE(String.valueOf(this.zY.TRI))) {
            sc(true, this.zY.pFF.uEA(), this.zY.pFF.Dl(), 0, "");
        } else {
            com.bytedance.sdk.openadsdk.core.Xc.zY().sc(Gb(), new com.bytedance.sdk.openadsdk.core.Sfl.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.zY.3
                @Override // com.bytedance.sdk.openadsdk.core.Sfl.pFF
                public void sc(int i11, String str) {
                    zY.this.sc(false, 0, "", i11, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.Sfl.pFF
                public void sc(YIK.pFF pff) {
                    zY.this.sc(pff.pFF, pff.zY.sc(), pff.zY.pFF(), 0, "");
                }
            });
        }
    }

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
