package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.o0;
import com.google.protobuf.v0;
import com.google.protobuf.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class TransportInfo extends GeneratedMessageLite<TransportInfo, b> implements o0 {
    private static final TransportInfo DEFAULT_INSTANCE;
    public static final int DISPATCH_DESTINATION_FIELD_NUMBER = 1;
    private static volatile v0<TransportInfo> PARSER;
    private int bitField0_;
    private int dispatchDestination_;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public enum DispatchDestination implements y.c {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);

        public static final int FL_LEGACY_V1_VALUE = 1;
        public static final int SOURCE_UNKNOWN_VALUE = 0;
        private static final y.d<DispatchDestination> internalValueMap = new a();
        private final int value;

        /* JADX INFO: compiled from: source.java */
        public class a implements y.d<DispatchDestination> {
            @Override // com.google.protobuf.y.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public DispatchDestination a(int i11) {
                return DispatchDestination.forNumber(i11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b implements y.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final y.e f41045a = new b();

            @Override // com.google.protobuf.y.e
            public boolean a(int i11) {
                return DispatchDestination.forNumber(i11) != null;
            }
        }

        DispatchDestination(int i11) {
            this.value = i11;
        }

        public static DispatchDestination forNumber(int i11) {
            if (i11 == 0) {
                return SOURCE_UNKNOWN;
            }
            if (i11 != 1) {
                return null;
            }
            return FL_LEGACY_V1;
        }

        public static y.d<DispatchDestination> internalGetValueMap() {
            return internalValueMap;
        }

        public static y.e internalGetVerifier() {
            return b.f41045a;
        }

        @Deprecated
        public static DispatchDestination valueOf(int i11) {
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
        public static final /* synthetic */ int[] f41046a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f41046a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41046a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41046a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41046a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41046a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41046a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41046a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class b extends GeneratedMessageLite.a<TransportInfo, b> implements o0 {
        public b() {
            super(TransportInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        TransportInfo transportInfo = new TransportInfo();
        DEFAULT_INSTANCE = transportInfo;
        GeneratedMessageLite.O(TransportInfo.class, transportInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object B(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f41046a[methodToInvoke.ordinal()]) {
            case 1:
                return new TransportInfo();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.M(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"bitField0_", "dispatchDestination_", DispatchDestination.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                v0<TransportInfo> bVar = PARSER;
                if (bVar == null) {
                    synchronized (TransportInfo.class) {
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
}
