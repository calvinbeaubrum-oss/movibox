package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zznz;
import com.google.android.gms.internal.measurement.zzoc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaa extends zzkh {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzaa(zzkt zzktVar) {
        super(zzktVar);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza, null);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean zzf(int i11, int i12) {
        zzu zzuVar = (zzu) this.zzc.get(Integer.valueOf(i11));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zze.get(i12);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0292 A[Catch: all -> 0x02ad, SQLiteException -> 0x02b0, LOOP:11: B:102:0x0292->B:514:?, LOOP_START, TryCatch #5 {all -> 0x02ad, blocks: (B:100:0x028c, B:102:0x0292, B:104:0x02a3, B:110:0x02b2, B:113:0x02c7, B:121:0x02d4), top: B:438:0x0282 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x02a3 A[Catch: all -> 0x02ad, SQLiteException -> 0x02b0, TryCatch #5 {all -> 0x02ad, blocks: (B:100:0x028c, B:102:0x0292, B:104:0x02a3, B:110:0x02b2, B:113:0x02c7, B:121:0x02d4), top: B:438:0x0282 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02c7 A[Catch: all -> 0x02ad, SQLiteException -> 0x02b0, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x02ad, blocks: (B:100:0x028c, B:102:0x0292, B:104:0x02a3, B:110:0x02b2, B:113:0x02c7, B:121:0x02d4), top: B:438:0x0282 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0303  */
    /* JADX WARN: Code duplicated, block: B:130:0x0311  */
    /* JADX WARN: Code duplicated, block: B:132:0x032d  */
    /* JADX WARN: Code duplicated, block: B:173:0x0450  */
    /* JADX WARN: Code duplicated, block: B:175:0x0454  */
    /* JADX WARN: Code duplicated, block: B:179:0x0461  */
    /* JADX WARN: Code duplicated, block: B:181:0x0486  */
    /* JADX WARN: Code duplicated, block: B:187:0x049b  */
    /* JADX WARN: Code duplicated, block: B:191:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:192:0x04be  */
    /* JADX WARN: Code duplicated, block: B:196:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:202:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:208:0x0513  */
    /* JADX WARN: Code duplicated, block: B:211:0x051c  */
    /* JADX WARN: Code duplicated, block: B:213:0x0526  */
    /* JADX WARN: Code duplicated, block: B:215:0x054c  */
    /* JADX WARN: Code duplicated, block: B:216:0x0550  */
    /* JADX WARN: Code duplicated, block: B:221:0x056d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:246:0x0603  */
    /* JADX WARN: Code duplicated, block: B:249:0x0618  */
    /* JADX WARN: Code duplicated, block: B:253:0x063c  */
    /* JADX WARN: Code duplicated, block: B:254:0x067b  */
    /* JADX WARN: Code duplicated, block: B:257:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:265:0x0711  */
    /* JADX WARN: Code duplicated, block: B:272:0x0739  */
    /* JADX WARN: Code duplicated, block: B:278:0x0748  */
    /* JADX WARN: Code duplicated, block: B:287:0x0773 A[LOOP:8: B:266:0x0713->B:287:0x0773, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:288:0x0776  */
    /* JADX WARN: Code duplicated, block: B:308:0x07b6  */
    /* JADX WARN: Code duplicated, block: B:312:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:314:0x07c4  */
    /* JADX WARN: Code duplicated, block: B:318:0x07da  */
    /* JADX WARN: Code duplicated, block: B:324:0x080f  */
    /* JADX WARN: Code duplicated, block: B:326:0x083a A[LOOP:10: B:322:0x0809->B:326:0x083a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:334:0x086d  */
    /* JADX WARN: Code duplicated, block: B:337:0x087c  */
    /* JADX WARN: Code duplicated, block: B:339:0x088f  */
    /* JADX WARN: Code duplicated, block: B:343:0x08cf A[Catch: all -> 0x08fe, SQLiteException -> 0x0906, LOOP:3: B:343:0x08cf->B:486:?, LOOP_START, TRY_LEAVE, TryCatch #15 {all -> 0x08fe, blocks: (B:341:0x08c9, B:343:0x08cf, B:344:0x08d4, B:346:0x08e5, B:348:0x08f5, B:353:0x0902, B:358:0x091e, B:371:0x093c, B:357:0x090a, B:362:0x092a), top: B:449:0x08c9 }] */
    /* JADX WARN: Code duplicated, block: B:348:0x08f5 A[Catch: all -> 0x08fe, SQLiteException -> 0x0900, TryCatch #15 {all -> 0x08fe, blocks: (B:341:0x08c9, B:343:0x08cf, B:344:0x08d4, B:346:0x08e5, B:348:0x08f5, B:353:0x0902, B:358:0x091e, B:371:0x093c, B:357:0x090a, B:362:0x092a), top: B:449:0x08c9 }] */
    /* JADX WARN: Code duplicated, block: B:361:0x0929  */
    /* JADX WARN: Code duplicated, block: B:378:0x095e  */
    /* JADX WARN: Code duplicated, block: B:382:0x096d  */
    /* JADX WARN: Code duplicated, block: B:385:0x0992  */
    /* JADX WARN: Code duplicated, block: B:388:0x09a3  */
    /* JADX WARN: Code duplicated, block: B:390:0x09ba  */
    /* JADX WARN: Code duplicated, block: B:392:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:393:0x09d7  */
    /* JADX WARN: Code duplicated, block: B:397:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:406:0x0a5a  */
    /* JADX WARN: Code duplicated, block: B:407:0x0a63  */
    /* JADX WARN: Code duplicated, block: B:410:0x0a70  */
    /* JADX WARN: Code duplicated, block: B:415:0x0a96  */
    /* JADX WARN: Code duplicated, block: B:420:0x0af8 A[Catch: SQLiteException -> 0x0b10, TRY_LEAVE, TryCatch #28 {SQLiteException -> 0x0b10, blocks: (B:418:0x0aee, B:420:0x0af8), top: B:463:0x0aee }] */
    /* JADX WARN: Code duplicated, block: B:481:0x0983 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:488:0x0a79 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:489:0x0a6e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:490:0x0a44 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:495:0x0b0b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:498:0x0626 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:500:0x0612 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x076e A[EDGE_INSN: B:502:0x076e->B:286:0x076e BREAK  A[LOOP:8: B:266:0x0713->B:287:0x0773], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x07fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:505:0x0851 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x07f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:508:0x07d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:512:0x0846 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:516:0x05cb A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:523:0x04a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x0495 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:528:0x04ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x04db A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:0x0333 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x0217 A[EDGE_INSN: B:563:0x0217->B:78:0x0217 BREAK  A[LOOP:22: B:69:0x01cf->B:79:0x021d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x017c  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b7 A[Catch: all -> 0x01c3, SQLiteException -> 0x01c5, TRY_LEAVE, TryCatch #16 {all -> 0x01c3, blocks: (B:60:0x01b1, B:62:0x01b7, B:68:0x01ca, B:69:0x01cf, B:70:0x01d9, B:71:0x01e9, B:76:0x0211, B:73:0x01f6, B:75:0x020a, B:89:0x0232), top: B:451:0x01b1 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ca A[Catch: all -> 0x01c3, SQLiteException -> 0x01c5, TRY_ENTER, TryCatch #16 {all -> 0x01c3, blocks: (B:60:0x01b1, B:62:0x01b7, B:68:0x01ca, B:69:0x01cf, B:70:0x01d9, B:71:0x01e9, B:76:0x0211, B:73:0x01f6, B:75:0x020a, B:89:0x0232), top: B:451:0x01b1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x021d A[LOOP:22: B:69:0x01cf->B:79:0x021d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x0255  */
    /* JADX WARN: Code duplicated, block: B:96:0x025b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0266  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v197, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r4v29, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v59, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v63, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67 */
    /* JADX WARN: Type inference failed for: r5v68 */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    public final List zza(String str, List list, List list2, Long l11, Long l12) throws Throwable {
        int i11;
        int i12;
        boolean z11;
        ?? r11;
        Map map;
        Cursor cursor;
        Cursor cursorQuery;
        Map map2;
        String str2;
        Map map3;
        Iterator it;
        String str3;
        String str4;
        int iIntValue;
        com.google.android.gms.internal.measurement.zzgi zzgiVar;
        BitSet bitSet;
        BitSet bitSet2;
        a aVar;
        List<com.google.android.gms.internal.measurement.zzek> list3;
        int i13;
        String str5;
        Long lValueOf;
        String str6;
        Map aVar2;
        SQLiteDatabase sQLiteDatabaseZzh;
        ?? r12;
        Cursor cursorRawQuery;
        a aVar3;
        Iterator it2;
        com.google.android.gms.internal.measurement.zzgi zzgiVar2;
        List list4;
        Map map4;
        Integer numValueOf;
        List arrayList;
        zzw zzwVar;
        a aVar4;
        Iterator it3;
        com.google.android.gms.internal.measurement.zzft zzftVar;
        com.google.android.gms.internal.measurement.zzft zzftVarZza;
        zzam zzamVarZzi;
        String str7;
        String strZzh;
        zzas zzasVarZzn;
        zzas zzasVar;
        long j11;
        String strZzh2;
        Map mapEmptyMap;
        String str8;
        Iterator it4;
        int iIntValue2;
        Set set;
        Integer numValueOf2;
        boolean zZzd;
        zzx zzxVar;
        String str9;
        a aVar5;
        Cursor cursor2;
        String str10;
        Cursor cursorQuery2;
        Integer numValueOf3;
        List list5;
        List arrayList2;
        String str11;
        ArrayList arrayList3;
        Iterator it5;
        zzam zzamVarZzi2;
        String str12;
        ContentValues contentValues;
        a aVar6;
        Iterator it6;
        String strZzf;
        Map mapEmptyMap2;
        Iterator it7;
        int iIntValue3;
        Set set2;
        Integer numValueOf4;
        Iterator it8;
        boolean zZzd2;
        com.google.android.gms.internal.measurement.zzet zzetVar;
        Integer numValueOf5;
        zzz zzzVar;
        Integer numValueOf6;
        zzam zzamVarZzi3;
        String str13;
        a aVar7;
        Cursor cursor3;
        Cursor cursorQuery3;
        Integer numValueOf7;
        List arrayList4;
        a aVar8;
        int i14;
        ?? r13;
        Cursor cursorQuery4;
        List arrayList5;
        String str14 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new a();
        this.zzd = l11;
        this.zze = l12;
        Iterator it9 = list.iterator();
        while (true) {
            i11 = 0;
            i12 = 1;
            if (!it9.hasNext()) {
                z11 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzft) it9.next()).zzh())) {
                z11 = true;
                break;
            }
        }
        zznz.zzc();
        boolean zZzs = this.zzt.zzf().zzs(this.zza, zzdu.zzW);
        zznz.zzc();
        boolean zZzs2 = this.zzt.zzf().zzs(this.zza, zzdu.zzV);
        if (z11) {
            zzam zzamVarZzi4 = this.zzf.zzi();
            String str15 = this.zza;
            zzamVarZzi4.zzW();
            zzamVarZzi4.zzg();
            Preconditions.checkNotEmpty(str15);
            ?? contentValues2 = new ContentValues();
            int i15 = 0;
            contentValues2.put("current_session_count", 0);
            try {
                i15 = new String[]{str15};
                zzamVarZzi4.zzh().update("events", contentValues2, "app_id = ?", i15);
                r11 = i15;
            } catch (SQLiteException e11) {
                zzamVarZzi4.zzt.zzay().zzd().zzc("Error resetting session-scoped event counts. appId", zzeh.zzn(str15), e11);
                r11 = i15;
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str16 = "Failed to merge filter. appId";
        String str17 = "Database error querying filters. appId";
        String str18 = "audience_id";
        if (zZzs2 && zZzs) {
            zzam zzamVarZzi5 = this.zzf.zzi();
            String str19 = this.zza;
            Preconditions.checkNotEmpty(str19);
            a aVar9 = new a();
            try {
                try {
                    cursorQuery4 = zzamVarZzi5.zzh().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str19}, null, null, null);
                    try {
                        if (cursorQuery4.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.zzek zzekVar = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzkv.zzl(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery4.getBlob(i12))).zzaC();
                                    if (zzekVar.zzo()) {
                                        Integer numValueOf8 = Integer.valueOf(cursorQuery4.getInt(i11));
                                        List list6 = (List) aVar9.get(numValueOf8);
                                        if (list6 == null) {
                                            arrayList5 = new ArrayList();
                                            aVar9.put(numValueOf8, arrayList5);
                                        } else {
                                            arrayList5 = list6;
                                        }
                                        arrayList5.add(zzekVar);
                                    }
                                } catch (IOException e12) {
                                    zzamVarZzi5.zzt.zzay().zzd().zzc("Failed to merge filter. appId", zzeh.zzn(str19), e12);
                                }
                                if (!cursorQuery4.moveToNext()) {
                                    break;
                                }
                                i11 = 0;
                                i12 = 1;
                            }
                            cursorQuery4.close();
                            map = aVar9;
                        } else {
                            mapEmptyMap3 = Collections.emptyMap();
                            cursorQuery4.close();
                            map = mapEmptyMap3;
                        }
                    } catch (SQLiteException e13) {
                        e = e13;
                        zzamVarZzi5.zzt.zzay().zzd().zzc("Database error querying filters. appId", zzeh.zzn(str19), e);
                        mapEmptyMap3 = Collections.emptyMap();
                        if (cursorQuery4 != null) {
                        }
                        map = mapEmptyMap3;
                        zzam zzamVarZzi6 = this.zzf.zzi();
                        String str20 = this.zza;
                        zzamVarZzi6.zzW();
                        zzamVarZzi6.zzg();
                        Preconditions.checkNotEmpty(str20);
                        cursorQuery = zzamVarZzi6.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str20}, null, null, null);
                        try {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    aVar8 = new a();
                                    while (true) {
                                        i14 = cursorQuery.getInt(0);
                                        try {
                                            aVar8.put(Integer.valueOf(i14), (com.google.android.gms.internal.measurement.zzgi) ((com.google.android.gms.internal.measurement.zzgh) zzkv.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursorQuery.getBlob(1))).zzaC());
                                        } catch (IOException e14) {
                                            zzamVarZzi6.zzt.zzay().zzd().zzd("Failed to merge filter results. appId, audienceId, error", zzeh.zzn(str20), Integer.valueOf(i14), e14);
                                        }
                                        try {
                                            if (!cursorQuery.moveToNext()) {
                                                break;
                                            }
                                            aVar8 = aVar8;
                                            str18 = str18;
                                        } catch (SQLiteException e15) {
                                            e = e15;
                                            zzamVarZzi6.zzt.zzay().zzd().zzc("Database error querying filter results. appId", zzeh.zzn(str20), e);
                                            Map mapEmptyMap4 = Collections.emptyMap();
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            map2 = mapEmptyMap4;
                                        }
                                    }
                                    cursorQuery.close();
                                    map2 = aVar8;
                                } else {
                                    Map mapEmptyMap5 = Collections.emptyMap();
                                    cursorQuery.close();
                                    map2 = mapEmptyMap5;
                                    str18 = "audience_id";
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e16) {
                            e = e16;
                            str18 = "audience_id";
                        }
                        if (map2.isEmpty()) {
                            str4 = "Database error querying filters. appId";
                            str3 = "Failed to merge filter. appId";
                        } else {
                            HashSet hashSet = new HashSet(map2.keySet());
                            if (z11) {
                                String str21 = this.zza;
                                zzam zzamVarZzi7 = this.zzf.zzi();
                                str6 = this.zza;
                                zzamVarZzi7.zzW();
                                zzamVarZzi7.zzg();
                                Preconditions.checkNotEmpty(str6);
                                aVar2 = new a();
                                sQLiteDatabaseZzh = zzamVarZzi7.zzh();
                                try {
                                    try {
                                        cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                                        try {
                                            if (cursorRawQuery.moveToFirst()) {
                                                do {
                                                    numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                    arrayList = (List) aVar2.get(numValueOf);
                                                    if (arrayList == null) {
                                                        arrayList = new ArrayList();
                                                        aVar2.put(numValueOf, arrayList);
                                                    }
                                                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                } while (cursorRawQuery.moveToNext());
                                            } else {
                                                aVar2 = Collections.emptyMap();
                                            }
                                        } catch (SQLiteException e17) {
                                            e = e17;
                                            zzamVarZzi7.zzt.zzay().zzd().zzc("Database error querying scoped filters. appId", zzeh.zzn(str6), e);
                                            aVar2 = Collections.emptyMap();
                                            if (cursorRawQuery != null) {
                                            }
                                            Preconditions.checkNotEmpty(str21);
                                            Preconditions.checkNotNull(map2);
                                            aVar3 = new a();
                                            if (!map2.isEmpty()) {
                                                it2 = map2.keySet().iterator();
                                                while (it2.hasNext()) {
                                                    int iIntValue4 = ((Integer) it2.next()).intValue();
                                                    Integer numValueOf9 = Integer.valueOf(iIntValue4);
                                                    zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf9);
                                                    list4 = (List) aVar2.get(numValueOf9);
                                                    if (list4 != null) {
                                                    }
                                                    map4 = aVar2;
                                                    aVar3.put(numValueOf9, zzgiVar2);
                                                    aVar2 = map4;
                                                    it2 = it2;
                                                    str17 = str17;
                                                }
                                            }
                                            str2 = str17;
                                            map3 = aVar3;
                                            it = hashSet.iterator();
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                                                bitSet = new BitSet();
                                                bitSet2 = new BitSet();
                                                aVar = new a();
                                                if (zzgiVar != null) {
                                                    for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzgiVar.zzj()) {
                                                        if (zzfrVar.zzh()) {
                                                            Integer numValueOf10 = Integer.valueOf(zzfrVar.zza());
                                                            if (zzfrVar.zzg()) {
                                                                lValueOf = Long.valueOf(zzfrVar.zzb());
                                                            } else {
                                                                lValueOf = null;
                                                            }
                                                            aVar.put(numValueOf10, lValueOf);
                                                        }
                                                    }
                                                }
                                                a aVar10 = new a();
                                                if (zzgiVar != null) {
                                                    for (com.google.android.gms.internal.measurement.zzgk zzgkVar : zzgiVar.zzm()) {
                                                        if (!zzgkVar.zzi()) {
                                                        }
                                                    }
                                                }
                                                Map map5 = map3;
                                                if (zzgiVar != null) {
                                                    i13 = 0;
                                                    while (i13 < zzgiVar.zzd() * 64) {
                                                        if (zzkv.zzv(zzgiVar.zzn(), i13)) {
                                                            str5 = str16;
                                                            this.zzt.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i13));
                                                            bitSet2.set(i13);
                                                            if (zzkv.zzv(zzgiVar.zzk(), i13)) {
                                                                bitSet.set(i13);
                                                            }
                                                            i13++;
                                                            str16 = str5;
                                                        } else {
                                                            str5 = str16;
                                                        }
                                                        aVar.remove(Integer.valueOf(i13));
                                                        i13++;
                                                        str16 = str5;
                                                    }
                                                }
                                                String str22 = str16;
                                                Integer numValueOf11 = Integer.valueOf(iIntValue);
                                                com.google.android.gms.internal.measurement.zzgi zzgiVar3 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf11);
                                                if (!zZzs2) {
                                                }
                                                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar3, bitSet, bitSet2, aVar, aVar10, null));
                                                str16 = str22;
                                                map = map;
                                                map3 = map5;
                                                map2 = map2;
                                            }
                                            str3 = str16;
                                            str4 = str2;
                                            if (!list.isEmpty()) {
                                                zzwVar = new zzw(this, null);
                                                aVar4 = new a();
                                                it3 = list.iterator();
                                                while (it3.hasNext()) {
                                                    zzftVar = (com.google.android.gms.internal.measurement.zzft) it3.next();
                                                    zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                                                    if (zzftVarZza != null) {
                                                        zzamVarZzi = this.zzf.zzi();
                                                        str7 = this.zza;
                                                        strZzh = zzftVarZza.zzh();
                                                        zzasVarZzn = zzamVarZzi.zzn(str7, zzftVar.zzh());
                                                        if (zzasVarZzn == null) {
                                                            zzamVarZzi.zzt.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeh.zzn(str7), zzamVarZzi.zzt.zzj().zzd(strZzh));
                                                            zzasVar = new zzas(str7, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                        } else {
                                                            zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                        }
                                                        this.zzf.zzi().zzE(zzasVar);
                                                        j11 = zzasVar.zzc;
                                                        strZzh2 = zzftVarZza.zzh();
                                                        mapEmptyMap = (Map) aVar4.get(strZzh2);
                                                        if (mapEmptyMap == null) {
                                                            zzam zzamVarZzi8 = this.zzf.zzi();
                                                            str9 = this.zza;
                                                            zzamVarZzi8.zzW();
                                                            zzamVarZzi8.zzg();
                                                            Preconditions.checkNotEmpty(str9);
                                                            Preconditions.checkNotEmpty(strZzh2);
                                                            aVar5 = new a();
                                                            SQLiteDatabase sQLiteDatabaseZzh2 = zzamVarZzi8.zzh();
                                                            try {
                                                                try {
                                                                    String[] strArr = new String[2];
                                                                    str10 = str18;
                                                                    try {
                                                                        strArr[0] = str10;
                                                                        strArr[1] = "data";
                                                                        str8 = str14;
                                                                        try {
                                                                            cursorQuery2 = sQLiteDatabaseZzh2.query("event_filters", strArr, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                                                                            try {
                                                                                try {
                                                                                    if (cursorQuery2.moveToFirst()) {
                                                                                        str18 = str10;
                                                                                        while (true) {
                                                                                            try {
                                                                                                try {
                                                                                                    com.google.android.gms.internal.measurement.zzek zzekVar2 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzkv.zzl(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                                                                    numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                                    list5 = (List) aVar5.get(numValueOf3);
                                                                                                    if (list5 == null) {
                                                                                                        zzasVar = zzasVar;
                                                                                                        try {
                                                                                                            arrayList2 = new ArrayList();
                                                                                                            aVar5.put(numValueOf3, arrayList2);
                                                                                                        } catch (SQLiteException e18) {
                                                                                                            e = e18;
                                                                                                            cursor2 = cursorQuery2;
                                                                                                            try {
                                                                                                                zzamVarZzi8.zzt.zzay().zzd().zzc(str4, zzeh.zzn(str9), e);
                                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                                if (cursor2 != null) {
                                                                                                                    cursor2.close();
                                                                                                                }
                                                                                                            } catch (Throwable th3) {
                                                                                                                th = th3;
                                                                                                                if (cursor2 != null) {
                                                                                                                    cursor2.close();
                                                                                                                }
                                                                                                                throw th;
                                                                                                            }
                                                                                                        }
                                                                                                    } else {
                                                                                                        zzasVar = zzasVar;
                                                                                                        arrayList2 = list5;
                                                                                                    }
                                                                                                    arrayList2.add(zzekVar2);
                                                                                                } catch (IOException e19) {
                                                                                                    zzasVar = zzasVar;
                                                                                                    zzamVarZzi8.zzt.zzay().zzd().zzc(str3, zzeh.zzn(str9), e19);
                                                                                                }
                                                                                                if (!cursorQuery2.moveToNext()) {
                                                                                                    break;
                                                                                                }
                                                                                                zzasVar = zzasVar;
                                                                                            } catch (SQLiteException e21) {
                                                                                                e = e21;
                                                                                                zzasVar = zzasVar;
                                                                                                cursor2 = cursorQuery2;
                                                                                                zzamVarZzi8.zzt.zzay().zzd().zzc(str4, zzeh.zzn(str9), e);
                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                if (cursor2 != null) {
                                                                                                    cursor2.close();
                                                                                                }
                                                                                                aVar4.put(strZzh2, mapEmptyMap);
                                                                                                it4 = mapEmptyMap.keySet().iterator();
                                                                                                while (it4.hasNext()) {
                                                                                                    iIntValue2 = ((Integer) it4.next()).intValue();
                                                                                                    set = this.zzb;
                                                                                                    numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                                    if (set.contains(numValueOf2)) {
                                                                                                        this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                                    } else {
                                                                                                        zZzd = true;
                                                                                                        for (com.google.android.gms.internal.measurement.zzek zzekVar3 : (List) mapEmptyMap.get(numValueOf2)) {
                                                                                                            zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                                                            zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j11, zzasVar, zzf(iIntValue2, zzekVar3.zzb()));
                                                                                                            if (zZzd) {
                                                                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                                break;
                                                                                                            }
                                                                                                            zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                                        }
                                                                                                        if (!zZzd) {
                                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                zzwVar = zzwVar;
                                                                                                it3 = it3;
                                                                                                str14 = str8;
                                                                                            }
                                                                                        }
                                                                                        cursorQuery2.close();
                                                                                        mapEmptyMap = aVar5;
                                                                                    } else {
                                                                                        str18 = str10;
                                                                                        zzasVar = zzasVar;
                                                                                        mapEmptyMap = Collections.emptyMap();
                                                                                        cursorQuery2.close();
                                                                                    }
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    cursor2 = cursorQuery2;
                                                                                    if (cursor2 != null) {
                                                                                        cursor2.close();
                                                                                    }
                                                                                    throw th;
                                                                                }
                                                                            } catch (SQLiteException e22) {
                                                                                e = e22;
                                                                                str18 = str10;
                                                                            }
                                                                        } catch (SQLiteException e23) {
                                                                            e = e23;
                                                                            str18 = str10;
                                                                            cursor2 = null;
                                                                            zzamVarZzi8.zzt.zzay().zzd().zzc(str4, zzeh.zzn(str9), e);
                                                                            mapEmptyMap = Collections.emptyMap();
                                                                            if (cursor2 != null) {
                                                                                cursor2.close();
                                                                            }
                                                                            aVar4.put(strZzh2, mapEmptyMap);
                                                                            it4 = mapEmptyMap.keySet().iterator();
                                                                            while (it4.hasNext()) {
                                                                                iIntValue2 = ((Integer) it4.next()).intValue();
                                                                                set = this.zzb;
                                                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                if (set.contains(numValueOf2)) {
                                                                                    this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                } else {
                                                                                    zZzd = true;
                                                                                    while (r5.hasNext()) {
                                                                                        zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                                        zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j11, zzasVar, zzf(iIntValue2, zzekVar3.zzb()));
                                                                                        if (zZzd) {
                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                            break;
                                                                                        }
                                                                                        zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                    }
                                                                                    if (!zZzd) {
                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                    }
                                                                                }
                                                                            }
                                                                            zzwVar = zzwVar;
                                                                            it3 = it3;
                                                                            str14 = str8;
                                                                        }
                                                                    } catch (SQLiteException e24) {
                                                                        e = e24;
                                                                        str18 = str10;
                                                                        str8 = str14;
                                                                        cursor2 = null;
                                                                        zzamVarZzi8.zzt.zzay().zzd().zzc(str4, zzeh.zzn(str9), e);
                                                                        mapEmptyMap = Collections.emptyMap();
                                                                        if (cursor2 != null) {
                                                                            cursor2.close();
                                                                        }
                                                                        aVar4.put(strZzh2, mapEmptyMap);
                                                                        it4 = mapEmptyMap.keySet().iterator();
                                                                        while (it4.hasNext()) {
                                                                            iIntValue2 = ((Integer) it4.next()).intValue();
                                                                            set = this.zzb;
                                                                            numValueOf2 = Integer.valueOf(iIntValue2);
                                                                            if (set.contains(numValueOf2)) {
                                                                                this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                            } else {
                                                                                zZzd = true;
                                                                                while (r5.hasNext()) {
                                                                                    zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                                    zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j11, zzasVar, zzf(iIntValue2, zzekVar3.zzb()));
                                                                                    if (zZzd) {
                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                        break;
                                                                                    }
                                                                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                }
                                                                                if (!zZzd) {
                                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                }
                                                                            }
                                                                        }
                                                                        zzwVar = zzwVar;
                                                                        it3 = it3;
                                                                        str14 = str8;
                                                                    }
                                                                } catch (SQLiteException e25) {
                                                                    e = e25;
                                                                }
                                                                aVar4.put(strZzh2, mapEmptyMap);
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                cursor2 = null;
                                                            }
                                                        } else {
                                                            zzasVar = zzasVar;
                                                            str8 = str14;
                                                        }
                                                        it4 = mapEmptyMap.keySet().iterator();
                                                        while (it4.hasNext()) {
                                                            iIntValue2 = ((Integer) it4.next()).intValue();
                                                            set = this.zzb;
                                                            numValueOf2 = Integer.valueOf(iIntValue2);
                                                            if (set.contains(numValueOf2)) {
                                                                this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                            } else {
                                                                zZzd = true;
                                                                while (r5.hasNext()) {
                                                                    zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                                    zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j11, zzasVar, zzf(iIntValue2, zzekVar3.zzb()));
                                                                    if (zZzd) {
                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                        break;
                                                                    }
                                                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                }
                                                                if (!zZzd) {
                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                }
                                                            }
                                                        }
                                                        zzwVar = zzwVar;
                                                        it3 = it3;
                                                        str14 = str8;
                                                    }
                                                }
                                            }
                                            str11 = str14;
                                            if (!list2.isEmpty()) {
                                                aVar6 = new a();
                                                it6 = list2.iterator();
                                                while (it6.hasNext()) {
                                                    com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                                                    strZzf = zzgmVar.zzf();
                                                    mapEmptyMap2 = (Map) aVar6.get(strZzf);
                                                    if (mapEmptyMap2 == null) {
                                                        zzamVarZzi3 = this.zzf.zzi();
                                                        str13 = this.zza;
                                                        zzamVarZzi3.zzW();
                                                        zzamVarZzi3.zzg();
                                                        Preconditions.checkNotEmpty(str13);
                                                        Preconditions.checkNotEmpty(strZzf);
                                                        aVar7 = new a();
                                                        try {
                                                            cursorQuery3 = zzamVarZzi3.zzh().query("property_filters", new String[]{str18, "data"}, "app_id=? AND property_name=?", new String[]{str13, strZzf}, null, null, null);
                                                            try {
                                                                try {
                                                                    if (cursorQuery3.moveToFirst()) {
                                                                        do {
                                                                            try {
                                                                                com.google.android.gms.internal.measurement.zzet zzetVar2 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzkv.zzl(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                                                                try {
                                                                                    numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                    arrayList4 = (List) aVar7.get(numValueOf7);
                                                                                    if (arrayList4 == null) {
                                                                                        arrayList4 = new ArrayList();
                                                                                        aVar7.put(numValueOf7, arrayList4);
                                                                                    }
                                                                                    arrayList4.add(zzetVar2);
                                                                                } catch (SQLiteException e26) {
                                                                                    e = e26;
                                                                                    zzamVarZzi3.zzt.zzay().zzd().zzc(str4, zzeh.zzn(str13), e);
                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                    if (cursorQuery3 != null) {
                                                                                        cursorQuery3.close();
                                                                                    }
                                                                                }
                                                                            } catch (IOException e27) {
                                                                                zzamVarZzi3.zzt.zzay().zzd().zzc("Failed to merge filter", zzeh.zzn(str13), e27);
                                                                            }
                                                                        } while (cursorQuery3.moveToNext());
                                                                        cursorQuery3.close();
                                                                        mapEmptyMap2 = aVar7;
                                                                    } else {
                                                                        mapEmptyMap2 = Collections.emptyMap();
                                                                        cursorQuery3.close();
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    cursor3 = cursorQuery3;
                                                                    if (cursor3 != null) {
                                                                        cursor3.close();
                                                                    }
                                                                    throw th;
                                                                }
                                                            } catch (SQLiteException e28) {
                                                                e = e28;
                                                            }
                                                        } catch (SQLiteException e29) {
                                                            e = e29;
                                                            cursorQuery3 = null;
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            cursor3 = null;
                                                        }
                                                        aVar6.put(strZzf, mapEmptyMap2);
                                                    }
                                                    it7 = mapEmptyMap2.keySet().iterator();
                                                    while (it7.hasNext()) {
                                                        iIntValue3 = ((Integer) it7.next()).intValue();
                                                        set2 = this.zzb;
                                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                                        if (set2.contains(numValueOf4)) {
                                                            this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                            break;
                                                        }
                                                        it8 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                        zZzd2 = true;
                                                        while (true) {
                                                            if (it8.hasNext()) {
                                                                zzetVar = (com.google.android.gms.internal.measurement.zzet) it8.next();
                                                                if (Log.isLoggable(this.zzt.zzay().zzq(), 2)) {
                                                                    zzef zzefVarZzj = this.zzt.zzay().zzj();
                                                                    Integer numValueOf12 = Integer.valueOf(iIntValue3);
                                                                    if (zzetVar.zzj()) {
                                                                        numValueOf6 = Integer.valueOf(zzetVar.zza());
                                                                    } else {
                                                                        numValueOf6 = null;
                                                                    }
                                                                    zzefVarZzj.zzd("Evaluating filter. audience, filter, property", numValueOf12, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                                                    this.zzt.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzetVar));
                                                                }
                                                                if (zzetVar.zzj()) {
                                                                }
                                                                zzef zzefVarZzk = this.zzt.zzay().zzk();
                                                                Object objZzn = zzeh.zzn(this.zza);
                                                                if (zzetVar.zzj()) {
                                                                    numValueOf5 = Integer.valueOf(zzetVar.zza());
                                                                } else {
                                                                    numValueOf5 = null;
                                                                }
                                                                zzefVarZzk.zzc("Invalid property filter ID. appId, id", objZzn, String.valueOf(numValueOf5));
                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                            }
                                                            if (!zZzd2) {
                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                            }
                                                            zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                        }
                                                    }
                                                }
                                            }
                                            arrayList3 = new ArrayList();
                                            Set setKeySet = this.zzc.keySet();
                                            setKeySet.removeAll(this.zzb);
                                            it5 = setKeySet.iterator();
                                            while (it5.hasNext()) {
                                                int iIntValue5 = ((Integer) it5.next()).intValue();
                                                Map map6 = this.zzc;
                                                Integer numValueOf13 = Integer.valueOf(iIntValue5);
                                                zzu zzuVar = (zzu) map6.get(numValueOf13);
                                                Preconditions.checkNotNull(zzuVar);
                                                com.google.android.gms.internal.measurement.zzfp zzfpVarZza = zzuVar.zza(iIntValue5);
                                                arrayList3.add(zzfpVarZza);
                                                zzamVarZzi2 = this.zzf.zzi();
                                                str12 = this.zza;
                                                com.google.android.gms.internal.measurement.zzgi zzgiVarZzd = zzfpVarZza.zzd();
                                                zzamVarZzi2.zzW();
                                                zzamVarZzi2.zzg();
                                                Preconditions.checkNotEmpty(str12);
                                                Preconditions.checkNotNull(zzgiVarZzd);
                                                byte[] bArrZzbu = zzgiVarZzd.zzbu();
                                                contentValues = new ContentValues();
                                                contentValues.put("app_id", str12);
                                                String str23 = str18;
                                                contentValues.put(str23, numValueOf13);
                                                String str24 = str11;
                                                contentValues.put(str24, bArrZzbu);
                                                try {
                                                    try {
                                                        if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                            zzamVarZzi2.zzt.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeh.zzn(str12));
                                                        }
                                                    } catch (SQLiteException e31) {
                                                        e = e31;
                                                        zzamVarZzi2.zzt.zzay().zzd().zzc("Error storing filter results. appId", zzeh.zzn(str12), e);
                                                    }
                                                } catch (SQLiteException e32) {
                                                    e = e32;
                                                }
                                                str11 = str24;
                                                str18 = str23;
                                            }
                                            return arrayList3;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        r12 = sQLiteDatabaseZzh;
                                        if (r12 != 0) {
                                            r12.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e33) {
                                    e = e33;
                                    cursorRawQuery = null;
                                } catch (Throwable th9) {
                                    th = th9;
                                    r12 = 0;
                                    if (r12 != 0) {
                                        r12.close();
                                    }
                                    throw th;
                                }
                                cursorRawQuery.close();
                                Preconditions.checkNotEmpty(str21);
                                Preconditions.checkNotNull(map2);
                                aVar3 = new a();
                                if (!map2.isEmpty()) {
                                    it2 = map2.keySet().iterator();
                                    while (it2.hasNext()) {
                                        int iIntValue6 = ((Integer) it2.next()).intValue();
                                        Integer numValueOf14 = Integer.valueOf(iIntValue6);
                                        zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf14);
                                        list4 = (List) aVar2.get(numValueOf14);
                                        if (list4 != null) {
                                        }
                                        map4 = aVar2;
                                        aVar3.put(numValueOf14, zzgiVar2);
                                        aVar2 = map4;
                                        it2 = it2;
                                        str17 = str17;
                                    }
                                }
                                str2 = str17;
                                map3 = aVar3;
                            } else {
                                str2 = "Database error querying filters. appId";
                                map3 = map2;
                            }
                            it = hashSet.iterator();
                            while (it.hasNext()) {
                                iIntValue = ((Integer) it.next()).intValue();
                                zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                                bitSet = new BitSet();
                                bitSet2 = new BitSet();
                                aVar = new a();
                                if (zzgiVar != null) {
                                    while (r2.hasNext()) {
                                        if (zzfrVar.zzh()) {
                                            Integer numValueOf15 = Integer.valueOf(zzfrVar.zza());
                                            if (zzfrVar.zzg()) {
                                                lValueOf = Long.valueOf(zzfrVar.zzb());
                                            } else {
                                                lValueOf = null;
                                            }
                                            aVar.put(numValueOf15, lValueOf);
                                        }
                                    }
                                }
                                a aVar11 = new a();
                                if (zzgiVar != null) {
                                    while (r2.hasNext()) {
                                        if (!zzgkVar.zzi()) {
                                        }
                                    }
                                }
                                Map map7 = map3;
                                if (zzgiVar != null) {
                                    i13 = 0;
                                    while (i13 < zzgiVar.zzd() * 64) {
                                        if (zzkv.zzv(zzgiVar.zzn(), i13)) {
                                            str5 = str16;
                                            this.zzt.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i13));
                                            bitSet2.set(i13);
                                            if (zzkv.zzv(zzgiVar.zzk(), i13)) {
                                                bitSet.set(i13);
                                            }
                                            i13++;
                                            str16 = str5;
                                        } else {
                                            str5 = str16;
                                        }
                                        aVar.remove(Integer.valueOf(i13));
                                        i13++;
                                        str16 = str5;
                                    }
                                }
                                String str25 = str16;
                                Integer numValueOf16 = Integer.valueOf(iIntValue);
                                com.google.android.gms.internal.measurement.zzgi zzgiVar4 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf16);
                                if (!zZzs2) {
                                }
                                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar4, bitSet, bitSet2, aVar, aVar11, null));
                                str16 = str25;
                                map = map;
                                map3 = map7;
                                map2 = map2;
                            }
                            str3 = str16;
                            str4 = str2;
                        }
                        if (!list.isEmpty()) {
                            zzwVar = new zzw(this, null);
                            aVar4 = new a();
                            it3 = list.iterator();
                            while (it3.hasNext()) {
                                zzftVar = (com.google.android.gms.internal.measurement.zzft) it3.next();
                                zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                                if (zzftVarZza != null) {
                                    zzamVarZzi = this.zzf.zzi();
                                    str7 = this.zza;
                                    strZzh = zzftVarZza.zzh();
                                    zzasVarZzn = zzamVarZzi.zzn(str7, zzftVar.zzh());
                                    if (zzasVarZzn == null) {
                                        zzamVarZzi.zzt.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeh.zzn(str7), zzamVarZzi.zzt.zzj().zzd(strZzh));
                                        zzasVar = new zzas(str7, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                    } else {
                                        zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                    }
                                    this.zzf.zzi().zzE(zzasVar);
                                    j11 = zzasVar.zzc;
                                    strZzh2 = zzftVarZza.zzh();
                                    mapEmptyMap = (Map) aVar4.get(strZzh2);
                                    if (mapEmptyMap == null) {
                                        zzam zzamVarZzi9 = this.zzf.zzi();
                                        str9 = this.zza;
                                        zzamVarZzi9.zzW();
                                        zzamVarZzi9.zzg();
                                        Preconditions.checkNotEmpty(str9);
                                        Preconditions.checkNotEmpty(strZzh2);
                                        aVar5 = new a();
                                        SQLiteDatabase sQLiteDatabaseZzh3 = zzamVarZzi9.zzh();
                                        String[] strArr2 = new String[2];
                                        str10 = str18;
                                        strArr2[0] = str10;
                                        strArr2[1] = "data";
                                        str8 = str14;
                                        cursorQuery2 = sQLiteDatabaseZzh3.query("event_filters", strArr2, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                                        if (cursorQuery2.moveToFirst()) {
                                            str18 = str10;
                                            while (true) {
                                                com.google.android.gms.internal.measurement.zzek zzekVar4 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzkv.zzl(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                list5 = (List) aVar5.get(numValueOf3);
                                                if (list5 == null) {
                                                    zzasVar = zzasVar;
                                                    arrayList2 = new ArrayList();
                                                    aVar5.put(numValueOf3, arrayList2);
                                                } else {
                                                    zzasVar = zzasVar;
                                                    arrayList2 = list5;
                                                }
                                                arrayList2.add(zzekVar4);
                                                if (!cursorQuery2.moveToNext()) {
                                                    break;
                                                    break;
                                                }
                                                zzasVar = zzasVar;
                                            }
                                            cursorQuery2.close();
                                            mapEmptyMap = aVar5;
                                        } else {
                                            str18 = str10;
                                            zzasVar = zzasVar;
                                            mapEmptyMap = Collections.emptyMap();
                                            cursorQuery2.close();
                                        }
                                        aVar4.put(strZzh2, mapEmptyMap);
                                    } else {
                                        zzasVar = zzasVar;
                                        str8 = str14;
                                    }
                                    it4 = mapEmptyMap.keySet().iterator();
                                    while (it4.hasNext()) {
                                        iIntValue2 = ((Integer) it4.next()).intValue();
                                        set = this.zzb;
                                        numValueOf2 = Integer.valueOf(iIntValue2);
                                        if (set.contains(numValueOf2)) {
                                            this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                        } else {
                                            zZzd = true;
                                            while (r5.hasNext()) {
                                                zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                                zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j11, zzasVar, zzf(iIntValue2, zzekVar3.zzb()));
                                                if (zZzd) {
                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                    break;
                                                }
                                                zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                            }
                                            if (!zZzd) {
                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                            }
                                        }
                                    }
                                    zzwVar = zzwVar;
                                    it3 = it3;
                                    str14 = str8;
                                }
                            }
                        }
                        str11 = str14;
                        if (!list2.isEmpty()) {
                            aVar6 = new a();
                            it6 = list2.iterator();
                            while (it6.hasNext()) {
                                com.google.android.gms.internal.measurement.zzgm zzgmVar2 = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                                strZzf = zzgmVar2.zzf();
                                mapEmptyMap2 = (Map) aVar6.get(strZzf);
                                if (mapEmptyMap2 == null) {
                                    zzamVarZzi3 = this.zzf.zzi();
                                    str13 = this.zza;
                                    zzamVarZzi3.zzW();
                                    zzamVarZzi3.zzg();
                                    Preconditions.checkNotEmpty(str13);
                                    Preconditions.checkNotEmpty(strZzf);
                                    aVar7 = new a();
                                    cursorQuery3 = zzamVarZzi3.zzh().query("property_filters", new String[]{str18, "data"}, "app_id=? AND property_name=?", new String[]{str13, strZzf}, null, null, null);
                                    if (cursorQuery3.moveToFirst()) {
                                        do {
                                            com.google.android.gms.internal.measurement.zzet zzetVar3 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzkv.zzl(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                            numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                            arrayList4 = (List) aVar7.get(numValueOf7);
                                            if (arrayList4 == null) {
                                                arrayList4 = new ArrayList();
                                                aVar7.put(numValueOf7, arrayList4);
                                            }
                                            arrayList4.add(zzetVar3);
                                        } while (cursorQuery3.moveToNext());
                                        cursorQuery3.close();
                                        mapEmptyMap2 = aVar7;
                                    } else {
                                        mapEmptyMap2 = Collections.emptyMap();
                                        cursorQuery3.close();
                                    }
                                    aVar6.put(strZzf, mapEmptyMap2);
                                }
                                it7 = mapEmptyMap2.keySet().iterator();
                                while (it7.hasNext()) {
                                    iIntValue3 = ((Integer) it7.next()).intValue();
                                    set2 = this.zzb;
                                    numValueOf4 = Integer.valueOf(iIntValue3);
                                    if (set2.contains(numValueOf4)) {
                                        this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                        break;
                                        break;
                                    }
                                    it8 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                    zZzd2 = true;
                                    while (true) {
                                        if (it8.hasNext()) {
                                            zzetVar = (com.google.android.gms.internal.measurement.zzet) it8.next();
                                            if (Log.isLoggable(this.zzt.zzay().zzq(), 2)) {
                                                zzef zzefVarZzj2 = this.zzt.zzay().zzj();
                                                Integer numValueOf17 = Integer.valueOf(iIntValue3);
                                                if (zzetVar.zzj()) {
                                                    numValueOf6 = Integer.valueOf(zzetVar.zza());
                                                } else {
                                                    numValueOf6 = null;
                                                }
                                                zzefVarZzj2.zzd("Evaluating filter. audience, filter, property", numValueOf17, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                                this.zzt.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzetVar));
                                            }
                                            if (zzetVar.zzj()) {
                                            }
                                            zzef zzefVarZzk2 = this.zzt.zzay().zzk();
                                            Object objZzn2 = zzeh.zzn(this.zza);
                                            if (zzetVar.zzj()) {
                                                numValueOf5 = Integer.valueOf(zzetVar.zza());
                                            } else {
                                                numValueOf5 = null;
                                            }
                                            zzefVarZzk2.zzc("Invalid property filter ID. appId, id", objZzn2, String.valueOf(numValueOf5));
                                            this.zzb.add(Integer.valueOf(iIntValue3));
                                        }
                                        if (!zZzd2) {
                                            this.zzb.add(Integer.valueOf(iIntValue3));
                                        }
                                        zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                    }
                                }
                            }
                        }
                        arrayList3 = new ArrayList();
                        Set setKeySet2 = this.zzc.keySet();
                        setKeySet2.removeAll(this.zzb);
                        it5 = setKeySet2.iterator();
                        while (it5.hasNext()) {
                            int iIntValue7 = ((Integer) it5.next()).intValue();
                            Map map8 = this.zzc;
                            Integer numValueOf18 = Integer.valueOf(iIntValue7);
                            zzu zzuVar2 = (zzu) map8.get(numValueOf18);
                            Preconditions.checkNotNull(zzuVar2);
                            com.google.android.gms.internal.measurement.zzfp zzfpVarZza2 = zzuVar2.zza(iIntValue7);
                            arrayList3.add(zzfpVarZza2);
                            zzamVarZzi2 = this.zzf.zzi();
                            str12 = this.zza;
                            com.google.android.gms.internal.measurement.zzgi zzgiVarZzd2 = zzfpVarZza2.zzd();
                            zzamVarZzi2.zzW();
                            zzamVarZzi2.zzg();
                            Preconditions.checkNotEmpty(str12);
                            Preconditions.checkNotNull(zzgiVarZzd2);
                            byte[] bArrZzbu2 = zzgiVarZzd2.zzbu();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str12);
                            String str26 = str18;
                            contentValues.put(str26, numValueOf18);
                            String str27 = str11;
                            contentValues.put(str27, bArrZzbu2);
                            if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                zzamVarZzi2.zzt.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeh.zzn(str12));
                            }
                            str11 = str27;
                            str18 = str26;
                        }
                        return arrayList3;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    r13 = r11;
                    if (r13 != 0) {
                        r13.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e34) {
                e = e34;
                cursorQuery4 = null;
            } catch (Throwable th11) {
                th = th11;
                r13 = 0;
                if (r13 != 0) {
                    r13.close();
                }
                throw th;
            }
        } else {
            map = mapEmptyMap3;
        }
        zzam zzamVarZzi10 = this.zzf.zzi();
        String str28 = this.zza;
        zzamVarZzi10.zzW();
        zzamVarZzi10.zzg();
        Preconditions.checkNotEmpty(str28);
        try {
            cursorQuery = zzamVarZzi10.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str28}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                Map mapEmptyMap6 = Collections.emptyMap();
                cursorQuery.close();
                map2 = mapEmptyMap6;
                str18 = "audience_id";
            } else {
                aVar8 = new a();
                while (true) {
                    i14 = cursorQuery.getInt(0);
                    aVar8.put(Integer.valueOf(i14), (com.google.android.gms.internal.measurement.zzgi) ((com.google.android.gms.internal.measurement.zzgh) zzkv.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursorQuery.getBlob(1))).zzaC());
                    if (!cursorQuery.moveToNext()) {
                        break;
                        break;
                    }
                    aVar8 = aVar8;
                    str18 = str18;
                }
                cursorQuery.close();
                map2 = aVar8;
            }
        } catch (SQLiteException e35) {
            e = e35;
            str18 = "audience_id";
            cursorQuery = null;
        } catch (Throwable th12) {
            th = th12;
            cursor = null;
        }
        if (map2.isEmpty()) {
            str4 = "Database error querying filters. appId";
            str3 = "Failed to merge filter. appId";
        } else {
            HashSet hashSet2 = new HashSet(map2.keySet());
            if (z11) {
                String str29 = this.zza;
                zzam zzamVarZzi11 = this.zzf.zzi();
                str6 = this.zza;
                zzamVarZzi11.zzW();
                zzamVarZzi11.zzg();
                Preconditions.checkNotEmpty(str6);
                aVar2 = new a();
                sQLiteDatabaseZzh = zzamVarZzi11.zzh();
                cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                        arrayList = (List) aVar2.get(numValueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            aVar2.put(numValueOf, arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                } else {
                    aVar2 = Collections.emptyMap();
                }
                cursorRawQuery.close();
                Preconditions.checkNotEmpty(str29);
                Preconditions.checkNotNull(map2);
                aVar3 = new a();
                if (!map2.isEmpty()) {
                    it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue8 = ((Integer) it2.next()).intValue();
                        Integer numValueOf19 = Integer.valueOf(iIntValue8);
                        zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf19);
                        list4 = (List) aVar2.get(numValueOf19);
                        if (list4 != null || list4.isEmpty()) {
                            map4 = aVar2;
                            aVar3.put(numValueOf19, zzgiVar2);
                            aVar2 = map4;
                            it2 = it2;
                            str17 = str17;
                        } else {
                            map4 = aVar2;
                            List listZzq = this.zzf.zzu().zzq(zzgiVar2.zzk(), list4);
                            if (listZzq.isEmpty()) {
                                aVar2 = map4;
                            } else {
                                com.google.android.gms.internal.measurement.zzgh zzghVar = (com.google.android.gms.internal.measurement.zzgh) zzgiVar2.zzby();
                                zzghVar.zzf();
                                zzghVar.zzb(listZzq);
                                List listZzq2 = this.zzf.zzu().zzq(zzgiVar2.zzn(), list4);
                                zzghVar.zzh();
                                zzghVar.zzd(listZzq2);
                                zzoc.zzc();
                                if (this.zzt.zzf().zzs(null, zzdu.zzas)) {
                                    ArrayList arrayList6 = new ArrayList();
                                    Iterator it10 = zzgiVar2.zzj().iterator();
                                    while (it10.hasNext()) {
                                        com.google.android.gms.internal.measurement.zzfr zzfrVar2 = (com.google.android.gms.internal.measurement.zzfr) it10.next();
                                        Iterator it11 = it10;
                                        if (!list4.contains(Integer.valueOf(zzfrVar2.zza()))) {
                                            arrayList6.add(zzfrVar2);
                                        }
                                        it10 = it11;
                                    }
                                    zzghVar.zze();
                                    zzghVar.zza(arrayList6);
                                    ArrayList arrayList7 = new ArrayList();
                                    for (com.google.android.gms.internal.measurement.zzgk zzgkVar2 : zzgiVar2.zzm()) {
                                        if (!list4.contains(Integer.valueOf(zzgkVar2.zzb()))) {
                                            arrayList7.add(zzgkVar2);
                                        }
                                    }
                                    zzghVar.zzg();
                                    zzghVar.zzc(arrayList7);
                                } else {
                                    for (int i16 = 0; i16 < zzgiVar2.zza(); i16++) {
                                        if (list4.contains(Integer.valueOf(zzgiVar2.zze(i16).zza()))) {
                                            zzghVar.zzi(i16);
                                        }
                                    }
                                    for (int i17 = 0; i17 < zzgiVar2.zzc(); i17++) {
                                        if (list4.contains(Integer.valueOf(zzgiVar2.zzi(i17).zzb()))) {
                                            zzghVar.zzj(i17);
                                        }
                                    }
                                }
                                aVar3.put(Integer.valueOf(iIntValue8), (com.google.android.gms.internal.measurement.zzgi) zzghVar.zzaC());
                                aVar2 = map4;
                                it2 = it2;
                                str17 = str17;
                            }
                        }
                    }
                }
                str2 = str17;
                map3 = aVar3;
            } else {
                str2 = "Database error querying filters. appId";
                map3 = map2;
            }
            it = hashSet2.iterator();
            while (it.hasNext()) {
                iIntValue = ((Integer) it.next()).intValue();
                zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map3.get(Integer.valueOf(iIntValue));
                bitSet = new BitSet();
                bitSet2 = new BitSet();
                aVar = new a();
                if (zzgiVar != null && zzgiVar.zza() != 0) {
                    while (r2.hasNext()) {
                        if (zzfrVar.zzh()) {
                            Integer numValueOf110 = Integer.valueOf(zzfrVar.zza());
                            if (zzfrVar.zzg()) {
                                lValueOf = Long.valueOf(zzfrVar.zzb());
                            } else {
                                lValueOf = null;
                            }
                            aVar.put(numValueOf110, lValueOf);
                        }
                    }
                }
                a aVar12 = new a();
                if (zzgiVar != null && zzgiVar.zzc() != 0) {
                    while (r2.hasNext()) {
                        if (!zzgkVar.zzi() && zzgkVar.zza() > 0) {
                            aVar12.put(Integer.valueOf(zzgkVar.zzb()), Long.valueOf(zzgkVar.zzc(zzgkVar.zza() - 1)));
                            map3 = map3;
                        }
                    }
                }
                Map map9 = map3;
                if (zzgiVar != null) {
                    i13 = 0;
                    while (i13 < zzgiVar.zzd() * 64) {
                        if (zzkv.zzv(zzgiVar.zzn(), i13)) {
                            str5 = str16;
                            this.zzt.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i13));
                            bitSet2.set(i13);
                            if (zzkv.zzv(zzgiVar.zzk(), i13)) {
                                bitSet.set(i13);
                            }
                            i13++;
                            str16 = str5;
                        } else {
                            str5 = str16;
                        }
                        aVar.remove(Integer.valueOf(i13));
                        i13++;
                        str16 = str5;
                    }
                }
                String str210 = str16;
                Integer numValueOf111 = Integer.valueOf(iIntValue);
                com.google.android.gms.internal.measurement.zzgi zzgiVar5 = (com.google.android.gms.internal.measurement.zzgi) map2.get(numValueOf111);
                if (!zZzs2 && zZzs && (list3 = (List) map.get(numValueOf111)) != null && this.zze != null && this.zzd != null) {
                    for (com.google.android.gms.internal.measurement.zzek zzekVar5 : list3) {
                        int iZzb = zzekVar5.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzekVar5.zzm()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        Integer numValueOf20 = Integer.valueOf(iZzb);
                        if (aVar.containsKey(numValueOf20)) {
                            aVar.put(numValueOf20, Long.valueOf(jLongValue));
                        }
                        if (aVar12.containsKey(numValueOf20)) {
                            aVar12.put(numValueOf20, Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzgiVar5, bitSet, bitSet2, aVar, aVar12, null));
                str16 = str210;
                map = map;
                map3 = map9;
                map2 = map2;
            }
            str3 = str16;
            str4 = str2;
        }
        if (!list.isEmpty()) {
            zzwVar = new zzw(this, null);
            aVar4 = new a();
            it3 = list.iterator();
            while (it3.hasNext()) {
                zzftVar = (com.google.android.gms.internal.measurement.zzft) it3.next();
                zzftVarZza = zzwVar.zza(this.zza, zzftVar);
                if (zzftVarZza != null) {
                    zzamVarZzi = this.zzf.zzi();
                    str7 = this.zza;
                    strZzh = zzftVarZza.zzh();
                    zzasVarZzn = zzamVarZzi.zzn(str7, zzftVar.zzh());
                    if (zzasVarZzn == null) {
                        zzamVarZzi.zzt.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeh.zzn(str7), zzamVarZzi.zzt.zzj().zzd(strZzh));
                        zzasVar = new zzas(str7, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                    } else {
                        zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                    }
                    this.zzf.zzi().zzE(zzasVar);
                    j11 = zzasVar.zzc;
                    strZzh2 = zzftVarZza.zzh();
                    mapEmptyMap = (Map) aVar4.get(strZzh2);
                    if (mapEmptyMap == null) {
                        zzam zzamVarZzi12 = this.zzf.zzi();
                        str9 = this.zza;
                        zzamVarZzi12.zzW();
                        zzamVarZzi12.zzg();
                        Preconditions.checkNotEmpty(str9);
                        Preconditions.checkNotEmpty(strZzh2);
                        aVar5 = new a();
                        SQLiteDatabase sQLiteDatabaseZzh4 = zzamVarZzi12.zzh();
                        String[] strArr3 = new String[2];
                        str10 = str18;
                        strArr3[0] = str10;
                        strArr3[1] = "data";
                        str8 = str14;
                        cursorQuery2 = sQLiteDatabaseZzh4.query("event_filters", strArr3, "app_id=? AND event_name=?", new String[]{str9, strZzh2}, null, null, null);
                        if (cursorQuery2.moveToFirst()) {
                            str18 = str10;
                            while (true) {
                                com.google.android.gms.internal.measurement.zzek zzekVar6 = (com.google.android.gms.internal.measurement.zzek) ((com.google.android.gms.internal.measurement.zzej) zzkv.zzl(com.google.android.gms.internal.measurement.zzek.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                list5 = (List) aVar5.get(numValueOf3);
                                if (list5 == null) {
                                    zzasVar = zzasVar;
                                    arrayList2 = new ArrayList();
                                    aVar5.put(numValueOf3, arrayList2);
                                } else {
                                    zzasVar = zzasVar;
                                    arrayList2 = list5;
                                }
                                arrayList2.add(zzekVar6);
                                if (!cursorQuery2.moveToNext()) {
                                    break;
                                    break;
                                }
                                zzasVar = zzasVar;
                            }
                            cursorQuery2.close();
                            mapEmptyMap = aVar5;
                        } else {
                            str18 = str10;
                            zzasVar = zzasVar;
                            mapEmptyMap = Collections.emptyMap();
                            cursorQuery2.close();
                        }
                        aVar4.put(strZzh2, mapEmptyMap);
                    } else {
                        zzasVar = zzasVar;
                        str8 = str14;
                    }
                    it4 = mapEmptyMap.keySet().iterator();
                    while (it4.hasNext()) {
                        iIntValue2 = ((Integer) it4.next()).intValue();
                        set = this.zzb;
                        numValueOf2 = Integer.valueOf(iIntValue2);
                        if (set.contains(numValueOf2)) {
                            this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                        } else {
                            zZzd = true;
                            while (r5.hasNext()) {
                                zzxVar = new zzx(this, this.zza, iIntValue2, zzekVar3);
                                zZzd = zzxVar.zzd(this.zzd, this.zze, zzftVarZza, j11, zzasVar, zzf(iIntValue2, zzekVar3.zzb()));
                                if (zZzd) {
                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                    break;
                                }
                                zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                            }
                            if (!zZzd) {
                                this.zzb.add(Integer.valueOf(iIntValue2));
                            }
                        }
                    }
                    zzwVar = zzwVar;
                    it3 = it3;
                    str14 = str8;
                }
            }
        }
        str11 = str14;
        if (!list2.isEmpty()) {
            aVar6 = new a();
            it6 = list2.iterator();
            while (it6.hasNext()) {
                com.google.android.gms.internal.measurement.zzgm zzgmVar3 = (com.google.android.gms.internal.measurement.zzgm) it6.next();
                strZzf = zzgmVar3.zzf();
                mapEmptyMap2 = (Map) aVar6.get(strZzf);
                if (mapEmptyMap2 == null) {
                    zzamVarZzi3 = this.zzf.zzi();
                    str13 = this.zza;
                    zzamVarZzi3.zzW();
                    zzamVarZzi3.zzg();
                    Preconditions.checkNotEmpty(str13);
                    Preconditions.checkNotEmpty(strZzf);
                    aVar7 = new a();
                    cursorQuery3 = zzamVarZzi3.zzh().query("property_filters", new String[]{str18, "data"}, "app_id=? AND property_name=?", new String[]{str13, strZzf}, null, null, null);
                    if (cursorQuery3.moveToFirst()) {
                        do {
                            com.google.android.gms.internal.measurement.zzet zzetVar4 = (com.google.android.gms.internal.measurement.zzet) ((com.google.android.gms.internal.measurement.zzes) zzkv.zzl(com.google.android.gms.internal.measurement.zzet.zzc(), cursorQuery3.getBlob(1))).zzaC();
                            numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                            arrayList4 = (List) aVar7.get(numValueOf7);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                                aVar7.put(numValueOf7, arrayList4);
                            }
                            arrayList4.add(zzetVar4);
                        } while (cursorQuery3.moveToNext());
                        cursorQuery3.close();
                        mapEmptyMap2 = aVar7;
                    } else {
                        mapEmptyMap2 = Collections.emptyMap();
                        cursorQuery3.close();
                    }
                    aVar6.put(strZzf, mapEmptyMap2);
                }
                it7 = mapEmptyMap2.keySet().iterator();
                while (it7.hasNext()) {
                    iIntValue3 = ((Integer) it7.next()).intValue();
                    set2 = this.zzb;
                    numValueOf4 = Integer.valueOf(iIntValue3);
                    if (set2.contains(numValueOf4)) {
                        this.zzt.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                        break;
                        break;
                    }
                    it8 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                    zZzd2 = true;
                    while (true) {
                        if (it8.hasNext()) {
                            zzetVar = (com.google.android.gms.internal.measurement.zzet) it8.next();
                            if (Log.isLoggable(this.zzt.zzay().zzq(), 2)) {
                                zzef zzefVarZzj3 = this.zzt.zzay().zzj();
                                Integer numValueOf112 = Integer.valueOf(iIntValue3);
                                if (zzetVar.zzj()) {
                                    numValueOf6 = Integer.valueOf(zzetVar.zza());
                                } else {
                                    numValueOf6 = null;
                                }
                                zzefVarZzj3.zzd("Evaluating filter. audience, filter, property", numValueOf112, numValueOf6, this.zzt.zzj().zzf(zzetVar.zze()));
                                this.zzt.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzetVar));
                            }
                            if (zzetVar.zzj() || zzetVar.zza() > 256) {
                                zzef zzefVarZzk3 = this.zzt.zzay().zzk();
                                Object objZzn3 = zzeh.zzn(this.zza);
                                if (zzetVar.zzj()) {
                                    numValueOf5 = Integer.valueOf(zzetVar.zza());
                                } else {
                                    numValueOf5 = null;
                                }
                                zzefVarZzk3.zzc("Invalid property filter ID. appId, id", objZzn3, String.valueOf(numValueOf5));
                                this.zzb.add(Integer.valueOf(iIntValue3));
                            } else {
                                zzzVar = new zzz(this, this.zza, iIntValue3, zzetVar);
                                zZzd2 = zzzVar.zzd(this.zzd, this.zze, zzgmVar3, zzf(iIntValue3, zzetVar.zza()));
                                if (zZzd2) {
                                    zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                } else {
                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                }
                            }
                        }
                        if (!zZzd2) {
                            this.zzb.add(Integer.valueOf(iIntValue3));
                        }
                    }
                }
            }
        }
        arrayList3 = new ArrayList();
        Set setKeySet3 = this.zzc.keySet();
        setKeySet3.removeAll(this.zzb);
        it5 = setKeySet3.iterator();
        while (it5.hasNext()) {
            int iIntValue9 = ((Integer) it5.next()).intValue();
            Map map10 = this.zzc;
            Integer numValueOf113 = Integer.valueOf(iIntValue9);
            zzu zzuVar3 = (zzu) map10.get(numValueOf113);
            Preconditions.checkNotNull(zzuVar3);
            com.google.android.gms.internal.measurement.zzfp zzfpVarZza3 = zzuVar3.zza(iIntValue9);
            arrayList3.add(zzfpVarZza3);
            zzamVarZzi2 = this.zzf.zzi();
            str12 = this.zza;
            com.google.android.gms.internal.measurement.zzgi zzgiVarZzd3 = zzfpVarZza3.zzd();
            zzamVarZzi2.zzW();
            zzamVarZzi2.zzg();
            Preconditions.checkNotEmpty(str12);
            Preconditions.checkNotNull(zzgiVarZzd3);
            byte[] bArrZzbu3 = zzgiVarZzd3.zzbu();
            contentValues = new ContentValues();
            contentValues.put("app_id", str12);
            String str211 = str18;
            contentValues.put(str211, numValueOf113);
            String str212 = str11;
            contentValues.put(str212, bArrZzbu3);
            if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                zzamVarZzi2.zzt.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeh.zzn(str12));
            }
            str11 = str212;
            str18 = str211;
        }
        return arrayList3;
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final boolean zzb() {
        return false;
    }
}
