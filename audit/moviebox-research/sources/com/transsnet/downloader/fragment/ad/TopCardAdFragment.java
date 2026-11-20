package com.transsnet.downloader.fragment.ad;

import android.view.LayoutInflater;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.wrapperad.view.NativeSlideshowView;
import h00.l0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TopCardAdFragment extends LazyFragment<l0> {
    private final String S0() {
        return "DownloadListScene";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        NativeSlideshowView nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView2;
        super.B0();
        l0 l0Var = (l0) getMViewBinding();
        if (l0Var != null && (nativeSlideshowView2 = l0Var.f65936c) != null) {
            nativeSlideshowView2.setSceneId(S0());
        }
        l0 l0Var2 = (l0) getMViewBinding();
        if (l0Var2 == null || (nativeSlideshowView = l0Var2.f65936c) == null) {
            return;
        }
        nativeSlideshowView.initAd();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R0() {
        NativeSlideshowView nativeSlideshowView;
        l0 l0Var = (l0) getMViewBinding();
        if (l0Var == null || (nativeSlideshowView = l0Var.f65936c) == null) {
            return;
        }
        nativeSlideshowView.affirm();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public l0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        l0 l0VarC = l0.c(inflater);
        Intrinsics.f(l0VarC, "inflate(inflater)");
        return l0VarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public h newLogViewConfig() {
        return new h("TopCardAdFragment", false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        NativeSlideshowView nativeSlideshowView;
        super.onDestroy();
        l0 l0Var = (l0) getMViewBinding();
        if (l0Var == null || (nativeSlideshowView = l0Var.f65936c) == null) {
            return;
        }
        nativeSlideshowView.destroy();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
