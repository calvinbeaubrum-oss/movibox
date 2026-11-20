package com.mbridge.msdk.e;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class y {
    public static long a(int i11, long j11, long j12) {
        if (i11 <= 0 || j11 == 0 || i11 <= 10) {
            return j12;
        }
        if (i11 <= 20) {
            return ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
        if (i11 <= 30) {
            return 120000L;
        }
        if (i11 <= 40) {
            return 180000L;
        }
        return i11 <= 50 ? 240000L : 300000L;
    }

    public static void a(Cursor cursor) {
        try {
            if (!b((Object) cursor) || cursor.isClosed()) {
                return;
            }
            cursor.close();
        } catch (Exception unused) {
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = null;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return true;
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused2) {
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static List<i> b(Cursor cursor) {
        int i11;
        int i12;
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("time_stamp");
            int columnIndex4 = cursor.getColumnIndex("properties");
            int columnIndex5 = cursor.getColumnIndex(TrackingKey.PRIORITY);
            int columnIndex6 = cursor.getColumnIndex("uuid");
            int columnIndex7 = cursor.getColumnIndex("duration");
            int columnIndex8 = cursor.getColumnIndex("state");
            int columnIndex9 = cursor.getColumnIndex("report_count");
            int columnIndex10 = cursor.getColumnIndex("ignore_max_timeout");
            int columnIndex11 = cursor.getColumnIndex("ignore_max_retry_times");
            int columnIndex12 = cursor.getColumnIndex("invalid_time");
            while (cursor.moveToNext()) {
                try {
                    e eVar = new e(cursor.getString(columnIndex));
                    eVar.a(cursor.getInt(columnIndex2));
                    i11 = columnIndex;
                    i12 = columnIndex2;
                    try {
                        eVar.a(cursor.getLong(columnIndex3));
                        eVar.a(new JSONObject(cursor.getString(columnIndex4)));
                        eVar.b(cursor.getInt(columnIndex5));
                        eVar.a(cursor.getString(columnIndex6));
                        eVar.b(cursor.getLong(columnIndex7));
                        i iVar = new i(eVar);
                        iVar.b(cursor.getInt(columnIndex8));
                        iVar.a(cursor.getInt(columnIndex9));
                        iVar.a(cursor.getInt(columnIndex10) == 0);
                        iVar.b(cursor.getInt(columnIndex11) == 0);
                        iVar.a(cursor.getLong(columnIndex12));
                        arrayList.add(iVar);
                    } catch (JSONException e11) {
                        e = e11;
                        if (a.f43738a) {
                            Log.e("TrackManager", "create: ", e);
                        }
                    }
                } catch (JSONException e12) {
                    e = e12;
                    i11 = columnIndex;
                    i12 = columnIndex2;
                }
                columnIndex = i11;
                columnIndex2 = i12;
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static boolean b(Object obj) {
        return obj != null;
    }

    public static boolean b(List<i> list) {
        if (a((List<?>) list)) {
            return false;
        }
        for (i iVar : list) {
            if (!a(iVar)) {
                e eVarC = iVar.c();
                if (!a(eVarC) && eVarC.c() == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
