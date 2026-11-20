package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class StaticLayoutBuilderCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f36952n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f36953o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public static Constructor<StaticLayout> f36954p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public static Object f36955q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f36956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f36957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36958c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36960e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f36967l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36959d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Layout.Alignment f36961f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36962g = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36963h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f36964i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36965j = f36952n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f36966k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public TextUtils.TruncateAt f36968m = null;

    /* JADX INFO: compiled from: source.java */
    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable th2) {
            super("Error thrown initializing StaticLayout " + th2.getMessage(), th2);
        }
    }

    static {
        f36952n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i11) {
        this.f36956a = charSequence;
        this.f36957b = textPaint;
        this.f36958c = i11;
        this.f36960e = charSequence.length();
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, int i11) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i11);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.f36956a == null) {
            this.f36956a = "";
        }
        int iMax = Math.max(0, this.f36958c);
        CharSequence charSequenceEllipsize = this.f36956a;
        if (this.f36962g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f36957b, iMax, this.f36968m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f36960e);
        this.f36960e = iMin;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) androidx.core.util.i.g(f36954p)).newInstance(charSequenceEllipsize, Integer.valueOf(this.f36959d), Integer.valueOf(this.f36960e), this.f36957b, Integer.valueOf(iMax), this.f36961f, androidx.core.util.i.g(f36955q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f36966k), null, Integer.valueOf(iMax), Integer.valueOf(this.f36962g));
            } catch (Exception e11) {
                throw new StaticLayoutBuilderCompatException(e11);
            }
        }
        if (this.f36967l && this.f36962g == 1) {
            this.f36961f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f36959d, iMin, this.f36957b, iMax);
        builderObtain.setAlignment(this.f36961f);
        builderObtain.setIncludePad(this.f36966k);
        builderObtain.setTextDirection(this.f36967l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f36968m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f36962g);
        float f11 = this.f36963h;
        if (f11 != 0.0f || this.f36964i != 1.0f) {
            builderObtain.setLineSpacing(f11, this.f36964i);
        }
        if (this.f36962g > 1) {
            builderObtain.setHyphenationFrequency(this.f36965j);
        }
        return builderObtain.build();
    }

    public final void b() throws StaticLayoutBuilderCompatException {
        if (f36953o) {
            return;
        }
        try {
            f36955q = this.f36967l && Build.VERSION.SDK_INT >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f36954p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f36953o = true;
        } catch (Exception e11) {
            throw new StaticLayoutBuilderCompatException(e11);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.f36961f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f36968m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(int i11) {
        this.f36965j = i11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(boolean z11) {
        this.f36966k = z11;
        return this;
    }

    public StaticLayoutBuilderCompat h(boolean z11) {
        this.f36967l = z11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(float f11, float f12) {
        this.f36963h = f11;
        this.f36964i = f12;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(int i11) {
        this.f36962g = i11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat k(@Nullable x xVar) {
        return this;
    }
}
