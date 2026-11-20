package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyu implements zzhbq {
    private final zzgyt zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgyu(zzgyt zzgytVar) {
        byte[] bArr = zzhae.zzd;
        this.zza = zzgytVar;
        zzgytVar.zzc = this;
    }

    private final void zzP(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        int i11 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhbyVar.zzh(obj, this, zzgzfVar);
            if (this.zzb != this.zzc) {
                throw zzhag.zzg();
            }
            this.zzc = i11;
        } catch (Throwable th2) {
            this.zzc = i11;
            throw th2;
        }
    }

    private final void zzQ(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        zzgyt zzgytVar = this.zza;
        int iZzn = zzgytVar.zzn();
        if (zzgytVar.zza >= zzgytVar.zzb) {
            throw new zzhag("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZze = this.zza.zze(iZzn);
        this.zza.zza++;
        zzhbyVar.zzh(obj, this, zzgzfVar);
        this.zza.zzz(0);
        zzgyt zzgytVar2 = this.zza;
        zzgytVar2.zza--;
        zzgytVar2.zzA(iZze);
    }

    private final void zzR(int i11) throws IOException {
        if (this.zza.zzd() != i11) {
            throw zzhag.zzj();
        }
    }

    private final void zzS(int i11) throws IOException {
        if ((this.zzb & 7) != i11) {
            throw zzhag.zza();
        }
    }

    private static final void zzT(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw zzhag.zzg();
        }
    }

    private static final void zzU(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw zzhag.zzg();
        }
    }

    public static zzgyu zzq(zzgyt zzgytVar) {
        zzgyu zzgyuVar = zzgytVar.zzc;
        return zzgyuVar != null ? zzgyuVar : new zzgyu(zzgytVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzA(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i11 = this.zzb & 7;
            if (i11 != 1) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                int iZzn = this.zza.zzn();
                zzU(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzhatVar.zzg(this.zza.zzo());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzhatVar.zzg(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 1) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                int iZzn2 = this.zza.zzn();
                zzU(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzB(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzm) {
            zzgzm zzgzmVar = (zzgzm) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int iZzn = this.zza.zzn();
                zzT(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzgzmVar.zze(this.zza.zzc());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i11 != 5) {
                throw zzhag.zza();
            }
            do {
                zzgzmVar.zze(this.zza.zzc());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int iZzn2 = this.zza.zzn();
                zzT(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i12 != 5) {
                throw zzhag.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    @Deprecated
    public final void zzC(List list, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        int iZzm;
        int i11 = this.zzb;
        if ((i11 & 7) != 3) {
            throw zzhag.zza();
        }
        do {
            Object objZze = zzhbyVar.zze();
            zzP(objZze, zzhbyVar, zzgzfVar);
            zzhbyVar.zzf(objZze);
            list.add(objZze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i11);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzD(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzgzvVar.zzh(this.zza.zzh());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzgzvVar.zzh(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzE(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzhatVar.zzg(this.zza.zzp());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzhatVar.zzg(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzF(List list, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        int iZzm;
        int i11 = this.zzb;
        if ((i11 & 7) != 2) {
            throw zzhag.zza();
        }
        do {
            Object objZze = zzhbyVar.zze();
            zzQ(objZze, zzhbyVar, zzgzfVar);
            zzhbyVar.zzf(objZze);
            list.add(objZze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i11);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzG(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int iZzn = this.zza.zzn();
                zzT(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzgzvVar.zzh(this.zza.zzk());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i11 != 5) {
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzk());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int iZzn2 = this.zza.zzn();
                zzT(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i12 != 5) {
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzH(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i11 = this.zzb & 7;
            if (i11 != 1) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                int iZzn = this.zza.zzn();
                zzU(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzhatVar.zzg(this.zza.zzt());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzhatVar.zzg(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 1) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                int iZzn2 = this.zza.zzn();
                zzU(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzI(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzgzvVar.zzh(this.zza.zzl());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzgzvVar.zzh(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzJ(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzhatVar.zzg(this.zza.zzu());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzhatVar.zzg(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    public final void zzK(List list, boolean z11) throws IOException {
        int iZzm;
        int iZzm2;
        if ((this.zzb & 7) != 2) {
            throw zzhag.zza();
        }
        if ((list instanceof zzham) && !z11) {
            zzham zzhamVar = (zzham) list;
            do {
                zzhamVar.zzi(zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            do {
                list.add(z11 ? zzs() : zzr());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzL(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzgzvVar.zzh(this.zza.zzn());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzgzvVar.zzh(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzM(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzhat) {
            zzhat zzhatVar = (zzhat) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzhatVar.zzg(this.zza.zzv());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzhatVar.zzg(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final boolean zzO() throws IOException {
        int i11;
        if (this.zza.zzC() || (i11 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzc() throws IOException {
        int iZzm = this.zzd;
        if (iZzm != 0) {
            this.zzb = iZzm;
            this.zzd = 0;
        } else {
            iZzm = this.zza.zzm();
            this.zzb = iZzm;
        }
        return (iZzm == 0 || iZzm == this.zzc) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iZzm >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final zzgyl zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzt(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        zzS(3);
        zzP(obj, zzhbyVar, zzgzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzu(Object obj, zzhby zzhbyVar, zzgzf zzgzfVar) throws IOException {
        zzS(2);
        zzQ(obj, zzhbyVar, zzgzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzv(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzgxzVar.zze(this.zza.zzD());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzgxzVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzw(List list) throws IOException {
        int iZzm;
        if ((this.zzb & 7) != 2) {
            throw zzhag.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == this.zzb);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzx(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzc) {
            zzgzc zzgzcVar = (zzgzc) list;
            int i11 = this.zzb & 7;
            if (i11 != 1) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                int iZzn = this.zza.zzn();
                zzU(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzgzcVar.zze(this.zza.zzb());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzgzcVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 1) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                int iZzn2 = this.zza.zzn();
                zzU(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzy(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i11 = this.zzb & 7;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar = this.zza;
                int iZzd = zzgytVar.zzd() + zzgytVar.zzn();
                do {
                    zzgzvVar.zzh(this.zza.zzf());
                } while (this.zza.zzd() < iZzd);
                zzR(iZzd);
                return;
            }
            do {
                zzgzvVar.zzh(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 != 0) {
                if (i12 != 2) {
                    throw zzhag.zza();
                }
                zzgyt zzgytVar2 = this.zza;
                int iZzd2 = zzgytVar2.zzd() + zzgytVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < iZzd2);
                zzR(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.ads.zzhbq
    public final void zzz(List list) throws IOException {
        int iZzm;
        int iZzm2;
        if (list instanceof zzgzv) {
            zzgzv zzgzvVar = (zzgzv) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int iZzn = this.zza.zzn();
                zzT(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzgzvVar.zzh(this.zza.zzg());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i11 != 5) {
                throw zzhag.zza();
            }
            do {
                zzgzvVar.zzh(this.zza.zzg());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int iZzn2 = this.zza.zzn();
                zzT(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i12 != 5) {
                throw zzhag.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }
}
