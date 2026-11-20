package com.transsion.commercialization.task;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.Utils;
import com.transsion.commercialization.R$string;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.OpType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
@Route(path = "/commercialize/TaskCenterProvider")
@Metadata
public final class TaskCenterProvider implements ITaskCenterApi {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements su.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ss.b f51766b;

        public a(ss.b bVar) {
            this.f51766b = bVar;
        }

        @Override // su.b
        public void a() {
            com.transsion.commercialization.pslink.a.f51724a.a(TaskCenterProvider.this.C1() + " --> showMemberPage() --> checkMember() --> onFailed() --> 开通会员失败");
            ss.b bVar = this.f51766b;
            if (bVar != null) {
                bVar.onFail();
            }
        }

        @Override // su.b
        public void onSuccess() {
            com.transsion.commercialization.pslink.a.f51724a.a(TaskCenterProvider.this.C1() + " --> showMemberPage() --> checkMember() --> onSuccess() --> 开通会员成功，直接下载不需要做任务了");
            ss.b bVar = this.f51766b;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    public static /* synthetic */ void G1(TaskCenterProvider taskCenterProvider, ss.b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        taskCenterProvider.F1(bVar, z11);
    }

    public final void B1(final ss.b bVar, Integer num, final String str) {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e0(MemberSceneType.SCENE_HDDL, num, new su.a() { // from class: com.transsion.commercialization.task.TaskCenterProvider$checkMemberRights$1
            @Override // su.a
            public void a(MemberCheckResult memberCheckResult) {
                this.f51767a.H1(bVar, memberCheckResult);
            }

            @Override // su.a
            public void b(MemberCheckResult memberCheckResult) {
                this.f51767a.E1(bVar, memberCheckResult, str);
            }

            @Override // su.a
            public void c(MemberCheckResult memberCheckResult) {
                TaskCenterProvider.G1(this.f51767a, bVar, false, 2, null);
            }

            @Override // su.a
            public void d() {
                bVar.onSuccess();
                com.transsion.commercialization.pslink.a.f51724a.a(this.f51767a.C1() + " --> checkMember() --> passed() --> 会员权益通过验证 --> 继续下载任务");
                IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
                OpType opType = OpType.OP_DOWNLOAD;
                final TaskCenterProvider taskCenterProvider = this.f51767a;
                iMemberApi.R(opType, new Function1<Object, Unit>() { // from class: com.transsion.commercialization.task.TaskCenterProvider$checkMemberRights$1$onPassed$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        com.transsion.commercialization.pslink.a.f51724a.a(taskCenterProvider.C1() + " --> checkMember() --> uploadOperationStat --> OpType.OP_DOWNLOAD --> success");
                    }
                });
            }

            @Override // su.a
            public void e(MemberCheckResult memberCheckResult) {
                su.a.C0841a.a(this, memberCheckResult);
                com.transsion.commercialization.pslink.a.f51724a.b(this.f51767a.C1() + " --> triggerDownload() --> showCheckMemberRights() --> notImplement() --> 当前类型没有实现");
            }

            @Override // su.a
            public void onFail(String errorMsg) {
                Intrinsics.g(errorMsg, "errorMsg");
                su.a.C0841a.b(this, errorMsg);
                com.transsion.commercialization.pslink.a.f51724a.b(this.f51767a.C1() + " --> triggerDownload() --> checkMemberRights() --> showCheckMemberRightsDialog() --> " + errorMsg);
                bVar.onFail();
            }
        });
    }

