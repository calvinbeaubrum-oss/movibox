package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import com.transsion.ad.ps.PSAdPlanRequestManager;
import com.transsion.ad.strategy.AdMmkv;
import com.transsion.ad.strategy.d;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import org.apache.tools.zip.UnixStat;
import uq.a;
import vq.b;
import w9.q;
import xq.f;
import xq.k;

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
public final class AdPlansRequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlansRequestManager f50530a = new AdPlansRequestManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50531b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.ad.monopoly.manager.AdPlansRequestManager$mbAdConfigApi$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object s(AdPlansRequestManager adPlansRequestManager, String str, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return adPlansRequestManager.r(str, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0070  */
    /* JADX WARN: Code duplicated, block: B:21:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x008b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0097  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0124  */
    /* JADX WARN: Code duplicated, block: B:68:0x0127  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a5 -> B:28:0x00a8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0127 -> B:65:0x0120). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object g(java.util.List<com.transsion.ad.monopoly.model.AdPlans> r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.g(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(MbAdPlansDto mbAdPlansDto, String str, Continuation<? super Unit> continuation) throws Throwable {
        AdPlansRequestManager$checkResult$1 adPlansRequestManager$checkResult$1;
        AdPlansRequestManager adPlansRequestManager;
        MbAdPlansBean data;
        String str2;
        com.transsion.ad.a aVar;
        String str3;
        List list;
        Integer numD;
        if (continuation instanceof AdPlansRequestManager$checkResult$1) {
            adPlansRequestManager$checkResult$1 = (AdPlansRequestManager$checkResult$1) continuation;
            int i11 = adPlansRequestManager$checkResult$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$checkResult$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlansRequestManager$checkResult$1 = new AdPlansRequestManager$checkResult$1(this, continuation);
            }
        } else {
            adPlansRequestManager$checkResult$1 = new AdPlansRequestManager$checkResult$1(this, continuation);
        }
        Object objG = adPlansRequestManager$checkResult$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlansRequestManager$checkResult$1.label;
        if (i12 == 0) {
            ResultKt.b(objG);
            if (((mbAdPlansDto == null || (data = mbAdPlansDto.getData()) == null) ? null : data.getAdPlans()) != null) {
                List<AdPlans> adPlans = mbAdPlansDto.getData().getAdPlans();
                adPlansRequestManager$checkResult$1.L$0 = this;
                adPlansRequestManager$checkResult$1.L$1 = mbAdPlansDto;
                adPlansRequestManager$checkResult$1.L$2 = str;
                adPlansRequestManager$checkResult$1.label = 1;
                objG = g(adPlans, adPlansRequestManager$checkResult$1);
                if (objG == objE) {
                    return objE;
                }
                adPlansRequestManager = this;
            }
            return Unit.f68710a;
        }
        if (i12 == 1) {
            str = (String) adPlansRequestManager$checkResult$1.L$2;
            mbAdPlansDto = (MbAdPlansDto) adPlansRequestManager$checkResult$1.L$1;
            adPlansRequestManager = (AdPlansRequestManager) adPlansRequestManager$checkResult$1.L$0;
            ResultKt.b(objG);
        } else {
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str3 = (String) adPlansRequestManager$checkResult$1.L$3;
            str = (String) adPlansRequestManager$checkResult$1.L$2;
            str2 = (String) adPlansRequestManager$checkResult$1.L$1;
            aVar = (com.transsion.ad.a) adPlansRequestManager$checkResult$1.L$0;
            ResultKt.b(objG);
        }
        list = (List) objG;
        if (list != null) {
            numD = Boxing.d(list.size());
        } else {
            numD = null;
        }
        com.transsion.ad.a.b(aVar, str2 + " --> checkResult() --> 更新完计划且下载完素材,新计划可用 --> lastVersion = " + str + " --> newVersion = " + str3 + " --> size = " + numD, false, 2, null);
        return Unit.f68710a;
        if (((Boolean) objG).booleanValue()) {
            String strValueOf = String.valueOf(mbAdPlansDto.getData().getVersion());
            b.f79053a.j(strValueOf);
            AdMmkv.f50558a.b().putString("non_ad_plan_version", strValueOf);
            adPlansRequestManager.j(mbAdPlansDto.getData().getAdPlans());
            com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
            String strO = adPlansRequestManager.o();
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
            adPlansRequestManager$checkResult$1.L$0 = aVar2;
            adPlansRequestManager$checkResult$1.L$1 = strO;
            adPlansRequestManager$checkResult$1.L$2 = str;
            adPlansRequestManager$checkResult$1.L$3 = strValueOf;
            adPlansRequestManager$checkResult$1.label = 2;
            Object objH = adPlansStorageManager.h(adPlansRequestManager$checkResult$1);
            if (objH == objE) {
                return objE;
            }
            str2 = strO;
            aVar = aVar2;
            str3 = strValueOf;
            objG = objH;
            list = (List) objG;
            if (list != null) {
                numD = Boxing.d(list.size());
            } else {
                numD = null;
            }
            com.transsion.ad.a.b(aVar, str2 + " --> checkResult() --> 更新完计划且下载完素材,新计划可用 --> lastVersion = " + str + " --> newVersion = " + str3 + " --> size = " + numD, false, 2, null);
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        AdPlansRequestManager$deleteExpireAdPlan$1 adPlansRequestManager$deleteExpireAdPlan$1;
        AdPlansRequestManager adPlansRequestManager;
        if (continuation instanceof AdPlansRequestManager$deleteExpireAdPlan$1) {
            adPlansRequestManager$deleteExpireAdPlan$1 = (AdPlansRequestManager$deleteExpireAdPlan$1) continuation;
            int i11 = adPlansRequestManager$deleteExpireAdPlan$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$deleteExpireAdPlan$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlansRequestManager$deleteExpireAdPlan$1 = new AdPlansRequestManager$deleteExpireAdPlan$1(this, continuation);
            }
        } else {
            adPlansRequestManager$deleteExpireAdPlan$1 = new AdPlansRequestManager$deleteExpireAdPlan$1(this, continuation);
        }
        Object obj = adPlansRequestManager$deleteExpireAdPlan$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlansRequestManager$deleteExpireAdPlan$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (TextUtils.isEmpty(str)) {
                return Unit.f68710a;
            }
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
            adPlansRequestManager$deleteExpireAdPlan$1.L$0 = this;
            adPlansRequestManager$deleteExpireAdPlan$1.L$1 = str;
            adPlansRequestManager$deleteExpireAdPlan$1.L$2 = str2;
            adPlansRequestManager$deleteExpireAdPlan$1.label = 1;
            if (adPlansStorageManager.a(str, adPlansRequestManager$deleteExpireAdPlan$1) == objE) {
                return objE;
            }
            adPlansRequestManager = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) adPlansRequestManager$deleteExpireAdPlan$1.L$2;
            str = (String) adPlansRequestManager$deleteExpireAdPlan$1.L$1;
            adPlansRequestManager = (AdPlansRequestManager) adPlansRequestManager$deleteExpireAdPlan$1.L$0;
            ResultKt.b(obj);
        }
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, adPlansRequestManager.o() + " --> deleteExpireAdPlan() --> 删除过期计划 -- success --> newVersion = " + str + " -- lastVersion = " + str2, false, 2, null);
        return Unit.f68710a;
    }

    public final void j(List<AdPlans> list) {
        HashSet<String> hashSet = new HashSet<>();
        for (AdPlans adPlans : list) {
            List<AdMaterialList> adMaterialList = adPlans.getAdMaterialList();
            if (adMaterialList != null) {
                for (AdMaterialList adMaterialList2 : adMaterialList) {
                    if (Intrinsics.b(AdMaterialList.NON_AD_TYPE_TEXT, adMaterialList2.getType())) {
                        MbAdImage image = adMaterialList2.getImage();
                        hashSet.add(image != null ? image.getPath() : null);
                    } else {
                        MbAdVideo video = adMaterialList2.getVideo();
                        hashSet.add(video != null ? video.getPath() : null);
                    }
                }
            }
            if (!TextUtils.isEmpty(adPlans.getAdvertiserAvatarPath())) {
                hashSet.add(adPlans.getAdvertiserAvatarPath());
            }
        }
        f.f80673a.b(new File(com.transsion.ad.b.f50277a.b() + File.separatorChar), hashSet);
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, o() + " --> deleteExpireMaterial() --> 删除过期资源 -- success", false, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009b  */
    public final boolean k(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        String url;
        String str;
        Integer size;
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        com.transsion.ad.a.b(aVar, o() + " --> downloadAdPlan() --> 下载非标广告计划素材 start --> adPlans.id = " + (adPlans != null ? adPlans.getId() : null) + " ......", false, 2, null);
        String strL = l(adPlans != null ? adPlans.getAdvertiserAvatar() : null);
        if (adPlans != null) {
            adPlans.setAdvertiserAvatarPath(strL);
        }
        com.transsion.ad.a.b(aVar, o() + " --> --> downloadAdPlan() --> 广告主头像下载完成 --> advertiserAvatarPath = " + strL, false, 2, null);
        m(adPlans != null ? adPlans.getExtImage() : null);
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null) {
            return false;
        }
        Iterator<T> it = adMaterialList.iterator();
        if (!it.hasNext()) {
            return false;
        }
        AdMaterialList adMaterialList2 = (AdMaterialList) it.next();
        if (Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
            MbAdImage image = adMaterialList2.getImage();
            if (image != null) {
                url = image.getUrl();
                str = url;
            } else {
                str = null;
            }
        } else {
            MbAdVideo video = adMaterialList2.getVideo();
            if (video != null) {
                url = video.getUrl();
                str = url;
            } else {
                str = null;
            }
        }
        String strC = q.c(str);
        String str2 = com.transsion.ad.b.f50277a.b() + File.separatorChar + strC + InstructionFileId.DOT + "mineType";
        File file = new File(str2);
        if (!Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_VIDEO)) {
            if (file.isFile() && file.exists() && file.length() > 0) {
                MbAdImage image2 = adMaterialList2.getImage();
                if (image2 != null) {
                    image2.setPath(str2);
                }
                adMaterialList2.setDownloadMaterialSuccess(true);
                return true;
            }
            boolean zA = d.f50607a.a(str, str2, Intrinsics.b(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT));
            long length = file.length();
            if (!zA || length <= 0) {
                com.transsion.ad.a.d(aVar, f50530a.o() + " --> downloadAdPlan() --> 图片素材下载失败 -- adPlans.id = " + adPlans.getId() + " downloadFileSuccess = " + zA + " -- localFileSize = " + length + " -- destination = " + str2, false, 2, null);
                return false;
            }
            com.transsion.ad.a.b(aVar, f50530a.o() + " --> downloadAdPlan() --> 图片素材下载成功 --> adPlans.id = " + adPlans.getId() + " -- adMaterial.id = " + adMaterialList2.getId() + " -- destination = " + str2, false, 2, null);
            MbAdImage image3 = adMaterialList2.getImage();
            if (image3 != null) {
                image3.setPath(str2);
            }
            adMaterialList2.setDownloadMaterialSuccess(true);
            return true;
        }
        MbAdVideo video2 = adMaterialList2.getVideo();
        int iIntValue = (video2 == null || (size = video2.getSize()) == null) ? 1 : size.intValue();
        if (file.isFile() && file.exists() && file.length() > 0) {
            MbAdVideo video3 = adMaterialList2.getVideo();
            if (video3 != null) {
                video3.setPath(str2);
            }
            adMaterialList2.setDownloadMaterialSuccess(true);
            return true;
        }
        boolean zB = d.b(d.f50607a, str, str2, false, 4, null);
        long length2 = file.length();
        if (!zB || length2 < iIntValue) {
            com.transsion.ad.a.d(aVar, f50530a.o() + " --> downloadAdPlan() --> 视频素材下载失败 -- adPlans.id = " + adPlans.getId() + " downloadFileSuccess = " + zB + " -- localFileSize = " + length2 + " -- remoteFileSize = " + iIntValue + " destination = " + str2, false, 2, null);
            return false;
        }
        com.transsion.ad.a.b(aVar, f50530a.o() + " --> downloadAdPlan() --> 视频素材下载成功 --> adPlans.id = " + adPlans.getId() + " -- adMaterial.id = " + adMaterialList2.getId() + " -- destination = " + str2, false, 2, null);
        MbAdVideo video4 = adMaterialList2.getVideo();
        if (video4 != null) {
            video4.setPath(str2);
        }
        adMaterialList2.setDownloadMaterialSuccess(true);
        return true;
    }

    public final String l(String str) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String str2 = com.transsion.ad.b.f50277a.b() + File.separatorChar + strValueOf + InstructionFileId.DOT + "mineType";
        return (f.f80673a.c(str2) || d.b(d.f50607a, str, str2, false, 4, null)) ? str2 : "";
    }

    public final void m(MbAdImage mbAdImage) {
        if (mbAdImage == null || TextUtils.isEmpty(mbAdImage.getUrl())) {
            return;
        }
        String url = mbAdImage.getUrl();
        String strC = q.c(url);
        String str = com.transsion.ad.b.f50277a.b() + File.separatorChar + strC + InstructionFileId.DOT + "mineType";
        if (f.f80673a.c(str)) {
            mbAdImage.setPath(str);
            return;
        }
        if (d.b(d.f50607a, url, str, false, 4, null)) {
            mbAdImage.setPath(str);
            com.transsion.ad.a.b(com.transsion.ad.a.f50276a, o() + " --> downloadExtImage() --> extImage下载成功 --> path = " + mbAdImage.getPath(), false, 2, null);
        }
    }

    public final Object n(AdPlans adPlans, String str, MbAdDbPlans mbAdDbPlans, Continuation<? super Unit> continuation) throws Throwable {
        Object objU;
        if (!AdPlanSourceManager.f50540a.g(adPlans)) {
            return (k(adPlans) && (objU = u(adPlans, str, mbAdDbPlans, continuation)) == kotlin.coroutines.intrinsics.a.e()) ? objU : Unit.f68710a;
        }
        AdMaterialList adMaterialList = new AdMaterialList(null, null, null, null, null, null, null, null, null, false, null, null, UnixStat.PERM_MASK, null);
        adMaterialList.setDownloadMaterialSuccess(true);
        adPlans.setAdMaterialList(kotlin.collections.f.e(adMaterialList));
        Object objU2 = u(adPlans, str, mbAdDbPlans, continuation);
        return objU2 == kotlin.coroutines.intrinsics.a.e() ? objU2 : Unit.f68710a;
    }

    public final String o() {
        String simpleName = AdPlansRequestManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final a p() {
        return (a) f50531b.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:64:0x01bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object q(MbAdPlansDto mbAdPlansDto, String str, Continuation<? super Boolean> continuation) throws Throwable {
        AdPlansRequestManager$handleResponse$1 adPlansRequestManager$handleResponse$1;
        AdPlansRequestManager adPlansRequestManager;
        MbAdPlansDto mbAdPlansDto2;
        String str2;
        MbAdPlansDto mbAdPlansDto3 = mbAdPlansDto;
        String str3 = str;
        if (continuation instanceof AdPlansRequestManager$handleResponse$1) {
            adPlansRequestManager$handleResponse$1 = (AdPlansRequestManager$handleResponse$1) continuation;
            int i11 = adPlansRequestManager$handleResponse$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$handleResponse$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlansRequestManager$handleResponse$1 = new AdPlansRequestManager$handleResponse$1(this, continuation);
            }
        } else {
            adPlansRequestManager$handleResponse$1 = new AdPlansRequestManager$handleResponse$1(this, continuation);
        }
        Object obj = adPlansRequestManager$handleResponse$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlansRequestManager$handleResponse$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                String str4 = (String) adPlansRequestManager$handleResponse$1.L$2;
                MbAdPlansDto mbAdPlansDto4 = (MbAdPlansDto) adPlansRequestManager$handleResponse$1.L$1;
                adPlansRequestManager = (AdPlansRequestManager) adPlansRequestManager$handleResponse$1.L$0;
                ResultKt.b(obj);
                str3 = str4;
                mbAdPlansDto3 = mbAdPlansDto4;
            } else if (i12 == 2) {
                str2 = (String) adPlansRequestManager$handleResponse$1.L$2;
                mbAdPlansDto2 = (MbAdPlansDto) adPlansRequestManager$handleResponse$1.L$1;
                adPlansRequestManager = (AdPlansRequestManager) adPlansRequestManager$handleResponse$1.L$0;
                ResultKt.b(obj);
                adPlansRequestManager$handleResponse$1.L$0 = null;
                adPlansRequestManager$handleResponse$1.L$1 = null;
                adPlansRequestManager$handleResponse$1.L$2 = null;
                adPlansRequestManager$handleResponse$1.label = 3;
                if (adPlansRequestManager.h(mbAdPlansDto2, str2, adPlansRequestManager$handleResponse$1) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Boxing.a(true);
        }
        ResultKt.b(obj);
        if (mbAdPlansDto3 == null) {
            com.transsion.ad.a.d(com.transsion.ad.a.f50276a, o() + " --> handleResponse() --> mbAdConfig == null --> lastVersion = " + str3, false, 2, null);
            return Boxing.a(false);
        }
        if (!Intrinsics.b(mbAdPlansDto.getCode(), "0")) {
            com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
            String strO = o();
            MbAdPlansBean data = mbAdPlansDto.getData();
            com.transsion.ad.a.d(aVar, strO + " --> handleResponse() --> mbAdConfig.code != 0 --> lastVersion = " + str3 + " --> data.version = " + (data != null ? data.getVersion() : null), false, 2, null);
            return Boxing.a(false);
        }
        com.transsion.ad.strategy.b.f50584a.e(mbAdPlansDto.getData());
        wq.d.f79584a.g(mbAdPlansDto3);
        MbAdPlansBean data2 = mbAdPlansDto.getData();
        if (TextUtils.equals(str3, String.valueOf(data2 != null ? data2.getVersion() : null))) {
            com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
            String strO2 = o();
            MbAdPlansBean data3 = mbAdPlansDto.getData();
            com.transsion.ad.a.b(aVar2, strO2 + " --> handleResponse() --> 版本号一致，服务端不会下发list 省流量 --> lastVersion = " + str3 + " --> data.version = " + (data3 != null ? data3.getVersion() : null), false, 2, null);
            return Boxing.a(true);
        }
        b bVar = b.f79053a;
        MbAdPlansBean data4 = mbAdPlansDto.getData();
        bVar.i(data4 != null ? data4.getVersion() : null, str3);
        com.transsion.ad.a aVar3 = com.transsion.ad.a.f50276a;
        String strO3 = o();
        MbAdPlansBean data5 = mbAdPlansDto.getData();
        String version = data5 != null ? data5.getVersion() : null;
        com.transsion.ad.a.b(aVar3, strO3 + " --> handleResponse() --> lastVersion = " + str3 + " --> data.version = " + version + " --> 开始增量更新 --> mbAdConfig = " + n.f().toJson(mbAdPlansDto3), false, 2, null);
        MbAdPlansBean data6 = mbAdPlansDto.getData();
        String strValueOf = String.valueOf(data6 != null ? data6.getVersion() : null);
        adPlansRequestManager$handleResponse$1.L$0 = this;
        adPlansRequestManager$handleResponse$1.L$1 = mbAdPlansDto3;
        adPlansRequestManager$handleResponse$1.L$2 = str3;
        adPlansRequestManager$handleResponse$1.label = 1;
        if (i(strValueOf, str3, adPlansRequestManager$handleResponse$1) == objE) {
            return objE;
        }
        adPlansRequestManager = this;
        adPlansRequestManager$handleResponse$1.L$0 = adPlansRequestManager;
        adPlansRequestManager$handleResponse$1.L$1 = mbAdPlansDto3;
        adPlansRequestManager$handleResponse$1.L$2 = str3;
        adPlansRequestManager$handleResponse$1.label = 2;
        if (adPlansRequestManager.t(mbAdPlansDto3, adPlansRequestManager$handleResponse$1) == objE) {
            return objE;
        }
        String str5 = str3;
        mbAdPlansDto2 = mbAdPlansDto3;
        str2 = str5;
        adPlansRequestManager$handleResponse$1.L$0 = null;
        adPlansRequestManager$handleResponse$1.L$1 = null;
        adPlansRequestManager$handleResponse$1.L$2 = null;
        adPlansRequestManager$handleResponse$1.label = 3;
        if (adPlansRequestManager.h(mbAdPlansDto2, str2, adPlansRequestManager$handleResponse$1) == objE) {
            return objE;
        }
        return Boxing.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:50:0x0116 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0117  */
    /* JADX WARN: Code duplicated, block: B:54:0x0120 A[Catch: all -> 0x012b, TryCatch #4 {all -> 0x012b, blocks: (B:60:0x013c, B:52:0x0118, B:54:0x0120, B:57:0x012e), top: B:83:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final Object r(String str, Function1<? super Boolean, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        AdPlansRequestManager$requestNonAdPlanList$1 adPlansRequestManager$requestNonAdPlanList$1;
        int i11;
        ?? r11;
        String str2;
        Object obj;
        Object objM163constructorimpl;
        ?? r12;
        ?? r13;
        boolean zBooleanValue;
        PSAdPlanRequestManager pSAdPlanRequestManager;
        MbAdPlansDto mbAdPlansDto;
        String version;
        MbAdPlansBean data;
        Object obj2;
        String str3 = "";
        if (continuation instanceof AdPlansRequestManager$requestNonAdPlanList$1) {
            adPlansRequestManager$requestNonAdPlanList$1 = (AdPlansRequestManager$requestNonAdPlanList$1) continuation;
            int i12 = adPlansRequestManager$requestNonAdPlanList$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$requestNonAdPlanList$1.label = i12 - Integer.MIN_VALUE;
            } else {
                adPlansRequestManager$requestNonAdPlanList$1 = new AdPlansRequestManager$requestNonAdPlanList$1(this, continuation);
            }
        } else {
            adPlansRequestManager$requestNonAdPlanList$1 = new AdPlansRequestManager$requestNonAdPlanList$1(this, continuation);
        }
        Object objA = adPlansRequestManager$requestNonAdPlanList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = adPlansRequestManager$requestNonAdPlanList$1.label;
        if (i13 != 0) {
            if (i13 != 1) {
                try {
                    if (i13 == 2) {
                        Function1 function2 = (Function1) adPlansRequestManager$requestNonAdPlanList$1.L$0;
                        ResultKt.b(objA);
                        i11 = 2;
                        r13 = function2;
                        try {
                            zBooleanValue = ((Boolean) objA).booleanValue();
                            if (r13 != 0) {
                            }
                            pSAdPlanRequestManager = PSAdPlanRequestManager.f50545a;
                            adPlansRequestManager$requestNonAdPlanList$1.L$0 = r13;
                            adPlansRequestManager$requestNonAdPlanList$1.label = 3;
                            r13 = r13;
                            if (pSAdPlanRequestManager.p(adPlansRequestManager$requestNonAdPlanList$1) == objE) {
                                return objE;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r11 = r13;
                            Result.Companion companion = Result.Companion;
                            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                            r12 = r11;
                        }
                    } else {
                        if (i13 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Function1 function3 = (Function1) adPlansRequestManager$requestNonAdPlanList$1.L$0;
                        ResultKt.b(objA);
                        i11 = 2;
                        r13 = function3;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    r12 = r13;
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = "";
                    i11 = 2;
                    r11 = obj2;
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    r12 = r11;
                }
            } else {
                str2 = (String) adPlansRequestManager$requestNonAdPlanList$1.L$1;
                obj2 = (Function1) adPlansRequestManager$requestNonAdPlanList$1.L$0;
                try {
                    ResultKt.b(objA);
                    i11 = 2;
                    obj = obj2;
                    try {
                        mbAdPlansDto = (MbAdPlansDto) objA;
                        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
                        AdPlansRequestManager adPlansRequestManager = f50530a;
                        String strO = adPlansRequestManager.o();
                        if (mbAdPlansDto != null || (data = mbAdPlansDto.getData()) == null) {
                            version = null;
                        } else {
                            version = data.getVersion();
                        }
                        com.transsion.ad.a.b(aVar, strO + " --> requestNonAdPlanList() --> 接口响应成功 开始处理数据 --> version = " + version, false, i11, null);
                        adPlansRequestManager$requestNonAdPlanList$1.L$0 = obj;
                        adPlansRequestManager$requestNonAdPlanList$1.L$1 = null;
                        adPlansRequestManager$requestNonAdPlanList$1.label = i11;
                        objA = adPlansRequestManager.q(mbAdPlansDto, str2, adPlansRequestManager$requestNonAdPlanList$1);
                        if (objA == objE) {
                            return objE;
                        }
                        r13 = obj;
                        zBooleanValue = ((Boolean) objA).booleanValue();
                        if (r13 != 0) {
                        }
                        pSAdPlanRequestManager = PSAdPlanRequestManager.f50545a;
                        adPlansRequestManager$requestNonAdPlanList$1.L$0 = r13;
                        adPlansRequestManager$requestNonAdPlanList$1.label = 3;
                        r13 = r13;
                        if (pSAdPlanRequestManager.p(adPlansRequestManager$requestNonAdPlanList$1) == objE) {
                            return objE;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        r12 = r13;
                    } catch (Throwable th4) {
                        th = th4;
                        r11 = obj;
                        Result.Companion companion3 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                        r12 = r11;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    i11 = 2;
                    r11 = obj2;
                }
            }
            i11 = 2;
            r11 = obj2;
            Result.Companion companion4 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
            r12 = r11;
        } else {
            ResultKt.b(objA);
            try {
                Result.Companion companion5 = Result.Companion;
                AdMmkv adMmkv = AdMmkv.f50558a;
                String string = adMmkv.b().getString("non_ad_plan_version", "");
                String string2 = adMmkv.b().getString("non_ad_scene_version", "");
                com.transsion.ad.a aVar2 = com.transsion.ad.a.f50276a;
                AdPlansRequestManager adPlansRequestManager2 = f50530a;
                com.transsion.ad.a.b(aVar2, adPlansRequestManager2.o() + " --> requestNonAdPlanList() --> 开始请求广告配置接口 --> lastVersion = " + string + " --> lastSceneVersion = " + string2 + " --> url = " + str, false, 2, null);
                a aVarP = adPlansRequestManager2.p();
                if (string != null) {
                    str3 = string;
                }
                adPlansRequestManager$requestNonAdPlanList$1.L$0 = function1;
                adPlansRequestManager$requestNonAdPlanList$1.L$1 = string;
                adPlansRequestManager$requestNonAdPlanList$1.label = 1;
                String str4 = str3;
                str2 = string;
                i11 = 2;
                try {
                    objA = a.C0869a.a(aVarP, str, str4, string2, false, adPlansRequestManager$requestNonAdPlanList$1, 8, null);
                    if (objA == objE) {
                        return objE;
                    }
                    obj = function1;
                    mbAdPlansDto = (MbAdPlansDto) objA;
                    com.transsion.ad.a aVar3 = com.transsion.ad.a.f50276a;
                    AdPlansRequestManager adPlansRequestManager3 = f50530a;
                    String strO2 = adPlansRequestManager3.o();
                    if (mbAdPlansDto != null) {
                        version = null;
                    } else {
                        version = null;
                    }
                    com.transsion.ad.a.b(aVar3, strO2 + " --> requestNonAdPlanList() --> 接口响应成功 开始处理数据 --> version = " + version, false, i11, null);
                    adPlansRequestManager$requestNonAdPlanList$1.L$0 = obj;
                    adPlansRequestManager$requestNonAdPlanList$1.L$1 = null;
                    adPlansRequestManager$requestNonAdPlanList$1.label = i11;
                    objA = adPlansRequestManager3.q(mbAdPlansDto, str2, adPlansRequestManager$requestNonAdPlanList$1);
                    if (objA == objE) {
                        return objE;
                    }
                    r13 = obj;
                    zBooleanValue = ((Boolean) objA).booleanValue();
                    if (r13 != 0) {
                    }
                    pSAdPlanRequestManager = PSAdPlanRequestManager.f50545a;
                    adPlansRequestManager$requestNonAdPlanList$1.L$0 = r13;
                    adPlansRequestManager$requestNonAdPlanList$1.label = 3;
                    r13 = r13;
                    if (pSAdPlanRequestManager.p(adPlansRequestManager$requestNonAdPlanList$1) == objE) {
                        return objE;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    r12 = r13;
                } catch (Throwable th6) {
                    th = th6;
                    r11 = function1;
                }
            } catch (Throwable th7) {
                th = th7;
                i11 = 2;
            }
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            if (r12 != 0) {
            }
            com.transsion.ad.a.d(com.transsion.ad.a.f50276a, f50530a.o() + " --> requestNonAdPlanList() --> fail fail fail --> 请求非标广告计划列表失败 it = " + thM166exceptionOrNullimpl, false, i11, null);
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:45:0x0110 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0111  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:51:0x0136 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0137  */
    /* JADX WARN: Code duplicated, block: B:55:0x0143  */
    /* JADX WARN: Code duplicated, block: B:58:0x0150  */
    /* JADX WARN: Code duplicated, block: B:60:0x0153  */
    /* JADX WARN: Code duplicated, block: B:61:0x0158  */
    /* JADX WARN: Code duplicated, block: B:64:0x015c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0169  */
    /* JADX WARN: Code duplicated, block: B:72:0x0192 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0193  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f  */
    /* JADX WARN: Code duplicated, block: B:77:0x01bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0178 -> B:79:0x01c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0193 -> B:74:0x0196). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x01bd -> B:74:0x0196). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object t(com.transsion.ad.monopoly.model.MbAdPlansDto r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.t(com.transsion.ad.monopoly.model.MbAdPlansDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object u(AdPlans adPlans, String str, MbAdDbPlans mbAdDbPlans, Continuation<? super Boolean> continuation) throws Throwable {
        AdPlansRequestManager$updateAdPlanToDatabase$1 adPlansRequestManager$updateAdPlanToDatabase$1;
        MbAdDbPlans mbAdDbPlansE;
        AdPlansRequestManager adPlansRequestManager;
        if (continuation instanceof AdPlansRequestManager$updateAdPlanToDatabase$1) {
            adPlansRequestManager$updateAdPlanToDatabase$1 = (AdPlansRequestManager$updateAdPlanToDatabase$1) continuation;
            int i11 = adPlansRequestManager$updateAdPlanToDatabase$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlansRequestManager$updateAdPlanToDatabase$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlansRequestManager$updateAdPlanToDatabase$1 = new AdPlansRequestManager$updateAdPlanToDatabase$1(this, continuation);
            }
        } else {
            adPlansRequestManager$updateAdPlanToDatabase$1 = new AdPlansRequestManager$updateAdPlanToDatabase$1(this, continuation);
        }
        Object obj = adPlansRequestManager$updateAdPlanToDatabase$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlansRequestManager$updateAdPlanToDatabase$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            Integer showedTimes = (!TextUtils.equals(mbAdDbPlans != null ? mbAdDbPlans.getShowDate() : null, k.f80682a.c()) || mbAdDbPlans == null) ? null : mbAdDbPlans.getShowedTimes();
            adPlans.setShowDate(mbAdDbPlans != null ? mbAdDbPlans.getShowDate() : null);
            adPlans.setShowedTimes(showedTimes);
            mbAdDbPlansE = AdPlansTransform.f50542a.e(adPlans);
            mbAdDbPlansE.setVersion(str);
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
            adPlansRequestManager$updateAdPlanToDatabase$1.L$0 = this;
            adPlansRequestManager$updateAdPlanToDatabase$1.L$1 = mbAdDbPlansE;
            adPlansRequestManager$updateAdPlanToDatabase$1.label = 1;
            if (adPlansStorageManager.k(mbAdDbPlansE, adPlansRequestManager$updateAdPlanToDatabase$1) == objE) {
                return objE;
            }
            adPlansRequestManager = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mbAdDbPlansE = (MbAdDbPlans) adPlansRequestManager$updateAdPlanToDatabase$1.L$1;
            adPlansRequestManager = (AdPlansRequestManager) adPlansRequestManager$updateAdPlanToDatabase$1.L$0;
            ResultKt.b(obj);
        }
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, adPlansRequestManager.o() + " --> updateAdPlanToDatabase() --> 保存非标广告计划列表到数据库成功 --> transformAdPlans = " + mbAdDbPlansE.getName(), false, 2, null);
        return Boxing.a(true);
    }
}
