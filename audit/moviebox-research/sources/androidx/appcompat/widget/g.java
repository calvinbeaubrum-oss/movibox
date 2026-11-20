package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f1662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final m3.a f1663b;

    public g(@NonNull EditText editText) {
        this.f1662a = editText;
        this.f1663b = new m3.a(editText, false);
    }

    @Nullable
    public KeyListener a(@Nullable KeyListener keyListener) {
        return b(keyListener) ? this.f1663b.a(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public boolean c() {
        return this.f1663b.b();
    }

    public void d(@Nullable AttributeSet attributeSet, int i11) {
        TypedArray typedArrayObtainStyledAttributes = this.f1662a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        try {
            boolean z11 = typedArrayObtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            f(z11);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Nullable
    public InputConnection e(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.f1663b.c(inputConnection, editorInfo);
    }

    public void f(boolean z11) {
        this.f1663b.d(z11);
    }
}
