package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.o0;
import com.google.protobuf.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends GeneratedMessageLite<a, b> implements o0 {
    private static final a DEFAULT_INSTANCE;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
    private static volatile v0<a> PARSER = null;
    public static final int SDK_VERSION_FIELD_NUMBER = 2;
    public static final int VERSION_NAME_FIELD_NUMBER = 3;
    private int bitField0_;
    private String packageName_ = "";
    private String sdkVersion_ = "";
    private String versionName_ = "";

    /* JADX INFO: renamed from: com.google.firebase.perf.v1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0450a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41047a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41047a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41047a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41047a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41047a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41047a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41047a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41047a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends GeneratedMessageLite.a<a, b> implements o0 {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(C0450a c0450a) {
            this();
        }

        public b K(String str) {
            C();
            ((a) this.f41174b).Y(str);
            return this;
        }

        public b L(String str) {
            C();
            ((a) this.f41174b).Z(str);
            return this;
        }

        public b M(String str) {
            C();
            ((a) this.f41174b).a0(str);
            return this;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        GeneratedMessageLite.O(a.class, aVar);
    }

    public static a U() {
        return DEFAULT_INSTANCE;
    }

    public static b X() {
        return DEFAULT_INSTANCE.y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        C0450a c0450a = null;
        switch (C0450a.f41047a[methodToInvoke.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return new b(c0450a);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "packageName_", "sdkVersion_", "versionName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<a> bVar = PARSER;
                if (bVar == null) {
                    synchronized (a.class) {
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

    public boolean V() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean W() {
        return (this.bitField0_ & 2) != 0;
    }

    public final void Y(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.packageName_ = str;
    }

    public final void Z(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.sdkVersion_ = str;
    }

    public final void a0(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.versionName_ = str;
    }
}
