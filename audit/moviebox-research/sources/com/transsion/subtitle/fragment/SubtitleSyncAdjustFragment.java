package com.transsion.subtitle.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.c0;
import com.transsion.subtitle.view.SubtitleSyncAdjustView;
import com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class SubtitleSyncAdjustFragment extends SubtitleBaseFragment<wx.h> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.subtitle.helper.g f58223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.transsion.subtitle.helper.g f58224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public xx.b f58225j;

    public static final void p0(SubtitleSyncAdjustFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        SubtitleDownloadViewModel subtitleDownloadViewModelI0 = this$0.i0();
        c0<String> c0VarF = subtitleDownloadViewModelI0 != null ? subtitleDownloadViewModelI0.f() : null;
        if (c0VarF == null) {
            return;
        }
        c0VarF.q("SELECT_SUBTITLE");
    }

    private final void q0() {
        List<vx.a> listL;
        ArrayList arrayList = new ArrayList();
        xx.b bVar = this.f58225j;
        if (bVar == null || (listL = bVar.i()) == null) {
            listL = kotlin.collections.g.l();
        }
        for (vx.a aVar : listL) {
            if (aVar.f()) {
                arrayList.add(aVar);
            }
        }
        s0(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        Intrinsics.g(view, "view");
        wx.h hVar = (wx.h) getMViewBinding();
        if (hVar != null && (appCompatImageView = hVar.f79710b) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.fragment.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubtitleSyncAdjustFragment.p0(this.f58254a, view2);
                }
            });
        }
        wx.h hVar2 = (wx.h) getMViewBinding();
        com.transsion.subtitle.helper.g gVar = new com.transsion.subtitle.helper.g(hVar2 != null ? hVar2.f79714g : null);
        gVar.o(null);
        this.f58223h = gVar;
        wx.h hVar3 = (wx.h) getMViewBinding();
        com.transsion.subtitle.helper.g gVar2 = new com.transsion.subtitle.helper.g(hVar3 != null ? hVar3.f79713f : null);
        gVar2.o(null);
        this.f58224i = gVar2;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        q0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public wx.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.h hVarC = wx.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            return;
        }
        q0();
    }

    @Override // com.transsion.subtitle.fragment.SubtitleBaseFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        l0("dialog_subtitle_sync_adjust");
    }

    public final void r0(xx.b bVar) {
        this.f58225j = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s0(List<vx.a> list) {
        Space space;
        wx.h hVar;
        SubtitleSyncAdjustView subtitleSyncAdjustView;
        wx.h hVar2;
        SubtitleSyncAdjustView subtitleSyncAdjustView2;
        SubtitleSyncAdjustView subtitleSyncAdjustView3;
        com.transsion.subtitle.a.f58119a.a(SubtitleSyncAdjustFragment.class.getSimpleName() + " --> showSyncAdjustLayout() --> list.size = " + list.size());
        wx.h hVar3 = (wx.h) getMViewBinding();
        SubtitleSyncAdjustView subtitleSyncAdjustView4 = hVar3 != null ? hVar3.f79714g : null;
        if (subtitleSyncAdjustView4 != null) {
            subtitleSyncAdjustView4.setVisibility(8);
        }
        wx.h hVar4 = (wx.h) getMViewBinding();
        SubtitleSyncAdjustView subtitleSyncAdjustView5 = hVar4 != null ? hVar4.f79713f : null;
        if (subtitleSyncAdjustView5 != null) {
            subtitleSyncAdjustView5.setVisibility(8);
        }
        if (list.size() == 1) {
            vx.a aVar = list.get(0);
            wx.h hVar5 = (wx.h) getMViewBinding();
            if (hVar5 != null && (subtitleSyncAdjustView3 = hVar5.f79714g) != null) {
                subtitleSyncAdjustView3.setVisibility(0);
                subtitleSyncAdjustView3.setTitle("");
                com.transsion.subtitle.helper.g gVar = this.f58223h;
                if (gVar != null) {
                    gVar.r(aVar);
                }
                com.transsion.subtitle.helper.g gVar2 = this.f58223h;
                if (gVar2 != null) {
                    gVar2.q(new Function2<vx.a, Long, Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSyncAdjustFragment$showSyncAdjustLayout$1$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(vx.a aVar2, Long l11) {
                            invoke(aVar2, l11.longValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(vx.a aVar2, long j11) {
                            xx.b bVar = this.this$0.f58225j;
                            if (bVar != null) {
                                bVar.j(aVar2, j11);
                            }
                        }
                    });
                }
            }
            wx.h hVar6 = (wx.h) getMViewBinding();
            space = hVar6 != null ? hVar6.f79711c : null;
            if (space == null) {
                return;
            }
            space.setVisibility(8);
            return;
        }
        wx.h hVar7 = (wx.h) getMViewBinding();
        space = hVar7 != null ? hVar7.f79711c : null;
        if (space != null) {
            space.setVisibility(0);
        }
        for (vx.a aVar2 : list) {
            if (TextUtils.equals(aVar2.a(), "1st") && (hVar2 = (wx.h) getMViewBinding()) != null && (subtitleSyncAdjustView2 = hVar2.f79714g) != null) {
                subtitleSyncAdjustView2.setVisibility(0);
                subtitleSyncAdjustView2.setTitle("1st " + aVar2.b().getName());
                com.transsion.subtitle.helper.g gVar3 = this.f58223h;
                if (gVar3 != null) {
                    gVar3.r(aVar2);
                }
                com.transsion.subtitle.helper.g gVar4 = this.f58223h;
                if (gVar4 != null) {
                    gVar4.q(new Function2<vx.a, Long, Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSyncAdjustFragment$showSyncAdjustLayout$2$1$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(vx.a aVar3, Long l11) {
                            invoke(aVar3, l11.longValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(vx.a aVar3, long j11) {
                            xx.b bVar = this.this$0.f58225j;
                            if (bVar != null) {
                                bVar.j(aVar3, j11);
                            }
                        }
                    });
                }
            }
            if (TextUtils.equals(aVar2.a(), "2nd") && (hVar = (wx.h) getMViewBinding()) != null && (subtitleSyncAdjustView = hVar.f79713f) != null) {
                subtitleSyncAdjustView.setVisibility(0);
                subtitleSyncAdjustView.setTitle("2nd " + aVar2.b().getName());
                com.transsion.subtitle.helper.g gVar5 = this.f58224i;
                if (gVar5 != null) {
                    gVar5.r(aVar2);
                }
                com.transsion.subtitle.helper.g gVar6 = this.f58224i;
                if (gVar6 != null) {
                    gVar6.q(new Function2<vx.a, Long, Unit>() { // from class: com.transsion.subtitle.fragment.SubtitleSyncAdjustFragment$showSyncAdjustLayout$2$2$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(vx.a aVar3, Long l11) {
                            invoke(aVar3, l11.longValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(vx.a aVar3, long j11) {
                            xx.b bVar = this.this$0.f58225j;
                            if (bVar != null) {
                                bVar.j(aVar3, j11);
                            }
                        }
                    });
                }
            }
        }
    }
}
