package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.pFF.Ol;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.google.logging.type.LogSeverity;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static com.bytedance.sdk.openadsdk.sc.zY.pFF Tf;
    private boolean Ql;
    private com.bytedance.sdk.openadsdk.sc.zY.pFF UFX;

    /* JADX INFO: Access modifiers changed from: private */
    public void Sfl() {
        Dl.sc("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.UFX;
        if (pff != null) {
            pff.onAdClicked();
        }
    }

    private void We(int i11) {
        this.pFF.cJ.sc(null, String.format(Sfl.sc(Xc.sc(), "tt_skip_ad_time_text"), Integer.valueOf(i11)));
    }

    private void YIK() {
        if (this.Qj) {
            return;
        }
        this.Qj = true;
        Dl.sc("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.UFX;
        if (pff != null) {
            pff.pFF();
        }
    }

    private boolean pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        return Xc.We().YIK(String.valueOf(this.pFF.TRI));
    }

    private void sc(final String str) {
        Cb.zY(new Qj("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.pFF(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.pFF.QLv, str);
                } catch (Throwable th2) {
                    Tf.sc("TTAD.FSVA", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    private boolean sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return sfl == null || sfl.AZJ() == 100.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void ExN() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.sc.zY.pFF pff = this.UFX;
            if (pff != null) {
                pff.sc();
            }
        }
        if (wjp()) {
            this.pFF.cvk.WH();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void SR() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void We() {
        Sfl();
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
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void c_() {
        if (this.pFF.pFF.AZJ() != 100.0f) {
            this.Ql = true;
        }
        Sfl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void dE() {
        final View viewWH = this.pFF.BR.WH();
        if (viewWH != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTFullScreenVideoActivity.this.pFF.Cb.cvk() && TTFullScreenVideoActivity.this.pFF.WH.get()) {
                        boolean zQl = TTFullScreenVideoActivity.this.pFF.OXF.Ql();
                        TTFullScreenVideoActivity.this.pFF.Cb.ExN(zQl);
                        TTFullScreenVideoActivity.this.pFF.BR.ExN(8);
                        View view2 = viewWH;
                        if (view2 instanceof com.bytedance.sdk.openadsdk.core.ExN.We) {
                            ((com.bytedance.sdk.openadsdk.core.ExN.We) view2).setImageResource(Sfl.We(TTFullScreenVideoActivity.this.pFF.f27911pc, "tt_close_btn"));
                        }
                        TTFullScreenVideoActivity.this.pFF.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 5000L);
                        if (!com.bytedance.sdk.openadsdk.core.model.Sfl.zY(TTFullScreenVideoActivity.this.pFF.pFF)) {
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(TTFullScreenVideoActivity.this.pFF.pFF) && zQl) {
                            return;
                        }
                    }
                    if (TTFullScreenVideoActivity.this.pFF.pFF.vzC()) {
                        if (TTFullScreenVideoActivity.this.pFF.pFF.ymG()) {
                            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = TTFullScreenVideoActivity.this.pFF;
                            if (scVar.kX != null) {
                                scVar.pFF.OXF(2);
                                if (TTFullScreenVideoActivity.this.pFF.kX.ExN()) {
                                    return;
                                }
                            }
                        } else if (TTFullScreenVideoActivity.this.pFF.pFF.Vb() == 0 && !TTFullScreenVideoActivity.this.pFF.Cb.Xc()) {
                            TTFullScreenVideoActivity.this.pFF.pFF.OXF(11);
                            if (TTFullScreenVideoActivity.this.pFF.Cb.We()) {
                                TTFullScreenVideoActivity.this.pFF.pFF.OXF(12);
                            }
                            try {
                                TTFullScreenVideoActivity.this.pFF.BR.Xc();
                                return;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    TTFullScreenVideoActivity.this.pFF.Cb.II();
                    TTFullScreenVideoActivity.this.pFF.OXF.UFX();
                    TTFullScreenVideoActivity.this.pFF.McK.TRI();
                    TTFullScreenVideoActivity.this.finish();
                }
            };
            viewWH.setOnClickListener(onClickListener);
            viewWH.setTag(viewWH.getId(), onClickListener);
        }
        this.pFF.cJ.sc(new com.bytedance.sdk.openadsdk.component.reward.top.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void We(View view) {
                View view2 = viewWH;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void pFF(View view) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = tTFullScreenVideoActivity.pFF;
                scVar.f27908eo = !scVar.f27908eo;
                com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = tTFullScreenVideoActivity.zY;
                if (pff != null && pff.We() != null) {
                    TTFullScreenVideoActivity.this.zY.We().sc(TTFullScreenVideoActivity.this.pFF.f27908eo);
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTFullScreenVideoActivity.this.pFF;
                scVar2.JPJ.pFF(scVar2.f27908eo);
                if (!JPJ.Sfl(TTFullScreenVideoActivity.this.pFF.pFF) || TTFullScreenVideoActivity.this.pFF.WH.get()) {
                    if (JPJ.qr(TTFullScreenVideoActivity.this.pFF.pFF)) {
                        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = TTFullScreenVideoActivity.this.pFF;
                        scVar3.cD.sc(scVar3.f27908eo, true);
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = TTFullScreenVideoActivity.this.pFF;
                    scVar4.Cb.We(scVar4.f27908eo);
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = TTFullScreenVideoActivity.this.pFF;
                    scVar5.WP.TRI(scVar5.f27908eo);
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl = TTFullScreenVideoActivity.this.pFF.pFF;
                    if (sfl == null || sfl.GOt() == null || TTFullScreenVideoActivity.this.pFF.pFF.GOt().sc() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar6 = TTFullScreenVideoActivity.this.pFF;
                    if (scVar6.JPJ != null) {
                        if (scVar6.f27908eo) {
                            scVar6.pFF.GOt().sc().Qj(TTFullScreenVideoActivity.this.pFF.JPJ.qr());
                        } else {
                            scVar6.pFF.GOt().sc().Ol(TTFullScreenVideoActivity.this.pFF.JPJ.qr());
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void sc(View view) {
                com.bytedance.sdk.openadsdk.component.reward.view.pFF pffSc;
                if (JPJ.TRI(TTFullScreenVideoActivity.this.pFF.pFF) || (JPJ.ExN(TTFullScreenVideoActivity.this.pFF.pFF) && TTFullScreenVideoActivity.this.pFF.WP.Qj(com.bytedance.sdk.openadsdk.component.reward.sc.Qj.pFF))) {
                    if (JPJ.WH(TTFullScreenVideoActivity.this.pFF.pFF)) {
                        TTFullScreenVideoActivity.this.pFF.WP.Xc();
                        return;
                    }
                    View view2 = viewWH;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                }
                if (JPJ.Qj(TTFullScreenVideoActivity.this.pFF.pFF) && (JPJ.wjp(TTFullScreenVideoActivity.this.pFF.pFF) || TTFullScreenVideoActivity.this.pFF.WH.get())) {
                    if (TTFullScreenVideoActivity.this.pFF.WP.sc()) {
                        TTFullScreenVideoActivity.this.pFF.WP.sc(5);
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.pFF.Cb.Qj();
                        return;
                    }
                }
                if (JPJ.wjp(TTFullScreenVideoActivity.this.pFF.pFF) || (com.bytedance.sdk.openadsdk.core.model.Xc.sc(TTFullScreenVideoActivity.this.pFF.pFF) && !TTFullScreenVideoActivity.this.pFF.dE.get())) {
                    if (!JPJ.Qj(TTFullScreenVideoActivity.this.pFF.pFF) && TTFullScreenVideoActivity.this.pFF.WP.sc()) {
                        TTFullScreenVideoActivity.this.pFF.WP.sc(4);
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                if (TTFullScreenVideoActivity.this.pFF.pFF.uoi()) {
                    if (TTFullScreenVideoActivity.this.pFF.BR.UFX() != null) {
                        TTFullScreenVideoActivity.this.pFF.pFF.OXF(2);
                        TTFullScreenVideoActivity.this.pFF.BR.Xc();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = TTFullScreenVideoActivity.this.pFF;
                if (!scVar.zY && scVar.pFF.vzC() && !TTFullScreenVideoActivity.this.pFF.pFF.ymG()) {
                    TTFullScreenVideoActivity.this.pFF.pFF.OXF(13);
                    try {
                        TTFullScreenVideoActivity.this.pFF.BR.Xc();
                        return;
                    } catch (Exception unused) {
                    }
                }
                BT.sc scVar2 = new BT.sc();
                scVar2.sc(TTFullScreenVideoActivity.this.pFF.JPJ.qr());
                scVar2.zY(TTFullScreenVideoActivity.this.pFF.JPJ.Sfl());
                scVar2.pFF(TTFullScreenVideoActivity.this.pFF.JPJ.UFX());
                scVar2.zY(3);
                scVar2.We(TTFullScreenVideoActivity.this.pFF.JPJ.wjp());
                com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(TTFullScreenVideoActivity.this.pFF.JPJ.zY(), scVar2, TTFullScreenVideoActivity.this.pFF.JPJ.sc());
                com.bytedance.sdk.openadsdk.core.JPJ.zY(TTFullScreenVideoActivity.this.pFF.TRI);
                TTFullScreenVideoActivity.this.pFF.JPJ.sc("skip", false);
                TTFullScreenVideoActivity.this.pFF.cJ.We(false);
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = TTFullScreenVideoActivity.this.pFF;
                if (!scVar3.zY || (com.bytedance.sdk.openadsdk.core.model.Xc.zY(scVar3.pFF) && (pffSc = TTFullScreenVideoActivity.this.pFF.cvk.sc()) != null && pffSc.We == 0)) {
                    TTFullScreenVideoActivity.this.finish();
                } else {
                    TTFullScreenVideoActivity.this.sc(true, 4);
                }
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl = TTFullScreenVideoActivity.this.pFF.pFF;
                if (sfl != null && sfl.GOt() != null) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = TTFullScreenVideoActivity.this.pFF;
                    if (scVar4.JPJ != null) {
                        scVar4.pFF.GOt().sc().TRI(TTFullScreenVideoActivity.this.pFF.JPJ.qr());
                        TTFullScreenVideoActivity.this.pFF.pFF.GOt().sc().ExN(TTFullScreenVideoActivity.this.pFF.JPJ.qr());
                    }
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(TTFullScreenVideoActivity.this.pFF.pFF, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void zY(View view) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                tTFullScreenVideoActivity.pFF.Gb.sc(tTFullScreenVideoActivity.zY);
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        Tf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.pFF != null) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("videoForceBreak", this.pFF.pFF);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
            scVar.WP.sc(scVar.Bs);
        }
        try {
            YIK();
        } catch (Exception unused) {
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null || com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(scVar.pFF)) {
            return;
        }
        x8.a aVarGI = this.pFF.pFF.GI();
        if (aVarGI == null) {
            x8.a aVar = new x8.a();
            aVar.F(10.0d);
            this.pFF.pFF.sc(aVar);
        } else if (aVarGI.m() <= 0.0d) {
            aVarGI.F(10.0d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YIK();
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("recycleRes");
        }
        this.UFX = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.view.pFF pffSc;
        super.onResume();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null || (pffSc = scVar.cvk.sc()) == null) {
            return;
        }
        pffSc.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
            public void sc() {
                TTFullScreenVideoActivity.this.Sfl();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Tf = this.UFX;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null || !pFF(scVar.pFF) || sc(this.pFF.pFF)) {
            return;
        }
        if (this.Ql) {
            this.Ql = false;
            finish();
        } else if (this.pFF.Cb.OXF()) {
            finish();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void sc() {
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.pFF.pFF)) {
            this.pFF.cJ.sc(null, TTAdDislikeToast.getSkipText());
        } else {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
            if (scVar.zY) {
                this.pFF.cJ.sc(null, TTAdDislikeToast.getSkipText());
            } else {
                scVar.cJ.sc(null, "X");
            }
        }
        this.pFF.cJ.ExN(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(int i11) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void sc(@NonNull Intent intent) {
        super.sc(intent);
        this.pFF.Bs = intent.getBooleanExtra("is_verity_playable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            this.UFX = FI.sc().We();
        }
        if (this.UFX != null || bundle == null) {
            return;
        }
        this.UFX = Tf;
        Tf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(boolean z11) {
    }

    public boolean sc(long j11, boolean z11) {
        qr qrVar = new qr();
        qrVar.sc(System.currentTimeMillis(), 1.0f);
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null || !(pff instanceof Ol)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
            scVar.JPJ.sc(scVar.BR.TRI(), qrVar);
        } else {
            this.pFF.JPJ.sc(((Ol) pff).HJN(), qrVar);
        }
        c.InterfaceC0849c interfaceC0849c = new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.5

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            boolean f27535sc;

            @Override // t8.c.InterfaceC0849c
            public void pFF(long j12, int i11) {
                TTFullScreenVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (TTFullScreenVideoActivity.this.pFF.JPJ.pFF()) {
                    TTFullScreenVideoActivity.this.Ql();
                    return;
                }
                TTFullScreenVideoActivity.this.pFF.JPJ.Ql();
                Tf.sc("TTAD.FSVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                if (!tTFullScreenVideoActivity.pFF.zY) {
                    tTFullScreenVideoActivity.finish();
                    return;
                }
                tTFullScreenVideoActivity.sc(false, true, 3);
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = TTFullScreenVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, 2);
            }

            @Override // t8.c.InterfaceC0849c
            public void sc() {
                TTFullScreenVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTFullScreenVideoActivity.this.BT();
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                if (tTFullScreenVideoActivity.pFF.zY) {
                    tTFullScreenVideoActivity.sc(false, true, 6);
                } else {
                    tTFullScreenVideoActivity.finish();
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.Xc xc2 = TTFullScreenVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, 1 ^ (TTFullScreenVideoActivity.this.pFF.JPJ.II() ? 1 : 0));
                TTFullScreenVideoActivity.this.pFF.JPJ.Ql();
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, int i11) {
                com.bytedance.sdk.openadsdk.utils.Tf tf2;
                if (this.f27535sc) {
                    return;
                }
                this.f27535sc = true;
                TTFullScreenVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTFullScreenVideoActivity.this.BT();
                TTFullScreenVideoActivity.this.pFF.JPJ.sc(j12, j12);
                TTFullScreenVideoActivity.this.pFF.Sfl.set(true);
                if (TTFullScreenVideoActivity.this.pFF.pFF.Xc() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTFullScreenVideoActivity.this.pFF;
                    if (scVar2.zY) {
                        scVar2.FI.zY().We();
                        Ql.pFF();
                    }
                }
                if (TTFullScreenVideoActivity.this.pFF.pFF.wdI()) {
                    TTFullScreenVideoActivity.this.pFF.pFF.OXF(1);
                    TTFullScreenVideoActivity.this.pFF.BR.Xc();
                }
                if (TTFullScreenVideoActivity.this.pFF.pFF.Xc() == 21 && !TTFullScreenVideoActivity.this.pFF.pFF.We()) {
                    TTFullScreenVideoActivity.this.pFF.pFF.pFF(true);
                    TTFullScreenVideoActivity.this.pFF.BR.Xc();
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = TTFullScreenVideoActivity.this.pFF;
                if (!scVar3.zY) {
                    if (scVar3.pFF.Chh()) {
                        TTFullScreenVideoActivity.this.pFF.cJ.zY();
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(TTFullScreenVideoActivity.this.pFF.pFF)) {
                        TTFullScreenVideoActivity.this.pFF.JPJ.sc("skip", true);
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                if (scVar3.pFF.Chh()) {
                    TTFullScreenVideoActivity.this.pFF.cJ.zY();
                    return;
                }
                TTFullScreenVideoActivity.this.sc(false, 5);
                if (com.bytedance.sdk.openadsdk.core.model.Xc.pFF(TTFullScreenVideoActivity.this.pFF.pFF) && (tf2 = TTFullScreenVideoActivity.this.pFF.NP) != null) {
                    tf2.sc(0L);
                }
                if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(TTFullScreenVideoActivity.this.pFF.pFF)) {
                    return;
                }
                TTFullScreenVideoActivity.this.pFF.JPJ.sc("skip", true);
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTFullScreenVideoActivity.this.pFF;
                if (!scVar2.yL && scVar2.JPJ.pFF()) {
                    TTFullScreenVideoActivity.this.pFF.JPJ.BT();
                }
                if (TTFullScreenVideoActivity.this.pFF.WH.get()) {
                    return;
                }
                TTFullScreenVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (j12 != TTFullScreenVideoActivity.this.pFF.JPJ.Qj()) {
                    TTFullScreenVideoActivity.this.BT();
                }
                TTFullScreenVideoActivity.this.pFF.JPJ.sc(j12, j13);
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                long j14 = j12 / 1000;
                tTFullScreenVideoActivity.TRI = (int) (tTFullScreenVideoActivity.pFF.JPJ.McK() - j14);
                int i11 = (int) j14;
                if ((TTFullScreenVideoActivity.this.pFF.YIK.get() || TTFullScreenVideoActivity.this.pFF.UFX.get()) && TTFullScreenVideoActivity.this.pFF.JPJ.pFF()) {
                    TTFullScreenVideoActivity.this.pFF.JPJ.BT();
                }
                TTFullScreenVideoActivity.this.zY(i11);
                TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                int i12 = tTFullScreenVideoActivity2.TRI;
                if (i12 >= 0) {
                    tTFullScreenVideoActivity2.pFF.cJ.sc(String.valueOf(i12), null);
                }
            }
        };
        this.pFF.JPJ.sc(interfaceC0849c);
        com.bytedance.sdk.openadsdk.core.model.Xc xc2 = this.pFF.BR.BT;
        if (xc2 != null) {
            xc2.sc(interfaceC0849c);
        }
        return this.pFF.JPJ.sc(j11, z11, null, this.zY);
    }

    public void zY(int i11) {
        int iSfl = Xc.We().Sfl(String.valueOf(this.pFF.TRI));
        if (!Xc.We().TRI(String.valueOf(this.pFF.TRI)) || (!com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.pFF.pFF) && !this.pFF.zY)) {
            if (i11 >= iSfl) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
                if (!scVar.fT) {
                    scVar.sc(true);
                }
                sc();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
        if (!scVar2.fT) {
            scVar2.sc(true);
        }
        if (i11 > iSfl) {
            sc();
        } else {
            We(iSfl - i11);
            this.pFF.cJ.ExN(false);
        }
    }
}
