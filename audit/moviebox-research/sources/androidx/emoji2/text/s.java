package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8380a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public Spannable f8381b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class c extends b {
        @Override // androidx.emoji2.text.s.b
        public boolean a(CharSequence charSequence) {
            return androidx.core.text.c.a(charSequence) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    public s(@NonNull Spannable spannable) {
        this.f8381b = spannable;
    }

    public s(@NonNull CharSequence charSequence) {
        this.f8381b = new SpannableString(charSequence);
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f8381b;
        if (!this.f8380a && c().a(spannable)) {
            this.f8381b = new SpannableString(spannable);
        }
        this.f8380a = true;
    }

    public Spannable b() {
        return this.f8381b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i11) {
        return this.f8381b.charAt(i11);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream chars() {
        return a.a(this.f8381b);
    }

    @Override // java.lang.CharSequence
    @NonNull
    @RequiresApi(api = 24)
    public IntStream codePoints() {
        return a.b(this.f8381b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f8381b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f8381b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f8381b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        return (T[]) this.f8381b.getSpans(i11, i12, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f8381b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.f8381b.nextSpanTransition(i11, i12, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f8381b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i11, int i12, int i13) {
        a();
        this.f8381b.setSpan(obj, i11, i12, i13);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public CharSequence subSequence(int i11, int i12) {
        return this.f8381b.subSequence(i11, i12);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f8381b.toString();
    }
}
