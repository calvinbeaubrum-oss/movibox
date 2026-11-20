package com.transsion.home.fragment.tab;

import androidx.recyclerview.widget.RecyclerView;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.home.adapter.trending.TrendingAdapter;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TrendingFragment$checkGamesList$1 extends Lambda implements Function1<List<AhaGameAllGames>, Unit> {
    final /* synthetic */ TrendingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingFragment$checkGamesList$1(TrendingFragment trendingFragment) {
        super(1);
        this.this$0 = trendingFragment;
    }

    public static final void b(TrendingFragment this$0, List list) {
        Intrinsics.g(this$0, "this$0");
        TrendingAdapter trendingAdapter = this$0.f52566l;
        TrendingAdapter trendingAdapter2 = null;
        if (trendingAdapter == null) {
            Intrinsics.y("mAdapter");
            trendingAdapter = null;
        }
        if (trendingAdapter.D().size() > 2) {
            TrendingAdapter trendingAdapter3 = this$0.f52566l;
            if (trendingAdapter3 == null) {
                Intrinsics.y("mAdapter");
                trendingAdapter3 = null;
            }
            String type = trendingAdapter3.getItem(2).getType();
            PostItemType postItemType = PostItemType.GAME_LIST;
            if (Intrinsics.b(type, postItemType.getValue())) {
                return;
            }
            TrendingAdapter trendingAdapter4 = this$0.f52566l;
            if (trendingAdapter4 == null) {
                Intrinsics.y("mAdapter");
            } else {
                trendingAdapter2 = trendingAdapter4;
            }
            trendingAdapter2.j(2, new OperateItem(null, postItemType.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, list, null, null, null, null, 2031613, null));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<AhaGameAllGames> list) {
        invoke2(list);
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<AhaGameAllGames> list) {
        lt.s sVar;
        RecyclerView recyclerView;
        List<AhaGameAllGames> list2 = list;
        if (list2 == null || list2.isEmpty() || (sVar = (lt.s) this.this$0.getMViewBinding()) == null || (recyclerView = sVar.f70507d) == null) {
            return;
        }
        final TrendingFragment trendingFragment = this.this$0;
        recyclerView.post(new Runnable() { // from class: com.transsion.home.fragment.tab.j0
            @Override // java.lang.Runnable
            public final void run() {
                TrendingFragment$checkGamesList$1.b(trendingFragment, list);
            }
        });
    }
}
