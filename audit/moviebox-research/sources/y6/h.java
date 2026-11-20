package y6;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<c7.i, Path>> f81256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<Integer, Integer>> f81257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Mask> f81258c;

    public h(List<Mask> list) {
        this.f81258c = list;
        this.f81256a = new ArrayList(list.size());
        this.f81257b = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f81256a.add(list.get(i11).b().a());
            this.f81257b.add(list.get(i11).c().a());
        }
    }

    public List<a<c7.i, Path>> a() {
        return this.f81256a;
    }

    public List<Mask> b() {
        return this.f81258c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f81257b;
    }
}
