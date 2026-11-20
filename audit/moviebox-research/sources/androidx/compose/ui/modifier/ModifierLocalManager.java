package androidx.compose.ui.modifier;

import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.y0;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ModifierLocalManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f4892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<BackwardsCompatNode> f4893b = new androidx.compose.runtime.collection.b<>(new BackwardsCompatNode[16], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<c<?>> f4894c = new androidx.compose.runtime.collection.b<>(new c[16], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<LayoutNode> f4895d = new androidx.compose.runtime.collection.b<>(new LayoutNode[16], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<c<?>> f4896e = new androidx.compose.runtime.collection.b<>(new c[16], 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4897f;

    public ModifierLocalManager(y0 y0Var) {
        this.f4892a = y0Var;
    }

    public final void a(BackwardsCompatNode backwardsCompatNode, c<?> cVar) {
        this.f4893b.b(backwardsCompatNode);
        this.f4894c.b(cVar);
        b();
    }

    public final void b() {
        if (this.f4897f) {
            return;
        }
        this.f4897f = true;
        this.f4892a.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.e();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    public final void c(androidx.compose.ui.f.c r13, androidx.compose.ui.modifier.c<?> r14, java.util.Set<androidx.compose.ui.node.BackwardsCompatNode> r15) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.modifier.ModifierLocalManager.c(androidx.compose.ui.f$c, androidx.compose.ui.modifier.c, java.util.Set):void");
    }

    public final void d(BackwardsCompatNode backwardsCompatNode, c<?> cVar) {
        this.f4895d.b(androidx.compose.ui.node.g.m(backwardsCompatNode));
        this.f4896e.b(cVar);
        b();
    }

    public final void e() {
        int i11 = 0;
        this.f4897f = false;
        HashSet hashSet = new HashSet();
        androidx.compose.runtime.collection.b<LayoutNode> bVar = this.f4895d;
        int iR = bVar.r();
        if (iR > 0) {
            LayoutNode[] layoutNodeArrQ = bVar.q();
            int i12 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArrQ[i12];
                c<?> cVar = this.f4896e.q()[i12];
                if (layoutNode.e0().k().o1()) {
                    c(layoutNode.e0().k(), cVar, hashSet);
                }
                i12++;
            } while (i12 < iR);
        }
        this.f4895d.i();
        this.f4896e.i();
        androidx.compose.runtime.collection.b<BackwardsCompatNode> bVar2 = this.f4893b;
        int iR2 = bVar2.r();
        if (iR2 > 0) {
            BackwardsCompatNode[] backwardsCompatNodeArrQ = bVar2.q();
            do {
                BackwardsCompatNode backwardsCompatNode = backwardsCompatNodeArrQ[i11];
                c<?> cVar2 = this.f4894c.q()[i11];
                if (backwardsCompatNode.o1()) {
                    c(backwardsCompatNode, cVar2, hashSet);
                }
                i11++;
            } while (i11 < iR2);
        }
        this.f4893b.i();
        this.f4894c.i();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((BackwardsCompatNode) it.next()).P1();
        }
    }

    public final void f(BackwardsCompatNode backwardsCompatNode, c<?> cVar) {
        this.f4893b.b(backwardsCompatNode);
        this.f4894c.b(cVar);
        b();
    }
}
