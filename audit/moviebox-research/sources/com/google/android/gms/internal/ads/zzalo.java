package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzalo {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;

    @Nullable
    public final zzalu zzf;
    public final String zzg;

    @Nullable
    public final String zzh;

    @Nullable
    public final zzalo zzi;

    @Nullable
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    private zzalo(@Nullable String str, @Nullable String str2, long j11, long j12, @Nullable zzalu zzaluVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable zzalo zzaloVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzaluVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j11;
        this.zze = j12;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzaloVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }

    public static zzalo zzb(@Nullable String str, long j11, long j12, @Nullable zzalu zzaluVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable zzalo zzaloVar) {
        return new zzalo(str, null, j11, j12, zzaluVar, strArr, str2, str3, zzaloVar);
    }

    public static zzalo zzc(String str) {
        return new zzalo(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzea zzeaVar = new zzea();
            zzeaVar.zzl(new SpannableStringBuilder());
            map.put(str, zzeaVar);
        }
        CharSequence charSequenceZzq = ((zzea) map.get(str)).zzq();
        charSequenceZzq.getClass();
        return (SpannableStringBuilder) charSequenceZzq;
    }

    private final void zzj(TreeSet treeSet, boolean z11) {
        String str = this.zza;
        boolean zEquals = TtmlNode.TAG_P.equals(str);
        boolean zEquals2 = TtmlNode.TAG_DIV.equals(str);
        if (z11 || zEquals || (zEquals2 && this.zzh != null)) {
            long j11 = this.zzd;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.zze;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.zzm != null) {
            for (int i11 = 0; i11 < this.zzm.size(); i11++) {
                zzalo zzaloVar = (zzalo) this.zzm.get(i11);
                boolean z12 = true;
                if (!z11 && !zEquals) {
                    z12 = false;
                }
                zzaloVar.zzj(treeSet, z12);
            }
        }
    }

    private final void zzk(long j11, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (zzg(j11) && TtmlNode.TAG_DIV.equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i11 = 0; i11 < zza(); i11++) {
            zzd(i11).zzk(j11, str, list);
        }
    }

    private final void zzl(long j11, Map map, Map map2, String str, Map map3) {
        zzalo zzaloVar;
        int i11;
        int iZzf;
        zzalu zzaluVarZza;
        int i12;
        if (zzg(j11)) {
            String str2 = !"".equals(this.zzg) ? this.zzg : str;
            for (Map.Entry entry : this.zzl.entrySet()) {
                String str3 = (String) entry.getKey();
                int iIntValue = this.zzk.containsKey(str3) ? ((Integer) this.zzk.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    zzea zzeaVar = (zzea) map3.get(str3);
                    zzeaVar.getClass();
                    zzals zzalsVar = (zzals) map2.get(str2);
                    zzalsVar.getClass();
                    zzalu zzaluVarZza2 = zzalt.zza(this.zzf, this.zzj, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzeaVar.zzq();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzeaVar.zzl(spannableStringBuilder);
                    }
                    if (zzaluVarZza2 != null) {
                        zzalo zzaloVar2 = this.zzi;
                        if (zzaluVarZza2.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zzaluVarZza2.zzh()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzI()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzJ()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzH()) {
                            zzei.zza(spannableStringBuilder, new ForegroundColorSpan(zzaluVarZza2.zzd()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzG()) {
                            zzei.zza(spannableStringBuilder, new BackgroundColorSpan(zzaluVarZza2.zzc()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzD() != null) {
                            zzei.zza(spannableStringBuilder, new TypefaceSpan(zzaluVarZza2.zzD()), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzk() != null) {
                            zzaln zzalnVarZzk = zzaluVarZza2.zzk();
                            zzalnVarZzk.getClass();
                            int i13 = zzalnVarZzk.zza;
                            if (i13 == -1) {
                                int i14 = zzalsVar.zzj;
                                i13 = (i14 == 2 || i14 == 1) ? 3 : 1;
                                i12 = 1;
                            } else {
                                i12 = zzalnVarZzk.zzb;
                            }
                            int i15 = zzalnVarZzk.zzc;
                            if (i15 == -2) {
                                i15 = 1;
                            }
                            zzei.zza(spannableStringBuilder, new zzej(i13, i12, i15), iIntValue, iIntValue2, 33);
                        }
                        int iZzg = zzaluVarZza2.zzg();
                        if (iZzg == 2) {
                            while (true) {
                                if (zzaloVar2 == null) {
                                    zzaloVar2 = null;
                                    break;
                                }
                                zzalu zzaluVarZza3 = zzalt.zza(zzaloVar2.zzf, zzaloVar2.zzj, map);
                                if (zzaluVarZza3 != null && zzaluVarZza3.zzg() == 1) {
                                    break;
                                } else {
                                    zzaloVar2 = zzaloVar2.zzi;
                                }
                            }
                            if (zzaloVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzaloVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzaloVar = null;
                                        break;
                                    }
                                    zzalo zzaloVar3 = (zzalo) arrayDeque.pop();
                                    zzalu zzaluVarZza4 = zzalt.zza(zzaloVar3.zzf, zzaloVar3.zzj, map);
                                    if (zzaluVarZza4 != null && zzaluVarZza4.zzg() == 3) {
                                        zzaloVar = zzaloVar3;
                                        break;
                                    }
                                    for (int iZza = zzaloVar3.zza() - 1; iZza >= 0; iZza--) {
                                        arrayDeque.push(zzaloVar3.zzd(iZza));
                                    }
                                }
                                if (zzaloVar != null) {
                                    if (zzaloVar.zza() != 1 || zzaloVar.zzd(0).zzb == null) {
                                        zzff.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str4 = zzaloVar.zzd(0).zzb;
                                        int i16 = zzfy.zza;
                                        zzalu zzaluVarZza5 = zzalt.zza(zzaloVar.zzf, zzaloVar.zzj, map);
                                        if (zzaluVarZza5 != null) {
                                            iZzf = zzaluVarZza5.zzf();
                                            i11 = -1;
                                        } else {
                                            i11 = -1;
                                            iZzf = -1;
                                        }
                                        if (iZzf == i11 && (zzaluVarZza = zzalt.zza(zzaloVar2.zzf, zzaloVar2.zzj, map)) != null) {
                                            iZzf = zzaluVarZza.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzeh(str4, iZzf), iIntValue, iIntValue2, 33);
                                    }
                                }
                            }
                        } else if (iZzg == 3 || iZzg == 4) {
                            spannableStringBuilder.setSpan(new zzalm(), iIntValue, iIntValue2, 33);
                        }
                        if (zzaluVarZza2.zzF()) {
                            zzei.zza(spannableStringBuilder, new zzeg(), iIntValue, iIntValue2, 33);
                        }
                        int iZze = zzaluVarZza2.zze();
                        if (iZze == 1) {
                            zzei.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzaluVarZza2.zza(), true), iIntValue, iIntValue2, 33);
                        } else if (iZze == 2) {
                            zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zzaluVarZza2.zza()), iIntValue, iIntValue2, 33);
                        } else if (iZze == 3) {
                            zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zzaluVarZza2.zza() / 100.0f), iIntValue, iIntValue2, 33);
                        }
                        if (TtmlNode.TAG_P.equals(this.zza)) {
                            if (zzaluVarZza2.zzb() != Float.MAX_VALUE) {
                                zzeaVar.zzj((zzaluVarZza2.zzb() * (-90.0f)) / 100.0f);
                            }
                            if (zzaluVarZza2.zzj() != null) {
                                zzeaVar.zzm(zzaluVarZza2.zzj());
                            }
                            if (zzaluVarZza2.zzi() != null) {
                                zzeaVar.zzg(zzaluVarZza2.zzi());
                            }
                        }
                    }
                }
            }
            for (int i17 = 0; i17 < zza(); i17++) {
                zzd(i17).zzl(j11, map, map2, str2, map3);
            }
        }
    }

    private final void zzm(long j11, boolean z11, String str, Map map) {
        this.zzk.clear();
        this.zzl.clear();
        if (TtmlNode.TAG_METADATA.equals(this.zza)) {
            return;
        }
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (this.zzc && z11) {
            SpannableStringBuilder spannableStringBuilderZzi = zzi(str, map);
            String str2 = this.zzb;
            str2.getClass();
            spannableStringBuilderZzi.append((CharSequence) str2);
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.zza) && z11) {
            zzi(str, map).append('\n');
            return;
        }
        if (zzg(j11)) {
            for (Map.Entry entry : map.entrySet()) {
                HashMap map2 = this.zzk;
                String str3 = (String) entry.getKey();
                CharSequence charSequenceZzq = ((zzea) entry.getValue()).zzq();
                charSequenceZzq.getClass();
                map2.put(str3, Integer.valueOf(charSequenceZzq.length()));
            }
            boolean zEquals = TtmlNode.TAG_P.equals(this.zza);
            for (int i11 = 0; i11 < zza(); i11++) {
                zzd(i11).zzm(j11, z11 || zEquals, str, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzi2 = zzi(str, map);
                int length = spannableStringBuilderZzi2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzi2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzi2.charAt(length) != '\n') {
                    spannableStringBuilderZzi2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                HashMap map3 = this.zzl;
                String str4 = (String) entry2.getKey();
                CharSequence charSequenceZzq2 = ((zzea) entry2.getValue()).zzq();
                charSequenceZzq2.getClass();
                map3.put(str4, Integer.valueOf(charSequenceZzq2.length()));
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzalo zzd(int i11) {
        List list = this.zzm;
        if (list != null) {
            return (zzalo) list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j11, Map map, Map map2, Map map3) {
        List arrayList = new ArrayList();
        zzk(j11, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        zzm(j11, false, this.zzg, treeMap);
        zzl(j11, map, map2, this.zzg, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            Pair pair = (Pair) arrayList.get(i11);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzals zzalsVar = (zzals) map2.get(pair.first);
                zzalsVar.getClass();
                zzea zzeaVar = new zzea();
                zzeaVar.zzc(bitmapDecodeByteArray);
                zzeaVar.zzh(zzalsVar.zzb);
                zzeaVar.zzi(0);
                zzeaVar.zze(zzalsVar.zzc, 0);
                zzeaVar.zzf(zzalsVar.zze);
                zzeaVar.zzk(zzalsVar.zzf);
                zzeaVar.zzd(zzalsVar.zzg);
                zzeaVar.zzo(zzalsVar.zzj);
                arrayList2.add(zzeaVar.zzp());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzals zzalsVar2 = (zzals) map2.get(entry.getKey());
            zzalsVar2.getClass();
            zzea zzeaVar2 = (zzea) entry.getValue();
            CharSequence charSequenceZzq = zzeaVar2.zzq();
            charSequenceZzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzq;
            for (zzalm zzalmVar : (zzalm[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzalm.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzalmVar), spannableStringBuilder.getSpanEnd(zzalmVar), (CharSequence) "");
            }
            int i12 = 0;
            while (i12 < spannableStringBuilder.length()) {
                int i13 = i12 + 1;
                if (spannableStringBuilder.charAt(i12) == ' ') {
                    int i14 = i13;
                    while (i14 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i14) == ' ') {
                        i14++;
                    }
                    int i15 = i14 - i13;
                    if (i15 > 0) {
                        spannableStringBuilder.delete(i12, i15 + i12);
                    }
                }
                i12 = i13;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i16 = 0;
            while (i16 < spannableStringBuilder.length() - 1) {
                int i17 = i16 + 1;
                if (spannableStringBuilder.charAt(i16) == '\n' && spannableStringBuilder.charAt(i17) == ' ') {
                    spannableStringBuilder.delete(i17, i16 + 2);
                }
                i16 = i17;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i18 = 0;
            while (i18 < spannableStringBuilder.length() - 1) {
                int i19 = i18 + 1;
                if (spannableStringBuilder.charAt(i18) == ' ' && spannableStringBuilder.charAt(i19) == '\n') {
                    spannableStringBuilder.delete(i18, i19);
                }
                i18 = i19;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzeaVar2.zze(zzalsVar2.zzc, zzalsVar2.zzd);
            zzeaVar2.zzf(zzalsVar2.zze);
            zzeaVar2.zzh(zzalsVar2.zzb);
            zzeaVar2.zzk(zzalsVar2.zzf);
            zzeaVar2.zzn(zzalsVar2.zzi, zzalsVar2.zzh);
            zzeaVar2.zzo(zzalsVar2.zzj);
            arrayList2.add(zzeaVar2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzalo zzaloVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzaloVar);
    }

    public final boolean zzg(long j11) {
        long j12 = this.zzd;
        if (j12 == C.TIME_UNSET) {
            if (this.zze == C.TIME_UNSET) {
                return true;
            }
            j12 = -9223372036854775807L;
        }
        if (j12 <= j11 && this.zze == C.TIME_UNSET) {
            return true;
        }
        if (j12 != C.TIME_UNSET || j11 >= this.zze) {
            return j12 <= j11 && j11 < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i11 = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i11] = ((Long) it.next()).longValue();
            i11++;
        }
        return jArr;
    }
}
