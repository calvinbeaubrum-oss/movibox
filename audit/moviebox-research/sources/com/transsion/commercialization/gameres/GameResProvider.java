package com.transsion.commercialization.gameres;

import android.content.Context;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.bean.GameInfoType;
import com.transsion.commercializationapi.IGameResApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
@Route(path = "/commercialize/GameResTabProvider")
@Metadata
public final class GameResProvider implements IGameResApi {
    @Override // com.transsion.commercializationapi.IGameResApi
    public void f1(Context context, String pageName, GameInfoType type, String itemId, Function1<? super View, Unit> callback) {
        Intrinsics.g(context, "context");
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(type, "type");
        Intrinsics.g(itemId, "itemId");
        Intrinsics.g(callback, "callback");
        a.f51659a.a(type).a(context, pageName, itemId, callback);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }
}
