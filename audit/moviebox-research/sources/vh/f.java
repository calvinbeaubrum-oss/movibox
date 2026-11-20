package vh;

import android.os.Bundle;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f78852b = new f(ImmutableList.of());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<f> f78853c = new com.google.android.exoplayer2.g.a() { // from class: vh.e
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return f.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<b> f78854a;

    public f(List<b> list) {
        this.f78854a = ImmutableList.copyOf((Collection) list);
    }

    public static ImmutableList<b> b(List<b> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11).f78821d == null) {
                aVarBuilder.a(list.get(i11));
            }
        }
        return aVarBuilder.m();
    }

    public static final f c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return new f(parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(b.f78817t, parcelableArrayList));
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(b(this.f78854a)));
        return bundle;
    }
}
