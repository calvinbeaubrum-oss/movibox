package p010OooOooo;

import android.graphics.Bitmap;
import android.os.Build;
import com.cloud.tmc.integration.utils.y;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniutils.util.ImageUtils;
import e0.j0;
import java.io.File;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import n0.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0O0O00 extends Lambda implements Function1<File, Unit> {
    public static final o0O0O00 OooO00o = new o0O0O00();

    public o0O0O00() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(File file) {
        Bitmap.CompressFormat compressFormat;
        File file2 = file;
        if (file2 == null) {
            TmcLogger.c("ImagePreviewActivity", "doDownloadFile file is null");
            j.b(R$string.mini_image_select_save_failed, 0, 0L, false, 14);
        } else {
            Bitmap bitmapA = ImageUtils.a(file2);
            String strT = FilesKt__UtilsKt.t(file2);
            if (Intrinsics.b(strT, "png")) {
                compressFormat = Bitmap.CompressFormat.PNG;
            } else if (Intrinsics.b(strT, "webp")) {
                compressFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP;
            } else {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
            y.b(bitmapA, new j0(), compressFormat);
        }
        return Unit.f68710a;
    }
}
