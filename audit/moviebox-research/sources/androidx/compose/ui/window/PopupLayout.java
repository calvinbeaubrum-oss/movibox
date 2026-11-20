package androidx.compose.ui.window;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.runtime.u2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$string;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.layout.n;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.v2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.material.card.MaterialCardView;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.p;
import q2.q;
import q2.r;
import q2.s;
import q2.t;
import q2.u;

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
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
public final class PopupLayout extends AbstractComposeView implements v2 {
    public final int[] A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f6238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f6240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f6241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final WindowManager f6242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final WindowManager.LayoutParams f6243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutDirection f6244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final i1 f6245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final i1 f6246r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public r f6247s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a3 f6248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f6249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f6250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SnapshotStateObserver f6251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f6252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final i1 f6253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6254z;
    public static final b B = new b(null);
    public static final int $stable = 8;
    public static final Function1<PopupLayout, Unit> C = new Function1<PopupLayout, Unit>() { // from class: androidx.compose.ui.window.PopupLayout$Companion$onCommitAffectingPopupPosition$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PopupLayout popupLayout) {
            invoke2(popupLayout);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PopupLayout popupLayout) {
            if (popupLayout.isAttachedToWindow()) {
                popupLayout.updatePosition();
            }
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(0.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6255a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6255a = iArr;
        }
    }

    public PopupLayout(Function0<Unit> function0, j jVar, String str, View view, q2.e eVar, i iVar, UUID uuid, f fVar) {
        super(view.getContext(), null, 0, 6, null);
        this.f6238j = function0;
        this.f6239k = str;
        this.f6240l = view;
        this.f6241m = fVar;
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f6242n = (WindowManager) systemService;
        this.f6243o = f();
        this.f6244p = LayoutDirection.Ltr;
        this.f6245q = u2.c(null, null, 2, null);
        this.f6246r = u2.c(null, null, 2, null);
        this.f6248t = r2.c(new Function0<Boolean>() { // from class: androidx.compose.ui.window.PopupLayout$canCalculatePosition$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                m parentLayoutCoordinates = this.this$0.getParentLayoutCoordinates();
                if (parentLayoutCoordinates == null || !parentLayoutCoordinates.D()) {
                    parentLayoutCoordinates = null;
                }
                return Boolean.valueOf((parentLayoutCoordinates == null || this.this$0.m91getPopupContentSizebOM6tXw() == null) ? false : true);
            }
        });
        float fH = q2.i.h(8);
        this.f6249u = fH;
        this.f6250v = new Rect();
        this.f6251w = new SnapshotStateObserver(new PopupLayout$snapshotStateObserver$1(this));
        setId(R.id.content);
        ViewTreeLifecycleOwner.b(this, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(this, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(this, ViewTreeSavedStateRegistryOwner.a(view));
        setTag(R$id.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(eVar.N0(fH));
        setOutlineProvider(new a());
        this.f6253y = u2.c(ComposableSingletons$AndroidPopup_androidKt.f6225a.a(), null, 2, null);
        this.A = new int[2];
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PopupLayout(Function0 function0, j jVar, String str, View view, q2.e eVar, i iVar, UUID uuid, f fVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        f gVar;
        if ((i11 & 128) != 0) {
            gVar = Build.VERSION.SDK_INT >= 29 ? new g() : new h();
        } else {
            gVar = fVar;
        }
        this(function0, jVar, str, view, eVar, iVar, uuid, gVar);
    }

    private final Function2<androidx.compose.runtime.i, Integer, Unit> getContent() {
        return (Function2) this.f6253y.getValue();
    }

    private final int getDisplayHeight() {
        return Math.round(getContext().getResources().getConfiguration().screenHeightDp * getContext().getResources().getDisplayMetrics().density);
    }

    private final int getDisplayWidth() {
        return Math.round(getContext().getResources().getConfiguration().screenWidthDp * getContext().getResources().getDisplayMetrics().density);
    }

    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m getParentLayoutCoordinates() {
        return (m) this.f6246r.getValue();
    }

    private final void setContent(Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        this.f6253y.setValue(function2);
    }

    private final void setParentLayoutCoordinates(m mVar) {
        this.f6246r.setValue(mVar);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(-857613600);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.A(this) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 3) == 2 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-857613600, i12, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:572)");
            }
            getContent().invoke(iVarG, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.window.PopupLayout.Content.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    PopupLayout.this.Content(iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.b(this, null);
        this.f6242n.removeViewImmediate(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        throw null;
    }

    public final WindowManager.LayoutParams f() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        layoutParams.flags = AndroidPopup_androidKt.c(null, AndroidPopup_androidKt.d(this.f6240l));
        layoutParams.type = 1002;
        layoutParams.token = this.f6240l.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.f6240l.getContext().getResources().getString(R$string.default_popup_window_title));
        return layoutParams;
    }

    public final void g() {
        throw null;
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.f6248t.getValue()).booleanValue();
    }

    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.f6243o;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.f6244p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final t m91getPopupContentSizebOM6tXw() {
        return (t) this.f6245q.getValue();
    }

