package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class InstallationResponse {

    /* JADX INFO: compiled from: source.java */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class a {
        @NonNull
        public abstract InstallationResponse a();

        @NonNull
        public abstract a b(@NonNull TokenResult tokenResult);

        @NonNull
        public abstract a c(@NonNull String str);

        @NonNull
        public abstract a d(@NonNull String str);

        @NonNull
        public abstract a e(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract a f(@NonNull String str);
    }

    @NonNull
    public static a a() {
        return new com.google.firebase.installations.remote.a.b();
    }

    @Nullable
    public abstract TokenResult b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract ResponseCode e();

    @Nullable
    public abstract String f();
}
