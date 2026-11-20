package androidx.media3.exoplayer.audio;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f9936d = new C0094b().d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9939c;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.audio.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0094b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9942c;

        public b d() {
            if (this.f9940a || !(this.f9941b || this.f9942c)) {
                return new b(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public C0094b e(boolean z11) {
            this.f9940a = z11;
            return this;
        }

        public C0094b f(boolean z11) {
            this.f9941b = z11;
            return this;
        }

        public C0094b g(boolean z11) {
            this.f9942c = z11;
            return this;
        }
    }

    public b(C0094b c0094b) {
        this.f9937a = c0094b.f9940a;
        this.f9938b = c0094b.f9941b;
        this.f9939c = c0094b.f9942c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9937a == bVar.f9937a && this.f9938b == bVar.f9938b && this.f9939c == bVar.f9939c;
    }

    public int hashCode() {
        return ((this.f9937a ? 1 : 0) << 2) + ((this.f9938b ? 1 : 0) << 1) + (this.f9939c ? 1 : 0);
    }
}
