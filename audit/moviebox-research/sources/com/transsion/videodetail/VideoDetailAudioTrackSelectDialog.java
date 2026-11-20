package com.transsion.videodetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class VideoDetailAudioTrackSelectDialog extends BaseBottomDialogFragment<rz.c> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f59846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public pz.a f59847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f59848n = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f59849o = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsion.player.longvideo.helper.w.class), new Function0<x0>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$3
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$special$$inlined$activityViewModels$default$4
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

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f59850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super DubsInfo, Unit> f59851q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59852a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59852a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59852a;
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
            this.f59852a.invoke(obj);
        }
    }

    private final MovieDetailViewModel Y0() {
        return (MovieDetailViewModel) this.f59848n.getValue();
    }

    private final com.transsion.player.longvideo.helper.w Z0() {
        return (com.transsion.player.longvideo.helper.w) this.f59849o.getValue();
    }

    public static final void b1(VideoDetailAudioTrackSelectDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        BaseBottomDialogFragment.S0(this$0, false, 1, null);
    }

    public static final void c1(VideoDetailAudioTrackSelectDialog this$0, pz.a this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (this$0.f59850p == 0 || System.currentTimeMillis() - this$0.f59850p > 1000) {
            this$0.f59850p = System.currentTimeMillis();
            DubsInfo item = this_apply.getItem(i11);
            if (item.isSubtitle()) {
                List<vx.a> listF = this$0.Z0().c().f();
                if (listF != null) {
                    for (vx.a aVar : listF) {
                        if (Intrinsics.b(aVar.b().getLan(), item.getLanCode())) {
                            aVar.l(true);
                            uo.b.f78622a.c("Audio_Subtitle", "详情页 字幕选择了, name:" + aVar.b().getLanName() + ", " + aVar.b().getLan() + ", " + aVar.d(), true);
                            this$0.Z0().b().n(aVar);
                        } else {
                            aVar.l(false);
                        }
                    }
                }
            } else {
                Function1<? super DubsInfo, Unit> function1 = this$0.f59851q;
                if (function1 != null) {
                    function1.invoke(this_apply.getItem(i11));
                }
            }
            BaseBottomDialogFragment.S0(this$0, false, 1, null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public rz.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.c cVarC = rz.c.c(inflater);
        Intrinsics.f(cVarC, "inflate(inflater)");
        return cVarC;
    }

    public final void d1(Function1<? super DubsInfo, Unit> function1) {
        this.f59851q = function1;
    }

    public final void e1(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.f59846l = subjectId;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003b  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        Subject second;
        List<DubsInfo> dubs;
        RecyclerView.m npaLinearLayoutManager;
        rz.c cVar = (rz.c) getMViewBinding();
        if (cVar != null) {
            cVar.f75785c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailAudioTrackSelectDialog.b1(this.f60002a, view);
                }
            });
            ProgressBar pbLoading = cVar.f75786d;
            Intrinsics.f(pbLoading, "pbLoading");
            so.c.k(pbLoading);
            RecyclerView recyclerView = cVar.f75787f;
            Context context = getContext();
            if (context != null) {
                Intrinsics.f(context, "context");
                if (com.transsion.baseui.util.b.a(context)) {
                    npaLinearLayoutManager = new NpaGridLayoutManager(requireContext(), 2);
                } else {
                    npaLinearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
                }
            } else {
                npaLinearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
            }
            recyclerView.setLayoutManager(npaLinearLayoutManager);
            RecyclerView recyclerView2 = cVar.f75787f;
            final pz.a aVar = new pz.a();
            this.f59847m = aVar;
            aVar.B0(new f9.d() { // from class: com.transsion.videodetail.t
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    VideoDetailAudioTrackSelectDialog.c1(this.f60003a, aVar, baseQuickAdapter, view, i11);
                }
            });
            recyclerView2.setAdapter(aVar);
        }
        MovieDetailViewModel movieDetailViewModelY0 = Y0();
        movieDetailViewModelY0.r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$initViewData$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Subject> pair) {
                invoke2((Pair<String, ? extends Subject>) pair);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends Subject> pair) {
                List listL;
                ProgressBar pbLoading2;
                List<DubsInfo> dubs2;
                Subject second2 = pair.getSecond();
                VideoDetailAudioTrackSelectDialog videoDetailAudioTrackSelectDialog = this.this$0;
                Subject subject = second2;
                if (subject == null || (dubs2 = subject.getDubs()) == null) {
                    listL = kotlin.collections.g.l();
                } else {
                    List<DubsInfo> list = dubs2;
                    listL = new ArrayList(kotlin.collections.h.v(list, 10));
                    for (DubsInfo dubsInfo : list) {
                        uo.b.a.g(uo.b.f78622a, "The dubsInfo.id is " + dubsInfo.getSubjectId() + ", the subjectId: $" + videoDetailAudioTrackSelectDialog.f59846l, false, 2, null);
                        dubsInfo.setSelected(Intrinsics.b(dubsInfo.getSubjectId(), videoDetailAudioTrackSelectDialog.f59846l));
                        listL.add(dubsInfo);
                    }
                }
                if (listL.size() > 1) {
                    rz.c cVar2 = (rz.c) videoDetailAudioTrackSelectDialog.getMViewBinding();
                    if (cVar2 != null && (pbLoading2 = cVar2.f75786d) != null) {
                        Intrinsics.f(pbLoading2, "pbLoading");
                        so.c.g(pbLoading2);
                    }
                    pz.a aVar2 = videoDetailAudioTrackSelectDialog.f59847m;
                    if (aVar2 != null) {
                        aVar2.w0(listL);
                    }
                }
            }
        }));
        Pair<String, Subject> pairF = movieDetailViewModelY0.r().f();
        if (pairF != null) {
            Subject second2 = pairF.getSecond();
            List<DubsInfo> dubs2 = second2 != null ? second2.getDubs() : null;
            if (dubs2 != null && !dubs2.isEmpty() && (second = pairF.getSecond()) != null && (dubs = second.getDubs()) != null && dubs.size() > 1) {
                return;
            }
        }
        uo.b.f78622a.c("Audio_Subtitle", "AudioTrack try use subtitle~~~", true);
        Z0().c().j(this, new a(new Function1<List<vx.a>, Unit>() { // from class: com.transsion.videodetail.VideoDetailAudioTrackSelectDialog$initViewData$2$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<vx.a> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<vx.a> list) {
                ProgressBar progressBar;
                uo.b.f78622a.c("Audio_Subtitle", "AudioTrack ---- use subtitle " + (list != null ? Integer.valueOf(list.size()) : null), true);
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (vx.a aVar2 : list) {
                        DubsInfo dubsInfo = new DubsInfo(null, aVar2.b().getLanName(), aVar2.b().getLan(), false, 9, null);
                        dubsInfo.setSelected(aVar2.f());
                        dubsInfo.setSubtitle(true);
                        arrayList.add(dubsInfo);
                    }
                }
                rz.c cVar2 = (rz.c) this.this$0.getMViewBinding();
                if (cVar2 != null && (progressBar = cVar2.f75786d) != null) {
                    so.c.g(progressBar);
                }
                pz.a aVar3 = this.this$0.f59847m;
                if (aVar3 != null) {
                    aVar3.w0(arrayList);
                }
            }
        }));
    }
}
