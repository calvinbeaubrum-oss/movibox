package com.vungle.warren.session;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum SessionAttribute {
    PLACEMENT_ID,
    TIMESTAMP,
    SUCCESS,
    EVENT_ID,
    ORIENTATION,
    VIDEO_CACHED,
    USED,
    URL,
    MUTED,
    ENABLED,
    REASON;

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase();
    }
}
