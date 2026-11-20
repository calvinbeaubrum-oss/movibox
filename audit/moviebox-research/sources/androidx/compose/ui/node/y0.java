package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.platform.k2;
import androidx.compose.ui.platform.l2;
import androidx.compose.ui.platform.r2;
import androidx.compose.ui.platform.y2;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface y0 extends androidx.compose.ui.input.pointer.l0 {

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final a f5155b8 = a.f5156a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5156a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f5157b;

        public final boolean a() {
            return f5157b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void f();
    }

    /* JADX INFO: renamed from: calculatePositionInWindow-MK-Hz9U, reason: not valid java name */
    long mo61calculatePositionInWindowMKHz9U(long j11);

    w0 createLayer(Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0, GraphicsLayer graphicsLayer);

    void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z11);

    androidx.compose.ui.platform.h getAccessibilityManager();

    x1.i getAutofill();

    x1.d0 getAutofillTree();

    androidx.compose.ui.platform.w0 getClipboardManager();

    CoroutineContext getCoroutineContext();

    q2.e getDensity();

    androidx.compose.ui.draganddrop.c getDragAndDropManager();

    androidx.compose.ui.focus.k getFocusOwner();

    androidx.compose.ui.text.font.i.b getFontFamilyResolver();

    androidx.compose.ui.text.font.h.a getFontLoader();

    c4 getGraphicsContext();

    c2.a getHapticFeedBack();

    d2.b getInputModeManager();

    LayoutDirection getLayoutDirection();

    ModifierLocalManager getModifierLocalManager();

    androidx.compose.ui.layout.k0.a getPlacementScope();

    androidx.compose.ui.input.pointer.w getPointerIconService();

    LayoutNode getRoot();

    d0 getSharedDrawScope();

    boolean getShowLayoutBounds();

    OwnerSnapshotObserver getSnapshotObserver();

    k2 getSoftwareKeyboardController();

    androidx.compose.ui.text.input.d0 getTextInputService();

    l2 getTextToolbar();

    r2 getViewConfiguration();

    y2 getWindowInfo();

    void measureAndLayout(boolean z11);

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    void mo62measureAndLayout0kLqBqw(LayoutNode layoutNode, long j11);

    void onAttach(LayoutNode layoutNode);

    void onDetach(LayoutNode layoutNode);

    void onEndApplyChanges();

    void onInteropViewLayoutChange(View view);

    void onLayoutChange(LayoutNode layoutNode);

    void onRequestMeasure(LayoutNode layoutNode, boolean z11, boolean z12, boolean z13);

    void onRequestRelayout(LayoutNode layoutNode, boolean z11, boolean z12);

    void onSemanticsChange();

    void registerOnEndApplyChangesListener(Function0<Unit> function0);

    void registerOnLayoutCompletedListener(b bVar);

    void requestOnPositionedCallback(LayoutNode layoutNode);

    void setShowLayoutBounds(boolean z11);
}
