package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.a;
import com.google.android.gms.internal.measurement.zznz;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzx extends zzy {
    final /* synthetic */ zzaa zza;
    private final com.google.android.gms.internal.measurement.zzek zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(zzaa zzaaVar, String str, int i11, com.google.android.gms.internal.measurement.zzek zzekVar) {
        super(str, i11);
        this.zza = zzaaVar;
        this.zzh = zzekVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final int zza() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzb() {
        return this.zzh.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzc() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:107:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:108:0x030d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0313  */
    /* JADX WARN: Code duplicated, block: B:112:0x031b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0327  */
    /* JADX WARN: Code duplicated, block: B:121:0x0388 A[EDGE_INSN: B:121:0x0388->B:124:0x03e0 BREAK  A[LOOP:0: B:40:0x0121->B:45:0x0156]] */
    /* JADX WARN: Code duplicated, block: B:122:0x03b4 A[EDGE_INSN: B:122:0x03b4->B:124:0x03e0 BREAK  A[LOOP:0: B:40:0x0121->B:45:0x0156]] */
    /* JADX WARN: Code duplicated, block: B:157:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0181 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x019f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x03de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x022b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x029f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x03e0 A[EDGE_INSN: B:175:0x03e0->B:124:0x03e0 BREAK  A[LOOP:0: B:40:0x0121->B:45:0x0156], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x029b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x03e0 A[EDGE_INSN: B:177:0x03e0->B:124:0x03e0 BREAK  A[LOOP:0: B:40:0x0121->B:45:0x0156], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x02f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x02a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x035c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0331 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x03e0 A[EDGE_INSN: B:186:0x03e0->B:124:0x03e0 BREAK  A[LOOP:0: B:40:0x0121->B:45:0x0156], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0206 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0206 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0206 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0114  */
    /* JADX WARN: Code duplicated, block: B:42:0x0127  */
    /* JADX WARN: Code duplicated, block: B:45:0x0156 A[LOOP:0: B:40:0x0121->B:45:0x0156, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:49:0x0171  */
    /* JADX WARN: Code duplicated, block: B:55:0x0191  */
    /* JADX WARN: Code duplicated, block: B:56:0x019a  */
    /* JADX WARN: Code duplicated, block: B:62:0x01af  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x020c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0220  */
    /* JADX WARN: Code duplicated, block: B:81:0x024a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0283  */
    /* JADX WARN: Code duplicated, block: B:89:0x0295  */
    /* JADX WARN: Code duplicated, block: B:97:0x02d4  */
    public final boolean zzd(Long l11, Long l12, com.google.android.gms.internal.measurement.zzft zzftVar, long j11, zzas zzasVar, boolean z11) {
        HashSet hashSet;
        Iterator it;
        a aVar;
        Iterator it2;
        Iterator it3;
        com.google.android.gms.internal.measurement.zzem zzemVar;
        boolean z12;
        String strZze;
        Object obj;
        Boolean boolZzh;
        Boolean boolZzg;
        String str;
        Boolean boolZzi;
        com.google.android.gms.internal.measurement.zzfx zzfxVar;
        Long lValueOf;
        Double dValueOf;
        com.google.android.gms.internal.measurement.zzem zzemVar2;
        zznz.zzc();
        boolean zZzs = this.zza.zzt.zzf().zzs(this.zzb, zzdu.zzW);
        long j12 = this.zzh.zzn() ? zzasVar.zze : j11;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (Log.isLoggable(this.zza.zzt.zzay().zzq(), 2)) {
            this.zza.zzt.zzay().zzj().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzc), this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null, this.zza.zzt.zzj().zzd(this.zzh.zzg()));
            this.zza.zzt.zzay().zzj().zzb("Filter definition", this.zza.zzf.zzu().zzo(this.zzh));
        }
        if (!this.zzh.zzp() || this.zzh.zzb() > 256) {
            this.zza.zzt.zzay().zzk().zzc("Invalid event filter ID. appId, id", zzeh.zzn(this.zzb), String.valueOf(this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null));
            return false;
        }
        boolean z13 = this.zzh.zzk() || this.zzh.zzm() || this.zzh.zzn();
        if (z11 && !z13) {
            this.zza.zzt.zzay().zzj().zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), this.zzh.zzp() ? Integer.valueOf(this.zzh.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzek zzekVar = this.zzh;
        String strZzh = zzftVar.zzh();
        if (!zzekVar.zzo()) {
            hashSet = new HashSet();
            it = zzekVar.zzh().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = new a();
                    it2 = zzftVar.zzi().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = zzekVar.zzh().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                zzemVar = (com.google.android.gms.internal.measurement.zzem) it3.next();
                                if (zzemVar.zzh() || !zzemVar.zzg()) {
                                    z12 = false;
                                } else {
                                    z12 = true;
                                }
                                strZze = zzemVar.zze();
                                if (strZze.isEmpty()) {
                                    obj = aVar.get(strZze);
                                    if (obj instanceof Long) {
                                        if (obj instanceof Double) {
                                            if (obj instanceof String) {
                                                if (obj == null) {
                                                    this.zza.zzt.zzay().zzk().zzc("Unknown param type. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                    break;
                                                }
                                                this.zza.zzt.zzay().zzj().zzc("Missing param for filter. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            if (zzemVar.zzk()) {
                                                if (zzemVar.zzi()) {
                                                    this.zza.zzt.zzay().zzk().zzc("No filter for String param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                    break;
                                                }
                                                str = (String) obj;
                                                if (zzkv.zzx(str)) {
                                                    this.zza.zzt.zzay().zzk().zzc("Invalid param value for number filter. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                    break;
                                                }
                                                boolZzi = zzy.zzi(str, zzemVar.zzc());
                                            } else {
                                                boolZzi = zzy.zzf((String) obj, zzemVar.zzd(), this.zza.zzt.zzay());
                                            }
                                            if (boolZzi != null) {
                                                break;
                                            }
                                            if (boolZzi.booleanValue() == z12) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            if (zzemVar.zzi()) {
                                                this.zza.zzt.zzay().zzk().zzc("No number filter for double param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                break;
                                            }
                                            boolZzg = zzy.zzg(((Double) obj).doubleValue(), zzemVar.zzc());
                                            if (boolZzg != null) {
                                                break;
                                            }
                                            if (boolZzg.booleanValue() == z12) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (zzemVar.zzi()) {
                                            this.zza.zzt.zzay().zzk().zzc("No number filter for long param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                            break;
                                        }
                                        boolZzh = zzy.zzh(((Long) obj).longValue(), zzemVar.zzc());
                                        if (boolZzh != null) {
                                            break;
                                        }
                                        if (boolZzh.booleanValue() == z12) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    }
                                } else {
                                    this.zza.zzt.zzay().zzk().zzb("Event has empty param name. event", this.zza.zzt.zzj().zzd(strZzh));
                                    break;
                                }
                            }
                        } else {
                            zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it2.next();
                            if (!hashSet.contains(zzfxVar.zzg())) {
                                if (zzfxVar.zzw()) {
                                    if (zzfxVar.zzu()) {
                                        if (zzfxVar.zzy()) {
                                            this.zza.zzt.zzay().zzk().zzc("Unknown value for param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(zzfxVar.zzg()));
                                            break;
                                        }
                                        aVar.put(zzfxVar.zzg(), zzfxVar.zzh());
                                    } else {
                                        String strZzg = zzfxVar.zzg();
                                        if (zzfxVar.zzu()) {
                                            dValueOf = Double.valueOf(zzfxVar.zza());
                                        } else {
                                            dValueOf = null;
                                        }
                                        aVar.put(strZzg, dValueOf);
                                    }
                                } else {
                                    String strZzg2 = zzfxVar.zzg();
                                    if (zzfxVar.zzw()) {
                                        lValueOf = Long.valueOf(zzfxVar.zzd());
                                    } else {
                                        lValueOf = null;
                                    }
                                    aVar.put(strZzg2, lValueOf);
                                }
                            }
                        }
                    }
                } else {
                    zzemVar2 = (com.google.android.gms.internal.measurement.zzem) it.next();
                    if (zzemVar2.zze().isEmpty()) {
                        this.zza.zzt.zzay().zzk().zzb("null or empty param name in filter. event", this.zza.zzt.zzj().zzd(strZzh));
                        break;
                    }
                    hashSet.add(zzemVar2.zze());
                }
            }
        } else {
            Boolean boolZzh2 = zzy.zzh(j12, zzekVar.zzf());
            if (boolZzh2 != null) {
                if (boolZzh2.booleanValue()) {
                    hashSet = new HashSet();
                    it = zzekVar.zzh().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            aVar = new a();
                            it2 = zzftVar.zzi().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    it3 = zzekVar.zzh().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            bool = Boolean.TRUE;
                                            break;
                                        }
                                        zzemVar = (com.google.android.gms.internal.measurement.zzem) it3.next();
                                        if (zzemVar.zzh()) {
                                            z12 = false;
                                        } else {
                                            z12 = false;
                                        }
                                        strZze = zzemVar.zze();
                                        if (strZze.isEmpty()) {
                                            obj = aVar.get(strZze);
                                            if (obj instanceof Long) {
                                                if (obj instanceof Double) {
                                                    if (obj instanceof String) {
                                                        if (obj == null) {
                                                            this.zza.zzt.zzay().zzk().zzc("Unknown param type. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                            break;
                                                        }
                                                        this.zza.zzt.zzay().zzj().zzc("Missing param for filter. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                    if (zzemVar.zzk()) {
                                                        if (zzemVar.zzi()) {
                                                            this.zza.zzt.zzay().zzk().zzc("No filter for String param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                            break;
                                                        }
                                                        str = (String) obj;
                                                        if (zzkv.zzx(str)) {
                                                            this.zza.zzt.zzay().zzk().zzc("Invalid param value for number filter. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                            break;
                                                        }
                                                        boolZzi = zzy.zzi(str, zzemVar.zzc());
                                                    } else {
                                                        boolZzi = zzy.zzf((String) obj, zzemVar.zzd(), this.zza.zzt.zzay());
                                                    }
                                                    if (boolZzi != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolZzi.booleanValue() == z12) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else if (zzemVar.zzi()) {
                                                    boolZzg = zzy.zzg(((Double) obj).doubleValue(), zzemVar.zzc());
                                                    if (boolZzg != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolZzg.booleanValue() == z12) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else {
                                                    this.zza.zzt.zzay().zzk().zzc("No number filter for double param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                    break;
                                                }
                                            } else if (zzemVar.zzi()) {
                                                boolZzh = zzy.zzh(((Long) obj).longValue(), zzemVar.zzc());
                                                if (boolZzh != null) {
                                                    break;
                                                    break;
                                                }
                                                if (boolZzh.booleanValue() == z12) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            } else {
                                                this.zza.zzt.zzay().zzk().zzc("No number filter for long param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(strZze));
                                                break;
                                            }
                                        } else {
                                            this.zza.zzt.zzay().zzk().zzb("Event has empty param name. event", this.zza.zzt.zzj().zzd(strZzh));
                                            break;
                                        }
                                    }
                                } else {
                                    zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it2.next();
                                    if (!hashSet.contains(zzfxVar.zzg())) {
                                        if (zzfxVar.zzw()) {
                                            if (zzfxVar.zzu()) {
                                                if (zzfxVar.zzy()) {
                                                    this.zza.zzt.zzay().zzk().zzc("Unknown value for param. event, param", this.zza.zzt.zzj().zzd(strZzh), this.zza.zzt.zzj().zze(zzfxVar.zzg()));
                                                    break;
                                                }
                                                aVar.put(zzfxVar.zzg(), zzfxVar.zzh());
                                            } else {
                                                String strZzg3 = zzfxVar.zzg();
                                                if (zzfxVar.zzu()) {
                                                    dValueOf = Double.valueOf(zzfxVar.zza());
                                                } else {
                                                    dValueOf = null;
                                                }
                                                aVar.put(strZzg3, dValueOf);
                                            }
                                        } else {
                                            String strZzg4 = zzfxVar.zzg();
                                            if (zzfxVar.zzw()) {
                                                lValueOf = Long.valueOf(zzfxVar.zzd());
                                            } else {
                                                lValueOf = null;
                                            }
                                            aVar.put(strZzg4, lValueOf);
                                        }
                                    }
                                }
                            }
                        } else {
                            zzemVar2 = (com.google.android.gms.internal.measurement.zzem) it.next();
                            if (zzemVar2.zze().isEmpty()) {
                                this.zza.zzt.zzay().zzk().zzb("null or empty param name in filter. event", this.zza.zzt.zzj().zzd(strZzh));
                                break;
                            }
                            hashSet.add(zzemVar2.zze());
                        }
                    }
                } else {
                    bool = Boolean.FALSE;
                }
            }
        }
        this.zza.zzt.zzay().zzj().zzb("Event filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.zzd = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.zze = bool2;
        if (z13 && zzftVar.zzu()) {
            Long lValueOf2 = Long.valueOf(zzftVar.zzd());
            if (this.zzh.zzm()) {
                if (zZzs && this.zzh.zzo()) {
                    lValueOf2 = l11;
                }
                this.zzg = lValueOf2;
            } else {
                if (zZzs && this.zzh.zzo()) {
                    lValueOf2 = l12;
                }
                this.zzf = lValueOf2;
            }
        }
        return true;
    }
}
