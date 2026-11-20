package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.collections.w;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FragmentStrictMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f8612a = new FragmentStrictMode();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f8613b = b.f8615d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public interface a {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8614c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public static final b f8615d = new b(w.f(), null, s.h());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Flag> f8616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Set<Class<? extends Violation>>> f8617b;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends Flag> flags, a aVar, Map<String, ? extends Set<Class<? extends Violation>>> allowedViolations) {
            Intrinsics.g(flags, "flags");
            Intrinsics.g(allowedViolations, "allowedViolations");
            this.f8616a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f8617b = linkedHashMap;
        }

        public final Set<Flag> a() {
            return this.f8616a;
        }

        public final a b() {
            return null;
        }

        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.f8617b;
        }
    }

    public static final void d(String str, Violation violation) {
        Intrinsics.g(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void f(Fragment fragment, String previousFragmentId) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.p(bVarB, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentReuseViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.g(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentTagUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void h(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(getRetainInstanceUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void i(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(getTargetFragmentRequestCodeUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void j(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void k(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(setRetainInstanceUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.p(bVarB, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void l(Fragment violatingFragment, Fragment targetFragment, int i11) {
        Intrinsics.g(violatingFragment, "violatingFragment");
        Intrinsics.g(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, i11);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(setTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(violatingFragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.p(bVarB, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void m(Fragment fragment, boolean z11) {
        Intrinsics.g(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z11);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(setUserVisibleHintViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.p(bVarB, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.c(bVarB, setUserVisibleHintViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void n(Fragment fragment, ViewGroup container) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f8612a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.p(bVarB, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(bVarB, wrongFragmentContainerViolation);
        }
    }

    public final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.f(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.getStrictModePolicy() != null) {
                    b strictModePolicy = parentFragmentManager.getStrictModePolicy();
                    Intrinsics.d(strictModePolicy);
                    return strictModePolicy;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f8613b;
    }

    public final void c(b bVar, final Violation violation) {
        Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Policy violation in ");
            sb2.append(name);
        }
        bVar.b();
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            o(fragment, new Runnable() { // from class: o3.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.d(name, violation);
                }
            });
        }
    }

    public final void e(Violation violation) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("StrictMode violation in ");
            sb2.append(violation.getFragment().getClass().getName());
        }
    }

    public final void o(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler handlerG = fragment.getParentFragmentManager().getHost().g();
        Intrinsics.f(handlerG, "fragment.parentFragmentManager.host.handler");
        if (Intrinsics.b(handlerG.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerG.post(runnable);
        }
    }

    public final boolean p(b bVar, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        Set<Class<? extends Violation>> set = bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.b(cls2.getSuperclass(), Violation.class) || !CollectionsKt___CollectionsKt.X(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
