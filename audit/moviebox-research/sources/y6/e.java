package y6;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends g<c7.d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c7.d f81255i;

    public e(List<h7.a<c7.d>> list) {
        super(list);
        int iMax = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            c7.d dVar = list.get(i11).f66350b;
            if (dVar != null) {
                iMax = Math.max(iMax, dVar.f());
            }
        }
        this.f81255i = new c7.d(new float[iMax], new int[iMax]);
    }

    @Override // y6.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public c7.d i(h7.a<c7.d> aVar, float f11) {
        this.f81255i.g(aVar.f66350b, aVar.f66351c, f11);
        return this.f81255i;
    }
}
