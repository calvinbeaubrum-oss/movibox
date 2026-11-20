package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum DescriptorProtos$FieldOptions$CType implements y.c {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);

    public static final int CORD_VALUE = 1;
    public static final int STRING_PIECE_VALUE = 2;
    public static final int STRING_VALUE = 0;
    private static final y.d<DescriptorProtos$FieldOptions$CType> internalValueMap = new y.d<DescriptorProtos$FieldOptions$CType>() { // from class: com.google.protobuf.DescriptorProtos$FieldOptions$CType.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos$FieldOptions$CType a(int i11) {
            return DescriptorProtos$FieldOptions$CType.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41164a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return DescriptorProtos$FieldOptions$CType.forNumber(i11) != null;
        }
    }

    DescriptorProtos$FieldOptions$CType(int i11) {
        this.value = i11;
    }

    public static DescriptorProtos$FieldOptions$CType forNumber(int i11) {
        if (i11 == 0) {
            return STRING;
        }
        if (i11 == 1) {
            return CORD;
        }
        if (i11 != 2) {
            return null;
        }
        return STRING_PIECE;
    }

    public static y.d<DescriptorProtos$FieldOptions$CType> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41164a;
    }

    @Deprecated
    public static DescriptorProtos$FieldOptions$CType valueOf(int i11) {
        return forNumber(i11);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
