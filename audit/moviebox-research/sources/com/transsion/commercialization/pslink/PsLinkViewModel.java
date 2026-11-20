package com.transsion.commercialization.pslink;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.ad.ps.model.PsLinkDto;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PsLinkViewModel extends t0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f51722b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<PsLinkDto> f51723a = new c0<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void d(PsLinkViewModel psLinkViewModel, int i11, boolean z11, int i12, String str, String str2, int i13, Object obj) {
        int i14 = (i13 & 1) != 0 ? 0 : i11;
        boolean z12 = (i13 & 2) != 0 ? false : z11;
        int i15 = (i13 & 4) != 0 ? 10 : i12;
        if ((i13 & 16) != 0) {
            str2 = "";
        }
        psLinkViewModel.c(i14, z12, i15, str, str2);
    }

    public final void c(int i11, boolean z11, int i12, String scene, String pushModel) {
        Intrinsics.g(scene, "scene");
        Intrinsics.g(pushModel, "pushModel");
        j.d(u0.a(this), null, null, new PsLinkViewModel$getPsLinkList$1(i11, z11, i12, scene, pushModel, this, null), 3, null);
    }

    public final c0<PsLinkDto> e() {
        return this.f51723a;
    }
}
