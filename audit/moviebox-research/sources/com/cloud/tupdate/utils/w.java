package com.cloud.tupdate.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cloud.tupdate.TUpdate;
import com.cloud.tupdate.bean.UpdateContent;
import com.cloud.tupdate.bean.UpdateEntity;
import com.cloud.tupdate.net.utils.LogUtil;
import com.transsion.gslb.Utils;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f32268a = new w();

    public static /* synthetic */ void m(w wVar, UpdateEntity updateEntity, te.e eVar, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        wVar.l(updateEntity, eVar, z11);
    }

    public static /* synthetic */ void q(w wVar, Context context, String str, int i11, Long l11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            l11 = null;
        }
        wVar.p(context, str, i11, l11);
    }

    public static /* synthetic */ void v(w wVar, String str, int i11, String str2, Long l11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            l11 = null;
        }
        wVar.u(str, i11, str2, l11);
    }

    public final boolean a() {
        Object systemService = TUpdate.f32174c.b().b().getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void b(UpdateEntity updateEntity, te.e eVar, String str) {
        int i11 = Calendar.getInstance().get(5);
        UpdateContent updateContent = updateEntity.getUpdateContent();
        if ((updateContent == null ? null : updateContent.getUpdateInterval()) == null || !(!updateEntity.getUpdateContent().getUpdateInterval().isEmpty())) {
            if (i(eVar.getContext(), "tupdate_update_day", i11)) {
                a.j().d("update", "非时间间隔的自动普通升级");
                f(updateEntity, eVar, str);
                return;
            } else {
                b.f32235a.h(3);
                e(updateEntity, eVar);
                return;
            }
        }
        if (j(updateEntity, "upgrade_record")) {
            a.j().d("update", "根据时间间隔的自动普通升级");
            f(updateEntity, eVar, str);
        } else {
            b.f32235a.h(2);
            e(updateEntity, eVar);
        }
    }

    public final void c(UpdateEntity updateEntity, te.e eVar) {
        String updateUrl;
        UpdateContent updateContent = updateEntity.getUpdateContent();
        String str = "";
        if (updateContent != null && (updateUrl = updateContent.getUpdateUrl()) != null) {
            str = updateUrl;
        }
        String strValueOf = String.valueOf(str.hashCode());
        if (updateEntity.getUpdateContent() == null || !Intrinsics.b(updateEntity.getUpdateContent().getShowDialog(), Boolean.TRUE) || g(updateEntity.getUpdateContent().getUpdateVersion())) {
            e(updateEntity, eVar);
        } else {
            b(updateEntity, eVar, strValueOf);
        }
    }

    public final void d(UpdateEntity updateEntity, te.e eVar, boolean z11) {
        if (updateEntity.getUpdateContent() == null || !Intrinsics.b(updateEntity.getUpdateContent().getShowDialog(), Boolean.TRUE)) {
            return;
        }
        a.j().d("update", "手动普通升级");
        eVar.j(updateEntity, eVar, z11);
    }

    public final void e(UpdateEntity updateEntity, te.e eVar) {
        UpdateContent updateContent;
        UpdateContent updateContent2 = updateEntity.getUpdateContent();
        String updateVersion = updateContent2 == null ? null : updateContent2.getUpdateVersion();
        if (updateEntity.getAppScoreContent() == null || (updateContent = updateEntity.getUpdateContent()) == null || !Intrinsics.b(updateContent.getShowDialog(), Boolean.FALSE)) {
            return;
        }
        if (!Intrinsics.b(updateEntity.getAppScoreContent().getShowAfterUpdate(), Boolean.TRUE)) {
            if (h(TUpdate.f32174c.a(), updateEntity)) {
                a.j().d("update", "升级后弹评分引导关闭，根据时间间隔弹评分弹框");
                eVar.i(updateEntity, eVar);
                return;
            }
            return;
        }
        a.j().d("update", "升级后自动弹评分 开关 = true");
        if (!k(updateVersion)) {
            a.j().d("update", "升级后自动弹评分弹框");
            eVar.i(updateEntity, eVar);
            p(TUpdate.f32174c.a(), updateVersion, -1, Long.valueOf(System.currentTimeMillis()));
        } else if (h(TUpdate.f32174c.a(), updateEntity)) {
            a.j().d("update", "升级后根据时间间隔弹评分弹框");
            eVar.i(updateEntity, eVar);
        }
        s(updateVersion, true);
    }

    public final void f(UpdateEntity updateEntity, te.e eVar, String str) {
        te.e.a.a(eVar, updateEntity, eVar, false, 4, null);
    }

    public final boolean g(String str) {
        String ignoreInstallDialogValue;
        boolean z11 = false;
        if (str != null && !kotlin.text.l.y(str) && (ignoreInstallDialogValue = v.f32267a.a().j("ignore_upgrade_dialog", "")) != null && !kotlin.text.l.y(ignoreInstallDialogValue)) {
            Intrinsics.f(ignoreInstallDialogValue, "ignoreInstallDialogValue");
            List listE0 = StringsKt__StringsKt.E0(ignoreInstallDialogValue, new String[]{"-"}, false, 0, 6, null);
            if (listE0.size() == 2 && Intrinsics.b(str, listE0.get(0)) && (z11 = Boolean.parseBoolean((String) listE0.get(1)))) {
                b.f32235a.h(1);
            }
        }
        return z11;
    }

    public final boolean h(Context context, UpdateEntity updateEntity) {
        String updateVersion;
        int i11;
        if (context != null && updateEntity.getAppScoreContent() != null) {
            UpdateContent updateContent = updateEntity.getUpdateContent();
            String str = (updateContent == null || (updateVersion = updateContent.getUpdateVersion()) == null) ? "" : updateVersion;
            v vVar = v.f32267a;
            String scoreRecordValue = vVar.a().j("score_record", "");
            if (vVar.a().c(str, false)) {
                return false;
            }
            if (scoreRecordValue != null && !kotlin.text.l.y(scoreRecordValue)) {
                Intrinsics.f(scoreRecordValue, "scoreRecordValue");
                List listE0 = StringsKt__StringsKt.E0(scoreRecordValue, new String[]{Utils.SEPARATOR}, false, 0, 6, null);
                if (listE0.size() == 3) {
                    String str2 = (String) listE0.get(0);
                    int i12 = Integer.parseInt((String) listE0.get(1));
                    long j11 = Long.parseLong((String) listE0.get(2));
                    try {
                        if (!Intrinsics.b(str2, str)) {
                            p(context, str, -1, Long.valueOf(System.currentTimeMillis()));
                            return false;
                        }
                        if (updateEntity.getAppScoreContent().getIntervalDays() == null || updateEntity.getAppScoreContent().getIntervalDays().isEmpty() || updateEntity.getAppScoreContent().getIntervalDays().size() - 1 < (i11 = i12 + 1)) {
                            return false;
                        }
                        float f11 = 60;
                        if (System.currentTimeMillis() - j11 <= updateEntity.getAppScoreContent().getIntervalDays().get(i11).floatValue() * 24 * f11 * f11 * 1000) {
                            return false;
                        }
                        q(this, context, str2, i11, null, 8, null);
                        return true;
                    } catch (Exception e11) {
                        LogUtil.f32213a.d(e11);
                    }
                }
                return false;
            }
            q(this, context, str, -1, null, 8, null);
        }
        return false;
    }

    public final boolean i(Context context, String str, int i11) {
        return context == null || v.f32267a.a().f(str, 0) != i11;
    }

    public final boolean j(UpdateEntity updateEntity, String str) {
        int i11;
        if (updateEntity.getUpdateContent() == null) {
            return false;
        }
        String updateVersion = updateEntity.getUpdateContent().getUpdateVersion();
        String str2 = updateVersion == null ? "" : updateVersion;
        String updateRecordValue = v.f32267a.a().j(str, "");
        if (updateRecordValue == null || kotlin.text.l.y(updateRecordValue)) {
            v(this, str2, -1, str, null, 8, null);
            return true;
        }
        Intrinsics.f(updateRecordValue, "updateRecordValue");
        List listE0 = StringsKt__StringsKt.E0(updateRecordValue, new String[]{Utils.SEPARATOR}, false, 0, 6, null);
        if (listE0.size() == 3) {
            String str3 = (String) listE0.get(0);
            int i12 = Integer.parseInt((String) listE0.get(1));
            long j11 = Long.parseLong((String) listE0.get(2));
            try {
                if (!Intrinsics.b(str3, str2)) {
                    u(str2, -1, str, Long.valueOf(System.currentTimeMillis()));
                    return true;
                }
                if (updateEntity.getUpdateContent().getUpdateInterval() == null || updateEntity.getUpdateContent().getUpdateInterval().isEmpty() || updateEntity.getUpdateContent().getUpdateInterval().size() - 1 < (i11 = i12 + 1)) {
                    return false;
                }
                float f11 = 60;
                if (System.currentTimeMillis() - j11 <= updateEntity.getUpdateContent().getUpdateInterval().get(i11).floatValue() * 24 * f11 * f11 * 1000) {
                    return false;
                }
                v(this, str3, i11, str, null, 8, null);
                return true;
            } catch (Exception e11) {
                LogUtil.f32213a.d(e11);
            }
        }
        return false;
    }

    public final boolean k(String str) {
        a.j().d("update", Intrinsics.p("version = ", str));
        if (str == null || kotlin.text.l.y(str)) {
            return false;
        }
        String isShowScoreDialogValue = v.f32267a.a().j("is_show_After_Update", "");
        a.j().d("update", Intrinsics.p("isShowScoreDialogValue = ", isShowScoreDialogValue));
        if (isShowScoreDialogValue == null || kotlin.text.l.y(isShowScoreDialogValue)) {
            return false;
        }
        Intrinsics.f(isShowScoreDialogValue, "isShowScoreDialogValue");
        List listE0 = StringsKt__StringsKt.E0(isShowScoreDialogValue, new String[]{"-"}, false, 0, 6, null);
        if (listE0.size() == 2 && Intrinsics.b(str, listE0.get(0))) {
            return Boolean.parseBoolean((String) listE0.get(1));
        }
        return false;
    }

    public final void l(UpdateEntity updateEntity, te.e updateManager, boolean z11) {
        Boolean showDialog;
        UpdateContent updateContent;
        Intrinsics.g(updateManager, "updateManager");
        if (updateEntity == null) {
            return;
        }
        v vVar = v.f32267a;
        if (vVar.a().c("show_dialog_flag", false) && (updateContent = updateEntity.getUpdateContent()) != null && Intrinsics.b(updateContent.getShowDialog(), Boolean.FALSE)) {
            b.f32235a.f();
        }
        UpdateContent updateContent2 = updateEntity.getUpdateContent();
        if (updateContent2 != null && (showDialog = updateContent2.getShowDialog()) != null) {
            boolean zBooleanValue = showDialog.booleanValue();
            if (zBooleanValue) {
                b bVar = b.f32235a;
                Context context = updateManager.getContext();
                bVar.g(context == null ? null : d.f32241a.j(context), updateEntity.getUpdateContent().getUpdateVersion());
            }
            vVar.a().l("show_dialog_flag", zBooleanValue);
        }
        a aVarJ = a.j();
        UpdateContent updateContent3 = updateEntity.getUpdateContent();
        aVarJ.d("update", Intrinsics.p("定向条件结果 = ", updateContent3 != null ? updateContent3.getCriteriaResult() : null));
        if (updateEntity.getUpdateContent() != null) {
            Boolean showDialog2 = updateEntity.getUpdateContent().getShowDialog();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.b(showDialog2, bool) && Intrinsics.b(updateEntity.getUpdateContent().getForce(), bool)) {
                a.j().d("update", "强制升级");
                updateManager.j(updateEntity, updateManager, z11);
                return;
            }
        }
        if (z11) {
            f32268a.d(updateEntity, updateManager, z11);
        } else {
            f32268a.c(updateEntity, updateManager);
        }
    }

    public final <T> T n(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public final void o(String str, boolean z11) {
        if (str == null || kotlin.text.l.y(str)) {
            return;
        }
        com.transsion.core.utils.f fVarA = v.f32267a.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) str);
        sb2.append('-');
        sb2.append(z11);
        fVarA.p("ignore_upgrade_dialog", sb2.toString());
    }

    public final void p(Context context, String str, int i11, Long l11) {
        if (context == null || str == null) {
            return;
        }
        try {
            if (l11 == null) {
                v vVar = v.f32267a;
                String strJ = vVar.a().j("score_record", "");
                Intrinsics.f(strJ, "SharedPreferencesHelper.…ing(KEY_SCORE_RECORD, \"\")");
                if (kotlin.text.l.y(strJ)) {
                    vVar.a().p("score_record", ((Object) str) + "#-1#" + System.currentTimeMillis());
                } else {
                    String str2 = (String) StringsKt__StringsKt.E0(strJ, new String[]{Utils.SEPARATOR}, false, 0, 6, null).get(2);
                    vVar.a().p("score_record", ((Object) str) + '#' + i11 + '#' + str2);
                }
            } else {
                com.transsion.core.utils.f fVarA = v.f32267a.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) str);
                sb2.append('#');
                sb2.append(i11);
                sb2.append('#');
                sb2.append(l11);
                fVarA.p("score_record", sb2.toString());
            }
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    public final void r(Context context, String str, boolean z11) {
        if (context == null || str == null || kotlin.text.l.y(str)) {
            return;
        }
        v.f32267a.a().l(str, z11);
    }

    public final void s(String str, boolean z11) {
        if (str == null || kotlin.text.l.y(str)) {
            return;
        }
        v vVar = v.f32267a;
        String isShowScoreDialogValue = vVar.a().j("is_show_After_Update", "");
        a.j().d("update", Intrinsics.p("saveShowScoreDialogValue --> isShowScoreDialogValue = ", isShowScoreDialogValue));
        if (isShowScoreDialogValue == null || kotlin.text.l.y(isShowScoreDialogValue)) {
            com.transsion.core.utils.f fVarA = vVar.a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) str);
            sb2.append('-');
            sb2.append(z11);
            fVarA.p("is_show_After_Update", sb2.toString());
            return;
        }
        Intrinsics.f(isShowScoreDialogValue, "isShowScoreDialogValue");
        if (Intrinsics.b(str, StringsKt__StringsKt.E0(isShowScoreDialogValue, new String[]{"-"}, false, 0, 6, null).get(0))) {
            return;
        }
        com.transsion.core.utils.f fVarA2 = vVar.a();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((Object) str);
        sb3.append('-');
        sb3.append(z11);
        fVarA2.p("is_show_After_Update", sb3.toString());
    }

    public final void t(Context context, String judgeKey, int i11) {
        Intrinsics.g(judgeKey, "judgeKey");
        if (context == null) {
            return;
        }
        v.f32267a.a().n(judgeKey, i11);
    }

    public final void u(String str, int i11, String str2, Long l11) {
        if (str == null) {
            return;
        }
        try {
            if (l11 == null) {
                v vVar = v.f32267a;
                String strJ = vVar.a().j(str2, "");
                Intrinsics.f(strJ, "SharedPreferencesHelper.…e.getString(judgeKey, \"\")");
                if (kotlin.text.l.y(strJ)) {
                    vVar.a().p(str2, ((Object) str) + "#-1#" + System.currentTimeMillis());
                } else {
                    String str3 = (String) StringsKt__StringsKt.E0(strJ, new String[]{Utils.SEPARATOR}, false, 0, 6, null).get(2);
                    vVar.a().p(str2, ((Object) str) + '#' + i11 + '#' + str3);
                }
            } else {
                com.transsion.core.utils.f fVarA = v.f32267a.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) str);
                sb2.append('#');
                sb2.append(i11);
                sb2.append('#');
                sb2.append(l11);
                fVarA.p(str2, sb2.toString());
            }
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }
}
