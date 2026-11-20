package x6;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public class l implements m, j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f80353d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MergePaths f80355f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80350a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f80351b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f80352c = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<m> f80354e = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f80356a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f80356a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f80356a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f80356a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f80356a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f80356a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        this.f80353d = mergePaths.c();
        this.f80355f = mergePaths;
    }

    public final void b() {
        for (int i11 = 0; i11 < this.f80354e.size(); i11++) {
            this.f80352c.addPath(this.f80354e.get(i11).getPath());
        }
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
        for (int i11 = 0; i11 < this.f80354e.size(); i11++) {
            this.f80354e.get(i11).c(list, list2);
        }
    }

    @TargetApi(19)
    public final void d(Path.Op op2) {
        this.f80351b.reset();
        this.f80350a.reset();
        for (int size = this.f80354e.size() - 1; size >= 1; size--) {
            m mVar = this.f80354e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> listK = dVar.k();
                for (int size2 = listK.size() - 1; size2 >= 0; size2--) {
                    Path path = listK.get(size2).getPath();
                    path.transform(dVar.l());
                    this.f80351b.addPath(path);
                }
            } else {
                this.f80351b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.f80354e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> listK2 = dVar2.k();
            for (int i11 = 0; i11 < listK2.size(); i11++) {
                Path path2 = listK2.get(i11).getPath();
                path2.transform(dVar2.l());
                this.f80350a.addPath(path2);
            }
        } else {
            this.f80350a.set(mVar2.getPath());
        }
        this.f80352c.op(this.f80350a, this.f80351b, op2);
    }

    @Override // x6.j
    public void g(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof m) {
                this.f80354e.add((m) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // x6.m
    public Path getPath() {
        this.f80352c.reset();
        if (this.f80355f.d()) {
            return this.f80352c;
        }
        int i11 = a.f80356a[this.f80355f.b().ordinal()];
        if (i11 == 1) {
            b();
        } else if (i11 == 2) {
            d(Path.Op.UNION);
        } else if (i11 == 3) {
            d(Path.Op.REVERSE_DIFFERENCE);
        } else if (i11 == 4) {
            d(Path.Op.INTERSECT);
        } else if (i11 == 5) {
            d(Path.Op.XOR);
        }
        return this.f80352c;
    }
}
