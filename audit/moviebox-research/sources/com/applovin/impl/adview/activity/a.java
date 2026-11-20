package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.h0;
import com.applovin.impl.p9;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tb;
import com.applovin.impl.um;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f17557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f17558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f17559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f17560d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Messenger f17561e;

    /* JADX INFO: renamed from: com.applovin.impl.adview.activity.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0178a implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: com.applovin.impl.adview.activity.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0179a implements p9.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppLovinFullscreenActivity f17563a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppLovinAd f17564b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f17565c;

            public C0179a(AppLovinFullscreenActivity appLovinFullscreenActivity, AppLovinAd appLovinAd, b bVar) {
                this.f17563a = appLovinFullscreenActivity;
                this.f17564b = appLovinAd;
                this.f17565c = bVar;
            }

            @Override // com.applovin.impl.p9.d
            public void a(p9 p9Var) {
                this.f17563a.setPresenter(p9Var);
                p9Var.A();
            }

            @Override // com.applovin.impl.p9.d
            public void a(String str, Throwable th2) {
                tb.a((com.applovin.impl.sdk.ad.b) this.f17564b, this.f17565c, str, th2, this.f17563a);
            }
        }

        public C0178a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) a.this.f17559c.get();
            if (appLovinFullscreenActivity != null) {
                n unused = a.this.f17558b;
                if (n.a()) {
                    a.this.f17558b.a("AppLovinFullscreenActivity", "Presenting ad...");
                }
                b bVar = new b(a.this, null);
                p9.a((com.applovin.impl.sdk.ad.b) appLovinAd, bVar, bVar, bVar, null, a.this.f17557a, appLovinFullscreenActivity, new C0179a(appLovinFullscreenActivity, appLovinAd, bVar));
                return;
            }
            n unused2 = a.this.f17558b;
            if (n.a()) {
                a.this.f17558b.b("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i11) {
            a.this.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private b() {
        }

        public /* synthetic */ b(a aVar, C0178a c0178a) {
            this();
        }

        private void a(Bundle bundle, FullscreenAdService.c cVar) {
            Message messageObtain = Message.obtain((Handler) null, cVar.b());
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            try {
                a.this.f17561e.send(messageObtain);
            } catch (RemoteException e11) {
                n unused = a.this.f17558b;
                if (n.a()) {
                    a.this.f17558b.a("AppLovinFullscreenActivity", "Failed to forward callback (" + cVar.b() + ")", e11);
                }
            }
        }

        private void a(FullscreenAdService.c cVar) {
            a(null, cVar);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_CLICKED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_DISPLAYED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_HIDDEN);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_VIDEO_STARTED);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d11, boolean z11) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d11);
            bundle.putBoolean("fully_watched", z11);
            a(bundle, FullscreenAdService.c.AD_VIDEO_ENDED);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f17568a;

        private c(a aVar) {
            this.f17568a = new WeakReference(aVar);
        }

        public /* synthetic */ c(a aVar, C0178a c0178a) {
            this(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            if (message.what != FullscreenAdService.c.AD.b() || (aVar = (a) this.f17568a.get()) == null) {
                super.handleMessage(message);
            } else {
                aVar.a(message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
            }
        }
    }

    public a(AppLovinFullscreenActivity appLovinFullscreenActivity, j jVar) {
        this.f17557a = jVar;
        this.f17558b = jVar.J();
        this.f17559c = new WeakReference(appLovinFullscreenActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.f17559c.get();
        if (appLovinFullscreenActivity != null) {
            if (n.a()) {
                this.f17558b.a("AppLovinFullscreenActivity", "Dismissing...");
            }
            appLovinFullscreenActivity.dismiss();
        } else if (n.a()) {
            this.f17558b.b("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = JsonUtils.getString(jSONObject, "zone_id", "");
            if (!TextUtils.isEmpty(string)) {
                this.f17557a.j0().a(new um(jSONObject, h0.a(string), true, new C0178a(), this.f17557a));
                return;
            }
            throw new IllegalStateException("No zone identifier found in ad response: " + jSONObject);
        } catch (JSONException e11) {
            if (n.a()) {
                this.f17558b.a("AppLovinFullscreenActivity", "Unable to process ad: " + str, e11);
            }
            a();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f17560d.compareAndSet(false, true)) {
            if (n.a()) {
                this.f17558b.a("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            }
            this.f17561e = new Messenger(iBinder);
            Message messageObtain = Message.obtain((Handler) null, FullscreenAdService.c.AD.b());
            messageObtain.replyTo = new Messenger(new c(this, null));
            try {
                if (n.a()) {
                    this.f17558b.a("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                }
                this.f17561e.send(messageObtain);
            } catch (RemoteException e11) {
                if (n.a()) {
                    this.f17558b.a("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e11);
                }
                a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f17560d.compareAndSet(true, false) && n.a()) {
            this.f17558b.a("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }
}
