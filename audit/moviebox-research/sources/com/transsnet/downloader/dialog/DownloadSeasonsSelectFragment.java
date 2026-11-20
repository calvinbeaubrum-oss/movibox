package com.transsnet.downloader.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.drawable.DrawableCreator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsnet.downloader.R$anim;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.SeasonListBean;
import com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadSeasonsSelectFragment extends DownloadReDetectorBaseFragment<h00.k0> {
    public static final a B = new a(null);
    public Integer A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ResourcesSeasonList f60543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f60544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f60545x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.transsnet.downloader.adapter.n f60546y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f60547z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadSeasonsSelectFragment a(ResourcesSeasonList resourcesSeasonList, Integer num, boolean z11) {
            DownloadSeasonsSelectFragment downloadSeasonsSelectFragment = new DownloadSeasonsSelectFragment();
            downloadSeasonsSelectFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_dialog_style", Boolean.valueOf(z11)), TuplesKt.a("extra_subject_id_type", num)));
            downloadSeasonsSelectFragment.u1(resourcesSeasonList);
            return downloadSeasonsSelectFragment;
        }
    }

    public static final void q1(DownloadSeasonsSelectFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.t1();
    }

    public static final void r1(DownloadSeasonsSelectFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        List<SeasonListBean> listD;
        List<SeasonListBean> listD2;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsnet.downloader.bean.SeasonListBean");
        SeasonListBean seasonListBean = (SeasonListBean) item;
        if (this$0.f60547z == 0 || System.currentTimeMillis() - this$0.f60547z > 1000) {
            this$0.f60547z = System.currentTimeMillis();
            com.transsnet.downloader.adapter.n nVar = this$0.f60546y;
            int i12 = -1;
            if (nVar != null && (listD2 = nVar.D()) != null) {
                int i13 = 0;
                for (SeasonListBean seasonListBean2 : listD2) {
                    Integer num = this$0.A;
                    int season = seasonListBean2.getSeason();
                    if (num != null && num.intValue() == season) {
                        i12 = i13;
                        break;
                    }
                    i13++;
                }
            }
            if (i12 >= 0) {
                com.transsnet.downloader.adapter.n nVar2 = this$0.f60546y;
                if (i12 < ((nVar2 == null || (listD = nVar2.D()) == null) ? 0 : listD.size())) {
                    com.transsnet.downloader.adapter.n nVar3 = this$0.f60546y;
                    SeasonListBean item2 = nVar3 != null ? nVar3.getItem(i12) : null;
                    if (item2 != null) {
                        item2.setSelected(false);
                    }
                    com.transsnet.downloader.adapter.n nVar4 = this$0.f60546y;
                    if (nVar4 != null) {
                        nVar4.notifyItemChanged(i12, Boolean.FALSE);
                    }
                }
            }
            seasonListBean.setSelected(true);
            this$0.A = Integer.valueOf(seasonListBean.getSeason());
            com.transsnet.downloader.adapter.n nVar5 = this$0.f60546y;
            if (nVar5 != null) {
                nVar5.notifyItemChanged(i11, Boolean.TRUE);
            }
            this$0.s1(seasonListBean.getSeason());
            this$0.t1();
        }
    }

    private final void s1(int i11) {
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<Integer> c0VarY = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.y() : null;
        if (c0VarY == null) {
            return;
        }
        c0VarY.q(Integer.valueOf(i11));
    }

    private final void t1() {
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(2);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f60545x = arguments != null ? arguments.getBoolean("extra_dialog_style") : true;
        Bundle arguments2 = getArguments();
        this.f60544w = arguments2 != null ? Integer.valueOf(arguments2.getInt("extra_subject_id_type")) : null;
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        return z11 ? AnimationUtils.loadAnimation(getActivity(), R$anim.enter_bottom_menu) : AnimationUtils.loadAnimation(getActivity(), R$anim.exit_bottom_menu);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public h00.k0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.k0 k0VarC = h00.k0.c(inflater);
        Intrinsics.f(k0VarC, "inflate(inflater)");
        return k0VarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void u1(ResourcesSeasonList resourcesSeasonList) {
        this.f60543v = resourcesSeasonList;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0152  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        List<ResourcesSeason> seasons;
        RecyclerView.m npaLinearLayoutManager;
        List<ResourcesSeason> seasons2;
        List<ResourcesSeason> seasons3;
        Integer numF;
        androidx.lifecycle.c0<Integer> c0VarG;
        if (this.A == null) {
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
            if (downloadResourcesDetectorViewModelY0 == null || (c0VarG = downloadResourcesDetectorViewModelY0.g()) == null || (numF = c0VarG.f()) == null) {
                numF = 1;
            }
            this.A = numF;
        }
        h00.k0 k0Var = (h00.k0) getMViewBinding();
        if (k0Var != null) {
            if (!this.f60545x) {
                k0Var.f65922b.setBackground(new DrawableCreator.Builder().setSolidColor(requireActivity().getResources().getColor(R$color.gray_dark_00)).build());
            }
            k0Var.f65922b.getLayoutParams().height = T0();
            k0Var.f65925f.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadSeasonsSelectFragment.q1(this.f60602a, view);
                }
            });
            ResourcesSeasonList resourcesSeasonList = this.f60543v;
            if (resourcesSeasonList == null || (seasons3 = resourcesSeasonList.getSeasons()) == null || seasons3.size() != 1) {
                AppCompatTextView tvAllEpisodes = k0Var.f65927h;
                Intrinsics.f(tvAllEpisodes, "tvAllEpisodes");
                so.c.h(tvAllEpisodes);
                AppCompatTextView tvTitle = k0Var.f65928i;
                Intrinsics.f(tvTitle, "tvTitle");
                so.c.k(tvTitle);
            } else {
                AppCompatTextView tvAllEpisodes2 = k0Var.f65927h;
                Intrinsics.f(tvAllEpisodes2, "tvAllEpisodes");
                so.c.k(tvAllEpisodes2);
                AppCompatTextView tvTitle2 = k0Var.f65928i;
                Intrinsics.f(tvTitle2, "tvTitle");
                so.c.h(tvTitle2);
            }
            Integer num = this.f60544w;
            int value = SubjectType.EDUCATION.getValue();
            String string = null;
            if (num != null && num.intValue() == value) {
                h00.k0 k0Var2 = (h00.k0) getMViewBinding();
                AppCompatTextView appCompatTextView = k0Var2 != null ? k0Var2.f65927h : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(Utils.a().getString(R$string.download_series_all_lessons));
                }
                AppCompatTextView appCompatTextView2 = k0Var.f65928i;
                Context context = getContext();
                if (context != null) {
                    int i11 = R$string.download_video_detail_units;
                    Object[] objArr = new Object[1];
                    ResourcesSeasonList resourcesSeasonList2 = this.f60543v;
                    objArr[0] = String.valueOf((resourcesSeasonList2 == null || (seasons2 = resourcesSeasonList2.getSeasons()) == null) ? 1 : seasons2.size());
                    string = context.getString(i11, objArr);
                }
                appCompatTextView2.setText(string);
            } else {
                h00.k0 k0Var3 = (h00.k0) getMViewBinding();
                AppCompatTextView appCompatTextView3 = k0Var3 != null ? k0Var3.f65927h : null;
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setText(Utils.a().getString(R$string.download_series_all_episodes));
                }
                AppCompatTextView appCompatTextView4 = k0Var.f65928i;
                Context context2 = getContext();
                if (context2 != null) {
                    int i12 = R$string.download_video_detail_seasons;
                    Object[] objArr2 = new Object[1];
                    ResourcesSeasonList resourcesSeasonList3 = this.f60543v;
                    objArr2[0] = String.valueOf((resourcesSeasonList3 == null || (seasons = resourcesSeasonList3.getSeasons()) == null) ? 1 : seasons.size());
                    string = context2.getString(i12, objArr2);
                }
                appCompatTextView4.setText(string);
            }
            RecyclerView recyclerView = k0Var.f65926g;
            Context context3 = getContext();
            if (context3 != null) {
                Intrinsics.f(context3, "context");
                if (com.transsion.baseui.util.b.a(context3)) {
                    npaLinearLayoutManager = new NpaGridLayoutManager(requireContext(), 2);
                } else {
                    npaLinearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
                }
            } else {
                npaLinearLayoutManager = new NpaLinearLayoutManager(requireContext(), 1, false);
            }
            recyclerView.setLayoutManager(npaLinearLayoutManager);
            RecyclerView recyclerView2 = k0Var.f65926g;
            com.transsnet.downloader.adapter.n nVar = new com.transsnet.downloader.adapter.n(this.f60544w);
            this.f60546y = nVar;
            nVar.B0(new f9.d() { // from class: com.transsnet.downloader.dialog.y
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                    DownloadSeasonsSelectFragment.r1(this.f60603a, baseQuickAdapter, view, i13);
                }
            });
            recyclerView2.setAdapter(nVar);
        }
        ResourcesSeasonList resourcesSeasonList4 = this.f60543v;
        if (resourcesSeasonList4 != null) {
            ArrayList arrayList = new ArrayList();
            List<ResourcesSeason> seasons4 = resourcesSeasonList4.getSeasons();
            if (seasons4 != null) {
                for (ResourcesSeason resourcesSeason : seasons4) {
                    int se2 = resourcesSeason.getSe();
                    Integer num2 = this.A;
                    arrayList.add(new SeasonListBean(se2, num2 != null && num2.intValue() == resourcesSeason.getSe()));
                }
            }
            com.transsnet.downloader.adapter.n nVar2 = this.f60546y;
            if (nVar2 != null) {
                nVar2.w0(arrayList);
            }
        }
    }
}
