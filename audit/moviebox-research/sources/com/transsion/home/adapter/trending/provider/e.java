package com.transsion.home.adapter.trending.provider;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.TnTextView;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$string;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class e extends BaseItemProvider<OperateItem> {
    public static final void x(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/commercial/gamecenter").navigation();
        pr.a.f74040a.i();
    }

    public static final void y(com.transsion.home.adapter.trending.adapter.a this_apply, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        String link = this_apply.getItem(i11).getLink();
        if (link != null) {
            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", link).withString(WebConstants.PAGE_FROM, "game_center").navigation();
        }
        pr.a.f74040a.h(this_apply.getItem(i11), i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.GAME_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_game_list;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        List<AhaGameAllGames> gameList;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TnTextView tnTextView = (TnTextView) helper.getViewOrNull(R$id.tv_game_title);
        if (tnTextView != null) {
            tnTextView.setTextById(R$string.must_play_games);
        }
        TnTextView tnTextView2 = (TnTextView) helper.getViewOrNull(R$id.tv_game_center);
        if (tnTextView2 != null) {
            tnTextView2.setTextById(com.tn.lib.widget.R$string.game_center);
            tnTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.x(view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) helper.getViewOrNull(R$id.game_list);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new ro.b(f0.a(4.0f), f0.a(4.0f), 0, 0));
            }
            List<AhaGameAllGames> gameList2 = item.getGameList();
            if (gameList2 == null || gameList2.size() < 4) {
                gameList = item.getGameList();
            } else {
                List<AhaGameAllGames> gameList3 = item.getGameList();
                gameList = gameList3 != null ? gameList3.subList(0, 4) : null;
            }
            if (gameList != null) {
                final com.transsion.home.adapter.trending.adapter.a aVar = new com.transsion.home.adapter.trending.adapter.a(gameList);
                aVar.B0(new f9.d() { // from class: com.transsion.home.adapter.trending.provider.d
                    @Override // f9.d
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                        e.y(aVar, baseQuickAdapter, view, i11);
                    }
                });
                recyclerView.setAdapter(aVar);
            }
        }
    }
}
