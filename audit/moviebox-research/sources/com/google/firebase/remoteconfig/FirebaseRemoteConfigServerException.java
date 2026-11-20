package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int i11, @NonNull String str) {
        super(str);
        this.httpStatusCode = i11;
    }

    public FirebaseRemoteConfigServerException(int i11, @NonNull String str, @Nullable Throwable th2) {
        super(str, th2);
        this.httpStatusCode = i11;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
