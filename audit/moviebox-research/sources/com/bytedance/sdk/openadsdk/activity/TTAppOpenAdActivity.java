package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.common.BT;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.Ol.Qj;
import com.bytedance.sdk.openadsdk.core.JPJ;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTAppOpenAdActivity extends TTBaseActivity implements FI.sc {
    private static com.bytedance.sdk.openadsdk.sc.We.pFF Qj;
    private qr BT;
    private Sfl Dl;
    private AdSlot Gb;
    private com.bytedance.sdk.openadsdk.component.zY HJN;
    private FrameLayout II;
    private com.bytedance.sdk.openadsdk.sc.We.pFF JPJ;
    private boolean McK;
    private int Sfl;
    private TTAdDislikeToast Tf;
    private BT UFX;
    private com.bytedance.sdk.openadsdk.component.TRI.pFF WH;
    private int WP;
    private float Xc;
    private String YIK;
    private int cvk;
    private float dE;
    private IListenerManager uEA;
    private boolean wjp;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final AtomicBoolean f27506sc = new AtomicBoolean(false);
    protected final FI pFF = new FI(Looper.getMainLooper(), this);
    final AtomicBoolean zY = new AtomicBoolean(false);
    final AtomicBoolean We = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.component.Qj.sc Ol = new com.bytedance.sdk.openadsdk.component.Qj.sc();
    protected boolean ExN = false;
    private final AtomicBoolean Ql = new AtomicBoolean(false);
    private OXF SR = OXF.zY();
    private final AtomicBoolean FI = new AtomicBoolean(false);
    long TRI = 0;
    private volatile boolean cD = false;
    private final com.bytedance.sdk.openadsdk.component.sc Cb = new com.bytedance.sdk.openadsdk.component.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.1
        @Override // com.bytedance.sdk.openadsdk.component.sc
        public void ExN() {
            TTAppOpenAdActivity.this.Sfl();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc
        public void We() {
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, com.bytedance.sdk.openadsdk.component.TRI.sc
        public void pFF() {
            TTAppOpenAdActivity.this.cD = true;
            if (com.bytedance.sdk.openadsdk.YIK.sc.sc("splash_auto_close_switch", 0) == 0) {
                TTAppOpenAdActivity.this.qr();
                TTAppOpenAdActivity.this.finish();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, t8.c.InterfaceC0849c
        public void pFF(long j11, int i11) {
            com.bytedance.sdk.openadsdk.component.Qj.zY zYVarQr;
            StringBuilder sb2 = new StringBuilder("onError() called with: totalPlayTime = [");
            sb2.append(j11);
            sb2.append("], percent = [");
            sb2.append(i11);
            sb2.append("]");
            if (TTAppOpenAdActivity.this.HJN != null && (zYVarQr = TTAppOpenAdActivity.this.HJN.qr()) != null) {
                zYVarQr.sc(true);
            }
            TTAppOpenAdActivity.this.YIK();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, com.bytedance.sdk.openadsdk.component.TRI.sc
        public void pFF(View view) {
            TTAppOpenAdActivity.this.sc();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, t8.c.InterfaceC0849c
        public void sc() {
            TTAppOpenAdActivity.this.YIK();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, com.bytedance.sdk.openadsdk.component.TRI.sc
        public void sc(int i11, int i12, boolean z11) {
            if (TTAppOpenAdActivity.this.HJN != null) {
                TTAppOpenAdActivity.this.HJN.sc(i11, i12, z11 || i11 == 0);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, t8.c.InterfaceC0849c
        public void sc(long j11, long j12) {
            TTAppOpenAdActivity.this.Ol.sc(j11);
            TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
            if (!tTAppOpenAdActivity.ExN && tTAppOpenAdActivity.HJN != null && TTAppOpenAdActivity.this.HJN.qr() != null && TTAppOpenAdActivity.this.HJN.qr().We()) {
                TTAppOpenAdActivity.this.HJN.qr().qr();
            }
            TTAppOpenAdActivity.this.Ql();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc, com.bytedance.sdk.openadsdk.component.TRI.sc
        public void sc(View view) {
            TTAppOpenAdActivity.this.Dl();
        }

        @Override // com.bytedance.sdk.openadsdk.component.sc
        public void zY() {
            TTAppOpenAdActivity.this.TRI();
            TTAppOpenAdActivity.this.SR.ExN();
            TTAppOpenAdActivity.this.Xc();
            if (TTAppOpenAdActivity.this.wjp) {
                TTAppOpenAdActivity.this.Tf();
            }
        }
    };
    private final Runnable OXF = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (TTAppOpenAdActivity.this.Ql.get()) {
                return;
            }
            if (TTAppOpenAdActivity.this.Dl != null && TTAppOpenAdActivity.this.Dl.ymG() && TTAppOpenAdActivity.this.Dl.GOt() != null && TTAppOpenAdActivity.this.Dl.GOt().sc() != null) {
                TTAppOpenAdActivity.this.Dl.GOt().sc().sc(0L);
            }
            TTAppOpenAdActivity.this.BT = new qr();
            TTAppOpenAdActivity.this.BT.sc(System.currentTimeMillis(), 1.0f);
            TTAppOpenAdActivity.this.SR.ExN();
            if (TTAppOpenAdActivity.this.WH != null) {
                TTAppOpenAdActivity.this.WH.pFF();
            }
            if (TTAppOpenAdActivity.this.HJN != null) {
                TTAppOpenAdActivity.this.HJN.ExN();
            }
            TTAppOpenAdActivity.this.wjp();
            View viewFindViewById = TTAppOpenAdActivity.this.findViewById(R.id.content);
            JSONObject jSONObject = new JSONObject();
            if (viewFindViewById != null) {
                try {
                    jSONObject.put("width", viewFindViewById.getWidth());
                    jSONObject.put("height", viewFindViewById.getHeight());
                    jSONObject.put("alpha", viewFindViewById.getAlpha());
                } catch (JSONException e11) {
                    Log.e("TTAppOpenAdActivity", "run: ", e11);
                    TTAppOpenAdActivity.this.finish();
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("root_view", jSONObject.toString());
            jSONObject2.put("ad_root", TTAppOpenAdActivity.this.WP);
            jSONObject2.put("openad_creative_type", TTAppOpenAdActivity.this.wjp ? "video_normal_ad" : "image_normal_ad");
            if (Qj.zY() == null) {
                jSONObject2.put("appicon_acquirefail", "1");
            }
            if (TTAppOpenAdActivity.this.McK || TTAppOpenAdActivity.this.Dl.Pu()) {
                jSONObject2.put("dynamic_show_type", TTAppOpenAdActivity.this.dE());
                TTAppOpenAdActivity.this.sc(jSONObject2);
            }
            jSONObject2.put("is_icon_only", TTAppOpenAdActivity.this.Dl.LVf() ? 1 : 0);
            com.bytedance.sdk.openadsdk.We.zY.sc(TTAppOpenAdActivity.this.Dl, "open_ad", jSONObject2);
            com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(TTAppOpenAdActivity.this.findViewById(R.id.content), TTAppOpenAdActivity.this.Dl, new com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(TTAppOpenAdActivity.this.dE()));
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(TTAppOpenAdActivity.this.Dl);
            TTAppOpenAdActivity.this.Ql.set(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        this.Tf.show(TTAdDislikeToast.getDislikeSendTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl() {
        com.bytedance.sdk.openadsdk.component.zY zYVar;
        JPJ.zY(this.Sfl);
        YIK();
        if (this.wjp && (zYVar = this.HJN) != null && zYVar.qr() != null) {
            this.HJN.qr().sc(4);
        }
        com.bytedance.sdk.openadsdk.component.We.sc.sc(this.Dl, (int) this.Ol.pFF(), this.WH.sc(), this.Ol.sc());
        Sfl sfl = this.Dl;
        if (sfl != null && sfl.ymG() && this.Dl.GOt() != null && this.Dl.GOt().sc() != null) {
            com.bytedance.sdk.openadsdk.core.Tf.We weSc = this.Dl.GOt().sc();
            com.bytedance.sdk.openadsdk.component.zY zYVar2 = this.HJN;
            long jTf = (zYVar2 == null || zYVar2.qr() == null) ? 0L : this.HJN.qr().Tf();
            weSc.TRI(jTf);
            weSc.ExN(jTf);
        }
        finish();
    }

    private void Ol() {
        int iMin;
        int iMax;
        new StringBuilder("changeScreenOrientation: mOrientation=").append(this.cvk);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 != 26) {
            if (i11 == 27) {
                try {
                    WH();
                } catch (Throwable th2) {
                    Tf.sc("TTAppOpenAdActivity", th2.getMessage());
                    return;
                }
            } else {
                WH();
            }
        }
        Pair<Integer, Integer> pairQj = kX.Qj(getApplicationContext());
        if (this.cvk == 2) {
            iMin = Math.max(((Integer) pairQj.first).intValue(), ((Integer) pairQj.second).intValue());
            iMax = Math.min(((Integer) pairQj.first).intValue(), ((Integer) pairQj.second).intValue());
        } else {
            iMin = Math.min(((Integer) pairQj.first).intValue(), ((Integer) pairQj.second).intValue());
            iMax = Math.max(((Integer) pairQj.first).intValue(), ((Integer) pairQj.second).intValue());
        }
        this.dE = iMax;
        this.Xc = iMin;
        float fSc = kX.sc();
        if (kX.zY((Activity) this)) {
            int i12 = this.cvk;
            if (i12 == 1) {
                this.dE -= fSc;
            } else if (i12 == 2) {
                this.Xc -= fSc;
            }
        }
        com.bytedance.sdk.openadsdk.component.zY zYVar = this.HJN;
        if (zYVar != null) {
            zYVar.sc(this.Xc, this.dE);
        }
    }

    private void Qj() {
        if (26 != Build.VERSION.SDK_INT) {
            this.cvk = this.Dl.gx();
        } else if (getResources().getConfiguration().orientation == 1) {
            this.cvk = 1;
        } else {
            this.cvk = 2;
        }
        Ol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql() {
        if (!this.wjp || this.Dl.LVf()) {
            return;
        }
        this.pFF.removeMessages(100);
    }

    private void SR() {
        this.Tf.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sfl() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdClicked");
        } else {
            com.bytedance.sdk.openadsdk.sc.We.pFF pff = this.JPJ;
            if (pff != null) {
                pff.onAdClicked();
            }
        }
        if (dE.ef().FI(String.valueOf(this.Sfl))) {
            this.FI.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TRI() {
        this.WH.pFF(Xc.We().uEA(String.valueOf(this.Sfl)));
        this.WH.sc(this.Ol.sc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (!this.wjp || this.Dl.LVf() || this.cD) {
            return;
        }
        this.pFF.sendEmptyMessageDelayed(100, 5000L);
    }

    private void UFX() {
        if (this.UFX == null) {
            BT bt2 = new BT(this, this.Dl);
            this.UFX = bt2;
            bt2.setDislikeSource("video_player");
            this.UFX.setCallback(new BT.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.4
                @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                public void pFF(View view) {
                    TTAppOpenAdActivity.this.zY.set(false);
                    TTAppOpenAdActivity.this.pFF();
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(TTAppOpenAdActivity.this.Dl, 4);
                }

                @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                public void sc(View view) {
                    TTAppOpenAdActivity.this.zY.set(true);
                    TTAppOpenAdActivity.this.zY();
                    com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(TTAppOpenAdActivity.this.Dl, 8);
                }

                @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                public void sc(FilterWord filterWord) {
                    if (TTAppOpenAdActivity.this.We.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTAppOpenAdActivity.this.We.set(true);
                    TTAppOpenAdActivity.this.BT();
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        frameLayout.addView(this.UFX);
        if (this.Tf == null) {
            TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this);
            this.Tf = tTAdDislikeToast;
            frameLayout.addView(tTAdDislikeToast);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private void WH() {
        if (this.cvk != 2) {
            setRequestedOrientation(1);
        } else if (ExN()) {
            setRequestedOrientation(8);
        } else {
            setRequestedOrientation(0);
        }
        if (this.cvk == 2 || !kX.zY((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.Ql.get()) {
            return;
        }
        try {
            getWindow().getDecorView().post(this.OXF);
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YIK() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdSkip");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.We.pFF pff = this.JPJ;
        if (pff != null) {
            pff.pFF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dE() {
        if (this.Dl.Pu()) {
            return 5;
        }
        if (this.McK) {
            return this.HJN.We();
        }
        return -1;
    }

    private boolean pFF(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.Dl = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(stringExtra));
                    } catch (Exception e11) {
                        Tf.sc("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e11);
                    }
                }
                this.YIK = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.Dl = com.bytedance.sdk.openadsdk.core.FI.sc().pFF();
            this.JPJ = com.bytedance.sdk.openadsdk.core.FI.sc().ExN();
            com.bytedance.sdk.openadsdk.core.FI.sc().TRI();
        }
        sc(getIntent());
        sc(bundle);
        Sfl sfl = this.Dl;
        if (sfl == null) {
            finish();
            return false;
        }
        this.Gb = sfl.Cb();
        this.Dl.sc(this.TRI);
        this.Sfl = this.Dl.QT();
        com.bytedance.sdk.openadsdk.utils.pFF.sc(this.Dl);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr() {
        Dl.sc("TTAppOpenAdActivity", "invoke callback onAdDismiss, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdTimeOver");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.We.pFF pff = this.JPJ;
        if (pff != null) {
            pff.zY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject sc(JSONObject jSONObject) {
        if (dE() == 0) {
            return this.HJN.sc(jSONObject);
        }
        return null;
    }

    private void sc(final String str) {
        Cb.zY(new com.bytedance.sdk.component.Qj.Qj("AppOpenAd_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTAppOpenAdActivity.this.We().executeAppOpenAdCallback(TTAppOpenAdActivity.this.YIK, str);
                } catch (Throwable th2) {
                    Tf.sc("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wjp() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdShow");
            return;
        }
        com.bytedance.sdk.openadsdk.sc.We.pFF pff = this.JPJ;
        if (pff != null) {
            pff.sc();
        }
    }

    public boolean ExN() {
        try {
            return getIntent().getIntExtra("orientation_angle", 0) == 3;
        } catch (Exception e11) {
            Tf.sc("TTAppOpenAdActivity", e11.getMessage());
            return false;
        }
    }

    public IListenerManager We() {
        if (this.uEA == null) {
            this.uEA = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(7));
        }
        return this.uEA;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        kX.sc((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i11) {
                if (i11 == 0) {
                    try {
                        if (TTAppOpenAdActivity.this.isFinishing()) {
                            return;
                        }
                        TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                kX.sc((Activity) TTAppOpenAdActivity.this);
                            }
                        }, 2500L);
                    } catch (Exception e11) {
                        Tf.sc("TTAppOpenAdActivity", e11.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (Xc.We().Dl(String.valueOf(this.Sfl)) == 1) {
            if (this.Ol.pFF() >= ((long) Xc.We().uEA(String.valueOf(this.Sfl))) * 1000) {
                Dl();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Xc.pFF(getApplicationContext());
        if (!pFF(bundle)) {
            finish();
            return;
        }
        if (!SR.ExN()) {
            finish();
            return;
        }
        if (bundle != null) {
            com.bytedance.sdk.openadsdk.We.zY.ExN(this.Dl, "open_ad", (JSONObject) null);
        }
        this.wjp = Sfl.ExN(this.Dl);
        new StringBuilder("onCreate: isVideo is ").append(this.wjp);
        if (this.wjp) {
            this.Ol.sc((float) this.Dl.GI().m());
        } else {
            this.Ol.sc(Xc.We().JPJ(String.valueOf(this.Sfl)));
        }
        com.bytedance.sdk.openadsdk.component.TRI.pFF pff = new com.bytedance.sdk.openadsdk.component.TRI.pFF(this.Ol);
        this.WH = pff;
        pff.sc(this.Cb);
        Qj();
        FrameLayout frameLayout = new FrameLayout(this);
        this.II = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        try {
            setContentView(this.II);
            this.II.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.2
                /* JADX WARN: Code duplicated, block: B:11:0x0026  */
                @Override // java.lang.Runnable
                public void run() {
                    boolean z11;
                    try {
                        int iCvk = TTAppOpenAdActivity.this.Dl.cvk();
                        TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
                        if (tTAppOpenAdActivity.Dl == null || TTAppOpenAdActivity.this.Dl.JPJ() != 2) {
                            z11 = false;
                        } else {
                            z11 = true;
                            if (iCvk == 1) {
                                z11 = false;
                            }
                        }
                        tTAppOpenAdActivity.McK = z11;
                        if (TTAppOpenAdActivity.this.McK) {
                            TTAppOpenAdActivity tTAppOpenAdActivity2 = TTAppOpenAdActivity.this;
                            tTAppOpenAdActivity2.HJN = new com.bytedance.sdk.openadsdk.component.pFF(tTAppOpenAdActivity2, tTAppOpenAdActivity2.Dl, TTAppOpenAdActivity.this.II, TTAppOpenAdActivity.this.Cb, TTAppOpenAdActivity.this.cvk, TTAppOpenAdActivity.this.wjp, TTAppOpenAdActivity.this.Ol, TTAppOpenAdActivity.this.WH);
                        } else {
                            TTAppOpenAdActivity tTAppOpenAdActivity3 = TTAppOpenAdActivity.this;
                            tTAppOpenAdActivity3.HJN = new com.bytedance.sdk.openadsdk.component.zY(tTAppOpenAdActivity3, tTAppOpenAdActivity3.Dl, TTAppOpenAdActivity.this.II, TTAppOpenAdActivity.this.Cb, TTAppOpenAdActivity.this.cvk, TTAppOpenAdActivity.this.wjp, TTAppOpenAdActivity.this.Ol);
                            TTAppOpenAdActivity.this.HJN.sc(TTAppOpenAdActivity.this.Xc, TTAppOpenAdActivity.this.dE);
                        }
                        TTAppOpenAdActivity.this.HJN.sc((ViewGroup) TTAppOpenAdActivity.this.II);
                        TTAppOpenAdActivity.this.HJN.sc();
                        TTAppOpenAdActivity.this.HJN.pFF();
                    } catch (Throwable th2) {
                        TTAppOpenAdActivity.this.finish();
                        Tf.sc("TTAppOpenAdActivity", th2.getMessage());
                    }
                }
            });
            try {
                final View decorView = getWindow().getDecorView();
                if (Build.VERSION.SDK_INT >= 35) {
                    decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.3
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            List boundingRects;
                            try {
                                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                                if (displayCutout != null && (boundingRects = displayCutout.getBoundingRects()) != null && !boundingRects.isEmpty()) {
                                    decorView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                                }
                            } catch (Throwable unused) {
                            }
                            return windowInsets;
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            com.bytedance.sdk.openadsdk.SR.zY.pFF();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.Dl != null) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("videoForceBreak", this.Dl);
        }
        this.pFF.removeCallbacksAndMessages(null);
        com.bytedance.sdk.openadsdk.component.TRI.pFF pff = this.WH;
        if (pff != null) {
            pff.ExN();
        }
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.Dl);
        com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF(this.Dl);
        if (this.wjp) {
            com.bytedance.sdk.openadsdk.component.We.sc.sc(this.Dl, this.Ol.pFF(), this.Ol.sc(), true);
        } else {
            com.bytedance.sdk.openadsdk.component.We.sc.sc(this.Dl, -1L, this.Ol.sc(), false);
        }
        if (this.SR.TRI() && this.Ql.get()) {
            com.bytedance.sdk.openadsdk.We.zY.sc(String.valueOf(this.SR.We()), this.Dl, "open_ad", this.BT);
            this.SR = OXF.zY();
        }
        com.bytedance.sdk.openadsdk.component.zY zYVar = this.HJN;
        if (zYVar != null) {
            zYVar.zY();
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("recycleRes");
        }
        qr();
        Qj = null;
        this.JPJ = null;
        BT bt2 = this.UFX;
        if (bt2 != null) {
            bt2.setCallback(null);
        }
        if (dE.ef().WP(String.valueOf(this.Sfl)) != 1 || Sfl.TRI(this.Dl)) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.TRI.sc(Xc.sc()).sc(this.Gb);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ExN = false;
        zY();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.zY zYVar;
        super.onResume();
        this.ExN = true;
        if (this.f27506sc.getAndSet(true)) {
            if (!this.FI.get()) {
                pFF();
                return;
            }
            YIK();
            if (this.wjp && (zYVar = this.HJN) != null && zYVar.qr() != null) {
                this.HJN.qr().sc(3);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            Sfl sfl = this.Dl;
            bundle.putString("material_meta", sfl != null ? sfl.JP().toString() : null);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.YIK);
            bundle.putInt("ad_source", this.WP);
            bundle.putLong("start_show_time", this.TRI);
        } catch (Throwable th2) {
            Tf.sc("TTAppOpenAdActivity", th2.getMessage());
        }
        Qj = this.JPJ;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.zY.sc(this, this.Dl);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            if (!this.McK) {
                this.SR.ExN();
            }
            Sfl sfl = this.Dl;
            if (sfl != null && sfl.RiV() && !this.Dl.AIZ()) {
                this.Dl.qr(true);
                Sfl sfl2 = this.Dl;
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl2, "open_ad", sfl2.fKf());
            }
        } else if (this.Ql.get()) {
            if (this.SR.TRI()) {
                com.bytedance.sdk.openadsdk.We.zY.sc(String.valueOf(this.SR.We()), this.Dl, "open_ad", this.BT);
            }
            this.SR = OXF.zY();
        }
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.Dl, z11 ? 4 : 8);
        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(this.Dl, z11);
    }

    public void pFF() {
        if (this.zY.get()) {
            return;
        }
        if (this.wjp) {
            com.bytedance.sdk.openadsdk.component.zY zYVar = this.HJN;
            if (zYVar != null && zYVar.qr() != null && this.HJN.qr().ExN()) {
                this.HJN.qr().WH();
            }
            Tf();
        }
        com.bytedance.sdk.openadsdk.component.TRI.pFF pff = this.WH;
        if (pff != null) {
            pff.zY();
        }
    }

    public void sc() {
        if (isFinishing()) {
            return;
        }
        if (this.We.get()) {
            SR();
            return;
        }
        if (this.UFX == null) {
            try {
                UFX();
            } catch (Throwable th2) {
                ApmHelper.reportCustomError("initDislike error", "TTAppOpenAdActivity", th2);
            }
        }
        BT bt2 = this.UFX;
        if (bt2 != null) {
            bt2.sc();
        }
    }

    public void sc(Intent intent) {
        if (intent != null) {
            this.WP = intent.getIntExtra("ad_source", 0);
            this.TRI = intent.getLongExtra("start_show_time", 0L);
        }
    }

    public void sc(Bundle bundle) {
        if (bundle != null) {
            if (this.JPJ == null) {
                this.JPJ = Qj;
                Qj = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.YIK = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.WP = bundle.getInt("ad_source", 0);
                this.TRI = bundle.getLong("start_show_time", 0L);
                this.Dl = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(string));
            } catch (Throwable th2) {
                Tf.sc("TTAppOpenAdActivity", th2.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        com.bytedance.sdk.openadsdk.component.zY zYVar;
        if (message.what == 100) {
            if (this.wjp && (zYVar = this.HJN) != null && zYVar.qr() != null) {
                this.HJN.qr().sc(1);
            }
            YIK();
            finish();
        }
    }

    public void zY() {
        if (this.wjp) {
            com.bytedance.sdk.openadsdk.component.zY zYVar = this.HJN;
            if (zYVar != null && zYVar.qr() != null && this.HJN.qr().We()) {
                this.HJN.qr().qr();
            }
            Ql();
        }
        com.bytedance.sdk.openadsdk.component.TRI.pFF pff = this.WH;
        if (pff != null) {
            pff.We();
        }
    }
}
