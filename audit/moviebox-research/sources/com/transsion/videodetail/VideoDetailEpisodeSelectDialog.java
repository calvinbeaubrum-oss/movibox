package com.transsion.videodetail;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.dialog.BaseDialog;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.videodetail.bean.VideoDetailMediaSource;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class VideoDetailEpisodeSelectDialog extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rz.a f59853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GridLayoutManager f59854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pz.b f59855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59856d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f59857f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59858a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59858a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59858a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59858a.invoke(obj);
        }
    }

    public VideoDetailEpisodeSelectDialog() {
        super(R$layout.dialog_episode);
        this.f59856d = FragmentViewModelLazyKt.a(this, Reflection.b(VideoDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoDetailEpisodeSelectDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailEpisodeSelectDialog$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final VideoDetailViewModel k0() {
        return (VideoDetailViewModel) this.f59856d.getValue();
    }

    public static final void l0(VideoDetailEpisodeSelectDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void m0(VideoDetailEpisodeSelectDialog this$0, pz.b this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (this$0.f59857f == 0 || System.currentTimeMillis() - this$0.f59857f > 1000) {
            this$0.f59857f = System.currentTimeMillis();
            this$0.k0().z(this_apply.O(i11));
            this$0.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, com.transsion.baseui.R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(requireContext(), com.transsion.baseui.R$style.BottomDialogTheme);
        bVar.o().U0(3);
        bVar.o().T0(true);
        return bVar;
    }

    @Override // com.tn.lib.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().gravity = 80;
        window.getAttributes().height = -2;
        View viewFindViewById = window.findViewById(com.google.android.material.R$id.design_bottom_sheet);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(R.color.transparent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        rz.a aVarA = rz.a.a(view);
        aVarA.f75771b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoDetailEpisodeSelectDialog.l0(this.f60005a, view2);
            }
        });
        ProgressBar pbLoading = aVarA.f75772c;
        Intrinsics.f(pbLoading, "pbLoading");
        so.c.k(pbLoading);
        aVarA.f75773d.addItemDecoration(new pz.c(com.blankj.utilcode.util.i.e(12.0f)));
        RecyclerView recyclerView = aVarA.f75773d;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3);
        this.f59854b = gridLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView2 = aVarA.f75773d;
        final pz.b bVar = new pz.b(SubjectType.TV.getValue(), false, R$layout.item_video_detail_sel_dialog_episode);
        this.f59855c = bVar;
        bVar.B0(new f9.d() { // from class: com.transsion.videodetail.v
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                VideoDetailEpisodeSelectDialog.m0(this.f60011a, bVar, baseQuickAdapter, view2, i11);
            }
        });
        recyclerView2.setAdapter(bVar);
        this.f59853a = aVarA;
        k0().q().j(this, new a(new Function1<List<? extends VideoDetailMediaSource>, Unit>() { // from class: com.transsion.videodetail.VideoDetailEpisodeSelectDialog.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends VideoDetailMediaSource> list) {
                invoke2((List<VideoDetailMediaSource>) list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<VideoDetailMediaSource> list) {
                rz.a aVar;
                RecyclerView recyclerView3;
                ProgressBar progressBar;
                rz.a aVar2 = VideoDetailEpisodeSelectDialog.this.f59853a;
                if (aVar2 != null && (progressBar = aVar2.f75772c) != null) {
                    so.c.g(progressBar);
                }
                if (list == null) {
                    return;
                }
                if (list.size() >= 24 && (aVar = VideoDetailEpisodeSelectDialog.this.f59853a) != null && (recyclerView3 = aVar.f75773d) != null) {
                    ViewGroup.LayoutParams layoutParams = recyclerView3.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams;
                    ((ViewGroup.MarginLayoutParams) bVar2).height = com.blankj.utilcode.util.i.e(430.0f);
                    recyclerView3.setLayoutParams(bVar2);
                }
                pz.b bVar3 = VideoDetailEpisodeSelectDialog.this.f59855c;
                if (bVar3 != null) {
                    bVar3.m(list);
                }
            }
        }));
        k0().v().j(this, new a(new Function1<VideoDetailMediaSource, Unit>() { // from class: com.transsion.videodetail.VideoDetailEpisodeSelectDialog.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VideoDetailMediaSource videoDetailMediaSource) {
                invoke2(videoDetailMediaSource);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VideoDetailMediaSource videoDetailMediaSource) {
                pz.b bVar2 = VideoDetailEpisodeSelectDialog.this.f59855c;
                if (bVar2 != null) {
                    bVar2.K0(videoDetailMediaSource);
                }
            }
        }));
    }
}
