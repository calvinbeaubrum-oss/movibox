package com.transsion.commercialization.aha;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.bean.AhaGameResponse;
import com.transsion.commercializationapi.IAhaGameApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
@Route(path = "/commercialize/AhaGameProvider")
@Metadata
public final class AhaGameProvider implements IAhaGameApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f51613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f51614b = (d) NetServiceGenerator.f49399d.a().i(d.class);

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        this.f51613a = context;
    }

    @Override // com.transsion.commercializationapi.IAhaGameApi
    public Object r(Continuation<? super AhaGameResponse> continuation) {
        return this.f51614b.a(d.f51622a.a(), ip.b.f67591a.a(new AhaGameRequest(new AhaGameQuery(0, 10))), continuation);
    }
}
