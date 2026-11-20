package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.m0;

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
public class LockFreeLinkedListNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69442a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69443b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f69444c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @PublishedApi
    public static abstract class a extends b<LockFreeLinkedListNode> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final LockFreeLinkedListNode f69445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public LockFreeLinkedListNode f69446c;

        public a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f69445b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z11 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z11 ? this.f69445b : this.f69446c;
            if (lockFreeLinkedListNode2 != null && androidx.concurrent.futures.a.a(LockFreeLinkedListNode.l(), lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z11) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f69445b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f69446c;
                Intrinsics.d(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.h(lockFreeLinkedListNode4);
            }
        }
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater l() {
        return f69442a;
    }

    public final boolean e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f69443b.set(lockFreeLinkedListNode, this);
        f69442a.set(lockFreeLinkedListNode, this);
        while (i() == this) {
            if (kotlinx.coroutines.o.a(f69442a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.h(this);
                return true;
            }
        }
        return false;
    }

    public final LockFreeLinkedListNode f(v vVar) {
        Object obj;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) f69443b.get(this);
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    obj = f69442a.get(lockFreeLinkedListNode2);
                    if (obj == this) {
                        if (lockFreeLinkedListNode != lockFreeLinkedListNode2 && !kotlinx.coroutines.o.a(f69443b, this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            break;
                        }
                        return lockFreeLinkedListNode2;
                    }
                    if (o()) {
                        return null;
                    }
                    if (obj == vVar) {
                        return lockFreeLinkedListNode2;
                    }
                    if (obj instanceof v) {
                        ((v) obj).a(lockFreeLinkedListNode2);
                        break;
                    }
                    if (!(obj instanceof w)) {
                        Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                    } else {
                        if (lockFreeLinkedListNode3 != null) {
                            break;
                        }
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) f69443b.get(lockFreeLinkedListNode2);
                    }
                }
                if (!kotlinx.coroutines.o.a(f69442a, lockFreeLinkedListNode3, lockFreeLinkedListNode2, ((w) obj).f69495a)) {
                    break;
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    public final LockFreeLinkedListNode g(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.o()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f69443b.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    public final void h(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69443b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (i() != lockFreeLinkedListNode) {
                return;
            }
        } while (!kotlinx.coroutines.o.a(f69443b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (o()) {
            lockFreeLinkedListNode.f(null);
        }
    }

    public final Object i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f69442a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof v)) {
                return obj;
            }
            ((v) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode j() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object objI = i();
        w wVar = objI instanceof w ? (w) objI : null;
        if (wVar != null && (lockFreeLinkedListNode = wVar.f69495a) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.e(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) objI;
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode lockFreeLinkedListNodeF = f(null);
        return lockFreeLinkedListNodeF == null ? g((LockFreeLinkedListNode) f69443b.get(this)) : lockFreeLinkedListNodeF;
    }

    public boolean o() {
        return i() instanceof w;
    }

    public boolean p() {
        return q() == null;
    }

    @PublishedApi
    public final LockFreeLinkedListNode q() {
        Object objI;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            objI = i();
            if (objI instanceof w) {
                return ((w) objI).f69495a;
            }
            if (objI == this) {
                return (LockFreeLinkedListNode) objI;
            }
            Intrinsics.e(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) objI;
        } while (!kotlinx.coroutines.o.a(f69442a, this, objI, lockFreeLinkedListNode.r()));
        lockFreeLinkedListNode.f(null);
        return null;
    }

    public final w r() {
        w wVar = (w) f69444c.get(this);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this);
        f69444c.set(this, wVar2);
        return wVar2;
    }

    @PublishedApi
    public final int s(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, a aVar) {
        f69443b.set(lockFreeLinkedListNode, this);
        f69442a.set(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        aVar.f69446c = lockFreeLinkedListNode2;
        if (kotlinx.coroutines.o.a(f69442a, this, lockFreeLinkedListNode2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.jvm.internal.PropertyReference0
            public Object get() {
                return m0.a(this.receiver);
            }
        } + '@' + m0.b(this);
    }
}
