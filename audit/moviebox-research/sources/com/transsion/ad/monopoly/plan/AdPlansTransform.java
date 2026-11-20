package com.transsion.ad.monopoly.plan;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.google.gson.reflect.TypeToken;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.CtxAttributeConfig;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.ps.model.PsLinkAdInfo;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.d;
import kotlin.collections.f;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tools.zip.UnixStat;
import sq.a;

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
public final class AdPlansTransform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlansTransform f50542a = new AdPlansTransform();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50543b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.ad.monopoly.plan.AdPlansTransform$psLinkAdPlanDao$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            MbAdDatabase.e eVar = MbAdDatabase.f50387p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return eVar.b(applicationA).O();
        }
    });

    public final String b() {
        String simpleName = AdPlansTransform.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final a c() {
        return (a) f50543b.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object d(AdPlans adPlans, MbAdDbPlans mbAdDbPlans, Continuation<? super Unit> continuation) throws Throwable {
        AdPlansTransform$parsePsAdPlansMaterialList$1 adPlansTransform$parsePsAdPlansMaterialList$1;
        AdMaterialList adMaterialList;
        Object objD;
        Integer num;
        AdPlans adPlans2;
        int iIntValue;
        if (continuation instanceof AdPlansTransform$parsePsAdPlansMaterialList$1) {
            adPlansTransform$parsePsAdPlansMaterialList$1 = (AdPlansTransform$parsePsAdPlansMaterialList$1) continuation;
            int i11 = adPlansTransform$parsePsAdPlansMaterialList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlansTransform$parsePsAdPlansMaterialList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlansTransform$parsePsAdPlansMaterialList$1 = new AdPlansTransform$parsePsAdPlansMaterialList$1(this, continuation);
            }
        } else {
            adPlansTransform$parsePsAdPlansMaterialList$1 = new AdPlansTransform$parsePsAdPlansMaterialList$1(this, continuation);
        }
        Object obj = adPlansTransform$parsePsAdPlansMaterialList$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlansTransform$parsePsAdPlansMaterialList$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            adMaterialList = new AdMaterialList(null, null, null, null, null, null, null, null, null, false, null, null, UnixStat.PERM_MASK, null);
            adMaterialList.setDownloadMaterialSuccess(true);
            Integer showedTimes = mbAdDbPlans != null ? mbAdDbPlans.getShowedTimes() : null;
            if (mbAdDbPlans == null || (objD = mbAdDbPlans.getExtAdSlot()) == null) {
                objD = Boxing.d(14);
            }
            a aVarC = c();
            String string = objD.toString();
            adPlansTransform$parsePsAdPlansMaterialList$1.L$0 = adPlans;
            adPlansTransform$parsePsAdPlansMaterialList$1.L$1 = adMaterialList;
            adPlansTransform$parsePsAdPlansMaterialList$1.L$2 = showedTimes;
            adPlansTransform$parsePsAdPlansMaterialList$1.label = 1;
            Object objC = aVarC.c(string, adPlansTransform$parsePsAdPlansMaterialList$1);
            if (objC == objE) {
                return objE;
            }
            num = showedTimes;
            obj = objC;
            adPlans2 = adPlans;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            num = (Integer) adPlansTransform$parsePsAdPlansMaterialList$1.L$2;
            adMaterialList = (AdMaterialList) adPlansTransform$parsePsAdPlansMaterialList$1.L$1;
            adPlans2 = (AdPlans) adPlansTransform$parsePsAdPlansMaterialList$1.L$0;
            ResultKt.b(obj);
        }
        List list = (List) obj;
        Integer numD = list != null ? Boxing.d(list.size()) : null;
        if (numD != null && numD.intValue() >= 1) {
            if (num != null) {
                iIntValue = num.intValue() % (numD != null ? numD.intValue() : 1);
            } else {
                iIntValue = 0;
            }
            PsLinkAdPlan psLinkAdPlan = list != null ? (PsLinkAdPlan) CollectionsKt___CollectionsKt.h0(list, iIntValue) : null;
            if (psLinkAdPlan != null) {
                PsLinkAdInfo psLinkAdInfo = (PsLinkAdInfo) n.d(psLinkAdPlan.getPsLinkAdInfoStr(), PsLinkAdInfo.class);
                RecommendInfo recommendInfo = (RecommendInfo) n.d(psLinkAdPlan.getPsInfoJson(), RecommendInfo.class);
                adMaterialList.setType(AdMaterialList.NON_AD_TYPE_TEXT);
                adMaterialList.setTitle(psLinkAdInfo != null ? psLinkAdInfo.getTitle() : null);
                adMaterialList.setDesc(psLinkAdInfo != null ? psLinkAdInfo.getDesc() : null);
                adMaterialList.setPsRecommendInfo(recommendInfo);
                adMaterialList.setImage(new MbAdImage(null, psLinkAdInfo != null ? psLinkAdInfo.getUrl() : null, null, null, null, null, null, null, null, psLinkAdInfo.getPath(), null, null, 3581, null));
                adMaterialList.setButtonText(psLinkAdInfo.getButtonText());
                if (adPlans2 != null) {
                    adPlans2.setAdvertiserName(psLinkAdInfo.getAdvertiserName());
                    adPlans2.setAdvertiserAvatar(psLinkAdInfo.getAdvertiserAvatar());
                    adPlans2.setAdvertiserAvatarPath(psLinkAdInfo.getAdvertiserAvatarPath());
                }
                if (adPlans2 != null) {
                    adPlans2.setExtImage(new MbAdImage(null, adPlans2.getAdvertiserAvatar(), null, null, null, null, null, null, null, adPlans2.getAdvertiserAvatarPath(), null, null, 3581, null));
                }
            }
        }
        if (adPlans2 != null) {
            adPlans2.setAdMaterialList(f.e(adMaterialList));
        }
        return Unit.f68710a;
    }

    public final MbAdDbPlans e(AdPlans adPlans) {
        String id2;
        if (adPlans == null || (id2 = adPlans.getId()) == null) {
            id2 = "";
        }
        String str = id2;
        String version = adPlans != null ? adPlans.getVersion() : null;
        String name = adPlans != null ? adPlans.getName() : null;
        String startTime = adPlans != null ? adPlans.getStartTime() : null;
        String endTime = adPlans != null ? adPlans.getEndTime() : null;
        String extraConfig = adPlans != null ? adPlans.getExtraConfig() : null;
        Integer displayTimes = adPlans != null ? adPlans.getDisplayTimes() : null;
        Integer showedTimes = adPlans != null ? adPlans.getShowedTimes() : null;
        String showDate = adPlans != null ? adPlans.getShowDate() : null;
        String advertiserName = adPlans != null ? adPlans.getAdvertiserName() : null;
        String advertiserAvatar = adPlans != null ? adPlans.getAdvertiserAvatar() : null;
        String advertiserAvatarPath = adPlans != null ? adPlans.getAdvertiserAvatarPath() : null;
        String strJ = n.j(adPlans != null ? adPlans.getBrand() : null);
        String strJ2 = n.j(adPlans != null ? adPlans.getDenyBrand() : null);
        String strJ3 = n.j(adPlans != null ? adPlans.getModel() : null);
        String strJ4 = n.j(adPlans != null ? adPlans.getDenyModel() : null);
        String strJ5 = n.j(adPlans != null ? adPlans.getCountry() : null);
        String strJ6 = n.j(adPlans != null ? adPlans.getScenes() : null);
        String adPlanUpdateTime = adPlans != null ? adPlans.getAdPlanUpdateTime() : null;
        String adSource = adPlans != null ? adPlans.getAdSource() : null;
        String extAdSlot = adPlans != null ? adPlans.getExtAdSlot() : null;
        Integer sort = adPlans != null ? adPlans.getSort() : null;
        return new MbAdDbPlans(str, version, name, startTime, endTime, extraConfig, displayTimes, showedTimes, showDate, advertiserName, advertiserAvatar, advertiserAvatarPath, strJ, strJ2, strJ3, strJ4, strJ5, strJ6, adSource, extAdSlot, n.j(adPlans != null ? adPlans.getAdMaterialList() : null), adPlanUpdateTime, sort, adPlans != null ? adPlans.getAdShowLevel() : null, adPlans != null ? adPlans.getFilterClientVersion() : null, adPlans != null ? adPlans.getAdPlanCreateTime() : null, adPlans != null ? adPlans.getAppStarDesc() : null, adPlans != null ? adPlans.getAppSizeDesc() : null, adPlans != null ? adPlans.getCtxEnableExpr() : null, adPlans != null ? adPlans.getCtxDisableExpr() : null, n.j(adPlans != null ? adPlans.getCtxAttributeConfig() : null), adPlans != null ? adPlans.getDispatchTimeStart() : null, adPlans != null ? adPlans.getDispatchTimeEnd() : null, n.j(adPlans != null ? adPlans.getExtImage() : null), adPlans != null ? adPlans.getBidEcpmCent() : null, adPlans != null ? adPlans.getEcpmCent() : null);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0199  */
    /* JADX WARN: Code duplicated, block: B:58:0x019b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x019b, please report this as an issue */
    public final Object f(MbAdDbPlans mbAdDbPlans, Continuation<? super AdPlans> continuation) {
        AdPlansTransform$transformPlanDb2Bean$1 adPlansTransform$transformPlanDb2Bean$1;
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        AdPlans adPlans;
        AdPlans adPlans2;
        if (continuation instanceof AdPlansTransform$transformPlanDb2Bean$1) {
            adPlansTransform$transformPlanDb2Bean$1 = (AdPlansTransform$transformPlanDb2Bean$1) continuation;
            int i11 = adPlansTransform$transformPlanDb2Bean$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                adPlansTransform$transformPlanDb2Bean$1.label = i11 - Integer.MIN_VALUE;
            } else {
                adPlansTransform$transformPlanDb2Bean$1 = new AdPlansTransform$transformPlanDb2Bean$1(this, continuation);
            }
        } else {
            adPlansTransform$transformPlanDb2Bean$1 = new AdPlansTransform$transformPlanDb2Bean$1(this, continuation);
        }
        Object obj = adPlansTransform$transformPlanDb2Bean$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = adPlansTransform$transformPlanDb2Bean$1.label;
        try {
            if (i12 == 0) {
                ResultKt.b(obj);
                if (mbAdDbPlans == null) {
                    return null;
                }
                Result.Companion companion = Result.Companion;
                String id2 = mbAdDbPlans.getId();
                String version = mbAdDbPlans.getVersion();
                String name = mbAdDbPlans.getName();
                String advertiserName = mbAdDbPlans.getAdvertiserName();
                String advertiserAvatar = mbAdDbPlans.getAdvertiserAvatar();
                String advertiserAvatarPath = mbAdDbPlans.getAdvertiserAvatarPath();
                Integer displayTimes = mbAdDbPlans.getDisplayTimes();
                Integer showedTimes = mbAdDbPlans.getShowedTimes();
                String showDate = mbAdDbPlans.getShowDate();
                String[] strArr = (String[]) n.d(mbAdDbPlans.getScenes(), String[].class);
                List listA0 = strArr != null ? d.A0(strArr) : null;
                String[] strArr2 = (String[]) n.d(mbAdDbPlans.getCountry(), String[].class);
                List listA1 = strArr2 != null ? d.A0(strArr2) : null;
                String[] strArr3 = (String[]) n.d(mbAdDbPlans.getBrand(), String[].class);
                List listA2 = strArr3 != null ? d.A0(strArr3) : null;
                String[] strArr4 = (String[]) n.d(mbAdDbPlans.getDenyBrand(), String[].class);
                List listA3 = strArr4 != null ? d.A0(strArr4) : null;
                String[] strArr5 = (String[]) n.d(mbAdDbPlans.getModel(), String[].class);
                List listA4 = strArr5 != null ? d.A0(strArr5) : null;
                String[] strArr6 = (String[]) n.d(mbAdDbPlans.getDenyModel(), String[].class);
                List listA5 = strArr6 != null ? d.A0(strArr6) : null;
                String startTime = mbAdDbPlans.getStartTime();
                String endTime = mbAdDbPlans.getEndTime();
                String extraConfig = mbAdDbPlans.getExtraConfig();
                String adPlanUpdateTime = mbAdDbPlans.getAdPlanUpdateTime();
                String adSource = mbAdDbPlans.getAdSource();
                String extAdSlot = mbAdDbPlans.getExtAdSlot();
                adPlans = new AdPlans(id2, name, mbAdDbPlans.getSort(), advertiserName, advertiserAvatar, advertiserAvatarPath, showedTimes, showDate, listA0, displayTimes, listA1, listA2, listA3, listA4, listA5, mbAdDbPlans.getFilterClientVersion(), startTime, endTime, extraConfig, (List) n.e(mbAdDbPlans.getAdMaterialList(), new TypeToken<List<? extends AdMaterialList>>() { // from class: com.transsion.ad.monopoly.plan.AdPlansTransform$transformPlanDb2Bean$2$adPlans$1
                }.getType()), mbAdDbPlans.getAdPlanCreateTime(), adPlanUpdateTime, mbAdDbPlans.getAdShowLevel(), mbAdDbPlans.getAppStarDesc(), mbAdDbPlans.getAppSizeDesc(), mbAdDbPlans.getCtxEnableExpr(), mbAdDbPlans.getCtxDisableExpr(), (CtxAttributeConfig) n.d(mbAdDbPlans.getCtxAttributeConfig(), CtxAttributeConfig.class), mbAdDbPlans.getDispatchTimeStart(), mbAdDbPlans.getDispatchTimeEnd(), adSource, extAdSlot, (MbAdImage) n.d(mbAdDbPlans.getExtImage(), MbAdImage.class), version, mbAdDbPlans.getBidEcpmCent(), mbAdDbPlans.getEcpmCent());
                if (AdPlanSourceManager.f50540a.g(adPlans)) {
                    AdPlansTransform adPlansTransform = f50542a;
                    adPlansTransform$transformPlanDb2Bean$1.L$0 = adPlans;
                    adPlansTransform$transformPlanDb2Bean$1.label = 1;
                    if (adPlansTransform.d(adPlans, mbAdDbPlans, adPlansTransform$transformPlanDb2Bean$1) == objE) {
                        return objE;
                    }
                    adPlans2 = adPlans;
                }
                objM163constructorimpl = Result.m163constructorimpl(adPlans);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl == null) {
                    return objM163constructorimpl;
                }
                com.transsion.ad.a.z(com.transsion.ad.a.f50276a, f50542a.b() + " --> transformPlanDb2Bean() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
                return null;
            }
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            adPlans2 = (AdPlans) adPlansTransform$transformPlanDb2Bean$1.L$0;
            ResultKt.b(obj);
            adPlans = adPlans2;
            objM163constructorimpl = Result.m163constructorimpl(adPlans);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return objM163constructorimpl;
        }
        com.transsion.ad.a.z(com.transsion.ad.a.f50276a, f50542a.b() + " --> transformPlanDb2Bean() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
        return null;
    }
}
