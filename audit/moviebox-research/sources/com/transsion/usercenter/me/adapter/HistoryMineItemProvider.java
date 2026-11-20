package com.transsion.usercenter.me.adapter;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.postdetail.shorttv.widget.ShortTVHistoryView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.profile.bean.MeHistoryInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class HistoryMineItemProvider extends BaseItemProvider<MeItemInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f59439f = LazyKt__LazyJVMKt.b(new Function0<c>() { // from class: com.transsion.usercenter.me.adapter.HistoryMineItemProvider$mAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c invoke() {
            return new c();
        }
    });

    public static final void w(HistoryMineItemProvider this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        VideoDetailPlayBean item = this$0.x().getItem(i11);
        this$0.y(item != null ? item.getSubjectType() : null, item != null ? item.getSubjectId() : null, "");
    }

    private final void y(Integer num, String str, String str2) {
        com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", num != null ? num.intValue() : SubjectType.MOVIE.getValue()).withString("id", str).withString("ops", str2).withString("module_name", "profiledetail").navigation();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 4;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.mine_item_history_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Object data = item.getData();
        MeHistoryInfo meHistoryInfo = data instanceof MeHistoryInfo ? (MeHistoryInfo) data : null;
        if (meHistoryInfo == null) {
            return;
        }
        View view = helper.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.HistoryMineItemProvider$convert$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                com.transsion.usercenter.me.b.f59452a.b(ShortTVHistoryView.TYPE_HISTORY);
                com.alibaba.android.arouter.launcher.a.d().b("/download/play_history").navigation();
            }
        }, 1, null);
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.historyRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        recyclerView.setAdapter(x());
        x().B0(new f9.d() { // from class: com.transsion.usercenter.me.adapter.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                HistoryMineItemProvider.w(this.f59449a, baseQuickAdapter, view2, i11);
            }
        });
        x().w0(meHistoryInfo.getList());
        List<VideoDetailPlayBean> list = meHistoryInfo.getList();
        recyclerView.setVisibility((list == null || list.isEmpty()) ^ true ? 0 : 8);
    }

    public final c x() {
        return (c) this.f59439f.getValue();
    }
}
