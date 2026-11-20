package vi;

import android.graphics.Typeface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f78892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0876a f78893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78894c;

    /* JADX INFO: renamed from: vi.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0876a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0876a interfaceC0876a, Typeface typeface) {
        this.f78892a = typeface;
        this.f78893b = interfaceC0876a;
    }

    @Override // vi.g
    public void a(int i11) {
        d(this.f78892a);
    }

    @Override // vi.g
    public void b(Typeface typeface, boolean z11) {
        d(typeface);
    }

    public void c() {
        this.f78894c = true;
    }

    public final void d(Typeface typeface) {
        if (this.f78894c) {
            return;
        }
        this.f78893b.a(typeface);
    }
}
