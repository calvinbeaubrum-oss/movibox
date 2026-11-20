package com.transsion.postdetail.ui.fragment;

import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import com.tn.lib.widget.R$drawable;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PostImageTextDetailFragment extends PostDetailCommonFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f55773u = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PostImageTextDetailFragment a(String str, boolean z11, String str2, PostSubjectItem postSubjectItem, String str3) {
            PostImageTextDetailFragment postImageTextDetailFragment = new PostImageTextDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putBoolean("from_comment", z11);
            bundle.putString("rec_ops", str2);
            postImageTextDetailFragment.setArguments(bundle);
            return postImageTextDetailFragment;
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public String getPageName() {
        return "postdetail_image_text";
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void p1() {
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void q1() {
        AppCompatImageView appCompatImageView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77846p) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$drawable.libui_ic_base_left);
    }

    @Override // com.transsion.postdetail.ui.fragment.PostDetailCommonFragment
    public void r1() {
    }
}
