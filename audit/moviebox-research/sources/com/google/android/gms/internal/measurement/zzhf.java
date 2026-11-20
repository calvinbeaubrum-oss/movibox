package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhf implements zzhk {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map zzh;
    private final List zzi;
    private static final Map zzb = new a();
    public static final String[] zza = {"key", AppMeasurementSdk.ConditionalUserProperty.VALUE};

    private zzhf(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhe zzheVar = new zzhe(this, null);
        this.zzf = zzheVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzheVar);
    }

    public static zzhf zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhf zzhfVar;
        synchronized (zzhf.class) {
            Map map = zzb;
            zzhfVar = (zzhf) map.get(uri);
            if (zzhfVar == null) {
                try {
                    zzhf zzhfVar2 = new zzhf(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzhfVar2);
                    } catch (SecurityException unused) {
                    }
                    zzhfVar = zzhfVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzhfVar;
    }

    public static synchronized void zze() {
        try {
            for (zzhf zzhfVar : zzb.values()) {
                zzhfVar.zzc.unregisterContentObserver(zzhfVar.zzf);
            }
            zzb.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhk
    public final /* bridge */ /* synthetic */ Object zzb(String str) {
        return (String) zzc().get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final Map zzc() {
        ?? r11;
        Map map;
        Map map2 = this.zzh;
        ?? r12 = map2;
        if (map2 == null) {
            synchronized (this.zzg) {
                Map map3 = this.zzh;
                r11 = map3;
                if (map3 == null) {
                    ?? AllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map = (Map) zzhi.zza(new zzhj() { // from class: com.google.android.gms.internal.measurement.zzhd
                                @Override // com.google.android.gms.internal.measurement.zzhj
                                public final Object zza() {
                                    return this.zza.zzd();
                                }
                            });
                            StrictMode.setThreadPolicy(AllowThreadDiskReads);
                        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                            Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(AllowThreadDiskReads);
                            map = null;
                        }
                        this.zzh = map;
                        AllowThreadDiskReads = map;
                        r11 = AllowThreadDiskReads;
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(AllowThreadDiskReads);
                        throw th2;
                    }
                }
            }
            r12 = r11;
        }
        return r12 != 0 ? r12 : Collections.emptyMap();
    }

    public final /* synthetic */ Map zzd() {
        Cursor cursorQuery = this.zzc.query(this.zzd, zza, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map aVar = count <= 256 ? new a(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                aVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return aVar;
        } finally {
            cursorQuery.close();
        }
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.zzi.iterator();
                while (it.hasNext()) {
                    ((zzhg) it.next()).zza();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
