package com.transsion.usercenter.profile.see;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.share.bean.PostType;
import com.transsion.usercenter.profile.b;
import com.transsion.usercenter.profile.see.bean.ProfileSeeData;
import com.transsion.usercenter.profile.see.bean.ProfileSeeItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeMultiItemData;
import com.transsion.usercenter.profile.see.bean.ProfileSeeStaffItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeSubjectItem;
import com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem;
import com.transsnet.downloader.viewmodel.c;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k10.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.g;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
public final class ProfileSeeViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f59623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f59624d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<String> f59625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<ProfileSeeMultiItemData> f59626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<Pair<String, PostType>> f59627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<Integer> f59628i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<T, R> implements h {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00c1  */
        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<ProfileSeeMultiItemData>> apply(BaseDto<ProfileSeeData> it) {
            ArrayList arrayList;
            Iterable iterableEmptyList;
            Intrinsics.g(it, "it");
            ProfileSeeData data = it.getData();
            if (data != null) {
                ProfileSeeViewModel profileSeeViewModel = ProfileSeeViewModel.this;
                List<ProfileSeeItem> items = data.getItems();
                if (items != null) {
                    arrayList = new ArrayList();
                    for (ProfileSeeItem profileSeeItem : items) {
                        ProfileSeeSubjectItem subject = profileSeeItem.getSubject();
                        ProfileSeeStaffItem staff = profileSeeItem.getStaff();
                        if (subject != null) {
                            String mySeeTime = subject.getMySeeTime();
                            String strI = profileSeeViewModel.i(mySeeTime != null ? Long.parseLong(mySeeTime) : 0L);
                            if (profileSeeViewModel.f59625f.contains(strI)) {
                                iterableEmptyList = g.h(subject);
                            } else {
                                profileSeeViewModel.f59625f.add(strI);
                                iterableEmptyList = g.h(new ProfileSeeTimeItem(strI), subject);
                            }
                        } else if (staff != null) {
                            String mySeeTime2 = staff.getMySeeTime();
                            String strI2 = profileSeeViewModel.i(mySeeTime2 != null ? Long.parseLong(mySeeTime2) : 0L);
                            if (profileSeeViewModel.f59625f.contains(strI2)) {
                                iterableEmptyList = g.h(staff);
                            } else {
                                profileSeeViewModel.f59625f.add(strI2);
                                iterableEmptyList = g.h(new ProfileSeeTimeItem(strI2), staff);
                            }
                        } else {
                            iterableEmptyList = Collections.emptyList();
                        }
                        Intrinsics.f(iterableEmptyList, "if (null != profileSeeSu…                        }");
                        k.A(arrayList, iterableEmptyList);
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
            } else {
                arrayList = new ArrayList();
            }
            BaseDto baseDto = new BaseDto();
            ProfileSeeData data2 = it.getData();
            baseDto.setData(new ProfileSeeMultiItemData(data2 != null ? data2.getPager() : null, arrayList));
            baseDto.setCode(it.getCode());
            baseDto.setMsg(it.getMsg());
            baseDto.setReason(it.getReason());
            return j.p(baseDto);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<ProfileSeeMultiItemData> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            ProfileSeeViewModel.this.f59626g.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileSeeMultiItemData profileSeeMultiItemData) {
            Pager pager;
            super.c(profileSeeMultiItemData);
            ProfileSeeViewModel.this.f59626g.q(profileSeeMultiItemData);
            if (profileSeeMultiItemData == null || (pager = profileSeeMultiItemData.getPager()) == null) {
                return;
            }
            ProfileSeeViewModel profileSeeViewModel = ProfileSeeViewModel.this;
            String nextPage = pager.getNextPage();
            profileSeeViewModel.f59623c = nextPage != null ? Integer.parseInt(nextPage) : 1;
            Integer perPage = pager.getPerPage();
            profileSeeViewModel.f59624d = perPage != null ? perPage.intValue() : 10;
            c0 c0Var = profileSeeViewModel.f59628i;
            int totalCount = pager.getTotalCount();
            if (totalCount == null) {
                totalCount = 0;
            }
            c0Var.q(totalCount);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSeeViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59622b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<com.transsion.usercenter.profile.b>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeViewModel$mProfileApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) NetServiceGenerator.f49399d.a().i(b.class);
            }
        });
        this.f59623c = 1;
        this.f59624d = 10;
        this.f59625f = new ArrayList<>();
        this.f59626g = new c0<>();
        this.f59627h = new c0<>();
        this.f59628i = new c0<>();
    }

    private final com.transsion.usercenter.profile.b l() {
        return (com.transsion.usercenter.profile.b) this.f59622b.getValue();
    }

    public final String i(long j11) {
        return c.f61276a.E(j11 * ((long) 1000));
    }

    public final LiveData<Integer> j() {
        return this.f59628i;
    }

    public final LiveData<Pair<String, PostType>> k() {
        return this.f59627h;
    }

    public final LiveData<ProfileSeeMultiItemData> m() {
        return this.f59626g;
    }

    public final void n(String userId, int i11) {
        Intrinsics.g(userId, "userId");
        com.transsion.usercenter.profile.b.a.i(l(), userId, this.f59623c, this.f59624d, i11, null, 16, null).k(new a()).e(d.f82109a.c()).subscribe(new b());
    }

    public final void o(String userId, int i11) {
        Intrinsics.g(userId, "userId");
        this.f59623c = 1;
        this.f59624d = 10;
        this.f59625f.clear();
        n(userId, i11);
    }
}
