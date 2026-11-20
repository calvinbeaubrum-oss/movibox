package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.AdAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.MiniCardAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.OfflineDownloadAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.b;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniutils.util.k;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import q.a;
import q.c;
import q.d;
import q.e;
import q.g;
import q.h;
import q.i;
import q.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PerformanceTrack implements PerformanceAnalyseProxy {
    public final Lazy OooO00o = LazyKt__LazyJVMKt.b(OooOOO0.OooO00o);
    public final Lazy OooO0O0 = LazyKt__LazyJVMKt.b(OooOO0.OooO00o);
    public final Lazy OooO0OO = LazyKt__LazyJVMKt.b(OooO.OooO00o);

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Lazy f31551OooO0Oo = LazyKt__LazyJVMKt.b(OooOO0O.OooO00o);

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final Lazy f31553OooO0o0 = LazyKt__LazyJVMKt.b(OooO00o.OooO00o);

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final Lazy f31552OooO0o = LazyKt__LazyJVMKt.b(OooO0O0.OooO00o);
    public final Lazy OooO0oO = LazyKt__LazyJVMKt.b(OooO0OO.OooO00o);

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public final Lazy f31554OooO0oo = LazyKt__LazyJVMKt.b(OooO0o.OooO00o);

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<h> {
        public static final OooO OooO00o = new OooO();

        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public h invoke() {
            return new h();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<a> {
        public static final OooO00o OooO00o = new OooO00o();

        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public a invoke() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<c> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public c invoke() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<d> {
        public static final OooO0OO OooO00o = new OooO0OO();

        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public d invoke() {
            return new d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<e> {
        public static final OooO0o OooO00o = new OooO0o();

        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public e invoke() {
            return new e();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<g> {
        public static final OooOO0 OooO00o = new OooOO0();

        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public g invoke() {
            return new g();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<j> {
        public static final OooOO0O OooO00o = new OooOO0O();

        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public j invoke() {
            return new j();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<i> {
        public static final OooOOO0 OooO00o = new OooOOO0();

        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public i invoke() {
            return new i();
        }
    }

    public final a getAdTrack() {
        return (a) this.f31553OooO0o0.getValue();
    }

    public final h getPointTrack() {
        return (h) this.OooO0OO.getValue();
    }

    public final g getRenderTrack() {
        return (g) this.OooO0O0.getValue();
    }

    public final j getV8Track() {
        return (j) this.f31551OooO0Oo.getValue();
    }

    public final i getWorkerTrack() {
        return (i) this.OooO00o.getValue();
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void record(String str, com.cloud.tmc.kernel.proxy.performanceanalyse.c target, String str2) {
        Intrinsics.g(target, "target");
        record(str, target, str2, null);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void record(String str, com.cloud.tmc.kernel.proxy.performanceanalyse.c target, String str2, Bundle bundle) {
        String strA;
        StringBuilder sb2;
        StringBuilder sb3;
        String str3;
        long j11;
        String str4;
        long j12;
        String str5;
        long jCurrentTimeMillis;
        long j13;
        long j14;
        boolean z11;
        String str6;
        Intrinsics.g(target, "target");
        if (target instanceof WorkerAnalyseType) {
            i workerTrack = getWorkerTrack();
            WorkerAnalyseType target2 = (WorkerAnalyseType) target;
            workerTrack.getClass();
            Intrinsics.g(target2, "target");
            int i11 = i.a.f74102a[target2.ordinal()];
            if (i11 == 3) {
                if (workerTrack.f74101b == WorkerAnalyseType.CREATE_START) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    j13 = workerTrack.f74100a;
                    j14 = jCurrentTimeMillis - j13;
                } else {
                    j14 = 0;
                }
                z11 = false;
            } else if (i11 == 5) {
                if (workerTrack.f74101b == WorkerAnalyseType.LOAD_JS_START) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    j13 = workerTrack.f74100a;
                    j14 = jCurrentTimeMillis - j13;
                } else {
                    j14 = 0;
                }
                z11 = false;
            } else if (i11 != 7) {
                if (i11 == 8) {
                    WorkerAnalyseType workerAnalyseType = workerTrack.f74101b;
                    if (workerAnalyseType == WorkerAnalyseType.EXECUTE_JS_START) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        j13 = workerTrack.f74100a;
                        j14 = jCurrentTimeMillis - j13;
                        z11 = false;
                    } else if (workerAnalyseType == WorkerAnalyseType.SEND_TO_NATIVE) {
                        j14 = 0;
                        z11 = true;
                    }
                }
                j14 = 0;
                z11 = false;
            } else {
                if (workerTrack.f74101b == WorkerAnalyseType.EXECUTE_JS_START) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    j13 = workerTrack.f74100a;
                    j14 = jCurrentTimeMillis - j13;
                } else {
                    j14 = 0;
                }
                z11 = false;
            }
            if (z11) {
                return;
            }
            strA = str2 != null ? h.a.a("-信息:", str2) : "";
            if (j14 != 0) {
                strA = "-耗时:" + j14 + strA;
                ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString(WorkerAnalyseType.class.getSimpleName() + '.' + target2.name(), strA);
                Unit unit = Unit.f68710a;
                reportProxy.report(str, "webviewWorker", bundle2);
            }
            if (str != null) {
                str6 = '[' + str + "]:" + target2.getDes() + strA;
            } else {
                str6 = target2.getDes() + strA;
            }
            if (target2 == WorkerAnalyseType.ERROR) {
                p.c("TmcPerferenceWorker", str6);
            } else {
                p.a("TmcPerferenceWorker", str6);
            }
            b.a(target2, str6);
            workerTrack.f74101b = target2;
            workerTrack.f74100a = System.currentTimeMillis();
            return;
        }
        if (target instanceof RenderAnalyseType) {
            g renderTrack = getRenderTrack();
            RenderAnalyseType target3 = (RenderAnalyseType) target;
            renderTrack.getClass();
            Intrinsics.g(target3, "target");
            int i12 = g.a.f74092a[target3.ordinal()];
            if (i12 == 3 || i12 == 5) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long j15 = renderTrack.f74091a;
                j12 = jCurrentTimeMillis2 - j15;
            } else {
                j12 = 0;
            }
            strA = str2 != null ? h.a.a("-信息:", str2) : "";
            if (j12 != 0) {
                strA = "-耗时:" + j12 + strA;
                ReportProxy reportProxy2 = (ReportProxy) tc.a.a(ReportProxy.class);
                Bundle bundle3 = new Bundle();
                bundle3.putString(RenderAnalyseType.class.getSimpleName() + '.' + target3.name(), strA);
                Unit unit2 = Unit.f68710a;
                reportProxy2.report(str, "render", bundle3);
            }
            if (str != null) {
                str5 = '[' + str + "]:" + target3.getDes() + strA;
            } else {
                str5 = target3.getDes() + strA;
            }
            if (target3 == RenderAnalyseType.ERROR) {
                p.d("TmcPerferenceRender", str5, j12 != 0);
            } else {
                p.b("TmcPerferenceRender", str5, j12 != 0);
            }
            b.a(target3, str5);
            renderTrack.f74091a = System.currentTimeMillis();
            return;
        }
        if (target instanceof PointAnalyseType) {
            getPointTrack().f(str, (PointAnalyseType) target, str2, bundle);
            return;
        }
        if (target instanceof V8AnalyseType) {
            j v8Track = getV8Track();
            V8AnalyseType target4 = (V8AnalyseType) target;
            v8Track.getClass();
            Intrinsics.g(target4, "target");
            int i13 = j.a.f74104a[target4.ordinal()];
            if (i13 == 5 || i13 == 8) {
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                long j16 = v8Track.f74103a;
                j11 = jCurrentTimeMillis3 - j16;
            } else {
                j11 = 0;
            }
            strA = str2 != null ? h.a.a("-信息:", str2) : "";
            if (j11 != 0) {
                strA = "-耗时:" + j11 + strA;
                ReportProxy reportProxy3 = (ReportProxy) tc.a.a(ReportProxy.class);
                Bundle bundle4 = new Bundle();
                bundle4.putString(V8AnalyseType.class.getSimpleName() + '.' + target4.name(), strA);
                Unit unit3 = Unit.f68710a;
                reportProxy3.report(str, "v8", bundle4);
            }
            if (str != null) {
                str4 = '[' + str + "]:" + target4.getDes() + strA;
            } else {
                str4 = target4.getDes() + strA;
            }
            if (target4 == V8AnalyseType.DOWNLOAD_FAIL || target4 == V8AnalyseType.UNZIP_FAIL) {
                p.d("TmcPerferenceV8", str4, j11 != 0);
            } else {
                p.b("TmcPerferenceV8", str4, j11 != 0);
            }
            b.a(target4, str4);
            v8Track.f74103a = System.currentTimeMillis();
            return;
        }
        if (target instanceof com.cloud.tmc.kernel.proxy.performanceanalyse.d) {
            com.cloud.tmc.kernel.proxy.performanceanalyse.d target5 = (com.cloud.tmc.kernel.proxy.performanceanalyse.d) target;
            ((c) this.f31552OooO0o.getValue()).getClass();
            Intrinsics.g(target5, "target");
            ReportProxy reportProxy4 = (ReportProxy) tc.a.a(ReportProxy.class);
            Bundle bundle5 = new Bundle();
            bundle5.putString("page_path", target5.f31240b);
            bundle5.putString("event_name", target5.f31239a);
            Object obj = target5.f31241c;
            if (obj != null) {
                bundle5.putString("data", k.j(obj));
            }
            Unit unit4 = Unit.f68710a;
            reportProxy4.report(str, "inner_miniapp_developer", bundle5);
            if (str != null) {
                str3 = '[' + str + "]:" + k.j(target5) + "";
            } else {
                str3 = k.j(target5) + "";
            }
            b.a(target5, str3);
            return;
        }
        if (target instanceof MiniCardAnalyseType) {
            MiniCardAnalyseType target6 = (MiniCardAnalyseType) target;
            ((d) this.OooO0oO.getValue()).getClass();
            Intrinsics.g(target6, "target");
            if (str != null) {
                sb3 = new StringBuilder();
                sb3.append('[');
                sb3.append(str);
                sb3.append("]:");
            } else {
                sb3 = new StringBuilder();
            }
            sb3.append(target6.getObjectNameZh());
            sb3.append("");
            String string = sb3.toString();
            ReportProxy reportProxy5 = (ReportProxy) tc.a.a(ReportProxy.class);
            Bundle bundle6 = new Bundle();
            bundle6.putString(target6.getClass().getSimpleName() + '.' + target6.name(), string);
            bundle6.putString("object_id", target6.getObjectId());
            bundle6.putString("object_name", target6.getObjectNameEn());
            if (bundle != null) {
                bundle6.putAll(bundle);
            }
            Unit unit5 = Unit.f68710a;
            reportProxy5.report(str, "miniapp_card", bundle6);
            TmcLogger.c("TmcMiniCard", string);
            b.a(target6, string);
            return;
        }
        if (!(target instanceof OfflineDownloadAnalyseType)) {
            if (target instanceof AdAnalyseType) {
                AdAnalyseType target7 = (AdAnalyseType) target;
                getAdTrack().getClass();
                Intrinsics.g(target7, "target");
                ((ReportProxy) tc.a.a(ReportProxy.class)).reportAd(str, target7.name(), bundle);
                return;
            }
            return;
        }
        OfflineDownloadAnalyseType target8 = (OfflineDownloadAnalyseType) target;
        ((e) this.f31554OooO0oo.getValue()).getClass();
        Intrinsics.g(target8, "target");
        strA = str2 != null ? str2 : "";
        if (str != null) {
            sb2 = new StringBuilder();
            sb2.append('[');
            sb2.append(str);
            sb2.append("]:");
        } else {
            sb2 = new StringBuilder();
        }
        sb2.append(target8.getObjectNameZh());
        sb2.append(' ');
        sb2.append(strA);
        String string2 = sb2.toString();
        ReportProxy reportProxy6 = (ReportProxy) tc.a.a(ReportProxy.class);
        Bundle bundle7 = new Bundle();
        bundle7.putString(target8.getClass().getSimpleName() + '.' + target8.name(), string2);
        bundle7.putString("object_id", target8.getObjectId());
        bundle7.putString("object_name", target8.getObjectNameEn());
        if (bundle != null) {
            bundle7.putAll(bundle);
        }
        Unit unit6 = Unit.f68710a;
        reportProxy6.report(str, "miniapp_offline_download", bundle7);
        TmcLogger.c("TmcOfflineDownloadAnalyse", string2);
        b.a(target8, string2);
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void recordForAd(String str, String target, String str2, Bundle bundle) {
        if (target != null) {
            getAdTrack().getClass();
            Intrinsics.g(target, "target");
            ((ReportProxy) tc.a.a(ReportProxy.class)).reportAd(str, target, bundle);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void recordForCommon(String str, String str2, Bundle bundle) {
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(str, str2, bundle);
    }
}
