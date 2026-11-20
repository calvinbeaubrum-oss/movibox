package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzalt {
    @Nullable
    public static zzalu zza(@Nullable zzalu zzaluVar, @Nullable String[] strArr, Map map) {
        int length;
        int i11 = 0;
        if (zzaluVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzalu) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzalu zzaluVar2 = new zzalu();
                while (i11 < length2) {
                    zzaluVar2.zzl((zzalu) map.get(strArr[i11]));
                    i11++;
                }
                return zzaluVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzaluVar.zzl((zzalu) map.get(strArr[0]));
                return zzaluVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i11 < length) {
                    zzaluVar.zzl((zzalu) map.get(strArr[i11]));
                    i11++;
                }
            }
        }
        return zzaluVar;
    }
}
