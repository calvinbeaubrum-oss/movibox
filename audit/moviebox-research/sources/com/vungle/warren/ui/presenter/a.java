package com.vungle.warren.ui.presenter;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b10.e;
import b10.f;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.material.timepicker.TimeModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.j;
import com.vungle.warren.model.m;
import com.vungle.warren.model.o;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.utility.r;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f62433q = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.vungle.warren.model.c f62434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f62435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Repository f62436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f62437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s00.a f62438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f62439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f62440g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f62442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f62443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b10.b.a f62444k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedList<com.vungle.warren.model.c.a> f62447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Repository.y f62448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a10.b f62449p;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, j> f62441h = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f62445l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f62446m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.vungle.warren.ui.presenter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0634a implements Repository.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f62450a = false;

        public C0634a() {
        }

        @Override // com.vungle.warren.persistence.Repository.y
        public void a(Exception exc) {
            if (this.f62450a) {
                return;
            }
            this.f62450a = true;
            a.this.y(26);
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#onError", new VungleException(26).getLocalizedMessage());
            a.this.w();
        }

        @Override // com.vungle.warren.persistence.Repository.y
        public void b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements PresenterAdOpenCallback {
        public b() {
        }

        @Override // com.vungle.warren.ui.PresenterAdOpenCallback
        public void a(PresenterAdOpenCallback.AdOpenType adOpenType) {
            if (adOpenType == PresenterAdOpenCallback.AdOpenType.DEEP_LINK) {
                a.this.B("deeplinkSuccess", null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f62453a;

        public c(j jVar) {
            this.f62453a = jVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            String str;
            if (i11 == -2) {
                str = "opted_out";
            } else {
                str = i11 == -1 ? "opted_in" : "opted_out_by_timeout";
            }
            this.f62453a.e("consent_status", str);
            this.f62453a.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
            this.f62453a.e("consent_source", "vungle_modal");
            a.this.f62436c.i0(this.f62453a, null);
            a.this.start();
        }
    }

    public a(@NonNull com.vungle.warren.model.c cVar, @NonNull m mVar, @NonNull Repository repository, @NonNull r rVar, @NonNull s00.a aVar, @Nullable c10.a aVar2, @Nullable String[] strArr) {
        LinkedList<com.vungle.warren.model.c.a> linkedList = new LinkedList<>();
        this.f62447n = linkedList;
        this.f62448o = new C0634a();
        this.f62434a = cVar;
        this.f62435b = mVar;
        this.f62436c = repository;
        this.f62437d = rVar;
        this.f62438e = aVar;
        this.f62439f = strArr;
        if (cVar.p() != null) {
            linkedList.addAll(cVar.p());
        }
        x(aVar2);
    }

    private void A(c10.a aVar) {
        n(aVar);
        j jVar = this.f62441h.get("incentivizedTextSetByPub");
        String strD = jVar == null ? null : jVar.d("userID");
        if (this.f62440g == null) {
            o oVar = new o(this.f62434a, this.f62435b, System.currentTimeMillis(), strD);
            this.f62440g = oVar;
            oVar.l(this.f62434a.H());
            this.f62436c.i0(this.f62440g, this.f62448o);
        }
        if (this.f62449p == null) {
            this.f62449p = new a10.b(this.f62440g, this.f62436c, this.f62448o);
        }
        b10.b.a aVar2 = this.f62444k;
        if (aVar2 != null) {
            aVar2.a("start", null, this.f62435b.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(@NonNull String str, @Nullable String str2) {
        this.f62440g.f(str, str2, System.currentTimeMillis());
        this.f62436c.i0(this.f62440g, this.f62448o);
    }

    private void D(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        this.f62442i.showDialog(str, str2, str3, str4, onClickListener);
    }

    private void E(@NonNull j jVar) {
        c cVar = new c(jVar);
        jVar.e("consent_status", "opted_out_by_timeout");
        jVar.e(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
        jVar.e("consent_source", "vungle_modal");
        this.f62436c.i0(jVar, this.f62448o);
        D(jVar.d("consent_title"), jVar.d("consent_message"), jVar.d("button_accept"), jVar.d("button_deny"), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f62442i.close();
        this.f62437d.b();
    }

    private void x(c10.a aVar) {
        this.f62441h.put("incentivizedTextSetByPub", (j) this.f62436c.T("incentivizedTextSetByPub", j.class).get());
        this.f62441h.put("consentIsImportantToVungle", (j) this.f62436c.T("consentIsImportantToVungle", j.class).get());
        this.f62441h.put("configSettings", (j) this.f62436c.T("configSettings", j.class).get());
        if (aVar != null) {
            String string = aVar.getString("saved_report");
            o oVar = TextUtils.isEmpty(string) ? null : (o) this.f62436c.T(string, o.class).get();
            if (oVar != null) {
                this.f62440g = oVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i11) {
        b10.b.a aVar = this.f62444k;
        if (aVar != null) {
            aVar.b(new VungleException(i11), this.f62435b.d());
        }
    }

    private boolean z(@Nullable j jVar) {
        return jVar != null && jVar.a("is_country_data_protected").booleanValue() && AppLovinMediationProvider.UNKNOWN.equals(jVar.d("consent_status"));
    }

    public final void C(long j11) {
        this.f62440g.m(j11);
        this.f62436c.i0(this.f62440g, this.f62448o);
    }

    @Override // b10.e
    public void a(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isViewable=");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(this.f62435b);
        sb2.append(" ");
        sb2.append(hashCode());
        if (z11) {
            this.f62449p.b();
        } else {
            this.f62449p.c();
        }
    }

    @Override // b10.e
    public void b() {
        B("mraidOpen", "");
        try {
            this.f62438e.b(this.f62434a.G("clickUrl"));
            this.f62438e.b(new String[]{this.f62434a.m(true)});
            B(DownloadBaseRunnable.TAG, null);
            String strM = this.f62434a.m(false);
            String strS = this.f62434a.s();
            if ((strS == null || strS.isEmpty()) && (strM == null || strM.isEmpty())) {
                Log.e(f62433q, "CTA destination URL is not configured properly");
            } else {
                this.f62442i.open(strS, strM, new a10.f(this.f62444k, this.f62435b), new b());
            }
            b10.b.a aVar = this.f62444k;
            if (aVar != null) {
                aVar.a("open", "adClick", this.f62435b.d());
            }
        } catch (ActivityNotFoundException unused) {
            Log.e(f62433q, "Unable to find destination activity");
            VungleLogger.c(LocalAdPresenter.class.getSimpleName() + "#download", "Download - Activity Not Found");
        }
    }

    @Override // b10.e
    public void c(int i11, float f11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onProgressUpdate() ");
        sb2.append(this.f62435b);
        sb2.append(" ");
        sb2.append(hashCode());
        b10.b.a aVar = this.f62444k;
        if (aVar != null && i11 > 0 && !this.f62443j) {
            this.f62443j = true;
            aVar.a("adViewed", null, this.f62435b.d());
            String[] strArr = this.f62439f;
            if (strArr != null) {
                this.f62438e.b(strArr);
            }
        }
        b10.b.a aVar2 = this.f62444k;
        if (aVar2 != null) {
            aVar2.a("percentViewed:100", null, this.f62435b.d());
        }
        C(5000L);
        Locale locale = Locale.ENGLISH;
        B("videoLength", String.format(locale, TimeModel.NUMBER_FORMAT, 5000));
        B("videoViewed", String.format(locale, TimeModel.NUMBER_FORMAT, 100));
        com.vungle.warren.model.c.a aVarPollFirst = this.f62447n.pollFirst();
        if (aVarPollFirst != null) {
            this.f62438e.b(aVarPollFirst.c());
        }
        this.f62449p.d();
    }

    @Override // b10.e
    public void d() {
        this.f62442i.open(null, this.f62434a.A(), new a10.f(this.f62444k, this.f62435b), null);
    }

    @Override // b10.b
    public boolean k() {
        w();
        return true;
    }

    @Override // b10.b
    public void l() {
        this.f62442i.refreshDialogIfVisible();
    }

    @Override // b10.b
    public void m(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("stop() ");
        sb2.append(this.f62435b);
        sb2.append(" ");
        sb2.append(hashCode());
        this.f62449p.c();
        boolean z11 = (i11 & 1) != 0;
        boolean z12 = (i11 & 2) != 0;
        boolean z13 = (i11 & 4) != 0;
        if (z11 || !z12 || this.f62446m.getAndSet(true)) {
            return;
        }
        if (z13) {
            B("mraidCloseByApi", null);
        }
        this.f62436c.i0(this.f62440g, this.f62448o);
        w();
        b10.b.a aVar = this.f62444k;
        if (aVar != null) {
            aVar.a(TtmlNode.END, this.f62440g.e() ? "isCTAClicked" : null, this.f62435b.d());
        }
    }

    @Override // b10.b
    public void n(@Nullable c10.a aVar) {
        if (aVar == null) {
            return;
        }
        boolean z11 = aVar.getBoolean("incentivized_sent", false);
        if (z11) {
            this.f62445l.set(z11);
        }
        if (this.f62440g == null) {
            this.f62442i.close();
            VungleLogger.c(MRAIDAdPresenter.class.getSimpleName() + "#restoreFromSave", "The advertisement was not started and cannot be restored.");
        }
    }

    @Override // b10.b
    public void o(@Nullable b10.b.a aVar) {
        this.f62444k = aVar;
    }

    @Override // b10.b
    public void p(@Nullable c10.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f62436c.i0(this.f62440g, this.f62448o);
        o oVar = this.f62440g;
        aVar.put("saved_report", oVar == null ? null : oVar.c());
        aVar.put("incentivized_sent", this.f62445l.get());
    }

    @Override // b10.b
    public void s(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("detach() ");
        sb2.append(this.f62435b);
        sb2.append(" ");
        sb2.append(hashCode());
        m(i11);
        this.f62442i.destroyAdView(0L);
    }

    @Override // b10.b
    public void start() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("start() ");
        sb2.append(this.f62435b);
        sb2.append(" ");
        sb2.append(hashCode());
        this.f62449p.b();
        j jVar = this.f62441h.get("consentIsImportantToVungle");
        if (z(jVar)) {
            E(jVar);
        }
    }

    @Override // a10.d.a
    public void u(String str) {
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005c  */
    @Override // b10.b
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void j(@NonNull f fVar, @Nullable c10.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attach() ");
        sb2.append(this.f62435b);
        sb2.append(" ");
        sb2.append(hashCode());
        this.f62446m.set(false);
        this.f62442i = fVar;
        fVar.setPresenter(this);
        b10.b.a aVar2 = this.f62444k;
        if (aVar2 != null) {
            aVar2.a("attach", this.f62434a.q(), this.f62435b.d());
        }
        int iE = this.f62434a.d().e();
        int i11 = 7;
        if (iE == 3) {
            int iY = this.f62434a.y();
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
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Requested Orientation ");
        sb3.append(i11);
        fVar.setOrientation(i11);
        A(aVar);
    }
}
