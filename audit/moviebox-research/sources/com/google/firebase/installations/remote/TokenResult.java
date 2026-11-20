package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class TokenResult {

    /* JADX INFO: compiled from: source.java */
    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class a {
        @NonNull
        public abstract TokenResult a();

        @NonNull
        public abstract a b(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract a c(@NonNull String str);

        @NonNull
        public abstract a d(long j11);
    }

    @NonNull
    public static a a() {
        return new b.C0448b().d(0L);
    }

    @Nullable
    public abstract ResponseCode b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();
}
