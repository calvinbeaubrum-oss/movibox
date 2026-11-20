package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements EmojiCompat.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f8315b = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f8316a;

    public e() {
        TextPaint textPaint = new TextPaint();
        this.f8316a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f8315b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.e
    public boolean a(@NonNull CharSequence charSequence, int i11, int i12, int i13) {
        int i14 = Build.VERSION.SDK_INT;
        if (i14 < 23 && i13 > i14) {
            return false;
        }
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i11 < i12) {
            sbB.append(charSequence.charAt(i11));
            i11++;
        }
        return c3.d.a(this.f8316a, sbB.toString());
    }
}
