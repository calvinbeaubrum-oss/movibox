package com.iab.omid.library.bytedance2.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.bytedance2.internal.c;
import com.iab.omid.library.bytedance2.internal.e;
import com.iab.omid.library.bytedance2.internal.f;
import com.iab.omid.library.bytedance2.internal.i;
import com.iab.omid.library.bytedance2.publisher.AdSessionStatePublisher;
import com.iab.omid.library.bytedance2.publisher.b;
import com.iab.omid.library.bytedance2.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f42215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f42216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f42217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.weakreference.a f42218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f42219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f42220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f42221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f42222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f42223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f42224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f42225k;

    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f42217c = new f();
        this.f42220f = false;
        this.f42221g = false;
        this.f42216b = adSessionConfiguration;
        this.f42215a = adSessionContext;
        this.f42222h = str;
        b(null);
        this.f42219e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.bytedance2.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f42219e.i();
        c.c().a(this);
        this.f42219e.a(adSessionConfiguration);
    }

    private void a() {
        if (this.f42223i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void a(View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.c() == view) {
                aVar.f42218d.clear();
            }
        }
    }

    private void b() {
        if (this.f42224j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void b(View view) {
        this.f42218d = new com.iab.omid.library.bytedance2.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.bytedance2.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.bytedance2.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f42225k.onPossibleObstructionsDetected(this.f42222h, arrayList);
        }
    }

    public void a(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f42224j = true;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f42221g) {
            return;
        }
        this.f42217c.a(view, friendlyObstructionPurpose, str);
    }

    public View c() {
        return this.f42218d.get();
    }

    public List<e> d() {
        return this.f42217c.a();
    }

    public boolean e() {
        return this.f42225k != null;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f42221g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f42220f && !this.f42221g;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void finish() {
        if (this.f42221g) {
            return;
        }
        this.f42218d.clear();
        removeAllFriendlyObstructions();
        this.f42221g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f42219e = null;
        this.f42225k = null;
    }

    public boolean g() {
        return this.f42221g;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public String getAdSessionId() {
        return this.f42222h;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f42219e;
    }

    public boolean h() {
        return this.f42216b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f42216b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f42220f;
    }

    public void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f42223i = true;
    }

    public void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f42224j = true;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void registerAdView(View view) {
        if (this.f42221g) {
            return;
        }
        g.a(view, "AdView is null");
        if (c() == view) {
            return;
        }
        b(view);
        getAdSessionStatePublisher().a();
        a(view);
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f42221g) {
            return;
        }
        this.f42217c.b();
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f42221g) {
            return;
        }
        this.f42217c.c(view);
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f42225k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.bytedance2.adsession.AdSession
    public void start() {
        if (this.f42220f) {
            return;
        }
        this.f42220f = true;
        c.c().c(this);
        this.f42219e.a(i.c().b());
        this.f42219e.a(com.iab.omid.library.bytedance2.internal.a.a().b());
        this.f42219e.a(this, this.f42215a);
    }
}
