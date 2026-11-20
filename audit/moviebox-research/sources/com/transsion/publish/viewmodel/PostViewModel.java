package com.transsion.publish.viewmodel;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import com.transsion.publish.model.PublishModel;
import com.transsion.publish.net.PostResuleEntity;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PostViewModel extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0<PostResuleEntity> f56810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Boolean> f56811d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f56809b = LazyKt__LazyJVMKt.b(new Function0<PublishModel>() { // from class: com.transsion.publish.viewmodel.PostViewModel$publishModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishModel invoke() {
                return new PublishModel();
            }
        });
        this.f56810c = new c0<>();
        this.f56811d = new c0<>(Boolean.FALSE);
    }
}
