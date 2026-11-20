package com.google.firebase.crashlytics.internal.model;

import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements vk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vk.a f40241a = new a();

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.model.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0440a implements uk.c<CrashlyticsReport.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0440a f40242a = new C0440a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40243b = uk.b.d("pid");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40244c = uk.b.d("processName");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40245d = uk.b.d("reasonCode");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40246e = uk.b.d("importance");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40247f = uk.b.d("pss");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40248g = uk.b.d("rss");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f40249h = uk.b.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f40250i = uk.b.d("traceFile");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.a aVar, uk.d dVar) throws IOException {
            dVar.e(f40243b, aVar.c());
            dVar.a(f40244c, aVar.d());
            dVar.e(f40245d, aVar.f());
            dVar.e(f40246e, aVar.b());
            dVar.f(f40247f, aVar.e());
            dVar.f(f40248g, aVar.g());
            dVar.f(f40249h, aVar.h());
            dVar.a(f40250i, aVar.i());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements uk.c<CrashlyticsReport.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f40251a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40252b = uk.b.d("key");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40253c = uk.b.d(AppMeasurementSdk.ConditionalUserProperty.VALUE);

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.c cVar, uk.d dVar) throws IOException {
            dVar.a(f40252b, cVar.b());
            dVar.a(f40253c, cVar.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements uk.c<CrashlyticsReport> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f40254a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40255b = uk.b.d(PushConstants.PROVIDER_FIELD_SDK_VERSION);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40256c = uk.b.d("gmpAppId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40257d = uk.b.d(TrackingKey.PLATFORM);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40258e = uk.b.d("installationUuid");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40259f = uk.b.d("buildVersion");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40260g = uk.b.d("displayVersion");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f40261h = uk.b.d("session");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f40262i = uk.b.d("ndkPayload");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport crashlyticsReport, uk.d dVar) throws IOException {
            dVar.a(f40255b, crashlyticsReport.i());
            dVar.a(f40256c, crashlyticsReport.e());
            dVar.e(f40257d, crashlyticsReport.h());
            dVar.a(f40258e, crashlyticsReport.f());
            dVar.a(f40259f, crashlyticsReport.c());
            dVar.a(f40260g, crashlyticsReport.d());
            dVar.a(f40261h, crashlyticsReport.j());
            dVar.a(f40262i, crashlyticsReport.g());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements uk.c<CrashlyticsReport.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f40263a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40264b = uk.b.d("files");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40265c = uk.b.d("orgId");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.d dVar, uk.d dVar2) throws IOException {
            dVar2.a(f40264b, dVar.b());
            dVar2.a(f40265c, dVar.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements uk.c<CrashlyticsReport.d.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f40266a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40267b = uk.b.d("filename");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40268c = uk.b.d("contents");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.d.b bVar, uk.d dVar) throws IOException {
            dVar.a(f40267b, bVar.c());
            dVar.a(f40268c, bVar.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements uk.c<CrashlyticsReport.e.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f40269a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40270b = uk.b.d("identifier");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40271c = uk.b.d("version");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40272d = uk.b.d("displayVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40273e = uk.b.d("organization");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40274f = uk.b.d("installationUuid");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40275g = uk.b.d("developmentPlatform");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f40276h = uk.b.d("developmentPlatformVersion");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.a aVar, uk.d dVar) throws IOException {
            dVar.a(f40270b, aVar.e());
            dVar.a(f40271c, aVar.h());
            dVar.a(f40272d, aVar.d());
            dVar.a(f40273e, aVar.g());
            dVar.a(f40274f, aVar.f());
            dVar.a(f40275g, aVar.b());
            dVar.a(f40276h, aVar.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements uk.c<CrashlyticsReport.e.a.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f40277a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40278b = uk.b.d("clsId");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.a.b bVar, uk.d dVar) throws IOException {
            dVar.a(f40278b, bVar.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements uk.c<CrashlyticsReport.e.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f40279a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40280b = uk.b.d("arch");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40281c = uk.b.d("model");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40282d = uk.b.d("cores");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40283e = uk.b.d("ram");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40284f = uk.b.d("diskSpace");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40285g = uk.b.d("simulator");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f40286h = uk.b.d("state");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f40287i = uk.b.d("manufacturer");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final uk.b f40288j = uk.b.d("modelClass");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.c cVar, uk.d dVar) throws IOException {
            dVar.e(f40280b, cVar.b());
            dVar.a(f40281c, cVar.f());
            dVar.e(f40282d, cVar.c());
            dVar.f(f40283e, cVar.h());
            dVar.f(f40284f, cVar.d());
            dVar.d(f40285g, cVar.j());
            dVar.e(f40286h, cVar.i());
            dVar.a(f40287i, cVar.e());
            dVar.a(f40288j, cVar.g());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i implements uk.c<CrashlyticsReport.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f40289a = new i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40290b = uk.b.d("generator");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40291c = uk.b.d("identifier");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40292d = uk.b.d("startedAt");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40293e = uk.b.d("endedAt");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40294f = uk.b.d("crashed");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40295g = uk.b.d(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f40296h = uk.b.d("user");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f40297i = uk.b.d("os");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final uk.b f40298j = uk.b.d("device");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final uk.b f40299k = uk.b.d("events");

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final uk.b f40300l = uk.b.d("generatorType");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e eVar, uk.d dVar) throws IOException {
            dVar.a(f40290b, eVar.f());
            dVar.a(f40291c, eVar.i());
            dVar.f(f40292d, eVar.k());
            dVar.a(f40293e, eVar.d());
            dVar.d(f40294f, eVar.m());
            dVar.a(f40295g, eVar.b());
            dVar.a(f40296h, eVar.l());
            dVar.a(f40297i, eVar.j());
            dVar.a(f40298j, eVar.c());
            dVar.a(f40299k, eVar.e());
            dVar.e(f40300l, eVar.g());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j implements uk.c<CrashlyticsReport.e.d.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f40301a = new j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40302b = uk.b.d("execution");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40303c = uk.b.d("customAttributes");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40304d = uk.b.d("internalKeys");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40305e = uk.b.d("background");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40306f = uk.b.d("uiOrientation");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a aVar, uk.d dVar) throws IOException {
            dVar.a(f40302b, aVar.d());
            dVar.a(f40303c, aVar.c());
            dVar.a(f40304d, aVar.e());
            dVar.a(f40305e, aVar.b());
            dVar.e(f40306f, aVar.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k implements uk.c<CrashlyticsReport.e.d.a.b.AbstractC0428a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f40307a = new k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40308b = uk.b.d("baseAddress");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40309c = uk.b.d("size");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40310d = uk.b.d("name");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40311e = uk.b.d("uuid");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0428a abstractC0428a, uk.d dVar) throws IOException {
            dVar.f(f40308b, abstractC0428a.b());
            dVar.f(f40309c, abstractC0428a.d());
            dVar.a(f40310d, abstractC0428a.c());
            dVar.a(f40311e, abstractC0428a.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l implements uk.c<CrashlyticsReport.e.d.a.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f40312a = new l();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40313b = uk.b.d("threads");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40314c = uk.b.d("exception");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40315d = uk.b.d("appExitInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40316e = uk.b.d("signal");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40317f = uk.b.d("binaries");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b bVar, uk.d dVar) throws IOException {
            dVar.a(f40313b, bVar.f());
            dVar.a(f40314c, bVar.d());
            dVar.a(f40315d, bVar.b());
            dVar.a(f40316e, bVar.e());
            dVar.a(f40317f, bVar.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m implements uk.c<CrashlyticsReport.e.d.a.b.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f40318a = new m();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40319b = uk.b.d("type");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40320c = uk.b.d("reason");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40321d = uk.b.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40322e = uk.b.d("causedBy");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40323f = uk.b.d("overflowCount");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.c cVar, uk.d dVar) throws IOException {
            dVar.a(f40319b, cVar.f());
            dVar.a(f40320c, cVar.e());
            dVar.a(f40321d, cVar.c());
            dVar.a(f40322e, cVar.b());
            dVar.e(f40323f, cVar.d());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class n implements uk.c<CrashlyticsReport.e.d.a.b.AbstractC0432d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f40324a = new n();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40325b = uk.b.d("name");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40326c = uk.b.d(TrackingKey.CODE);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40327d = uk.b.d(PlaceTypes.ADDRESS);

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0432d abstractC0432d, uk.d dVar) throws IOException {
            dVar.a(f40325b, abstractC0432d.d());
            dVar.a(f40326c, abstractC0432d.c());
            dVar.f(f40327d, abstractC0432d.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o implements uk.c<CrashlyticsReport.e.d.a.b.AbstractC0434e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f40328a = new o();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40329b = uk.b.d("name");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40330c = uk.b.d("importance");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40331d = uk.b.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0434e abstractC0434e, uk.d dVar) throws IOException {
            dVar.a(f40329b, abstractC0434e.d());
            dVar.e(f40330c, abstractC0434e.c());
            dVar.a(f40331d, abstractC0434e.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class p implements uk.c<CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f40332a = new p();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40333b = uk.b.d("pc");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40334c = uk.b.d("symbol");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40335d = uk.b.d("file");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40336e = uk.b.d("offset");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40337f = uk.b.d("importance");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b abstractC0436b, uk.d dVar) throws IOException {
            dVar.f(f40333b, abstractC0436b.e());
            dVar.a(f40334c, abstractC0436b.f());
            dVar.a(f40335d, abstractC0436b.b());
            dVar.f(f40336e, abstractC0436b.d());
            dVar.e(f40337f, abstractC0436b.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class q implements uk.c<CrashlyticsReport.e.d.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f40338a = new q();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40339b = uk.b.d("batteryLevel");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40340c = uk.b.d("batteryVelocity");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40341d = uk.b.d("proximityOn");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40342e = uk.b.d("orientation");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40343f = uk.b.d("ramUsed");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40344g = uk.b.d("diskUsed");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.c cVar, uk.d dVar) throws IOException {
            dVar.a(f40339b, cVar.b());
            dVar.e(f40340c, cVar.c());
            dVar.d(f40341d, cVar.g());
            dVar.e(f40342e, cVar.e());
            dVar.f(f40343f, cVar.f());
            dVar.f(f40344g, cVar.d());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class r implements uk.c<CrashlyticsReport.e.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f40345a = new r();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40346b = uk.b.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40347c = uk.b.d("type");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40348d = uk.b.d(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40349e = uk.b.d("device");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40350f = uk.b.d("log");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d dVar, uk.d dVar2) throws IOException {
            dVar2.f(f40346b, dVar.e());
            dVar2.a(f40347c, dVar.f());
            dVar2.a(f40348d, dVar.b());
            dVar2.a(f40349e, dVar.c());
            dVar2.a(f40350f, dVar.d());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class s implements uk.c<CrashlyticsReport.e.d.AbstractC0438d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f40351a = new s();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40352b = uk.b.d(AppLovinEventTypes.USER_VIEWED_CONTENT);

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.d.AbstractC0438d abstractC0438d, uk.d dVar) throws IOException {
            dVar.a(f40352b, abstractC0438d.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class t implements uk.c<CrashlyticsReport.e.AbstractC0439e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f40353a = new t();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40354b = uk.b.d(TrackingKey.PLATFORM);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40355c = uk.b.d("version");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40356d = uk.b.d("buildVersion");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40357e = uk.b.d("jailbroken");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.AbstractC0439e abstractC0439e, uk.d dVar) throws IOException {
            dVar.e(f40354b, abstractC0439e.c());
            dVar.a(f40355c, abstractC0439e.d());
            dVar.a(f40356d, abstractC0439e.b());
            dVar.d(f40357e, abstractC0439e.e());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class u implements uk.c<CrashlyticsReport.e.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f40358a = new u();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40359b = uk.b.d("identifier");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CrashlyticsReport.e.f fVar, uk.d dVar) throws IOException {
            dVar.a(f40359b, fVar.b());
        }
    }

    @Override // vk.a
    public void a(vk.b<?> bVar) {
        c cVar = c.f40254a;
        bVar.a(CrashlyticsReport.class, cVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.b.class, cVar);
        i iVar = i.f40289a;
        bVar.a(CrashlyticsReport.e.class, iVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.g.class, iVar);
        f fVar = f.f40269a;
        bVar.a(CrashlyticsReport.e.a.class, fVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.h.class, fVar);
        g gVar = g.f40277a;
        bVar.a(CrashlyticsReport.e.a.b.class, gVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.i.class, gVar);
        u uVar = u.f40358a;
        bVar.a(CrashlyticsReport.e.f.class, uVar);
        bVar.a(v.class, uVar);
        t tVar = t.f40353a;
        bVar.a(CrashlyticsReport.e.AbstractC0439e.class, tVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.u.class, tVar);
        h hVar = h.f40279a;
        bVar.a(CrashlyticsReport.e.c.class, hVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.j.class, hVar);
        r rVar = r.f40345a;
        bVar.a(CrashlyticsReport.e.d.class, rVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.k.class, rVar);
        j jVar = j.f40301a;
        bVar.a(CrashlyticsReport.e.d.a.class, jVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.l.class, jVar);
        l lVar = l.f40312a;
        bVar.a(CrashlyticsReport.e.d.a.b.class, lVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.m.class, lVar);
        o oVar = o.f40328a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0434e.class, oVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.q.class, oVar);
        p pVar = p.f40332a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.class, pVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.r.class, pVar);
        m mVar = m.f40318a;
        bVar.a(CrashlyticsReport.e.d.a.b.c.class, mVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.o.class, mVar);
        C0440a c0440a = C0440a.f40242a;
        bVar.a(CrashlyticsReport.a.class, c0440a);
        bVar.a(com.google.firebase.crashlytics.internal.model.c.class, c0440a);
        n nVar = n.f40324a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0432d.class, nVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.p.class, nVar);
        k kVar = k.f40307a;
        bVar.a(CrashlyticsReport.e.d.a.b.AbstractC0428a.class, kVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.n.class, kVar);
        b bVar2 = b.f40251a;
        bVar.a(CrashlyticsReport.c.class, bVar2);
        bVar.a(com.google.firebase.crashlytics.internal.model.d.class, bVar2);
        q qVar = q.f40338a;
        bVar.a(CrashlyticsReport.e.d.c.class, qVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.s.class, qVar);
        s sVar = s.f40351a;
        bVar.a(CrashlyticsReport.e.d.AbstractC0438d.class, sVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.t.class, sVar);
        d dVar = d.f40263a;
        bVar.a(CrashlyticsReport.d.class, dVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.e.class, dVar);
        e eVar = e.f40266a;
        bVar.a(CrashlyticsReport.d.b.class, eVar);
        bVar.a(com.google.firebase.crashlytics.internal.model.f.class, eVar);
    }
}
