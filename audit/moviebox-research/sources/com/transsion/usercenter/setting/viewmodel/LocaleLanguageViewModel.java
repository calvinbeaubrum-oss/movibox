package com.transsion.usercenter.setting.viewmodel;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import kz.a;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocaleLanguageViewModel extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59755b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocaleLanguageViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59755b = LazyKt__LazyJVMKt.b(new Function0<c0<List<a>>>() { // from class: com.transsion.usercenter.setting.viewmodel.LocaleLanguageViewModel$localeLanguageListLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<List<a>> invoke() {
                return new c0<>();
            }
        });
    }

    public final void c() {
        j.d(l0.a(w0.b()), null, null, new LocaleLanguageViewModel$getList$1(this, null), 3, null);
    }

    public final c0<List<a>> d() {
        return (c0) this.f59755b.getValue();
    }
}
