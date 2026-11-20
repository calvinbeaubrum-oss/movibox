package com.transsion.home.viewmodel.oneclicked;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.banner.banner.holder.BannerImageHolder;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class OneClickDownloadAdapter extends ir.b<Subject> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneClickDownloadAdapter(List<? extends Subject> datas) {
        super(datas);
        Intrinsics.g(datas, "datas");
    }

    @Override // ir.b
    public boolean k() {
        return true;
    }

    @Override // kr.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void c(BannerImageHolder bannerImageHolder, Subject subject, int i11, int i12) {
        AppCompatImageView appCompatImageViewE;
        String url;
        Cover cover;
        if (bannerImageHolder == null || (appCompatImageViewE = bannerImageHolder.e()) == null) {
            return;
        }
        if (subject != null && subject.getBuiltIn()) {
            j.d(l0.a(w0.c()), null, null, new OneClickDownloadAdapter$onBindView$1$1(subject, appCompatImageViewE, null), 3, null);
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = appCompatImageViewE.getContext();
        Intrinsics.f(context, "context");
        if (subject == null || (cover = subject.getCover()) == null || (url = cover.getUrl()) == null) {
            url = "";
        }
        companion.r(context, appCompatImageViewE, url, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }
}
