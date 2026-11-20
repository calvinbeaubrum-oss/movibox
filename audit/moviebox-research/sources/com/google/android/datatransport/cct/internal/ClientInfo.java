package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ClientInfo {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i11) {
            this.value = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class a {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract a b(@Nullable eg.a aVar);

        @NonNull
        public abstract a c(@Nullable ClientType clientType);
    }

    @NonNull
    public static a a() {
        return new b.C0353b();
    }

    @Nullable
    public abstract eg.a b();

    @Nullable
    public abstract ClientType c();
}
