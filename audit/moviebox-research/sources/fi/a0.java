package fi;

import android.os.SystemClock;
import com.google.android.exoplayer2.o3;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import nh.i0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a0 {
    public static o3 a(u.a aVar, v[] vVarArr) {
        List[] listArr = new List[vVarArr.length];
        for (int i11 = 0; i11 < vVarArr.length; i11++) {
            v vVar = vVarArr[i11];
            listArr[i11] = vVar != null ? ImmutableList.of(vVar) : ImmutableList.of();
        }
        return b(aVar, listArr);
    }

    public static o3 b(u.a aVar, List<? extends v>[] listArr) {
        boolean z11;
        ImmutableList.a aVar2 = new ImmutableList.a();
        for (int i11 = 0; i11 < aVar.d(); i11++) {
            k0 k0VarF = aVar.f(i11);
            List<? extends v> list = listArr[i11];
            for (int i12 = 0; i12 < k0VarF.f71941a; i12++) {
                i0 i0VarB = k0VarF.b(i12);
                boolean z12 = aVar.a(i11, i12, false) != 0;
                int i13 = i0VarB.f71931a;
                int[] iArr = new int[i13];
                boolean[] zArr = new boolean[i13];
                for (int i14 = 0; i14 < i0VarB.f71931a; i14++) {
                    iArr[i14] = aVar.g(i11, i12, i14);
                    int i15 = 0;
                    while (true) {
                        if (i15 >= list.size()) {
                            z11 = false;
                            break;
                        }
                        v vVar = list.get(i15);
                        if (vVar.getTrackGroup().equals(i0VarB) && vVar.indexOf(i14) != -1) {
                            z11 = true;
                            break;
                        }
                        i15++;
                    }
                    zArr[i14] = z11;
                }
                aVar2.a(new o3.a(i0VarB, z12, iArr, zArr));
            }
        }
        k0 k0VarH = aVar.h();
        for (int i16 = 0; i16 < k0VarH.f71941a; i16++) {
            i0 i0VarB2 = k0VarH.b(i16);
            int[] iArr2 = new int[i0VarB2.f71931a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new o3.a(i0VarB2, false, iArr2, new boolean[i0VarB2.f71931a]));
        }
        return new o3(aVar2.m());
    }

    public static com.google.android.exoplayer2.upstream.z.a c(s sVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (sVar.e(i12, jElapsedRealtime)) {
                i11++;
            }
        }
        return new com.google.android.exoplayer2.upstream.z.a(1, 0, length, i11);
    }
}
