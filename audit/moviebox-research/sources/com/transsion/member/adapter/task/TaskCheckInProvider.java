package com.transsion.member.adapter.task;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.d0;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.constants.TaskType;
import com.transsion.member.view.CheckInView;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class TaskCheckInProvider extends BaseItemProvider<MemberTaskItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f53225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MemberViewModel f53226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f53227h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements CheckInView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MemberTaskItem f53228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskCheckInProvider f53229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CheckInView f53230c;

        public a(MemberTaskItem memberTaskItem, TaskCheckInProvider taskCheckInProvider, CheckInView checkInView) {
            this.f53228a = memberTaskItem;
            this.f53229b = taskCheckInProvider;
            this.f53230c = checkInView;
        }

        @Override // com.transsion.member.view.CheckInView.d
        @SuppressLint({"SetTextI18n"})
        public void a(CheckInView.b holder, int i11) {
            Intrinsics.g(holder, "holder");
            List<MemberTaskItemCheckInInfo> checkInList = this.f53228a.getCheckInList();
            List<MemberTaskItemCheckInInfo> list = checkInList;
            if (list == null || list.isEmpty()) {
                return;
            }
            ImageView imageView = (ImageView) holder.itemView.findViewById(R$id.tag_iv);
            TextView textView = (TextView) holder.itemView.findViewById(R$id.member_point);
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i11);
            if (textView != null) {
                textView.setText("+" + memberTaskItemCheckInInfo.getRewardAmount() + (memberTaskItemCheckInInfo.getRewardType() == 1 ? "days" : ""));
            }
            if (holder.e() == 2 || holder.e() == 5) {
                if (memberTaskItemCheckInInfo.isToday() && this.f53229b.f53227h) {
                    View viewFindViewById = holder.itemView.findViewById(R$id.member_check_in_tv);
                    if (viewFindViewById != null) {
                        so.c.g(viewFindViewById);
                    }
                    View viewFindViewById2 = holder.itemView.findViewById(R$id.member_check_in_pb);
                    if (viewFindViewById2 != null) {
                        so.c.k(viewFindViewById2);
                    }
                } else {
                    View viewFindViewById3 = holder.itemView.findViewById(R$id.member_check_in_tv);
                    if (viewFindViewById3 != null) {
                        so.c.k(viewFindViewById3);
                    }
                    View viewFindViewById4 = holder.itemView.findViewById(R$id.member_check_in_pb);
                    if (viewFindViewById4 != null) {
                        so.c.g(viewFindViewById4);
                    }
                }
            }
            if (imageView != null) {
                imageView.setImageResource(memberTaskItemCheckInInfo.getRewardType() == 1 ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
            }
            TextView textView2 = (TextView) holder.itemView.findViewById(R$id.member_check_in);
            if (textView2 == null) {
                return;
            }
            textView2.setText((holder.e() == 5 || holder.e() == 2) ? this.f53230c.getContext().getString(R$string.member_claim) : this.f53230c.getContext().getString(R$string.member_task_day_tip, Integer.valueOf(i11 + 1)));
        }

        @Override // com.transsion.member.view.CheckInView.d
        public int b(int i11) {
            List<MemberTaskItemCheckInInfo> checkInList = this.f53228a.getCheckInList();
            List<MemberTaskItemCheckInInfo> list = checkInList;
            if (list == null || list.isEmpty()) {
                return 2;
            }
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i11);
            boolean z11 = i11 == checkInList.size() - 1;
            if (memberTaskItemCheckInInfo.getHasCheckIn()) {
                return z11 ? 4 : 1;
            }
            if (memberTaskItemCheckInInfo.isToday()) {
                return z11 ? 5 : 2;
            }
            return z11 ? 6 : 3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53231a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53231a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53231a;
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
            this.f53231a.invoke(obj);
        }
    }

    public TaskCheckInProvider(u owner, MemberViewModel viewModel) {
        Intrinsics.g(owner, "owner");
        Intrinsics.g(viewModel, "viewModel");
        this.f53225f = owner;
        this.f53226g = viewModel;
    }

    private final void A(MemberTaskItem memberTaskItem) {
        HashMap map = new HashMap();
        map.put("event_type", "task_browse");
        map.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        map.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        map.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        Object obj = null;
        if (checkInList != null) {
            for (Object obj2 : checkInList) {
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj2;
                if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                    obj = obj2;
                    break;
                }
            }
            obj = (MemberTaskItemCheckInInfo) obj;
        }
        map.put("showClaim", String.valueOf(obj == null));
        com.transsion.baselib.helper.a.f51183a.a("memberdetail", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String str) {
        zp.b.f82110a.g(R$layout.claim_succeed_layout, str, (8 & 4) != 0 ? 0 : 80, (8 & 8) != 0 ? 0 : 0, (8 & 16) != 0 ? 0 : f0.a(66.0f));
    }

    public final void B(MemberTaskItem memberTaskItem, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("event_type", "task_click");
        map2.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        map2.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        map2.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
        Object obj = null;
        if (checkInList != null) {
            for (Object obj2 : checkInList) {
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj2;
                if (memberTaskItemCheckInInfo.isToday() && !memberTaskItemCheckInInfo.getHasCheckIn()) {
                    obj = obj2;
                    break;
                }
            }
            obj = (MemberTaskItemCheckInInfo) obj;
        }
        map2.put("showClaim", String.valueOf(obj == null));
        map2.putAll(map);
        com.transsion.baselib.helper.a.f51183a.b("memberdetail", map2);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return TaskType.CHECK_IN.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_task_check_in_container;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final MemberTaskItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        A(item);
        final CheckInView checkInView = (CheckInView) helper.getView(R$id.member_check_in_view);
        checkInView.setDataViewBinder(new a(item, this, checkInView));
        checkInView.setItemClicker(new Function2<Integer, Integer, Unit>() { // from class: com.transsion.member.adapter.task.TaskCheckInProvider$convert$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11, int i12) {
                if ((i12 == 2 || i12 == 5) && !com.transsion.baseui.util.c.f51452a.a(checkInView.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                    MemberTaskItem memberTaskItem = item;
                    TaskCheckInProvider taskCheckInProvider = this;
                    CheckInView checkInView2 = checkInView;
                    try {
                        Result.Companion companion = Result.Companion;
                        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
                        List<MemberTaskItemCheckInInfo> list = checkInList;
                        if (list != null && !list.isEmpty()) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("event_detail", "task_check_in_item");
                            linkedHashMap.put("index", String.valueOf(i11));
                            Unit unit = Unit.f68710a;
                            taskCheckInProvider.B(memberTaskItem, linkedHashMap);
                            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList.get(i11);
                            if (memberTaskItemCheckInInfo.getHasCheckIn() || !memberTaskItemCheckInInfo.isToday()) {
                                checkInView2.notifyItemCheckInStateChange(i11);
                            } else {
                                taskCheckInProvider.f53227h = true;
                                checkInView2.notifyItemCheckInStateChange(i11);
                                taskCheckInProvider.f53226g.I(i11);
                            }
                        }
                        Result.m163constructorimpl(Unit.f68710a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m163constructorimpl(ResultKt.a(th2));
                    }
                }
            }
        });
        checkInView.notifyAllChange();
        this.f53226g.z().j(this.f53225f, new b(new Function1<Pair<? extends Integer, ? extends MemberTaskSubmitCheckInRes>, Unit>() { // from class: com.transsion.member.adapter.task.TaskCheckInProvider$convert$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends MemberTaskSubmitCheckInRes> pair) {
                invoke2((Pair<Integer, MemberTaskSubmitCheckInRes>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Integer, MemberTaskSubmitCheckInRes> pair) {
                if (this.this$0.f53227h) {
                    this.this$0.f53227h = false;
                    List<MemberTaskItemCheckInInfo> checkInList = item.getCheckInList();
                    if (checkInList == null || checkInList.isEmpty()) {
                        return;
                    }
                    int iIntValue = pair.getFirst().intValue();
                    MemberTaskSubmitCheckInRes second = pair.getSecond();
                    if (second != null) {
                        TaskCheckInProvider taskCheckInProvider = this.this$0;
                        MemberTaskItem memberTaskItem = item;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("event_detail", "task_check_in_item_success");
                        linkedHashMap.put("index", String.valueOf(iIntValue));
                        Unit unit = Unit.f68710a;
                        taskCheckInProvider.B(memberTaskItem, linkedHashMap);
                        List<MemberTaskItemCheckInInfo> checkInList2 = item.getCheckInList();
                        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = null;
                        Object obj = null;
                        if (checkInList2 != null) {
                            for (Object obj2 : checkInList2) {
                                if (((MemberTaskItemCheckInInfo) obj2).isToday()) {
                                    obj = obj2;
                                    break;
                                }
                            }
                            memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) obj;
                        }
                        if (memberTaskItemCheckInInfo != null) {
                            memberTaskItemCheckInInfo.setHasCheckIn(true);
                        }
                        TaskCheckInProvider taskCheckInProvider2 = this.this$0;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                        String string = checkInView.getContext().getString(second.getRewardType() == 1 ? R$string.member_claimed_succeed_days : R$string.member_reward_points_receive_tips);
                        Intrinsics.f(string, "context.getString(\n     …                        )");
                        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(second.getRewardAmount())}, 1));
                        Intrinsics.f(str, "format(...)");
                        taskCheckInProvider2.C(str);
                    } else {
                        TaskCheckInProvider taskCheckInProvider3 = this.this$0;
                        MemberTaskItem memberTaskItem2 = item;
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("event_detail", "task_check_in_item_fail");
                        linkedHashMap2.put("index", String.valueOf(iIntValue));
                        Unit unit2 = Unit.f68710a;
                        taskCheckInProvider3.B(memberTaskItem2, linkedHashMap2);
                        TaskCheckInProvider taskCheckInProvider4 = this.this$0;
                        String string2 = checkInView.getContext().getString(R$string.member_reward_receive_fault_tips);
                        Intrinsics.f(string2, "context.getString(\n     …                        )");
                        taskCheckInProvider4.C(string2);
                    }
                    checkInView.notifyItemCheckInStateChange(iIntValue);
                }
            }
        }));
    }
}
