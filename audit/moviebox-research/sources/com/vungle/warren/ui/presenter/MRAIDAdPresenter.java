package com.vungle.warren.ui.presenter;

import a10.f;
import android.content.ActivityNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b10.g;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.i;
import com.vungle.warren.model.j;
import com.vungle.warren.model.l;
import com.vungle.warren.model.m;
import com.vungle.warren.model.o;
import com.vungle.warren.model.p;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.view.h;
import com.vungle.warren.utility.r;
import com.vungle.warren.utility.t;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class MRAIDAdPresenter implements g, h.a, h.b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f62404w = "com.vungle.warren.ui.presenter.MRAIDAdPresenter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f62405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s00.a f62406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.vungle.warren.omsdk.a f62407c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.vungle.warren.utility.b.a f62409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f62410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b10.b.a f62411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.vungle.warren.model.c f62412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f62413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final m f62414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f62415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Repository f62416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public File f62417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b10.h f62418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f62419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f62420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f62421q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a10.b f62425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public final String[] f62426v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, j> f62408d = new HashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AtomicBoolean f62422r = new AtomicBoolean(false);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AtomicBoolean f62423s = new AtomicBoolean(false);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Repository.y f62424t = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Repository.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f62427a = false;

        public a() {
        }

        @Override // com.vungle.warren.persistence.Repository.y
        public void a(Exception exc) {
            if (this.f62427a) {
                return;
            }
            this.f62427a = true;
            VungleException vungleException = new VungleException(26);
            MRAIDAdPresenter.this.I(vungleException);
            VungleLogger.c(MRAIDAdPresenter.class.getSimpleName(), vungleException.getLocalizedMessage());
            MRAIDAdPresenter.this.D();
        }

        @Override // com.vungle.warren.persistence.Repository.y
        public void b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.vungle.warren.utility.b.InterfaceC0638b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f62429a;

        public b(File file) {
            this.f62429a = file;
        }

        @Override // com.vungle.warren.utility.b.InterfaceC0638b
        public void a(boolean z11) {
            if (!z11) {
                MRAIDAdPresenter.this.I(new VungleException(27));
                MRAIDAdPresenter.this.I(new VungleException(10));
                MRAIDAdPresenter.this.f62418n.close();
            } else {
                MRAIDAdPresenter.this.f62418n.showWebsite("file://" + this.f62429a.getPath());
                MRAIDAdPresenter.this.L();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements PresenterAdOpenCallback {
        public c() {
        }

        @Override // com.vungle.warren.ui.PresenterAdOpenCallback
        public void a(PresenterAdOpenCallback.AdOpenType adOpenType) {
            if (adOpenType == PresenterAdOpenCallback.AdOpenType.DEEP_LINK) {
                MRAIDAdPresenter.this.M("deeplinkSuccess", null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements PresenterAdOpenCallback {
        public d() {
        }

        @Override // com.vungle.warren.ui.PresenterAdOpenCallback
        public void a(PresenterAdOpenCallback.AdOpenType adOpenType) {
            if (adOpenType == PresenterAdOpenCallback.AdOpenType.DEEP_LINK) {
                MRAIDAdPresenter.this.M("deeplinkSuccess", null);
            }
        }
    }

    public MRAIDAdPresenter(@NonNull com.vungle.warren.model.c cVar, @NonNull m mVar, @NonNull Repository repository, @NonNull r rVar, @NonNull s00.a aVar, @NonNull h hVar, @Nullable c10.a aVar2, @NonNull File file, @NonNull com.vungle.warren.omsdk.a aVar3, @Nullable String[] strArr) {
        this.f62412h = cVar;
        this.f62416l = repository;
        this.f62414j = mVar;
        this.f62405a = rVar;
        this.f62406b = aVar;
        this.f62415k = hVar;
        this.f62417m = file;
        this.f62407c = aVar3;
        this.f62426v = strArr;
        G(aVar2);
        if (cVar.U()) {
            this.f62410f = new i(cVar, aVar);
        }
    }

    private void E() {
        M("cta", "");
        try {
            this.f62406b.b(new String[]{this.f62412h.m(true)});
            this.f62418n.open(this.f62412h.s(), this.f62412h.m(false), new f(this.f62411g, this.f62414j), new d());
        } catch (ActivityNotFoundException unused) {
            VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#download", "Download - Activity Not Found");
        }
    }

    private void G(c10.a aVar) {
        this.f62408d.put("incentivizedTextSetByPub", (j) this.f62416l.T("incentivizedTextSetByPub", j.class).get());
        this.f62408d.put("consentIsImportantToVungle", (j) this.f62416l.T("consentIsImportantToVungle", j.class).get());
        this.f62408d.put("configSettings", (j) this.f62416l.T("configSettings", j.class).get());
        if (aVar != null) {
            String string = aVar.getString("saved_report");
            o oVar = TextUtils.isEmpty(string) ? null : (o) this.f62416l.T(string, o.class).get();
            if (oVar != null) {
                this.f62413i = oVar;
            }
        }
    }

    private void J(@Nullable c10.a aVar) {
        this.f62415k.d(this);
        this.f62415k.b(this);
        H(new File(this.f62417m.getPath() + File.separator + "template"));
        j jVar = this.f62408d.get("incentivizedTextSetByPub");
        if (jVar != null) {
            this.f62412h.c0(jVar.d(CampaignEx.JSON_KEY_TITLE), jVar.d(TtmlNode.TAG_BODY), jVar.d("continue"), jVar.d(CampaignEx.JSON_NATIVE_VIDEO_CLOSE));
        }
        String strD = jVar == null ? null : jVar.d("userID");
        boolean z11 = false;
        if (this.f62413i == null) {
            o oVar = new o(this.f62412h, this.f62414j, System.currentTimeMillis(), strD);
            this.f62413i = oVar;
            oVar.l(this.f62412h.H());
            this.f62416l.j0(this.f62413i, this.f62424t, false);
        }
        if (this.f62425u == null) {
            this.f62425u = new a10.b(this.f62413i, this.f62416l, this.f62424t);
        }
        j jVar2 = this.f62408d.get("consentIsImportantToVungle");
        if (jVar2 != null) {
            if (jVar2.a("is_country_data_protected").booleanValue() && AppLovinMediationProvider.UNKNOWN.equals(jVar2.d("consent_status"))) {
                z11 = true;
            }
            this.f62415k.f(z11, jVar2.d("consent_title"), jVar2.d("consent_message"), jVar2.d("button_accept"), jVar2.d("button_deny"));
            if (z11) {
                jVar2.e("consent_status", "opted_out_by_timeout");
                jVar2.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
                jVar2.e("consent_source", "vungle_modal");
                this.f62416l.i0(jVar2, this.f62424t);
            }
        }
        int iC = this.f62412h.C(this.f62414j.k());
        if (iC > 0) {
            this.f62405a.a(new Runnable() { // from class: com.vungle.warren.ui.presenter.MRAIDAdPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    MRAIDAdPresenter.this.f62419o = true;
                }
            }, iC);
        } else {
            this.f62419o = true;
        }
        this.f62418n.updateWindow();
        b10.b.a aVar2 = this.f62411g;
        if (aVar2 != null) {
            aVar2.a("start", null, this.f62414j.d());
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059  */
    @Override // b10.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void j(@NonNull b10.h hVar, @Nullable c10.a aVar) {
        this.f62423s.set(false);
        this.f62418n = hVar;
        hVar.setPresenter(this);
        b10.b.a aVar2 = this.f62411g;
        if (aVar2 != null) {
            aVar2.a("attach", this.f62412h.q(), this.f62414j.d());
        }
        this.f62407c.b();
        int iB = this.f62412h.d().b();
        if (iB > 0) {
            this.f62419o = (iB & 2) == 2;
        }
        int iE = this.f62412h.d().e();
        int i11 = 7;
        if (iE == 3) {
            int iY = this.f62412h.y();
            if (iY != 0) {
                if (iY != 1) {
                    i11 = -1;
                } else {
                    i11 = 6;
                }
            }
        } else if (iE != 0) {
            if (iE == 1) {
                i11 = 6;
            } else {
                i11 = 4;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Requested Orientation ");
        sb2.append(i11);
        hVar.setOrientation(i11);
        J(aVar);
        SessionTracker.l().w(new p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, true).a(SessionAttribute.EVENT_ID, this.f62412h.v()).c());
    }

    public final void D() {
        this.f62418n.close();
        this.f62405a.b();
    }

    public final void F(@NonNull VungleException vungleException) {
        b10.h hVar = this.f62418n;
        if (hVar != null) {
            hVar.removeWebView();
        }
        VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#handleWebViewException", "WebViewException: " + vungleException.getLocalizedMessage());
        N(vungleException);
    }

    public final void H(@NonNull File file) {
        File file2 = new File(new File(file.getParent()).getPath() + File.separator + "index.html");
        this.f62409e = com.vungle.warren.utility.b.a(file2, new b(file2));
    }

    public final void I(@NonNull VungleException vungleException) {
        b10.b.a aVar = this.f62411g;
        if (aVar != null) {
            aVar.b(vungleException, this.f62414j.d());
        }
    }

    public final void K(String str) {
        if (this.f62413i == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f62413i.g(str);
        this.f62416l.i0(this.f62413i, this.f62424t);
    }

    public final void L() {
        o oVar;
        com.vungle.warren.model.c cVar = (com.vungle.warren.model.c) this.f62416l.T(this.f62412h.v(), com.vungle.warren.model.c.class).get();
        if (cVar == null || (oVar = this.f62413i) == null) {
            return;
        }
        oVar.j(cVar.W);
        this.f62416l.j0(this.f62413i, this.f62424t, false);
    }

    public void M(@NonNull String str, @Nullable String str2) {
        if (!str.equals("videoLength")) {
            this.f62413i.f(str, str2, System.currentTimeMillis());
            this.f62416l.i0(this.f62413i, this.f62424t);
        } else {
            long j11 = Long.parseLong(str2);
            this.f62420p = j11;
            this.f62413i.m(j11);
            this.f62416l.i0(this.f62413i, this.f62424t);
        }
    }

    public final void N(@NonNull VungleException vungleException) {
        I(vungleException);
        D();
    }

    @Override // b10.g
    public void a(boolean z11) {
        this.f62415k.a(z11);
        if (z11) {
            this.f62425u.b();
        } else {
            this.f62425u.c();
        }
    }

    @Override // b10.g
    public void e(MotionEvent motionEvent) {
        i iVar = this.f62410f;
        if (iVar != null) {
            iVar.f(motionEvent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0022  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:98:0x01cb  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.vungle.warren.ui.view.h.a
    public boolean f(@NonNull String str, @NonNull JsonObject jsonObject) {
        byte b11;
        float f11;
        Handler handler = new Handler(Looper.getMainLooper());
        str.hashCode();
        switch (str.hashCode()) {
            case -1912374177:
                if (!str.equals("successfulView")) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case -1422950858:
                if (!str.equals("action")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case -735200587:
                if (!str.equals("actionWithValue")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case -660787472:
                if (!str.equals("consentAction")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case -511324706:
                if (!str.equals("openPrivacy")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case -418575596:
                if (!str.equals("openNonMraid")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case -348095344:
                if (!str.equals("useCustomPrivacy")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case 3417674:
                if (!str.equals("open")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case 3566511:
                if (!str.equals("tpat")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case 94756344:
                if (!str.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case 96784904:
                if (!str.equals("error")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case 133423073:
                if (!str.equals("setOrientationProperties")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case 1614272768:
                if (!str.equals("useCustomClose")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                b10.b.a aVar = this.f62411g;
                if (aVar != null) {
                    aVar.a("successfulView", null, this.f62414j.d());
                }
                j jVar = this.f62408d.get("configSettings");
                if (this.f62414j.k() && jVar != null && jVar.a("isReportIncentivizedEnabled").booleanValue() && !this.f62422r.getAndSet(true)) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.add("placement_reference_id", new JsonPrimitive(this.f62414j.d()));
                    jsonObject2.add("app_id", new JsonPrimitive(this.f62412h.j()));
                    jsonObject2.add("adStartTime", new JsonPrimitive(Long.valueOf(this.f62413i.b())));
                    jsonObject2.add("user", new JsonPrimitive(this.f62413i.d()));
                    this.f62406b.c(jsonObject2);
                }
                return true;
            case 2:
                String asString = jsonObject.get(NotificationCompat.CATEGORY_EVENT).getAsString();
                String asString2 = jsonObject.get(AppMeasurementSdk.ConditionalUserProperty.VALUE).getAsString();
                this.f62413i.f(asString, asString2, System.currentTimeMillis());
                this.f62416l.i0(this.f62413i, this.f62424t);
                if (asString.equals("videoViewed")) {
                    try {
                        f11 = Float.parseFloat(asString2);
                    } catch (NumberFormatException unused) {
                        Log.e(f62404w, "value for videoViewed is null !");
                        f11 = 0.0f;
                    }
                    b10.b.a aVar2 = this.f62411g;
                    if (aVar2 != null && f11 > 0.0f && !this.f62421q) {
                        this.f62421q = true;
                        aVar2.a("adViewed", null, this.f62414j.d());
                        String[] strArr = this.f62426v;
                        if (strArr != null) {
                            this.f62406b.b(strArr);
                        }
                    }
                    if (this.f62420p > 0) {
                        this.f62425u.d();
                    }
                    break;
                }
                if (asString.equals("videoLength")) {
                    this.f62420p = Long.parseLong(asString2);
                    M("videoLength", asString2);
                    handler.post(new Runnable() { // from class: com.vungle.warren.ui.presenter.MRAIDAdPresenter.4
                        @Override // java.lang.Runnable
                        public void run() {
                            MRAIDAdPresenter.this.f62415k.c(true);
                        }
                    });
                }
                handler.post(new Runnable() { // from class: com.vungle.warren.ui.presenter.MRAIDAdPresenter.5
                    @Override // java.lang.Runnable
                    public void run() {
                        MRAIDAdPresenter.this.f62418n.setVisibility(true);
                    }
                });
            case 1:
                return true;
            case 3:
                j jVar2 = this.f62408d.get("consentIsImportantToVungle");
                if (jVar2 == null) {
                    jVar2 = new j("consentIsImportantToVungle");
                }
                jVar2.e("consent_status", jsonObject.get(NotificationCompat.CATEGORY_EVENT).getAsString());
                jVar2.e("consent_source", "vungle_modal");
                jVar2.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
                this.f62416l.i0(jVar2, this.f62424t);
                return true;
            case 4:
                this.f62418n.open(null, jsonObject.get("url").getAsString(), new f(this.f62411g, this.f62414j), null);
                return true;
            case 5:
            case 7:
                M(DownloadBaseRunnable.TAG, null);
                if ("open".equalsIgnoreCase(str)) {
                    M("mraidOpen", null);
                } else {
                    M("nonMraidOpen", null);
                }
                String strS = this.f62412h.s();
                String asString3 = jsonObject.get("url").getAsString();
                if ((strS == null || strS.isEmpty()) && (asString3 == null || asString3.isEmpty())) {
                    Log.e(f62404w, "CTA destination URL is not configured properly");
                } else {
                    this.f62418n.open(strS, asString3, new f(this.f62411g, this.f62414j), new c());
                }
                b10.b.a aVar3 = this.f62411g;
                if (aVar3 != null) {
                    aVar3.a("open", "adClick", this.f62414j.d());
                }
                return true;
            case 6:
                String asString4 = jsonObject.get("useCustomPrivacy").getAsString();
                asString4.hashCode();
                switch (asString4) {
                    case "gone":
                    case "true":
                    case "false":
                        return true;
                    default:
                        throw new IllegalArgumentException("Unknown value " + asString4);
                }
            case 8:
                this.f62406b.b(this.f62412h.G(jsonObject.get(NotificationCompat.CATEGORY_EVENT).getAsString()));
                return true;
            case 9:
                M("mraidClose", null);
                D();
                return true;
            case 10:
                String strD = l.d(jsonObject, TrackingKey.CODE, null);
                final String str2 = String.format("%s Creative Id: %s", strD, this.f62412h.q());
                Log.e(f62404w, "Receive Creative error: " + str2);
                K(strD);
                t.b(new Runnable() { // from class: com.vungle.warren.ui.presenter.MRAIDAdPresenter.7
                    @Override // java.lang.Runnable
                    public void run() {
                        MRAIDAdPresenter.this.F(new VungleException(40, str2));
                    }
                });
                return true;
            case 11:
                String strD2 = l.d(jsonObject, "forceOrientation", null);
                if (!TextUtils.isEmpty(strD2)) {
                    String lowerCase = strD2.toLowerCase();
                    lowerCase.hashCode();
                    if (lowerCase.equals("portrait")) {
                        this.f62418n.setOrientation(7);
                    } else if (lowerCase.equals("landscape")) {
                        this.f62418n.setOrientation(6);
                    }
                }
                return true;
            case 12:
                String asString5 = jsonObject.get("sdkCloseButton").getAsString();
                asString5.hashCode();
                switch (asString5) {
                    case "invisible":
                    case "gone":
                    case "visible":
                        return true;
                    default:
                        throw new IllegalArgumentException("Unknown value " + asString5);
                }
            default:
                VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#processCommand", "Unknown MRAID Command");
                return true;
        }
    }

    @Override // com.vungle.warren.ui.view.h.b
    public void g(String str, boolean z11) {
        K(str);
        VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#onReceivedError", str);
        if (z11) {
            N(new VungleException(38));
        }
    }

    @Override // com.vungle.warren.ui.view.h.b
    public boolean i(WebView webView, boolean z11) {
        F(new VungleException(31));
        VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    @Override // b10.b
    public boolean k() {
        if (!this.f62419o) {
            return false;
        }
        this.f62418n.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        return false;
    }

    @Override // b10.b
    public void l() {
        this.f62418n.updateWindow();
        this.f62415k.c(true);
    }

    @Override // b10.b
    public void m(int i11) {
        boolean z11 = (i11 & 1) != 0;
        boolean z12 = (i11 & 2) != 0;
        boolean z13 = (i11 & 4) != 0;
        this.f62418n.pauseWeb();
        a(false);
        if (z11 || !z12 || this.f62423s.getAndSet(true)) {
            return;
        }
        h hVar = this.f62415k;
        if (hVar != null) {
            hVar.d(null);
        }
        if (z13) {
            M("mraidCloseByApi", null);
        }
        this.f62416l.i0(this.f62413i, this.f62424t);
        b10.b.a aVar = this.f62411g;
        if (aVar != null) {
            aVar.a(TtmlNode.END, this.f62413i.e() ? "isCTAClicked" : null, this.f62414j.d());
        }
    }

    @Override // b10.b
    public void n(@Nullable c10.a aVar) {
        if (aVar == null) {
            return;
        }
        boolean z11 = aVar.getBoolean("incentivized_sent", false);
        if (z11) {
            this.f62422r.set(z11);
        }
        if (this.f62413i == null) {
            this.f62418n.close();
            VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#restoreFromSave", "The advertisement was not started and cannot be restored.");
        }
    }

    @Override // b10.b
    public void o(@Nullable b10.b.a aVar) {
        this.f62411g = aVar;
    }

    @Override // b10.b
    public void p(@Nullable c10.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f62416l.i0(this.f62413i, this.f62424t);
        aVar.put("saved_report", this.f62413i.c());
        aVar.put("incentivized_sent", this.f62422r.get());
    }

    @Override // b10.b
    public void s(int i11) {
        com.vungle.warren.utility.b.a aVar = this.f62409e;
        if (aVar != null) {
            aVar.a();
        }
        m(i11);
        this.f62415k.e(null);
        this.f62418n.destroyAdView(this.f62407c.c());
    }

    @Override // b10.b
    public void start() {
        if (!this.f62418n.hasWebView()) {
            N(new VungleException(31));
            return;
        }
        this.f62418n.setImmersiveMode();
        this.f62418n.resumeWeb();
        a(true);
    }

    @Override // com.vungle.warren.ui.view.h.b
    public void t(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        VungleException vungleException = new VungleException(32);
        F(vungleException);
        VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", vungleException.getLocalizedMessage());
    }

    @Override // a10.d.a
    public void u(@NonNull String str) {
        str.hashCode();
        switch (str) {
            case "privacy":
                return;
            case "close":
                D();
                return;
            case "download":
                E();
                return;
            default:
                throw new IllegalArgumentException("Unknown action " + str);
        }
    }
}
