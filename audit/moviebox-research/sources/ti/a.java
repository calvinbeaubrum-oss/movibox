package ti;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R$attr;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<V extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TimeInterpolator f77195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final V f77196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f77198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f77199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public androidx.activity.b f77200f;

    public a(@NonNull V v11) {
        this.f77196b = v11;
        Context context = v11.getContext();
        this.f77195a = j.g(context, R$attr.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.f77197c = j.f(context, R$attr.motionDurationMedium2, LogSeverity.NOTICE_VALUE);
        this.f77198d = j.f(context, R$attr.motionDurationShort3, 150);
        this.f77199e = j.f(context, R$attr.motionDurationShort2, 100);
    }

    public float a(float f11) {
        return this.f77195a.getInterpolation(f11);
    }

    @Nullable
    public androidx.activity.b b() {
        if (this.f77200f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = this.f77200f;
        this.f77200f = null;
        return bVar;
    }

    @Nullable
    public androidx.activity.b c() {
        androidx.activity.b bVar = this.f77200f;
        this.f77200f = null;
        return bVar;
    }

    public void d(@NonNull androidx.activity.b bVar) {
        this.f77200f = bVar;
    }

    @Nullable
    public androidx.activity.b e(@NonNull androidx.activity.b bVar) {
        if (this.f77200f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = this.f77200f;
        this.f77200f = bVar;
        return bVar2;
    }
}
