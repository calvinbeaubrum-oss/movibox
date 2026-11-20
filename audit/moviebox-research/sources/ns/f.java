package ns;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.bean.GameLayoutType;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
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
public final class f extends BaseItemProvider<AhaGameAllGames> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ms.a f72149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f72150g;

    public f(ms.a gameDotHelper) {
        Intrinsics.g(gameDotHelper, "gameDotHelper");
        this.f72149f = gameDotHelper;
        this.f72150g = GameLayoutType.PEOPLE_PLAYING.ordinal();
    }

    public static final void w(d this_apply, f this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        String link = this_apply.getItem(i11).getLink();
        if (link != null) {
            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", link).withString(WebConstants.PAGE_FROM, "game_center").navigation();
        }
        this$0.f72149f.b(this_apply.getItem(i11), i11, GameLayoutType.PEOPLE_PLAYING);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return this.f72150g;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_people_playing;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, AhaGameAllGames item) {
        RecyclerView recyclerView;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        List<AhaGameAllGames> peoplePlaying = item.getPeoplePlaying();
        if (peoplePlaying == null || (recyclerView = (RecyclerView) helper.getViewOrNull(R$id.people_playing_recycler_view)) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        if (recyclerView.getItemDecorationCount() <= 0) {
            recyclerView.addItemDecoration(new ro.b(f0.a(4.0f), f0.a(4.0f), 0, 0));
        }
        if (peoplePlaying.size() >= 4) {
            peoplePlaying = peoplePlaying.subList(0, 4);
        }
        final d dVar = new d(peoplePlaying);
        dVar.B0(new f9.d() { // from class: ns.e
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                f.w(dVar, this, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.setAdapter(dVar);
    }
}