    public final i getPositionProvider() {
        return null;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.f6254z;
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    public final String getTestTag() {
        return this.f6239k;
    }

    public /* bridge */ /* synthetic */ View getViewRoot() {
        return androidx.compose.ui.platform.u2.b(this);
    }

    public final void h() {
        if (Build.VERSION.SDK_INT >= 33) {
            androidx.compose.ui.window.b.e(this, this.f6252x);
        }
        this.f6252x = null;
    }

    public final void i(LayoutDirection layoutDirection) {
        int i11 = c.f6255a[layoutDirection.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            i12 = 0;
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i12);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean z11, int i11, int i12, int i13, int i14) {
        super.internalOnLayout$ui_release(z11, i11, i12, i13, i14);
        throw null;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int i11, int i12) {
        throw null;
    }

    public final void j(j jVar) {
        if (!Intrinsics.b(null, jVar)) {
            throw null;
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6251w.s();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6251w.t();
        this.f6251w.j();
        h();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        throw null;
    }

    public final void pollForLocationOnScreenChange() {
        int[] iArr = this.A;
        int i11 = iArr[0];
        int i12 = iArr[1];
        this.f6240l.getLocationOnScreen(iArr);
        int[] iArr2 = this.A;
        if (i11 == iArr2[0] && i12 == iArr2[1]) {
            return;
        }
        updateParentBounds$ui_release();
    }

    public final void setContent(androidx.compose.runtime.m mVar, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        setParentCompositionContext(mVar);
        setContent(function2);
        this.f6254z = true;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i11) {
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.f6244p = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m92setPopupContentSizefhxjrPA(t tVar) {
        this.f6245q.setValue(tVar);
    }

    public final void setPositionProvider(i iVar) {
    }

    public final void setTestTag(String str) {
        this.f6239k = str;
    }

    public final void show() {
        this.f6242n.addView(this, this.f6243o);
    }

    public final void updateParameters(Function0<Unit> function0, j jVar, String str, LayoutDirection layoutDirection) {
        this.f6238j = function0;
        this.f6239k = str;
        j(jVar);
        i(layoutDirection);
    }

    public final void updateParentBounds$ui_release() {
        m parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (!parentLayoutCoordinates.D()) {
                parentLayoutCoordinates = null;
            }
            if (parentLayoutCoordinates == null) {
                return;
            }
            long jP = parentLayoutCoordinates.p();
            long jF = n.f(parentLayoutCoordinates);
            r rVarA = s.a(q.a(Math.round(y1.g.m(jF)), Math.round(y1.g.n(jF))), jP);
            if (Intrinsics.b(rVarA, this.f6247s)) {
                return;
            }
            this.f6247s = rVarA;
            updatePosition();
        }
    }

    public final void updateParentLayoutCoordinates(m mVar) {
        setParentLayoutCoordinates(mVar);
        updateParentBounds$ui_release();
    }

    public final void updatePosition() {
        t tVarM91getPopupContentSizebOM6tXw;
        final r rVar = this.f6247s;
        if (rVar == null || (tVarM91getPopupContentSizebOM6tXw = m91getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        final long j11 = tVarM91getPopupContentSizebOM6tXw.j();
        Rect rect = this.f6250v;
        this.f6241m.a(this.f6240l, rect);
        r rVarE = AndroidPopup_androidKt.e(rect);
        final long jA = u.a(rVarE.j(), rVarE.e());
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = p.f74244b.a();
        this.f6251w.o(this, C, new Function0<Unit>() { // from class: androidx.compose.ui.window.PopupLayout.updatePosition.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.getPositionProvider();
                this.getParentLayoutDirection();
                throw null;
            }
        });
        this.f6243o.x = p.h(longRef.element);
        this.f6243o.y = p.i(longRef.element);
        throw null;
    }
}
