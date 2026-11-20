package com.cloud.hisavana.sdk.manager;

import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.g1;
import com.cloud.hisavana.sdk.o1;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.i;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f29881d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f29882e = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29883a = "RetryTrackingManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f29884b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f29885c = 2;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return g.f29882e;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class b {
        public abstract void a();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class c {
        public abstract void a(String str);

        public abstract void b(String str, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiskTrackingBean f29886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f29887b;

        public d(DiskTrackingBean diskTrackingBean, g gVar) {
            this.f29886a = diskTrackingBean;
            this.f29887b = gVar;
        }

        public static final void c(g this$0, DiskTrackingBean diskTrackingBean) {
            Intrinsics.g(this$0, "this$0");
            this$0.p(diskTrackingBean.getNext());
        }

        @Override // com.cloud.hisavana.sdk.manager.g.b
        public void a() {
            if (this.f29886a.getNext() == null) {
                this.f29887b.f29884b.set(false);
                return;
            }
            i iVar = i.f30292a;
            final g gVar = this.f29887b;
            final DiskTrackingBean diskTrackingBean = this.f29886a;
            iVar.f(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.d.c(gVar, diskTrackingBean);
                }
            }, this.f29887b.h());
        }
    }

    public static final void k(g this$0, DiskTrackingBean diskTrackingBean) {
        String uuid;
        Intrinsics.g(this$0, "this$0");
        z.a().d(this$0.f29883a, "addTrackingBean " + diskTrackingBean);
        g1.a aVar = g1.f29717e;
        aVar.a().k();
        g1 g1VarA = aVar.a();
        if (diskTrackingBean == null || (uuid = diskTrackingBean.getUuid()) == null) {
            uuid = "";
        }
        if (g1VarA.g(uuid) == null) {
            aVar.a().i(diskTrackingBean);
        }
    }

    public static final void n(g this$0) {
        Intrinsics.g(this$0, "this$0");
        List<DiskTrackingBean> listM = g1.f29717e.a().m();
        if (listM == null || listM.isEmpty()) {
            this$0.f29884b.set(false);
            return;
        }
        DiskTrackingBean diskTrackingBean = listM.get(0);
        DiskTrackingBean diskTrackingBean2 = diskTrackingBean;
        for (DiskTrackingBean diskTrackingBean3 : listM) {
            if (!Intrinsics.b(diskTrackingBean2, diskTrackingBean3)) {
                diskTrackingBean2.setNext(diskTrackingBean3);
                diskTrackingBean2 = diskTrackingBean3;
            }
        }
        this$0.p(diskTrackingBean);
    }

    public static final void o(DiskTrackingBean diskTrackingBean) {
        if (diskTrackingBean != null) {
            g1.f29717e.a().e(diskTrackingBean.getUuid());
        }
    }

    public final void f(DiskTrackingBean diskTrackingBean) {
        if (diskTrackingBean != null) {
            diskTrackingBean.getRetryTimes().addAndGet(1);
            if (diskTrackingBean.getRetryTimes().get() >= this.f29885c) {
                m(diskTrackingBean);
            } else {
                g1.f29717e.a().l(diskTrackingBean);
            }
        }
    }

    public final long h() {
        return (new SecureRandom().nextLong() % ((long) 2000)) + ((long) 1000);
    }

    public final void j(final DiskTrackingBean diskTrackingBean) {
        i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.d
            @Override // java.lang.Runnable
            public final void run() {
                g.k(this.f29877a, diskTrackingBean);
            }
        });
    }

    public final void l() {
        if (this.f29884b.get()) {
            z.a().d(this.f29883a, "startRetryTracking,is retrying");
        } else {
            this.f29884b.set(true);
            i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.n(this.f29879a);
                }
            });
        }
    }

    public final void m(final DiskTrackingBean diskTrackingBean) {
        i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.f
            @Override // java.lang.Runnable
            public final void run() {
                g.o(diskTrackingBean);
            }
        });
    }

    public final void p(DiskTrackingBean diskTrackingBean) {
        z.a().d(this.f29883a, "tracking " + diskTrackingBean);
        if (diskTrackingBean == null) {
            return;
        }
        if (diskTrackingBean.getRetryTimes().get() >= this.f29885c) {
            m(diskTrackingBean);
            p(diskTrackingBean.getNext());
        } else if (NetStateManager.checkNetworkState()) {
            o1.f(diskTrackingBean, new d(diskTrackingBean, this));
        } else {
            this.f29884b.set(false);
            z.a().d(this.f29883a, "tracking,net is not ok");
        }
    }
}
