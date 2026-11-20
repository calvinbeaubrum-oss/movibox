package com.transsion.postdetail.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.LikeBean;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.fragment.preload.VideoDataLoader;
import com.transsion.postdetail.ui.fragment.preload.VideoImmersiveDataLoaderV2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import lu.e;
import xv.b;
import yu.a;

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
public final class PostDetailViewModel extends t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoDataLoader f56276d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoImmersiveDataLoaderV2 f56277f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56273a = "PostDetailViewModel";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56274b = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) NetServiceGenerator.f49399d.a().i(b.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f56275c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<a>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$commonService$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f56278g = LazyKt__LazyJVMKt.b(new Function0<c0<PostSubjectItem>>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$postDetailLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<PostSubjectItem> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f56279h = LazyKt__LazyJVMKt.b(new Function0<c0<String>>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$postDetailCodeData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<String> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f56280i = LazyKt__LazyJVMKt.b(new Function0<c0<PostSubjectBean>>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$immVideoLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<PostSubjectBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f56281j = LazyKt__LazyJVMKt.b(new Function0<c0<LikeBean>>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$likeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<LikeBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f56282k = LazyKt__LazyJVMKt.b(new Function0<c0<String>>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$deleteLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<String> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f56283l = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsion.postdetail.viewmodel.PostDetailViewModel$removeVideoLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Integer> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final b t() {
        return (b) this.f56274b.getValue();
    }

    public final void h(String postId) {
        Intrinsics.g(postId, "postId");
        j.d(u0.a(this), null, null, new PostDetailViewModel$deletePost$1(postId, this, null), 3, null);
    }

    public final a i() {
        return (a) this.f56275c.getValue();
    }

    public final c0<String> j() {
        return (c0) this.f56282k.getValue();
    }

    public final void k(String postId, int i11, String nextPage, int i12, boolean z11, int i13) {
        Intrinsics.g(postId, "postId");
        Intrinsics.g(nextPage, "nextPage");
        if (!z11) {
            j.d(u0.a(this), null, null, new PostDetailViewModel$getImmVideoList$1(this, postId, null), 3, null);
            return;
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = this.f56277f;
        if (videoImmersiveDataLoaderV2 != null) {
            videoImmersiveDataLoaderV2.r(postId);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV3 = this.f56277f;
        if (videoImmersiveDataLoaderV3 != null) {
            videoImmersiveDataLoaderV3.p(nextPage);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV4 = this.f56277f;
        if (videoImmersiveDataLoaderV4 != null) {
            videoImmersiveDataLoaderV4.q(i12);
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV5 = this.f56277f;
        if (videoImmersiveDataLoaderV5 != null) {
            videoImmersiveDataLoaderV5.f(m());
        }
    }

    public final LiveData<PostSubjectBean> l() {
        return m();
    }

    public final c0<PostSubjectBean> m() {
        return (c0) this.f56280i.getValue();
    }

    public final void n(String postId) {
        Intrinsics.g(postId, "postId");
        if (TextUtils.isEmpty(postId)) {
            return;
        }
        j.d(u0.a(this), null, null, new PostDetailViewModel$getPostDetail$1(this, postId, null), 3, null);
    }

    public final c0<String> o() {
        return (c0) this.f56279h.getValue();
    }

    public final c0<PostSubjectItem> p() {
        return (c0) this.f56278g.getValue();
    }

    public final LiveData<PostSubjectItem> q() {
        return p();
    }

    public final PostSubjectBean r() {
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = this.f56277f;
        if (videoImmersiveDataLoaderV2 != null) {
            return videoImmersiveDataLoaderV2.a();
        }
        return null;
    }

    public final c0<Integer> s() {
        return (c0) this.f56283l.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final void u(Integer num) {
        lu.b bVar;
        Object next;
        ?? r11 = 0;
        Object obj = null;
        List<lu.b<?>> listA = num != null ? e.f70544a.a(num.intValue()) : null;
        if (listA != null) {
            Iterator it = listA.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((lu.b) next) instanceof VideoDataLoader));
            bVar = (lu.b) next;
        } else {
            bVar = null;
        }
        VideoDataLoader videoDataLoader = (VideoDataLoader) bVar;
        if (videoDataLoader == null) {
            videoDataLoader = new VideoDataLoader(r11, 1, r11);
        }
        this.f56276d = videoDataLoader;
        if (listA != null) {
            for (Object obj2 : listA) {
                if (((lu.b) obj2) instanceof VideoImmersiveDataLoaderV2) {
                    obj = obj2;
                    break;
                }
            }
            r11 = (lu.b) obj;
        }
        VideoImmersiveDataLoaderV2 videoImmersiveDataLoaderV2 = (VideoImmersiveDataLoaderV2) r11;
        if (videoImmersiveDataLoaderV2 == null) {
            videoImmersiveDataLoaderV2 = new VideoImmersiveDataLoaderV2(null, null, 0, 7, null);
        }
        this.f56277f = videoImmersiveDataLoaderV2;
    }

    public void v(String str, int i11) {
        j.d(u0.a(this), null, null, new PostDetailViewModel$like$1(str, i11, this, null), 3, null);
    }
}
