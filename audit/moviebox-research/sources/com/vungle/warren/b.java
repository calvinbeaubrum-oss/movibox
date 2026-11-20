package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.push.PushConstants;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.presenter.LocalAdPresenter;
import com.vungle.warren.ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.ui.view.FullAdWidget;
import com.vungle.warren.ui.view.LocalAdView;
import com.vungle.warren.ui.view.VungleWebClient;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f61895k = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y00.h f61896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VungleApiClient f61897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f61898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Repository f61899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f61900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.vungle.warren.model.c f61901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AdLoader f61902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.vungle.warren.omsdk.a.b f61903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ExecutorService f61904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c.a f61905j = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements c.a {
        public a() {
        }

        @Override // com.vungle.warren.b.c.a
        public void a(com.vungle.warren.model.c cVar, com.vungle.warren.model.m mVar) {
            b.this.f61901f = cVar;
        }
    }

    /* JADX INFO: renamed from: com.vungle.warren.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class AsyncTaskC0628b extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public Context f61907h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AdRequest f61908i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AdConfig f61909j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final r.c f61910k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Bundle f61911l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final y00.h f61912m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final AdLoader f61913n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final VungleApiClient f61914o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final com.vungle.warren.omsdk.a.b f61915p;

        public AsyncTaskC0628b(Context context, AdRequest adRequest, AdConfig adConfig, AdLoader adLoader, Repository repository, y yVar, y00.h hVar, r.c cVar, Bundle bundle, c.a aVar, VungleApiClient vungleApiClient, com.vungle.warren.omsdk.a.b bVar) {
            super(repository, yVar, aVar);
            this.f61907h = context;
            this.f61908i = adRequest;
            this.f61909j = adConfig;
            this.f61910k = cVar;
            this.f61911l = bundle;
            this.f61912m = hVar;
            this.f61913n = adLoader;
            this.f61914o = vungleApiClient;
            this.f61915p = bVar;
        }

        @Override // com.vungle.warren.b.c
        public void a() {
            super.a();
            this.f61907h = null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(f fVar) {
            r.c cVar;
            super.onPostExecute(fVar);
            if (isCancelled() || (cVar = this.f61910k) == null) {
                return;
            }
            cVar.a(new Pair<>((b10.g) fVar.f61945b, fVar.f61947d), fVar.f61946c);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public f doInBackground(Void... voidArr) {
            try {
                Pair<com.vungle.warren.model.c, com.vungle.warren.model.m> pairB = b(this.f61908i, this.f61911l);
                com.vungle.warren.model.c cVar = (com.vungle.warren.model.c) pairB.first;
                if (cVar.h() != 1) {
                    Log.e(b.f61895k, "Invalid Ad Type for Native Ad.");
                    return new f(new VungleException(10));
                }
                com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) pairB.second;
                if (!this.f61913n.t(cVar)) {
                    Log.e(b.f61895k, "Advertisement is null or assets are missing");
                    return new f(new VungleException(10));
                }
                com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f61916a.T("configSettings", com.vungle.warren.model.j.class).get();
                if (jVar != null && jVar.a("isAdDownloadOptEnabled").booleanValue() && !cVar.W) {
                    List<com.vungle.warren.model.a> listW = this.f61916a.W(cVar.v(), 3);
                    if (!listW.isEmpty()) {
                        cVar.h0(listW);
                        try {
                            this.f61916a.h0(cVar);
                        } catch (DatabaseHelper.DBException unused) {
                            Log.e(b.f61895k, "Unable to update tokens");
                        }
                    }
                }
                s00.b bVar = new s00.b(this.f61912m);
                VungleWebClient vungleWebClient = new VungleWebClient(cVar, mVar, ((com.vungle.warren.utility.f) t.f(this.f61907h).h(com.vungle.warren.utility.f.class)).g());
                File file = this.f61916a.L(cVar.v()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(b.f61895k, "Advertisement assets dir is missing");
                    return new f(new VungleException(26));
                }
                if ("mrec".equals(cVar.F()) && this.f61909j.a() != AdConfig.AdSize.VUNGLE_MREC) {
                    Log.e(b.f61895k, "Corresponding AdConfig#setAdSize must be passed for the type/size of banner ad");
                    return new f(new VungleException(28));
                }
                if (mVar.f() == 0) {
                    return new f(new VungleException(10));
                }
                cVar.b(this.f61909j);
                try {
                    this.f61916a.h0(cVar);
                    com.vungle.warren.omsdk.a aVarA = this.f61915p.a(this.f61914o.m() && cVar.x());
                    vungleWebClient.e(aVarA);
                    return new f(null, new MRAIDAdPresenter(cVar, mVar, this.f61916a, new com.vungle.warren.utility.j(), bVar, vungleWebClient, null, file, aVarA, this.f61908i.getImpression()), vungleWebClient);
                } catch (DatabaseHelper.DBException unused2) {
                    return new f(new VungleException(26));
                }
            } catch (VungleException e11) {
                return new f(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends AsyncTask<Void, Void, f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Repository f61916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f61917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f61918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicReference<com.vungle.warren.model.c> f61919d = new AtomicReference<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AtomicReference<com.vungle.warren.model.m> f61920e = new AtomicReference<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AdLoader f61921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Downloader f61922g;

        /* JADX INFO: compiled from: source.java */
        public interface a {
            void a(com.vungle.warren.model.c cVar, com.vungle.warren.model.m mVar);
        }

        public c(Repository repository, y yVar, a aVar) {
            this.f61916a = repository;
            this.f61917b = yVar;
            this.f61918c = aVar;
            Context contextAppContext = Vungle.appContext();
            if (contextAppContext != null) {
                t tVarF = t.f(contextAppContext);
                this.f61921f = (AdLoader) tVarF.h(AdLoader.class);
                this.f61922g = (Downloader) tVarF.h(Downloader.class);
            }
        }

        public void a() {
            this.f61918c = null;
        }

        public Pair<com.vungle.warren.model.c, com.vungle.warren.model.m> b(AdRequest adRequest, Bundle bundle) throws VungleException {
            com.vungle.warren.model.c cVar;
            if (!this.f61917b.isInitialized()) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).c());
                throw new VungleException(9);
            }
            if (adRequest == null || TextUtils.isEmpty(adRequest.getPlacementId())) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).c());
                throw new VungleException(10);
            }
            com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) this.f61916a.T(adRequest.getPlacementId(), com.vungle.warren.model.m.class).get();
            if (mVar == null) {
                Log.e(b.f61895k, "No Placement for ID");
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).c());
                throw new VungleException(13);
            }
            if (mVar.l() && adRequest.getEventId() == null) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).c());
                throw new VungleException(36);
            }
            this.f61920e.set(mVar);
            if (bundle == null) {
                cVar = this.f61916a.C(adRequest.getPlacementId(), adRequest.getEventId()).get();
            } else {
                String string = bundle.getString("ADV_FACTORY_ADVERTISEMENT");
                cVar = !TextUtils.isEmpty(string) ? (com.vungle.warren.model.c) this.f61916a.T(string, com.vungle.warren.model.c.class).get() : null;
            }
            if (cVar == null) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).c());
                throw new VungleException(10);
            }
            this.f61919d.set(cVar);
            File file = this.f61916a.L(cVar.v()).get();
            if (file == null || !file.isDirectory()) {
                Log.e(b.f61895k, "Advertisement assets dir is missing");
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.PLAY_AD).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.EVENT_ID, cVar.v()).c());
                throw new VungleException(26);
            }
            AdLoader adLoader = this.f61921f;
            if (adLoader != null && this.f61922g != null && adLoader.M(cVar)) {
                String unused = b.f61895k;
                for (com.vungle.warren.downloader.e eVar : this.f61922g.d()) {
                    if (cVar.v().equals(eVar.b())) {
                        String unused2 = b.f61895k;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Cancel downloading: ");
                        sb2.append(eVar);
                        this.f61922g.h(eVar);
                    }
                }
            }
            return new Pair<>(cVar, mVar);
        }

        /* JADX INFO: renamed from: c */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            a aVar = this.f61918c;
            if (aVar != null) {
                aVar.a(this.f61919d.get(), this.f61920e.get());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AdLoader f61923h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public FullAdWidget f61924i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public Context f61925j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AdRequest f61926k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final c10.a f61927l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final r.a f61928m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Bundle f61929n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final y00.h f61930o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final VungleApiClient f61931p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final a10.a f61932q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final a10.e f61933r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public com.vungle.warren.model.c f61934s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final com.vungle.warren.omsdk.a.b f61935t;

        public d(Context context, AdLoader adLoader, AdRequest adRequest, Repository repository, y yVar, y00.h hVar, VungleApiClient vungleApiClient, FullAdWidget fullAdWidget, c10.a aVar, a10.e eVar, a10.a aVar2, r.a aVar3, c.a aVar4, Bundle bundle, com.vungle.warren.omsdk.a.b bVar) {
            super(repository, yVar, aVar4);
            this.f61926k = adRequest;
            this.f61924i = fullAdWidget;
            this.f61927l = aVar;
            this.f61925j = context;
            this.f61928m = aVar3;
            this.f61929n = bundle;
            this.f61930o = hVar;
            this.f61931p = vungleApiClient;
            this.f61933r = eVar;
            this.f61932q = aVar2;
            this.f61923h = adLoader;
            this.f61935t = bVar;
        }

        @Override // com.vungle.warren.b.c
        public void a() {
            super.a();
            this.f61925j = null;
            this.f61924i = null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            if (isCancelled() || this.f61928m == null) {
                return;
            }
            if (fVar.f61946c != null) {
                Log.e(b.f61895k, "Exception on creating presenter", fVar.f61946c);
                this.f61928m.a(new Pair<>(null, null), fVar.f61946c);
            } else {
                this.f61924i.linkWebView(fVar.f61947d, new a10.d(fVar.f61945b));
                this.f61928m.a(new Pair<>(fVar.f61944a, fVar.f61945b), fVar.f61946c);
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public f doInBackground(Void... voidArr) {
            try {
                Pair<com.vungle.warren.model.c, com.vungle.warren.model.m> pairB = b(this.f61926k, this.f61929n);
                com.vungle.warren.model.c cVar = (com.vungle.warren.model.c) pairB.first;
                this.f61934s = cVar;
                com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) pairB.second;
                if (!this.f61923h.v(cVar)) {
                    Log.e(b.f61895k, "Advertisement is null or assets are missing");
                    return new f(new VungleException(10));
                }
                if (mVar.f() == 4) {
                    return new f(new VungleException(41));
                }
                if (mVar.f() != 0) {
                    return new f(new VungleException(29));
                }
                s00.b bVar = new s00.b(this.f61930o);
                com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f61916a.T(PushConstants.PROVIDER_FIELD_APP_ID, com.vungle.warren.model.j.class).get();
                if (jVar != null && !TextUtils.isEmpty(jVar.d(PushConstants.PROVIDER_FIELD_APP_ID))) {
                    jVar.d(PushConstants.PROVIDER_FIELD_APP_ID);
                }
                com.vungle.warren.model.j jVar2 = (com.vungle.warren.model.j) this.f61916a.T("configSettings", com.vungle.warren.model.j.class).get();
                if (jVar2 != null && jVar2.a("isAdDownloadOptEnabled").booleanValue()) {
                    com.vungle.warren.model.c cVar2 = this.f61934s;
                    if (!cVar2.W) {
                        List<com.vungle.warren.model.a> listW = this.f61916a.W(cVar2.v(), 3);
                        if (!listW.isEmpty()) {
                            this.f61934s.h0(listW);
                            try {
                                this.f61916a.h0(this.f61934s);
                            } catch (DatabaseHelper.DBException unused) {
                                Log.e(b.f61895k, "Unable to update tokens");
                            }
                        }
                    }
                }
                VungleWebClient vungleWebClient = new VungleWebClient(this.f61934s, mVar, ((com.vungle.warren.utility.f) t.f(this.f61925j).h(com.vungle.warren.utility.f.class)).g());
                File file = this.f61916a.L(this.f61934s.v()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(b.f61895k, "Advertisement assets dir is missing");
                    return new f(new VungleException(26));
                }
                int iH = this.f61934s.h();
                if (iH == 0) {
                    return new f(new LocalAdView(this.f61925j, this.f61924i, this.f61933r, this.f61932q), new LocalAdPresenter(this.f61934s, mVar, this.f61916a, new com.vungle.warren.utility.j(), bVar, vungleWebClient, this.f61927l, file, this.f61926k.getImpression()), vungleWebClient);
                }
                if (iH != 1) {
                    return new f(new VungleException(10));
                }
                com.vungle.warren.omsdk.a aVarA = this.f61935t.a(this.f61931p.m() && this.f61934s.x());
                vungleWebClient.e(aVarA);
                return new f(new com.vungle.warren.ui.view.c(this.f61925j, this.f61924i, this.f61933r, this.f61932q), new MRAIDAdPresenter(this.f61934s, mVar, this.f61916a, new com.vungle.warren.utility.j(), bVar, vungleWebClient, this.f61927l, file, aVarA, this.f61926k.getImpression()), vungleWebClient);
            } catch (VungleException e11) {
                return new f(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public Context f61936h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public NativeAdLayout f61937i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AdRequest f61938j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AdConfig f61939k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final r.b f61940l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Bundle f61941m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final y00.h f61942n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final AdLoader f61943o;

        public e(Context context, NativeAdLayout nativeAdLayout, AdRequest adRequest, AdConfig adConfig, AdLoader adLoader, Repository repository, y yVar, y00.h hVar, r.b bVar, Bundle bundle, c.a aVar) {
            super(repository, yVar, aVar);
            this.f61936h = context;
            this.f61937i = nativeAdLayout;
            this.f61938j = adRequest;
            this.f61939k = adConfig;
            this.f61940l = bVar;
            this.f61941m = bundle;
            this.f61942n = hVar;
            this.f61943o = adLoader;
        }

        @Override // com.vungle.warren.b.c
        public void a() {
            super.a();
            this.f61936h = null;
            this.f61937i = null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c */
        public void onPostExecute(f fVar) {
            r.b bVar;
            super.onPostExecute(fVar);
            if (isCancelled() || (bVar = this.f61940l) == null) {
                return;
            }
            bVar.a(new Pair<>((b10.f) fVar.f61944a, (b10.e) fVar.f61945b), fVar.f61946c);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public f doInBackground(Void... voidArr) {
            try {
                Pair<com.vungle.warren.model.c, com.vungle.warren.model.m> pairB = b(this.f61938j, this.f61941m);
                com.vungle.warren.model.c cVar = (com.vungle.warren.model.c) pairB.first;
                if (cVar.h() != 1) {
                    Log.e(b.f61895k, "Invalid Ad Type for Native Ad.");
                    return new f(new VungleException(10));
                }
                com.vungle.warren.model.m mVar = (com.vungle.warren.model.m) pairB.second;
                if (!this.f61943o.t(cVar)) {
                    Log.e(b.f61895k, "Advertisement is null or assets are missing");
                    return new f(new VungleException(10));
                }
                com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f61916a.T("configSettings", com.vungle.warren.model.j.class).get();
                if (jVar != null && jVar.a("isAdDownloadOptEnabled").booleanValue() && !cVar.W) {
                    List<com.vungle.warren.model.a> listW = this.f61916a.W(cVar.v(), 3);
                    if (!listW.isEmpty()) {
                        cVar.h0(listW);
                        try {
                            this.f61916a.h0(cVar);
                        } catch (DatabaseHelper.DBException unused) {
                            Log.e(b.f61895k, "Unable to update tokens");
                        }
                    }
                }
                s00.b bVar = new s00.b(this.f61942n);
                File file = this.f61916a.L(cVar.v()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(b.f61895k, "Advertisement assets dir is missing");
                    return new f(new VungleException(26));
                }
                if (!cVar.W()) {
                    return new f(new VungleException(10));
                }
                cVar.b(this.f61939k);
                try {
                    this.f61916a.h0(cVar);
                    return new f(new com.vungle.warren.ui.view.d(this.f61936h, this.f61937i), new com.vungle.warren.ui.presenter.a(cVar, mVar, this.f61916a, new com.vungle.warren.utility.j(), bVar, null, this.f61938j.getImpression()), null);
                } catch (DatabaseHelper.DBException unused2) {
                    return new f(new VungleException(26));
                }
            } catch (VungleException e11) {
                return new f(e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b10.a f61944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b10.b f61945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public VungleException f61946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public VungleWebClient f61947d;

        public f(b10.a aVar, b10.b bVar, VungleWebClient vungleWebClient) {
            this.f61944a = aVar;
            this.f61945b = bVar;
            this.f61947d = vungleWebClient;
        }

        public f(VungleException vungleException) {
            this.f61946c = vungleException;
        }
    }

    public b(@NonNull AdLoader adLoader, @NonNull y yVar, @NonNull Repository repository, @NonNull VungleApiClient vungleApiClient, @NonNull y00.h hVar, @NonNull com.vungle.warren.omsdk.a.b bVar, @NonNull ExecutorService executorService) {
        this.f61900e = yVar;
        this.f61899d = repository;
        this.f61897b = vungleApiClient;
        this.f61896a = hVar;
        this.f61902g = adLoader;
        this.f61903h = bVar;
        this.f61904i = executorService;
    }

    @Override // com.vungle.warren.r
    public void a(@NonNull Context context, @NonNull NativeAdLayout nativeAdLayout, @NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull r.b bVar) {
        g();
        e eVar = new e(context, nativeAdLayout, adRequest, adConfig, this.f61902g, this.f61899d, this.f61900e, this.f61896a, bVar, null, this.f61905j);
        this.f61898c = eVar;
        eVar.executeOnExecutor(this.f61904i, new Void[0]);
    }

    @Override // com.vungle.warren.r
    public void b(Context context, @NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull a10.a aVar, @NonNull r.c cVar) {
        g();
        AsyncTaskC0628b asyncTaskC0628b = new AsyncTaskC0628b(context, adRequest, adConfig, this.f61902g, this.f61899d, this.f61900e, this.f61896a, cVar, null, this.f61905j, this.f61897b, this.f61903h);
        this.f61898c = asyncTaskC0628b;
        asyncTaskC0628b.executeOnExecutor(this.f61904i, new Void[0]);
    }

    @Override // com.vungle.warren.r
    public void c(@NonNull Context context, @NonNull AdRequest adRequest, @NonNull FullAdWidget fullAdWidget, @Nullable c10.a aVar, @NonNull a10.a aVar2, @NonNull a10.e eVar, @Nullable Bundle bundle, @NonNull r.a aVar3) {
        g();
        d dVar = new d(context, this.f61902g, adRequest, this.f61899d, this.f61900e, this.f61896a, this.f61897b, fullAdWidget, aVar, eVar, aVar2, aVar3, this.f61905j, bundle, this.f61903h);
        this.f61898c = dVar;
        dVar.executeOnExecutor(this.f61904i, new Void[0]);
    }

    @Override // com.vungle.warren.r
    public void d(Bundle bundle) {
        com.vungle.warren.model.c cVar = this.f61901f;
        bundle.putString("ADV_FACTORY_ADVERTISEMENT", cVar == null ? null : cVar.v());
    }

    @Override // com.vungle.warren.r
    public void destroy() {
        g();
    }

    public final void g() {
        c cVar = this.f61898c;
        if (cVar != null) {
            cVar.cancel(true);
            this.f61898c.a();
        }
    }
}
