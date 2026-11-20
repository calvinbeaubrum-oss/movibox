package com.google.firebase.perf.v1;

import com.google.protobuf.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public enum ApplicationProcessState implements y.c {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);

    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final int BACKGROUND_VALUE = 2;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final y.d<ApplicationProcessState> internalValueMap = new y.d<ApplicationProcessState>() { // from class: com.google.firebase.perf.v1.ApplicationProcessState.a
        @Override // com.google.protobuf.y.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ApplicationProcessState a(int i11) {
            return ApplicationProcessState.forNumber(i11);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static final class b implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y.e f41037a = new b();

        @Override // com.google.protobuf.y.e
        public boolean a(int i11) {
            return ApplicationProcessState.forNumber(i11) != null;
        }
    }

    ApplicationProcessState(int i11) {
        this.value = i11;
    }

    public static ApplicationProcessState forNumber(int i11) {
        if (i11 == 0) {
            return APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        if (i11 == 1) {
            return FOREGROUND;
        }
        if (i11 == 2) {
            return BACKGROUND;
        }
        if (i11 != 3) {
            return null;
        }
        return FOREGROUND_BACKGROUND;
    }

    public static y.d<ApplicationProcessState> internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.f41037a;
    }

    @Deprecated
    public static ApplicationProcessState valueOf(int i11) {
        return forNumber(i11);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
