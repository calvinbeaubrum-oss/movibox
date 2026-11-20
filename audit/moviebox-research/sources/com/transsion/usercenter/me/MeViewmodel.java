package com.transsion.usercenter.me;

import android.app.Application;
import android.content.res.Resources;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.memberapi.MemberInfo;
import com.transsion.usercenter.R$mipmap;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.net.HostServiceGenerator;
import com.transsion.usercenter.profile.bean.CountInfo;
import com.transsion.usercenter.profile.bean.IconItemInfo;
import com.transsion.usercenter.profile.bean.MeHistoryInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsion.usercenter.profile.bean.MineNovel;
import com.transsion.usercenter.profile.bean.MinePageInfo;
import com.transsion.usercenter.profile.bean.MyGroup;
import com.transsion.usercenter.profile.bean.MySubject;
import com.transsion.usercenter.profile.bean.ZeroConfig;
import com.transsion.usercenter.profile.bean.ZeroInfo;
import com.transsion.usercenter.profile.c;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;

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
public final class MeViewmodel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f59426o = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ZeroInfo> f59429d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ZeroConfig f59430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f59431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f59432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<List<VideoDetailPlayBean>> f59433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile List<VideoDetailPlayBean> f59434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f59435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MinePageInfo f59436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0<List<MeItemInfo>> f59437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q1 f59438n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewmodel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59427b = LazyKt__LazyJVMKt.b(new Function0<com.transsion.usercenter.profile.b>() { // from class: com.transsion.usercenter.me.MeViewmodel$mProfileApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.usercenter.profile.b invoke() {
                return (com.transsion.usercenter.profile.b) NetServiceGenerator.f49399d.a().i(com.transsion.usercenter.profile.b.class);
            }
        });
        this.f59428c = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.me.MeViewmodel$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f59429d = new ArrayList();
        this.f59431g = LazyKt__LazyJVMKt.b(new Function0<c>() { // from class: com.transsion.usercenter.me.MeViewmodel$mZeroApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) HostServiceGenerator.f59489c.a().h(c.class);
            }
        });
        this.f59432h = 10;
        this.f59433i = new c0<>();
        this.f59434j = new ArrayList();
        this.f59435k = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.usercenter.me.MeViewmodel$videoDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        this.f59437m = new c0<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.usercenter.profile.b t() {
        return (com.transsion.usercenter.profile.b) this.f59427b.getValue();
    }

    public final void n() {
        j.d(u0.a(this), w0.b(), null, new MeViewmodel$fetchHistory$1(this, null), 2, null);
    }

    public final void o() {
        n();
        q1 q1Var = this.f59438n;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f59438n = j.d(u0.a(this), w0.b(), null, new MeViewmodel$fetchProfile$1(this, null), 2, null);
    }

    public final void p() {
        if (this.f59430f == null) {
            q();
        }
        uo.b.a.f(uo.b.f78622a, "MeViewmodel", "zeroConfig:" + this.f59430f, false, 4, null);
        ZeroConfig zeroConfig = this.f59430f;
        if (zeroConfig == null || !zeroConfig.getEnable()) {
            return;
        }
        j.d(u0.a(this), w0.b(), null, new MeViewmodel$fetchPurchase$1(this, null), 2, null);
    }

    public final void q() {
        try {
            Result.Companion companion = Result.Companion;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("free_buy_config", true);
            this.f59430f = (ZeroConfig) n.e(configBeanB != null ? configBeanB.getValue() : null, n.h(ZeroConfig.class, new Type[0]));
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final c0<List<VideoDetailPlayBean>> r() {
        return this.f59433i;
    }

    public final ILoginApi s() {
        Object value = this.f59428c.getValue();
        Intrinsics.f(value, "<get-loginApi>(...)");
        return (ILoginApi) value;
    }

    public final c u() {
        return (c) this.f59431g.getValue();
    }

    public final c0<List<MeItemInfo>> v() {
        return this.f59437m;
    }

    public final VideoDetailPlayDao w() {
        return (VideoDetailPlayDao) this.f59435k.getValue();
    }

    public final void x() {
        UserInfo userInfoP;
        CountInfo myComment;
        CountInfo myLike;
        CountInfo myPost;
        MySubject mySubject;
        MyGroup myGroup;
        ArrayList arrayList = new ArrayList();
        MinePageInfo minePageInfo = this.f59436l;
        Resources resources = Utils.a().getResources();
        if (minePageInfo == null || (userInfoP = minePageInfo.getUserInfo()) == null) {
            userInfoP = s().P();
        }
        MemberInfo vipInfo = minePageInfo != null ? minePageInfo.getVipInfo() : null;
        MineNovel novelEntry = minePageInfo != null ? minePageInfo.getNovelEntry() : null;
        int count = 0;
        int count2 = (minePageInfo == null || (myGroup = minePageInfo.getMyGroup()) == null) ? 0 : myGroup.getCount();
        int wantToSeeCount = (minePageInfo == null || (mySubject = minePageInfo.getMySubject()) == null) ? 0 : mySubject.getWantToSeeCount();
        int count3 = (minePageInfo == null || (myPost = minePageInfo.getMyPost()) == null) ? 0 : myPost.getCount();
        int count4 = (minePageInfo == null || (myLike = minePageInfo.getMyLike()) == null) ? 0 : myLike.getCount();
        if (minePageInfo != null && (myComment = minePageInfo.getMyComment()) != null) {
            count = myComment.getCount();
        }
        arrayList.add(new MeItemInfo(1, userInfoP));
        if (vipInfo != null) {
            arrayList.add(new MeItemInfo(2, vipInfo));
        }
        ZeroInfo zeroInfo = (ZeroInfo) CollectionsKt___CollectionsKt.g0(this.f59429d);
        if (zeroInfo != null) {
            arrayList.add(new MeItemInfo(3, zeroInfo));
        }
        if (novelEntry != null) {
            arrayList.add(new MeItemInfo(7, novelEntry));
        }
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.profile_your_list), String.valueOf(wantToSeeCount), "oneroom://com.community.oneroom/profile/see", R$drawable.ic_mine_mylist, com.transsion.baseui.R$drawable.bg_radius_top_6_color_white_6p, true, gs.a.a(8), false, "want_to_see", 128, null)));
        arrayList.add(new MeItemInfo(4, new MeHistoryInfo(this.f59434j)));
        arrayList.add(new MeItemInfo(6, null));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.profile_my_room), String.valueOf(count2), s().N() ? "oneroom://com.community.oneroom/room/list" : "oneroom://com.community.oneroom/room/list?index=1", com.transsion.publish.R$drawable.icon_post_group, com.transsion.baseui.R$drawable.bg_radius_top_6_color_white_6p, true, gs.a.a(8), false, "myrooms")));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.profile_post), String.valueOf(count3), "post_list_type", R$drawable.ic_mine_post, R$color.white_6, true, 0, true, "post", 64, null)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(com.tn.lib.widget.R$string.my_likes), String.valueOf(count4), "like_list_type", R$drawable.ic_post_like, R$color.white_6, true, 0, false, "like", PsExtractor.AUDIO_STREAM, null)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(com.transsion.baseui.R$string.my_comments), String.valueOf(count), "oneroom://com.community.oneroom/post/my_comment", com.transsion.baseui.R$drawable.ic_post_comment, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, true, "comments", 96, null)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_setting), null, "oneroom://com.community.oneroom/profile/setting", R$mipmap.profile_setting, com.transsion.baseui.R$drawable.bg_radius_top_6_color_white_6p, true, gs.a.a(8), false, "setting", 128, null)));
        arrayList.add(new MeItemInfo(5, new IconItemInfo(resources.getString(R$string.user_setting_feedback), null, "oneroom://com.community.oneroom/profile/user_center_labels_feedback", R$drawable.ic_mine_feedback, com.transsion.baseui.R$drawable.bg_radius_bottom_6_color_white_6p, false, 0, false, "feedback", 224, null)));
        this.f59437m.n(arrayList);
    }
}
