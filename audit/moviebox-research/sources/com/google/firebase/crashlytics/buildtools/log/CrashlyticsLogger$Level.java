package com.google.firebase.crashlytics.buildtools.log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum CrashlyticsLogger$Level {
    ERROR(0),
    WARNING(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4);

    private final int value;

    CrashlyticsLogger$Level(int i11) {
        this.value = i11;
    }

    public boolean logsFor(CrashlyticsLogger$Level crashlyticsLogger$Level) {
        return this.value >= crashlyticsLogger$Level.value;
    }
}
