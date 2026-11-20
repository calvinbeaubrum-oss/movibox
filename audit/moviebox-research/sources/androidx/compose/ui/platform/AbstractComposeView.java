package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Recomposer;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<androidx.compose.runtime.m> f5158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IBinder f5159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.runtime.l f5160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.compose.runtime.m f5161d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f5162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5165i;

    @JvmOverloads
    public AbstractComposeView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AbstractComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public AbstractComposeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setClipChildren(false);
        setClipToPadding(false);
        this.f5162f = ViewCompositionStrategy.f5374a.a().a(this);
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    private final void setParentContext(androidx.compose.runtime.m mVar) {
        if (this.f5161d != mVar) {
            this.f5161d = mVar;
            if (mVar != null) {
                this.f5158a = null;
            }
            androidx.compose.runtime.l lVar = this.f5160c;
            if (lVar != null) {
                lVar.dispose();
                this.f5160c = null;
                if (isAttachedToWindow()) {
                    c();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.f5159b != iBinder) {
            this.f5159b = iBinder;
            this.f5158a = null;
        }
    }

    public abstract void Content(androidx.compose.runtime.i iVar, int i11);

    public final androidx.compose.runtime.m a(androidx.compose.runtime.m mVar) {
        androidx.compose.runtime.m mVar2 = d(mVar) ? mVar : null;
        if (mVar2 != null) {
            this.f5158a = new WeakReference<>(mVar2);
        }
        return mVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        b();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11) {
        b();
        super.addView(view, i11);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, int i12) {
        b();
        super.addView(view, i11, i12);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        b();
        return super.addViewInLayout(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i11, ViewGroup.LayoutParams layoutParams, boolean z11) {
        b();
        return super.addViewInLayout(view, i11, layoutParams, z11);
    }

    public final void b() {
        if (this.f5164h) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    public final void c() {
        if (this.f5160c == null) {
            try {
                this.f5164h = true;
                this.f5160c = e3.c(this, e(), androidx.compose.runtime.internal.b.c(-656146368, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
                        invoke(iVar, num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                        if ((i11 & 3) == 2 && iVar.h()) {
                            iVar.H();
                            return;
                        }
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.S(-656146368, i11, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:258)");
                        }
                        this.this$0.Content(iVar, 0);
                        if (androidx.compose.runtime.k.J()) {
                            androidx.compose.runtime.k.R();
                        }
                    }
                }));
            } finally {
                this.f5164h = false;
            }
        }
    }

    public final void createComposition() {
        if (this.f5161d == null && !isAttachedToWindow()) {
            throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
        }
        c();
    }

    public final boolean d(androidx.compose.runtime.m mVar) {
        return !(mVar instanceof Recomposer) || ((Recomposer) mVar).f0().getValue().compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    public final void disposeComposition() {
        androidx.compose.runtime.l lVar = this.f5160c;
        if (lVar != null) {
            lVar.dispose();
        }
        this.f5160c = null;
        requestLayout();
    }

    public final androidx.compose.runtime.m e() {
        androidx.compose.runtime.m mVar;
        androidx.compose.runtime.m mVar2 = this.f5161d;
        if (mVar2 != null) {
            return mVar2;
        }
        androidx.compose.runtime.m mVarD = WindowRecomposer_androidKt.d(this);
        androidx.compose.runtime.m mVar3 = null;
        androidx.compose.runtime.m mVarA = mVarD != null ? a(mVarD) : null;
        if (mVarA != null) {
            return mVarA;
        }
        WeakReference<androidx.compose.runtime.m> weakReference = this.f5158a;
        if (weakReference != null && (mVar = weakReference.get()) != null && d(mVar)) {
            mVar3 = mVar;
        }
        androidx.compose.runtime.m mVar4 = mVar3;
        return mVar4 == null ? a(WindowRecomposer_androidKt.h(this)) : mVar4;
    }

    public final boolean getHasComposition() {
        return this.f5160c != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.f5163g;
    }

    public void internalOnLayout$ui_release(boolean z11, int i11, int i12, int i13, int i14) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i13 - i11) - getPaddingRight(), (i14 - i12) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui_release(int i11, int i12) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i11, i12);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i11) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i11)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i12) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i12)));
        setMeasuredDimension(childAt.getMeasuredWidth() + getPaddingLeft() + getPaddingRight(), childAt.getMeasuredHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.f5165i || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        internalOnLayout$ui_release(z11, i11, i12, i13, i14);
    }

    @Override // android.view.View
    public final void onMeasure(int i11, int i12) {
        c();
        internalOnMeasure$ui_release(i11, i12);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        childAt.setLayoutDirection(i11);
    }

    public final void setParentCompositionContext(androidx.compose.runtime.m mVar) {
        setParentContext(mVar);
    }

    public final void setShowLayoutBounds(boolean z11) {
        this.f5163g = z11;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((androidx.compose.ui.node.y0) childAt).setShowLayoutBounds(z11);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z11) {
        super.setTransitionGroup(z11);
        this.f5165i = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy viewCompositionStrategy) {
        Function0<Unit> function0 = this.f5162f;
        if (function0 != null) {
            function0.invoke();
        }
        this.f5162f = viewCompositionStrategy.a(this);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
