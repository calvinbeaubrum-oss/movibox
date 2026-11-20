package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.view.Qj;
import com.bytedance.sdk.openadsdk.core.YIK;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends sc {
    private static String BT;
    private static String Ql;
    private static String SR;
    private static String Xc;
    private static String dE;
    protected int ExN;
    private String Sfl;
    protected int TRI;
    private int YIK;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    int f27492qr;
    private String wjp;

    public ExN(pFF pff, Sfl sfl, int i11) {
        super(pff, sfl, i11);
        this.YIK = -1;
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
            jSONObject.put("play_start_ts", this.TRI);
            jSONObject.put("play_end_ts", this.ExN);
            jSONObject.put("duration", iYIK);
            jSONObject.put("user_id", this.wjp);
            jSONObject.put("trans_id", JPJ.sc().replace("-", ""));
            return jSONObject;
        } catch (Throwable th2) {
            Tf.sc("TTAD.RewardAdScene", "", th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0078  */
    public void cD() {
        com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc scVar = new com.bytedance.sdk.openadsdk.We.ExN.pFF.BT.sc();
        scVar.sc(this.zY.JPJ.qr());
        scVar.zY(this.zY.JPJ.Sfl());
        scVar.pFF(this.zY.JPJ.UFX());
        scVar.zY(3);
        scVar.We(this.zY.JPJ.wjp());
        com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(this.zY.JPJ.zY(), scVar, this.zY.JPJ.sc());
        com.bytedance.sdk.openadsdk.core.JPJ.zY(this.zY.TRI);
        this.zY.JPJ.sc("skip", false);
        if (this.zY.zY) {
            sc(true, 4);
            if (Xc.sc(this.zY.pFF) && !this.zY.dE.get()) {
                cvk();
            }
        } else {
            cvk();
        }
        com.bytedance.sdk.openadsdk.core.Tf.sc scVarGOt = this.zY.pFF.GOt();
        if (scVarGOt != null) {
            com.bytedance.sdk.openadsdk.core.Tf.We weSc = scVarGOt.sc();
            long jQr = this.zY.JPJ.qr();
            weSc.TRI(jQr);
            weSc.ExN(jQr);
        }
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.zY.pFF, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(final boolean z11, boolean z12, final Runnable runnable) {
        if (!z12 && FI().WH().getBoolean("user_has_give_up_reward", false) && (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(this.zY.pFF) || runnable != null)) {
            if (runnable == null) {
                cD();
            }
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.Xc.We().Qj(String.valueOf(this.zY.TRI))) {
            if (runnable == null) {
                if (z11) {
                    cvk();
                    return false;
                }
                cD();
            }
            return false;
        }
        if (FI().WH().getBoolean("reward_verify", false)) {
            if (runnable == null) {
                if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(this.zY.pFF)) {
                    cD();
                    return false;
                }
                if (z11) {
                    cvk();
                    return false;
                }
                cD();
            }
            return false;
        }
        this.zY.YIK.set(true);
        this.zY.JPJ.BT();
        if (z11) {
            this.zY.WP.SR();
        }
        final com.bytedance.sdk.openadsdk.core.widget.pFF pff = new com.bytedance.sdk.openadsdk.core.widget.pFF(WP());
        this.pFF.Ql = pff;
        if (z11) {
            pff.sc(Ql).pFF(SR).zY(BT);
        } else {
            pff.sc(dE).pFF(Xc).zY(BT);
        }
        this.pFF.Ql.sc(new com.bytedance.sdk.openadsdk.core.widget.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.pFF.sc
            public void pFF() {
                pff.dismiss();
                ExN.this.FI().WH().putBoolean("user_has_give_up_reward", true);
                ExN.this.zY.YIK.set(false);
                ExN.this.zY.WP.TRI(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z11) {
                    ExN.this.cD();
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.JPJ.Qj(ExN.this.zY.pFF)) {
                    if (ExN.this.zY.WP.sc()) {
                        ExN.this.zY.WP.sc(5);
                        return;
                    } else {
                        ExN.this.cD();
                        return;
                    }
                }
                ExN.this.zY.McK.TRI();
                if (ExN.this.zY.WP.sc()) {
                    ExN.this.zY.WP.sc(4);
                }
                ExN.this.cvk();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.pFF.sc
            public void sc() {
                ExN.this.zY.JPJ.SR();
                if (z11) {
                    ExN.this.zY.WP.ExN(1000);
                }
                pff.dismiss();
                ExN.this.zY.YIK.set(false);
            }
        }).show();
        return true;
    }

    public void JPJ() {
        if (FI().WH().getBoolean("reward_verify", false) || FI().SR()) {
            return;
        }
        FI().WH().putBoolean("reward_verify", true);
        if (com.bytedance.sdk.openadsdk.core.Xc.We().dE(String.valueOf(this.zY.TRI))) {
            sc(true, this.zY.pFF.uEA(), this.zY.pFF.Dl(), 0, "");
        } else {
            com.bytedance.sdk.openadsdk.core.Xc.zY().sc(Gb(), new com.bytedance.sdk.openadsdk.core.Sfl.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.6
                @Override // com.bytedance.sdk.openadsdk.core.Sfl.pFF
                public void sc(int i11, String str) {
                    ExN.this.sc(false, 0, "", i11, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.Sfl.pFF
                public void sc(YIK.pFF pff) {
                    boolean z11 = pff.pFF;
                    ExN.this.sc(pff.pFF, pff.zY.sc(), pff.zY.pFF(), 0, "");
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.activity.TRI, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void SR() {
        if (this.Qj.xP()) {
            int i11 = com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.zY.TRI)).TRI;
            if (com.bytedance.sdk.openadsdk.core.model.JPJ.Sfl(this.zY.pFF)) {
                if ((1.0d - (((double) this.f27492qr) / this.zY.JPJ.McK())) * 100.0d < i11) {
                    return;
                }
            } else {
                boolean z11 = (1.0f - (this.zY.WP.pFF() / ((float) this.zY.pFF.ds()))) * 100.0f >= ((float) i11);
                int iSc = com.bytedance.sdk.openadsdk.core.Xc.We().sc(String.valueOf(this.zY.TRI));
                if (iSc == 0) {
                    boolean zExN = this.zY.WP.zY() ? true : this.zY.Cb.Tf().ExN();
                    if (!z11 || !zExN) {
                        return;
                    }
                } else if (iSc != 1 || !z11) {
                    return;
                }
            }
            JPJ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void Tf() {
        JPJ();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public boolean a_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public String b_() {
        return "rewarded_video";
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void c_() {
        HJN();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc
    public void pFF() {
        this.zY.cJ.sc(null, TTAdDislikeToast.getSkipText());
        this.zY.cJ.ExN(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc
    public void qr() {
        McK();
        if (this.Qj.sc()) {
            this.zY.cvk.WH();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(int i11) {
        if (i11 == 10000) {
            JPJ();
        }
    }

    public void sc(long j11, long j12) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar.otH) {
            return;
        }
        long j13 = j11 + (((long) scVar.Yhz) * 1000);
        if (this.YIK == -1) {
            this.YIK = com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.zY.TRI)).TRI;
        }
        if (j12 <= 0) {
            return;
        }
        if (j12 >= 30000 && j13 >= 27000) {
            JPJ();
        } else if ((j13 * 100) / j12 >= this.YIK) {
            JPJ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.activity.TRI
    public void sc(Activity activity, pFF.ExN exN) {
        super.sc(activity, exN);
        if (activity.isFinishing()) {
            return;
        }
        Intent intent = activity.getIntent();
        this.Sfl = intent.getStringExtra("media_extra");
        this.wjp = intent.getStringExtra("user_id");
        try {
            if (dE == null) {
                dE = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_reward_msg");
                Ql = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_msgPlayable");
                BT = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_negtiveBtnBtnText");
                Xc = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_postiveBtnText");
                SR = com.bytedance.sdk.component.utils.Sfl.sc(this.zY.f27911pc, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th2) {
            Tf.sc("TTAD.RewardAdScene", th2.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(final String str, final JSONObject jSONObject) {
        if ("skipToNextAd".equals(str) && this.zY.dix != null && FI().TRI() == null && sc(com.bytedance.sdk.openadsdk.core.model.JPJ.zY(this.zY.pFF), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.7
            @Override // java.lang.Runnable
            public void run() {
                ExN.super.sc(str, jSONObject);
            }
        })) {
            return;
        }
        super.sc(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(boolean z11) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public boolean sc(long j11, boolean z11) {
        if (!this.Qj.sc()) {
            qr qrVar = new qr();
            qrVar.sc(System.currentTimeMillis(), 1.0f);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
            scVar.JPJ.sc(scVar.BR.TRI(), qrVar);
            c.InterfaceC0849c interfaceC0849c = new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.4

                /* JADX INFO: renamed from: sc, reason: collision with root package name */
                boolean f27496sc;

                @Override // t8.c.InterfaceC0849c
                public void pFF(long j12, int i11) {
                    ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    if (ExN.this.zY.JPJ.pFF()) {
                        ExN.this.ExN();
                        return;
                    }
                    ExN.this.zY.JPJ.Ql();
                    ExN.this.JPJ();
                    pFF pffFI = ExN.this.FI();
                    ExN exN = ExN.this;
                    pffFI.sc(exN, exN.pFF(3));
                }

                @Override // t8.c.InterfaceC0849c
                public void sc() {
                    ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    ExN.this.Ql();
                    ExN.this.JPJ();
                    pFF pffFI = ExN.this.FI();
                    ExN exN = ExN.this;
                    pffFI.sc(exN, exN.pFF(6));
                }

                @Override // t8.c.InterfaceC0849c
                public void sc(long j12, int i11) {
                    com.bytedance.sdk.openadsdk.utils.Tf tf2;
                    if (this.f27496sc) {
                        return;
                    }
                    this.f27496sc = true;
                    ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    ExN.this.Ql();
                    ExN exN = ExN.this;
                    if (!exN.zY.otH) {
                        exN.JPJ();
                    }
                    ExN.this.zY.JPJ.sc(j12, j12);
                    ExN.this.zY.Sfl.set(true);
                    if (ExN.this.zY.pFF.wdI()) {
                        ExN.this.zY.pFF.OXF(1);
                        ExN.this.zY.BR.Xc();
                    }
                    if (ExN.this.zY.pFF.Xc() == 21 && !ExN.this.zY.pFF.We()) {
                        ExN.this.zY.pFF.pFF(true);
                        ExN.this.zY.BR.Xc();
                    }
                    ExN.this.ExN = (int) (System.currentTimeMillis() / 1000);
                    ExN exN2 = ExN.this;
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = exN2.zY;
                    if (scVar2.otH) {
                        pFF.ExN exNPFF = exN2.pFF(5);
                        exNPFF.ExN = true;
                        ExN.this.FI().sc(ExN.this, exNPFF);
                        return;
                    }
                    if (Xc.We(scVar2.pFF) || Xc.pFF(ExN.this.zY.pFF) || Xc.ExN(ExN.this.zY.pFF)) {
                        ExN.this.sc(false, 5);
                        if (!Xc.pFF(ExN.this.zY.pFF) || (tf2 = ExN.this.zY.NP) == null) {
                            return;
                        }
                        tf2.sc(0L);
                        return;
                    }
                    if (Xc.sc(ExN.this.zY.pFF) && !ExN.this.zY.dE.get()) {
                        ExN.this.zY.sc(true);
                        ExN.this.zY.cJ.ExN(true);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = ExN.this.zY;
                    if (!scVar3.zY) {
                        if (scVar3.pFF.Chh()) {
                            ExN.this.zY.cJ.zY();
                            return;
                        }
                        if (!Sfl.ExN(ExN.this.zY.pFF)) {
                            ExN.this.zY.JPJ.sc("skip", true);
                        }
                        ExN.this.cvk();
                        return;
                    }
                    if (scVar3.pFF.Chh()) {
                        ExN.this.zY.cJ.zY();
                        return;
                    }
                    ExN.this.sc(false, 5);
                    if (Sfl.ExN(ExN.this.zY.pFF)) {
                        return;
                    }
                    ExN.this.zY.JPJ.sc("skip", true);
                }

                @Override // t8.c.InterfaceC0849c
                public void sc(long j12, long j13) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = ExN.this.zY;
                    if (!scVar2.yL && scVar2.JPJ.pFF()) {
                        ExN.this.zY.JPJ.BT();
                    }
                    if (ExN.this.zY.WH.get()) {
                        return;
                    }
                    ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    if (j12 != ExN.this.zY.JPJ.Qj()) {
                        ExN.this.Ql();
                    }
                    ExN.this.zY.JPJ.sc(j12, j13);
                    ExN exN = ExN.this;
                    long j14 = j12 / 1000;
                    double d11 = j14;
                    exN.f27492qr = (int) (exN.zY.JPJ.McK() - d11);
                    ExN exN2 = ExN.this;
                    int i11 = exN2.f27492qr;
                    if (i11 >= 0) {
                        exN2.zY.cJ.sc(String.valueOf(i11), null);
                    }
                    ExN exN3 = ExN.this;
                    exN3.f27492qr = (int) (exN3.zY.JPJ.McK() - d11);
                    int i12 = (int) j14;
                    int iWH = com.bytedance.sdk.openadsdk.core.Xc.We().WH(String.valueOf(ExN.this.zY.TRI));
                    boolean z12 = iWH >= 0;
                    if ((ExN.this.zY.YIK.get() || ExN.this.zY.UFX.get()) && ExN.this.zY.JPJ.pFF()) {
                        ExN.this.zY.JPJ.BT();
                    }
                    ExN.this.zY.BR.We(i12);
                    ExN.this.sc(j12, j13);
                    ExN.this.sc((j12 * 1.0f) / j13);
                    ExN exN4 = ExN.this;
                    if (exN4.f27492qr > 0) {
                        exN4.zY.cJ.We(true);
                        if (!z12 || i12 < iWH) {
                            ExN exN5 = ExN.this;
                            exN5.zY.cJ.sc(String.valueOf(exN5.f27492qr), null);
                        } else {
                            ExN.this.zY.sc(true);
                            ExN exN6 = ExN.this;
                            exN6.zY.cJ.sc(String.valueOf(exN6.f27492qr), TTAdDislikeToast.getSkipText());
                            ExN.this.zY.cJ.ExN(true);
                        }
                    }
                }
            };
            this.zY.JPJ.sc(interfaceC0849c);
            Xc xc2 = this.zY.BR.BT;
            if (xc2 != null) {
                xc2.sc(interfaceC0849c);
            }
            boolean zSc = this.zY.JPJ.sc(j11, z11, null, this.pFF);
            if (zSc && !z11) {
                this.TRI = (int) (System.currentTimeMillis() / 1000);
            }
            return zSc;
        }
        Qj qj2 = this.zY.cvk;
        qr qrVar2 = (qj2 == null || qj2.sc() == null) ? new qr() : this.zY.cvk.sc().getAdShowTime();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
        scVar2.JPJ.sc(scVar2.cvk.pFF(), qrVar2);
        HashMap map = new HashMap();
        Qj qj3 = this.zY.cvk;
        if (qj3 != null) {
            map.put("dynamic_show_type", Integer.valueOf(qj3.Ol()));
            JSONObject jSONObjectSc = this.zY.cvk.sc((JSONObject) null);
            if (jSONObjectSc != null) {
                Iterator<String> itKeys = jSONObjectSc.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        map.put(next, jSONObjectSc.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        this.zY.JPJ.sc(new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.3

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            boolean f27495sc;

            @Override // t8.c.InterfaceC0849c
            public void pFF(long j12, int i11) {
                ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                if (ExN.this.zY.JPJ.pFF()) {
                    ExN.this.ExN();
                    return;
                }
                ExN.this.JPJ();
                ExN.this.zY.JPJ.Ql();
                ExN.this.zY.cvk.sc(true);
                pFF pffFI = ExN.this.FI();
                ExN exN = ExN.this;
                pffFI.sc(exN, exN.pFF(3));
            }

            @Override // t8.c.InterfaceC0849c
            public void sc() {
                ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                ExN.this.Ql();
                ExN.this.JPJ();
                pFF pffFI = ExN.this.FI();
                ExN exN = ExN.this;
                pffFI.sc(exN, exN.pFF(6));
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, int i11) {
                if (this.f27495sc) {
                    return;
                }
                this.f27495sc = true;
                ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                ExN.this.Ql();
                ExN.this.zY.JPJ.sc(j12, j12);
                ExN.this.zY.cvk.pFF(true);
                if (ExN.this.zY.pFF.Xc() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = ExN.this.zY;
                    if (scVar3.zY) {
                        scVar3.FI.zY().We();
                        Ql.pFF();
                    }
                }
                if (ExN.this.zY.pFF.Xc() == 21 && !ExN.this.zY.pFF.We()) {
                    ExN.this.zY.pFF.pFF(true);
                    ExN.this.zY.BR.Xc();
                }
                ExN exN = ExN.this;
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = exN.zY;
                if (scVar4.otH) {
                    pFF pffFI = exN.FI();
                    ExN exN2 = ExN.this;
                    pffFI.sc(exN2, exN2.pFF(5));
                } else if (scVar4.zY) {
                    if (!scVar4.pFF.Chh()) {
                        ExN.this.sc(false, 5);
                        if (!Sfl.ExN(ExN.this.zY.pFF)) {
                            ExN.this.zY.JPJ.sc("skip", true);
                        }
                    } else if (ExN.this.zY.cvk.Ol() == 1) {
                        ExN.this.zY.cJ.zY();
                    }
                } else if (!scVar4.pFF.Chh()) {
                    if (!Sfl.ExN(ExN.this.zY.pFF)) {
                        ExN.this.zY.JPJ.sc("skip", true);
                    }
                    ExN.this.cvk();
                } else if (ExN.this.zY.cvk.Ol() == 1) {
                    ExN.this.zY.cJ.zY();
                }
                ExN.this.ExN = (int) (System.currentTimeMillis() / 1000);
                ExN exN3 = ExN.this;
                if (exN3.zY.otH) {
                    return;
                }
                exN3.JPJ();
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = ExN.this.zY;
                if (!scVar3.yL && scVar3.JPJ.pFF()) {
                    ExN.this.zY.JPJ.BT();
                }
                if (ExN.this.zY.WH.get()) {
                    return;
                }
                ((sc) ExN.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                if (j12 != ExN.this.zY.JPJ.Qj()) {
                    ExN.this.Ql();
                }
                if (ExN.this.zY.JPJ.pFF()) {
                    ExN.this.zY.JPJ.sc(j12, j13);
                    int iWH = com.bytedance.sdk.openadsdk.core.Xc.We().WH(String.valueOf(ExN.this.zY.TRI));
                    boolean z12 = ExN.this.zY.cvk.Qj() && iWH != -1 && iWH >= 0;
                    ExN exN = ExN.this;
                    long j14 = j12 / 1000;
                    exN.f27492qr = (int) (exN.zY.JPJ.McK() - j14);
                    int i11 = (int) j14;
                    if ((ExN.this.zY.YIK.get() || ExN.this.zY.UFX.get()) && ExN.this.zY.JPJ.pFF()) {
                        ExN.this.zY.JPJ.BT();
                    }
                    ExN exN2 = ExN.this;
                    int i12 = exN2.f27492qr;
                    if (i12 >= 0) {
                        exN2.zY.cJ.sc(String.valueOf(i12), null);
                    }
                    ExN.this.zY.BR.We(i11);
                    ExN.this.sc(j12, j13);
                    Qj qj4 = ExN.this.zY.cvk;
                    if (qj4 != null && qj4.sc() != null) {
                        ExN.this.zY.cvk.sc().setTime(String.valueOf(ExN.this.f27492qr), i11, 0, false);
                    }
                    ExN.this.sc((j12 * 1.0f) / j13);
                    ExN exN3 = ExN.this;
                    if (exN3.f27492qr > 0) {
                        if (!z12 || i11 < iWH || exN3.zY.pFF.Xc() == 5) {
                            ExN exN4 = ExN.this;
                            exN4.zY.cJ.sc(String.valueOf(exN4.f27492qr), null);
                        } else {
                            ExN.this.zY.sc(true);
                            ExN exN5 = ExN.this;
                            exN5.zY.cJ.sc(String.valueOf(exN5.f27492qr), TTAdDislikeToast.getSkipText());
                            ExN.this.zY.cJ.ExN(true);
                        }
                    }
                }
            }
        });
        boolean zSc2 = this.zY.JPJ.sc(j11, z11, map, this.pFF);
        if (zSc2 && !z11) {
            this.TRI = (int) (System.currentTimeMillis() / 1000);
        }
        return zSc2;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc
    public void zY() {
        final View viewWH = this.zY.BR.WH();
        if (viewWH != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ExN.this.zY.Cb.cvk() && ExN.this.zY.WH.get()) {
                        boolean zQl = ExN.this.zY.OXF.Ql();
                        ExN.this.zY.Cb.ExN(zQl);
                        ExN.this.zY.BR.ExN(8);
                        ExN.this.zY.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 5000L);
                        if (!Sfl.zY(ExN.this.zY.pFF)) {
                            return;
                        }
                        if (Sfl.zY(ExN.this.zY.pFF) && zQl) {
                            return;
                        }
                    }
                    if (ExN.this.zY.pFF.vzC()) {
                        if (ExN.this.zY.pFF.ymG()) {
                            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = ExN.this.zY;
                            if (scVar.kX != null) {
                                scVar.pFF.OXF(2);
                                if (ExN.this.zY.kX.ExN()) {
                                    return;
                                }
                            }
                        } else if (ExN.this.zY.pFF.Vb() == 0 && !ExN.this.zY.Cb.Xc()) {
                            ExN.this.zY.pFF.OXF(11);
                            if (ExN.this.zY.Cb.We()) {
                                ExN.this.zY.pFF.OXF(12);
                            }
                            try {
                                ExN.this.zY.BR.Xc();
                                return;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    ExN.this.zY.Cb.II();
                    ExN.this.zY.OXF.UFX();
                    ExN.this.zY.McK.TRI();
                    if (com.bytedance.sdk.openadsdk.core.model.JPJ.We(ExN.this.zY.pFF)) {
                        ExN.this.sc(true, true, (Runnable) null);
                    } else {
                        ExN.this.cvk();
                    }
                }
            };
            viewWH.setOnClickListener(onClickListener);
            viewWH.setTag(viewWH.getId(), onClickListener);
        }
        this.zY.cJ.sc(new com.bytedance.sdk.openadsdk.component.reward.top.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.ExN.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void We(View view) {
                View view2 = viewWH;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void pFF(View view) {
                com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = ExN.this.pFF;
                if (pff != null && pff.We() != null) {
                    ExN.this.pFF.We().sc(ExN.this.zY.f27908eo);
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = ExN.this.zY;
                scVar.f27908eo = !scVar.f27908eo;
                StringBuilder sb2 = new StringBuilder("will set is Mute ");
                sb2.append(ExN.this.zY.f27908eo);
                sb2.append(" mLastVolume=");
                sb2.append(ExN.this.zY.cD.sc());
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = ExN.this.zY;
                scVar2.JPJ.pFF(scVar2.f27908eo);
                if (!com.bytedance.sdk.openadsdk.core.model.JPJ.Sfl(ExN.this.zY.pFF) || ExN.this.zY.WH.get()) {
                    if (com.bytedance.sdk.openadsdk.core.model.JPJ.qr(ExN.this.zY.pFF)) {
                        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = ExN.this.zY;
                        scVar3.cD.sc(scVar3.f27908eo, true);
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = ExN.this.zY;
                    scVar4.Cb.We(scVar4.f27908eo);
                    Sfl sfl = ExN.this.zY.pFF;
                    if (sfl == null || sfl.GOt() == null || ExN.this.zY.pFF.GOt().sc() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = ExN.this.zY;
                    if (scVar5.JPJ != null) {
                        if (scVar5.f27908eo) {
                            scVar5.pFF.GOt().sc().Qj(ExN.this.zY.JPJ.qr());
                        } else {
                            scVar5.pFF.GOt().sc().Ol(ExN.this.zY.JPJ.qr());
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void sc(View view) {
                if (ExN.this.zY.pFF.uoi()) {
                    if (ExN.this.zY.BR.UFX() != null) {
                        ExN.this.zY.pFF.OXF(2);
                        ExN.this.zY.BR.Xc();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = ExN.this.zY;
                if (!scVar.zY && scVar.pFF.vzC() && !ExN.this.zY.pFF.ymG()) {
                    ExN.this.zY.pFF.OXF(13);
                    try {
                        ExN.this.zY.BR.Xc();
                        return;
                    } catch (Exception unused) {
                    }
                }
                ExN exN = ExN.this;
                exN.sc(com.bytedance.sdk.openadsdk.core.model.JPJ.zY(exN.zY.pFF), false, (Runnable) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void zY(View view) {
                ExN exN = ExN.this;
                exN.zY.Gb.sc(exN.pFF);
            }
        });
    }
}
