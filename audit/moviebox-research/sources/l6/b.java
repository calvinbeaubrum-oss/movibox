package l6;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animatable2.AnimationCallback f69982a;

    /* JADX INFO: compiled from: source.java */
    public class a extends Animatable2.AnimationCallback {
        public a() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            b.this.b(drawable);
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            b.this.c(drawable);
        }
    }

    @RequiresApi(23)
    public Animatable2.AnimationCallback a() {
        if (this.f69982a == null) {
            this.f69982a = new a();
        }
        return this.f69982a;
    }

    public void b(Drawable drawable) {
    }

    public void c(Drawable drawable) {
    }
}
