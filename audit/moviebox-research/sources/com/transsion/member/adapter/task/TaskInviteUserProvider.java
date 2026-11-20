package com.transsion.member.adapter.task;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.member.MemberFragment;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.bean.request.MemberInviteUserShareInfo;
import com.transsion.member.constants.TaskType;
import com.transsion.member.view.InviteUserView;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.web.share.WebShareDialog;
import com.transsnet.loginapi.ILoginApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class TaskInviteUserProvider extends BaseItemProvider<MemberTaskItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MemberFragment f53232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MemberViewModel f53233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f53234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ILoginApi f53235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f53236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f53237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b1.b<Intent> f53238l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements InviteUserView.c<MemberTaskItemInvite> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InviteUserView<MemberTaskItemInvite> f53240b;

        public a(InviteUserView<MemberTaskItemInvite> inviteUserView) {
            this.f53240b = inviteUserView;
        }

        @Override // com.transsion.member.view.InviteUserView.c
        public void a() {
            MemberViewModel memberViewModelL = TaskInviteUserProvider.this.L();
            Integer num = TaskInviteUserProvider.this.f53237k;
            memberViewModelL.G(num != null ? num.intValue() : 0, 15);
        }

        @Override // com.transsion.member.view.InviteUserView.c
        @SuppressLint({"SetTextI18n"})
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(InviteUserView<?>.e holder, int i11, MemberTaskItemInvite data) {
            TextView textView;
            Intrinsics.g(holder, "holder");
            Intrinsics.g(data, "data");
            ImageView imageView = (ImageView) holder.itemView.findViewById(R$id.tag_iv);
            TextView textView2 = (TextView) holder.itemView.findViewById(R$id.member_reward);
            TaskInviteUserProvider taskInviteUserProvider = TaskInviteUserProvider.this;
            InviteUserView<MemberTaskItemInvite> inviteUserView = this.f53240b;
            textView2.setText("+" + data.getRewardAmount() + (data.getRewardType() == 1 ? "days" : "points"));
            if (data.getStatus() == 1 && taskInviteUserProvider.f53234h) {
                View viewFindViewById = holder.itemView.findViewById(R$id.member_invite_user_tv);
                if (viewFindViewById != null) {
                    so.c.g(viewFindViewById);
                }
                View viewFindViewById2 = holder.itemView.findViewById(R$id.member_invite_user_pb);
                if (viewFindViewById2 != null) {
                    so.c.k(viewFindViewById2);
                }
            } else {
                View viewFindViewById3 = holder.itemView.findViewById(R$id.member_invite_user_tv);
                if (viewFindViewById3 != null) {
                    so.c.k(viewFindViewById3);
                }
                View viewFindViewById4 = holder.itemView.findViewById(R$id.member_invite_user_pb);
                if (viewFindViewById4 != null) {
                    so.c.g(viewFindViewById4);
                }
            }
            if (data.getStatus() == 0 && (textView = (TextView) holder.itemView.findViewById(R$id.member_invite_user_tv)) != null) {
                textView.setText(inviteUserView.getContext().getString(R$string.member_reward_friend_tips, Integer.valueOf(data.getFriendSeq())));
            }
            imageView.setImageResource(data.getRewardType() == 1 ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
        }

        @Override // com.transsion.member.view.InviteUserView.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int b(int i11, MemberTaskItemInvite data) {
            Intrinsics.g(data, "data");
            int status = data.getStatus();
            if (status != 0) {
                return status != 1 ? 1 : 2;
            }
            return 3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53241a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53241a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53241a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f53241a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements b1.a<ActivityResult> {
        public c() {
        }

        @Override // b1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(ActivityResult activityResult) {
            try {
                int resultCode = activityResult.getResultCode();
                if (resultCode == -1) {
                    com.tn.lib.widget.toast.core.h.f50034a.l(TaskInviteUserProvider.this.g().getString(R$string.share_success_tips));
                } else if (resultCode != 0) {
                    com.tn.lib.widget.toast.core.h.f50034a.l(TaskInviteUserProvider.this.g().getString(R$string.share_failed_tips));
                } else {
                    com.tn.lib.widget.toast.core.h.f50034a.l(TaskInviteUserProvider.this.g().getString(R$string.share_canceled_tips));
                }
            } catch (Exception unused) {
            }
        }
    }

    public TaskInviteUserProvider(MemberFragment fragment, MemberViewModel viewModel) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(viewModel, "viewModel");
        this.f53232f = fragment;
        this.f53233g = viewModel;
        this.f53235i = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        b1.b<Intent> bVarRegisterForActivityResult = fragment.registerForActivityResult(new c1.j(), new c());
        Intrinsics.f(bVarRegisterForActivityResult, "fragment.registerForActi…eption) {\n        }\n    }");
        this.f53238l = bVarRegisterForActivityResult;
    }

    public static final void H(TextView this_apply, TaskInviteUserProvider this$0, MemberTaskItem item, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        if (com.transsion.baseui.util.c.f51452a.a(this_apply.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "task_invite_user_claim_all");
        linkedHashMap.put("index", "-1");
        Unit unit = Unit.f68710a;
        this$0.N(item, linkedHashMap);
        this$0.f53234h = true;
        MemberViewModel memberViewModel = this$0.f53233g;
        MemberTaskRewardInfo rewardInfo = item.getRewardInfo();
        memberViewModel.J(-1, "0", rewardInfo != null ? rewardInfo.getDuration() : 0, 1);
    }

    public static final void I(TextView this_apply, TaskInviteUserProvider this$0, MemberTaskItem item, View view) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        if (com.transsion.baseui.util.c.f51452a.a(this_apply.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "task_invite_user_share_dialog");
        ILoginApi iLoginApi = this$0.f53235i;
        boolean z11 = false;
        if (iLoginApi != null && iLoginApi.N()) {
            z11 = true;
        }
        linkedHashMap.put("is_login", String.valueOf(z11));
        Unit unit = Unit.f68710a;
        this$0.N(item, linkedHashMap);
        ILoginApi iLoginApi2 = this$0.f53235i;
        if (iLoginApi2 != null && iLoginApi2.N()) {
            this$0.f53236j = true;
            this$0.f53233g.H();
            return;
        }
        ILoginApi iLoginApi3 = this$0.f53235i;
        if (iLoginApi3 != null) {
            Context context = this_apply.getContext();
            Intrinsics.f(context, "context");
            iLoginApi3.w0(context);
        }
    }

    private final String K(String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f51450a.c(g(), str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f51450a.c(g(), str2)) {
            return null;
        }
        return str2;
    }

    private final void M(MemberTaskItem memberTaskItem) {
        HashMap map = new HashMap();
        map.put("event_type", "task_browse");
        map.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        map.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        map.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        Object obj = null;
        if (inviteList != null) {
            for (Object obj2 : inviteList) {
                if (((MemberTaskItemInvite) obj2).getStatus() == 1) {
                    obj = obj2;
                    break;
                }
            }
            obj = (MemberTaskItemInvite) obj;
        }
        map.put("showClaim", String.valueOf(obj == null));
        com.transsion.baselib.helper.a.f51183a.a("memberdetail", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(MemberTaskItem memberTaskItem, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("event_type", "task_click");
        map2.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        map2.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        map2.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        Object obj = null;
        if (inviteList != null) {
            for (Object obj2 : inviteList) {
                if (((MemberTaskItemInvite) obj2).getStatus() == 1) {
                    obj = obj2;
                    break;
                }
            }
            obj = (MemberTaskItemInvite) obj;
        }
        map2.put("showClaim", String.valueOf(obj == null));
        map2.putAll(map);
        com.transsion.baselib.helper.a.f51183a.b("memberdetail", map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String str) {
        zp.b.f82110a.g(R$layout.claim_succeed_layout, str, (8 & 4) != 0 ? 0 : 80, (8 & 8) != 0 ? 0 : 0, (8 & 16) != 0 ? 0 : f0.a(66.0f));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final MemberTaskItem item) {
        String string;
        Object objM163constructorimpl;
        List arrayList;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        M(item);
        final InviteUserView inviteUserView = (InviteUserView) helper.getView(R$id.task_invite_user_view);
        List data = inviteUserView.getData();
        List<MemberTaskItemInvite> inviteList = item.getInviteList();
        boolean zContainsAll = data.containsAll(inviteList != null ? inviteList : new ArrayList<>());
        boolean z11 = false;
        if (zContainsAll) {
            Integer num = this.f53237k;
            inviteUserView.setLoadMoreEnable(num == null || num.intValue() != 0);
        } else {
            List<MemberTaskItemInvite> inviteList2 = item.getInviteList();
            if (inviteList2 == null || (arrayList = CollectionsKt___CollectionsKt.J0(inviteList2)) == null) {
                arrayList = new ArrayList();
            }
            inviteUserView.setData(arrayList);
            this.f53237k = null;
            inviteUserView.setLoadMoreEnable(true);
        }
        inviteUserView.setDataViewBinder(new a(inviteUserView));
        inviteUserView.setItemClicker(new Function2<Integer, Integer, Unit>() { // from class: com.transsion.member.adapter.task.TaskInviteUserProvider$convert$inviteUserView$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num2, Integer num3) {
                invoke(num2.intValue(), num3.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11, int i12) {
                if (i12 != 2 || com.transsion.baseui.util.c.f51452a.a(inviteUserView.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                    return;
                }
                MemberTaskItem memberTaskItem = item;
                TaskInviteUserProvider taskInviteUserProvider = this;
                InviteUserView<MemberTaskItemInvite> inviteUserView2 = inviteUserView;
                try {
                    Result.Companion companion = Result.Companion;
                    List<MemberTaskItemInvite> inviteList3 = memberTaskItem.getInviteList();
                    List<MemberTaskItemInvite> list = inviteList3;
                    if (list != null && !list.isEmpty()) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("event_detail", "task_invite_user_claim_item");
                        linkedHashMap.put("index", String.valueOf(i11));
                        Unit unit = Unit.f68710a;
                        taskInviteUserProvider.N(memberTaskItem, linkedHashMap);
                        MemberTaskItemInvite memberTaskItemInvite = inviteList3.get(i11);
                        if (memberTaskItemInvite.getStatus() == 1) {
                            taskInviteUserProvider.f53234h = true;
                            inviteUserView2.notifyItemInviteUserStateChange(i11);
                            taskInviteUserProvider.L().J(i11, memberTaskItemInvite.getRewardId(), memberTaskItemInvite.getRewardAmount(), memberTaskItemInvite.getRewardType());
                        }
                    }
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        });
        final TextView textView = (TextView) helper.getView(R$id.claim_all_bt);
        MemberTaskRewardInfo rewardInfo = item.getRewardInfo();
        if (rewardInfo == null || rewardInfo.getDuration() == 0) {
            string = textView.getContext().getString(R$string.member_claim_all);
        } else {
            try {
                Result.Companion companion = Result.Companion;
                Context context = textView.getContext();
                int i11 = R$string.task_invite_user_view_get_premium_text;
                Object[] objArr = new Object[1];
                MemberTaskRewardInfo rewardInfo2 = item.getRewardInfo();
                objArr[0] = rewardInfo2 != null ? Integer.valueOf(rewardInfo2.getDuration()) : null;
                objM163constructorimpl = Result.m163constructorimpl(context.getString(i11, objArr));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            if (Result.m169isFailureimpl(objM163constructorimpl)) {
                objM163constructorimpl = null;
            }
            string = (String) objM163constructorimpl;
            if (string == null) {
                MemberTaskRewardInfo rewardInfo3 = item.getRewardInfo();
                String description = rewardInfo3 != null ? rewardInfo3.getDescription() : null;
                string = description == null ? "" : description;
            }
        }
        textView.setText(string);
        MemberTaskRewardInfo rewardInfo4 = item.getRewardInfo();
        if (rewardInfo4 != null && rewardInfo4.getDuration() > 0) {
            z11 = true;
        }
        textView.setEnabled(z11);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.adapter.task.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskInviteUserProvider.H(textView, this, item, view);
            }
        });
        final TextView textView2 = (TextView) helper.getView(R$id.invite_tips_bt);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.adapter.task.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskInviteUserProvider.I(textView2, this, item, view);
            }
        });
        this.f53233g.A().j(this.f53232f.getViewLifecycleOwner(), new b(new Function1<su.d, Unit>() { // from class: com.transsion.member.adapter.task.TaskInviteUserProvider$convert$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(su.d dVar) {
                invoke2(dVar);
                return Unit.f68710a;
            }

            /* JADX WARN: Code duplicated, block: B:67:0x020f  */
            /* JADX WARN: Code duplicated, block: B:68:0x0211  */
            /* JADX WARN: Code duplicated, block: B:71:0x0216  */
            /* JADX WARN: Code duplicated, block: B:72:0x021b  */
            /* JADX WARN: Code duplicated, block: B:76:0x0226  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(su.d dVar) {
                boolean z12;
                Object objM163constructorimpl2;
                Object obj;
                String str;
                String description2;
                Object next;
                if (this.this$0.f53234h) {
                    this.this$0.f53234h = false;
                    List<MemberTaskItemInvite> inviteList3 = item.getInviteList();
                    if (inviteList3 == null || inviteList3.isEmpty()) {
                        return;
                    }
                    int iA = dVar.a();
                    String strD = dVar.d();
                    int iC = dVar.c();
                    int iE = dVar.e();
                    MemberTaskRewardInfo memberTaskRewardInfoB = dVar.b();
                    int iAbs = Math.abs(iA);
                    if (!Intrinsics.b(strD, "0")) {
                        if (iA < 0 || memberTaskRewardInfoB == null) {
                            TaskInviteUserProvider taskInviteUserProvider = this.this$0;
                            MemberTaskItem memberTaskItem = item;
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("event_detail", "task_invite_user_claim_item_fail");
                            linkedHashMap.put("index", String.valueOf(iA));
                            linkedHashMap.put("rewardId", strD.toString());
                            Unit unit = Unit.f68710a;
                            taskInviteUserProvider.N(memberTaskItem, linkedHashMap);
                            TaskInviteUserProvider taskInviteUserProvider2 = this.this$0;
                            String string2 = taskInviteUserProvider2.g().getString(R$string.member_reward_receive_fault_tips);
                            Intrinsics.f(string2, "context.getString(\n     …                        )");
                            taskInviteUserProvider2.O(string2);
                        } else {
                            TaskInviteUserProvider taskInviteUserProvider3 = this.this$0;
                            MemberTaskItem memberTaskItem2 = item;
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            linkedHashMap2.put("event_detail", "task_invite_user_claim_item_success");
                            linkedHashMap2.put("index", String.valueOf(iA));
                            linkedHashMap2.put("rewardId", strD.toString());
                            linkedHashMap2.put("rewardRes", memberTaskRewardInfoB.toString());
                            Unit unit2 = Unit.f68710a;
                            taskInviteUserProvider3.N(memberTaskItem2, linkedHashMap2);
                            List<MemberTaskItemInvite> inviteList4 = item.getInviteList();
                            if (inviteList4 != null) {
                                Iterator<T> it = inviteList4.iterator();
                                do {
                                    if (!it.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it.next();
                                } while (!Intrinsics.b(((MemberTaskItemInvite) next).getRewardId(), strD));
                                MemberTaskItemInvite memberTaskItemInvite = (MemberTaskItemInvite) next;
                                if (memberTaskItemInvite != null) {
                                    MemberTaskItem memberTaskItem3 = item;
                                    memberTaskItemInvite.setStatus(2);
                                    List<MemberTaskItemInvite> inviteList5 = memberTaskItem3.getInviteList();
                                    iAbs = inviteList5 != null ? inviteList5.indexOf(memberTaskItemInvite) : 0;
                                }
                            }
                            TaskInviteUserProvider taskInviteUserProvider4 = this.this$0;
                            String string3 = taskInviteUserProvider4.g().getString(iE == 1 ? R$string.member_claimed_succeed_days : R$string.member_reward_points_receive_tips, Integer.valueOf(iC));
                            Intrinsics.f(string3, "context.getString(\n     …                        )");
                            taskInviteUserProvider4.O(string3);
                        }
                        inviteUserView.notifyItemInviteUserStateChange(iAbs);
                    } else if (memberTaskRewardInfoB == null) {
                        TaskInviteUserProvider taskInviteUserProvider5 = this.this$0;
                        String string4 = taskInviteUserProvider5.g().getString(R$string.member_reward_receive_fault_tips);
                        Intrinsics.f(string4, "context.getString(\n     …                        )");
                        taskInviteUserProvider5.O(string4);
                        TaskInviteUserProvider taskInviteUserProvider6 = this.this$0;
                        MemberTaskItem memberTaskItem4 = item;
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap3.put("event_detail", "task_invite_user_claim_all_fail");
                        linkedHashMap3.put("index", String.valueOf(iA));
                        linkedHashMap3.put("rewardId", strD.toString());
                        Unit unit3 = Unit.f68710a;
                        taskInviteUserProvider6.N(memberTaskItem4, linkedHashMap3);
                    } else {
                        TaskInviteUserProvider taskInviteUserProvider7 = this.this$0;
                        MemberTaskItem memberTaskItem5 = item;
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                        linkedHashMap4.put("event_detail", "task_invite_user_claim_all_success");
                        linkedHashMap4.put("index", String.valueOf(iA));
                        linkedHashMap4.put("rewardId", strD.toString());
                        linkedHashMap4.put("rewardRes", memberTaskRewardInfoB.toString());
                        Unit unit4 = Unit.f68710a;
                        taskInviteUserProvider7.N(memberTaskItem5, linkedHashMap4);
                        List<MemberTaskItemInvite> inviteList6 = item.getInviteList();
                        if (inviteList6 != null) {
                            for (MemberTaskItemInvite memberTaskItemInvite2 : inviteList6) {
                                if (memberTaskItemInvite2.getStatus() == 1) {
                                    memberTaskItemInvite2.setStatus(2);
                                }
                            }
                        }
                        TaskInviteUserProvider taskInviteUserProvider8 = this.this$0;
                        String string5 = taskInviteUserProvider8.g().getString(R$string.member_claimed_succeed_days, Integer.valueOf(iC));
                        Intrinsics.f(string5, "context.getString(\n     …                        )");
                        taskInviteUserProvider8.O(string5);
                        inviteUserView.notifyAllItemInviteUserStateChange();
                    }
                    if (memberTaskRewardInfoB != null) {
                        MemberTaskItem memberTaskItem6 = item;
                        TextView textView3 = textView;
                        TaskInviteUserProvider taskInviteUserProvider9 = this.this$0;
                        memberTaskItem6.setRewardInfo(memberTaskRewardInfoB);
                        if (memberTaskRewardInfoB.getDuration() == 0) {
                            description2 = taskInviteUserProvider9.g().getString(R$string.member_claim_all);
                            z12 = true;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                Context contextG = taskInviteUserProvider9.g();
                                int i12 = R$string.task_invite_user_view_get_premium_text;
                                z12 = true;
                                try {
                                    Object[] objArr2 = new Object[1];
                                    try {
                                        objArr2[0] = Integer.valueOf(memberTaskRewardInfoB.getDuration());
                                        objM163constructorimpl2 = Result.m163constructorimpl(contextG.getString(i12, objArr2));
                                    } catch (Throwable th3) {
                                        th = th3;
                                        Result.Companion companion4 = Result.Companion;
                                        objM163constructorimpl2 = Result.m163constructorimpl(ResultKt.a(th));
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    Result.Companion companion5 = Result.Companion;
                                    objM163constructorimpl2 = Result.m163constructorimpl(ResultKt.a(th));
                                    if (Result.m169isFailureimpl(objM163constructorimpl2)) {
                                        obj = null;
                                    } else {
                                        obj = objM163constructorimpl2;
                                    }
                                    str = (String) obj;
                                    if (str == null) {
                                        description2 = memberTaskRewardInfoB.getDescription();
                                    } else {
                                        description2 = str;
                                    }
                                    textView3.setText(description2);
                                    if (memberTaskRewardInfoB.getDuration() <= 0) {
                                        z12 = false;
                                    }
                                    textView3.setEnabled(z12);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                z12 = true;
                            }
                            if (Result.m169isFailureimpl(objM163constructorimpl2)) {
                                obj = null;
                            } else {
                                obj = objM163constructorimpl2;
                            }
                            str = (String) obj;
                            if (str == null) {
                                description2 = memberTaskRewardInfoB.getDescription();
                            } else {
                                description2 = str;
                            }
                        }
                        textView3.setText(description2);
                        if (memberTaskRewardInfoB.getDuration() <= 0) {
                            z12 = false;
                        }
                        textView3.setEnabled(z12);
                    }
                }
            }
        }));
        this.f53233g.r().j(this.f53232f.getViewLifecycleOwner(), new b(new Function1<MemberTaskInviteRewards, Unit>() { // from class: com.transsion.member.adapter.task.TaskInviteUserProvider$convert$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MemberTaskInviteRewards memberTaskInviteRewards) {
                invoke2(memberTaskInviteRewards);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MemberTaskInviteRewards memberTaskInviteRewards) {
                List<MemberTaskItemInvite> list;
                if (inviteUserView.isLoadingMoreState()) {
                    if (memberTaskInviteRewards == null || (list = memberTaskInviteRewards.getList()) == null || list.isEmpty()) {
                        inviteUserView.onLoadMoreCompleted(new ArrayList());
                        inviteUserView.setLoadMoreEnable(false);
                        return;
                    }
                    this.f53237k = Integer.valueOf(memberTaskInviteRewards.getLastId());
                    List<MemberTaskItemInvite> list2 = memberTaskInviteRewards.getList();
                    if (list2 == null || list2.isEmpty()) {
                        inviteUserView.onLoadMoreCompleted(new ArrayList());
                    } else {
                        List<MemberTaskItemInvite> list3 = memberTaskInviteRewards.getList();
                        if (list3 != null) {
                            MemberTaskItem memberTaskItem = item;
                            InviteUserView<MemberTaskItemInvite> inviteUserView2 = inviteUserView;
                            List<MemberTaskItemInvite> list4 = list3;
                            if (!list4.isEmpty()) {
                                List<MemberTaskItemInvite> inviteList3 = memberTaskItem.getInviteList();
                                if (inviteList3 != null) {
                                    inviteList3.addAll(list4);
                                }
                                inviteUserView2.onLoadMoreCompleted(list3);
                            } else {
                                inviteUserView2.onLoadMoreCompleted(new ArrayList());
                            }
                        }
                    }
                    if (memberTaskInviteRewards.getLastId() == 0) {
                        inviteUserView.setLoadMoreEnable(false);
                    }
                }
            }
        }));
        this.f53233g.w().j(this.f53232f.getViewLifecycleOwner(), new b(new Function1<Map<String, ? extends MemberInviteUserShareInfo>, Unit>() { // from class: com.transsion.member.adapter.task.TaskInviteUserProvider$convert$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends MemberInviteUserShareInfo> map) throws JSONException {
                invoke2((Map<String, MemberInviteUserShareInfo>) map);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, MemberInviteUserShareInfo> it) throws JSONException {
                String string2;
                MemberInviteUserShareInfo value;
                if (this.this$0.f53236j) {
                    if (it.isEmpty()) {
                        TaskInviteUserProvider taskInviteUserProvider = this.this$0;
                        String string3 = taskInviteUserProvider.g().getString(com.tn.lib.widget.R$string.load_failed);
                        Intrinsics.f(string3, "context.getString(\n     …                        )");
                        taskInviteUserProvider.O(string3);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    Intrinsics.f(it, "it");
                    loop0: while (true) {
                        string2 = "";
                        for (Map.Entry<String, MemberInviteUserShareInfo> entry : it.entrySet()) {
                            String key = entry.getKey();
                            MemberInviteUserShareInfo value2 = entry.getValue();
                            String desc = value2 != null ? value2.getDesc() : null;
                            MemberInviteUserShareInfo value3 = entry.getValue();
                            jSONObject.put(key, desc + ", " + (value3 != null ? value3.getUrl() : null));
                            if (string2.length() != 0 || ((value = entry.getValue()) != null && (string2 = value.getTitle()) != null)) {
                            }
                        }
                        break loop0;
                    }
                    jSONObject.put("H5Source", "fissionNative");
                    TaskInviteUserProvider taskInviteUserProvider2 = this.this$0;
                    if (string2.length() == 0) {
                        string2 = taskInviteUserProvider2.g().getString(R$string.member_invite_user_share_title);
                        Intrinsics.f(string2, "context.getString(R.stri…_invite_user_share_title)");
                    }
                    jSONObject.put(CampaignEx.JSON_KEY_TITLE, string2);
                    WebShareDialog.a aVar = WebShareDialog.f60210h;
                    String string4 = jSONObject.toString();
                    Intrinsics.f(string4, "info.toString()");
                    final WebShareDialog webShareDialogA = aVar.a(string4);
                    final TaskInviteUserProvider taskInviteUserProvider3 = this.this$0;
                    webShareDialogA.q0(new Function3<String, String, String, Unit>() { // from class: com.transsion.member.adapter.task.TaskInviteUserProvider$convert$4$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3) {
                            invoke2(str, str2, str3);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String packageName, String str, String txt) {
                            Intrinsics.g(packageName, "packageName");
                            Intrinsics.g(txt, "txt");
                            if (packageName.length() == 0) {
                                ClipData clipDataNewPlainText = ClipData.newPlainText("MovieBox", txt);
                                Context context2 = webShareDialogA.getContext();
                                ClipboardManager clipboardManager = (ClipboardManager) (context2 != null ? context2.getSystemService("clipboard") : null);
                                if (clipboardManager != null) {
                                    clipboardManager.setPrimaryClip(clipDataNewPlainText);
                                }
                                com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.web.R$string.web_copied);
                                return;
                            }
                            Intent intentJ = taskInviteUserProvider3.J(webShareDialogA.getContext(), txt, packageName, str);
                            if (intentJ == null) {
                                com.tn.lib.widget.toast.core.h.f50034a.k(com.transsion.web.R$string.web_app_not_exist);
                                return;
                            }
                            TaskInviteUserProvider taskInviteUserProvider4 = taskInviteUserProvider3;
                            try {
                                Result.Companion companion3 = Result.Companion;
                                taskInviteUserProvider4.f53238l.a(intentJ);
                                Result.m163constructorimpl(Unit.f68710a);
                            } catch (Throwable th3) {
                                Result.Companion companion4 = Result.Companion;
                                Result.m163constructorimpl(ResultKt.a(th3));
                            }
                        }
                    });
                    webShareDialogA.j0(this.this$0.g(), "WebShareDialog");
                    TaskInviteUserProvider taskInviteUserProvider4 = this.this$0;
                    taskInviteUserProvider4.f53236j = !taskInviteUserProvider4.f53236j;
                }
            }
        }));
    }

    public final Intent J(Context context, String str, String str2, String str3) {
        String strK = K(str2, str3);
        if (strK == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(strK);
        return intent;
    }

    public final MemberViewModel L() {
        return this.f53233g;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.INVITE_USER.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_task_invite_user_container;
    }
}
