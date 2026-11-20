package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;
import xk.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LogEventDropped {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LogEventDropped f32640c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reason f32642b;

    /* JADX INFO: compiled from: source.java */
    public enum Reason implements b {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;

        Reason(int i11) {
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
        public long f32643a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Reason f32644b = Reason.REASON_UNKNOWN;

        public LogEventDropped a() {
            return new LogEventDropped(this.f32643a, this.f32644b);
        }

        public a b(long j11) {
            this.f32643a = j11;
            return this;
        }

        public a c(Reason reason) {
            this.f32644b = reason;
            return this;
        }
    }

    public LogEventDropped(long j11, Reason reason) {
        this.f32641a = j11;
        this.f32642b = reason;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f32641a;
    }

    @Protobuf(tag = 3)
    public Reason b() {
        return this.f32642b;
    }
}
