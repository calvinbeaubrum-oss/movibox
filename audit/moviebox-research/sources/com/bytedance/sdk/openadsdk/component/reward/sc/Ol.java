package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol implements Handler.Callback, com.bytedance.sdk.openadsdk.Tf.qr {
    private static final com.bytedance.sdk.openadsdk.Sfl.qr.sc WH = new com.bytedance.sdk.openadsdk.Sfl.qr.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.1
        @Override // com.bytedance.sdk.openadsdk.Sfl.qr.sc
        public void sc(String str, String str2, Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc(str, str2, th2);
        }
    };
    private final sc BT;
    private HomeWatcherReceiver Dl;
    private volatile boolean FI;
    private boolean JPJ;
    private boolean Ol;
    private boolean Qj;

    @NonNull
    private final com.bytedance.sdk.openadsdk.core.model.Sfl Ql;
    private final String SR;
    private com.bytedance.sdk.openadsdk.core.widget.UFX Sfl;
    private final Activity Tf;
    private volatile boolean UFX;
    private boolean WP;
    private wjp Xc;
    private boolean cvk;
    private com.bytedance.sdk.openadsdk.Sfl.Qj uEA;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final AtomicBoolean f27858sc = new AtomicBoolean(false);
    private final Handler dE = new Handler(this);
    boolean pFF = false;
    boolean zY = false;
    long We = 0;
    int ExN = 0;
    int TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    int f27857qr = 0;
    private int wjp = 1;
    private boolean YIK = true;
    private final com.bytedance.sdk.openadsdk.Tf.We II = new com.bytedance.sdk.openadsdk.Tf.We() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.8
        @Override // com.bytedance.sdk.openadsdk.Tf.We
        public void pFF() {
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.We
        public void sc() {
            if (!Ol.this.BT.CYO.isFinishing() && Ol.this.BT.pFF.TEo() && JPJ.dE(Ol.this.BT.pFF)) {
                Ol.this.dE.removeMessages(LogSeverity.EMERGENCY_VALUE);
                Ol.this.dE.sendMessage(Ol.sc(1, 0));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.We
        public void sc(int i11) {
        }
    };

    public Ol(sc scVar) {
        this.Qj = true;
        this.BT = scVar;
        this.Tf = scVar.CYO;
        this.SR = scVar.ExN;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.pFF;
        this.Ql = sfl;
        this.Qj = JPJ.qr(sfl);
    }

    private void Dl() {
        if (this.Qj) {
            this.Sfl = (com.bytedance.sdk.openadsdk.core.widget.UFX) this.BT.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.ixT);
        }
    }

    private String JPJ() {
        String strCvk = com.bytedance.sdk.openadsdk.core.Xc.We().cvk();
        if (TextUtils.isEmpty(strCvk) || this.Ql.NP() == null) {
            return strCvk;
        }
        String strPFF = this.Ql.NP().pFF();
        double dWe = this.Ql.NP().We();
        int iExN = this.Ql.NP().ExN();
        String strSc = (this.Ql.qfG() == null || TextUtils.isEmpty(this.Ql.qfG().sc())) ? "" : this.Ql.qfG().sc();
        String strKDg = this.Ql.kDg();
        String strZY = this.Ql.NP().zY();
        String strSc2 = this.Ql.NP().sc();
        String strPFF2 = this.Ql.NP().pFF();
        String strYdT = this.Ql.YdT();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("appname=");
        sb2.append(URLEncoder.encode(strPFF));
        sb2.append("&stars=");
        sb2.append(dWe);
        sb2.append("&comments=");
        sb2.append(iExN);
        sb2.append("&icon=");
        sb2.append(URLEncoder.encode(strSc));
        sb2.append("&downloading=true&id=");
        sb2.append(URLEncoder.encode(strKDg));
        sb2.append("&packageName=");
        sb2.append(URLEncoder.encode(strZY));
        sb2.append("&downloadUrl=");
        sb2.append(URLEncoder.encode(strSc2));
        sb2.append("&name=");
        sb2.append(URLEncoder.encode(strPFF2));
        sb2.append("&orientation=");
        sb2.append(this.wjp == 1 ? "portrait" : "landscape");
        sb2.append("&apptitle=");
        sb2.append(URLEncoder.encode(strYdT));
        return strCvk + "?" + ((Object) sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.bytedance.sdk.openadsdk.Sfl.We YIK() {
        String strTRI = com.bytedance.sdk.openadsdk.common.pFF.TRI();
        strTRI.hashCode();
        switch (strTRI) {
            case "2g":
                return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_UNKNOWN;
        }
    }

    public static Message sc(int i11, int i12) {
        Message messageObtain = Message.obtain();
        messageObtain.what = LogSeverity.EMERGENCY_VALUE;
        messageObtain.arg1 = i11;
        if (i11 == 3) {
            messageObtain.arg2 = i12;
        }
        return messageObtain;
    }

    private void sc(Context context) {
        if (this.Qj) {
            try {
                this.Dl.sc(null);
                context.getApplicationContext().unregisterReceiver(this.Dl);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean uEA() {
        if (this.Sfl == null) {
            return false;
        }
        if (this.Ql.TEo() && JPJ.wjp(this.Ql)) {
            this.Sfl.pFF(this.Ql, this.wjp);
            return true;
        }
        this.Sfl.zY();
        return false;
    }

    public boolean BT() {
        return this.FI;
    }

    public void ExN() {
        if (this.Qj && this.We <= 0) {
            this.We = System.currentTimeMillis();
            Handler handler = this.dE;
            handler.sendMessage(handler.obtainMessage(900, Ol(), 0));
            zY(true);
        }
    }

    public void ExN(int i11) {
        this.ExN = i11 - 1;
    }

    public void ExN(boolean z11) {
        com.bytedance.sdk.openadsdk.Sfl.Qj qj2;
        if (this.Qj && (qj2 = this.uEA) != null) {
            qj2.sc(z11);
        }
    }

    public int Ol() {
        return this.TRI;
    }

    public boolean Qj() {
        return this.UFX;
    }

    public void Ql() {
        if (this.Qj) {
            this.dE.removeMessages(900);
            this.dE.removeMessages(LogSeverity.CRITICAL_VALUE);
        }
    }

    public com.bytedance.sdk.openadsdk.Tf.We SR() {
        return this.II;
    }

    public void TRI() {
        com.bytedance.sdk.openadsdk.Sfl.Qj qj2;
        com.bytedance.sdk.openadsdk.utils.Tf tf2;
        if (this.Qj) {
            if (!JPJ.Qj(this.Ql) && this.Sfl.isShown() && (tf2 = this.BT.NP) != null) {
                tf2.sc(Ol() * 1000);
            }
            if (JPJ.Sfl(this.Ql) && this.Sfl.isShown()) {
                sc scVar = this.BT;
                scVar.kX.pFF(scVar.kDg);
            }
            com.bytedance.sdk.openadsdk.core.widget.UFX ufx = this.Sfl;
            if (ufx != null) {
                ufx.zY();
            }
            if (this.f27858sc.getAndSet(true)) {
                return;
            }
            if (this.BT.Cb.BR() && (qj2 = this.uEA) != null) {
                qj2.sc(1);
            }
            if (JPJ.qr(this.Ql) && JPJ.JPJ(this.Ql)) {
                wjp wjpVar = this.BT.Cb;
                if (wjpVar == null || wjpVar.BR()) {
                    sc scVar2 = this.BT;
                    scVar2.kX.sc(scVar2.kDg);
                    return;
                }
                int i11 = !this.BT.Cb.wjp() ? 2 : 3;
                com.bytedance.sdk.openadsdk.Sfl.Qj qj3 = this.uEA;
                if (qj3 != null) {
                    qj3.sc(i11);
                }
                if (JPJ.wjp(this.BT.pFF)) {
                    sc scVar3 = this.BT;
                    int i12 = scVar3.TRI;
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar3.pFF;
                    sc(i12, sfl, sfl.xP());
                    ExN();
                    this.BT.qKn.UFX();
                }
                this.BT.kX.sc(false);
                this.BT.Cb.kX();
                this.FI = true;
                this.BT.cJ.zY(false);
                this.BT.cD.sc(true);
                this.BT.f27908eo = true;
                if (JPJ.Sfl(this.Ql)) {
                    this.dE.removeMessages(900);
                    this.BT.cJ.We(false);
                    FI fi2 = this.BT.GI;
                    if (fi2 != null) {
                        fi2.removeMessages(1);
                        this.BT.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 1000L);
                    }
                }
                com.bytedance.sdk.openadsdk.Sfl.Qj qj4 = this.uEA;
                if (qj4 != null) {
                    qj4.zY(true);
                }
            }
        }
    }

    public void TRI(int i11) {
        this.ExN = i11;
    }

    public void TRI(boolean z11) {
        if (this.Qj && z11 && !this.BT.WP.qr()) {
            com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
            if (qj2 != null) {
                qj2.sc(1);
            }
            boolean zWjp = JPJ.wjp(this.Ql);
            if ((zWjp || JPJ.JPJ(this.Ql)) && this.Ql.TEo() && !JPJ.dE(this.Ql)) {
                Handler handler = this.dE;
                handler.sendMessageDelayed(handler.obtainMessage(LogSeverity.EMERGENCY_VALUE, 0, 0), 1000L);
            }
            if (zWjp) {
                this.BT.WP.Qj();
                this.BT.Cb.pFF(true);
                this.BT.Cb.zY(true);
                com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), this.BT.pFF, this.SR, "py_loading_success");
            }
        }
    }

    public void Tf() {
        if (this.Qj) {
            com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
            if (qj2 != null) {
                qj2.zY(false);
            }
            this.dE.removeMessages(900);
        }
    }

    public void UFX() {
        if (this.Qj && this.uEA != null && kX.We(this.BT.Cb.WH())) {
            this.uEA.zY(true);
        }
    }

    public int WH() {
        return this.ExN;
    }

    public int We(int i11) {
        return this.f27857qr - (this.TRI - i11);
    }

    public void We() {
        if (this.Qj) {
            try {
                HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
                this.Dl = homeWatcherReceiver;
                homeWatcherReceiver.sc(new HomeWatcherReceiver.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.7
                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.sc
                    public void pFF() {
                        Ol.this.zY = true;
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.sc
                    public void sc() {
                        Ol.this.zY = true;
                    }
                });
                this.Tf.getApplicationContext().registerReceiver(this.Dl, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Throwable unused) {
            }
        }
    }

    public void We(boolean z11) {
        com.bytedance.sdk.openadsdk.Sfl.Qj qj2;
        if (this.Qj && (qj2 = this.uEA) != null) {
            qj2.zY(z11);
        }
    }

    public boolean Xc() {
        com.bytedance.sdk.openadsdk.core.widget.UFX ufx = this.Sfl;
        return ufx != null && ufx.isShown();
    }

    public boolean dE() {
        return this.WP;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.bytedance.sdk.openadsdk.core.widget.UFX ufx;
        wjp wjpVar;
        int i11 = message.what;
        if (i11 == 900) {
            if (!this.UFX || !JPJ.wjp(this.BT.pFF)) {
                return true;
            }
            int i12 = message.arg1;
            if (i12 > 0) {
                this.BT.cJ.We(true);
                int iPFF = this.BT.WP.pFF(i12);
                if (iPFF == i12) {
                    this.BT.cJ.sc(String.valueOf(i12), null);
                } else if (iPFF > 0) {
                    this.BT.cJ.sc(String.valueOf(i12), String.format(com.bytedance.sdk.component.utils.Sfl.sc(this.BT.CYO.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(iPFF)));
                } else if (!JPJ.Qj(this.Ql) || BT()) {
                    this.BT.Sfl.set(true);
                    this.BT.kDg.BT();
                } else {
                    this.BT.cJ.sc(String.valueOf(i12), com.bytedance.sdk.component.utils.Sfl.sc(this.BT.CYO.getApplicationContext(), "tt_reward_screen_skip_tx"));
                    this.BT.cJ.ExN(true);
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                messageObtain.arg1 = i12 - 1;
                this.dE.sendMessageDelayed(messageObtain, 1000L);
                ExN(i12);
            } else {
                if (!JPJ.Qj(this.Ql) || (JPJ.JPJ(this.Ql) && this.BT.WP.qr())) {
                    this.BT.cJ.We(false);
                    this.BT.Sfl.set(true);
                    this.BT.kDg.BT();
                } else {
                    this.BT.cJ.zY();
                    this.BT.cJ.ExN(true);
                }
                if (!this.Ol) {
                    this.WP = true;
                }
            }
            this.BT.qKn.SR();
        } else {
            if (i11 != 800 || ((ufx = this.Sfl) != null && (!ufx.isShown() || this.Sfl.We()))) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            long displayDuration = 0;
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                int i13 = message.arg2;
                if (i13 != 0) {
                    jSONObject.put("remove_loading_page_reason", i13);
                }
                String strTf = JPJ.Tf(this.Ql);
                sc scVar = this.BT;
                if (scVar != null && (wjpVar = scVar.Cb) != null) {
                    String strWP = wjpVar.WP();
                    if (!TextUtils.isEmpty(strWP)) {
                        strTf = strWP;
                    }
                }
                jSONObject.put("playable_url", strTf);
                com.bytedance.sdk.openadsdk.core.widget.UFX ufx2 = this.Sfl;
                displayDuration = ufx2 != null ? ufx2.getDisplayDuration() : 0L;
                jSONObject.put("duration", displayDuration);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFPM", "handleMessage json error", e11);
            }
            long j11 = displayDuration;
            sc scVar2 = this.BT;
            com.bytedance.sdk.openadsdk.We.zY.sc(scVar2.pFF, scVar2.ExN, "remove_loading_page", jSONObject, j11);
            this.dE.removeMessages(LogSeverity.EMERGENCY_VALUE);
            if (!this.Tf.isFinishing()) {
                this.BT.WP.ExN();
            }
        }
        return true;
    }

    public void pFF() {
        if (this.Qj && !this.f27858sc.getAndSet(true)) {
            this.Xc.cJ();
            if (JPJ.Qj(this.Ql)) {
                this.Xc.qr();
            }
        }
    }

    public void pFF(int i11) {
        if (this.Qj) {
            if (i11 == 5) {
                this.Ol = true;
                if (JPJ.JPJ(this.Ql)) {
                    this.dE.removeMessages(900);
                    this.BT.GI.sendEmptyMessage(LogSeverity.CRITICAL_VALUE);
                }
            }
            this.dE.sendMessage(sc(i11, 0));
        }
    }

    public void pFF(String str) {
        com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
        if (qj2 != null) {
            if (!this.Qj) {
                return;
            }
            qj2.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(this.Ql));
            this.uEA.Ol(str);
        }
        if (BT()) {
            this.BT.Cb.We(true);
            this.BT.cD.sc(true);
            this.BT.f27908eo = true;
        }
    }

    public void pFF(boolean z11) {
        if (this.Qj) {
            if (z11) {
                try {
                    if (!TextUtils.isEmpty(this.Xc.WP()) && this.Xc.JPJ() != 0) {
                        com.bytedance.sdk.openadsdk.SR.zY.sc().sc(this.Xc.WP(), this.Xc.JPJ(), this.Xc.FI());
                    }
                } catch (Throwable unused) {
                }
            }
            if (z11) {
                try {
                    if (TextUtils.isEmpty(this.Xc.WP())) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.SR.zY.sc().pFF(this.Xc.WP());
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void qr() {
        if (this.Qj && !this.Sfl.isShown()) {
            com.bytedance.sdk.openadsdk.core.widget.UFX ufx = this.Sfl;
            if (ufx != null) {
                ufx.pFF(this.Ql, this.wjp);
                this.Sfl.setProgress(this.BT.Cb.WH() != null ? this.BT.Cb.WH().getProgress() : 0);
            }
            com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
            if (qj2 != null) {
                qj2.HJN();
            }
        }
    }

    public void sc() {
        if (this.Qj && !this.JPJ) {
            this.JPJ = true;
            sc scVar = this.BT;
            this.Xc = scVar.Cb;
            this.wjp = scVar.OKY;
            Dl();
            if (JPJ.qr(this.Ql)) {
                DeviceUtils.AudioInfoReceiver.sc(this);
            }
            if (uEA() && JPJ.wjp(this.Ql) && JPJ.dE(this.Ql)) {
                Handler handler = this.dE;
                handler.sendMessageDelayed(handler.obtainMessage(LogSeverity.EMERGENCY_VALUE, 2, JPJ.sc(2)), JPJ.YIK(this.Ql) * 1000);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.qr
    public void sc(int i11) {
        if (this.Qj) {
            if (!JPJ.Sfl(this.BT.pFF) || this.BT.WH.get()) {
                if (JPJ.wjp(this.BT.pFF) || JPJ.Sfl(this.BT.pFF)) {
                    if (this.BT.cD.pFF()) {
                        sc scVar = this.BT;
                        boolean z11 = scVar.f27908eo;
                        scVar.cD.sc();
                        if (i11 == 0) {
                            this.BT.cJ.pFF(true);
                            this.BT.JPJ.pFF(true);
                            return;
                        } else {
                            this.BT.cJ.pFF(false);
                            this.BT.JPJ.pFF(false);
                            return;
                        }
                    }
                    this.BT.cD.sc(-1);
                    sc scVar2 = this.BT;
                    boolean z12 = scVar2.f27908eo;
                    scVar2.cD.sc();
                    sc scVar3 = this.BT;
                    if (scVar3.yL) {
                        if (i11 == 0) {
                            scVar3.f27908eo = true;
                            scVar3.cJ.pFF(true);
                            this.BT.JPJ.pFF(true);
                        } else {
                            scVar3.f27908eo = false;
                            scVar3.cJ.pFF(false);
                            this.BT.JPJ.pFF(false);
                        }
                    }
                }
            }
        }
    }

    public void sc(int i11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, boolean z11) {
        if (this.Qj && sfl != null) {
            this.TRI = sfl.ds();
            this.f27857qr = com.bytedance.sdk.openadsdk.core.Xc.We().sc(String.valueOf(i11), z11);
        }
    }

    public void sc(int i11, String str, String str2) {
        if (this.Qj) {
            try {
                com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
                if (qj2 != null) {
                    qj2.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(this.Ql));
                    this.uEA.sc(i11, str, str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void sc(long j11) {
        if (this.Qj) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = WH();
            this.dE.sendMessageDelayed(messageObtain, j11);
        }
    }

    public void sc(DownloadListener downloadListener) {
        com.bytedance.sdk.component.Ol.We weUFX;
        if (this.Qj && (weUFX = this.Xc.UFX()) != null) {
            String strJPJ = JPJ();
            if (TextUtils.isEmpty(strJPJ)) {
                return;
            }
            weUFX.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(this.Tf, this.Xc.Ql(), this.Ql.kDg(), null, false) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.6
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    if (Ol.this.YIK) {
                        com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), Ol.this.Ql, Ol.this.SR, "loading_h5_success");
                    }
                    super.onPageFinished(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i11, String str, String str2) {
                    super.onReceivedError(webView, i11, str, str2);
                    Ol.this.YIK = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    Ol.this.YIK = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    Ol.this.YIK = false;
                }
            });
            weUFX.a_(strJPJ);
            weUFX.setDisplayZoomControls(false);
            weUFX.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.Xc.Ql(), this.Xc.SR()));
            weUFX.setDownloadListener(downloadListener);
        }
    }

    public void sc(final com.bytedance.sdk.openadsdk.Tf.ExN exN, boolean z11) {
        com.bytedance.sdk.openadsdk.SR.pFF pff;
        com.bytedance.sdk.component.sc.Xc xcSc;
        if (this.Qj && JPJ.qr(this.Ql) && this.BT.MxZ) {
            if (com.bytedance.sdk.openadsdk.core.Ol.pFF().Xc()) {
                com.bytedance.sdk.openadsdk.Sfl.qr.sc(WH);
            }
            com.bytedance.sdk.openadsdk.Sfl.sc scVar = new com.bytedance.sdk.openadsdk.Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.2
                @Override // com.bytedance.sdk.openadsdk.Sfl.sc
                public void pFF() {
                    Ol.this.BT.Cb.Tf().zY(true);
                    com.bytedance.sdk.openadsdk.Tf.ExN exN2 = exN;
                    if (exN2 != null) {
                        exN2.sc();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.Sfl.sc
                public com.bytedance.sdk.openadsdk.Sfl.We sc() {
                    return Ol.YIK();
                }

                @Override // com.bytedance.sdk.openadsdk.Sfl.sc
                public void sc(int i11, String str) {
                    super.sc(i11, str);
                    if (Ol.this.Sfl == null || !Ol.this.Sfl.isShown()) {
                        return;
                    }
                    Ol.this.dE.sendMessage(Ol.sc(3, JPJ.sc(i11)));
                }

                @Override // com.bytedance.sdk.openadsdk.Sfl.sc
                public void sc(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.We.zY.pFF(Ol.this.Ql, Ol.this.SR, "playable_track", jSONObject);
                }
            };
            com.bytedance.sdk.openadsdk.Sfl.zY zYVar = new com.bytedance.sdk.openadsdk.Sfl.zY() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.3
                @Override // com.bytedance.sdk.openadsdk.Sfl.zY
                public void sc(String str, JSONObject jSONObject) {
                    Ol.this.BT.Cb.Tf().sc(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BidResponsedEx.KEY_CID, this.Ql.kDg());
                jSONObject.put("log_extra", this.Ql.mD());
                com.bytedance.sdk.openadsdk.Sfl.Qj qjExN = com.bytedance.sdk.openadsdk.Sfl.Qj.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), this.BT.Cb.WH().getWebView(), zYVar, scVar).qr(this.BT.Cb.WP()).ExN(com.bytedance.sdk.openadsdk.common.pFF.sc(com.bytedance.sdk.openadsdk.core.Xc.sc())).sc(com.bytedance.sdk.openadsdk.common.pFF.sc()).zY(jSONObject).sc("sdkEdition", com.bytedance.sdk.openadsdk.common.pFF.zY()).pFF(com.bytedance.sdk.openadsdk.common.pFF.ExN()).We(com.bytedance.sdk.openadsdk.common.pFF.We()).We(false).sc(z11).sc(JPJ.YIK(this.Ql)).pFF(JPJ.YIK(this.Ql)).ExN(JPJ.wjp(this.Ql));
                this.uEA = qjExN;
                if (qjExN == null) {
                    pff = new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.4
                        @Override // com.bytedance.sdk.openadsdk.SR.pFF
                        public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("PlayablePlugin_init").pFF(jSONObject2.toString());
                        }
                    };
                    com.bytedance.sdk.openadsdk.SR.zY.sc("PlayablePlugin_init", false, pff);
                }
            } catch (Exception unused) {
                if (this.uEA == null) {
                    pff = new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.4
                        @Override // com.bytedance.sdk.openadsdk.SR.pFF
                        public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("PlayablePlugin_init").pFF(jSONObject2.toString());
                        }
                    };
                }
            } catch (Throwable th2) {
                if (this.uEA == null) {
                    com.bytedance.sdk.openadsdk.SR.zY.sc("PlayablePlugin_init", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.4
                        @Override // com.bytedance.sdk.openadsdk.SR.pFF
                        public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("PlayablePlugin_init").pFF(jSONObject2.toString());
                        }
                    });
                }
                throw th2;
            }
            if (this.uEA != null && !TextUtils.isEmpty(JPJ.UFX(this.Ql))) {
                this.uEA.zY(JPJ.UFX(this.Ql));
            }
            com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
            if (qj2 != null) {
                Set<String> setUFX = qj2.UFX();
                final WeakReference weakReference = new WeakReference(this.uEA);
                for (String str : setUFX) {
                    if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (xcSc = this.BT.Cb.Tf().sc()) != null) {
                        xcSc.sc(str, new com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Ol.5
                            @Override // com.bytedance.sdk.component.sc.ExN
                            public JSONObject sc(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.sc.TRI tri) {
                                try {
                                    com.bytedance.sdk.openadsdk.Sfl.Qj qj3 = (com.bytedance.sdk.openadsdk.Sfl.Qj) weakReference.get();
                                    if (qj3 == null) {
                                        return null;
                                    }
                                    return qj3.We(sc(), jSONObject2);
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void sc(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        com.bytedance.sdk.openadsdk.core.widget.UFX ufx;
        if (!this.Qj || (ufx = this.Sfl) == null || ufx.getDownloadButton() == null) {
            return;
        }
        if (JPJ.wjp(this.Ql) || JPJ.JPJ(this.Ql)) {
            this.Sfl.getDownloadButton().setOnClickListener(exN);
            this.Sfl.getDownloadButton().setOnTouchListener(exN);
        }
    }

    public void sc(String str) {
        if (this.Qj && this.zY) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.We);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFPM", "sendPlayableEvent error", e11);
            }
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.Ql, this.SR, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.zY = false;
            }
        }
    }

    public void sc(JSONObject jSONObject) {
        if (this.Qj && jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.We);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFPM", "endShow json error", e11);
            }
        }
    }

    public void sc(boolean z11) {
        if (this.Qj && z11) {
            this.Xc.WH().setDomStorageEnabled(true);
        }
    }

    public void sc(boolean z11, String str, int i11) {
        if (this.Qj) {
            try {
                com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
                if (qj2 != null) {
                    qj2.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(this.Ql));
                    this.uEA.sc(z11, str, i11);
                }
            } catch (Exception unused) {
            }
        }
    }

    public com.bytedance.sdk.openadsdk.Sfl.Qj wjp() {
        return this.uEA;
    }

    public void zY() {
        if (this.Qj && !this.cvk) {
            this.cvk = true;
            zY(false);
            sc(this.Tf.getApplicationContext());
            com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
            if (qj2 != null) {
                qj2.cJ();
            }
            this.dE.removeCallbacksAndMessages(null);
            DeviceUtils.AudioInfoReceiver.pFF(this);
        }
    }

    public void zY(int i11) {
        com.bytedance.sdk.openadsdk.core.widget.UFX ufx;
        if (this.Qj && (ufx = this.Sfl) != null) {
            ufx.setProgress(i11);
        }
    }

    public void zY(String str) {
        com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.uEA;
        if (qj2 == null || !this.Qj) {
            return;
        }
        qj2.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(this.Ql));
        this.uEA.Qj(str);
    }

    public void zY(boolean z11) {
        if (this.Qj) {
            this.UFX = z11;
            if (z11) {
                return;
            }
            this.dE.removeMessages(900);
        }
    }
}
