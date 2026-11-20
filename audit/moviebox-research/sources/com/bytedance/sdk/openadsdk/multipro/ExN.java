package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements sc {
    private static WeakReference<Context> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile ExN f28614sc;
    private static final List<sc> zY;

    static {
        List<sc> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        zY = listSynchronizedList;
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.We.zY());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.sc.pFF());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.zY.sc());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.We.sc.ExN(new com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF()));
        Iterator<sc> it = listSynchronizedList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private ExN() {
    }

    private sc pFF(Uri uri) {
        if (uri == null || !zY(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (sc scVar : zY) {
            if (str.equals(scVar.sc())) {
                return scVar;
            }
        }
        return null;
    }

    public static ExN sc(Context context) {
        if (context != null) {
            pFF = new WeakReference<>(context.getApplicationContext());
        }
        if (f28614sc == null) {
            synchronized (ExN.class) {
                try {
                    if (f28614sc == null) {
                        f28614sc = new ExN();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28614sc;
    }

    private boolean zY(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        try {
            sc scVarPFF = pFF(uri);
            if (scVarPFF != null) {
                return scVarPFF.sc(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        try {
            sc scVarPFF = pFF(uri);
            if (scVarPFF != null) {
                return scVarPFF.sc(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Cursor sc(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            sc scVarPFF = pFF(uri);
            if (scVarPFF != null) {
                return scVarPFF.sc(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Uri sc(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        try {
            sc scVarPFF = pFF(uri);
            if (scVarPFF != null) {
                return scVarPFF.sc(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    @NonNull
    public String sc() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public String sc(@NonNull Uri uri) {
        try {
            sc scVarPFF = pFF(uri);
            if (scVarPFF != null) {
                return scVarPFF.sc(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
