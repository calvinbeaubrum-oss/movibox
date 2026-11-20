package h4;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f66287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f66289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f66290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final e f66291e;

    public g(@Nullable String str, long j11, List<a> list, List<f> list2) {
        this(str, j11, list, list2, null);
    }

    public g(@Nullable String str, long j11, List<a> list, List<f> list2, @Nullable e eVar) {
        this.f66287a = str;
        this.f66288b = j11;
        this.f66289c = Collections.unmodifiableList(list);
        this.f66290d = Collections.unmodifiableList(list2);
        this.f66291e = eVar;
    }

    public int a(int i11) {
        int size = this.f66289c.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.f66289c.get(i12).f66243b == i11) {
                return i12;
            }
        }
        return -1;
    }
}
