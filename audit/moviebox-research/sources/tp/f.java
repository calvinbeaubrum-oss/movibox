package tp;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$dimen;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f77260a = new f();

    public final int a(Context context, float f11) {
        Intrinsics.g(context, "context");
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final Pair<Integer, Integer> b() {
        float fE = (d0.e() - f0.a(40.0f)) / 3.0f;
        return new Pair<>(Integer.valueOf((int) fE), Integer.valueOf((int) ((153.0f * fE) / 107.0f)));
    }

    public final int c(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public final int d(Context context) {
        Intrinsics.g(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            identifier = R$dimen.default_status_bar_height;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public final int e(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public final boolean f() {
        return ((double) (((float) f0.a(120.0f)) / ((float) d0.e()))) >= 0.35d;
    }
}
