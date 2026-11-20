package qg;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u1 f74753b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f74754a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f74755b = new a(LogSessionId.LOG_SESSION_ID_NONE);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LogSessionId f74756a;

        public a(LogSessionId logSessionId) {
            this.f74756a = logSessionId;
        }
    }

    static {
        f74753b = com.google.android.exoplayer2.util.o0.f35608a < 31 ? new u1() : new u1(a.f74755b);
    }

    public u1() {
        this((a) null);
        com.google.android.exoplayer2.util.a.g(com.google.android.exoplayer2.util.o0.f35608a < 31);
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public u1(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    public u1(@Nullable a aVar) {
        this.f74754a = aVar;
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public LogSessionId a() {
        return ((a) com.google.android.exoplayer2.util.a.e(this.f74754a)).f74756a;
    }
}
