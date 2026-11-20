package com.transsion.home.fragment.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.transsion.baseui.fragment.BaseFragment;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BottomRoomFragment extends BaseFragment<lt.p> {
    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public lt.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.p pVarC = lt.p.c(inflater);
        Intrinsics.f(pVarC, "inflate(inflater)");
        return pVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        LinearLayout linearLayout;
        View view2;
        Intrinsics.g(view, "view");
        lt.p mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (view2 = mViewBinding.f70493b) == null) ? null : view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = com.blankj.utilcode.util.d.c();
        }
        lt.p mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f70494c) == null) {
            return;
        }
        so.c.k(linearLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }
}
