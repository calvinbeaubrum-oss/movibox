package q6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s6.u;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class c<T> implements p6.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r6.g<T> f74435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<u> f74436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f74437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f74438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f74439e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void b(List<u> list);

        void c(List<u> list);
    }

    public c(r6.g<T> tracker) {
        Intrinsics.g(tracker, "tracker");
        this.f74435a = tracker;
        this.f74436b = new ArrayList();
        this.f74437c = new ArrayList();
    }

    @Override // p6.a
    public void a(T t11) {
        this.f74438d = t11;
        h(this.f74439e, t11);
    }

    public abstract boolean b(u uVar);

    public abstract boolean c(T t11);

    public final boolean d(String workSpecId) {
        Intrinsics.g(workSpecId, "workSpecId");
        T t11 = this.f74438d;
        return t11 != null && c(t11) && this.f74437c.contains(workSpecId);
    }

    public final void e(Iterable<u> workSpecs) {
        Intrinsics.g(workSpecs, "workSpecs");
        this.f74436b.clear();
        this.f74437c.clear();
        List<u> list = this.f74436b;
        for (u uVar : workSpecs) {
            if (b(uVar)) {
                list.add(uVar);
            }
        }
        List<u> list2 = this.f74436b;
        List<String> list3 = this.f74437c;
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            list3.add(((u) it.next()).f76199a);
        }
        if (this.f74436b.isEmpty()) {
            this.f74435a.f(this);
        } else {
            this.f74435a.c(this);
        }
        h(this.f74439e, this.f74438d);
    }

    public final void f() {
        if (!this.f74436b.isEmpty()) {
            this.f74436b.clear();
            this.f74435a.f(this);
        }
    }

    public final void g(a aVar) {
        if (this.f74439e != aVar) {
            this.f74439e = aVar;
            h(aVar, this.f74438d);
        }
    }

    public final void h(a aVar, T t11) {
        if (this.f74436b.isEmpty() || aVar == null) {
            return;
        }
        if (t11 == null || c(t11)) {
            aVar.c(this.f74436b);
        } else {
            aVar.b(this.f74436b);
        }
    }
}
