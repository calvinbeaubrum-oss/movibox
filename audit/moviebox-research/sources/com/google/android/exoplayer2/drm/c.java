package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import qg.u1;
import sg.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f33170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final c f33171b;

    /* JADX INFO: compiled from: source.java */
    public class a implements c {
        @Override // com.google.android.exoplayer2.drm.c
        public int a(m1 m1Var) {
            return m1Var.f33448p != null ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.drm.c
        public void b(Looper looper, u1 u1Var) {
        }

        @Override // com.google.android.exoplayer2.drm.c
        @Nullable
        public DrmSession c(@Nullable com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var) {
            if (m1Var.f33448p == null) {
                return null;
            }
            return new f(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ b d(com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var) {
            return r.a(this, aVar, m1Var);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void prepare() {
            r.b(this);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void release() {
            r.c(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f33172a = new b() { // from class: sg.s
            @Override // com.google.android.exoplayer2.drm.c.b
            public final void release() {
                t.a();
            }
        };

        void release();
    }

    static {
        a aVar = new a();
        f33170a = aVar;
        f33171b = aVar;
    }

    int a(m1 m1Var);

    void b(Looper looper, u1 u1Var);

    @Nullable
    DrmSession c(@Nullable com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var);

    b d(@Nullable com.google.android.exoplayer2.drm.b.a aVar, m1 m1Var);

    void prepare();

    void release();
}
