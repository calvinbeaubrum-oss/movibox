package com.transsion.moviedetail.provider;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.activity.SubjectListActivity;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.IMovieDetailService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
@Route(path = "/movie/details")
@Metadata
public class MovieDetailServiceImpl implements IMovieDetailService {
    @Override // com.transsion.moviedetailapi.IMovieDetailService
    public String Q0() {
        return String.valueOf(Reflection.b(MovieDetailActivity.class).e());
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.moviedetailapi.IMovieDetailService
    public void l(Context context, Bundle params, Class<? extends AbsSubjectListViewModel> type, String str) {
        Intrinsics.g(context, "context");
        Intrinsics.g(params, "params");
        Intrinsics.g(type, "type");
        SubjectListActivity.f53436m.a(context, params, type, str);
    }

    @Override // com.transsion.moviedetailapi.IMovieDetailService
    public void o0(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        if (fragment instanceof SubjectListFragment) {
            ((SubjectListFragment) fragment).O1();
        }
    }

    @Override // com.transsion.moviedetailapi.IMovieDetailService
    public Fragment q1(Bundle params, Class<? extends AbsSubjectListViewModel> type) {
        Intrinsics.g(params, "params");
        Intrinsics.g(type, "type");
        return SubjectListFragment.C.a(params, type);
    }
}
