package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$mipmap;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class OpNumberRankProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52241f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class NumberRankAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> {
        public final OperateItem H;
        public final int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NumberRankAdapter(OperateItem operateItem, int i11) {
            super(R$layout.item_number_rank_adapter, null, 2, null);
            Intrinsics.g(operateItem, "operateItem");
            this.H = operateItem;
            this.I = i11;
        }

        public static final void I0(Subject item, NumberRankAdapter this$0, int i11, View view) {
            Intrinsics.g(item, "$item");
            Intrinsics.g(this$0, "this$0");
            HomeUtilsKt.b(item, PostItemType.RANKING_LIST_NUMBER.getValue());
            this$0.L0(i11);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, final Subject item) {
            String url;
            String thumbnail;
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            final int iB = com.transsion.baselib.utils.i.b(D(), item);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpNumberRankProvider.NumberRankAdapter.I0(item, this, iB, view);
                }
            });
            holder.setText(R$id.op_item_number_rank_title, item.getTitle());
            ((TextView) holder.getView(R$id.op_item_number_rank_title)).setGravity(ot.a.d());
            ImageView imageView = (ImageView) holder.getView(R$id.op_item_number_rank_poster);
            if (item.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new OpNumberRankProvider$NumberRankAdapter$convert$2(item, imageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = imageView.getContext();
                Intrinsics.f(context, "coverImage.context");
                Cover cover = item.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                int iA = f0.a(105.0f);
                int iA2 = f0.a(147.0f);
                Cover cover2 = item.getCover();
                if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                    thumbnail = "";
                }
                companion.q(context, imageView, url, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : iA2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
            holder.setText(R$id.op_item_number_rank_corner, item.getCorner());
            holder.setImageResource(R$id.op_item_number_rank_index_image, J0(iB));
            K0(iB);
        }

        public final int J0(int i11) {
            switch (i11) {
                case 0:
                    return R$mipmap.ic_op_rank_number_1;
                case 1:
                    return R$mipmap.ic_op_rank_number_2;
                case 2:
                    return R$mipmap.ic_op_rank_number_3;
                case 3:
                    return R$mipmap.ic_op_rank_number_4;
                case 4:
                    return R$mipmap.ic_op_rank_number_5;
                case 5:
                    return R$mipmap.ic_op_rank_number_6;
                case 6:
                    return R$mipmap.ic_op_rank_number_7;
                case 7:
                    return R$mipmap.ic_op_rank_number_8;
                case 8:
                    return R$mipmap.ic_op_rank_number_9;
                case 9:
                    return R$mipmap.ic_op_rank_number_10;
                default:
                    return R$mipmap.ic_op_rank_number_10;
            }
        }

        public final void K0(int i11) {
            List<AppointSubject> subjects = this.H.getSubjects();
            AppointSubject appointSubject = subjects != null ? subjects.get(i11) : null;
            HashMap map = new HashMap();
            map.put("event_type", "browse_number_rank_item");
            map.put("sequence", String.valueOf(i11));
            map.put("subject_type", String.valueOf(appointSubject != null ? appointSubject.getSubjectType() : null));
            map.put("tabId", String.valueOf(this.I));
            String title = this.H.getTitle();
            if (title == null) {
                title = "";
            }
            map.put("groupTitle", title);
            ot.b.a(this.H, map);
            if (appointSubject != null) {
                ot.b.c(appointSubject, map);
            }
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.I), map);
        }

        public final void L0(int i11) {
            List<AppointSubject> subjects = this.H.getSubjects();
            AppointSubject appointSubject = subjects != null ? subjects.get(i11) : null;
            HashMap map = new HashMap();
            map.put("event_type", "click_number_rank_item");
            map.put("sequence", String.valueOf(i11));
            map.put("subject_type", String.valueOf(appointSubject != null ? appointSubject.getSubjectType() : null));
            map.put("tabId", String.valueOf(this.I));
            String title = this.H.getTitle();
            if (title == null) {
                title = "";
            }
            map.put("groupTitle", title);
            ot.b.a(this.H, map);
            if (appointSubject != null) {
                ot.b.c(appointSubject, map);
            }
            com.transsion.baselib.helper.a.f51183a.b(SubTabFragment.f52541r.a(this.I), map);
        }
    }

    public OpNumberRankProvider(int i11) {
        this.f52241f = i11;
    }

    private final void A(OperateItem operateItem) {
        List<OperateItem> listD;
        HashMap map = new HashMap();
        map.put("event_type", "click_number_rank_more");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        map.put("sequence", String.valueOf((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? null : Integer.valueOf(listD.indexOf(operateItem))));
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null) {
            deepLink = "";
        }
        map.put("deepLink", deepLink);
        String title = operateItem.getTitle();
        map.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        map.put("tabId", String.valueOf(this.f52241f));
        ot.b.a(operateItem, map);
        map.put("opt_type", PostItemType.RANKING_LIST_NUMBER.getValue() + "_MORE");
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52241f), map);
    }

    public static final void x(OperateItem item, OpNumberRankProvider this$0, View view) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        String deepLink = item.getDeepLink();
        if (deepLink != null) {
            com.transsion.baselib.utils.i.e(deepLink, null, 1, null);
        }
        this$0.A(item);
    }

    public static final void y(OperateItem item, OpNumberRankProvider this$0, View view) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        String deepLink = item.getDeepLink();
        if (deepLink != null) {
            com.transsion.baselib.utils.i.e(deepLink, null, 1, null);
        }
        this$0.A(item);
    }

    private final void z(OperateItem operateItem) {
        List<OperateItem> listD;
        HashMap map = new HashMap();
        map.put("event_type", "browse_number_rank_more");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        map.put("sequence", String.valueOf((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? null : Integer.valueOf(listD.indexOf(operateItem))));
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null) {
            deepLink = "";
        }
        map.put("deepLink", deepLink);
        String title = operateItem.getTitle();
        map.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        map.put("tabId", String.valueOf(this.f52241f));
        ot.b.a(operateItem, map);
        map.put("opt_type", PostItemType.RANKING_LIST_NUMBER.getValue() + "_MORE");
        com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52241f), map);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.RANKING_LIST_NUMBER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_op_movie_rank;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) helper.getView(R$id.main_operation_movie_rank_title);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.main_operation_movie_more_text);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            so.c.h(textView2);
        } else {
            so.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpNumberRankProvider.x(item, this, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpNumberRankProvider.y(item, this, view);
                }
            });
            z(item);
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_movie_rank_recycler);
        NumberRankAdapter numberRankAdapter = new NumberRankAdapter(item, this.f52241f);
        recyclerView.setAdapter(numberRankAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        List<AppointSubject> subjects = item.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        if (subjects.size() > 10) {
            subjects = subjects.subList(0, 10);
        }
        numberRankAdapter.w0(subjects);
    }
}
