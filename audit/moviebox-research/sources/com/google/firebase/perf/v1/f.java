package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f extends GeneratedMessageLite<f, b> implements o0 {
    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    private static final f DEFAULT_INSTANCE;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    private static volatile v0<f> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private e gaugeMetadata_;
    private String sessionId_ = "";
    private y.j<d> cpuMetricReadings_ = GeneratedMessageLite.D();
    private y.j<com.google.firebase.perf.v1.b> androidMemoryReadings_ = GeneratedMessageLite.D();

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41053a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41053a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41053a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41053a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41053a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41053a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41053a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41053a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends GeneratedMessageLite.a<f, b> implements o0 {
        public b() {
            super(f.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b K(com.google.firebase.perf.v1.b bVar) {
            C();
            ((f) this.f41174b).V(bVar);
            return this;
        }

        public b L(d dVar) {
            C();
            ((f) this.f41174b).W(dVar);
            return this;
        }

        public b M(e eVar) {
            C();
            ((f) this.f41174b).g0(eVar);
            return this;
        }

        public b N(String str) {
            C();
            ((f) this.f41174b).h0(str);
            return this;
        }
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.O(f.class, fVar);
    }

    public static f b0() {
        return DEFAULT_INSTANCE;
    }

    public static b f0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f41053a[methodToInvoke.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b", new Object[]{"bitField0_", "sessionId_", "cpuMetricReadings_", d.class, "gaugeMetadata_", "androidMemoryReadings_", com.google.firebase.perf.v1.b.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<f> bVar = PARSER;
                if (bVar == null) {
                    synchronized (f.class) {
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

    public final void V(com.google.firebase.perf.v1.b bVar) {
        bVar.getClass();
        X();
        this.androidMemoryReadings_.add(bVar);
    }

    public final void W(d dVar) {
        dVar.getClass();
        Y();
        this.cpuMetricReadings_.add(dVar);
    }

    public final void X() {
        y.j<com.google.firebase.perf.v1.b> jVar = this.androidMemoryReadings_;
        if (jVar.m()) {
            return;
        }
        this.androidMemoryReadings_ = GeneratedMessageLite.K(jVar);
    }

    public final void Y() {
        y.j<d> jVar = this.cpuMetricReadings_;
        if (jVar.m()) {
            return;
        }
        this.cpuMetricReadings_ = GeneratedMessageLite.K(jVar);
    }

    public int Z() {
        return this.androidMemoryReadings_.size();
    }

    public int a0() {
        return this.cpuMetricReadings_.size();
    }

    public e c0() {
        e eVar = this.gaugeMetadata_;
        return eVar == null ? e.U() : eVar;
    }

    public boolean d0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean e0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final void g0(e eVar) {
        eVar.getClass();
        this.gaugeMetadata_ = eVar;
        this.bitField0_ |= 2;
    }

    public final void h0(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }
}
