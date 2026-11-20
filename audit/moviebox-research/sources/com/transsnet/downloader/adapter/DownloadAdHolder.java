package com.transsnet.downloader.adapter;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hisavana.common.interfacz.TAdditionalListener;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$id;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class DownloadAdHolder extends BaseViewHolder implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f60302b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadAdHolder(View view) {
        super(view);
        Intrinsics.g(view, "view");
        this.f60302b = view;
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void a(int i11, e9.a aVar) {
        d0.a.a(this, i11, aVar);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void c(d0.b bVar) {
        d0.a.b(this, bVar);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void d(int i11, e9.a aVar) {
        NativeWrapperAdView nativeWrapperAdView;
        if (aVar instanceof DownloadBean) {
            try {
                Result.Companion companion = Result.Companion;
                TAdditionalListener wrapNativeManager = ((DownloadBean) aVar).getWrapNativeManager();
                Unit unit = null;
                com.transsion.ad.bidding.nativead.c cVar = wrapNativeManager instanceof com.transsion.ad.bidding.nativead.c ? (com.transsion.ad.bidding.nativead.c) wrapNativeManager : null;
                if (cVar != null && (nativeWrapperAdView = (NativeWrapperAdView) this.f60302b.findViewById(R$id.flRoot)) != null) {
                    Intrinsics.f(nativeWrapperAdView, "findViewById<NativeWrapperAdView>(R.id.flRoot)");
                    d00.b bVar = d00.b.f62855a;
                    Context context = nativeWrapperAdView.getContext();
                    Intrinsics.f(context, "it.context");
                    nativeWrapperAdView.bindNativeView(cVar, bVar.a(context, cVar.Q()));
                    unit = Unit.f68710a;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }
}
