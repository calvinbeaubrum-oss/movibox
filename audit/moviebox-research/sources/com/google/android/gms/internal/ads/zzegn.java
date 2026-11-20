package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzegn {
    public static int zza(SQLiteDatabase sQLiteDatabase, int i11) {
        int i12 = 0;
        if (i11 == 2) {
            return 0;
        }
        Cursor cursorZzh = zzh(sQLiteDatabase, i11);
        if (cursorZzh.getCount() > 0) {
            cursorZzh.moveToNext();
            i12 = cursorZzh.getInt(cursorZzh.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        }
        cursorZzh.close();
        return i12;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i11) {
        long j11;
        Cursor cursorZzh = zzh(sQLiteDatabase, 2);
        if (cursorZzh.getCount() > 0) {
            cursorZzh.moveToNext();
            j11 = cursorZzh.getLong(cursorZzh.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        } else {
            j11 = 0;
        }
        cursorZzh.close();
        return j11;
    }

    public static ArrayList zzc(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(zzbdy.zzi(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzhag e11) {
                zzcec.zzg("Unable to deserialize proto from offline signals database:");
                zzcec.zzg(e11.getMessage());
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public static void zzd(SQLiteDatabase sQLiteDatabase, long j11, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j11));
        contentValues.put("serialized_proto_data", bArr);
        if (sQLiteDatabase.update("offline_signal_contents", contentValues, "timestamp = ?", new String[]{String.valueOf(j11)}) == 0) {
            sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
        }
    }

    public static void zze(SQLiteDatabase sQLiteDatabase) {
        zzi(sQLiteDatabase, "failed_requests", 0);
        zzi(sQLiteDatabase, "total_requests", 0);
        zzi(sQLiteDatabase, "completed_requests", 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", "last_successful_request_time");
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (Long) 0L);
        sQLiteDatabase.insert("offline_signal_statistics", null, contentValues);
    }

    public static void zzf(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        zzj(sQLiteDatabase, "failed_requests", 0);
        zzj(sQLiteDatabase, "total_requests", 0);
        zzj(sQLiteDatabase, "completed_requests", 0);
    }

    public static void zzg(SQLiteDatabase sQLiteDatabase, boolean z11, boolean z12) {
        if (!z12) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
            return;
        }
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "completed_requests"));
        if (z11) {
            return;
        }
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
    }

    private static Cursor zzh(SQLiteDatabase sQLiteDatabase, int i11) {
        String[] strArr = {AppMeasurementSdk.ConditionalUserProperty.VALUE};
        String[] strArr2 = new String[1];
        if (i11 == 0) {
            strArr2[0] = "failed_requests";
        } else if (i11 == 1) {
            strArr2[0] = "total_requests";
        } else if (i11 != 2) {
            strArr2[0] = "completed_requests";
        } else {
            strArr2[0] = "last_successful_request_time";
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
    }

    private static void zzi(SQLiteDatabase sQLiteDatabase, String str, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", str);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (Integer) 0);
        sQLiteDatabase.insert("offline_signal_statistics", null, contentValues);
    }

    private static void zzj(SQLiteDatabase sQLiteDatabase, String str, int i11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{str});
    }
}
