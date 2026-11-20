package w5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import o5.k;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f79340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f79341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f79342c;

    public j(List<d> list) {
        this.f79340a = Collections.unmodifiableList(new ArrayList(list));
        this.f79341b = new long[list.size() * 2];
        for (int i11 = 0; i11 < list.size(); i11++) {
            d dVar = list.get(i11);
            int i12 = i11 * 2;
            long[] jArr = this.f79341b;
            jArr[i12] = dVar.f79311b;
            jArr[i12 + 1] = dVar.f79312c;
        }
        long[] jArr2 = this.f79341b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f79342c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public static /* synthetic */ int b(d dVar, d dVar2) {
        return Long.compare(dVar.f79311b, dVar2.f79311b);
    }

    @Override // o5.k
    public List<y3.a> getCues(long j11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < this.f79340a.size(); i11++) {
            long[] jArr = this.f79341b;
            int i12 = i11 * 2;
            if (jArr[i12] <= j11 && j11 < jArr[i12 + 1]) {
                d dVar = this.f79340a.get(i11);
                y3.a aVar = dVar.f79310a;
                if (aVar.f81113e == -3.4028235E38f) {
                    arrayList2.add(dVar);
                } else {
                    arrayList.add(aVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: w5.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return j.b((d) obj, (d) obj2);
            }
        });
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            arrayList.add(((d) arrayList2.get(i13)).f79310a.a().h((-1) - i13, 1).a());
        }
        return arrayList;
    }

    @Override // o5.k
    public long getEventTime(int i11) {
        z3.a.a(i11 >= 0);
        z3.a.a(i11 < this.f79342c.length);
        return this.f79342c[i11];
    }

    @Override // o5.k
    public int getEventTimeCount() {
        return this.f79342c.length;
    }

    @Override // o5.k
    public int getNextEventTimeIndex(long j11) {
        int iD = u0.d(this.f79342c, j11, false, false);
        if (iD < this.f79342c.length) {
            return iD;
        }
        return -1;
    }
}
