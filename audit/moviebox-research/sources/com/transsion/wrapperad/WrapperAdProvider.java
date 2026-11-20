package com.transsion.wrapperad;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.AppManager;
import com.transsion.wrapperadapi.IWrapperAdApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vq.c;

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
@Route(path = "/wrapperAd/WrapperAdProvider")
@Metadata
public final class WrapperAdProvider implements IWrapperAdApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f60242a = new a(null);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements c {
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.wrapperadapi.IWrapperAdApi
    public Object k(Continuation<? super Unit> continuation) {
        Object objD = MBAd.f50258a.d(new MBAd.b().e("2301069UF9YjuO").c(false).g(false).d(AppManager.AppEnum.APP_MOVIE_BOX).f("HotStartScene").b("/wefeed-mobile-bff/ad/config").h(new b()).a(), continuation);
        return objD == kotlin.coroutines.intrinsics.a.e() ? objD : Unit.f68710a;
    }

    @Override // com.transsion.wrapperadapi.IWrapperAdApi
    public Object s1(Continuation<? super Unit> continuation) {
        Object objE = MBAd.f50258a.e("/wefeed-mobile-bff/ad/config", continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }
}
