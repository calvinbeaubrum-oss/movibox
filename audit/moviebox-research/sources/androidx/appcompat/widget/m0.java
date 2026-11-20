package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m0 extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f1721b;

    public m0(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f1721b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i11) throws Resources.NotFoundException {
        Drawable drawableA = a(i11);
        Context context = this.f1721b.get();
        if (drawableA != null && context != null) {
            e0.h().x(context, i11, drawableA);
        }
        return drawableA;
    }
}
