package com.tn.lib.widget.toast.impl;

import android.app.Application;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.toast.core.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class ToastUtilImpl implements zp.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f50041a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<ToastUtilImpl> f50042b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ToastUtilImpl>() { // from class: com.tn.lib.widget.toast.impl.ToastUtilImpl$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ToastUtilImpl invoke() {
            return new ToastUtilImpl();
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ToastUtilImpl a() {
            return (ToastUtilImpl) ToastUtilImpl.f50042b.getValue();
        }

        public final void b(Application application) {
            Intrinsics.g(application, "application");
            h.c(h.f50034a, application, null, 2, null);
        }
    }

    @Override // zp.a
    public void a(int i11) {
        f("", i11, 0, 0, 0, 0);
    }

    @Override // zp.a
    public void b(CharSequence charSequence) {
        f(charSequence, 0, 0, 0, 0, 0);
    }

    @Override // zp.a
    public void c(CharSequence charSequence, int i11) {
        f(charSequence, 0, i11, 0, 0, 0);
    }

    @Override // zp.a
    public void d(int i11, CharSequence text, int i12, int i13, int i14) {
        Intrinsics.g(text, "text");
        f(text, 0, i12, i13, i14, i11);
    }

    public final void f(CharSequence charSequence, int i11, int i12, int i13, int i14, int i15) {
        if (i15 != 0) {
            h.f50034a.j(i15);
        } else {
            h.f50034a.j(R$layout.libui_common_toast_layout);
        }
        if (i12 != 0 || i13 != 0 || i14 != 0) {
            h.f50034a.f(i12, i13, i14);
        }
        if (i11 != 0) {
            h.f50034a.k(i11);
        } else {
            h.f50034a.l(charSequence);
        }
    }
}
