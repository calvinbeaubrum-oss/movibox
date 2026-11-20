package com.google.android.libraries.places.api.net;

import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class FetchResolvedPhotoUriResponse {
    @RecentlyNonNull
    public static FetchResolvedPhotoUriResponse newInstance(@RecentlyNonNull Uri uri) {
        return new zzl(uri);
    }

    @RecentlyNullable
    public abstract Uri getUri();
}
