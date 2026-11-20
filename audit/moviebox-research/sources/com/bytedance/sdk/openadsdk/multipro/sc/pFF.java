package com.bytedance.sdk.openadsdk.multipro.sc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.ExN;
import com.bytedance.sdk.openadsdk.core.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF implements com.bytedance.sdk.openadsdk.multipro.sc {
    private static final Object pFF = new Object();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f28653sc;

    private Context pFF() {
        Context context = this.f28653sc;
        return context == null ? Xc.sc() : context;
    }

    private boolean pFF(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        synchronized (pFF) {
            try {
                if (pFF(uri)) {
                    return 0;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str2 = strArrSplit[2];
                    String str3 = strArrSplit[3];
                    if (!"ttopensdk.db".equals(str2)) {
                        return 0;
                    }
                    return ExN.sc(pFF()).sc().sc(str3, contentValues, str, strArr);
                }
                return 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        synchronized (pFF) {
            try {
                if (pFF(uri)) {
                    return 0;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str2 = strArrSplit[2];
                    String str3 = strArrSplit[3];
                    if (!"ttopensdk.db".equals(str2)) {
                        return 0;
                    }
                    return ExN.sc(pFF()).sc().sc(str3, str, strArr);
                }
                return 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Cursor sc(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        synchronized (pFF) {
            try {
                if (pFF(uri)) {
                    return null;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str3 = strArrSplit[2];
                    String str4 = strArrSplit[3];
                    if (!"ttopensdk.db".equals(str3)) {
                        return null;
                    }
                    return ExN.sc(pFF()).sc().sc(str4, strArr, str, strArr2, null, null, str2);
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Uri sc(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        synchronized (pFF) {
            try {
                if (pFF(uri)) {
                    return null;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str = strArrSplit[2];
                    String str2 = strArrSplit[3];
                    if ("ttopensdk.db".equals(str)) {
                        ExN.sc(pFF()).sc().sc(str2, (String) null, contentValues);
                    }
                    return null;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    @NonNull
    public String sc() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public String sc(@NonNull Uri uri) {
        synchronized (pFF) {
            try {
                if (pFF(uri)) {
                    return null;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 5) {
                    String str = strArrSplit[2];
                    String str2 = strArrSplit[4];
                    if ("ttopensdk.db".equals(str)) {
                        if ("execSQL".equals(str2)) {
                            String queryParameter = uri.getQueryParameter("sql");
                            if (!TextUtils.isEmpty(queryParameter)) {
                                ExN.sc(pFF()).sc().sc(Uri.decode(queryParameter));
                            }
                        } else if ("transactionBegin".equals(str2)) {
                            ExN.sc(pFF()).sc().pFF();
                        } else if ("transactionSetSuccess".equals(str2)) {
                            ExN.sc(pFF()).sc().zY();
                        } else if ("transactionEnd".equals(str2)) {
                            ExN.sc(pFF()).sc().We();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
