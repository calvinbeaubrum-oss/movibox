package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.sdk.AppLovinEventParameters;
import com.cloud.tmc.miniapp.bridge.BluetoothBridge;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkt implements zzgm {
    private static volatile zzkt zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzie zzD;
    private String zzE;

    @VisibleForTesting
    long zza;
    private final zzfi zzc;
    private final zzen zzd;
    private zzam zze;
    private zzep zzf;
    private zzkf zzg;
    private zzaa zzh;
    private final zzkv zzi;
    private zzic zzj;
    private zzjo zzk;
    private final zzki zzl;
    private zzez zzm;
    private final zzfr zzn;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;
    private boolean zzo = false;
    private final zzla zzF = new zzko(this);

    public zzkt(zzku zzkuVar, zzfr zzfrVar) {
        Preconditions.checkNotNull(zzkuVar);
        this.zzn = zzfr.zzp(zzkuVar.zza, null, null);
        this.zzA = -1L;
        this.zzl = new zzki(this);
        zzkv zzkvVar = new zzkv(this);
        zzkvVar.zzX();
        this.zzi = zzkvVar;
        zzen zzenVar = new zzen(this);
        zzenVar.zzX();
        this.zzd = zzenVar;
        zzfi zzfiVar = new zzfi(this);
        zzfiVar.zzX();
        this.zzc = zzfiVar;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new zzkj(this, zzkuVar));
    }

    @VisibleForTesting
    public static final void zzaa(com.google.android.gms.internal.measurement.zzfs zzfsVar, int i11, String str) {
        List listZzp = zzfsVar.zzp();
        for (int i12 = 0; i12 < listZzp.size(); i12++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzfx) listZzp.get(i12)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzfw zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
        zzfwVarZze.zzj("_err");
        zzfwVarZze.zzi(Long.valueOf(i11).longValue());
        com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) zzfwVarZze.zzaC();
        com.google.android.gms.internal.measurement.zzfw zzfwVarZze2 = com.google.android.gms.internal.measurement.zzfx.zze();
        zzfwVarZze2.zzj("_ev");
        zzfwVarZze2.zzk(str);
        com.google.android.gms.internal.measurement.zzfx zzfxVar2 = (com.google.android.gms.internal.measurement.zzfx) zzfwVarZze2.zzaC();
        zzfsVar.zzf(zzfxVar);
        zzfsVar.zzf(zzfxVar2);
    }

    @VisibleForTesting
    public static final void zzab(com.google.android.gms.internal.measurement.zzfs zzfsVar, @NonNull String str) {
        List listZzp = zzfsVar.zzp();
        for (int i11 = 0; i11 < listZzp.size(); i11++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzfx) listZzp.get(i11)).zzg())) {
                zzfsVar.zzh(i11);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        if (zzhVarZzj == null || TextUtils.isEmpty(zzhVarZzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzad = zzad(zzhVarZzj);
        if (boolZzad != null && !boolZzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping. appId", zzeh.zzn(str));
            return null;
        }
        String strZzy = zzhVarZzj.zzy();
        String strZzw = zzhVarZzj.zzw();
        long jZzb = zzhVarZzj.zzb();
        String strZzv = zzhVarZzj.zzv();
        long jZzm = zzhVarZzj.zzm();
        long jZzj = zzhVarZzj.zzj();
        boolean zZzai = zzhVarZzj.zzai();
        String strZzx = zzhVarZzj.zzx();
        zzhVarZzj.zza();
        return new zzq(str, strZzy, strZzw, jZzb, strZzv, jZzm, jZzj, (String) null, zZzai, false, strZzx, 0L, 0L, 0, zzhVarZzj.zzah(), false, zzhVarZzj.zzr(), zzhVarZzj.zzq(), zzhVarZzj.zzk(), zzhVarZzj.zzC(), (String) null, zzh(str).zzh(), "", (String) null);
    }

    private final Boolean zzad(zzh zzhVar) {
        try {
            if (zzhVar.zzb() != -2147483648L) {
                if (zzhVar.zzb() == Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzhVar.zzt(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzhVar.zzt(), 0).versionName;
                String strZzw = zzhVar.zzw();
                if (strZzw != null && strZzw.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    @VisibleForTesting
    private final void zzaf(com.google.android.gms.internal.measurement.zzgc zzgcVar, long j11, boolean z11) {
        zzky zzkyVar;
        String str = true != z11 ? "_lte" : "_se";
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzky zzkyVarZzp = zzamVar.zzp(zzgcVar.zzap(), str);
        if (zzkyVarZzp == null || zzkyVarZzp.zze == null) {
            zzkyVar = new zzky(zzgcVar.zzap(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(j11));
        } else {
            zzkyVar = new zzky(zzgcVar.zzap(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzkyVarZzp.zze).longValue() + j11));
        }
        com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
        zzglVarZzd.zzf(str);
        zzglVarZzd.zzg(zzav().currentTimeMillis());
        zzglVarZzd.zze(((Long) zzkyVar.zze).longValue());
        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd.zzaC();
        int iZza = zzkv.zza(zzgcVar, str);
        if (iZza >= 0) {
            zzgcVar.zzam(iZza, zzgmVar);
        } else {
            zzgcVar.zzm(zzgmVar);
        }
        if (j11 > 0) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzL(zzkyVar);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z11 ? "lifetime" : "session-scoped", zzkyVar.zze);
        }
    }

    private final void zzag() {
        long jMax;
        long jMax2;
        zzaz().zzg();
        zzB();
        if (this.zza > 0) {
            long jAbs = 3600000 - Math.abs(zzav().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzay().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzm().zzc();
                zzkf zzkfVar = this.zzg;
                zzal(zzkfVar);
                zzkfVar.zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzai()) {
            zzay().zzj().zza("Nothing to upload or uploading impossible");
            zzm().zzc();
            zzkf zzkfVar2 = this.zzg;
            zzal(zzkfVar2);
            zzkfVar2.zza();
            return;
        }
        long jCurrentTimeMillis = zzav().currentTimeMillis();
        zzg();
        long jMax3 = Math.max(0L, ((Long) zzdu.zzz.zza(null)).longValue());
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        boolean z11 = true;
        if (!zzamVar.zzH()) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            if (!zzamVar2.zzG()) {
                z11 = false;
            }
        }
        if (z11) {
            String strZzl = zzg().zzl();
            if (TextUtils.isEmpty(strZzl) || ".none.".equals(strZzl)) {
                zzg();
                jMax = Math.max(0L, ((Long) zzdu.zzt.zza(null)).longValue());
            } else {
                zzg();
                jMax = Math.max(0L, ((Long) zzdu.zzu.zza(null)).longValue());
            }
        } else {
            zzg();
            jMax = Math.max(0L, ((Long) zzdu.zzs.zza(null)).longValue());
        }
        long jZza = this.zzk.zzc.zza();
        long jZza2 = this.zzk.zzd.zza();
        zzam zzamVar3 = this.zze;
        zzal(zzamVar3);
        boolean z12 = z11;
        long jZzd = zzamVar3.zzd();
        zzam zzamVar4 = this.zze;
        zzal(zzamVar4);
        long jMax4 = Math.max(jZzd, zzamVar4.zze());
        if (jMax4 != 0) {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jCurrentTimeMillis - jAbs3, jAbs4);
            jMax2 = jAbs2 + jMax3;
            if (z12 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            zzkv zzkvVar = this.zzi;
            zzal(zzkvVar);
            if (!zzkvVar.zzw(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i11 = 0;
                while (true) {
                    zzg();
                    if (i11 >= Math.min(20, Math.max(0, ((Integer) zzdu.zzB.zza(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzg();
                    jMax2 += Math.max(0L, ((Long) zzdu.zzA.zza(null)).longValue()) * (1 << i11);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        } else {
            jMax2 = 0;
            break;
        }
        if (jMax2 == 0) {
            zzay().zzj().zza("Next upload time is 0");
            zzm().zzc();
            zzkf zzkfVar3 = this.zzg;
            zzal(zzkfVar3);
            zzkfVar3.zza();
            return;
        }
        zzen zzenVar = this.zzd;
        zzal(zzenVar);
        if (!zzenVar.zza()) {
            zzay().zzj().zza("No network");
            zzm().zzb();
            zzkf zzkfVar4 = this.zzg;
            zzal(zzkfVar4);
            zzkfVar4.zza();
            return;
        }
        long jZza3 = this.zzk.zzb.zza();
        zzg();
        long jMax6 = Math.max(0L, ((Long) zzdu.zzq.zza(null)).longValue());
        zzkv zzkvVar2 = this.zzi;
        zzal(zzkvVar2);
        if (!zzkvVar2.zzw(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzm().zzc();
        long jCurrentTimeMillis2 = jMax2 - zzav().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzg();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzdu.zzv.zza(null)).longValue());
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzay().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzkf zzkfVar5 = this.zzg;
        zzal(zzkfVar5);
        zzkfVar5.zzd(jCurrentTimeMillis2);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0378 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0390 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x03a9 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x03bf A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:119:0x03d1 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:125:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:126:0x03ea A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x041a  */
    /* JADX WARN: Code duplicated, block: B:134:0x041f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0420 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0431  */
    /* JADX WARN: Code duplicated, block: B:140:0x0438 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0442 A[Catch: all -> 0x00e9, LOOP:3: B:138:0x0432->B:142:0x0442, LOOP_END, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x046c A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x047d  */
    /* JADX WARN: Code duplicated, block: B:158:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:160:0x04c2 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x04d0 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:172:0x0513  */
    /* JADX WARN: Code duplicated, block: B:184:0x0569 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x0574 A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x057a A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0583  */
    /* JADX WARN: Code duplicated, block: B:291:0x08e4 A[PHI: r8
  0x08e4: PHI (r8v19 com.google.android.gms.measurement.internal.zzas) = (r8v18 com.google.android.gms.measurement.internal.zzas), (r8v31 com.google.android.gms.measurement.internal.zzas) binds: [B:287:0x088e, B:289:0x08a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:378:0x0b7c A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:3:0x000e, B:5:0x0026, B:8:0x002e, B:9:0x0040, B:12:0x0054, B:15:0x007b, B:17:0x00b1, B:20:0x00c3, B:22:0x00cd, B:175:0x0533, B:26:0x00fa, B:28:0x0108, B:31:0x0128, B:33:0x012e, B:35:0x0140, B:37:0x014e, B:39:0x015e, B:40:0x016b, B:41:0x0170, B:44:0x0189, B:112:0x03a9, B:113:0x03b5, B:116:0x03bf, B:122:0x03e2, B:119:0x03d1, B:144:0x0460, B:146:0x046c, B:149:0x047f, B:151:0x0490, B:153:0x049c, B:174:0x051d, B:160:0x04c2, B:162:0x04d0, B:165:0x04e5, B:167:0x04f6, B:169:0x0502, B:126:0x03ea, B:128:0x03f6, B:130:0x0402, B:143:0x0448, B:135:0x0420, B:138:0x0432, B:140:0x0438, B:142:0x0442, B:69:0x01e9, B:72:0x01f3, B:74:0x0201, B:78:0x0246, B:75:0x021d, B:77:0x022d, B:82:0x0253, B:84:0x027f, B:85:0x02a9, B:87:0x02e0, B:89:0x02e6, B:92:0x02f2, B:94:0x0328, B:95:0x0343, B:97:0x0349, B:99:0x0357, B:103:0x036a, B:100:0x035f, B:106:0x0371, B:109:0x0378, B:110:0x0390, B:178:0x0547, B:180:0x0555, B:182:0x0560, B:194:0x0594, B:184:0x0569, B:186:0x0574, B:188:0x057a, B:191:0x0586, B:193:0x058e, B:195:0x0596, B:196:0x05a2, B:199:0x05aa, B:201:0x05bc, B:202:0x05c8, B:204:0x05d0, B:208:0x05f5, B:210:0x061a, B:212:0x062b, B:214:0x0631, B:216:0x063d, B:217:0x066e, B:219:0x0674, B:221:0x0682, B:222:0x0686, B:223:0x0689, B:224:0x068c, B:225:0x069a, B:227:0x06a0, B:229:0x06b0, B:230:0x06b7, B:232:0x06c3, B:233:0x06ca, B:234:0x06cd, B:236:0x070b, B:237:0x071e, B:239:0x0724, B:242:0x073e, B:244:0x0759, B:246:0x0772, B:248:0x0777, B:250:0x077b, B:252:0x077f, B:254:0x0789, B:255:0x0793, B:257:0x0797, B:259:0x079d, B:260:0x07ab, B:261:0x07b4, B:330:0x0a09, B:263:0x07c0, B:265:0x07d7, B:271:0x07f3, B:273:0x0817, B:274:0x081f, B:276:0x0825, B:278:0x0837, B:285:0x0861, B:286:0x0884, B:288:0x0890, B:290:0x08a5, B:292:0x08e6, B:296:0x08fe, B:298:0x0905, B:300:0x0914, B:302:0x0918, B:304:0x091c, B:306:0x0920, B:307:0x092c, B:308:0x0931, B:310:0x0937, B:312:0x0953, B:313:0x0958, B:329:0x0a06, B:314:0x0972, B:316:0x097a, B:320:0x09a1, B:322:0x09cd, B:324:0x09db, B:326:0x09ef, B:328:0x09f9, B:317:0x0987, B:283:0x084b, B:269:0x07de, B:331:0x0a14, B:333:0x0a21, B:334:0x0a27, B:335:0x0a2f, B:337:0x0a35, B:340:0x0a4f, B:342:0x0a60, B:362:0x0ad4, B:364:0x0ada, B:366:0x0af2, B:369:0x0af9, B:374:0x0b28, B:376:0x0b6a, B:379:0x0b9f, B:380:0x0ba3, B:381:0x0bae, B:383:0x0bf1, B:384:0x0bfe, B:386:0x0c0d, B:390:0x0c27, B:392:0x0c40, B:378:0x0b7c, B:370:0x0b01, B:372:0x0b0d, B:373:0x0b11, B:393:0x0c58, B:394:0x0c70, B:397:0x0c78, B:398:0x0c7d, B:399:0x0c8d, B:401:0x0ca7, B:402:0x0cc2, B:403:0x0ccb, B:408:0x0cea, B:407:0x0cd7, B:343:0x0a78, B:345:0x0a7e, B:347:0x0a88, B:349:0x0a8f, B:355:0x0a9f, B:357:0x0aa6, B:359:0x0ac5, B:361:0x0acc, B:360:0x0ac9, B:356:0x0aa3, B:348:0x0a8c, B:205:0x05d5, B:207:0x05db, B:411:0x0cfc), top: B:420:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:436:0x03e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:438:0x0448 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x01ce  */
    private final boolean zzah(String str, long j11) {
        int i11;
        int i12;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        zzkq zzkqVar;
        long j12;
        int iZzc;
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzB;
        Long lValueOf;
        String str2;
        String str3;
        int i13;
        int i14;
        com.google.android.gms.internal.measurement.zzgc zzgcVar2;
        com.google.android.gms.internal.measurement.zzfs zzfsVar;
        com.google.android.gms.internal.measurement.zzfs zzfsVar2;
        com.google.android.gms.internal.measurement.zzgc zzgcVar3;
        int i15;
        int i16;
        com.google.android.gms.internal.measurement.zzfs zzfsVar3;
        ArrayList arrayList;
        int i17;
        int i18;
        int i19;
        String strZzh;
        int iCharCount;
        int iCodePointAt;
        byte b11;
        String str4 = "_npa";
        String str5 = "_ai";
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzkq zzkqVar2 = new zzkq(this, null);
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzU(null, j11, this.zzA, zzkqVar2);
            List list = zzkqVar2.zzc;
            if (list != null && !list.isEmpty()) {
                com.google.android.gms.internal.measurement.zzgc zzgcVar4 = (com.google.android.gms.internal.measurement.zzgc) zzkqVar2.zza.zzby();
                zzgcVar4.zzr();
                com.google.android.gms.internal.measurement.zzfs zzfsVar4 = null;
                com.google.android.gms.internal.measurement.zzfs zzfsVar5 = null;
                int i21 = 0;
                int i22 = 0;
                int i23 = -1;
                int i24 = -1;
                int i25 = 0;
                while (true) {
                    i11 = i25;
                    i12 = i22;
                    com.google.android.gms.internal.measurement.zzfs zzfsVar6 = zzfsVar4;
                    if (i21 >= zzkqVar2.zzc.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzfs zzfsVar7 = (com.google.android.gms.internal.measurement.zzfs) ((com.google.android.gms.internal.measurement.zzft) zzkqVar2.zzc.get(i21)).zzby();
                    zzfi zzfiVar = this.zzc;
                    zzal(zzfiVar);
                    String str6 = str4;
                    if (zzfiVar.zzr(zzkqVar2.zza.zzx(), zzfsVar7.zzo())) {
                        zzay().zzk().zzc("Dropping blocked raw event. appId", zzeh.zzn(zzkqVar2.zza.zzx()), this.zzn.zzj().zzd(zzfsVar7.zzo()));
                        zzfi zzfiVar2 = this.zzc;
                        zzal(zzfiVar2);
                        if (!zzfiVar2.zzp(zzkqVar2.zza.zzx())) {
                            zzfi zzfiVar3 = this.zzc;
                            zzal(zzfiVar3);
                            if (!zzfiVar3.zzs(zzkqVar2.zza.zzx()) && !"_err".equals(zzfsVar7.zzo())) {
                                zzv().zzN(this.zzF, zzkqVar2.zza.zzx(), 11, "_ev", zzfsVar7.zzo(), 0);
                            }
                        }
                        str2 = str5;
                        zzgcVar3 = zzgcVar4;
                        i16 = i21;
                        i25 = i11;
                        i22 = i12;
                        zzfsVar4 = zzfsVar6;
                    } else {
                        if (zzfsVar7.zzo().equals(zzgo.zza(str5))) {
                            zzfsVar7.zzi(str5);
                            zzay().zzj().zza("Renaming ad_impression to _ai");
                            if (Log.isLoggable(zzay().zzq(), 5)) {
                                int i26 = 0;
                                while (i26 < zzfsVar7.zza()) {
                                    String str7 = str5;
                                    if ("ad_platform".equals(zzfsVar7.zzn(i26).zzg()) && !zzfsVar7.zzn(i26).zzh().isEmpty() && "admob".equalsIgnoreCase(zzfsVar7.zzn(i26).zzh())) {
                                        zzay().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                    i26++;
                                    str5 = str7;
                                }
                            }
                        }
                        str2 = str5;
                        zzfi zzfiVar4 = this.zzc;
                        zzal(zzfiVar4);
                        boolean zZzq = zzfiVar4.zzq(zzkqVar2.zza.zzx(), zzfsVar7.zzo());
                        if (zZzq) {
                            str3 = "_et";
                            i13 = i21;
                            i14 = i23;
                        } else {
                            zzal(this.zzi);
                            String strZzo = zzfsVar7.zzo();
                            Preconditions.checkNotEmpty(strZzo);
                            i13 = i21;
                            int iHashCode = strZzo.hashCode();
                            i14 = i23;
                            str3 = "_et";
                            if (iHashCode != 94660) {
                                if (iHashCode != 95025) {
                                    if (iHashCode == 95027 && strZzo.equals("_ui")) {
                                        b11 = 1;
                                    } else {
                                        b11 = -1;
                                    }
                                } else if (strZzo.equals("_ug")) {
                                    b11 = 2;
                                } else {
                                    b11 = -1;
                                }
                            } else if (strZzo.equals("_in")) {
                                b11 = 0;
                            } else {
                                b11 = -1;
                            }
                            if (b11 != 0 && b11 != 1 && b11 != 2) {
                                zzgcVar2 = zzgcVar4;
                                zzfsVar = zzfsVar5;
                                i24 = i24;
                                zZzq = false;
                            }
                            if (zZzq) {
                                arrayList = new ArrayList(zzfsVar7.zzp());
                                i18 = -1;
                                i19 = -1;
                                for (i17 = 0; i17 < arrayList.size(); i17++) {
                                    if (AppMeasurementSdk.ConditionalUserProperty.VALUE.equals(((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i17)).zzg())) {
                                        i18 = i17;
                                    } else if (AppLovinEventParameters.REVENUE_CURRENCY.equals(((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i17)).zzg())) {
                                        i19 = i17;
                                    }
                                }
                                if (i18 != -1) {
                                    if (!((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i18)).zzw() || ((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i18)).zzu()) {
                                        if (i19 == -1) {
                                            strZzh = ((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i19)).zzh();
                                            if (strZzh.length() == 3) {
                                                iCharCount = 0;
                                                while (iCharCount < strZzh.length()) {
                                                    iCodePointAt = strZzh.codePointAt(iCharCount);
                                                    if (Character.isLetter(iCodePointAt)) {
                                                        iCharCount += Character.charCount(iCodePointAt);
                                                    }
                                                }
                                            }
                                        }
                                        zzay().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                        zzfsVar7.zzh(i18);
                                        zzab(zzfsVar7, "_c");
                                        zzaa(zzfsVar7, 19, AppLovinEventParameters.REVENUE_CURRENCY);
                                        break;
                                    }
                                    zzay().zzl().zza("Value must be specified with a numeric type.");
                                    zzfsVar7.zzh(i18);
                                    zzab(zzfsVar7, "_c");
                                    zzaa(zzfsVar7, 18, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                                }
                            }
                            if ("_e".equals(zzfsVar7.zzo())) {
                                zzal(this.zzi);
                                if (zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar7.zzaC(), "_fr") != null) {
                                    zzgcVar3 = zzgcVar2;
                                    i23 = i14;
                                    zzfsVar5 = zzfsVar;
                                } else if (zzfsVar != null || Math.abs(zzfsVar.zzc() - zzfsVar7.zzc()) > 1000) {
                                    zzgcVar3 = zzgcVar2;
                                    zzfsVar6 = zzfsVar7;
                                    i23 = i12;
                                    zzfsVar5 = zzfsVar;
                                } else {
                                    com.google.android.gms.internal.measurement.zzfs zzfsVar8 = (com.google.android.gms.internal.measurement.zzfs) zzfsVar.clone();
                                    if (zzaj(zzfsVar7, zzfsVar8)) {
                                        zzgcVar3 = zzgcVar2;
                                        zzgcVar3.zzS(i24, zzfsVar8);
                                        i23 = i14;
                                        zzfsVar3 = null;
                                        zzfsVar5 = null;
                                    } else {
                                        zzgcVar3 = zzgcVar2;
                                        zzfsVar3 = zzfsVar7;
                                        i23 = i12;
                                        zzfsVar5 = zzfsVar;
                                    }
                                    zzfsVar6 = zzfsVar3;
                                    i24 = i24;
                                }
                            } else {
                                zzgcVar3 = zzgcVar2;
                                if ("_vs".equals(zzfsVar7.zzo())) {
                                    zzal(this.zzi);
                                    if (zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar7.zzaC(), str3) == null) {
                                        if (zzfsVar6 != null || Math.abs(zzfsVar6.zzc() - zzfsVar7.zzc()) > 1000) {
                                            i23 = i14;
                                            zzfsVar5 = zzfsVar7;
                                            i24 = i12;
                                        } else {
                                            com.google.android.gms.internal.measurement.zzfs zzfsVar9 = (com.google.android.gms.internal.measurement.zzfs) zzfsVar6.clone();
                                            if (zzaj(zzfsVar9, zzfsVar7)) {
                                                i15 = i14;
                                                zzgcVar3.zzS(i15, zzfsVar9);
                                                i24 = i24;
                                                zzfsVar5 = null;
                                                zzfsVar6 = null;
                                            } else {
                                                i15 = i14;
                                                zzfsVar5 = zzfsVar7;
                                                i24 = i12;
                                            }
                                            i23 = i15;
                                        }
                                    }
                                }
                                i23 = i14;
                                zzfsVar5 = zzfsVar;
                            }
                            i16 = i13;
                            zzkqVar2.zzc.set(i16, (com.google.android.gms.internal.measurement.zzft) zzfsVar7.zzaC());
                            i22 = i12 + 1;
                            zzgcVar3.zzk(zzfsVar7);
                            i25 = i11;
                            zzfsVar4 = zzfsVar6;
                        }
                        int i27 = 0;
                        boolean z11 = false;
                        boolean z12 = false;
                        while (true) {
                            zzgcVar2 = zzgcVar4;
                            if (i27 >= zzfsVar7.zza()) {
                                break;
                            }
                            if ("_c".equals(zzfsVar7.zzn(i27).zzg())) {
                                com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) zzfsVar7.zzn(i27).zzby();
                                zzfsVar2 = zzfsVar5;
                                zzfwVar.zzi(1L);
                                zzfsVar7.zzk(i27, (com.google.android.gms.internal.measurement.zzfx) zzfwVar.zzaC());
                                z11 = true;
                            } else {
                                zzfsVar2 = zzfsVar5;
                                if ("_r".equals(zzfsVar7.zzn(i27).zzg())) {
                                    com.google.android.gms.internal.measurement.zzfw zzfwVar2 = (com.google.android.gms.internal.measurement.zzfw) zzfsVar7.zzn(i27).zzby();
                                    zzfwVar2.zzi(1L);
                                    zzfsVar7.zzk(i27, (com.google.android.gms.internal.measurement.zzfx) zzfwVar2.zzaC());
                                    z12 = true;
                                }
                            }
                            i27++;
                            zzgcVar4 = zzgcVar2;
                            zzfsVar5 = zzfsVar2;
                        }
                        zzfsVar = zzfsVar5;
                        if (!z11 && zZzq) {
                            zzay().zzj().zzb("Marking event as conversion", this.zzn.zzj().zzd(zzfsVar7.zzo()));
                            com.google.android.gms.internal.measurement.zzfw zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
                            zzfwVarZze.zzj("_c");
                            zzfwVarZze.zzi(1L);
                            zzfsVar7.zze(zzfwVarZze);
                        }
                        if (!z12) {
                            zzay().zzj().zzb("Marking event as real-time", this.zzn.zzj().zzd(zzfsVar7.zzo()));
                            com.google.android.gms.internal.measurement.zzfw zzfwVarZze2 = com.google.android.gms.internal.measurement.zzfx.zze();
                            zzfwVarZze2.zzj("_r");
                            zzfwVarZze2.zzi(1L);
                            zzfsVar7.zze(zzfwVarZze2);
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        i24 = i24;
                        if (zzamVar3.zzl(zza(), zzkqVar2.zza.zzx(), false, false, false, false, true).zze > zzg().zze(zzkqVar2.zza.zzx(), zzdu.zzn)) {
                            zzab(zzfsVar7, "_r");
                        } else {
                            i11 = 1;
                        }
                        if (zzlb.zzai(zzfsVar7.zzo()) && zZzq) {
                            zzam zzamVar4 = this.zze;
                            zzal(zzamVar4);
                            if (zzamVar4.zzl(zza(), zzkqVar2.zza.zzx(), false, false, true, false, false).zzc > zzg().zze(zzkqVar2.zza.zzx(), zzdu.zzm)) {
                                zzay().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzeh.zzn(zzkqVar2.zza.zzx()));
                                com.google.android.gms.internal.measurement.zzfw zzfwVar3 = null;
                                boolean z13 = false;
                                int i28 = -1;
                                for (int i29 = 0; i29 < zzfsVar7.zza(); i29++) {
                                    com.google.android.gms.internal.measurement.zzfx zzfxVarZzn = zzfsVar7.zzn(i29);
                                    if ("_c".equals(zzfxVarZzn.zzg())) {
                                        zzfwVar3 = (com.google.android.gms.internal.measurement.zzfw) zzfxVarZzn.zzby();
                                        i28 = i29;
                                    } else if ("_err".equals(zzfxVarZzn.zzg())) {
                                        z13 = true;
                                    }
                                }
                                if (z13) {
                                    if (zzfwVar3 != null) {
                                        zzfsVar7.zzh(i28);
                                    } else {
                                        zzfwVar3 = null;
                                        if (zzfwVar3 != null) {
                                            com.google.android.gms.internal.measurement.zzfw zzfwVar4 = (com.google.android.gms.internal.measurement.zzfw) zzfwVar3.clone();
                                            zzfwVar4.zzj("_err");
                                            zzfwVar4.zzi(10L);
                                            zzfsVar7.zzk(i28, (com.google.android.gms.internal.measurement.zzfx) zzfwVar4.zzaC());
                                        } else {
                                            zzay().zzd().zzb("Did not find conversion parameter. appId", zzeh.zzn(zzkqVar2.zza.zzx()));
                                        }
                                    }
                                } else if (zzfwVar3 != null) {
                                    com.google.android.gms.internal.measurement.zzfw zzfwVar5 = (com.google.android.gms.internal.measurement.zzfw) zzfwVar3.clone();
                                    zzfwVar5.zzj("_err");
                                    zzfwVar5.zzi(10L);
                                    zzfsVar7.zzk(i28, (com.google.android.gms.internal.measurement.zzfx) zzfwVar5.zzaC());
                                } else {
                                    zzay().zzd().zzb("Did not find conversion parameter. appId", zzeh.zzn(zzkqVar2.zza.zzx()));
                                }
                            }
                        }
                        if (zZzq) {
                            arrayList = new ArrayList(zzfsVar7.zzp());
                            i18 = -1;
                            i19 = -1;
                            while (i17 < arrayList.size()) {
                                if (AppMeasurementSdk.ConditionalUserProperty.VALUE.equals(((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i17)).zzg())) {
                                    i18 = i17;
                                } else if (AppLovinEventParameters.REVENUE_CURRENCY.equals(((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i17)).zzg())) {
                                    i19 = i17;
                                }
                            }
                            if (i18 != -1) {
                                if (((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i18)).zzw()) {
                                }
                                if (i19 == -1) {
                                    strZzh = ((com.google.android.gms.internal.measurement.zzfx) arrayList.get(i19)).zzh();
                                    if (strZzh.length() == 3) {
                                        iCharCount = 0;
                                        while (iCharCount < strZzh.length()) {
                                            iCodePointAt = strZzh.codePointAt(iCharCount);
                                            if (Character.isLetter(iCodePointAt)) {
                                                iCharCount += Character.charCount(iCodePointAt);
                                            }
                                        }
                                    }
                                }
                                zzay().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                zzfsVar7.zzh(i18);
                                zzab(zzfsVar7, "_c");
                                zzaa(zzfsVar7, 19, AppLovinEventParameters.REVENUE_CURRENCY);
                                break;
                            }
                        }
                        if ("_e".equals(zzfsVar7.zzo())) {
                            zzal(this.zzi);
                            if (zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar7.zzaC(), "_fr") != null) {
                                if (zzfsVar != null) {
                                }
                                zzgcVar3 = zzgcVar2;
                                zzfsVar6 = zzfsVar7;
                                i23 = i12;
                                zzfsVar5 = zzfsVar;
                            } else {
                                zzgcVar3 = zzgcVar2;
                                i23 = i14;
                                zzfsVar5 = zzfsVar;
                            }
                        } else {
                            zzgcVar3 = zzgcVar2;
                            if ("_vs".equals(zzfsVar7.zzo())) {
                                zzal(this.zzi);
                                if (zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar7.zzaC(), str3) == null) {
                                    if (zzfsVar6 != null) {
                                        i23 = i14;
                                        zzfsVar5 = zzfsVar7;
                                        i24 = i12;
                                    } else {
                                        i23 = i14;
                                        zzfsVar5 = zzfsVar7;
                                        i24 = i12;
                                    }
                                }
                            }
                            i23 = i14;
                            zzfsVar5 = zzfsVar;
                        }
                        i16 = i13;
                        zzkqVar2.zzc.set(i16, (com.google.android.gms.internal.measurement.zzft) zzfsVar7.zzaC());
                        i22 = i12 + 1;
                        zzgcVar3.zzk(zzfsVar7);
                        i25 = i11;
                        zzfsVar4 = zzfsVar6;
                    }
                    i21 = i16 + 1;
                    zzgcVar4 = zzgcVar3;
                    str4 = str6;
                    str5 = str2;
                }
                String str8 = str4;
                com.google.android.gms.internal.measurement.zzgc zzgcVar5 = zzgcVar4;
                long jLongValue = 0;
                int i31 = i12;
                int i32 = 0;
                while (i32 < i31) {
                    com.google.android.gms.internal.measurement.zzft zzftVarZze = zzgcVar5.zze(i32);
                    if ("_e".equals(zzftVarZze.zzh())) {
                        zzal(this.zzi);
                        if (zzkv.zzB(zzftVarZze, "_fr") != null) {
                            zzgcVar5.zzA(i32);
                            i31--;
                            i32--;
                        } else {
                            zzal(this.zzi);
                            zzfxVarZzB = zzkv.zzB(zzftVarZze, "_et");
                            if (zzfxVarZzB != null) {
                                if (zzfxVarZzB.zzw()) {
                                    lValueOf = Long.valueOf(zzfxVarZzB.zzd());
                                } else {
                                    lValueOf = null;
                                }
                                if (lValueOf != null && lValueOf.longValue() > 0) {
                                    jLongValue += lValueOf.longValue();
                                }
                            }
                        }
                    } else {
                        zzal(this.zzi);
                        zzfxVarZzB = zzkv.zzB(zzftVarZze, "_et");
                        if (zzfxVarZzB != null) {
                            if (zzfxVarZzB.zzw()) {
                                lValueOf = Long.valueOf(zzfxVarZzB.zzd());
                            } else {
                                lValueOf = null;
                            }
                            if (lValueOf != null) {
                                jLongValue += lValueOf.longValue();
                            }
                        }
                    }
                    i32++;
                }
                zzaf(zzgcVar5, jLongValue, false);
                Iterator it = zzgcVar5.zzas().iterator();
                while (it.hasNext()) {
                    if ("_s".equals(((com.google.android.gms.internal.measurement.zzft) it.next()).zzh())) {
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzA(zzgcVar5.zzap(), "_se");
                        break;
                    }
                }
                if (zzkv.zza(zzgcVar5, "_sid") >= 0) {
                    zzaf(zzgcVar5, jLongValue, true);
                } else {
                    int iZza = zzkv.zza(zzgcVar5, "_se");
                    if (iZza >= 0) {
                        zzgcVar5.zzB(iZza);
                        zzay().zzd().zzb("Session engagement user property is in the bundle without session ID. appId", zzeh.zzn(zzkqVar2.zza.zzx()));
                    }
                }
                zzkv zzkvVar = this.zzi;
                zzal(zzkvVar);
                zzkvVar.zzt.zzay().zzj().zza("Checking account type status for ad personalization signals");
                zzfi zzfiVar5 = zzkvVar.zzf.zzc;
                zzal(zzfiVar5);
                if (zzfiVar5.zzn(zzgcVar5.zzap())) {
                    zzam zzamVar6 = zzkvVar.zzf.zze;
                    zzal(zzamVar6);
                    zzh zzhVarZzj = zzamVar6.zzj(zzgcVar5.zzap());
                    if (zzhVarZzj != null && zzhVarZzj.zzah() && zzkvVar.zzt.zzg().zze()) {
                        zzkvVar.zzt.zzay().zzc().zza("Turning off ad personalization due to account type");
                        com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                        zzglVarZzd.zzf(str8);
                        zzglVarZzd.zzg(zzkvVar.zzt.zzg().zza());
                        zzglVarZzd.zze(1L);
                        com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) zzglVarZzd.zzaC();
                        int i33 = 0;
                        while (true) {
                            if (i33 >= zzgcVar5.zzb()) {
                                zzgcVar5.zzm(zzgmVar);
                                break;
                            }
                            if (str8.equals(zzgcVar5.zzao(i33).zzf())) {
                                zzgcVar5.zzam(i33, zzgmVar);
                                break;
                            }
                            i33++;
                        }
                    }
                }
                zzgcVar5.zzai(Long.MAX_VALUE);
                zzgcVar5.zzQ(Long.MIN_VALUE);
                for (int i34 = 0; i34 < zzgcVar5.zza(); i34++) {
                    com.google.android.gms.internal.measurement.zzft zzftVarZze2 = zzgcVar5.zze(i34);
                    if (zzftVarZze2.zzd() < zzgcVar5.zzd()) {
                        zzgcVar5.zzai(zzftVarZze2.zzd());
                    }
                    if (zzftVarZze2.zzd() > zzgcVar5.zzc()) {
                        zzgcVar5.zzQ(zzftVarZze2.zzd());
                    }
                }
                zzgcVar5.zzz();
                zzgcVar5.zzo();
                zzaa zzaaVar = this.zzh;
                zzal(zzaaVar);
                zzgcVar5.zzf(zzaaVar.zza(zzgcVar5.zzap(), zzgcVar5.zzas(), zzgcVar5.zzat(), Long.valueOf(zzgcVar5.zzd()), Long.valueOf(zzgcVar5.zzc())));
                if (zzg().zzw(zzkqVar2.zza.zzx())) {
                    HashMap map = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    SecureRandom secureRandomZzG = zzv().zzG();
                    int i35 = 0;
                    while (i35 < zzgcVar5.zza()) {
                        com.google.android.gms.internal.measurement.zzfs zzfsVar10 = (com.google.android.gms.internal.measurement.zzfs) zzgcVar5.zze(i35).zzby();
                        if (zzfsVar10.zzo().equals("_ep")) {
                            zzal(this.zzi);
                            String str9 = (String) zzkv.zzC((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC(), "_en");
                            zzas zzasVarZzn = (zzas) map.get(str9);
                            if (zzasVarZzn == null) {
                                zzam zzamVar7 = this.zze;
                                zzal(zzamVar7);
                                zzasVarZzn = zzamVar7.zzn(zzkqVar2.zza.zzx(), (String) Preconditions.checkNotNull(str9));
                                if (zzasVarZzn != null) {
                                    map.put(str9, zzasVarZzn);
                                }
                            }
                            if (zzasVarZzn != null && zzasVarZzn.zzi == null) {
                                Long l11 = zzasVarZzn.zzj;
                                if (l11 != null && l11.longValue() > 1) {
                                    zzal(this.zzi);
                                    zzkv.zzz(zzfsVar10, "_sr", zzasVarZzn.zzj);
                                }
                                Boolean bool = zzasVarZzn.zzk;
                                if (bool != null && bool.booleanValue()) {
                                    zzal(this.zzi);
                                    zzkv.zzz(zzfsVar10, "_efs", 1L);
                                }
                                arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC());
                            }
                            zzgcVar5.zzS(i35, zzfsVar10);
                        } else {
                            zzfi zzfiVar6 = this.zzc;
                            zzal(zzfiVar6);
                            String strZzx = zzkqVar2.zza.zzx();
                            String strZza = zzfiVar6.zza(strZzx, "measurement.account.time_zone_offset_minutes");
                            if (TextUtils.isEmpty(strZza)) {
                                j12 = 0;
                            } else {
                                try {
                                    j12 = Long.parseLong(strZza);
                                } catch (NumberFormatException e11) {
                                    zzfiVar6.zzt.zzay().zzk().zzc("Unable to parse timezone offset. appId", zzeh.zzn(strZzx), e11);
                                    j12 = 0;
                                }
                            }
                            long jZzr = zzv().zzr(zzfsVar10.zzc(), j12);
                            com.google.android.gms.internal.measurement.zzft zzftVar = (com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC();
                            Long l12 = 1L;
                            long j13 = j12;
                            if (!TextUtils.isEmpty("_dbg")) {
                                Iterator it2 = zzftVar.zzi().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it2.next();
                                        Iterator it3 = it2;
                                        if ("_dbg".equals(zzfxVar.zzg())) {
                                            if (l12.equals(Long.valueOf(zzfxVar.zzd()))) {
                                                iZzc = 1;
                                                break;
                                            }
                                        } else {
                                            it2 = it3;
                                        }
                                    }
                                    zzfi zzfiVar7 = this.zzc;
                                    zzal(zzfiVar7);
                                    iZzc = zzfiVar7.zzc(zzkqVar2.zza.zzx(), zzfsVar10.zzo());
                                    break;
                                }
                            }
                            zzfi zzfiVar8 = this.zzc;
                            zzal(zzfiVar8);
                            iZzc = zzfiVar8.zzc(zzkqVar2.zza.zzx(), zzfsVar10.zzo());
                            break;
                            if (iZzc <= 0) {
                                zzay().zzk().zzc("Sample rate must be positive. event, rate", zzfsVar10.zzo(), Integer.valueOf(iZzc));
                                arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC());
                                zzgcVar5.zzS(i35, zzfsVar10);
                            } else {
                                zzas zzasVarZza = (zzas) map.get(zzfsVar10.zzo());
                                if (zzasVarZza == null) {
                                    zzam zzamVar8 = this.zze;
                                    zzal(zzamVar8);
                                    zzasVarZza = zzamVar8.zzn(zzkqVar2.zza.zzx(), zzfsVar10.zzo());
                                    if (zzasVarZza == null) {
                                        zzay().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzkqVar2.zza.zzx(), zzfsVar10.zzo());
                                        zzasVarZza = new zzas(zzkqVar2.zza.zzx(), zzfsVar10.zzo(), 1L, 1L, 1L, zzfsVar10.zzc(), 0L, null, null, null, null);
                                    }
                                }
                                zzal(this.zzi);
                                Long l13 = (Long) zzkv.zzC((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC(), "_eid");
                                Boolean boolValueOf = Boolean.valueOf(l13 != null);
                                if (iZzc == 1) {
                                    arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC());
                                    if (boolValueOf.booleanValue() && (zzasVarZza.zzi != null || zzasVarZza.zzj != null || zzasVarZza.zzk != null)) {
                                        map.put(zzfsVar10.zzo(), zzasVarZza.zza(null, null, null));
                                    }
                                    zzgcVar5.zzS(i35, zzfsVar10);
                                } else {
                                    if (secureRandomZzG.nextInt(iZzc) == 0) {
                                        zzal(this.zzi);
                                        Long lValueOf2 = Long.valueOf(iZzc);
                                        zzkv.zzz(zzfsVar10, "_sr", lValueOf2);
                                        arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC());
                                        if (boolValueOf.booleanValue()) {
                                            zzasVarZza = zzasVarZza.zza(null, lValueOf2, null);
                                        }
                                        map.put(zzfsVar10.zzo(), zzasVarZza.zzb(zzfsVar10.zzc(), jZzr));
                                        zzkqVar2 = zzkqVar2;
                                    } else {
                                        Long l14 = zzasVarZza.zzh;
                                        if ((l14 != null ? l14.longValue() : zzv().zzr(zzfsVar10.zzb(), j13)) != jZzr) {
                                            zzal(this.zzi);
                                            zzkv.zzz(zzfsVar10, "_efs", 1L);
                                            zzal(this.zzi);
                                            Long lValueOf3 = Long.valueOf(iZzc);
                                            zzkv.zzz(zzfsVar10, "_sr", lValueOf3);
                                            arrayList2.add((com.google.android.gms.internal.measurement.zzft) zzfsVar10.zzaC());
                                            map.put(zzfsVar10.zzo(), (boolValueOf.booleanValue() ? zzasVarZza.zza(null, lValueOf3, Boolean.TRUE) : zzasVarZza).zzb(zzfsVar10.zzc(), jZzr));
                                        } else {
                                            zzas zzasVar = zzasVarZza;
                                            if (boolValueOf.booleanValue()) {
                                                map.put(zzfsVar10.zzo(), zzasVar.zza(l13, null, null));
                                            }
                                        }
                                        i35 = i35;
                                    }
                                    zzgcVar5.zzS(i35, zzfsVar10);
                                }
                                i35++;
                                zzgcVar5 = zzgcVar5;
                                secureRandomZzG = secureRandomZzG;
                                zzkqVar2 = zzkqVar2;
                            }
                        }
                        zzkqVar2 = zzkqVar2;
                        secureRandomZzG = secureRandomZzG;
                        zzgcVar5 = zzgcVar5;
                        i35++;
                        zzgcVar5 = zzgcVar5;
                        secureRandomZzG = secureRandomZzG;
                        zzkqVar2 = zzkqVar2;
                    }
                    zzgcVar = zzgcVar5;
                    zzkq zzkqVar3 = zzkqVar2;
                    if (arrayList2.size() < zzgcVar.zza()) {
                        zzgcVar.zzr();
                        zzgcVar.zzg(arrayList2);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzamVar9.zzE((zzas) entry.getValue());
                    }
                    zzkqVar = zzkqVar3;
                } else {
                    zzgcVar = zzgcVar5;
                    zzkqVar = zzkqVar2;
                }
                String strZzx2 = zzkqVar.zza.zzx();
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzh zzhVarZzj2 = zzamVar10.zzj(strZzx2);
                if (zzhVarZzj2 == null) {
                    zzay().zzd().zzb("Bundling raw events w/o app info. appId", zzeh.zzn(zzkqVar.zza.zzx()));
                } else if (zzgcVar.zza() > 0) {
                    long jZzn = zzhVarZzj2.zzn();
                    if (jZzn != 0) {
                        zzgcVar.zzab(jZzn);
                    } else {
                        zzgcVar.zzv();
                    }
                    long jZzp = zzhVarZzj2.zzp();
                    if (jZzp != 0) {
                        jZzn = jZzp;
                    }
                    if (jZzn != 0) {
                        zzgcVar.zzac(jZzn);
                    } else {
                        zzgcVar.zzw();
                    }
                    zzhVarZzj2.zzE();
                    zzgcVar.zzI((int) zzhVarZzj2.zzo());
                    zzhVarZzj2.zzab(zzgcVar.zzd());
                    zzhVarZzj2.zzZ(zzgcVar.zzc());
                    String strZzs = zzhVarZzj2.zzs();
                    if (strZzs != null) {
                        zzgcVar.zzW(strZzs);
                    } else {
                        zzgcVar.zzs();
                    }
                    zzam zzamVar11 = this.zze;
                    zzal(zzamVar11);
                    zzamVar11.zzD(zzhVarZzj2);
                }
                if (zzgcVar.zza() > 0) {
                    this.zzn.zzaw();
                    zzfi zzfiVar9 = this.zzc;
                    zzal(zzfiVar9);
                    com.google.android.gms.internal.measurement.zzff zzffVarZze = zzfiVar9.zze(zzkqVar.zza.zzx());
                    if (zzffVarZze != null && zzffVarZze.zzs()) {
                        zzgcVar.zzK(zzffVarZze.zzc());
                    } else if (zzkqVar.zza.zzF().isEmpty()) {
                        zzgcVar.zzK(-1L);
                    } else {
                        zzay().zzk().zzb("Did not find measurement config or missing version info. appId", zzeh.zzn(zzkqVar.zza.zzx()));
                    }
                    zzam zzamVar12 = this.zze;
                    zzal(zzamVar12);
                    com.google.android.gms.internal.measurement.zzgd zzgdVar = (com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC();
                    zzamVar12.zzg();
                    zzamVar12.zzW();
                    Preconditions.checkNotNull(zzgdVar);
                    Preconditions.checkNotEmpty(zzgdVar.zzx());
                    Preconditions.checkState(zzgdVar.zzbe());
                    zzamVar12.zzz();
                    long jCurrentTimeMillis = zzamVar12.zzt.zzav().currentTimeMillis();
                    long jZzk = zzgdVar.zzk();
                    zzamVar12.zzt.zzf();
                    if (jZzk >= jCurrentTimeMillis - zzag.zzA()) {
                        long jZzk2 = zzgdVar.zzk();
                        zzamVar12.zzt.zzf();
                        if (jZzk2 > zzag.zzA() + jCurrentTimeMillis) {
                            zzamVar12.zzt.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeh.zzn(zzgdVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgdVar.zzk()));
                        }
                    } else {
                        zzamVar12.zzt.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeh.zzn(zzgdVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgdVar.zzk()));
                    }
                    byte[] bArrZzbu = zzgdVar.zzbu();
                    try {
                        zzkv zzkvVar2 = zzamVar12.zzf.zzi;
                        zzal(zzkvVar2);
                        byte[] bArrZzy = zzkvVar2.zzy(bArrZzbu);
                        zzamVar12.zzt.zzay().zzj().zzb("Saving bundle, size", Integer.valueOf(bArrZzy.length));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", zzgdVar.zzx());
                        contentValues.put("bundle_end_timestamp", Long.valueOf(zzgdVar.zzk()));
                        contentValues.put("data", bArrZzy);
                        contentValues.put("has_realtime", Integer.valueOf(i11));
                        if (zzgdVar.zzbk()) {
                            contentValues.put(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(zzgdVar.zze()));
                        }
                        try {
                            if (zzamVar12.zzh().insert("queue", null, contentValues) == -1) {
                                zzamVar12.zzt.zzay().zzd().zzb("Failed to insert bundle (got -1). appId", zzeh.zzn(zzgdVar.zzx()));
                            }
                        } catch (SQLiteException e12) {
                            zzamVar12.zzt.zzay().zzd().zzc("Error storing bundle. appId", zzeh.zzn(zzgdVar.zzx()), e12);
                        }
                    } catch (IOException e13) {
                        zzamVar12.zzt.zzay().zzd().zzc("Data loss. Failed to serialize bundle. appId", zzeh.zzn(zzgdVar.zzx()), e13);
                    }
                }
                zzam zzamVar13 = this.zze;
                zzal(zzamVar13);
                List list2 = zzkqVar.zzb;
                Preconditions.checkNotNull(list2);
                zzamVar13.zzg();
                zzamVar13.zzW();
                StringBuilder sb2 = new StringBuilder("rowid in (");
                for (int i36 = 0; i36 < list2.size(); i36++) {
                    if (i36 != 0) {
                        sb2.append(",");
                    }
                    sb2.append(((Long) list2.get(i36)).longValue());
                }
                sb2.append(")");
                int iDelete = zzamVar13.zzh().delete("raw_events", sb2.toString(), null);
                if (iDelete != list2.size()) {
                    zzamVar13.zzt.zzay().zzd().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list2.size()));
                }
                zzam zzamVar14 = this.zze;
                zzal(zzamVar14);
                try {
                    zzamVar14.zzh().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzx2, strZzx2});
                } catch (SQLiteException e14) {
                    zzamVar14.zzt.zzay().zzd().zzc("Failed to remove unused event metadata. appId", zzeh.zzn(strZzx2), e14);
                }
                zzam zzamVar15 = this.zze;
                zzal(zzamVar15);
                zzamVar15.zzC();
                zzam zzamVar16 = this.zze;
                zzal(zzamVar16);
                zzamVar16.zzx();
                return true;
            }
            zzam zzamVar17 = this.zze;
            zzal(zzamVar17);
            zzamVar17.zzC();
            zzam zzamVar18 = this.zze;
            zzal(zzamVar18);
            zzamVar18.zzx();
            return false;
        } catch (Throwable th2) {
            zzam zzamVar19 = this.zze;
            zzal(zzamVar19);
            zzamVar19.zzx();
            throw th2;
        }
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        if (zzamVar.zzF()) {
            return true;
        }
        zzam zzamVar2 = this.zze;
        zzal(zzamVar2);
        return !TextUtils.isEmpty(zzamVar2.zzr());
    }

    private final boolean zzaj(com.google.android.gms.internal.measurement.zzfs zzfsVar, com.google.android.gms.internal.measurement.zzfs zzfsVar2) {
        Preconditions.checkArgument("_e".equals(zzfsVar.zzo()));
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzB = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaC(), "_sc");
        String strZzh = zzfxVarZzB == null ? null : zzfxVarZzB.zzh();
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzB2 = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar2.zzaC(), "_pc");
        String strZzh2 = zzfxVarZzB2 != null ? zzfxVarZzB2.zzh() : null;
        if (strZzh2 == null || !strZzh2.equals(strZzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfsVar.zzo()));
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzB3 = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar.zzaC(), "_et");
        if (zzfxVarZzB3 == null || !zzfxVarZzB3.zzw() || zzfxVarZzB3.zzd() <= 0) {
            return true;
        }
        long jZzd = zzfxVarZzB3.zzd();
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzB4 = zzkv.zzB((com.google.android.gms.internal.measurement.zzft) zzfsVar2.zzaC(), "_et");
        if (zzfxVarZzB4 != null && zzfxVarZzB4.zzd() > 0) {
            jZzd += zzfxVarZzB4.zzd();
        }
        zzal(this.zzi);
        zzkv.zzz(zzfsVar2, "_et", Long.valueOf(jZzd));
        zzal(this.zzi);
        zzkv.zzz(zzfsVar, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzqVar) {
        return (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) ? false : true;
    }

    private static final zzkh zzal(zzkh zzkhVar) {
        if (zzkhVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkhVar.zzY()) {
            return zzkhVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzkhVar.getClass())));
    }

    public static zzkt zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkt.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzkt((zzku) Preconditions.checkNotNull(new zzku(context)), null);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return zzb;
    }

    public static /* bridge */ /* synthetic */ void zzy(zzkt zzktVar, zzku zzkuVar) {
        zzktVar.zzaz().zzg();
        zzktVar.zzm = new zzez(zzktVar);
        zzam zzamVar = new zzam(zzktVar);
        zzamVar.zzX();
        zzktVar.zze = zzamVar;
        zzktVar.zzg().zzq((zzaf) Preconditions.checkNotNull(zzktVar.zzc));
        zzjo zzjoVar = new zzjo(zzktVar);
        zzjoVar.zzX();
        zzktVar.zzk = zzjoVar;
        zzaa zzaaVar = new zzaa(zzktVar);
        zzaaVar.zzX();
        zzktVar.zzh = zzaaVar;
        zzic zzicVar = new zzic(zzktVar);
        zzicVar.zzX();
        zzktVar.zzj = zzicVar;
        zzkf zzkfVar = new zzkf(zzktVar);
        zzkfVar.zzX();
        zzktVar.zzg = zzkfVar;
        zzktVar.zzf = new zzep(zzktVar);
        if (zzktVar.zzr != zzktVar.zzs) {
            zzktVar.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzktVar.zzr), Integer.valueOf(zzktVar.zzs));
        }
        zzktVar.zzo = true;
    }

    @VisibleForTesting
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzZ()) {
            FileChannel fileChannel = this.zzx;
            zzaz().zzg();
            int i11 = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzay().zzd().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i12 = fileChannel.read(byteBufferAllocate);
                    if (i12 == 4) {
                        byteBufferAllocate.flip();
                        i11 = byteBufferAllocate.getInt();
                    } else if (i12 != -1) {
                        zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(i12));
                    }
                } catch (IOException e11) {
                    zzay().zzd().zzb("Failed to read from channel", e11);
                }
            }
            int iZzi = this.zzn.zzh().zzi();
            zzaz().zzg();
            if (i11 > iZzi) {
                zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i11), Integer.valueOf(iZzi));
                return;
            }
            if (i11 < iZzi) {
                FileChannel fileChannel2 = this.zzx;
                zzaz().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzi);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i11), Integer.valueOf(iZzi));
                        return;
                    } catch (IOException e12) {
                        zzay().zzd().zzb("Failed to write to channel", e12);
                    }
                }
                zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i11), Integer.valueOf(iZzi));
            }
        }
    }

    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzC(String str, com.google.android.gms.internal.measurement.zzgc zzgcVar) {
        int iZza;
        int iIndexOf;
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        Set setZzk = zzfiVar.zzk(str);
        if (setZzk != null) {
            zzgcVar.zzi(setZzk);
        }
        zzfi zzfiVar2 = this.zzc;
        zzal(zzfiVar2);
        if (zzfiVar2.zzv(str)) {
            zzgcVar.zzp();
        }
        zzfi zzfiVar3 = this.zzc;
        zzal(zzfiVar3);
        if (zzfiVar3.zzy(str)) {
            if (zzg().zzs(str, zzdu.zzaq)) {
                String strZzar = zzgcVar.zzar();
                if (!TextUtils.isEmpty(strZzar) && (iIndexOf = strZzar.indexOf(InstructionFileId.DOT)) != -1) {
                    zzgcVar.zzY(strZzar.substring(0, iIndexOf));
                }
            } else {
                zzgcVar.zzu();
            }
        }
        zzfi zzfiVar4 = this.zzc;
        zzal(zzfiVar4);
        if (zzfiVar4.zzz(str) && (iZza = zzkv.zza(zzgcVar, "_id")) != -1) {
            zzgcVar.zzB(iZza);
        }
        zzfi zzfiVar5 = this.zzc;
        zzal(zzfiVar5);
        if (zzfiVar5.zzx(str)) {
            zzgcVar.zzq();
        }
        zzfi zzfiVar6 = this.zzc;
        zzal(zzfiVar6);
        if (zzfiVar6.zzu(str)) {
            zzgcVar.zzn();
            zzks zzksVar = (zzks) this.zzC.get(str);
            if (zzksVar == null || zzksVar.zzb + zzg().zzi(str, zzdu.zzR) < zzav().elapsedRealtime()) {
                zzksVar = new zzks(this);
                this.zzC.put(str, zzksVar);
            }
            zzgcVar.zzR(zzksVar.zza);
        }
        zzfi zzfiVar7 = this.zzc;
        zzal(zzfiVar7);
        if (zzfiVar7.zzw(str)) {
            zzgcVar.zzy();
        }
    }

    public final void zzD(zzh zzhVar) {
        a aVar;
        a aVar2;
        zzaz().zzg();
        if (TextUtils.isEmpty(zzhVar.zzy()) && TextUtils.isEmpty(zzhVar.zzr())) {
            zzI((String) Preconditions.checkNotNull(zzhVar.zzt()), 204, null, null, null);
            return;
        }
        zzki zzkiVar = this.zzl;
        Uri.Builder builder = new Uri.Builder();
        String strZzy = zzhVar.zzy();
        if (TextUtils.isEmpty(strZzy)) {
            strZzy = zzhVar.zzr();
        }
        a aVar3 = null;
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) zzdu.zzd.zza(null)).encodedAuthority((String) zzdu.zze.zza(null)).path("config/app/".concat(String.valueOf(strZzy))).appendQueryParameter(TrackingKey.PLATFORM, "android");
        zzkiVar.zzt.zzf().zzh();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            String str = (String) Preconditions.checkNotNull(zzhVar.zzt());
            URL url = new URL(string);
            zzay().zzj().zzb("Fetching remote configuration", str);
            zzfi zzfiVar = this.zzc;
            zzal(zzfiVar);
            com.google.android.gms.internal.measurement.zzff zzffVarZze = zzfiVar.zze(str);
            zzfi zzfiVar2 = this.zzc;
            zzal(zzfiVar2);
            String strZzh = zzfiVar2.zzh(str);
            if (zzffVarZze == null) {
                aVar = aVar3;
            } else {
                if (TextUtils.isEmpty(strZzh)) {
                    aVar2 = null;
                } else {
                    aVar2 = new a();
                    aVar2.put("If-Modified-Since", strZzh);
                }
                zzox.zzc();
                if (zzg().zzs(null, zzdu.zzao)) {
                    zzfi zzfiVar3 = this.zzc;
                    zzal(zzfiVar3);
                    String strZzf = zzfiVar3.zzf(str);
                    if (!TextUtils.isEmpty(strZzf)) {
                        if (aVar2 == null) {
                            aVar2 = new a();
                        }
                        aVar3 = aVar2;
                        aVar3.put("If-None-Match", strZzf);
                        aVar = aVar3;
                    }
                }
                aVar = aVar2;
            }
            this.zzt = true;
            zzen zzenVar = this.zzd;
            zzal(zzenVar);
            zzkl zzklVar = new zzkl(this);
            zzenVar.zzg();
            zzenVar.zzW();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzklVar);
            zzenVar.zzt.zzaz().zzo(new zzem(zzenVar, str, url, null, aVar, zzklVar));
        } catch (MalformedURLException unused) {
            zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeh.zzn(zzhVar.zzt()), string);
        }
    }

    public final void zzE(zzaw zzawVar, zzq zzqVar) {
        zzaw zzawVar2;
        List<zzac> listZzt;
        List<zzac> listZzt2;
        List<zzac> listZzt3;
        String str;
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzqVar.zza;
        long j11 = zzawVar.zzd;
        zzei zzeiVarZzb = zzei.zzb(zzawVar);
        zzaz().zzg();
        zzie zzieVar = null;
        if (this.zzD != null && (str = this.zzE) != null && str.equals(str2)) {
            zzieVar = this.zzD;
        }
        zzlb.zzK(zzieVar, zzeiVarZzb.zzd, false);
        zzaw zzawVarZza = zzeiVarZzb.zza();
        zzal(this.zzi);
        if (zzkv.zzA(zzawVarZza, zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            List list = zzqVar.zzt;
            if (list == null) {
                zzawVar2 = zzawVarZza;
            } else if (!list.contains(zzawVarZza.zza)) {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzawVarZza.zza, zzawVarZza.zzc);
                return;
            } else {
                Bundle bundleZzc = zzawVarZza.zzb.zzc();
                bundleZzc.putLong("ga_safelisted", 1L);
                zzawVar2 = new zzaw(zzawVarZza.zza, new zzau(bundleZzc), zzawVarZza.zzc, zzawVarZza.zzd);
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                Preconditions.checkNotEmpty(str2);
                zzamVar2.zzg();
                zzamVar2.zzW();
                if (j11 < 0) {
                    zzamVar2.zzt.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeh.zzn(str2), Long.valueOf(j11));
                    listZzt = Collections.emptyList();
                } else {
                    listZzt = zzamVar2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j11)});
                }
                for (zzac zzacVar : listZzt) {
                    if (zzacVar != null) {
                        zzay().zzj().zzd("User property timed out", zzacVar.zza, this.zzn.zzj().zzf(zzacVar.zzc.zzb), zzacVar.zzc.zza());
                        zzaw zzawVar3 = zzacVar.zzg;
                        if (zzawVar3 != null) {
                            zzY(new zzaw(zzawVar3, j11), zzqVar);
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzamVar3.zza(str2, zzacVar.zzc.zzb);
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                Preconditions.checkNotEmpty(str2);
                zzamVar4.zzg();
                zzamVar4.zzW();
                if (j11 < 0) {
                    zzamVar4.zzt.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeh.zzn(str2), Long.valueOf(j11));
                    listZzt2 = Collections.emptyList();
                } else {
                    listZzt2 = zzamVar4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j11)});
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                for (zzac zzacVar2 : listZzt2) {
                    if (zzacVar2 != null) {
                        zzay().zzj().zzd("User property expired", zzacVar2.zza, this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzA(str2, zzacVar2.zzc.zzb);
                        zzaw zzawVar4 = zzacVar2.zzk;
                        if (zzawVar4 != null) {
                            arrayList.add(zzawVar4);
                        }
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zza(str2, zzacVar2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzY(new zzaw((zzaw) it.next(), j11), zzqVar);
                }
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                String str3 = zzawVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzamVar7.zzg();
                zzamVar7.zzW();
                if (j11 < 0) {
                    zzamVar7.zzt.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), zzamVar7.zzt.zzj().zzd(str3), Long.valueOf(j11));
                    listZzt3 = Collections.emptyList();
                } else {
                    listZzt3 = zzamVar7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j11)});
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzac zzacVar3 : listZzt3) {
                    if (zzacVar3 != null) {
                        zzkw zzkwVar = zzacVar3.zzc;
                        zzky zzkyVar = new zzky((String) Preconditions.checkNotNull(zzacVar3.zza), zzacVar3.zzb, zzkwVar.zzb, j11, Preconditions.checkNotNull(zzkwVar.zza()));
                        zzam zzamVar8 = this.zze;
                        zzal(zzamVar8);
                        if (zzamVar8.zzL(zzkyVar)) {
                            zzay().zzj().zzd("User property triggered", zzacVar3.zza, this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeh.zzn(zzacVar3.zza), this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                        }
                        zzaw zzawVar5 = zzacVar3.zzi;
                        if (zzawVar5 != null) {
                            arrayList2.add(zzawVar5);
                        }
                        zzacVar3.zzc = new zzkw(zzkyVar);
                        zzacVar3.zze = true;
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzamVar9.zzK(zzacVar3);
                    }
                }
                zzY(zzawVar2, zzqVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzY(new zzaw((zzaw) it2.next(), j11), zzqVar);
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzC();
            } finally {
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzamVar11.zzx();
            }
        }
    }

    public final void zzF(zzaw zzawVar, String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        if (zzhVarZzj == null || TextUtils.isEmpty(zzhVarZzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzad = zzad(zzhVarZzj);
        if (boolZzad == null) {
            if (!"_ui".equals(zzawVar.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeh.zzn(str));
            }
        } else if (!boolZzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeh.zzn(str));
            return;
        }
        String strZzy = zzhVarZzj.zzy();
        String strZzw = zzhVarZzj.zzw();
        long jZzb = zzhVarZzj.zzb();
        String strZzv = zzhVarZzj.zzv();
        long jZzm = zzhVarZzj.zzm();
        long jZzj = zzhVarZzj.zzj();
        boolean zZzai = zzhVarZzj.zzai();
        String strZzx = zzhVarZzj.zzx();
        zzhVarZzj.zza();
        zzG(zzawVar, new zzq(str, strZzy, strZzw, jZzb, strZzv, jZzm, jZzj, (String) null, zZzai, false, strZzx, 0L, 0L, 0, zzhVarZzj.zzah(), false, zzhVarZzj.zzr(), zzhVarZzj.zzq(), zzhVarZzj.zzk(), zzhVarZzj.zzC(), (String) null, zzh(str).zzh(), "", (String) null));
    }

    public final void zzG(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzei zzeiVarZzb = zzei.zzb(zzawVar);
        zzlb zzlbVarZzv = zzv();
        Bundle bundle = zzeiVarZzb.zzd;
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzlbVarZzv.zzL(bundle, zzamVar.zzi(zzqVar.zza));
        zzv().zzM(zzeiVarZzb, zzg().zzd(zzqVar.zza));
        zzaw zzawVarZza = zzeiVarZzb.zza();
        if ("_cmp".equals(zzawVarZza.zza) && "referrer API v2".equals(zzawVarZza.zzb.zzg("_cis"))) {
            String strZzg = zzawVarZza.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(strZzg)) {
                zzW(new zzkw("_lgclid", zzawVarZza.zzd, strZzg, "auto"), zzqVar);
            }
        }
        zzE(zzawVarZza, zzqVar);
    }

    public final void zzH() {
        this.zzs++;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048 A[PHI: r10
  0x0048: PHI (r10v11 int) = (r10v2 int), (r10v0 int) binds: [B:15:0x004a, B:12:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:49:0x010a  */
    @VisibleForTesting
    public final void zzI(String str, int i11, Throwable th2, byte[] bArr, Map map) {
        boolean z11;
        String str2;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th3) {
                this.zzt = false;
                zzae();
                throw th3;
            }
        }
        zzef zzefVarZzj = zzay().zzj();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzefVarZzj.zzb("onConfigFetched. Response size", numValueOf);
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzh zzhVarZzj = zzamVar2.zzj(str);
            if (i11 == 200 || i11 == 204) {
                if (th2 == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else if (i11 == 304) {
                i11 = 304;
                if (th2 == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            if (zzhVarZzj == null) {
                zzay().zzk().zzb("App does not exist in onConfigFetched. appId", zzeh.zzn(str));
            } else if (z11 || i11 == 404) {
                List list = map != null ? (List) map.get(HttpHeaders.LAST_MODIFIED) : null;
                String str3 = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                zzox.zzc();
                if (zzg().zzs(null, zzdu.zzao)) {
                    List list2 = map != null ? (List) map.get("ETag") : null;
                    if (list2 == null || list2.isEmpty()) {
                        str2 = null;
                    } else {
                        str2 = (String) list2.get(0);
                    }
                } else {
                    str2 = null;
                }
                if (i11 == 404 || i11 == 304) {
                    zzfi zzfiVar = this.zzc;
                    zzal(zzfiVar);
                    if (zzfiVar.zze(str) == null) {
                        zzfi zzfiVar2 = this.zzc;
                        zzal(zzfiVar2);
                        zzfiVar2.zzt(str, null, null, null);
                    }
                } else {
                    zzfi zzfiVar3 = this.zzc;
                    zzal(zzfiVar3);
                    zzfiVar3.zzt(str, bArr, str3, str2);
                }
                zzhVarZzj.zzL(zzav().currentTimeMillis());
                zzam zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzamVar3.zzD(zzhVarZzj);
                if (i11 == 404) {
                    zzay().zzl().zzb("Config not found. Using empty config. appId", str);
                } else {
                    zzay().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i11), numValueOf);
                }
                zzen zzenVar = this.zzd;
                zzal(zzenVar);
                if (zzenVar.zza() && zzai()) {
                    zzX();
                } else {
                    zzag();
                }
            } else {
                zzhVarZzj.zzU(zzav().currentTimeMillis());
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzamVar4.zzD(zzhVarZzj);
                zzay().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i11), th2);
                zzfi zzfiVar4 = this.zzc;
                zzal(zzfiVar4);
                zzfiVar4.zzl(str);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i11 == 503 || i11 == 429) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzag();
            }
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzamVar5.zzC();
            zzam zzamVar6 = this.zze;
            zzal(zzamVar6);
            zzamVar6.zzx();
            this.zzt = false;
            zzae();
        } catch (Throwable th4) {
            zzam zzamVar7 = this.zze;
            zzal(zzamVar7);
            zzamVar7.zzx();
            throw th4;
        }
    }

    public final void zzJ(boolean z11) {
        zzag();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006d A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #1 {all -> 0x00a2, blocks: (B:15:0x0063, B:16:0x0067, B:18:0x006d, B:19:0x0073, B:20:0x008f, B:23:0x009a, B:24:0x00a1, B:28:0x00a5, B:29:0x00b4, B:31:0x00b6, B:33:0x00ba, B:36:0x00c1, B:37:0x00c2), top: B:61:0x0063, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00eb A[Catch: all -> 0x0010, SQLiteException -> 0x00e9, TryCatch #2 {SQLiteException -> 0x00e9, blocks: (B:14:0x002a, B:38:0x00ca, B:40:0x00df, B:42:0x00e5, B:46:0x00f2, B:45:0x00eb, B:47:0x00f5, B:48:0x00fd), top: B:62:0x002a, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0129 A[Catch: all -> 0x0010, PHI: r9
  0x0129: PHI (r9v18 int) = (r9v2 int), (r9v0 int) binds: [B:13:0x0028, B:11:0x0024] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:7:0x0013, B:50:0x0129, B:55:0x0160, B:54:0x0151, B:14:0x002a, B:38:0x00ca, B:40:0x00df, B:42:0x00e5, B:46:0x00f2, B:45:0x00eb, B:47:0x00f5, B:48:0x00fd, B:49:0x00fe), top: B:60:0x000d, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x014d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0151 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:7:0x0013, B:50:0x0129, B:55:0x0160, B:54:0x0151, B:14:0x002a, B:38:0x00ca, B:40:0x00df, B:42:0x00e5, B:46:0x00f2, B:45:0x00eb, B:47:0x00f5, B:48:0x00fd, B:49:0x00fe), top: B:60:0x000d, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0099 A[SYNTHETIC] */
    @VisibleForTesting
    public final void zzK(int i11, Throwable th2, byte[] bArr, String str) {
        zzen zzenVar;
        zzam zzamVar;
        long jLongValue;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th3) {
                this.zzu = false;
                zzae();
                throw th3;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i11 == 200) {
            if (th2 == null) {
                try {
                    this.zzk.zzc.zzb(zzav().currentTimeMillis());
                    this.zzk.zzd.zzb(0L);
                    zzag();
                    zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i11), Integer.valueOf(bArr.length));
                    zzam zzamVar2 = this.zze;
                    zzal(zzamVar2);
                    zzamVar2.zzw();
                    try {
                        for (Long l11 : list) {
                            try {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                jLongValue = l11.longValue();
                                zzamVar.zzg();
                                zzamVar.zzW();
                                try {
                                    if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) == 1) {
                                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                                    }
                                } catch (SQLiteException e11) {
                                    zzamVar.zzt.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e11);
                                    throw e11;
                                }
                            } catch (SQLiteException e12) {
                                List list2 = this.zzz;
                                if (list2 == null || !list2.contains(l11)) {
                                    throw e12;
                                }
                            }
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzamVar3.zzC();
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzx();
                        this.zzz = null;
                        zzenVar = this.zzd;
                        zzal(zzenVar);
                        if (zzenVar.zza() || !zzai()) {
                            this.zzA = -1L;
                            zzag();
                        } else {
                            zzX();
                        }
                        this.zza = 0L;
                    } catch (Throwable th4) {
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzx();
                        throw th4;
                    }
                } catch (SQLiteException e13) {
                    zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e13);
                    this.zza = zzav().elapsedRealtime();
                    zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
                }
            } else {
                zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i11), th2);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i11 != 503 || i11 == 429) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzy(list);
                zzag();
            }
        } else if (i11 == 204) {
            i11 = 204;
            if (th2 == null) {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0L);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i11), Integer.valueOf(bArr.length));
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                zzamVar7.zzw();
                while (r9.hasNext()) {
                    zzamVar = this.zze;
                    zzal(zzamVar);
                    jLongValue = l11.longValue();
                    zzamVar.zzg();
                    zzamVar.zzW();
                    if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) == 1) {
                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                    }
                }
                zzam zzamVar8 = this.zze;
                zzal(zzamVar8);
                zzamVar8.zzC();
                zzam zzamVar9 = this.zze;
                zzal(zzamVar9);
                zzamVar9.zzx();
                this.zzz = null;
                zzenVar = this.zzd;
                zzal(zzenVar);
                if (zzenVar.zza()) {
                    this.zzA = -1L;
                    zzag();
                } else {
                    this.zzA = -1L;
                    zzag();
                }
                this.zza = 0L;
            } else {
                zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i11), th2);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i11 != 503) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                } else {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzy(list);
                zzag();
            }
        } else {
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i11), th2);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i11 != 503) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            } else {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzam zzamVar11 = this.zze;
            zzal(zzamVar11);
            zzamVar11.zzy(list);
            zzag();
        }
        this.zzu = false;
        zzae();
    }

    /* JADX WARN: Code duplicated, block: B:163:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:78:0x023d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0241 A[Catch: all -> 0x00c5, TryCatch #2 {all -> 0x00c5, blocks: (B:23:0x00a4, B:25:0x00b3, B:45:0x011a, B:47:0x012e, B:49:0x0144, B:50:0x016b, B:52:0x01c3, B:54:0x01cb, B:58:0x01d7, B:65:0x0207, B:67:0x0212, B:72:0x0225, B:75:0x0233, B:79:0x023e, B:81:0x0241, B:83:0x0262, B:85:0x0267, B:88:0x0286, B:91:0x029a, B:93:0x02c1, B:96:0x02cb, B:98:0x02da, B:133:0x03c7, B:135:0x03f9, B:136:0x03fc, B:138:0x0425, B:178:0x04f1, B:179:0x04f4, B:187:0x056f, B:140:0x043a, B:145:0x045e, B:147:0x0466, B:149:0x046c, B:153:0x047f, B:157:0x0490, B:161:0x049c, B:164:0x04b2, B:169:0x04d5, B:171:0x04da, B:173:0x04e2, B:175:0x04e8, B:167:0x04c2, B:155:0x0488, B:143:0x044a, B:100:0x02ed, B:102:0x0318, B:103:0x0328, B:105:0x032f, B:107:0x0335, B:109:0x033f, B:111:0x0345, B:113:0x034b, B:115:0x0351, B:116:0x0356, B:118:0x0361, B:122:0x0378, B:128:0x0380, B:129:0x0394, B:131:0x03a7, B:132:0x03b8, B:180:0x0509, B:182:0x053a, B:183:0x053d, B:184:0x0552, B:186:0x0556, B:86:0x0276, B:62:0x01ef, B:31:0x00c8, B:33:0x00cc, B:37:0x00dd, B:39:0x00f4, B:41:0x00fe, B:44:0x010a), top: B:197:0x00a4, inners: #0, #4 }] */
    public final void zzL(zzq zzqVar) {
        String str;
        String str2;
        String str3;
        long j11;
        zzas zzasVarZzn;
        boolean z11;
        int i11;
        PackageInfo packageInfo;
        int i12;
        ApplicationInfo applicationInfo;
        int i13;
        long j12;
        boolean z12;
        boolean z13;
        String strZzw;
        boolean z14;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        if (zzak(zzqVar)) {
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzh zzhVarZzj = zzamVar.zzj(zzqVar.zza);
            if (zzhVarZzj != null && TextUtils.isEmpty(zzhVarZzj.zzy()) && !TextUtils.isEmpty(zzqVar.zzb)) {
                zzhVarZzj.zzL(0L);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzamVar2.zzD(zzhVarZzj);
                zzfi zzfiVar = this.zzc;
                zzal(zzfiVar);
                zzfiVar.zzm(zzqVar.zza);
            }
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            long jCurrentTimeMillis = zzqVar.zzm;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzav().currentTimeMillis();
            }
            this.zzn.zzg().zzd();
            int i14 = zzqVar.zzn;
            if (i14 != 0 && i14 != 1) {
                zzay().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzeh.zzn(zzqVar.zza), Integer.valueOf(i14));
                i14 = 0;
            }
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzamVar3.zzw();
            try {
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzky zzkyVarZzp = zzamVar4.zzp(zzqVar.zza, "_npa");
                if (zzkyVarZzp != null && !"auto".equals(zzkyVarZzp.zzb)) {
                    str = "_sysu";
                    str2 = "_sys";
                } else if (zzqVar.zzr != null) {
                    str = "_sysu";
                    str2 = "_sys";
                    zzkw zzkwVar = new zzkw("_npa", jCurrentTimeMillis, Long.valueOf(true != zzqVar.zzr.booleanValue() ? 0L : 1L), "auto");
                    if (zzkyVarZzp == null || !zzkyVarZzp.zze.equals(zzkwVar.zzd)) {
                        zzW(zzkwVar, zzqVar);
                    }
                } else {
                    str = "_sysu";
                    str2 = "_sys";
                    if (zzkyVarZzp != null) {
                        zzP(new zzkw("_npa", jCurrentTimeMillis, null, "auto"), zzqVar);
                    }
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzh zzhVarZzj2 = zzamVar5.zzj((String) Preconditions.checkNotNull(zzqVar.zza));
                if (zzhVarZzj2 == null || !zzv().zzam(zzqVar.zzb, zzhVarZzj2.zzy(), zzqVar.zzq, zzhVarZzj2.zzr())) {
                    str3 = "_pfo";
                } else {
                    zzay().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzeh.zzn(zzhVarZzj2.zzt()));
                    zzam zzamVar6 = this.zze;
                    zzal(zzamVar6);
                    String strZzt = zzhVarZzj2.zzt();
                    zzamVar6.zzW();
                    zzamVar6.zzg();
                    Preconditions.checkNotEmpty(strZzt);
                    try {
                        SQLiteDatabase sQLiteDatabaseZzh = zzamVar6.zzh();
                        String[] strArr = {strZzt};
                        int iDelete = sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("consent_settings", "app_id=?", strArr);
                        zzoi.zzc();
                        str3 = "_pfo";
                        try {
                            if (zzamVar6.zzt.zzf().zzs(null, zzdu.zzat)) {
                                iDelete += sQLiteDatabaseZzh.delete("default_event_params", "app_id=?", strArr);
                            }
                            if (iDelete > 0) {
                                zzamVar6.zzt.zzay().zzj().zzc("Deleted application data. app, records", strZzt, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e11) {
                            e = e11;
                            zzamVar6.zzt.zzay().zzd().zzc("Error deleting application data. appId, error", zzeh.zzn(strZzt), e);
                        }
                    } catch (SQLiteException e12) {
                        e = e12;
                        str3 = "_pfo";
                    }
                    zzhVarZzj2 = null;
                }
                if (zzhVarZzj2 != null) {
                    if (zzhVarZzj2.zzb() != -2147483648L) {
                        j11 = jCurrentTimeMillis;
                        z13 = zzhVarZzj2.zzb() != zzqVar.zzj;
                        strZzw = zzhVarZzj2.zzw();
                        if (zzhVarZzj2.zzb() == -2147483648L || strZzw == null || strZzw.equals(zzqVar.zzc)) {
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                        if (z14 | z13) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", strZzw);
                            zzE(new zzaw("_au", new zzau(bundle), "auto", j11), zzqVar);
                        }
                    } else {
                        j11 = jCurrentTimeMillis;
                    }
                    strZzw = zzhVarZzj2.zzw();
                    if (zzhVarZzj2.zzb() == -2147483648L) {
                        z14 = false;
                    } else {
                        z14 = false;
                    }
                    if (z14 | z13) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("_pv", strZzw);
                        zzE(new zzaw("_au", new zzau(bundle2), "auto", j11), zzqVar);
                    }
                } else {
                    j11 = jCurrentTimeMillis;
                }
                zzd(zzqVar);
                if (i14 == 0) {
                    zzam zzamVar7 = this.zze;
                    zzal(zzamVar7);
                    zzasVarZzn = zzamVar7.zzn(zzqVar.zza, "_f");
                    z11 = false;
                } else {
                    zzam zzamVar8 = this.zze;
                    zzal(zzamVar8);
                    zzasVarZzn = zzamVar8.zzn(zzqVar.zza, "_v");
                    z11 = true;
                }
                if (zzasVarZzn == null) {
                    long j13 = ((j11 / 3600000) + 1) * 3600000;
                    if (z11) {
                        zzW(new zzkw("_fvt", j11, Long.valueOf(j13), "auto"), zzqVar);
                        zzaz().zzg();
                        zzB();
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("_c", 1L);
                        bundle3.putLong("_r", 1L);
                        bundle3.putLong("_et", 1L);
                        if (zzqVar.zzp) {
                            bundle3.putLong("_dac", 1L);
                        }
                        zzG(new zzaw("_v", new zzau(bundle3), "auto", j11), zzqVar);
                    } else {
                        zzW(new zzkw("_fot", j11, Long.valueOf(j13), "auto"), zzqVar);
                        zzaz().zzg();
                        zzez zzezVar = (zzez) Preconditions.checkNotNull(this.zzm);
                        String str4 = zzqVar.zza;
                        if (str4 == null || str4.isEmpty()) {
                            i11 = 0;
                            zzezVar.zza.zzay().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzezVar.zza.zzaz().zzg();
                            if (zzezVar.zza()) {
                                zzey zzeyVar = new zzey(zzezVar, str4);
                                zzezVar.zza.zzaz().zzg();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzezVar.zza.zzau().getPackageManager();
                                if (packageManager == null) {
                                    zzezVar.zza.zzay().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    i11 = 0;
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzezVar.zza.zzay().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                                        if (serviceInfo != null) {
                                            String str5 = serviceInfo.packageName;
                                            if (serviceInfo.name != null && "com.android.vending".equals(str5) && zzezVar.zza()) {
                                                try {
                                                    try {
                                                        boolean zBindService = ConnectionTracker.getInstance().bindService(zzezVar.zza.zzau(), new Intent(intent), zzeyVar, 1);
                                                        zzef zzefVarZzj = zzezVar.zza.zzay().zzj();
                                                        String str6 = BluetoothBridge.EXTEA_AVALIABLE;
                                                        if (true != zBindService) {
                                                            str6 = "not available";
                                                        }
                                                        zzefVarZzj.zzb("Install Referrer Service is", str6);
                                                    } catch (RuntimeException e13) {
                                                        e = e13;
                                                        zzezVar.zza.zzay().zzd().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                    }
                                                } catch (RuntimeException e14) {
                                                    e = e14;
                                                }
                                            } else {
                                                zzezVar.zza.zzay().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzezVar.zza.zzay().zzi().zza("Install Referrer Reporter is not available");
                            }
                            i11 = 0;
                        }
                        zzaz().zzg();
                        zzB();
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("_c", 1L);
                        bundle4.putLong("_r", 1L);
                        bundle4.putLong("_uwa", 0L);
                        String str7 = str3;
                        bundle4.putLong(str7, 0L);
                        String str8 = str2;
                        bundle4.putLong(str8, 0L);
                        String str9 = str;
                        bundle4.putLong(str9, 0L);
                        bundle4.putLong("_et", 1L);
                        if (zzqVar.zzp) {
                            bundle4.putLong("_dac", 1L);
                        }
                        String str10 = (String) Preconditions.checkNotNull(zzqVar.zza);
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        Preconditions.checkNotEmpty(str10);
                        zzamVar9.zzg();
                        zzamVar9.zzW();
                        long jZzc = zzamVar9.zzc(str10, "first_open_count");
                        if (this.zzn.zzau().getPackageManager() == null) {
                            zzay().zzd().zzb("PackageManager is null, first open report might be inaccurate. appId", zzeh.zzn(str10));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(str10, i11);
                            } catch (PackageManager.NameNotFoundException e15) {
                                zzay().zzd().zzc("Package info is null, first open report might be inaccurate. appId", zzeh.zzn(str10), e15);
                                packageInfo = null;
                            }
                            if (packageInfo != null) {
                                long j14 = packageInfo.firstInstallTime;
                                if (j14 != 0) {
                                    if (j14 != packageInfo.lastUpdateTime) {
                                        applicationInfo = null;
                                        if (!zzg().zzs(null, zzdu.zzab)) {
                                            bundle4.putLong("_uwa", 1L);
                                        } else if (jZzc == 0) {
                                            bundle4.putLong("_uwa", 1L);
                                            jZzc = 0;
                                        }
                                        z12 = false;
                                    } else {
                                        applicationInfo = null;
                                        z12 = true;
                                    }
                                    i12 = 1;
                                    i13 = 0;
                                    zzW(new zzkw("_fi", j11, Long.valueOf(true != z12 ? 0L : 1L), "auto"), zzqVar);
                                } else {
                                    i12 = 1;
                                    applicationInfo = null;
                                    i13 = 0;
                                }
                            } else {
                                i12 = 1;
                                applicationInfo = null;
                                i13 = 0;
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzn.zzau()).getApplicationInfo(str10, i13);
                            } catch (PackageManager.NameNotFoundException e16) {
                                zzay().zzd().zzc("Application info is null, first open report might be inaccurate. appId", zzeh.zzn(str10), e16);
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & i12) != 0) {
                                    j12 = 1;
                                    bundle4.putLong(str8, 1L);
                                } else {
                                    j12 = 1;
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle4.putLong(str9, j12);
                                }
                            }
                        }
                        if (jZzc >= 0) {
                            bundle4.putLong(str7, jZzc);
                        }
                        zzG(new zzaw("_f", new zzau(bundle4), "auto", j11), zzqVar);
                    }
                } else if (zzqVar.zzi) {
                    zzG(new zzaw("_cd", new zzau(new Bundle()), "auto", j11), zzqVar);
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzC();
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzamVar11.zzx();
            } catch (Throwable th2) {
                zzam zzamVar12 = this.zze;
                zzal(zzamVar12);
                zzamVar12.zzx();
                throw th2;
            }
        }
    }

    public final void zzM() {
        this.zzr++;
    }

    public final void zzN(zzac zzacVar) {
        zzq zzqVarZzac = zzac((String) Preconditions.checkNotNull(zzacVar.zza));
        if (zzqVarZzac != null) {
            zzO(zzacVar, zzqVarZzac);
        }
    }

    public final void zzO(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                String str = (String) Preconditions.checkNotNull(zzacVar.zza);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzacVarZzk = zzamVar2.zzk(str, zzacVar.zzc.zzb);
                if (zzacVarZzk != null) {
                    zzay().zzc().zzc("Removing conditional user property", zzacVar.zza, this.zzn.zzj().zzf(zzacVar.zzc.zzb));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzamVar3.zza(str, zzacVar.zzc.zzb);
                    if (zzacVarZzk.zze) {
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzA(str, zzacVar.zzc.zzb);
                    }
                    zzaw zzawVar = zzacVar.zzk;
                    if (zzawVar != null) {
                        zzau zzauVar = zzawVar.zzb;
                        zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzacVar.zzk)).zza, zzauVar != null ? zzauVar.zzc() : null, zzacVarZzk.zzb, zzacVar.zzk.zzd, true, true)), zzqVar);
                    }
                } else {
                    zzay().zzk().zzc("Conditional user property doesn't exist", zzeh.zzn(zzacVar.zza), this.zzn.zzj().zzf(zzacVar.zzc.zzb));
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    public final void zzP(zzkw zzkwVar, zzq zzqVar) {
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            if ("_npa".equals(zzkwVar.zzb) && zzqVar.zzr != null) {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzkw("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzqVar.zzr.booleanValue() ? 0L : 1L), "auto"), zzqVar);
                return;
            }
            zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkwVar.zzb));
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                if ("_id".equals(zzkwVar.zzb)) {
                    zzam zzamVar2 = this.zze;
                    zzal(zzamVar2);
                    zzamVar2.zzA((String) Preconditions.checkNotNull(zzqVar.zza), "_lair");
                }
                zzam zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzamVar3.zzA((String) Preconditions.checkNotNull(zzqVar.zza), zzkwVar.zzb);
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzamVar4.zzC();
                zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkwVar.zzb));
            } finally {
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzx();
            }
        }
    }

    @VisibleForTesting
    public final void zzQ(zzq zzqVar) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        String str = (String) Preconditions.checkNotNull(zzqVar.zza);
        Preconditions.checkNotEmpty(str);
        zzamVar.zzg();
        zzamVar.zzW();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzamVar.zzh();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzamVar.zzt.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e11) {
            zzamVar.zzt.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeh.zzn(str), e11);
        }
        if (zzqVar.zzh) {
            zzL(zzqVar);
        }
    }

    public final void zzR(String str, zzie zzieVar) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzieVar != null) {
            this.zzE = str;
            this.zzD = zzieVar;
        }
    }

    public final void zzS() {
        zzaz().zzg();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    public final void zzT(zzac zzacVar) {
        zzq zzqVarZzac = zzac((String) Preconditions.checkNotNull(zzacVar.zza));
        if (zzqVarZzac != null) {
            zzU(zzacVar, zzqVarZzac);
        }
    }

    public final void zzU(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzb);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzac zzacVar2 = new zzac(zzacVar);
            boolean z11 = false;
            zzacVar2.zze = false;
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzacVarZzk = zzamVar2.zzk((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzc.zzb);
                if (zzacVarZzk != null && !zzacVarZzk.zzb.equals(zzacVar2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzb, zzacVarZzk.zzb);
                }
                if (zzacVarZzk != null && zzacVarZzk.zze) {
                    zzacVar2.zzb = zzacVarZzk.zzb;
                    zzacVar2.zzd = zzacVarZzk.zzd;
                    zzacVar2.zzh = zzacVarZzk.zzh;
                    zzacVar2.zzf = zzacVarZzk.zzf;
                    zzacVar2.zzi = zzacVarZzk.zzi;
                    zzacVar2.zze = true;
                    zzkw zzkwVar = zzacVar2.zzc;
                    zzacVar2.zzc = new zzkw(zzkwVar.zzb, zzacVarZzk.zzc.zzc, zzkwVar.zza(), zzacVarZzk.zzc.zzf);
                } else if (TextUtils.isEmpty(zzacVar2.zzf)) {
                    zzkw zzkwVar2 = zzacVar2.zzc;
                    zzacVar2.zzc = new zzkw(zzkwVar2.zzb, zzacVar2.zzd, zzkwVar2.zza(), zzacVar2.zzc.zzf);
                    zzacVar2.zze = true;
                    z11 = true;
                }
                if (zzacVar2.zze) {
                    zzkw zzkwVar3 = zzacVar2.zzc;
                    zzky zzkyVar = new zzky((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzb, zzkwVar3.zzb, zzkwVar3.zzc, Preconditions.checkNotNull(zzkwVar3.zza()));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzL(zzkyVar)) {
                        zzay().zzc().zzd("User property updated immediately", zzacVar2.zza, this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzacVar2.zza), this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                    }
                    if (z11 && zzacVar2.zzi != null) {
                        zzY(new zzaw(zzacVar2.zzi, zzacVar2.zzd), zzqVar);
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                if (zzamVar4.zzK(zzacVar2)) {
                    zzay().zzc().zzd("Conditional property added", zzacVar2.zza, this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeh.zzn(zzacVar2.zza), this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    public final void zzV(String str, zzai zzaiVar) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzaiVar);
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaiVar);
        zzamVar.zzg();
        zzamVar.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzaiVar.zzh());
        try {
            if (zzamVar.zzh().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzamVar.zzt.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e11) {
            zzamVar.zzt.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeh.zzn(str), e11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:45:0x0111  */
    public final void zzW(zzkw zzkwVar, zzq zzqVar) {
        zzas zzasVarZzn;
        long jLongValue;
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            int iZzl = zzv().zzl(zzkwVar.zzb);
            if (iZzl != 0) {
                zzlb zzlbVarZzv = zzv();
                String str = zzkwVar.zzb;
                zzg();
                String strZzD = zzlbVarZzv.zzD(str, 24, true);
                String str2 = zzkwVar.zzb;
                zzv().zzN(this.zzF, zzqVar.zza, iZzl, "_ev", strZzD, str2 != null ? str2.length() : 0);
                return;
            }
            int iZzd = zzv().zzd(zzkwVar.zzb, zzkwVar.zza());
            if (iZzd != 0) {
                zzlb zzlbVarZzv2 = zzv();
                String str3 = zzkwVar.zzb;
                zzg();
                String strZzD2 = zzlbVarZzv2.zzD(str3, 24, true);
                Object objZza = zzkwVar.zza();
                zzv().zzN(this.zzF, zzqVar.zza, iZzd, "_ev", strZzD2, (objZza == null || !((objZza instanceof String) || (objZza instanceof CharSequence))) ? 0 : objZza.toString().length());
                return;
            }
            Object objZzB = zzv().zzB(zzkwVar.zzb, zzkwVar.zza());
            if (objZzB == null) {
                return;
            }
            if ("_sid".equals(zzkwVar.zzb)) {
                long j11 = zzkwVar.zzc;
                String str4 = zzkwVar.zzf;
                String str5 = (String) Preconditions.checkNotNull(zzqVar.zza);
                zzam zzamVar = this.zze;
                zzal(zzamVar);
                zzky zzkyVarZzp = zzamVar.zzp(str5, "_sno");
                if (zzkyVarZzp != null) {
                    Object obj = zzkyVarZzp.zze;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (zzkyVarZzp != null) {
                            zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzkyVarZzp.zze);
                        }
                        zzam zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        zzasVarZzn = zzamVar2.zzn(str5, "_s");
                        if (zzasVarZzn != null) {
                            jLongValue = zzasVarZzn.zzc;
                            zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        } else {
                            jLongValue = 0;
                        }
                    }
                } else {
                    if (zzkyVarZzp != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzkyVarZzp.zze);
                    }
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzasVarZzn = zzamVar3.zzn(str5, "_s");
                    if (zzasVarZzn != null) {
                        jLongValue = zzasVarZzn.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                    } else {
                        jLongValue = 0;
                    }
                }
                zzW(new zzkw("_sno", j11, Long.valueOf(jLongValue + 1), str4), zzqVar);
            }
            zzky zzkyVar = new zzky((String) Preconditions.checkNotNull(zzqVar.zza), (String) Preconditions.checkNotNull(zzkwVar.zzf), zzkwVar.zzb, zzkwVar.zzc, objZzB);
            zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzkyVar.zzc), objZzB);
            zzam zzamVar4 = this.zze;
            zzal(zzamVar4);
            zzamVar4.zzw();
            try {
                if ("_id".equals(zzkyVar.zzc)) {
                    zzam zzamVar5 = this.zze;
                    zzal(zzamVar5);
                    zzky zzkyVarZzp2 = zzamVar5.zzp(zzqVar.zza, "_id");
                    if (zzkyVarZzp2 != null && !zzkyVar.zze.equals(zzkyVarZzp2.zze)) {
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zzA(zzqVar.zza, "_lair");
                    }
                }
                zzd(zzqVar);
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                boolean zZzL = zzamVar7.zzL(zzkyVar);
                zzam zzamVar8 = this.zze;
                zzal(zzamVar8);
                zzamVar8.zzC();
                if (!zZzL) {
                    zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzkyVar.zzc), zzkyVar.zze);
                    zzv().zzN(this.zzF, zzqVar.zza, 9, null, null, 0);
                }
            } finally {
                zzam zzamVar9 = this.zze;
                zzal(zzamVar9);
                zzamVar9.zzx();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x020d A[Catch: all -> 0x01ab, SQLiteException -> 0x01f9, TryCatch #4 {SQLiteException -> 0x01f9, blocks: (B:88:0x01dd, B:90:0x01e3, B:91:0x01ed, B:93:0x01f3, B:99:0x01fc, B:101:0x0207, B:103:0x020d, B:104:0x0214, B:122:0x026f, B:106:0x0229, B:111:0x0240, B:115:0x0247, B:116:0x0256, B:121:0x025c), top: B:253:0x01dd }] */
    /* JADX WARN: Code duplicated, block: B:110:0x023f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0275 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x02b4 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02c0 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02ca A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:154:0x02ed A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0301 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:157:0x0302 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0330 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x033e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0363 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0371  */
    /* JADX WARN: Code duplicated, block: B:175:0x0375 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x03af A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x03b4 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x03bc A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x03c4 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x03d3 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0402 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0413  */
    /* JADX WARN: Code duplicated, block: B:195:0x0436 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:196:0x046b A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x0486 A[Catch: all -> 0x0034, MalformedURLException -> 0x04f4, TryCatch #12 {MalformedURLException -> 0x04f4, blocks: (B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494), top: B:260:0x0474, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0494 A[Catch: all -> 0x0034, MalformedURLException -> 0x04f4, TryCatch #12 {MalformedURLException -> 0x04f4, blocks: (B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494), top: B:260:0x0474, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x04a6 A[Catch: all -> 0x0034, MalformedURLException -> 0x04f4, TryCatch #12 {MalformedURLException -> 0x04f4, blocks: (B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494), top: B:260:0x0474, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0580 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x058b A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:274:0x02e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:0x02de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:? A[LOOP:1: B:144:0x02c4->B:276:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:283:0x03e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x0280 A[ADDED_TO_REGION, EDGE_INSN: B:286:0x0280->B:127:0x0280 BREAK  A[LOOP:4: B:84:0x01b9->B:126:0x0278], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x01e3 A[EDGE_INSN: B:288:0x01e3->B:90:0x01e3 BREAK  A[LOOP:5: B:253:0x01dd->B:111:0x0240], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0136 A[Catch: all -> 0x0034, TryCatch #13 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:77:0x01a4, B:139:0x02ae, B:141:0x02b4, B:143:0x02c0, B:144:0x02c4, B:146:0x02ca, B:148:0x02de, B:152:0x02e7, B:154:0x02ed, B:160:0x0312, B:157:0x0302, B:159:0x030c, B:161:0x0315, B:163:0x0330, B:167:0x033f, B:169:0x0363, B:175:0x0375, B:177:0x03af, B:179:0x03b4, B:181:0x03bc, B:182:0x03bf, B:184:0x03c4, B:185:0x03c7, B:187:0x03d3, B:188:0x03e9, B:189:0x03f1, B:191:0x0402, B:193:0x0414, B:195:0x0436, B:197:0x0474, B:199:0x0486, B:201:0x049b, B:203:0x04a6, B:204:0x04af, B:200:0x0494, B:206:0x04f4, B:196:0x046b, B:127:0x0280, B:138:0x02ab, B:208:0x0508, B:209:0x050b, B:210:0x050c, B:215:0x054d, B:235:0x057a, B:237:0x0580, B:239:0x058b, B:223:0x055b, B:243:0x0596, B:244:0x0599), top: B:262:0x0010, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x015f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0161  */
    /* JADX WARN: Code duplicated, block: B:69:0x0167  */
    /* JADX WARN: Code duplicated, block: B:70:0x0169  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a0 A[Catch: all -> 0x01ab, SQLiteException -> 0x01ae, TRY_LEAVE, TryCatch #7 {all -> 0x01ab, blocks: (B:74:0x019a, B:76:0x01a0, B:83:0x01b3, B:84:0x01b9, B:85:0x01bd, B:86:0x01c8, B:88:0x01dd, B:90:0x01e3, B:91:0x01ed, B:93:0x01f3, B:99:0x01fc, B:101:0x0207, B:103:0x020d, B:104:0x0214, B:122:0x026f, B:106:0x0229, B:111:0x0240, B:136:0x0292, B:115:0x0247, B:116:0x0256, B:121:0x025c), top: B:256:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01b3 A[Catch: all -> 0x01ab, SQLiteException -> 0x01ae, TRY_ENTER, TryCatch #7 {all -> 0x01ab, blocks: (B:74:0x019a, B:76:0x01a0, B:83:0x01b3, B:84:0x01b9, B:85:0x01bd, B:86:0x01c8, B:88:0x01dd, B:90:0x01e3, B:91:0x01ed, B:93:0x01f3, B:99:0x01fc, B:101:0x0207, B:103:0x020d, B:104:0x0214, B:122:0x026f, B:106:0x0229, B:111:0x0240, B:136:0x0292, B:115:0x0247, B:116:0x0256, B:121:0x025c), top: B:256:0x019a }] */
    /* JADX WARN: Instruction removed from duplicated block: B:195:0x0436, please report this as an issue */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x055f: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:225:0x055f */
    public final void zzX() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursorRawQuery;
        String string;
        zzh zzhVarZzj;
        int iZze;
        int iMax;
        zzam zzamVar;
        boolean z11;
        boolean z12;
        Cursor cursor3;
        long j11;
        Cursor cursorQuery;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzga zzgaVarZza;
        int size;
        ArrayList arrayList;
        boolean z13;
        boolean zZzi;
        boolean zZzi2;
        boolean z14;
        int i11;
        String strZzm;
        String strZzi;
        String string2;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        Iterator it;
        String strZzJ;
        int i12;
        com.google.android.gms.internal.measurement.zzgd zzgdVar;
        com.google.android.gms.internal.measurement.zzgd zzgdVar2;
        ArrayList arrayList2;
        int length;
        long j12;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i13;
        byte[] byteArray;
        com.google.android.gms.internal.measurement.zzgc zzgcVar2;
        Cursor cursorRawQuery2;
        zzaz().zzg();
        zzB();
        int i14 = 1;
        this.zzv = true;
        int i15 = 0;
        try {
            this.zzn.zzaw();
            Boolean boolZzj = this.zzn.zzt().zzj();
            if (boolZzj == null) {
                zzay().zzk().zza("Upload data called on the client side before use of service was decided");
                this.zzv = false;
            } else if (boolZzj.booleanValue()) {
                zzay().zzd().zza("Upload called in the client side when service should be used");
                this.zzv = false;
            } else if (this.zza > 0) {
                zzag();
                this.zzv = false;
            } else {
                zzaz().zzg();
                if (this.zzy != null) {
                    zzay().zzj().zza("Uploading requested multiple times");
                    this.zzv = false;
                } else {
                    zzen zzenVar = this.zzd;
                    zzal(zzenVar);
                    if (zzenVar.zza()) {
                        long jCurrentTimeMillis = zzav().currentTimeMillis();
                        Cursor cursor4 = null;
                        int iZze2 = zzg().zze(null, zzdu.zzP);
                        zzg();
                        long jZzz = jCurrentTimeMillis - zzag.zzz();
                        for (int i16 = 0; i16 < iZze2 && zzah(null, jZzz); i16++) {
                        }
                        long jZza = this.zzk.zzc.zza();
                        if (jZza != 0) {
                            zzay().zzc().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
                        }
                        zzam zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        String strZzr = zzamVar2.zzr();
                        long j13 = -1;
                        if (TextUtils.isEmpty(strZzr)) {
                            try {
                                this.zzA = -1L;
                                zzam zzamVar3 = this.zze;
                                zzal(zzamVar3);
                                zzg();
                                long jZzz2 = jCurrentTimeMillis - zzag.zzz();
                                zzamVar3.zzg();
                                zzamVar3.zzW();
                                try {
                                    cursorRawQuery = zzamVar3.zzh().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzz2)});
                                    try {
                                        if (cursorRawQuery.moveToFirst()) {
                                            string = cursorRawQuery.getString(0);
                                            cursorRawQuery.close();
                                        } else {
                                            zzamVar3.zzt.zzay().zzj().zza("No expired configs for apps with pending events");
                                            cursorRawQuery.close();
                                            string = null;
                                        }
                                    } catch (SQLiteException e11) {
                                        e = e11;
                                        zzamVar3.zzt.zzay().zzd().zzb("Error selecting expired configs", e);
                                        if (cursorRawQuery != null) {
                                        }
                                        string = null;
                                        if (!TextUtils.isEmpty(string)) {
                                            zzam zzamVar4 = this.zze;
                                            zzal(zzamVar4);
                                            zzhVarZzj = zzamVar4.zzj(string);
                                            if (zzhVarZzj != null) {
                                                zzD(zzhVarZzj);
                                            }
                                        }
                                        this.zzv = false;
                                        zzae();
                                    }
                                } catch (SQLiteException e12) {
                                    e = e12;
                                    cursorRawQuery = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = null;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    zzam zzamVar5 = this.zze;
                                    zzal(zzamVar5);
                                    zzhVarZzj = zzamVar5.zzj(string);
                                    if (zzhVarZzj != null) {
                                        zzD(zzhVarZzj);
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = cursor;
                            }
                        } else {
                            if (this.zzA == -1) {
                                zzam zzamVar6 = this.zze;
                                zzal(zzamVar6);
                                try {
                                    cursorRawQuery2 = zzamVar6.zzh().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    try {
                                        try {
                                            if (cursorRawQuery2.moveToFirst()) {
                                                j13 = cursorRawQuery2.getLong(0);
                                            }
                                        } catch (SQLiteException e13) {
                                            e = e13;
                                            zzamVar6.zzt.zzay().zzd().zzb("Error querying raw events", e);
                                            if (cursorRawQuery2 != null) {
                                            }
                                            this.zzA = j13;
                                            iZze = zzg().zze(strZzr, zzdu.zzf);
                                            iMax = Math.max(0, zzg().zze(strZzr, zzdu.zzg));
                                            zzamVar = this.zze;
                                            zzal(zzamVar);
                                            zzamVar.zzg();
                                            zzamVar.zzW();
                                            if (iZze > 0) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            Preconditions.checkArgument(z11);
                                            if (iMax > 0) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                            Preconditions.checkArgument(z12);
                                            Preconditions.checkNotEmpty(strZzr);
                                            cursorQuery = zzamVar.zzh().query("queue", new String[]{"rowid", "data", PushConstants.SP_KEY_RETRY_COUNT}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze));
                                            try {
                                                try {
                                                    if (cursorQuery.moveToFirst()) {
                                                        arrayList2 = new ArrayList();
                                                        length = 0;
                                                        while (true) {
                                                            j12 = cursorQuery.getLong(i15);
                                                            try {
                                                                byte[] blob = cursorQuery.getBlob(i14);
                                                                zzkv zzkvVar = zzamVar.zzf.zzi;
                                                                zzal(zzkvVar);
                                                                try {
                                                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                                                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                                                    bArr = new byte[1024];
                                                                    j11 = jCurrentTimeMillis;
                                                                    while (true) {
                                                                        try {
                                                                            try {
                                                                                i13 = gZIPInputStream.read(bArr);
                                                                                if (i13 <= 0) {
                                                                                    break;
                                                                                } else {
                                                                                    byteArrayOutputStream.write(bArr, 0, i13);
                                                                                }
                                                                            } catch (SQLiteException e14) {
                                                                                e = e14;
                                                                                zzamVar.zzt.zzay().zzd().zzc("Error querying bundles. appId", zzeh.zzn(strZzr), e);
                                                                                listEmptyList = Collections.emptyList();
                                                                                if (cursorQuery != null) {
                                                                                    cursorQuery.close();
                                                                                }
                                                                            }
                                                                        } catch (IOException e15) {
                                                                            e = e15;
                                                                            try {
                                                                                zzkvVar.zzt.zzay().zzd().zzb("Failed to ungzip content", e);
                                                                                throw e;
                                                                            } catch (IOException e16) {
                                                                                e = e16;
                                                                                zzamVar.zzt.zzay().zzd().zzc("Failed to unzip queued bundle. appId", zzeh.zzn(strZzr), e);
                                                                                if (cursorQuery.moveToNext()) {
                                                                                    break;
                                                                                } else {
                                                                                    break;
                                                                                }
                                                                                cursorQuery.close();
                                                                                listEmptyList = arrayList2;
                                                                                if (!listEmptyList.isEmpty()) {
                                                                                    if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                                                                        it = listEmptyList.iterator();
                                                                                        while (true) {
                                                                                            if (!it.hasNext()) {
                                                                                                strZzJ = null;
                                                                                                break;
                                                                                            }
                                                                                            zzgdVar2 = (com.google.android.gms.internal.measurement.zzgd) ((Pair) it.next()).first;
                                                                                            if (!zzgdVar2.zzJ().isEmpty()) {
                                                                                                strZzJ = zzgdVar2.zzJ();
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        if (strZzJ != null) {
                                                                                            for (i12 = 0; i12 < listEmptyList.size(); i12++) {
                                                                                                zzgdVar = (com.google.android.gms.internal.measurement.zzgd) ((Pair) listEmptyList.get(i12)).first;
                                                                                                if (zzgdVar.zzJ().isEmpty()) {
                                                                                                    listEmptyList = listEmptyList.subList(0, i12);
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    zzgaVarZza = com.google.android.gms.internal.measurement.zzgb.zza();
                                                                                    size = listEmptyList.size();
                                                                                    arrayList = new ArrayList(listEmptyList.size());
                                                                                    if (zzg().zzt(strZzr)) {
                                                                                        z13 = false;
                                                                                    } else {
                                                                                        z13 = false;
                                                                                    }
                                                                                    zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                                                                    zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                                                    zzpd.zzc();
                                                                                    if (zzg().zzs(null, zzdu.zzal)) {
                                                                                        z14 = false;
                                                                                    } else {
                                                                                        z14 = false;
                                                                                    }
                                                                                    i11 = 0;
                                                                                    while (i11 < size) {
                                                                                        zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((com.google.android.gms.internal.measurement.zzgd) ((Pair) listEmptyList.get(i11)).first).zzby();
                                                                                        arrayList.add((Long) ((Pair) listEmptyList.get(i11)).second);
                                                                                        zzg().zzh();
                                                                                        zzgcVar.zzal(74029L);
                                                                                        long j14 = j11;
                                                                                        zzgcVar.zzak(j14);
                                                                                        this.zzn.zzaw();
                                                                                        zzgcVar.zzag(false);
                                                                                        if (!z13) {
                                                                                            zzgcVar.zzq();
                                                                                        }
                                                                                        if (!zZzi) {
                                                                                            zzgcVar.zzx();
                                                                                            zzgcVar.zzt();
                                                                                        }
                                                                                        if (!zZzi2) {
                                                                                            zzgcVar.zzn();
                                                                                        }
                                                                                        zzC(strZzr, zzgcVar);
                                                                                        if (!z14) {
                                                                                            zzgcVar.zzy();
                                                                                        }
                                                                                        if (zzg().zzs(strZzr, zzdu.zzT)) {
                                                                                            byte[] bArrZzbu = ((com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC()).zzbu();
                                                                                            zzkv zzkvVar2 = this.zzi;
                                                                                            zzal(zzkvVar2);
                                                                                            zzgcVar.zzJ(zzkvVar2.zzd(bArrZzbu));
                                                                                        }
                                                                                        zzgaVarZza.zza(zzgcVar);
                                                                                        i11++;
                                                                                        j11 = j14;
                                                                                    }
                                                                                    long j15 = j11;
                                                                                    if (Log.isLoggable(zzay().zzq(), 2)) {
                                                                                        zzkv zzkvVar3 = this.zzi;
                                                                                        zzal(zzkvVar3);
                                                                                        strZzm = zzkvVar3.zzm((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaC());
                                                                                    } else {
                                                                                        strZzm = null;
                                                                                    }
                                                                                    zzal(this.zzi);
                                                                                    byte[] bArrZzbu2 = ((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaC()).zzbu();
                                                                                    zzfi zzfiVar = this.zzl.zzf.zzc;
                                                                                    zzal(zzfiVar);
                                                                                    strZzi = zzfiVar.zzi(strZzr);
                                                                                    if (TextUtils.isEmpty(strZzi)) {
                                                                                        string2 = (String) zzdu.zzp.zza(null);
                                                                                    } else {
                                                                                        Uri uri = Uri.parse((String) zzdu.zzp.zza(null));
                                                                                        Uri.Builder builderBuildUpon = uri.buildUpon();
                                                                                        builderBuildUpon.authority(strZzi + InstructionFileId.DOT + uri.getAuthority());
                                                                                        string2 = builderBuildUpon.build().toString();
                                                                                    }
                                                                                    try {
                                                                                        URL url = new URL(string2);
                                                                                        Preconditions.checkArgument(!arrayList.isEmpty());
                                                                                        if (this.zzy != null) {
                                                                                            zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                                                        } else {
                                                                                            this.zzy = new ArrayList(arrayList);
                                                                                        }
                                                                                        this.zzk.zzd.zzb(j15);
                                                                                        zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzgaVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbu2.length), strZzm);
                                                                                        this.zzu = true;
                                                                                        zzen zzenVar2 = this.zzd;
                                                                                        zzal(zzenVar2);
                                                                                        zzkk zzkkVar = new zzkk(this, strZzr);
                                                                                        zzenVar2.zzg();
                                                                                        zzenVar2.zzW();
                                                                                        Preconditions.checkNotNull(url);
                                                                                        Preconditions.checkNotNull(bArrZzbu2);
                                                                                        Preconditions.checkNotNull(zzkkVar);
                                                                                        zzenVar2.zzt.zzaz().zzo(new zzem(zzenVar2, strZzr, url, bArrZzbu2, null, zzkkVar));
                                                                                    } catch (MalformedURLException unused) {
                                                                                        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", zzeh.zzn(strZzr), string2);
                                                                                    }
                                                                                }
                                                                                this.zzv = false;
                                                                                zzae();
                                                                            }
                                                                        }
                                                                    }
                                                                    gZIPInputStream.close();
                                                                    byteArrayInputStream.close();
                                                                    byteArray = byteArrayOutputStream.toByteArray();
                                                                    if (arrayList2.isEmpty()) {
                                                                    }
                                                                    try {
                                                                        zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) zzkv.zzl(com.google.android.gms.internal.measurement.zzgd.zzt(), byteArray);
                                                                        if (!cursorQuery.isNull(2)) {
                                                                            zzgcVar2.zzaf(cursorQuery.getInt(2));
                                                                        }
                                                                        length += byteArray.length;
                                                                        arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzgd) zzgcVar2.zzaC(), Long.valueOf(j12)));
                                                                    } catch (IOException e17) {
                                                                        zzamVar.zzt.zzay().zzd().zzc("Failed to merge queued bundle. appId", zzeh.zzn(strZzr), e17);
                                                                    }
                                                                    if (cursorQuery.moveToNext()) {
                                                                        break;
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    jCurrentTimeMillis = j11;
                                                                    i14 = 1;
                                                                    i15 = 0;
                                                                } catch (IOException e18) {
                                                                    e = e18;
                                                                    j11 = jCurrentTimeMillis;
                                                                }
                                                            } catch (IOException e19) {
                                                                e = e19;
                                                                j11 = jCurrentTimeMillis;
                                                            }
                                                        }
                                                        cursorQuery.close();
                                                        listEmptyList = arrayList2;
                                                    } else {
                                                        listEmptyList = Collections.emptyList();
                                                        cursorQuery.close();
                                                        j11 = jCurrentTimeMillis;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    cursor3 = cursorQuery;
                                                    if (cursor3 != null) {
                                                        cursor3.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (SQLiteException e21) {
                                                e = e21;
                                                j11 = jCurrentTimeMillis;
                                            }
                                            if (!listEmptyList.isEmpty()) {
                                                if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                                    it = listEmptyList.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            strZzJ = null;
                                                            break;
                                                        }
                                                        zzgdVar2 = (com.google.android.gms.internal.measurement.zzgd) ((Pair) it.next()).first;
                                                        if (!zzgdVar2.zzJ().isEmpty()) {
                                                            strZzJ = zzgdVar2.zzJ();
                                                            break;
                                                        }
                                                    }
                                                    if (strZzJ != null) {
                                                        while (i12 < listEmptyList.size()) {
                                                            zzgdVar = (com.google.android.gms.internal.measurement.zzgd) ((Pair) listEmptyList.get(i12)).first;
                                                            if (zzgdVar.zzJ().isEmpty()) {
                                                                listEmptyList = listEmptyList.subList(0, i12);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                zzgaVarZza = com.google.android.gms.internal.measurement.zzgb.zza();
                                                size = listEmptyList.size();
                                                arrayList = new ArrayList(listEmptyList.size());
                                                if (zzg().zzt(strZzr)) {
                                                    z13 = false;
                                                } else {
                                                    z13 = false;
                                                }
                                                zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                                zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                zzpd.zzc();
                                                if (zzg().zzs(null, zzdu.zzal)) {
                                                    z14 = false;
                                                } else {
                                                    z14 = false;
                                                }
                                                i11 = 0;
                                                while (i11 < size) {
                                                    zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((com.google.android.gms.internal.measurement.zzgd) ((Pair) listEmptyList.get(i11)).first).zzby();
                                                    arrayList.add((Long) ((Pair) listEmptyList.get(i11)).second);
                                                    zzg().zzh();
                                                    zzgcVar.zzal(74029L);
                                                    long j16 = j11;
                                                    zzgcVar.zzak(j16);
                                                    this.zzn.zzaw();
                                                    zzgcVar.zzag(false);
                                                    if (!z13) {
                                                        zzgcVar.zzq();
                                                    }
                                                    if (!zZzi) {
                                                        zzgcVar.zzx();
                                                        zzgcVar.zzt();
                                                    }
                                                    if (!zZzi2) {
                                                        zzgcVar.zzn();
                                                    }
                                                    zzC(strZzr, zzgcVar);
                                                    if (!z14) {
                                                        zzgcVar.zzy();
                                                    }
                                                    if (zzg().zzs(strZzr, zzdu.zzT)) {
                                                        byte[] bArrZzbu3 = ((com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC()).zzbu();
                                                        zzkv zzkvVar4 = this.zzi;
                                                        zzal(zzkvVar4);
                                                        zzgcVar.zzJ(zzkvVar4.zzd(bArrZzbu3));
                                                    }
                                                    zzgaVarZza.zza(zzgcVar);
                                                    i11++;
                                                    j11 = j16;
                                                }
                                                long j17 = j11;
                                                if (Log.isLoggable(zzay().zzq(), 2)) {
                                                    zzkv zzkvVar5 = this.zzi;
                                                    zzal(zzkvVar5);
                                                    strZzm = zzkvVar5.zzm((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaC());
                                                } else {
                                                    strZzm = null;
                                                }
                                                zzal(this.zzi);
                                                byte[] bArrZzbu4 = ((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaC()).zzbu();
                                                zzfi zzfiVar2 = this.zzl.zzf.zzc;
                                                zzal(zzfiVar2);
                                                strZzi = zzfiVar2.zzi(strZzr);
                                                if (TextUtils.isEmpty(strZzi)) {
                                                    Uri uri2 = Uri.parse((String) zzdu.zzp.zza(null));
                                                    Uri.Builder builderBuildUpon2 = uri2.buildUpon();
                                                    builderBuildUpon2.authority(strZzi + InstructionFileId.DOT + uri2.getAuthority());
                                                    string2 = builderBuildUpon2.build().toString();
                                                } else {
                                                    string2 = (String) zzdu.zzp.zza(null);
                                                }
                                                URL url2 = new URL(string2);
                                                Preconditions.checkArgument(!arrayList.isEmpty());
                                                if (this.zzy != null) {
                                                    zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                } else {
                                                    this.zzy = new ArrayList(arrayList);
                                                }
                                                this.zzk.zzd.zzb(j17);
                                                zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzgaVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbu4.length), strZzm);
                                                this.zzu = true;
                                                zzen zzenVar3 = this.zzd;
                                                zzal(zzenVar3);
                                                zzkk zzkkVar2 = new zzkk(this, strZzr);
                                                zzenVar3.zzg();
                                                zzenVar3.zzW();
                                                Preconditions.checkNotNull(url2);
                                                Preconditions.checkNotNull(bArrZzbu4);
                                                Preconditions.checkNotNull(zzkkVar2);
                                                zzenVar3.zzt.zzaz().zzo(new zzem(zzenVar3, strZzr, url2, bArrZzbu4, null, zzkkVar2));
                                            }
                                            this.zzv = false;
                                            zzae();
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        cursor4 = cursorRawQuery2;
                                        if (cursor4 != null) {
                                            cursor4.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e22) {
                                    e = e22;
                                    cursorRawQuery2 = null;
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (cursor4 != null) {
                                        cursor4.close();
                                    }
                                    throw th;
                                }
                                cursorRawQuery2.close();
                                this.zzA = j13;
                            }
                            iZze = zzg().zze(strZzr, zzdu.zzf);
                            iMax = Math.max(0, zzg().zze(strZzr, zzdu.zzg));
                            zzamVar = this.zze;
                            zzal(zzamVar);
                            zzamVar.zzg();
                            zzamVar.zzW();
                            if (iZze > 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            Preconditions.checkArgument(z11);
                            if (iMax > 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            Preconditions.checkArgument(z12);
                            Preconditions.checkNotEmpty(strZzr);
                            try {
                                cursorQuery = zzamVar.zzh().query("queue", new String[]{"rowid", "data", PushConstants.SP_KEY_RETRY_COUNT}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze));
                                if (cursorQuery.moveToFirst()) {
                                    listEmptyList = Collections.emptyList();
                                    cursorQuery.close();
                                    j11 = jCurrentTimeMillis;
                                } else {
                                    arrayList2 = new ArrayList();
                                    length = 0;
                                    while (true) {
                                        j12 = cursorQuery.getLong(i15);
                                        byte[] blob2 = cursorQuery.getBlob(i14);
                                        zzkv zzkvVar6 = zzamVar.zzf.zzi;
                                        zzal(zzkvVar6);
                                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(blob2);
                                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        bArr = new byte[1024];
                                        j11 = jCurrentTimeMillis;
                                        while (true) {
                                            i13 = gZIPInputStream.read(bArr);
                                            if (i13 <= 0) {
                                                break;
                                                break;
                                            }
                                            byteArrayOutputStream.write(bArr, 0, i13);
                                        }
                                        gZIPInputStream.close();
                                        byteArrayInputStream2.close();
                                        byteArray = byteArrayOutputStream.toByteArray();
                                        if (arrayList2.isEmpty() && byteArray.length + length > iMax) {
                                            break;
                                        }
                                        zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) zzkv.zzl(com.google.android.gms.internal.measurement.zzgd.zzt(), byteArray);
                                        if (!cursorQuery.isNull(2)) {
                                            zzgcVar2.zzaf(cursorQuery.getInt(2));
                                        }
                                        length += byteArray.length;
                                        arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzgd) zzgcVar2.zzaC(), Long.valueOf(j12)));
                                        if (cursorQuery.moveToNext() || length > iMax) {
                                            break;
                                            break;
                                        } else {
                                            jCurrentTimeMillis = j11;
                                            i14 = 1;
                                            i15 = 0;
                                        }
                                    }
                                    cursorQuery.close();
                                    listEmptyList = arrayList2;
                                }
                            } catch (SQLiteException e23) {
                                e = e23;
                                j11 = jCurrentTimeMillis;
                                cursorQuery = null;
                            } catch (Throwable th7) {
                                th = th7;
                                cursor3 = null;
                            }
                            if (!listEmptyList.isEmpty()) {
                                if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                    it = listEmptyList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            strZzJ = null;
                                            break;
                                        }
                                        zzgdVar2 = (com.google.android.gms.internal.measurement.zzgd) ((Pair) it.next()).first;
                                        if (!zzgdVar2.zzJ().isEmpty()) {
                                            strZzJ = zzgdVar2.zzJ();
                                            break;
                                        }
                                    }
                                    if (strZzJ != null) {
                                        while (i12 < listEmptyList.size()) {
                                            zzgdVar = (com.google.android.gms.internal.measurement.zzgd) ((Pair) listEmptyList.get(i12)).first;
                                            if (zzgdVar.zzJ().isEmpty() && !zzgdVar.zzJ().equals(strZzJ)) {
                                                listEmptyList = listEmptyList.subList(0, i12);
                                                break;
                                            }
                                        }
                                    }
                                }
                                zzgaVarZza = com.google.android.gms.internal.measurement.zzgb.zza();
                                size = listEmptyList.size();
                                arrayList = new ArrayList(listEmptyList.size());
                                if (zzg().zzt(strZzr) || !zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                    z13 = false;
                                } else {
                                    z13 = true;
                                }
                                zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                zzpd.zzc();
                                if (zzg().zzs(null, zzdu.zzal) || !zzg().zzs(strZzr, zzdu.zzan)) {
                                    z14 = false;
                                } else {
                                    z14 = true;
                                }
                                i11 = 0;
                                while (i11 < size) {
                                    zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((com.google.android.gms.internal.measurement.zzgd) ((Pair) listEmptyList.get(i11)).first).zzby();
                                    arrayList.add((Long) ((Pair) listEmptyList.get(i11)).second);
                                    zzg().zzh();
                                    zzgcVar.zzal(74029L);
                                    long j18 = j11;
                                    zzgcVar.zzak(j18);
                                    this.zzn.zzaw();
                                    zzgcVar.zzag(false);
                                    if (!z13) {
                                        zzgcVar.zzq();
                                    }
                                    if (!zZzi) {
                                        zzgcVar.zzx();
                                        zzgcVar.zzt();
                                    }
                                    if (!zZzi2) {
                                        zzgcVar.zzn();
                                    }
                                    zzC(strZzr, zzgcVar);
                                    if (!z14) {
                                        zzgcVar.zzy();
                                    }
                                    if (zzg().zzs(strZzr, zzdu.zzT)) {
                                        byte[] bArrZzbu5 = ((com.google.android.gms.internal.measurement.zzgd) zzgcVar.zzaC()).zzbu();
                                        zzkv zzkvVar7 = this.zzi;
                                        zzal(zzkvVar7);
                                        zzgcVar.zzJ(zzkvVar7.zzd(bArrZzbu5));
                                    }
                                    zzgaVarZza.zza(zzgcVar);
                                    i11++;
                                    j11 = j18;
                                }
                                long j19 = j11;
                                if (Log.isLoggable(zzay().zzq(), 2)) {
                                    zzkv zzkvVar8 = this.zzi;
                                    zzal(zzkvVar8);
                                    strZzm = zzkvVar8.zzm((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaC());
                                } else {
                                    strZzm = null;
                                }
                                zzal(this.zzi);
                                byte[] bArrZzbu6 = ((com.google.android.gms.internal.measurement.zzgb) zzgaVarZza.zzaC()).zzbu();
                                zzfi zzfiVar3 = this.zzl.zzf.zzc;
                                zzal(zzfiVar3);
                                strZzi = zzfiVar3.zzi(strZzr);
                                if (TextUtils.isEmpty(strZzi)) {
                                    Uri uri3 = Uri.parse((String) zzdu.zzp.zza(null));
                                    Uri.Builder builderBuildUpon3 = uri3.buildUpon();
                                    builderBuildUpon3.authority(strZzi + InstructionFileId.DOT + uri3.getAuthority());
                                    string2 = builderBuildUpon3.build().toString();
                                } else {
                                    string2 = (String) zzdu.zzp.zza(null);
                                }
                                URL url3 = new URL(string2);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzy != null) {
                                    zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzy = new ArrayList(arrayList);
                                }
                                this.zzk.zzd.zzb(j19);
                                zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzgaVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbu6.length), strZzm);
                                this.zzu = true;
                                zzen zzenVar4 = this.zzd;
                                zzal(zzenVar4);
                                zzkk zzkkVar3 = new zzkk(this, strZzr);
                                zzenVar4.zzg();
                                zzenVar4.zzW();
                                Preconditions.checkNotNull(url3);
                                Preconditions.checkNotNull(bArrZzbu6);
                                Preconditions.checkNotNull(zzkkVar3);
                                zzenVar4.zzt.zzaz().zzo(new zzem(zzenVar4, strZzr, url3, bArrZzbu6, null, zzkkVar3));
                            }
                        }
                        this.zzv = false;
                    } else {
                        zzay().zzj().zza("Network not connected, ignoring upload request");
                        zzag();
                        this.zzv = false;
                    }
                }
            }
            zzae();
        } catch (Throwable th8) {
            this.zzv = false;
            zzae();
            throw th8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x015d  */
    /* JADX WARN: Code duplicated, block: B:47:0x016f A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0186 A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01d3 A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01e3 A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01f1 A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0202 A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0208  */
    /* JADX WARN: Code duplicated, block: B:70:0x020e A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x02b0 A[Catch: all -> 0x014b, TryCatch #8 {all -> 0x014b, blocks: (B:28:0x0124, B:31:0x0135, B:33:0x013f, B:39:0x014f, B:86:0x02e0, B:95:0x0316, B:97:0x0353, B:99:0x0358, B:100:0x036f, B:104:0x0382, B:106:0x0399, B:108:0x03a0, B:109:0x03b7, B:114:0x03e1, B:118:0x0404, B:119:0x041b, B:123:0x042e, B:126:0x044b, B:127:0x045f, B:129:0x0469, B:131:0x0476, B:133:0x047c, B:134:0x0485, B:135:0x0493, B:137:0x04a8, B:139:0x04b8, B:150:0x04e2, B:151:0x04f7, B:153:0x051d, B:156:0x0535, B:159:0x0578, B:161:0x05a4, B:163:0x05e1, B:164:0x05e6, B:166:0x05ee, B:167:0x05f3, B:169:0x05fb, B:170:0x0600, B:172:0x0610, B:174:0x061e, B:176:0x0626, B:177:0x062b, B:179:0x0634, B:180:0x0638, B:182:0x0645, B:183:0x064a, B:185:0x0671, B:187:0x0679, B:188:0x067e, B:190:0x0686, B:191:0x0689, B:193:0x06a1, B:196:0x06aa, B:197:0x06c4, B:199:0x06ca, B:201:0x06de, B:203:0x06ea, B:205:0x06f7, B:209:0x0711, B:210:0x0721, B:214:0x072b, B:215:0x072e, B:217:0x074c, B:219:0x0750, B:221:0x0762, B:223:0x0766, B:225:0x0771, B:226:0x077a, B:228:0x07b9, B:230:0x07c3, B:231:0x07c6, B:233:0x07d3, B:235:0x07f3, B:236:0x0800, B:237:0x0836, B:239:0x083e, B:241:0x0848, B:242:0x0855, B:244:0x085f, B:245:0x086c, B:246:0x0878, B:248:0x087e, B:250:0x08ae, B:251:0x08f4, B:253:0x08fe, B:254:0x0901, B:255:0x090d, B:257:0x0913, B:266:0x0962, B:267:0x09b0, B:269:0x09bf, B:288:0x0a2e, B:274:0x09da, B:275:0x09dd, B:260:0x0920, B:262:0x094c, B:287:0x0a19, B:285:0x0a01, B:286:0x0a18, B:160:0x0596, B:147:0x04ca, B:89:0x02f6, B:90:0x02fd, B:92:0x0303, B:94:0x030f, B:44:0x0163, B:47:0x016f, B:49:0x0186, B:54:0x019f, B:61:0x01dd, B:63:0x01e3, B:65:0x01f1, B:67:0x0202, B:70:0x020e, B:83:0x02a5, B:85:0x02b0, B:72:0x0237, B:73:0x0251, B:75:0x025a, B:82:0x0288, B:81:0x0275, B:57:0x01ad, B:60:0x01d3), top: B:310:0x0124, inners: #3, #5 }] */
    public final void zzY(zzaw zzawVar, zzq zzqVar) {
        String strZzg;
        long jLongValue;
        String upperCase;
        String strConcat;
        zzky zzkyVarZzp;
        zzam zzamVar;
        zzky zzkyVar;
        Object obj;
        zzky zzkyVar2;
        zzam zzamVar2;
        Object obj2;
        double dDoubleValue;
        long length;
        String str;
        long jDelete;
        zzas zzasVarZzc;
        ArrayList arrayList;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        int i11;
        String str2 = "metadata_fingerprint";
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        long jNanoTime = System.nanoTime();
        zzaz().zzg();
        zzB();
        String str3 = zzqVar.zza;
        zzal(this.zzi);
        if (!zzkv.zzA(zzawVar, zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            zzd(zzqVar);
            return;
        }
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        String str4 = "_err";
        if (zzfiVar.zzr(str3, zzawVar.zza)) {
            zzay().zzk().zzc("Dropping blocked event. appId", zzeh.zzn(str3), this.zzn.zzj().zzd(zzawVar.zza));
            zzfi zzfiVar2 = this.zzc;
            zzal(zzfiVar2);
            if (!zzfiVar2.zzp(str3)) {
                zzfi zzfiVar3 = this.zzc;
                zzal(zzfiVar3);
                if (!zzfiVar3.zzs(str3)) {
                    if ("_err".equals(zzawVar.zza)) {
                        return;
                    }
                    zzv().zzN(this.zzF, str3, 11, "_ev", zzawVar.zza, 0);
                    return;
                }
            }
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzh zzhVarZzj = zzamVar3.zzj(str3);
            if (zzhVarZzj != null) {
                long jAbs = Math.abs(zzav().currentTimeMillis() - Math.max(zzhVarZzj.zzl(), zzhVarZzj.zzc()));
                zzg();
                if (jAbs > ((Long) zzdu.zzy.zza(null)).longValue()) {
                    zzay().zzc().zza("Fetching config for blocked app");
                    zzD(zzhVarZzj);
                    return;
                }
                return;
            }
            return;
        }
        zzei zzeiVarZzb = zzei.zzb(zzawVar);
        zzv().zzM(zzeiVarZzb, zzg().zzd(str3));
        zzaw zzawVarZza = zzeiVarZzb.zza();
        if (Log.isLoggable(zzay().zzq(), 2)) {
            zzay().zzj().zzb("Logging event", this.zzn.zzj().zzc(zzawVarZza));
        }
        zzam zzamVar4 = this.zze;
        zzal(zzamVar4);
        zzamVar4.zzw();
        try {
            zzd(zzqVar);
            boolean z11 = "ecommerce_purchase".equals(zzawVarZza.zza) || "purchase".equals(zzawVarZza.zza) || "refund".equals(zzawVarZza.zza);
            if ("_iap".equals(zzawVarZza.zza)) {
                strZzg = zzawVarZza.zzb.zzg(AppLovinEventParameters.REVENUE_CURRENCY);
                if (z11) {
                    dDoubleValue = zzawVarZza.zzb.zzd(AppMeasurementSdk.ConditionalUserProperty.VALUE).doubleValue() * 1000000.0d;
                    if (dDoubleValue == 0.0d) {
                        dDoubleValue = zzawVarZza.zzb.zze(AppMeasurementSdk.ConditionalUserProperty.VALUE).longValue() * 1000000.0d;
                    }
                    if (dDoubleValue <= 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                        zzay().zzk().zzc("Data lost. Currency value is too big. appId", zzeh.zzn(str3), Double.valueOf(dDoubleValue));
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzC();
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zzx();
                        return;
                    }
                    jLongValue = Math.round(dDoubleValue);
                    if ("refund".equals(zzawVarZza.zza)) {
                        jLongValue = -jLongValue;
                    }
                } else {
                    jLongValue = zzawVarZza.zzb.zze(AppMeasurementSdk.ConditionalUserProperty.VALUE).longValue();
                }
                if (TextUtils.isEmpty(strZzg)) {
                    str2 = "metadata_fingerprint";
                    str4 = "_err";
                    obj = null;
                } else {
                    upperCase = strZzg.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        strConcat = "_ltv_".concat(upperCase);
                        zzam zzamVar7 = this.zze;
                        zzal(zzamVar7);
                        zzkyVarZzp = zzamVar7.zzp(str3, strConcat);
                        if (zzkyVarZzp != null) {
                            obj2 = zzkyVarZzp.zze;
                            if (obj2 instanceof Long) {
                                zzkyVar = new zzky(str3, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(((Long) obj2).longValue() + jLongValue));
                                obj = null;
                            } else {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                int iZze = zzg().zze(str3, zzdu.zzD) - 1;
                                Preconditions.checkNotEmpty(str3);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                try {
                                    SQLiteDatabase sQLiteDatabaseZzh = zzamVar.zzh();
                                    String[] strArr = new String[3];
                                    try {
                                        strArr[0] = str3;
                                        strArr[1] = str3;
                                        strArr[2] = String.valueOf(iZze);
                                        sQLiteDatabaseZzh.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr);
                                    } catch (SQLiteException e11) {
                                        e = e11;
                                        zzamVar.zzt.zzay().zzd().zzc("Error pruning currencies. appId", zzeh.zzn(str3), e);
                                    }
                                } catch (SQLiteException e12) {
                                    e = e12;
                                }
                                obj = null;
                                zzkyVar = new zzky(str3, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                            }
                        } else {
                            zzamVar = this.zze;
                            zzal(zzamVar);
                            int iZze2 = zzg().zze(str3, zzdu.zzD) - 1;
                            Preconditions.checkNotEmpty(str3);
                            zzamVar.zzg();
                            zzamVar.zzW();
                            SQLiteDatabase sQLiteDatabaseZzh2 = zzamVar.zzh();
                            String[] strArr2 = new String[3];
                            strArr2[0] = str3;
                            strArr2[1] = str3;
                            strArr2[2] = String.valueOf(iZze2);
                            sQLiteDatabaseZzh2.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr2);
                            obj = null;
                            zzkyVar = new zzky(str3, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                        }
                        zzkyVar2 = zzkyVar;
                        zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        if (!zzamVar2.zzL(zzkyVar2)) {
                            zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeh.zzn(str3), this.zzn.zzj().zzf(zzkyVar2.zzc), zzkyVar2.zze);
                            zzv().zzN(this.zzF, str3, 9, null, null, 0);
                        }
                    } else {
                        str2 = "metadata_fingerprint";
                        str4 = "_err";
                        obj = null;
                    }
                }
            } else if (z11) {
                z11 = true;
                strZzg = zzawVarZza.zzb.zzg(AppLovinEventParameters.REVENUE_CURRENCY);
                if (z11) {
                    dDoubleValue = zzawVarZza.zzb.zzd(AppMeasurementSdk.ConditionalUserProperty.VALUE).doubleValue() * 1000000.0d;
                    if (dDoubleValue == 0.0d) {
                        dDoubleValue = zzawVarZza.zzb.zze(AppMeasurementSdk.ConditionalUserProperty.VALUE).longValue() * 1000000.0d;
                    }
                    if (dDoubleValue <= 9.223372036854776E18d) {
                    }
                    zzay().zzk().zzc("Data lost. Currency value is too big. appId", zzeh.zzn(str3), Double.valueOf(dDoubleValue));
                    zzam zzamVar8 = this.zze;
                    zzal(zzamVar8);
                    zzamVar8.zzC();
                    zzam zzamVar9 = this.zze;
                    zzal(zzamVar9);
                    zzamVar9.zzx();
                    return;
                }
                jLongValue = zzawVarZza.zzb.zze(AppMeasurementSdk.ConditionalUserProperty.VALUE).longValue();
                if (TextUtils.isEmpty(strZzg)) {
                    upperCase = strZzg.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        strConcat = "_ltv_".concat(upperCase);
                        zzam zzamVar10 = this.zze;
                        zzal(zzamVar10);
                        zzkyVarZzp = zzamVar10.zzp(str3, strConcat);
                        if (zzkyVarZzp != null) {
                            obj2 = zzkyVarZzp.zze;
                            if (obj2 instanceof Long) {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                int iZze3 = zzg().zze(str3, zzdu.zzD) - 1;
                                Preconditions.checkNotEmpty(str3);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                SQLiteDatabase sQLiteDatabaseZzh3 = zzamVar.zzh();
                                String[] strArr3 = new String[3];
                                strArr3[0] = str3;
                                strArr3[1] = str3;
                                strArr3[2] = String.valueOf(iZze3);
                                sQLiteDatabaseZzh3.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr3);
                                obj = null;
                                zzkyVar = new zzky(str3, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                            } else {
                                zzkyVar = new zzky(str3, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(((Long) obj2).longValue() + jLongValue));
                                obj = null;
                            }
                        } else {
                            zzamVar = this.zze;
                            zzal(zzamVar);
                            int iZze4 = zzg().zze(str3, zzdu.zzD) - 1;
                            Preconditions.checkNotEmpty(str3);
                            zzamVar.zzg();
                            zzamVar.zzW();
                            SQLiteDatabase sQLiteDatabaseZzh4 = zzamVar.zzh();
                            String[] strArr4 = new String[3];
                            strArr4[0] = str3;
                            strArr4[1] = str3;
                            strArr4[2] = String.valueOf(iZze4);
                            sQLiteDatabaseZzh4.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr4);
                            obj = null;
                            zzkyVar = new zzky(str3, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                        }
                        zzkyVar2 = zzkyVar;
                        zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        if (!zzamVar2.zzL(zzkyVar2)) {
                            zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeh.zzn(str3), this.zzn.zzj().zzf(zzkyVar2.zzc), zzkyVar2.zze);
                            zzv().zzN(this.zzF, str3, 9, null, null, 0);
                        }
                    } else {
                        str2 = "metadata_fingerprint";
                        str4 = "_err";
                        obj = null;
                    }
                } else {
                    str2 = "metadata_fingerprint";
                    str4 = "_err";
                    obj = null;
                }
            } else {
                str2 = "metadata_fingerprint";
                str4 = "_err";
                obj = null;
            }
            boolean zZzai = zzlb.zzai(zzawVarZza.zza);
            boolean zEquals = str4.equals(zzawVarZza.zza);
            zzv();
            zzau zzauVar = zzawVarZza.zzb;
            if (zzauVar == null) {
                length = 0;
            } else {
                zzat zzatVar = new zzat(zzauVar);
                length = 0;
                while (zzatVar.hasNext()) {
                    Object objZzf = zzauVar.zzf(zzatVar.next());
                    if (objZzf instanceof Parcelable[]) {
                        length += (long) ((Parcelable[]) objZzf).length;
                    }
                }
            }
            zzam zzamVar11 = this.zze;
            zzal(zzamVar11);
            zzak zzakVarZzm = zzamVar11.zzm(zza(), str3, length + 1, true, zZzai, false, zEquals, false);
            long j11 = zzakVarZzm.zzb;
            zzg();
            long jIntValue = j11 - ((long) ((Integer) zzdu.zzj.zza(obj)).intValue());
            if (jIntValue > 0) {
                if (jIntValue % 1000 == 1) {
                    zzay().zzd().zzc("Data loss. Too many events logged. appId, count", zzeh.zzn(str3), Long.valueOf(zzakVarZzm.zzb));
                }
                zzam zzamVar12 = this.zze;
                zzal(zzamVar12);
                zzamVar12.zzC();
                zzam zzamVar13 = this.zze;
                zzal(zzamVar13);
                zzamVar13.zzx();
                return;
            }
            if (zZzai) {
                long j12 = zzakVarZzm.zza;
                zzg();
                long jIntValue2 = j12 - ((long) ((Integer) zzdu.zzl.zza(obj)).intValue());
                if (jIntValue2 > 0) {
                    if (jIntValue2 % 1000 == 1) {
                        zzay().zzd().zzc("Data loss. Too many public events logged. appId, count", zzeh.zzn(str3), Long.valueOf(zzakVarZzm.zza));
                    }
                    zzv().zzN(this.zzF, str3, 16, "_ev", zzawVarZza.zza, 0);
                    zzam zzamVar14 = this.zze;
                    zzal(zzamVar14);
                    zzamVar14.zzC();
                    zzam zzamVar15 = this.zze;
                    zzal(zzamVar15);
                    zzamVar15.zzx();
                    return;
                }
            }
            if (zEquals) {
                long jMax = zzakVarZzm.zzd - ((long) Math.max(0, Math.min(1000000, zzg().zze(zzqVar.zza, zzdu.zzk))));
                if (jMax > 0) {
                    if (jMax == 1) {
                        zzay().zzd().zzc("Too many error events logged. appId, count", zzeh.zzn(str3), Long.valueOf(zzakVarZzm.zzd));
                    }
                    zzam zzamVar16 = this.zze;
                    zzal(zzamVar16);
                    zzamVar16.zzC();
                    zzam zzamVar17 = this.zze;
                    zzal(zzamVar17);
                    zzamVar17.zzx();
                    return;
                }
            }
            Bundle bundleZzc = zzawVarZza.zzb.zzc();
            zzv().zzO(bundleZzc, "_o", zzawVarZza.zzc);
            if (zzv().zzae(str3)) {
                zzv().zzO(bundleZzc, "_dbg", 1L);
                zzv().zzO(bundleZzc, "_r", 1L);
            }
            if ("_s".equals(zzawVarZza.zza)) {
                zzam zzamVar18 = this.zze;
                zzal(zzamVar18);
                zzky zzkyVarZzp2 = zzamVar18.zzp(zzqVar.zza, "_sno");
                if (zzkyVarZzp2 != null && (zzkyVarZzp2.zze instanceof Long)) {
                    zzv().zzO(bundleZzc, "_sno", zzkyVarZzp2.zze);
                }
            }
            zzam zzamVar19 = this.zze;
            zzal(zzamVar19);
            Preconditions.checkNotEmpty(str3);
            zzamVar19.zzg();
            zzamVar19.zzW();
            try {
                try {
                    str = "raw_events";
                    try {
                        jDelete = zzamVar19.zzh().delete(str, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str3, String.valueOf(Math.max(0, Math.min(1000000, zzamVar19.zzt.zzf().zze(str3, zzdu.zzo))))});
                    } catch (SQLiteException e13) {
                        e = e13;
                        zzamVar19.zzt.zzay().zzd().zzc("Error deleting over the limit events. appId", zzeh.zzn(str3), e);
                        jDelete = 0;
                    }
                } catch (SQLiteException e14) {
                    e = e14;
                    str = "raw_events";
                }
            } catch (SQLiteException e15) {
                e = e15;
                str = "raw_events";
            }
            if (jDelete > 0) {
                zzay().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzeh.zzn(str3), Long.valueOf(jDelete));
            }
            zzfr zzfrVar = this.zzn;
            String str5 = zzawVarZza.zzc;
            String str6 = zzawVarZza.zza;
            long j13 = zzawVarZza.zzd;
            String str7 = str;
            zzar zzarVar = new zzar(zzfrVar, str5, str3, str6, j13, 0L, bundleZzc);
            zzam zzamVar20 = this.zze;
            zzal(zzamVar20);
            zzas zzasVarZzn = zzamVar20.zzn(str3, zzarVar.zzb);
            if (zzasVarZzn == null) {
                zzam zzamVar21 = this.zze;
                zzal(zzamVar21);
                if (zzamVar21.zzf(str3) >= zzg().zzb(str3) && zZzai) {
                    zzay().zzd().zzd("Too many event names used, ignoring event. appId, name, supported count", zzeh.zzn(str3), this.zzn.zzj().zzd(zzarVar.zzb), Integer.valueOf(zzg().zzb(str3)));
                    zzv().zzN(this.zzF, str3, 8, null, null, 0);
                    zzam zzamVar22 = this.zze;
                    zzal(zzamVar22);
                    zzamVar22.zzx();
                    return;
                }
                zzasVarZzc = new zzas(str3, zzarVar.zzb, 0L, 0L, 0L, zzarVar.zzd, 0L, null, null, null, null);
            } else {
                zzarVar = zzarVar.zza(this.zzn, zzasVarZzn.zzf);
                zzasVarZzc = zzasVarZzn.zzc(zzarVar.zzd);
            }
            zzam zzamVar23 = this.zze;
            zzal(zzamVar23);
            zzamVar23.zzE(zzasVarZzc);
            zzaz().zzg();
            zzB();
            Preconditions.checkNotNull(zzarVar);
            Preconditions.checkNotNull(zzqVar);
            Preconditions.checkNotEmpty(zzarVar.zza);
            Preconditions.checkArgument(zzarVar.zza.equals(zzqVar.zza));
            com.google.android.gms.internal.measurement.zzgc zzgcVarZzt = com.google.android.gms.internal.measurement.zzgd.zzt();
            zzgcVarZzt.zzad(1);
            zzgcVarZzt.zzZ("android");
            if (!TextUtils.isEmpty(zzqVar.zza)) {
                zzgcVarZzt.zzD(zzqVar.zza);
            }
            if (!TextUtils.isEmpty(zzqVar.zzd)) {
                zzgcVarZzt.zzF(zzqVar.zzd);
            }
            if (!TextUtils.isEmpty(zzqVar.zzc)) {
                zzgcVarZzt.zzG(zzqVar.zzc);
            }
            zzpd.zzc();
            if (zzg().zzs(null, zzdu.zzal) && zzg().zzs(zzqVar.zza, zzdu.zzan) && !TextUtils.isEmpty(zzqVar.zzx)) {
                zzgcVarZzt.zzah(zzqVar.zzx);
            }
            long j14 = zzqVar.zzj;
            if (j14 != -2147483648L) {
                zzgcVarZzt.zzH((int) j14);
            }
            zzgcVarZzt.zzV(zzqVar.zze);
            if (!TextUtils.isEmpty(zzqVar.zzb)) {
                zzgcVarZzt.zzU(zzqVar.zzb);
            }
            zzgcVarZzt.zzL(zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv)).zzh());
            if (zzgcVarZzt.zzaq().isEmpty() && !TextUtils.isEmpty(zzqVar.zzq)) {
                zzgcVarZzt.zzC(zzqVar.zzq);
            }
            long j15 = zzqVar.zzf;
            if (j15 != 0) {
                zzgcVarZzt.zzM(j15);
            }
            zzgcVarZzt.zzP(zzqVar.zzs);
            zzkv zzkvVar = this.zzi;
            zzal(zzkvVar);
            Map mapZzc = zzdu.zzc(zzkvVar.zzf.zzn.zzau());
            if (mapZzc != null && !mapZzc.isEmpty()) {
                arrayList = new ArrayList();
                int iIntValue = ((Integer) zzdu.zzO.zza(null)).intValue();
                for (Map.Entry entry : mapZzc.entrySet()) {
                    if (((String) entry.getKey()).startsWith("measurement.id.")) {
                        try {
                            int i12 = Integer.parseInt((String) entry.getValue());
                            if (i12 != 0) {
                                arrayList.add(Integer.valueOf(i12));
                                if (arrayList.size() >= iIntValue) {
                                    zzkvVar.zzt.zzay().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                    break;
                                }
                                continue;
                            } else {
                                continue;
                            }
                        } catch (NumberFormatException e16) {
                            zzkvVar.zzt.zzay().zzk().zzb("Experiment ID NumberFormatException", e16);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                zzam zzamVar24 = this.zze;
                zzal(zzamVar24);
                zzamVar24.zzx();
                throw th;
            }
            arrayList = null;
            if (arrayList != null) {
                zzgcVarZzt.zzh(arrayList);
            }
            zzai zzaiVarZzc = zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv));
            zzah zzahVar = zzah.AD_STORAGE;
            if (zzaiVarZzc.zzi(zzahVar) && zzqVar.zzo) {
                Pair pairZzd = this.zzk.zzd(zzqVar.zza, zzaiVarZzc);
                if (!TextUtils.isEmpty((CharSequence) pairZzd.first) && zzqVar.zzo) {
                    zzgcVarZzt.zzae((String) pairZzd.first);
                    Object obj3 = pairZzd.second;
                    if (obj3 != null) {
                        zzgcVarZzt.zzX(((Boolean) obj3).booleanValue());
                    }
                }
            }
            this.zzn.zzg().zzu();
            zzgcVarZzt.zzN(Build.MODEL);
            this.zzn.zzg().zzu();
            zzgcVarZzt.zzY(Build.VERSION.RELEASE);
            zzgcVarZzt.zzaj((int) this.zzn.zzg().zzb());
            zzgcVarZzt.zzan(this.zzn.zzg().zzc());
            if (this.zzn.zzJ()) {
                zzgcVarZzt.zzap();
                if (!TextUtils.isEmpty(null)) {
                    zzgcVarZzt.zzO(null);
                }
            }
            zzam zzamVar25 = this.zze;
            zzal(zzamVar25);
            zzh zzhVarZzj2 = zzamVar25.zzj(zzqVar.zza);
            if (zzhVarZzj2 == null) {
                zzhVarZzj2 = new zzh(this.zzn, zzqVar.zza);
                zzhVarZzj2.zzH(zzw(zzaiVarZzc));
                zzhVarZzj2.zzV(zzqVar.zzk);
                zzhVarZzj2.zzW(zzqVar.zzb);
                if (zzaiVarZzc.zzi(zzahVar)) {
                    zzhVarZzj2.zzae(this.zzk.zzf(zzqVar.zza, zzqVar.zzo));
                }
                zzhVarZzj2.zzaa(0L);
                zzhVarZzj2.zzab(0L);
                zzhVarZzj2.zzZ(0L);
                zzhVarZzj2.zzJ(zzqVar.zzc);
                zzhVarZzj2.zzK(zzqVar.zzj);
                zzhVarZzj2.zzI(zzqVar.zzd);
                zzhVarZzj2.zzX(zzqVar.zze);
                zzhVarZzj2.zzS(zzqVar.zzf);
                zzhVarZzj2.zzac(zzqVar.zzh);
                zzhVarZzj2.zzT(zzqVar.zzs);
                zzam zzamVar26 = this.zze;
                zzal(zzamVar26);
                zzamVar26.zzD(zzhVarZzj2);
            }
            if (zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzj2.zzu())) {
                zzgcVarZzt.zzE((String) Preconditions.checkNotNull(zzhVarZzj2.zzu()));
            }
            if (!TextUtils.isEmpty(zzhVarZzj2.zzx())) {
                zzgcVarZzt.zzT((String) Preconditions.checkNotNull(zzhVarZzj2.zzx()));
            }
            zzam zzamVar27 = this.zze;
            zzal(zzamVar27);
            List listZzu = zzamVar27.zzu(zzqVar.zza);
            for (int i13 = 0; i13 < listZzu.size(); i13++) {
                com.google.android.gms.internal.measurement.zzgl zzglVarZzd = com.google.android.gms.internal.measurement.zzgm.zzd();
                zzglVarZzd.zzf(((zzky) listZzu.get(i13)).zzc);
                zzglVarZzd.zzg(((zzky) listZzu.get(i13)).zzd);
                zzkv zzkvVar2 = this.zzi;
                zzal(zzkvVar2);
                zzkvVar2.zzu(zzglVarZzd, ((zzky) listZzu.get(i13)).zze);
                zzgcVarZzt.zzl(zzglVarZzd);
            }
            try {
                zzam zzamVar28 = this.zze;
                zzal(zzamVar28);
                com.google.android.gms.internal.measurement.zzgd zzgdVar = (com.google.android.gms.internal.measurement.zzgd) zzgcVarZzt.zzaC();
                zzamVar28.zzg();
                zzamVar28.zzW();
                Preconditions.checkNotNull(zzgdVar);
                Preconditions.checkNotEmpty(zzgdVar.zzx());
                byte[] bArrZzbu = zzgdVar.zzbu();
                zzkv zzkvVar3 = zzamVar28.zzf.zzi;
                zzal(zzkvVar3);
                long jZzd = zzkvVar3.zzd(bArrZzbu);
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", zzgdVar.zzx());
                String str8 = str2;
                contentValues.put(str8, Long.valueOf(jZzd));
                contentValues.put(TtmlNode.TAG_METADATA, bArrZzbu);
                try {
                    zzgcVar = zzgcVarZzt;
                    try {
                        try {
                            zzamVar28.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                            zzam zzamVar29 = this.zze;
                            zzal(zzamVar29);
                            zzat zzatVar2 = new zzat(zzarVar.zzf);
                            while (true) {
                                if (!zzatVar2.hasNext()) {
                                    zzfi zzfiVar4 = this.zzc;
                                    zzal(zzfiVar4);
                                    boolean zZzq = zzfiVar4.zzq(zzarVar.zza, zzarVar.zzb);
                                    zzam zzamVar30 = this.zze;
                                    zzal(zzamVar30);
                                    zzak zzakVarZzl = zzamVar30.zzl(zza(), zzarVar.zza, false, false, false, false, false);
                                    if (!zZzq || zzakVarZzl.zze >= zzg().zze(zzarVar.zza, zzdu.zzn)) {
                                        i11 = 0;
                                        break;
                                    }
                                } else if ("_r".equals(zzatVar2.next())) {
                                }
                                i11 = 1;
                                break;
                            }
                            zzamVar29.zzg();
                            zzamVar29.zzW();
                            Preconditions.checkNotNull(zzarVar);
                            Preconditions.checkNotEmpty(zzarVar.zza);
                            zzkv zzkvVar4 = zzamVar29.zzf.zzi;
                            zzal(zzkvVar4);
                            byte[] bArrZzbu2 = zzkvVar4.zzj(zzarVar).zzbu();
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("app_id", zzarVar.zza);
                            contentValues2.put("name", zzarVar.zzb);
                            contentValues2.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(zzarVar.zzd));
                            contentValues2.put(str8, Long.valueOf(jZzd));
                            contentValues2.put("data", bArrZzbu2);
                            contentValues2.put("realtime", Integer.valueOf(i11));
                            try {
                                if (zzamVar29.zzh().insert(str7, null, contentValues2) == -1) {
                                    zzamVar29.zzt.zzay().zzd().zzb("Failed to insert raw event (got -1). appId", zzeh.zzn(zzarVar.zza));
                                } else {
                                    this.zza = 0L;
                                }
                            } catch (SQLiteException e17) {
                                zzamVar29.zzt.zzay().zzd().zzc("Error storing raw event. appId", zzeh.zzn(zzarVar.zza), e17);
                            }
                        } catch (SQLiteException e18) {
                            e = e18;
                            SQLiteException sQLiteException = e;
                            zzamVar28.zzt.zzay().zzd().zzc("Error storing raw event metadata. appId", zzeh.zzn(zzgdVar.zzx()), sQLiteException);
                            throw sQLiteException;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        zzay().zzd().zzc("Data loss. Failed to insert raw event metadata. appId", zzeh.zzn(zzgcVar.zzap()), e);
                    }
                    zzam zzamVar31 = this.zze;
                    zzal(zzamVar31);
                    zzamVar31.zzC();
                    zzam zzamVar32 = this.zze;
                    zzal(zzamVar32);
                    zzamVar32.zzx();
                    zzag();
                    zzay().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                } catch (SQLiteException e21) {
                    e = e21;
                    zzgcVar = zzgcVarZzt;
                }
            } catch (IOException e22) {
                e = e22;
                zzgcVar = zzgcVarZzt;
            }
        } catch (Throwable th2) {
            zzam zzamVar210 = this.zze;
            zzal(zzamVar210);
            zzamVar210.zzx();
            throw th2;
        }
    }

    @VisibleForTesting
    public final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock != null && fileLock.isValid()) {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzt.zzf();
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzx = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzw = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzay().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzay().zzd().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e11) {
            zzay().zzd().zzb("Failed to acquire storage lock", e11);
            return false;
        } catch (IOException e12) {
            zzay().zzd().zzb("Failed to access storage lock file", e12);
            return false;
        } catch (OverlappingFileLockException e13) {
            zzay().zzk().zzb("Storage lock already acquired", e13);
            return false;
        }
    }

    public final long zza() {
        long jCurrentTimeMillis = zzav().currentTimeMillis();
        zzjo zzjoVar = this.zzk;
        zzjoVar.zzW();
        zzjoVar.zzg();
        long jZza = zzjoVar.zze.zza();
        if (jZza == 0) {
            jZza = ((long) zzjoVar.zzt.zzv().zzG().nextInt(86400000)) + 1;
            zzjoVar.zze.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Context zzau() {
        return this.zzn.zzau();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final Clock zzav() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzab zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzeh zzay() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final zzfo zzaz() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    public final zzh zzd(zzq zzqVar) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzkr zzkrVar = null;
        if (!zzqVar.zzw.isEmpty()) {
            this.zzC.put(zzqVar.zza, new zzks(this, zzqVar.zzw));
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(zzqVar.zza);
        zzai zzaiVarZzc = zzh(zzqVar.zza).zzc(zzai.zzb(zzqVar.zzv));
        zzah zzahVar = zzah.AD_STORAGE;
        String strZzf = zzaiVarZzc.zzi(zzahVar) ? this.zzk.zzf(zzqVar.zza, zzqVar.zzo) : "";
        if (zzhVarZzj == null) {
            zzhVarZzj = new zzh(this.zzn, zzqVar.zza);
            if (zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE)) {
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
            }
            if (zzaiVarZzc.zzi(zzahVar)) {
                zzhVarZzj.zzae(strZzf);
            }
        } else if (zzaiVarZzc.zzi(zzahVar) && strZzf != null && !strZzf.equals(zzhVarZzj.zzA())) {
            zzhVarZzj.zzae(strZzf);
            if (zzqVar.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzqVar.zza, zzaiVarZzc).first)) {
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                if (zzamVar2.zzp(zzqVar.zza, "_id") != null) {
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzp(zzqVar.zza, "_lair") == null) {
                        zzky zzkyVar = new zzky(zzqVar.zza, "auto", "_lair", zzav().currentTimeMillis(), 1L);
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzL(zzkyVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzhVarZzj.zzu()) && zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE)) {
            zzhVarZzj.zzH(zzw(zzaiVarZzc));
        }
        zzhVarZzj.zzW(zzqVar.zzb);
        zzhVarZzj.zzF(zzqVar.zzq);
        if (!TextUtils.isEmpty(zzqVar.zzk)) {
            zzhVarZzj.zzV(zzqVar.zzk);
        }
        long j11 = zzqVar.zze;
        if (j11 != 0) {
            zzhVarZzj.zzX(j11);
        }
        if (!TextUtils.isEmpty(zzqVar.zzc)) {
            zzhVarZzj.zzJ(zzqVar.zzc);
        }
        zzhVarZzj.zzK(zzqVar.zzj);
        String str = zzqVar.zzd;
        if (str != null) {
            zzhVarZzj.zzI(str);
        }
        zzhVarZzj.zzS(zzqVar.zzf);
        zzhVarZzj.zzac(zzqVar.zzh);
        if (!TextUtils.isEmpty(zzqVar.zzg)) {
            zzhVarZzj.zzY(zzqVar.zzg);
        }
        zzhVarZzj.zzG(zzqVar.zzo);
        zzhVarZzj.zzad(zzqVar.zzr);
        zzhVarZzj.zzT(zzqVar.zzs);
        zzpd.zzc();
        if (zzg().zzs(null, zzdu.zzal) && zzg().zzs(zzqVar.zza, zzdu.zzan)) {
            zzhVarZzj.zzag(zzqVar.zzx);
        }
        zznt.zzc();
        if (zzg().zzs(null, zzdu.zzaj)) {
            zzhVarZzj.zzaf(zzqVar.zzt);
        } else {
            zznt.zzc();
            if (zzg().zzs(null, zzdu.zzai)) {
                zzhVarZzj.zzaf(null);
            }
        }
        if (zzhVarZzj.zzaj()) {
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzamVar5.zzD(zzhVarZzj);
        }
        return zzhVarZzj;
    }

    public final zzaa zzf() {
        zzaa zzaaVar = this.zzh;
        zzal(zzaaVar);
        return zzaaVar;
    }

    public final zzag zzg() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzai zzh(String str) {
        String string;
        zzai zzaiVar = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzaiVar2 = (zzai) this.zzB.get(str);
        if (zzaiVar2 != null) {
            return zzaiVar2;
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        Preconditions.checkNotNull(str);
        zzamVar.zzg();
        zzamVar.zzW();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzamVar.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                } else {
                    cursorRawQuery.close();
                    string = "G1";
                }
                zzai zzaiVarZzb = zzai.zzb(string);
                zzV(str, zzaiVarZzb);
                return zzaiVarZzb;
            } catch (SQLiteException e11) {
                zzamVar.zzt.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e11);
                throw e11;
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    public final zzam zzi() {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        return zzamVar;
    }

    public final zzec zzj() {
        return this.zzn.zzj();
    }

    public final zzen zzl() {
        zzen zzenVar = this.zzd;
        zzal(zzenVar);
        return zzenVar;
    }

    public final zzep zzm() {
        zzep zzepVar = this.zzf;
        if (zzepVar != null) {
            return zzepVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfi zzo() {
        zzfi zzfiVar = this.zzc;
        zzal(zzfiVar);
        return zzfiVar;
    }

    public final zzfr zzq() {
        return this.zzn;
    }

    public final zzic zzr() {
        zzic zzicVar = this.zzj;
        zzal(zzicVar);
        return zzicVar;
    }

    public final zzjo zzs() {
        return this.zzk;
    }

    public final zzkv zzu() {
        zzkv zzkvVar = this.zzi;
        zzal(zzkvVar);
        return zzkvVar;
    }

    public final zzlb zzv() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    public final String zzw(zzai zzaiVar) {
        if (!zzaiVar.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final String zzx(zzq zzqVar) {
        try {
            return (String) zzaz().zzh(new zzkm(this, zzqVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeh.zzn(zzqVar.zza), e11);
            return null;
        }
    }

    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
