package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum NullValue implements y.c {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    public static final int NULL_VALUE_VALUE = 0;
    private static final y.d<NullValue> internalValueMap = new y.d<NullValue>() { // from class: com.google.protobuf.NullValue.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NullValue a(int i11) {
            return NullValue.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41186a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return NullValue.forNumber(i11) != null;
        }
    }

    NullValue(int i11) {
        this.value = i11;
    }

    public static NullValue forNumber(int i11) {
        if (i11 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static y.d<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41186a;
    }

    @Deprecated
    public static NullValue valueOf(int i11) {
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
