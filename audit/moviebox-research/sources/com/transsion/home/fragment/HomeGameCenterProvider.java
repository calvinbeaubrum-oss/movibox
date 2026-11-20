package com.transsion.home.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.transsion.ad.middle.nonstandard.WrapperNonstandardManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
public final class HomeGameCenterProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WrapperNonstandardManager f52404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WrapperNonstandardManager f52405b;

    public final void c() {
        WrapperNonstandardManager wrapperNonstandardManager = this.f52404a;
        if (wrapperNonstandardManager != null) {
            wrapperNonstandardManager.b();
        }
        WrapperNonstandardManager wrapperNonstandardManager2 = this.f52405b;
        if (wrapperNonstandardManager2 != null) {
            wrapperNonstandardManager2.b();
        }
    }

    public final void d(FrameLayout flGameCenter, FrameLayout flPhoneCenter, View leftLogo, k0 k0Var) {
        Intrinsics.g(flGameCenter, "flGameCenter");
        Intrinsics.g(flPhoneCenter, "flPhoneCenter");
        Intrinsics.g(leftLogo, "leftLogo");
        if (this.f52404a == null) {
            this.f52404a = new WrapperNonstandardManager();
        }
        if (this.f52405b == null) {
            this.f52405b = new WrapperNonstandardManager();
        }
        if (k0Var != null) {
            kotlinx.coroutines.j.d(k0Var, null, null, new HomeGameCenterProvider$initGameCenter$1(this, flGameCenter, flPhoneCenter, leftLogo, null), 3, null);
        }
    }
}
