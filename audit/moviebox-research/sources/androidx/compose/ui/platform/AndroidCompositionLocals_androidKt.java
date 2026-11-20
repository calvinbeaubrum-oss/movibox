package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class AndroidCompositionLocals_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.compose.runtime.s1<Configuration> f5262a = CompositionLocalKt.d(null, new Function0<Configuration>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalConfiguration$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Configuration invoke() {
            AndroidCompositionLocals_androidKt.k("LocalConfiguration");
            throw new KotlinNothingValueException();
        }
    }, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.compose.runtime.s1<Context> f5263b = CompositionLocalKt.f(new Function0<Context>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalContext$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            AndroidCompositionLocals_androidKt.k("LocalContext");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.compose.runtime.s1<k2.e> f5264c = CompositionLocalKt.f(new Function0<k2.e>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalImageVectorCache$1
        @Override // kotlin.jvm.functions.Function0
        public final k2.e invoke() {
            AndroidCompositionLocals_androidKt.k("LocalImageVectorCache");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final androidx.compose.runtime.s1<k2.g> f5265d = CompositionLocalKt.f(new Function0<k2.g>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalResourceIdCache$1
        @Override // kotlin.jvm.functions.Function0
        public final k2.g invoke() {
            AndroidCompositionLocals_androidKt.k("LocalResourceIdCache");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.compose.runtime.s1<f6.e> f5266e = CompositionLocalKt.f(new Function0<f6.e>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final f6.e invoke() {
            AndroidCompositionLocals_androidKt.k("LocalSavedStateRegistryOwner");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final androidx.compose.runtime.s1<View> f5267f = CompositionLocalKt.f(new Function0<View>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$LocalView$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            AndroidCompositionLocals_androidKt.k("LocalView");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Configuration f5269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k2.e f5270b;

        public a(Configuration configuration, k2.e eVar) {
            this.f5269a = configuration;
            this.f5270b = eVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            this.f5270b.c(this.f5269a.updateFrom(configuration));
            this.f5269a.setTo(configuration);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.f5270b.a();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
            this.f5270b.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k2.g f5271a;

        public b(k2.g gVar) {
            this.f5271a = gVar;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            this.f5271a.a();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            this.f5271a.a();
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i11) {
            this.f5271a.a();
        }
    }

    public static final void a(final AndroidComposeView androidComposeView, final Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVarG = iVar.g(1396852028);
        if ((i11 & 6) == 0) {
            i12 = (iVarG.A(androidComposeView) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= iVarG.A(function2) ? 32 : 16;
        }
        if ((i12 & 19) == 18 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(1396852028, i12, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:91)");
            }
            Context context = androidComposeView.getContext();
            Object objY = iVarG.y();
            androidx.compose.runtime.i.a aVar = androidx.compose.runtime.i.f3413a;
            if (objY == aVar.a()) {
                objY = androidx.compose.runtime.u2.c(new Configuration(context.getResources().getConfiguration()), null, 2, null);
                iVarG.p(objY);
            }
            final androidx.compose.runtime.i1 i1Var = (androidx.compose.runtime.i1) objY;
            Object objY2 = iVarG.y();
            if (objY2 == aVar.a()) {
                objY2 = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                        invoke2(configuration);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Configuration configuration) {
                        AndroidCompositionLocals_androidKt.c(i1Var, new Configuration(configuration));
                    }
                };
                iVarG.p(objY2);
            }
            androidComposeView.setConfigurationChangeObserver((Function1) objY2);
            Object objY3 = iVarG.y();
            if (objY3 == aVar.a()) {
                objY3 = new q0(context);
                iVarG.p(objY3);
            }
            final q0 q0Var = (q0) objY3;
            AndroidComposeView.b viewTreeOwners = androidComposeView.getViewTreeOwners();
            if (viewTreeOwners == null) {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
            Object objY4 = iVarG.y();
            if (objY4 == aVar.a()) {
                objY4 = DisposableSaveableStateRegistry_androidKt.b(androidComposeView, viewTreeOwners.b());
                iVarG.p(objY4);
            }
            final z0 z0Var = (z0) objY4;
            Unit unit = Unit.f68710a;
            boolean zA = iVarG.A(z0Var);
            Object objY5 = iVarG.y();
            if (zA || objY5 == aVar.a()) {
                objY5 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ z0 f5268a;

                        public a(z0 z0Var) {
                            this.f5268a = z0Var;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f5268a.c();
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        return new a(z0Var);
                    }
                };
                iVarG.p(objY5);
            }
            androidx.compose.runtime.g0.a(unit, (Function1) objY5, iVarG, 6);
            CompositionLocalKt.b(new androidx.compose.runtime.t1[]{f5262a.d(b(i1Var)), f5263b.d(context), LocalLifecycleOwnerKt.a().d(viewTreeOwners.a()), f5266e.d(viewTreeOwners.b()), SaveableStateRegistryKt.d().d(z0Var), f5267f.d(androidComposeView.getView()), f5264c.d(l(context, b(i1Var), iVarG, 0)), f5265d.d(m(context, iVarG, 0)), CompositionLocalsKt.i().d(Boolean.valueOf(((Boolean) iVarG.l(CompositionLocalsKt.j())).booleanValue() | androidComposeView.getScrollCaptureInProgress$ui_release()))}, androidx.compose.runtime.internal.b.e(1471621628, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    if ((i13 & 3) == 2 && iVar2.h()) {
                        iVar2.H();
                        return;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(1471621628, i13, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:131)");
                    }
                    CompositionLocalsKt.a(androidComposeView, q0Var, function2, iVar2, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                }
            }, iVarG, 54), iVarG, androidx.compose.runtime.t1.f3721i | 48);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        androidx.compose.runtime.g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i13) {
                    AndroidCompositionLocals_androidKt.a(androidComposeView, function2, iVar2, androidx.compose.runtime.v1.a(i11 | 1));
                }
            });
        }
    }

    public static final Configuration b(androidx.compose.runtime.i1<Configuration> i1Var) {
        return i1Var.getValue();
    }

    public static final void c(androidx.compose.runtime.i1<Configuration> i1Var, Configuration configuration) {
        i1Var.setValue(configuration);
    }

    public static final androidx.compose.runtime.s1<Configuration> f() {
        return f5262a;
    }

    public static final androidx.compose.runtime.s1<Context> g() {
        return f5263b;
    }

    public static final androidx.compose.runtime.s1<k2.e> h() {
        return f5264c;
    }

    public static final androidx.compose.runtime.s1<k2.g> i() {
        return f5265d;
    }

    public static final androidx.compose.runtime.s1<View> j() {
        return f5267f;
    }

    public static final Void k(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    public static final k2.e l(final Context context, Configuration configuration, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-485908294, i11, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:172)");
        }
        Object objY = iVar.y();
        androidx.compose.runtime.i.a aVar = androidx.compose.runtime.i.f3413a;
        if (objY == aVar.a()) {
            objY = new k2.e();
            iVar.p(objY);
        }
        k2.e eVar = (k2.e) objY;
        Object objY2 = iVar.y();
        Object obj = objY2;
        if (objY2 == aVar.a()) {
            Configuration configuration2 = new Configuration();
            if (configuration != null) {
                configuration2.setTo(configuration);
            }
            iVar.p(configuration2);
            obj = configuration2;
        }
        Configuration configuration3 = (Configuration) obj;
        Object objY3 = iVar.y();
        if (objY3 == aVar.a()) {
            objY3 = new a(configuration3, eVar);
            iVar.p(objY3);
        }
        final a aVar2 = (a) objY3;
        boolean zA = iVar.A(context);
        Object objY4 = iVar.y();
        if (zA || objY4 == aVar.a()) {
            objY4 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1

                /* JADX INFO: compiled from: source.java */
                @Metadata
                @SourceDebugExtension
                public static final class a implements androidx.compose.runtime.c0 {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Context f5272a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ AndroidCompositionLocals_androidKt.a f5273b;

                    public a(Context context, AndroidCompositionLocals_androidKt.a aVar) {
                        this.f5272a = context;
                        this.f5273b = aVar;
                    }

                    @Override // androidx.compose.runtime.c0
                    public void dispose() {
                        this.f5272a.getApplicationContext().unregisterComponentCallbacks(this.f5273b);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                    context.getApplicationContext().registerComponentCallbacks(aVar2);
                    return new a(context, aVar2);
                }
            };
            iVar.p(objY4);
        }
        androidx.compose.runtime.g0.a(eVar, (Function1) objY4, iVar, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return eVar;
    }

    public static final k2.g m(final Context context, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1348507246, i11, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:141)");
        }
        Object objY = iVar.y();
        androidx.compose.runtime.i.a aVar = androidx.compose.runtime.i.f3413a;
        if (objY == aVar.a()) {
            objY = new k2.g();
            iVar.p(objY);
        }
        k2.g gVar = (k2.g) objY;
        Object objY2 = iVar.y();
        if (objY2 == aVar.a()) {
            objY2 = new b(gVar);
            iVar.p(objY2);
        }
        final b bVar = (b) objY2;
        boolean zA = iVar.A(context);
        Object objY3 = iVar.y();
        if (zA || objY3 == aVar.a()) {
            objY3 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1

                /* JADX INFO: compiled from: source.java */
                @Metadata
                @SourceDebugExtension
                public static final class a implements androidx.compose.runtime.c0 {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Context f5274a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ AndroidCompositionLocals_androidKt.b f5275b;

                    public a(Context context, AndroidCompositionLocals_androidKt.b bVar) {
                        this.f5274a = context;
                        this.f5275b = bVar;
                    }

                    @Override // androidx.compose.runtime.c0
                    public void dispose() {
                        this.f5274a.getApplicationContext().unregisterComponentCallbacks(this.f5275b);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                    context.getApplicationContext().registerComponentCallbacks(bVar);
                    return new a(context, bVar);
                }
            };
            iVar.p(objY3);
        }
        androidx.compose.runtime.g0.a(gVar, (Function1) objY3, iVar, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return gVar;
    }
}
