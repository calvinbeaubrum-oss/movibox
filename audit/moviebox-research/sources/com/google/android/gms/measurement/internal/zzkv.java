package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzpd;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkv extends zzkh {
    public zzkv(zzkt zzktVar) {
        super(zzktVar);
    }

    public static final boolean zzA(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzawVar);
        Preconditions.checkNotNull(zzqVar);
        return (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) ? false : true;
    }

    public static final com.google.android.gms.internal.measurement.zzfx zzB(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        for (com.google.android.gms.internal.measurement.zzfx zzfxVar : zzftVar.zzi()) {
            if (zzfxVar.zzg().equals(str)) {
                return zzfxVar;
            }
        }
        return null;
    }

    public static final Object zzC(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzB = zzB(zzftVar, str);
        if (zzfxVarZzB == null) {
            return null;
        }
        if (zzfxVarZzB.zzy()) {
            return zzfxVarZzB.zzh();
        }
        if (zzfxVarZzB.zzw()) {
            return Long.valueOf(zzfxVarZzB.zzd());
        }
        if (zzfxVarZzB.zzu()) {
            return Double.valueOf(zzfxVarZzB.zza());
        }
        if (zzfxVarZzB.zzc() <= 0) {
            return null;
        }
        List<com.google.android.gms.internal.measurement.zzfx> listZzi = zzfxVarZzB.zzi();
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.internal.measurement.zzfx zzfxVar : listZzi) {
            if (zzfxVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzfx zzfxVar2 : zzfxVar.zzi()) {
                    if (zzfxVar2.zzy()) {
                        bundle.putString(zzfxVar2.zzg(), zzfxVar2.zzh());
                    } else if (zzfxVar2.zzw()) {
                        bundle.putLong(zzfxVar2.zzg(), zzfxVar2.zzd());
                    } else if (zzfxVar2.zzu()) {
                        bundle.putDouble(zzfxVar2.zzg(), zzfxVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void zzD(StringBuilder sb2, int i11, List list) {
        if (list == null) {
            return;
        }
        int i12 = i11 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it.next();
            if (zzfxVar != null) {
                zzF(sb2, i12);
                sb2.append("param {\n");
                zzI(sb2, i12, "name", zzfxVar.zzx() ? this.zzt.zzj().zze(zzfxVar.zzg()) : null);
                zzI(sb2, i12, "string_value", zzfxVar.zzy() ? zzfxVar.zzh() : null);
                zzI(sb2, i12, "int_value", zzfxVar.zzw() ? Long.valueOf(zzfxVar.zzd()) : null);
                zzI(sb2, i12, "double_value", zzfxVar.zzu() ? Double.valueOf(zzfxVar.zza()) : null);
                if (zzfxVar.zzc() > 0) {
                    zzD(sb2, i12, zzfxVar.zzi());
                }
                zzF(sb2, i12);
                sb2.append("}\n");
            }
        }
    }

    private final void zzE(StringBuilder sb2, int i11, com.google.android.gms.internal.measurement.zzem zzemVar) {
        String str;
        if (zzemVar == null) {
            return;
        }
        zzF(sb2, i11);
        sb2.append("filter {\n");
        if (zzemVar.zzh()) {
            zzI(sb2, i11, "complement", Boolean.valueOf(zzemVar.zzg()));
        }
        if (zzemVar.zzj()) {
            zzI(sb2, i11, "param_name", this.zzt.zzj().zze(zzemVar.zze()));
        }
        if (zzemVar.zzk()) {
            int i12 = i11 + 1;
            com.google.android.gms.internal.measurement.zzey zzeyVarZzd = zzemVar.zzd();
            if (zzeyVarZzd != null) {
                zzF(sb2, i12);
                sb2.append("string_filter {\n");
                if (zzeyVarZzd.zzi()) {
                    switch (zzeyVarZzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzI(sb2, i12, "match_type", str);
                }
                if (zzeyVarZzd.zzh()) {
                    zzI(sb2, i12, "expression", zzeyVarZzd.zzd());
                }
                if (zzeyVarZzd.zzg()) {
                    zzI(sb2, i12, "case_sensitive", Boolean.valueOf(zzeyVarZzd.zzf()));
                }
                if (zzeyVarZzd.zza() > 0) {
                    zzF(sb2, i11 + 2);
                    sb2.append("expression_list {\n");
                    for (String str2 : zzeyVarZzd.zze()) {
                        zzF(sb2, i11 + 3);
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                zzF(sb2, i12);
                sb2.append("}\n");
            }
        }
        if (zzemVar.zzi()) {
            zzJ(sb2, i11 + 1, "number_filter", zzemVar.zzc());
        }
        zzF(sb2, i11);
        sb2.append("}\n");
    }

    private static final void zzF(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("  ");
        }
    }

    private static final String zzG(boolean z11, boolean z12, boolean z13) {
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            sb2.append("Dynamic ");
        }
        if (z12) {
            sb2.append("Sequence ");
        }
        if (z13) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    private static final void zzH(StringBuilder sb2, int i11, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar) {
        if (zzgiVar == null) {
            return;
        }
        zzF(sb2, 3);
        sb2.append(str);
        sb2.append(" {\n");
        if (zzgiVar.zzb() != 0) {
            zzF(sb2, 4);
            sb2.append("results: ");
            int i12 = 0;
            for (Long l11 : zzgiVar.zzk()) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i12 = i13;
            }
            sb2.append('\n');
        }
        if (zzgiVar.zzd() != 0) {
            zzF(sb2, 4);
            sb2.append("status: ");
            int i14 = 0;
            for (Long l12 : zzgiVar.zzn()) {
                int i15 = i14 + 1;
                if (i14 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l12);
                i14 = i15;
            }
            sb2.append('\n');
        }
        if (zzgiVar.zza() != 0) {
            zzF(sb2, 4);
            sb2.append("dynamic_filter_timestamps: {");
            int i16 = 0;
            for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzgiVar.zzj()) {
                int i17 = i16 + 1;
                if (i16 != 0) {
                    sb2.append(", ");
                }
                sb2.append(zzfrVar.zzh() ? Integer.valueOf(zzfrVar.zza()) : null);
                sb2.append(":");
                sb2.append(zzfrVar.zzg() ? Long.valueOf(zzfrVar.zzb()) : null);
                i16 = i17;
            }
            sb2.append("}\n");
        }
        if (zzgiVar.zzc() != 0) {
            zzF(sb2, 4);
            sb2.append("sequence_filter_timestamps: {");
            int i18 = 0;
            for (com.google.android.gms.internal.measurement.zzgk zzgkVar : zzgiVar.zzm()) {
                int i19 = i18 + 1;
                if (i18 != 0) {
                    sb2.append(", ");
                }
                sb2.append(zzgkVar.zzi() ? Integer.valueOf(zzgkVar.zzb()) : null);
                sb2.append(": [");
                Iterator it = zzgkVar.zzf().iterator();
                int i21 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i22 = i21 + 1;
                    if (i21 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jLongValue);
                    i21 = i22;
                }
                sb2.append("]");
                i18 = i19;
            }
            sb2.append("}\n");
        }
        zzF(sb2, 3);
        sb2.append("}\n");
    }

    private static final void zzI(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzF(sb2, i11 + 1);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    private static final void zzJ(StringBuilder sb2, int i11, String str, com.google.android.gms.internal.measurement.zzer zzerVar) {
        String str2;
        if (zzerVar == null) {
            return;
        }
        zzF(sb2, i11);
        sb2.append(str);
        sb2.append(" {\n");
        if (zzerVar.zzg()) {
            int iZzm = zzerVar.zzm();
            if (iZzm == 1) {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            } else if (iZzm == 2) {
                str2 = "LESS_THAN";
            } else if (iZzm != 3) {
                str2 = iZzm != 4 ? "BETWEEN" : "EQUAL";
            } else {
                str2 = "GREATER_THAN";
            }
            zzI(sb2, i11, "comparison_type", str2);
        }
        if (zzerVar.zzi()) {
            zzI(sb2, i11, "match_as_float", Boolean.valueOf(zzerVar.zzf()));
        }
        if (zzerVar.zzh()) {
            zzI(sb2, i11, "comparison_value", zzerVar.zzc());
        }
        if (zzerVar.zzk()) {
            zzI(sb2, i11, "min_comparison_value", zzerVar.zze());
        }
        if (zzerVar.zzj()) {
            zzI(sb2, i11, "max_comparison_value", zzerVar.zzd());
        }
        zzF(sb2, i11);
        sb2.append("}\n");
    }

    public static int zza(com.google.android.gms.internal.measurement.zzgc zzgcVar, String str) {
        for (int i11 = 0; i11 < zzgcVar.zzb(); i11++) {
            if (str.equals(zzgcVar.zzao(i11).zzf())) {
                return i11;
            }
        }
        return -1;
    }

    public static zzll zzl(zzll zzllVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzkp {
        com.google.android.gms.internal.measurement.zzjr zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza();
        return zzjrVarZza != null ? zzllVar.zzay(bArr, zzjrVarZza) : zzllVar.zzax(bArr);
    }

    public static List zzr(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 0; i11 < length; i11++) {
            long j11 = 0;
            for (int i12 = 0; i12 < 64; i12++) {
                int i13 = (i11 * 64) + i12;
                if (i13 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i13)) {
                    j11 |= 1 << i12;
                }
            }
            arrayList.add(Long.valueOf(j11));
        }
        return arrayList;
    }

    public static boolean zzv(List list, int i11) {
        if (i11 < list.size() * 64) {
            return ((1 << (i11 % 64)) & ((Long) list.get(i11 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static boolean zzx(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static final void zzz(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str, Object obj) {
        List listZzp = zzfsVar.zzp();
        int i11 = 0;
        while (true) {
            if (i11 >= listZzp.size()) {
                i11 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzfx) listZzp.get(i11)).zzg())) {
                break;
            } else {
                i11++;
            }
        }
        com.google.android.gms.internal.measurement.zzfw zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
        zzfwVarZze.zzj(str);
        if (obj instanceof Long) {
            zzfwVarZze.zzi(((Long) obj).longValue());
        }
        if (i11 >= 0) {
            zzfsVar.zzj(i11, zzfwVarZze);
        } else {
            zzfsVar.zze(zzfwVarZze);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final boolean zzb() {
        return false;
    }

    public final long zzd(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.zzt.zzv().zzg();
        MessageDigest messageDigestZzF = zzlb.zzF();
        if (messageDigestZzF != null) {
            return zzlb.zzp(messageDigestZzF.digest(bArr));
        }
        this.zzt.zzay().zzd().zza("Failed to get MD5");
        return 0L;
    }

    public final Bundle zzf(Map map, boolean z11) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z11) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    arrayList2.add(zzf((Map) arrayList.get(i11), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public final Parcelable zzh(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.zzt.zzay().zzd().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final zzaw zzi(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        Object obj;
        Bundle bundleZzf = zzf(zzaaVar.zze(), true);
        String string = (!bundleZzf.containsKey("_o") || (obj = bundleZzf.get("_o")) == null) ? MBridgeConstans.DYNAMIC_VIEW_WX_APP : obj.toString();
        String strZzb = zzgo.zzb(zzaaVar.zzd());
        if (strZzb == null) {
            strZzb = zzaaVar.zzd();
        }
        return new zzaw(strZzb, new zzau(bundleZzf), string, zzaaVar.zza());
    }

    public final com.google.android.gms.internal.measurement.zzft zzj(zzar zzarVar) {
        com.google.android.gms.internal.measurement.zzfs zzfsVarZze = com.google.android.gms.internal.measurement.zzft.zze();
        zzfsVarZze.zzl(zzarVar.zze);
        zzat zzatVar = new zzat(zzarVar.zzf);
        while (zzatVar.hasNext()) {
            String next = zzatVar.next();
            com.google.android.gms.internal.measurement.zzfw zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
            zzfwVarZze.zzj(next);
            Object objZzf = zzarVar.zzf.zzf(next);
            Preconditions.checkNotNull(objZzf);
            zzt(zzfwVarZze, objZzf);
            zzfsVarZze.zze(zzfwVarZze);
        }
        return (com.google.android.gms.internal.measurement.zzft) zzfsVarZze.zzaC();
    }

    public final String zzm(com.google.android.gms.internal.measurement.zzgb zzgbVar) {
        if (zzgbVar == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.zzgd zzgdVar : zzgbVar.zzd()) {
            if (zzgdVar != null) {
                zzF(sb2, 1);
                sb2.append("bundle {\n");
                if (zzgdVar.zzbj()) {
                    zzI(sb2, 1, "protocol_version", Integer.valueOf(zzgdVar.zzd()));
                }
                zzpd.zzc();
                if (this.zzt.zzf().zzs(null, zzdu.zzal) && this.zzt.zzf().zzs(zzgdVar.zzx(), zzdu.zzan) && zzgdVar.zzbm()) {
                    zzI(sb2, 1, "session_stitching_token", zzgdVar.zzK());
                }
                zzI(sb2, 1, TrackingKey.PLATFORM, zzgdVar.zzI());
                if (zzgdVar.zzbf()) {
                    zzI(sb2, 1, "gmp_version", Long.valueOf(zzgdVar.zzm()));
                }
                if (zzgdVar.zzbq()) {
                    zzI(sb2, 1, "uploading_gmp_version", Long.valueOf(zzgdVar.zzr()));
                }
                if (zzgdVar.zzbd()) {
                    zzI(sb2, 1, "dynamite_version", Long.valueOf(zzgdVar.zzj()));
                }
                if (zzgdVar.zzba()) {
                    zzI(sb2, 1, "config_version", Long.valueOf(zzgdVar.zzh()));
                }
                zzI(sb2, 1, "gmp_app_id", zzgdVar.zzF());
                zzI(sb2, 1, "admob_app_id", zzgdVar.zzw());
                zzI(sb2, 1, "app_id", zzgdVar.zzx());
                zzI(sb2, 1, "app_version", zzgdVar.zzA());
                if (zzgdVar.zzaY()) {
                    zzI(sb2, 1, "app_version_major", Integer.valueOf(zzgdVar.zza()));
                }
                zzI(sb2, 1, "firebase_instance_id", zzgdVar.zzE());
                if (zzgdVar.zzbc()) {
                    zzI(sb2, 1, "dev_cert_hash", Long.valueOf(zzgdVar.zzi()));
                }
                zzI(sb2, 1, "app_store", zzgdVar.zzz());
                if (zzgdVar.zzbp()) {
                    zzI(sb2, 1, "upload_timestamp_millis", Long.valueOf(zzgdVar.zzq()));
                }
                if (zzgdVar.zzbn()) {
                    zzI(sb2, 1, "start_timestamp_millis", Long.valueOf(zzgdVar.zzp()));
                }
                if (zzgdVar.zzbe()) {
                    zzI(sb2, 1, "end_timestamp_millis", Long.valueOf(zzgdVar.zzk()));
                }
                if (zzgdVar.zzbi()) {
                    zzI(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgdVar.zzo()));
                }
                if (zzgdVar.zzbh()) {
                    zzI(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgdVar.zzn()));
                }
                zzI(sb2, 1, "app_instance_id", zzgdVar.zzy());
                zzI(sb2, 1, "resettable_device_id", zzgdVar.zzJ());
                zzI(sb2, 1, "ds_id", zzgdVar.zzD());
                if (zzgdVar.zzbg()) {
                    zzI(sb2, 1, "limited_ad_tracking", Boolean.valueOf(zzgdVar.zzaW()));
                }
                zzI(sb2, 1, "os_version", zzgdVar.zzH());
                zzI(sb2, 1, "device_model", zzgdVar.zzC());
                zzI(sb2, 1, "user_default_language", zzgdVar.zzL());
                if (zzgdVar.zzbo()) {
                    zzI(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(zzgdVar.zzf()));
                }
                if (zzgdVar.zzaZ()) {
                    zzI(sb2, 1, "bundle_sequential_index", Integer.valueOf(zzgdVar.zzb()));
                }
                if (zzgdVar.zzbl()) {
                    zzI(sb2, 1, "service_upload", Boolean.valueOf(zzgdVar.zzaX()));
                }
                zzI(sb2, 1, "health_monitor", zzgdVar.zzG());
                if (zzgdVar.zzbk()) {
                    zzI(sb2, 1, "retry_counter", Integer.valueOf(zzgdVar.zze()));
                }
                if (zzgdVar.zzbb()) {
                    zzI(sb2, 1, "consent_signals", zzgdVar.zzB());
                }
                List<com.google.android.gms.internal.measurement.zzgm> listZzO = zzgdVar.zzO();
                if (listZzO != null) {
                    for (com.google.android.gms.internal.measurement.zzgm zzgmVar : listZzO) {
                        if (zzgmVar != null) {
                            zzF(sb2, 2);
                            sb2.append("user_property {\n");
                            zzI(sb2, 2, "set_timestamp_millis", zzgmVar.zzs() ? Long.valueOf(zzgmVar.zzc()) : null);
                            zzI(sb2, 2, "name", this.zzt.zzj().zzf(zzgmVar.zzf()));
                            zzI(sb2, 2, "string_value", zzgmVar.zzg());
                            zzI(sb2, 2, "int_value", zzgmVar.zzr() ? Long.valueOf(zzgmVar.zzb()) : null);
                            zzI(sb2, 2, "double_value", zzgmVar.zzq() ? Double.valueOf(zzgmVar.zza()) : null);
                            zzF(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzfp> listZzM = zzgdVar.zzM();
                if (listZzM != null) {
                    for (com.google.android.gms.internal.measurement.zzfp zzfpVar : listZzM) {
                        if (zzfpVar != null) {
                            zzF(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (zzfpVar.zzk()) {
                                zzI(sb2, 2, "audience_id", Integer.valueOf(zzfpVar.zza()));
                            }
                            if (zzfpVar.zzm()) {
                                zzI(sb2, 2, "new_audience", Boolean.valueOf(zzfpVar.zzj()));
                            }
                            zzH(sb2, 2, "current_data", zzfpVar.zzd());
                            if (zzfpVar.zzn()) {
                                zzH(sb2, 2, "previous_data", zzfpVar.zze());
                            }
                            zzF(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzft> listZzN = zzgdVar.zzN();
                if (listZzN != null) {
                    for (com.google.android.gms.internal.measurement.zzft zzftVar : listZzN) {
                        if (zzftVar != null) {
                            zzF(sb2, 2);
                            sb2.append("event {\n");
                            zzI(sb2, 2, "name", this.zzt.zzj().zzd(zzftVar.zzh()));
                            if (zzftVar.zzu()) {
                                zzI(sb2, 2, "timestamp_millis", Long.valueOf(zzftVar.zzd()));
                            }
                            if (zzftVar.zzt()) {
                                zzI(sb2, 2, "previous_timestamp_millis", Long.valueOf(zzftVar.zzc()));
                            }
                            if (zzftVar.zzs()) {
                                zzI(sb2, 2, "count", Integer.valueOf(zzftVar.zza()));
                            }
                            if (zzftVar.zzb() != 0) {
                                zzD(sb2, 2, zzftVar.zzi());
                            }
                            zzF(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                zzF(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    public final String zzo(com.google.android.gms.internal.measurement.zzek zzekVar) {
        if (zzekVar == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (zzekVar.zzp()) {
            zzI(sb2, 0, "filter_id", Integer.valueOf(zzekVar.zzb()));
        }
        zzI(sb2, 0, "event_name", this.zzt.zzj().zzd(zzekVar.zzg()));
        String strZzG = zzG(zzekVar.zzk(), zzekVar.zzm(), zzekVar.zzn());
        if (!strZzG.isEmpty()) {
            zzI(sb2, 0, "filter_type", strZzG);
        }
        if (zzekVar.zzo()) {
            zzJ(sb2, 1, "event_count_filter", zzekVar.zzf());
        }
        if (zzekVar.zza() > 0) {
            sb2.append("  filters {\n");
            Iterator it = zzekVar.zzh().iterator();
            while (it.hasNext()) {
                zzE(sb2, 2, (com.google.android.gms.internal.measurement.zzem) it.next());
            }
        }
        zzF(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    public final String zzp(com.google.android.gms.internal.measurement.zzet zzetVar) {
        if (zzetVar == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (zzetVar.zzj()) {
            zzI(sb2, 0, "filter_id", Integer.valueOf(zzetVar.zza()));
        }
        zzI(sb2, 0, "property_name", this.zzt.zzj().zzf(zzetVar.zze()));
        String strZzG = zzG(zzetVar.zzg(), zzetVar.zzh(), zzetVar.zzi());
        if (!strZzG.isEmpty()) {
            zzI(sb2, 0, "filter_type", strZzG);
        }
        zzE(sb2, 1, zzetVar.zzb());
        sb2.append("}\n");
        return sb2.toString();
    }

    public final List zzq(List list, List list2) {
        int i11;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzt.zzay().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    this.zzt.zzay().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i12 = size2;
            i11 = size;
            size = i12;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i11);
    }

    public final Map zzs(Bundle bundle, boolean z11) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z12 = obj instanceof Parcelable[];
            if (z12 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z11) {
                    ArrayList arrayList = new ArrayList();
                    if (z12) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzs((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            Object obj2 = arrayList2.get(i11);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzs((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzs((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzfw zzfwVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfwVar.zzg();
        zzfwVar.zze();
        zzfwVar.zzd();
        zzfwVar.zzf();
        if (obj instanceof String) {
            zzfwVar.zzk((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzfwVar.zzi(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzfwVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            this.zzt.zzay().zzd().zzb("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.zzfw zzfwVarZze = com.google.android.gms.internal.measurement.zzfx.zze();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.zzfw zzfwVarZze2 = com.google.android.gms.internal.measurement.zzfx.zze();
                    zzfwVarZze2.zzj(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzfwVarZze2.zzi(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzfwVarZze2.zzk((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzfwVarZze2.zzh(((Double) obj2).doubleValue());
                    }
                    zzfwVarZze.zzc(zzfwVarZze2);
                }
                if (zzfwVarZze.zza() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.zzfx) zzfwVarZze.zzaC());
                }
            }
        }
        zzfwVar.zzb(arrayList);
    }

    public final void zzu(com.google.android.gms.internal.measurement.zzgl zzglVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzglVar.zzc();
        zzglVar.zzb();
        zzglVar.zza();
        if (obj instanceof String) {
            zzglVar.zzh((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzglVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzglVar.zzd(((Double) obj).doubleValue());
        } else {
            this.zzt.zzay().zzd().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final boolean zzw(long j11, long j12) {
        return j11 == 0 || j12 <= 0 || Math.abs(this.zzt.zzav().currentTimeMillis() - j11) > j12;
    }

    public final byte[] zzy(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            this.zzt.zzay().zzd().zzb("Failed to gzip content", e11);
            throw e11;
        }
    }
}
