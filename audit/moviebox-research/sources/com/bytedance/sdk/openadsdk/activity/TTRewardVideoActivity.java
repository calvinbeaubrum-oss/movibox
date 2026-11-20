package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.JPJ;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.YIK;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String BT;
    private static com.bytedance.sdk.openadsdk.sc.ExN.sc Dl;
    private static String SR;
    private static String Xc;
    private static String dE;
    private static String wjp;
    private boolean FI;
    protected com.bytedance.sdk.openadsdk.sc.ExN.sc Ql;
    private String Sfl;
    protected int Tf;
    protected int UFX;
    private String YIK;
    private final AtomicBoolean uEA = new AtomicBoolean(false);
    private int JPJ = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl() {
        Dl.sc("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Ql;
        if (scVar != null) {
            scVar.onAdClicked();
        }
    }

    private void JPJ() {
        if (this.Qj) {
            return;
        }
        this.Qj = true;
        Dl.sc("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Ql;
        if (scVar != null) {
            scVar.pFF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0096  */
    public void YIK() {
        com.bytedance.sdk.openadsdk.component.reward.view.pFF pffSc;
        BT.sc scVar = new BT.sc();
        scVar.sc(this.pFF.JPJ.qr());
        scVar.zY(this.pFF.JPJ.Sfl());
        scVar.pFF(this.pFF.JPJ.UFX());
        scVar.zY(3);
        scVar.We(this.pFF.JPJ.wjp());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.pFF.JPJ.zY(), scVar, this.pFF.JPJ.sc());
        JPJ.zY(this.pFF.TRI);
        this.pFF.JPJ.sc("skip", false);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
        if (scVar2.zY) {
            if (Xc.zY(scVar2.pFF) && (pffSc = this.pFF.cvk.sc()) != null && pffSc.We == 0) {
                finish();
            } else {
                sc(true, 4);
            }
            if (Xc.sc(this.pFF.pFF) && !this.pFF.dE.get()) {
                finish();
            }
        } else {
            finish();
        }
        com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = this.pFF.pFF.GOt();
        if (scVarGOt != null) {
            com.bytedance.sdk.openadsdk.core.Tf.We weSc = scVarGOt.sc();
            long jQr = this.pFF.JPJ.qr();
            weSc.TRI(jQr);
            weSc.ExN(jQr);
        }
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.pFF.pFF, 5);
    }

    private void sc(final String str, final boolean z11, final int i11, final String str2, final int i12, final String str3) {
        Cb.zY(new Qj("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.pFF(0).executeRewardVideoCallback(TTRewardVideoActivity.this.pFF.QLv, str, z11, i11, str2, i12, str3);
                } catch (Throwable th2) {
                    Tf.sc("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final boolean z11, final int i11, final String str, final int i12, final String str2) {
        Dl.sc("BVA", "invoke callback onRewardVerify: " + z11 + ", " + i11 + ", " + str + ", " + i12 + ", " + str2 + "; " + this);
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onRewardVerify", z11, i11, str, i12, str2);
        } else {
            this.We.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = TTRewardVideoActivity.this.Ql;
                    if (scVar != null) {
                        scVar.sc(z11, i11, str, i12, str2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final boolean z11, boolean z12) {
        if (!z12 && this.FI && this.pFF.WH.get()) {
            if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(this.pFF.pFF)) {
                this.pFF.Cb.Qj();
                return;
            } else if (com.bytedance.sdk.openadsdk.core.model.JPJ.WH(this.pFF.pFF)) {
                this.pFF.WP.Xc();
                return;
            }
        }
        if (!com.bytedance.sdk.openadsdk.core.Xc.We().Qj(String.valueOf(this.pFF.TRI))) {
            if (!z12 && this.pFF.WH.get()) {
                if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(this.pFF.pFF)) {
                    this.pFF.Cb.Qj();
                    return;
                } else if (com.bytedance.sdk.openadsdk.core.model.JPJ.WH(this.pFF.pFF)) {
                    this.pFF.WP.Xc();
                    return;
                }
            }
            if (z11) {
                finish();
                return;
            } else {
                YIK();
                return;
            }
        }
        if (this.uEA.get()) {
            if (this.pFF.WH.get()) {
                if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(this.pFF.pFF)) {
                    this.pFF.Cb.Qj();
                    return;
                } else if (com.bytedance.sdk.openadsdk.core.model.JPJ.WH(this.pFF.pFF)) {
                    this.pFF.WP.Xc();
                    return;
                }
            }
            if (z11) {
                finish();
                return;
            } else {
                YIK();
                return;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(this.pFF.pFF) && this.pFF.Cb.UFX().getVisibility() == 0) {
            this.pFF.Cb.Qj();
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.model.JPJ.WH(this.pFF.pFF) && this.pFF.Cb.WH().getVisibility() == 0) {
            this.pFF.WP.Xc();
            return;
        }
        this.pFF.YIK.set(true);
        this.pFF.JPJ.BT();
        if (z11) {
            this.pFF.WP.SR();
        }
        final com.bytedance.sdk.openadsdk.core.widget.pFF pff = new com.bytedance.sdk.openadsdk.core.widget.pFF(this);
        this.zY.Ql = pff;
        if (z11) {
            pff.sc(BT).pFF(wjp).zY(dE);
        } else {
            pff.sc(SR).pFF(Xc).zY(dE);
        }
        this.zY.Ql.sc(new com.bytedance.sdk.openadsdk.core.widget.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.pFF.sc
            public void pFF() {
                pff.dismiss();
                TTRewardVideoActivity.this.FI = true;
                TTRewardVideoActivity.this.pFF.YIK.set(false);
                TTRewardVideoActivity.this.pFF.WP.TRI(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                if (z11) {
                    if (com.bytedance.sdk.openadsdk.core.model.JPJ.wjp(TTRewardVideoActivity.this.pFF.pFF)) {
                        if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(TTRewardVideoActivity.this.pFF.pFF)) {
                            if (TTRewardVideoActivity.this.pFF.WP.sc()) {
                                TTRewardVideoActivity.this.pFF.WP.sc(5);
                                return;
                            } else {
                                TTRewardVideoActivity.this.pFF.Cb.Qj();
                                return;
                            }
                        }
                        TTRewardVideoActivity.this.pFF.McK.TRI();
                        if (TTRewardVideoActivity.this.pFF.WP.sc()) {
                            TTRewardVideoActivity.this.pFF.WP.sc(4);
                        }
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    if (com.bytedance.sdk.openadsdk.core.model.JPJ.TRI(TTRewardVideoActivity.this.pFF.pFF)) {
                        if (com.bytedance.sdk.openadsdk.core.model.JPJ.WH(TTRewardVideoActivity.this.pFF.pFF)) {
                            TTRewardVideoActivity.this.pFF.WP.Xc();
                            return;
                        } else {
                            TTRewardVideoActivity.this.pFF.McK.TRI();
                            TTRewardVideoActivity.this.finish();
                            return;
                        }
                    }
                }
                TTRewardVideoActivity.this.YIK();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pFF.sc
            public void sc() {
                TTRewardVideoActivity.this.pFF.JPJ.SR();
                if (z11) {
                    TTRewardVideoActivity.this.pFF.WP.ExN(1000);
                }
                pff.dismiss();
                TTRewardVideoActivity.this.pFF.YIK.set(false);
            }
        }).show();
    }

    private JSONObject uEA() {
        JSONObject jSONObject = new JSONObject();
        int iYIK = (int) this.pFF.JPJ.YIK();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.pFF.pFF.Dl());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.pFF.pFF.uEA());
            jSONObject.put("network", com.bytedance.sdk.component.utils.BT.zY(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int iBR = this.pFF.pFF.BR();
            String strZY = "unKnow";
            if (iBR == 2) {
                strZY = cJ.pFF();
            } else if (iBR == 1) {
                strZY = cJ.zY();
            }
            jSONObject.put("user_agent", strZY);
            jSONObject.put("extra", this.pFF.pFF.jxU());
            jSONObject.put("media_extra", this.Sfl);
            jSONObject.put("video_duration", this.pFF.pFF.GI().m());
            jSONObject.put("play_start_ts", this.UFX);
            jSONObject.put("play_end_ts", this.Tf);
            jSONObject.put("duration", iYIK);
            jSONObject.put("user_id", this.YIK);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.utils.JPJ.sc().replace("-", ""));
            return jSONObject;
        } catch (Throwable th2) {
            Tf.sc("TTAD.RVA", "", th2);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void ExN() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.sc.ExN.sc scVar = this.Ql;
            if (scVar != null) {
                scVar.sc();
            }
        }
        if (wjp()) {
            this.pFF.cvk.WH();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void SR() {
        int i11 = com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.pFF.TRI)).TRI;
        if (com.bytedance.sdk.openadsdk.core.model.JPJ.Sfl(this.pFF.pFF)) {
            if ((1.0d - (((double) this.TRI) / this.pFF.JPJ.McK())) * 100.0d < i11) {
                return;
            }
        } else {
            boolean z11 = (1.0f - (this.pFF.WP.pFF() / ((float) this.pFF.pFF.ds()))) * 100.0f >= ((float) i11);
            int iSc = com.bytedance.sdk.openadsdk.core.Xc.We().sc(String.valueOf(this.pFF.TRI));
            if (iSc == 0) {
                boolean zExN = this.pFF.WP.zY() ? true : this.pFF.Cb.Tf().ExN();
                if (!z11 || !zExN) {
                    return;
                }
            } else if (iSc != 1 || !z11) {
                return;
            }
        }
        Sfl();
    }

    public void Sfl() {
        if (this.uEA.get()) {
            return;
        }
        this.uEA.set(true);
        if (com.bytedance.sdk.openadsdk.core.Xc.We().dE(String.valueOf(this.pFF.TRI))) {
            sc(true, this.pFF.pFF.uEA(), this.pFF.pFF.Dl(), 0, "");
        } else {
            com.bytedance.sdk.openadsdk.core.Xc.zY().sc(uEA(), new Sfl.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.8
                @Override // com.bytedance.sdk.openadsdk.core.Sfl.pFF
                public void sc(int i11, String str) {
                    TTRewardVideoActivity.this.sc(false, 0, "", i11, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.Sfl.pFF
                public void sc(YIK.pFF pff) {
                    boolean z11 = pff.pFF;
                    TTRewardVideoActivity.this.sc(pff.pFF, pff.zY.sc(), pff.zY.pFF(), 0, "");
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void Tf() {
        Sfl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void We() {
        Dl();
        this.pFF.pFF.pXW();
        this.pFF.pFF.sc(true);
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.pFF.pFF)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.pFF;
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, scVar.ExN, sfl.ap());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean Xc() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void c_() {
        Dl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void dE() {
        final View viewWH = this.pFF.BR.WH();
        if (viewWH != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTRewardVideoActivity.this.pFF.Cb.cvk() && TTRewardVideoActivity.this.pFF.WH.get()) {
                        boolean zQl = TTRewardVideoActivity.this.pFF.OXF.Ql();
                        TTRewardVideoActivity.this.pFF.Cb.ExN(zQl);
                        TTRewardVideoActivity.this.pFF.BR.ExN(8);
                        View view2 = viewWH;
                        if (view2 instanceof com.bytedance.sdk.openadsdk.core.ExN.We) {
                            ((com.bytedance.sdk.openadsdk.core.ExN.We) view2).setImageResource(com.bytedance.sdk.component.utils.Sfl.We(TTRewardVideoActivity.this.pFF.f27911pc, "tt_close_btn"));
                        }
                        TTRewardVideoActivity.this.pFF.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 5000L);
                        if (!com.bytedance.sdk.openadsdk.core.model.Sfl.zY(TTRewardVideoActivity.this.pFF.pFF)) {
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(TTRewardVideoActivity.this.pFF.pFF) && zQl) {
                            return;
                        }
                    }
                    if (TTRewardVideoActivity.this.pFF.pFF.vzC()) {
                        if (TTRewardVideoActivity.this.pFF.pFF.ymG()) {
                            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = TTRewardVideoActivity.this.pFF;
                            if (scVar.kX != null) {
                                scVar.pFF.OXF(2);
                                if (TTRewardVideoActivity.this.pFF.kX.ExN()) {
                                    return;
                                }
                            }
                        } else if (TTRewardVideoActivity.this.pFF.pFF.Vb() == 0 && !TTRewardVideoActivity.this.pFF.Cb.Xc()) {
                            TTRewardVideoActivity.this.pFF.pFF.OXF(11);
                            if (TTRewardVideoActivity.this.pFF.Cb.We()) {
                                TTRewardVideoActivity.this.pFF.pFF.OXF(12);
                            }
                            try {
                                TTRewardVideoActivity.this.pFF.BR.Xc();
                                return;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    TTRewardVideoActivity.this.pFF.Cb.II();
                    TTRewardVideoActivity.this.pFF.OXF.UFX();
                    TTRewardVideoActivity.this.pFF.McK.TRI();
                    if (com.bytedance.sdk.openadsdk.core.model.JPJ.We(TTRewardVideoActivity.this.pFF.pFF)) {
                        TTRewardVideoActivity.this.sc(true, true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            };
            viewWH.setOnClickListener(onClickListener);
            viewWH.setTag(viewWH.getId(), onClickListener);
        }
        this.pFF.cJ.sc(new com.bytedance.sdk.openadsdk.component.reward.top.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void We(View view) {
                View view2 = viewWH;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void pFF(View view) {
                com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = TTRewardVideoActivity.this.zY;
                if (pff != null && pff.We() != null) {
                    TTRewardVideoActivity.this.zY.We().sc(TTRewardVideoActivity.this.pFF.f27908eo);
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = TTRewardVideoActivity.this.pFF;
                scVar.f27908eo = !scVar.f27908eo;
                StringBuilder sb2 = new StringBuilder("will set is Mute ");
                sb2.append(TTRewardVideoActivity.this.pFF.f27908eo);
                sb2.append(" mLastVolume=");
                sb2.append(TTRewardVideoActivity.this.pFF.cD.sc());
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTRewardVideoActivity.this.pFF;
                scVar2.JPJ.pFF(scVar2.f27908eo);
                if (!com.bytedance.sdk.openadsdk.core.model.JPJ.Sfl(TTRewardVideoActivity.this.pFF.pFF) || TTRewardVideoActivity.this.pFF.WH.get()) {
                    if (com.bytedance.sdk.openadsdk.core.model.JPJ.qr(TTRewardVideoActivity.this.pFF.pFF)) {
                        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = TTRewardVideoActivity.this.pFF;
                        scVar3.cD.sc(scVar3.f27908eo, true);
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = TTRewardVideoActivity.this.pFF;
                    scVar4.Cb.We(scVar4.f27908eo);
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = TTRewardVideoActivity.this.pFF;
                    scVar5.WP.TRI(scVar5.f27908eo);
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl = TTRewardVideoActivity.this.pFF.pFF;
                    if (sfl == null || sfl.GOt() == null || TTRewardVideoActivity.this.pFF.pFF.GOt().sc() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar6 = TTRewardVideoActivity.this.pFF;
                    if (scVar6.JPJ != null) {
                        if (scVar6.f27908eo) {
                            scVar6.pFF.GOt().sc().Qj(TTRewardVideoActivity.this.pFF.JPJ.qr());
                        } else {
                            scVar6.pFF.GOt().sc().Ol(TTRewardVideoActivity.this.pFF.JPJ.qr());
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void sc(View view) {
                if (TTRewardVideoActivity.this.pFF.pFF.uoi()) {
                    if (TTRewardVideoActivity.this.pFF.BR.UFX() != null) {
                        TTRewardVideoActivity.this.pFF.pFF.OXF(2);
                        TTRewardVideoActivity.this.pFF.BR.Xc();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = TTRewardVideoActivity.this.pFF;
                if (!scVar.zY && scVar.pFF.vzC() && !TTRewardVideoActivity.this.pFF.pFF.ymG()) {
                    TTRewardVideoActivity.this.pFF.pFF.OXF(13);
                    try {
                        TTRewardVideoActivity.this.pFF.BR.Xc();
                        return;
                    } catch (Exception unused) {
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.sc(com.bytedance.sdk.openadsdk.core.model.JPJ.zY(tTRewardVideoActivity.pFF.pFF), false);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void zY(View view) {
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.pFF.Gb.sc(tTRewardVideoActivity.zY);
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        Dl = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.pFF != null) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("videoForceBreak", this.pFF.pFF);
        }
        JPJ();
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        super.onCreate(bundle);
        try {
            if (SR == null) {
                SR = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_reward_msg");
                BT = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_msgPlayable");
                dE = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_negtiveBtnBtnText");
                Xc = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_postiveBtnText");
                wjp = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th2) {
            Tf.sc("TTAD.RVA", th2.getMessage());
        }
        if (bundle == null || (scVar = this.pFF) == null || (sfl = scVar.pFF) == null || !sfl.IE()) {
            return;
        }
        this.uEA.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        JPJ();
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("recycleRes");
        }
        this.Ql = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.view.pFF pffSc;
        super.onResume();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null || (pffSc = scVar.cvk.sc()) == null) {
            return;
        }
        pffSc.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
            public void sc() {
                TTRewardVideoActivity.this.Dl();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Dl = this.Ql;
        if (this.uEA.get() && (scVar = this.pFF) != null) {
            scVar.pFF.zu();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void sc() {
        this.pFF.cJ.sc(null, TTAdDislikeToast.getSkipText());
        this.pFF.cJ.ExN(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(int i11) {
        if (i11 == 10000) {
            Sfl();
        }
    }

    public void sc(long j11, long j12) {
        long j13 = j11 + (((long) this.pFF.Yhz) * 1000);
        if (this.JPJ == -1) {
            this.JPJ = com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.pFF.TRI)).TRI;
        }
        if (j12 <= 0) {
            return;
        }
        if (j12 >= 30000 && j13 >= 27000) {
            Sfl();
        } else if ((j13 * 100) / j12 >= this.JPJ) {
            Sfl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void sc(@NonNull Intent intent) {
        super.sc(intent);
        this.Sfl = intent.getStringExtra("media_extra");
        this.YIK = intent.getStringExtra("user_id");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            this.Ql = FI.sc().zY();
        }
        if (this.Ql != null || bundle == null) {
            return;
        }
        this.Ql = Dl;
        Dl = null;
    }

    public void sc(String str) {
        sc(str, false, 0, "", 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(boolean z11) {
        if (z11) {
            Sfl();
            return;
        }
        if ((1.0d - (((double) this.TRI) / this.pFF.JPJ.McK())) * 100.0d >= com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.pFF.TRI)).TRI) {
            Sfl();
        }
    }

    public boolean sc(long j11, boolean z11) {
        qr qrVar = new qr();
        qrVar.sc(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        scVar.JPJ.sc(scVar.BR.TRI(), qrVar);
        c.InterfaceC0849c interfaceC0849c = new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            boolean f27576sc;

            @Override // t8.c.InterfaceC0849c
            public void pFF(long j12, int i11) {
                TTRewardVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (TTRewardVideoActivity.this.pFF.JPJ.pFF()) {
                    TTRewardVideoActivity.this.Ql();
                    return;
                }
                TTRewardVideoActivity.this.pFF.JPJ.Ql();
                TTRewardVideoActivity.this.Sfl();
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity.pFF.zY) {
                    tTRewardVideoActivity.sc(false, true, 3);
                } else {
                    tTRewardVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = TTRewardVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, 2);
            }

            @Override // t8.c.InterfaceC0849c
            public void sc() {
                TTRewardVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTRewardVideoActivity.this.BT();
                TTRewardVideoActivity.this.Sfl();
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity.pFF.zY) {
                    tTRewardVideoActivity.sc(false, true, 6);
                } else {
                    tTRewardVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = TTRewardVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, 1 ^ (TTRewardVideoActivity.this.pFF.JPJ.II() ? 1 : 0));
                TTRewardVideoActivity.this.pFF.JPJ.Ql();
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, int i11) {
                com.bytedance.sdk.openadsdk.utils.Tf tf2;
                if (this.f27576sc) {
                    return;
                }
                this.f27576sc = true;
                TTRewardVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTRewardVideoActivity.this.BT();
                TTRewardVideoActivity.this.Sfl();
                TTRewardVideoActivity.this.pFF.JPJ.sc(j12, j12);
                TTRewardVideoActivity.this.pFF.Sfl.set(true);
                if (TTRewardVideoActivity.this.pFF.pFF.Xc() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTRewardVideoActivity.this.pFF;
                    if (scVar2.zY) {
                        scVar2.FI.zY().We();
                        Ql.pFF();
                    }
                }
                if (TTRewardVideoActivity.this.pFF.pFF.wdI()) {
                    TTRewardVideoActivity.this.pFF.pFF.OXF(1);
                    TTRewardVideoActivity.this.pFF.BR.Xc();
                }
                if (TTRewardVideoActivity.this.pFF.pFF.Xc() == 21 && !TTRewardVideoActivity.this.pFF.pFF.We()) {
                    TTRewardVideoActivity.this.pFF.pFF.pFF(true);
                    TTRewardVideoActivity.this.pFF.BR.Xc();
                }
                TTRewardVideoActivity.this.Tf = (int) (System.currentTimeMillis() / 1000);
                if (Xc.We(TTRewardVideoActivity.this.pFF.pFF) || Xc.pFF(TTRewardVideoActivity.this.pFF.pFF) || Xc.ExN(TTRewardVideoActivity.this.pFF.pFF)) {
                    TTRewardVideoActivity.this.sc(false, 5);
                    if (!Xc.pFF(TTRewardVideoActivity.this.pFF.pFF) || (tf2 = TTRewardVideoActivity.this.pFF.NP) == null) {
                        return;
                    }
                    tf2.sc(0L);
                    return;
                }
                if (Xc.sc(TTRewardVideoActivity.this.pFF.pFF) && !TTRewardVideoActivity.this.pFF.dE.get()) {
                    TTRewardVideoActivity.this.pFF.sc(true);
                    TTRewardVideoActivity.this.pFF.cJ.ExN(true);
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = TTRewardVideoActivity.this.pFF;
                if (!scVar3.zY) {
                    if (scVar3.pFF.Chh()) {
                        TTRewardVideoActivity.this.pFF.cJ.zY();
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(TTRewardVideoActivity.this.pFF.pFF)) {
                        TTRewardVideoActivity.this.pFF.JPJ.sc("skip", true);
                    }
                    TTRewardVideoActivity.this.finish();
                    return;
                }
                if (scVar3.pFF.Chh()) {
                    TTRewardVideoActivity.this.pFF.cJ.zY();
                    return;
                }
                TTRewardVideoActivity.this.sc(false, 5);
                if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(TTRewardVideoActivity.this.pFF.pFF)) {
                    return;
                }
                TTRewardVideoActivity.this.pFF.JPJ.sc("skip", true);
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTRewardVideoActivity.this.pFF;
                if (!scVar2.yL && scVar2.JPJ.pFF()) {
                    TTRewardVideoActivity.this.pFF.JPJ.BT();
                }
                if (TTRewardVideoActivity.this.pFF.WH.get()) {
                    return;
                }
                TTRewardVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (j12 != TTRewardVideoActivity.this.pFF.JPJ.Qj()) {
                    TTRewardVideoActivity.this.BT();
                }
                TTRewardVideoActivity.this.pFF.JPJ.sc(j12, j13);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j14 = j12 / 1000;
                double d11 = j14;
                tTRewardVideoActivity.TRI = (int) (tTRewardVideoActivity.pFF.JPJ.McK() - d11);
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                int i11 = tTRewardVideoActivity2.TRI;
                if (i11 >= 0) {
                    tTRewardVideoActivity2.pFF.cJ.sc(String.valueOf(i11), null);
                }
                TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                tTRewardVideoActivity3.TRI = (int) (tTRewardVideoActivity3.pFF.JPJ.McK() - d11);
                int i12 = (int) j14;
                int iWH = com.bytedance.sdk.openadsdk.core.Xc.We().WH(String.valueOf(TTRewardVideoActivity.this.pFF.TRI));
                boolean z12 = iWH >= 0;
                if ((TTRewardVideoActivity.this.pFF.YIK.get() || TTRewardVideoActivity.this.pFF.UFX.get()) && TTRewardVideoActivity.this.pFF.JPJ.pFF()) {
                    TTRewardVideoActivity.this.pFF.JPJ.BT();
                }
                TTRewardVideoActivity.this.pFF.BR.We(i12);
                TTRewardVideoActivity.this.sc(j12, j13);
                TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity4.TRI > 0) {
                    tTRewardVideoActivity4.pFF.cJ.We(true);
                    if (!z12 || i12 < iWH) {
                        TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity5.pFF.cJ.sc(String.valueOf(tTRewardVideoActivity5.TRI), null);
                    } else {
                        TTRewardVideoActivity.this.pFF.sc(true);
                        TTRewardVideoActivity tTRewardVideoActivity6 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity6.pFF.cJ.sc(String.valueOf(tTRewardVideoActivity6.TRI), TTAdDislikeToast.getSkipText());
                        TTRewardVideoActivity.this.pFF.cJ.ExN(true);
                    }
                }
            }
        };
        this.pFF.JPJ.sc(interfaceC0849c);
        Xc xc2 = this.pFF.BR.BT;
        if (xc2 != null) {
            xc2.sc(interfaceC0849c);
        }
        boolean zSc = this.pFF.JPJ.sc(j11, z11, null, this.zY);
        if (zSc && !z11) {
            this.UFX = (int) (System.currentTimeMillis() / 1000);
        }
        return zSc;
    }
}
