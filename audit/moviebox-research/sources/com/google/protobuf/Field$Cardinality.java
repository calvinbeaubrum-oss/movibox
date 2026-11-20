package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum Field$Cardinality implements y.c {
    CARDINALITY_UNKNOWN(0),
    CARDINALITY_OPTIONAL(1),
    CARDINALITY_REQUIRED(2),
    CARDINALITY_REPEATED(3),
    UNRECOGNIZED(-1);

    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    private static final y.d<Field$Cardinality> internalValueMap = new y.d<Field$Cardinality>() { // from class: com.google.protobuf.Field$Cardinality.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Field$Cardinality a(int i11) {
            return Field$Cardinality.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41168a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return Field$Cardinality.forNumber(i11) != null;
        }
    }

    Field$Cardinality(int i11) {
        this.value = i11;
    }

    public static Field$Cardinality forNumber(int i11) {
        if (i11 == 0) {
            return CARDINALITY_UNKNOWN;
        }
        if (i11 == 1) {
            return CARDINALITY_OPTIONAL;
        }
        if (i11 == 2) {
            return CARDINALITY_REQUIRED;
        }
        if (i11 != 3) {
            return null;
        }
        return CARDINALITY_REPEATED;
    }

    public static y.d<Field$Cardinality> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41168a;
    }

    @Deprecated
    public static Field$Cardinality valueOf(int i11) {
        return forNumber(i11);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
