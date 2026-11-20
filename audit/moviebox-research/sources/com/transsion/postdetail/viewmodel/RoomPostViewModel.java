package com.transsion.postdetail.viewmodel;

import android.content.Context;
import android.location.Address;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomBean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import xv.c;
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
public final class RoomPostViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f56293a = LazyKt__LazyJVMKt.b(new Function0<c>() { // from class: com.transsion.postdetail.viewmodel.RoomPostViewModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final c invoke() {
            return (c) NetServiceGenerator.f49399d.a().i(c.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f56294b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<a>() { // from class: com.transsion.postdetail.viewmodel.RoomPostViewModel$commonService$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f56295c = LazyKt__LazyJVMKt.b(new Function0<RoomBuiltInHelper>() { // from class: com.transsion.postdetail.viewmodel.RoomPostViewModel$builtInHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RoomBuiltInHelper invoke() {
            return new RoomBuiltInHelper();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<PostSubjectBean> f56296d = new c0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<PostSubjectBean> f56297f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<PostSubjectBean> f56298g = new c0<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<PostSubjectBean> f56299h = new c0<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<BaseDto<String>> f56300i = new c0<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<RoomBean> f56301j = new c0<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0<PostSubjectItem> f56302k = new c0<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final a m() {
        return (a) this.f56294b.getValue();
    }

    public final void k(String str) {
        j.d(u0.a(this), null, null, new RoomPostViewModel$deletePost$1(str, this, null), 3, null);
    }

    public final RoomBuiltInHelper l() {
        return (RoomBuiltInHelper) this.f56295c.getValue();
    }

    public final c0<BaseDto<String>> n() {
        return this.f56300i;
    }

    public final c0<PostSubjectBean> o() {
        return this.f56296d;
    }

    public final c0<PostSubjectBean> p() {
        return this.f56297f;
    }

    public final c0<PostSubjectBean> q() {
        return this.f56299h;
    }

    public final c0<PostSubjectBean> r() {
        return this.f56298g;
    }

    public final void s(Context context, boolean z11, String str, int i11, String str2) {
        Intrinsics.g(context, "context");
        j.d(u0.a(this), null, null, new RoomPostViewModel$getPostExplore$1(this, context, str, i11, str2, z11, null), 3, null);
    }

    public final void t(boolean z11, String str, int i11, double d11, double d12) {
        j.d(u0.a(this), w0.b(), null, new RoomPostViewModel$getPostNearby$1(this, str, i11, d12, d11, z11, null), 2, null);
    }

    public final void u(boolean z11, String str, String str2, int i11, String sortType, boolean z12) {
        Intrinsics.g(sortType, "sortType");
        j.d(u0.a(this), null, null, new RoomPostViewModel$getPostNewest$1(this, str, str2, i11, sortType, z12, z11, null), 3, null);
    }

    public final void v(boolean z11, String groupId, String str, int i11, boolean z12) {
        Intrinsics.g(groupId, "groupId");
        j.d(u0.a(this), null, null, new RoomPostViewModel$getPostPopular$1(this, groupId, str, i11, z12, z11, null), 3, null);
    }

    public final void w(double d11, double d12, Address address) {
        j.d(u0.a(this), null, null, new RoomPostViewModel$getRecommendRooms$1(this, d11, d12, address, null), 3, null);
    }

    public final c0<RoomBean> x() {
        return this.f56301j;
    }

    public final c y() {
        return (c) this.f56293a.getValue();
    }

    public final void z(String str, int i11) {
        j.d(u0.a(this), null, null, new RoomPostViewModel$like$1(str, i11, this, null), 3, null);
    }
}
