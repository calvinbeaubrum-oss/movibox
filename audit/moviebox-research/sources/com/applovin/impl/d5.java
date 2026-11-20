package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CustomTabsClient f18367b;

    /* JADX INFO: compiled from: source.java */
    public class a extends androidx.browser.customtabs.f {
        public a() {
        }

        @Override // androidx.browser.customtabs.f
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            d5.this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                d5.this.f18366a.J().a("CustomTabsManager", "Connection successful: " + componentName);
            }
            d5.this.f18367b = customTabsClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d5.this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                d5.this.f18366a.J().a("CustomTabsManager", "Service disconnected: " + componentName);
            }
            d5.this.f18367b = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends androidx.browser.customtabs.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.adview.a f18369a;

        public b(com.applovin.impl.adview.a aVar) {
            this.f18369a = aVar;
        }

        @Override // androidx.browser.customtabs.c
        public void onNavigationEvent(int i11, Bundle bundle) {
            com.applovin.impl.sdk.ad.b bVarI = this.f18369a.i();
            if (bVarI == null) {
                d5.this.f18366a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    d5.this.f18366a.J().b("CustomTabsManager", "Unable to track navigation event (" + i11 + "). No ad specified.");
                }
                return;
            }
            switch (i11) {
                case 1:
                    if (bVarI.Q0()) {
                        d5.this.f18366a.i().trackCustomTabsNavigationStarted(bVarI);
                    }
                    break;
                case 2:
                    if (bVarI.Q0()) {
                        d5.this.f18366a.i().trackCustomTabsNavigationFinished(bVarI);
                    }
                    break;
                case 3:
                    if (bVarI.Q0()) {
                        d5.this.f18366a.i().trackCustomTabsNavigationFailed(bVarI);
                    }
                    break;
                case 4:
                    if (bVarI.Q0()) {
                        d5.this.f18366a.i().trackCustomTabsNavigationAborted(bVarI);
                    }
                    break;
                case 5:
                    if (bVarI.Q0()) {
                        d5.this.f18366a.i().trackCustomTabsTabShown(bVarI);
                    }
                    gc.c(this.f18369a.e(), bVarI, this.f18369a.k());
                    break;
                case 6:
                    if (bVarI.Q0()) {
                        d5.this.f18366a.i().trackCustomTabsTabHidden(bVarI);
                    }
                    gc.a(this.f18369a.e(), bVarI, this.f18369a.k());
                    break;
                default:
                    d5.this.f18366a.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        d5.this.f18366a.J().a("CustomTabsManager", "Unknown navigation event: " + i11);
                    }
                    break;
            }
        }

        @Override // androidx.browser.customtabs.c
        public void onRelationshipValidationResult(int i11, Uri uri, boolean z11, Bundle bundle) {
            d5.this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVarJ = d5.this.f18366a.J();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Validation ");
                sb2.append(z11 ? "succeeded" : "failed");
                sb2.append(" for session-URL relation(");
                sb2.append(i11);
                sb2.append("), requestedOrigin(");
                sb2.append(uri);
                sb2.append(")");
                nVarJ.a("CustomTabsManager", sb2.toString());
            }
        }
    }

    public d5(com.applovin.impl.sdk.j jVar) {
        this.f18366a = jVar;
    }

    private androidx.browser.customtabs.d a(com.applovin.impl.adview.a aVar, Activity activity) {
        this.f18366a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f18366a.J().a("CustomTabsManager", "Creating Custom Tabs intent");
        }
        com.applovin.impl.sdk.ad.b bVarI = aVar.i();
        androidx.browser.customtabs.d.b bVar = new androidx.browser.customtabs.d.b(aVar.j());
        e5 e5VarX = bVarI != null ? bVarI.x() : null;
        if (((Boolean) this.f18366a.a(sj.f23099x6)).booleanValue()) {
            bVar.k(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
            bVar.e(activity, R.anim.applovin_slide_up_animation, R.anim.applovin_slide_down_animation);
        }
        if (e5VarX != null) {
            Integer numH = e5VarX.h();
            if (numH != null) {
                bVar.d(new androidx.browser.customtabs.b.a().b(numH.intValue()).a());
            }
            Integer numA = e5VarX.a();
            if (numA != null) {
                bVar.b(2, new androidx.browser.customtabs.b.a().b(numA.intValue()).a());
            }
            Boolean boolI = e5VarX.i();
            if (boolI != null) {
                bVar.l(boolI.booleanValue());
            }
            Boolean boolG = e5VarX.g();
            if (boolG != null) {
                bVar.j(boolG.booleanValue());
            }
            Boolean boolC = e5VarX.c();
            if (boolC != null) {
                bVar.f(boolC.booleanValue());
            }
            Integer numF = e5VarX.f();
            if (numF != null) {
                bVar.i(numF.intValue());
            }
        }
        androidx.browser.customtabs.d dVarA = bVar.a();
        if (e5VarX != null) {
            String strD = e5VarX.d();
            if (strD != null) {
                dVarA.f1830a.putExtra("android.intent.extra.REFERRER", Uri.parse(strD));
            }
            Bundle bundleS = bVarI.s();
            if (!bundleS.isEmpty()) {
                dVarA.f1830a.putExtra("com.android.browser.headers", bundleS);
            }
        }
        return dVarA;
    }

    private void a(final androidx.browser.customtabs.j jVar, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null || !bVar.z0()) {
            return;
        }
        a("client warmup", new Runnable() { // from class: com.applovin.impl.zu
            @Override // java.lang.Runnable
            public final void run() {
                this.f24921a.a(bVar, jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.adview.a aVar, Activity activity, String str) {
        a(aVar, activity).a(activity, Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, androidx.browser.customtabs.j jVar) {
        this.f18367b.g(0L);
        e5 e5VarX = bVar.x();
        if (e5VarX == null) {
            return;
        }
        Integer numE = e5VarX.e();
        String strB = e5VarX.b();
        if (numE == null || TextUtils.isEmpty(strB)) {
            return;
        }
        if (jVar == null) {
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().b("CustomTabsManager", "Cannot validate session-URL relation because the session is null");
                return;
            }
            return;
        }
        this.f18366a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f18366a.J().a("CustomTabsManager", "Validating session-URL relation: " + numE + " with digital asset link: " + strB);
        }
        jVar.n(numE.intValue(), Uri.parse(strB), null);
    }

    private void a(String str, Runnable runnable) {
        try {
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().a("CustomTabsManager", "Running operation: " + str);
            }
            runnable.run();
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().a("CustomTabsManager", "Finished operation: " + str);
            }
        } catch (Throwable th2) {
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().a("CustomTabsManager", "Failed to run operation: " + str, th2);
            }
            this.f18366a.E().a("CustomTabsManager", str, th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0073 A[DONT_GENERATE] */
    private void a(LinkedList linkedList) {
        boolean zA = false;
        try {
            zA = CustomTabsClient.a(com.applovin.impl.sdk.j.l(), (String) linkedList.poll(), new a());
            if (!zA) {
                this.f18366a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f18366a.J().b("CustomTabsManager", "Custom Tabs service not available");
                }
            }
            if (zA || linkedList.isEmpty()) {
                return;
            }
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
            }
        } catch (Throwable th2) {
            try {
                this.f18366a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f18366a.J().a("CustomTabsManager", "Failed to bind to service", th2);
                }
            } finally {
                if (!zA && !linkedList.isEmpty()) {
                    this.f18366a.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f18366a.J().a("CustomTabsManager", "Retrying with next package name...");
                    }
                    a(linkedList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, androidx.browser.customtabs.j jVar) {
        this.f18366a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f18366a.J().a("CustomTabsManager", "Warming up URLs: " + list);
        }
        String str = (String) list.remove(0);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.customtabs.otherurls.URL", Uri.parse(str2));
            arrayList.add(bundle);
        }
        boolean zI = jVar.i(Uri.parse(str), null, arrayList);
        this.f18366a.J();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVarJ = this.f18366a.J();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Warmup for URLs ");
            sb2.append(zI ? "succeeded" : "failed");
            nVarJ.a("CustomTabsManager", sb2.toString());
        }
    }

    public androidx.browser.customtabs.j a(com.applovin.impl.adview.a aVar) {
        if (this.f18367b == null) {
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().a("CustomTabsManager", "Custom Tabs service is not connected, cannot start session");
            }
            return null;
        }
        this.f18366a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f18366a.J().a("CustomTabsManager", "Starting Custom Tabs session");
        }
        try {
            androidx.browser.customtabs.j jVarE = this.f18367b.e(new b(aVar));
            a(jVarE, aVar.i());
            return jVarE;
        } catch (Exception e11) {
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().a("CustomTabsManager", "Failed to create Custom Tabs session", e11);
            }
            return null;
        }
    }

    public void a() {
        if (((Boolean) this.f18366a.a(sj.f23075u6)).booleanValue() && this.f18367b == null) {
            String strD = CustomTabsClient.d(com.applovin.impl.sdk.j.l(), this.f18366a.c(sj.f23083v6), true);
            String strC = CustomTabsClient.c(com.applovin.impl.sdk.j.l(), null);
            LinkedList linkedList = new LinkedList();
            if (((Boolean) this.f18366a.a(sj.f23091w6)).booleanValue()) {
                CollectionUtils.addUniqueObjectIfExists(strC, linkedList);
                CollectionUtils.addUniqueObjectIfExists(strD, linkedList);
            } else {
                CollectionUtils.addUniqueObjectIfExists(strD, linkedList);
                CollectionUtils.addUniqueObjectIfExists(strC, linkedList);
            }
            if (!linkedList.isEmpty()) {
                a(linkedList);
                return;
            }
            this.f18366a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18366a.J().b("CustomTabsManager", "Unable to find a supported Custom Tabs package name");
            }
        }
    }

    public void a(final String str, final com.applovin.impl.adview.a aVar, final Activity activity) {
        a("launch url", new Runnable() { // from class: com.applovin.impl.av
            @Override // java.lang.Runnable
            public final void run() {
                this.f17788a.a(aVar, activity, str);
            }
        });
    }

    public void b(final List list, final androidx.browser.customtabs.j jVar) {
        if (list.isEmpty()) {
            return;
        }
        if (jVar != null) {
            a("warmup urls", new Runnable() { // from class: com.applovin.impl.bv
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18055a.a(list, jVar);
                }
            });
            return;
        }
        this.f18366a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f18366a.J().a("CustomTabsManager", "Custom Tabs session is null, cannot warmup urls");
        }
    }
}
