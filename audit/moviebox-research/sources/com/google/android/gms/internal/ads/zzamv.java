package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamv implements zzaoj {
    private final List zza;

    public zzamv() {
        this(0);
    }

    public zzamv(int i11) {
        this.zza = zzgaa.zzl();
    }

    public zzamv(int i11, List list) {
        this.zza = list;
    }

    private final zzanz zzb(zzaoi zzaoiVar) {
        return new zzanz(zzd(zzaoiVar));
    }

    private final zzaon zzc(zzaoi zzaoiVar) {
        return new zzaon(zzd(zzaoiVar));
    }

    private final List zzd(zzaoi zzaoiVar) {
        String str;
        int i11;
        List listSingletonList;
        zzfp zzfpVar = new zzfp(zzaoiVar.zzd);
        List arrayList = this.zza;
        while (zzfpVar.zzb() > 0) {
            int iZzm = zzfpVar.zzm();
            int iZzd = zzfpVar.zzd() + zzfpVar.zzm();
            if (iZzm == 134) {
                arrayList = new ArrayList();
                int iZzm2 = zzfpVar.zzm() & 31;
                for (int i12 = 0; i12 < iZzm2; i12++) {
                    String strZzA = zzfpVar.zzA(3, zzfwq.zzc);
                    int iZzm3 = zzfpVar.zzm();
                    boolean z11 = (iZzm3 & 128) != 0;
                    if (z11) {
                        i11 = iZzm3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i11 = 1;
                    }
                    byte bZzm = (byte) zzfpVar.zzm();
                    zzfpVar.zzL(1);
                    if (z11) {
                        int i13 = bZzm & 64;
                        int i14 = zzem.zza;
                        listSingletonList = Collections.singletonList(i13 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzak zzakVar = new zzak();
                    zzakVar.zzW(str);
                    zzakVar.zzN(strZzA);
                    zzakVar.zzw(i11);
                    zzakVar.zzL(listSingletonList);
                    arrayList.add(zzakVar.zzac());
                }
            }
            zzfpVar.zzK(iZzd);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    @Nullable
    public final zzaol zza(int i11, zzaoi zzaoiVar) {
        if (i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                return new zzanp(new zzanm(zzaoiVar.zzb));
            }
            if (i11 == 21) {
                return new zzanp(new zzank());
            }
            if (i11 == 27) {
                return new zzanp(new zzanh(zzb(zzaoiVar), false, false));
            }
            if (i11 == 36) {
                return new zzanp(new zzanj(zzb(zzaoiVar)));
            }
            if (i11 == 89) {
                return new zzanp(new zzamx(zzaoiVar.zzc));
            }
            if (i11 == 138) {
                return new zzanp(new zzamw(zzaoiVar.zzb));
            }
            if (i11 == 172) {
                return new zzanp(new zzamr(zzaoiVar.zzb));
            }
            if (i11 == 257) {
                return new zzany(new zzano("application/vnd.dvb.ait"));
            }
            if (i11 != 128) {
                if (i11 != 129) {
                    if (i11 == 134) {
                        return new zzany(new zzano(MimeTypes.APPLICATION_SCTE35));
                    }
                    if (i11 != 135) {
                        switch (i11) {
                            case 15:
                                return new zzanp(new zzamu(false, zzaoiVar.zzb));
                            case 16:
                                return new zzanp(new zzand(zzc(zzaoiVar)));
                            case 17:
                                return new zzanp(new zzanl(zzaoiVar.zzb));
                            default:
                                return null;
                        }
                    }
                }
                return new zzanp(new zzamo(zzaoiVar.zzb));
            }
        }
        return new zzanp(new zzana(zzc(zzaoiVar)));
    }
}
