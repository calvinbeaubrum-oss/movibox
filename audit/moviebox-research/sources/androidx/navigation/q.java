package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@SuppressLint({"TypeParameterUnusedInFormals"})
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12332b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<?>, String> f12333c = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Navigator<? extends NavDestination>> f12334a = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(Class<? extends Navigator<?>> navigatorClass) {
            Intrinsics.g(navigatorClass, "navigatorClass");
            String strValue = (String) q.f12333c.get(navigatorClass);
            if (strValue == null) {
                Navigator.b bVar = (Navigator.b) navigatorClass.getAnnotation(Navigator.b.class);
                strValue = bVar == null ? null : bVar.value();
                if (!b(strValue)) {
                    throw new IllegalArgumentException(Intrinsics.p("No @Navigator.Name annotation found for ", navigatorClass.getSimpleName()).toString());
                }
                q.f12333c.put(navigatorClass, strValue);
            }
            Intrinsics.d(strValue);
            return strValue;
        }

        public final boolean b(String str) {
            return str != null && str.length() > 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Navigator<? extends NavDestination> b(Navigator<? extends NavDestination> navigator) {
        Intrinsics.g(navigator, "navigator");
        return c(f12332b.a(navigator.getClass()), navigator);
    }

    @CallSuper
    public Navigator<? extends NavDestination> c(String name, Navigator<? extends NavDestination> navigator) {
        Intrinsics.g(name, "name");
        Intrinsics.g(navigator, "navigator");
        if (!f12332b.b(name)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        Navigator<? extends NavDestination> navigator2 = this.f12334a.get(name);
        if (Intrinsics.b(navigator2, navigator)) {
            return navigator;
        }
        boolean z11 = false;
        if (navigator2 != null && navigator2.c()) {
            z11 = true;
        }
        if (!(!z11)) {
            throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
        }
        if (!navigator.c()) {
            return this.f12334a.put(name, navigator);
        }
        throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
    }

    @CallSuper
    public <T extends Navigator<?>> T d(String name) {
        Intrinsics.g(name, "name");
        if (!f12332b.b(name)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        Navigator<? extends NavDestination> navigator = this.f12334a.get(name);
        if (navigator != null) {
            return navigator;
        }
        throw new IllegalStateException("Could not find Navigator with name \"" + name + "\". You must call NavController.addNavigator() for each navigation type.");
    }

    public final Map<String, Navigator<? extends NavDestination>> e() {
        return kotlin.collections.s.t(this.f12334a);
    }
}
