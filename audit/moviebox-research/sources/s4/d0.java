package s4;

import android.os.SystemClock;
import androidx.media3.common.n0;
import androidx.media3.common.q0;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import p4.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    public static q0 a(b0.a aVar, List<? extends c0>[] listArr) {
        boolean z11;
        ImmutableList.a aVar2 = new ImmutableList.a();
        for (int i11 = 0; i11 < aVar.d(); i11++) {
            k0 k0VarF = aVar.f(i11);
            List<? extends c0> list = listArr[i11];
            for (int i12 = 0; i12 < k0VarF.f73574a; i12++) {
                n0 n0VarB = k0VarF.b(i12);
                boolean z12 = aVar.a(i11, i12, false) != 0;
                int i13 = n0VarB.f9330a;
                int[] iArr = new int[i13];
                boolean[] zArr = new boolean[i13];
                for (int i14 = 0; i14 < n0VarB.f9330a; i14++) {
                    iArr[i14] = aVar.g(i11, i12, i14);
                    int i15 = 0;
                    while (true) {
                        if (i15 >= list.size()) {
                            z11 = false;
                            break;
                        }
                        c0 c0Var = list.get(i15);
                        if (c0Var.getTrackGroup().equals(n0VarB) && c0Var.indexOf(i14) != -1) {
                            z11 = true;
                            break;
                        }
                        i15++;
                    }
                    zArr[i14] = z11;
                }
                aVar2.a(new q0.a(n0VarB, z12, iArr, zArr));
            }
        }
        k0 k0VarH = aVar.h();
        for (int i16 = 0; i16 < k0VarH.f73574a; i16++) {
            n0 n0VarB2 = k0VarH.b(i16);
            int[] iArr2 = new int[n0VarB2.f9330a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new q0.a(n0VarB2, false, iArr2, new boolean[n0VarB2.f9330a]));
        }
        return new q0(aVar2.m());
    }

    public static q0 b(b0.a aVar, c0[] c0VarArr) {
        List[] listArr = new List[c0VarArr.length];
        for (int i11 = 0; i11 < c0VarArr.length; i11++) {
            c0 c0Var = c0VarArr[i11];
            listArr[i11] = c0Var != null ? ImmutableList.of(c0Var) : ImmutableList.of();
        }
        return a(aVar, listArr);
    }

    public static androidx.media3.exoplayer.upstream.m.a c(z zVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = zVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (zVar.d(i12, jElapsedRealtime)) {
                i11++;
            }
        }
        return new androidx.media3.exoplayer.upstream.m.a(1, 0, length, i11);
    }
}
