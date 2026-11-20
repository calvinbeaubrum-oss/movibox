package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f1672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final m3.f f1673b;

    public h(@NonNull TextView textView) {
        this.f1672a = textView;
        this.f1673b = new m3.f(textView, false);
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f1673b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1673b.b();
    }

    public void c(@Nullable AttributeSet attributeSet, int i11) {
        TypedArray typedArrayObtainStyledAttributes = this.f1672a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        try {
            boolean z11 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z11);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void d(boolean z11) {
        this.f1673b.c(z11);
    }

    public void e(boolean z11) {
        this.f1673b.d(z11);
    }

    @Nullable
    public TransformationMethod f(@Nullable TransformationMethod transformationMethod) {
        return this.f1673b.e(transformationMethod);
    }
}
