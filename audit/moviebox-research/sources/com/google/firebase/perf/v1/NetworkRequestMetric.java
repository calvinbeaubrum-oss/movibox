package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.h0;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkRequestMetric extends GeneratedMessageLite<NetworkRequestMetric, b> implements o0 {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 7;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 12;
    private static final NetworkRequestMetric DEFAULT_INSTANCE;
    public static final int HTTP_METHOD_FIELD_NUMBER = 2;
    public static final int HTTP_RESPONSE_CODE_FIELD_NUMBER = 5;
    public static final int NETWORK_CLIENT_ERROR_REASON_FIELD_NUMBER = 11;
    private static volatile v0<NetworkRequestMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 13;
    public static final int REQUEST_PAYLOAD_BYTES_FIELD_NUMBER = 3;
    public static final int RESPONSE_CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int RESPONSE_PAYLOAD_BYTES_FIELD_NUMBER = 4;
    public static final int TIME_TO_REQUEST_COMPLETED_US_FIELD_NUMBER = 8;
    public static final int TIME_TO_RESPONSE_COMPLETED_US_FIELD_NUMBER = 10;
    public static final int TIME_TO_RESPONSE_INITIATED_US_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private long clientStartTimeUs_;
    private int httpMethod_;
    private int httpResponseCode_;
    private int networkClientErrorReason_;
    private long requestPayloadBytes_;
    private long responsePayloadBytes_;
    private long timeToRequestCompletedUs_;
    private long timeToResponseCompletedUs_;
    private long timeToResponseInitiatedUs_;
    private MapFieldLite<String, String> customAttributes_ = MapFieldLite.emptyMapField();
    private String url_ = "";
    private String responseContentType_ = "";
    private y.j<h> perfSessions_ = GeneratedMessageLite.D();

    /* JADX INFO: compiled from: source.java */
    public enum HttpMethod implements y.c {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);

        public static final int CONNECT_VALUE = 9;
        public static final int DELETE_VALUE = 4;
        public static final int GET_VALUE = 1;
        public static final int HEAD_VALUE = 5;
        public static final int HTTP_METHOD_UNKNOWN_VALUE = 0;
        public static final int OPTIONS_VALUE = 7;
        public static final int PATCH_VALUE = 6;
        public static final int POST_VALUE = 3;
        public static final int PUT_VALUE = 2;
        public static final int TRACE_VALUE = 8;
        private static final y.d<HttpMethod> internalValueMap = new a();
        private final int value;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes6.dex */
        public class a implements y.d<HttpMethod> {
            @Override // com.google.protobuf.y.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public HttpMethod a(int i11) {
                return HttpMethod.forNumber(i11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes6.dex */
        public static final class b implements y.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final y.e f41040a = new b();

            @Override // com.google.protobuf.y.e
            public boolean a(int i11) {
                return HttpMethod.forNumber(i11) != null;
            }
        }

        HttpMethod(int i11) {
            this.value = i11;
        }

        public static HttpMethod forNumber(int i11) {
            switch (i11) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static y.d<HttpMethod> internalGetValueMap() {
            return internalValueMap;
        }

        public static y.e internalGetVerifier() {
            return b.f41040a;
        }

        @Deprecated
        public static HttpMethod valueOf(int i11) {
            return forNumber(i11);
        }

        @Override // com.google.protobuf.y.c
        public final int getNumber() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum NetworkClientErrorReason implements y.c {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);

        public static final int GENERIC_CLIENT_ERROR_VALUE = 1;
        public static final int NETWORK_CLIENT_ERROR_REASON_UNKNOWN_VALUE = 0;
        private static final y.d<NetworkClientErrorReason> internalValueMap = new a();
        private final int value;

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes6.dex */
        public class a implements y.d<NetworkClientErrorReason> {
            @Override // com.google.protobuf.y.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public NetworkClientErrorReason a(int i11) {
                return NetworkClientErrorReason.forNumber(i11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes6.dex */
        public static final class b implements y.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final y.e f41041a = new b();

            @Override // com.google.protobuf.y.e
            public boolean a(int i11) {
                return NetworkClientErrorReason.forNumber(i11) != null;
            }
        }

        NetworkClientErrorReason(int i11) {
            this.value = i11;
        }

        public static NetworkClientErrorReason forNumber(int i11) {
            if (i11 == 0) {
                return NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
            }
            if (i11 != 1) {
                return null;
            }
            return GENERIC_CLIENT_ERROR;
        }

        public static y.d<NetworkClientErrorReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static y.e internalGetVerifier() {
            return b.f41041a;
        }

        @Deprecated
        public static NetworkClientErrorReason valueOf(int i11) {
            return forNumber(i11);
        }

        @Override // com.google.protobuf.y.c
        public final int getNumber() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41042a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41042a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41042a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41042a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41042a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41042a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41042a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41042a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class b extends GeneratedMessageLite.a<NetworkRequestMetric, b> implements o0 {
        public b() {
            super(NetworkRequestMetric.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b K(Iterable<? extends h> iterable) {
            C();
            ((NetworkRequestMetric) this.f41174b).e0(iterable);
            return this;
        }

        public b L() {
            C();
            ((NetworkRequestMetric) this.f41174b).f0();
            return this;
        }

        public long M() {
            return ((NetworkRequestMetric) this.f41174b).r0();
        }

        public boolean N() {
            return ((NetworkRequestMetric) this.f41174b).t0();
        }

        public boolean O() {
            return ((NetworkRequestMetric) this.f41174b).v0();
        }

        public boolean P() {
            return ((NetworkRequestMetric) this.f41174b).z0();
        }

        public b Q(long j11) {
            C();
            ((NetworkRequestMetric) this.f41174b).C0(j11);
            return this;
        }

        public b R(HttpMethod httpMethod) {
            C();
            ((NetworkRequestMetric) this.f41174b).D0(httpMethod);
            return this;
        }

        public b S(int i11) {
            C();
            ((NetworkRequestMetric) this.f41174b).E0(i11);
            return this;
        }

        public b T(NetworkClientErrorReason networkClientErrorReason) {
            C();
            ((NetworkRequestMetric) this.f41174b).F0(networkClientErrorReason);
            return this;
        }

        public b U(long j11) {
            C();
            ((NetworkRequestMetric) this.f41174b).G0(j11);
            return this;
        }

        public b V(String str) {
            C();
            ((NetworkRequestMetric) this.f41174b).H0(str);
            return this;
        }

        public b W(long j11) {
            C();
            ((NetworkRequestMetric) this.f41174b).I0(j11);
            return this;
        }

        public b X(long j11) {
            C();
            ((NetworkRequestMetric) this.f41174b).J0(j11);
            return this;
        }

        public b Y(long j11) {
            C();
            ((NetworkRequestMetric) this.f41174b).K0(j11);
            return this;
        }

        public b Z(long j11) {
            C();
            ((NetworkRequestMetric) this.f41174b).L0(j11);
            return this;
        }

        public b a0(String str) {
            C();
            ((NetworkRequestMetric) this.f41174b).M0(str);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0<String, String> f41043a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f41043a = h0.d(fieldType, "", fieldType, "");
        }
    }

    static {
        NetworkRequestMetric networkRequestMetric = new NetworkRequestMetric();
        DEFAULT_INSTANCE = networkRequestMetric;
        GeneratedMessageLite.O(NetworkRequestMetric.class, networkRequestMetric);
    }

    public static b B0() {
        return DEFAULT_INSTANCE.y();
    }

    public static NetworkRequestMetric i0() {
        return DEFAULT_INSTANCE;
    }

    public boolean A0() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f41042a[methodToInvoke.ordinal()]) {
            case 1:
                return new NetworkRequestMetric();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006ဈ\u0006\u0007ဂ\u0007\bဂ\b\tဂ\t\nဂ\n\u000bဌ\u0004\f2\r\u001b", new Object[]{"bitField0_", "url_", "httpMethod_", HttpMethod.internalGetVerifier(), "requestPayloadBytes_", "responsePayloadBytes_", "httpResponseCode_", "responseContentType_", "clientStartTimeUs_", "timeToRequestCompletedUs_", "timeToResponseInitiatedUs_", "timeToResponseCompletedUs_", "networkClientErrorReason_", NetworkClientErrorReason.internalGetVerifier(), "customAttributes_", c.f41043a, "perfSessions_", h.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<NetworkRequestMetric> bVar = PARSER;
                if (bVar == null) {
                    synchronized (NetworkRequestMetric.class) {
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

    public final void C0(long j11) {
        this.bitField0_ |= 128;
        this.clientStartTimeUs_ = j11;
    }

    public final void D0(HttpMethod httpMethod) {
        this.httpMethod_ = httpMethod.getNumber();
        this.bitField0_ |= 2;
    }

    public final void E0(int i11) {
        this.bitField0_ |= 32;
        this.httpResponseCode_ = i11;
    }

    public final void F0(NetworkClientErrorReason networkClientErrorReason) {
        this.networkClientErrorReason_ = networkClientErrorReason.getNumber();
        this.bitField0_ |= 16;
    }

    public final void G0(long j11) {
        this.bitField0_ |= 4;
        this.requestPayloadBytes_ = j11;
    }

    public final void H0(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.responseContentType_ = str;
    }

    public final void I0(long j11) {
        this.bitField0_ |= 8;
        this.responsePayloadBytes_ = j11;
    }

    public final void J0(long j11) {
        this.bitField0_ |= 256;
        this.timeToRequestCompletedUs_ = j11;
    }

    public final void K0(long j11) {
        this.bitField0_ |= 1024;
        this.timeToResponseCompletedUs_ = j11;
    }

    public final void L0(long j11) {
        this.bitField0_ |= 512;
        this.timeToResponseInitiatedUs_ = j11;
    }

    public final void M0(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.url_ = str;
    }

    public final void e0(Iterable<? extends h> iterable) {
        g0();
        com.google.protobuf.a.e(iterable, this.perfSessions_);
    }

    public final void f0() {
        this.bitField0_ &= -65;
        this.responseContentType_ = i0().n0();
    }

    public final void g0() {
        y.j<h> jVar = this.perfSessions_;
        if (jVar.m()) {
            return;
        }
        this.perfSessions_ = GeneratedMessageLite.K(jVar);
    }

    public long h0() {
        return this.clientStartTimeUs_;
    }

    public HttpMethod j0() {
        HttpMethod httpMethodForNumber = HttpMethod.forNumber(this.httpMethod_);
        return httpMethodForNumber == null ? HttpMethod.HTTP_METHOD_UNKNOWN : httpMethodForNumber;
    }

    public int k0() {
        return this.httpResponseCode_;
    }

    public List<h> l0() {
        return this.perfSessions_;
    }

    public long m0() {
        return this.requestPayloadBytes_;
    }

    public String n0() {
        return this.responseContentType_;
    }

    public long o0() {
        return this.responsePayloadBytes_;
    }

    public long p0() {
        return this.timeToRequestCompletedUs_;
    }

    public long q0() {
        return this.timeToResponseCompletedUs_;
    }

    public long r0() {
        return this.timeToResponseInitiatedUs_;
    }

    public String s0() {
        return this.url_;
    }

    public boolean t0() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean u0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean v0() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean w0() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean x0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean y0() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean z0() {
        return (this.bitField0_ & 1024) != 0;
    }
}
