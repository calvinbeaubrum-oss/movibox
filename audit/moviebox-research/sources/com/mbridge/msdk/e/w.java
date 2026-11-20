package com.mbridge.msdk.e;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f43955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f43956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f43958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f43959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f43960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f43961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v f43962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f43963j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private o f43967d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private d f43971h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private v f43972i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private f f43973j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f43964a = 50;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f43965b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f43966c = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f43968e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f43969f = 50;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f43970g = 604800000;

        public final a a(int i11) {
            if (i11 <= 0) {
                this.f43964a = 50;
            } else {
                this.f43964a = i11;
            }
            return this;
        }

        public final a a(int i11, o oVar) {
            this.f43966c = i11;
            this.f43967d = oVar;
            return this;
        }

        public final a a(d dVar) {
            this.f43971h = dVar;
            return this;
        }

        public final a a(f fVar) {
            this.f43973j = fVar;
            return this;
        }

        public final a a(v vVar) {
            this.f43972i = vVar;
            return this;
        }

        public final w a() {
            if (y.a(this.f43971h) && com.mbridge.msdk.e.a.f43738a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.a(this.f43972i) && com.mbridge.msdk.e.a.f43738a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.a(this.f43967d) || y.a(this.f43967d.c())) && com.mbridge.msdk.e.a.f43738a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new w(this);
        }

        public final a b(int i11) {
            if (i11 < 0) {
                this.f43965b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
            } else {
                this.f43965b = i11;
            }
            return this;
        }

        public final a c(int i11) {
            if (i11 <= 0) {
                this.f43968e = 2;
            } else {
                this.f43968e = i11;
            }
            return this;
        }

        public final a d(int i11) {
            if (i11 < 0) {
                this.f43969f = 50;
            } else {
                this.f43969f = i11;
            }
            return this;
        }

        public final a e(int i11) {
            if (i11 < 0) {
                this.f43970g = 604800000;
            } else {
                this.f43970g = i11;
            }
            return this;
        }
    }

    private w(a aVar) {
        this.f43954a = aVar.f43964a;
        this.f43955b = aVar.f43965b;
        this.f43956c = aVar.f43966c;
        this.f43957d = aVar.f43968e;
        this.f43958e = aVar.f43969f;
        this.f43959f = aVar.f43970g;
        this.f43960g = aVar.f43967d;
        this.f43961h = aVar.f43971h;
        this.f43962i = aVar.f43972i;
        this.f43963j = aVar.f43973j;
    }
}
