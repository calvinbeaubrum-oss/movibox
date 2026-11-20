package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.h;
import androidx.compose.runtime.m;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.d0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.x;
import androidx.compose.ui.layout.y;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.y0;
import androidx.compose.ui.node.z0;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.platform.l1;
import androidx.compose.ui.semantics.n;
import androidx.compose.ui.semantics.q;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.u;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import q2.a0;
import q2.e;
import q2.g;
import q2.z;

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
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, h, z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollDispatcher f6191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f6192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f6193d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f6194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f6196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f6197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f6198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super f, Unit> f6199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f6200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function1<? super e, Unit> f6201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u f6202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f6.e f6203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f6204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<Unit> f6205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f6206r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f6207s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6208t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6209u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final NestedScrollingParentHelper f6210v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6211w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LayoutNode f6212x;
    public static final a Companion = new a(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Function1<AndroidViewHolder, Unit> f6189y = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", l = {565, 570}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $consumed;
        final /* synthetic */ long $viewVelocity;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z11, AndroidViewHolder androidViewHolder, long j11, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$consumed = z11;
            this.this$0 = androidViewHolder;
            this.$viewVelocity = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                if (this.$consumed) {
                    NestedScrollDispatcher nestedScrollDispatcher = this.this$0.f6191b;
                    long j11 = this.$viewVelocity;
                    long jA = z.f74266b.a();
                    this.label = 2;
                    if (nestedScrollDispatcher.a(j11, jA, this) == objE) {
                        return objE;
                    }
                } else {
                    NestedScrollDispatcher nestedScrollDispatcher2 = this.this$0.f6191b;
                    long jA2 = z.f74266b.a();
                    long j12 = this.$viewVelocity;
                    this.label = 1;
                    if (nestedScrollDispatcher2.a(jA2, j12, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 1 && i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", l = {583}, m = "invokeSuspend")
    public static final class C09391 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $toBeConsumed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C09391(long j11, Continuation<? super C09391> continuation) {
            super(2, continuation);
            this.$toBeConsumed = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidViewHolder.this.new C09391(this.$toBeConsumed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C09391) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                NestedScrollDispatcher nestedScrollDispatcher = AndroidViewHolder.this.f6191b;
                long j11 = this.$toBeConsumed;
                this.label = 1;
                if (nestedScrollDispatcher.c(j11, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidViewHolder(Context context, m mVar, int i11, NestedScrollDispatcher nestedScrollDispatcher, View view, y0 y0Var) {
        super(context);
        this.f6190a = i11;
        this.f6191b = nestedScrollDispatcher;
        this.f6192c = view;
        this.f6193d = y0Var;
        if (mVar != null) {
            WindowRecomposer_androidKt.i(this, mVar);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        this.f6194f = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.f6196h = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        this.f6197i = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        f.a aVar = f.f3863a;
        this.f6198j = aVar;
        this.f6200l = g.b(1.0f, 0.0f, 2, null);
        this.f6204p = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
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
                if (this.this$0.f6195g && this.this$0.isAttachedToWindow()) {
                    ViewParent parent = this.this$0.getView().getParent();
                    AndroidViewHolder androidViewHolder = this.this$0;
                    if (parent == androidViewHolder) {
                        androidViewHolder.getSnapshotObserver().i(this.this$0, AndroidViewHolder.f6189y, this.this$0.getUpdate());
                    }
                }
            }
        };
        this.f6205q = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runInvalidate$1
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
                this.this$0.getLayoutNode().w0();
            }
        };
        this.f6207s = new int[2];
        this.f6208t = Integer.MIN_VALUE;
        this.f6209u = Integer.MIN_VALUE;
        this.f6210v = new NestedScrollingParentHelper(this);
        Object[] objArr = 0 == true ? 1 : 0;
        final LayoutNode layoutNode = new LayoutNode(false, objArr, 3, null);
        layoutNode.n1(this);
        final f fVarA = d0.a(androidx.compose.ui.draw.h.b(PointerInteropFilter_androidKt.a(n.b(androidx.compose.ui.input.nestedscroll.c.a(aVar, c.f6219a, nestedScrollDispatcher), true, new Function1<q, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                invoke2(qVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(q qVar) {
            }
        }), this), new Function1<z1.g, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(z1.g gVar) {
                invoke2(gVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(z1.g gVar) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                LayoutNode layoutNode2 = layoutNode;
                AndroidViewHolder androidViewHolder2 = this;
                o1 o1VarE = gVar.Q0().e();
                if (androidViewHolder.getView().getVisibility() != 8) {
                    androidViewHolder.f6211w = true;
                    y0 y0VarG0 = layoutNode2.g0();
                    AndroidComposeView androidComposeView = y0VarG0 instanceof AndroidComposeView ? (AndroidComposeView) y0VarG0 : null;
                    if (androidComposeView != null) {
                        androidComposeView.drawAndroidView(androidViewHolder2, h0.d(o1VarE));
                    }
                    androidViewHolder.f6211w = false;
                }
            }
        }), new Function1<androidx.compose.ui.layout.m, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.m mVar2) {
                invoke2(mVar2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(androidx.compose.ui.layout.m mVar2) {
                c.f(this.$this_run, layoutNode);
                this.$this_run.f6193d.onInteropViewLayoutChange(this.$this_run);
            }
        });
        layoutNode.c(i11);
        layoutNode.h(this.f6198j.f(fVarA));
        this.f6199k = new Function1<f, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f fVar) {
                invoke2(fVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f fVar) {
                layoutNode.h(fVar.f(fVarA));
            }
        };
        layoutNode.b(this.f6200l);
        this.f6201m = new Function1<e, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e eVar) {
                layoutNode.b(eVar);
            }
        };
        layoutNode.q1(new Function1<y0, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y0 y0Var2) {
                invoke2(y0Var2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y0 y0Var2) {
                AndroidComposeView androidComposeView = y0Var2 instanceof AndroidComposeView ? (AndroidComposeView) y0Var2 : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(this.$this_run, layoutNode);
                }
                ViewParent parent = this.$this_run.getView().getParent();
                AndroidViewHolder androidViewHolder = this.$this_run;
                if (parent != androidViewHolder) {
                    androidViewHolder.addView(androidViewHolder.getView());
                }
            }
        });
        layoutNode.r1(new Function1<y0, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(y0 y0Var2) {
                invoke2(y0Var2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(y0 y0Var2) {
                AndroidComposeView androidComposeView = y0Var2 instanceof AndroidComposeView ? (AndroidComposeView) y0Var2 : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(this.$this_run);
                }
                this.$this_run.removeAllViewsInLayout();
            }
        });
        layoutNode.g(new androidx.compose.ui.layout.u() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            @Override // androidx.compose.ui.layout.u
            public w c(y yVar, List<? extends t> list, long j11) {
                if (this.f6213a.getChildCount() == 0) {
                    return x.b(yVar, q2.b.n(j11), q2.b.m(j11), null, new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar2) {
                            invoke2(aVar2);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(androidx.compose.ui.layout.k0.a aVar2) {
                        }
                    }, 4, null);
                }
                if (q2.b.n(j11) != 0) {
                    this.f6213a.getChildAt(0).setMinimumWidth(q2.b.n(j11));
                }
                if (q2.b.m(j11) != 0) {
                    this.f6213a.getChildAt(0).setMinimumHeight(q2.b.m(j11));
                }
                AndroidViewHolder androidViewHolder = this.f6213a;
                int iN = q2.b.n(j11);
                int iL = q2.b.l(j11);
                ViewGroup.LayoutParams layoutParams = this.f6213a.getLayoutParams();
                Intrinsics.d(layoutParams);
                int iC = androidViewHolder.c(iN, iL, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = this.f6213a;
                int iM = q2.b.m(j11);
                int iK = q2.b.k(j11);
                ViewGroup.LayoutParams layoutParams2 = this.f6213a.getLayoutParams();
                Intrinsics.d(layoutParams2);
                androidViewHolder.measure(iC, androidViewHolder2.c(iM, iK, layoutParams2.height));
                int measuredWidth = this.f6213a.getMeasuredWidth();
                int measuredHeight = this.f6213a.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder3 = this.f6213a;
                final LayoutNode layoutNode2 = layoutNode;
                return x.b(yVar, measuredWidth, measuredHeight, null, new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar2) {
                        invoke2(aVar2);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.compose.ui.layout.k0.a aVar2) {
                        c.f(androidViewHolder3, layoutNode2);
                    }
                }, 4, null);
            }
        });
        this.f6212x = layoutNode;
    }

    public static final void b(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            h2.a.b("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.f6193d.getSnapshotObserver();
    }

    public final int c(int i11, int i12, int i13) {
        if (i13 >= 0 || i11 == i12) {
            return View.MeasureSpec.makeMeasureSpec(kotlin.ranges.a.k(i13, i11, i12), 1073741824);
        }
        if (i13 != -2 || i12 == Integer.MAX_VALUE) {
            return (i13 != -1 || i12 == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.f6207s);
        int[] iArr = this.f6207s;
        int i11 = iArr[0];
        region.op(i11, iArr[1], i11 + getWidth(), this.f6207s[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public final e getDensity() {
        return this.f6200l;
    }

    public final View getInteropView() {
        return this.f6192c;
    }

    public final LayoutNode getLayoutNode() {
        return this.f6212x;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.f6192c.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final u getLifecycleOwner() {
        return this.f6202n;
    }

    public final f getModifier() {
        return this.f6198j;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f6210v.getNestedScrollAxes();
    }

    public final Function1<e, Unit> getOnDensityChanged$ui_release() {
        return this.f6201m;
    }

    public final Function1<f, Unit> getOnModifierChanged$ui_release() {
        return this.f6199k;
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.f6206r;
    }

    public final Function0<Unit> getRelease() {
        return this.f6197i;
    }

    public final Function0<Unit> getReset() {
        return this.f6196h;
    }

    public final f6.e getSavedStateRegistryOwner() {
        return this.f6203o;
    }

    public final Function0<Unit> getUpdate() {
        return this.f6194f;
    }

    public final View getView() {
        return this.f6192c;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        invalidateOrDefer();
        return null;
    }

    public final void invalidateOrDefer() {
        if (!this.f6211w) {
            this.f6212x.w0();
            return;
        }
        View view = this.f6192c;
        final Function0<Unit> function0 = this.f6205q;
        view.postOnAnimation(new Runnable() { // from class: androidx.compose.ui.viewinterop.a
            @Override // java.lang.Runnable
            public final void run() {
                AndroidViewHolder.b(function0);
            }
        });
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f6192c.isNestedScrollingEnabled();
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6204p.invoke();
    }

    @Override // androidx.compose.runtime.h
    public void onDeactivate() {
        this.f6196h.invoke();
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidateOrDefer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f6192c.layout(0, 0, i13 - i11, i14 - i12);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.f6192c.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i11), View.MeasureSpec.getSize(i12));
            return;
        }
        if (this.f6192c.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        this.f6192c.measure(i11, i12);
        setMeasuredDimension(this.f6192c.getMeasuredWidth(), this.f6192c.getMeasuredHeight());
        this.f6208t = i11;
        this.f6209u = i12;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        j.d(this.f6191b.e(), null, null, new AnonymousClass1(z11, this, a0.a(c.h(f11), c.h(f12)), null), 3, null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        j.d(this.f6191b.e(), null, null, new C09391(a0.a(c.h(f11), c.h(f12)), null), 3, null);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (isNestedScrollingEnabled()) {
            long jD = this.f6191b.d(y1.h.a(c.g(i11), c.g(i12)), c.i(i13));
            iArr[0] = l1.b(y1.g.m(jD));
            iArr[1] = l1.b(y1.g.n(jD));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        if (isNestedScrollingEnabled()) {
            this.f6191b.b(y1.h.a(c.g(i11), c.g(i12)), y1.h.a(c.g(i13), c.g(i14)), c.i(i15));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (isNestedScrollingEnabled()) {
            long jB = this.f6191b.b(y1.h.a(c.g(i11), c.g(i12)), y1.h.a(c.g(i13), c.g(i14)), c.i(i15));
            iArr[0] = l1.b(y1.g.m(jB));
            iArr[1] = l1.b(y1.g.n(jB));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        this.f6210v.onNestedScrollAccepted(view, view2, i11, i12);
    }

    @Override // androidx.compose.runtime.h
    public void onRelease() {
        this.f6197i.invoke();
    }

    @Override // androidx.compose.runtime.h
    public void onReuse() {
        if (this.f6192c.getParent() != this) {
            addView(this.f6192c);
        } else {
            this.f6196h.invoke();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        return ((i11 & 2) == 0 && (i11 & 1) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        this.f6210v.onStopNestedScroll(view, i11);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        if (Build.VERSION.SDK_INT >= 23 || i11 != 0) {
            return;
        }
        this.f6212x.w0();
    }

    public final void remeasure() {
        int i11;
        int i12 = this.f6208t;
        if (i12 == Integer.MIN_VALUE || (i11 = this.f6209u) == Integer.MIN_VALUE) {
            return;
        }
        measure(i12, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        Function1<? super Boolean, Unit> function1 = this.f6206r;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z11));
        }
        super.requestDisallowInterceptTouchEvent(z11);
    }

    public final void setDensity(e eVar) {
        if (eVar != this.f6200l) {
            this.f6200l = eVar;
            Function1<? super e, Unit> function1 = this.f6201m;
            if (function1 != null) {
                function1.invoke(eVar);
            }
        }
    }

    public final void setLifecycleOwner(u uVar) {
        if (uVar != this.f6202n) {
            this.f6202n = uVar;
            ViewTreeLifecycleOwner.b(this, uVar);
        }
    }

    public final void setModifier(f fVar) {
        if (fVar != this.f6198j) {
            this.f6198j = fVar;
            Function1<? super f, Unit> function1 = this.f6199k;
            if (function1 != null) {
                function1.invoke(fVar);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(Function1<? super e, Unit> function1) {
        this.f6201m = function1;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super f, Unit> function1) {
        this.f6199k = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.f6206r = function1;
    }

    public final void setRelease(Function0<Unit> function0) {
        this.f6197i = function0;
    }

    public final void setReset(Function0<Unit> function0) {
        this.f6196h = function0;
    }

    public final void setSavedStateRegistryOwner(f6.e eVar) {
        if (eVar != this.f6203o) {
            this.f6203o = eVar;
            ViewTreeSavedStateRegistryOwner.b(this, eVar);
        }
    }

    public final void setUpdate(Function0<Unit> function0) {
        this.f6194f = function0;
        this.f6195g = true;
        this.f6204p.invoke();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }
}
