package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.Protobuf;
import xk.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class MessagingClientEvent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final MessagingClientEvent f40886p = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageType f40890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SDKPlatform f40891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f40892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f40893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f40894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f40895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f40896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f40897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Event f40898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f40899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f40900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f40901o;

    /* JADX INFO: compiled from: source.java */
    public enum Event implements b {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);

        private final int number_;

        Event(int i11) {
            this.number_ = i11;
        }

        @Override // xk.b
        public int getNumber() {
            return this.number_;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum MessageType implements b {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);

        private final int number_;

        MessageType(int i11) {
            this.number_ = i11;
        }

        @Override // xk.b
        public int getNumber() {
            return this.number_;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum SDKPlatform implements b {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);

        private final int number_;

        SDKPlatform(int i11) {
            this.number_ = i11;
        }

        @Override // xk.b
        public int getNumber() {
            return this.number_;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f40902a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40903b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40904c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MessageType f40905d = MessageType.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public SDKPlatform f40906e = SDKPlatform.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f40907f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f40908g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f40909h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f40910i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f40911j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f40912k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Event f40913l = Event.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f40914m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f40915n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f40916o = "";

        public MessagingClientEvent a() {
            return new MessagingClientEvent(this.f40902a, this.f40903b, this.f40904c, this.f40905d, this.f40906e, this.f40907f, this.f40908g, this.f40909h, this.f40910i, this.f40911j, this.f40912k, this.f40913l, this.f40914m, this.f40915n, this.f40916o);
        }

        public a b(String str) {
            this.f40914m = str;
            return this;
        }

        public a c(String str) {
            this.f40908g = str;
            return this;
        }

        public a d(String str) {
            this.f40916o = str;
            return this;
        }

        public a e(Event event) {
            this.f40913l = event;
            return this;
        }

        public a f(String str) {
            this.f40904c = str;
            return this;
        }

        public a g(String str) {
            this.f40903b = str;
            return this;
        }

        public a h(MessageType messageType) {
            this.f40905d = messageType;
            return this;
        }

        public a i(String str) {
            this.f40907f = str;
            return this;
        }

        public a j(long j11) {
            this.f40902a = j11;
            return this;
        }

        public a k(SDKPlatform sDKPlatform) {
            this.f40906e = sDKPlatform;
            return this;
        }

        public a l(String str) {
            this.f40911j = str;
            return this;
        }

        public a m(int i11) {
            this.f40910i = i11;
            return this;
        }
    }

    public MessagingClientEvent(long j11, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i11, int i12, String str5, long j12, Event event, String str6, long j13, String str7) {
        this.f40887a = j11;
        this.f40888b = str;
        this.f40889c = str2;
        this.f40890d = messageType;
        this.f40891e = sDKPlatform;
        this.f40892f = str3;
        this.f40893g = str4;
        this.f40894h = i11;
        this.f40895i = i12;
        this.f40896j = str5;
        this.f40897k = j12;
        this.f40898l = event;
        this.f40899m = str6;
        this.f40900n = j13;
        this.f40901o = str7;
    }

    public static a p() {
        return new a();
    }

    @Protobuf(tag = 13)
    public String a() {
        return this.f40899m;
    }

    @Protobuf(tag = 11)
    public long b() {
        return this.f40897k;
    }

    @Protobuf(tag = 14)
    public long c() {
        return this.f40900n;
    }

    @Protobuf(tag = 7)
    public String d() {
        return this.f40893g;
    }

    @Protobuf(tag = 15)
    public String e() {
        return this.f40901o;
    }

    @Protobuf(tag = 12)
    public Event f() {
        return this.f40898l;
    }

    @Protobuf(tag = 3)
    public String g() {
        return this.f40889c;
    }

    @Protobuf(tag = 2)
    public String h() {
        return this.f40888b;
    }

    @Protobuf(tag = 4)
    public MessageType i() {
        return this.f40890d;
    }

    @Protobuf(tag = 6)
    public String j() {
        return this.f40892f;
    }

    @Protobuf(tag = 8)
    public int k() {
        return this.f40894h;
    }

    @Protobuf(tag = 1)
    public long l() {
        return this.f40887a;
    }

    @Protobuf(tag = 5)
    public SDKPlatform m() {
        return this.f40891e;
    }

    @Protobuf(tag = 10)
    public String n() {
        return this.f40896j;
    }

    @Protobuf(tag = 9)
    public int o() {
        return this.f40895i;
    }
}
