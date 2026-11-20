package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum Syntax implements y.c {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);

    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final y.d<Syntax> internalValueMap = new y.d<Syntax>() { // from class: com.google.protobuf.Syntax.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Syntax a(int i11) {
            return Syntax.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41200a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return Syntax.forNumber(i11) != null;
        }
    }

    Syntax(int i11) {
        this.value = i11;
    }

    public static Syntax forNumber(int i11) {
        if (i11 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i11 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static y.d<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41200a;
    }

    @Deprecated
    public static Syntax valueOf(int i11) {
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
