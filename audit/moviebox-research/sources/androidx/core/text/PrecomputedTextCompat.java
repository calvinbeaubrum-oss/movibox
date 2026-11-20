package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class PrecomputedTextCompat implements Spannable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f7841f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Spannable f7842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final b f7843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final int[] f7844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final PrecomputedText f7845d;

    /* JADX INFO: compiled from: source.java */
    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        /* JADX INFO: compiled from: source.java */
        public static class a implements Callable<PrecomputedTextCompat> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public b f7846a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public CharSequence f7847b;

            public a(@NonNull b bVar, @NonNull CharSequence charSequence) {
                this.f7846a = bVar;
                this.f7847b = charSequence;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.a(this.f7847b, this.f7846a);
            }
        }

        public PrecomputedTextFutureTask(@NonNull b bVar, @NonNull CharSequence charSequence) {
            super(new a(bVar, charSequence));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class a {
        public static Spannable a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final TextPaint f7848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final TextDirectionHeuristic f7849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f7851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f7852e;

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NonNull
            public final TextPaint f7853a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f7854b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f7855c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f7856d;

            public a(@NonNull TextPaint textPaint) {
                this.f7853a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f7855c = 1;
                    this.f7856d = 1;
                } else {
                    this.f7856d = 0;
                    this.f7855c = 0;
                }
                this.f7854b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public b a() {
                return new b(this.f7853a, this.f7854b, this.f7855c, this.f7856d);
            }

            @RequiresApi(23)
            public a b(int i11) {
                this.f7855c = i11;
                return this;
            }

            @RequiresApi(23)
            public a c(int i11) {
                this.f7856d = i11;
                return this;
            }

            public a d(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f7854b = textDirectionHeuristic;
                return this;
            }
        }

        @RequiresApi(28)
        public b(@NonNull PrecomputedText.Params params) {
            this.f7848a = params.getTextPaint();
            this.f7849b = params.getTextDirection();
            this.f7850c = params.getBreakStrategy();
            this.f7851d = params.getHyphenationFrequency();
            this.f7852e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public b(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i11, int i12) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f7852e = j.a(textPaint).setBreakStrategy(i11).setHyphenationFrequency(i12).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f7852e = null;
            }
            this.f7848a = textPaint;
            this.f7849b = textDirectionHeuristic;
            this.f7850c = i11;
            this.f7851d = i12;
        }

        public boolean a(@NonNull b bVar) {
            int i11 = Build.VERSION.SDK_INT;
            if ((i11 >= 23 && (this.f7850c != bVar.b() || this.f7851d != bVar.c())) || this.f7848a.getTextSize() != bVar.e().getTextSize() || this.f7848a.getTextScaleX() != bVar.e().getTextScaleX() || this.f7848a.getTextSkewX() != bVar.e().getTextSkewX() || this.f7848a.getLetterSpacing() != bVar.e().getLetterSpacing() || !TextUtils.equals(this.f7848a.getFontFeatureSettings(), bVar.e().getFontFeatureSettings()) || this.f7848a.getFlags() != bVar.e().getFlags()) {
                return false;
            }
            if (i11 >= 24) {
                if (!this.f7848a.getTextLocales().equals(bVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f7848a.getTextLocale().equals(bVar.e().getTextLocale())) {
                return false;
            }
            if (this.f7848a.getTypeface() == null) {
                return bVar.e().getTypeface() == null;
            }
            return this.f7848a.getTypeface().equals(bVar.e().getTypeface());
        }

        @RequiresApi(23)
        public int b() {
            return this.f7850c;
        }

        @RequiresApi(23)
        public int c() {
            return this.f7851d;
        }

        @Nullable
        public TextDirectionHeuristic d() {
            return this.f7849b;
        }

        @NonNull
        public TextPaint e() {
            return this.f7848a;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return a(bVar) && this.f7849b == bVar.d();
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? androidx.core.util.d.b(Float.valueOf(this.f7848a.getTextSize()), Float.valueOf(this.f7848a.getTextScaleX()), Float.valueOf(this.f7848a.getTextSkewX()), Float.valueOf(this.f7848a.getLetterSpacing()), Integer.valueOf(this.f7848a.getFlags()), this.f7848a.getTextLocales(), this.f7848a.getTypeface(), Boolean.valueOf(this.f7848a.isElegantTextHeight()), this.f7849b, Integer.valueOf(this.f7850c), Integer.valueOf(this.f7851d)) : androidx.core.util.d.b(Float.valueOf(this.f7848a.getTextSize()), Float.valueOf(this.f7848a.getTextScaleX()), Float.valueOf(this.f7848a.getTextSkewX()), Float.valueOf(this.f7848a.getLetterSpacing()), Integer.valueOf(this.f7848a.getFlags()), this.f7848a.getTextLocale(), this.f7848a.getTypeface(), Boolean.valueOf(this.f7848a.isElegantTextHeight()), this.f7849b, Integer.valueOf(this.f7850c), Integer.valueOf(this.f7851d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f7848a.getTextSize());
            sb2.append(", textScaleX=" + this.f7848a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f7848a.getTextSkewX());
            int i11 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f7848a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f7848a.isElegantTextHeight());
            if (i11 >= 24) {
                sb2.append(", textLocale=" + this.f7848a.getTextLocales());
            } else {
                sb2.append(", textLocale=" + this.f7848a.getTextLocale());
            }
            sb2.append(", typeface=" + this.f7848a.getTypeface());
            if (i11 >= 26) {
                sb2.append(", variationSettings=" + this.f7848a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f7849b);
            sb2.append(", breakStrategy=" + this.f7850c);
            sb2.append(", hyphenationFrequency=" + this.f7851d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    @RequiresApi(28)
    public PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull b bVar) {
        this.f7842a = a.a(precomputedText);
        this.f7843b = bVar;
        this.f7844c = null;
        this.f7845d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull b bVar, @NonNull int[] iArr) {
        this.f7842a = new SpannableString(charSequence);
        this.f7843b = bVar;
        this.f7844c = iArr;
        this.f7845d = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat a(@NonNull CharSequence charSequence, @NonNull b bVar) {
        PrecomputedText.Params params;
        androidx.core.util.i.g(charSequence);
        androidx.core.util.i.g(bVar);
        try {
            Trace.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params = bVar.f7852e) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params), bVar);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                int iIndexOf = TextUtils.indexOf(charSequence, '\n', i11, length);
                i11 = iIndexOf < 0 ? length : iIndexOf + 1;
                arrayList.add(Integer.valueOf(i11));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), bVar.e(), Api.BaseClientBuilder.API_PRIORITY_OTHER).setBreakStrategy(bVar.b()).setHyphenationFrequency(bVar.c()).setTextDirection(bVar.d()).build();
            } else {
                new StaticLayout(charSequence, bVar.e(), Api.BaseClientBuilder.API_PRIORITY_OTHER, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new PrecomputedTextCompat(charSequence, bVar, iArr);
        } finally {
            Trace.endSection();
        }
    }

    @NonNull
    public b b() {
        return this.f7843b;
    }

    @Nullable
    @RequiresApi(28)
    public PrecomputedText c() {
        if (c.a(this.f7842a)) {
            return d.a(this.f7842a);
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i11) {
        return this.f7842a.charAt(i11);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f7842a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f7842a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f7842a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f7845d.getSpans(i11, i12, cls) : (T[]) this.f7842a.getSpans(i11, i12, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f7842a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.f7842a.nextSpanTransition(i11, i12, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f7845d.removeSpan(obj);
        } else {
            this.f7842a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i11, int i12, int i13) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f7845d.setSpan(obj, i11, i12, i13);
        } else {
            this.f7842a.setSpan(obj, i11, i12, i13);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i11, int i12) {
        return this.f7842a.subSequence(i11, i12);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f7842a.toString();
    }
}
