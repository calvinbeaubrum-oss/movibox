package com.transsion.baseui.activity;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class d {
    public static final void a(String tag) {
        Intrinsics.g(tag, "tag");
        uo.b.f78622a.n(tag, new String[]{"Application onCreate"}, true);
    }

    public static /* synthetic */ void b(String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        a(str);
    }

    public static final void c(String tag, Activity activity) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(activity, "activity");
        uo.b.f78622a.n(tag, new String[]{activity.getLocalClassName() + " onCreate"}, true);
    }

    public static /* synthetic */ void d(String str, Activity activity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        c(str, activity);
    }

    public static final void e(String tag, Activity activity) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(activity, "activity");
        uo.b.f78622a.n(tag, new String[]{activity.getLocalClassName() + " onDestroy"}, true);
    }

    public static /* synthetic */ void f(String str, Activity activity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        e(str, activity);
    }

    public static final void g(String tag, Fragment fragment, boolean z11, String other) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(other, "other");
        uo.b.f78622a.n(tag, new String[]{fragment.getClass().getSimpleName() + " hidden=" + z11 + " " + other}, true);
    }

    public static /* synthetic */ void h(String str, Fragment fragment, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        if ((i11 & 8) != 0) {
            str2 = "";
        }
        g(str, fragment, z11, str2);
    }

    public static final void i(String tag, Activity activity) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(activity, "activity");
        uo.b.f78622a.n(tag, new String[]{activity.getLocalClassName() + " onPause"}, true);
    }

    public static final void j(String tag, Fragment fragment, String other) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(other, "other");
        uo.b.f78622a.n(tag, new String[]{fragment.getClass().getSimpleName() + " onPause " + other}, true);
    }

    public static /* synthetic */ void k(String str, Activity activity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        i(str, activity);
    }

    public static /* synthetic */ void l(String str, Fragment fragment, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        j(str, fragment, str2);
    }

    public static final void m(String tag, Activity activity) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(activity, "activity");
        uo.b.f78622a.n(tag, new String[]{activity.getLocalClassName() + " onResume"}, true);
    }

    public static final void n(String tag, Fragment fragment, String other) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(other, "other");
        uo.b.f78622a.n(tag, new String[]{fragment.getClass().getSimpleName() + " onResume " + other}, true);
    }

    public static /* synthetic */ void o(String str, Activity activity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        m(str, activity);
    }

    public static /* synthetic */ void p(String str, Fragment fragment, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "CommonInfo";
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        n(str, fragment, str2);
    }
}
