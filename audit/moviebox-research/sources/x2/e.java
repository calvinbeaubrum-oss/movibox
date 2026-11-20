package x2;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f79850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f79851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f79852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f79853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f79854e;

    public void a(View view) {
        this.f79851b = view.getLeft();
        this.f79852c = view.getTop();
        this.f79853d = view.getRight();
        this.f79854e = view.getBottom();
        this.f79850a = view.getRotation();
    }

    public int b() {
        return this.f79854e - this.f79852c;
    }

    public int c() {
        return this.f79853d - this.f79851b;
    }
}
