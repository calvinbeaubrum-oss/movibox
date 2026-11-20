package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class tb implements AppLovinInterstitialAdDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f23223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f23224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f23225c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile AppLovinAdLoadListener f23226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile AppLovinAdDisplayListener f23227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile AppLovinAdVideoPlaybackListener f23228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile AppLovinAdClickListener f23229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile com.applovin.impl.sdk.ad.b f23230h;

    /* JADX INFO: compiled from: source.java */
    public class a implements AppLovinAdLoadListener {
        public a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            tb.this.b(appLovinAd);
            tb.this.showAndRender(appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i11) {
            tb.this.b(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements p9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f23232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinFullscreenAdViewObserver f23233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f23234c;

        public b(Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, ViewGroup viewGroup) {
            this.f23232a = context;
            this.f23233b = appLovinFullscreenAdViewObserver;
            this.f23234c = viewGroup;
        }

        @Override // com.applovin.impl.p9.d
        public void a(p9 p9Var) {
            if (r.a((Activity) this.f23232a)) {
                com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad when parent activity is finishing");
                tb.a(tb.this.f23230h, tb.this.f23227e, "Failed to show interstitial: attempting to show ad when parent activity is finishing", null, null);
                return;
            }
            this.f23233b.setPresenter(p9Var);
            try {
                p9Var.a(this.f23234c);
            } catch (Throwable th2) {
                String str = "Failed to show interstitial: presenter threw exception " + th2;
                com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", str);
                tb.a(tb.this.f23230h, tb.this.f23227e, str, null, null);
            }
        }

        @Override // com.applovin.impl.p9.d
        public void a(String str, Throwable th2) {
            tb.a(tb.this.f23230h, tb.this.f23227e, str, th2, null);
        }
    }

    public tb(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f23223a = appLovinSdk.a();
        this.f23224b = new WeakReference(context);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            return "Failed to show interstitial: stale activity reference provided";
        }
        if (appLovinAd == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Unable to retrieve the loaded ad: " + appLovinAd2);
            return "Unable to retrieve the loaded ad";
        }
        if (!((AppLovinAdImpl) appLovinAd).hasShown() || !((Boolean) this.f23223a.a(sj.Y1)).booleanValue()) {
            return null;
        }
        com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Attempting to show ad again: " + appLovinAd);
        return "Attempting to show ad again";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i11) {
        if (this.f23226d != null) {
            this.f23226d.failedToReceiveAd(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        this.f23223a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23223a.J().a("InterstitialAdDialogWrapper", "Presenting ad in a fullscreen activity");
        }
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Context context, long j11) {
        new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.a60
            @Override // java.lang.Runnable
            public final void run() {
                this.f17461a.a(context);
            }
        }, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Context context, final ViewGroup viewGroup, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, long j11) {
        new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.b60
            @Override // java.lang.Runnable
            public final void run() {
                this.f17873a.a(viewGroup, context, appLovinFullscreenAdViewObserver);
            }
        }, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        this.f23223a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23223a.J().a("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + viewGroup + ")");
        }
        viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        p9.a(this.f23230h, this.f23229g, this.f23227e, this.f23228f, this.f23225c, this.f23223a, (Activity) context, new b(context, appLovinFullscreenAdViewObserver, viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar) {
        this.f23223a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23223a.J().a("InterstitialAdDialogWrapper", "Re-showing the current ad after app launch.");
        }
        showAndRender(bVar);
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final Context context) {
        i();
        this.f23223a.f().a(bVar);
        this.f23230h = bVar;
        final long jG = g();
        this.f23223a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23223a.J().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + jG + "ms...");
        }
        a(bVar, context, new Runnable() { // from class: com.applovin.impl.x50
            @Override // java.lang.Runnable
            public final void run() {
                this.f24259a.a(context, jG);
            }
        });
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(bVar.H()) || !bVar.a1() || e4.a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(bVar.O()).setMessage(bVar.N()).setPositiveButton(bVar.M(), (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.d60
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        alertDialogCreate.show();
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final ViewGroup viewGroup, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, final Context context) {
        i();
        this.f23223a.f().a(bVar);
        this.f23230h = bVar;
        final long jG = g();
        this.f23223a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23223a.J().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + jG + "ms...");
        }
        a(bVar, context, new Runnable() { // from class: com.applovin.impl.c60
            @Override // java.lang.Runnable
            public final void run() {
                this.f18109a.a(context, viewGroup, appLovinFullscreenAdViewObserver, jG);
            }
        });
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th2, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        com.applovin.impl.sdk.n.c("InterstitialAdDialogWrapper", str, th2);
        if (appLovinAdDisplayListener instanceof qb) {
            gc.a(appLovinAdDisplayListener, str);
        } else {
            gc.b(appLovinAdDisplayListener, bVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.f23226d != null) {
            this.f23226d.adReceived(appLovinAd);
        }
    }

    private void a(AppLovinAd appLovinAd, String str) {
        if (this.f23227e != null) {
            if (this.f23227e instanceof qb) {
                ((qb) this.f23227e).onAdDisplayFailed(str);
            } else {
                this.f23227e.adHidden(appLovinAd);
            }
        }
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f23223a.i().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i11) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z50
            @Override // java.lang.Runnable
            public final void run() {
                this.f24812a.a(i11);
            }
        });
    }

    private void b(Context context) {
        Intent intent = new Intent(context, (Class<?>) AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f23223a.b0());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        if (this.f23223a.e().a() == null && ((Boolean) this.f23223a.a(sj.L2)).booleanValue()) {
            intent.addFlags(8388608);
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.y50
            @Override // java.lang.Runnable
            public final void run() {
                this.f24553a.a(appLovinAd);
            }
        });
    }

    private Context e() {
        return (Context) this.f23224b.get();
    }

    private long g() {
        String str = this.f23223a.g0().getExtraParameters().get("fullscreen_ad_display_delay_enabled");
        if (str == null || Boolean.parseBoolean(str)) {
            return Math.max(0L, ((Long) this.f23223a.a(sj.f23023o2)).longValue());
        }
        return 0L;
    }

    private void i() {
        if (this.f23223a.e().a() == null) {
            this.f23223a.D().c(ca.f18161r);
        }
    }

    public void a() {
        this.f23229g = null;
        this.f23226d = null;
        this.f23228f = null;
        this.f23227e = null;
    }

    public AppLovinAdClickListener b() {
        return this.f23229g;
    }

    public AppLovinAdDisplayListener c() {
        return this.f23227e;
    }

    public AppLovinAdVideoPlaybackListener d() {
        return this.f23228f;
    }

    public com.applovin.impl.sdk.ad.b f() {
        return this.f23230h;
    }

    public Map h() {
        return this.f23225c;
    }

    public void j() {
        final com.applovin.impl.sdk.ad.b bVar = this.f23230h;
        long jD = bVar.d();
        if (bVar.canExpire() && bVar.getTimeToLiveMillis() <= jD) {
            bVar.setExpired();
            gc.b(this.f23227e, bVar);
        } else if (jD >= 0) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.e60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18588a.a(bVar);
                }
            }, jD);
        }
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f23229g = appLovinAdClickListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f23227e = appLovinAdDisplayListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f23226d = appLovinAdLoadListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f23228f = appLovinAdVideoPlaybackListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setExtraInfo(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        this.f23225c.put(str, obj);
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void show() {
        a(new a());
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAdA = yp.a(appLovinAd, this.f23223a);
        Context contextE = e();
        String strA = a(appLovinAdA, appLovinAd, contextE);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAd, strA);
        } else {
            a((com.applovin.impl.sdk.ad.b) appLovinAdA, contextE);
        }
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle) {
        if (viewGroup == null || lifecycle == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
            a(appLovinAd, "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
            return;
        }
        AppLovinAd appLovinAdA = yp.a(appLovinAd, this.f23223a);
        Context contextE = e();
        String strA = a(appLovinAdA, appLovinAd, contextE);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAd, strA);
            return;
        }
        AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver = new AppLovinFullscreenAdViewObserver(lifecycle, this, this.f23223a);
        lifecycle.a(appLovinFullscreenAdViewObserver);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, viewGroup, appLovinFullscreenAdViewObserver, contextE);
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
