package com.transsion.baseui.widget.jumpingbeans;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JumpingBeansSpan[] f51530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<TextView> f51531b;

    /* JADX INFO: renamed from: com.transsion.baseui.widget.jumpingbeans.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0558a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f51532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f51533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f51535d = 0.65f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f51536e = 1300;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f51537f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f51538g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f51539h;

        public C0558a(TextView textView) {
            this.f51532a = textView;
        }

        public static CharSequence d(int i11, int i12, CharSequence charSequence) {
            if (charSequence == null) {
                throw new NullPointerException("The textView text must not be null");
            }
            if (i12 < i11) {
                throw new IllegalArgumentException("The start position must be smaller than the end position");
            }
            if (i11 < 0) {
                throw new IndexOutOfBoundsException("The start position must be non-negative");
            }
            if (i12 <= charSequence.length()) {
                return charSequence;
            }
            throw new IndexOutOfBoundsException("The end position must be smaller than the text length");
        }

        @NonNull
        public a a() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f51538g);
            JumpingBeansSpan[] jumpingBeansSpanArrC = this.f51539h ? c(spannableStringBuilder) : b(spannableStringBuilder);
            this.f51532a.setText(spannableStringBuilder);
            return new a(jumpingBeansSpanArrC, this.f51532a);
        }

        public final JumpingBeansSpan[] b(SpannableStringBuilder spannableStringBuilder) {
            JumpingBeansSpan jumpingBeansSpan = new JumpingBeansSpan(this.f51532a, this.f51536e, 0, 0, this.f51535d);
            JumpingBeansSpan[] jumpingBeansSpanArr = {jumpingBeansSpan};
            spannableStringBuilder.setSpan(jumpingBeansSpan, this.f51533b, this.f51534c, 33);
            return jumpingBeansSpanArr;
        }

        public final JumpingBeansSpan[] c(SpannableStringBuilder spannableStringBuilder) {
            if (this.f51537f == -1) {
                this.f51537f = this.f51536e / ((this.f51534c - this.f51533b) * 3);
            }
            int i11 = this.f51534c;
            int i12 = this.f51533b;
            JumpingBeansSpan[] jumpingBeansSpanArr = new JumpingBeansSpan[i11 - i12];
            while (i12 < this.f51534c) {
                JumpingBeansSpan jumpingBeansSpan = new JumpingBeansSpan(this.f51532a, this.f51536e, i12 - this.f51533b, this.f51537f, this.f51535d);
                int i13 = i12 + 1;
                spannableStringBuilder.setSpan(jumpingBeansSpan, i12, i13, 33);
                jumpingBeansSpanArr[i12 - this.f51533b] = jumpingBeansSpan;
                i12 = i13;
            }
            return jumpingBeansSpanArr;
        }

        @NonNull
        public C0558a e(int i11, int i12) {
            CharSequence text = this.f51532a.getText();
            d(i11, i12, text);
            this.f51538g = text;
            this.f51539h = true;
            this.f51533b = i11;
            this.f51534c = i12;
            return this;
        }

        @NonNull
        public C0558a f(float f11) {
            if (f11 <= 0.0f || f11 > 1.0f) {
                throw new IllegalArgumentException("The animated range must be in the (0, 1] range");
            }
            this.f51535d = f11;
            return this;
        }

        @NonNull
        public C0558a g(boolean z11) {
            this.f51539h = z11;
            return this;
        }

        @NonNull
        public C0558a h(int i11) {
            if (i11 < 1) {
                throw new IllegalArgumentException("The loop duration must be bigger than zero");
            }
            this.f51536e = i11;
            return this;
        }

        @NonNull
        public C0558a i(int i11) {
            if (i11 < 0) {
                throw new IllegalArgumentException("The wave char offset must be non-negative");
            }
            this.f51537f = i11;
            return this;
        }
    }

    public a(JumpingBeansSpan[] jumpingBeansSpanArr, TextView textView) {
        this.f51530a = jumpingBeansSpanArr;
        this.f51531b = new WeakReference<>(textView);
    }

    public static C0558a a(@NonNull TextView textView) {
        return new C0558a(textView);
    }
}
