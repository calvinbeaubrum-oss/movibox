package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.h0;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i extends GeneratedMessageLite<i, b> implements o0 {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    private static final i DEFAULT_INSTANCE;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile v0<i> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    private int bitField0_;
    private long clientStartTimeUs_;
    private long durationUs_;
    private boolean isAuto_;
    private MapFieldLite<String, Long> counters_ = MapFieldLite.emptyMapField();
    private MapFieldLite<String, String> customAttributes_ = MapFieldLite.emptyMapField();
    private String name_ = "";
    private y.j<i> subtraces_ = GeneratedMessageLite.D();
    private y.j<h> perfSessions_ = GeneratedMessageLite.D();

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41056a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41056a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41056a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41056a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41056a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41056a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41056a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41056a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends GeneratedMessageLite.a<i, b> implements o0 {
        public b() {
            super(i.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b K(Iterable<? extends h> iterable) {
            C();
            ((i) this.f41174b).a0(iterable);
            return this;
        }

        public b L(Iterable<? extends i> iterable) {
            C();
            ((i) this.f41174b).b0(iterable);
            return this;
        }

        public b M(h hVar) {
            C();
            ((i) this.f41174b).c0(hVar);
            return this;
        }

        public b N(i iVar) {
            C();
            ((i) this.f41174b).d0(iVar);
            return this;
        }

        public b O(Map<String, Long> map) {
            C();
            ((i) this.f41174b).m0().putAll(map);
            return this;
        }

        public b P(Map<String, String> map) {
            C();
            ((i) this.f41174b).n0().putAll(map);
            return this;
        }

        public b Q(String str, long j11) {
            str.getClass();
            C();
            ((i) this.f41174b).m0().put(str, Long.valueOf(j11));
            return this;
        }

        public b R(long j11) {
            C();
            ((i) this.f41174b).x0(j11);
            return this;
        }

        public b S(long j11) {
            C();
            ((i) this.f41174b).y0(j11);
            return this;
        }

        public b T(String str) {
            C();
            ((i) this.f41174b).z0(str);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0<String, Long> f41057a = h0.d(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0<String, String> f41058a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f41058a = h0.d(fieldType, "", fieldType, "");
        }
    }

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        GeneratedMessageLite.O(i.class, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(Iterable<? extends h> iterable) {
        f0();
        com.google.protobuf.a.e(iterable, this.perfSessions_);
    }

    private void f0() {
        y.j<h> jVar = this.perfSessions_;
        if (jVar.m()) {
            return;
        }
        this.perfSessions_ = GeneratedMessageLite.K(jVar);
    }

    public static i k0() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> n0() {
        return v0();
    }

    private MapFieldLite<String, String> v0() {
        if (!this.customAttributes_.isMutable()) {
            this.customAttributes_ = this.customAttributes_.mutableCopy();
        }
        return this.customAttributes_;
    }

    public static b w0() {
        return DEFAULT_INSTANCE.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(long j11) {
        this.bitField0_ |= 4;
        this.clientStartTimeUs_ = j11;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f41056a[methodToInvoke.ordinal()]) {
            case 1:
                return new i();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"bitField0_", "name_", "isAuto_", "clientStartTimeUs_", "durationUs_", "counters_", c.f41057a, "subtraces_", i.class, "customAttributes_", d.f41058a, "perfSessions_", h.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<i> bVar = PARSER;
                if (bVar == null) {
                    synchronized (i.class) {
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

    public final void b0(Iterable<? extends i> iterable) {
        g0();
        com.google.protobuf.a.e(iterable, this.subtraces_);
    }

    public final void c0(h hVar) {
        hVar.getClass();
        f0();
        this.perfSessions_.add(hVar);
    }

    public final void d0(i iVar) {
        iVar.getClass();
        g0();
        this.subtraces_.add(iVar);
    }

    public boolean e0(String str) {
        str.getClass();
        return t0().containsKey(str);
    }

    public final void g0() {
        y.j<i> jVar = this.subtraces_;
        if (jVar.m()) {
            return;
        }
        this.subtraces_ = GeneratedMessageLite.K(jVar);
    }

    public int h0() {
        return s0().size();
    }

    public Map<String, Long> i0() {
        return Collections.unmodifiableMap(s0());
    }

    public Map<String, String> j0() {
        return Collections.unmodifiableMap(t0());
    }

    public long l0() {
        return this.durationUs_;
    }

    public final Map<String, Long> m0() {
        return u0();
    }

    public String o0() {
        return this.name_;
    }

    public List<h> p0() {
        return this.perfSessions_;
    }

    public List<i> q0() {
        return this.subtraces_;
    }

    public boolean r0() {
        return (this.bitField0_ & 4) != 0;
    }

    public final MapFieldLite<String, Long> s0() {
        return this.counters_;
    }

    public final MapFieldLite<String, String> t0() {
        return this.customAttributes_;
    }

    public final MapFieldLite<String, Long> u0() {
        if (!this.counters_.isMutable()) {
            this.counters_ = this.counters_.mutableCopy();
        }
        return this.counters_;
    }

    public final void y0(long j11) {
        this.bitField0_ |= 8;
        this.durationUs_ = j11;
    }

    public final void z0(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }
}
