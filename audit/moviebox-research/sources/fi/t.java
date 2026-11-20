package fi;

import androidx.annotation.Nullable;
import java.util.List;
import nh.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f65044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final Object f65045i;

    public t(i0 i0Var, int i11, int i12) {
        this(i0Var, i11, i12, 0, null);
    }

    public t(i0 i0Var, int i11, int i12, int i13, @Nullable Object obj) {
        super(i0Var, new int[]{i11}, i12);
        this.f65044h = i13;
        this.f65045i = obj;
    }

    @Override // fi.s
    public void d(long j11, long j12, long j13, List<? extends ph.n> list, ph.o[] oVarArr) {
    }

    @Override // fi.s
    public int getSelectedIndex() {
        return 0;
    }

    @Override // fi.s
    @Nullable
    public Object getSelectionData() {
        return this.f65045i;
    }

    @Override // fi.s
    public int getSelectionReason() {
        return this.f65044h;
    }
}
