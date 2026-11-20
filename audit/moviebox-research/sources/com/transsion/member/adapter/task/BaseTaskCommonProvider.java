package com.transsion.member.adapter.task;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.widget.R$color;
import com.transsion.member.MemberFragment;
import com.transsion.member.R$drawable;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.TaskRewards;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseTaskCommonProvider extends BaseItemProvider<MemberTaskItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MemberFragment f53221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f53222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f53223h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a extends zo.a<TaskRewards> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            BaseTaskCommonProvider.this.x().p1();
            zp.b.f82110a.e(BaseTaskCommonProvider.this.g().getString(R$string.member_reward_points_failed_tips));
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TaskRewards taskRewards) {
            int i11;
            List<MemberTaskItem> listD;
            MemberTaskItem memberTaskItem;
            Integer rewardAmount;
            Integer currentPoint;
            List<MemberTaskItem> listD2;
            List<MemberTaskItem> listD3;
            MemberTaskItem memberTaskItem2;
            MemberTaskItem taskInfo;
            BaseTaskCommonProvider.this.x().p1();
            BaseProviderMultiAdapter<MemberTaskItem> baseProviderMultiAdapterC = BaseTaskCommonProvider.this.c();
            if (baseProviderMultiAdapterC == null || (listD2 = baseProviderMultiAdapterC.D()) == null) {
                i11 = 0;
            } else {
                BaseTaskCommonProvider baseTaskCommonProvider = BaseTaskCommonProvider.this;
                int i12 = 0;
                i11 = 0;
                for (Object obj : listD2) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.g.u();
                    }
                    MemberTaskItem memberTaskItem3 = (MemberTaskItem) obj;
                    if (Intrinsics.b(memberTaskItem3.getTaskId(), (taskRewards == null || (taskInfo = taskRewards.getTaskInfo()) == null) ? null : taskInfo.getTaskId()) && memberTaskItem3.getTaskId() != null) {
                        MemberTaskItem taskInfo2 = taskRewards != null ? taskRewards.getTaskInfo() : null;
                        BaseProviderMultiAdapter<MemberTaskItem> baseProviderMultiAdapterC2 = baseTaskCommonProvider.c();
                        if (baseProviderMultiAdapterC2 != null && (listD3 = baseProviderMultiAdapterC2.D()) != null && (memberTaskItem2 = listD3.get(i12)) != null) {
                            memberTaskItem2.setStatus(taskInfo2 != null ? taskInfo2.getStatus() : null);
                            memberTaskItem2.setProgress(taskInfo2 != null ? taskInfo2.getProgress() : null);
                            memberTaskItem2.setTotalProgress(taskInfo2 != null ? taskInfo2.getTotalProgress() : null);
                        }
                        i11 = i12;
                    }
                    i12 = i13;
                }
            }
            if (taskRewards != null && (currentPoint = taskRewards.getCurrentPoint()) != null) {
                BaseTaskCommonProvider.this.x().N1(currentPoint.intValue());
            }
            BaseProviderMultiAdapter<MemberTaskItem> baseProviderMultiAdapterC3 = BaseTaskCommonProvider.this.c();
            int iIntValue = (baseProviderMultiAdapterC3 == null || (listD = baseProviderMultiAdapterC3.D()) == null || (memberTaskItem = listD.get(i11)) == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 0 : rewardAmount.intValue();
            zp.b.a aVar = zp.b.f82110a;
            int i14 = R$layout.claim_succeed_layout;
            String string = BaseTaskCommonProvider.this.g().getString(R$string.member_reward_points_receive_tips, Integer.valueOf(iIntValue));
            Intrinsics.f(string, "context.getString(R.stri…ceive_tips, rewardAmount)");
            aVar.g(i14, string, (8 & 4) != 0 ? 0 : 80, (8 & 8) != 0 ? 0 : 0, (8 & 16) != 0 ? 0 : f0.a(66.0f));
            BaseTaskCommonProvider.this.D();
            BaseProviderMultiAdapter<MemberTaskItem> baseProviderMultiAdapterC4 = BaseTaskCommonProvider.this.c();
            if (baseProviderMultiAdapterC4 != null) {
                baseProviderMultiAdapterC4.notifyItemChanged(i11);
            }
        }
    }

    public BaseTaskCommonProvider(MemberFragment fragment) {
        Intrinsics.g(fragment, "fragment");
        this.f53221f = fragment;
        this.f53222g = LazyKt__LazyJVMKt.b(new Function0<pu.a>() { // from class: com.transsion.member.adapter.task.BaseTaskCommonProvider$memberApi$2
            @Override // kotlin.jvm.functions.Function0
            public final pu.a invoke() {
                return (pu.a) NetServiceGenerator.f49399d.a().i(pu.a.class);
            }
        });
    }

    public static final void w(BaseTaskCommonProvider this$0, MemberTaskItem item, View view) throws JSONException {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        if (com.transsion.baseui.util.c.f51452a.a(R$id.member_item_task_button, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        if (this$0.C(item)) {
            this$0.G(item);
        } else {
            Intrinsics.e(view, "null cannot be cast to non-null type android.widget.TextView");
            this$0.H((TextView) view, item);
        }
        this$0.F(item);
    }

    private final int z() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? GravityCompat.END : GravityCompat.START;
    }

    public String A(MemberTaskItem item) {
        Intrinsics.g(item, "item");
        String title = item.getTitle();
        return title == null ? "" : title;
    }

    public void B(TextView button, MemberTaskItem item) {
        Intrinsics.g(button, "button");
        Intrinsics.g(item, "item");
        this.f53223h = C(item);
        Integer status = item.getStatus();
        if (status != null && status.intValue() == 3) {
            button.setText(g().getString(R$string.member_claimed));
            button.setEnabled(false);
            button.setAlpha(0.5f);
            button.setTextColor(z2.a.getColor(g(), R$color.gray_dark_00));
            button.setBackgroundResource(R$drawable.bg_member_btn_6_normal);
            return;
        }
        if (this.f53223h) {
            button.setText(button.getContext().getString(R$string.member_claim));
            button.setEnabled(true);
            button.setAlpha(1.0f);
            button.setTextColor(z2.a.getColor(g(), R$color.gray_dark_00));
            button.setBackgroundResource(R$drawable.bg_member_btn_6_normal);
            return;
        }
        button.setText(item.getButtonName());
        button.setEnabled(true);
        button.setAlpha(1.0f);
        button.setTextColor(z2.a.getColor(g(), R$color.yellow_50));
        button.setBackgroundResource(R$drawable.bg_member_btn_white_6);
    }

    public boolean C(MemberTaskItem memberTaskItem) {
        return false;
    }

    public void D() {
    }

    public final void E(MemberTaskItem memberTaskItem) {
        HashMap map = new HashMap();
        map.put("event_type", "task_browse");
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        map.put("taskId", taskId);
        map.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        map.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        map.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        map.put("showClaim", String.valueOf(this.f53223h));
        com.transsion.baselib.helper.a.f51183a.a("memberdetail", map);
    }

    public final void F(MemberTaskItem memberTaskItem) {
        HashMap map = new HashMap();
        map.put("event_type", "task_click");
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        map.put("taskId", taskId);
        map.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        map.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        map.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        map.put("showClaim", String.valueOf(this.f53223h));
        com.transsion.baselib.helper.a.f51183a.b("memberdetail", map);
    }

    public final void G(MemberTaskItem memberTaskItem) throws JSONException {
        this.f53221f.O1();
        JSONObject jSONObject = new JSONObject();
        String taskId = memberTaskItem.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        jSONObject.put("taskId", taskId);
        RequestBody.Companion companion = RequestBody.Companion;
        String string = jSONObject.toString();
        Intrinsics.f(string, "json.toString()");
        pu.a.C0809a.j(y(), null, companion.create(string, MediaType.Companion.parse("application/json")), 1, null).e(zo.d.f82109a.c()).subscribe(new a());
    }

    public abstract void H(TextView textView, MemberTaskItem memberTaskItem);

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_task_common;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final MemberTaskItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        int i11 = R$id.member_item_task_points_icon;
        Integer rewardType = item.getRewardType();
        helper.setImageResource(i11, (rewardType != null && rewardType.intValue() == 1) ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
        helper.setText(R$id.member_item_task_points_text, "+" + item.getRewardAmount());
        TextView textView = (TextView) helper.getView(R$id.member_item_task_title);
        textView.setText(A(item));
        textView.setGravity(z());
        TextView textView2 = (TextView) helper.getView(R$id.member_item_task_button);
        B(textView2, item);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.adapter.task.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                BaseTaskCommonProvider.w(this.f53243a, item, view);
            }
        });
        E(item);
    }

    public final MemberFragment x() {
        return this.f53221f;
    }

    public final pu.a y() {
        return (pu.a) this.f53222g.getValue();
    }
}
