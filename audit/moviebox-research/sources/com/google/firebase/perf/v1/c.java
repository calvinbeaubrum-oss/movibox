package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.h0;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends GeneratedMessageLite<c, b> implements o0 {
    public static final int ANDROID_APP_INFO_FIELD_NUMBER = 3;
    public static final int APPLICATION_PROCESS_STATE_FIELD_NUMBER = 5;
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 6;
    private static final c DEFAULT_INSTANCE;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile v0<c> PARSER;
    private com.google.firebase.perf.v1.a androidAppInfo_;
    private int applicationProcessState_;
    private int bitField0_;
    private MapFieldLite<String, String> customAttributes_ = MapFieldLite.emptyMapField();
    private String googleAppId_ = "";
    private String appInstanceId_ = "";

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41049a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41049a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41049a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41049a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41049a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41049a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41049a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41049a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends GeneratedMessageLite.a<c, b> implements o0 {
        public b() {
            super(c.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public boolean K() {
            return ((c) this.f41174b).a0();
        }

        public b L(Map<String, String> map) {
            C();
            ((c) this.f41174b).Y().putAll(map);
            return this;
        }

        public b M(com.google.firebase.perf.v1.a.b bVar) {
            C();
            ((c) this.f41174b).f0(bVar.build());
            return this;
        }

        public b N(String str) {
            C();
            ((c) this.f41174b).g0(str);
            return this;
        }

        public b O(ApplicationProcessState applicationProcessState) {
            C();
            ((c) this.f41174b).h0(applicationProcessState);
            return this;
        }

        public b P(String str) {
            C();
            ((c) this.f41174b).i0(str);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.perf.v1.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0452c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0<String, String> f41050a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f41050a = h0.d(fieldType, "", fieldType, "");
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.O(c.class, cVar);
    }

    public static c X() {
        return DEFAULT_INSTANCE;
    }

    public static b e0() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f41049a[methodToInvoke.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0001\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0005ဌ\u0003\u00062", new Object[]{"bitField0_", "googleAppId_", "appInstanceId_", "androidAppInfo_", "applicationProcessState_", ApplicationProcessState.internalGetVerifier(), "customAttributes_", C0452c.f41050a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<c> bVar = PARSER;
                if (bVar == null) {
                    synchronized (c.class) {
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

    public com.google.firebase.perf.v1.a W() {
        com.google.firebase.perf.v1.a aVar = this.androidAppInfo_;
        return aVar == null ? com.google.firebase.perf.v1.a.U() : aVar;
    }

    public final Map<String, String> Y() {
        return d0();
    }

    public boolean Z() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean a0() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean b0() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean c0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final MapFieldLite<String, String> d0() {
        if (!this.customAttributes_.isMutable()) {
            this.customAttributes_ = this.customAttributes_.mutableCopy();
        }
        return this.customAttributes_;
    }

    public final void f0(com.google.firebase.perf.v1.a aVar) {
        aVar.getClass();
        this.androidAppInfo_ = aVar;
        this.bitField0_ |= 4;
    }

    public final void g0(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.appInstanceId_ = str;
    }

    public final void h0(ApplicationProcessState applicationProcessState) {
        this.applicationProcessState_ = applicationProcessState.getNumber();
        this.bitField0_ |= 8;
    }

    public final void i0(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.googleAppId_ = str;
    }
}
