package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.play.detail.fragment.BaseBottomDialogFragment;
import com.transsnet.downloader.R$anim;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.SeasonListBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class VideoDetailSeasonsSelectFragment extends BaseBottomDialogFragment<tu.u> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f53627r = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ResourcesSeasonList f53628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f53629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.transsnet.downloader.adapter.n f53630n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f53631o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f53632p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super Integer, Unit> f53633q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoDetailSeasonsSelectFragment a(ResourcesSeasonList resourcesSeasonList, Integer num) {
            VideoDetailSeasonsSelectFragment videoDetailSeasonsSelectFragment = new VideoDetailSeasonsSelectFragment();
            videoDetailSeasonsSelectFragment.b1(resourcesSeasonList, num);
            return videoDetailSeasonsSelectFragment;
        }
    }

    public static final void X0(VideoDetailSeasonsSelectFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.a1();
    }

    public static final void Y0(VideoDetailSeasonsSelectFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        List<SeasonListBean> listD;
        List<SeasonListBean> listD2;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsnet.downloader.bean.SeasonListBean");
        SeasonListBean seasonListBean = (SeasonListBean) item;
        if (this$0.f53631o == 0 || System.currentTimeMillis() - this$0.f53631o > 1000) {
            this$0.f53631o = System.currentTimeMillis();
            com.transsnet.downloader.adapter.n nVar = this$0.f53630n;
            int i12 = -1;
            if (nVar != null && (listD2 = nVar.D()) != null) {
                int i13 = 0;
                for (SeasonListBean seasonListBean2 : listD2) {
                    Integer num = this$0.f53632p;
                    int season = seasonListBean2.getSeason();
                    if (num != null && num.intValue() == season) {
                        i12 = i13;
                        break;
                    }
                    i13++;
                }
            }
            if (i12 >= 0) {
                com.transsnet.downloader.adapter.n nVar2 = this$0.f53630n;
                if (i12 < ((nVar2 == null || (listD = nVar2.D()) == null) ? 0 : listD.size())) {
                    com.transsnet.downloader.adapter.n nVar3 = this$0.f53630n;
                    SeasonListBean item2 = nVar3 != null ? nVar3.getItem(i12) : null;
                    if (item2 != null) {
                        item2.setSelected(false);
                    }
                    com.transsnet.downloader.adapter.n nVar4 = this$0.f53630n;
                    if (nVar4 != null) {
                        nVar4.notifyItemChanged(i12, Boolean.FALSE);
                    }
                }
            }
            seasonListBean.setSelected(true);
            this$0.f53632p = Integer.valueOf(seasonListBean.getSeason());
            com.transsnet.downloader.adapter.n nVar5 = this$0.f53630n;
            if (nVar5 != null) {
                nVar5.notifyItemChanged(i11, Boolean.TRUE);
            }
            this$0.Z0(seasonListBean.getSeason());
            this$0.a1();
        }
    }

    private final void a1() {
        R0(true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public tu.u getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.u uVarC = tu.u.c(inflater);
        Intrinsics.f(uVarC, "inflate(inflater)");
        return uVarC;
    }

    public final void Z0(int i11) {
        Function1<? super Integer, Unit> function1 = this.f53633q;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i11));
        }
    }

    public final void b1(ResourcesSeasonList resourcesSeasonList, Integer num) {
        this.f53628l = resourcesSeasonList;
        this.f53629m = num;
    }

    public final void c1(Function1<? super Integer, Unit> function1) {
        this.f53633q = function1;
    }

    public final void d1(int i11) {
        this.f53632p = Integer.valueOf(i11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.play.detail.fragment.BaseBottomDialogFragment, androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i11, boolean z11, int i12) {
        return z11 ? AnimationUtils.loadAnimation(getActivity(), R$anim.enter_bottom_menu) : AnimationUtils.loadAnimation(getActivity(), R$anim.exit_bottom_menu);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0104  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        List<ResourcesSeason> seasons;
        RecyclerView.m npaLinearLayoutManager;
        List<ResourcesSeason> seasons2;
        List<ResourcesSeason> seasons3;
        tu.u uVar = (tu.u) getMViewBinding();
        if (uVar != null) {
            uVar.f77633d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoDetailSeasonsSelectFragment.X0(this.f53693a, view);
                }
            });
            ResourcesSeasonList resourcesSeasonList = this.f53628l;
            if (resourcesSeasonList == null || (seasons3 = resourcesSeasonList.getSeasons()) == null || seasons3.size() != 1) {
                AppCompatTextView tvAllEpisodes = uVar.f77635g;
                Intrinsics.f(tvAllEpisodes, "tvAllEpisodes");
                so.c.h(tvAllEpisodes);
                AppCompatTextView tvTitle = uVar.f77636h;
                Intrinsics.f(tvTitle, "tvTitle");
                so.c.k(tvTitle);
            } else {
                AppCompatTextView tvAllEpisodes2 = uVar.f77635g;
                Intrinsics.f(tvAllEpisodes2, "tvAllEpisodes");
                so.c.k(tvAllEpisodes2);
                AppCompatTextView tvTitle2 = uVar.f77636h;
                Intrinsics.f(tvTitle2, "tvTitle");
                so.c.h(tvTitle2);
            }
            Integer num = this.f53629m;
            int value = SubjectType.EDUCATION.getValue();
            String string = null;
            if (num != null && num.intValue() == value) {
                tu.u uVar2 = (tu.u) getMViewBinding();
                AppCompatTextView appCompatTextView = uVar2 != null ? uVar2.f77635g : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(Utils.a().getString(R$string.download_series_all_lessons));
                }
                AppCompatTextView appCompatTextView2 = uVar.f77636h;
                Context context = getContext();
                if (context != null) {
                    int i11 = R$string.download_video_detail_units;
                    Object[] objArr = new Object[1];
                    ResourcesSeasonList resourcesSeasonList2 = this.f53628l;
                    objArr[0] = String.valueOf((resourcesSeasonList2 == null || (seasons2 = resourcesSeasonList2.getSeasons()) == null) ? 1 : seasons2.size());
                    string = context.getString(i11, objArr);
                }
                appCompatTextView2.setText(string);
            } else {
                tu.u uVar3 = (tu.u) getMViewBinding();
                AppCompatTextView appCompatTextView3 = uVar3 != null ? uVar3.f77635g : null;
                if (appCompatTextView3 != null) {
                    appCompatTextView3.setText(Utils.a().getString(R$string.download_series_all_episodes));
                }
                AppCompatTextView appCompatTextView4 = uVar.f77636h;
                Context context2 = getContext();
                if (context2 != null) {
                    int i12 = R$string.download_video_detail_seasons;
                    Object[] objArr2 = new Object[1];
                    ResourcesSeasonList resourcesSeasonList3 = this.f53628l;
                    objArr2[0] = String.valueOf((resourcesSeasonList3 == null || (seasons = resourcesSeasonList3.getSeasons()) == null) ? 1 : seasons.size());
                    string = context2.getString(i12, objArr2);
                }
                appCompatTextView4.setText(string);
            }
            RecyclerView recyclerView = uVar.f77634f;
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
            RecyclerView recyclerView2 = uVar.f77634f;
            com.transsnet.downloader.adapter.n nVar = new com.transsnet.downloader.adapter.n(this.f53629m);
            this.f53630n = nVar;
            nVar.B0(new f9.d() { // from class: com.transsion.moviedetail.fragment.a1
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i13) {
                    VideoDetailSeasonsSelectFragment.Y0(this.f53635a, baseQuickAdapter, view, i13);
                }
            });
            recyclerView2.setAdapter(nVar);
        }
        ResourcesSeasonList resourcesSeasonList4 = this.f53628l;
        if (resourcesSeasonList4 != null) {
            ArrayList arrayList = new ArrayList();
            List<ResourcesSeason> seasons4 = resourcesSeasonList4.getSeasons();
            if (seasons4 != null) {
                for (ResourcesSeason resourcesSeason : seasons4) {
                    int se2 = resourcesSeason.getSe();
                    Integer num2 = this.f53632p;
                    arrayList.add(new SeasonListBean(se2, num2 != null && num2.intValue() == resourcesSeason.getSe()));
                }
            }
            com.transsnet.downloader.adapter.n nVar2 = this.f53630n;
            if (nVar2 != null) {
                nVar2.w0(arrayList);
            }
        }
    }
}
