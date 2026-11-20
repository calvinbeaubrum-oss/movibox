package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.pFF.Ol;
import com.bytedance.sdk.openadsdk.component.reward.view.Qj;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.bytedance.sdk.openadsdk.utils.Tf;
import com.google.logging.type.LogSeverity;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends sc {
    int ExN;
    private boolean TRI;

    public We(pFF pff, Sfl sfl, int i11) {
        super(pff, sfl, i11);
    }

    private void ExN(int i11) {
        this.zY.cJ.sc(null, new SpannableStringBuilder(String.format(com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_skip_ad_time_text"), Integer.valueOf(i11))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We(int i11) {
        int iSfl = Xc.We().Sfl(String.valueOf(this.zY.TRI));
        if (!Xc.We().TRI(String.valueOf(this.zY.TRI)) || (!Sfl.ExN(this.zY.pFF) && !this.zY.zY)) {
            if (i11 >= iSfl) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
                if (!scVar.fT) {
                    scVar.sc(true);
                }
                pFF();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
        if (!scVar2.fT) {
            scVar2.sc(true);
        }
        if (i11 > iSfl) {
            pFF();
        } else {
            ExN(iSfl - i11);
            this.zY.cJ.ExN(false);
        }
    }

    private boolean pFF(Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        return Xc.We().YIK(String.valueOf(this.zY.TRI));
    }

    private boolean sc(Sfl sfl) {
        return sfl == null || sfl.AZJ() == 100.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public boolean a_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TRI
    public String b_() {
        return "fullscreen_interstitial_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void c_() {
        if (this.zY.pFF.AZJ() != 100.0f) {
            this.TRI = true;
        }
        HJN();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.bytedance.sdk.openadsdk.activity.sc
    public void pFF() {
        if (Sfl.ExN(this.zY.pFF)) {
            this.zY.cJ.sc(null, TTAdDislikeToast.getSkipText());
        } else {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
            if (scVar.zY) {
                this.zY.cJ.sc(null, TTAdDislikeToast.getSkipText());
            } else {
                scVar.cJ.sc(null, "X");
            }
        }
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
    public void sc(Bundle bundle) {
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public boolean sc(long j11, boolean z11) {
        if (!this.Qj.sc()) {
            qr qrVar = new qr();
            qrVar.sc(System.currentTimeMillis(), 1.0f);
            com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.pFF;
            if (pff == null || !(pff instanceof Ol)) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
                scVar.JPJ.sc(scVar.BR.TRI(), qrVar);
            } else {
                this.zY.JPJ.sc(((Ol) pff).HJN(), qrVar);
            }
            c.InterfaceC0849c interfaceC0849c = new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.We.4

                /* JADX INFO: renamed from: sc, reason: collision with root package name */
                boolean f27624sc;

                @Override // t8.c.InterfaceC0849c
                public void pFF(long j12, int i11) {
                    ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    if (We.this.zY.JPJ.pFF()) {
                        We.this.ExN();
                        return;
                    }
                    We.this.zY.JPJ.Ql();
                    pFF pffFI = We.this.FI();
                    We we2 = We.this;
                    pffFI.sc(we2, we2.pFF(3));
                }

                @Override // t8.c.InterfaceC0849c
                public void sc() {
                    ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    We.this.Ql();
                    pFF pffFI = We.this.FI();
                    We we2 = We.this;
                    pffFI.sc(we2, we2.pFF(6));
                }

                @Override // t8.c.InterfaceC0849c
                public void sc(long j12, int i11) {
                    Tf tf2;
                    if (this.f27624sc) {
                        return;
                    }
                    this.f27624sc = true;
                    ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    We.this.Ql();
                    We.this.zY.JPJ.sc(j12, j12);
                    We.this.zY.Sfl.set(true);
                    if (We.this.zY.pFF.wdI()) {
                        We.this.zY.pFF.OXF(1);
                        We.this.zY.BR.Xc();
                    }
                    if (We.this.zY.pFF.Xc() == 21 && !We.this.zY.pFF.We()) {
                        We.this.zY.pFF.pFF(true);
                        We.this.zY.BR.Xc();
                    }
                    We we2 = We.this;
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = we2.zY;
                    if (scVar2.otH) {
                        pFF.ExN exNPFF = we2.pFF(5);
                        exNPFF.ExN = true;
                        We.this.FI().sc(We.this, exNPFF);
                        return;
                    }
                    if (!scVar2.zY) {
                        if (scVar2.pFF.Chh()) {
                            We.this.zY.cJ.zY();
                            return;
                        }
                        if (!Sfl.ExN(We.this.zY.pFF)) {
                            We.this.zY.JPJ.sc("skip", true);
                        }
                        We.this.cvk();
                        return;
                    }
                    if (scVar2.pFF.Chh()) {
                        We.this.zY.cJ.zY();
                        return;
                    }
                    We.this.sc(false, 5);
                    if (com.bytedance.sdk.openadsdk.core.model.Xc.pFF(We.this.zY.pFF) && (tf2 = We.this.zY.NP) != null) {
                        tf2.sc(0L);
                    }
                    if (Sfl.ExN(We.this.zY.pFF)) {
                        return;
                    }
                    We.this.zY.JPJ.sc("skip", true);
                }

                @Override // t8.c.InterfaceC0849c
                public void sc(long j12, long j13) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = We.this.zY;
                    if (!scVar2.yL && scVar2.JPJ.pFF()) {
                        We.this.zY.JPJ.BT();
                    }
                    if (We.this.zY.WH.get()) {
                        return;
                    }
                    ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                    if (j12 != We.this.zY.JPJ.Qj()) {
                        We.this.Ql();
                    }
                    We.this.zY.JPJ.sc(j12, j13);
                    We we2 = We.this;
                    long j14 = j12 / 1000;
                    we2.ExN = (int) (we2.zY.JPJ.McK() - j14);
                    int i11 = (int) j14;
                    if ((We.this.zY.YIK.get() || We.this.zY.UFX.get()) && We.this.zY.JPJ.pFF()) {
                        We.this.zY.JPJ.BT();
                    }
                    We.this.We(i11);
                    We.this.sc((j12 * 1.0f) / j13);
                    We we3 = We.this;
                    int i12 = we3.ExN;
                    if (i12 >= 0) {
                        we3.zY.cJ.sc(String.valueOf(i12), null);
                    }
                }
            };
            this.zY.JPJ.sc(interfaceC0849c);
            com.bytedance.sdk.openadsdk.core.model.Xc xc2 = this.zY.BR.BT;
            if (xc2 != null) {
                xc2.sc(interfaceC0849c);
            }
            return this.zY.JPJ.sc(j11, z11, null, this.pFF);
        }
        Qj qj2 = this.zY.cvk;
        qr qrVar2 = (qj2 == null || qj2.sc() == null) ? new qr() : this.zY.cvk.sc().getAdShowTime();
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff2 = this.pFF;
        if (pff2 == null || !(pff2 instanceof Ol)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.zY;
            scVar2.JPJ.sc(scVar2.cvk.pFF(), qrVar2);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.zY;
            if (scVar3.qfG) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.zY;
                scVar4.JPJ.sc(scVar4.cvk.pFF(), qrVar2);
            } else {
                scVar3.JPJ.sc(((Ol) pff2).HJN(), qrVar2);
            }
        }
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
        this.zY.JPJ.sc(new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.We.3

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            boolean f27623sc;

            @Override // t8.c.InterfaceC0849c
            public void pFF(long j12, int i11) {
                ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                if (We.this.zY.JPJ.pFF()) {
                    We.this.ExN();
                    return;
                }
                We.this.zY.JPJ.Ql();
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdScene", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                We.this.zY.cvk.sc(true);
                pFF pffFI = We.this.FI();
                We we2 = We.this;
                pffFI.sc(we2, we2.pFF(3));
            }

            @Override // t8.c.InterfaceC0849c
            public void sc() {
                ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                We.this.Ql();
                pFF pffFI = We.this.FI();
                We we2 = We.this;
                pffFI.sc(we2, we2.pFF(6));
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, int i11) {
                if (this.f27623sc) {
                    return;
                }
                this.f27623sc = true;
                ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                We.this.Ql();
                We.this.zY.JPJ.sc(j12, j12);
                We.this.zY.cvk.pFF(true);
                if (We.this.zY.pFF.Xc() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = We.this.zY;
                    if (scVar5.zY) {
                        scVar5.FI.zY().We();
                        Ql.pFF();
                    }
                }
                if (We.this.zY.pFF.Xc() == 21 && !We.this.zY.pFF.We()) {
                    We.this.zY.pFF.pFF(true);
                    We.this.zY.BR.Xc();
                }
                We we2 = We.this;
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar6 = we2.zY;
                if (scVar6.otH) {
                    pFF.ExN exNPFF = we2.pFF(5);
                    exNPFF.ExN = true;
                    We.this.FI().sc(We.this, exNPFF);
                    return;
                }
                if (scVar6.zY) {
                    if (scVar6.pFF.Chh()) {
                        if (We.this.zY.cvk.Ol() == 1) {
                            We.this.zY.cJ.zY();
                            return;
                        }
                        return;
                    } else {
                        We.this.sc(false, 5);
                        if (Sfl.ExN(We.this.zY.pFF)) {
                            return;
                        }
                        We.this.zY.JPJ.sc("skip", true);
                        return;
                    }
                }
                if (Sfl.ExN(scVar6.pFF)) {
                    We.this.cvk();
                    return;
                }
                Qj qj4 = We.this.zY.cvk;
                if (qj4 == null || qj4.sc() == null) {
                    return;
                }
                We.this.zY.cvk.sc().setTime("0", 0, 0, false);
                if (We.this.zY.cvk.Qj()) {
                    We.this.zY.cJ.sc("0", "X");
                    We.this.zY.cJ.ExN(true);
                    We.this.zY.cJ.zY();
                }
            }

            @Override // t8.c.InterfaceC0849c
            public void sc(long j12, long j13) {
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = We.this.zY;
                if (!scVar5.yL && scVar5.JPJ.pFF()) {
                    We.this.zY.JPJ.BT();
                }
                if (We.this.zY.WH.get()) {
                    return;
                }
                ((sc) We.this).f27638sc.removeMessages(LogSeverity.NOTICE_VALUE);
                if (j12 != We.this.zY.JPJ.Qj()) {
                    We.this.Ql();
                }
                if (We.this.zY.JPJ.pFF()) {
                    We.this.zY.JPJ.sc(j12, j13);
                    We we2 = We.this;
                    long j14 = j12 / 1000;
                    we2.ExN = (int) (we2.zY.JPJ.McK() - j14);
                    int i11 = (int) j14;
                    if ((We.this.zY.YIK.get() || We.this.zY.UFX.get()) && We.this.zY.JPJ.pFF()) {
                        We.this.zY.JPJ.BT();
                    }
                    Qj qj4 = We.this.zY.cvk;
                    if (qj4 != null && qj4.sc() != null) {
                        We.this.zY.cvk.sc().setTime(String.valueOf(We.this.ExN), i11, 0, false);
                    }
                    We.this.sc((j12 * 1.0f) / j13);
                    if (We.this.zY.cvk.Qj() || We.this.zY.pFF.ixT()) {
                        We.this.We(i11);
                        We we3 = We.this;
                        if (we3.ExN >= 0) {
                            we3.zY.cJ.We(true);
                            We we4 = We.this;
                            we4.zY.cJ.sc(String.valueOf(we4.ExN), null);
                        }
                    }
                }
            }
        });
        return this.zY.JPJ.sc(j11, z11, map, this.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc
    public void zY() {
        final View viewWH = this.zY.BR.WH();
        if (viewWH != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.We.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (We.this.zY.Cb.cvk() && We.this.zY.WH.get()) {
                        boolean zQl = We.this.zY.OXF.Ql();
                        We.this.zY.Cb.ExN(zQl);
                        We.this.zY.BR.ExN(8);
                        We.this.zY.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 5000L);
                        if (!Sfl.zY(We.this.zY.pFF)) {
                            return;
                        }
                        if (Sfl.zY(We.this.zY.pFF) && zQl) {
                            return;
                        }
                    }
                    if (We.this.zY.pFF.vzC()) {
                        if (We.this.zY.pFF.ymG()) {
                            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = We.this.zY;
                            if (scVar.kX != null) {
                                scVar.pFF.OXF(2);
                                if (We.this.zY.kX.ExN()) {
                                    return;
                                }
                            }
                        } else if (We.this.zY.pFF.Vb() == 0 && !We.this.zY.Cb.Xc()) {
                            We.this.zY.pFF.OXF(11);
                            if (We.this.zY.Cb.We()) {
                                We.this.zY.pFF.OXF(12);
                            }
                            try {
                                We.this.zY.BR.Xc();
                                return;
                            } catch (Exception unused) {
                            }
                        }
                    }
                    We.this.zY.Cb.II();
                    We.this.zY.OXF.UFX();
                    We.this.zY.McK.TRI();
                    We.this.cvk();
                }
            };
            viewWH.setOnClickListener(onClickListener);
            viewWH.setTag(viewWH.getId(), onClickListener);
        }
        this.zY.cJ.sc(new com.bytedance.sdk.openadsdk.component.reward.top.pFF() { // from class: com.bytedance.sdk.openadsdk.activity.We.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void We(View view) {
                View view2 = viewWH;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void pFF(View view) {
                We we2 = We.this;
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = we2.zY;
                scVar.f27908eo = !scVar.f27908eo;
                com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = we2.pFF;
                if (pff != null && pff.We() != null) {
                    We.this.pFF.We().sc(We.this.zY.f27908eo);
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = We.this.zY;
                scVar2.JPJ.pFF(scVar2.f27908eo);
                if (!JPJ.Sfl(We.this.zY.pFF) || We.this.zY.WH.get()) {
                    if (JPJ.qr(We.this.zY.pFF)) {
                        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = We.this.zY;
                        scVar3.cD.sc(scVar3.f27908eo, true);
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = We.this.zY;
                    scVar4.Cb.We(scVar4.f27908eo);
                    Sfl sfl = We.this.zY.pFF;
                    if (sfl == null || sfl.GOt() == null || We.this.zY.pFF.GOt().sc() == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = We.this.zY;
                    if (scVar5.JPJ != null) {
                        if (scVar5.f27908eo) {
                            scVar5.pFF.GOt().sc().Qj(We.this.zY.JPJ.qr());
                        } else {
                            scVar5.pFF.GOt().sc().Ol(We.this.zY.JPJ.qr());
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void sc(View view) {
                if (JPJ.Qj(We.this.zY.pFF) && (JPJ.wjp(We.this.zY.pFF) || We.this.zY.WH.get())) {
                    if (We.this.zY.WP.sc()) {
                        We.this.zY.WP.sc(5);
                        return;
                    } else {
                        We.this.zY.Cb.Qj();
                        return;
                    }
                }
                if (JPJ.wjp(We.this.zY.pFF) || (com.bytedance.sdk.openadsdk.core.model.Xc.sc(We.this.zY.pFF) && !We.this.zY.dE.get())) {
                    if (!JPJ.Qj(We.this.zY.pFF) && We.this.zY.WP.sc()) {
                        We.this.zY.WP.sc(4);
                    }
                    We.this.cvk();
                    return;
                }
                if (We.this.zY.pFF.uoi()) {
                    if (We.this.zY.BR.UFX() != null) {
                        We.this.zY.pFF.OXF(2);
                        We.this.zY.BR.Xc();
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = We.this.zY;
                if (!scVar.zY && scVar.pFF.vzC() && !We.this.zY.pFF.ymG()) {
                    We.this.zY.pFF.OXF(13);
                    try {
                        We.this.zY.BR.Xc();
                        return;
                    } catch (Exception unused) {
                    }
                }
                BT.sc scVar2 = new BT.sc();
                scVar2.sc(We.this.zY.JPJ.qr());
                scVar2.zY(We.this.zY.JPJ.Sfl());
                scVar2.pFF(We.this.zY.JPJ.UFX());
                scVar2.zY(3);
                scVar2.We(We.this.zY.JPJ.wjp());
                com.bytedance.sdk.openadsdk.We.ExN.sc.sc.sc(We.this.zY.JPJ.zY(), scVar2, We.this.zY.JPJ.sc());
                com.bytedance.sdk.openadsdk.core.JPJ.zY(We.this.zY.TRI);
                We.this.zY.JPJ.sc("skip", false);
                We.this.zY.cJ.We(false);
                We we2 = We.this;
                if (we2.zY.zY) {
                    we2.sc(true, 4);
                } else {
                    we2.cvk();
                }
                Sfl sfl = We.this.zY.pFF;
                if (sfl != null && sfl.GOt() != null) {
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = We.this.zY;
                    if (scVar3.JPJ != null) {
                        scVar3.pFF.GOt().sc().TRI(We.this.zY.JPJ.qr());
                        We.this.zY.pFF.GOt().sc().ExN(We.this.zY.JPJ.qr());
                    }
                }
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(We.this.zY.pFF, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.pFF
            public void zY(View view) {
                We we2 = We.this;
                we2.zY.Gb.sc(we2.pFF);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.sc, com.bytedance.sdk.openadsdk.activity.TRI
    public void zY(Activity activity) {
        super.zY(activity);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.zY;
        if (scVar == null || !pFF(scVar.pFF) || sc(this.zY.pFF)) {
            return;
        }
        if (this.TRI) {
            this.TRI = false;
            cvk();
        } else if (this.zY.Cb.OXF()) {
            cvk();
        }
    }
}
