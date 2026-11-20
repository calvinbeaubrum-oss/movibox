package f30;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;
import org.jsoup.parser.f;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b extends Element {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Elements f64537k;

    public b(f fVar, String str, org.jsoup.nodes.b bVar) {
        super(fVar, str, bVar);
        this.f64537k = new Elements();
    }

    @Override // org.jsoup.nodes.g
    public void Q(g gVar) {
        super.Q(gVar);
        this.f64537k.remove(gVar);
    }

    public b g1(Element element) {
        this.f64537k.add(element);
        return this;
    }
}
