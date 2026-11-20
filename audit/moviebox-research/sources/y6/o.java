package y6;

import com.airbnb.lottie.model.DocumentData;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends g<DocumentData> {

    /* JADX INFO: compiled from: source.java */
    public class a extends h7.c<DocumentData> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h7.b f81279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h7.c f81280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ DocumentData f81281f;

        public a(h7.b bVar, h7.c cVar, DocumentData documentData) {
            this.f81279d = bVar;
            this.f81280e = cVar;
            this.f81281f = documentData;
        }

        @Override // h7.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DocumentData a(h7.b<DocumentData> bVar) {
            this.f81279d.h(bVar.f(), bVar.a(), bVar.g().f15143a, bVar.b().f15143a, bVar.d(), bVar.c(), bVar.e());
            String str = (String) this.f81280e.a(this.f81279d);
            DocumentData documentDataB = bVar.c() == 1.0f ? bVar.b() : bVar.g();
            this.f81281f.a(str, documentDataB.f15144b, documentDataB.f15145c, documentDataB.f15146d, documentDataB.f15147e, documentDataB.f15148f, documentDataB.f15149g, documentDataB.f15150h, documentDataB.f15151i, documentDataB.f15152j, documentDataB.f15153k, documentDataB.f15154l, documentDataB.f15155m);
            return this.f81281f;
        }
    }

    public o(List<h7.a<DocumentData>> list) {
        super(list);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // y6.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public DocumentData i(h7.a<DocumentData> aVar, float f11) {
        DocumentData documentData;
        h7.c<A> cVar = this.f81231e;
        if (cVar == 0) {
            return (f11 != 1.0f || (documentData = aVar.f66351c) == null) ? aVar.f66350b : documentData;
        }
        float f12 = aVar.f66355g;
        Float f13 = aVar.f66356h;
        float fFloatValue = f13 == null ? Float.MAX_VALUE : f13.floatValue();
        DocumentData documentData2 = aVar.f66350b;
        DocumentData documentData3 = documentData2;
        DocumentData documentData4 = aVar.f66351c;
        return (DocumentData) cVar.b(f12, fFloatValue, documentData3, documentData4 == null ? documentData2 : documentData4, f11, d(), f());
    }

    public void r(h7.c<String> cVar) {
        super.o(new a(new h7.b(), cVar, new DocumentData()));
    }
}
