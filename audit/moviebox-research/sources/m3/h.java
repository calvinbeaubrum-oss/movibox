package m3;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final TransformationMethod f70744a;

    public h(@Nullable TransformationMethod transformationMethod) {
        this.f70744a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f70744a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(@Nullable CharSequence charSequence, @NonNull View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f70744a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || EmojiCompat.c().e() != 1) ? charSequence : EmojiCompat.c().p(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z11, int i11, Rect rect) {
        TransformationMethod transformationMethod = this.f70744a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z11, i11, rect);
        }
    }
}
