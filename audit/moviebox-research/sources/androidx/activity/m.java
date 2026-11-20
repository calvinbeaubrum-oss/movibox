package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Function0<Unit>> f646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f647h;

    public m(Executor executor, Function0<Unit> reportFullyDrawn) {
        Intrinsics.g(executor, "executor");
        Intrinsics.g(reportFullyDrawn, "reportFullyDrawn");
        this.f640a = executor;
        this.f641b = reportFullyDrawn;
        this.f642c = new Object();
        this.f646g = new ArrayList();
        this.f647h = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(this.f639a);
            }
        };
    }

    public static final void d(m this$0) {
        Intrinsics.g(this$0, "this$0");
        synchronized (this$0.f642c) {
            try {
                this$0.f644e = false;
                if (this$0.f643d == 0 && !this$0.f645f) {
                    this$0.f641b.invoke();
                    this$0.b();
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        synchronized (this.f642c) {
            try {
                this.f645f = true;
                Iterator<T> it = this.f646g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f646g.clear();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean c() {
        boolean z11;
        synchronized (this.f642c) {
            z11 = this.f645f;
        }
        return z11;
    }
}
