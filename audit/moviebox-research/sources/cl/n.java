package cl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f14970b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f14971c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static n f14972d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gl.a f14973a;

    public n(gl.a aVar) {
        this.f14973a = aVar;
    }

    public static n c() {
        return d(gl.b.a());
    }

    public static n d(gl.a aVar) {
        if (f14972d == null) {
            f14972d = new n(aVar);
        }
        return f14972d;
    }

    public static boolean g(@Nullable String str) {
        return f14971c.matcher(str).matches();
    }

    public static boolean h(@Nullable String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f14973a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(@NonNull com.google.firebase.installations.local.b bVar) {
        return TextUtils.isEmpty(bVar.b()) || bVar.h() + bVar.c() < b() + f14970b;
    }
}
