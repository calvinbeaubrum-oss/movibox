package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzw {
    final /* synthetic */ zzaa zza;
    private com.google.android.gms.internal.measurement.zzft zzb;
    private Long zzc;
    private long zzd;

    public /* synthetic */ zzw(zzaa zzaaVar, zzv zzvVar) {
        this.zza = zzaaVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    /* JADX WARN: Code duplicated, block: B:20:0x0090 A[Catch: all -> 0x00a4, SQLiteException -> 0x00a6, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:18:0x008a, B:20:0x0090, B:27:0x00a8, B:28:0x00b4, B:29:0x00c4, B:32:0x00cd, B:39:0x00ea), top: B:79:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a8 A[Catch: all -> 0x00a4, SQLiteException -> 0x00a6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:18:0x008a, B:20:0x0090, B:27:0x00a8, B:28:0x00b4, B:29:0x00c4, B:32:0x00cd, B:39:0x00ea), top: B:79:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v10, types: [long] */
    public final com.google.android.gms.internal.measurement.zzft zza(String str, com.google.android.gms.internal.measurement.zzft zzftVar) {
        zzam zzamVarZzi;
        SQLiteException e11;
        Cursor cursorRawQuery;
        Pair pairCreate;
        Object obj;
        ?? LongValue;
        String strZzh = zzftVar.zzh();
        List listZzi = zzftVar.zzi();
        this.zza.zzf.zzu();
        Long l11 = (Long) zzkv.zzC(zzftVar, "_eid");
        if (l11 != null) {
            if (strZzh.equals("_ep")) {
                Preconditions.checkNotNull(l11);
                this.zza.zzf.zzu();
                strZzh = (String) zzkv.zzC(zzftVar, "_en");
                ?? r11 = 0;
                if (TextUtils.isEmpty(strZzh)) {
                    this.zza.zzt.zzay().zzh().zzb("Extra parameter without an event name. eventId", l11);
                    return null;
                }
                if (this.zzb == null || this.zzc == null) {
                    zzamVarZzi = this.zza.zzf.zzi();
                    zzamVarZzi.zzg();
                    zzamVarZzi.zzW();
                    try {
                        try {
                            cursorRawQuery = zzamVarZzi.zzh().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l11.toString()});
                            try {
                                if (!cursorRawQuery.moveToFirst()) {
                                    try {
                                        pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzft) ((com.google.android.gms.internal.measurement.zzfs) zzkv.zzl(com.google.android.gms.internal.measurement.zzft.zze(), cursorRawQuery.getBlob(0))).zzaC(), Long.valueOf(cursorRawQuery.getLong(1)));
                                        cursorRawQuery.close();
                                    } catch (IOException e12) {
                                        zzamVarZzi.zzt.zzay().zzd().zzd("Failed to merge main event. appId, eventId", zzeh.zzn(str), l11, e12);
                                        cursorRawQuery.close();
                                        pairCreate = null;
                                    }
                                    if (pairCreate != null || (obj = pairCreate.first) == null) {
                                        this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", strZzh, l11);
                                        return null;
                                    }
                                    this.zzb = (com.google.android.gms.internal.measurement.zzft) obj;
                                    this.zzd = ((Long) pairCreate.second).longValue();
                                    this.zza.zzf.zzu();
                                    this.zzc = (Long) zzkv.zzC(this.zzb, "_eid");
                                } else {
                                    zzamVarZzi.zzt.zzay().zzj().zza("Main event not found");
                                }
                            } catch (SQLiteException e13) {
                                e11 = e13;
                                zzamVarZzi.zzt.zzay().zzd().zzb("Error selecting main event", e11);
                                if (cursorRawQuery != null) {
                                }
                                pairCreate = null;
                                if (pairCreate != null) {
                                }
                                this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", strZzh, l11);
                                return null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r11 = LongValue;
                            if (r11 != 0) {
                                r11.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e14) {
                        e11 = e14;
                        cursorRawQuery = null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (r11 != 0) {
                            r11.close();
                        }
                        throw th;
                    }
                    cursorRawQuery.close();
                    pairCreate = null;
                    if (pairCreate != null) {
                    }
                    this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", strZzh, l11);
                    return null;
                }
                LongValue = l11.longValue();
                if (LongValue != this.zzc.longValue()) {
                    zzamVarZzi = this.zza.zzf.zzi();
                    zzamVarZzi.zzg();
                    zzamVarZzi.zzW();
                    cursorRawQuery = zzamVarZzi.zzh().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l11.toString()});
                    if (!cursorRawQuery.moveToFirst()) {
                        pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzft) ((com.google.android.gms.internal.measurement.zzfs) zzkv.zzl(com.google.android.gms.internal.measurement.zzft.zze(), cursorRawQuery.getBlob(0))).zzaC(), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                        if (pairCreate != null) {
                        }
                        this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", strZzh, l11);
                        return null;
                    }
                    zzamVarZzi.zzt.zzay().zzj().zza("Main event not found");
                    cursorRawQuery.close();
                    pairCreate = null;
                    if (pairCreate != null) {
                    }
                    this.zza.zzt.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", strZzh, l11);
                    return null;
                }
                long j11 = this.zzd - 1;
                this.zzd = j11;
                if (j11 <= 0) {
                    zzam zzamVarZzi2 = this.zza.zzf.zzi();
                    zzamVarZzi2.zzg();
                    zzamVarZzi2.zzt.zzay().zzj().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzamVarZzi2.zzh().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e15) {
                        zzamVarZzi2.zzt.zzay().zzd().zzb("Error clearing complex main event", e15);
                    }
                } else {
                    this.zza.zzf.zzi().zzJ(str, l11, this.zzd, this.zzb);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzfx zzfxVar : this.zzb.zzi()) {
                    this.zza.zzf.zzu();
                    if (zzkv.zzB(zzftVar, zzfxVar.zzg()) == null) {
                        arrayList.add(zzfxVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.zza.zzt.zzay().zzh().zzb("No unique parameters in main event. eventName", strZzh);
                } else {
                    arrayList.addAll(listZzi);
                    listZzi = arrayList;
                }
            } else {
                this.zzc = l11;
                this.zzb = zzftVar;
                this.zza.zzf.zzu();
                Object objZzC = zzkv.zzC(zzftVar, "_epc");
                long jLongValue = ((Long) (objZzC != null ? objZzC : 0L)).longValue();
                this.zzd = jLongValue;
                if (jLongValue <= 0) {
                    this.zza.zzt.zzay().zzh().zzb("Complex event with zero extra param count. eventName", strZzh);
                } else {
                    this.zza.zzf.zzi().zzJ(str, (Long) Preconditions.checkNotNull(l11), this.zzd, zzftVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzfs zzfsVar = (com.google.android.gms.internal.measurement.zzfs) zzftVar.zzby();
        zzfsVar.zzi(strZzh);
        zzfsVar.zzg();
        zzfsVar.zzd(listZzi);
        return (com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaC();
    }
}
