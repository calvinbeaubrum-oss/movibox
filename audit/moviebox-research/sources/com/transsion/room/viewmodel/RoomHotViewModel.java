package com.transsion.room.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.p005enum.PostListSource;
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
import uw.a;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class RoomHotViewModel extends AbsSubjectListViewModel {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f57327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f57328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f57329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f57330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f57331p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomHotViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f57327l = 10;
        this.f57328m = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<a>() { // from class: com.transsion.room.viewmodel.RoomHotViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) NetServiceGenerator.f49399d.a().i(a.class);
            }
        });
        this.f57330o = "0";
        this.f57331p = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.room.viewmodel.RoomHotViewModel$mProfileApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) NetServiceGenerator.f49399d.a().i(b.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b J() {
        return (b) this.f57331p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(String str) {
        j.d(u0.a(this), null, null, new RoomHotViewModel$loadNewSubject$1(this, str, null), 3, null);
    }

    public int I() {
        return this.f57327l;
    }

    public final void K(String str, String page, int i11, String sortType, boolean z11) {
        Intrinsics.g(page, "page");
        Intrinsics.g(sortType, "sortType");
        j.d(u0.a(this), null, null, new RoomHotViewModel$getPostSubject$1(this, str, page, i11, sortType, z11, null), 3, null);
    }

    public final a L() {
        return (a) this.f57328m.getValue();
    }

    public void N(int i11) {
        this.f57327l = i11;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String n(int i11) {
        return i11 == PostRankType.POST_RANK_TYPE_NEW.ordinal() ? "roomdetail_new" : "roomdetail_hot";
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource r() {
        return PostListSource.ROOM;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void u(boolean z11) {
        K(this.f57329n, this.f57330o, I(), k().getValue(), z11);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void v(Bundle bundle) {
        if (bundle != null) {
            this.f57329n = bundle.getString("subject_id");
            Serializable serializable = bundle.getSerializable("rank_type");
            Intrinsics.e(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.PostRankType");
            A((PostRankType) serializable);
        }
        j.d(u0.a(this), null, null, new RoomHotViewModel$onCreate$$inlined$observeEvent$1(false, new Function1<PublishEvent, Unit>() { // from class: com.transsion.room.viewmodel.RoomHotViewModel$onCreate$2
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
                this.this$0.M(it.getPostId());
            }
        }, null), 3, null);
    }
}
