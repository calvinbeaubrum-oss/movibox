package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.applovin.impl.i4;
import com.applovin.impl.m3;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.yp;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinCmpService;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class CmpServiceImpl implements AppLovinCmpService, com.applovin.impl.privacy.cmp.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f21821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m3 f21822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.applovin.impl.privacy.cmp.a f21823c = b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f21824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f21825e;

    /* JADX INFO: compiled from: source.java */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppLovinCmpService.OnCompletedListener f21826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f21827b;

        /* JADX INFO: renamed from: com.applovin.impl.privacy.cmp.CmpServiceImpl$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0194a implements e {
            public C0194a() {
            }

            @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.e
            public void a(AppLovinCmpError appLovinCmpError) {
                a.this.f21826a.onCompleted(appLovinCmpError);
            }
        }

        public a(AppLovinCmpService.OnCompletedListener onCompletedListener, Activity activity) {
            this.f21826a = onCompletedListener;
            this.f21827b = activity;
        }

        @Override // com.applovin.impl.privacy.cmp.CmpServiceImpl.d
        public void a(AppLovinCmpError appLovinCmpError) {
            if (appLovinCmpError != null) {
                this.f21826a.onCompleted(appLovinCmpError);
            } else {
                CmpServiceImpl.this.showCmp(this.f21827b, new C0194a());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f21830a;

        public b(Activity activity) {
            this.f21830a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            CmpServiceImpl.this.f21823c.a(this.f21830a, CmpServiceImpl.this.f21822b, CmpServiceImpl.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f21832a;

        public c(Activity activity) {
            this.f21832a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            CmpServiceImpl.this.f21823c.b(this.f21832a, CmpServiceImpl.this.f21822b, CmpServiceImpl.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(AppLovinCmpError appLovinCmpError);
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void a(AppLovinCmpError appLovinCmpError);
    }

    public CmpServiceImpl(j jVar) {
        this.f21821a = jVar;
        this.f21822b = new m3(jVar.u().f());
    }

    private void a() {
        com.applovin.impl.privacy.cmp.a aVar = this.f21823c;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    private void a(AppLovinCmpError appLovinCmpError) {
        d dVar = this.f21824d;
        if (dVar == null) {
            return;
        }
        dVar.a(appLovinCmpError);
        this.f21824d = null;
    }

    private com.applovin.impl.privacy.cmp.a b() {
        if (yp.a("com.google.android.ump.ConsentForm")) {
            return new com.applovin.impl.privacy.cmp.a(this.f21821a);
        }
        if (!this.f21821a.u().k() || this.f21821a.u().e() != i4.a.UNIFIED) {
            return null;
        }
        n.h("AppLovinSdk", "Could not load Google UMP. Please add the Google User Messaging Platform SDK into your application. Instructions can be found here: https://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow#enabling-google-ump");
        return null;
    }

    private void b(AppLovinCmpError appLovinCmpError) {
        e eVar = this.f21825e;
        if (eVar == null) {
            return;
        }
        eVar.a(appLovinCmpError);
        this.f21825e = null;
    }

    private void c() {
        if (hasSupportedCmp()) {
            this.f21823c.c();
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public boolean hasSupportedCmp() {
        return this.f21823c != null;
    }

    public void loadCmp(Activity activity, d dVar) {
        if (!hasSupportedCmp()) {
            dVar.a(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
            return;
        }
        this.f21824d = dVar;
        b bVar = new b(activity);
        if (this.f21823c.d()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            bVar.run();
        }
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowHidden(Bundle bundle) {
        b((AppLovinCmpError) null);
        a();
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl) {
        a(cmpErrorImpl);
        a();
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowLoaded(Bundle bundle) {
        a((AppLovinCmpError) null);
    }

    @Override // com.applovin.impl.privacy.cmp.a.d
    public void onFlowShowFailed(CmpErrorImpl cmpErrorImpl) {
        b(cmpErrorImpl);
        a();
    }

    public void showCmp(Activity activity, e eVar) {
        c cVar = new c(activity);
        this.f21825e = eVar;
        if (this.f21823c.e()) {
            AppLovinSdkUtils.runOnUiThread(cVar);
        } else {
            cVar.run();
        }
    }

    @Override // com.applovin.sdk.AppLovinCmpService
    public void showCmpForExistingUser(@NonNull Activity activity, @NonNull AppLovinCmpService.OnCompletedListener onCompletedListener) {
        this.f21821a.J();
        if (n.a()) {
            this.f21821a.J().a("AppLovinCmpService", "showCmpForExistingUser(activity=" + activity + ", completedListener=" + onCompletedListener + ")");
        }
        if (!hasSupportedCmp()) {
            onCompletedListener.onCompleted(new CmpErrorImpl(AppLovinCmpError.Code.INTEGRATION_ERROR, "A supported CMP is not integrated"));
        } else {
            c();
            loadCmp(activity, new a(onCompletedListener, activity));
        }
    }

    @NonNull
    public String toString() {
        return "[CmpService]";
    }
}
