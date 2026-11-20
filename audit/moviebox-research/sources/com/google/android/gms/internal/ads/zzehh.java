package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzehh extends SQLiteOpenHelper {
    private final Context zza;
    private final zzgey zzb;

    public zzehh(Context context, zzgey zzgeyVar) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzik)).intValue());
        this.zza = context;
        this.zzb = zzgeyVar;
    }

    public static /* synthetic */ Void zzb(zzceh zzcehVar, SQLiteDatabase sQLiteDatabase) throws Exception {
        zzj(sQLiteDatabase, zzcehVar);
        return null;
    }

    public static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, zzceh zzcehVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", (Integer) 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzcehVar);
    }

    public static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    private static void zzj(SQLiteDatabase sQLiteDatabase, zzceh zzcehVar) {
        sQLiteDatabase.beginTransaction();
        try {
            Cursor cursorQuery = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, "event_state = 1", null, null, null, "timestamp ASC", null);
            int count = cursorQuery.getCount();
            String[] strArr = new String[count];
            int i11 = 0;
            while (cursorQuery.moveToNext()) {
                int columnIndex = cursorQuery.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i11] = cursorQuery.getString(columnIndex);
                }
                i11++;
            }
            cursorQuery.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            for (int i12 = 0; i12 < count; i12++) {
                zzcehVar.zza(strArr[i12]);
            }
        } catch (Throwable th2) {
            sQLiteDatabase.endTransaction();
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final /* synthetic */ Void zza(zzehj zzehjVar, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(zzehjVar.zza));
        contentValues.put("gws_query_id", zzehjVar.zzb);
        contentValues.put("url", zzehjVar.zzc);
        contentValues.put("event_state", Integer.valueOf(zzehjVar.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", null, contentValues);
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.util.zzbt zzbtVarZzy = com.google.android.gms.ads.internal.util.zzt.zzy(this.zza);
        if (zzbtVarZzy != null) {
            try {
                zzbtVarZzy.zze(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e11) {
                com.google.android.gms.ads.internal.util.zze.zzb("Failed to schedule offline ping sender.", e11);
            }
        }
        return null;
    }

    public final void zzc(final String str) {
        zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzehf
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                zzehh.zzi((SQLiteDatabase) obj, str);
                return null;
            }
        });
    }

    public final void zzd(final zzehj zzehjVar) {
        zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzehb
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) throws Exception {
                this.zza.zza(zzehjVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    public final void zze(zzfkp zzfkpVar) {
        zzgen.zzr(this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzehd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.getWritableDatabase();
            }
        }), new zzehg(this, zzfkpVar), this.zzb);
    }

    public final void zzg(final SQLiteDatabase sQLiteDatabase, final zzceh zzcehVar, final String str) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehe
            @Override // java.lang.Runnable
            public final void run() {
                zzehh.zzf(sQLiteDatabase, str, zzcehVar);
            }
        });
    }

    public final void zzh(final zzceh zzcehVar, final String str) {
        zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzehc
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                this.zza.zzg((SQLiteDatabase) obj, zzcehVar, str);
                return null;
            }
        });
    }
}
