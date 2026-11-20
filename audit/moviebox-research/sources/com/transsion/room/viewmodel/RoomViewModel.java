package com.transsion.room.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomFilterClasses;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import vw.a;
import zo.d;

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
public final class RoomViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f57333l = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f57335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<RoomBean> f57336d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f57337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<RoomBean> f57338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<RoomFilterClasses> f57339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<RoomBean> f57340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<RoomBean> f57341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f57342k;

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
    public static final class b extends zo.a<RoomBean> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            RoomViewModel.this.q().q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomBean roomBean) {
            RoomViewModel.this.q().q(roomBean);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<RoomBean> {
        public c() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            RoomViewModel.this.v().q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomBean roomBean) {
            RoomViewModel.this.v().q(roomBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f57334b = LazyKt__LazyJVMKt.b(new Function0<c0<RoomBean>>() { // from class: com.transsion.room.viewmodel.RoomViewModel$hotRoomListLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<RoomBean> invoke() {
                return new c0<>();
            }
        });
        this.f57335c = LazyKt__LazyJVMKt.b(new Function0<c0<RoomBean>>() { // from class: com.transsion.room.viewmodel.RoomViewModel$personalRoomListLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<RoomBean> invoke() {
                return new c0<>();
            }
        });
        this.f57336d = new c0<>();
        this.f57337f = LazyKt__LazyJVMKt.b(new Function0<vw.a>() { // from class: com.transsion.room.viewmodel.RoomViewModel$builtInHelper$2
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.f57338g = new c0<>();
        this.f57339h = new c0<>();
        this.f57340i = new c0<>();
        this.f57341j = new c0<>();
        this.f57342k = LazyKt__LazyJVMKt.b(new Function0<uw.a>() { // from class: com.transsion.room.viewmodel.RoomViewModel$service$2
            @Override // kotlin.jvm.functions.Function0
            public final uw.a invoke() {
                return (uw.a) NetServiceGenerator.f49399d.a().i(uw.a.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final uw.a A() {
        return (uw.a) this.f57342k.getValue();
    }

    public static /* synthetic */ void m(RoomViewModel roomViewModel, Context context, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            str = "1";
        }
        if ((i12 & 4) != 0) {
            i11 = 16;
        }
        roomViewModel.l(context, str, i11);
    }

    public final vw.a k() {
        return (vw.a) this.f57337f.getValue();
    }

    public final void l(Context context, String page, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(page, "page");
        j.d(u0.a(this), null, null, new RoomViewModel$getCommunityRooms$1(this, context, page, i11, null), 3, null);
    }

    public final c0<RoomBean> n() {
        return this.f57341j;
    }

    public final void o(String page, int i11) {
        Intrinsics.g(page, "page");
        A().e(cp.a.f62775a.a(), page, i11).e(d.f82109a.c()).subscribe(new b());
    }

    public final LiveData<RoomBean> p() {
        return q();
    }

    public final c0<RoomBean> q() {
        return (c0) this.f57334b.getValue();
    }

    public final void r(boolean z11, String str, int i11, String str2) {
        j.d(u0.a(this), null, null, new RoomViewModel$getMyRooms$1(this, str, i11, str2, z11, null), 3, null);
    }

    public final c0<RoomBean> s() {
        return this.f57336d;
    }

    public final void t(String page, int i11, String str) {
        Intrinsics.g(page, "page");
        if (str != null) {
            A().n(cp.a.f62775a.a(), page, i11, str).e(d.f82109a.c()).subscribe(new c());
        }
    }

    public final LiveData<RoomBean> u() {
        return v();
    }

    public final c0<RoomBean> v() {
        return (c0) this.f57335c.getValue();
    }

    public final void w() {
        j.d(u0.a(this), null, null, new RoomViewModel$getRoomFilterTabList$1(this, null), 3, null);
    }

    public final void x(boolean z11, int i11, String page, int i12, Double d11, Double d12, Address address) {
        Intrinsics.g(page, "page");
        j.d(u0.a(this), null, null, new RoomViewModel$getRoomList$1(d12, d11, address, page, i12, i11, this, z11, null), 3, null);
    }

    public final c0<RoomFilterClasses> y() {
        return this.f57339h;
    }

    public final c0<RoomBean> z() {
        return this.f57340i;
    }
}
