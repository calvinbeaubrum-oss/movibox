package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzea extends zzf {
    private final zzdz zza;
    private boolean zzb;

    public zzea(zzfr zzfrVar) {
        super(zzfrVar);
        Context contextZzau = this.zzt.zzau();
        this.zzt.zzf();
        this.zza = new zzdz(this, contextZzau, "google_app_measurement_local.db");
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00f4 A[PHI: r8
  0x00f4: PHI (r8v3 android.database.sqlite.SQLiteDatabase) = (r8v2 android.database.sqlite.SQLiteDatabase), (r8v4 android.database.sqlite.SQLiteDatabase) binds: [B:60:0x00f2, B:76:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x0130  */
    /* JADX WARN: Code duplicated, block: B:82:0x0135  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v9 */
    private final boolean zzq(int i11, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzh;
        ?? RawQuery;
        ?? r11;
        zzg();
        ?? r12 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i11));
        contentValues.put("entry", bArr);
        this.zzt.zzf();
        int i12 = 0;
        int i13 = 5;
        for (int i14 = 5; i12 < i14; i14 = 5) {
            ?? r13 = 0;
             = 0;
            ?? r14 = 0;
            sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseZzh = zzh();
                try {
                    if (sQLiteDatabaseZzh == null) {
                        this.zzb = true;
                        return r12;
                    }
                    sQLiteDatabaseZzh.beginTransaction();
                    RawQuery = sQLiteDatabaseZzh.rawQuery("select count(1) from messages", null);
                    long j11 = 0;
                    if (RawQuery != 0) {
                        try {
                            if (RawQuery.moveToFirst()) {
                                j11 = RawQuery.getLong(r12);
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            r14 = RawQuery;
                            try {
                                SystemClock.sleep(i13);
                                i13 += 20;
                                if (r14 != 0) {
                                    r14.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                i12++;
                                r12 = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                r13 = r14;
                                if (r13 != 0) {
                                    r13.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteFullException e11) {
                            e = e11;
                            sQLiteDatabase = sQLiteDatabaseZzh;
                            r11 = RawQuery;
                            this.zzt.zzay().zzd().zzb("Error writing entry; local database full", e);
                            this.zzb = true;
                            if (r11 != 0) {
                                r11.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i12++;
                            r12 = 0;
                        } catch (SQLiteException e12) {
                            e = e12;
                            sQLiteDatabase = sQLiteDatabaseZzh;
                            RawQuery = RawQuery;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    sQLiteDatabaseZzh = sQLiteDatabase;
                                    r13 = RawQuery;
                                    if (r13 != 0) {
                                        r13.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    throw th;
                                }
                            }
                            this.zzt.zzay().zzd().zzb("Error writing entry to local database", e);
                            this.zzb = true;
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i12++;
                            r12 = 0;
                        } catch (Throwable th4) {
                            th = th4;
                            r13 = RawQuery;
                            if (r13 != 0) {
                                r13.close();
                            }
                            if (sQLiteDatabaseZzh != null) {
                                sQLiteDatabaseZzh.close();
                            }
                            throw th;
                        }
                    }
                    if (j11 >= 100000) {
                        this.zzt.zzay().zzd().zza("Data loss, local db full");
                        long j12 = 100001 - j11;
                        String[] strArr = new String[1];
                        strArr[r12] = Long.toString(j12);
                        long jDelete = sQLiteDatabaseZzh.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (jDelete != j12) {
                            this.zzt.zzay().zzd().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j12), Long.valueOf(jDelete), Long.valueOf(j12 - jDelete));
                        }
                    }
                    sQLiteDatabaseZzh.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabaseZzh.setTransactionSuccessful();
                    sQLiteDatabaseZzh.endTransaction();
                    if (RawQuery != 0) {
                        RawQuery.close();
                    }
                    sQLiteDatabaseZzh.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused2) {
                } catch (SQLiteFullException e13) {
                    e = e13;
                    RawQuery = 0;
                } catch (SQLiteException e14) {
                    e = e14;
                    RawQuery = 0;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabaseZzh = null;
            } catch (SQLiteFullException e15) {
                e = e15;
                r11 = 0;
            } catch (SQLiteException e16) {
                e = e16;
                RawQuery = 0;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabaseZzh = null;
                if (r13 != 0) {
                    r13.close();
                }
                if (sQLiteDatabaseZzh != null) {
                    sQLiteDatabaseZzh.close();
                }
                throw th;
            }
        }
        this.zzt.zzay().zzj().zza("Failed to write entry to local database");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    @VisibleForTesting
    public final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:139:0x0229 A[Catch: all -> 0x022d, TryCatch #5 {all -> 0x022d, blocks: (B:137:0x0223, B:139:0x0229, B:142:0x022f, B:158:0x025e, B:150:0x024b), top: B:176:0x0223 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0240  */
    /* JADX WARN: Code duplicated, block: B:153:0x0252  */
    /* JADX WARN: Code duplicated, block: B:155:0x0257 A[PHI: r9 r15
  0x0257: PHI (r9v3 int) = (r9v1 int), (r9v1 int), (r9v4 int) binds: [B:145:0x0243, B:161:0x0272, B:154:0x0255] A[DONT_GENERATE, DONT_INLINE]
  0x0257: PHI (r15v7 android.database.sqlite.SQLiteDatabase) = 
  (r15v5 android.database.sqlite.SQLiteDatabase)
  (r15v6 android.database.sqlite.SQLiteDatabase)
  (r15v8 android.database.sqlite.SQLiteDatabase)
 binds: [B:145:0x0243, B:161:0x0272, B:154:0x0255] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:160:0x026f  */
    /* JADX WARN: Code duplicated, block: B:165:0x027c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0281  */
    /* JADX WARN: Code duplicated, block: B:176:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x0275 A[SYNTHETIC] */
    public final List zzi(int i11) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursorQuery2;
        long j11;
        String str;
        String[] strArr;
        zzkw zzkwVarCreateFromParcel;
        zzac zzacVarCreateFromParcel;
        zzg();
        Cursor cursor = null;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzl()) {
            return arrayList;
        }
        int i12 = 0;
        int i13 = 5;
        for (int i14 = 5; i12 < i14; i14 = 5) {
            try {
                SQLiteDatabase sQLiteDatabaseZzh = zzh();
                if (sQLiteDatabaseZzh == null) {
                    this.zzb = true;
                    return null;
                }
                try {
                    sQLiteDatabaseZzh.beginTransaction();
                    try {
                        try {
                            cursorQuery2 = sQLiteDatabaseZzh.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
                            try {
                                long j12 = -1;
                                if (cursorQuery2.moveToFirst()) {
                                    j11 = cursorQuery2.getLong(0);
                                    try {
                                        cursorQuery2.close();
                                    } catch (SQLiteDatabaseLockedException unused) {
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                        cursorQuery = null;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        SystemClock.sleep(i13);
                                        i13 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i12++;
                                    } catch (SQLiteFullException e11) {
                                        e = e11;
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                        cursorQuery = null;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        this.zzt.zzay().zzd().zzb("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i12++;
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                        cursorQuery = null;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        if (sQLiteDatabase != null) {
                                            try {
                                                if (sQLiteDatabase.inTransaction()) {
                                                    sQLiteDatabase.endTransaction();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cursor = cursorQuery;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        this.zzt.zzay().zzd().zzb("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i12++;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                } else {
                                    cursorQuery2.close();
                                    j11 = -1;
                                }
                                if (j11 != -1) {
                                    str = "rowid<?";
                                    strArr = new String[]{String.valueOf(j11)};
                                } else {
                                    str = null;
                                    strArr = null;
                                }
                                cursorQuery = sQLiteDatabaseZzh.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        j12 = cursorQuery.getLong(0);
                                        int i15 = cursorQuery.getInt(1);
                                        byte[] blob = cursorQuery.getBlob(2);
                                        if (i15 == 0) {
                                            Parcel parcelObtain = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                    parcelObtain.setDataPosition(0);
                                                    zzaw zzawVarCreateFromParcel = zzaw.CREATOR.createFromParcel(parcelObtain);
                                                    parcelObtain.recycle();
                                                    if (zzawVarCreateFromParcel != null) {
                                                        arrayList.add(zzawVarCreateFromParcel);
                                                    }
                                                } catch (SafeParcelReader.ParseException unused2) {
                                                    this.zzt.zzay().zzd().zza("Failed to load event from local database");
                                                    parcelObtain.recycle();
                                                }
                                            } catch (Throwable th4) {
                                                parcelObtain.recycle();
                                                throw th4;
                                            }
                                        } else if (i15 == 1) {
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain2.unmarshall(blob, 0, blob.length);
                                                    parcelObtain2.setDataPosition(0);
                                                    zzkwVarCreateFromParcel = zzkw.CREATOR.createFromParcel(parcelObtain2);
                                                    parcelObtain2.recycle();
                                                } catch (Throwable th5) {
                                                    parcelObtain2.recycle();
                                                    throw th5;
                                                }
                                            } catch (SafeParcelReader.ParseException unused3) {
                                                this.zzt.zzay().zzd().zza("Failed to load user property from local database");
                                                parcelObtain2.recycle();
                                                zzkwVarCreateFromParcel = null;
                                            }
                                            if (zzkwVarCreateFromParcel != null) {
                                                arrayList.add(zzkwVarCreateFromParcel);
                                            }
                                        } else if (i15 == 2) {
                                            Parcel parcelObtain3 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain3.unmarshall(blob, 0, blob.length);
                                                    parcelObtain3.setDataPosition(0);
                                                    zzacVarCreateFromParcel = zzac.CREATOR.createFromParcel(parcelObtain3);
                                                    parcelObtain3.recycle();
                                                } catch (Throwable th6) {
                                                    parcelObtain3.recycle();
                                                    throw th6;
                                                }
                                            } catch (SafeParcelReader.ParseException unused4) {
                                                this.zzt.zzay().zzd().zza("Failed to load conditional user property from local database");
                                                parcelObtain3.recycle();
                                                zzacVarCreateFromParcel = null;
                                            }
                                            if (zzacVarCreateFromParcel != null) {
                                                arrayList.add(zzacVarCreateFromParcel);
                                            }
                                        } else if (i15 == 3) {
                                            this.zzt.zzay().zzk().zza("Skipping app launch break");
                                        } else {
                                            this.zzt.zzay().zzd().zza("Unknown record type in local database");
                                        }
                                    } catch (SQLiteDatabaseLockedException unused5) {
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                    } catch (SQLiteFullException e13) {
                                        e = e13;
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                    } catch (SQLiteException e14) {
                                        e = e14;
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                                    }
                                }
                                sQLiteDatabase2 = sQLiteDatabaseZzh;
                                try {
                                    if (sQLiteDatabase2.delete("messages", "rowid <= ?", new String[]{Long.toString(j12)}) < arrayList.size()) {
                                        this.zzt.zzay().zzd().zza("Fewer entries removed from local database than expected");
                                    }
                                    sQLiteDatabase2.setTransactionSuccessful();
                                    sQLiteDatabase2.endTransaction();
                                    cursorQuery.close();
                                    sQLiteDatabase2.close();
                                    return arrayList;
                                } catch (SQLiteDatabaseLockedException unused6) {
                                    sQLiteDatabase = sQLiteDatabase2;
                                    SystemClock.sleep(i13);
                                    i13 += 20;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i12++;
                                } catch (SQLiteFullException e15) {
                                    e = e15;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    this.zzt.zzay().zzd().zzb("Error reading entries from local database", e);
                                    this.zzb = true;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i12++;
                                } catch (SQLiteException e16) {
                                    e = e16;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    if (sQLiteDatabase != null) {
                                        if (sQLiteDatabase.inTransaction()) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                    }
                                    this.zzt.zzay().zzd().zzb("Error reading entries from local database", e);
                                    this.zzb = true;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i12++;
                                } catch (Throwable th8) {
                                    th = th8;
                                    cursor = cursorQuery;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                sQLiteDatabase2 = sQLiteDatabaseZzh;
                                if (cursorQuery2 != null) {
                                    try {
                                        cursorQuery2.close();
                                    } catch (SQLiteDatabaseLockedException unused7) {
                                        cursorQuery = null;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        SystemClock.sleep(i13);
                                        i13 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i12++;
                                    } catch (SQLiteFullException e17) {
                                        e = e17;
                                        cursorQuery = null;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        this.zzt.zzay().zzd().zzb("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i12++;
                                    } catch (SQLiteException e18) {
                                        e = e18;
                                        cursorQuery = null;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        if (sQLiteDatabase != null) {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        }
                                        this.zzt.zzay().zzd().zzb("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i12++;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            sQLiteDatabase2 = sQLiteDatabaseZzh;
                            cursorQuery2 = null;
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        sQLiteDatabase2 = sQLiteDatabaseZzh;
                    }
                } catch (SQLiteDatabaseLockedException unused8) {
                    sQLiteDatabase2 = sQLiteDatabaseZzh;
                } catch (SQLiteFullException e19) {
                    e = e19;
                    sQLiteDatabase2 = sQLiteDatabaseZzh;
                } catch (SQLiteException e21) {
                    e = e21;
                    sQLiteDatabase2 = sQLiteDatabaseZzh;
                } catch (Throwable th13) {
                    th = th13;
                    sQLiteDatabase2 = sQLiteDatabaseZzh;
                }
            } catch (SQLiteDatabaseLockedException unused9) {
                cursorQuery = null;
                sQLiteDatabase = null;
            } catch (SQLiteFullException e22) {
                e = e22;
                cursorQuery = null;
                sQLiteDatabase = null;
            } catch (SQLiteException e23) {
                e = e23;
                cursorQuery = null;
                sQLiteDatabase = null;
            } catch (Throwable th14) {
                th = th14;
                sQLiteDatabase = null;
            }
        }
        this.zzt.zzay().zzk().zza("Failed to read events from database in reasonable time");
        return null;
    }

    public final void zzj() {
        int iDelete;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzh();
            if (sQLiteDatabaseZzh == null || (iDelete = sQLiteDatabaseZzh.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzt.zzay().zzj().zzb("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e11) {
            this.zzt.zzay().zzd().zzb("Error resetting local analytics data. error", e11);
        }
    }

    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    @VisibleForTesting
    public final boolean zzl() {
        Context contextZzau = this.zzt.zzau();
        this.zzt.zzf();
        return contextZzau.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0069 A[PHI: r4
  0x0069: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:35:0x007c, B:32:0x0067, B:29:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i11 = 5;
            for (int i12 = 0; i12 < 5; i12++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase sQLiteDatabaseZzh = zzh();
                            if (sQLiteDatabaseZzh == null) {
                                this.zzb = true;
                                return false;
                            }
                            sQLiteDatabaseZzh.beginTransaction();
                            sQLiteDatabaseZzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                            sQLiteDatabaseZzh.setTransactionSuccessful();
                            sQLiteDatabaseZzh.endTransaction();
                            sQLiteDatabaseZzh.close();
                            return true;
                        } catch (SQLiteException e11) {
                            if (0 != 0) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    if (0 != 0) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th2;
                                }
                            }
                            this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e11);
                            this.zzb = true;
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                        }
                    } catch (SQLiteDatabaseLockedException unused) {
                        SystemClock.sleep(i11);
                        i11 += 20;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteFullException e12) {
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e12);
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.zzt.zzay().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzacVar) {
        byte[] bArrZzan = this.zzt.zzv().zzan(zzacVar);
        if (bArrZzan.length <= 131072) {
            return zzq(2, bArrZzan);
        }
        this.zzt.zzay().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzaw zzawVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzax.zza(zzawVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzq(0, bArrMarshall);
        }
        this.zzt.zzay().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzkw zzkwVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzkx.zza(zzkwVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzq(1, bArrMarshall);
        }
        this.zzt.zzay().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
