package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SafeWindowLayoutComponentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SafeWindowLayoutComponentProvider f13154a = new SafeWindowLayoutComponentProvider();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f13155b = LazyKt__LazyJVMKt.b(new Function0<WindowLayoutComponent>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$windowLayoutComponent$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WindowLayoutComponent invoke() {
            ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
            if (classLoader == null || !SafeWindowLayoutComponentProvider.f13154a.i(classLoader)) {
                return null;
            }
            try {
                return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
            } catch (UnsupportedOperationException unused) {
                return null;
            }
        }
    });

    public final boolean i(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && r(classLoader) && p(classLoader) && q(classLoader) && n(classLoader);
    }

    public final boolean j(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }

    public final boolean k(Method method, KClass<?> kClass) {
        return j(method, JvmClassMappingKt.a(kClass));
    }

    public final Class<?> l(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    public final WindowLayoutComponent m() {
        return (WindowLayoutComponent) f13155b.getValue();
    }

    public final boolean n(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f13154a;
                Class clsL = safeWindowLayoutComponentProvider.l(classLoader);
                boolean z11 = false;
                Method getBoundsMethod = clsL.getMethod("getBounds", new Class[0]);
                Method getTypeMethod = clsL.getMethod("getType", new Class[0]);
                Method getStateMethod = clsL.getMethod("getState", new Class[0]);
                Intrinsics.f(getBoundsMethod, "getBoundsMethod");
                if (safeWindowLayoutComponentProvider.k(getBoundsMethod, Reflection.b(Rect.class)) && safeWindowLayoutComponentProvider.o(getBoundsMethod)) {
                    Intrinsics.f(getTypeMethod, "getTypeMethod");
                    Class cls = Integer.TYPE;
                    if (safeWindowLayoutComponentProvider.k(getTypeMethod, Reflection.b(cls)) && safeWindowLayoutComponentProvider.o(getTypeMethod)) {
                        Intrinsics.f(getStateMethod, "getStateMethod");
                        if (safeWindowLayoutComponentProvider.k(getStateMethod, Reflection.b(cls)) && safeWindowLayoutComponentProvider.o(getStateMethod)) {
                            z11 = true;
                        }
                    }
                }
                return Boolean.valueOf(z11);
            }
        });
    }

    public final boolean o(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean p(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f13154a;
                boolean z11 = false;
                Method getWindowLayoutComponentMethod = safeWindowLayoutComponentProvider.t(classLoader).getMethod("getWindowLayoutComponent", new Class[0]);
                Class windowLayoutComponentClass = safeWindowLayoutComponentProvider.v(classLoader);
                Intrinsics.f(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
                if (safeWindowLayoutComponentProvider.o(getWindowLayoutComponentMethod)) {
                    Intrinsics.f(windowLayoutComponentClass, "windowLayoutComponentClass");
                    if (safeWindowLayoutComponentProvider.j(getWindowLayoutComponentMethod, windowLayoutComponentClass)) {
                        z11 = true;
                    }
                }
                return Boolean.valueOf(z11);
            }
        });
    }

    @RequiresApi(24)
    public final boolean q(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f13154a;
                Class clsV = safeWindowLayoutComponentProvider.v(classLoader);
                boolean z11 = false;
                Method addListenerMethod = clsV.getMethod("addWindowLayoutInfoListener", Activity.class, s.a());
                Method removeListenerMethod = clsV.getMethod("removeWindowLayoutInfoListener", s.a());
                Intrinsics.f(addListenerMethod, "addListenerMethod");
                if (safeWindowLayoutComponentProvider.o(addListenerMethod)) {
                    Intrinsics.f(removeListenerMethod, "removeListenerMethod");
                    if (safeWindowLayoutComponentProvider.o(removeListenerMethod)) {
                        z11 = true;
                    }
                }
                return Boolean.valueOf(z11);
            }
        });
    }

    public final boolean r(final ClassLoader classLoader) {
        return s(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.f13154a;
                boolean z11 = false;
                Method getWindowExtensionsMethod = safeWindowLayoutComponentProvider.u(classLoader).getDeclaredMethod("getWindowExtensions", new Class[0]);
                Class windowExtensionsClass = safeWindowLayoutComponentProvider.t(classLoader);
                Intrinsics.f(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                Intrinsics.f(windowExtensionsClass, "windowExtensionsClass");
                if (safeWindowLayoutComponentProvider.j(getWindowExtensionsMethod, windowExtensionsClass) && safeWindowLayoutComponentProvider.o(getWindowExtensionsMethod)) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }
        });
    }

    public final boolean s(Function0<Boolean> function0) {
        try {
            return function0.invoke().booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    public final Class<?> t(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    public final Class<?> u(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    public final Class<?> v(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }
}
