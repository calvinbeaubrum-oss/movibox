package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Gb;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.cD;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Sfl extends com.bytedance.sdk.openadsdk.core.ExN.zY implements com.bytedance.sdk.component.adexpress.dynamic.We, com.bytedance.sdk.component.adexpress.pFF.BT, com.bytedance.sdk.component.adexpress.pFF.Qj, SR, com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc {
    public static int Dl = 500;
    private boolean BR;
    protected com.bytedance.sdk.component.adexpress.pFF.zY BT;
    private int Bs;
    private final AtomicBoolean CYO;
    private com.bytedance.sdk.openadsdk.We.We.ExN Cb;
    private float DNB;
    private PAGExpressAdWrapperListener ExN;
    boolean FI;
    private final Runnable GI;
    private float Gb;
    private String HJN;
    protected com.bytedance.sdk.component.adexpress.pFF.pFF II;
    int JPJ;
    private Dl JoC;
    public com.bytedance.sdk.component.adexpress.pFF.We<? extends View> McK;
    private final Runnable MxZ;
    private long NP;
    private float NQ;
    private com.bytedance.sdk.component.adexpress.pFF.dE OKY;
    private String OXF;
    protected String Ol;
    private final Runnable QLv;
    protected final Context Qj;
    protected boolean Ql;
    protected boolean SR;
    protected String Sfl;
    private Qj TRI;
    public FrameLayout Tf;
    protected com.bytedance.sdk.openadsdk.core.model.Sfl UFX;
    protected AdSlot WH;
    public com.bytedance.sdk.openadsdk.We.qr WP;
    private TTDislikeDialogAbstract We;
    boolean Xc;
    protected HashSet<String> YIK;
    private final SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> YdT;
    private com.bytedance.sdk.component.adexpress.pFF.WH.sc Yhz;
    private com.bytedance.sdk.openadsdk.core.UFX.We.zY ZM;
    private float bSP;
    private float cD;
    private String cJ;
    long cvk;
    protected boolean dE;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private ThemeStatusBroadcastReceiver f28061eo;
    private com.bytedance.sdk.component.adexpress.pFF.Ql fT;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.UFX.pFF.qr f28062ht;
    private com.bytedance.sdk.component.adexpress.pFF.Ol idT;
    private float kDg;
    private com.bytedance.sdk.openadsdk.core.zY.We.sc kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.pFF.TRI f28063ko;
    private com.bytedance.sdk.openadsdk.core.zY.qr otH;
    private int pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f28064pc;
    private zY qKn;
    private List<com.bytedance.sdk.component.adexpress.pFF.WH> qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Ol f28065qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f28066sc;
    public boolean uEA;
    protected int wjp;
    private JPJ yL;
    private com.bytedance.sdk.openadsdk.zY.zY zY;

    public Sfl(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot, String str) {
        super(context);
        this.f28066sc = true;
        this.pFF = 0;
        this.Ol = "embeded_ad";
        this.HJN = null;
        this.SR = false;
        this.dE = false;
        this.Xc = true;
        this.wjp = -1;
        this.OXF = "";
        this.uEA = false;
        this.BR = true;
        this.JPJ = -1;
        this.WP = new com.bytedance.sdk.openadsdk.We.qr();
        this.cvk = 0L;
        this.CYO = new AtomicBoolean(false);
        this.f28064pc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Sfl sfl2 = Sfl.this;
                if (sfl2.Xc) {
                    sfl2.Dl();
                    Sfl sfl3 = Sfl.this;
                    sfl3.removeCallbacks(sfl3.GI);
                    Sfl sfl4 = Sfl.this;
                    sfl4.postDelayed(sfl4.GI, 500L);
                }
            }
        };
        this.GI = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.2
            @Override // java.lang.Runnable
            public void run() {
                if (!Gb.sc(Sfl.this, 0, 5)) {
                    Sfl.this.TRI(8);
                } else {
                    Sfl sfl2 = Sfl.this;
                    sfl2.TRI(sfl2.getVisibility());
                }
            }
        };
        this.MxZ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.3
            @Override // java.lang.Runnable
            public void run() {
                Sfl.this.TRI(0);
            }
        };
        this.QLv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.4
            @Override // java.lang.Runnable
            public void run() {
                Sfl.this.TRI(8);
            }
        };
        this.Bs = 8;
        this.YdT = new SparseArray<>();
        this.bSP = -1.0f;
        this.NQ = -1.0f;
        this.kDg = -1.0f;
        this.DNB = -1.0f;
        this.NP = 0L;
        this.Ol = str;
        this.Qj = context;
        this.UFX = sfl;
        this.WH = adSlot;
        this.uEA = false;
        TRI();
    }

    public Sfl(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot, String str, boolean z11, boolean z12) {
        super(context);
        this.f28066sc = true;
        this.pFF = 0;
        this.Ol = "embeded_ad";
        this.HJN = null;
        this.SR = false;
        this.dE = false;
        this.Xc = true;
        this.wjp = -1;
        this.OXF = "";
        this.uEA = false;
        this.BR = true;
        this.JPJ = -1;
        this.WP = new com.bytedance.sdk.openadsdk.We.qr();
        this.cvk = 0L;
        this.CYO = new AtomicBoolean(false);
        this.f28064pc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Sfl sfl2 = Sfl.this;
                if (sfl2.Xc) {
                    sfl2.Dl();
                    Sfl sfl3 = Sfl.this;
                    sfl3.removeCallbacks(sfl3.GI);
                    Sfl sfl4 = Sfl.this;
                    sfl4.postDelayed(sfl4.GI, 500L);
                }
            }
        };
        this.GI = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.2
            @Override // java.lang.Runnable
            public void run() {
                if (!Gb.sc(Sfl.this, 0, 5)) {
                    Sfl.this.TRI(8);
                } else {
                    Sfl sfl2 = Sfl.this;
                    sfl2.TRI(sfl2.getVisibility());
                }
            }
        };
        this.MxZ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.3
            @Override // java.lang.Runnable
            public void run() {
                Sfl.this.TRI(0);
            }
        };
        this.QLv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.4
            @Override // java.lang.Runnable
            public void run() {
                Sfl.this.TRI(8);
            }
        };
        this.Bs = 8;
        this.YdT = new SparseArray<>();
        this.bSP = -1.0f;
        this.NQ = -1.0f;
        this.kDg = -1.0f;
        this.DNB = -1.0f;
        this.NP = 0L;
        this.Ol = str;
        this.Qj = context;
        this.UFX = sfl;
        this.WH = adSlot;
        this.uEA = z11;
        this.BR = z12;
        TRI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl() {
        if (this.CYO.get()) {
            this.WP.sc(System.currentTimeMillis(), Gb.sc(this));
        }
    }

    private void FI() {
        List<com.bytedance.sdk.component.adexpress.pFF.WH> list = this.qfG;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.pFF.WH> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void JPJ() {
        List<com.bytedance.sdk.component.adexpress.pFF.WH> list = this.qfG;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.pFF.WH> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void Sfl() {
        if (com.bytedance.sdk.openadsdk.core.SR.ExN()) {
            return;
        }
        Tf.sc();
    }

    private boolean WP() {
        return TextUtils.equals(this.Ol, "fullscreen_interstitial_ad") || TextUtils.equals(this.Ol, "rewarded_video") || TextUtils.equals("open_ad", this.Ol) || JPJ.pFF(this.Ol) || TextUtils.equals(this.Ol, "embeded_ad");
    }

    private void Xc() {
        if (this.UFX.qY() == 1 && this.UFX.ymG()) {
            com.bytedance.sdk.component.adexpress.pFF.TRI tri = new com.bytedance.sdk.component.adexpress.pFF.TRI(this.Qj, this.fT, new YIK(this, this.f28061eo, this.fT));
            this.f28063ko = tri;
            this.qfG.add(tri);
            this.Yhz = new com.bytedance.sdk.component.adexpress.pFF.Tf(this.qfG, this.idT);
            return;
        }
        if (WP()) {
            wjp();
            return;
        }
        try {
            Sfl();
            JPJ jpj = new JPJ(this.Qj, this.fT, this.f28061eo, this.Cb, this.UFX);
            this.yL = jpj;
            com.bytedance.sdk.component.adexpress.pFF.dE dEVar = new com.bytedance.sdk.component.adexpress.pFF.dE(this.Qj, this.fT, jpj, this);
            this.OKY = dEVar;
            this.qfG.add(dEVar);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("NativeExpressView", "NativeExpressView dynamicRender fail", e11);
        }
        com.bytedance.sdk.component.adexpress.pFF.TRI tri2 = new com.bytedance.sdk.component.adexpress.pFF.TRI(this.Qj, this.fT, new YIK(this, this.f28061eo, this.fT));
        this.f28063ko = tri2;
        this.qfG.add(tri2);
        this.Yhz = new com.bytedance.sdk.component.adexpress.pFF.Tf(this.qfG, this.idT);
    }

    private void YIK() {
        com.bytedance.sdk.openadsdk.core.TRI.sc.sc scVar = new com.bytedance.sdk.openadsdk.core.TRI.sc.sc();
        int i11 = this.pFF;
        if (i11 == 3) {
            com.bytedance.sdk.component.adexpress.dynamic.ExN.qr qrVar = new com.bytedance.sdk.component.adexpress.dynamic.ExN.qr();
            Context applicationContext = this.Qj.getApplicationContext();
            com.bytedance.sdk.component.adexpress.pFF.Ql ql2 = this.fT;
            ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = this.f28061eo;
            boolean z11 = this.uEA;
            com.bytedance.sdk.component.adexpress.pFF.pFF pff = new com.bytedance.sdk.component.adexpress.pFF.pFF(applicationContext, ql2, themeStatusBroadcastReceiver, z11, qrVar, this, scVar, new TRI(this.Qj, themeStatusBroadcastReceiver, z11, qrVar, ql2, scVar));
            this.II = pff;
            this.qfG.add(pff);
            return;
        }
        if (i11 == 7) {
            com.bytedance.sdk.openadsdk.core.UFX.We.zY zYVar = new com.bytedance.sdk.openadsdk.core.UFX.We.zY(this.Qj, this.UFX, this.uEA, (com.bytedance.sdk.openadsdk.core.UFX.We.sc) this.fT, this);
            this.ZM = zYVar;
            com.bytedance.sdk.openadsdk.core.UFX.pFF.qr qrVar2 = new com.bytedance.sdk.openadsdk.core.UFX.pFF.qr(this.Qj, zYVar, this, this.fT);
            this.f28062ht = qrVar2;
            this.qfG.add(qrVar2);
            return;
        }
        if (i11 == 10) {
            com.bytedance.sdk.openadsdk.core.UFX.pFF.qr qrVar3 = new com.bytedance.sdk.openadsdk.core.UFX.pFF.qr(this.Qj, new com.bytedance.sdk.openadsdk.core.UFX.We.ExN(this.Qj, this.UFX, this.uEA, (com.bytedance.sdk.openadsdk.core.UFX.We.sc) this.fT, this), this, this.fT);
            this.f28062ht = qrVar3;
            this.qfG.add(qrVar3);
            return;
        }
        JPJ jpj = new JPJ(this.Qj, this.fT, this.f28061eo, this.Cb, this.UFX);
        this.yL = jpj;
        com.bytedance.sdk.component.adexpress.pFF.dE dEVar = new com.bytedance.sdk.component.adexpress.pFF.dE(this.Qj, this.fT, jpj, this);
        this.OKY = dEVar;
        this.qfG.add(dEVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003f  */
    private void dE() {
        long jOptLong;
        boolean z11;
        com.bytedance.sdk.component.adexpress.pFF.Ql.sc scVar;
        com.bytedance.sdk.openadsdk.We.Xc xc2 = new com.bytedance.sdk.openadsdk.We.Xc(1, this.Ol, this.UFX);
        this.Cb = xc2;
        this.idT = new Ql(xc2, this.Ol, this.UFX, this.HJN);
        final boolean zCYO = this.UFX.CYO();
        try {
            com.bytedance.sdk.openadsdk.core.model.Sfl.sc scVarJoC = this.UFX.JoC();
            if (scVarJoC != null) {
                String strUFX = scVarJoC.UFX();
                if (TextUtils.isEmpty(strUFX)) {
                    jOptLong = 0;
                } else {
                    jOptLong = new JSONObject(strUFX).optLong("render_delay_time");
                }
            } else {
                jOptLong = 0;
            }
        } catch (Exception unused) {
        }
        try {
            z11 = !com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.UFX) && com.bytedance.sdk.openadsdk.core.Xc.We().Ql(this.HJN) == 1;
            try {
                if (!com.bytedance.sdk.openadsdk.core.settings.dE.ef().SR(this.HJN) || this.UFX.Xc() == 5 || this.UFX.Xc() == 6 || this.UFX.Zn() == 3) {
                    z11 = true;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            z11 = false;
        }
        long jMin = Math.min(Math.max(jOptLong, 0L), 10000L);
        int renderTimeout = getRenderTimeout();
        double dM = this.UFX.GI() != null ? this.UFX.GI().m() * ((double) this.UFX.GI().J()) : 0.0d;
        int i11 = this.JPJ;
        this.FI = i11 != -1 && i11 < ((int) dM);
        if (com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.UFX) || com.bytedance.sdk.openadsdk.core.UFX.zY.pFF(this.UFX)) {
            com.bytedance.sdk.openadsdk.core.UFX.We.sc.C0295sc c0295sc = new com.bytedance.sdk.openadsdk.core.UFX.We.sc.C0295sc();
            if (com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.UFX)) {
                c0295sc.sc(com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.UFX, this.Ol));
            }
            c0295sc.sc((com.bytedance.adsdk.ugeno.core.BT) this.idT);
            c0295sc.sc(this.Gb);
            c0295sc.pFF(this.cD);
            scVar = c0295sc;
        } else {
            scVar = new com.bytedance.sdk.component.adexpress.pFF.Ql.sc();
        }
        scVar.ExN(zCYO);
        scVar.sc(this.Ol).pFF(this.UFX.kDg()).zY(this.UFX.BU()).We(this.UFX.mD()).sc(this.idT).We(this.UFX.ra()).sc(renderTimeout).pFF(this.UFX.vYl()).zY(this.BR).pFF(this.UFX.HJN()).sc(jMin).zY(this.UFX.QLv()).sc(com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc(this.UFX)).We(z11).ExN(this.JPJ).sc(this.FI).sc(dM).TRI(com.bytedance.sdk.openadsdk.core.settings.dE.ef().PPh()).sc(new com.bytedance.sdk.component.adexpress.pFF.ExN() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.5
            @Override // com.bytedance.sdk.component.adexpress.pFF.ExN
            public JSONObject sc() {
                try {
                    Sfl sfl = Sfl.this;
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = sfl.UFX;
                    if (sfl2 == null) {
                        sfl.OXF = "material is null";
                        return null;
                    }
                    if (zCYO) {
                        sfl.JoC = new Dl();
                        float f11 = Sfl.this.Gb;
                        float f12 = Sfl.this.cD;
                        Sfl sfl3 = Sfl.this;
                        JSONObject jSONObjectSc = com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc(f11, f12, sfl3.SR, sfl3.UFX, sfl3.Ol, sfl3.JoC);
                        Sfl.this.OXF = com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc();
                        return jSONObjectSc;
                    }
                    if (!com.bytedance.sdk.openadsdk.core.UFX.zY.sc(sfl2)) {
                        float f13 = Sfl.this.Gb;
                        float f14 = Sfl.this.cD;
                        Sfl sfl4 = Sfl.this;
                        JSONObject jSONObjectSc2 = com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc(f13, f14, sfl4.SR, sfl4.UFX);
                        Sfl.this.sc(jSONObjectSc2);
                        return jSONObjectSc2;
                    }
                    Sfl.this.JoC = new Dl();
                    Sfl sfl5 = Sfl.this;
                    JSONObject jSONObjectSc3 = com.bytedance.sdk.openadsdk.core.UFX.zY.sc(sfl5.UFX, sfl5.JoC);
                    Sfl.this.OXF = com.bytedance.sdk.openadsdk.core.UFX.zY.sc();
                    return jSONObjectSc3;
                } catch (Throwable unused4) {
                    return null;
                }
            }
        });
        sc(scVar);
        this.fT = scVar.sc();
    }

    private int getAdSlotType() {
        String str = this.Ol;
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }

    private void qr() {
        com.bytedance.sdk.openadsdk.core.model.Sfl.sc scVarJoC = this.UFX.JoC();
        if (!TextUtils.equals(this.Ol, "embeded_ad") || scVarJoC == null) {
            return;
        }
        String strTf = scVarJoC.Tf();
        if (TextUtils.isEmpty(strTf)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strTf);
            int iOptInt = jSONObject.optInt("width");
            int iOptInt2 = jSONObject.optInt("height");
            if (iOptInt == 0 || iOptInt2 == 0) {
                return;
            }
            this.cD = iOptInt2;
            this.Gb = iOptInt;
        } catch (Exception unused) {
        }
    }

    public static JSONObject sc(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(TtmlNode.LEFT, iArr[0]);
            jSONObject.put("top", iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean uEA() {
        return com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.UFX);
    }

    private void wjp() {
        this.pFF = this.UFX.cvk();
        try {
            Sfl();
            YIK();
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("NativeExpressView", "NativeExpressView dynamicRender fail", e11);
        }
        boolean z11 = this.UFX.II() == 1;
        this.f28066sc = z11;
        if (z11) {
            com.bytedance.sdk.component.adexpress.pFF.TRI tri = new com.bytedance.sdk.component.adexpress.pFF.TRI(this.Qj, this.fT, new YIK(this, this.f28061eo, this.fT));
            this.f28063ko = tri;
            this.qfG.add(tri);
        }
        Objects.toString(this.qfG);
        this.Yhz = new com.bytedance.sdk.component.adexpress.pFF.Tf(this.qfG, this.idT);
    }

    public boolean BT() {
        return this.CYO.get();
    }

    public void ExN() {
    }

    public void ExN(int i11) {
        if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(this.UFX)) {
            com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
            if (we2 instanceof JPJ) {
                ((JPJ) we2).pFF(i11);
            }
        }
    }

    public void Ol() {
        if (this.UFX == null) {
            return;
        }
        this.cvk = SystemClock.elapsedRealtime();
        if (this.UFX.Pu()) {
            zY zYVar = this.qKn;
            if (zYVar == null) {
                a_(106);
                return;
            } else {
                zYVar.sc((com.bytedance.sdk.component.adexpress.pFF.BT) this);
                this.qKn.sc();
                return;
            }
        }
        this.Cb.sc();
        com.bytedance.sdk.component.adexpress.pFF.WH.sc scVar = this.Yhz;
        if (scVar != null) {
            scVar.sc(this);
        }
        try {
            this.Yhz.sc();
        } catch (Throwable unused) {
        }
    }

    public void Qj() {
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 instanceof JPJ) {
            if (we2 == null) {
                return;
            }
            ((JPJ) we2).Qj();
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
            com.bytedance.sdk.component.utils.qr.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.Sfl.6
                @Override // java.lang.Runnable
                public void run() {
                    Sfl.this.ExN(1);
                }
            }, ((long) (sfl != null ? sfl.WH().sc() : 5)) * 1000);
        }
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.UFX;
        if (sfl2 == null || sfl2.GOt() == null || this.UFX.GOt().sc() == null) {
            return;
        }
        this.UFX.GOt().sc().sc(0L);
    }

    public boolean Ql() {
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        return we2 != null && (we2 instanceof YIK);
    }

    public void SR() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
        if (sfl == null || sfl.GOt() == null || this.UFX.GOt().sc() == null) {
            return;
        }
        this.UFX.GOt().sc().ExN(getVideoProgress());
    }

    public void TRI() {
        this.YIK = new HashSet<>();
        this.f28061eo = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.WH;
        if (adSlot != null) {
            this.Gb = adSlot.getExpressViewAcceptedWidth();
            this.cD = this.WH.getExpressViewAcceptedHeight();
            qr();
            this.HJN = this.WH.getCodeId();
            if (TextUtils.equals(this.Ol, "fullscreen_interstitial_ad")) {
                this.JPJ = com.bytedance.sdk.openadsdk.core.Xc.We().Sfl(this.HJN);
            } else if (TextUtils.equals(this.Ol, "rewarded_video")) {
                this.JPJ = com.bytedance.sdk.openadsdk.core.Xc.We().WH(this.HJN);
            } else if (TextUtils.equals(this.Ol, "open_ad")) {
                int iUEA = com.bytedance.sdk.openadsdk.core.Xc.We().uEA(this.HJN);
                this.JPJ = iUEA;
                if (iUEA < 0) {
                    this.JPJ = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.UFX.Pu()) {
            this.qKn = new zY(this.Qj, this, this.UFX, this.Ol);
            return;
        }
        dE();
        this.qfG = new ArrayList();
        Xc();
        com.bytedance.sdk.component.adexpress.pFF.dE dEVar = this.OKY;
        if (dEVar != null) {
            this.yL = (JPJ) dEVar.pFF();
        }
        HJN jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.TRI(this.Ol);
        }
    }

    public void TRI(int i11) {
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 == null || !(we2 instanceof JPJ)) {
            return;
        }
        ((JPJ) we2).sc(i11);
        this.Bs = i11;
    }

    public void Tf() {
        try {
            FrameLayout frameLayout = this.Tf;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.Tf);
        } catch (Throwable unused) {
        }
    }

    public void UFX() {
        try {
            zY zYVar = this.qKn;
            if (zYVar != null) {
                zYVar.pFF();
            }
            SR();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<com.bytedance.sdk.component.adexpress.pFF.WH> list = this.qfG;
            if (list != null) {
                Iterator<com.bytedance.sdk.component.adexpress.pFF.WH> it = list.iterator();
                while (it.hasNext()) {
                    it.next().sc();
                }
            }
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.UFX);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF(this.UFX);
            this.zY = null;
            this.We = null;
            this.WH = null;
            this.UFX = null;
            this.ExN = null;
            this.TRI = null;
            this.BT = null;
            this.f28065qr = null;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("NativeExpressView", "detach error", th2);
        }
    }

    public void WH() {
        JPJ jpj = this.yL;
        if (jpj == null || jpj.ExN() == null) {
            return;
        }
        this.yL.TRI();
    }

    public int We() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.BT
    public void a_(int i11) {
        com.bytedance.sdk.component.adexpress.pFF.Ol ol2 = this.idT;
        if (ol2 != null) {
            if (!this.f28066sc) {
                ol2.Qj();
            }
            this.idT.Ol();
            ((Ql) this.idT).UFX();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ExN;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.Qj.sc(i11), i11);
        }
        Dl dl2 = this.JoC;
        if (dl2 != null) {
            dl2.sc(this.UFX, this.Ol);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i11;
        Qj qj2 = this.TRI;
        if (qj2 != null) {
            qj2.pFF(motionEvent.getDeviceId());
            this.TRI.sc(motionEvent.getSource());
            this.TRI.zY(motionEvent.getToolType(0));
        }
        Ol ol2 = this.f28065qr;
        if (ol2 != null) {
            ol2.pFF(motionEvent.getDeviceId());
            this.f28065qr.sc(motionEvent.getSource());
            this.f28065qr.zY(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.bSP = motionEvent.getRawX();
            this.NQ = motionEvent.getRawY();
            this.NP = System.currentTimeMillis();
            i11 = 0;
        } else if (actionMasked == 1) {
            i11 = 3;
        } else if (actionMasked != 2) {
            i11 = actionMasked != 3 ? -1 : 4;
        } else {
            this.kDg += Math.abs(motionEvent.getX() - this.bSP);
            this.DNB += Math.abs(motionEvent.getY() - this.NQ);
            this.bSP = motionEvent.getX();
            this.NQ = motionEvent.getY();
            i11 = (System.currentTimeMillis() - this.NP <= 200 || (this.kDg <= 8.0f && this.DNB <= 8.0f)) ? 2 : 1;
        }
        SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray = this.YdT;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.pFF.zY.sc(i11, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.sdk.openadsdk.We.qr getAdShowTime() {
        return this.WP;
    }

    public zY getBrandBannerController() {
        return this.qKn;
    }

    public Qj getClickCreativeListener() {
        return this.TRI;
    }

    public Ol getClickListener() {
        return this.f28065qr;
    }

    public String getClosedListenerKey() {
        return this.cJ;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 != null) {
            return we2.zY();
        }
        return 0;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.cD).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.Gb).intValue();
    }

    public HJN getJsObject() {
        JPJ jpj = this.yL;
        if (jpj != null) {
            return jpj.dE();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        WH whBT;
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (!(we2 instanceof JPJ) || (whBT = ((JPJ) we2).BT()) == null) {
            return 0;
        }
        return whBT.sc();
    }

    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.Xc.We().II();
    }

    public String getUgenTemplateErrorReason() {
        return this.OXF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc
    public long getVideoProgress() {
        com.bytedance.sdk.openadsdk.core.zY.qr qrVar = this.otH;
        if (qrVar != null) {
            return qrVar.getVideoProgress();
        }
        return 0L;
    }

    public com.bytedance.sdk.component.Ol.We getWebView() {
        JPJ jpj = this.yL;
        if (jpj == null) {
            return null;
        }
        return jpj.sc();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Dl();
        JPJ();
        com.bytedance.sdk.component.utils.Tf.sc("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.f28064pc);
        com.bytedance.sdk.openadsdk.core.Ol.pFF().sc(this.cJ, this.kX);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.f28064pc);
        com.bytedance.sdk.openadsdk.core.Ol.pFF().TRI(this.cJ);
        FI();
        com.bytedance.sdk.component.utils.Tf.sc("webviewpool", "onDetachedFromWindow===");
        sc(8, true, true);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.Tf.sc("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        Dl();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.Tf.sc("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z11 ? getVisibility() : 8);
        }
        Dl();
        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(this.UFX, z11);
        if (z11) {
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.UFX, 4);
        } else {
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.UFX, 8);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        sc(i11, true, false);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void onvideoComplate() {
    }

    public void pFF() {
    }

    public void pFF(int i11) {
    }

    public void pFF(int i11, int i12) {
        int iMin;
        if (TextUtils.equals(this.Ol, "banner_ad")) {
            return;
        }
        int i13 = this.JPJ;
        int i14 = ((i12 < i13 || i13 < 0 || !(this.FI || TextUtils.equals(this.Ol, "open_ad"))) && !((i11 == 0 && TextUtils.equals(this.Ol, "open_ad")) || We() == 5)) ? 0 : 1;
        if (i12 <= this.JPJ) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
            iMin = (sfl == null || sfl.GI() == null) ? this.JPJ - i12 : (int) (Math.min(this.JPJ, this.UFX.GI().m() * ((double) this.UFX.GI().J())) - ((double) i12));
        } else {
            iMin = 0;
        }
        com.bytedance.sdk.component.adexpress.pFF.pFF pff = this.II;
        if (pff != null && pff.pFF() != null) {
            this.II.pFF().setTime(String.valueOf(i11), i14, iMin, false);
        }
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 instanceof com.bytedance.sdk.openadsdk.core.UFX.We.zY) {
            ((com.bytedance.sdk.openadsdk.core.UFX.We.zY) we2).setTime(String.valueOf(i11), i14, iMin, false);
        }
    }

    public void pFF(int i11, String str) {
        HJN hjnDE;
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 == null || !(we2 instanceof JPJ) || (hjnDE = ((JPJ) we2).dE()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i11);
            jSONObject.put("flag", str);
            hjnDE.sc("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public JSONObject sc(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (!(this.McK instanceof JPJ)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int renderEngineCacheType = getRenderEngineCacheType();
            if (sfl != null) {
                if (sfl.JoC() != null && sfl.JoC().SR()) {
                    jSONObject.put("engine_version", sfl.JoC().Ql());
                } else if (sfl.qKn() != null) {
                    jSONObject.put("engine_version", "v3");
                } else {
                    jSONObject.put("engine_version", "v1");
                }
            }
            jSONObject.put("engine_type", renderEngineCacheType);
        } catch (Exception e11) {
            e11.getMessage();
        }
        return jSONObject;
    }

    public void sc() {
    }

    public void sc(int i11) {
    }

    public void sc(int i11, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
    }

    public void sc(int i11, String str) {
    }

    public void sc(int i11, boolean z11, boolean z12) {
        this.Xc = z11;
        removeCallbacks(this.QLv);
        removeCallbacks(this.MxZ);
        if (i11 == 0) {
            if (z12) {
                this.MxZ.run();
                return;
            } else {
                postDelayed(this.MxZ, 50L);
                return;
            }
        }
        if (z12) {
            this.QLv.run();
        } else {
            postDelayed(this.QLv, 50L);
        }
    }

    public void sc(View view, int i11, com.bytedance.sdk.component.adexpress.zY zYVar) {
        View view2;
        JSONObject jSONObject;
        com.bytedance.sdk.openadsdk.utils.Dl.sc("ClickCreativeListener", "trigger Class2 method1", Integer.valueOf(i11));
        if (i11 == -1 || zYVar == null) {
            return;
        }
        HashMap map = new HashMap();
        if (com.bytedance.sdk.openadsdk.core.model.JPJ.zY(this.UFX)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.model.SR sr2 = (com.bytedance.sdk.openadsdk.core.model.SR) zYVar;
        if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(this.UFX)) {
            try {
                JSONObject jSONObject2 = sr2.Xc;
                if (jSONObject2 != null) {
                    int iOptInt = jSONObject2.optInt("click_type", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("click_type", iOptInt);
                    map.put("pag_json_data", jSONObject3.toString());
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
            }
        }
        Qj qj2 = this.TRI;
        if (qj2 != null) {
            qj2.We(getDynamicShowType());
            this.TRI.sc(map);
        }
        Ol ol2 = this.f28065qr;
        if (ol2 != null) {
            ol2.We(getDynamicShowType());
            this.f28065qr.sc(map);
        }
        float f11 = sr2.f28400sc;
        float f12 = sr2.pFF;
        float f13 = sr2.zY;
        float f14 = sr2.We;
        boolean z11 = sr2.BT;
        SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray = sr2.SR;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.YdT;
        }
        SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray2 = sparseArray;
        String str = sr2.UFX;
        JSONObject jSONObjectSc = null;
        if (view == null) {
            view2 = this;
        } else {
            jSONObjectSc = view != this ? sc(view) : null;
            view2 = view;
        }
        sr2.Tf = i11;
        if (jSONObjectSc != null && sr2.Ql == null) {
            sr2.Ql = jSONObjectSc;
        }
        switch (i11) {
            case 1:
                FrameLayout frameLayout = this.Tf;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
                if (sfl == null || sfl.Sfl() != 1 || z11) {
                    Ol ol3 = this.f28065qr;
                    if (ol3 != null) {
                        ol3.sc(sr2);
                        this.f28065qr.sc(str);
                        this.f28065qr.sc(view2, f11, f12, f13, f14, sparseArray2, z11);
                    }
                    PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ExN;
                    if (pAGExpressAdWrapperListener != null && !sr2.wjp) {
                        pAGExpressAdWrapperListener.onAdClicked();
                        break;
                    }
                }
                break;
            case 2:
                if (sr2.dE > 0) {
                    cD.sc(true);
                }
                Qj qj3 = this.TRI;
                if (qj3 != null) {
                    qj3.sc(sr2);
                    this.TRI.sc(str);
                    if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(this.UFX) && (jSONObject = sr2.Xc) != null) {
                        this.TRI.We(jSONObject.optBoolean("is_ceiling_page", false));
                    }
                    this.TRI.sc(view2, f11, f12, f13, f14, sparseArray2, z11);
                }
                PAGExpressAdWrapperListener pAGExpressAdWrapperListener2 = this.ExN;
                if (pAGExpressAdWrapperListener2 != null && !sr2.wjp) {
                    pAGExpressAdWrapperListener2.onAdClicked();
                }
                cD.sc(false);
                com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.UFX, 9);
                break;
            case 3:
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.We;
                if (tTDislikeDialogAbstract == null) {
                    com.bytedance.sdk.openadsdk.zY.zY zYVar2 = this.zY;
                    if (zYVar2 == null) {
                        TTDelegateActivity.sc(this.UFX, this.cJ);
                    } else {
                        zYVar2.sc();
                    }
                } else {
                    tTDislikeDialogAbstract.show();
                }
                break;
            case 4:
                FrameLayout frameLayout2 = this.Tf;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.UFX;
                if (sfl2 == null || sfl2.Sfl() != 1 || z11) {
                    cJ.zY(this.UFX);
                    if ("embeded_ad".equals(this.Ol) && uEA() && !this.Ql && cJ.zY(this.UFX)) {
                        Qj qj4 = this.TRI;
                        if (qj4 != null) {
                            qj4.sc(sr2);
                            this.TRI.sc(str);
                            this.TRI.sc(view2, f11, f12, f13, f14, sparseArray2, z11);
                        }
                    } else {
                        Ol ol4 = this.f28065qr;
                        if (ol4 != null) {
                            ol4.sc(sr2);
                            this.f28065qr.sc(str);
                            this.f28065qr.sc(view2, f11, f12, f13, f14, sparseArray2, z11);
                        }
                    }
                    PAGExpressAdWrapperListener pAGExpressAdWrapperListener3 = this.ExN;
                    if (pAGExpressAdWrapperListener3 != null && !sr2.wjp) {
                        pAGExpressAdWrapperListener3.onAdClicked();
                        break;
                    }
                }
                break;
            case 5:
                sc(!this.uEA);
                break;
            case 6:
                sc();
                break;
            case 7:
                TTWebsiteActivity.sc(this.Qj, this.UFX, this.Ol);
                break;
        }
    }

    public void sc(com.bytedance.sdk.component.adexpress.pFF.Ql.sc scVar) {
    }

    public void sc(com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        this.CYO.set(true);
        this.McK = we2;
        if (this.Bs != getWindowVisibility()) {
            TRI(getWindowVisibility());
        }
        we2.zY();
        if (we2.zY() == 3 && (sfl = this.UFX) != null && sfl.Xc() == 1) {
            this.UFX.pFF(0);
        }
        if (we2.zY() != 1) {
            View viewExN = we2.ExN();
            if (viewExN.getParent() != null) {
                ((ViewGroup) viewExN.getParent()).removeView(viewExN);
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                arrayList.add(getChildAt(i11));
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                if (arrayList.get(i12) instanceof com.bytedance.sdk.component.Ol.We) {
                    removeView((View) arrayList.get(i12));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(this.UFX)) {
                addView(we2.ExN(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                addView(we2.ExN());
            }
        }
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.UFX;
        if (sfl2 != null) {
            com.bytedance.sdk.openadsdk.SR.zY.sc(sfl2.pFF(), this.cvk, this.Ol, we2.zY());
        }
        com.bytedance.sdk.component.adexpress.pFF.Ol ol2 = this.idT;
        if (ol2 != null) {
            ((Ql) ol2).UFX();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.ExN;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderSuccess(this, (float) sr2.We(), (float) sr2.ExN());
        }
        if (sc(sr2)) {
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this, this.UFX, zY(getDynamicShowType()));
        }
        Dl dl2 = this.JoC;
        if (dl2 != null) {
            dl2.sc(this.UFX, this.Ol);
        }
    }

    public void sc(String str, JSONObject jSONObject) {
    }

    public void sc(JSONObject jSONObject) {
    }

    public void sc(boolean z11) {
    }

    public boolean sc(com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        return true;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.pFF.zY zYVar) {
        this.BT = zYVar;
        com.bytedance.sdk.component.adexpress.pFF.TRI tri = this.f28063ko;
        if (tri != null) {
            tri.sc(zYVar);
        }
    }

    public void setBannerClickClosedListener(com.bytedance.sdk.openadsdk.core.zY.We.sc scVar) {
        this.kX = scVar;
    }

    public void setClickCreativeListener(Qj qj2) {
        this.TRI = qj2;
        if (qj2 != null) {
            qj2.sc((com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc) this);
        }
    }

    public void setClickListener(Ol ol2) {
        this.f28065qr = ol2;
    }

    public void setClosedListenerKey(String str) {
        this.cJ = str;
        zY zYVar = this.qKn;
        if (zYVar != null) {
            zYVar.sc(str);
        }
    }

    public void setDislike(com.bytedance.sdk.openadsdk.zY.zY zYVar) {
        sc scVar;
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 != null && (we2 instanceof YIK) && (scVar = (sc) we2.ExN()) != null) {
            scVar.setDislikeInner(zYVar);
        }
        zY zYVar2 = this.qKn;
        if (zYVar2 != null) {
            zYVar2.sc(zYVar);
        }
        this.zY = zYVar;
    }

    public void setExpressInteractionListener(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        this.ExN = pAGExpressAdWrapperListener;
        zY zYVar = this.qKn;
        if (zYVar != null) {
            zYVar.sc(pAGExpressAdWrapperListener);
        }
    }

    public void setJsbLandingPageOpenListener(com.bytedance.sdk.openadsdk.core.widget.TRI tri) {
        if (this.yL != null && getJsObject() != null) {
            getJsObject().sc(tri);
        }
        com.bytedance.sdk.openadsdk.core.UFX.We.zY zYVar = this.ZM;
        if (zYVar != null) {
            zYVar.sc(tri);
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        sc scVar;
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 != null && (we2 instanceof YIK) && (scVar = (sc) we2.ExN()) != null) {
            scVar.setDislikeOuter(tTDislikeDialogAbstract);
        }
        zY zYVar = this.qKn;
        if (zYVar != null) {
            zYVar.sc(tTDislikeDialogAbstract);
        }
        this.We = tTDislikeDialogAbstract;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setSoundMute(boolean z11) {
        this.uEA = z11;
        com.bytedance.sdk.component.adexpress.pFF.pFF pff = this.II;
        if (pff != null && pff.pFF() != null) {
            this.II.pFF().setSoundMute(z11);
        }
        com.bytedance.sdk.component.adexpress.pFF.We<? extends View> we2 = this.McK;
        if (we2 instanceof com.bytedance.sdk.openadsdk.core.UFX.We.zY) {
            ((com.bytedance.sdk.openadsdk.core.UFX.We.zY) we2).setSoundMute(z11);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setTime(CharSequence charSequence, int i11, int i12, boolean z11) {
        pFF(Integer.parseInt(String.valueOf(charSequence)), i11);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setTimeUpdate(int i11) {
    }

    public void setVastVideoHelper(com.bytedance.sdk.openadsdk.core.zY.qr qrVar) {
        this.otH = qrVar;
    }

    public long zY() {
        return 0L;
    }

    public com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc zY(int i11) {
        return new com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(i11);
    }
}
