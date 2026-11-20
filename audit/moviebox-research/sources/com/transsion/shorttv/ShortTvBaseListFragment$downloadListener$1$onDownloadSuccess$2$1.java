package com.transsion.shorttv;

import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.MediaSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.shorttv.ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1", f = "ShortTvBaseListFragment.kt", l = {1140}, m = "invokeSuspend")
@SourceDebugExtension
public final class ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ qx.d $it;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ShortTvBaseListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1(qx.d dVar, ShortTvBaseListFragment shortTvBaseListFragment, Continuation<? super ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1> continuation) {
        super(2, continuation);
        this.$it = dVar;
        this.this$0 = shortTvBaseListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTvBaseListFragment$downloadListener$1$onDownloadSuccess$2$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Media video;
        Video videoAddress;
        String url;
        ShortTvBaseListFragment shortTvBaseListFragment;
        qx.d dVar;
        String str;
        com.transsion.player.shorttv.b bVar;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            ShortTVItem shortTVItemC = this.$it.c();
            if (shortTVItemC != null && (video = shortTVItemC.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
                ShortTvBaseListFragment shortTvBaseListFragment2 = this.this$0;
                qx.d dVar2 = this.$it;
                com.transsnet.downloader.manager.a aVarI0 = shortTvBaseListFragment2.I0();
                String strD = dVar2.d();
                int iB = dVar2.b();
                this.L$0 = shortTvBaseListFragment2;
                this.L$1 = dVar2;
                this.L$2 = url;
                this.label = 1;
                Object objA = aVarI0.a(strD, iB, url, this);
                if (objA == objE) {
                    return objE;
                }
                shortTvBaseListFragment = shortTvBaseListFragment2;
                dVar = dVar2;
                str = url;
                obj = objA;
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str2 = (String) this.L$2;
        dVar = (qx.d) this.L$1;
        ShortTvBaseListFragment shortTvBaseListFragment3 = (ShortTvBaseListFragment) this.L$0;
        ResultKt.b(obj);
        str = str2;
        shortTvBaseListFragment = shortTvBaseListFragment3;
        String str3 = (String) obj;
        if (str3 != null && (bVar = shortTvBaseListFragment.f57777p) != null) {
            ShortTVItem shortTVItemC2 = dVar.c();
            MediaSource mediaSource = new MediaSource(shortTVItemC2 != null ? shortTVItemC2.getId() : null, str, dVar.b(), null, null, 24, null);
            mediaSource.o(str3);
            Boxing.a(bVar.b(mediaSource));
        }
        return Unit.f68710a;
    }
}
