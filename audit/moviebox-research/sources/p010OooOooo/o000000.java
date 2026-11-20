package p010OooOooo;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.ui.ImagePreviewActivity;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import e0.h0;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import n0.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o000000 extends Lambda implements Function1<File, Unit> {
    public final /* synthetic */ ImagePreviewActivity OooO00o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o000000(ImagePreviewActivity imagePreviewActivity) {
        super(1);
        this.OooO00o = imagePreviewActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(File file) {
        File file2 = file;
        if (file2 == null) {
            TmcLogger.c("ImagePreviewActivity", "doShareFile file is null");
            j.b(R$string.mini_image_select_shared_failed, 0, 0L, false, 14);
        } else {
            PermissionUtils.y("STORAGE_WRITE").m(new h0(this.OooO00o, file2)).z();
        }
        return Unit.f68710a;
    }
}
