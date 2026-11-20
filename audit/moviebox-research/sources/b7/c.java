package b7;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends p<c7.d, c7.d> {
    public c(List<h7.a<c7.d>> list) {
        super(e(list));
    }

    public static h7.a<c7.d> d(h7.a<c7.d> aVar) {
        c7.d dVar = aVar.f66350b;
        c7.d dVar2 = aVar.f66351c;
        if (dVar == null || dVar2 == null || dVar.e().length == dVar2.e().length) {
            return aVar;
        }
        float[] fArrF = f(dVar.e(), dVar2.e());
        return aVar.b(dVar.b(fArrF), dVar2.b(fArrF));
    }

    public static List<h7.a<c7.d>> e(List<h7.a<c7.d>> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            list.set(i11, d(list.get(i11)));
        }
        return list;
    }

    public static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f11 = Float.NaN;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            float f12 = fArr3[i12];
            if (f12 != f11) {
                fArr3[i11] = f12;
                i11++;
                f11 = fArr3[i12];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i11);
    }

    @Override // b7.o
    public y6.a<c7.d, c7.d> a() {
        return new y6.e(this.f14060a);
    }

    @Override // b7.p, b7.o
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // b7.p, b7.o
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // b7.p
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
