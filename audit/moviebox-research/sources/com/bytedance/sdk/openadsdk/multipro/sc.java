package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface sc {
    int sc(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr);

    int sc(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr);

    Cursor sc(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2);

    Uri sc(@NonNull Uri uri, @Nullable ContentValues contentValues);

    @NonNull
    String sc();

    String sc(@NonNull Uri uri);
}
