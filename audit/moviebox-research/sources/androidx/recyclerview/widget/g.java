package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12664e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12668i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12660a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12665f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12666g = 0;

    public boolean a(RecyclerView.x xVar) {
        int i11 = this.f12662c;
        return i11 >= 0 && i11 < xVar.b();
    }

    public View b(RecyclerView.t tVar) {
        View viewO = tVar.o(this.f12662c);
        this.f12662c += this.f12663d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f12661b + ", mCurrentPosition=" + this.f12662c + ", mItemDirection=" + this.f12663d + ", mLayoutDirection=" + this.f12664e + ", mStartLine=" + this.f12665f + ", mEndLine=" + this.f12666g + '}';
    }
}
