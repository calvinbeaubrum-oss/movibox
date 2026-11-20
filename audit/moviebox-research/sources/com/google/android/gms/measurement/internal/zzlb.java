package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlb extends zzgl {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd;
    private int zze;
    private Integer zzf;

    public zzlb(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = null;
        this.zzd = new AtomicLong(0L);
    }

    public static MessageDigest zzF() {
        for (int i11 = 0; i11 < 2; i11++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.zza);
            bundle.putString("origin", zzacVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzacVar.zzd);
            bundle.putString("name", zzacVar.zzc.zzb);
            zzgn.zzb(bundle, Preconditions.checkNotNull(zzacVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzacVar.zze);
            String str = zzacVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzaw zzawVar = zzacVar.zzg;
            if (zzawVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzawVar.zza);
                zzau zzauVar = zzawVar.zzb;
                if (zzauVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzauVar.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzacVar.zzh);
            zzaw zzawVar2 = zzacVar.zzi;
            if (zzawVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzawVar2.zza);
                zzau zzauVar2 = zzawVar2.zzb;
                if (zzauVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzauVar2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzacVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzacVar.zzj);
            zzaw zzawVar3 = zzacVar.zzk;
            if (zzawVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzawVar3.zza);
                zzau zzauVar3 = zzawVar3.zzb;
                if (zzauVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzauVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void zzK(zzie zzieVar, Bundle bundle, boolean z11) {
        if (bundle != null && zzieVar != null) {
            if (!bundle.containsKey("_sc") || z11) {
                String str = zzieVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzieVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzieVar.zzc);
                return;
            }
            z11 = false;
        }
        if (bundle != null && zzieVar == null && z11) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static boolean zzah(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzai(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean zzaj(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zzak(Context context, boolean z11) {
        Preconditions.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzat(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzat(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzal(String str) {
        return !zzb[0].equals(str);
    }

    public static final boolean zzao(Bundle bundle, int i11) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i11);
        return true;
    }

    @VisibleForTesting
    public static final boolean zzap(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzaq(String str) {
        if ("_ldl".equals(str)) {
            this.zzt.zzf();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.zzt.zzf();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.zzt.zzf();
            return 100;
        }
        this.zzt.zzf();
        return 36;
    }

    private final Object zzar(int i11, Object obj, boolean z11, boolean z12) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zzD(obj.toString(), i11, z11);
        }
        if (!z12 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleZzt = zzt((Bundle) parcelable);
                if (!bundleZzt.isEmpty()) {
                    arrayList.add(bundleZzt);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private static boolean zzas(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (zzkz.zza(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzat(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @VisibleForTesting
    public static long zzp(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i11 = 0;
        Preconditions.checkState(length > 0);
        long j11 = 0;
        for (int i12 = length - 1; i12 >= 0 && i12 >= bArr.length - 8; i12--) {
            j11 += (((long) bArr[i12]) & 255) << i11;
            i11 += 8;
        }
        return j11;
    }

    public final Object zzA(String str, Object obj) {
        int i11 = 256;
        if ("_ev".equals(str)) {
            this.zzt.zzf();
            return zzar(256, obj, true, true);
        }
        if (zzah(str)) {
            this.zzt.zzf();
        } else {
            this.zzt.zzf();
            i11 = 100;
        }
        return zzar(i11, obj, false, true);
    }

    public final Object zzB(String str, Object obj) {
        return "_ldl".equals(str) ? zzar(zzaq(str), obj, true, false) : zzar(zzaq(str), obj, false, false);
    }

    public final String zzC() {
        byte[] bArr = new byte[16];
        zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final String zzD(String str, int i11, boolean z11) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i11) {
            return str;
        }
        if (z11) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i11))).concat("...");
        }
        return null;
    }

    public final URL zzE(long j11, String str, String str2, long j12) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 74029L, Integer.valueOf(zzm())), str2, str, Long.valueOf(j12));
            if (str.equals(this.zzt.zzf().zzm())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e11) {
            e = e11;
            this.zzt.zzay().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e12) {
            e = e12;
            this.zzt.zzay().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final SecureRandom zzG() {
        zzg();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public final void zzI(Bundle bundle, long j11) {
        long j12 = bundle.getLong("_et");
        if (j12 != 0) {
            this.zzt.zzay().zzk().zzb("Params already contained engagement", Long.valueOf(j12));
        } else {
            j12 = 0;
        }
        bundle.putLong("_et", j11 + j12);
    }

    public final void zzJ(Bundle bundle, int i11, String str, String str2, Object obj) {
        if (zzao(bundle, i11)) {
            this.zzt.zzf();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzt.zzv().zzO(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void zzM(zzei zzeiVar, int i11) {
        int i12 = 0;
        for (String str : new TreeSet(zzeiVar.zzd.keySet())) {
            if (zzai(str) && (i12 = i12 + 1) > i11) {
                this.zzt.zzay().zze().zzc("Event can't contain more than " + i11 + " params", this.zzt.zzj().zzd(zzeiVar.zza), this.zzt.zzj().zzb(zzeiVar.zzd));
                zzao(zzeiVar.zzd, 5);
                zzeiVar.zzd.remove(str);
            }
        }
    }

    public final void zzN(zzla zzlaVar, String str, int i11, String str2, String str3, int i12) {
        Bundle bundle = new Bundle();
        zzao(bundle, i11);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i11 == 6 || i11 == 7 || i11 == 2) {
            bundle.putLong("_el", i12);
        }
        zzlaVar.zza(str, "_err", bundle);
    }

    public final void zzO(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            this.zzt.zzay().zzl().zzc("Not putting event parameter. Invalid value type. name, type", this.zzt.zzj().zze(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zzP(com.google.android.gms.internal.measurement.zzcf zzcfVar, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CampaignEx.JSON_KEY_AD_R, z11);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning boolean value to wrapper", e11);
        }
    }

    public final void zzQ(com.google.android.gms.internal.measurement.zzcf zzcfVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(CampaignEx.JSON_KEY_AD_R, arrayList);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning bundle list to wrapper", e11);
        }
    }

    public final void zzR(com.google.android.gms.internal.measurement.zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning bundle value to wrapper", e11);
        }
    }

    public final void zzS(com.google.android.gms.internal.measurement.zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(CampaignEx.JSON_KEY_AD_R, bArr);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning byte array to wrapper", e11);
        }
    }

    public final void zzT(com.google.android.gms.internal.measurement.zzcf zzcfVar, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt(CampaignEx.JSON_KEY_AD_R, i11);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning int value to wrapper", e11);
        }
    }

    public final void zzU(com.google.android.gms.internal.measurement.zzcf zzcfVar, long j11) {
        Bundle bundle = new Bundle();
        bundle.putLong(CampaignEx.JSON_KEY_AD_R, j11);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning long value to wrapper", e11);
        }
    }

    public final void zzV(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(CampaignEx.JSON_KEY_AD_R, str);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e11) {
            this.zzt.zzay().zzk().zzb("Error returning string value to wrapper", e11);
        }
    }

    public final void zzW(String str, String str2, String str3, Bundle bundle, List list, boolean z11) {
        int i11;
        int iZza;
        if (bundle == null) {
            return;
        }
        this.zzt.zzf();
        int i12 = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str4)) {
                int iZzj = !z11 ? zzj(str4) : 0;
                if (iZzj == 0) {
                    iZzj = zzi(str4);
                }
                i11 = iZzj;
            } else {
                i11 = 0;
            }
            if (i11 != 0) {
                zzJ(bundle, i11, str4, str4, i11 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (zzaf(bundle.get(str4))) {
                    this.zzt.zzay().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iZza = 22;
                } else {
                    iZza = zza(str, str2, str4, bundle.get(str4), bundle, list, z11, false);
                }
                if (iZza != 0 && !"_ev".equals(str4)) {
                    zzJ(bundle, iZza, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzai(str4) && !zzas(str4, zzgp.zzd) && (i12 = i12 + 1) > 0) {
                    this.zzt.zzay().zze().zzc("Item cannot contain custom parameters", this.zzt.zzj().zzd(str2), this.zzt.zzj().zzb(bundle));
                    zzao(bundle, 23);
                    bundle.remove(str4);
                }
            }
        }
    }

    public final boolean zzX(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzap(str)) {
                return true;
            }
            if (this.zzt.zzL()) {
                this.zzt.zzay().zze().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzeh.zzn(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.zzt.zzL()) {
                this.zzt.zzay().zze().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (zzap(str2)) {
            return true;
        }
        this.zzt.zzay().zze().zzb("Invalid admob_app_id. Analytics disabled.", zzeh.zzn(str2));
        return false;
    }

    public final boolean zzY(String str, int i11, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i11) {
            return true;
        }
        this.zzt.zzay().zze().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i11), str2);
        return false;
    }

    public final boolean zzZ(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        for (int i11 = 0; i11 < 3; i11++) {
            if (str2.startsWith(strArr3[i11])) {
                this.zzt.zzay().zze().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzas(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzas(str2, strArr2)) {
            return true;
        }
        this.zzt.zzay().zze().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
    public final int zza(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z11, boolean z12) {
        int i11;
        int i12;
        int size;
        zzg();
        if (!zzaf(obj)) {
            i11 = 0;
        } else {
            if (!z12) {
                return 21;
            }
            if (!zzas(str3, zzgp.zzc)) {
                return 20;
            }
            zzjm zzjmVarZzt = this.zzt.zzt();
            zzjmVarZzt.zzg();
            zzjmVarZzt.zza();
            if (zzjmVarZzt.zzN() && zzjmVarZzt.zzt.zzv().zzm() < 200900) {
                return 25;
            }
            this.zzt.zzf();
            boolean z13 = obj instanceof Parcelable[];
            if (z13) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            } else {
                i11 = 0;
            }
            if (size > 200) {
                this.zzt.zzay().zzl().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                this.zzt.zzf();
                if (z13) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i11 = 17;
            } else {
                i11 = 0;
            }
        }
        if (zzah(str2) || zzah(str3)) {
            this.zzt.zzf();
            i12 = 256;
        } else {
            this.zzt.zzf();
            i12 = 100;
        }
        if (zzaa("param", str3, i12, obj)) {
            return i11;
        }
        if (!z12) {
            return 4;
        }
        if (obj instanceof Bundle) {
            zzW(str, str2, str3, (Bundle) obj, list, z11);
        } else if (obj instanceof Parcelable[]) {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    this.zzt.zzay().zzl().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                    return 4;
                }
                zzW(str, str2, str3, (Bundle) parcelable, list, z11);
            }
        } else {
            if (!(obj instanceof ArrayList)) {
                return 4;
            }
            ArrayList arrayList2 = (ArrayList) obj;
            int size2 = arrayList2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                Object obj2 = arrayList2.get(i13);
                if (!(obj2 instanceof Bundle)) {
                    this.zzt.zzay().zzl().zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : "null", str3);
                    return 4;
                }
                zzW(str, str2, str3, (Bundle) obj2, list, z11);
            }
        }
        return i11;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzaA() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.zzt.zzay().zzk().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(jNextLong);
    }

    public final boolean zzaa(String str, String str2, int i11, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i11) {
                this.zzt.zzay().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean zzab(String str, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzt.zzay().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.zzt.zzay().zze().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzt.zzay().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzac(String str, String str2) {
        if (str2 == null) {
            this.zzt.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzt.zzay().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.zzt.zzay().zze().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzt.zzay().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzad(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzt.zzau()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzt.zzay().zzc().zzb("Permission not granted", str);
        return false;
    }

    public final boolean zzae(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strZzl = this.zzt.zzf().zzl();
        this.zzt.zzaw();
        return strZzl.equals(str);
    }

    public final boolean zzaf(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    @VisibleForTesting
    public final boolean zzag(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e11) {
            this.zzt.zzay().zzd().zzb("Package name not found", e11);
            return true;
        } catch (CertificateException e12) {
            this.zzt.zzay().zzd().zzb("Error obtaining certificate", e12);
            return true;
        }
    }

    public final boolean zzam(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return !TextUtils.isEmpty(str4);
            }
            return !str3.equals(str4);
        }
        if (zIsEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final byte[] zzan(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final int zzd(String str, Object obj) {
        return "_ldl".equals(str) ? zzaa("user property referrer", str, zzaq(str), obj) : zzaa("user property", str, zzaq(str), obj) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return true;
    }

    public final int zzh(String str) {
        if (!zzab(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zzZ(NotificationCompat.CATEGORY_EVENT, zzgo.zza, zzgo.zzb, str)) {
            return 13;
        }
        this.zzt.zzf();
        return !zzY(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    public final int zzi(String str) {
        if (!zzab("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        this.zzt.zzf();
        return !zzY("event param", 40, str) ? 3 : 0;
    }

    public final int zzj(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        this.zzt.zzf();
        return !zzY("event param", 40, str) ? 3 : 0;
    }

    public final int zzl(String str) {
        if (!zzab("user property", str)) {
            return 6;
        }
        if (!zzZ("user property", zzgq.zza, null, str)) {
            return 15;
        }
        this.zzt.zzf();
        return !zzY("user property", 24, str) ? 6 : 0;
    }

    public final int zzm() {
        if (this.zzf == null) {
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzt.zzau()) / 1000);
        }
        return this.zzf.intValue();
    }

    public final int zzo(int i11) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzt.zzau(), 12451000);
    }

    public final long zzq() {
        long andIncrement;
        long j11;
        if (this.zzd.get() != 0) {
            synchronized (this.zzd) {
                this.zzd.compareAndSet(-1L, 1L);
                andIncrement = this.zzd.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.zzd) {
            long jNextLong = new Random(System.nanoTime() ^ this.zzt.zzav().currentTimeMillis()).nextLong();
            int i11 = this.zze + 1;
            this.zze = i11;
            j11 = jNextLong + ((long) i11);
        }
        return j11;
    }

    public final long zzr(long j11, long j12) {
        return (j11 + (j12 * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS)) / ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
    }

    public final Bundle zzs(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                    queryParameter5 = uri.getQueryParameter("utm_id");
                    queryParameter6 = uri.getQueryParameter("dclid");
                    queryParameter7 = uri.getQueryParameter("srsltid");
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                    queryParameter5 = null;
                    queryParameter6 = null;
                    queryParameter7 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("campaign", queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("source", queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("medium", queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                String queryParameter8 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("term", queryParameter8);
                }
                String queryParameter9 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString(AppLovinEventTypes.USER_VIEWED_CONTENT, queryParameter9);
                }
                String queryParameter10 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter10)) {
                    bundle.putString("aclid", queryParameter10);
                }
                String queryParameter11 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter11)) {
                    bundle.putString("cp1", queryParameter11);
                }
                String queryParameter12 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter12)) {
                    bundle.putString("anid", queryParameter12);
                }
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("campaign_id", queryParameter5);
                }
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("dclid", queryParameter6);
                }
                String queryParameter13 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter13)) {
                    bundle.putString("source_platform", queryParameter13);
                }
                String queryParameter14 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter14)) {
                    bundle.putString("creative_format", queryParameter14);
                }
                String queryParameter15 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter15)) {
                    bundle.putString("marketing_tactic", queryParameter15);
                }
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("srsltid", queryParameter7);
                }
                return bundle;
            } catch (UnsupportedOperationException e11) {
                this.zzt.zzay().zzk().zzb("Install referrer url isn't a hierarchical URI", e11);
            }
        }
        return null;
    }

    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objZzA = zzA(str, bundle.get(str));
                if (objZzA == null) {
                    this.zzt.zzay().zzl().zzb("Param value can't be null", this.zzt.zzj().zze(str));
                } else {
                    zzO(bundle2, str, objZzA);
                }
            }
        }
        return bundle2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:51:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:41:0x00c6, please report this as an issue */
    public final Bundle zzy(String str, String str2, Bundle bundle, List list, boolean z11) {
        int i11;
        int i12;
        String str3;
        int i13;
        boolean zZzas = zzas(str2, zzgo.zzd);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iZzc = this.zzt.zzf().zzc();
        int i14 = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str4)) {
                int iZzj = !z11 ? zzj(str4) : 0;
                if (iZzj == 0) {
                    iZzj = zzi(str4);
                }
                i11 = iZzj;
            } else {
                i11 = 0;
            }
            if (i11 != 0) {
                zzJ(bundle2, i11, str4, str4, i11 == 3 ? str4 : null);
                bundle2.remove(str4);
                i12 = iZzc;
            } else {
                i12 = iZzc;
                int iZza = zza(str, str2, str4, bundle.get(str4), bundle2, list, z11, zZzas);
                if (iZza == 17) {
                    zzJ(bundle2, 17, str4, str4, Boolean.FALSE);
                } else {
                    if (iZza != 0) {
                        str3 = str4;
                        if (!"_ev".equals(str3)) {
                            zzJ(bundle2, iZza, iZza == 21 ? str2 : str3, str3, bundle.get(str3));
                            bundle2.remove(str3);
                        }
                    }
                    if (!zzai(str3)) {
                        i13 = i14 + 1;
                        if (i13 > i12) {
                            this.zzt.zzay().zze().zzc("Event can't contain more than " + i12 + " params", this.zzt.zzj().zzd(str2), this.zzt.zzj().zzb(bundle));
                            zzao(bundle2, 5);
                            bundle2.remove(str3);
                        }
                        i14 = i13;
                    }
                }
                str3 = str4;
                if (!zzai(str3)) {
                    i13 = i14 + 1;
                    if (i13 > i12) {
                        this.zzt.zzay().zze().zzc("Event can't contain more than " + i12 + " params", this.zzt.zzj().zzd(str2), this.zzt.zzj().zzb(bundle));
                        zzao(bundle2, 5);
                        bundle2.remove(str3);
                    }
                    i14 = i13;
                }
            }
            iZzc = i12;
        }
        return bundle2;
    }

    public final zzaw zzz(String str, String str2, Bundle bundle, String str3, long j11, boolean z11, boolean z12) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzh(str2) != 0) {
            this.zzt.zzay().zzd().zzb("Invalid conditional property event name", this.zzt.zzj().zzf(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleZzy = zzy(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z11) {
            bundleZzy = zzt(bundleZzy);
        }
        Preconditions.checkNotNull(bundleZzy);
        return new zzaw(str2, new zzau(bundleZzy), str3, j11);
    }
}
