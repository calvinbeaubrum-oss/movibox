package com.google.android.datatransport.cct.internal;

import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.push.PushConstants;
import eg.j;
import eg.k;
import eg.l;
import eg.m;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements vk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vk.a f32512a = new a();

    /* JADX INFO: renamed from: com.google.android.datatransport.cct.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0352a implements uk.c<eg.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0352a f32513a = new C0352a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32514b = uk.b.d(PushConstants.PROVIDER_FIELD_SDK_VERSION);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32515c = uk.b.d("model");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f32516d = uk.b.d("hardware");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f32517e = uk.b.d("device");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f32518f = uk.b.d(AppLovinEventTypes.USER_VIEWED_PRODUCT);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f32519g = uk.b.d("osBuild");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f32520h = uk.b.d("manufacturer");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f32521i = uk.b.d("fingerprint");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final uk.b f32522j = uk.b.d("locale");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final uk.b f32523k = uk.b.d(PlaceTypes.COUNTRY);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final uk.b f32524l = uk.b.d("mccMnc");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final uk.b f32525m = uk.b.d("applicationBuild");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(eg.a aVar, uk.d dVar) throws IOException {
            dVar.a(f32514b, aVar.m());
            dVar.a(f32515c, aVar.j());
            dVar.a(f32516d, aVar.f());
            dVar.a(f32517e, aVar.d());
            dVar.a(f32518f, aVar.l());
            dVar.a(f32519g, aVar.k());
            dVar.a(f32520h, aVar.h());
            dVar.a(f32521i, aVar.e());
            dVar.a(f32522j, aVar.g());
            dVar.a(f32523k, aVar.c());
            dVar.a(f32524l, aVar.i());
            dVar.a(f32525m, aVar.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements uk.c<eg.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32526a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32527b = uk.b.d("logRequest");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(eg.i iVar, uk.d dVar) throws IOException {
            dVar.a(f32527b, iVar.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements uk.c<ClientInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32528a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32529b = uk.b.d("clientType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32530c = uk.b.d("androidClientInfo");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientInfo clientInfo, uk.d dVar) throws IOException {
            dVar.a(f32529b, clientInfo.c());
            dVar.a(f32530c, clientInfo.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements uk.c<ComplianceData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32531a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32532b = uk.b.d("privacyContext");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32533c = uk.b.d("productIdOrigin");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ComplianceData complianceData, uk.d dVar) throws IOException {
            dVar.a(f32532b, complianceData.b());
            dVar.a(f32533c, complianceData.c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements uk.c<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32534a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32535b = uk.b.d("originAssociatedProductId");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, uk.d dVar) throws IOException {
            dVar.a(f32535b, jVar.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements uk.c<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f32536a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32537b = uk.b.d("prequest");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k kVar, uk.d dVar) throws IOException {
            dVar.a(f32537b, kVar.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements uk.c<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f32538a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32539b = uk.b.d("eventTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32540c = uk.b.d("eventCode");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f32541d = uk.b.d("complianceData");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f32542e = uk.b.d("eventUptimeMs");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f32543f = uk.b.d("sourceExtension");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f32544g = uk.b.d("sourceExtensionJsonProto3");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f32545h = uk.b.d("timezoneOffsetSeconds");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f32546i = uk.b.d("networkConnectionInfo");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l lVar, uk.d dVar) throws IOException {
            dVar.f(f32539b, lVar.d());
            dVar.a(f32540c, lVar.c());
            dVar.a(f32541d, lVar.b());
            dVar.f(f32542e, lVar.e());
            dVar.a(f32543f, lVar.g());
            dVar.a(f32544g, lVar.h());
            dVar.f(f32545h, lVar.i());
            dVar.a(f32546i, lVar.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h implements uk.c<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f32547a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32548b = uk.b.d("requestTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32549c = uk.b.d("requestUptimeMs");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f32550d = uk.b.d("clientInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f32551e = uk.b.d("logSource");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f32552f = uk.b.d("logSourceName");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f32553g = uk.b.d("logEvent");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f32554h = uk.b.d("qosTier");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, uk.d dVar) throws IOException {
            dVar.f(f32548b, mVar.g());
            dVar.f(f32549c, mVar.h());
            dVar.a(f32550d, mVar.b());
            dVar.a(f32551e, mVar.d());
            dVar.a(f32552f, mVar.e());
            dVar.a(f32553g, mVar.c());
            dVar.a(f32554h, mVar.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i implements uk.c<NetworkConnectionInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f32555a = new i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32556b = uk.b.d(NetworkBridge.KEY_NETWORK_TYPE);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32557c = uk.b.d("mobileSubtype");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(NetworkConnectionInfo networkConnectionInfo, uk.d dVar) throws IOException {
            dVar.a(f32556b, networkConnectionInfo.c());
            dVar.a(f32557c, networkConnectionInfo.b());
        }
    }

    @Override // vk.a
    public void a(vk.b<?> bVar) {
        b bVar2 = b.f32526a;
        bVar.a(eg.i.class, bVar2);
        bVar.a(eg.c.class, bVar2);
        h hVar = h.f32547a;
        bVar.a(m.class, hVar);
        bVar.a(eg.g.class, hVar);
        c cVar = c.f32528a;
        bVar.a(ClientInfo.class, cVar);
        bVar.a(com.google.android.datatransport.cct.internal.b.class, cVar);
        C0352a c0352a = C0352a.f32513a;
        bVar.a(eg.a.class, c0352a);
        bVar.a(eg.b.class, c0352a);
        g gVar = g.f32538a;
        bVar.a(l.class, gVar);
        bVar.a(eg.f.class, gVar);
        d dVar = d.f32531a;
        bVar.a(ComplianceData.class, dVar);
        bVar.a(com.google.android.datatransport.cct.internal.c.class, dVar);
        f fVar = f.f32536a;
        bVar.a(k.class, fVar);
        bVar.a(eg.e.class, fVar);
        e eVar = e.f32534a;
        bVar.a(j.class, eVar);
        bVar.a(eg.d.class, eVar);
        i iVar = i.f32555a;
        bVar.a(NetworkConnectionInfo.class, iVar);
        bVar.a(com.google.android.datatransport.cct.internal.d.class, iVar);
    }
}
