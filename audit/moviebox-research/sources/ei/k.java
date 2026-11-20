package ei;

import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements vh.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f64266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f64267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f64268c;

    public k(List<e> list) {
        this.f64266a = Collections.unmodifiableList(new ArrayList(list));
        this.f64267b = new long[list.size() * 2];
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = list.get(i11);
            int i12 = i11 * 2;
            long[] jArr = this.f64267b;
            jArr[i12] = eVar.f64237b;
            jArr[i12 + 1] = eVar.f64238c;
        }
        long[] jArr2 = this.f64267b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f64268c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public static /* synthetic */ int b(e eVar, e eVar2) {
        return Long.compare(eVar.f64237b, eVar2.f64237b);
    }

    @Override // vh.i
    public List<vh.b> getCues(long j11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < this.f64266a.size(); i11++) {
            long[] jArr = this.f64267b;
            int i12 = i11 * 2;
            if (jArr[i12] <= j11 && j11 < jArr[i12 + 1]) {
                e eVar = this.f64266a.get(i11);
                vh.b bVar = eVar.f64236a;
                if (bVar.f78822f == -3.4028235E38f) {
                    arrayList2.add(eVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: ei.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k.b((e) obj, (e) obj2);
            }
        });
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            arrayList.add(((e) arrayList2.get(i13)).f64236a.b().h((-1) - i13, 1).a());
        }
        return arrayList;
    }

    @Override // vh.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        com.google.android.exoplayer2.util.a.a(i11 < this.f64268c.length);
        return this.f64268c[i11];
    }

    @Override // vh.i
    public int getEventTimeCount() {
        return this.f64268c.length;
    }

    @Override // vh.i
    public int getNextEventTimeIndex(long j11) {
        int iE = o0.e(this.f64268c, j11, false, false);
        if (iE < this.f64268c.length) {
            return iE;
        }
        return -1;
    }
}
