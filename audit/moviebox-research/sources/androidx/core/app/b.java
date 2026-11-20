package androidx.core.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: compiled from: source.java */
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActivityOptions f7706a;

        public a(ActivityOptions activityOptions) {
            this.f7706a = activityOptions;
        }

        @Override // androidx.core.app.b
        public Bundle b() {
            return this.f7706a.toBundle();
        }
    }

    @NonNull
    public static b a(@NonNull Context context, int i11, int i12) {
        return new a(ActivityOptions.makeCustomAnimation(context, i11, i12));
    }

    @Nullable
    public Bundle b() {
        throw null;
    }
}
