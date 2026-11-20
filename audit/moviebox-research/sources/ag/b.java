package ag;

import androidx.compose.ui.graphics.y1;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b {
    public static void a(c cVar, long j11, boolean z11, boolean z12, Function1 transformColorForLightContent) {
        Intrinsics.g(transformColorForLightContent, "transformColorForLightContent");
        cVar.a(j11, z11, transformColorForLightContent);
        cVar.b(j11, z11, z12, transformColorForLightContent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(c cVar, long j11, boolean z11, boolean z12, Function1 function1, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSystemBarsColor-Iv8Zu3U");
        }
        if ((i11 & 2) != 0) {
            z11 = y1.i(j11) > 0.5f;
        }
        boolean z13 = z11;
        boolean z14 = (i11 & 4) != 0 ? true : z12;
        if ((i11 & 8) != 0) {
            function1 = SystemUiControllerKt.f32502b;
        }
        cVar.c(j11, z13, z14, function1);
    }
}
