package androidx.compose.ui.window;

import android.R;
import android.graphics.Outline;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.activity.p;
import androidx.activity.r;
import androidx.compose.runtime.m;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$style;
import androidx.compose.ui.platform.v2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class DialogWrapper extends androidx.activity.k implements v2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f6231d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f6232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f6233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DialogLayout f6234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f6235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f6236j;

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
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6237a;

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
            f6237a = iArr;
        }
    }

    public DialogWrapper(Function0<Unit> function0, c cVar, View view, LayoutDirection layoutDirection, q2.e eVar, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), (Build.VERSION.SDK_INT >= 31 || cVar.a()) ? R$style.DialogWindowTheme : R$style.FloatingDialogWindowTheme), 0, 2, null);
        this.f6231d = function0;
        this.f6232f = cVar;
        this.f6233g = view;
        float fH = q2.i.h(8);
        this.f6235i = fH;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window".toString());
        }
        this.f6236j = window.getAttributes().softInputMode & 240;
        window.requestFeature(1);
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(window, this.f6232f.a());
        DialogLayout dialogLayout = new DialogLayout(getContext(), window);
        dialogLayout.setTag(R$id.compose_view_saveable_id_tag, "Dialog:" + uuid);
        dialogLayout.setClipChildren(false);
        dialogLayout.setElevation(eVar.N0(fH));
        dialogLayout.setOutlineProvider(new a());
        this.f6234h = dialogLayout;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            e(viewGroup);
        }
        setContentView(dialogLayout);
        ViewTreeLifecycleOwner.b(dialogLayout, ViewTreeLifecycleOwner.a(view));
        ViewTreeViewModelStoreOwner.b(dialogLayout, ViewTreeViewModelStoreOwner.a(view));
        ViewTreeSavedStateRegistryOwner.b(dialogLayout, ViewTreeSavedStateRegistryOwner.a(view));
        l(this.f6231d, this.f6232f, layoutDirection);
        r.b(getOnBackPressedDispatcher(), this, false, new Function1<p, Unit>() { // from class: androidx.compose.ui.window.DialogWrapper.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(p pVar) {
                invoke2(pVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(p pVar) {
                if (DialogWrapper.this.f6232f.b()) {
                    DialogWrapper.this.f6231d.invoke();
                }
            }
        }, 2, null);
    }

    public static final void e(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                e(viewGroup2);
            }
        }
    }

    private final void j(LayoutDirection layoutDirection) {
        DialogLayout dialogLayout = this.f6234h;
        int i11 = b.f6237a[layoutDirection.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            i12 = 0;
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        dialogLayout.setLayoutDirection(i12);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }

    public final void h() {
        this.f6234h.disposeComposition();
    }

    public final void i(m mVar, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        this.f6234h.setContent(mVar, function2);
    }

    public final void k(SecureFlagPolicy secureFlagPolicy) {
        boolean zA = k.a(secureFlagPolicy, AndroidPopup_androidKt.d(this.f6233g));
        Window window = getWindow();
        Intrinsics.d(window);
        window.setFlags(zA ? 8192 : -8193, 8192);
    }

    public final void l(Function0<Unit> function0, c cVar, LayoutDirection layoutDirection) {
        Window window;
        this.f6231d = function0;
        this.f6232f = cVar;
        k(cVar.d());
        j(layoutDirection);
        if (cVar.e() && !this.f6234h.f() && (window = getWindow()) != null) {
            window.setLayout(-2, -2);
        }
        this.f6234h.g(cVar.e());
        if (Build.VERSION.SDK_INT < 31) {
            if (cVar.a()) {
                Window window2 = getWindow();
                if (window2 != null) {
                    window2.setSoftInputMode(this.f6236j);
                    return;
                }
                return;
            }
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setSoftInputMode(16);
            }
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent && this.f6232f.c()) {
            this.f6231d.invoke();
        }
        return zOnTouchEvent;
    }
}
