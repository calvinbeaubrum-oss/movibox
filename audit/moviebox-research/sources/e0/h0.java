package e0;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.ui.ImagePreviewActivity;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements PermissionUtils.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImagePreviewActivity f63598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f63599b;

    public h0(ImagePreviewActivity imagePreviewActivity, File file) {
        this.f63598a = imagePreviewActivity;
        this.f63599b = file;
    }

    @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
    public void a() {
        TmcLogger.c("ImagePreviewActivity", "doShareFile onDenied");
        n0.j.b(R$string.mini_image_select_shared_failed, 0, 0L, false, 14);
    }

    @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
    public void onGranted() {
        ImagePreviewActivity imagePreviewActivity = this.f63598a;
        File file = this.f63599b;
        ImagePreviewActivity.a aVar = ImagePreviewActivity.f31681r;
        imagePreviewActivity.getClass();
        com.cloud.tmc.integration.utils.share.g.e(imagePreviewActivity, file, (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? false : false, (60 & 64) == 0 ? new p(imagePreviewActivity) : null);
    }
}
