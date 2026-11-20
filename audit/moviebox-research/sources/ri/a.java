package ri;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Animator f75486a;

    public void a() {
        Animator animator = this.f75486a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f75486a = null;
    }

    public void c(Animator animator) {
        a();
        this.f75486a = animator;
    }
}
