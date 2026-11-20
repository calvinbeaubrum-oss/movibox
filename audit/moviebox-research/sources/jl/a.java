package jl;

import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.h0;
import com.google.firebase.messaging.reporting.MessagingClientEvent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f68080b = new C0731a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessagingClientEvent f68081a;

    /* JADX INFO: renamed from: jl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0731a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MessagingClientEvent f68082a = null;

        public a a() {
            return new a(this.f68082a);
        }

        public C0731a b(MessagingClientEvent messagingClientEvent) {
            this.f68082a = messagingClientEvent;
            return this;
        }
    }

    public a(MessagingClientEvent messagingClientEvent) {
        this.f68081a = messagingClientEvent;
    }

    public static C0731a b() {
        return new C0731a();
    }

    @Protobuf(tag = 1)
    public MessagingClientEvent a() {
        return this.f68081a;
    }

    public byte[] c() {
        return h0.a(this);
    }
}
