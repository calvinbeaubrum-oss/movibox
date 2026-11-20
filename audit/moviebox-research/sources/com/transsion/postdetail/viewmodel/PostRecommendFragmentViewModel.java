package com.transsion.postdetail.viewmodel;

import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.report.o;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.postdetail.bean.ForYouBean;
import com.transsion.publish.R$string;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import okhttp3.RequestBody;
import xv.b;

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
public final class PostRecommendFragmentViewModel extends t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f56286d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f56287a = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.postdetail.viewmodel.PostRecommendFragmentViewModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) NetServiceGenerator.f49399d.a().i(b.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<PostSubjectBean> f56288b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f56289c = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<ForYouBean>>>() { // from class: com.transsion.postdetail.viewmodel.PostRecommendFragmentViewModel$forYouLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<BaseDto<ForYouBean>> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b f() {
        return (b) this.f56287a.getValue();
    }

    public final void d(String postId, int i11, int i12, int i13) {
        String string;
        Intrinsics.g(postId, "postId");
        if (TextUtils.isEmpty(postId)) {
            return;
        }
        if (!f.f49475a.e()) {
            zp.b.f82110a.d(R$string.upload_no_network);
            this.f56288b.n(null);
            return;
        }
        ImmVideoRequestEntity immVideoRequestEntity = new ImmVideoRequestEntity();
        immVideoRequestEntity.setPage(String.valueOf(i12));
        immVideoRequestEntity.setPerPage(i13);
        immVideoRequestEntity.setSessionId(fp.b.f65208a.h());
        Uri uriA = o.f51281a.a();
        if (uriA == null || (string = uriA.toString()) == null) {
            string = "";
        }
        immVideoRequestEntity.setDeepLink(string);
        immVideoRequestEntity.setUserPrefer("");
        immVideoRequestEntity.setLatest_events(ds.b.f63534a.e());
        immVideoRequestEntity.setPostId(postId);
        immVideoRequestEntity.setTabId(i11);
        ip.b.a aVar = ip.b.f67591a;
        String strJ = n.j(immVideoRequestEntity);
        Intrinsics.f(strJ, "toJson(requestEntity)");
        RequestBody requestBodyA = aVar.a(strJ);
        if (requestBodyA != null) {
            j.d(u0.a(this), null, null, new PostRecommendFragmentViewModel$getImmVideoList$1$1(this, requestBodyA, null), 3, null);
        }
    }

    public final LiveData<PostSubjectBean> e() {
        return this.f56288b;
    }
}
