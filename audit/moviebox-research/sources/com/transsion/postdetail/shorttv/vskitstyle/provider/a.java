package com.transsion.postdetail.shorttv.vskitstyle.provider;

import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.shorttv.favorite.IShortTvFavoriteProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

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
public final class a implements IShortTvFavoriteProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.postdetail.shorttv.a f55435a = (com.transsion.postdetail.shorttv.a) NetServiceGenerator.f49399d.a().i(com.transsion.postdetail.shorttv.a.class);

    @Override // com.transsion.shorttv.favorite.IShortTvFavoriteProvider
    public Object a(String str, ShortTVFavInfo shortTVFavInfo, Continuation<? super Unit> continuation) {
        return IShortTvFavoriteProvider.DefaultImpls.c(this, str, shortTVFavInfo, continuation);
    }

    @Override // com.transsion.shorttv.favorite.IShortTvFavoriteProvider
    public void b(String str, boolean z11, String str2) {
        IShortTvFavoriteProvider.DefaultImpls.b(this, str, z11, str2);
    }

    @Override // com.transsion.shorttv.favorite.IShortTvFavoriteProvider
    public Object c(JSONObject jSONObject, Continuation<? super BaseDto<String>> continuation) {
        com.transsion.postdetail.shorttv.a aVar = this.f55435a;
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jSONObject.toString();
        Intrinsics.f(string, "body.toString()");
        return com.transsion.postdetail.shorttv.a.C0589a.a(aVar, companion.create(string, MediaType.Companion.parse("application/json")), null, continuation, 2, null);
    }

    @Override // com.transsion.shorttv.favorite.IShortTvFavoriteProvider
    public Object d(String str, Continuation<? super ShortTVFavInfo> continuation) {
        return IShortTvFavoriteProvider.DefaultImpls.a(this, str, continuation);
    }
}
