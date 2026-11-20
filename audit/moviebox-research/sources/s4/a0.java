package s4;

import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f75984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final Object f75985i;

    public a0(n0 n0Var, int i11, int i12) {
        this(n0Var, i11, i12, 0, null);
    }

    public a0(n0 n0Var, int i11, int i12, int i13, @Nullable Object obj) {
        super(n0Var, new int[]{i11}, i12);
        this.f75984h = i13;
        this.f75985i = obj;
    }

    @Override // s4.z
    public int getSelectedIndex() {
        return 0;
    }

    @Override // s4.z
    @Nullable
    public Object getSelectionData() {
        return this.f75985i;
    }

    @Override // s4.z
    public int getSelectionReason() {
        return this.f75984h;
    }

    @Override // s4.z
    public void h(long j11, long j12, long j13, List<? extends q4.m> list, q4.n[] nVarArr) {
    }
}
