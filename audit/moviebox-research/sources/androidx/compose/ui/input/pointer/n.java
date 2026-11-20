package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.Metadata;
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
public final class n extends o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.compose.ui.f.c f4719c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.compose.ui.layout.m f4722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q f4723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4724h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f2.b f4720d = new f2.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.collection.v<z> f4721e = new androidx.collection.v<>(2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4725i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4726j = true;

    public n(androidx.compose.ui.f.c cVar) {
        this.f4719c = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0258  */
    /* JADX WARN: Code duplicated, block: B:105:0x0266  */
    /* JADX WARN: Code duplicated, block: B:85:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x022b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0230  */
    /* JADX WARN: Code duplicated, block: B:96:0x0238  */
    /* JADX WARN: Code duplicated, block: B:98:0x0248  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v23 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.input.pointer.o
    public boolean a(androidx.collection.v<androidx.compose.ui.input.pointer.z> r37, androidx.compose.ui.layout.m r38, androidx.compose.ui.input.pointer.i r39, boolean r40) {
        /*
            Method dump skipped, instruction units count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.n.a(androidx.collection.v, androidx.compose.ui.layout.m, androidx.compose.ui.input.pointer.i, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.o
    public void b(i iVar) {
        super.b(iVar);
        q qVar = this.f4723g;
        if (qVar == null) {
            return;
        }
        this.f4724h = this.f4725i;
        List<z> listC = qVar.c();
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            z zVar = listC.get(i11);
            boolean z11 = !zVar.i();
            boolean z12 = !iVar.a(zVar.f());
            boolean z13 = !this.f4725i;
            if ((z11 && z12) || (z11 && z13)) {
                this.f4720d.i(zVar.f());
            }
        }
        this.f4725i = false;
        this.f4726j = s.i(qVar.f(), s.f4737a.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.input.pointer.o
    public void d() {
        /*
            r10 = this;
            androidx.compose.runtime.collection.b r0 = r10.g()
            int r1 = r0.r()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L1b
            java.lang.Object[] r0 = r0.q()
            r4 = 0
        L11:
            r5 = r0[r4]
            androidx.compose.ui.input.pointer.n r5 = (androidx.compose.ui.input.pointer.n) r5
            r5.d()
            int r4 = r4 + r3
            if (r4 < r1) goto L11
        L1b:
            androidx.compose.ui.f$c r0 = r10.f4719c
            r1 = 16
            int r4 = androidx.compose.ui.node.s0.a(r1)
            r5 = 0
            r6 = r5
        L25:
            if (r0 == 0) goto L72
            boolean r7 = r0 instanceof androidx.compose.ui.node.e1
            if (r7 == 0) goto L31
            androidx.compose.ui.node.e1 r0 = (androidx.compose.ui.node.e1) r0
            r0.D0()
            goto L6d
        L31:
            int r7 = r0.j1()
            r7 = r7 & r4
            if (r7 == 0) goto L6d
            boolean r7 = r0 instanceof androidx.compose.ui.node.i
            if (r7 == 0) goto L6d
            r7 = r0
            androidx.compose.ui.node.i r7 = (androidx.compose.ui.node.i) r7
            androidx.compose.ui.f$c r7 = r7.I1()
            r8 = 0
        L44:
            if (r7 == 0) goto L6a
            int r9 = r7.j1()
            r9 = r9 & r4
            if (r9 == 0) goto L65
            int r8 = r8 + 1
            if (r8 != r3) goto L53
            r0 = r7
            goto L65
        L53:
            if (r6 != 0) goto L5c
            androidx.compose.runtime.collection.b r6 = new androidx.compose.runtime.collection.b
            androidx.compose.ui.f$c[] r9 = new androidx.compose.ui.f.c[r1]
            r6.<init>(r9, r2)
        L5c:
            if (r0 == 0) goto L62
            r6.b(r0)
            r0 = r5
        L62:
            r6.b(r7)
        L65:
            androidx.compose.ui.f$c r7 = r7.f1()
            goto L44
        L6a:
            if (r8 != r3) goto L6d
            goto L25
        L6d:
            androidx.compose.ui.f$c r0 = androidx.compose.ui.node.g.b(r6)
            goto L25
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.n.d():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.input.pointer.o
    public boolean e(androidx.compose.ui.input.pointer.i r14) {
        /*
            r13 = this;
            androidx.collection.v<androidx.compose.ui.input.pointer.z> r0 = r13.f4721e
            boolean r0 = r0.j()
            r1 = 0
            if (r0 == 0) goto Lb
            goto L9e
        Lb:
            androidx.compose.ui.f$c r0 = r13.f4719c
            boolean r0 = r0.o1()
            if (r0 != 0) goto L15
            goto L9e
        L15:
            androidx.compose.ui.input.pointer.q r0 = r13.f4723g
            kotlin.jvm.internal.Intrinsics.d(r0)
            androidx.compose.ui.layout.m r2 = r13.f4722f
            kotlin.jvm.internal.Intrinsics.d(r2)
            long r2 = r2.p()
            androidx.compose.ui.f$c r4 = r13.f4719c
            r5 = 16
            int r6 = androidx.compose.ui.node.s0.a(r5)
            r7 = 0
            r8 = r7
        L2d:
            r9 = 1
            if (r4 == 0) goto L7d
            boolean r10 = r4 instanceof androidx.compose.ui.node.e1
            if (r10 == 0) goto L3c
            androidx.compose.ui.node.e1 r4 = (androidx.compose.ui.node.e1) r4
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4.T(r0, r9, r2)
            goto L78
        L3c:
            int r10 = r4.j1()
            r10 = r10 & r6
            if (r10 == 0) goto L78
            boolean r10 = r4 instanceof androidx.compose.ui.node.i
            if (r10 == 0) goto L78
            r10 = r4
            androidx.compose.ui.node.i r10 = (androidx.compose.ui.node.i) r10
            androidx.compose.ui.f$c r10 = r10.I1()
            r11 = 0
        L4f:
            if (r10 == 0) goto L75
            int r12 = r10.j1()
            r12 = r12 & r6
            if (r12 == 0) goto L70
            int r11 = r11 + 1
            if (r11 != r9) goto L5e
            r4 = r10
            goto L70
        L5e:
            if (r8 != 0) goto L67
            androidx.compose.runtime.collection.b r8 = new androidx.compose.runtime.collection.b
            androidx.compose.ui.f$c[] r12 = new androidx.compose.ui.f.c[r5]
            r8.<init>(r12, r1)
        L67:
            if (r4 == 0) goto L6d
            r8.b(r4)
            r4 = r7
        L6d:
            r8.b(r10)
        L70:
            androidx.compose.ui.f$c r10 = r10.f1()
            goto L4f
        L75:
            if (r11 != r9) goto L78
            goto L2d
        L78:
            androidx.compose.ui.f$c r4 = androidx.compose.ui.node.g.b(r8)
            goto L2d
        L7d:
            androidx.compose.ui.f$c r0 = r13.f4719c
            boolean r0 = r0.o1()
            if (r0 == 0) goto L9d
            androidx.compose.runtime.collection.b r0 = r13.g()
            int r2 = r0.r()
            if (r2 <= 0) goto L9d
            java.lang.Object[] r0 = r0.q()
        L93:
            r3 = r0[r1]
            androidx.compose.ui.input.pointer.n r3 = (androidx.compose.ui.input.pointer.n) r3
            r3.e(r14)
            int r1 = r1 + r9
            if (r1 < r2) goto L93
        L9d:
            r1 = 1
        L9e:
            r13.b(r14)
            r13.j()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.n.e(androidx.compose.ui.input.pointer.i):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.input.pointer.o
    public boolean f(androidx.collection.v<androidx.compose.ui.input.pointer.z> r12, androidx.compose.ui.layout.m r13, androidx.compose.ui.input.pointer.i r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.n.f(androidx.collection.v, androidx.compose.ui.layout.m, androidx.compose.ui.input.pointer.i, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.o
    public void i(long j11, androidx.collection.j0<n> j0Var) {
        if (this.f4720d.d(j11) && !j0Var.a(this)) {
            this.f4720d.h(j11);
            this.f4721e.m(j11);
        }
        androidx.compose.runtime.collection.b<n> bVarG = g();
        int iR = bVarG.r();
        if (iR > 0) {
            n[] nVarArrQ = bVarG.q();
            int i11 = 0;
            do {
                nVarArrQ[i11].i(j11, j0Var);
                i11++;
            } while (i11 < iR);
        }
    }

    public final void j() {
        this.f4721e.b();
        this.f4722f = null;
    }

    public final androidx.compose.ui.f.c k() {
        return this.f4719c;
    }

    public final f2.b l() {
        return this.f4720d;
    }

    public final boolean m(q qVar, q qVar2) {
        if (qVar == null || qVar.c().size() != qVar2.c().size()) {
            return true;
        }
        int size = qVar2.c().size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!y1.g.j(qVar.c().get(i11).h(), qVar2.c().get(i11).h())) {
                return true;
            }
        }
        return false;
    }

    public final void n() {
        this.f4725i = true;
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.f4719c + ", children=" + g() + ", pointerIds=" + this.f4720d + ')';
    }
}
