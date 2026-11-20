package p4;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements d {
    @Override // p4.d
    public androidx.media3.exoplayer.source.t a(List<? extends androidx.media3.exoplayer.source.t> list, List<List<Integer>> list2) {
        return new c(list, list2);
    }

    @Override // p4.d
    public androidx.media3.exoplayer.source.t b() {
        return new c(ImmutableList.of(), ImmutableList.of());
    }
}
