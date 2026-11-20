package com.transsion.baselib.report.launch;

import android.app.Application;
import android.content.pm.PackageInfo;
import com.transsion.baselib.helper.ReferrerBean;
import com.transsion.baselib.report.m;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import u7.c;
import u7.d;

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
@Metadata
@SourceDebugExtension
public final class RoomInstallReferrer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RoomInstallReferrer f51273a = new RoomInstallReferrer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static u7.a f51274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f51275c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public interface a {
        void a(ReferrerBean referrerBean);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f51276a;

        public b(Application application) {
            this.f51276a = application;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0038 A[PHI: r6
  0x0038: PHI (r6v4 u7.a) = (r6v3 u7.a), (r6v6 u7.a) binds: [B:19:0x004a, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // u7.c
        public void a(int i11) {
            u7.a aVar;
            u7.a aVar2 = null;
            try {
                try {
                    try {
                        if (i11 == 0) {
                            RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.f51273a;
                            Application application = this.f51276a;
                            u7.a aVar3 = RoomInstallReferrer.f51274b;
                            if (aVar3 == null) {
                                Intrinsics.y("referrerClient");
                                aVar3 = null;
                            }
                            d dVarB = aVar3.b();
                            Intrinsics.f(dVarB, "referrerClient.installReferrer");
                            roomInstallReferrer.e(application, dVarB);
                        } else {
                            RoomInstallReferrer.f51273a.f(this.f51276a, String.valueOf(i11));
                        }
                        aVar = RoomInstallReferrer.f51274b;
                        if (aVar == null) {
                            Intrinsics.y("referrerClient");
                        } else {
                            aVar2 = aVar;
                        }
                    } catch (Exception unused) {
                        RoomInstallReferrer.f51273a.f(this.f51276a, "unknown err");
                        aVar = RoomInstallReferrer.f51274b;
                        if (aVar != null) {
                            aVar2 = aVar;
                        }
                    }
                    aVar2.a();
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                try {
                    u7.a aVar4 = RoomInstallReferrer.f51274b;
                    if (aVar4 == null) {
                        Intrinsics.y("referrerClient");
                    } else {
                        aVar2 = aVar4;
                    }
                    aVar2.a();
                } catch (Exception unused3) {
                }
                throw th2;
            }
        }

        @Override // u7.c
        public void b() {
        }
    }

    public final void d(Application context, a lis) {
        Intrinsics.g(context, "context");
        Intrinsics.g(lis, "lis");
        u7.a aVar = null;
        String string = RoomAppMMKV.f51271a.a().getString("k_install_referrer", null);
        if (string != null && string.length() != 0) {
            uo.b.a.f(uo.b.f78622a, "RoomInstallReferrer", "localReferrerUrl:" + string, false, 4, null);
            return;
        }
        f51275c = lis;
        try {
            u7.a aVarA = u7.a.c(context).a();
            Intrinsics.f(aVarA, "newBuilder(context).build()");
            f51274b = aVarA;
            if (aVarA == null) {
                Intrinsics.y("referrerClient");
            } else {
                aVar = aVarA;
            }
            aVar.d(new b(context));
        } catch (Exception unused) {
            f(context, "unknown err");
        }
    }

    public final void e(Application application, d dVar) {
        String strC = dVar.c();
        uo.b.a.f(uo.b.f78622a, "RoomInstallReferrer", "fetchInstallReferrer referrerUrl: " + strC, false, 4, null);
        j.d(l0.a(w0.b()), null, null, new RoomInstallReferrer$fetchInstallReferrer$1(application, strC, dVar, null), 3, null);
    }

    public final void f(Application application, String str) {
        uo.b.a.f(uo.b.f78622a, "RoomInstallReferrer", "fetchInstallReferrerErr msg: " + str, false, 4, null);
        j.d(l0.a(w0.b()), null, null, new RoomInstallReferrer$fetchInstallReferrerErr$1(application, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0046 A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:3:0x000a, B:5:0x0033, B:7:0x0039, B:13:0x004c, B:14:0x0051, B:16:0x0057, B:17:0x005c, B:19:0x0092, B:20:0x00d3, B:22:0x00de, B:23:0x00e1, B:11:0x0046), top: B:27:0x000a }] */
    public final void g(Application context, String referrer, d dVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(referrer, "referrer");
        try {
            RoomAppMMKV.f51271a.a().putString("k_install_referrer", referrer);
            HashMap map = new HashMap();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ReferrerBean referrerBeanB = com.transsion.baselib.helper.b.f51184a.b(referrer);
            String utmSource = referrerBeanB.getUtmSource();
            if (utmSource == null) {
                utmSource = referrerBeanB.getUtmSource();
            } else {
                if (utmSource.length() == 0) {
                    utmSource = fp.b.f65208a.e(context);
                }
                if (utmSource == null) {
                    utmSource = referrerBeanB.getUtmSource();
                }
            }
            if (utmSource != null) {
                ip.a.f67589a.e(utmSource);
            }
            String utmCampaign = referrerBeanB.getUtmCampaign();
            if (utmCampaign != null) {
                ip.a.f67589a.g(utmCampaign);
            }
            ip.a.C0714a c0714a = ip.a.f67589a;
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            c0714a.f(string);
            map.put("install_time", String.valueOf(packageInfo.lastUpdateTime));
            map.put("install_version", packageInfo.versionName);
            map.put("install_referrer", referrer);
            map.put("install_store", fp.b.f65208a.e(context));
            if (dVar != null) {
                map.put("referrer_click_timestamp_seconds", String.valueOf(dVar.d()));
                map.put("install_begin_timestamp_seconds", String.valueOf(dVar.b()));
                map.put("google_play_instant", String.valueOf(dVar.a()));
                map.put("referrer_click_timestamp_server_seconds", String.valueOf(dVar.e()));
                map.put("install_begin_timestamp_server_seconds", String.valueOf(dVar.e()));
            }
            m.f51277a.n("app_install", map);
            a aVar = f51275c;
            if (aVar != null) {
                aVar.a(referrerBeanB);
            }
            f51275c = null;
        } catch (Exception e11) {
            uo.b.a.e(uo.b.f78622a, "RoomInstallReferrer", "", e11, false, 8, null);
        }
    }
}
