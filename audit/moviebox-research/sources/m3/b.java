package m3;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f70721a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f70722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static Class<?> f70723c;

    @SuppressLint({"PrivateApi"})
    public b() {
        try {
            f70723c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f70722b == null) {
            synchronized (f70721a) {
                try {
                    if (f70722b == null) {
                        f70722b = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f70722b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = f70723c;
        return cls != null ? n.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
