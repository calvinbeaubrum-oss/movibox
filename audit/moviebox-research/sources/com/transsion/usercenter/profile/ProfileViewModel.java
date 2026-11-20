package com.transsion.usercenter.profile;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.usercenter.profile.bean.ProfileEntranceInfo;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ProfileViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<ProfileInfo> f59557d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<Pair<Integer, List<DownloadBean>>> f59558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<ProfileEntranceInfo> f59559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h10.b f59560h;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a extends zo.a<ProfileEntranceInfo> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchEntrance: error:");
            sb2.append(str2);
            ProfileViewModel.this.j().q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileEntranceInfo profileEntranceInfo) {
            super.c(profileEntranceInfo);
            ProfileViewModel.this.j().q(profileEntranceInfo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f59562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProfileViewModel f59563b;

        public b(String str, ProfileViewModel profileViewModel) {
            this.f59562a = str;
            this.f59563b = profileViewModel;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002b  */
        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<ProfileInfo>> apply(Throwable it) {
            String string;
            Intrinsics.g(it, "it");
            String str = this.f59562a;
            if (str == null || str.length() == 0) {
                string = ProfileKV.f59540a.a().getString("PROFILE_JSON", null);
                if (string != null && string.length() != 0) {
                    try {
                        ProfileInfo profileInfo = (ProfileInfo) com.blankj.utilcode.util.n.d(string, ProfileInfo.class);
                        BaseDto baseDto = new BaseDto();
                        baseDto.setCode("0");
                        baseDto.setData(profileInfo);
                        return io.reactivex.rxjava3.core.j.p(baseDto);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            } else {
                String str2 = this.f59562a;
                UserInfo userInfoP = this.f59563b.l().P();
                if (Intrinsics.b(str2, userInfoP != null ? userInfoP.getUserId() : null)) {
                    string = ProfileKV.f59540a.a().getString("PROFILE_JSON", null);
                    if (string != null) {
                        ProfileInfo profileInfo2 = (ProfileInfo) com.blankj.utilcode.util.n.d(string, ProfileInfo.class);
                        BaseDto baseDto2 = new BaseDto();
                        baseDto2.setCode("0");
                        baseDto2.setData(profileInfo2);
                        return io.reactivex.rxjava3.core.j.p(baseDto2);
                    }
                }
            }
            return io.reactivex.rxjava3.core.j.i(it);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c<T> implements k10.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f59564a = new c<>();

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto<ProfileInfo> it) {
            Intrinsics.g(it, "it");
            ProfileInfo data = it.getData();
            if (data != null) {
                ProfileKV.f59540a.a().putString("PROFILE_JSON", com.blankj.utilcode.util.n.j(data));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class d extends zo.a<ProfileInfo> {
        public d() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            ProfileViewModel.this.f59557d.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileInfo profileInfo) {
            super.c(profileInfo);
            ProfileViewModel.this.f59557d.q(profileInfo);
        }

        @Override // zo.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            super.onSubscribe(d11);
            ProfileViewModel.this.f59560h = d11;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59555b = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.profile.ProfileViewModel$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f59556c = LazyKt__LazyJVMKt.b(new Function0<com.transsion.usercenter.profile.b>() { // from class: com.transsion.usercenter.profile.ProfileViewModel$mProfileApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) NetServiceGenerator.f49399d.a().i(b.class);
            }
        });
        this.f59557d = new c0<>();
        this.f59558f = new c0<>();
        this.f59559g = new c0<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi l() {
        Object value = this.f59555b.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    private final com.transsion.usercenter.profile.b m() {
        return (com.transsion.usercenter.profile.b) this.f59556c.getValue();
    }

    public final void g() {
        com.transsion.usercenter.profile.b.a.g(m(), null, 1, null).r(q10.a.b()).e(zo.d.f82109a.c()).subscribe(new a());
    }

    public final void h() {
        kotlinx.coroutines.j.d(u0.a(this), null, null, new ProfileViewModel$fetchLatestDownloadList$1(this, null), 3, null);
    }

    public final void i(String str) {
        h10.b bVar;
        h10.b bVar2 = this.f59560h;
        if (bVar2 != null && !bVar2.isDisposed() && (bVar = this.f59560h) != null) {
            bVar.dispose();
        }
        com.transsion.usercenter.profile.b.a.h(m(), str == null ? "" : str, null, 2, null).r(q10.a.b()).t(new b(str, this)).g(c.f59564a).e(zo.d.f82109a.c()).subscribe(new d());
    }

    public final c0<ProfileEntranceInfo> j() {
        return this.f59559g;
    }

    public final LiveData<Pair<Integer, List<DownloadBean>>> k() {
        return this.f59558f;
    }

    public final LiveData<ProfileInfo> n() {
        return this.f59557d;
    }
}
