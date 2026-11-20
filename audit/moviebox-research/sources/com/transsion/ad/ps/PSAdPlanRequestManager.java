package com.transsion.ad.ps;

import android.app.Application;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.strategy.d;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import w9.q;
import xq.f;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PSAdPlanRequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PSAdPlanRequestManager f50545a = new PSAdPlanRequestManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50546b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.ad.ps.PSAdPlanRequestManager$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f50547c = LazyKt__LazyJVMKt.b(new Function0<sq.a>() { // from class: com.transsion.ad.ps.PSAdPlanRequestManager$psLinkAdPlanDao$2
        @Override // kotlin.jvm.functions.Function0
        public final sq.a invoke() {
            MbAdDatabase.e eVar = MbAdDatabase.f50387p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return eVar.b(applicationA).O();
        }
    });

    public static /* synthetic */ Object m(PSAdPlanRequestManager pSAdPlanRequestManager, int i11, boolean z11, int i12, Integer num, String str, Continuation continuation, int i13, Object obj) {
        int i14 = (i13 & 1) != 0 ? 0 : i11;
        boolean z12 = (i13 & 2) != 0 ? true : z11;
        int i15 = (i13 & 4) != 0 ? 10 : i12;
        if ((i13 & 8) != 0) {
            num = 14;
        }
        return pSAdPlanRequestManager.l(i14, z12, i15, num, str, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009b  */
    /* JADX WARN: Code duplicated, block: B:28:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:40:0x0113  */
    /* JADX WARN: Code duplicated, block: B:41:0x011a  */
    /* JADX WARN: Code duplicated, block: B:43:0x011e  */
    /* JADX WARN: Code duplicated, block: B:46:0x01a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:49:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b4 -> B:50:0x01b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01a2 -> B:48:0x01a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01a6 -> B:50:0x01b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:31:0x00b7
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object e(java.lang.String r33, java.lang.String r34, com.transsion.ad.ps.model.PsLinkDto r35, kotlin.coroutines.Continuation<? super kotlin.Unit> r36) {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.PSAdPlanRequestManager.e(java.lang.String, java.lang.String, com.transsion.ad.ps.model.PsLinkDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String f(String str) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String str2 = com.transsion.ad.b.f50277a.a() + File.separatorChar + strValueOf + InstructionFileId.DOT + "mineType";
        return (f.f80673a.c(str2) || d.b(d.f50607a, str, str2, false, 4, null)) ? str2 : "";
    }

    public final boolean g(MbAdImage mbAdImage) {
        String url = mbAdImage.getUrl();
        String strC = q.c(url);
        String str = com.transsion.ad.b.f50277a.a() + File.separatorChar + strC + InstructionFileId.DOT + "mineType";
        File file = new File(str);
        if (file.isFile() && file.exists() && file.length() > 0) {
            mbAdImage.setPath(str);
            return true;
        }
        boolean zA = d.f50607a.a(url, str, false);
        long length = file.length();
        if (!zA || length <= 0) {
            return false;
        }
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, h() + " --> downloadAdPlan() --> 图片素材下载成功 --> -- destination = " + str, false, 2, null);
        mbAdImage.setPath(str);
        return true;
    }

    public final String h() {
        String simpleName = PSAdPlanRequestManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Object i(MbAdDbPlans mbAdDbPlans, Continuation<? super Unit> continuation) {
        String extAdSlot;
        int i11 = 14;
        if (!TextUtils.isEmpty(mbAdDbPlans.getExtAdSlot()) && (extAdSlot = mbAdDbPlans.getExtAdSlot()) != null) {
            i11 = Integer.parseInt(extAdSlot);
        }
        Object objL = l(0, false, 10, Boxing.d(i11), mbAdDbPlans.getId(), continuation);
        return objL == kotlin.coroutines.intrinsics.a.e() ? objL : Unit.f68710a;
    }

    public final JSONObject j(int i11, int i12, Integer num) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bu", "mb");
        jSONObject.put("pageIndex", i11);
        jSONObject.put("pageSize", i12);
        jSONObject.put("media", 1);
        jSONObject.put("scene", num);
        for (Map.Entry<String, Object> entry : a.f50553a.a(System.currentTimeMillis()).entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public final sq.a k() {
        return (sq.a) f50547c.getValue();
    }

    public final Object l(int i11, boolean z11, int i12, Integer num, String str, Continuation<? super Unit> continuation) {
        PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, null, String.valueOf(num), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue());
        Object objG = h.g(w0.b(), new PSAdPlanRequestManager$getPsLinkListBySlot$2(i11, i12, num, str, z11, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final a n() {
        return (a) f50546b.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object o(JSONObject jSONObject, Integer num, String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        PSAdPlanRequestManager$request$1 pSAdPlanRequestManager$request$1;
        Integer num2;
        String str3;
        PSAdPlanRequestManager pSAdPlanRequestManager;
        List<RecommendInfo> data;
        if (continuation instanceof PSAdPlanRequestManager$request$1) {
            pSAdPlanRequestManager$request$1 = (PSAdPlanRequestManager$request$1) continuation;
            int i11 = pSAdPlanRequestManager$request$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                pSAdPlanRequestManager$request$1.label = i11 - Integer.MIN_VALUE;
            } else {
                pSAdPlanRequestManager$request$1 = new PSAdPlanRequestManager$request$1(this, continuation);
            }
        } else {
            pSAdPlanRequestManager$request$1 = new PSAdPlanRequestManager$request$1(this, continuation);
        }
        Object objA = pSAdPlanRequestManager$request$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = pSAdPlanRequestManager$request$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                str3 = (String) pSAdPlanRequestManager$request$1.L$2;
                num2 = (Integer) pSAdPlanRequestManager$request$1.L$1;
                pSAdPlanRequestManager = (PSAdPlanRequestManager) pSAdPlanRequestManager$request$1.L$0;
                ResultKt.b(objA);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(objA);
            }
            return Unit.f68710a;
        }
        ResultKt.b(objA);
        a aVarN = n();
        ip.b.a aVar = ip.b.f67591a;
        String string = jSONObject.toString();
        Intrinsics.f(string, "jsonObject.toString()");
        RequestBody requestBodyA = aVar.a(string);
        pSAdPlanRequestManager$request$1.L$0 = this;
        pSAdPlanRequestManager$request$1.L$1 = num;
        pSAdPlanRequestManager$request$1.L$2 = str;
        pSAdPlanRequestManager$request$1.label = 1;
        objA = aVarN.a(requestBodyA, str2, pSAdPlanRequestManager$request$1);
        if (objA == objE) {
            return objE;
        }
        num2 = num;
        str3 = str;
        pSAdPlanRequestManager = this;
        PsLinkDto psLinkDto = (PsLinkDto) objA;
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, pSAdPlanRequestManager.h() + " --> request() --> PS 接口返回 --> scene = " + num2 + " --> adPlanId = " + str3 + " --> data = " + (psLinkDto != null ? psLinkDto.getData() : null), false, 2, null);
        PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_SUCCESS, (psLinkDto == null || (data = psLinkDto.getData()) == null) ? null : Boxing.d(data.size()), "", String.valueOf(num2), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue());
        String strValueOf = String.valueOf(num2);
        pSAdPlanRequestManager$request$1.L$0 = null;
        pSAdPlanRequestManager$request$1.L$1 = null;
        pSAdPlanRequestManager$request$1.L$2 = null;
        pSAdPlanRequestManager$request$1.label = 2;
        if (pSAdPlanRequestManager.e(strValueOf, str3, psLinkDto, pSAdPlanRequestManager$request$1) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:30:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:41:0x0112  */
    /* JADX WARN: Code duplicated, block: B:42:0x0115  */
    /* JADX WARN: Code duplicated, block: B:44:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x0125  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0112 -> B:26:0x0084). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0125 -> B:46:0x0126). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.PSAdPlanRequestManager.p(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
