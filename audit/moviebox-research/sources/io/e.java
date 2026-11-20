package io;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f67267a;

    static {
        f67267a = Build.VERSION.SDK_INT >= 33 ? new i0() : new l0();
    }

    public e() {
    }

    public /* synthetic */ e(int i11) {
        this();
    }

    public static Runnable b(@NonNull Object obj, Runnable runnable) {
        e eVar = f67267a;
        Objects.requireNonNull(obj);
        return eVar.a(obj, runnable);
    }

    public abstract Runnable a(Object obj, Runnable runnable);
}
