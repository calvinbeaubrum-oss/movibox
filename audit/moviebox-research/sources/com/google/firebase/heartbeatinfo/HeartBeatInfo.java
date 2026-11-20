package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface HeartBeatInfo {

    /* JADX INFO: compiled from: source.java */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i11) {
            this.code = i11;
        }

        public int getCode() {
            return this.code;
        }
    }

    @NonNull
    HeartBeat b(@NonNull String str);
}
