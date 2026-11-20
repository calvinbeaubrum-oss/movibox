package yi;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class s extends r {
    @Override // yi.r
    public void b(@NonNull View view) {
        if (this.f81496c == null || this.f81497d.isEmpty() || !j()) {
            return;
        }
        view.invalidate();
    }

    @Override // yi.r
    public boolean j() {
        return true;
    }
}
