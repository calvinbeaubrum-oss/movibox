package com.transsion.member;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.n;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.member.dialog.CheckMemberRightsLoadingDialog;
import com.transsion.member.dialog.ClaimMemberDialog;
import com.transsion.member.dialog.MemberGuideDialog;
import com.transsion.member.dialog.MemberMiddleStateDialog;
import com.transsion.member.dialog.MemberTaskCheckInDialog;
import com.transsion.member.dialog.PurchaseSucceedDialog;
import com.transsion.memberapi.GlobalTaskInfo;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MemberTaskCheckInInfo;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberType;
import com.transsion.memberapi.OpType;
import com.transsion.memberapi.TaskRewards;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.v0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

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
@Route(path = "/member/MemberProvider")
@Metadata
@SourceDebugExtension
public final class MemberProvider implements IMemberApi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile MemberDetail f53164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile MemberTaskInfo f53165c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClaimMemberDialog f53169g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f53163a = LazyKt__LazyJVMKt.b(new Function0<pu.a>() { // from class: com.transsion.member.MemberProvider$memberApi$2
        @Override // kotlin.jvm.functions.Function0
        public final pu.a invoke() {
            return (pu.a) NetServiceGenerator.f49399d.a().i(pu.a.class);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v0<MemberTaskItem> f53166d = g1.a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v0<Boolean> f53167e = g1.a(Boolean.FALSE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53168f = "";

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a extends zo.a<TaskRewards> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function2<String, String, Unit> f53170d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function1<TaskRewards, Unit> f53171f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super String, ? super String, Unit> function2, Function1<? super TaskRewards, Unit> function1) {
            this.f53170d = function2;
            this.f53171f = function1;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("claimTaskReward error:" + str2);
            Function2<String, String, Unit> function2 = this.f53170d;
            if (function2 != null) {
                function2.invoke(str, str2);
            }
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TaskRewards taskRewards) {
            com.transsion.member.a.f53220a.a("claimTaskReward success");
            Function1<TaskRewards, Unit> function1 = this.f53171f;
            if (function1 != null) {
                function1.invoke(taskRewards);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b extends zo.a<GlobalTaskInfo> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("fetchGlobalTasks failed, code: " + str + ", message: " + str2);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(GlobalTaskInfo globalTaskInfo) {
            super.c(globalTaskInfo);
            if (globalTaskInfo == null) {
                com.transsion.member.a.f53220a.b("fetchGlobalTasks data error");
                return;
            }
            com.transsion.member.a.f53220a.a("fetchGlobalTasks succeed " + globalTaskInfo.getTaskInfo());
            MemberProvider.this.f53166d.setValue(globalTaskInfo.getTaskInfo());
            MemberProvider.this.f53167e.setValue(Boolean.valueOf(globalTaskInfo.getTaskInfo() != null));
            com.transsion.member.task.i.f53350a.Y(globalTaskInfo.getGlobalTaskConf());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class c<T> implements k10.f {
        public c() {
        }

        @Override // k10.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto<MemberTaskInfo> it) {
            Intrinsics.g(it, "it");
            MemberTaskInfo data = it.getData();
            if (data != null) {
                MemberProvider memberProvider = MemberProvider.this;
                MemberKV.f53157a.a().putString("MEMBER_TASK_JSON", n.j(data));
                memberProvider.f53165c = data;
                memberProvider.f53168f = memberProvider.I1();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class d extends zo.a<MemberTaskInfo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ su.c f53178f;

        public d(su.c cVar) {
            this.f53178f = cVar;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("fetchMemberTaskInfo onFailure:" + str + ", " + str2);
            com.transsion.member.task.i.f53350a.X(MemberProvider.this.f53165c);
            su.c cVar = this.f53178f;
            if (cVar != null) {
                cVar.a(MemberProvider.this.f53165c, true);
            }
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskInfo memberTaskInfo) {
            super.c(memberTaskInfo);
            com.transsion.member.a.f53220a.b("fetchMemberTaskInfo onSuccess:" + memberTaskInfo);
            com.transsion.member.task.i.f53350a.X(memberTaskInfo);
            su.c cVar = this.f53178f;
            if (cVar != null) {
                cVar.a(memberTaskInfo, false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class e implements su.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ su.a f53179a;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements su.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ su.a f53180a;

            public a(su.a aVar) {
                this.f53180a = aVar;
            }

            @Override // su.b
            public void a() {
                su.a aVar = this.f53180a;
                if (aVar != null) {
                    aVar.onFail("开通会员失败");
                }
            }

            @Override // su.b
            public void onSuccess() {
                su.a aVar = this.f53180a;
                if (aVar != null) {
                    aVar.d();
                }
            }
        }

        public e(su.a aVar) {
            this.f53179a = aVar;
        }

        @Override // su.a
        public void a(MemberCheckResult memberCheckResult) {
            su.a.C0841a.f(this, memberCheckResult);
            ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).c1(com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_HDDL, memberCheckResult, new a(this.f53179a));
        }

        @Override // su.a
        public void b(MemberCheckResult memberCheckResult) {
            su.a.C0841a.d(this, memberCheckResult);
        }

        @Override // su.a
        public void c(MemberCheckResult memberCheckResult) {
            su.a.C0841a.e(this, memberCheckResult);
        }

        @Override // su.a
        public void d() {
            su.a.C0841a.c(this);
            su.a aVar = this.f53179a;
            if (aVar != null) {
                aVar.d();
            }
        }

        @Override // su.a
        public void e(MemberCheckResult memberCheckResult) {
            su.a.C0841a.a(this, memberCheckResult);
        }

        @Override // su.a
        public void onFail(String errorMsg) {
            Intrinsics.g(errorMsg, "errorMsg");
            su.a.C0841a.b(this, errorMsg);
            su.a aVar = this.f53179a;
            if (aVar != null) {
                aVar.onFail("请求权益校验接口失败");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class f extends zo.a<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<Object, Unit> f53181d;

        public f(Function1<Object, Unit> function1) {
            this.f53181d = function1;
        }

        @Override // zo.a
        public void a(String str, String str2) {
            com.transsion.member.a.f53220a.b("Upload operation stat failed " + str + ", " + str2);
            Function1<Object, Unit> function1 = this.f53181d;
            if (function1 != null) {
                function1.invoke(null);
            }
        }

        @Override // zo.a
        public void c(Object obj) {
            super.c(obj);
            com.transsion.member.a.f53220a.b("Upload operation stat succeed " + obj);
            Function1<Object, Unit> function1 = this.f53181d;
            if (function1 != null) {
                function1.invoke("ok");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H1() {
        String simpleName = MemberProvider.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public boolean A(Fragment fragment) {
        return fragment instanceof MemberFragment;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void A0() {
        com.transsion.member.task.i.f53350a.c0();
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void B(MemberDetail memberDetail) {
        this.f53164b = memberDetail;
    }

    public void G1(MemberTaskItem item, Function2<? super String, ? super String, Unit> function2, Function1<? super TaskRewards, Unit> function1) throws JSONException {
        Intrinsics.g(item, "item");
        JSONObject jSONObject = new JSONObject();
        com.transsion.member.a.f53220a.a("claimTaskReward taskId: " + item.getTaskId());
        Object taskId = item.getTaskId();
        if (taskId == null) {
            taskId = 0;
        }
        jSONObject.put("taskId", taskId);
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jSONObject.toString();
        Intrinsics.f(string, "json.toString()");
        pu.a.C0809a.j(J1(), null, companion.create(string, MediaType.Companion.parse("application/json")), 1, null).e(zo.d.f82109a.c()).subscribe(new a(function2, function1));
    }

    public final String I1() {
        String str = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(Calendar.getInstance().getTimeInMillis() - ((long) 14400000)));
        Intrinsics.f(str, "SimpleDateFormat(\n      …() - 4 * 60 * 60 * 1000))");
        return str;
    }

    public final pu.a J1() {
        return (pu.a) this.f53163a.getValue();
    }

    public boolean K1() {
        MemberInfo memberInfo;
        MemberDetail memberDetail;
        MemberInfo memberInfo2;
        MemberDetail memberDetail2 = this.f53164b;
        return (memberDetail2 == null || (memberInfo = memberDetail2.getMemberInfo()) == null || !memberInfo.isActive() || (memberDetail = this.f53164b) == null || (memberInfo2 = memberDetail.getMemberInfo()) == null || memberInfo2.getMemberType() != MemberType.PREMIUM.getValue()) ? false : true;
    }

    public final void L1(boolean z11) {
        MemberTaskGroup memberTaskGroup;
        List<MemberTaskGroup> list;
        Object next;
        Object next2;
        List<MemberTaskItemCheckInInfo> checkInList;
        MemberTaskInfo memberTaskInfo = this.f53165c;
        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = null;
        Object obj = null;
        if (memberTaskInfo == null || (list = memberTaskInfo.getList()) == null) {
            memberTaskGroup = null;
        } else {
            Iterator<T> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Iterator<T> it2 = ((MemberTaskGroup) next).getTaskItems().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    MemberTaskItem memberTaskItem = (MemberTaskItem) next2;
                    Integer taskSubType = memberTaskItem.getTaskSubType();
                    if (taskSubType != null && taskSubType.intValue() == 8 && (checkInList = memberTaskItem.getCheckInList()) != null && !checkInList.isEmpty()) {
                        break;
                    }
                }
            } while (next2 == null);
            memberTaskGroup = (MemberTaskGroup) next;
        }
        if (memberTaskGroup != null) {
            List<MemberTaskItemCheckInInfo> checkInList2 = memberTaskGroup.getTaskItems().get(0).getCheckInList();
            if (checkInList2 != null) {
                for (Object obj2 : checkInList2) {
                    if (((MemberTaskItemCheckInInfo) obj2).isToday()) {
                        obj = obj2;
                        break;
                    }
                }
                memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj;
            }
            if (memberTaskItemCheckInInfo == null) {
                return;
            }
            memberTaskItemCheckInInfo.setHasCheckIn(z11);
        }
    }

    @Override // com.transsion.memberapi.IMemberApi
    public MemberDetail M() {
        return this.f53164b;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void N0(float f11) {
        com.transsion.member.a.f53220a.a("checkMemberShipShow data:" + this.f53166d.getValue());
        try {
            if (this.f53166d.getValue() != null) {
                ClaimMemberDialog claimMemberDialog = new ClaimMemberDialog();
                claimMemberDialog.v0(this.f53166d.getValue());
                claimMemberDialog.w0(com.transsion.core.utils.e.a(f11));
                claimMemberDialog.j0(com.blankj.utilcode.util.a.b(), "ClaimMemberDialog");
                this.f53169g = claimMemberDialog;
            }
        } catch (Exception e11) {
            com.transsion.member.a.f53220a.b("checkMemberShipShow error:" + e11.getMessage());
        }
    }

    @Override // com.transsion.memberapi.IMemberApi
    public boolean O() {
        MemberInfo memberInfo;
        MemberDetail memberDetail = this.f53164b;
        if (memberDetail == null || (memberInfo = memberDetail.getMemberInfo()) == null) {
            return false;
        }
        return memberInfo.isActive();
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void R(OpType opType, Function1<Object, Unit> function1) {
        Intrinsics.g(opType, "opType");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("opType", opType.getValue());
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jsonObject.toString();
        Intrinsics.f(string, "json.toString()");
        J1().g(cp.a.f62775a.a(), companion.create(string, MediaType.Companion.parse("application/json"))).e(zo.d.f82109a.c()).subscribe(new f(function1));
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void V0(su.e listener) {
        Intrinsics.g(listener, "listener");
        ObserveLoginAction.f53214c.a().k(listener);
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void W(final int i11, final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        if (!K1()) {
            pu.a.C0809a.e(J1(), null, 1, null).e(zo.d.f82109a.c()).subscribe(new zo.a<MemberTaskCheckInInfo>() { // from class: com.transsion.member.MemberProvider$asyncShowMemberCheckInDialog$1
                @Override // zo.a
                public void a(String str, String str2) {
                    a.f53220a.b("fetchMemberTaskCheckInInfo failed, code: " + str + ", message: " + str2);
                }

                @Override // zo.a
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public void c(MemberTaskCheckInInfo memberTaskCheckInInfo) {
                    Object next;
                    super.c(memberTaskCheckInInfo);
                    if (memberTaskCheckInInfo == null) {
                        a.f53220a.b("fetchMemberTaskCheckInInfo data error");
                        Function2<Boolean, Boolean, Unit> function3 = function2;
                        if (function3 != null) {
                            function3.invoke(Boolean.TRUE, Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    a.f53220a.a("fetchMemberTaskCheckInInfo succeed " + memberTaskCheckInInfo);
                    Iterator<T> it = memberTaskCheckInInfo.getCheckInList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) next;
                        if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                            break;
                        }
                    }
                    if (next == null) {
                        a.f53220a.b("fetchMemberTaskCheckInInfo today already check in ，can`t show");
                        Function2<Boolean, Boolean, Unit> function4 = function2;
                        if (function4 != null) {
                            function4.invoke(Boolean.TRUE, Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    MemberTaskCheckInDialog.a aVar = MemberTaskCheckInDialog.f53291m;
                    if (aVar.d()) {
                        int i12 = i11;
                        final MemberProvider memberProvider = this;
                        aVar.c(i12, memberTaskCheckInInfo, new Function1<Boolean, Unit>() { // from class: com.transsion.member.MemberProvider$asyncShowMemberCheckInDialog$1$onSuccess$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.f68710a;
                            }

                            public final void invoke(boolean z11) {
                                memberProvider.L1(z11);
                            }
                        }).F0(function2).j0(com.blankj.utilcode.util.a.b(), MemberTaskCheckInDialog.class.getSimpleName());
                    } else {
                        a.f53220a.b("fetchMemberTaskCheckInInfo today show has been ignored，can`t show");
                        Function2<Boolean, Boolean, Unit> function5 = function2;
                        if (function5 != null) {
                            function5.invoke(Boolean.TRUE, Boolean.FALSE);
                        }
                    }
                }
            });
        } else if (function2 != null) {
            function2.invoke(Boolean.TRUE, Boolean.FALSE);
        }
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void Y() {
        com.transsion.member.task.i.f53350a.h0();
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void Z0(final Function2<? super String, ? super String, Unit> function2, final Function0<Unit> function0) throws JSONException {
        MemberTaskItem value = this.f53166d.getValue();
        if (value != null) {
            G1(value, new Function2<String, String, Unit>() { // from class: com.transsion.member.MemberProvider$claimMemberShipReward$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, String str2) {
                    Function2<String, String, Unit> function3 = function2;
                    if (function3 != null) {
                        function3.invoke(str, str2);
                    }
                    zp.b.a aVar = zp.b.f82110a;
                    if (str2 == null) {
                        return;
                    }
                    aVar.e(str2);
                }
            }, new Function1<TaskRewards, Unit>() { // from class: com.transsion.member.MemberProvider$claimMemberShipReward$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TaskRewards taskRewards) {
                    invoke2(taskRewards);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TaskRewards taskRewards) {
                    this.this$0.f53166d.setValue(null);
                    this.this$0.f53167e.setValue(Boolean.FALSE);
                    if (taskRewards != null && taskRewards.getTips() != null) {
                        zp.b.f82110a.e(taskRewards.getTips());
                    }
                    Function0<Unit> function1 = function0;
                    if (function1 != null) {
                        function1.invoke();
                    }
                }
            });
        }
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void c1(Activity activity, MemberSource source, MemberCheckResult memberCheckResult, su.b callback) {
        Intrinsics.g(source, "source");
        Intrinsics.g(callback, "callback");
        MemberGuideDialog memberGuideDialog = new MemberGuideDialog();
        memberGuideDialog.q0(callback);
        memberGuideDialog.v0(source);
        memberGuideDialog.u0(memberCheckResult);
        memberGuideDialog.j0(activity, "MemberGuideDialog");
    }

    @Override // com.transsion.memberapi.IMemberApi
    public f1<Boolean> d() {
        return this.f53167e;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void e0(MemberSceneType sceneType, Integer num, su.a aVar) {
        Intrinsics.g(sceneType, "sceneType");
        CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog = new CheckMemberRightsLoadingDialog();
        checkMemberRightsLoadingDialog.t0(aVar);
        checkMemberRightsLoadingDialog.u0(sceneType, num);
        checkMemberRightsLoadingDialog.j0(com.blankj.utilcode.util.a.b(), "CheckMemberRightsDialog");
    }

    @Override // com.transsion.memberapi.IMemberApi
    public boolean e1() {
        return MemberKV.f53157a.a().getBoolean("kv_is_enable_member", true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.transsion.memberapi.IMemberApi
    public Object f(MemberSceneType memberSceneType, Integer num, Function1<? super MemberCheckResult, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        MemberProvider$checkMemberRights$1 memberProvider$checkMemberRights$1;
        MemberProvider memberProvider;
        Object objM163constructorimpl;
        Unit unit;
        if (continuation instanceof MemberProvider$checkMemberRights$1) {
            memberProvider$checkMemberRights$1 = (MemberProvider$checkMemberRights$1) continuation;
            int i11 = memberProvider$checkMemberRights$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                memberProvider$checkMemberRights$1.label = i11 - Integer.MIN_VALUE;
            } else {
                memberProvider$checkMemberRights$1 = new MemberProvider$checkMemberRights$1(this, continuation);
            }
        } else {
            memberProvider$checkMemberRights$1 = new MemberProvider$checkMemberRights$1(this, continuation);
        }
        Object objL = memberProvider$checkMemberRights$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = memberProvider$checkMemberRights$1.label;
        if (i12 == 0) {
            ResultKt.b(objL);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("sceneType", memberSceneType != null ? memberSceneType.getValue() : null);
            if (num != null) {
                jsonObject.addProperty("resolution", num);
            }
            RequestBody.Companion companion = RequestBody.Companion;
            String string = jsonObject.toString();
            Intrinsics.f(string, "json.toString()");
            RequestBody requestBodyCreate = companion.create(string, MediaType.Companion.parse("application/json"));
            try {
                Result.Companion companion2 = Result.Companion;
                pu.a aVarJ1 = J1();
                String strA = cp.a.f62775a.a();
                memberProvider$checkMemberRights$1.L$0 = this;
                memberProvider$checkMemberRights$1.L$1 = function1;
                memberProvider$checkMemberRights$1.label = 1;
                objL = aVarJ1.l(strA, requestBodyCreate, memberProvider$checkMemberRights$1);
                if (objL == objE) {
                    return objE;
                }
                memberProvider = this;
            } catch (Throwable th2) {
                th = th2;
                memberProvider = this;
                Result.Companion companion3 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) memberProvider$checkMemberRights$1.L$1;
            memberProvider = (MemberProvider) memberProvider$checkMemberRights$1.L$0;
            try {
                ResultKt.b(objL);
            } catch (Throwable th3) {
                th = th3;
                Result.Companion companion4 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
            }
        }
        BaseDto baseDto = (BaseDto) objL;
        if (function1 != null) {
            function1.invoke(baseDto.getData());
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        objM163constructorimpl = Result.m163constructorimpl(unit);
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.member.a.f53220a.b(memberProvider.H1() + " --> checkMemberRights() ---> getOrElse() --> it = " + thM166exceptionOrNullimpl);
            if (function1 != null) {
                function1.invoke(null);
            }
        }
        return Unit.f68710a;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public boolean g() {
        return MemberKV.f53157a.a().getBoolean("kv_is_pay_enable_member", false);
    }

    @Override // com.transsion.memberapi.IMemberApi
    public f1<MemberTaskItem> g0() {
        return this.f53166d;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void h1(Function0<Unit> function0) {
        j.d(l0.a(w0.b()), null, null, new MemberProvider$checkShowAdState$1(this, function0, null), 3, null);
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void i(Integer num, su.a aVar) {
        com.transsion.member.a.f53220a.a(H1() + " --> showCheckResolutionRightsDialog() --> 分辨率会员权益校验");
        e0(MemberSceneType.SCENE_PREDL, num, new e(aVar));
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        Object objM163constructorimpl;
        String string = MemberKV.f53157a.a().getString("MEMBER_JSON", null);
        if (string == null || string.length() == 0) {
            this.f53164b = null;
        } else {
            try {
                this.f53164b = (MemberDetail) n.d(string, MemberDetail.class);
            } catch (Exception unused) {
                this.f53164b = null;
            }
        }
        String string2 = MemberKV.f53157a.a().getString("MEMBER_TASK_JSON", null);
        if (string2 != null) {
            try {
                Result.Companion companion = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl((MemberTaskInfo) n.d(string2, MemberTaskInfo.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            this.f53165c = (MemberTaskInfo) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
        }
        if (e1()) {
            ObserveLoginAction.f53214c.a().i();
        }
    }

    @Override // com.transsion.memberapi.IMemberApi
    public int j1() {
        return MemberKV.f53157a.a().getInt("kv_parallel_download_task_num", 1);
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void k1(Activity activity, String title, String buttonTitle, su.g gVar) {
        Intrinsics.g(title, "title");
        Intrinsics.g(buttonTitle, "buttonTitle");
        PurchaseSucceedDialog purchaseSucceedDialog = new PurchaseSucceedDialog(title, buttonTitle, gVar);
        purchaseSucceedDialog.r0(gVar);
        purchaseSucceedDialog.s0(title);
        purchaseSucceedDialog.q0(buttonTitle);
        purchaseSucceedDialog.j0(activity, "PurchaseSucceedDialog");
    }

    @Override // com.transsion.memberapi.IMemberApi
    public boolean m() {
        return MemberKV.f53157a.a().getBoolean("kv_is_skip_ad", false);
    }

    @Override // com.transsion.memberapi.IMemberApi
    public Fragment m0() {
        Object objNavigation = com.alibaba.android.arouter.launcher.a.d().b("/member/MemberFragment").navigation();
        Intrinsics.e(objNavigation, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) objNavigation;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void n() {
        pu.a.C0809a.a(J1(), null, 1, null).e(zo.d.f82109a.c()).subscribe(new b());
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void p(su.c cVar) {
        pu.a.C0809a.f(J1(), null, 1, null).e(zo.d.f82109a.c()).g(new c()).subscribe(new d(cVar));
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void v(Activity activity, MemberSource memberSource, su.b callback, boolean z11) {
        Intrinsics.g(callback, "callback");
        if (e1()) {
            MemberMiddleStateDialog memberMiddleStateDialogA = MemberMiddleStateDialog.f53277h.a(z11);
            memberMiddleStateDialogA.o0(callback);
            memberMiddleStateDialogA.p0(memberSource);
            memberMiddleStateDialogA.j0(activity, "MemberMiddleStateDialog");
            return;
        }
        com.transsion.member.a.f53220a.b(H1() + " --> startMemberPage() --> 当前不开发会员功能");
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void w(su.e listener) {
        Intrinsics.g(listener, "listener");
        ObserveLoginAction.f53214c.a().d(listener);
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void y1() {
        ClaimMemberDialog claimMemberDialog = this.f53169g;
        if (claimMemberDialog != null) {
            claimMemberDialog.p0();
        }
        this.f53169g = null;
    }

    @Override // com.transsion.memberapi.IMemberApi
    public void z() {
        com.transsion.member.task.i.f53350a.f0();
    }
}
