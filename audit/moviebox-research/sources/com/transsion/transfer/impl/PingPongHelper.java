package com.transsion.transfer.impl;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.transfer.androidasync.http.d0;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
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
public final class PingPongHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f58927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f58928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f58929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Stack<String> f58930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f58932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f58933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Timer f58934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PingPongHelper$task$1 f58935j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(String str, d0 d0Var);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.transsion.transfer.impl.PingPongHelper$task$1] */
    public PingPongHelper(String remoteIP, boolean z11, d0 socket, a pingPongListener) {
        Intrinsics.g(remoteIP, "remoteIP");
        Intrinsics.g(socket, "socket");
        Intrinsics.g(pingPongListener, "pingPongListener");
        this.f58926a = remoteIP;
        this.f58927b = z11;
        this.f58928c = socket;
        this.f58929d = pingPongListener;
        this.f58930e = new Stack<>();
        this.f58933h = 2;
        socket.E(new d0.b() { // from class: com.transsion.transfer.impl.f
            @Override // com.transsion.transfer.androidasync.http.d0.b
            public final void a(String str) {
                PingPongHelper.b(this.f59044a, str);
            }
        });
        this.f58934i = new Timer();
        this.f58935j = new TimerTask() { // from class: com.transsion.transfer.impl.PingPongHelper$task$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (this.this$0.f58932g >= this.this$0.f58933h) {
                    this.this$0.f58929d.a(this.this$0.f58926a, this.this$0.f58928c);
                    this.this$0.f58931f = true;
                }
                if (this.this$0.f58931f) {
                    return;
                }
                String strM = this.this$0.m();
                this.this$0.f58930e.push(strM);
                this.this$0.f58928c.x(strM);
                this.this$0.f58932g++;
                if (this.this$0.f58930e.size() > this.this$0.f58933h) {
                    this.this$0.f58930e.remove(0);
                }
            }
        };
    }

    public static final void b(PingPongHelper this$0, String str) {
        Intrinsics.g(this$0, "this$0");
        this$0.f58932g = 0;
        this$0.f58930e.remove(str);
    }

    public final String m() {
        return (this.f58927b ? "server" : "client") + "-" + System.currentTimeMillis();
    }

    public final void n() {
        this.f58934i.schedule(this.f58935j, 0L, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    public final void o() {
        this.f58931f = true;
        cancel();
        this.f58934i.cancel();
    }
}
