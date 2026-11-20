package com.transsion.postdetail.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.mediasession.c;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.impl.PostDetailApiImpl;
import com.transsion.postdetail.ui.adapter.provider.i;
import com.transsion.postdetail.ui.adapter.provider.o;
import com.transsion.postdetail.ui.fragment.RoomPostExploreFragment;
import com.transsion.postdetail.ui.fragment.RoomPostNearbyFragment;
import com.transsion.postdetail.ui.fragment.RoomPostNewestFragment;
import com.transsion.postdetail.ui.fragment.RoomPostPopularFragment;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.videofloat.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/post/detailapi")
@Metadata
public final class PostDetailApiImpl implements IPostDetailApi {
    public static final void A1() {
        c.f54613a.p();
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public Fragment E(String str) {
        return RoomPostNewestFragment.F.a(str);
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public Fragment P0(String str, String str2) {
        return RoomPostExploreFragment.I.a(str, str2);
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public Fragment X0(String str) {
        return RoomPostPopularFragment.F.a(str);
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public BaseItemProvider<PostSubjectItem> d0(String str, String str2, RecyclerView.s pool) {
        Intrinsics.g(pool, "pool");
        return new o(str, str2, pool);
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public void f0(PostSubjectItem data) {
        Intrinsics.g(data, "data");
        ImmVideoHelper.f55024g.a().o(data);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public void l1(String tag) {
        Intrinsics.g(tag, "tag");
        a aVar = a.f60027a;
        if (aVar.b(tag)) {
            b.a.f(b.f78622a, "VideoFloat", "资源被删除，移除pip,tag:" + tag, false, 4, null);
            aVar.a();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: vv.a
                @Override // java.lang.Runnable
                public final void run() {
                    PostDetailApiImpl.A1();
                }
            }, 1500L);
        }
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public Fragment n1() {
        return RoomPostNearbyFragment.P.a();
    }

    @Override // com.transsion.postdetailapi.IPostDetailApi
    public BaseItemProvider<PostSubjectItem> x1(String str, String str2, RecyclerView.s pool) {
        Intrinsics.g(pool, "pool");
        return new i(str, str2, pool);
    }
}
