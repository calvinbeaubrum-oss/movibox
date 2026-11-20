package yi;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(33)
public class u extends r {

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (u.this.f81498e.isEmpty()) {
                return;
            }
            outline.setPath(u.this.f81498e);
        }
    }

    public u(@NonNull View view) {
        l(view);
    }

    private void l(View view) {
        view.setOutlineProvider(new a());
    }

    @Override // yi.r
    public void b(@NonNull View view) {
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // yi.r
    public boolean j() {
        return this.f81494a;
    }
}
