package com.bytedance.sdk.openadsdk.activity;

import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.sc.Xc;
import com.bytedance.sdk.openadsdk.component.reward.view.Qj;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.google.logging.type.LogSeverity;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public boolean sc(long j11, boolean z11) {
        Qj qj2 = this.pFF.cvk;
        qr qrVar = (qj2 == null || qj2.sc() == null) ? new qr() : this.pFF.cvk.sc().getAdShowTime();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        scVar.JPJ.sc(scVar.cvk.pFF(), qrVar);
        HashMap map = new HashMap();
        Qj qj3 = this.pFF.cvk;
        if (qj3 != null) {
            map.put("dynamic_show_type", Integer.valueOf(qj3.Ol()));
            JSONObject jSONObjectSc = this.pFF.cvk.sc((JSONObject) null);
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
        this.pFF.JPJ.sc(new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.1

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            boolean f27569sc;

            @Override // t8.c.InterfaceC0849c
            public void pFF(long j12, int i11) {
                TTRewardExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (TTRewardExpressVideoActivity.this.pFF.JPJ.pFF()) {
                    TTRewardExpressVideoActivity.this.Ql();
                    return;
                }
                TTRewardExpressVideoActivity.this.Sfl();
                TTRewardExpressVideoActivity.this.pFF.JPJ.Ql();
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity.pFF.zY) {
                    tTRewardExpressVideoActivity.sc(false, 3);
                } else {
                    tTRewardExpressVideoActivity.finish();
                }
                TTRewardExpressVideoActivity.this.pFF.cvk.sc(true);
                Xc xc2 = TTRewardExpressVideoActivity.this.pFF.JPJ;
                xc2.sc(1 ^ (xc2.II() ? 1 : 0), 2);
            }

            @Override // t8.c.InterfaceC0849c
            public void sc() {
                TTRewardExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTRewardExpressVideoActivity.this.BT();
                TTRewardExpressVideoActivity.this.Sfl();
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity.pFF.zY) {
                    tTRewardExpressVideoActivity.sc(false, 6);
                } else {
                    tTRewardExpressVideoActivity.finish();
                }
                Xc xc2 = TTRewardExpressVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, !TTRewardExpressVideoActivity.this.pFF.JPJ.II() ? 1 : 0);
                TTRewardExpressVideoActivity.this.pFF.JPJ.Ql();
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, int i11) {
                if (this.f27569sc) {
                    return;
                }
                this.f27569sc = true;
                TTRewardExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTRewardExpressVideoActivity.this.BT();
                TTRewardExpressVideoActivity.this.pFF.JPJ.sc(j12, j12);
                TTRewardExpressVideoActivity.this.pFF.cvk.pFF(true);
                if (TTRewardExpressVideoActivity.this.pFF.pFF.Xc() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTRewardExpressVideoActivity.this.pFF;
                    if (scVar2.zY) {
                        scVar2.FI.zY().We();
                        Ql.pFF();
                    }
                }
                if (TTRewardExpressVideoActivity.this.pFF.pFF.Xc() == 21 && !TTRewardExpressVideoActivity.this.pFF.pFF.We()) {
                    TTRewardExpressVideoActivity.this.pFF.pFF.pFF(true);
                    TTRewardExpressVideoActivity.this.pFF.BR.Xc();
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = TTRewardExpressVideoActivity.this.pFF;
                if (scVar3.zY) {
                    if (!scVar3.pFF.Chh()) {
                        TTRewardExpressVideoActivity.this.sc(false, 5);
                        if (!Sfl.ExN(TTRewardExpressVideoActivity.this.pFF.pFF)) {
                            TTRewardExpressVideoActivity.this.pFF.JPJ.sc("skip", true);
                        }
                    } else if (TTRewardExpressVideoActivity.this.pFF.cvk.Ol() == 1) {
                        TTRewardExpressVideoActivity.this.pFF.cJ.zY();
                    }
                } else if (!scVar3.pFF.Chh()) {
                    if (!Sfl.ExN(TTRewardExpressVideoActivity.this.pFF.pFF)) {
                        TTRewardExpressVideoActivity.this.pFF.JPJ.sc("skip", true);
                    }
                    TTRewardExpressVideoActivity.this.finish();
                } else if (TTRewardExpressVideoActivity.this.pFF.cvk.Ol() == 1) {
                    TTRewardExpressVideoActivity.this.pFF.cJ.zY();
                }
                ((TTRewardVideoActivity) TTRewardExpressVideoActivity.this).Tf = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.Sfl();
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = TTRewardExpressVideoActivity.this.pFF;
                if (!scVar2.yL && scVar2.JPJ.pFF()) {
                    TTRewardExpressVideoActivity.this.pFF.JPJ.BT();
                }
                if (TTRewardExpressVideoActivity.this.pFF.WH.get()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (j12 != TTRewardExpressVideoActivity.this.pFF.JPJ.Qj()) {
                    TTRewardExpressVideoActivity.this.BT();
                }
                if (TTRewardExpressVideoActivity.this.pFF.JPJ.pFF()) {
                    TTRewardExpressVideoActivity.this.pFF.JPJ.sc(j12, j13);
                    int iWH = com.bytedance.sdk.openadsdk.core.Xc.We().WH(String.valueOf(TTRewardExpressVideoActivity.this.pFF.TRI));
                    boolean z12 = TTRewardExpressVideoActivity.this.pFF.cvk.Qj() && iWH >= 0;
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    long j14 = j12 / 1000;
                    tTRewardExpressVideoActivity.TRI = (int) (tTRewardExpressVideoActivity.pFF.JPJ.McK() - j14);
                    int i11 = (int) j14;
                    if ((TTRewardExpressVideoActivity.this.pFF.YIK.get() || TTRewardExpressVideoActivity.this.pFF.UFX.get()) && TTRewardExpressVideoActivity.this.pFF.JPJ.pFF()) {
                        TTRewardExpressVideoActivity.this.pFF.JPJ.BT();
                    }
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = TTRewardExpressVideoActivity.this;
                    int i12 = tTRewardExpressVideoActivity2.TRI;
                    if (i12 >= 0) {
                        tTRewardExpressVideoActivity2.pFF.cJ.sc(String.valueOf(i12), null);
                    }
                    TTRewardExpressVideoActivity.this.pFF.BR.We(i11);
                    TTRewardExpressVideoActivity.this.sc(j12, j13);
                    Qj qj4 = TTRewardExpressVideoActivity.this.pFF.cvk;
                    if (qj4 != null && qj4.sc() != null) {
                        TTRewardExpressVideoActivity.this.pFF.cvk.sc().setTime(String.valueOf(TTRewardExpressVideoActivity.this.TRI), i11, 0, false);
                    }
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = TTRewardExpressVideoActivity.this;
                    if (tTRewardExpressVideoActivity3.TRI > 0) {
                        if (!z12 || i11 < iWH || tTRewardExpressVideoActivity3.pFF.pFF.Xc() == 5 || TTRewardExpressVideoActivity.this.pFF.pFF.Xc() == 33) {
                            TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = TTRewardExpressVideoActivity.this;
                            tTRewardExpressVideoActivity4.pFF.cJ.sc(String.valueOf(tTRewardExpressVideoActivity4.TRI), null);
                        } else {
                            TTRewardExpressVideoActivity.this.pFF.sc(true);
                            TTRewardExpressVideoActivity tTRewardExpressVideoActivity5 = TTRewardExpressVideoActivity.this;
                            tTRewardExpressVideoActivity5.pFF.cJ.sc(String.valueOf(tTRewardExpressVideoActivity5.TRI), TTAdDislikeToast.getSkipText());
                            TTRewardExpressVideoActivity.this.pFF.cJ.ExN(true);
                        }
                    }
                }
            }
        });
        boolean zSc = this.pFF.JPJ.sc(j11, z11, map, this.zY);
        if (zSc && !z11) {
            ((TTRewardVideoActivity) this).UFX = (int) (System.currentTimeMillis() / 1000);
        }
        return zSc;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean wjp() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void zY() {
    }
}
