package com.transsnet.downloader.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;

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
public final class TransferReceivedViewModel extends MediaBaseViewModel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<List<DownloadBean>> f61270d = new c0<>();

    public static /* synthetic */ void i(TransferReceivedViewModel transferReceivedViewModel, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        transferReceivedViewModel.h(z11);
    }

    public final void h(boolean z11) {
        j.d(u0.a(this), w0.b(), null, new TransferReceivedViewModel$getTransferReceivedList$1(z11, this, null), 2, null);
    }

    public final c0<List<DownloadBean>> j() {
        return this.f61270d;
    }
}
