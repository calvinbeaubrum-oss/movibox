package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum DescriptorProtos$MethodOptions$IdempotencyLevel implements y.c {
    IDEMPOTENCY_UNKNOWN(0),
    NO_SIDE_EFFECTS(1),
    IDEMPOTENT(2);

    public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
    public static final int IDEMPOTENT_VALUE = 2;
    public static final int NO_SIDE_EFFECTS_VALUE = 1;
    private static final y.d<DescriptorProtos$MethodOptions$IdempotencyLevel> internalValueMap = new y.d<DescriptorProtos$MethodOptions$IdempotencyLevel>() { // from class: com.google.protobuf.DescriptorProtos$MethodOptions$IdempotencyLevel.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos$MethodOptions$IdempotencyLevel a(int i11) {
            return DescriptorProtos$MethodOptions$IdempotencyLevel.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41167a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return DescriptorProtos$MethodOptions$IdempotencyLevel.forNumber(i11) != null;
        }
    }

    DescriptorProtos$MethodOptions$IdempotencyLevel(int i11) {
        this.value = i11;
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel forNumber(int i11) {
        if (i11 == 0) {
            return IDEMPOTENCY_UNKNOWN;
        }
        if (i11 == 1) {
            return NO_SIDE_EFFECTS;
        }
        if (i11 != 2) {
            return null;
        }
        return IDEMPOTENT;
    }

    public static y.d<DescriptorProtos$MethodOptions$IdempotencyLevel> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41167a;
    }

    @Deprecated
    public static DescriptorProtos$MethodOptions$IdempotencyLevel valueOf(int i11) {
        return forNumber(i11);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
