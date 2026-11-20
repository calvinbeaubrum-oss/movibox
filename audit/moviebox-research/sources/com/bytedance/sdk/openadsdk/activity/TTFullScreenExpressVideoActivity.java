package com.bytedance.sdk.openadsdk.activity;

import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.component.reward.pFF.Ol;
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
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public boolean sc(long j11, boolean z11) {
        Qj qj2 = this.pFF.cvk;
        qr qrVar = (qj2 == null || qj2.sc() == null) ? new qr() : this.pFF.cvk.sc().getAdShowTime();
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null || !(pff instanceof Ol)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
            scVar.JPJ.sc(scVar.cvk.pFF(), qrVar);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
            if (scVar2.qfG) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.pFF;
                scVar3.JPJ.sc(scVar3.cvk.pFF(), qrVar);
            } else {
                scVar2.JPJ.sc(((Ol) pff).HJN(), qrVar);
            }
        }
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
        this.pFF.JPJ.sc(new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.1

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            boolean f27530sc;

            @Override // t8.c.InterfaceC0849c
            public void pFF(long j12, int i11) {
                TTFullScreenExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (TTFullScreenExpressVideoActivity.this.pFF.JPJ.pFF()) {
                    TTFullScreenExpressVideoActivity.this.Ql();
                    return;
                }
                TTFullScreenExpressVideoActivity.this.pFF.JPJ.Ql();
                Tf.sc("TTAD.FSEVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                TTFullScreenExpressVideoActivity.this.pFF.cvk.sc(true);
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                if (!tTFullScreenExpressVideoActivity.pFF.zY) {
                    tTFullScreenExpressVideoActivity.finish();
                    return;
                }
                tTFullScreenExpressVideoActivity.sc(false, 3);
                Xc xc2 = TTFullScreenExpressVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, 2);
            }

            @Override // t8.c.InterfaceC0849c
            public void sc() {
                TTFullScreenExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTFullScreenExpressVideoActivity.this.BT();
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                if (tTFullScreenExpressVideoActivity.pFF.zY) {
                    tTFullScreenExpressVideoActivity.sc(false, 6);
                } else {
                    tTFullScreenExpressVideoActivity.finish();
                }
                Xc xc2 = TTFullScreenExpressVideoActivity.this.pFF.JPJ;
                xc2.sc(!xc2.II() ? 1 : 0, !TTFullScreenExpressVideoActivity.this.pFF.JPJ.II() ? 1 : 0);
                TTFullScreenExpressVideoActivity.this.pFF.JPJ.Ql();
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, int i11) {
                if (this.f27530sc) {
                    return;
                }
                this.f27530sc = true;
                TTFullScreenExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                TTFullScreenExpressVideoActivity.this.BT();
                TTFullScreenExpressVideoActivity.this.pFF.JPJ.sc(j12, j12);
                TTFullScreenExpressVideoActivity.this.pFF.cvk.pFF(true);
                if (TTFullScreenExpressVideoActivity.this.pFF.pFF.Xc() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = TTFullScreenExpressVideoActivity.this.pFF;
                    if (scVar4.zY) {
                        scVar4.FI.zY().We();
                        Ql.pFF();
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.pFF.pFF.Xc() == 21 && !TTFullScreenExpressVideoActivity.this.pFF.pFF.We()) {
                    TTFullScreenExpressVideoActivity.this.pFF.pFF.pFF(true);
                    TTFullScreenExpressVideoActivity.this.pFF.BR.Xc();
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = TTFullScreenExpressVideoActivity.this.pFF;
                if (scVar5.zY) {
                    if (scVar5.pFF.Chh()) {
                        if (TTFullScreenExpressVideoActivity.this.pFF.cvk.Ol() == 1) {
                            TTFullScreenExpressVideoActivity.this.pFF.cJ.zY();
                            return;
                        }
                        return;
                    } else {
                        TTFullScreenExpressVideoActivity.this.sc(false, 5);
                        if (Sfl.ExN(TTFullScreenExpressVideoActivity.this.pFF.pFF)) {
                            return;
                        }
                        TTFullScreenExpressVideoActivity.this.pFF.JPJ.sc("skip", true);
                        return;
                    }
                }
                if (Sfl.ExN(scVar5.pFF)) {
                    TTFullScreenExpressVideoActivity.this.finish();
                    return;
                }
                Qj qj4 = TTFullScreenExpressVideoActivity.this.pFF.cvk;
                if (qj4 == null || qj4.sc() == null) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.pFF.cvk.sc().setTime("0", 0, 0, false);
                if (TTFullScreenExpressVideoActivity.this.pFF.cvk.Qj()) {
                    TTFullScreenExpressVideoActivity.this.pFF.cJ.sc("0", "X");
                    TTFullScreenExpressVideoActivity.this.pFF.cJ.ExN(true);
                    TTFullScreenExpressVideoActivity.this.pFF.cJ.zY();
                }
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = TTFullScreenExpressVideoActivity.this.pFF;
                if (!scVar4.yL && scVar4.JPJ.pFF()) {
                    TTFullScreenExpressVideoActivity.this.pFF.JPJ.BT();
                }
                if (TTFullScreenExpressVideoActivity.this.pFF.WH.get()) {
                    return;
                }
                TTFullScreenExpressVideoActivity.this.We.removeMessages(LogSeverity.NOTICE_VALUE);
                if (j12 != TTFullScreenExpressVideoActivity.this.pFF.JPJ.Qj()) {
                    TTFullScreenExpressVideoActivity.this.BT();
                }
                if (TTFullScreenExpressVideoActivity.this.pFF.JPJ.pFF()) {
                    TTFullScreenExpressVideoActivity.this.pFF.JPJ.sc(j12, j13);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                    long j14 = j12 / 1000;
                    tTFullScreenExpressVideoActivity.TRI = (int) (tTFullScreenExpressVideoActivity.pFF.JPJ.McK() - j14);
                    int i11 = (int) j14;
                    if ((TTFullScreenExpressVideoActivity.this.pFF.YIK.get() || TTFullScreenExpressVideoActivity.this.pFF.UFX.get()) && TTFullScreenExpressVideoActivity.this.pFF.JPJ.pFF()) {
                        TTFullScreenExpressVideoActivity.this.pFF.JPJ.BT();
                    }
                    Qj qj4 = TTFullScreenExpressVideoActivity.this.pFF.cvk;
                    if (qj4 != null && qj4.sc() != null) {
                        TTFullScreenExpressVideoActivity.this.pFF.cvk.sc().setTime(String.valueOf(TTFullScreenExpressVideoActivity.this.TRI), i11, 0, false);
                    }
                    if (TTFullScreenExpressVideoActivity.this.pFF.cvk.Qj() || TTFullScreenExpressVideoActivity.this.pFF.pFF.ixT()) {
                        TTFullScreenExpressVideoActivity.this.zY(i11);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = TTFullScreenExpressVideoActivity.this;
                        if (tTFullScreenExpressVideoActivity2.TRI >= 0) {
                            tTFullScreenExpressVideoActivity2.pFF.cJ.We(true);
                            TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = TTFullScreenExpressVideoActivity.this;
                            tTFullScreenExpressVideoActivity3.pFF.cJ.sc(String.valueOf(tTFullScreenExpressVideoActivity3.TRI), null);
                        }
                    }
                }
            }
        });
        return this.pFF.JPJ.sc(j11, z11, map, this.zY);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean wjp() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void zY() {
    }
}
