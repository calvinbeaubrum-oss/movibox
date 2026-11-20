package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import e4.x3;
import i4.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final c f10293b;

    /* JADX INFO: compiled from: source.java */
    public class a implements c {
        @Override // androidx.media3.exoplayer.drm.c
        public void a(Looper looper, x3 x3Var) {
        }

        @Override // androidx.media3.exoplayer.drm.c
        @Nullable
        public DrmSession b(@Nullable androidx.media3.exoplayer.drm.b.a aVar, y yVar) {
            if (yVar.f9504p == null) {
                return null;
            }
            return new f(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // androidx.media3.exoplayer.drm.c
        public int c(y yVar) {
            return yVar.f9504p != null ? 1 : 0;
        }

        @Override // androidx.media3.exoplayer.drm.c
        public /* synthetic */ b d(androidx.media3.exoplayer.drm.b.a aVar, y yVar) {
            return r.a(this, aVar, yVar);
        }

        @Override // androidx.media3.exoplayer.drm.c
        public /* synthetic */ void prepare() {
            r.b(this);
        }

        @Override // androidx.media3.exoplayer.drm.c
        public /* synthetic */ void release() {
            r.c(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10294a = new b() { // from class: i4.s
            @Override // androidx.media3.exoplayer.drm.c.b
            public final void release() {
                t.a();
            }
        };

        void release();
    }

    static {
        a aVar = new a();
        f10292a = aVar;
        f10293b = aVar;
    }

    void a(Looper looper, x3 x3Var);

    @Nullable
    DrmSession b(@Nullable androidx.media3.exoplayer.drm.b.a aVar, y yVar);

    int c(y yVar);

    b d(@Nullable androidx.media3.exoplayer.drm.b.a aVar, y yVar);

    void prepare();

    void release();
}
