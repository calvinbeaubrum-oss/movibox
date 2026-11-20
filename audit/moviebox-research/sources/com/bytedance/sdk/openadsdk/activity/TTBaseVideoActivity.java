package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.component.reward.pFF.qr;
import com.bytedance.sdk.openadsdk.component.reward.sc.Qj;
import com.bytedance.sdk.openadsdk.component.reward.sc.UFX;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.Ql;
import com.bytedance.sdk.openadsdk.utils.WP;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TTBaseVideoActivity extends TTBaseActivity implements FI.sc, com.bytedance.sdk.openadsdk.core.Ql.We.pFF {
    protected IListenerManager ExN;
    int Ol;
    boolean Qj;
    private final AtomicBoolean Ql;
    int TRI;
    private int Tf;
    private boolean UFX;
    protected com.bytedance.sdk.openadsdk.Tf.ExN WH;
    final FI We;
    com.bytedance.sdk.openadsdk.component.reward.sc.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final String f27516sc;

    @Nullable
    protected com.bytedance.sdk.openadsdk.component.reward.pFF.pFF zY;

    public TTBaseVideoActivity() {
        this.f27516sc = Xc() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.We = new FI(Looper.getMainLooper(), this);
        this.UFX = false;
        this.Tf = 0;
        this.Ol = 1;
        this.Ql = new AtomicBoolean(false);
        this.WH = new com.bytedance.sdk.openadsdk.Tf.ExN() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.Tf.ExN
            public void sc() {
                TTBaseVideoActivity.this.SR();
            }
        };
    }

    private boolean Dl() {
        if (this.pFF.WH.get() && this.pFF.f27912qr) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.pFF.WH.get();
        }
        return true;
    }

    private void Sfl() {
        setContentView(this.pFF.JoC);
        this.pFF.JoC.sc(this.zY);
        this.zY.sc(this, this.We);
        this.zY.UFX();
    }

    private void YIK() {
        this.zY.sc(this.WH);
        this.TRI = (int) this.pFF.JPJ.McK();
        dE();
        zY();
        if (this.pFF.pFF.GOt() == null || this.pFF.pFF.GOt().sc() == null) {
            return;
        }
        this.pFF.pFF.GOt().sc().sc(0L);
    }

    private void sc(Sfl sfl, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = new com.bytedance.sdk.openadsdk.component.reward.sc.sc(this, this.We, sfl, this, 0);
        this.pFF = scVar;
        com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(scVar, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            sc(intent);
            sfl.sc(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.pFF.fT) {
            sc();
        }
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pffSc = qr.sc(this.pFF);
        this.zY = pffSc;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
        scVar2.kDg = pffSc;
        Ql.sc(scVar2);
        Objects.toString(this.zY);
    }

    public void BT() {
        this.We.removeMessages(LogSeverity.WARNING_VALUE);
    }

    public abstract void ExN();

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void Ol() {
        this.pFF.JPJ.HJN();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void Qj() {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        pff.Ql();
    }

    public void Ql() {
        Message message = new Message();
        message.what = LogSeverity.WARNING_VALUE;
        if (Xc()) {
            sc(10000);
        }
        this.We.sendMessageDelayed(message, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public final void TRI() {
        if (this.Ql.compareAndSet(false, true)) {
            Dl.sc("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            ExN();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void Tf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void UFX() {
        if (!this.pFF.SR.getAndSet(true) || JPJ.zY(this.pFF.pFF)) {
            this.pFF.McK.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public View WH() {
        return this.pFF.JPJ.Gb();
    }

    public abstract boolean Xc();

    public abstract void dE();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.pFF == null) {
            return;
        }
        if (WP.ExN()) {
            kX.pFF((Activity) this);
        }
        if (JPJ.qr(this.pFF.pFF) && !this.pFF.WH.get()) {
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        } else {
            if (!JPJ.ExN(this.pFF.pFF) || this.pFF.WP.Qj(Qj.pFF)) {
                return;
            }
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null) {
            return;
        }
        scVar.II.sc();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff;
        if (this.pFF == null || (pff = this.zY) == null) {
            super.onBackPressed();
        } else {
            pff.JPJ();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar;
        super.onCreate(bundle);
        Dl.sc("BVA", "onCreate ".concat(String.valueOf(this)));
        Xc.pFF(getApplicationContext());
        if (!SR.ExN()) {
            finish();
            return;
        }
        Sfl sflSc = com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(getIntent(), bundle, this);
        if (sflSc == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.pFF.sc(sflSc);
        this.Ol = sflSc.gx();
        sc(sflSc, bundle);
        if (bundle != null) {
            if (sflSc.FJp()) {
                this.Ql.set(true);
            }
            if (sflSc.io() && (scVar = this.pFF) != null) {
                scVar.Ql.set(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
            if (scVar2 != null) {
                scVar2.McK.qr();
            }
        }
        try {
            Sfl();
            YIK();
        } catch (Throwable th2) {
            Tf.sc("TTAD.BVA", "onCreate: ", th2);
            com.bytedance.sdk.openadsdk.SR.zY.pFF();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Dl.sc("BVA", "onDestroy ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null || this.zY == null) {
            return;
        }
        if (scVar.YdT > 0 && scVar.Ql.get()) {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.pFF.YdT);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
            com.bytedance.sdk.openadsdk.We.zY.sc(strValueOf, scVar2.pFF, this.f27516sc, scVar2.JPJ.sc());
            this.pFF.YdT = 0L;
        }
        this.pFF.Gb.pFF();
        this.We.removeCallbacksAndMessages(null);
        this.zY.uEA();
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.pFF.pFF);
        com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF(this.pFF.pFF);
        final AdSlot adSlotCb = this.pFF.pFF.Cb();
        if (!this.pFF.JPJ.FI() && adSlotCb != null && TextUtils.isEmpty(adSlotCb.getBidAdm())) {
            SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TTBaseVideoActivity.this.Xc()) {
                        com.bytedance.sdk.openadsdk.component.reward.Tf.sc(Xc.sc()).sc(adSlotCb);
                    } else {
                        com.bytedance.sdk.openadsdk.component.reward.ExN.sc(Xc.sc()).sc(adSlotCb);
                    }
                }
            });
        }
        Ql.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Dl.sc("BVA", "onPause ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        pff.YIK();
    }

    @Override // android.app.Activity
    public void onRestart() {
        Sfl sfl;
        super.onRestart();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null || (sfl = scVar.pFF) == null) {
            return;
        }
        if (this.f27515qr && !sfl.TpG() && !TextUtils.isEmpty(Sfl.sc(this, sfl))) {
            finish();
        }
        if (sfl.TpG()) {
            sfl.ExN(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff;
        super.onResume();
        Dl.sc("BVA", "onResume ".concat(String.valueOf(this)));
        if (this.pFF == null || (pff = this.zY) == null) {
            return;
        }
        pff.Xc();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        scVar.yL = true;
        scVar.II.pFF(this.We);
        if (Dl()) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
            scVar2.cJ.sc(scVar2.pFF.vYl());
        }
        this.pFF.BR.BT();
        this.pFF.Cb.uEA();
        this.pFF.WP.Ql();
        if (this.zY.pFF()) {
            this.pFF.JPJ.sc(this.zY);
            this.pFF.JPJ.sc(false, this, this.Tf != 0);
        }
        this.Tf++;
        qr();
        com.bytedance.sdk.openadsdk.component.reward.view.Qj qj2 = this.pFF.cvk;
        if (qj2 != null) {
            qj2.qr();
        }
        this.pFF.II.sc(this.We);
        this.zY.Sfl();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        if (scVar.Ql.get()) {
            this.pFF.pFF.Qj(true);
        }
        if (this.Ql.get()) {
            this.pFF.pFF.BCJ();
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(this.pFF, bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Dl.sc("BVA", "onStart ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar == null) {
            return;
        }
        scVar.Cb.Cb();
        com.bytedance.sdk.openadsdk.utils.zY.sc(this, this.pFF.pFF);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        Dl.sc("BVA", "onStop ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        pff.Dl();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        UFX ufx;
        super.onWindowFocusChanged(z11);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.pFF;
        if (scVar != null && (ufx = scVar.McK) != null) {
            ufx.pFF(z11);
            this.pFF.McK.zY(z11);
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.pFF;
        if (scVar2 != null) {
            com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = scVar2.kDg;
            if (pff instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) {
                ((com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) pff).pFF(z11);
            }
        }
    }

    public IListenerManager pFF(int i11) {
        if (this.ExN == null) {
            this.ExN = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(i11));
        }
        return this.ExN;
    }

    public void qr() {
        if (wjp() && !this.UFX) {
            this.UFX = true;
            getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.3
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = tTBaseVideoActivity.pFF;
                    com.bytedance.sdk.openadsdk.component.reward.sc.TRI tri = scVar.HJN;
                    float[] fArrSc = scVar.II.sc(tTBaseVideoActivity.Ol);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tri.sc(fArrSc, tTBaseVideoActivity2, tTBaseVideoActivity2.zY);
                }
            });
        }
    }

    public abstract void sc();

    public void sc(@NonNull Intent intent) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.We.pFF
    public void sc(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        pff.sc(message);
    }

    public void sc(boolean z11, int i11) {
        sc(z11, false, i11);
    }

    public void sc(boolean z11, boolean z12, int i11) {
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff == null) {
            return;
        }
        pff.sc(z11, z12, false, i11);
    }

    public boolean wjp() {
        return false;
    }

    public void zY() {
        if (JPJ.zY(this.pFF.pFF)) {
            sc(false, com.bytedance.sdk.openadsdk.We.pFF.C0272pFF.zY);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff = this.zY;
        if (pff != null) {
            pff.sc(this.pFF.BR.TRI());
            this.zY.cvk();
        }
    }
}
