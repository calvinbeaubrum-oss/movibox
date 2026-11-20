package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseRemoteConfigException extends FirebaseException {
    public FirebaseRemoteConfigException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigException(@NonNull String str, @Nullable Throwable th2) {
        super(str, th2);
    }
}