    public final String C1() {
        String simpleName = TaskCenterProvider.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final String D1(MemberCheckResult memberCheckResult) {
        return (memberCheckResult != null ? memberCheckResult.getMemberPrice() : null) + " " + (memberCheckResult != null ? memberCheckResult.getCurrency() : null) + " ";
    }

    public final void E1(final ss.b bVar, MemberCheckResult memberCheckResult, String str) {
        new AdInterceptDialog().z0(D1(memberCheckResult)).v0(str).u0(new Function1<Integer, Unit>() { // from class: com.transsion.commercialization.task.TaskCenterProvider$showAdInterceptDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                if (i11 == 1) {
                    com.transsion.commercialization.pslink.a.f51724a.b(this.this$0.C1() + " --> showAdInterceptDialog() --> 广告任务 未完成 --> 结束流程");
                    zp.b.f82110a.e(Utils.a().getString(R$string.co_cancel_tips));
                    ss.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onFail();
                        return;
                    }
                    return;
                }
                if (i11 != 2) {
                    return;
                }
                com.transsion.commercialization.pslink.a.f51724a.a(this.this$0.C1() + " --> showAdInterceptDialog() --> 广告任务完成 --> 继续执行下载任务 --> 结束流程");
                ss.b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.onSuccess();
                }
                IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
                OpType opType = OpType.OP_AD;
                final TaskCenterProvider taskCenterProvider = this.this$0;
                iMemberApi.R(opType, new Function1<Object, Unit>() { // from class: com.transsion.commercialization.task.TaskCenterProvider$showAdInterceptDialog$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        com.transsion.commercialization.pslink.a.f51724a.a(taskCenterProvider.C1() + " --> checkMember() --> uploadOperationStat --> OpType.OP_AD --> success");
                    }
                });
            }
        }).j0(com.blankj.utilcode.util.a.b(), "AdInterceptDialog");
    }

    public final void F1(final ss.b bVar, final boolean z11) {
        if (bVar != null) {
            bVar.a(true);
        }
        new DownloadInterceptDialog().o1(new Function1<Integer, Unit>() { // from class: com.transsion.commercialization.task.TaskCenterProvider$showDownloadInterceptDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
                if (i11 == 1) {
                    com.transsion.commercialization.pslink.a.f51724a.b(this.C1() + " --> showDownloadInterceptDialog() --> 用户放弃下载任务");
                    if (!z11) {
                        zp.b.f82110a.e(Utils.a().getString(R$string.co_cancel_tips));
                    }
                    ss.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.onFail();
                    }
                    ss.b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.a(false);
                        return;
                    }
                    return;
                }
                if (i11 == 2 || i11 == 3) {
                    if (!z11) {
                        com.transsion.commercialization.pslink.a.f51724a.a(this.C1() + " --> DownloadInterceptDialog() --> 下载应用任务完成 --> 继续执行下载任务 --> 结束流程");
                        ss.b bVar4 = bVar;
                        if (bVar4 != null) {
                            bVar4.onSuccess();
                        }
                        IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
                        OpType opType = OpType.OP_INSTALL;
                        final TaskCenterProvider taskCenterProvider = this;
                        iMemberApi.R(opType, new Function1<Object, Unit>() { // from class: com.transsion.commercialization.task.TaskCenterProvider$showDownloadInterceptDialog$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke2(obj);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj) {
                                com.transsion.commercialization.pslink.a.f51724a.a(taskCenterProvider.C1() + " --> checkMember() --> uploadOperationStat --> OpType.OP_INSTALL --> success");
                            }
                        });
                    } else if (i11 == 2) {
                        ss.b bVar5 = bVar;
                        if (bVar5 != null) {
                            bVar5.onSuccess();
                        }
                    } else {
                        ss.b bVar6 = bVar;
                        if (bVar6 != null) {
                            bVar6.onFail();
                        }
                    }
                    ss.b bVar7 = bVar;
                    if (bVar7 != null) {
                        bVar7.a(false);
                    }
                }
            }
        }).u1(z11).j0(com.blankj.utilcode.util.a.b(), "DownloadInterceptV2Dialog");
    }

    public final void H1(ss.b bVar, MemberCheckResult memberCheckResult) {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).c1(com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG, memberCheckResult, new a(bVar));
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void h(ss.b bVar) {
        F1(bVar, true);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void t(Integer num, String str, ss.b listener) {
        Intrinsics.g(listener, "listener");
        com.transsion.commercialization.pslink.a.f51724a.a(C1() + " --> triggerDownload() --> 下载拦截统一处理 --> 会员权益校验");
        B1(listener, num, str);
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void u0(FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1) {
        new MemberPageVideoTaskDialog().s0(function1).j0(fragmentActivity, "MemberPageVideoTaskDialog");
    }

    @Override // com.transsion.commercializationapi.ITaskCenterApi
    public void v1() {
    }
}
