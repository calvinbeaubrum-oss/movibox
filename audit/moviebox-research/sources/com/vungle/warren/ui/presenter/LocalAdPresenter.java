package com.vungle.warren.ui.presenter;

import a10.f;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.material.timepicker.TimeModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.j;
import com.vungle.warren.model.m;
import com.vungle.warren.model.o;
import com.vungle.warren.model.p;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.view.h;
import com.vungle.warren.utility.r;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LocalAdPresenter implements b10.c, h.b {
    public a10.b B;

    @Nullable
    public final String[] C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f62370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s00.a f62371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f62372c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.vungle.warren.utility.b.a f62374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public m f62375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.vungle.warren.model.c f62376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f62377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Repository f62378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public File f62379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f62380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f62381l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f62382m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b10.d f62383n;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b10.b.a f62388s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f62389t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f62390u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f62393x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f62394y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, j> f62373d = new HashMap();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f62384o = "Are you sure?";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f62385p = "If you exit now, you will not get your reward";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f62386q = "Continue";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f62387r = "Close";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AtomicBoolean f62391v = new AtomicBoolean(false);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AtomicBoolean f62392w = new AtomicBoolean(false);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinkedList<com.vungle.warren.model.c.a> f62395z = new LinkedList<>();
    public Repository.y A = new a();
    public AtomicBoolean D = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public class a implements Repository.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f62396a = false;

        public a() {
        }

        @Override // com.vungle.warren.persistence.Repository.y
        public void a(Exception exc) {
            if (this.f62396a) {
                return;
            }
            this.f62396a = true;
            LocalAdPresenter.this.L(26);
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#onError", new VungleException(26).getLocalizedMessage());
            LocalAdPresenter.this.F();
        }

        @Override // com.vungle.warren.persistence.Repository.y
        public void b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.vungle.warren.utility.b.InterfaceC0638b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f62398a;

        public b(File file) {
            this.f62398a = file;
        }

        @Override // com.vungle.warren.utility.b.InterfaceC0638b
        public void a(boolean z11) {
            if (z11) {
                LocalAdPresenter.this.f62383n.showWebsite("file://" + this.f62398a.getPath());
                LocalAdPresenter.this.f62371b.b(LocalAdPresenter.this.f62376g.G("postroll_view"));
                LocalAdPresenter.this.f62382m = true;
                return;
            }
            LocalAdPresenter.this.L(27);
            LocalAdPresenter.this.L(10);
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#playPost", "Error Rendering Postroll");
            LocalAdPresenter.this.F();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f62400a;

        public c(j jVar) {
            this.f62400a = jVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            String str;
            if (i11 == -2) {
                str = "opted_out";
            } else {
                str = i11 == -1 ? "opted_in" : "opted_out_by_timeout";
            }
            this.f62400a.e("consent_status", str);
            this.f62400a.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
            this.f62400a.e("consent_source", "vungle_modal");
            LocalAdPresenter.this.f62378i.i0(this.f62400a, null);
            LocalAdPresenter.this.start();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            if (i11 == -2) {
                LocalAdPresenter.this.P("video_close", null);
                LocalAdPresenter.this.G();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements PresenterAdOpenCallback {
        public e() {
        }

        @Override // com.vungle.warren.ui.PresenterAdOpenCallback
        public void a(PresenterAdOpenCallback.AdOpenType adOpenType) {
            if (adOpenType == PresenterAdOpenCallback.AdOpenType.DEEP_LINK) {
                LocalAdPresenter.this.P("deeplinkSuccess", null);
            }
        }
    }

    public LocalAdPresenter(@NonNull com.vungle.warren.model.c cVar, @NonNull m mVar, @NonNull Repository repository, @NonNull r rVar, @NonNull s00.a aVar, @NonNull h hVar, @Nullable c10.a aVar2, @NonNull File file, @Nullable String[] strArr) {
        this.f62376g = cVar;
        this.f62375f = mVar;
        this.f62370a = rVar;
        this.f62371b = aVar;
        this.f62372c = hVar;
        this.f62378i = repository;
        this.f62379j = file;
        this.C = strArr;
        if (cVar.p() != null) {
            this.f62395z.addAll(cVar.p());
            Collections.sort(this.f62395z);
        }
        K(aVar2);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    @Override // b10.b
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void j(@NonNull b10.d dVar, @Nullable c10.a aVar) {
        this.f62392w.set(false);
        this.f62383n = dVar;
        dVar.setPresenter(this);
        b10.b.a aVar2 = this.f62388s;
        if (aVar2 != null) {
            aVar2.a("attach", this.f62376g.q(), this.f62375f.d());
        }
        int iB = this.f62376g.d().b();
        if (iB > 0) {
            this.f62380k = (iB & 1) == 1;
            this.f62381l = (iB & 2) == 2;
        }
        int iE = this.f62376g.d().e();
        int i11 = 7;
        if (iE == 3) {
            int iY = this.f62376g.y();
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
        dVar.setOrientation(i11);
        O(aVar);
        SessionTracker.l().w(new p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, true).a(SessionAttribute.EVENT_ID, this.f62376g.v()).c());
    }

    public final void F() {
        if (this.D.get()) {
            Log.w("LocalAdPresenter", "Busy with closing");
            return;
        }
        this.D.set(true);
        P(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, null);
        this.f62370a.b();
        this.f62383n.close();
    }

    public final void G() {
        if (this.f62376g.T()) {
            N();
        } else {
            F();
        }
    }

    public final void H() {
        P("cta", "");
        try {
            this.f62371b.b(this.f62376g.G("postroll_click"));
            this.f62371b.b(this.f62376g.G(CampaignEx.JSON_KEY_CLICK_URL));
            this.f62371b.b(this.f62376g.G(CampaignEx.JSON_NATIVE_VIDEO_VIDEO_CLICK));
            this.f62371b.b(new String[]{this.f62376g.m(true)});
            P(DownloadBaseRunnable.TAG, null);
            String strM = this.f62376g.m(false);
            if (strM == null || strM.isEmpty()) {
                Log.e("LocalAdPresenter", "CTA destination URL is not configured properly");
            } else {
                this.f62383n.open(this.f62376g.s(), strM, new f(this.f62388s, this.f62375f), new e());
            }
            b10.b.a aVar = this.f62388s;
            if (aVar != null) {
                aVar.a("open", "adClick", this.f62375f.d());
            }
        } catch (ActivityNotFoundException unused) {
            Log.e("LocalAdPresenter", "Unable to find destination activity");
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#download", "Download - Activity Not Found");
        }
    }

    public final void I(int i11) {
        b10.d dVar = this.f62383n;
        if (dVar != null) {
            dVar.removeWebView();
        }
        R(i11);
    }

    public final boolean J() {
        String websiteUrl = this.f62383n.getWebsiteUrl();
        return TextUtils.isEmpty(websiteUrl) || "about:blank".equalsIgnoreCase(websiteUrl);
    }

    public final void K(c10.a aVar) {
        this.f62373d.put("incentivizedTextSetByPub", (j) this.f62378i.T("incentivizedTextSetByPub", j.class).get());
        this.f62373d.put("consentIsImportantToVungle", (j) this.f62378i.T("consentIsImportantToVungle", j.class).get());
        this.f62373d.put("configSettings", (j) this.f62378i.T("configSettings", j.class).get());
        if (aVar != null) {
            String string = aVar.getString("saved_report");
            o oVar = TextUtils.isEmpty(string) ? null : (o) this.f62378i.T(string, o.class).get();
            if (oVar != null) {
                this.f62377h = oVar;
            }
        }
    }

    public final void L(int i11) {
        b10.b.a aVar = this.f62388s;
        if (aVar != null) {
            aVar.b(new VungleException(i11), this.f62375f.d());
        }
    }

    public final boolean M(@Nullable j jVar) {
        return jVar != null && jVar.a("is_country_data_protected").booleanValue() && AppLovinMediationProvider.UNKNOWN.equals(jVar.d("consent_status"));
    }

    public final void N() {
        File file = new File(new File(this.f62379j.getPath()).getPath() + File.separator + "index.html");
        this.f62374e = com.vungle.warren.utility.b.a(file, new b(file));
    }

    public final void O(@Nullable c10.a aVar) {
        n(aVar);
        j jVar = this.f62373d.get("incentivizedTextSetByPub");
        String strD = jVar == null ? null : jVar.d("userID");
        if (this.f62377h == null) {
            o oVar = new o(this.f62376g, this.f62375f, System.currentTimeMillis(), strD);
            this.f62377h = oVar;
            oVar.l(this.f62376g.H());
            this.f62378i.i0(this.f62377h, this.A);
        }
        if (this.B == null) {
            this.B = new a10.b(this.f62377h, this.f62378i, this.A);
        }
        this.f62372c.b(this);
        this.f62383n.g(this.f62376g.V(), this.f62376g.r());
        b10.b.a aVar2 = this.f62388s;
        if (aVar2 != null) {
            aVar2.a("start", null, this.f62375f.d());
        }
    }

    public void P(@NonNull String str, @Nullable String str2) {
        if (str.equals("videoLength")) {
            int i11 = Integer.parseInt(str2);
            this.f62389t = i11;
            this.f62377h.m(i11);
            this.f62378i.i0(this.f62377h, this.A);
            return;
        }
        switch (str) {
            case "unmute":
            case "mute":
            case "video_close":
                this.f62371b.b(this.f62376g.G(str));
                break;
        }
        this.f62377h.f(str, str2, System.currentTimeMillis());
        this.f62378i.i0(this.f62377h, this.A);
    }

    public final void Q(@NonNull String str) {
        this.f62377h.g(str);
        this.f62378i.i0(this.f62377h, this.A);
        L(27);
        if (!this.f62382m && this.f62376g.T()) {
            N();
        } else {
            L(10);
            this.f62383n.close();
        }
    }

    public final void R(int i11) {
        L(i11);
        VungleLogger.c(LocalAdPresenter.class.getSimpleName(), "WebViewException: " + new VungleException(i11).getLocalizedMessage());
        F();
    }

    public final void S(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.f62383n.e();
        this.f62383n.showDialog(str, str2, str3, str4, onClickListener);
    }

    public final void T(@NonNull j jVar) {
        c cVar = new c(jVar);
        jVar.e("consent_status", "opted_out_by_timeout");
        jVar.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
        jVar.e("consent_source", "vungle_modal");
        this.f62378i.i0(jVar, this.A);
        S(jVar.d("consent_title"), jVar.d("consent_message"), jVar.d("button_accept"), jVar.d("button_deny"), cVar);
    }

    public final void U() {
        String strD = this.f62384o;
        String strD2 = this.f62385p;
        String strD3 = this.f62386q;
        String strD4 = this.f62387r;
        j jVar = this.f62373d.get("incentivizedTextSetByPub");
        if (jVar != null) {
            strD = jVar.d(CampaignEx.JSON_KEY_TITLE);
            if (TextUtils.isEmpty(strD)) {
                strD = this.f62384o;
            }
            strD2 = jVar.d(TtmlNode.TAG_BODY);
            if (TextUtils.isEmpty(strD2)) {
                strD2 = this.f62385p;
            }
            strD3 = jVar.d("continue");
            if (TextUtils.isEmpty(strD3)) {
                strD3 = this.f62386q;
            }
            strD4 = jVar.d(CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
            if (TextUtils.isEmpty(strD4)) {
                strD4 = this.f62387r;
            }
        }
        S(strD, strD2, strD3, strD4, new d());
    }

    @Override // b10.c
    public void b() {
        H();
    }

    @Override // b10.c
    public void c(int i11, float f11) {
        this.f62394y = (int) ((i11 / f11) * 100.0f);
        this.f62393x = i11;
        this.B.d();
        b10.b.a aVar = this.f62388s;
        if (aVar != null) {
            aVar.a("percentViewed:" + this.f62394y, null, this.f62375f.d());
        }
        b10.b.a aVar2 = this.f62388s;
        if (aVar2 != null && i11 > 0 && !this.f62390u) {
            this.f62390u = true;
            aVar2.a("adViewed", null, this.f62375f.d());
            String[] strArr = this.C;
            if (strArr != null) {
                this.f62371b.b(strArr);
            }
        }
        P("video_viewed", String.format(Locale.ENGLISH, TimeModel.NUMBER_FORMAT, Integer.valueOf(i11)));
        if (this.f62394y == 100) {
            if (this.f62395z.peekLast() != null && this.f62395z.peekLast().b() == 100) {
                this.f62371b.b(this.f62395z.pollLast().c());
            }
            G();
        }
        this.f62377h.h(this.f62393x);
        this.f62378i.i0(this.f62377h, this.A);
        while (this.f62395z.peek() != null && this.f62394y > this.f62395z.peek().b()) {
            this.f62371b.b(this.f62395z.poll().c());
        }
        j jVar = this.f62373d.get("configSettings");
        if (!this.f62375f.k() || this.f62394y <= 75 || jVar == null || !jVar.a("isReportIncentivizedEnabled").booleanValue() || this.f62391v.getAndSet(true)) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("placement_reference_id", new JsonPrimitive(this.f62375f.d()));
        jsonObject.add("app_id", new JsonPrimitive(this.f62376g.j()));
        jsonObject.add("adStartTime", new JsonPrimitive(Long.valueOf(this.f62377h.b())));
        jsonObject.add("user", new JsonPrimitive(this.f62377h.d()));
        this.f62371b.c(jsonObject);
    }

    @Override // b10.c
    public void d() {
        this.f62383n.open(null, "https://vungle.com/privacy/", new f(this.f62388s, this.f62375f), null);
    }

    @Override // com.vungle.warren.ui.view.h.b
    public void g(String str, boolean z11) {
        o oVar = this.f62377h;
        if (oVar != null) {
            oVar.g(str);
            this.f62378i.i0(this.f62377h, this.A);
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "onReceivedError", str);
        }
    }

    @Override // b10.c
    public void h(int i11, float f11) {
        P("videoLength", String.format(Locale.ENGLISH, TimeModel.NUMBER_FORMAT, Integer.valueOf((int) f11)));
    }

    @Override // com.vungle.warren.ui.view.h.b
    public boolean i(WebView webView, boolean z11) {
        I(31);
        VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#onWebRenderingProcessGone", new VungleException(31).getLocalizedMessage());
        return true;
    }

    @Override // b10.b
    public boolean k() {
        if (this.f62382m) {
            F();
            return true;
        }
        if (!this.f62381l) {
            return false;
        }
        if (this.f62375f.k() && this.f62394y <= 75) {
            U();
            return false;
        }
        P("video_close", null);
        if (this.f62376g.T()) {
            N();
            return false;
        }
        F();
        return true;
    }

    @Override // b10.b
    public void l() {
        this.f62372c.c(true);
        this.f62383n.refreshDialogIfVisible();
    }

    @Override // b10.b
    public void m(int i11) {
        this.B.c();
        boolean z11 = (i11 & 1) != 0;
        boolean z12 = (i11 & 2) != 0;
        this.f62383n.pauseWeb();
        if (this.f62383n.d()) {
            this.f62393x = this.f62383n.c();
            this.f62383n.e();
        }
        if (z11 || !z12) {
            if (this.f62382m || z12) {
                this.f62383n.showWebsite("about:blank");
                return;
            }
            return;
        }
        if (this.f62392w.getAndSet(true)) {
            return;
        }
        P(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, null);
        this.f62370a.b();
        b10.b.a aVar = this.f62388s;
        if (aVar != null) {
            aVar.a(TtmlNode.END, this.f62377h.e() ? "isCTAClicked" : null, this.f62375f.d());
        }
    }

    @Override // b10.b
    public void n(@Nullable c10.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.getBoolean("incentivized_sent", false)) {
            this.f62391v.set(true);
        }
        this.f62382m = aVar.getBoolean("in_post_roll", this.f62382m);
        this.f62380k = aVar.getBoolean("is_muted_mode", this.f62380k);
        this.f62393x = aVar.getInt("videoPosition", this.f62393x).intValue();
    }

    @Override // b10.b
    public void o(@Nullable b10.b.a aVar) {
        this.f62388s = aVar;
    }

    @Override // b10.b
    public void p(@Nullable c10.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f62378i.i0(this.f62377h, this.A);
        o oVar = this.f62377h;
        aVar.put("saved_report", oVar == null ? null : oVar.c());
        aVar.put("incentivized_sent", this.f62391v.get());
        aVar.put("in_post_roll", this.f62382m);
        aVar.put("is_muted_mode", this.f62380k);
        b10.d dVar = this.f62383n;
        aVar.put("videoPosition", (dVar == null || !dVar.d()) ? this.f62393x : this.f62383n.c());
    }

    @Override // b10.c
    public boolean q(@NonNull String str) {
        Q(str);
        VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#onMediaError", "Media Error: " + str);
        return false;
    }

    @Override // b10.c
    public void r(boolean z11) {
        this.f62380k = z11;
        if (z11) {
            P(CampaignEx.JSON_NATIVE_VIDEO_MUTE, "true");
        } else {
            P(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, "false");
        }
    }

    @Override // b10.b
    public void s(int i11) {
        com.vungle.warren.utility.b.a aVar = this.f62374e;
        if (aVar != null) {
            aVar.a();
        }
        m(i11);
        this.f62383n.destroyAdView(0L);
    }

    @Override // b10.b
    public void start() {
        this.B.b();
        if (!this.f62383n.hasWebView()) {
            R(31);
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#start", new VungleException(31).getLocalizedMessage());
            return;
        }
        this.f62383n.setImmersiveMode();
        this.f62383n.resumeWeb();
        j jVar = this.f62373d.get("consentIsImportantToVungle");
        if (M(jVar)) {
            T(jVar);
            return;
        }
        if (this.f62382m) {
            if (J()) {
                N();
                return;
            }
            return;
        }
        if (this.f62383n.d() || this.f62383n.b()) {
            return;
        }
        this.f62383n.f(new File(this.f62379j.getPath() + File.separator + "video"), this.f62380k, this.f62393x);
        int iC = this.f62376g.C(this.f62375f.k());
        if (iC > 0) {
            this.f62370a.a(new Runnable() { // from class: com.vungle.warren.ui.presenter.LocalAdPresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    LocalAdPresenter.this.f62381l = true;
                    if (LocalAdPresenter.this.f62382m) {
                        return;
                    }
                    LocalAdPresenter.this.f62383n.showCloseButton();
                }
            }, iC);
        } else {
            this.f62381l = true;
            this.f62383n.showCloseButton();
        }
    }

    @Override // com.vungle.warren.ui.view.h.b
    public void t(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        I(32);
        VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#onRenderProcessUnresponsive", new VungleException(32).getLocalizedMessage());
    }

    @Override // a10.d.a
    public void u(@NonNull String str) {
        str.hashCode();
        switch (str) {
            case "privacy":
                return;
            case "close":
                F();
                return;
            case "download":
                H();
                F();
                return;
            default:
                VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#onMraidAction", "Unknown MRAID Command");
                throw new IllegalArgumentException("Unknown action " + str);
        }
    }
}
