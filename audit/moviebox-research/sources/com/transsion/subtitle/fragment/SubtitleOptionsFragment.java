package com.transsion.subtitle.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.c0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.subtitle.view.SubtitleOptionsView;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SubtitleOptionsFragment extends SubtitleBaseFragment<wx.e> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f58173n = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LocalVideoUiType f58174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f58175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.transsion.subtitle.helper.d f58176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SimpleSubtitleView f58177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SimpleSubtitleView f58178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f58179m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleOptionsFragment a(LocalVideoUiType localVideoUiType, Integer num, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ViewGroup viewGroup, com.transsion.subtitle.helper.d dVar, String str) {
            SubtitleOptionsFragment subtitleOptionsFragment = new SubtitleOptionsFragment();
            subtitleOptionsFragment.q0(localVideoUiType, num, simpleSubtitleView, simpleSubtitleView2, viewGroup, dVar);
            subtitleOptionsFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("KEY_PAGE_NAME", str)));
            return subtitleOptionsFragment;
        }
    }

    public static final void p0(SubtitleOptionsFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
        c0<String> c0VarF = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.f() : null;
        if (c0VarF == null) {
            return;
        }
        c0VarF.q("SELECT_SUBTITLE");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        SubtitleOptionsView subtitleOptionsView;
        Intrinsics.g(view, "view");
        wx.e eVar = (wx.e) getMViewBinding();
        if (eVar == null || (subtitleOptionsView = eVar.f79685b) == null) {
            return;
        }
        subtitleOptionsView.initOptions(this.f58174h, this.f58175i, this.f58177k, this.f58178l, this.f58179m, getPageName(), this.f58176j);
        wx.i.a(subtitleOptionsView).f79717c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleOptionsFragment.p0(this.f58230a, view2);
            }
        });
        subtitleOptionsView.addSubtitleOptions();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment
    public void k0() {
        SubtitleOptionsView subtitleOptionsView;
        wx.e eVar = (wx.e) getMViewBinding();
        if (eVar == null || (subtitleOptionsView = eVar.f79685b) == null) {
            return;
        }
        subtitleOptionsView.removeSubtitleOptions();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public wx.e getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.e eVarC = wx.e.c(inflater);
        Intrinsics.f(eVarC, "inflate(inflater)");
        return eVarC;
    }

    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        l0("dialog_subtitle_options");
    }

    public final void q0(LocalVideoUiType localVideoUiType, Integer num, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ViewGroup viewGroup, com.transsion.subtitle.helper.d dVar) {
        this.f58174h = localVideoUiType;
        this.f58175i = num;
        this.f58177k = simpleSubtitleView;
        this.f58178l = simpleSubtitleView2;
        this.f58179m = viewGroup;
        this.f58176j = dVar;
    }
}
