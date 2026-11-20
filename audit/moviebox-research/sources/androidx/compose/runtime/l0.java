package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;
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
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<Object> f3481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3482c;

    public final void a(Object obj) {
        ArrayList<Object> arrayList = this.f3481b;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.f3481b = arrayList;
        arrayList.add(obj);
    }

    public final void b(m2 m2Var, int i11, int i12) {
        c cVarO1;
        ArrayList<Object> arrayList = this.f3481b;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f3481b = arrayList;
        }
        int i13 = 0;
        if (i11 >= 0 && (cVarO1 = m2Var.o1(i11)) != null) {
            int size = arrayList.size();
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                if (!Intrinsics.b(obj, cVarO1) && (!(obj instanceof l0) || !((l0) obj).e(cVarO1))) {
                    i13++;
                }
            }
            i13 = -1;
        }
        arrayList.add(i13, m2Var.E(i12));
    }

    public final ArrayList<Object> c() {
        return this.f3481b;
    }

    public final int d() {
        return this.f3480a;
    }

    public final boolean e(c cVar) {
        ArrayList<Object> arrayList = this.f3481b;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = arrayList.get(i11);
            if (Intrinsics.b(obj, cVar) || ((obj instanceof l0) && ((l0) obj).e(cVar))) {
                return true;
            }
        }
        return false;
    }

    public final l0 f() {
        Object obj;
        l0 l0VarF;
        ArrayList<Object> arrayList = this.f3481b;
        if (arrayList == null) {
            obj = null;
            break;
        }
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                obj = null;
                break;
            }
            obj = arrayList.get(size);
            if ((obj instanceof l0) && !((l0) obj).f3482c) {
                break;
            }
            size--;
        }
        l0 l0Var = obj instanceof l0 ? (l0) obj : null;
        return (l0Var == null || (l0VarF = l0Var.f()) == null) ? this : l0VarF;
    }

    public final boolean g(c cVar) {
        ArrayList<Object> arrayList = this.f3481b;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Object obj = arrayList.get(size);
                if (obj instanceof c) {
                    if (Intrinsics.b(obj, cVar)) {
                        arrayList.remove(size);
                    }
                } else if ((obj instanceof l0) && !((l0) obj).g(cVar)) {
                    arrayList.remove(size);
                }
            }
            if (arrayList.isEmpty()) {
                this.f3481b = null;
                return false;
            }
        }
        return true;
    }

    public final void h(j2 j2Var, int i11) {
        f().a(j2Var.a(i11));
    }

    public final void i(m2 m2Var, int i11) {
        f().a(m2Var.E(i11));
    }
}
