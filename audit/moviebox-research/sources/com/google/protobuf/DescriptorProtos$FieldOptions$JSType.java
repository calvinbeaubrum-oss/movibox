package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum DescriptorProtos$FieldOptions$JSType implements y.c {
    JS_NORMAL(0),
    JS_STRING(1),
    JS_NUMBER(2);

    public static final int JS_NORMAL_VALUE = 0;
    public static final int JS_NUMBER_VALUE = 2;
    public static final int JS_STRING_VALUE = 1;
    private static final y.d<DescriptorProtos$FieldOptions$JSType> internalValueMap = new y.d<DescriptorProtos$FieldOptions$JSType>() { // from class: com.google.protobuf.DescriptorProtos$FieldOptions$JSType.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DescriptorProtos$FieldOptions$JSType a(int i11) {
            return DescriptorProtos$FieldOptions$JSType.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41165a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return DescriptorProtos$FieldOptions$JSType.forNumber(i11) != null;
        }
    }

    DescriptorProtos$FieldOptions$JSType(int i11) {
        this.value = i11;
    }

    public static DescriptorProtos$FieldOptions$JSType forNumber(int i11) {
        if (i11 == 0) {
            return JS_NORMAL;
        }
        if (i11 == 1) {
            return JS_STRING;
        }
        if (i11 != 2) {
            return null;
        }
        return JS_NUMBER;
    }

    public static y.d<DescriptorProtos$FieldOptions$JSType> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41165a;
    }

    @Deprecated
    public static DescriptorProtos$FieldOptions$JSType valueOf(int i11) {
        return forNumber(i11);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
