package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.focus.FocusOwner$CC;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class AndroidComposeView extends ViewGroup implements androidx.compose.ui.node.y0, w2, androidx.compose.ui.input.pointer.l0, androidx.lifecycle.f {
    public static Class<?> F0;
    public static Method G0;
    public boolean A;
    public final Function0<Unit> A0;
    public final androidx.compose.ui.input.pointer.j B;
    public final s0 B0;
    public final androidx.compose.ui.input.pointer.d0 C;
    public boolean C0;
    public Function1<? super Configuration, Unit> D;
    public final ScrollCapture D0;
    public final x1.e E;
    public final androidx.compose.ui.input.pointer.w E0;
    public boolean F;
    public final j G;
    public final OwnerSnapshotObserver H;
    public boolean I;
    public AndroidViewsHandler J;
    public DrawChildContainer K;
    public q2.b L;
    public boolean M;
    public final androidx.compose.ui.node.k0 N;
    public final r2 O;
    public long P;
    public final int[] Q;
    public final float[] R;
    public final float[] S;
    public final float[] T;
    public long U;
    public boolean V;
    public long W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5166a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f5167a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5168b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final androidx.compose.runtime.i1 f5169b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.compose.ui.node.d0 f5170c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final androidx.compose.runtime.a3 f5171c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.runtime.i1 f5172d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Function1<? super b, Unit> f5173d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f5174e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.semantics.f f5175f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final ViewTreeObserver.OnScrollChangedListener f5176f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EmptySemanticsElement f5177g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final ViewTreeObserver.OnTouchModeChangeListener f5178g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.compose.ui.focus.k f5179h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final TextInputServiceAndroid f5180h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DragAndDropModifierOnDragListener f5181i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final androidx.compose.ui.text.input.d0 f5182i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CoroutineContext f5183j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final AtomicReference f5184j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.ui.draganddrop.c f5185k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final k2 f5186k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z2 f5187l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final androidx.compose.ui.text.font.h.a f5188l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.compose.ui.f f5189m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final androidx.compose.runtime.i1 f5190m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.compose.ui.f f5191n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f5192n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final androidx.compose.ui.graphics.p1 f5193o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final androidx.compose.runtime.i1 f5194o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LayoutNode f5195p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final c2.a f5196p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.compose.ui.node.g1 f5197q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final d2.c f5198q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.compose.ui.semantics.p f5199r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final ModifierLocalManager f5200r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AndroidComposeViewAccessibilityDelegateCompat f5201s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final l2 f5202s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AndroidContentCaptureManager f5203t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public MotionEvent f5204t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f5205u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public long f5206u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c4 f5207v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final x2<androidx.compose.ui.node.w0> f5208v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x1.d0 f5209w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<Function0<Unit>> f5210w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<androidx.compose.ui.node.w0> f5211x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final AndroidComposeView$resendMotionEventRunnable$1 f5212x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<androidx.compose.ui.node.w0> f5213y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final Runnable f5214y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5215z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f5216z0;
    public static final a Companion = new a(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            try {
                if (AndroidComposeView.F0 == null) {
                    AndroidComposeView.F0 = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.F0;
                    AndroidComposeView.G0 = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.G0;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.u f5220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f6.e f5221b;

        public b(androidx.lifecycle.u uVar, f6.e eVar) {
            this.f5220a = uVar;
            this.f5221b = eVar;
        }

        public final androidx.lifecycle.u a() {
            return this.f5220a;
        }

        public final f6.e b() {
            return this.f5221b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.compose.ui.input.pointer.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.compose.ui.input.pointer.u f5222a = androidx.compose.ui.input.pointer.u.f4745a.a();

        public c() {
        }

        @Override // androidx.compose.ui.input.pointer.w
        public void a(androidx.compose.ui.input.pointer.u uVar) {
            if (uVar == null) {
                uVar = androidx.compose.ui.input.pointer.u.f4745a.a();
            }
            this.f5222a = uVar;
            if (Build.VERSION.SDK_INT >= 24) {
                j0.f5497a.a(AndroidComposeView.this, uVar);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeView$textInputSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.platform.AndroidComposeView", f = "AndroidComposeView.android.kt", l = {592}, m = "textInputSession")
    public static final class C09371 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C09371(Continuation<? super C09371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidComposeView.this.textInputSession(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        y1.g.a aVar = y1.g.f81070b;
        this.f5166a = aVar.b();
        this.f5168b = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.f5170c = new androidx.compose.ui.node.d0(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.f5172d = androidx.compose.runtime.r2.e(q2.a.a(context), androidx.compose.runtime.r2.h());
        androidx.compose.ui.semantics.f fVar = new androidx.compose.ui.semantics.f();
        this.f5175f = fVar;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(fVar);
        this.f5177g = emptySemanticsElement;
        this.f5179h = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.jvm.internal.MutablePropertyReference0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.jvm.internal.MutablePropertyReference0
            public void set(Object obj) {
                ((AndroidComposeView) this.receiver).setLayoutDirection((LayoutDirection) obj);
            }
        });
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.f5181i = dragAndDropModifierOnDragListener;
        this.f5183j = coroutineContext;
        this.f5185k = dragAndDropModifierOnDragListener;
        this.f5187l = new z2();
        androidx.compose.ui.f.a aVar2 = androidx.compose.ui.f.f3863a;
        androidx.compose.ui.f fVarA = androidx.compose.ui.input.key.a.a(aVar2, new Function1<e2.b, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(e2.b bVar) {
                return m73invokeZmokQxo(bVar.f());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m73invokeZmokQxo(KeyEvent keyEvent) {
                final androidx.compose.ui.focus.b bVarM67getFocusDirectionP8AzH3I = this.this$0.m67getFocusDirectionP8AzH3I(keyEvent);
                if (bVarM67getFocusDirectionP8AzH3I == null || !e2.c.e(e2.d.b(keyEvent), e2.c.f63782a.a())) {
                    return Boolean.FALSE;
                }
                y1.i iVarY = this.this$0.y();
                Boolean boolA = this.this$0.getFocusOwner().a(bVarM67getFocusDirectionP8AzH3I.o(), iVarY, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        Boolean boolK = FocusTransactionsKt.k(focusTargetNode, bVarM67getFocusDirectionP8AzH3I.o());
                        return Boolean.valueOf(boolK != null ? boolK.booleanValue() : true);
                    }
                });
                if (boolA == null || boolA.booleanValue()) {
                    return Boolean.TRUE;
                }
                if (!androidx.compose.ui.focus.l.a(bVarM67getFocusDirectionP8AzH3I.o())) {
                    return Boolean.FALSE;
                }
                Integer numC = androidx.compose.ui.focus.g.c(bVarM67getFocusDirectionP8AzH3I.o());
                if (numC == null) {
                    throw new IllegalStateException("Invalid focus direction".toString());
                }
                int iIntValue = numC.intValue();
                Rect rectB = iVarY != null ? w4.b(iVarY) : null;
                if (rectB == null) {
                    throw new IllegalStateException("Invalid rect".toString());
                }
                View viewK = this.this$0.k(iIntValue);
                if (!(!Intrinsics.b(viewK, this.this$0))) {
                    viewK = null;
                }
                if ((viewK == null || !androidx.compose.ui.focus.g.b(viewK, Integer.valueOf(iIntValue), rectB)) && this.this$0.getFocusOwner().i(false, true, false, bVarM67getFocusDirectionP8AzH3I.o())) {
                    Boolean boolA2 = this.this$0.getFocusOwner().a(bVarM67getFocusDirectionP8AzH3I.o(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FocusTargetNode focusTargetNode) {
                            Boolean boolK = FocusTransactionsKt.k(focusTargetNode, bVarM67getFocusDirectionP8AzH3I.o());
                            return Boolean.valueOf(boolK != null ? boolK.booleanValue() : true);
                        }
                    });
                    return Boolean.valueOf(boolA2 != null ? boolA2.booleanValue() : true);
                }
                return Boolean.TRUE;
            }
        });
        this.f5189m = fVarA;
        androidx.compose.ui.f fVarA2 = androidx.compose.ui.input.rotary.a.a(aVar2, new Function1<g2.c, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(g2.c cVar) {
                return Boolean.FALSE;
            }
        });
        this.f5191n = fVarA2;
        this.f5193o = new androidx.compose.ui.graphics.p1();
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.g(RootMeasurePolicy.f4842b);
        layoutNode.b(getDensity());
        layoutNode.h(aVar2.f(emptySemanticsElement).f(fVarA2).f(fVarA).f(getFocusOwner().g()).f(dragAndDropModifierOnDragListener.d()));
        this.f5195p = layoutNode;
        this.f5197q = this;
        this.f5199r = new androidx.compose.ui.semantics.p(getRoot(), fVar);
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.f5201s = androidComposeViewAccessibilityDelegateCompat;
        this.f5203t = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.f5205u = new i(context);
        this.f5207v = androidx.compose.ui.graphics.m0.a(this);
        this.f5209w = new x1.d0();
        this.f5211x = new ArrayList();
        this.B = new androidx.compose.ui.input.pointer.j();
        this.C = new androidx.compose.ui.input.pointer.d0(getRoot());
        this.D = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration configuration) {
            }
        };
        this.E = f() ? new x1.e(this, getAutofillTree()) : null;
        this.G = new j(context);
        this.H = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.N = new androidx.compose.ui.node.k0(getRoot());
        this.O = new r0(ViewConfiguration.get(context));
        this.P = q2.q.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.Q = new int[]{0, 0};
        float[] fArrC = k4.c(null, 1, null);
        this.R = fArrC;
        this.S = k4.c(null, 1, null);
        this.T = k4.c(null, 1, null);
        this.U = -1L;
        this.W = aVar.a();
        this.f5167a0 = true;
        this.f5169b0 = androidx.compose.runtime.u2.c(null, null, 2, null);
        this.f5171c0 = androidx.compose.runtime.r2.c(new Function0<b>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.b invoke() {
                return this.this$0.get_viewTreeOwners();
            }
        });
        this.f5174e0 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.l
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.n(this.f5500a);
            }
        };
        this.f5176f0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.m
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.H(this.f5501a);
            }
        };
        this.f5178g0 = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.n
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z11) {
                AndroidComposeView.N(this.f5518a, z11);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.f5180h0 = textInputServiceAndroid;
        this.f5182i0 = new androidx.compose.ui.text.input.d0(AndroidComposeView_androidKt.h().invoke(textInputServiceAndroid));
        this.f5184j0 = SessionMutex.a();
        this.f5186k0 = new x0(getTextInputService());
        this.f5188l0 = new n0(context);
        this.f5190m0 = androidx.compose.runtime.r2.e(androidx.compose.ui.text.font.l.a(context), androidx.compose.runtime.r2.h());
        this.f5192n0 = m(context.getResources().getConfiguration());
        LayoutDirection layoutDirectionE = androidx.compose.ui.focus.g.e(context.getResources().getConfiguration().getLayoutDirection());
        this.f5194o0 = androidx.compose.runtime.u2.c(layoutDirectionE == null ? LayoutDirection.Ltr : layoutDirectionE, null, 2, null);
        this.f5196p0 = new c2.b(this);
        this.f5198q0 = new d2.c(isInTouchMode() ? d2.a.f62868b.b() : d2.a.f62868b.a(), new Function1<d2.a, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(d2.a aVar3) {
                return m69invokeiuPiT84(aVar3.i());
            }

            /* JADX INFO: renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m69invokeiuPiT84(int i11) {
                boolean zRequestFocusFromTouch;
                d2.a.C0642a c0642a = d2.a.f62868b;
                if (d2.a.f(i11, c0642a.b())) {
                    zRequestFocusFromTouch = this.this$0.isInTouchMode();
                } else if (d2.a.f(i11, c0642a.a())) {
                    zRequestFocusFromTouch = this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true;
                } else {
                    zRequestFocusFromTouch = false;
                }
                return Boolean.valueOf(zRequestFocusFromTouch);
            }
        }, objArr2 == true ? 1 : 0);
        this.f5200r0 = new ModifierLocalManager(this);
        this.f5202s0 = new AndroidTextToolbar(this);
        this.f5208v0 = new x2<>();
        this.f5210w0 = new androidx.compose.runtime.collection.b<>(new Function0[16], 0);
        this.f5212x0 = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.removeCallbacks(this);
                MotionEvent motionEvent = this.this$0.f5204t0;
                if (motionEvent != null) {
                    boolean z11 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z11) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i11 = (actionMasked == 7 || actionMasked == 9) ? 7 : 2;
                    AndroidComposeView androidComposeView = this.this$0;
                    androidComposeView.K(motionEvent, i11, androidComposeView.f5206u0, false);
                }
            }
        };
        this.f5214y0 = new Runnable() { // from class: androidx.compose.ui.platform.o
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.I(this.f5534a);
            }
        };
        this.A0 = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
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
                MotionEvent motionEvent = this.this$0.f5204t0;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        this.this$0.f5206u0 = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView = this.this$0;
                        androidComposeView.post(androidComposeView.f5212x0);
                    }
                }
            }
        };
        int i11 = Build.VERSION.SDK_INT;
        this.B0 = i11 < 29 ? new t0(fArrC, objArr == true ? 1 : 0) : new v0();
        addOnAttachStateChangeListener(this.f5203t);
        setWillNotDraw(false);
        setFocusable(true);
        if (i11 >= 26) {
            m0.f5502a.a(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<w2, Unit> function1A = w2.f5555d8.a();
        if (function1A != null) {
            function1A.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener);
        getRoot().r(this);
        if (i11 >= 29) {
            y.f5561a.a(this);
        }
        this.D0 = i11 >= 31 ? new ScrollCapture() : null;
        this.E0 = new c();
    }

    public static /* synthetic */ void G(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.F(layoutNode);
    }

    public static final void H(AndroidComposeView androidComposeView) {
        androidComposeView.O();
    }

    public static final void I(AndroidComposeView androidComposeView) {
        androidComposeView.f5216z0 = false;
        MotionEvent motionEvent = androidComposeView.f5204t0;
        Intrinsics.d(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        androidComposeView.J(motionEvent);
    }

    public static /* synthetic */ void L(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i11, long j11, boolean z11, int i12, Object obj) {
        androidComposeView.K(motionEvent, i11, j11, (i12 & 8) != 0 ? true : z11);
    }

    public static final void N(AndroidComposeView androidComposeView, boolean z11) {
        androidComposeView.f5198q0.b(z11 ? d2.a.f62868b.b() : d2.a.f62868b.a());
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final b get_viewTreeOwners() {
        return (b) this.f5169b0.getValue();
    }

    public static final void n(AndroidComposeView androidComposeView) {
        androidComposeView.O();
    }

    private void setDensity(q2.e eVar) {
        this.f5172d.setValue(eVar);
    }

    private void setFontFamilyResolver(androidx.compose.ui.text.font.i.b bVar) {
        this.f5190m0.setValue(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.f5194o0.setValue(layoutDirection);
    }

    private final void set_viewTreeOwners(b bVar) {
        this.f5169b0.setValue(bVar);
    }

    public final boolean A(androidx.compose.ui.focus.b bVar, y1.i iVar) {
        Integer numC;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((bVar == null || (numC = androidx.compose.ui.focus.g.c(bVar.o())) == null) ? TsExtractor.TS_STREAM_TYPE_HDMV_DTS : numC.intValue(), iVar != null ? w4.b(iVar) : null);
    }

    public final long B(int i11, int i12) {
        return ULong.b(ULong.b(i12) | ULong.b(ULong.b(i11) << 32));
    }

    public final void C() {
        if (this.V) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.U) {
            this.U = jCurrentAnimationTimeMillis;
            E();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.Q);
            int[] iArr = this.Q;
            float f11 = iArr[0];
            float f12 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.Q;
            this.W = y1.h.a(f11 - iArr2[0], f12 - iArr2[1]);
        }
    }

    public final void D(MotionEvent motionEvent) {
        this.U = AnimationUtils.currentAnimationTimeMillis();
        E();
        long jF = k4.f(this.S, y1.h.a(motionEvent.getX(), motionEvent.getY()));
        this.W = y1.h.a(motionEvent.getRawX() - y1.g.m(jF), motionEvent.getRawY() - y1.g.n(jF));
    }

    public final void E() {
        this.B0.a(this, this.S);
        g1.a(this.S, this.T);
    }

    public final void F(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (layoutNode != null) {
            while (layoutNode != null && layoutNode.a0() == LayoutNode.UsageByParent.InMeasureBlock && g(layoutNode)) {
                layoutNode = layoutNode.h0();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public final int J(MotionEvent motionEvent) {
        androidx.compose.ui.input.pointer.c0 c0Var;
        if (this.C0) {
            this.C0 = false;
            this.f5187l.a(androidx.compose.ui.input.pointer.j0.b(motionEvent.getMetaState()));
        }
        androidx.compose.ui.input.pointer.b0 b0VarC = this.B.c(motionEvent, this);
        if (b0VarC == null) {
            this.C.c();
            return androidx.compose.ui.input.pointer.e0.a(false, false);
        }
        List<androidx.compose.ui.input.pointer.c0> listB = b0VarC.b();
        int size = listB.size() - 1;
        if (size < 0) {
            c0Var = null;
            break;
        }
        while (true) {
            int i11 = size - 1;
            c0Var = listB.get(size);
            if (c0Var.b()) {
                break;
            }
            if (i11 < 0) {
                c0Var = null;
                break;
            }
            size = i11;
        }
        androidx.compose.ui.input.pointer.c0 c0Var2 = c0Var;
        if (c0Var2 != null) {
            this.f5166a = c0Var2.f();
        }
        int iB = this.C.b(b0VarC, this, v(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || androidx.compose.ui.input.pointer.m0.c(iB)) {
            return iB;
        }
        this.B.e(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return iB;
    }

    public final void K(MotionEvent motionEvent, int i11, long j11, boolean z11) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i11 != 9 && i11 != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i12 = 0; i12 < pointerCount; i12++) {
            pointerPropertiesArr[i12] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i13 = 0; i13 < pointerCount; i13++) {
            pointerCoordsArr[i13] = new MotionEvent.PointerCoords();
        }
        int i14 = 0;
        while (i14 < pointerCount) {
            int i15 = ((actionIndex < 0 || i14 < actionIndex) ? 0 : 1) + i14;
            motionEvent.getPointerProperties(i15, pointerPropertiesArr[i14]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i14];
            motionEvent.getPointerCoords(i15, pointerCoords);
            long jMo54localToScreenMKHz9U = mo54localToScreenMKHz9U(y1.h.a(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = y1.g.m(jMo54localToScreenMKHz9U);
            pointerCoords.y = y1.g.n(jMo54localToScreenMKHz9U);
            i14++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j11 : motionEvent.getDownTime(), j11, i11, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z11 ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        androidx.compose.ui.input.pointer.b0 b0VarC = this.B.c(motionEventObtain, this);
        Intrinsics.d(b0VarC);
        this.C.b(b0VarC, this, true);
        motionEventObtain.recycle();
    }

    public final boolean M(androidx.compose.ui.draganddrop.g gVar, long j11, Function1<? super z1.g, Unit> function1) {
        Resources resources = getContext().getResources();
        androidx.compose.ui.draganddrop.a aVar = new androidx.compose.ui.draganddrop.a(q2.g.a(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), j11, function1, null);
        return Build.VERSION.SDK_INT >= 24 ? a0.f5422a.a(this, gVar, aVar) : startDrag(gVar.a(), aVar, gVar.c(), gVar.b());
    }

    public final void O() {
        getLocationOnScreen(this.Q);
        long j11 = this.P;
        int iH = q2.p.h(j11);
        int i11 = q2.p.i(j11);
        int[] iArr = this.Q;
        boolean z11 = false;
        int i12 = iArr[0];
        if (iH != i12 || i11 != iArr[1]) {
            this.P = q2.q.a(i12, iArr[1]);
            if (iH != Integer.MAX_VALUE && i11 != Integer.MAX_VALUE) {
                getRoot().P().I().k1();
                z11 = true;
            }
        }
        this.N.c(z11);
    }

    public final void addAndroidView(AndroidViewHolder androidViewHolder, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        androidViewHolder.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView.addAndroidView.1
            /* JADX WARN: Code duplicated, block: B:13:0x003e  */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (AndroidComposeView.this.f5201s.c0()) {
                    accessibilityNodeInfoCompat.setVisibleToUser(false);
                }
                LayoutNode layoutNodeF = androidx.compose.ui.semantics.o.f(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.e0().q(androidx.compose.ui.node.s0.a(8)));
                    }
                });
                Integer numValueOf = layoutNodeF != null ? Integer.valueOf(layoutNodeF.j0()) : null;
                if (numValueOf != null) {
                    if (numValueOf.intValue() == AndroidComposeView.this.getSemanticsOwner().a().o()) {
                        numValueOf = -1;
                    }
                } else {
                    numValueOf = -1;
                }
                accessibilityNodeInfoCompat.setParent(this, numValueOf.intValue());
                int iJ0 = layoutNode.j0();
                int iE = AndroidComposeView.this.f5201s.R().e(iJ0, -1);
                if (iE != -1) {
                    View viewG = i2.g(AndroidComposeView.this.getAndroidViewsHandler$ui_release(), iE);
                    if (viewG != null) {
                        accessibilityNodeInfoCompat.setTraversalBefore(viewG);
                    } else {
                        accessibilityNodeInfoCompat.setTraversalBefore(this, iE);
                    }
                    AndroidComposeView.this.e(iJ0, accessibilityNodeInfoCompat.unwrap(), AndroidComposeView.this.f5201s.P());
                }
                int iE2 = AndroidComposeView.this.f5201s.Q().e(iJ0, -1);
                if (iE2 != -1) {
                    View viewG2 = i2.g(AndroidComposeView.this.getAndroidViewsHandler$ui_release(), iE2);
                    if (viewG2 != null) {
                        accessibilityNodeInfoCompat.setTraversalAfter(viewG2);
                    } else {
                        accessibilityNodeInfoCompat.setTraversalAfter(this, iE2);
                    }
                    AndroidComposeView.this.e(iJ0, accessibilityNodeInfoCompat.unwrap(), AndroidComposeView.this.f5201s.O());
                }
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        addView(view, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11) {
        Intrinsics.d(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, int i12) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i11;
        layoutParamsGenerateDefaultLayoutParams.height = i12;
        Unit unit = Unit.f68710a;
        addView(view, -1, layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i11, layoutParams, true);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addView(view, -1, layoutParams);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        x1.e eVar;
        if (!f() || (eVar = this.E) == null) {
            return;
        }
        x1.h.a(eVar, sparseArray);
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object objZ = this.f5201s.z(continuation);
        return objZ == kotlin.coroutines.intrinsics.a.e() ? objZ : Unit.f68710a;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) throws Throwable {
        Object objB = this.f5203t.b(continuation);
        return objB == kotlin.coroutines.intrinsics.a.e() ? objB : Unit.f68710a;
    }

    /* JADX INFO: renamed from: calculateLocalPosition-MK-Hz9U, reason: not valid java name */
    public long m66calculateLocalPositionMKHz9U(long j11) {
        C();
        return k4.f(this.T, j11);
    }

    @Override // androidx.compose.ui.node.y0
    /* JADX INFO: renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo61calculatePositionInWindowMKHz9U(long j11) {
        C();
        return k4.f(this.S, j11);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i11) {
        return this.f5201s.A(false, i11, this.f5166a);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i11) {
        return this.f5201s.A(true, i11, this.f5166a);
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.node.w0 createLayer(Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0, GraphicsLayer graphicsLayer) {
        int i11;
        if (graphicsLayer != null) {
            return new GraphicsLayerOwnerLayer(graphicsLayer, null, this, function2, function0);
        }
        androidx.compose.ui.node.w0 w0VarB = this.f5208v0.b();
        if (w0VarB != null) {
            w0VarB.reuseLayer(function2, function0);
            return w0VarB;
        }
        if (isHardwareAccelerated() && (i11 = Build.VERSION.SDK_INT) >= 23 && i11 != 28) {
            return new GraphicsLayerOwnerLayer(getGraphicsContext().a(), getGraphicsContext(), this, function2, function0);
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT >= 23 && this.f5167a0) {
            try {
                return new RenderNodeLayer(this, function2, function0);
            } catch (Throwable unused) {
                this.f5167a0 = false;
            }
        }
        if (this.K == null) {
            ViewLayer.b bVar = ViewLayer.Companion;
            if (!bVar.a()) {
                bVar.d(new View(getContext()));
            }
            DrawChildContainer drawChildContainer = bVar.b() ? new DrawChildContainer(getContext()) : new ViewLayerContainer(getContext());
            this.K = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.K;
        Intrinsics.d(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, function2, function0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            r(getRoot());
        }
        androidx.compose.ui.node.x0.c(this, false, 1, null);
        androidx.compose.runtime.snapshots.j.f3684e.n();
        this.f5215z = true;
        androidx.compose.ui.graphics.p1 p1Var = this.f5193o;
        Canvas canvasV = p1Var.a().v();
        p1Var.a().w(canvas);
        getRoot().y(p1Var.a(), null);
        p1Var.a().w(canvasV);
        if (true ^ this.f5211x.isEmpty()) {
            int size = this.f5211x.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f5211x.get(i11).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.b()) {
            int iSave = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(iSave);
        }
        this.f5211x.clear();
        this.f5215z = false;
        List<androidx.compose.ui.node.w0> list = this.f5213y;
        if (list != null) {
            Intrinsics.d(list);
            this.f5211x.addAll(list);
            list.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.f5216z0) {
            removeCallbacks(this.f5214y0);
            if (motionEvent.getActionMasked() == 8) {
                this.f5216z0 = false;
            } else {
                this.f5214y0.run();
            }
        }
        if (motionEvent.getActionMasked() != 8) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (t(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return motionEvent.isFromSource(4194304) ? p(motionEvent) : androidx.compose.ui.input.pointer.m0.c(o(motionEvent));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f5216z0) {
            removeCallbacks(this.f5214y0);
            this.f5214y0.run();
        }
        if (t(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        this.f5201s.I(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && v(motionEvent)) {
                if (motionEvent.getToolType(0) == 3 && motionEvent.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent2 = this.f5204t0;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f5204t0 = MotionEvent.obtainNoHistory(motionEvent);
                this.f5216z0 = true;
                postDelayed(this.f5214y0, 8L);
                return false;
            }
        } else if (!w(motionEvent)) {
            return false;
        }
        return androidx.compose.ui.input.pointer.m0.c(o(motionEvent));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (!isFocused()) {
            return getFocusOwner().h(e2.b.b(keyEvent), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(AndroidComposeView.super.dispatchKeyEvent(keyEvent));
                }
            });
        }
        this.f5187l.a(androidx.compose.ui.input.pointer.j0.b(keyEvent.getMetaState()));
        return FocusOwner$CC.a(getFocusOwner(), e2.b.b(keyEvent), null, 2, null) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return (isFocused() && getFocusOwner().e(e2.b.b(keyEvent))) || super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        int i11 = Build.VERSION.SDK_INT;
        if (23 > i11 || i11 >= 28) {
            super.dispatchProvideStructure(viewStructure);
        } else {
            w.f5554a.a(viewStructure, getView());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f5216z0) {
            removeCallbacks(this.f5214y0);
            MotionEvent motionEvent2 = this.f5204t0;
            Intrinsics.d(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || q(motionEvent, motionEvent2)) {
                this.f5214y0.run();
            } else {
                this.f5216z0 = false;
            }
        }
        if (t(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !w(motionEvent)) {
            return false;
        }
        int iO = o(motionEvent);
        if (androidx.compose.ui.input.pointer.m0.b(iO)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return androidx.compose.ui.input.pointer.m0.c(iO);
    }

    public final void drawAndroidView(AndroidViewHolder androidViewHolder, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(androidViewHolder, canvas);
    }

    public final void e(int i11, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int iE;
        if (Intrinsics.b(str, this.f5201s.P())) {
            int iE2 = this.f5201s.R().e(i11, -1);
            if (iE2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, iE2);
                return;
            }
            return;
        }
        if (!Intrinsics.b(str, this.f5201s.O()) || (iE = this.f5201s.Q().e(i11, -1)) == -1) {
            return;
        }
        accessibilityNodeInfo.getExtras().putInt(str, iE);
    }

    public final boolean f() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final View findViewByAccessibilityIdTraversal(int i11) throws IllegalAccessException, InvocationTargetException {
        View viewL = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i11));
                if (objInvoke instanceof View) {
                    viewL = (View) objInvoke;
                }
            } else {
                viewL = l(i11, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return viewL;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i11) {
        if (view != null) {
            y1.i iVarA = androidx.compose.ui.focus.g.a(view);
            androidx.compose.ui.focus.b bVarD = androidx.compose.ui.focus.g.d(i11);
            if (Intrinsics.b(getFocusOwner().a(bVarD != null ? bVarD.o() : androidx.compose.ui.focus.b.f3922b.a(), iVarA, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.focusSearch.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.TRUE;
                }
            }), Boolean.TRUE)) {
                return this;
            }
        }
        return super.focusSearch(view, i11);
    }

    public void forceAccessibilityForTesting(boolean z11) {
        this.f5201s.C0(z11);
    }

    @Override // androidx.compose.ui.node.y0
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z11) {
        this.N.i(layoutNode, z11);
    }

    public final boolean g(LayoutNode layoutNode) {
        LayoutNode layoutNodeH0;
        return this.M || !((layoutNodeH0 = layoutNode.h0()) == null || layoutNodeH0.K());
    }

    @Override // androidx.compose.ui.node.y0
    public i getAccessibilityManager() {
        return this.f5205u;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this.J == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this.J = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this.J;
        Intrinsics.d(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.y0
    public x1.i getAutofill() {
        return this.E;
    }

    @Override // androidx.compose.ui.node.y0
    public x1.d0 getAutofillTree() {
        return this.f5209w;
    }

    @Override // androidx.compose.ui.node.y0
    public j getClipboardManager() {
        return this.G;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.D;
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui_release() {
        return this.f5203t;
    }

    @Override // androidx.compose.ui.node.y0
    public CoroutineContext getCoroutineContext() {
        return this.f5183j;
    }

    @Override // androidx.compose.ui.node.y0
    public q2.e getDensity() {
        return (q2.e) this.f5172d.getValue();
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.draganddrop.c getDragAndDropManager() {
        return this.f5185k;
    }

    /* JADX INFO: renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    public androidx.compose.ui.focus.b m67getFocusDirectionP8AzH3I(KeyEvent keyEvent) {
        long jA = e2.d.a(keyEvent);
        e2.a.C0656a c0656a = e2.a.f63630b;
        if (e2.a.p(jA, c0656a.l())) {
            return androidx.compose.ui.focus.b.i(e2.d.d(keyEvent) ? androidx.compose.ui.focus.b.f3922b.f() : androidx.compose.ui.focus.b.f3922b.e());
        }
        if (e2.a.p(jA, c0656a.e())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f3922b.g());
        }
        if (e2.a.p(jA, c0656a.d())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f3922b.d());
        }
        if (e2.a.p(jA, c0656a.f()) || e2.a.p(jA, c0656a.k())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f3922b.h());
        }
        if (e2.a.p(jA, c0656a.c()) || e2.a.p(jA, c0656a.j())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f3922b.a());
        }
        if (e2.a.p(jA, c0656a.b()) || e2.a.p(jA, c0656a.g()) || e2.a.p(jA, c0656a.i())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f3922b.b());
        }
        if (e2.a.p(jA, c0656a.a()) || e2.a.p(jA, c0656a.h())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f3922b.c());
        }
        return null;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.focus.k getFocusOwner() {
        return this.f5179h;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Unit unit;
        y1.i iVarY = y();
        if (iVarY != null) {
            rect.left = Math.round(iVarY.f());
            rect.top = Math.round(iVarY.i());
            rect.right = Math.round(iVarY.g());
            rect.bottom = Math.round(iVarY.c());
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.text.font.i.b getFontFamilyResolver() {
        return (androidx.compose.ui.text.font.i.b) this.f5190m0.getValue();
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.text.font.h.a getFontLoader() {
        return this.f5188l0;
    }

    @Override // androidx.compose.ui.node.y0
    public c4 getGraphicsContext() {
        return this.f5207v;
    }

    @Override // androidx.compose.ui.node.y0
    public c2.a getHapticFeedBack() {
        return this.f5196p0;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.N.m();
    }

    @Override // androidx.compose.ui.node.y0
    public d2.b getInputModeManager() {
        return this.f5198q0;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.U;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.y0
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.f5194o0.getValue();
    }

    public long getMeasureIteration() {
        return this.N.q();
    }

    @Override // androidx.compose.ui.node.y0
    public ModifierLocalManager getModifierLocalManager() {
        return this.f5200r0;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.layout.k0.a getPlacementScope() {
        return PlaceableKt.b(this);
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.input.pointer.w getPointerIconService() {
        return this.E0;
    }

    @Override // androidx.compose.ui.node.y0
    public LayoutNode getRoot() {
        return this.f5195p;
    }

    public androidx.compose.ui.node.g1 getRootForTest() {
        return this.f5197q;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.D0) == null) {
            return false;
        }
        return scrollCapture.c();
    }

    public androidx.compose.ui.semantics.p getSemanticsOwner() {
        return this.f5199r;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.node.d0 getSharedDrawScope() {
        return this.f5170c;
    }

    @Override // androidx.compose.ui.node.y0
    public boolean getShowLayoutBounds() {
        return this.I;
    }

    @Override // androidx.compose.ui.node.y0
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.H;
    }

    @Override // androidx.compose.ui.node.y0
    public k2 getSoftwareKeyboardController() {
        return this.f5186k0;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.text.input.d0 getTextInputService() {
        return this.f5182i0;
    }

    @Override // androidx.compose.ui.node.y0
    public l2 getTextToolbar() {
        return this.f5202s0;
    }

    public View getView() {
        return this;
    }

    @Override // androidx.compose.ui.node.y0
    public r2 getViewConfiguration() {
        return this.O;
    }

    public final b getViewTreeOwners() {
        return (b) this.f5171c0.getValue();
    }

    @Override // androidx.compose.ui.node.y0
    public y2 getWindowInfo() {
        return this.f5187l;
    }

    public final void h(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                h((ViewGroup) childAt);
            }
        }
    }

    public final long i(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return B(0, size);
        }
        if (mode == 0) {
            return B(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
        if (mode == 1073741824) {
            return B(size, size);
        }
        throw new IllegalStateException();
    }

    public void invalidateDescendants() {
        r(getRoot());
    }

    public boolean isLifecycleInResumedState() {
        androidx.lifecycle.u uVarA;
        Lifecycle lifecycle;
        b viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (uVarA = viewTreeOwners.a()) == null || (lifecycle = uVarA.getLifecycle()) == null) ? null : lifecycle.b()) == Lifecycle.State.RESUMED;
    }

    public final void j() {
        if (this.A) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.A = false;
        }
    }

    public final View k(int i11) {
        View viewFindNextFocus = this;
        while (viewFindNextFocus != null) {
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.e(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, viewFindNextFocus, i11);
            if (viewFindNextFocus != null && !AndroidComposeView_androidKt.e(this, viewFindNextFocus)) {
                return viewFindNextFocus;
            }
        }
        return null;
    }

    public final View l(int i11, View view) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.b(declaredMethod.invoke(view, new Object[0]), Integer.valueOf(i11))) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View viewL = l(i11, viewGroup.getChildAt(i12));
            if (viewL != null) {
                return viewL;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.input.pointer.l0
    /* JADX INFO: renamed from: localToScreen-58bKbWc */
    public void mo53localToScreen58bKbWc(float[] fArr) {
        C();
        k4.n(fArr, this.S);
        AndroidComposeView_androidKt.j(fArr, y1.g.m(this.W), y1.g.n(this.W), this.R);
    }

    @Override // androidx.compose.ui.input.pointer.l0
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo54localToScreenMKHz9U(long j11) {
        C();
        long jF = k4.f(this.S, j11);
        return y1.h.a(y1.g.m(jF) + y1.g.m(this.W), y1.g.n(jF) + y1.g.n(this.W));
    }

    public final int m(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.y0
    public void measureAndLayout(boolean z11) {
        Function0<Unit> function0;
        if (this.N.m() || this.N.n()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z11) {
                try {
                    function0 = this.A0;
                } finally {
                    Trace.endSection();
                }
            } else {
                function0 = null;
            }
            if (this.N.r(function0)) {
                requestLayout();
            }
            androidx.compose.ui.node.k0.d(this.N, false, 1, null);
            j();
            Unit unit = Unit.f68710a;
        }
    }

    @Override // androidx.compose.ui.node.y0
    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw */
    public void mo62measureAndLayout0kLqBqw(LayoutNode layoutNode, long j11) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.N.s(layoutNode, j11);
            if (!this.N.m()) {
                androidx.compose.ui.node.k0.d(this.N, false, 1, null);
                j();
            }
            Unit unit = Unit.f68710a;
        } finally {
            Trace.endSection();
        }
    }

    public void measureAndLayoutForTest() {
        androidx.compose.ui.node.x0.c(this, false, 1, null);
    }

    public final void notifyLayerIsDirty$ui_release(androidx.compose.ui.node.w0 w0Var, boolean z11) {
        if (!z11) {
            if (this.f5215z) {
                return;
            }
            this.f5211x.remove(w0Var);
            List<androidx.compose.ui.node.w0> list = this.f5213y;
            if (list != null) {
                list.remove(w0Var);
                return;
            }
            return;
        }
        if (!this.f5215z) {
            this.f5211x.add(w0Var);
            return;
        }
        List arrayList = this.f5213y;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f5213y = arrayList;
        }
        arrayList.add(w0Var);
    }

    public final int o(MotionEvent motionEvent) {
        int i11;
        int i12;
        removeCallbacks(this.f5212x0);
        try {
            D(motionEvent);
            this.V = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent2 = this.f5204t0;
                boolean z11 = motionEvent2 != null && motionEvent2.getToolType(0) == 3;
                if (motionEvent2 == null || !q(motionEvent, motionEvent2)) {
                    i11 = 10;
                } else {
                    if (u(motionEvent2)) {
                        this.C.c();
                    } else if (motionEvent2.getActionMasked() != 10 && z11) {
                        i11 = 10;
                        L(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, null);
                    }
                    i11 = 10;
                }
                boolean z12 = motionEvent.getToolType(0) == 3;
                if (z11 || !z12 || actionMasked == 3 || actionMasked == 9 || !v(motionEvent)) {
                    i12 = 9;
                } else {
                    i12 = 9;
                    L(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                MotionEvent motionEvent3 = this.f5204t0;
                if (motionEvent3 != null && motionEvent3.getAction() == i11) {
                    MotionEvent motionEvent4 = this.f5204t0;
                    int pointerId = motionEvent4 != null ? motionEvent4.getPointerId(0) : -1;
                    if (motionEvent.getAction() == i12 && motionEvent.getHistorySize() == 0) {
                        if (pointerId >= 0) {
                            this.B.e(pointerId);
                        }
                    } else if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                        MotionEvent motionEvent5 = this.f5204t0;
                        float x11 = motionEvent5 != null ? motionEvent5.getX() : Float.NaN;
                        MotionEvent motionEvent6 = this.f5204t0;
                        boolean z13 = (x11 == motionEvent.getX() && (motionEvent6 != null ? motionEvent6.getY() : Float.NaN) == motionEvent.getY()) ? false : true;
                        MotionEvent motionEvent7 = this.f5204t0;
                        boolean z14 = (motionEvent7 != null ? motionEvent7.getEventTime() : -1L) != motionEvent.getEventTime();
                        if (z13 || z14) {
                            if (pointerId >= 0) {
                                this.B.e(pointerId);
                            }
                            this.C.a();
                        }
                    }
                }
                this.f5204t0 = MotionEvent.obtainNoHistory(motionEvent);
                int iJ = J(motionEvent);
                Trace.endSection();
                this.V = false;
                return iJ;
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } catch (Throwable th3) {
            this.V = false;
            throw th3;
        }
    }

    @Override // androidx.compose.ui.node.y0
    public void onAttach(LayoutNode layoutNode) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        androidx.lifecycle.u uVarA;
        Lifecycle lifecycle;
        androidx.lifecycle.u uVarA2;
        x1.e eVar;
        super.onAttachedToWindow();
        this.f5187l.b(hasWindowFocus());
        s(getRoot());
        r(getRoot());
        getSnapshotObserver().k();
        if (f() && (eVar = this.E) != null) {
            x1.b0.f79787a.a(eVar);
        }
        androidx.lifecycle.u uVarA3 = ViewTreeLifecycleOwner.a(this);
        f6.e eVarA = ViewTreeSavedStateRegistryOwner.a(this);
        b viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (uVarA3 != null && eVarA != null && (uVarA3 != viewTreeOwners.a() || eVarA != viewTreeOwners.a()))) {
            if (uVarA3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (eVarA == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (uVarA = viewTreeOwners.a()) != null && (lifecycle = uVarA.getLifecycle()) != null) {
                lifecycle.d(this);
            }
            uVarA3.getLifecycle().a(this);
            b bVar = new b(uVarA3, eVarA);
            set_viewTreeOwners(bVar);
            Function1<? super b, Unit> function1 = this.f5173d0;
            if (function1 != null) {
                function1.invoke(bVar);
            }
            this.f5173d0 = null;
        }
        this.f5198q0.b(isInTouchMode() ? d2.a.f62868b.b() : d2.a.f62868b.a());
        b viewTreeOwners2 = getViewTreeOwners();
        if (viewTreeOwners2 != null && (uVarA2 = viewTreeOwners2.a()) != null) {
            lifecycle2 = uVarA2.getLifecycle();
        }
        if (lifecycle2 == null) {
            h2.a.c("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle2.a(this);
        lifecycle2.a(this.f5203t);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f5174e0);
        getViewTreeObserver().addOnScrollChangedListener(this.f5176f0);
        getViewTreeObserver().addOnTouchModeChangeListener(this.f5178g0);
        if (Build.VERSION.SDK_INT >= 31) {
            f0.f5468a.b(this);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        o0 o0Var = (o0) SessionMutex.c(this.f5184j0);
        return o0Var == null ? this.f5180h0.i() : o0Var.b();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDensity(q2.a.a(getContext()));
        if (m(configuration) != this.f5192n0) {
            this.f5192n0 = m(configuration);
            setFontFamilyResolver(androidx.compose.ui.text.font.l.a(getContext()));
        }
        this.D.invoke(configuration);
    }

    @Override // androidx.lifecycle.f
    public /* bridge */ /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        o0 o0Var = (o0) SessionMutex.c(this.f5184j0);
        return o0Var == null ? this.f5180h0.f(editorInfo) : o0Var.a(editorInfo);
    }

    @Override // android.view.View
    @RequiresApi(VungleException.WEB_CRASH)
    public void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        this.f5203t.o(jArr, iArr, consumer);
    }

    @Override // androidx.lifecycle.f
    public /* bridge */ /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.compose.ui.node.y0
    public void onDetach(LayoutNode layoutNode) {
        this.N.v(layoutNode);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        x1.e eVar;
        androidx.lifecycle.u uVarA;
        super.onDetachedFromWindow();
        getSnapshotObserver().l();
        b viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle = (viewTreeOwners == null || (uVarA = viewTreeOwners.a()) == null) ? null : uVarA.getLifecycle();
        if (lifecycle == null) {
            h2.a.c("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle.d(this.f5203t);
        lifecycle.d(this);
        if (f() && (eVar = this.E) != null) {
            x1.b0.f79787a.b(eVar);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f5174e0);
        getViewTreeObserver().removeOnScrollChangedListener(this.f5176f0);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.f5178g0);
        if (Build.VERSION.SDK_INT >= 31) {
            f0.f5468a.a(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // androidx.compose.ui.node.y0
    public void onEndApplyChanges() {
        if (this.F) {
            getSnapshotObserver().b();
            this.F = false;
        }
        AndroidViewsHandler androidViewsHandler = this.J;
        if (androidViewsHandler != null) {
            h(androidViewsHandler);
        }
        while (this.f5210w0.u()) {
            int iR = this.f5210w0.r();
            for (int i11 = 0; i11 < iR; i11++) {
                Function0<Unit> function0 = this.f5210w0.q()[i11];
                this.f5210w0.C(i11, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.f5210w0.A(0, iR);
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        if (z11 || hasFocus()) {
            return;
        }
        getFocusOwner().n();
    }

    @Override // androidx.compose.ui.node.y0
    public void onInteropViewLayoutChange(View view) {
        this.A = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.N.r(this.A0);
        this.L = null;
        O();
        if (this.J != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    @Override // androidx.compose.ui.node.y0
    public void onLayoutChange(LayoutNode layoutNode) {
        this.f5201s.g0(layoutNode);
        this.f5203t.q(layoutNode);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                s(getRoot());
            }
            long jI = i(i11);
            int iB = (int) ULong.b(jI >>> 32);
            int iB2 = (int) ULong.b(jI & 4294967295L);
            long jI2 = i(i12);
            long jA = q2.b.f74225b.a(iB, iB2, (int) ULong.b(jI2 >>> 32), (int) ULong.b(4294967295L & jI2));
            q2.b bVar = this.L;
            if (bVar == null) {
                this.L = q2.b.a(jA);
                this.M = false;
            } else if (bVar == null || !q2.b.f(bVar.r(), jA)) {
                this.M = true;
            }
            this.N.I(jA);
            this.N.t();
            setMeasuredDimension(getRoot().m0(), getRoot().L());
            if (this.J != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().m0(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().L(), 1073741824));
            }
            Unit unit = Unit.f68710a;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.lifecycle.f
    public /* bridge */ /* synthetic */ void onPause(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i11) {
        x1.e eVar;
        if (!f() || viewStructure == null || (eVar = this.E) == null) {
            return;
        }
        x1.h.b(eVar, viewStructure);
    }

    @Override // androidx.compose.ui.node.y0
    public void onRequestMeasure(LayoutNode layoutNode, boolean z11, boolean z12, boolean z13) {
        if (z11) {
            if (this.N.D(layoutNode, z12) && z13) {
                F(layoutNode);
                return;
            }
            return;
        }
        if (this.N.G(layoutNode, z12) && z13) {
            F(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.y0
    public void onRequestRelayout(LayoutNode layoutNode, boolean z11, boolean z12) {
        if (z11) {
            if (this.N.C(layoutNode, z12)) {
                G(this, null, 1, null);
            }
        } else if (this.N.F(layoutNode, z12)) {
            G(this, null, 1, null);
        }
    }

    @Override // androidx.lifecycle.f
    public void onResume(androidx.lifecycle.u uVar) {
        setShowLayoutBounds(Companion.b());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        if (this.f5168b) {
            LayoutDirection layoutDirectionE = androidx.compose.ui.focus.g.e(i11);
            if (layoutDirectionE == null) {
                layoutDirectionE = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirectionE);
        }
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(Rect rect, Point point, Consumer<ScrollCaptureTarget> consumer) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.D0) == null) {
            return;
        }
        scrollCapture.d(this, getSemanticsOwner(), getCoroutineContext(), consumer);
    }

    @Override // androidx.compose.ui.node.y0
    public void onSemanticsChange() {
        this.f5201s.h0();
        this.f5203t.r();
    }

    @Override // androidx.lifecycle.f
    public /* bridge */ /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.e(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* bridge */ /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.f(this, uVar);
    }

    @Override // android.view.View
    @RequiresApi(VungleException.WEB_CRASH)
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> longSparseArray) {
        AndroidContentCaptureManager androidContentCaptureManager = this.f5203t;
        androidContentCaptureManager.t(androidContentCaptureManager, longSparseArray);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        boolean zB;
        this.f5187l.b(z11);
        this.C0 = true;
        super.onWindowFocusChanged(z11);
        if (!z11 || getShowLayoutBounds() == (zB = Companion.b())) {
            return;
        }
        setShowLayoutBounds(zB);
        invalidateDescendants();
    }

    public final boolean p(MotionEvent motionEvent) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        float f11 = -motionEvent.getAxisValue(26);
        return getFocusOwner().c(new g2.c(f11 * ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()), f11 * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), motionEvent.getEventTime(), motionEvent.getDeviceId()));
    }

    public final boolean q(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) ? false : true;
    }

    public final void r(LayoutNode layoutNode) {
        layoutNode.x0();
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            int i11 = 0;
            do {
                r(layoutNodeArrQ[i11]);
                i11++;
            } while (i11 < iR);
        }
    }

    public final boolean recycle$ui_release(androidx.compose.ui.node.w0 w0Var) {
        boolean z11 = this.K == null || ViewLayer.Companion.b() || Build.VERSION.SDK_INT >= 23;
        if (z11) {
            this.f5208v0.c(w0Var);
        }
        return z11;
    }

    @Override // androidx.compose.ui.node.y0
    public void registerOnEndApplyChangesListener(Function0<Unit> function0) {
        if (this.f5210w0.j(function0)) {
            return;
        }
        this.f5210w0.b(function0);
    }

    @Override // androidx.compose.ui.node.y0
    public void registerOnLayoutCompletedListener(androidx.compose.ui.node.y0.b bVar) {
        this.N.x(bVar);
        G(this, null, 1, null);
    }

    public final void removeAndroidView(final AndroidViewHolder androidViewHolder) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView.removeAndroidView.1
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
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(androidViewHolder);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.d(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(androidViewHolder));
                androidViewHolder.setImportantForAccessibility(0);
            }
        });
    }

    public final void requestClearInvalidObservations() {
        this.F = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i11, Rect rect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().j().getHasFocus()) {
            return super.requestFocus(i11, rect);
        }
        androidx.compose.ui.focus.b bVarD = androidx.compose.ui.focus.g.d(i11);
        final int iO = bVarD != null ? bVarD.o() : androidx.compose.ui.focus.b.f3922b.b();
        Boolean boolA = getFocusOwner().a(iO, rect != null ? w4.e(rect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.requestFocus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Boolean boolK = FocusTransactionsKt.k(focusTargetNode, iO);
                return Boolean.valueOf(boolK != null ? boolK.booleanValue() : false);
            }
        });
        if (boolA != null) {
            return boolA.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.y0
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.N.E(layoutNode);
        G(this, null, 1, null);
    }

    public final void s(LayoutNode layoutNode) {
        int i11 = 0;
        androidx.compose.ui.node.k0.H(this.N, layoutNode, false, 2, null);
        androidx.compose.runtime.collection.b<LayoutNode> bVarP0 = layoutNode.p0();
        int iR = bVarP0.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVarP0.q();
            do {
                s(layoutNodeArrQ[i11]);
                i11++;
            } while (i11 < iR);
        }
    }

    @Override // androidx.compose.ui.input.pointer.l0
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo55screenToLocalMKHz9U(long j11) {
        C();
        return k4.f(this.T, y1.h.a(y1.g.m(j11) - y1.g.m(this.W), y1.g.n(j11) - y1.g.n(this.W)));
    }

    /* JADX INFO: renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m68sendKeyEventZmokQxo(KeyEvent keyEvent) {
        return getFocusOwner().e(keyEvent) || FocusOwner$CC.a(getFocusOwner(), keyEvent, null, 2, null);
    }

    public void setAccessibilityEventBatchIntervalMillis(long j11) {
        this.f5201s.G0(j11);
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.D = function1;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.f5203t = androidContentCaptureManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.f5183j = coroutineContext;
        androidx.compose.ui.node.f fVarK = getRoot().e0().k();
        if (fVarK instanceof androidx.compose.ui.input.pointer.q0) {
            ((androidx.compose.ui.input.pointer.q0) fVarK).r0();
        }
        int iA = androidx.compose.ui.node.s0.a(16);
        if (!fVarK.getNode().o1()) {
            h2.a.b("visitSubtree called on an unattached node");
        }
        androidx.compose.ui.f.c cVarF1 = fVarK.getNode().f1();
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(fVarK);
        androidx.compose.ui.node.p0 p0Var = new androidx.compose.ui.node.p0();
        while (layoutNodeM != null) {
            if (cVarF1 == null) {
                cVarF1 = layoutNodeM.e0().k();
            }
            if ((cVarF1.e1() & iA) != 0) {
                while (cVarF1 != null) {
                    if ((cVarF1.j1() & iA) != 0) {
                        androidx.compose.ui.f.c cVarG = cVarF1;
                        androidx.compose.runtime.collection.b bVar = null;
                        while (cVarG != 0) {
                            if (cVarG instanceof androidx.compose.ui.node.e1) {
                                androidx.compose.ui.node.e1 e1Var = (androidx.compose.ui.node.e1) cVarG;
                                if (e1Var instanceof androidx.compose.ui.input.pointer.q0) {
                                    ((androidx.compose.ui.input.pointer.q0) e1Var).r0();
                                }
                            } else if ((cVarG.j1() & iA) != 0 && (cVarG instanceof androidx.compose.ui.node.i)) {
                                androidx.compose.ui.f.c cVarI1 = ((androidx.compose.ui.node.i) cVarG).I1();
                                int i11 = 0;
                                cVarG = cVarG;
                                while (cVarI1 != null) {
                                    if ((cVarI1.j1() & iA) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            cVarG = cVarI1;
                                        } else {
                                            if (bVar == null) {
                                                bVar = new androidx.compose.runtime.collection.b(new androidx.compose.ui.f.c[16], 0);
                                            }
                                            if (cVarG != 0) {
                                                bVar.b(cVarG);
                                                cVarG = 0;
                                            }
                                            bVar.b(cVarI1);
                                        }
                                    }
                                    cVarI1 = cVarI1.f1();
                                    cVarG = cVarG;
                                }
                                if (i11 == 1) {
                                }
                            }
                            cVarG = androidx.compose.ui.node.g.g(bVar);
                        }
                    }
                    cVarF1 = cVarF1.f1();
                }
            }
            p0Var.c(layoutNodeM.p0());
            layoutNodeM = p0Var.a() ? (LayoutNode) p0Var.b() : null;
            cVarF1 = null;
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j11) {
        this.U = j11;
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super b, Unit> function1) {
        b viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.f5173d0 = function1;
    }

    @Override // androidx.compose.ui.node.y0
    public void setShowLayoutBounds(boolean z11) {
        this.I = z11;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    public final boolean t(MotionEvent motionEvent) {
        boolean z11;
        float x11 = motionEvent.getX();
        if (Float.isInfinite(x11) || Float.isNaN(x11)) {
            z11 = true;
        } else {
            float y11 = motionEvent.getY();
            if (Float.isInfinite(y11) || Float.isNaN(y11)) {
                z11 = true;
            } else {
                float rawX = motionEvent.getRawX();
                if (Float.isInfinite(rawX) || Float.isNaN(rawX)) {
                    z11 = true;
                } else {
                    float rawY = motionEvent.getRawY();
                    if (Float.isInfinite(rawY) || Float.isNaN(rawY)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
            }
        }
        if (!z11) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i11 = 1; i11 < pointerCount; i11++) {
                float x12 = motionEvent.getX(i11);
                if (Float.isInfinite(x12) || Float.isNaN(x12)) {
                    z11 = true;
                } else {
                    float y12 = motionEvent.getY(i11);
                    if (Float.isInfinite(y12) || Float.isNaN(y12) || (Build.VERSION.SDK_INT >= 29 && !k1.f5499a.a(motionEvent, i11))) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    break;
                }
            }
        }
        return z11;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object textInputSession(Function2<Object, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) throws Throwable {
        C09371 c09371;
        if (continuation instanceof C09371) {
            c09371 = (C09371) continuation;
            int i11 = c09371.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c09371.label = i11 - Integer.MIN_VALUE;
            } else {
                c09371 = new C09371(continuation);
            }
        } else {
            c09371 = new C09371(continuation);
        }
        Object obj = c09371.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = c09371.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            AtomicReference atomicReference = this.f5184j0;
            Function1<kotlinx.coroutines.k0, o0> function1 = new Function1<kotlinx.coroutines.k0, o0>() { // from class: androidx.compose.ui.platform.AndroidComposeView.textInputSession.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final o0 invoke(kotlinx.coroutines.k0 k0Var) {
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    return new o0(androidComposeView, androidComposeView.getTextInputService(), k0Var);
                }
            };
            c09371.label = 1;
            if (SessionMutex.d(atomicReference, function1, function2, c09371) == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    public final boolean u(MotionEvent motionEvent) {
        int actionMasked;
        return motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    public final boolean v(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        return 0.0f <= x11 && x11 <= ((float) getWidth()) && 0.0f <= y11 && y11 <= ((float) getHeight());
    }

    public final boolean w(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.f5204t0) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    public final void x() {
        if (isFocused() || hasFocus()) {
            super.clearFocus();
        }
    }

    public final y1.i y() {
        if (isFocused()) {
            return getFocusOwner().l();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return androidx.compose.ui.focus.g.a(viewFindFocus);
        }
        return null;
    }

    public final boolean z(int i11) {
        androidx.compose.ui.focus.b.a aVar = androidx.compose.ui.focus.b.f3922b;
        if (androidx.compose.ui.focus.b.l(i11, aVar.b()) || androidx.compose.ui.focus.b.l(i11, aVar.c())) {
            return false;
        }
        Integer numC = androidx.compose.ui.focus.g.c(i11);
        if (numC == null) {
            throw new IllegalStateException("Invalid focus direction".toString());
        }
        int iIntValue = numC.intValue();
        y1.i iVarY = y();
        Rect rectB = iVarY != null ? w4.b(iVarY) : null;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View viewFindNextFocus = rectB == null ? focusFinder.findNextFocus(this, findFocus(), iIntValue) : focusFinder.findNextFocusFromRect(this, rectB, iIntValue);
        if (viewFindNextFocus != null) {
            return androidx.compose.ui.focus.g.b(viewFindNextFocus, Integer.valueOf(iIntValue), rectB);
        }
        return false;
    }
}
