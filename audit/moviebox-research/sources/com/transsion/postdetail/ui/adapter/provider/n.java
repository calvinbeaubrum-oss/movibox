package com.transsion.postdetail.ui.adapter.provider;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.s;
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
public final class n extends BaseItemProvider<PostSubjectItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rw.b f55591f;

    public n(rw.b roomsView) {
        Intrinsics.g(roomsView, "roomsView");
        this.f55591f = roomsView;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return MediaType.ROOM_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_provider_room_post_nearby_rs_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, PostSubjectItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        List<RoomItem> roomList = item.getRoomList();
        if (roomList != null) {
            FrameLayout frameLayout = (FrameLayout) helper.getView(R$id.fl_container);
            frameLayout.removeAllViews();
            ViewParent parent = this.f55591f.getView().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.f55591f.getView());
            }
            frameLayout.addView(this.f55591f.getView());
            rw.b bVar = this.f55591f;
            String string = Utils.a().getString(R$string.Nearby_Communities);
            Intrinsics.f(string, "getApp().getString(R.string.Nearby_Communities)");
            bVar.updateTitle(string);
            this.f55591f.setList(roomList);
            com.transsion.baselib.report.m.f51277a.t("room_home", "browse", s.l(TuplesKt.a("module_name", "room_home_recommend")));
            this.f55591f.setReportName("room_home", "room_nearby_recommend");
        }
    }
}
