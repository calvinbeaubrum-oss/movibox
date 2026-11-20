package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.hisavana.common.tracking.TrackingKey;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements vk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vk.a f40793a = new a();

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0449a implements uk.c<MessagingClientEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0449a f40794a = new C0449a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40795b = uk.b.a("projectNumber").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final uk.b f40796c = uk.b.a("messageId").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.b f40797d = uk.b.a("instanceId").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final uk.b f40798e = uk.b.a("messageType").b(com.google.firebase.encoders.proto.a.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final uk.b f40799f = uk.b.a("sdkPlatform").b(com.google.firebase.encoders.proto.a.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final uk.b f40800g = uk.b.a("packageName").b(com.google.firebase.encoders.proto.a.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final uk.b f40801h = uk.b.a("collapseKey").b(com.google.firebase.encoders.proto.a.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final uk.b f40802i = uk.b.a(TrackingKey.PRIORITY).b(com.google.firebase.encoders.proto.a.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final uk.b f40803j = uk.b.a("ttl").b(com.google.firebase.encoders.proto.a.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final uk.b f40804k = uk.b.a("topic").b(com.google.firebase.encoders.proto.a.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final uk.b f40805l = uk.b.a("bulkId").b(com.google.firebase.encoders.proto.a.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final uk.b f40806m = uk.b.a(NotificationCompat.CATEGORY_EVENT).b(com.google.firebase.encoders.proto.a.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final uk.b f40807n = uk.b.a("analyticsLabel").b(com.google.firebase.encoders.proto.a.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final uk.b f40808o = uk.b.a("campaignId").b(com.google.firebase.encoders.proto.a.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final uk.b f40809p = uk.b.a("composerLabel").b(com.google.firebase.encoders.proto.a.b().c(15).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MessagingClientEvent messagingClientEvent, uk.d dVar) throws IOException {
            dVar.f(f40795b, messagingClientEvent.l());
            dVar.a(f40796c, messagingClientEvent.h());
            dVar.a(f40797d, messagingClientEvent.g());
            dVar.a(f40798e, messagingClientEvent.i());
            dVar.a(f40799f, messagingClientEvent.m());
            dVar.a(f40800g, messagingClientEvent.j());
            dVar.a(f40801h, messagingClientEvent.d());
            dVar.e(f40802i, messagingClientEvent.k());
            dVar.e(f40803j, messagingClientEvent.o());
            dVar.a(f40804k, messagingClientEvent.n());
            dVar.f(f40805l, messagingClientEvent.b());
            dVar.a(f40806m, messagingClientEvent.f());
            dVar.a(f40807n, messagingClientEvent.a());
            dVar.f(f40808o, messagingClientEvent.c());
            dVar.a(f40809p, messagingClientEvent.e());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements uk.c<jl.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f40810a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40811b = uk.b.a("messagingClientEvent").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(jl.a aVar, uk.d dVar) throws IOException {
            dVar.a(f40811b, aVar.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements uk.c<h0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f40812a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final uk.b f40813b = uk.b.d("messagingClientEventExtension");

        @Override // uk.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h0 h0Var, uk.d dVar) throws IOException {
            dVar.a(f40813b, h0Var.b());
        }
    }

    @Override // vk.a
    public void a(vk.b<?> bVar) {
        bVar.a(h0.class, c.f40812a);
        bVar.a(jl.a.class, b.f40810a);
        bVar.a(MessagingClientEvent.class, C0449a.f40794a);
    }
}
