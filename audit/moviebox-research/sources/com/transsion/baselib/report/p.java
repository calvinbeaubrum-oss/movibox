package com.transsion.baselib.report;

import android.os.Bundle;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<String> f51287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f51288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ILoginApi f51289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IMemberApi f51290d;

    public p() {
        HashSet<String> hashSet = new HashSet<>();
        this.f51287a = hashSet;
        this.f51288b = "ext";
        hashSet.add(AppStartDotState.APP_START);
        this.f51287a.add("app_stop");
        this.f51287a.add("download_click");
    }

    @Override // com.transsion.baselib.report.n
    public Bundle a(String event, Bundle bundle) {
        MemberDetail memberDetailM;
        Integer daysLeft;
        UserInfo userInfoP;
        Intrinsics.g(event, "event");
        Intrinsics.g(bundle, "bundle");
        bundle.putString("play_mode", String.valueOf(com.transsion.baselib.utils.m.f51320a.b()));
        fp.b.f65208a.a(bundle);
        if (this.f51289c == null) {
            synchronized (this) {
                try {
                    if (this.f51289c == null) {
                        this.f51289c = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (this.f51290d == null) {
            synchronized (this) {
                try {
                    if (this.f51290d == null) {
                        this.f51290d = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
                    }
                    Unit unit2 = Unit.f68710a;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        ILoginApi iLoginApi = this.f51289c;
        if (iLoginApi != null && (userInfoP = iLoginApi.P()) != null) {
            bundle.putString("myuserid", String.valueOf(userInfoP.getUserId()));
        }
        IMemberApi iMemberApi = this.f51290d;
        if (iMemberApi != null && (memberDetailM = iMemberApi.M()) != null) {
            MemberInfo memberInfo = memberDetailM.getMemberInfo();
            int iIntValue = 0;
            bundle.putBoolean("is_member", memberInfo != null ? memberInfo.isActive() : false);
            MemberInfo memberInfo2 = memberDetailM.getMemberInfo();
            if (memberInfo2 != null && (daysLeft = memberInfo2.getDaysLeft()) != null) {
                iIntValue = daysLeft.intValue();
            }
            bundle.putString("trial_days", String.valueOf(iIntValue));
            MemberInfo memberInfo3 = memberDetailM.getMemberInfo();
            bundle.putString("expiry_date", memberInfo3 != null ? memberInfo3.getExpiryDate() : null);
        }
        if (this.f51287a.contains(event)) {
            String string = bundle.getString(this.f51288b);
            String string2 = bundle.getString("net_state");
            uo.b.f78622a.c("report", "event " + event + " netState:" + string2 + " " + string, true);
        }
        return bundle;
    }

    @Override // com.transsion.baselib.report.n
    public void b(String pageName, String event, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        ds.b.f63534a.d(pageName, event, map);
    }

    @Override // com.transsion.baselib.report.n
    public Pair<Short, String> getAccount() {
        ILoginApi iLoginApi = this.f51289c;
        UserInfo userInfoP = iLoginApi != null ? iLoginApi.P() : null;
        if (userInfoP != null) {
            return new Pair<>(Short.valueOf((short) userInfoP.getUserType()), String.valueOf(userInfoP.getUserId()));
        }
        return null;
    }
}
