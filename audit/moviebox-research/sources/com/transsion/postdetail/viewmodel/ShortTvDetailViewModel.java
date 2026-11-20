package com.transsion.postdetail.viewmodel;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.report.o;
import com.transsion.moviedetailapi.bean.LikeBean;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.postdetail.ui.fragment.preload.ShortTvVideoImmersiveDataLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
public final class ShortTvDetailViewModel extends t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ShortTvVideoImmersiveDataLoader f56320d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56317a = "ShortTvDetailViewModel";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56318b = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.postdetail.viewmodel.ShortTvDetailViewModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) NetServiceGenerator.f49399d.a().i(b.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f56319c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<a>() { // from class: com.transsion.postdetail.viewmodel.ShortTvDetailViewModel$commonService$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f56321f = LazyKt__LazyJVMKt.b(new Function0<c0<ShortTVRespData>>() { // from class: com.transsion.postdetail.viewmodel.ShortTvDetailViewModel$immVideoLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<ShortTVRespData> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f56322g = LazyKt__LazyJVMKt.b(new Function0<c0<LikeBean>>() { // from class: com.transsion.postdetail.viewmodel.ShortTvDetailViewModel$likeLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<LikeBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f56323h = LazyKt__LazyJVMKt.b(new Function0<c0<String>>() { // from class: com.transsion.postdetail.viewmodel.ShortTvDetailViewModel$deleteLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<String> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f56324i = LazyKt__LazyJVMKt.b(new Function0<c0<Integer>>() { // from class: com.transsion.postdetail.viewmodel.ShortTvDetailViewModel$removeVideoLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<Integer> invoke() {
            return new c0<>();
        }
    });

    private final c0<ShortTVRespData> e() {
        return (c0) this.f56321f.getValue();
    }

    public final c0<String> b() {
        return (c0) this.f56323h.getValue();
    }

    public final void c(String postId, int i11, String nextPage, int i12, int i13) {
        String string;
        Intrinsics.g(postId, "postId");
        Intrinsics.g(nextPage, "nextPage");
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(nextPage);
        immVideoRequestEntity.setPerPage(i12);
        immVideoRequestEntity.setSessionId(fp.b.f65208a.h());
        Uri uriA = o.f51281a.a();
        if (uriA == null || (string = uriA.toString()) == null) {
            string = "";
        }
        immVideoRequestEntity.setDeepLink(string);
        immVideoRequestEntity.setUserPrefer("");
        immVideoRequestEntity.setLatest_events(new ds.a(ds.b.f63534a.e()));
        if (postId.length() == 0) {
            postId = "0";
        }
        immVideoRequestEntity.setPostId(postId);
        immVideoRequestEntity.setTabId(i11);
        immVideoRequestEntity.setImmersiveRecType(i13);
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.f56320d;
        if (shortTvVideoImmersiveDataLoader != null) {
            shortTvVideoImmersiveDataLoader.p(immVideoRequestEntity);
        }
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader2 = this.f56320d;
        if (shortTvVideoImmersiveDataLoader2 != null) {
            shortTvVideoImmersiveDataLoader2.f(e());
        }
    }

    public final LiveData<ShortTVRespData> d() {
        return e();
    }

    public final ShortTVRespData f() {
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = this.f56320d;
        if (shortTvVideoImmersiveDataLoader != null) {
            return shortTvVideoImmersiveDataLoader.a();
        }
        return null;
    }

    public final c0<Integer> g() {
        return (c0) this.f56324i.getValue();
    }

    public final void h(Integer num) {
        List<lu.b<?>> listA;
        lu.b bVar;
        Object next;
        if (num != null) {
            listA = e.f70544a.a(num.intValue());
        } else {
            listA = null;
        }
        if (listA != null) {
            Iterator<T> it = listA.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((lu.b) next) instanceof ShortTvVideoImmersiveDataLoader));
            bVar = (lu.b) next;
        } else {
            bVar = null;
        }
        ShortTvVideoImmersiveDataLoader shortTvVideoImmersiveDataLoader = (ShortTvVideoImmersiveDataLoader) bVar;
        if (shortTvVideoImmersiveDataLoader == null) {
            shortTvVideoImmersiveDataLoader = new ShortTvVideoImmersiveDataLoader(null, 1, null);
        }
        this.f56320d = shortTvVideoImmersiveDataLoader;
    }
}
