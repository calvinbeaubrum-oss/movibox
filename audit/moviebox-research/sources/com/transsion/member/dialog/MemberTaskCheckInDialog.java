package com.transsion.member.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$style;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.member.MemberCheckInViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.view.CheckInView;
import com.transsion.member.view.GradientTextView;
import com.transsion.memberapi.MemberTaskCheckInInfo;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class MemberTaskCheckInDialog extends BaseDialog {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f53291m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f53292n = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qu.f f53293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53294d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f53295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f53296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f53297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MemberTaskCheckInInfo f53298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f53299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f53300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2<? super Boolean, ? super Boolean, Unit> f53301l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String b() {
            String str = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(Calendar.getInstance().getTimeInMillis() - ((long) 14400000)));
            Intrinsics.f(str, "SimpleDateFormat(\n      …() - 4 * 60 * 60 * 1000))");
            return str;
        }

        public final MemberTaskCheckInDialog c(int i11, MemberTaskCheckInInfo checkInInfo, Function1<? super Boolean, Unit> onCheckInDoneListener) {
            Intrinsics.g(checkInInfo, "checkInInfo");
            Intrinsics.g(onCheckInDoneListener, "onCheckInDoneListener");
            MemberTaskCheckInDialog memberTaskCheckInDialog = new MemberTaskCheckInDialog();
            memberTaskCheckInDialog.f53299j = onCheckInDoneListener;
            Bundle bundle = new Bundle();
            bundle.putInt("key_routetabid", i11);
            bundle.putSerializable("key_check_in_info", checkInInfo);
            memberTaskCheckInDialog.setArguments(bundle);
            return memberTaskCheckInDialog;
        }

        public final boolean d() {
            String string = RoomAppMMKV.f51271a.a().getString("key_member_task_check_in_show_time", "");
            return string == null || string.length() <= 0 || !Intrinsics.b(string, b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements CheckInView.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckInView f53303b;

        public b(CheckInView checkInView) {
            this.f53303b = checkInView;
        }

        @Override // com.transsion.member.view.CheckInView.d
        @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
        public void a(CheckInView.b holder, int i11) {
            List<MemberTaskItemCheckInInfo> checkInList;
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
            Intrinsics.g(holder, "holder");
            ImageView imageView = (ImageView) holder.itemView.findViewById(R$id.tag_iv);
            TextView textView = (TextView) holder.itemView.findViewById(R$id.member_point);
            MemberTaskCheckInInfo memberTaskCheckInInfo = MemberTaskCheckInDialog.this.f53298i;
            if (memberTaskCheckInInfo == null || (checkInList = memberTaskCheckInInfo.getCheckInList()) == null || (memberTaskItemCheckInInfo = checkInList.get(i11)) == null) {
                return;
            }
            if (textView != null) {
                textView.setText("+" + memberTaskItemCheckInInfo.getRewardAmount());
            }
            if (holder.e() == 2 || holder.e() == 5) {
                if (memberTaskItemCheckInInfo.isToday() && MemberTaskCheckInDialog.this.f53296g) {
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
            textView2.setText(this.f53303b.getContext().getString(R$string.member_task_day_tip, Integer.valueOf(i11 + 1)));
        }

        @Override // com.transsion.member.view.CheckInView.d
        public int b(int i11) {
            List<MemberTaskItemCheckInInfo> checkInList;
            MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
            List<MemberTaskItemCheckInInfo> checkInList2;
            MemberTaskCheckInInfo memberTaskCheckInInfo = MemberTaskCheckInDialog.this.f53298i;
            if (memberTaskCheckInInfo == null || (checkInList = memberTaskCheckInInfo.getCheckInList()) == null || (memberTaskItemCheckInInfo = checkInList.get(i11)) == null) {
                return 5;
            }
            MemberTaskCheckInInfo memberTaskCheckInInfo2 = MemberTaskCheckInDialog.this.f53298i;
            boolean z11 = i11 == ((memberTaskCheckInInfo2 == null || (checkInList2 = memberTaskCheckInInfo2.getCheckInList()) == null) ? 0 : checkInList2.size()) - 1;
            if (memberTaskItemCheckInInfo.getHasCheckIn()) {
                return z11 ? 4 : 1;
            }
            if (memberTaskItemCheckInInfo.isToday()) {
                return z11 ? 5 : 2;
            }
            return z11 ? 6 : 3;
        }
    }

    public MemberTaskCheckInDialog() {
        super(R$layout.dialog_member_check_in_layout);
        this.f53294d = f53291m.b();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f53300k = FragmentViewModelLazyKt.a(this, Reflection.b(MemberCheckInViewModel.class), new Function0<x0>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final void A0(MemberTaskCheckInDialog this$0, CompoundButton compoundButton, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        this$0.f53295f = z11;
    }

    public static final void B0(MemberTaskCheckInDialog this$0, View view) {
        Context context;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (context = this$0.getContext()) == null) {
            return;
        }
        ArouterUtil.f51292a.b(context, "oneroom://com.community.oneroom?type=/main/tab&tabIndex=" + this$0.f53297h, null);
        this$0.dismissAllowingStateLoss();
    }

    public static final void C0(MemberTaskCheckInDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void initView() {
        AppCompatImageView appCompatImageView;
        GradientTextView gradientTextView;
        CheckBox checkBox;
        final CheckInView checkInView;
        D0(this.f53298i);
        qu.f fVar = this.f53293c;
        if (fVar != null && (checkInView = fVar.f74932g) != null) {
            checkInView.setDataViewBinder(new b(checkInView));
            checkInView.setItemClicker(new Function2<Integer, Integer, Unit>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog$initView$1$2
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
                    List<MemberTaskItemCheckInInfo> checkInList;
                    MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
                    List<MemberTaskItemCheckInInfo> checkInList2;
                    if ((i12 == 2 || i12 == 5) && !com.transsion.baseui.util.c.f51452a.a(checkInView.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                        MemberTaskCheckInDialog memberTaskCheckInDialog = this;
                        MemberTaskCheckInInfo memberTaskCheckInInfo = memberTaskCheckInDialog.f53298i;
                        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo2 = null;
                        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo3 = (memberTaskCheckInInfo == null || (checkInList2 = memberTaskCheckInInfo.getCheckInList()) == null) ? null : checkInList2.get(i11);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("event_detail", "task_check_in_item");
                        linkedHashMap.put("index", String.valueOf(i11));
                        Unit unit = Unit.f68710a;
                        memberTaskCheckInDialog.E0(memberTaskItemCheckInInfo3, linkedHashMap);
                        MemberTaskCheckInDialog memberTaskCheckInDialog2 = this;
                        try {
                            Result.Companion companion = Result.Companion;
                            MemberTaskCheckInInfo memberTaskCheckInInfo2 = memberTaskCheckInDialog2.f53298i;
                            if (memberTaskCheckInInfo2 != null && (checkInList = memberTaskCheckInInfo2.getCheckInList()) != null && (memberTaskItemCheckInInfo = checkInList.get(i11)) != null) {
                                if (!memberTaskItemCheckInInfo.getHasCheckIn() && memberTaskItemCheckInInfo.isToday()) {
                                    memberTaskCheckInDialog2.y0(i11);
                                }
                                memberTaskItemCheckInInfo2 = memberTaskItemCheckInInfo;
                            }
                            Result.m163constructorimpl(memberTaskItemCheckInInfo2);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            Result.m163constructorimpl(ResultKt.a(th2));
                        }
                    }
                }
            });
        }
        qu.f fVar2 = this.f53293c;
        if (fVar2 != null && (checkBox = fVar2.f74928b) != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.transsion.member.dialog.k
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    MemberTaskCheckInDialog.A0(this.f53323a, compoundButton, z11);
                }
            });
        }
        qu.f fVar3 = this.f53293c;
        if (fVar3 != null && (gradientTextView = fVar3.f74929c) != null) {
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberTaskCheckInDialog.B0(this.f53324a, view);
                }
            });
        }
        qu.f fVar4 = this.f53293c;
        if (fVar4 != null && (appCompatImageView = fVar4.f74931f) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberTaskCheckInDialog.C0(this.f53325a, view);
                }
            });
        }
        Bundle arguments = getArguments();
        this.f53297h = arguments != null ? arguments.getInt("key_routetabid") : 0;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("key_check_in_info") : null;
        Intrinsics.e(serializable, "null cannot be cast to non-null type com.transsion.memberapi.MemberTaskCheckInInfo");
        this.f53298i = (MemberTaskCheckInInfo) serializable;
        z0().e().j(getViewLifecycleOwner(), new c(new Function1<MemberTaskSubmitCheckInRes, Unit>() { // from class: com.transsion.member.dialog.MemberTaskCheckInDialog.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
                invoke2(memberTaskSubmitCheckInRes);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo;
                MemberTaskItemCheckInInfo memberTaskItemCheckInInfo2;
                CheckInView checkInView2;
                List<MemberTaskItemCheckInInfo> checkInList;
                Object next;
                String date;
                CheckInView checkInView3;
                String date2;
                List<MemberTaskItemCheckInInfo> checkInList2;
                Object next2;
                MemberTaskCheckInDialog.this.f53296g = false;
                MemberTaskCheckInInfo memberTaskCheckInInfo = MemberTaskCheckInDialog.this.f53298i;
                if (memberTaskCheckInInfo == null || (checkInList2 = memberTaskCheckInInfo.getCheckInList()) == null) {
                    memberTaskItemCheckInInfo = null;
                } else {
                    Iterator<T> it = checkInList2.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                    } while (!((MemberTaskItemCheckInInfo) next2).isToday());
                    memberTaskItemCheckInInfo = (MemberTaskItemCheckInInfo) next2;
                }
                String str = "";
                if (memberTaskSubmitCheckInRes == null) {
                    MemberTaskCheckInDialog memberTaskCheckInDialog = MemberTaskCheckInDialog.this;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("event_detail", "task_check_in_item_fail");
                    if (memberTaskItemCheckInInfo != null && (date2 = memberTaskItemCheckInInfo.getDate()) != null) {
                        str = date2;
                    }
                    linkedHashMap.put("date", str);
                    Unit unit = Unit.f68710a;
                    memberTaskCheckInDialog.E0(memberTaskItemCheckInInfo, linkedHashMap);
                    MemberTaskCheckInDialog memberTaskCheckInDialog2 = MemberTaskCheckInDialog.this;
                    try {
                        Result.Companion companion = Result.Companion;
                        qu.f fVar5 = memberTaskCheckInDialog2.f53293c;
                        if (fVar5 != null && (checkInView3 = fVar5.f74932g) != null) {
                            checkInView3.notifyAllChange();
                        }
                        String string = memberTaskCheckInDialog2.getString(R$string.member_reward_receive_fault_tips);
                        Intrinsics.f(string, "getString(\n             …                        )");
                        memberTaskCheckInDialog2.G0(string);
                        Result.m163constructorimpl(Unit.f68710a);
                        return;
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m163constructorimpl(ResultKt.a(th2));
                        return;
                    }
                }
                MemberTaskCheckInDialog memberTaskCheckInDialog3 = MemberTaskCheckInDialog.this;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("event_detail", "task_check_in_item_success");
                if (memberTaskItemCheckInInfo != null && (date = memberTaskItemCheckInInfo.getDate()) != null) {
                    str = date;
                }
                linkedHashMap2.put("date", str);
                Unit unit2 = Unit.f68710a;
                memberTaskCheckInDialog3.E0(memberTaskItemCheckInInfo, linkedHashMap2);
                MemberTaskCheckInDialog memberTaskCheckInDialog4 = MemberTaskCheckInDialog.this;
                try {
                    Result.Companion companion3 = Result.Companion;
                    MemberTaskCheckInInfo memberTaskCheckInInfo2 = memberTaskCheckInDialog4.f53298i;
                    if (memberTaskCheckInInfo2 == null || (checkInList = memberTaskCheckInInfo2.getCheckInList()) == null) {
                        memberTaskItemCheckInInfo2 = null;
                    } else {
                        Iterator<T> it2 = checkInList.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!((MemberTaskItemCheckInInfo) next).isToday());
                        memberTaskItemCheckInInfo2 = (MemberTaskItemCheckInInfo) next;
                    }
                    if (memberTaskItemCheckInInfo2 != null) {
                        memberTaskItemCheckInInfo2.setHasCheckIn(true);
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                    String string2 = memberTaskCheckInDialog4.getString((memberTaskItemCheckInInfo == null || memberTaskItemCheckInInfo.getRewardType() != 1) ? R$string.member_reward_points_receive_tips : R$string.member_claimed_succeed_days);
                    Intrinsics.f(string2, "getString(\n             …                        )");
                    Object[] objArr = new Object[1];
                    objArr[0] = memberTaskItemCheckInInfo != null ? Integer.valueOf(memberTaskItemCheckInInfo.getRewardAmount()) : null;
                    String str2 = String.format(string2, Arrays.copyOf(objArr, 1));
                    Intrinsics.f(str2, "format(...)");
                    memberTaskCheckInDialog4.G0(str2);
                    Function1 function1 = memberTaskCheckInDialog4.f53299j;
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                    memberTaskCheckInDialog4.f53296g = false;
                    qu.f fVar6 = memberTaskCheckInDialog4.f53293c;
                    if (fVar6 != null && (checkInView2 = fVar6.f74932g) != null) {
                        checkInView2.notifyAllChange();
                    }
                    memberTaskCheckInDialog4.dismissAllowingStateLoss();
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th3));
                }
            }
        }));
    }

    public final void D0(MemberTaskCheckInInfo memberTaskCheckInInfo) {
        HashMap map = new HashMap();
        map.put("event_type", "task_browse");
        map.put("taskSubType", PrepareException.ERROR_MANIFEST_INFO);
        map.put("showClaim", "true");
        com.transsion.baselib.helper.a.f51183a.a("member_check_in_dialog", map);
    }

    public final void E0(MemberTaskItemCheckInInfo memberTaskItemCheckInInfo, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("event_type", "task_click");
        map2.put("taskSubType", PrepareException.ERROR_MANIFEST_INFO);
        map2.put("rewardType", String.valueOf(memberTaskItemCheckInInfo != null ? Integer.valueOf(memberTaskItemCheckInInfo.getRewardType()) : null));
        map2.put("rewardAmount", String.valueOf(memberTaskItemCheckInInfo != null ? Integer.valueOf(memberTaskItemCheckInInfo.getRewardAmount()) : null));
        map2.putAll(map);
        com.transsion.baselib.helper.a.f51183a.b("member_check_in_dialog", map2);
    }

    public final MemberTaskCheckInDialog F0(Function2<? super Boolean, ? super Boolean, Unit> function2) {
        this.f53301l = function2;
        return this;
    }

    public final void G0(String str) {
        com.tn.lib.widget.toast.core.h.f50034a.l(str);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.f53295f) {
            RoomAppMMKV.f51271a.a().putString("key_member_task_check_in_show_time", this.f53294d);
        }
        Function2<? super Boolean, ? super Boolean, Unit> function2 = this.f53301l;
        if (function2 != null) {
            Boolean bool = Boolean.FALSE;
            function2.invoke(bool, bool);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Window window2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(true);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setCanceledOnTouchOutside(false);
        }
        ((ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class)).v1();
        this.f53293c = qu.f.a(view);
        initView();
        Function2<? super Boolean, ? super Boolean, Unit> function2 = this.f53301l;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, Boolean.TRUE);
        }
    }

    public final void y0(int i11) {
        CheckInView checkInView;
        this.f53296g = true;
        qu.f fVar = this.f53293c;
        if (fVar != null && (checkInView = fVar.f74932g) != null) {
            checkInView.notifyItemCheckInStateChange(i11);
        }
        z0().d();
    }

    public final MemberCheckInViewModel z0() {
        return (MemberCheckInViewModel) this.f53300k.getValue();
    }
}
