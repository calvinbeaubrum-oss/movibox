package com.bytedance.sdk.openadsdk.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.ExN.dE;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.uEA;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.We.WH;
import com.bytedance.sdk.openadsdk.common.SR;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.bytedance.sdk.openadsdk.wjp.sc.sc.qr;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TTVideoLandingPageActivity extends TTBaseActivity implements com.bytedance.sdk.openadsdk.WH.We {
    protected int BR;
    protected long BT;
    protected UFX CYO;
    protected Context ExN;
    protected com.bytedance.sdk.openadsdk.core.widget.sc FI;
    protected String GI;
    protected com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI HJN;
    protected SR II;
    protected TextView JPJ;
    protected com.bytedance.sdk.openadsdk.multipro.pFF.sc JoC;
    protected Button McK;
    protected com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc MxZ;
    private int OKY;
    protected String Ol;
    protected String Qj;
    protected com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI SR;
    protected int TRI;
    protected FrameLayout Tf;
    protected int UFX;
    protected HJN WH;
    protected TextView WP;
    protected TextView We;
    protected String cD;
    protected TextView cvk;
    protected Sfl dE;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private ILoader f27579eo;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private int f27581ko;
    protected ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected com.bytedance.sdk.component.Ol.We f27583sc;
    protected RelativeLayout uEA;
    protected ImageView zY;
    protected int Ql = -1;
    protected int Xc = 0;
    protected int wjp = 0;
    protected int Sfl = 0;
    protected int YIK = 0;
    protected String Dl = "ダウンロード";
    protected boolean Gb = false;
    protected boolean Cb = false;
    protected boolean OXF = true;
    protected boolean cJ = false;
    protected String kX = null;
    protected AtomicBoolean qKn = new AtomicBoolean(true);

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    protected JSONArray f27582pc = null;
    private final AtomicInteger yL = new AtomicInteger(0);
    private final AtomicInteger Yhz = new AtomicInteger(0);
    private final AtomicInteger qfG = new AtomicInteger(0);
    protected com.bytedance.sdk.openadsdk.core.pFF.sc QLv = null;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private final c.b f27580ht = new c.b() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.11
        @Override // t8.c.b
        public void sc(boolean z11) {
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity.Gb = z11;
            if (tTVideoLandingPageActivity.isFinishing()) {
                return;
            }
            if (!z11) {
                kX.sc((View) TTVideoLandingPageActivity.this.f27583sc, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.Tf.getLayoutParams();
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                marginLayoutParams.width = tTVideoLandingPageActivity2.Sfl;
                marginLayoutParams.height = tTVideoLandingPageActivity2.YIK;
                marginLayoutParams.leftMargin = tTVideoLandingPageActivity2.wjp;
                marginLayoutParams.topMargin = tTVideoLandingPageActivity2.Xc;
                tTVideoLandingPageActivity2.Tf.setLayoutParams(marginLayoutParams);
                return;
            }
            kX.sc((View) TTVideoLandingPageActivity.this.f27583sc, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.Tf.getLayoutParams();
            TTVideoLandingPageActivity tTVideoLandingPageActivity3 = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity3.wjp = marginLayoutParams2.leftMargin;
            tTVideoLandingPageActivity3.Xc = marginLayoutParams2.topMargin;
            tTVideoLandingPageActivity3.Sfl = marginLayoutParams2.width;
            tTVideoLandingPageActivity3.YIK = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            tTVideoLandingPageActivity3.Tf.setLayoutParams(marginLayoutParams2);
        }
    };
    private final uEA.sc ZM = new uEA.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2
        /* JADX INFO: Access modifiers changed from: private */
        public void sc(int i11) {
            com.bytedance.sdk.component.Ol.We we2;
            String str;
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            if (tTVideoLandingPageActivity.BR == 0 && i11 != 0 && (we2 = tTVideoLandingPageActivity.f27583sc) != null && (str = tTVideoLandingPageActivity.kX) != null) {
                we2.a_(str);
            }
            com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = TTVideoLandingPageActivity.this.SR;
            if (tri != null && tri.getNativeVideoController() != null) {
                TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                if (!tTVideoLandingPageActivity2.Cb && tTVideoLandingPageActivity2.BR != i11) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.pFF.zY) tTVideoLandingPageActivity2.SR.getNativeVideoController()).zY(i11);
                }
            }
            TTVideoLandingPageActivity.this.BR = i11;
        }

        @Override // com.bytedance.sdk.component.utils.uEA.sc
        public void sc(Context context, Intent intent, boolean z11, final int i11) {
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    sc(i11);
                }
            });
        }
    };

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"StaticFieldLeak"})
    public static class sc extends AsyncTask<Void, Void, Drawable> {
        private final WeakReference<t8.a> pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final Bitmap f27596sc;

        private sc(Bitmap bitmap, t8.a aVar) {
            this.f27596sc = bitmap;
            this.pFF = new WeakReference<>(aVar);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap bitmapSc = com.bytedance.sdk.component.adexpress.We.sc.sc(Xc.sc(), this.f27596sc, 25);
                if (bitmapSc == null) {
                    return null;
                }
                return new BitmapDrawable(Xc.sc().getResources(), bitmapSc);
            } catch (Throwable th2) {
                Tf.sc("TTVideoLandingPage", th2.getMessage());
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            WeakReference<t8.a> weakReference;
            if (drawable == null || (weakReference = this.pFF) == null || weakReference.get() == null) {
                return;
            }
            this.pFF.get().sc(drawable);
        }
    }

    private void BT() {
        if (this.SR == null || dE()) {
            return;
        }
        this.SR.Ql();
    }

    private void Ql() {
        HJN hjn = new HJN(this);
        this.WH = hjn;
        hjn.pFF(this.f27583sc).zY(this.Qj).We(this.Ol).pFF(this.UFX).sc(this.dE).sc(this.dE.BR()).sc(this.f27583sc).pFF("landingpage_split_screen").ExN(this.dE.BU());
    }

    private void SR() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri == null || tri.getNativeVideoController() == null || dE()) {
            return;
        }
        this.SR.Ql();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Tf() {
        Sfl sfl = this.dE;
        if (sfl == null || sfl.QLv() != 4) {
            return;
        }
        this.II.setVisibility(0);
        Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.SR.QST);
        this.McK = button;
        if (button != null) {
            sc(pFF());
            this.McK.setOnClickListener(this.QLv);
            this.McK.setOnTouchListener(this.QLv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xc() {
        return !TextUtils.isEmpty(this.kX) && this.kX.contains("__luban_sdk");
    }

    private boolean dE() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri == null || tri.getNativeVideoController() == null) {
            return true;
        }
        return this.SR.getNativeVideoController().BT();
    }

    private void sc(final int i11) {
        if (this.zY == null || !Xc()) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                kX.sc((View) TTVideoLandingPageActivity.this.zY, i11);
            }
        });
    }

    private void sc(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.McK) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.7
            @Override // java.lang.Runnable
            public void run() {
                TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                if (tTVideoLandingPageActivity.McK == null || tTVideoLandingPageActivity.isFinishing()) {
                    return;
                }
                TTVideoLandingPageActivity.this.McK.setText(str);
            }
        });
    }

    private void sc(c cVar) {
        this.Cb = this.Cb || cVar.BT();
        Boolean bool = Boolean.TRUE;
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_is_update_flag", bool);
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.Cb));
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.ExN()));
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.Qj() + cVar.TRI()));
        com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.Qj()));
    }

    private void wjp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.WH.sc("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public abstract boolean ExN();

    @SuppressLint({"ClickableViewAccessibility"})
    public void Ol() {
        Sfl sfl = this.dE;
        if (sfl == null) {
            return;
        }
        this.HJN = qr.sc(this, sfl, this.cD);
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(this, this.dE, this.cD, this.UFX);
        this.QLv = scVar;
        scVar.sc(false);
        this.QLv.zY(true);
        this.cvk.setOnClickListener(this.QLv);
        this.cvk.setOnTouchListener(this.QLv);
        this.QLv.sc(this.HJN);
    }

    public void Qj() {
        String strMxZ;
        Sfl sfl = this.dE;
        if (sfl == null || sfl.QLv() != 4) {
            return;
        }
        kX.sc((View) this.uEA, 0);
        if (!TextUtils.isEmpty(this.dE.YdT())) {
            strMxZ = this.dE.YdT();
        } else if (TextUtils.isEmpty(this.dE.bSP())) {
            strMxZ = !TextUtils.isEmpty(this.dE.MxZ()) ? this.dE.MxZ() : "";
        } else {
            strMxZ = this.dE.bSP();
        }
        if (this.dE.qfG() != null && this.dE.qfG().sc() != null) {
            kX.sc((View) this.FI, 0);
            kX.sc((View) this.JPJ, 4);
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.dE.qfG(), this.FI, this.dE);
        } else if (!TextUtils.isEmpty(strMxZ)) {
            kX.sc((View) this.FI, 4);
            kX.sc((View) this.JPJ, 0);
            this.JPJ.setText(strMxZ.substring(0, 1));
        }
        if (!TextUtils.isEmpty(this.dE.NQ())) {
            this.cvk.setText(this.dE.NQ());
        }
        if (!TextUtils.isEmpty(strMxZ)) {
            this.WP.setText(strMxZ);
        }
        kX.sc((View) this.WP, 0);
        kX.sc((View) this.cvk, 0);
    }

    public long TRI() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri == null || tri.getNativeVideoController() == null) {
            return 0L;
        }
        return this.SR.getNativeVideoController().Qj();
    }

    public void UFX() {
        try {
            uEA.sc(this.ZM);
        } catch (Exception unused) {
        }
    }

    public void WH() {
        uEA.sc(this.ZM, this.ExN);
    }

    public void We() {
        if (ExN()) {
            try {
                com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI(this.ExN, this.dE, true, null);
                this.SR = tri;
                if (tri.getNativeVideoController() != null) {
                    this.SR.getNativeVideoController().sc(false);
                }
                if (this.Cb) {
                    this.Tf.setVisibility(0);
                    this.Tf.removeAllViews();
                    this.Tf.addView(this.SR);
                    this.SR.pFF(true);
                } else {
                    if (!this.cJ) {
                        this.BT = 0L;
                    }
                    if (this.JoC != null && this.SR.getNativeVideoController() != null) {
                        this.SR.getNativeVideoController().pFF(this.JoC.f28651qr);
                        this.SR.getNativeVideoController().zY(this.JoC.ExN);
                        this.SR.setIsQuiet(Xc.We().zY(String.valueOf(this.dE.QT())));
                    }
                    if (this.SR.sc(this.BT, this.OXF, this.Cb)) {
                        this.Tf.setVisibility(0);
                        this.Tf.removeAllViews();
                        this.Tf.addView(this.SR);
                    }
                    if (this.SR.getNativeVideoController() != null) {
                        this.SR.getNativeVideoController().sc(false);
                        this.SR.getNativeVideoController().sc(this.f27580ht);
                    }
                }
                String strSc = this.dE.ht().get(0).sc();
                com.bytedance.sdk.openadsdk.Ol.We.sc().sc(strSc).sc(this.dE.ht().get(0).pFF()).pFF(this.dE.ht().get(0).zY()).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(this.dE, strSc, new dE<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.10
                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(int i11, String str, @Nullable Throwable th2) {
                    }

                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
                        try {
                            new sc(ufx.pFF(), TTVideoLandingPageActivity.this.SR.getNativeVideoController().Ql()).execute(new Void[0]);
                        } catch (Exception unused) {
                        }
                    }
                }), 4);
                this.SR.findViewById(520093726).setOnTouchListener(null);
                this.SR.findViewById(520093726).setOnClickListener(null);
            } catch (Exception e11) {
                Tf.sc("TTVideoLandingPage", e11.getMessage());
                if (this.SR == null) {
                    ApmHelper.reportCustomError("mNativeVideoTsView is null", "FUNCTION EXCEPTION", e11);
                }
            }
            if (this.BR == 0) {
                try {
                    Toast.makeText(this, com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri;
        if (this.Gb && (tri = this.SR) != null && tri.getNativeVideoController() != null) {
            ((t8.b) this.SR.getNativeVideoController()).ExN(null, null);
            this.Gb = false;
        } else if (!Xc() || this.qKn.getAndSet(true)) {
            super.onBackPressed();
        } else {
            wjp();
            sc(0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Tf();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.SR.ExN()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            Xc.pFF(this);
        } catch (Throwable unused2) {
        }
        this.BR = BT.zY(getApplicationContext());
        try {
            setContentView(sc());
            this.ExN = this;
            Intent intent = getIntent();
            this.TRI = intent.getIntExtra("sdk_version", 1);
            this.Qj = intent.getStringExtra("adid");
            this.Ol = intent.getStringExtra("log_extra");
            this.UFX = intent.getIntExtra("source", -1);
            this.kX = intent.getStringExtra("url");
            String stringExtra = intent.getStringExtra("web_title");
            this.cD = intent.getStringExtra("event_tag");
            this.GI = intent.getStringExtra("gecko_id");
            this.cJ = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.BT = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.dE = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(stringExtra3));
                    } catch (Exception unused3) {
                    }
                }
                Sfl sfl = this.dE;
                if (sfl != null) {
                    this.Ql = sfl.dix();
                }
            } else {
                Sfl sflPFF = FI.sc().pFF();
                this.dE = sflPFF;
                if (sflPFF != null) {
                    this.Ql = sflPFF.dix();
                }
                FI.sc().TRI();
            }
            if (this.dE == null) {
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.GI)) {
                this.f27579eo = com.bytedance.sdk.openadsdk.qr.pFF.sc().pFF();
                int iSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.f27579eo, this.GI);
                this.OKY = iSc;
                this.f27581ko = iSc > 0 ? 2 : 0;
            }
            if (stringExtra2 != null) {
                try {
                    this.JoC = com.bytedance.sdk.openadsdk.multipro.pFF.sc.sc(new JSONObject(stringExtra2));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.multipro.pFF.sc scVar = this.JoC;
                if (scVar != null) {
                    this.BT = scVar.f28651qr;
                }
            }
            if (bundle != null) {
                String string = bundle.getString("material_meta");
                if (this.dE == null) {
                    try {
                        this.dE = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(string));
                    } catch (Throwable unused5) {
                    }
                }
                long j11 = bundle.getLong("video_play_position");
                if (j11 > 0) {
                    this.BT = j11;
                }
            }
            zY();
            Ol();
            Ql();
            sc(4);
            if (this.f27583sc != null) {
                com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(this.ExN).sc(true).pFF(false).sc(this.f27583sc.getWebView());
                UFX ufxSc = new UFX(this.dE, this.f27583sc.getWebView(), new WH() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.1
                    @Override // com.bytedance.sdk.openadsdk.We.WH
                    public void sc(int i11) {
                        com.bytedance.sdk.openadsdk.We.zY.sc.sc(TTVideoLandingPageActivity.this.OKY, TTVideoLandingPageActivity.this.qfG.get(), TTVideoLandingPageActivity.this.Yhz.get(), TTVideoLandingPageActivity.this.yL.get() - TTVideoLandingPageActivity.this.Yhz.get(), TTVideoLandingPageActivity.this.dE, "landingpage_split_screen", i11);
                    }
                }, this.f27581ko).sc(true);
                this.CYO = ufxSc;
                this.MxZ = ufxSc.f27333sc;
                ufxSc.sc("landingpage_split_screen");
            }
            com.bytedance.sdk.component.Ol.We we2 = this.f27583sc;
            if (we2 != null) {
                we2.setLandingPage(true);
                this.f27583sc.setTag("landingpage_split_screen");
                this.f27583sc.setMaterialMeta(this.dE.bZj());
                this.f27583sc.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(this.ExN, this.WH, this.Qj, this.CYO, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        try {
                            if (TextUtils.isEmpty(TTVideoLandingPageActivity.this.GI)) {
                                return super.shouldInterceptRequest(webView, str);
                            }
                            TTVideoLandingPageActivity.this.yL.incrementAndGet();
                            WebResourceResponseModel webResourceResponseModelSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(TTVideoLandingPageActivity.this.f27579eo, TTVideoLandingPageActivity.this.GI, str);
                            if (webResourceResponseModelSc != null && webResourceResponseModelSc.getWebResourceResponse() != null) {
                                TTVideoLandingPageActivity.this.Yhz.incrementAndGet();
                                return webResourceResponseModelSc.getWebResourceResponse();
                            }
                            if (webResourceResponseModelSc != null && webResourceResponseModelSc.getMsg() == 2) {
                                TTVideoLandingPageActivity.this.qfG.incrementAndGet();
                            }
                            return super.shouldInterceptRequest(webView, str);
                        } catch (Throwable th2) {
                            Tf.sc("TTVideoLandingPage", "shouldInterceptRequest url error", th2);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                });
                com.bytedance.sdk.component.Ol.We we3 = this.f27583sc;
                we3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we3.getWebView(), this.TRI));
            }
            com.bytedance.sdk.component.Ol.We we4 = this.f27583sc;
            if (we4 != null) {
                we4.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(this.dE, "landingpage_split_screen", this.f27581ko);
            com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.f27583sc, this.kX);
            this.f27583sc.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.WH, this.CYO) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i11) {
                    super.onProgressChanged(webView, i11);
                }
            });
            this.f27583sc.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j12) {
                    com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri = TTVideoLandingPageActivity.this.HJN;
                    if (tri != null) {
                        tri.We();
                    }
                }
            });
            TextView textView = this.We;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_web_title_default");
                }
                textView.setText(stringExtra);
            }
            WH();
            We();
            Tf();
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(SystemClock.elapsedRealtime() - jElapsedRealtime, this.dE, "landingpage_split_screen", this.f27579eo, this.GI);
        } catch (Throwable unused6) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UFX();
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
            this.dE.TRI(false);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.Ol.We we2 = this.f27583sc;
        if (we2 != null) {
            com.bytedance.sdk.openadsdk.core.Cb.sc(we2.getWebView());
        }
        this.f27583sc = null;
        HJN hjn = this.WH;
        if (hjn != null) {
            hjn.UFX();
        }
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri != null && tri.getNativeVideoController() != null) {
            this.SR.getNativeVideoController().We();
        }
        this.SR = null;
        this.dE = null;
        UFX ufx = this.CYO;
        if (ufx != null) {
            ufx.zY(true);
        }
        if (!TextUtils.isEmpty(this.GI)) {
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.Yhz.get(), this.yL.get(), this.dE);
        }
        com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.f27579eo);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BT();
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri == null || tri.getNativeVideoController() == null) {
            return;
        }
        sc(this.SR.getNativeVideoController());
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.OXF) {
            SR();
        }
        this.OXF = false;
        HJN hjn = this.WH;
        if (hjn != null) {
            hjn.WH();
        }
        UFX ufx = this.CYO;
        if (ufx != null) {
            ufx.qr();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Sfl sfl = this.dE;
        bundle.putString("material_meta", sfl != null ? sfl.JP().toString() : null);
        bundle.putLong("video_play_position", this.BT);
        bundle.putBoolean("is_complete", this.Cb);
        long jExN = this.BT;
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri != null && tri.getNativeVideoController() != null) {
            jExN = this.SR.getNativeVideoController().ExN();
        }
        bundle.putLong("video_play_position", jExN);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.zY.sc(this, this.dE);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        UFX ufx = this.CYO;
        if (ufx != null) {
            ufx.Qj();
        }
    }

    public String pFF() {
        Sfl sfl = this.dE;
        if (sfl != null && !TextUtils.isEmpty(sfl.NQ())) {
            this.Dl = this.dE.NQ();
        }
        return this.Dl;
    }

    public int qr() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri == null || tri.getNativeVideoController() == null) {
            return 0;
        }
        return this.SR.getNativeVideoController().WH();
    }

    public abstract View sc();

    @Override // com.bytedance.sdk.openadsdk.WH.We
    public void sc(boolean z11, JSONArray jSONArray) {
        if (!z11 || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.f27582pc = jSONArray;
    }

    public void zY() {
        this.II = (SR) findViewById(com.bytedance.sdk.openadsdk.utils.SR.ZM);
        this.f27583sc = (com.bytedance.sdk.component.Ol.We) findViewById(com.bytedance.sdk.openadsdk.utils.SR.QLv);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.pFF = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObjectSc;
                    TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                    if (tTVideoLandingPageActivity.f27583sc != null) {
                        com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc scVar = tTVideoLandingPageActivity.MxZ;
                        if (scVar != null) {
                            scVar.sc();
                        }
                        if (TTVideoLandingPageActivity.this.f27583sc.ExN()) {
                            TTVideoLandingPageActivity.this.f27583sc.TRI();
                            return;
                        }
                        if (TTVideoLandingPageActivity.this.Xc()) {
                            TTVideoLandingPageActivity.this.onBackPressed();
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = TTVideoLandingPageActivity.this.SR;
                        if (tri == null || tri.getNativeVideoController() == null) {
                            jSONObjectSc = null;
                        } else {
                            TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                            jSONObjectSc = cJ.sc(tTVideoLandingPageActivity2.dE, tTVideoLandingPageActivity2.SR.getNativeVideoController().TRI(), TTVideoLandingPageActivity.this.SR.getNativeVideoController().Tf());
                        }
                        JSONObject jSONObject = jSONObjectSc;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity3 = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.We.zY.sc(tTVideoLandingPageActivity3.dE, "embeded_ad", "detail_back", tTVideoLandingPageActivity3.TRI(), TTVideoLandingPageActivity.this.qr(), jSONObject, (com.bytedance.sdk.openadsdk.We.qr) null);
                        TTVideoLandingPageActivity.this.finish();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri != null) {
            tri.setIsAutoPlay(this.cJ);
        }
        ImageView imageView2 = (ImageView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.JoC);
        this.zY = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObjectSc;
                    com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri2 = TTVideoLandingPageActivity.this.SR;
                    if (tri2 != null) {
                        if (tri2.getNativeVideoController() != null) {
                            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                            jSONObjectSc = cJ.sc(tTVideoLandingPageActivity.dE, tTVideoLandingPageActivity.SR.getNativeVideoController().TRI(), TTVideoLandingPageActivity.this.SR.getNativeVideoController().Tf());
                        } else {
                            jSONObjectSc = null;
                        }
                        JSONObject jSONObject = jSONObjectSc;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity2 = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.We.zY.sc(tTVideoLandingPageActivity2.dE, "embeded_ad", "detail_skip", tTVideoLandingPageActivity2.TRI(), TTVideoLandingPageActivity.this.qr(), jSONObject, (com.bytedance.sdk.openadsdk.We.qr) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.We = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.Mrq);
        this.Tf = (FrameLayout) findViewById(com.bytedance.sdk.openadsdk.utils.SR.BR);
        this.uEA = (RelativeLayout) findViewById(com.bytedance.sdk.openadsdk.utils.SR.CYO);
        this.JPJ = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.f28751pc);
        this.WP = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.GI);
        this.cvk = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.MxZ);
        this.FI = (com.bytedance.sdk.openadsdk.core.widget.sc) findViewById(com.bytedance.sdk.openadsdk.utils.SR.qKn);
        Qj();
    }
}
