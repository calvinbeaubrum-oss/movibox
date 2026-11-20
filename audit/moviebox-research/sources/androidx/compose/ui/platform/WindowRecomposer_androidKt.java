package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;

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
public final class WindowRecomposer_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Context, kotlinx.coroutines.flow.f1<Float>> f5404a = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Recomposer f5406b;

        public a(View view, Recomposer recomposer) {
            this.f5405a = view;
            this.f5406b = recomposer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f5405a.removeOnAttachStateChangeListener(this);
            this.f5406b.a0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.a<Unit> f5407a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlinx.coroutines.channels.a<Unit> aVar, Handler handler) {
            super(handler);
            this.f5407a = aVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z11, Uri uri) {
            this.f5407a.f(Unit.f68710a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, androidx.compose.ui.platform.j1] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.coroutines.CoroutineContext] */
    public static final Recomposer b(final View view, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        CoroutineContext coroutineContext2;
        ?? j1Var;
        if (coroutineContext.get(ContinuationInterceptor.f68810h8) == null || coroutineContext.get(androidx.compose.runtime.u0.X7) == null) {
            coroutineContext = AndroidUiDispatcher.f5280l.a().plus(coroutineContext);
        }
        androidx.compose.runtime.u0 u0Var = (androidx.compose.runtime.u0) coroutineContext.get(androidx.compose.runtime.u0.X7);
        if (u0Var != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(u0Var);
            pausableMonotonicFrameClock2.f();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        androidx.compose.ui.j jVar = (androidx.compose.ui.j) coroutineContext.get(androidx.compose.ui.j.Y7);
        ?? r11 = jVar;
        if (jVar == null) {
            j1Var = new j1();
            objectRef.element = j1Var;
        }
        if (pausableMonotonicFrameClock != null) {
            r11 = j1Var;
            coroutineContext2 = pausableMonotonicFrameClock;
        } else {
            r11 = j1Var;
            coroutineContext2 = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextPlus = coroutineContext.plus(coroutineContext2).plus(r11);
        final Recomposer recomposer = new Recomposer(coroutineContextPlus);
        recomposer.n0();
        final kotlinx.coroutines.k0 k0VarA = kotlinx.coroutines.l0.a(coroutineContextPlus);
        if (lifecycle == null) {
            androidx.lifecycle.u uVarA = ViewTreeLifecycleOwner.a(view);
            lifecycle = uVarA != null ? uVarA.getLifecycle() : null;
        }
        if (lifecycle != null) {
            view.addOnAttachStateChangeListener(new a(view, recomposer));
            lifecycle.a(new androidx.lifecycle.r() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

                /* JADX INFO: compiled from: source.java */
                @Metadata
                public /* synthetic */ class a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f5413a;

                    static {
                        int[] iArr = new int[Lifecycle.Event.values().length];
                        try {
                            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        f5413a = iArr;
                    }
                }

                @Override // androidx.lifecycle.r
                public void onStateChanged(androidx.lifecycle.u uVar, Lifecycle.Event event) {
                    int i11 = a.f5413a[event.ordinal()];
                    if (i11 == 1) {
                        kotlinx.coroutines.j.d(k0VarA, null, CoroutineStart.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(objectRef, recomposer, uVar, this, view, null), 1, null);
                        return;
                    }
                    if (i11 == 2) {
                        PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock3 != null) {
                            pausableMonotonicFrameClock3.k();
                        }
                        recomposer.A0();
                        return;
                    }
                    if (i11 == 3) {
                        recomposer.n0();
                    } else {
                        if (i11 != 4) {
                            return;
                        }
                        recomposer.a0();
                    }
                }
            });
            return recomposer;
        }
        h2.a.c("ViewTreeLifecycleOwner not found from " + view);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Recomposer c(View view, CoroutineContext coroutineContext, Lifecycle lifecycle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            lifecycle = null;
        }
        return b(view, coroutineContext, lifecycle);
    }

    public static final androidx.compose.runtime.m d(View view) {
        androidx.compose.runtime.m mVarF = f(view);
        if (mVarF != null) {
            return mVarF;
        }
        for (ViewParent parent = view.getParent(); mVarF == null && (parent instanceof View); parent = parent.getParent()) {
            mVarF = f((View) parent);
        }
        return mVarF;
    }

    public static final kotlinx.coroutines.flow.f1<Float> e(Context context) {
        kotlinx.coroutines.flow.f1<Float> f1Var;
        Map<Context, kotlinx.coroutines.flow.f1<Float>> map = f5404a;
        synchronized (map) {
            try {
                kotlinx.coroutines.flow.f1<Float> f1VarY = map.get(context);
                if (f1VarY == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    kotlinx.coroutines.channels.a aVarB = kotlinx.coroutines.channels.d.b(-1, null, null, 6, null);
                    f1VarY = kotlinx.coroutines.flow.c.y(kotlinx.coroutines.flow.c.o(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(contentResolver, uriFor, new b(aVarB, androidx.core.os.g.a(Looper.getMainLooper())), aVarB, context, null)), kotlinx.coroutines.l0.b(), kotlinx.coroutines.flow.d1.a.b(kotlinx.coroutines.flow.d1.f69383a, 0L, 0L, 3, null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                    map.put(context, f1VarY);
                }
                f1Var = f1VarY;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f1Var;
    }

    public static final androidx.compose.runtime.m f(View view) {
        Object tag = view.getTag(R$id.androidx_compose_ui_view_composition_context);
        if (tag instanceof androidx.compose.runtime.m) {
            return (androidx.compose.runtime.m) tag;
        }
        return null;
    }

    public static final View g(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    public static final Recomposer h(View view) {
        if (!view.isAttachedToWindow()) {
            h2.a.b("Cannot locate windowRecomposer; View " + view + " is not attached to a window");
        }
        View viewG = g(view);
        androidx.compose.runtime.m mVarF = f(viewG);
        if (mVarF == null) {
            return WindowRecomposerPolicy.f5400a.a(viewG);
        }
        if (mVarF instanceof Recomposer) {
            return (Recomposer) mVarF;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static final void i(View view, androidx.compose.runtime.m mVar) {
        view.setTag(R$id.androidx_compose_ui_view_composition_context, mVar);
    }
}
