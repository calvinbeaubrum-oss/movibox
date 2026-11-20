package com.transsion.subtitle.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.v0;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.subtitle.dialog.SubtitleMainDialog2;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n6.a;

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
public abstract class SubtitleBaseFragment<T extends n6.a> extends BaseFragment<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SubtitleDownloadViewModel f58167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58168b = getClass().getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f58169c = tp.f.f77260a.f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f58170d = d0.e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f58171f = d0.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f58172g;

    public void g0() {
        Fragment parentFragment = getParentFragment();
        SubtitleMainDialog2 subtitleMainDialog2 = parentFragment instanceof SubtitleMainDialog2 ? (SubtitleMainDialog2) parentFragment : null;
        if (subtitleMainDialog2 != null) {
            subtitleMainDialog2.dismissAllowingStateLoss();
        }
    }

    public final String getPageName() {
        return this.f58172g;
    }

    public final String h0() {
        return this.f58168b;
    }

    public final SubtitleDownloadViewModel i0() {
        return this.f58167a;
    }

    public final boolean j0() {
        return this.f58169c || ((double) (((float) (((this.f58170d * 9) / 16) + f0.a(40.0f))) / ((float) this.f58171f))) > 0.35d;
    }

    public void k0() {
    }

    public final void l0(String dialogName) {
        Intrinsics.g(dialogName, "dialogName");
        HashMap map = new HashMap();
        map.put("dialog_name", dialogName);
        String str = this.f58172g;
        if (str != null) {
            com.transsion.baselib.report.m.f51277a.t(str, "dialog_show", map);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        Fragment parentFragment = getParentFragment();
        SubtitleMainDialog2 subtitleMainDialog2 = parentFragment instanceof SubtitleMainDialog2 ? (SubtitleMainDialog2) parentFragment : null;
        if (subtitleMainDialog2 != null) {
            this.f58167a = (SubtitleDownloadViewModel) new v0(subtitleMainDialog2).a(SubtitleDownloadViewModel.class);
        }
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f58172g = arguments.getString("KEY_PAGE_NAME", "");
        }
    }
}
