package e4;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x3 f64017b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f64018a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f64019b = new a(LogSessionId.LOG_SESSION_ID_NONE);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LogSessionId f64020a;

        public a(LogSessionId logSessionId) {
            this.f64020a = logSessionId;
        }
    }

    static {
        f64017b = z3.u0.f81838a < 31 ? new x3() : new x3(a.f64019b);
    }

    public x3() {
        z3.a.g(z3.u0.f81838a < 31);
        this.f64018a = null;
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public x3(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    public x3(a aVar) {
        this.f64018a = aVar;
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public LogSessionId a() {
        return ((a) z3.a.e(this.f64018a)).f64020a;
    }
}
