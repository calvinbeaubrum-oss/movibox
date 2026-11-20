package com.transsion.room.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.room.R$string;
import com.transsion.room.bean.CheckInEntity;
import com.transsnet.flow.event.sync.SyncManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import uw.a;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RoomDetailViewModel extends t0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f57315g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f57316a = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<uw.a>() { // from class: com.transsion.room.viewmodel.RoomDetailViewModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57317b = LazyKt__LazyJVMKt.b(new Function0<yr.a>() { // from class: com.transsion.room.viewmodel.RoomDetailViewModel$roomDao$2
        @Override // kotlin.jvm.functions.Function0
        public final yr.a invoke() {
            Application applicationA = Utils.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).J0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f57318c = LazyKt__LazyJVMKt.b(new Function0<c0<RoomItem>>() { // from class: com.transsion.room.viewmodel.RoomDetailViewModel$roomDetailLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<RoomItem> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f57319d = LazyKt__LazyJVMKt.b(new Function0<c0<RoomNet>>() { // from class: com.transsion.room.viewmodel.RoomDetailViewModel$roomCheckInLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<RoomNet> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f57320f = LazyKt__LazyJVMKt.b(new Function0<c0<RoomNet>>() { // from class: com.transsion.room.viewmodel.RoomDetailViewModel$roomCheckOutLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<RoomNet> invoke() {
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<RoomItem> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            RoomDetailViewModel.this.m().q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomItem roomItem) {
            RoomDetailViewModel.this.m().q(roomItem);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<RoomNet> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f57322d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RoomDetailViewModel f57323f;

        public c(String str, RoomDetailViewModel roomDetailViewModel) {
            this.f57322d = str;
            this.f57323f = roomDetailViewModel;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            this.f57323f.h().q(null);
            zp.b.f82110a.d(R$string.join_room_fail);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            zp.b.f82110a.d(R$string.join_room_success);
            SyncManager.f61414a.a().d(1, this.f57322d);
            this.f57323f.h().q(new RoomNet("success"));
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends zo.a<RoomNet> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f57324d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RoomDetailViewModel f57325f;

        public d(String str, RoomDetailViewModel roomDetailViewModel) {
            this.f57324d = str;
            this.f57325f = roomDetailViewModel;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            this.f57325f.i().q(null);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "checkOutRoom onFailure message.." + str2, false, 4, null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            SyncManager.f61414a.a().d(0, this.f57324d);
            this.f57325f.i().q(new RoomNet("success"));
            uo.b.a.f(uo.b.f78622a, "RoomModel", "checkOutRoom onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final uw.a p() {
        return (uw.a) this.f57316a.getValue();
    }

    public final RequestBody g(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    public final c0<RoomNet> h() {
        return (c0) this.f57319d.getValue();
    }

    public final c0<RoomNet> i() {
        return (c0) this.f57320f.getValue();
    }

    public final yr.a j() {
        return (yr.a) this.f57317b.getValue();
    }

    public final void k(String groupId) {
        Intrinsics.g(groupId, "groupId");
        uw.a.C0870a.b(p(), cp.a.f62775a.a(), groupId, 0, 4, null).e(zo.d.f82109a.c()).subscribe(new b());
    }

    public final LiveData<RoomItem> l() {
        return m();
    }

    public final c0<RoomItem> m() {
        return (c0) this.f57318c.getValue();
    }

    public final LiveData<RoomNet> n() {
        return h();
    }

    public final LiveData<RoomNet> o() {
        return i();
    }

    public final void q(RoomItem roomItem) {
        Intrinsics.g(roomItem, "roomItem");
        j.d(u0.a(this), null, null, new RoomDetailViewModel$insertRecentlyRoom$1(roomItem, this, null), 3, null);
    }

    public final void r(String groupId) {
        Intrinsics.g(groupId, "groupId");
        uw.a aVarP = p();
        String strA = cp.a.f62775a.a();
        String strJ = n.j(new CheckInEntity(groupId));
        Intrinsics.f(strJ, "toJson(CheckInEntity(groupId))");
        aVarP.h(strA, g(strJ)).e(zo.d.f82109a.c()).subscribe(new c(groupId, this));
    }

    public final void s(String groupId) {
        Intrinsics.g(groupId, "groupId");
        uw.a aVarP = p();
        String strA = cp.a.f62775a.a();
        String strJ = n.j(new CheckInEntity(groupId));
        Intrinsics.f(strJ, "toJson(CheckInEntity(groupId))");
        aVarP.j(strA, g(strJ)).e(zo.d.f82109a.c()).subscribe(new d(groupId, this));
    }

    public final void t(String groupId) {
        Intrinsics.g(groupId, "groupId");
        j.d(u0.a(this), null, null, new RoomDetailViewModel$roomVisit$1(groupId, this, null), 3, null);
    }
}
