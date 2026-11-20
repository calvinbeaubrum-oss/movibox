package com.transsion.ad.ps;

import android.text.TextUtils;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PSDistributionRequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PSDistributionRequestManager f50548a = new PSDistributionRequestManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50549b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.ad.ps.PSDistributionRequestManager$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object d(PSDistributionRequestManager pSDistributionRequestManager, int i11, boolean z11, int i12, String str, String str2, Function1 function1, Continuation continuation, int i13, Object obj) {
        return pSDistributionRequestManager.c((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? true : z11, (i13 & 4) != 0 ? 10 : i12, str, (i13 & 16) != 0 ? "" : str2, (i13 & 32) != 0 ? null : function1, continuation);
    }

    public static /* synthetic */ Object f(PSDistributionRequestManager pSDistributionRequestManager, int i11, boolean z11, int i12, String str, String str2, WrapperAdListener wrapperAdListener, Continuation continuation, int i13, Object obj) {
        return pSDistributionRequestManager.e((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? true : z11, (i13 & 4) != 0 ? 10 : i12, str, (i13 & 16) != 0 ? "" : str2, wrapperAdListener, continuation);
    }

    public final String a() {
        String simpleName = PSDistributionRequestManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final JSONObject b(int i11, int i12, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bu", "mb");
        jSONObject.put("pageIndex", i11);
        jSONObject.put("pageSize", i12);
        jSONObject.put("recommendCode", "mb_apps");
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("pushModel", str);
        }
        for (Map.Entry<String, Object> entry : a.f50553a.a(System.currentTimeMillis()).entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:49:0x0124 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:34:0x00dd, B:36:0x00e5, B:38:0x00eb, B:42:0x00f8, B:44:0x0112, B:46:0x0118, B:47:0x011e, B:49:0x0124, B:51:0x0132, B:54:0x013d, B:59:0x0149, B:61:0x0151, B:57:0x0144, B:31:0x00d2), top: B:85:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0143  */
    /* JADX WARN: Code duplicated, block: B:57:0x0144 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:34:0x00dd, B:36:0x00e5, B:38:0x00eb, B:42:0x00f8, B:44:0x0112, B:46:0x0118, B:47:0x011e, B:49:0x0124, B:51:0x0132, B:54:0x013d, B:59:0x0149, B:61:0x0151, B:57:0x0144, B:31:0x00d2), top: B:85:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0149 A[Catch: all -> 0x00f4, TryCatch #0 {all -> 0x00f4, blocks: (B:34:0x00dd, B:36:0x00e5, B:38:0x00eb, B:42:0x00f8, B:44:0x0112, B:46:0x0118, B:47:0x011e, B:49:0x0124, B:51:0x0132, B:54:0x013d, B:59:0x0149, B:61:0x0151, B:57:0x0144, B:31:0x00d2), top: B:85:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0150  */
    /* JADX WARN: Code duplicated, block: B:71:0x0173  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x0173, please report this as an issue */
    public final Object c(int i11, boolean z11, int i12, String str, String str2, Function1<? super PsLinkDto, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        PSDistributionRequestManager$getPsLinkList$1 pSDistributionRequestManager$getPsLinkList$1;
        boolean z12;
        Function1<? super PsLinkDto, Unit> function2;
        Object objM163constructorimpl;
        String str3;
        Throwable thM166exceptionOrNullimpl;
        String message;
        PsLinkDto psLinkDto;
        Integer numD;
        ArrayList arrayList;
        Unit unitInvoke;
        List<RecommendInfo> data;
        List<RecommendInfo> data2;
        int i13 = i11;
        String str4 = str;
        if (continuation instanceof PSDistributionRequestManager$getPsLinkList$1) {
            pSDistributionRequestManager$getPsLinkList$1 = (PSDistributionRequestManager$getPsLinkList$1) continuation;
            int i14 = pSDistributionRequestManager$getPsLinkList$1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                pSDistributionRequestManager$getPsLinkList$1.label = i14 - Integer.MIN_VALUE;
            } else {
                pSDistributionRequestManager$getPsLinkList$1 = new PSDistributionRequestManager$getPsLinkList$1(this, continuation);
            }
        } else {
            pSDistributionRequestManager$getPsLinkList$1 = new PSDistributionRequestManager$getPsLinkList$1(this, continuation);
        }
        PSDistributionRequestManager$getPsLinkList$1 pSDistributionRequestManager$getPsLinkList$2 = pSDistributionRequestManager$getPsLinkList$1;
        Object objA = pSDistributionRequestManager$getPsLinkList$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i15 = pSDistributionRequestManager$getPsLinkList$2.label;
        if (i15 == 0) {
            ResultKt.b(objA);
            JSONObject jSONObjectB = b(i13, i12, str2);
            String str5 = wo.a.f79569a.d() ? "https://test-feature-api.palmplaystore.com" : "https://feature-api.palmplaystore.com";
            com.transsion.ad.a.b(com.transsion.ad.a.f50276a, a() + " --> getPsLinkListBySlot() --> scene = " + str4 + " --> url = " + str5 + " --> jsonObject = " + jSONObjectB, false, 2, null);
            PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, "", "", str);
            try {
                Result.Companion companion = Result.Companion;
                a aVarG = f50548a.g();
                ip.b.a aVar = ip.b.f67591a;
                String string = jSONObjectB.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                pSDistributionRequestManager$getPsLinkList$2.L$0 = str4;
                function2 = function1;
                try {
                    pSDistributionRequestManager$getPsLinkList$2.L$1 = function2;
                    pSDistributionRequestManager$getPsLinkList$2.I$0 = i13;
                    z12 = z11;
                    try {
                        pSDistributionRequestManager$getPsLinkList$2.Z$0 = z12;
                        pSDistributionRequestManager$getPsLinkList$2.label = 1;
                        objA = aVarG.a(requestBodyA, str5, pSDistributionRequestManager$getPsLinkList$2);
                        if (objA == objE) {
                            return objE;
                        }
                        psLinkDto = (PsLinkDto) objA;
                        PSReportUtil pSReportUtil = PSReportUtil.f50550a;
                        PSReportUtil.PSRequestState pSRequestState = PSReportUtil.PSRequestState.REQUEST_SUCCESS;
                        if (psLinkDto != null) {
                            numD = null;
                        } else {
                            numD = null;
                        }
                        pSReportUtil.b(pSRequestState, numD, "", "", str4);
                        arrayList = new ArrayList();
                        if (psLinkDto != null) {
                            for (RecommendInfo recommendInfo : data) {
                                if (!b.f50555a.m()) {
                                }
                                arrayList.add(recommendInfo);
                            }
                        }
                        if (psLinkDto == null) {
                            psLinkDto.setData(arrayList);
                        }
                        if (function2 != null) {
                            unitInvoke = function2.invoke(psLinkDto);
                        } else {
                            unitInvoke = null;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(unitInvoke);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion2 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z12 = z11;
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                }
            } catch (Throwable th4) {
                th = th4;
                z12 = z11;
                function2 = function1;
            }
            str3 = str4;
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
                PSDistributionRequestManager pSDistributionRequestManager = f50548a;
                com.transsion.ad.a.r(aVar2, pSDistributionRequestManager.a() + " --> getPsLinkList() --> 加载失败了 it = " + thM166exceptionOrNullimpl, false, 2, null);
                PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_FAIL, null, thM166exceptionOrNullimpl.getMessage(), "", str3);
                message = thM166exceptionOrNullimpl.getMessage();
                if (message == null) {
                    if (function2 != null) {
                        function2.invoke(null);
                    }
                } else if (function2 != null) {
                    function2.invoke(null);
                }
            }
        } else if (i15 == 1) {
            boolean z13 = pSDistributionRequestManager$getPsLinkList$2.Z$0;
            int i16 = pSDistributionRequestManager$getPsLinkList$2.I$0;
            function2 = (Function1) pSDistributionRequestManager$getPsLinkList$2.L$1;
            String str6 = (String) pSDistributionRequestManager$getPsLinkList$2.L$0;
            try {
                ResultKt.b(objA);
                str4 = str6;
                z12 = z13;
                i13 = i16;
                psLinkDto = (PsLinkDto) objA;
                PSReportUtil pSReportUtil2 = PSReportUtil.f50550a;
                PSReportUtil.PSRequestState pSRequestState2 = PSReportUtil.PSRequestState.REQUEST_SUCCESS;
                if (psLinkDto != null || (data2 = psLinkDto.getData()) == null) {
                    numD = null;
                } else {
                    numD = Boxing.d(data2.size());
                }
                pSReportUtil2.b(pSRequestState2, numD, "", "", str4);
                arrayList = new ArrayList();
                if (psLinkDto != null && (data = psLinkDto.getData()) != null) {
                    while (r6.hasNext()) {
                        if (!b.f50555a.m() || !TextUtils.isEmpty(recommendInfo.getGpLink())) {
                            arrayList.add(recommendInfo);
                        }
                    }
                }
                if (psLinkDto == null) {
                    psLinkDto.setData(arrayList);
                }
                if (function2 != null) {
                    unitInvoke = function2.invoke(psLinkDto);
                } else {
                    unitInvoke = null;
                }
                objM163constructorimpl = Result.m163constructorimpl(unitInvoke);
            } catch (Throwable th5) {
                th = th5;
                str4 = str6;
                z12 = z13;
                i13 = i16;
                Result.Companion companion4 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
            }
            str3 = str4;
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                com.transsion.ad.a aVar3 = com.transsion.ad.a.f50276a;
                PSDistributionRequestManager pSDistributionRequestManager2 = f50548a;
                com.transsion.ad.a.r(aVar3, pSDistributionRequestManager2.a() + " --> getPsLinkList() --> 加载失败了 it = " + thM166exceptionOrNullimpl, false, 2, null);
                PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_FAIL, null, thM166exceptionOrNullimpl.getMessage(), "", str3);
                message = thM166exceptionOrNullimpl.getMessage();
                if (message == null && StringsKt__StringsKt.Q(message, "Exception received from UploadDataProvider", false, 2, null) && z12 && f.f49475a.e()) {
                    com.transsion.ad.a.r(aVar3, pSDistributionRequestManager2.a() + " --> getPsLinkList() --> retry", false, 2, null);
                    pSDistributionRequestManager$getPsLinkList$2.L$0 = null;
                    pSDistributionRequestManager$getPsLinkList$2.L$1 = null;
                    pSDistributionRequestManager$getPsLinkList$2.label = 2;
                    if (d(pSDistributionRequestManager2, i13, false, 0, str3, null, null, pSDistributionRequestManager$getPsLinkList$2, 52, null) == objE) {
                        return objE;
                    }
                } else if (function2 != null) {
                    function2.invoke(null);
                }
            }
        } else {
            if (i15 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objA);
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:49:0x0124 A[Catch: all -> 0x00f4, TryCatch #1 {all -> 0x00f4, blocks: (B:34:0x00dd, B:36:0x00e5, B:38:0x00eb, B:42:0x00f8, B:44:0x0112, B:46:0x0118, B:47:0x011e, B:49:0x0124, B:51:0x0132, B:54:0x013d, B:56:0x0143, B:58:0x014a, B:31:0x00d2), top: B:84:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0143 A[Catch: all -> 0x00f4, TryCatch #1 {all -> 0x00f4, blocks: (B:34:0x00dd, B:36:0x00e5, B:38:0x00eb, B:42:0x00f8, B:44:0x0112, B:46:0x0118, B:47:0x011e, B:49:0x0124, B:51:0x0132, B:54:0x013d, B:56:0x0143, B:58:0x014a, B:31:0x00d2), top: B:84:0x00d2 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0149  */
    /* JADX WARN: Code duplicated, block: B:68:0x016d  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x016d, please report this as an issue */
    public final Object e(int i11, boolean z11, int i12, String str, String str2, WrapperAdListener wrapperAdListener, Continuation<? super Unit> continuation) throws Throwable {
        PSDistributionRequestManager$getPsLinkListV2$1 pSDistributionRequestManager$getPsLinkListV2$1;
        boolean z12;
        WrapperAdListener wrapperAdListener2;
        Object objM163constructorimpl;
        WrapperAdListener wrapperAdListener3;
        String str3;
        Throwable thM166exceptionOrNullimpl;
        String message;
        PsLinkDto psLinkDto;
        Integer numD;
        ArrayList arrayList;
        Unit unit;
        List<RecommendInfo> data;
        List<RecommendInfo> data2;
        int i13 = i11;
        String str4 = str;
        if (continuation instanceof PSDistributionRequestManager$getPsLinkListV2$1) {
            pSDistributionRequestManager$getPsLinkListV2$1 = (PSDistributionRequestManager$getPsLinkListV2$1) continuation;
            int i14 = pSDistributionRequestManager$getPsLinkListV2$1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                pSDistributionRequestManager$getPsLinkListV2$1.label = i14 - Integer.MIN_VALUE;
            } else {
                pSDistributionRequestManager$getPsLinkListV2$1 = new PSDistributionRequestManager$getPsLinkListV2$1(this, continuation);
            }
        } else {
            pSDistributionRequestManager$getPsLinkListV2$1 = new PSDistributionRequestManager$getPsLinkListV2$1(this, continuation);
        }
        PSDistributionRequestManager$getPsLinkListV2$1 pSDistributionRequestManager$getPsLinkListV2$2 = pSDistributionRequestManager$getPsLinkListV2$1;
        Object objA = pSDistributionRequestManager$getPsLinkListV2$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i15 = pSDistributionRequestManager$getPsLinkListV2$2.label;
        if (i15 == 0) {
            ResultKt.b(objA);
            JSONObject jSONObjectB = b(i13, i12, str2);
            String str5 = wo.a.f79569a.d() ? "https://test-feature-api.palmplaystore.com" : "https://feature-api.palmplaystore.com";
            com.transsion.ad.a.B(com.transsion.ad.a.f50276a, a() + " --> getPsLinkListBySlot() --> scene = " + str4 + " --> url = " + str5 + " --> jsonObject = " + jSONObjectB, false, 2, null);
            PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, "", "", str);
            try {
                Result.Companion companion = Result.Companion;
                a aVarG = f50548a.g();
                ip.b.a aVar = ip.b.f67591a;
                String string = jSONObjectB.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                pSDistributionRequestManager$getPsLinkListV2$2.L$0 = str4;
                wrapperAdListener2 = wrapperAdListener;
                try {
                    pSDistributionRequestManager$getPsLinkListV2$2.L$1 = wrapperAdListener2;
                    pSDistributionRequestManager$getPsLinkListV2$2.I$0 = i13;
                    z12 = z11;
                    try {
                        pSDistributionRequestManager$getPsLinkListV2$2.Z$0 = z12;
                        pSDistributionRequestManager$getPsLinkListV2$2.label = 1;
                        objA = aVarG.a(requestBodyA, str5, pSDistributionRequestManager$getPsLinkListV2$2);
                        if (objA == objE) {
                            return objE;
                        }
                        psLinkDto = (PsLinkDto) objA;
                        PSReportUtil pSReportUtil = PSReportUtil.f50550a;
                        PSReportUtil.PSRequestState pSRequestState = PSReportUtil.PSRequestState.REQUEST_SUCCESS;
                        if (psLinkDto != null) {
                            numD = null;
                        } else {
                            numD = null;
                        }
                        pSReportUtil.b(pSRequestState, numD, "", "", str4);
                        arrayList = new ArrayList();
                        if (psLinkDto != null) {
                            for (RecommendInfo recommendInfo : data) {
                                if (!b.f50555a.m()) {
                                }
                                arrayList.add(recommendInfo);
                            }
                        }
                        if (wrapperAdListener2 != null) {
                            wrapperAdListener2.onPSDistributionReady(arrayList);
                            unit = Unit.f68710a;
                        } else {
                            unit = null;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(unit);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion2 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z12 = z11;
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                }
            } catch (Throwable th4) {
                th = th4;
                z12 = z11;
                wrapperAdListener2 = wrapperAdListener;
            }
            wrapperAdListener3 = wrapperAdListener2;
            str3 = str4;
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
                PSDistributionRequestManager pSDistributionRequestManager = f50548a;
                com.transsion.ad.a.r(aVar2, pSDistributionRequestManager.a() + " --> getPsLinkList() --> 加载失败了 it = " + thM166exceptionOrNullimpl, false, 2, null);
                PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_FAIL, null, thM166exceptionOrNullimpl.getMessage(), "", str3);
                message = thM166exceptionOrNullimpl.getMessage();
                if (message == null) {
                    if (wrapperAdListener3 != null) {
                        wrapperAdListener3.onError(new TAdErrorCode(0, String.valueOf(thM166exceptionOrNullimpl.getMessage())));
                    }
                } else if (wrapperAdListener3 != null) {
                    wrapperAdListener3.onError(new TAdErrorCode(0, String.valueOf(thM166exceptionOrNullimpl.getMessage())));
                }
            }
        } else if (i15 == 1) {
            boolean z13 = pSDistributionRequestManager$getPsLinkListV2$2.Z$0;
            int i16 = pSDistributionRequestManager$getPsLinkListV2$2.I$0;
            wrapperAdListener2 = (WrapperAdListener) pSDistributionRequestManager$getPsLinkListV2$2.L$1;
            String str6 = (String) pSDistributionRequestManager$getPsLinkListV2$2.L$0;
            try {
                ResultKt.b(objA);
                str4 = str6;
                z12 = z13;
                i13 = i16;
                psLinkDto = (PsLinkDto) objA;
                PSReportUtil pSReportUtil2 = PSReportUtil.f50550a;
                PSReportUtil.PSRequestState pSRequestState2 = PSReportUtil.PSRequestState.REQUEST_SUCCESS;
                if (psLinkDto != null || (data2 = psLinkDto.getData()) == null) {
                    numD = null;
                } else {
                    numD = Boxing.d(data2.size());
                }
                pSReportUtil2.b(pSRequestState2, numD, "", "", str4);
                arrayList = new ArrayList();
                if (psLinkDto != null && (data = psLinkDto.getData()) != null) {
                    while (r0.hasNext()) {
                        if (!b.f50555a.m() || !TextUtils.isEmpty(recommendInfo.getGpLink())) {
                            arrayList.add(recommendInfo);
                        }
                    }
                }
                if (wrapperAdListener2 != null) {
                    wrapperAdListener2.onPSDistributionReady(arrayList);
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                objM163constructorimpl = Result.m163constructorimpl(unit);
            } catch (Throwable th5) {
                th = th5;
                str4 = str6;
                z12 = z13;
                i13 = i16;
                Result.Companion companion4 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
            }
            wrapperAdListener3 = wrapperAdListener2;
            str3 = str4;
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                com.transsion.ad.a aVar3 = com.transsion.ad.a.f50276a;
                PSDistributionRequestManager pSDistributionRequestManager2 = f50548a;
                com.transsion.ad.a.r(aVar3, pSDistributionRequestManager2.a() + " --> getPsLinkList() --> 加载失败了 it = " + thM166exceptionOrNullimpl, false, 2, null);
                PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_FAIL, null, thM166exceptionOrNullimpl.getMessage(), "", str3);
                message = thM166exceptionOrNullimpl.getMessage();
                if (message == null && StringsKt__StringsKt.Q(message, "Exception received from UploadDataProvider", false, 2, null) && z12 && f.f49475a.e()) {
                    com.transsion.ad.a.r(aVar3, pSDistributionRequestManager2.a() + " --> getPsLinkList() --> retry", false, 2, null);
                    pSDistributionRequestManager$getPsLinkListV2$2.L$0 = null;
                    pSDistributionRequestManager$getPsLinkListV2$2.L$1 = null;
                    pSDistributionRequestManager$getPsLinkListV2$2.label = 2;
                    if (f(pSDistributionRequestManager2, i13, false, 0, str3, null, wrapperAdListener3, pSDistributionRequestManager$getPsLinkListV2$2, 20, null) == objE) {
                        return objE;
                    }
                } else if (wrapperAdListener3 != null) {
                    wrapperAdListener3.onError(new TAdErrorCode(0, String.valueOf(thM166exceptionOrNullimpl.getMessage())));
                }
            }
        } else {
            if (i15 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objA);
        }
        return Unit.f68710a;
    }

    public final a g() {
        return (a) f50549b.getValue();
    }
}
