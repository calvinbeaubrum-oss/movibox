package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sg extends mg {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final /* synthetic */ boolean f22893p = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final aq f22894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f22895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaEvents f22896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final VastProperties f22897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f22898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f22899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f22900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f22901o;

    public sg(aq aqVar) {
        super(aqVar);
        this.f22895i = new AtomicBoolean();
        this.f22898l = new AtomicBoolean();
        this.f22899m = new AtomicBoolean();
        this.f22900n = new AtomicBoolean();
        this.f22901o = new AtomicBoolean();
        this.f22894h = aqVar;
        float fO1 = aqVar.o1();
        if (aqVar.o1() == -1) {
            this.f22897k = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        } else {
            this.f22897k = VastProperties.createVastPropertiesForSkippableMedia(fO1, true, Position.STANDALONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(float f11, boolean z11) {
        this.f22896j.start(f11, z11 ? 0.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z11) {
        this.f22896j.volumeChange(z11 ? 0.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f22896j.bufferFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f22896j.bufferStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f22896j.adUserInteraction(InteractionType.CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f22896j.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.f22896j.firstQuartile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f21162g.loaded(this.f22897k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f22896j.midpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.f22896j.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.f22896j.resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f22896j.skipped();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f22896j.thirdQuartile();
    }

    public void A() {
        b("track resumed", new Runnable() { // from class: com.applovin.impl.h50
            @Override // java.lang.Runnable
            public final void run() {
                this.f19375a.s();
            }
        });
    }

    public void B() {
        b("track skipped", new Runnable() { // from class: com.applovin.impl.j50
            @Override // java.lang.Runnable
            public final void run() {
                this.f19856a.t();
            }
        });
    }

    public void C() {
        if (this.f22901o.compareAndSet(false, true)) {
            b("track third quartile", new Runnable() { // from class: com.applovin.impl.m50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20576a.u();
                }
            });
        }
    }

    @Override // com.applovin.impl.mg
    public AdSessionConfiguration a() {
        try {
            CreativeType creativeType = CreativeType.VIDEO;
            ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
            Owner owner = Owner.NATIVE;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.a(this.f21159d, "Failed to create ad session configuration", th2);
            }
            return null;
        }
    }

    @Override // com.applovin.impl.mg
    public AdSessionContext a(WebView webView) {
        if (!f22893p && this.f22894h.g1() == null) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        for (bq bqVar : this.f22894h.g1().a()) {
            List<hq> listB = bqVar.b();
            if (listB.isEmpty()) {
                mq.a(bqVar.a(), fq.FAILED_TO_LOAD_RESOURCE, this.f21157b);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (hq hqVar : listB) {
                    if (CampaignEx.KEY_OMID.equalsIgnoreCase(hqVar.a())) {
                        arrayList2.add(hqVar);
                    }
                }
                if (arrayList2.isEmpty()) {
                    mq.a(bqVar.a(), fq.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED, this.f21157b);
                } else {
                    ArrayList<URL> arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList3.add(new URL(((hq) it.next()).b()));
                        } catch (Throwable th2) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f21158c.a(this.f21159d, "Failed to parse JavaScript resource url", th2);
                            }
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        mq.a(bqVar.a(), fq.FAILED_TO_LOAD_RESOURCE, this.f21157b);
                    } else {
                        String strD = bqVar.d();
                        String strC = bqVar.c();
                        if (!StringUtils.isValidString(strD) || StringUtils.isValidString(strC)) {
                            for (URL url : arrayList3) {
                                arrayList.add(StringUtils.isValidString(strD) ? VerificationScriptResource.createVerificationScriptResourceWithParameters(strC, url, strD) : VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                            }
                        } else {
                            mq.a(bqVar.a(), fq.FAILED_TO_LOAD_RESOURCE, this.f21157b);
                        }
                    }
                }
            }
        }
        String strA = this.f21157b.W().a();
        if (TextUtils.isEmpty(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.b(this.f21159d, "JavaScript SDK content not loaded successfully");
            }
            return null;
        }
        try {
            return AdSessionContext.createNativeAdSessionContext(this.f21157b.W().b(), strA, arrayList, this.f22894h.getOpenMeasurementContentUrl(), this.f22894h.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th3) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f21158c.a(this.f21159d, "Failed to create ad session context", th3);
            return null;
        }
    }

    @Override // com.applovin.impl.mg
    public void a(AdSession adSession) {
        try {
            this.f22896j = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.a(this.f21159d, "Failed to create media events", th2);
            }
        }
    }

    public void b(final float f11, final boolean z11) {
        if (this.f22898l.compareAndSet(false, true)) {
            b("track started", new Runnable() { // from class: com.applovin.impl.k50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20117a.a(f11, z11);
                }
            });
        }
    }

    public void b(final boolean z11) {
        b("track volume changed", new Runnable() { // from class: com.applovin.impl.f50
            @Override // java.lang.Runnable
            public final void run() {
                this.f18866a.a(z11);
            }
        });
    }

    @Override // com.applovin.impl.mg
    public void h() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.g50
            @Override // java.lang.Runnable
            public final void run() {
                this.f19161a.p();
            }
        });
    }

    public void i() {
        if (this.f22895i.compareAndSet(true, false)) {
            b("buffer finished", new Runnable() { // from class: com.applovin.impl.n50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21287a.k();
                }
            });
        }
    }

    public void j() {
        if (this.f22895i.compareAndSet(false, true)) {
            b("buffer started", new Runnable() { // from class: com.applovin.impl.i50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19628a.l();
                }
            });
        }
    }

    public void v() {
        b("track clicked", new Runnable() { // from class: com.applovin.impl.l50
            @Override // java.lang.Runnable
            public final void run() {
                this.f20357a.m();
            }
        });
    }

    public void w() {
        b("track completed", new Runnable() { // from class: com.applovin.impl.e50
            @Override // java.lang.Runnable
            public final void run() {
                this.f18561a.n();
            }
        });
    }

    public void x() {
        if (this.f22899m.compareAndSet(false, true)) {
            b("track first quartile", new Runnable() { // from class: com.applovin.impl.d50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18371a.o();
                }
            });
        }
    }

    public void y() {
        if (this.f22900n.compareAndSet(false, true)) {
            b("track midpoint", new Runnable() { // from class: com.applovin.impl.c50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18094a.q();
                }
            });
        }
    }

    public void z() {
        b("track paused", new Runnable() { // from class: com.applovin.impl.o50
            @Override // java.lang.Runnable
            public final void run() {
                this.f21463a.r();
            }
        });
    }
}
