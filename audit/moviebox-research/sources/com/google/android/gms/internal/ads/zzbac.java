package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbac {
    private final zzazr zza;
    private final int zzb;
    private String zzc;
    private final int zzd;

    public zzbac(int i11, int i12, int i13) {
        this.zzb = i11;
        i12 = (i12 > 64 || i12 < 0) ? 64 : i12;
        if (i13 <= 0) {
            this.zzd = 1;
        } else {
            this.zzd = i13;
        }
        this.zza = new zzbaa(i12);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0094  */
    public final String zza(ArrayList arrayList, ArrayList arrayList2) {
        Collections.sort(arrayList2, new zzbab(this));
        HashSet hashSet = new HashSet();
        loop0: for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            String[] strArrSplit = Normalizer.normalize((CharSequence) arrayList.get(((zzazq) arrayList2.get(i11)).zze()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
            if (strArrSplit.length != 0) {
                for (String str : strArrSplit) {
                    if (str.contains("'")) {
                        StringBuilder sb2 = new StringBuilder(str);
                        int i12 = 1;
                        boolean z11 = false;
                        while (true) {
                            int i13 = i12 + 2;
                            if (i13 > sb2.length()) {
                                break;
                            }
                            if (sb2.charAt(i12) == '\'') {
                                if (sb2.charAt(i12 - 1) != ' ') {
                                    int i14 = i12 + 1;
                                    if ((sb2.charAt(i14) == 's' || sb2.charAt(i14) == 'S') && (i13 == sb2.length() || sb2.charAt(i13) == ' ')) {
                                        sb2.insert(i12, ' ');
                                        i12 = i13;
                                    } else {
                                        sb2.setCharAt(i12, ' ');
                                    }
                                } else {
                                    sb2.setCharAt(i12, ' ');
                                }
                                z11 = true;
                            }
                            i12++;
                        }
                        String string = z11 ? sb2.toString() : null;
                        if (string != null) {
                            this.zzc = string;
                            str = string;
                        }
                    }
                    String[] strArrZzb = zzazv.zzb(str, true);
                    if (strArrZzb.length >= this.zzd) {
                        for (int i15 = 0; i15 < strArrZzb.length; i15++) {
                            String strConcat = "";
                            for (int i16 = 0; i16 < this.zzd; i16++) {
                                int i17 = i15 + i16;
                                if (i17 >= strArrZzb.length) {
                                    break;
                                }
                                if (i16 > 0) {
                                    strConcat = strConcat.concat(" ");
                                }
                                strConcat = strConcat.concat(String.valueOf(strArrZzb[i17]));
                            }
                            hashSet.add(strConcat);
                            if (hashSet.size() >= this.zzb) {
                                break loop0;
                            }
                        }
                        if (hashSet.size() >= this.zzb) {
                            break loop0;
                        }
                    }
                }
            }
        }
        zzazt zzaztVar = new zzazt();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                zzaztVar.zzb.write(this.zza.zzb((String) it.next()));
            } catch (IOException e11) {
                zzcec.zzh("Error while writing hash to byteStream", e11);
            }
        }
        return zzaztVar.toString();
    }
}
