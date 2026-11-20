package com.transsion.transfer.impl;

import android.app.Application;
import android.os.Build;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.server.TransferServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class g extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<Pair<String, Boolean>> f59045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<String> f59046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oy.b<Triple<String, String, Triple<TaskState, Long, Long>>> f59047d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oy.b<Pair<String, List<FileData>>> f59048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<String> f59049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.transfer.impl.c f59050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.transsion.transfer.impl.c f59051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function4<String, String, Boolean, String, Unit> f59052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f59053k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Function4<String, String, Boolean, String, Unit> {
        public a() {
        }

        public void a(String clientIp, String transferId, boolean z11, String str) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(transferId, "transferId");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invoke: clientIp:");
            sb2.append(clientIp);
            sb2.append(", transferId:");
            sb2.append(transferId);
            sb2.append(", isConnect:");
            sb2.append(z11);
            g.this.f59045b.n(new Pair(clientIp, Boolean.valueOf(z11)));
            if (z11) {
                return;
            }
            py.b.f74066a.s(str, g.this.t());
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Boolean bool, String str3) {
            a(str, str2, bool.booleanValue(), str3);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.transfer.impl.c {
        public b() {
        }

        @Override // com.transsion.transfer.impl.c
        public void a(String clientIp, String clientDeviceName) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(clientDeviceName, "clientDeviceName");
            g.this.f59046c.n(clientDeviceName);
            com.transsion.transfer.impl.c cVar = g.this.f59050h;
            if (cVar != null) {
                cVar.a(clientIp, clientDeviceName);
            }
        }

        @Override // com.transsion.transfer.impl.c
        public String b() {
            return g.this.q();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements e {
        public c() {
        }

        @Override // com.transsion.transfer.impl.e
        public void A(String clientIp) {
            Intrinsics.g(clientIp, "clientIp");
            g.this.f59045b.n(new Pair(clientIp, Boolean.FALSE));
        }

        @Override // com.transsion.transfer.impl.e
        public void U(String clientIp, String remoteFilePath, TaskState state, long j11, long j12) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            Intrinsics.g(state, "state");
            g.this.f59047d.n(new Triple(clientIp, remoteFilePath, new Triple(state, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.e
        public void d(String clientIp) {
            Intrinsics.g(clientIp, "clientIp");
            g.this.f59049g.n(clientIp);
        }

        @Override // com.transsion.transfer.impl.e
        public void i(String clientIp, String remoteFilePath, long j11, long j12) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            g.this.f59047d.n(new Triple(clientIp, remoteFilePath, new Triple(TaskState.TRANSFERRING, Long.valueOf(j11), Long.valueOf(j12))));
        }

        @Override // com.transsion.transfer.impl.e
        public void w(String clientIp) {
            Intrinsics.g(clientIp, "clientIp");
        }

        @Override // com.transsion.transfer.impl.e
        public void y(String clientIp, List<FileData> files) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(files, "files");
            g.this.f59048f.n(new Pair(clientIp, files));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59045b = new c0<>();
        this.f59046c = new c0<>();
        this.f59047d = new oy.b<>();
        this.f59048f = new oy.b<>();
        this.f59049g = new c0<>();
        this.f59051i = new b();
        this.f59052j = new a();
        this.f59053k = new c();
    }

    public final void A() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
        dVarB.open();
        py.b.f74066a.r();
    }

    public final void B(com.transsion.transfer.impl.c cVar) {
        this.f59050h = cVar;
    }

    public final void C() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
        dVarB.d();
    }

    public final boolean j() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
        return !dVarB.c().isEmpty();
    }

    public final LiveData<String> k() {
        return this.f59046c;
    }

    public final List<String> l() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
        return dVarB.c();
    }

    public final List<String> m() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
        return dVarB.i();
    }

    public final LiveData<String> n() {
        return this.f59049g;
    }

    public final LiveData<Pair<String, Boolean>> o() {
        return this.f59045b;
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        super.onCleared();
        TransferServer.a aVar = TransferServer.f59075s;
        aVar.b(b()).g(this.f59053k);
        aVar.b(b()).h(this.f59052j);
        aVar.b(b()).e(null);
    }

    public final String p() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
        List<String> listI = dVarB.i();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getCurClientName: getCurClientName:");
        sb2.append(listI);
        if (!listI.isEmpty()) {
            return listI.get(0);
        }
        return null;
    }

    public final String q() {
        String MODEL = Build.MODEL;
        Intrinsics.f(MODEL, "MODEL");
        return MODEL;
    }

    public final Function4<String, String, Boolean, String, Unit> r() {
        return this.f59052j;
    }

    public final int s() {
        return ry.b.f75768a.f().size();
    }

    public final String t() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.b(this.f59052j);
        return dVarB.j();
    }

    public final LiveData<Pair<String, List<FileData>>> u() {
        return this.f59048f;
    }

    public final LiveData<Triple<String, String, Triple<TaskState, Long, Long>>> v() {
        return this.f59047d;
    }

    public final int w() {
        ry.b bVar = ry.b.f75768a;
        return bVar.g().size() + bVar.h().size();
    }

    public final void x() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.a(this.f59053k);
        dVarB.b(this.f59052j);
    }

    public final boolean y() {
        d dVarB = TransferServer.f59075s.b(b());
        dVarB.e(this.f59051i);
        dVarB.b(this.f59052j);
        return dVarB.isRunning();
    }

    public final void z(int i11) {
        TransferServer.a aVar = TransferServer.f59075s;
        List<String> listC = aVar.b(b()).c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyClientCMD: clientIps:");
        sb2.append(listC);
        if (!listC.isEmpty()) {
            d dVarB = aVar.b(b());
            dVarB.e(this.f59051i);
            dVarB.a(this.f59053k);
            dVarB.b(this.f59052j);
            dVarB.f(listC.get(0), i11);
        }
    }
}
