package q30;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Map;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.res.Node;
import t30.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f74288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f74289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Node f74290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f74291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f74292e;

    public d(char[] cArr, c cVar, Node node, String str) {
        this.f74288a = cArr;
        this.f74289b = cVar;
        this.f74290c = node;
        this.f74291d = str;
    }

    public static Object a(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        return d(b.f(str), obj, variableResolverFactory);
    }

    public static Object b(String str, Map map) {
        return d(b.f(str), null, new MapVariableResolverFactory(map));
    }

    public static Object d(CompiledTemplate compiledTemplate, Object obj, VariableResolverFactory variableResolverFactory) {
        return f(compiledTemplate.getRoot(), compiledTemplate.getTemplate(), new StringBuilder(), obj, variableResolverFactory, null);
    }

    public static Object e(CompiledTemplate compiledTemplate, Object obj, VariableResolverFactory variableResolverFactory, c cVar) {
        return f(compiledTemplate.getRoot(), compiledTemplate.getTemplate(), new StringBuilder(), obj, variableResolverFactory, cVar);
    }

    public static Object f(Node node, char[] cArr, StringBuilder sb2, Object obj, VariableResolverFactory variableResolverFactory, c cVar) {
        return new d(cArr, cVar, node, InstructionFileId.DOT).c(sb2, obj, variableResolverFactory);
    }

    public Object c(StringBuilder sb2, Object obj, VariableResolverFactory variableResolverFactory) {
        return g(new s30.a(sb2), obj, variableResolverFactory);
    }

    public Object g(r30.c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        return this.f74290c.eval(this, cVar, obj, variableResolverFactory);
    }

    public c h() {
        return this.f74289b;
    }

    public g i() {
        if (this.f74292e == null) {
            g gVar = new g();
            this.f74292e = gVar;
            gVar.q(this.f74291d);
        }
        return this.f74292e;
    }

    public char[] j() {
        return this.f74288a;
    }

    public void k(c cVar) {
        this.f74289b = cVar;
    }
}
