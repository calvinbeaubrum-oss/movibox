package q30;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateError;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, CompiledTemplate> f74276a = new HashMap();

    @Override // q30.c
    public CompiledTemplate a(String str) {
        CompiledTemplate compiledTemplate = this.f74276a.get(str);
        if (compiledTemplate != null) {
            return compiledTemplate;
        }
        throw new TemplateError("no named template exists '" + str + "'");
    }

    @Override // q30.c
    public void b(String str, CompiledTemplate compiledTemplate) {
        this.f74276a.put(str, compiledTemplate);
    }
}
