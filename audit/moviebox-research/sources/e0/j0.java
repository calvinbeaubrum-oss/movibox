package e0;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$string;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 implements ua.h {
    @Override // ua.h
    public void a(File file) {
        n0.j.b(R$string.mini_image_select_save_success, 0, 0L, false, 14);
    }

    @Override // ua.h
    public void b(int i11, String str) {
        n0.j.b(R$string.mini_image_select_save_failed, 0, 0L, false, 14);
        TmcLogger.c("ImagePreviewActivity", i11 + " -> " + str);
    }
}
