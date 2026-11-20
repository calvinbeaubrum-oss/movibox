package com.transsion.room.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.room.bean.CheckNameBean;
import com.transsion.room.bean.CreateRoomRequestEntity;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class RoomCreateModel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f57308d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f57309a = LazyKt__LazyJVMKt.b(new Function0<c0<RoomNet>>() { // from class: com.transsion.room.viewmodel.RoomCreateModel$roomCreateLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<RoomNet> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57310b = LazyKt__LazyJVMKt.b(new Function0<c0<CheckNameBean>>() { // from class: com.transsion.room.viewmodel.RoomCreateModel$checkNameLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<CheckNameBean> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f57311c = LazyKt__LazyJVMKt.b(new Function0<uw.a>() { // from class: com.transsion.room.viewmodel.RoomCreateModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
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
    public static final class b extends zo.a<CheckNameBean> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            RoomCreateModel.this.d().q(null);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(CheckNameBean checkNameBean) {
            RoomCreateModel.this.d().q(checkNameBean);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onSuccess groupId.." + (checkNameBean != null ? checkNameBean.getGroupId() : null), false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<RoomNet> {
        public c() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            RoomCreateModel.this.g().q(null);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            RoomCreateModel.this.g().q(roomNet);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends zo.a<RoomNet> {
        public d() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            RoomCreateModel.this.g().q(null);
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            RoomCreateModel.this.g().q(new RoomNet("update"));
            uo.b.a.f(uo.b.f78622a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    public final void b(String name) {
        Intrinsics.g(name, "name");
        h().d(cp.a.f62775a.a(), name).e(zo.d.f82109a.c()).subscribe(new b());
    }

    public final void c(String name, String avator, String desc, String str) {
        Intrinsics.g(name, "name");
        Intrinsics.g(avator, "avator");
        Intrinsics.g(desc, "desc");
        CreateRoomRequestEntity createRoomRequestEntity = new CreateRoomRequestEntity("", name, avator, desc, str);
        uw.a aVarH = h();
        String strA = cp.a.f62775a.a();
        String strJ = n.j(createRoomRequestEntity);
        Intrinsics.f(strJ, "toJson(requestEntity)");
        aVarH.f(strA, e(strJ)).e(zo.d.f82109a.c()).subscribe(new c());
    }

    public final c0<CheckNameBean> d() {
        return (c0) this.f57310b.getValue();
    }

    public final RequestBody e(String str) {
        return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
    }

    public final LiveData<RoomNet> f() {
        return g();
    }

    public final c0<RoomNet> g() {
        return (c0) this.f57309a.getValue();
    }

    public final uw.a h() {
        return (uw.a) this.f57311c.getValue();
    }

    public final void i(String groupId, String name, String avator, String desc, String str) {
        Intrinsics.g(groupId, "groupId");
        Intrinsics.g(name, "name");
        Intrinsics.g(avator, "avator");
        Intrinsics.g(desc, "desc");
        CreateRoomRequestEntity createRoomRequestEntity = new CreateRoomRequestEntity(groupId, name, avator, desc, str);
        uw.a aVarH = h();
        String strA = cp.a.f62775a.a();
        String strJ = n.j(createRoomRequestEntity);
        Intrinsics.f(strJ, "toJson(requestEntity)");
        aVarH.b(strA, e(strJ)).e(zo.d.f82109a.c()).subscribe(new d());
    }
}
