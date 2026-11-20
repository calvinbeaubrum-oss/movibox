package androidx.compose.ui.platform;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$string;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;

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
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final d L = new d(null);
    public static final int M = 8;
    public static final androidx.collection.l N = androidx.collection.m.a(R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31);
    public androidx.collection.a0 A;
    public androidx.collection.a0 B;
    public final String C;
    public final String D;
    public final androidx.compose.ui.text.platform.s E;
    public androidx.collection.c0<g2> F;
    public g2 G;
    public boolean H;
    public final Runnable I;
    public final List<f2> J;
    public final Function1<f2, Unit> K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f5224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5225b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super AccessibilityEvent, Boolean> f5226c = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(this.this$0.Y().getParent().requestSendAccessibilityEvent(this.this$0.Y(), accessibilityEvent));
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccessibilityManager f5227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AccessibilityManager.AccessibilityStateChangeListener f5230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager.TouchExplorationStateChangeListener f5231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<AccessibilityServiceInfo> f5232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f5233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f5234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AccessibilityNodeInfoCompat f5236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final androidx.collection.c0<androidx.compose.ui.semantics.j> f5238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.collection.c0<androidx.compose.ui.semantics.j> f5239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.collection.w0<androidx.collection.w0<CharSequence>> f5240q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public androidx.collection.w0<androidx.collection.i0<CharSequence>> f5241r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5242s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f5243t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.collection.b<LayoutNode> f5244u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final kotlinx.coroutines.channels.a<Unit> f5245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f5246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f f5247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public androidx.collection.n<h2> f5248y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.collection.d0 f5249z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
            y1.i iVarJ = semanticsNode.j();
            y1.i iVarJ2 = semanticsNode2.j();
            int iCompare = Float.compare(iVarJ.f(), iVarJ2.f());
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompare2 = Float.compare(iVarJ.i(), iVarJ2.i());
            if (iCompare2 != 0) {
                return iCompare2;
            }
            int iCompare3 = Float.compare(iVarJ.c(), iVarJ2.c());
            return iCompare3 != 0 ? iCompare3 : Float.compare(iVarJ.g(), iVarJ2.g());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
            y1.i iVarJ = semanticsNode.j();
            y1.i iVarJ2 = semanticsNode2.j();
            int iCompare = Float.compare(iVarJ2.g(), iVarJ.g());
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompare2 = Float.compare(iVarJ.i(), iVarJ2.i());
            if (iCompare2 != 0) {
                return iCompare2;
            }
            int iCompare3 = Float.compare(iVarJ.c(), iVarJ2.c());
            return iCompare3 != 0 ? iCompare3 : Float.compare(iVarJ2.f(), iVarJ.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class TopBottomBoundsComparator implements Comparator<Pair<? extends y1.i, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Pair<? extends y1.i, ? extends List<SemanticsNode>> pair, Pair<? extends y1.i, ? extends List<SemanticsNode>> pair2) {
            return compare2((Pair<y1.i, ? extends List<SemanticsNode>>) pair, (Pair<y1.i, ? extends List<SemanticsNode>>) pair2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Pair<y1.i, ? extends List<SemanticsNode>> pair, Pair<y1.i, ? extends List<SemanticsNode>> pair2) {
            int iCompare = Float.compare(pair.getFirst().i(), pair2.getFirst().i());
            return iCompare != 0 ? iCompare : Float.compare(pair.getFirst().c(), pair2.getFirst().c());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AccessibilityManager accessibilityManager = AndroidComposeViewAccessibilityDelegateCompat.this.f5227d;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            accessibilityManager.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5230g);
            accessibilityManager.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5231h);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AndroidComposeViewAccessibilityDelegateCompat.this.f5233j.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.I);
            AccessibilityManager accessibilityManager = AndroidComposeViewAccessibilityDelegateCompat.this.f5227d;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            accessibilityManager.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5230g);
            accessibilityManager.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f5231h);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5251a = new b();

        @JvmStatic
        public static final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            androidx.compose.ui.semantics.a aVar;
            if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode) || (aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), androidx.compose.ui.semantics.k.f5661a.v())) == null) {
                return;
            }
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionSetProgress, aVar.b()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5252a = new c();

        @JvmStatic
        public static final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
                androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
                androidx.compose.ui.semantics.k kVar = androidx.compose.ui.semantics.k.f5661a;
                androidx.compose.ui.semantics.a aVar = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW, kVar.p());
                if (aVar != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, aVar.b()));
                }
                androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.m());
                if (aVar2 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, aVar2.b()));
                }
                androidx.compose.ui.semantics.a aVar3 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.n());
                if (aVar3 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageLeft, aVar3.b()));
                }
                androidx.compose.ui.semantics.a aVar4 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.o());
                if (aVar4 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageRight, aVar4.b()));
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d {
        public d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class e extends AccessibilityNodeProviderCompat {
        public e() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.x(i11, accessibilityNodeInfoCompat, str, bundle);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i11) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatF = AndroidComposeViewAccessibilityDelegateCompat.this.F(i11);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.f5237n && i11 == androidComposeViewAccessibilityDelegateCompat.f5235l) {
                androidComposeViewAccessibilityDelegateCompat.f5236m = accessibilityNodeInfoCompatF;
            }
            return accessibilityNodeInfoCompatF;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i11) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.f5235l);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i11, int i12, Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.i0(i11, i12, bundle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SemanticsNode f5254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f5259f;

        public f(SemanticsNode semanticsNode, int i11, int i12, int i13, int i14, long j11) {
            this.f5254a = semanticsNode;
            this.f5255b = i11;
            this.f5256c = i12;
            this.f5257d = i13;
            this.f5258e = i14;
            this.f5259f = j11;
        }

        public final int a() {
            return this.f5255b;
        }

        public final int b() {
            return this.f5257d;
        }

        public final int c() {
            return this.f5256c;
        }

        public final SemanticsNode d() {
            return this.f5254a;
        }

        public final int e() {
            return this.f5258e;
        }

        public final long f() {
            return this.f5259f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5260a;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5260a = iArr;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.f5224a = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.f5227d = accessibilityManager;
        this.f5229f = 100L;
        this.f5230g = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.r
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z11) {
                AndroidComposeViewAccessibilityDelegateCompat.J(this.f5544a, z11);
            }
        };
        this.f5231h = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.s
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z11) {
                AndroidComposeViewAccessibilityDelegateCompat.Q0(this.f5546a, z11);
            }
        };
        this.f5232i = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.f5233j = new Handler(Looper.getMainLooper());
        this.f5234k = new e();
        this.f5235l = Integer.MIN_VALUE;
        this.f5238o = new androidx.collection.c0<>(0, 1, null);
        this.f5239p = new androidx.collection.c0<>(0, 1, null);
        this.f5240q = new androidx.collection.w0<>(0, 1, null);
        this.f5241r = new androidx.collection.w0<>(0, 1, null);
        this.f5242s = -1;
        this.f5244u = new androidx.collection.b<>(0, 1, null);
        this.f5245v = kotlinx.coroutines.channels.d.b(1, null, null, 6, null);
        this.f5246w = true;
        this.f5248y = androidx.collection.o.a();
        this.f5249z = new androidx.collection.d0(0, 1, null);
        this.A = new androidx.collection.a0(0, 1, null);
        this.B = new androidx.collection.a0(0, 1, null);
        this.C = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.D = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.E = new androidx.compose.ui.text.platform.s();
        this.F = androidx.collection.o.b();
        this.G = new g2(androidComposeView.getSemanticsOwner().a(), androidx.collection.o.a());
        androidComposeView.addOnAttachStateChangeListener(new a());
        this.I = new Runnable() { // from class: androidx.compose.ui.platform.t
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.r0(this.f5548a);
            }
        };
        this.J = new ArrayList();
        this.K = new Function1<f2, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f2 f2Var) {
                invoke2(f2Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(f2 f2Var) {
                this.this$0.q0(f2Var);
            }
        };
    }

    public static final void J(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z11) {
        androidComposeViewAccessibilityDelegateCompat.f5232i = z11 ? androidComposeViewAccessibilityDelegateCompat.f5227d.getEnabledAccessibilityServiceList(-1) : kotlin.collections.g.l();
    }

    public static final int L0(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static final boolean M0(ArrayList<Pair<y1.i, List<SemanticsNode>>> arrayList, SemanticsNode semanticsNode) {
        float fI = semanticsNode.j().i();
        float fC = semanticsNode.j().c();
        boolean z11 = fI >= fC;
        int iN = kotlin.collections.g.n(arrayList);
        if (iN >= 0) {
            int i11 = 0;
            while (true) {
                y1.i first = arrayList.get(i11).getFirst();
                boolean z12 = first.i() >= first.c();
                if (!z11 && !z12 && Math.max(fI, first.i()) < Math.min(fC, first.c())) {
                    arrayList.set(i11, new Pair<>(first.l(0.0f, fI, Float.POSITIVE_INFINITY, fC), arrayList.get(i11).getSecond()));
                    arrayList.get(i11).getSecond().add(semanticsNode);
                    return true;
                }
                if (i11 != iN) {
                    i11++;
                }
            }
        }
        return false;
    }

    public static final void Q0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z11) {
        androidComposeViewAccessibilityDelegateCompat.f5232i = androidComposeViewAccessibilityDelegateCompat.f5227d.getEnabledAccessibilityServiceList(-1);
    }

    public static final boolean j0(androidx.compose.ui.semantics.j jVar, float f11) {
        return (f11 < 0.0f && jVar.c().invoke().floatValue() > 0.0f) || (f11 > 0.0f && jVar.c().invoke().floatValue() < jVar.a().invoke().floatValue());
    }

    public static final float k0(float f11, float f12) {
        if (Math.signum(f11) == Math.signum(f12)) {
            return Math.abs(f11) < Math.abs(f12) ? f11 : f12;
        }
        return 0.0f;
    }

    public static final boolean m0(androidx.compose.ui.semantics.j jVar) {
        return (jVar.c().invoke().floatValue() > 0.0f && !jVar.b()) || (jVar.c().invoke().floatValue() < jVar.a().invoke().floatValue() && jVar.b());
    }

    public static final boolean n0(androidx.compose.ui.semantics.j jVar) {
        return (jVar.c().invoke().floatValue() < jVar.a().invoke().floatValue() && !jVar.b()) || (jVar.c().invoke().floatValue() > 0.0f && jVar.b());
    }

    public static final void r0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            androidx.compose.ui.node.x0.c(androidComposeViewAccessibilityDelegateCompat.f5224a, false, 1, null);
            Unit unit = Unit.f68710a;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.C();
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.H = false;
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean w0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i11, int i12, Integer num, List list, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            num = null;
        }
        if ((i13 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.v0(i11, i12, num, list);
    }

    public final boolean A(boolean z11, int i11, long j11) {
        if (Intrinsics.b(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return B(N(), z11, i11, j11);
        }
        return false;
    }

    public final void A0(LayoutNode layoutNode, androidx.collection.d0 d0Var) {
        androidx.compose.ui.semantics.l lVarF;
        LayoutNode layoutNodeK;
        if (layoutNode.D0() && !this.f5224a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.e0().q(androidx.compose.ui.node.s0.a(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.k(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.e0().q(androidx.compose.ui.node.s0.a(8)));
                    }
                });
            }
            if (layoutNode == null || (lVarF = layoutNode.F()) == null) {
                return;
            }
            if (!lVarF.v() && (layoutNodeK = AndroidComposeViewAccessibilityDelegateCompat_androidKt.k(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode2) {
                    androidx.compose.ui.semantics.l lVarF2 = layoutNode2.F();
                    boolean z11 = false;
                    if (lVarF2 != null && lVarF2.v()) {
                        z11 = true;
                    }
                    return Boolean.valueOf(z11);
                }
            })) != null) {
                layoutNode = layoutNodeK;
            }
            int iJ0 = layoutNode.j0();
            if (d0Var.f(iJ0)) {
                w0(this, s0(iJ0), 2048, 1, null, 8, null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00af  */
    public final boolean B(androidx.collection.n<h2> nVar, boolean z11, int i11, long j11) {
        SemanticsPropertyKey<androidx.compose.ui.semantics.j> semanticsPropertyKeyK;
        boolean z12;
        androidx.compose.ui.semantics.j jVar;
        if (y1.g.j(j11, y1.g.f81070b.b()) || !y1.g.p(j11)) {
            return false;
        }
        if (z11) {
            semanticsPropertyKeyK = SemanticsProperties.f5594a.H();
        } else {
            if (z11) {
                throw new NoWhenBranchMatchedException();
            }
            semanticsPropertyKeyK = SemanticsProperties.f5594a.k();
        }
        Object[] objArr = nVar.f1953c;
        long[] jArr = nVar.f1951a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i12 = 0;
            boolean z13 = false;
            while (true) {
                long j12 = jArr[i12];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((j12 & 255) < 128) {
                            h2 h2Var = (h2) objArr[(i12 << 3) + i14];
                            if (w4.e(h2Var.a()).b(j11) && (jVar = (androidx.compose.ui.semantics.j) SemanticsConfigurationKt.a(h2Var.b().w(), semanticsPropertyKeyK)) != null) {
                                int i15 = jVar.b() ? -i11 : i11;
                                if (!(i11 == 0 && jVar.b()) && i15 >= 0) {
                                    if (jVar.c().invoke().floatValue() < jVar.a().invoke().floatValue()) {
                                        z13 = true;
                                    }
                                } else if (jVar.c().invoke().floatValue() > 0.0f) {
                                    z13 = true;
                                }
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i13 != 8) {
                        return z13;
                    }
                }
                if (i12 != length) {
                    i12++;
                } else {
                    z12 = z13;
                }
            }
        } else {
            z12 = false;
        }
        return z12;
    }

    public final void B0(LayoutNode layoutNode) {
        if (layoutNode.D0() && !this.f5224a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int iJ0 = layoutNode.j0();
            androidx.compose.ui.semantics.j jVarC = this.f5238o.c(iJ0);
            androidx.compose.ui.semantics.j jVarC2 = this.f5239p.c(iJ0);
            if (jVarC == null && jVarC2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventE = E(iJ0, 4096);
            if (jVarC != null) {
                accessibilityEventE.setScrollX((int) jVarC.c().invoke().floatValue());
                accessibilityEventE.setMaxScrollX((int) jVarC.a().invoke().floatValue());
            }
            if (jVarC2 != null) {
                accessibilityEventE.setScrollY((int) jVarC2.c().invoke().floatValue());
                accessibilityEventE.setMaxScrollY((int) jVarC2.a().invoke().floatValue());
            }
            u0(accessibilityEventE);
        }
    }

    public final void C() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (c0()) {
                t0(this.f5224a.getSemanticsOwner().a(), this.G);
            }
            Unit unit = Unit.f68710a;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                z0(N());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    U0();
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }

    public final void C0(boolean z11) {
        this.f5228e = z11;
        this.f5246w = true;
    }

    public final boolean D(int i11) {
        if (!a0(i11)) {
            return false;
        }
        this.f5235l = Integer.MIN_VALUE;
        this.f5236m = null;
        this.f5224a.invalidate();
        w0(this, i11, 65536, null, null, 12, null);
        return true;
    }

    public final boolean D0(SemanticsNode semanticsNode, int i11, int i12, boolean z11) {
        String strV;
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        androidx.compose.ui.semantics.k kVar = androidx.compose.ui.semantics.k.f5661a;
        if (lVarW.f(kVar.w()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
            Function3 function3 = (Function3) ((androidx.compose.ui.semantics.a) semanticsNode.w().j(kVar.w())).a();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11))).booleanValue();
            }
            return false;
        }
        if ((i11 == i12 && i12 == this.f5242s) || (strV = V(semanticsNode)) == null) {
            return false;
        }
        if (i11 < 0 || i11 != i12 || i12 > strV.length()) {
            i11 = -1;
        }
        this.f5242s = i11;
        boolean z12 = strV.length() > 0;
        u0(H(s0(semanticsNode.o()), z12 ? Integer.valueOf(this.f5242s) : null, z12 ? Integer.valueOf(this.f5242s) : null, z12 ? Integer.valueOf(strV.length()) : null, strV));
        y0(semanticsNode.o());
        return true;
    }

    public final AccessibilityEvent E(int i11, int i12) {
        h2 h2VarC;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i12);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        accessibilityEventObtain.setPackageName(this.f5224a.getContext().getPackageName());
        accessibilityEventObtain.setSource(this.f5224a, i11);
        if (c0() && (h2VarC = N().c(i11)) != null) {
            accessibilityEventObtain.setPassword(h2VarC.b().w().f(SemanticsProperties.f5594a.v()));
        }
        return accessibilityEventObtain;
    }

    public final void E0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        if (lVarW.f(semanticsProperties.h())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.h()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat F(int i11) {
        androidx.lifecycle.u uVarA;
        Lifecycle lifecycle;
        AndroidComposeView.b viewTreeOwners = this.f5224a.getViewTreeOwners();
        if (((viewTreeOwners == null || (uVarA = viewTreeOwners.a()) == null || (lifecycle = uVarA.getLifecycle()) == null) ? null : lifecycle.b()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        h2 h2VarC = N().c(i11);
        if (h2VarC == null) {
            return null;
        }
        SemanticsNode semanticsNodeB = h2VarC.b();
        if (i11 == -1) {
            ViewParent parentForAccessibility = this.f5224a.getParentForAccessibility();
            accessibilityNodeInfoCompatObtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode semanticsNodeR = semanticsNodeB.r();
            Integer numValueOf = semanticsNodeR != null ? Integer.valueOf(semanticsNodeR.o()) : null;
            if (numValueOf == null) {
                h2.a.c("semanticsNode " + i11 + " has null parent");
                throw new KotlinNothingValueException();
            }
            int iIntValue = numValueOf.intValue();
            accessibilityNodeInfoCompatObtain.setParent(this.f5224a, iIntValue != this.f5224a.getSemanticsOwner().a().o() ? iIntValue : -1);
        }
        accessibilityNodeInfoCompatObtain.setSource(this.f5224a, i11);
        accessibilityNodeInfoCompatObtain.setBoundsInScreen(y(h2VarC));
        l0(i11, accessibilityNodeInfoCompatObtain, semanticsNodeB);
        return accessibilityNodeInfoCompatObtain;
    }

    public final void F0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setCheckable(S(semanticsNode));
    }

    public final String G(SemanticsNode semanticsNode) {
        Collection collection;
        CharSequence charSequence;
        androidx.compose.ui.semantics.l lVarN = semanticsNode.a().n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        Collection collection2 = (Collection) SemanticsConfigurationKt.a(lVarN, semanticsProperties.d());
        if ((collection2 == null || collection2.isEmpty()) && (((collection = (Collection) SemanticsConfigurationKt.a(lVarN, semanticsProperties.C())) == null || collection.isEmpty()) && ((charSequence = (CharSequence) SemanticsConfigurationKt.a(lVarN, semanticsProperties.g())) == null || charSequence.length() == 0))) {
            return this.f5224a.getContext().getResources().getString(R$string.state_empty);
        }
        return null;
    }

    public final void G0(long j11) {
        this.f5229f = j11;
    }

    public final AccessibilityEvent H(int i11, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventE = E(i11, 8192);
        if (num != null) {
            accessibilityEventE.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventE.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventE.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventE.getText().add(charSequence);
        }
        return accessibilityEventE;
    }

    public final void H0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setStateDescription(T(semanticsNode));
    }

    public final boolean I(MotionEvent motionEvent) {
        if (!e0()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iZ = Z(motionEvent.getX(), motionEvent.getY());
            boolean zDispatchGenericMotionEvent = this.f5224a.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            T0(iZ);
            if (iZ == Integer.MIN_VALUE) {
                return zDispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.f5225b == Integer.MIN_VALUE) {
            return this.f5224a.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
        }
        T0(Integer.MIN_VALUE);
        return true;
    }

    public final void I0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString annotatedStringU = U(semanticsNode);
        accessibilityNodeInfoCompat.setText(annotatedStringU != null ? P0(annotatedStringU) : null);
    }

    public final void J0() {
        this.A.i();
        this.B.i();
        h2 h2VarC = N().c(-1);
        SemanticsNode semanticsNodeB = h2VarC != null ? h2VarC.b() : null;
        Intrinsics.d(semanticsNodeB);
        int i11 = 1;
        List<SemanticsNode> listN0 = N0(AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNodeB), kotlin.collections.g.q(semanticsNodeB));
        int iN = kotlin.collections.g.n(listN0);
        if (1 > iN) {
            return;
        }
        while (true) {
            int iO = listN0.get(i11 - 1).o();
            int iO2 = listN0.get(i11).o();
            this.A.q(iO, iO2);
            this.B.q(iO2, iO);
            if (i11 == iN) {
                return;
            } else {
                i11++;
            }
        }
    }

    public final void K(SemanticsNode semanticsNode, ArrayList<SemanticsNode> arrayList, androidx.collection.c0<List<SemanticsNode>> c0Var) {
        boolean zL = AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNode);
        boolean zBooleanValue = ((Boolean) semanticsNode.w().r(SemanticsProperties.f5594a.r(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$geometryDepthFirstSearch$isTraversalGroup$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue();
        if ((zBooleanValue || d0(semanticsNode)) && N().b(semanticsNode.o())) {
            arrayList.add(semanticsNode);
        }
        if (zBooleanValue) {
            c0Var.t(semanticsNode.o(), N0(zL, CollectionsKt___CollectionsKt.M0(semanticsNode.k())));
            return;
        }
        List<SemanticsNode> listK = semanticsNode.k();
        int size = listK.size();
        for (int i11 = 0; i11 < size; i11++) {
            K(listK.get(i11), arrayList, c0Var);
        }
    }

    public final List<SemanticsNode> K0(boolean z11, ArrayList<SemanticsNode> arrayList, androidx.collection.c0<List<SemanticsNode>> c0Var) {
        ArrayList arrayList2 = new ArrayList();
        int iN = kotlin.collections.g.n(arrayList);
        int size = 0;
        if (iN >= 0) {
            int i11 = 0;
            while (true) {
                SemanticsNode semanticsNode = arrayList.get(i11);
                if (i11 == 0 || !M0(arrayList2, semanticsNode)) {
                    arrayList2.add(new Pair(semanticsNode.j(), kotlin.collections.g.q(semanticsNode)));
                }
                if (i11 == iN) {
                    break;
                }
                i11++;
            }
        }
        kotlin.collections.j.z(arrayList2, TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Pair pair = (Pair) arrayList2.get(i12);
            List list = (List) pair.getSecond();
            final Comparator comparator = z11 ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE;
            final Comparator<LayoutNode> comparatorB = LayoutNode.L.b();
            final Comparator comparator2 = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    int iCompare = comparator.compare(t11, t12);
                    return iCompare != 0 ? iCompare : comparatorB.compare(((SemanticsNode) t11).q(), ((SemanticsNode) t12).q());
                }
            };
            kotlin.collections.j.z(list, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    int iCompare = comparator2.compare(t11, t12);
                    return iCompare != 0 ? iCompare : kotlin.comparisons.b.d(Integer.valueOf(((SemanticsNode) t11).o()), Integer.valueOf(((SemanticsNode) t12).o()));
                }
            });
            arrayList3.addAll((Collection) pair.getSecond());
        }
        final AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 androidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2 = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SemanticsNode semanticsNode2, SemanticsNode semanticsNode3) {
                androidx.compose.ui.semantics.l lVarW = semanticsNode2.w();
                SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
                return Integer.valueOf(Float.compare(((Number) lVarW.r(semanticsProperties.G(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) semanticsNode3.w().r(semanticsProperties.G(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
        kotlin.collections.j.z(arrayList3, new Comparator() { // from class: androidx.compose.ui.platform.q
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AndroidComposeViewAccessibilityDelegateCompat.L0(androidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2, obj, obj2);
            }
        });
        while (size <= kotlin.collections.g.n(arrayList3)) {
            List<SemanticsNode> listC = c0Var.c(((SemanticsNode) arrayList3.get(size)).o());
            if (listC != null) {
                if (d0((SemanticsNode) arrayList3.get(size))) {
                    size++;
                } else {
                    arrayList3.remove(size);
                }
                arrayList3.addAll(size, listC);
                size += listC.size();
            } else {
                size++;
            }
        }
        return arrayList3;
    }

    public final int L(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        return (lVarW.f(semanticsProperties.d()) || !semanticsNode.w().f(semanticsProperties.D())) ? this.f5242s : androidx.compose.ui.text.c0.g(((androidx.compose.ui.text.c0) semanticsNode.w().j(semanticsProperties.D())).n());
    }

    public final int M(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        return (lVarW.f(semanticsProperties.d()) || !semanticsNode.w().f(semanticsProperties.D())) ? this.f5242s : androidx.compose.ui.text.c0.k(((androidx.compose.ui.text.c0) semanticsNode.w().j(semanticsProperties.D())).n());
    }

    public final androidx.collection.n<h2> N() {
        if (this.f5246w) {
            this.f5246w = false;
            this.f5248y = i2.b(this.f5224a.getSemanticsOwner());
            if (c0()) {
                J0();
            }
        }
        return this.f5248y;
    }

    public final List<SemanticsNode> N0(boolean z11, List<SemanticsNode> list) {
        androidx.collection.c0<List<SemanticsNode>> c0VarB = androidx.collection.o.b();
        ArrayList<SemanticsNode> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            K(list.get(i11), arrayList, c0VarB);
        }
        return K0(z11, arrayList, c0VarB);
    }

    public final String O() {
        return this.D;
    }

    public final RectF O0(SemanticsNode semanticsNode, y1.i iVar) {
        if (semanticsNode == null) {
            return null;
        }
        y1.i iVarQ = iVar.q(semanticsNode.s());
        y1.i iVarI = semanticsNode.i();
        y1.i iVarM = iVarQ.o(iVarI) ? iVarQ.m(iVarI) : null;
        if (iVarM == null) {
            return null;
        }
        long jMo54localToScreenMKHz9U = this.f5224a.mo54localToScreenMKHz9U(y1.h.a(iVarM.f(), iVarM.i()));
        long jMo54localToScreenMKHz9U2 = this.f5224a.mo54localToScreenMKHz9U(y1.h.a(iVarM.g(), iVarM.c()));
        return new RectF(y1.g.m(jMo54localToScreenMKHz9U), y1.g.n(jMo54localToScreenMKHz9U), y1.g.m(jMo54localToScreenMKHz9U2), y1.g.n(jMo54localToScreenMKHz9U2));
    }

    public final String P() {
        return this.C;
    }

    public final SpannableString P0(AnnotatedString annotatedString) {
        return (SpannableString) S0(androidx.compose.ui.text.platform.a.b(annotatedString, this.f5224a.getDensity(), this.f5224a.getFontFamilyResolver(), this.E), DefaultOggSeeker.MATCH_BYTE_RANGE);
    }

    public final androidx.collection.a0 Q() {
        return this.B;
    }

    public final androidx.collection.a0 R() {
        return this.A;
    }

    public final boolean R0(SemanticsNode semanticsNode, int i11, boolean z11, boolean z12) {
        int iM;
        int i12;
        int iO = semanticsNode.o();
        Integer num = this.f5243t;
        if (num == null || iO != num.intValue()) {
            this.f5242s = -1;
            this.f5243t = Integer.valueOf(semanticsNode.o());
        }
        String strV = V(semanticsNode);
        boolean z13 = false;
        if (strV != null && strV.length() != 0) {
            androidx.compose.ui.platform.f fVarW = W(semanticsNode, i11);
            if (fVarW == null) {
                return false;
            }
            int iL = L(semanticsNode);
            if (iL == -1) {
                iL = z11 ? 0 : strV.length();
            }
            int[] iArrA = z11 ? fVarW.a(iL) : fVarW.b(iL);
            if (iArrA == null) {
                return false;
            }
            int i13 = iArrA[0];
            z13 = true;
            int i14 = iArrA[1];
            if (z12 && b0(semanticsNode)) {
                iM = M(semanticsNode);
                if (iM == -1) {
                    iM = z11 ? i13 : i14;
                }
                i12 = z11 ? i14 : i13;
            } else {
                iM = z11 ? i14 : i13;
                i12 = iM;
            }
            this.f5247x = new f(semanticsNode, z11 ? 256 : 512, i11, i13, i14, SystemClock.uptimeMillis());
            D0(semanticsNode, iM, i12, true);
        }
        return z13;
    }

    public final boolean S(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(lVarW, semanticsProperties.F());
        androidx.compose.ui.semantics.i iVar = (androidx.compose.ui.semantics.i) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.x());
        boolean z11 = true;
        boolean z12 = toggleableState != null;
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.z());
        if (bool == null) {
            return z12;
        }
        bool.booleanValue();
        int iG = androidx.compose.ui.semantics.i.f5649b.g();
        if (iVar != null && androidx.compose.ui.semantics.i.k(iVar.n(), iG)) {
            z11 = z12;
        }
        return z11;
    }

    public final <T extends CharSequence> T S0(T t11, int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        if (t11 == null || t11.length() == 0 || t11.length() <= i11) {
            return t11;
        }
        int i12 = i11 - 1;
        if (Character.isHighSurrogate(t11.charAt(i12)) && Character.isLowSurrogate(t11.charAt(i11))) {
            i11 = i12;
        }
        T t12 = (T) t11.subSequence(0, i11);
        Intrinsics.e(t12, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t12;
    }

    public final String T(SemanticsNode semanticsNode) {
        int iK;
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        Object objA = SemanticsConfigurationKt.a(lVarW, semanticsProperties.A());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.F());
        androidx.compose.ui.semantics.i iVar = (androidx.compose.ui.semantics.i) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.x());
        if (toggleableState != null) {
            int i11 = g.f5260a[toggleableState.ordinal()];
            if (i11 == 1) {
                int iF = androidx.compose.ui.semantics.i.f5649b.f();
                if (iVar != null && androidx.compose.ui.semantics.i.k(iVar.n(), iF) && objA == null) {
                    objA = this.f5224a.getContext().getResources().getString(R$string.state_on);
                }
            } else if (i11 == 2) {
                int iF2 = androidx.compose.ui.semantics.i.f5649b.f();
                if (iVar != null && androidx.compose.ui.semantics.i.k(iVar.n(), iF2) && objA == null) {
                    objA = this.f5224a.getContext().getResources().getString(R$string.state_off);
                }
            } else if (i11 == 3 && objA == null) {
                objA = this.f5224a.getContext().getResources().getString(R$string.indeterminate);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.z());
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            int iG = androidx.compose.ui.semantics.i.f5649b.g();
            if ((iVar == null || !androidx.compose.ui.semantics.i.k(iVar.n(), iG)) && objA == null) {
                objA = zBooleanValue ? this.f5224a.getContext().getResources().getString(R$string.selected) : this.f5224a.getContext().getResources().getString(R$string.not_selected);
            }
        }
        androidx.compose.ui.semantics.h hVar = (androidx.compose.ui.semantics.h) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.w());
        if (hVar != null) {
            if (hVar != androidx.compose.ui.semantics.h.f5644d.a()) {
                if (objA == null) {
                    ClosedFloatingPointRange<Float> closedFloatingPointRangeC = hVar.c();
                    float fB = closedFloatingPointRangeC.f().floatValue() - closedFloatingPointRangeC.j().floatValue() == 0.0f ? 0.0f : (hVar.b() - closedFloatingPointRangeC.j().floatValue()) / (closedFloatingPointRangeC.f().floatValue() - closedFloatingPointRangeC.j().floatValue());
                    if (fB < 0.0f) {
                        fB = 0.0f;
                    }
                    if (fB > 1.0f) {
                        fB = 1.0f;
                    }
                    if (fB == 0.0f) {
                        iK = 0;
                    } else {
                        iK = 100;
                        if (fB != 1.0f) {
                            iK = kotlin.ranges.a.k(Math.round(fB * 100), 1, 99);
                        }
                    }
                    objA = this.f5224a.getContext().getResources().getString(R$string.template_percent, Integer.valueOf(iK));
                }
            } else if (objA == null) {
                objA = this.f5224a.getContext().getResources().getString(R$string.in_progress);
            }
        }
        if (semanticsNode.w().f(semanticsProperties.g())) {
            objA = G(semanticsNode);
        }
        return (String) objA;
    }

    public final void T0(int i11) {
        int i12 = this.f5225b;
        if (i12 == i11) {
            return;
        }
        this.f5225b = i11;
        w0(this, i11, 128, null, null, 12, null);
        w0(this, i12, 256, null, null, 12, null);
    }

    public final AnnotatedString U(SemanticsNode semanticsNode) {
        AnnotatedString annotatedStringX = X(semanticsNode.w());
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5594a.C());
        return annotatedStringX == null ? list != null ? (AnnotatedString) CollectionsKt___CollectionsKt.g0(list) : null : annotatedStringX;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x009c A[LOOP:0: B:5:0x0024->B:28:0x009c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a7 A[EDGE_INSN: B:54:0x00a7->B:29:0x00a7 BREAK  A[LOOP:0: B:5:0x0024->B:28:0x009c], SYNTHETIC] */
    public final void U0() {
        androidx.compose.ui.semantics.l lVarB;
        androidx.collection.d0 d0Var = new androidx.collection.d0(0, 1, null);
        androidx.collection.d0 d0Var2 = this.f5249z;
        int[] iArr = d0Var2.f1964b;
        long[] jArr = d0Var2.f1963a;
        int length = jArr.length - 2;
        long j11 = 128;
        long j12 = 255;
        char c11 = 7;
        long j13 = -9187201950435737472L;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j14 = jArr[i11];
                long[] jArr2 = jArr;
                if ((((~j14) << 7) & j14 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i11 != length) {
                        break;
                        break;
                    }
                    i11++;
                    jArr = jArr2;
                    j11 = 128;
                    j12 = 255;
                } else {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j14 & j12) < j11) {
                            int i14 = iArr[(i11 << 3) + i13];
                            h2 h2VarC = N().c(i14);
                            SemanticsNode semanticsNodeB = h2VarC != null ? h2VarC.b() : null;
                            if (semanticsNodeB == null || !semanticsNodeB.w().f(SemanticsProperties.f5594a.u())) {
                                d0Var.f(i14);
                                g2 g2VarC = this.F.c(i14);
                                x0(i14, 32, (g2VarC == null || (lVarB = g2VarC.b()) == null) ? null : (String) SemanticsConfigurationKt.a(lVarB, SemanticsProperties.f5594a.u()));
                            }
                        }
                        j14 >>= 8;
                        i13++;
                        j11 = 128;
                        j12 = 255;
                    }
                    if (i12 != 8) {
                        break;
                    }
                    if (i11 != length) {
                        break;
                    }
                    i11++;
                    jArr = jArr2;
                    j11 = 128;
                    j12 = 255;
                }
            }
        }
        this.f5249z.r(d0Var);
        this.F.i();
        androidx.collection.n<h2> nVarN = N();
        int[] iArr2 = nVarN.f1952b;
        Object[] objArr = nVarN.f1953c;
        long[] jArr3 = nVarN.f1951a;
        int length2 = jArr3.length - 2;
        if (length2 >= 0) {
            int i15 = 0;
            while (true) {
                long j15 = jArr3[i15];
                if ((((~j15) << c11) & j15 & j13) != j13) {
                    int i16 = 8 - ((~(i15 - length2)) >>> 31);
                    for (int i17 = 0; i17 < i16; i17++) {
                        if ((j15 & 255) < 128) {
                            int i18 = (i15 << 3) + i17;
                            int i19 = iArr2[i18];
                            h2 h2Var = (h2) objArr[i18];
                            androidx.compose.ui.semantics.l lVarW = h2Var.b().w();
                            SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
                            if (lVarW.f(semanticsProperties.u()) && this.f5249z.f(i19)) {
                                x0(i19, 16, (String) h2Var.b().w().j(semanticsProperties.u()));
                            }
                            this.F.t(i19, new g2(h2Var.b(), N()));
                        }
                        j15 >>= 8;
                    }
                    if (i16 != 8) {
                        break;
                    }
                }
                if (i15 == length2) {
                    break;
                }
                i15++;
                c11 = 7;
                j13 = -9187201950435737472L;
            }
        }
        this.G = new g2(this.f5224a.getSemanticsOwner().a(), N());
    }

    public final String V(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        if (lVarW.f(semanticsProperties.d())) {
            return s2.a.d((List) semanticsNode.w().j(semanticsProperties.d()), ",", null, null, 0, null, null, 62, null);
        }
        if (semanticsNode.w().f(semanticsProperties.g())) {
            AnnotatedString annotatedStringX = X(semanticsNode.w());
            if (annotatedStringX != null) {
                return annotatedStringX.i();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.C());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt___CollectionsKt.g0(list)) == null) {
            return null;
        }
        return annotatedString.i();
    }

    public final androidx.compose.ui.platform.f W(SemanticsNode semanticsNode, int i11) {
        String strV;
        androidx.compose.ui.text.a0 a0VarE;
        if (semanticsNode == null || (strV = V(semanticsNode)) == null || strV.length() == 0) {
            return null;
        }
        if (i11 == 1) {
            androidx.compose.ui.platform.b bVarA = androidx.compose.ui.platform.b.f5429d.a(this.f5224a.getContext().getResources().getConfiguration().locale);
            bVarA.e(strV);
            return bVarA;
        }
        if (i11 == 2) {
            androidx.compose.ui.platform.g gVarA = androidx.compose.ui.platform.g.f5476d.a(this.f5224a.getContext().getResources().getConfiguration().locale);
            gVarA.e(strV);
            return gVarA;
        }
        if (i11 != 4) {
            if (i11 == 8) {
                androidx.compose.ui.platform.e eVarA = androidx.compose.ui.platform.e.f5461c.a();
                eVarA.e(strV);
                return eVarA;
            }
            if (i11 != 16) {
                return null;
            }
        }
        if (!semanticsNode.w().f(androidx.compose.ui.semantics.k.f5661a.i()) || (a0VarE = i2.e(semanticsNode.w())) == null) {
            return null;
        }
        if (i11 == 4) {
            androidx.compose.ui.platform.c cVarA = androidx.compose.ui.platform.c.f5440d.a();
            cVarA.j(strV, a0VarE);
            return cVarA;
        }
        androidx.compose.ui.platform.d dVarA = androidx.compose.ui.platform.d.f5449f.a();
        dVarA.j(strV, a0VarE, semanticsNode);
        return dVarA;
    }

    public final AnnotatedString X(androidx.compose.ui.semantics.l lVar) {
        return (AnnotatedString) SemanticsConfigurationKt.a(lVar, SemanticsProperties.f5594a.g());
    }

    public final AndroidComposeView Y() {
        return this.f5224a;
    }

    public final int Z(float f11, float f12) {
        androidx.compose.ui.node.q0 q0VarE0;
        androidx.compose.ui.node.x0.c(this.f5224a, false, 1, null);
        androidx.compose.ui.node.q qVar = new androidx.compose.ui.node.q();
        this.f5224a.getRoot().s0(y1.h.a(f11, f12), qVar, (12 & 4) != 0, (12 & 8) != 0);
        androidx.compose.ui.f.c cVar = (androidx.compose.ui.f.c) CollectionsKt___CollectionsKt.r0(qVar);
        LayoutNode layoutNodeM = cVar != null ? androidx.compose.ui.node.g.m(cVar) : null;
        if (layoutNodeM != null && (q0VarE0 = layoutNodeM.e0()) != null && q0VarE0.q(androidx.compose.ui.node.s0.a(8)) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.m(androidx.compose.ui.semantics.o.a(layoutNodeM, false)) && this.f5224a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNodeM) == null) {
            return s0(layoutNodeM.j0());
        }
        return Integer.MIN_VALUE;
    }

    public final boolean a0(int i11) {
        return this.f5235l == i11;
    }

    public final boolean b0(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        return !lVarW.f(semanticsProperties.d()) && semanticsNode.w().f(semanticsProperties.g());
    }

    public final boolean c0() {
        if (this.f5228e) {
            return true;
        }
        return this.f5227d.isEnabled() && (this.f5232i.isEmpty() ^ true);
    }

    public final boolean d0(SemanticsNode semanticsNode) {
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5594a.d());
        boolean z11 = ((list != null ? (String) CollectionsKt___CollectionsKt.g0(list) : null) == null && U(semanticsNode) == null && T(semanticsNode) == null && !S(semanticsNode)) ? false : true;
        if (semanticsNode.w().v()) {
            return true;
        }
        return semanticsNode.A() && z11;
    }

    public final boolean e0() {
        return this.f5228e || (this.f5227d.isEnabled() && this.f5227d.isTouchExplorationEnabled());
    }

    public final void f0(LayoutNode layoutNode) {
        if (this.f5244u.add(layoutNode)) {
            this.f5245v.f(Unit.f68710a);
        }
    }

    public final void g0(LayoutNode layoutNode) {
        this.f5246w = true;
        if (c0()) {
            f0(layoutNode);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return this.f5234k;
    }

    public final void h0() {
        this.f5246w = true;
        if (!c0() || this.H) {
            return;
        }
        this.H = true;
        this.f5233j.post(this.I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01a7 -> B:91:0x01a8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:91:0x01a8
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final boolean i0(int r18, int r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instruction units count: 1864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.i0(int, int, android.os.Bundle):boolean");
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0323  */
    public final void l0(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        View viewG;
        boolean z11;
        accessibilityNodeInfoCompat.setClassName("android.view.View");
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        if (lVarW.f(semanticsProperties.g())) {
            accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
        }
        if (semanticsNode.w().f(semanticsProperties.C())) {
            accessibilityNodeInfoCompat.setClassName("android.widget.TextView");
        }
        androidx.compose.ui.semantics.i iVar = (androidx.compose.ui.semantics.i) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.x());
        if (iVar != null) {
            iVar.n();
            if (semanticsNode.x() || semanticsNode.t().isEmpty()) {
                androidx.compose.ui.semantics.i.a aVar = androidx.compose.ui.semantics.i.f5649b;
                if (androidx.compose.ui.semantics.i.k(iVar.n(), aVar.g())) {
                    accessibilityNodeInfoCompat.setRoleDescription(this.f5224a.getContext().getResources().getString(R$string.tab));
                } else if (androidx.compose.ui.semantics.i.k(iVar.n(), aVar.f())) {
                    accessibilityNodeInfoCompat.setRoleDescription(this.f5224a.getContext().getResources().getString(R$string.switch_role));
                } else {
                    String strH = i2.h(iVar.n());
                    if (!androidx.compose.ui.semantics.i.k(iVar.n(), aVar.d()) || semanticsNode.A() || semanticsNode.w().v()) {
                        accessibilityNodeInfoCompat.setClassName(strH);
                    }
                }
            }
            Unit unit = Unit.f68710a;
        }
        accessibilityNodeInfoCompat.setPackageName(this.f5224a.getContext().getPackageName());
        accessibilityNodeInfoCompat.setImportantForAccessibility(i2.f(semanticsNode));
        List<SemanticsNode> listT = semanticsNode.t();
        int size = listT.size();
        for (int i12 = 0; i12 < size; i12++) {
            SemanticsNode semanticsNode2 = listT.get(i12);
            if (N().a(semanticsNode2.o())) {
                AndroidViewHolder androidViewHolder = this.f5224a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode2.q());
                if (semanticsNode2.o() != -1) {
                    if (androidViewHolder != null) {
                        accessibilityNodeInfoCompat.addChild(androidViewHolder);
                    } else {
                        accessibilityNodeInfoCompat.addChild(this.f5224a, semanticsNode2.o());
                    }
                }
            }
        }
        if (i11 == this.f5235l) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        I0(semanticsNode, accessibilityNodeInfoCompat);
        E0(semanticsNode, accessibilityNodeInfoCompat);
        H0(semanticsNode, accessibilityNodeInfoCompat);
        F0(semanticsNode, accessibilityNodeInfoCompat);
        androidx.compose.ui.semantics.l lVarW2 = semanticsNode.w();
        SemanticsProperties semanticsProperties2 = SemanticsProperties.f5594a;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(lVarW2, semanticsProperties2.F());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                accessibilityNodeInfoCompat.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                accessibilityNodeInfoCompat.setChecked(false);
            }
            Unit unit2 = Unit.f68710a;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties2.z());
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            int iG = androidx.compose.ui.semantics.i.f5649b.g();
            if (iVar != null && androidx.compose.ui.semantics.i.k(iVar.n(), iG)) {
                accessibilityNodeInfoCompat.setSelected(zBooleanValue);
            } else {
                accessibilityNodeInfoCompat.setChecked(zBooleanValue);
            }
            Unit unit3 = Unit.f68710a;
        }
        if (!semanticsNode.w().v() || semanticsNode.t().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties2.d());
            accessibilityNodeInfoCompat.setContentDescription(list != null ? (String) CollectionsKt___CollectionsKt.g0(list) : null);
        }
        String str = (String) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties2.B());
        if (str != null) {
            for (SemanticsNode semanticsNodeR = semanticsNode; semanticsNodeR != null; semanticsNodeR = semanticsNodeR.r()) {
                androidx.compose.ui.semantics.l lVarW3 = semanticsNodeR.w();
                SemanticsPropertiesAndroid semanticsPropertiesAndroid = SemanticsPropertiesAndroid.f5620a;
                if (lVarW3.f(semanticsPropertiesAndroid.a())) {
                    if (!((Boolean) semanticsNodeR.w().j(semanticsPropertiesAndroid.a())).booleanValue()) {
                        break;
                    }
                    accessibilityNodeInfoCompat.setViewIdResourceName(str);
                    break;
                }
            }
        }
        androidx.compose.ui.semantics.l lVarW4 = semanticsNode.w();
        SemanticsProperties semanticsProperties3 = SemanticsProperties.f5594a;
        if (((Unit) SemanticsConfigurationKt.a(lVarW4, semanticsProperties3.j())) != null) {
            accessibilityNodeInfoCompat.setHeading(true);
            Unit unit4 = Unit.f68710a;
        }
        accessibilityNodeInfoCompat.setPassword(semanticsNode.w().f(semanticsProperties3.v()));
        accessibilityNodeInfoCompat.setEditable(semanticsNode.w().f(semanticsProperties3.p()));
        Integer num = (Integer) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.t());
        accessibilityNodeInfoCompat.setMaxTextLength(num != null ? num.intValue() : -1);
        accessibilityNodeInfoCompat.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode));
        accessibilityNodeInfoCompat.setFocusable(semanticsNode.w().f(semanticsProperties3.i()));
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused(((Boolean) semanticsNode.w().j(semanticsProperties3.i())).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
            } else {
                accessibilityNodeInfoCompat.addAction(1);
            }
        }
        accessibilityNodeInfoCompat.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.m(semanticsNode));
        androidx.compose.ui.semantics.g gVar = (androidx.compose.ui.semantics.g) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.s());
        if (gVar != null) {
            int iH = gVar.h();
            androidx.compose.ui.semantics.g.a aVar2 = androidx.compose.ui.semantics.g.f5640b;
            accessibilityNodeInfoCompat.setLiveRegion((androidx.compose.ui.semantics.g.e(iH, aVar2.b()) || !androidx.compose.ui.semantics.g.e(iH, aVar2.a())) ? 1 : 2);
            Unit unit5 = Unit.f68710a;
        }
        accessibilityNodeInfoCompat.setClickable(false);
        androidx.compose.ui.semantics.l lVarW5 = semanticsNode.w();
        androidx.compose.ui.semantics.k kVar = androidx.compose.ui.semantics.k.f5661a;
        androidx.compose.ui.semantics.a aVar3 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(lVarW5, kVar.j());
        if (aVar3 != null) {
            boolean zB = Intrinsics.b(SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.z()), Boolean.TRUE);
            androidx.compose.ui.semantics.i.a aVar4 = androidx.compose.ui.semantics.i.f5649b;
            int iG2 = aVar4.g();
            if (iVar != null && androidx.compose.ui.semantics.i.k(iVar.n(), iG2)) {
                z11 = true;
            } else {
                int iE = aVar4.e();
                if (iVar != null && androidx.compose.ui.semantics.i.k(iVar.n(), iE)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            accessibilityNodeInfoCompat.setClickable(!z11 || (z11 && !zB));
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode) && accessibilityNodeInfoCompat.isClickable()) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, aVar3.b()));
            }
            Unit unit6 = Unit.f68710a;
        }
        accessibilityNodeInfoCompat.setLongClickable(false);
        androidx.compose.ui.semantics.a aVar5 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.l());
        if (aVar5 != null) {
            accessibilityNodeInfoCompat.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, aVar5.b()));
            }
            Unit unit7 = Unit.f68710a;
        }
        androidx.compose.ui.semantics.a aVar6 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.c());
        if (aVar6 != null) {
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, aVar6.b()));
            Unit unit8 = Unit.f68710a;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
            androidx.compose.ui.semantics.a aVar7 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.x());
            if (aVar7 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, aVar7.b()));
                Unit unit9 = Unit.f68710a;
            }
            androidx.compose.ui.semantics.a aVar8 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.k());
            if (aVar8 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionImeEnter, aVar8.b()));
                Unit unit10 = Unit.f68710a;
            }
            androidx.compose.ui.semantics.a aVar9 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.e());
            if (aVar9 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, aVar9.b()));
                Unit unit11 = Unit.f68710a;
            }
            androidx.compose.ui.semantics.a aVar10 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.q());
            if (aVar10 != null) {
                if (accessibilityNodeInfoCompat.isFocused() && this.f5224a.getClipboardManager().a()) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, aVar10.b()));
                }
                Unit unit12 = Unit.f68710a;
            }
        }
        String strV = V(semanticsNode);
        if (strV != null && strV.length() != 0) {
            accessibilityNodeInfoCompat.setTextSelection(M(semanticsNode), L(semanticsNode));
            androidx.compose.ui.semantics.a aVar11 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.w());
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, aVar11 != null ? aVar11.b() : null));
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            List list2 = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.d());
            if ((list2 == null || list2.isEmpty()) && semanticsNode.w().f(kVar.i()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.j(semanticsNode)) {
                accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat.getMovementGranularities() | 20);
            }
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 26) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("androidx.compose.ui.semantics.id");
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (text != null && text.length() != 0 && semanticsNode.w().f(kVar.i())) {
                arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.w().f(semanticsProperties3.B())) {
                arrayList.add("androidx.compose.ui.semantics.testTag");
            }
            accessibilityNodeInfoCompat.setAvailableExtraData(arrayList);
        }
        androidx.compose.ui.semantics.h hVar = (androidx.compose.ui.semantics.h) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.w());
        if (hVar != null) {
            if (semanticsNode.w().f(kVar.v())) {
                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
            }
            if (hVar != androidx.compose.ui.semantics.h.f5644d.a()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, hVar.c().j().floatValue(), hVar.c().f().floatValue(), hVar.b()));
            }
            if (semanticsNode.w().f(kVar.v()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
                if (hVar.b() < kotlin.ranges.a.c(hVar.c().f().floatValue(), hVar.c().j().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (hVar.b() > kotlin.ranges.a.f(hVar.c().j().floatValue(), hVar.c().f().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        if (i13 >= 24) {
            b.a(accessibilityNodeInfoCompat, semanticsNode);
        }
        CollectionInfo_androidKt.d(semanticsNode, accessibilityNodeInfoCompat);
        CollectionInfo_androidKt.e(semanticsNode, accessibilityNodeInfoCompat);
        androidx.compose.ui.semantics.j jVar = (androidx.compose.ui.semantics.j) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.k());
        androidx.compose.ui.semantics.a aVar12 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.s());
        if (jVar != null && aVar12 != null) {
            if (!CollectionInfo_androidKt.b(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
            }
            if (jVar.a().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
                if (n0(jVar)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNode) ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
                }
                if (m0(jVar)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.l(semanticsNode) ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
                }
            }
        }
        androidx.compose.ui.semantics.j jVar2 = (androidx.compose.ui.semantics.j) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.H());
        if (jVar2 != null && aVar12 != null) {
            if (!CollectionInfo_androidKt.b(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            }
            if (jVar2.a().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
                if (n0(jVar2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (m0(jVar2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (i13 >= 29) {
            c.a(accessibilityNodeInfoCompat, semanticsNode);
        }
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties3.u()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.i(semanticsNode)) {
            androidx.compose.ui.semantics.a aVar13 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.g());
            if (aVar13 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, aVar13.b()));
                Unit unit13 = Unit.f68710a;
            }
            androidx.compose.ui.semantics.a aVar14 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.b());
            if (aVar14 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, aVar14.b()));
                Unit unit14 = Unit.f68710a;
            }
            androidx.compose.ui.semantics.a aVar15 = (androidx.compose.ui.semantics.a) SemanticsConfigurationKt.a(semanticsNode.w(), kVar.f());
            if (aVar15 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, aVar15.b()));
                Unit unit15 = Unit.f68710a;
            }
            if (semanticsNode.w().f(kVar.d())) {
                List list3 = (List) semanticsNode.w().j(kVar.d());
                int size2 = list3.size();
                androidx.collection.l lVar = N;
                if (size2 >= lVar.b()) {
                    throw new IllegalStateException("Can't have more than " + lVar.b() + " custom actions for one widget");
                }
                androidx.collection.w0<CharSequence> w0Var = new androidx.collection.w0<>(0, 1, null);
                androidx.collection.i0<CharSequence> i0VarB = androidx.collection.o0.b();
                if (this.f5241r.d(i11)) {
                    androidx.collection.i0<CharSequence> i0VarG = this.f5241r.g(i11);
                    androidx.collection.b0 b0Var = new androidx.collection.b0(0, 1, null);
                    int[] iArr = lVar.f1942a;
                    int i14 = lVar.f1943b;
                    for (int i15 = 0; i15 < i14; i15++) {
                        b0Var.f(iArr[i15]);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = list3.size();
                    for (int i16 = 0; i16 < size3; i16++) {
                        androidx.compose.ui.semantics.e eVar = (androidx.compose.ui.semantics.e) list3.get(i16);
                        Intrinsics.d(i0VarG);
                        if (i0VarG.a(eVar.b())) {
                            int iC = i0VarG.c(eVar.b());
                            w0Var.m(iC, eVar.b());
                            i0VarB.s(eVar.b(), iC);
                            b0Var.j(iC);
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iC, eVar.b()));
                        } else {
                            arrayList2.add(eVar);
                        }
                    }
                    int size4 = arrayList2.size();
                    for (int i17 = 0; i17 < size4; i17++) {
                        androidx.compose.ui.semantics.e eVar2 = (androidx.compose.ui.semantics.e) arrayList2.get(i17);
                        int iA = b0Var.a(i17);
                        w0Var.m(iA, eVar2.b());
                        i0VarB.s(eVar2.b(), iA);
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iA, eVar2.b()));
                    }
                } else {
                    int size5 = list3.size();
                    for (int i18 = 0; i18 < size5; i18++) {
                        androidx.compose.ui.semantics.e eVar3 = (androidx.compose.ui.semantics.e) list3.get(i18);
                        int iA2 = N.a(i18);
                        w0Var.m(iA2, eVar3.b());
                        i0VarB.s(eVar3.b(), iA2);
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iA2, eVar3.b()));
                    }
                }
                this.f5240q.m(i11, w0Var);
                this.f5241r.m(i11, i0VarB);
            }
        }
        accessibilityNodeInfoCompat.setScreenReaderFocusable(d0(semanticsNode));
        int iE2 = this.A.e(i11, -1);
        if (iE2 != -1) {
            View viewG2 = i2.g(this.f5224a.getAndroidViewsHandler$ui_release(), iE2);
            if (viewG2 != null) {
                accessibilityNodeInfoCompat.setTraversalBefore(viewG2);
            } else {
                accessibilityNodeInfoCompat.setTraversalBefore(this.f5224a, iE2);
            }
            x(i11, accessibilityNodeInfoCompat, this.C, null);
        }
        int iE3 = this.B.e(i11, -1);
        if (iE3 == -1 || (viewG = i2.g(this.f5224a.getAndroidViewsHandler$ui_release(), iE3)) == null) {
            return;
        }
        accessibilityNodeInfoCompat.setTraversalAfter(viewG);
        x(i11, accessibilityNodeInfoCompat, this.D, null);
    }

    public final boolean o0(int i11, List<f2> list) {
        boolean z11;
        f2 f2VarA = i2.a(list, i11);
        if (f2VarA != null) {
            z11 = false;
        } else {
            f2VarA = new f2(i11, this.J, null, null, null, null);
            z11 = true;
        }
        this.J.add(f2VarA);
        return z11;
    }

    public final boolean p0(int i11) {
        if (!e0() || a0(i11)) {
            return false;
        }
        int i12 = this.f5235l;
        if (i12 != Integer.MIN_VALUE) {
            w0(this, i12, 65536, null, null, 12, null);
        }
        this.f5235l = i11;
        this.f5224a.invalidate();
        w0(this, i11, 32768, null, null, 12, null);
        return true;
    }

    public final void q0(final f2 f2Var) {
        if (f2Var.isValidOwnerScope()) {
            this.f5224a.getSnapshotObserver().i(f2Var, this.K, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1
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
                    SemanticsNode semanticsNodeB;
                    LayoutNode layoutNodeQ;
                    androidx.compose.ui.semantics.j jVarA = f2Var.a();
                    androidx.compose.ui.semantics.j jVarE = f2Var.e();
                    Float fB = f2Var.b();
                    Float fC = f2Var.c();
                    float fFloatValue = (jVarA == null || fB == null) ? 0.0f : jVarA.c().invoke().floatValue() - fB.floatValue();
                    float fFloatValue2 = (jVarE == null || fC == null) ? 0.0f : jVarE.c().invoke().floatValue() - fC.floatValue();
                    if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                        int iS0 = this.s0(f2Var.d());
                        h2 h2Var = (h2) this.N().c(this.f5235l);
                        if (h2Var != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.f5236m;
                                if (accessibilityNodeInfoCompat != null) {
                                    accessibilityNodeInfoCompat.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.y(h2Var));
                                    Unit unit = Unit.f68710a;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.f68710a;
                            }
                        }
                        this.Y().invalidate();
                        h2 h2Var2 = (h2) this.N().c(iS0);
                        if (h2Var2 != null && (semanticsNodeB = h2Var2.b()) != null && (layoutNodeQ = semanticsNodeB.q()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            if (jVarA != null) {
                                androidComposeViewAccessibilityDelegateCompat2.f5238o.t(iS0, jVarA);
                            }
                            if (jVarE != null) {
                                androidComposeViewAccessibilityDelegateCompat2.f5239p.t(iS0, jVarE);
                            }
                            androidComposeViewAccessibilityDelegateCompat2.f0(layoutNodeQ);
                        }
                    }
                    if (jVarA != null) {
                        f2Var.g(jVarA.c().invoke());
                    }
                    if (jVarE != null) {
                        f2Var.h(jVarE.c().invoke());
                    }
                }
            });
        }
    }

    public final int s0(int i11) {
        if (i11 == this.f5224a.getSemanticsOwner().a().o()) {
            return -1;
        }
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0092 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0094 A[LOOP:1: B:15:0x0054->B:28:0x0094, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x0097 A[EDGE_INSN: B:42:0x0097->B:29:0x0097 BREAK  A[LOOP:1: B:15:0x0054->B:28:0x0094], SYNTHETIC] */
    public final void t0(SemanticsNode semanticsNode, g2 g2Var) {
        androidx.collection.d0 d0VarB = androidx.collection.q.b();
        List<SemanticsNode> listT = semanticsNode.t();
        int size = listT.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = listT.get(i11);
            if (N().a(semanticsNode2.o())) {
                if (!g2Var.a().a(semanticsNode2.o())) {
                    f0(semanticsNode.q());
                    return;
                }
                d0VarB.f(semanticsNode2.o());
            }
        }
        androidx.collection.d0 d0VarA = g2Var.a();
        int[] iArr = d0VarA.f1964b;
        long[] jArr = d0VarA.f1963a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i12 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i12 != length) {
                        break;
                        break;
                    }
                    i12++;
                } else {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128 && !d0VarB.a(iArr[(i12 << 3) + i14])) {
                            f0(semanticsNode.q());
                            return;
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    } else if (i12 != length) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        List<SemanticsNode> listT2 = semanticsNode.t();
        int size2 = listT2.size();
        for (int i15 = 0; i15 < size2; i15++) {
            SemanticsNode semanticsNode3 = listT2.get(i15);
            if (N().a(semanticsNode3.o())) {
                g2 g2VarC = this.F.c(semanticsNode3.o());
                Intrinsics.d(g2VarC);
                t0(semanticsNode3, g2VarC);
            }
        }
    }

    public final boolean u0(AccessibilityEvent accessibilityEvent) {
        if (!c0()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.f5237n = true;
        }
        try {
            return this.f5226c.invoke(accessibilityEvent).booleanValue();
        } finally {
            this.f5237n = false;
        }
    }

    public final boolean v0(int i11, int i12, Integer num, List<String> list) {
        if (i11 == Integer.MIN_VALUE || !c0()) {
            return false;
        }
        AccessibilityEvent accessibilityEventE = E(i11, i12);
        if (num != null) {
            accessibilityEventE.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventE.setContentDescription(s2.a.d(list, ",", null, null, 0, null, null, 62, null));
        }
        Trace.beginSection("sendEvent");
        try {
            return u0(accessibilityEventE);
        } finally {
            Trace.endSection();
        }
    }

    public final void x(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode semanticsNodeB;
        h2 h2VarC = N().c(i11);
        if (h2VarC == null || (semanticsNodeB = h2VarC.b()) == null) {
            return;
        }
        String strV = V(semanticsNodeB);
        if (Intrinsics.b(str, this.C)) {
            int iE = this.A.e(i11, -1);
            if (iE != -1) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, iE);
                return;
            }
            return;
        }
        if (Intrinsics.b(str, this.D)) {
            int iE2 = this.B.e(i11, -1);
            if (iE2 != -1) {
                accessibilityNodeInfoCompat.getExtras().putInt(str, iE2);
                return;
            }
            return;
        }
        if (!semanticsNodeB.w().f(androidx.compose.ui.semantics.k.f5661a.i()) || bundle == null || !Intrinsics.b(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            androidx.compose.ui.semantics.l lVarW = semanticsNodeB.w();
            SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
            if (!lVarW.f(semanticsProperties.B()) || bundle == null || !Intrinsics.b(str, "androidx.compose.ui.semantics.testTag")) {
                if (Intrinsics.b(str, "androidx.compose.ui.semantics.id")) {
                    accessibilityNodeInfoCompat.getExtras().putInt(str, semanticsNodeB.o());
                    return;
                }
                return;
            } else {
                String str2 = (String) SemanticsConfigurationKt.a(semanticsNodeB.w(), semanticsProperties.B());
                if (str2 != null) {
                    accessibilityNodeInfoCompat.getExtras().putCharSequence(str, str2);
                    return;
                }
                return;
            }
        }
        int i12 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i13 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i13 > 0 && i12 >= 0) {
            if (i12 < (strV != null ? strV.length() : Api.BaseClientBuilder.API_PRIORITY_OTHER)) {
                androidx.compose.ui.text.a0 a0VarE = i2.e(semanticsNodeB.w());
                if (a0VarE == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i14 = 0; i14 < i13; i14++) {
                    int i15 = i12 + i14;
                    if (i15 >= a0VarE.k().j().length()) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(O0(semanticsNodeB, a0VarE.d(i15)));
                    }
                }
                accessibilityNodeInfoCompat.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                return;
            }
        }
        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
    }

    public final void x0(int i11, int i12, String str) {
        AccessibilityEvent accessibilityEventE = E(s0(i11), 32);
        accessibilityEventE.setContentChangeTypes(i12);
        if (str != null) {
            accessibilityEventE.getText().add(str);
        }
        u0(accessibilityEventE);
    }

    public final Rect y(h2 h2Var) {
        Rect rectA = h2Var.a();
        long jMo54localToScreenMKHz9U = this.f5224a.mo54localToScreenMKHz9U(y1.h.a(rectA.left, rectA.top));
        long jMo54localToScreenMKHz9U2 = this.f5224a.mo54localToScreenMKHz9U(y1.h.a(rectA.right, rectA.bottom));
        return new Rect((int) Math.floor(y1.g.m(jMo54localToScreenMKHz9U)), (int) Math.floor(y1.g.n(jMo54localToScreenMKHz9U)), (int) Math.ceil(y1.g.m(jMo54localToScreenMKHz9U2)), (int) Math.ceil(y1.g.n(jMo54localToScreenMKHz9U2)));
    }

    public final void y0(int i11) {
        f fVar = this.f5247x;
        if (fVar != null) {
            if (i11 != fVar.d().o()) {
                return;
            }
            if (SystemClock.uptimeMillis() - fVar.f() <= 1000) {
                AccessibilityEvent accessibilityEventE = E(s0(fVar.d().o()), 131072);
                accessibilityEventE.setFromIndex(fVar.b());
                accessibilityEventE.setToIndex(fVar.e());
                accessibilityEventE.setAction(fVar.a());
                accessibilityEventE.setMovementGranularity(fVar.c());
                accessibilityEventE.getText().add(V(fVar.d()));
                u0(accessibilityEventE);
            }
        }
        this.f5247x = null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0074  */
    /* JADX WARN: Code duplicated, block: B:31:0x007f A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:25:0x0065, B:29:0x0077, B:31:0x007f, B:33:0x0088, B:35:0x0091, B:36:0x00a2, B:38:0x00a9, B:39:0x00b2, B:20:0x0051), top: B:49:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0088 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:25:0x0065, B:29:0x0077, B:31:0x007f, B:33:0x0088, B:35:0x0091, B:36:0x00a2, B:38:0x00a9, B:39:0x00b2, B:20:0x0051), top: B:49:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0091 A[Catch: all -> 0x003a, LOOP:0: B:34:0x008f->B:35:0x0091, LOOP_END, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:25:0x0065, B:29:0x0077, B:31:0x007f, B:33:0x0088, B:35:0x0091, B:36:0x00a2, B:38:0x00a9, B:39:0x00b2, B:20:0x0051), top: B:49:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:13:0x0035, B:25:0x0065, B:29:0x0077, B:31:0x007f, B:33:0x0088, B:35:0x0091, B:36:0x00a2, B:38:0x00a9, B:39:0x00b2, B:20:0x0051), top: B:49:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0086 -> B:42:0x00d2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00cf -> B:42:0x00d2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object z(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.z(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:158:0x0558  */
    /*  JADX ERROR: NullPointerException in pass: ProcessVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getUseList()" because "ssaVar" is null
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:93)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final void z0(androidx.collection.n<androidx.compose.ui.platform.h2> r37) {
        /*
            Method dump skipped, instruction units count: 1591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.z0(androidx.collection.n):void");
    }
}
