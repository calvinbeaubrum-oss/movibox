package e0;

import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.ui.ImagePreviewActivity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements com.cloud.tmc.integration.utils.share.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImagePreviewActivity f63609a;

    public p(ImagePreviewActivity imagePreviewActivity) {
        this.f63609a = imagePreviewActivity;
    }

    public static final void b() {
        n0.j.b(R$string.mini_image_select_shared_success, 0, 0L, false, 14);
    }

    public static final void c() {
        n0.j.b(R$string.mini_image_select_shared_failed, 0, 0L, false, 14);
    }

    @Override // com.cloud.tmc.integration.utils.share.a
    public void a(int i11, int i12) {
        if (i12 == 1) {
            TmcLogger.c("ImagePreviewActivity", "Share file successfully");
            ImagePreviewActivity imagePreviewActivity = this.f63609a;
            ImagePreviewActivity.a aVar = ImagePreviewActivity.f31681r;
            imagePreviewActivity.U().b(new d0.b(AppLovinEventTypes.USER_SHARED_LINK, new Runnable() { // from class: e0.n
                @Override // java.lang.Runnable
                public final void run() {
                    p.b();
                }
            }));
            return;
        }
        TmcLogger.c("ImagePreviewActivity", "Share file failed");
        ImagePreviewActivity imagePreviewActivity2 = this.f63609a;
        ImagePreviewActivity.a aVar2 = ImagePreviewActivity.f31681r;
        imagePreviewActivity2.U().b(new d0.b(AppLovinEventTypes.USER_SHARED_LINK, new Runnable() { // from class: e0.o
            @Override // java.lang.Runnable
            public final void run() {
                p.c();
            }
        }));
    }
}
