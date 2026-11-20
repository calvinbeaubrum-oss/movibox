package com.transsion.postdetailapi;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;

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
@Metadata
public interface IPostDetailApi extends IProvider {
    Fragment E(String str);

    Fragment P0(String str, String str2);

    Fragment X0(String str);

    BaseItemProvider<PostSubjectItem> d0(String str, String str2, RecyclerView.s sVar);

    void f0(PostSubjectItem postSubjectItem);

    void l1(String str);

    Fragment n1();

    BaseItemProvider<PostSubjectItem> x1(String str, String str2, RecyclerView.s sVar);
}
