package com.transsion.postdetail.shorttv.vskitstyle.provider;

import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.h;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class ShortTvDownloadProvider implements ox.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f55433a = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsion.postdetail.shorttv.vskitstyle.provider.ShortTvDownloadProvider$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    @Override // ox.a
    public Object a(String str, int i11, String str2, Continuation<? super String> continuation) {
        return d().a(str, i11, str2, continuation);
    }

    @Override // ox.a
    public Object b(String str, int i11, long j11, Continuation<? super Unit> continuation) throws Throwable {
        Object objR = DownloadEsHelper.f60994m.a().R(str, i11, j11, continuation);
        return objR == kotlin.coroutines.intrinsics.a.e() ? objR : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // ox.a
    public Object c(String str, Continuation<? super List<ShortTVItem>> continuation) throws Throwable {
        ShortTvDownloadProvider$fetchDownloadList$1 shortTvDownloadProvider$fetchDownloadList$1;
        if (continuation instanceof ShortTvDownloadProvider$fetchDownloadList$1) {
            shortTvDownloadProvider$fetchDownloadList$1 = (ShortTvDownloadProvider$fetchDownloadList$1) continuation;
            int i11 = shortTvDownloadProvider$fetchDownloadList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                shortTvDownloadProvider$fetchDownloadList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                shortTvDownloadProvider$fetchDownloadList$1 = new ShortTvDownloadProvider$fetchDownloadList$1(this, continuation);
            }
        } else {
            shortTvDownloadProvider$fetchDownloadList$1 = new ShortTvDownloadProvider$fetchDownloadList$1(this, continuation);
        }
        Object objQ = shortTvDownloadProvider$fetchDownloadList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = shortTvDownloadProvider$fetchDownloadList$1.label;
        if (i12 == 0) {
            ResultKt.b(objQ);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            shortTvDownloadProvider$fetchDownloadList$1.label = 1;
            objQ = downloadEsHelperA.q(str, shortTvDownloadProvider$fetchDownloadList$1);
            if (objQ == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objQ);
        }
        Iterable iterable = (Iterable) objQ;
        ArrayList arrayList = new ArrayList(h.v(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(DownloadUtil.f61136a.o((DownloadBean) it.next()));
        }
        return arrayList;
    }

    public final com.transsnet.downloader.manager.a d() {
        return (com.transsnet.downloader.manager.a) this.f55433a.getValue();
    }
}
