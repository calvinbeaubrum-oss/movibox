package com.transsion.usercenter.profile;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.p005enum.PostListSource;
import com.transsion.moviedetailapi.p005enum.ProfileSubSource;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class ProfileSubjectListViewModel extends AbsSubjectListViewModel {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f59546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f59547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f59548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f59549o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f59550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f59551q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements k10.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f59553b;

        public a(String str) {
            this.f59553b = str;
        }

        public final io.reactivex.rxjava3.core.m<? extends BaseDto<PostSubjectBean>> a(int i11) {
            if (ProfileSubjectListViewModel.this.f59546l == 0) {
                return ProfileSubjectListViewModel.this.N() ? com.transsion.usercenter.profile.b.a.d(ProfileSubjectListViewModel.this.M(), this.f59553b, ProfileSubjectListViewModel.this.f59551q, ProfileSubjectListViewModel.this.L(), null, null, 24, null) : com.transsion.usercenter.profile.b.a.f(ProfileSubjectListViewModel.this.M(), this.f59553b, ProfileSubjectListViewModel.this.f59551q, ProfileSubjectListViewModel.this.L(), null, null, 24, null);
            }
            return com.transsion.usercenter.profile.b.a.b(ProfileSubjectListViewModel.this.M(), this.f59553b, ProfileSubjectListViewModel.this.f59551q, ProfileSubjectListViewModel.this.L(), null, 8, null);
        }

        @Override // k10.h
        public /* bridge */ /* synthetic */ Object apply(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<PostSubjectBean> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            ProfileSubjectListViewModel.this.p().q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(PostSubjectBean postSubjectBean) {
            String nextPage;
            Integer perPage;
            super.c(postSubjectBean);
            if (postSubjectBean != null) {
                ProfileSubjectListViewModel profileSubjectListViewModel = ProfileSubjectListViewModel.this;
                try {
                    Pager pager = postSubjectBean.getPager();
                    profileSubjectListViewModel.Q((pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue());
                    Pager pager2 = postSubjectBean.getPager();
                    if (pager2 == null || (nextPage = pager2.getNextPage()) == null) {
                        nextPage = "";
                    }
                    profileSubjectListViewModel.f59551q = nextPage;
                } catch (Exception unused) {
                }
            }
            ProfileSubjectListViewModel.this.p().q(postSubjectBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSubjectListViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59548n = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.profile.ProfileSubjectListViewModel$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f59549o = LazyKt__LazyJVMKt.b(new Function0<com.transsion.usercenter.profile.b>() { // from class: com.transsion.usercenter.profile.ProfileSubjectListViewModel$mProfileApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) NetServiceGenerator.f49399d.a().i(b.class);
            }
        });
        this.f59550p = 10;
        this.f59551q = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b M() {
        return (com.transsion.usercenter.profile.b) this.f59549o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(String str) {
        kotlinx.coroutines.j.d(u0.a(this), null, null, new ProfileSubjectListViewModel$loadNewSubject$1(this, str, null), 3, null);
    }

    public final ILoginApi K() {
        Object value = this.f59548n.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    public int L() {
        return this.f59550p;
    }

    public final boolean N() {
        String str = this.f59547m;
        if (str != null && str.length() != 0) {
            String str2 = this.f59547m;
            UserInfo userInfoP = K().P();
            if (!Intrinsics.b(str2, userInfoP != null ? userInfoP.getUserId() : null)) {
                return false;
            }
        }
        return true;
    }

    public final boolean O() {
        String userId = this.f59547m;
        if (userId == null) {
            UserInfo userInfoP = K().P();
            userId = userInfoP != null ? userInfoP.getUserId() : null;
            if (userId == null) {
                userId = "";
            }
        }
        if (userId.length() != 0) {
            UserInfo userInfoP2 = K().P();
            if (!Intrinsics.b(userId, userInfoP2 != null ? userInfoP2.getUserId() : null) || K().N()) {
                return false;
            }
        }
        return true;
    }

    public void Q(int i11) {
        this.f59550p = i11;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String n(int i11) {
        return this.f59546l == 0 ? "profiledetail_posts" : "profiledetail_likes";
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource r() {
        return PostListSource.PROFILE;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public ProfileSubSource s() {
        return this.f59546l == 0 ? ProfileSubSource.POSTS : ProfileSubSource.LIKES;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void u(boolean z11) {
        String userId = this.f59547m;
        if (userId == null) {
            UserInfo userInfoP = K().P();
            userId = userInfoP != null ? userInfoP.getUserId() : null;
            if (userId == null) {
                userId = "";
            }
        }
        if (O() && this.f59546l == 0) {
            p().q(null);
        } else {
            io.reactivex.rxjava3.core.j.p(Integer.valueOf(this.f59546l)).k(new a(userId)).e(zo.d.f82109a.c()).subscribe(new b());
        }
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void v(Bundle bundle) {
        this.f59546l = bundle != null ? bundle.getInt("source") : 0;
        this.f59547m = bundle != null ? bundle.getString("userId") : null;
        if (this.f59546l == 0 && N() && !O()) {
            kotlinx.coroutines.j.d(u0.a(this), null, null, new ProfileSubjectListViewModel$onCreate$$inlined$observeEvent$1(false, new Function1<PublishEvent, Unit>() { // from class: com.transsion.usercenter.profile.ProfileSubjectListViewModel$onCreate$1
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
                    this.this$0.P(it.getPostId());
                }
            }, null), 3, null);
        }
        this.f59551q = "0";
    }
}
