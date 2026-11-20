package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class g {
    public static final y1.i a(View view) {
        int[] iArrA = f.f3933a.a();
        view.getLocationInWindow(iArrA);
        int i11 = iArrA[0];
        return new y1.i(i11, iArrA[1], i11 + view.getWidth(), iArrA[1] + view.getHeight());
    }

    public static final boolean b(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if ((!viewGroup.isFocusable() || view.hasFocus()) && !(view instanceof AndroidComposeView)) {
            if (rect != null) {
                View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
                return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) view, view.hasFocus() ? view.findFocus() : null, num.intValue());
            return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
        }
        return view.requestFocus(num.intValue(), rect);
    }

    public static final Integer c(int i11) {
        b.a aVar = b.f3922b;
        if (b.l(i11, aVar.h())) {
            return 33;
        }
        if (b.l(i11, aVar.a())) {
            return Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        }
        if (b.l(i11, aVar.d())) {
            return 17;
        }
        if (b.l(i11, aVar.g())) {
            return 66;
        }
        if (b.l(i11, aVar.e())) {
            return 2;
        }
        return b.l(i11, aVar.f()) ? 1 : null;
    }

    public static final b d(int i11) {
        if (i11 == 1) {
            return b.i(b.f3922b.f());
        }
        if (i11 == 2) {
            return b.i(b.f3922b.e());
        }
        if (i11 == 17) {
            return b.i(b.f3922b.d());
        }
        if (i11 == 33) {
            return b.i(b.f3922b.h());
        }
        if (i11 == 66) {
            return b.i(b.f3922b.g());
        }
        if (i11 != 130) {
            return null;
        }
        return b.i(b.f3922b.a());
    }

    public static final LayoutDirection e(int i11) {
        if (i11 == 0) {
            return LayoutDirection.Ltr;
        }
        if (i11 != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }
}
