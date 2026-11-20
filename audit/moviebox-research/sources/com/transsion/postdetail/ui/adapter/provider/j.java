package com.transsion.postdetail.ui.adapter.provider;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.view.PostBaseItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public abstract class j<T extends PostBaseItemView> extends BaseItemProvider<PostSubjectItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f55588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f55589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RecyclerView.s f55590h;

    public j(String str, String str2, RecyclerView.s pool) {
        Intrinsics.g(pool, "pool");
        this.f55588f = str;
        this.f55589g = str2;
        this.f55590h = pool;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return MediaType.CONTENT_ALL.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, PostSubjectItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        View view = helper.itemView;
        PostBaseItemView postBaseItemView = view instanceof PostBaseItemView ? (PostBaseItemView) view : null;
        if (postBaseItemView != null) {
            postBaseItemView.setPage(this.f55588f, this.f55589g);
            postBaseItemView.setData(item);
            postBaseItemView.setRecycledViewPool(this.f55590h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, PostSubjectItem item, List<? extends Object> payloads) {
        List<T> listD;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.b(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object objR0 = CollectionsKt___CollectionsKt.r0(payloads);
        if (objR0 instanceof Boolean) {
            try {
                Result.Companion companion = Result.Companion;
                BaseProviderMultiAdapter<T> baseProviderMultiAdapterC = c();
                if (baseProviderMultiAdapterC != null && (listD = baseProviderMultiAdapterC.D()) != null) {
                    int adapterPosition = helper.getAdapterPosition();
                    BaseProviderMultiAdapter<T> baseProviderMultiAdapterC2 = c();
                    PostSubjectItem postSubjectItem = (PostSubjectItem) listD.get(adapterPosition + (baseProviderMultiAdapterC2 != null ? baseProviderMultiAdapterC2.K() : 0));
                    if (postSubjectItem != null) {
                        View view = helper.itemView;
                        w(view instanceof PostBaseItemView ? (PostBaseItemView) view : null, postSubjectItem, ((Boolean) objR0).booleanValue());
                    }
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void w(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, boolean z11) {
        if (postBaseItemView != null) {
            postBaseItemView.refreshLike(z11, postSubjectItem);
        }
    }
}
