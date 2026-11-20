package js;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
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
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Spannable f68131a;

    public a(Spannable spannable) {
        this.f68131a = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View textView, MotionEvent event) {
        Intrinsics.g(textView, "textView");
        Intrinsics.g(event, "event");
        int action = event.getAction();
        if (!(textView instanceof TextView)) {
            return false;
        }
        if (action == 0 || action == 1) {
            float x11 = event.getX();
            float y11 = event.getY();
            TextView textView2 = (TextView) textView;
            float totalPaddingLeft = x11 - textView2.getTotalPaddingLeft();
            float totalPaddingTop = y11 - textView2.getTotalPaddingTop();
            float scrollX = totalPaddingLeft + textView.getScrollX();
            float scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = ((TextView) textView).getLayout();
            Intrinsics.f(layout, "textView.layout");
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) scrollY), scrollX);
            Spannable spannable = this.f68131a;
            ClickableSpan[] clickableSpanArr = spannable != null ? (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class) : null;
            if (!(clickableSpanArr.length == 0)) {
                if (action == 0) {
                    Spannable spannable2 = this.f68131a;
                    if (spannable2 != null) {
                        int spanStart = spannable2.getSpanStart(clickableSpanArr[0]);
                        Spannable spannable3 = this.f68131a;
                        if (spannable3 != null) {
                            try {
                                Selection.setSelection(this.f68131a, spanStart, spannable3.getSpanEnd(clickableSpanArr[0]));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
                return true;
            }
            Selection.removeSelection(this.f68131a);
        }
        return false;
    }
}
