package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends GeneratedMessageLite<g, b> implements wl.a {
    public static final int APPLICATION_INFO_FIELD_NUMBER = 1;
    private static final g DEFAULT_INSTANCE;
    public static final int GAUGE_METRIC_FIELD_NUMBER = 4;
    public static final int NETWORK_REQUEST_METRIC_FIELD_NUMBER = 3;
    private static volatile v0<g> PARSER = null;
    public static final int TRACE_METRIC_FIELD_NUMBER = 2;
    public static final int TRANSPORT_INFO_FIELD_NUMBER = 5;
    private c applicationInfo_;
    private int bitField0_;
    private f gaugeMetric_;
    private NetworkRequestMetric networkRequestMetric_;
    private i traceMetric_;
    private TransportInfo transportInfo_;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41054a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41054a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41054a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41054a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41054a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41054a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41054a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41054a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends GeneratedMessageLite.a<g, b> implements wl.a {
        public b() {
            super(g.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b K(c.b bVar) {
            C();
            ((g) this.f41174b).Y(bVar.build());
            return this;
        }

        public b L(f fVar) {
            C();
            ((g) this.f41174b).Z(fVar);
            return this;
        }

        public b M(NetworkRequestMetric networkRequestMetric) {
            C();
            ((g) this.f41174b).a0(networkRequestMetric);
            return this;
        }

        public b N(i iVar) {
            C();
            ((g) this.f41174b).b0(iVar);
            return this;
        }

        @Override // wl.a
        public boolean a() {
            return ((g) this.f41174b).a();
        }

        @Override // wl.a
        public boolean d() {
            return ((g) this.f41174b).d();
        }

        @Override // wl.a
        public NetworkRequestMetric f() {
            return ((g) this.f41174b).f();
        }

        @Override // wl.a
        public boolean m() {
            return ((g) this.f41174b).m();
        }

        @Override // wl.a
        public i n() {
            return ((g) this.f41174b).n();
        }

        @Override // wl.a
        public f o() {
            return ((g) this.f41174b).o();
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        GeneratedMessageLite.O(g.class, gVar);
    }

    public static b X() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f41054a[methodToInvoke.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"bitField0_", "applicationInfo_", "traceMetric_", "networkRequestMetric_", "gaugeMetric_", "transportInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<g> bVar = PARSER;
                if (bVar == null) {
                    synchronized (g.class) {
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

    public c V() {
        c cVar = this.applicationInfo_;
        return cVar == null ? c.X() : cVar;
    }

    public boolean W() {
        return (this.bitField0_ & 1) != 0;
    }

    public final void Y(c cVar) {
        cVar.getClass();
        this.applicationInfo_ = cVar;
        this.bitField0_ |= 1;
    }

    public final void Z(f fVar) {
        fVar.getClass();
        this.gaugeMetric_ = fVar;
        this.bitField0_ |= 8;
    }

    @Override // wl.a
    public boolean a() {
        return (this.bitField0_ & 8) != 0;
    }

    public final void a0(NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.getClass();
        this.networkRequestMetric_ = networkRequestMetric;
        this.bitField0_ |= 4;
    }

    public final void b0(i iVar) {
        iVar.getClass();
        this.traceMetric_ = iVar;
        this.bitField0_ |= 2;
    }

    @Override // wl.a
    public boolean d() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // wl.a
    public NetworkRequestMetric f() {
        NetworkRequestMetric networkRequestMetric = this.networkRequestMetric_;
        return networkRequestMetric == null ? NetworkRequestMetric.i0() : networkRequestMetric;
    }

    @Override // wl.a
    public boolean m() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // wl.a
    public i n() {
        i iVar = this.traceMetric_;
        return iVar == null ? i.k0() : iVar;
    }

    @Override // wl.a
    public f o() {
        f fVar = this.gaugeMetric_;
        return fVar == null ? f.b0() : fVar;
    }
}
