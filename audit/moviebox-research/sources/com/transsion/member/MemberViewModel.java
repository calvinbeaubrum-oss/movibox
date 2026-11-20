package com.transsion.member;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.member.bean.RedeemResult;
import com.transsion.member.bean.request.InviteUserShareInfoReq;
import com.transsion.member.bean.request.MemberInviteUserShareInfo;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.PreloadSkuHelper;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.SkuItem;
import com.transsion.payment.lib.bean.HttpErrorBodyBean;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.HttpException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MemberViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f53182p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f53183q = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f53184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f53185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<MemberDetail> f53186d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<SkuData> f53187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<RedeemResult> f53188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<List<MemberTaskItem>> f53189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<Pair<Integer, MemberTaskSubmitCheckInRes>> f53190i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<su.d> f53191j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0<MemberTaskInviteRewards> f53192k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<Map<String, MemberInviteUserShareInfo>> f53193l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f53194m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h10.b f53195n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h10.b f53196o;

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
    public static final class b<T> implements k10.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f53197a = new b<>();

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto<MemberDetail> it) {
            Intrinsics.g(it, "it");
            MemberDetail data = it.getData();
            if (data != null) {
                MemberKV.f53157a.a().putString("MEMBER_JSON", n.j(data));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends zo.a<MemberDetail> {
        public c() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MemberViewModel.this.f53186d.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberDetail memberDetail) {
            super.c(memberDetail);
            MemberViewModel.this.f53186d.q(memberDetail);
            ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).B(memberDetail);
        }

        @Override // zo.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            super.onSubscribe(d11);
            MemberViewModel.this.f53195n = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements su.c {
        public d() {
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00af A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:35:0x0074 A[SYNTHETIC] */
        @Override // su.c
        public void a(MemberTaskInfo memberTaskInfo, boolean z11) {
            List<MemberTaskGroup> arrayList;
            ArrayList arrayList2 = new ArrayList();
            if (memberTaskInfo == null || (arrayList = memberTaskInfo.getList()) == null) {
                arrayList = new ArrayList<>();
            }
            for (MemberTaskGroup memberTaskGroup : arrayList) {
                int value = TaskType.TITLE.getValue();
                String groupUrl = memberTaskGroup.getGroupUrl();
                Object groupInfo = memberTaskGroup.getGroupInfo();
                arrayList2.add(new MemberTaskItem(null, null, Integer.valueOf(value), null, null, memberTaskGroup.getGroupName(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, memberTaskGroup.getGroupName(), groupUrl, groupInfo, 2097115, null));
                for (MemberTaskItem memberTaskItem : memberTaskGroup.getTaskItems()) {
                    Integer taskSubType = memberTaskItem.getTaskSubType();
                    int value2 = TaskType.DOWNLOAD_APP.getValue();
                    if (taskSubType == null || taskSubType.intValue() != value2) {
                        Integer taskSubType2 = memberTaskItem.getTaskSubType();
                        int value3 = TaskType.OPEN_APP.getValue();
                        if (taskSubType2 != null && taskSubType2.intValue() == value3) {
                            if (com.transsion.ad.ps.b.f50555a.m()) {
                            }
                        }
                        arrayList2.add(memberTaskItem);
                    } else if (com.transsion.ad.ps.b.f50555a.m()) {
                        arrayList2.add(memberTaskItem);
                    }
                }
            }
            MemberViewModel.this.f53189h.q(arrayList2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e<T, R> implements k10.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T, R> f53200a = new e<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m<? extends BaseDto<SkuData>> apply(Throwable it) {
            Intrinsics.g(it, "it");
            String string = MemberKV.f53157a.a().getString("SKU_LIST_JSON", null);
            if (string == null || string.length() == 0) {
                return io.reactivex.rxjava3.core.j.i(it);
            }
            try {
                SkuData skuData = (SkuData) n.e(string, n.h(SkuData.class, new Type[0]));
                BaseDto baseDto = new BaseDto();
                baseDto.setCode("0");
                baseDto.setData(skuData);
                return io.reactivex.rxjava3.core.j.p(baseDto);
            } catch (Exception unused) {
                return io.reactivex.rxjava3.core.j.i(it);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f<T> implements k10.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f53201a = new f<>();

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto<SkuData> it) {
            Intrinsics.g(it, "it");
            SkuData data = it.getData();
            if (data != null) {
                List<SkuItem> skuList = data.getSkuList();
                List<SkuItem> listF0 = skuList != null ? CollectionsKt___CollectionsKt.F0(skuList, 3) : null;
                if (listF0 == null) {
                    listF0 = kotlin.collections.g.l();
                }
                data.setSkuList(listF0);
                List<SkuItem> skuPointList = data.getSkuPointList();
                List<SkuItem> listF1 = skuPointList != null ? CollectionsKt___CollectionsKt.F0(skuPointList, 3) : null;
                if (listF1 == null) {
                    listF1 = kotlin.collections.g.l();
                }
                data.setSkuPointList(listF1);
                MemberKV.f53157a.a().putString("SKU_LIST_JSON", n.j(data));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g extends zo.a<SkuData> {
        public g() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MemberViewModel.this.f53187f.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SkuData skuData) {
            super.c(skuData);
            MemberViewModel.this.f53187f.q(skuData);
        }

        @Override // zo.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            super.onSubscribe(d11);
            MemberViewModel.this.f53196o = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h extends zo.a<MemberTaskInviteRewards> {
        public h() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("requestInviteUserMore failed " + str + ", " + str2);
            MemberViewModel.this.f53192k.q(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskInviteRewards memberTaskInviteRewards) {
            super.c(memberTaskInviteRewards);
            com.transsion.member.a.f53220a.b("requestInviteUserMore onSuccess:" + memberTaskInviteRewards);
            MemberViewModel.this.f53192k.q(memberTaskInviteRewards);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class i<T1, T2, T3, R> implements k10.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T1, T2, T3, R> f53204a = new i<>();

        @Override // k10.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Triple<MemberInviteUserShareInfo, MemberInviteUserShareInfo, MemberInviteUserShareInfo> a(BaseDto<MemberInviteUserShareInfo> response1, BaseDto<MemberInviteUserShareInfo> response2, BaseDto<MemberInviteUserShareInfo> response3) {
            Intrinsics.g(response1, "response1");
            Intrinsics.g(response2, "response2");
            Intrinsics.g(response3, "response3");
            return new Triple<>(response1.getData(), response2.getData(), response3.getData());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class j<T> implements k10.f {
        public j() {
        }

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Triple<MemberInviteUserShareInfo, MemberInviteUserShareInfo, MemberInviteUserShareInfo> it) {
            Intrinsics.g(it, "it");
            c0 c0Var = MemberViewModel.this.f53193l;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("WhatsApp", it.getFirst());
            linkedHashMap.put("Telegram", it.getSecond());
            linkedHashMap.put("CopyLink", it.getThird());
            c0Var.q(linkedHashMap);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class k<T> implements k10.f {
        public k() {
        }

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable it) {
            Intrinsics.g(it, "it");
            MemberViewModel.this.f53193l.q(new LinkedHashMap());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class l extends zo.a<MemberTaskSubmitCheckInRes> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f53208f;

        public l(int i11) {
            this.f53208f = i11;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("taskCheckInSubmit failed " + str + ", " + str2);
            MemberViewModel.this.f53190i.q(new Pair(Integer.valueOf(this.f53208f), null));
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
            super.c(memberTaskSubmitCheckInRes);
            MemberViewModel.this.f53190i.q(new Pair(Integer.valueOf(this.f53208f), memberTaskSubmitCheckInRes));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class m extends zo.a<MemberTaskRewardInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f53210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f53211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f53212h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f53213i;

        public m(int i11, String str, int i12, int i13) {
            this.f53210f = i11;
            this.f53211g = str;
            this.f53212h = i12;
            this.f53213i = i13;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("taskCheckInSubmit failed " + str + ", " + str2);
            MemberViewModel.this.f53191j.q(new su.d(-this.f53210f, this.f53211g, this.f53212h, this.f53213i, null));
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskRewardInfo memberTaskRewardInfo) {
            super.c(memberTaskRewardInfo);
            MemberViewModel.this.f53191j.q(new su.d(this.f53210f, this.f53211g, this.f53212h, this.f53213i, memberTaskRewardInfo));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f53184b = LazyKt__LazyJVMKt.b(new Function0<pu.a>() { // from class: com.transsion.member.MemberViewModel$memberApi$2
            @Override // kotlin.jvm.functions.Function0
            public final pu.a invoke() {
                return (pu.a) NetServiceGenerator.f49399d.a().i(pu.a.class);
            }
        });
        this.f53185c = LazyKt__LazyJVMKt.b(new Function0<IMemberApi>() { // from class: com.transsion.member.MemberViewModel$memberProvider$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IMemberApi invoke() {
                return (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
            }
        });
        this.f53186d = new c0<>();
        this.f53187f = new c0<>();
        this.f53188g = new c0<>();
        this.f53189h = new c0<>();
        this.f53190i = new c0<>();
        this.f53191j = new c0<>();
        this.f53192k = new c0<>();
        this.f53193l = new c0<>();
        this.f53194m = new LinkedHashMap();
    }

    private final pu.a s() {
        return (pu.a) this.f53184b.getValue();
    }

    public final LiveData<su.d> A() {
        return this.f53191j;
    }

    public final LiveData<List<MemberTaskItem>> B() {
        return this.f53189h;
    }

    public final void C() {
        String string = MemberKV.f53157a.a().getString("MEMBER_JSON", null);
        if (string != null && string.length() != 0) {
            try {
                this.f53186d.q((MemberDetail) n.d(string, MemberDetail.class));
            } catch (Exception e11) {
                uo.b.a.f(uo.b.f78622a, "MemberViewModel", "No member detail cache " + e11, false, 4, null);
            }
        }
        String string2 = MemberKV.f53157a.a().getString("SKU_LIST_JSON", null);
        if (string2 == null || string2.length() == 0) {
            uo.b.a.f(uo.b.f78622a, "MemberViewModel", "Preload sku local cache", false, 4, null);
            D();
        } else {
            try {
                this.f53187f.q((SkuData) n.e(string2, n.h(SkuData.class, new Type[0])));
                uo.b.a.f(uo.b.f78622a, "MemberViewModel", "Sku list mmkv cache exists", false, 4, null);
            } catch (Exception unused) {
                uo.b.a.f(uo.b.f78622a, "MemberViewModel", "No Sku list mmkv cache that needs to preload sku local cache", false, 4, null);
                D();
            }
        }
        p();
    }

    public final void D() {
        SkuData skuDataF = PreloadSkuHelper.f53417a.a().f();
        uo.b.a.f(uo.b.f78622a, "MemberViewModel", "Preload skuCache is " + skuDataF, false, 4, null);
        this.f53187f.q(skuDataF);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object E(SkuItem skuItem, Continuation<? super BaseDto<RedeemResult>> continuation) throws Throwable {
        MemberViewModel$redeem$1 memberViewModel$redeem$1;
        String message;
        String code;
        String reason;
        if (continuation instanceof MemberViewModel$redeem$1) {
            memberViewModel$redeem$1 = (MemberViewModel$redeem$1) continuation;
            int i11 = memberViewModel$redeem$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                memberViewModel$redeem$1.label = i11 - Integer.MIN_VALUE;
            } else {
                memberViewModel$redeem$1 = new MemberViewModel$redeem$1(this, continuation);
            }
        } else {
            memberViewModel$redeem$1 = new MemberViewModel$redeem$1(this, continuation);
        }
        Object objO = memberViewModel$redeem$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = memberViewModel$redeem$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(objO);
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("skuId", skuItem.getSkuId());
                if (this.f53194m.get(skuItem.getSkuId()) != null) {
                    jSONObject.put("clientOrderId", this.f53194m.get(skuItem.getSkuId()));
                } else {
                    jSONObject.put("clientOrderId", UUID.randomUUID().toString());
                    Map<String, String> map = this.f53194m;
                    String skuId = skuItem.getSkuId();
                    String string = jSONObject.getString("clientOrderId");
                    Intrinsics.f(string, "json.getString(\"clientOrderId\")");
                    map.put(skuId, string);
                }
                RequestBody.Companion companion2 = RequestBody.Companion;
                String string2 = jSONObject.toString();
                Intrinsics.f(string2, "json.toString()");
                RequestBody requestBodyCreate = companion2.create(string2, MediaType.Companion.parse("application/json"));
                pu.a aVarS = s();
                String strA = cp.a.f62775a.a();
                memberViewModel$redeem$1.label = 1;
                objO = aVarS.o(strA, requestBodyCreate, memberViewModel$redeem$1);
                if (objO == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objO);
            }
            return objO;
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2)));
            if (thM166exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            if (!(thM166exceptionOrNullimpl instanceof HttpException)) {
                uo.b.a.j(uo.b.f78622a, "MemberViewModel", "it = " + thM166exceptionOrNullimpl, false, 4, null);
                return null;
            }
            HttpErrorBodyBean httpErrorBodyBeanA = HttpErrorBodyBean.Companion.a((HttpException) thM166exceptionOrNullimpl);
            String str = "";
            if (httpErrorBodyBeanA == null || (message = httpErrorBodyBeanA.getMessage()) == null) {
                message = "";
            }
            if (httpErrorBodyBeanA == null || (code = httpErrorBodyBeanA.getCode()) == null) {
                code = "";
            }
            if (httpErrorBodyBeanA != null && (reason = httpErrorBodyBeanA.getReason()) != null) {
                str = reason;
            }
            return new BaseDto(message, code, null, str);
        }
    }

    public final void F(SkuItem skuItem) {
        Intrinsics.g(skuItem, "skuItem");
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new MemberViewModel$redeemProduct$1(this, skuItem, null), 3, null);
    }

    public final void G(int i11, int i12) {
        pu.a.C0809a.b(s(), null, i11, i12, 1, null).e(zo.d.f82109a.c()).subscribe(new h());
    }

    @SuppressLint({"CheckResult"})
    public final void H() {
        io.reactivex.rxjava3.core.j.D(pu.a.C0809a.c(s(), null, new InviteUserShareInfoReq(null, "WhatsApp", null, 5, null), 1, null), pu.a.C0809a.c(s(), null, new InviteUserShareInfoReq(null, "Telegram", null, 5, null), 1, null), pu.a.C0809a.c(s(), null, new InviteUserShareInfoReq(null, "CopyLink", null, 5, null), 1, null), i.f53204a).e(zo.d.f82109a.c()).x(new j(), new k());
    }

    public final void I(int i11) {
        pu.a.C0809a.l(s(), null, null, 3, null).e(zo.d.f82109a.c()).subscribe(new l(i11));
    }

    public final void J(int i11, String rewardId, int i12, int i13) {
        Intrinsics.g(rewardId, "rewardId");
        pu.a.C0809a.i(s(), null, rewardId, 1, null).e(zo.d.f82109a.c()).subscribe(new m(i11, rewardId, i12, i13));
    }

    public final void o() {
        h10.b bVar;
        h10.b bVar2 = this.f53195n;
        if (bVar2 != null && !bVar2.isDisposed() && (bVar = this.f53195n) != null) {
            bVar.dispose();
        }
        pu.a.C0809a.d(s(), null, 1, null).r(q10.a.b()).g(b.f53197a).e(zo.d.f82109a.c()).subscribe(new c());
    }

    public final void p() {
        u().p(new d());
    }

    public final void q() {
        h10.b bVar;
        h10.b bVar2 = this.f53196o;
        if (bVar2 != null && !bVar2.isDisposed() && (bVar = this.f53196o) != null) {
            bVar.dispose();
        }
        pu.a.C0809a.h(s(), null, 1, null).r(q10.a.b()).t(e.f53200a).g(f.f53201a).e(zo.d.f82109a.c()).subscribe(new g());
    }

    public final LiveData<MemberTaskInviteRewards> r() {
        return this.f53192k;
    }

    public final LiveData<MemberDetail> t() {
        return this.f53186d;
    }

    public final IMemberApi u() {
        return (IMemberApi) this.f53185c.getValue();
    }

    public final LiveData<RedeemResult> v() {
        return this.f53188g;
    }

    public final LiveData<Map<String, MemberInviteUserShareInfo>> w() {
        return this.f53193l;
    }

    public final SkuData x() {
        return this.f53187f.f();
    }

    public final LiveData<SkuData> y() {
        return this.f53187f;
    }

    public final LiveData<Pair<Integer, MemberTaskSubmitCheckInRes>> z() {
        return this.f53190i;
    }
}
