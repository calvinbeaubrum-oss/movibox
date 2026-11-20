package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h extends GeneratedMessageLite<h, c> implements o0 {
    private static final h DEFAULT_INSTANCE;
    private static volatile v0<h> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SESSION_VERBOSITY_FIELD_NUMBER = 2;
    private static final y.h.a<Integer, SessionVerbosity> sessionVerbosity_converter_ = new a();
    private int bitField0_;
    private String sessionId_ = "";
    private y.g sessionVerbosity_ = GeneratedMessageLite.C();

    /* JADX INFO: compiled from: source.java */
    public class a implements y.h.a<Integer, SessionVerbosity> {
        @Override // com.google.protobuf.y.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SessionVerbosity a(Integer num) {
            SessionVerbosity sessionVerbosityForNumber = SessionVerbosity.forNumber(num.intValue());
            return sessionVerbosityForNumber == null ? SessionVerbosity.SESSION_VERBOSITY_NONE : sessionVerbosityForNumber;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41055a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41055a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41055a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41055a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41055a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41055a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41055a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41055a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends GeneratedMessageLite.a<h, c> implements o0 {
        public c() {
            super(h.DEFAULT_INSTANCE);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public c K(SessionVerbosity sessionVerbosity) {
            C();
            ((h) this.f41174b).T(sessionVerbosity);
            return this;
        }

        public c L(String str) {
            C();
            ((h) this.f41174b).Z(str);
            return this;
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        GeneratedMessageLite.O(h.class, hVar);
    }

    public static c Y() {
        return DEFAULT_INSTANCE.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (b.f41055a[methodToInvoke.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return new c(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", new Object[]{"bitField0_", "sessionId_", "sessionVerbosity_", SessionVerbosity.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<h> bVar = PARSER;
                if (bVar == null) {
                    synchronized (h.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final void T(SessionVerbosity sessionVerbosity) {
        sessionVerbosity.getClass();
        U();
        this.sessionVerbosity_.n(sessionVerbosity.getNumber());
    }

    public final void U() {
        y.g gVar = this.sessionVerbosity_;
        if (gVar.m()) {
            return;
        }
        this.sessionVerbosity_ = GeneratedMessageLite.J(gVar);
    }

    public SessionVerbosity V(int i11) {
        return sessionVerbosity_converter_.a(Integer.valueOf(this.sessionVerbosity_.getInt(i11)));
    }

    public int W() {
        return this.sessionVerbosity_.size();
    }

    public List<SessionVerbosity> X() {
        return new y.h(this.sessionVerbosity_, sessionVerbosity_converter_);
    }
}
