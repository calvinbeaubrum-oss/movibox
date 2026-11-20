package com.transsion.postdetail.ui.adapter;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.adapter.provider.k;
import com.transsion.postdetail.ui.adapter.provider.l;
import com.transsion.postdetail.ui.adapter.provider.m;
import com.transsion.postdetail.ui.adapter.provider.n;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.RoomsViewType;
import h9.i;
import h9.j;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class d extends BaseProviderMultiAdapter<PostSubjectItem> implements j {
    public final zr.b I;
    public final RecyclerView.s J;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55569a;

        static {
            int[] iArr = new int[PostAdapterFrom.values().length];
            try {
                iArr[PostAdapterFrom.EXPLORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostAdapterFrom.NEARBY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostAdapterFrom.DETAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f55569a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, PostAdapterFrom adapterFrom, zr.b bVar, String str, String str2) {
        super(null, 1, null);
        Intrinsics.g(context, "context");
        Intrinsics.g(adapterFrom, "adapterFrom");
        this.I = bVar;
        RecyclerView.s sVar = new RecyclerView.s();
        this.J = sVar;
        int i11 = a.f55569a[adapterFrom.ordinal()];
        if (i11 == 1) {
            K0(new l(str, str2, sVar));
        } else if (i11 == 2) {
            K0(new m(str, str2, sVar));
        } else if (i11 == 3) {
            K0(new k(str, str2, sVar));
        }
        if (adapterFrom == PostAdapterFrom.NEARBY) {
            K0(new n(((IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class)).O0(context, RoomsViewType.TYPE_ROOM_HOME)));
        }
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends PostSubjectItem> data, int i11) {
        Intrinsics.g(data, "data");
        PostSubjectItem postSubjectItem = data.get(i11);
        if (postSubjectItem.getNonAdDelegate() != null) {
            return MediaType.POST_DETAIL_FOR_YOU_NATIVE_AD.ordinal();
        }
        return postSubjectItem.isRoomList() ? MediaType.ROOM_LIST.ordinal() : MediaType.CONTENT_ALL.ordinal();
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter, com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int adapterPosition = holder.getAdapterPosition();
        zr.b bVar = this.I;
        if (bVar != null) {
            RecyclerView.m layoutManager = W().getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            zr.b.j(bVar, (LinearLayoutManager) layoutManager, adapterPosition, true, false, 8, null);
        }
    }
}
