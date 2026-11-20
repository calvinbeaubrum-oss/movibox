package k6;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f68346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f68347b;

    @Nullable
    public static i b(@NonNull ViewGroup viewGroup) {
        return (i) viewGroup.getTag(R$id.transition_current_scene);
    }

    public static void c(@NonNull ViewGroup viewGroup, @Nullable i iVar) {
        viewGroup.setTag(R$id.transition_current_scene, iVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f68346a) != this || (runnable = this.f68347b) == null) {
            return;
        }
        runnable.run();
    }
}
