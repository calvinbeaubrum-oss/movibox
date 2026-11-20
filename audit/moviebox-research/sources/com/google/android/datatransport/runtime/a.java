package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements vk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vk.a f32571a = new a();

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0354a implements uk.c<hg.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0354a f32572a = new C0354a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32573b = uk.b.a("window").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32574c = uk.b.a("logSourceMetrics").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f32575d = uk.b.a("globalMetrics").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f32576e = uk.b.a("appNamespace").b(com.google.firebase.encoders.proto.a.b().c(4).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(hg.a aVar, uk.d dVar) throws IOException {
            dVar.a(f32573b, aVar.d());
            dVar.a(f32574c, aVar.c());
            dVar.a(f32575d, aVar.b());
            dVar.a(f32576e, aVar.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements uk.c<hg.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32577a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32578b = uk.b.a("storageMetrics").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(hg.b bVar, uk.d dVar) throws IOException {
            dVar.a(f32578b, bVar.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements uk.c<LogEventDropped> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32579a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32580b = uk.b.a("eventsDroppedCount").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32581c = uk.b.a("reason").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEventDropped logEventDropped, uk.d dVar) throws IOException {
            dVar.f(f32580b, logEventDropped.a());
            dVar.a(f32581c, logEventDropped.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements uk.c<hg.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32582a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32583b = uk.b.a("logSource").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32584c = uk.b.a("logEventDropped").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(hg.c cVar, uk.d dVar) throws IOException {
            dVar.a(f32583b, cVar.b());
            dVar.a(f32584c, cVar.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements uk.c<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32585a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32586b = uk.b.d("clientMetrics");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, uk.d dVar) throws IOException {
            dVar.a(f32586b, mVar.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements uk.c<hg.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f32587a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32588b = uk.b.a("currentCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32589c = uk.b.a("maxCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(hg.d dVar, uk.d dVar2) throws IOException {
            dVar2.f(f32588b, dVar.a());
            dVar2.f(f32589c, dVar.b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements uk.c<hg.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f32590a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f32591b = uk.b.a("startMs").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f32592c = uk.b.a("endMs").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(hg.e eVar, uk.d dVar) throws IOException {
            dVar.f(f32591b, eVar.b());
            dVar.f(f32592c, eVar.a());
        }
    }

    @Override // vk.a
    public void a(vk.b<?> bVar) {
        bVar.a(m.class, e.f32585a);
        bVar.a(hg.a.class, C0354a.f32572a);
        bVar.a(hg.e.class, g.f32590a);
        bVar.a(hg.c.class, d.f32582a);
        bVar.a(LogEventDropped.class, c.f32579a);
        bVar.a(hg.b.class, b.f32577a);
        bVar.a(hg.d.class, f.f32587a);
    }
}
