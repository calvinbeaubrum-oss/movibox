package com.bytedance.sdk.openadsdk.multipro.We;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements com.bytedance.sdk.openadsdk.multipro.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f28618sc;

    private Context pFF() {
        Context context = this.f28618sc;
        return context == null ? Xc.sc() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        sc(uri, contentValues);
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit[2].equals("clean")) {
            pFF.pFF(pFF(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (pFF.sc(pFF(), uri.getQueryParameter("sp_file_name"), str2)) {
            pFF.pFF(pFF(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Cursor sc(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Map<String, ?> mapZY;
        if (!uri.getPath().split("/")[2].equals("get_all") || (mapZY = pFF.zY(pFF(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapZY.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = mapZY.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (obj instanceof String) {
                objArr[1] = "string";
            } else if (obj instanceof Integer) {
                objArr[1] = "int";
            } else if (obj instanceof Long) {
                objArr[1] = "long";
            } else if (obj instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Uri sc(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split("/")[3];
        Object obj = contentValues.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (obj != null) {
            pFF.sc(pFF(), uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    @NonNull
    public String sc() {
        return "t_sp";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public String sc(@NonNull Uri uri) {
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        return str.equals("contain") ? String.valueOf(pFF.sc(Xc.sc(), uri.getQueryParameter("sp_file_name"), str2)) : pFF.sc(pFF(), uri.getQueryParameter("sp_file_name"), str2, str);
    }
}
