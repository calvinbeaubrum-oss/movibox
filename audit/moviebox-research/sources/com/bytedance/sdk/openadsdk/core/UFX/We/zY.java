package com.bytedance.sdk.openadsdk.core.UFX.We;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.Ol;
import com.bytedance.adsdk.ugeno.core.Ql;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.sdk.component.adexpress.pFF.Qj;
import com.bytedance.sdk.component.adexpress.pFF.SR;
import com.bytedance.sdk.component.adexpress.pFF.qr;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.core.widget.TRI;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements Ql, Tf, com.bytedance.sdk.component.adexpress.dynamic.We, com.bytedance.sdk.component.adexpress.pFF.We<View> {
    private static float Gb = 0.0f;
    private static float HJN = 0.0f;
    private static float II = 0.0f;
    private static float McK = 0.0f;
    protected static int Sfl = 24;
    private static long cvk;
    protected float BT;
    private Sfl Cb;
    protected String Dl;
    protected com.bytedance.sdk.openadsdk.core.model.Sfl ExN;
    private qr FI;
    protected JSONObject JPJ;
    protected SR Ol;
    protected Qj Qj;
    protected float Ql;
    protected float SR;
    protected sc TRI;
    protected float Tf;
    protected com.bytedance.adsdk.ugeno.pFF.zY UFX;
    private final boolean WP;
    protected JSONObject We;
    protected long Xc;
    protected WeakReference<View> YIK;
    private We cD;
    protected long dE;
    protected Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected FrameLayout f28260qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected Ol f28261sc;
    protected com.bytedance.adsdk.ugeno.pFF.zY<View> zY;
    protected boolean wjp = true;
    public SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> uEA = new SparseArray<>();
    private String OXF = "";
    private final com.bytedance.sdk.component.Qj.Qj cJ = new com.bytedance.sdk.component.Qj.Qj("ugen_render_template") { // from class: com.bytedance.sdk.openadsdk.core.UFX.We.zY.1
        @Override // java.lang.Runnable
        public void run() {
            zY zYVar = zY.this;
            zYVar.We = zYVar.sc();
            if (zY.this.Cb != null) {
                zY zYVar2 = zY.this;
                zYVar2.OXF = zYVar2.Cb.getUgenTemplateErrorReason();
            } else {
                zY.this.OXF = "expressView is null";
            }
            com.bytedance.sdk.openadsdk.core.SR.zY().post(zY.this.kX);
        }
    };
    private final Runnable kX = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.UFX.We.zY.2
        @Override // java.lang.Runnable
        public void run() {
            if (zY.this.FI != null) {
                zY zYVar = zY.this;
                zYVar.pFF(zYVar.FI);
            }
        }
    };
    private boolean BR = false;
    protected AtomicBoolean WH = new AtomicBoolean(false);

    static {
        if (Xc.sc() != null) {
            Sfl = Xc.pFF();
        }
    }

    public zY(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, boolean z11, sc scVar, ViewGroup viewGroup) {
        this.pFF = context;
        this.WP = z11;
        this.f28261sc = new Ol(context);
        this.ExN = sfl;
        this.TRI = scVar;
        this.f28260qr = new FrameLayout(context);
        if (viewGroup instanceof Sfl) {
            this.Cb = (Sfl) viewGroup;
        }
        this.Dl = scVar.We();
        JSONObject jSONObjectPFF = pFF();
        this.JPJ = jSONObjectPFF;
        this.cD = new We(this.pFF, this.ExN, this.Dl, jSONObjectPFF);
    }

    private void Qj() {
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY;
        if (this.zY == null) {
            return;
        }
        if (this.ExN.fb() && (zYVarZY = this.zY.zY("tvskip")) != 0) {
            zYVarZY.zY(8);
        }
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY2 = this.zY.zY("skip");
        if (zYVarZY2 != 0 && (zYVarZY2 instanceof com.bytedance.adsdk.ugeno.Ol.We.zY)) {
            if (!dE.ef().SR(String.valueOf(this.ExN.QT())) || this.ExN.Xc() == 5 || this.ExN.Xc() == 6 || this.ExN.Zn() == 3) {
                ((com.bytedance.adsdk.ugeno.Ol.We.zY) zYVarZY2).Qj("local://tt_close_btn");
                zYVarZY2.pFF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(qr qrVar) {
        this.TRI.HJN().sc();
        if (this.We == null) {
            qrVar.sc(133, "ugen template is null real reason is " + this.OXF);
            return;
        }
        if (this.JPJ == null) {
            qrVar.sc(133, "ugen data is null");
            return;
        }
        int iWe = We();
        if (this.f28261sc.sc()) {
            List<String> listPFF = this.f28261sc.pFF();
            if (listPFF == null) {
                qrVar.sc(TsExtractor.TS_STREAM_TYPE_DTS, "unknow widget");
                return;
            }
            qrVar.sc(TsExtractor.TS_STREAM_TYPE_DTS, "unknow widget;" + listPFF.toString());
            return;
        }
        if (iWe != 0) {
            qrVar.sc(iWe, "ugen render fail");
            return;
        }
        if (this.zY == null) {
            qrVar.sc(TsExtractor.TS_STREAM_TYPE_DTS, "ugen render error");
            return;
        }
        pFF pff = new pFF();
        this.Ol = pff;
        pff.sc(true);
        this.Ol.sc(zY());
        setSoundMute(this.WP);
        Qj();
        com.bytedance.adsdk.ugeno.pFF.zY zYVarTRI = TRI();
        this.UFX = zYVarTRI;
        if (zYVarTRI != null && (zYVarTRI instanceof com.bytedance.sdk.openadsdk.core.UFX.pFF.sc.pFF)) {
            ((pFF) this.Ol).sc((FrameLayout) ((com.bytedance.sdk.openadsdk.core.UFX.pFF.sc.pFF) zYVarTRI).yL());
        }
        com.bytedance.adsdk.ugeno.pFF.zY zYVarQr = qr();
        We we2 = this.cD;
        if (we2 != null) {
            we2.sc();
        }
        if (zYVarQr != null && zYVarQr.Ol() != null) {
            this.YIK = new WeakReference<>(zYVarQr.Ol());
        }
        this.f28260qr.addView(this.zY.Ol(), new FrameLayout.LayoutParams(this.zY.Cb(), this.zY.OXF()));
        float fCvk = this.TRI.cvk();
        float fII = this.TRI.II();
        float fZY = kX.zY(this.pFF, fCvk);
        float fZY2 = kX.zY(this.pFF, fII);
        if (zY() != 7) {
            this.f28260qr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else if (fII <= 0.0f) {
            this.f28260qr.setLayoutParams(new FrameLayout.LayoutParams((int) fZY, -2));
        } else {
            this.f28260qr.setLayoutParams(new FrameLayout.LayoutParams((int) fZY, (int) fZY2));
        }
        if (fII <= 0.0f || fCvk <= 0.0f) {
            this.f28260qr.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int iWe2 = kX.We(this.pFF, this.f28260qr.getMeasuredWidth());
            int iWe3 = kX.We(this.pFF, this.f28260qr.getMeasuredHeight());
            this.Ol.sc(iWe2);
            this.Ol.pFF(iWe3);
        } else {
            this.Ol.sc(fCvk);
            this.Ol.pFF(fII);
        }
        if (this.WH.get()) {
            qrVar.sc(137, "ugen render timeout");
        } else {
            qrVar.sc(this.f28260qr, this.Ol);
        }
    }

    private void pFF(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY;
        View viewOl;
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar = this.zY;
        if (zYVar == null || (zYVarZY = zYVar.zY("skip")) == 0 || (viewOl = zYVarZY.Ol()) == null) {
            return;
        }
        int i12 = 0;
        if (!z11 && !z12) {
            i12 = 8;
        }
        viewOl.setVisibility(i12);
    }

    private void sc(WH wh2) {
        JSONObject jSONObjectWe;
        boolean zSc;
        int i11;
        String str;
        We we2;
        We we3;
        We we4;
        if (this.Qj == null) {
            return;
        }
        String strOptString = wh2.zY().optString("type");
        if ("swiperLeft".equals(strOptString) && (we4 = this.cD) != null) {
            we4.pFF();
            return;
        }
        if ("swiperRight".equals(strOptString) && (we3 = this.cD) != null) {
            we3.zY();
            return;
        }
        if (!"swiperClick".equals(strOptString) || (we2 = this.cD) == null) {
            jSONObjectWe = null;
            zSc = false;
            i11 = 0;
        } else {
            zSc = we2.sc(wh2);
            jSONObjectWe = this.cD.We();
            i11 = 2;
        }
        strOptString.hashCode();
        switch (strOptString) {
            case "privacy":
                i11 = 7;
                break;
            case "feedback":
                i11 = 3;
                break;
            case "mute":
                i11 = 5;
                break;
            case "skip":
                i11 = 6;
                break;
            case "video":
                i11 = 4;
                break;
            case "creative":
                i11 = 2;
                break;
        }
        com.bytedance.adsdk.ugeno.pFF.zY zYVarSc = wh2.sc();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.YIK;
        if (weakReference != null) {
            int[] iArrSc = kX.sc(weakReference.get());
            if (iArrSc != null) {
                iArr = iArrSc;
            }
            int[] iArrZY = kX.zY(this.YIK.get());
            if (iArrZY != null) {
                iArr2 = iArrZY;
            }
        }
        com.bytedance.sdk.openadsdk.core.model.SR.sc scVarSc = new com.bytedance.sdk.openadsdk.core.model.SR.sc().We(this.Tf).zY(this.Ql).pFF(this.SR).sc(this.BT).pFF(this.dE).sc(this.Xc).zY(iArr[0]).We(iArr[1]).ExN(iArr2[0]).TRI(iArr2[1]).sc(this.uEA).sc(wh2.pFF() != 1 || this.wjp);
        if (zYVarSc == null) {
            str = "";
        } else {
            str = zYVarSc.cD() + "_" + zYVarSc.Gb();
        }
        this.Qj.sc(wh2.sc().Ol(), i11, scVarSc.sc(str).pFF(zSc).pFF(jSONObjectWe).sc());
    }

    private void sc(CharSequence charSequence, boolean z11, int i11, boolean z12) {
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY;
        int i12;
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar = this.zY;
        if (zYVar == null || (zYVarZY = zYVar.zY("countdown")) == 0) {
            return;
        }
        View viewOl = zYVarZY.Ol();
        if (viewOl instanceof TextView) {
            try {
                i12 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.Tf.sc("UGenRender", "parse duration exception", charSequence);
                i12 = 0;
            }
            if (z12 || i12 <= 0 || this.BR) {
                viewOl.setVisibility(8);
                return;
            }
            viewOl.setVisibility(0);
            if (!z11 && this.TRI.sc() && com.bytedance.sdk.component.adexpress.We.qr.pFF(this.TRI.We())) {
                ((TextView) viewOl).setText(String.format(com.bytedance.sdk.component.utils.Sfl.sc(com.bytedance.sdk.component.adexpress.We.sc(), "tt_reward_full_skip"), Integer.valueOf(i11)));
                return;
            }
            if (!"open_ad".equals(this.TRI.We()) && this.TRI.sc()) {
                this.BR = true;
                viewOl.setVisibility(8);
            } else {
                ((TextView) viewOl).setText(((Object) charSequence) + "s");
            }
        }
    }

    private void sc(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY;
        if (this.zY == null || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(strOptString2) || (zYVarZY = this.zY.zY(strOptString2)) == 0) {
            return;
        }
        if (TextUtils.equals(strOptString, "onShow")) {
            zYVarZY.zY(0);
        } else if (TextUtils.equals(strOptString, "onDismiss")) {
            zYVarZY.zY(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public View ExN() {
        return this.f28260qr;
    }

    public com.bytedance.adsdk.ugeno.pFF.zY TRI() {
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar = this.zY;
        if (zYVar == null) {
            return null;
        }
        return zYVar.zY("video");
    }

    public int We() {
        this.f28261sc.sc((Tf) this);
        this.f28261sc.sc((Ql) this);
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVarSc = this.f28261sc.sc(this.We);
        this.zY = zYVarSc;
        We we2 = this.cD;
        if (we2 != null && zYVarSc != null) {
            we2.sc(zYVarSc);
        }
        this.TRI.HJN().pFF();
        this.TRI.HJN().zY();
        this.f28261sc.pFF(this.JPJ);
        return 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void onvideoComplate() {
    }

    public JSONObject pFF() {
        return this.TRI.McK();
    }

    public com.bytedance.adsdk.ugeno.pFF.zY qr() {
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar = this.zY;
        if (zYVar == null) {
            return null;
        }
        return zYVar.zY("feedback");
    }

    public JSONObject sc() {
        return this.TRI.zY();
    }

    @Override // com.bytedance.adsdk.ugeno.core.Tf
    public void sc(WH wh2, Tf.pFF pff, Tf.sc scVar) {
        if (wh2 == null) {
            return;
        }
        if (wh2.pFF() == 1 || wh2.pFF() == 4) {
            sc(wh2);
        }
        if (wh2.pFF() == 10) {
            sc(wh2.zY());
        }
        if (pff == null || wh2.We() == null) {
            return;
        }
        pff.sc(wh2.We());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x00af  */
    @Override // com.bytedance.adsdk.ugeno.core.Ql
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, MotionEvent motionEvent) {
        int i11;
        int action = motionEvent.getAction();
        int i12 = 1;
        if (action != 0) {
            int i13 = -1;
            if (action == 1) {
                this.SR = motionEvent.getRawX();
                this.BT = motionEvent.getRawY();
                if (Math.abs(this.SR - this.Tf) < Sfl || Math.abs(this.BT - this.Ql) >= Sfl) {
                    this.wjp = false;
                }
                this.Xc = System.currentTimeMillis();
                i11 = i13;
            } else if (action != 2) {
                i11 = -1;
            } else {
                HJN += Math.abs(motionEvent.getX() - II);
                Gb += Math.abs(motionEvent.getY() - McK);
                II = motionEvent.getX();
                McK = motionEvent.getY();
                if (System.currentTimeMillis() - cvk > 200) {
                    float f11 = HJN;
                    int i14 = Sfl;
                    if (f11 <= i14 && Gb <= i14) {
                        i12 = 2;
                    }
                } else {
                    i12 = 2;
                }
                if (Math.abs(motionEvent.getRawX() - this.Tf) >= Sfl || Math.abs(motionEvent.getRawY() - this.Ql) >= Sfl) {
                    this.wjp = false;
                }
                i13 = i12;
                this.SR = motionEvent.getRawX();
                this.BT = motionEvent.getRawY();
                if (Math.abs(this.SR - this.Tf) < Sfl) {
                    this.wjp = false;
                } else {
                    this.wjp = false;
                }
                this.Xc = System.currentTimeMillis();
                i11 = i13;
            }
        } else {
            this.dE = System.currentTimeMillis();
            this.Tf = motionEvent.getRawX();
            this.Ql = motionEvent.getRawY();
            this.wjp = true;
            cvk = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.Ol.zY.sc(motionEvent);
            i11 = 0;
        }
        this.uEA.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.pFF.zY.sc(i11, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }

    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
    }

    public void sc(Qj qj2) {
        this.Qj = qj2;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public void sc(qr qrVar) {
        this.FI = qrVar;
        Cb.pFF(this.cJ);
    }

    public void sc(TRI tri) {
        We we2 = this.cD;
        if (we2 != null) {
            we2.sc(tri);
        }
    }

    public void sc(boolean z11) {
        this.WH.set(z11);
    }

    public void setSoundMute(boolean z11) {
        com.bytedance.adsdk.ugeno.pFF.zY<T> zYVarZY;
        com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar = this.zY;
        if (zYVar == null || (zYVarZY = zYVar.zY(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) == 0) {
            return;
        }
        if (z11) {
            ((com.bytedance.adsdk.ugeno.Ol.We.zY) zYVarZY).Qj("local://tt_reward_full_mute");
        } else {
            ((com.bytedance.adsdk.ugeno.Ol.We.zY) zYVarZY).Qj("local://tt_reward_full_unmute");
        }
        zYVarZY.pFF();
    }

    public void setTime(CharSequence charSequence, int i11, int i12, boolean z11) {
        if (this.zY == null) {
            return;
        }
        boolean z12 = i11 == 1;
        sc(charSequence, z12, i12, z11);
        pFF(charSequence, z12, i12, z11);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setTimeUpdate(int i11) {
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public int zY() {
        return this.ExN.cvk();
    }
}
