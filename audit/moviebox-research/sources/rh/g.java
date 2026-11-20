package rh;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f75429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f75430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f75431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f75432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final e f75433e;

    public g(@Nullable String str, long j11, List<a> list, List<f> list2) {
        this(str, j11, list, list2, null);
    }

    public g(@Nullable String str, long j11, List<a> list, List<f> list2, @Nullable e eVar) {
        this.f75429a = str;
        this.f75430b = j11;
        this.f75431c = Collections.unmodifiableList(list);
        this.f75432d = Collections.unmodifiableList(list2);
        this.f75433e = eVar;
    }

    public int a(int i11) {
        int size = this.f75431c.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.f75431c.get(i12).f75385b == i11) {
                return i12;
            }
        }
        return -1;
    }
}
