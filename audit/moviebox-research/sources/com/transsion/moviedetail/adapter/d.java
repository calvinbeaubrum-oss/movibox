package com.transsion.moviedetail.adapter;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.adapter.provider.SubjectDetailRoomsProvider;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.p005enum.PostListSource;
import com.transsion.moviedetailapi.p005enum.ProfileSubSource;
import com.transsion.postdetailapi.IPostDetailApi;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class d extends BaseProviderMultiAdapter<PostSubjectItem> implements j {
    public final AbsSubjectListViewModel I;
    public final String J;
    public final RecyclerView.s K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<PostSubjectItem> postSubjectList, AbsSubjectListViewModel absSubjectListViewModel, String str, String str2) {
        ProfileSubSource profileSubSourceS;
        super(CollectionsKt___CollectionsKt.M0(postSubjectList));
        Intrinsics.g(postSubjectList, "postSubjectList");
        this.I = absSubjectListViewModel;
        this.J = str;
        RecyclerView.s sVar = new RecyclerView.s();
        this.K = sVar;
        String value = null;
        K0((absSubjectListViewModel != null ? absSubjectListViewModel.r() : null) == PostListSource.PROFILE ? ((IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class)).x1(str, str2, sVar) : ((IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class)).d0(str, str2, sVar));
        K0(new com.transsion.moviedetail.adapter.provider.b());
        if (absSubjectListViewModel != null && (profileSubSourceS = absSubjectListViewModel.s()) != null) {
            value = profileSubSourceS.getValue();
        }
        K0(new SubjectDetailRoomsProvider(str, value));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends PostSubjectItem> data, int i11) {
        Intrinsics.g(data, "data");
        if (data.get(i11).isRoomList()) {
            return MediaType.ROOM_LIST.ordinal();
        }
        return data.get(i11).getNonAdDelegate() != null ? MediaType.SUBJECT_DETAIL_NATIVE_AD.ordinal() : MediaType.CONTENT_ALL.ordinal();
    }

    public final void V0() {
        D().clear();
        notifyDataSetChanged();
    }

    public final AbsSubjectListViewModel W0() {
        return this.I;
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d0 */
    public void onBindViewHolder(BaseViewHolder holder, int i11) {
        Intrinsics.g(holder, "holder");
        super.onBindViewHolder(holder, i11);
        if (((LinearLayoutCompat) holder.itemView.findViewById(R$id.root)) != null) {
            AbsSubjectListViewModel absSubjectListViewModel = this.I;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.w(D().get(i11), i11);
            }
            if (i11 != 0) {
                getItemCount();
            }
        }
    }
}
