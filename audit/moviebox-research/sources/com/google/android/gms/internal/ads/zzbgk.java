package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.transsion.push.PushConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzbgk {
    String zzd;
    Context zze;
    String zzf;
    private AtomicBoolean zzh;
    private File zzi;
    final BlockingQueue zza = new ArrayBlockingQueue(100);
    final LinkedHashMap zzb = new LinkedHashMap();
    final Map zzc = new HashMap();
    private final HashSet zzg = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    public static /* synthetic */ void zzc(zzbgk zzbgkVar) throws Throwable {
        while (true) {
            try {
                zzbgu zzbguVar = (zzbgu) zzbgkVar.zza.take();
                zzbgt zzbgtVarZza = zzbguVar.zza();
                if (!TextUtils.isEmpty(zzbgtVarZza.zzb())) {
                    zzbgkVar.zzg(zzbgkVar.zzb(zzbgkVar.zzb, zzbguVar.zzb()), zzbgtVarZza);
                }
            } catch (InterruptedException e11) {
                zzcec.zzk("CsiReporter:reporter interrupted", e11);
                return;
            }
        }
    }

    private final void zzg(Map map, zzbgt zzbgtVar) throws Throwable {
        Uri.Builder builderBuildUpon = Uri.parse(this.zzd).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (zzbgtVar != null) {
            StringBuilder sb2 = new StringBuilder(string);
            if (!TextUtils.isEmpty(zzbgtVar.zzb())) {
                sb2.append("&it=");
                sb2.append(zzbgtVar.zzb());
            }
            if (!TextUtils.isEmpty(zzbgtVar.zza())) {
                sb2.append("&blat=");
                sb2.append(zzbgtVar.zza());
            }
            string = sb2.toString();
        }
        if (!this.zzh.get()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzK(this.zze, this.zzf, string);
            return;
        }
        File file = this.zzi;
        if (file == null) {
            zzcec.zzj("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(string.getBytes());
                    fileOutputStream2.write(10);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e11) {
                        zzcec.zzk("CsiReporter: Cannot close file: sdk_csi_data.txt.", e11);
                    }
                } catch (IOException e12) {
                    e = e12;
                    fileOutputStream = fileOutputStream2;
                    zzcec.zzk("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e13) {
                            zzcec.zzk("CsiReporter: Cannot close file: sdk_csi_data.txt.", e13);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e14) {
                            zzcec.zzk("CsiReporter: Cannot close file: sdk_csi_data.txt.", e14);
                        }
                    }
                    throw th;
                }
            } catch (IOException e15) {
                e = e15;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final zzbgq zza(String str) {
        zzbgq zzbgqVar = (zzbgq) this.zzc.get(str);
        return zzbgqVar != null ? zzbgqVar : zzbgq.zza;
    }

    public final Map zzb(Map map, @Nullable Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(str, zza(str).zza((String) linkedHashMap.get(str), str2));
        }
        return linkedHashMap;
    }

    public final void zzd(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.zze = context;
        this.zzf = str;
        this.zzd = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzh = atomicBoolean;
        atomicBoolean.set(((Boolean) zzbhv.zzc.zze()).booleanValue());
        if (this.zzh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbgj
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzbgk.zzc(this.zza);
            }
        });
        Map map2 = this.zzc;
        zzbgq zzbgqVar = zzbgq.zzb;
        map2.put("action", zzbgqVar);
        this.zzc.put("ad_format", zzbgqVar);
        this.zzc.put("e", zzbgq.zzc);
    }

    public final void zze(String str) throws Throwable {
        if (this.zzg.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PushConstants.PROVIDER_FIELD_SDK_VERSION, this.zzf);
        linkedHashMap.put("ue", str);
        zzg(zzb(this.zzb, linkedHashMap), null);
    }

    public final boolean zzf(zzbgu zzbguVar) {
        return this.zza.offer(zzbguVar);
    }
}
