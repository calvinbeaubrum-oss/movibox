package com.transsion.publish.model;

import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.net.PostResuleEntity;
import hw.a;
import io.reactivex.rxjava3.core.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
public final class PublishModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f56480a = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.publish.model.PublishModel$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    public final String a() {
        return cp.a.f62775a.a();
    }

    public final RequestBody b(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    public final a c() {
        return (a) this.f56480a.getValue();
    }

    public final j<BaseDto<PostResuleEntity>> d(RequestPostEntity entity) {
        Intrinsics.g(entity, "entity");
        String strJ = n.j(entity);
        Intrinsics.f(strJ, "toJson(entity)");
        return c().b(a(), b(strJ));
    }

    public final j<BaseDto<PostResuleEntity>> e(RequestPostEntity entity) {
        Intrinsics.g(entity, "entity");
        String strJ = n.j(entity);
        Intrinsics.f(strJ, "toJson(entity)");
        return c().c(a(), b(strJ));
    }
}
