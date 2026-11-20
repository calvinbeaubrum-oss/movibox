package com.transsion.moviedetail.adapter.provider;

import android.widget.FrameLayout;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.p005enum.ProfileSubSource;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.RoomsViewType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class SubjectDetailRoomsProvider extends BaseItemProvider<PostSubjectItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f53450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f53451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f53452h = LazyKt__LazyJVMKt.b(new Function0<rw.b>() { // from class: com.transsion.moviedetail.adapter.provider.SubjectDetailRoomsProvider$roomView$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final rw.b invoke() {
            return ((IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class)).O0(this.this$0.g(), RoomsViewType.TYPE_SUBJECT_DETAIL);
        }
    });

    public SubjectDetailRoomsProvider(String str, String str2) {
        this.f53450f = str;
        this.f53451g = str2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return MediaType.ROOM_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.movie_detail_item_rooms;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, PostSubjectItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        FrameLayout frameLayout = (FrameLayout) helper.getView(R$id.fl_root);
        String str = this.f53450f;
        if (str != null) {
            String value = this.f53451g;
            if (value == null) {
                value = ProfileSubSource.COMMENTS.getValue();
            }
            v().setReportName(str, value);
        }
        List<RoomItem> roomList = item.getRoomList();
        if (roomList != null) {
            v().setList(roomList);
        }
        if (frameLayout.indexOfChild(v().getView()) != -1) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.addView(v().getView());
    }

    public final rw.b v() {
        return (rw.b) this.f53452h.getValue();
    }
}
