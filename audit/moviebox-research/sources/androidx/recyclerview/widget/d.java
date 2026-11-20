package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f12639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12640b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12641c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12642d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f12643f = null;

    public d(@NonNull j jVar) {
        this.f12639a = jVar;
    }

    public void a() {
        int i11 = this.f12640b;
        if (i11 == 0) {
            return;
        }
        if (i11 == 1) {
            this.f12639a.onInserted(this.f12641c, this.f12642d);
        } else if (i11 == 2) {
            this.f12639a.onRemoved(this.f12641c, this.f12642d);
        } else if (i11 == 3) {
            this.f12639a.onChanged(this.f12641c, this.f12642d, this.f12643f);
        }
        this.f12643f = null;
        this.f12640b = 0;
    }

    @Override // androidx.recyclerview.widget.j
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i11, int i12, Object obj) {
        int i13;
        if (this.f12640b == 3) {
            int i14 = this.f12641c;
            int i15 = this.f12642d;
            if (i11 <= i14 + i15 && (i13 = i11 + i12) >= i14 && this.f12643f == obj) {
                this.f12641c = Math.min(i11, i14);
                this.f12642d = Math.max(i15 + i14, i13) - this.f12641c;
                return;
            }
        }
        a();
        this.f12641c = i11;
        this.f12642d = i12;
        this.f12643f = obj;
        this.f12640b = 3;
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i11, int i12) {
        int i13;
        if (this.f12640b == 1 && i11 >= (i13 = this.f12641c)) {
            int i14 = this.f12642d;
            if (i11 <= i13 + i14) {
                this.f12642d = i14 + i12;
                this.f12641c = Math.min(i11, i13);
                return;
            }
        }
        a();
        this.f12641c = i11;
        this.f12642d = i12;
        this.f12640b = 1;
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i11, int i12) {
        a();
        this.f12639a.onMoved(i11, i12);
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i11, int i12) {
        int i13;
        if (this.f12640b == 2 && (i13 = this.f12641c) >= i11 && i13 <= i11 + i12) {
            this.f12642d += i12;
            this.f12641c = i11;
        } else {
            a();
            this.f12641c = i11;
            this.f12642d = i12;
            this.f12640b = 2;
        }
    }
}
