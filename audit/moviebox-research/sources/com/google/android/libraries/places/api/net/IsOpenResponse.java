package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class IsOpenResponse {
    @RecentlyNonNull
    public static IsOpenResponse newInstance(@Nullable Boolean bool) {
        return new zzx(bool);
    }

    @RecentlyNullable
    public abstract Boolean isOpen();
}
