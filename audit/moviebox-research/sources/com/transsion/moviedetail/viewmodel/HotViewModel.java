package com.transsion.moviedetail.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.p005enum.PostListSource;
import com.transsion.moviedetailapi.p005enum.ProfileSubSource;
import com.transsion.usercenter.profile.b;
import com.transsnet.flow.event.sync.event.PublishEvent;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import vu.a;

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
public final class HotViewModel extends AbsSubjectListViewModel {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f53840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f53841m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f53842n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f53843o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0<RoomBean> f53844p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f53845q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f53840l = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<a>() { // from class: com.transsion.moviedetail.viewmodel.HotViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) NetServiceGenerator.f49399d.a().i(a.class);
            }
        });
        this.f53842n = "0";
        this.f53844p = new c0<>();
        this.f53845q = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.moviedetail.viewmodel.HotViewModel$mProfileApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) NetServiceGenerator.f49399d.a().i(b.class);
            }
        });
    }

    private final void L(String str, String str2, int i11, String str3, boolean z11) {
        j.d(u0.a(this), null, null, new HotViewModel$getPostSubject$1(this, str, str2, i11, str3, z11, null), 3, null);
    }

    public static /* synthetic */ void N(HotViewModel hotViewModel, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "1";
        }
        if ((i12 & 2) != 0) {
            i11 = 3;
        }
        hotViewModel.M(str, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a P() {
        return (a) this.f53840l.getValue();
    }

    public int J() {
        return this.f53843o;
    }

    public final b K() {
        return (b) this.f53845q.getValue();
    }

    public final void M(String page, int i11) {
        Intrinsics.g(page, "page");
        j.d(u0.a(this), null, null, new HotViewModel$getRecommendRooms$1(this, page, i11, null), 3, null);
    }

    public final c0<RoomBean> O() {
        return this.f53844p;
    }

    public final String Q() {
        return this.f53841m;
    }

    public final void R(String str) {
        j.d(u0.a(this), null, null, new HotViewModel$loadNewSubject$1(this, str, null), 3, null);
    }

    public void S(int i11) {
        this.f53843o = i11;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String n(int i11) {
        return i11 == PostRankType.POST_RANK_TYPE_NEW.ordinal() ? "subjectdetail_new" : "subjectdetail_hot";
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource r() {
        return PostListSource.SUBJECT;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public ProfileSubSource s() {
        return ProfileSubSource.COMMENTS;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void u(boolean z11) {
        L(this.f53841m, this.f53842n, J(), k().getValue(), z11);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void v(Bundle bundle) {
        if (bundle != null) {
            this.f53841m = bundle.getString("subject_id");
            Serializable serializable = bundle.getSerializable("rank_type");
            Intrinsics.e(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.PostRankType");
            A((PostRankType) serializable);
        }
        j.d(u0.a(this), null, null, new HotViewModel$onCreate$$inlined$observeEvent$1(false, new Function1<PublishEvent, Unit>() { // from class: com.transsion.moviedetail.viewmodel.HotViewModel$onCreate$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishEvent publishEvent) {
                invoke2(publishEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishEvent it) {
                Intrinsics.g(it, "it");
                this.this$0.R(it.getPostId());
            }
        }, null), 3, null);
    }
}
