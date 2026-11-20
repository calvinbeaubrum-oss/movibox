package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {
    public static NodeFilter.FilterResult a(NodeFilter nodeFilter, g gVar) {
        g gVarN = gVar;
        int i11 = 0;
        while (gVarN != null) {
            NodeFilter.FilterResult filterResultB = nodeFilter.b(gVarN, i11);
            if (filterResultB == NodeFilter.FilterResult.STOP) {
                return filterResultB;
            }
            if (filterResultB != NodeFilter.FilterResult.CONTINUE || gVarN.o() <= 0) {
                while (gVarN.D() == null && i11 > 0) {
                    NodeFilter.FilterResult filterResult = NodeFilter.FilterResult.CONTINUE;
                    if ((filterResultB == filterResult || filterResultB == NodeFilter.FilterResult.SKIP_CHILDREN) && (filterResultB = nodeFilter.a(gVarN, i11)) == NodeFilter.FilterResult.STOP) {
                        return filterResultB;
                    }
                    g gVarM = gVarN.M();
                    i11--;
                    if (filterResultB == NodeFilter.FilterResult.REMOVE) {
                        gVarN.O();
                    }
                    filterResultB = filterResult;
                    gVarN = gVarM;
                }
                if ((filterResultB == NodeFilter.FilterResult.CONTINUE || filterResultB == NodeFilter.FilterResult.SKIP_CHILDREN) && (filterResultB = nodeFilter.a(gVarN, i11)) == NodeFilter.FilterResult.STOP) {
                    return filterResultB;
                }
                if (gVarN == gVar) {
                    return filterResultB;
                }
                g gVarD = gVarN.D();
                if (filterResultB == NodeFilter.FilterResult.REMOVE) {
                    gVarN.O();
                }
                gVarN = gVarD;
            } else {
                gVarN = gVarN.n(0);
                i11++;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void b(NodeFilter nodeFilter, Elements elements) {
        d30.d.j(nodeFilter);
        d30.d.j(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext() && a(nodeFilter, it.next()) != NodeFilter.FilterResult.STOP) {
        }
    }

    public static void c(g30.a aVar, g gVar) {
        g gVarN = gVar;
        int i11 = 0;
        while (gVarN != null) {
            aVar.b(gVarN, i11);
            if (gVarN.o() > 0) {
                gVarN = gVarN.n(0);
                i11++;
            } else {
                while (gVarN.D() == null && i11 > 0) {
                    aVar.a(gVarN, i11);
                    gVarN = gVarN.M();
                    i11--;
                }
                aVar.a(gVarN, i11);
                if (gVarN == gVar) {
                    return;
                } else {
                    gVarN = gVarN.D();
                }
            }
        }
    }

    public static void d(g30.a aVar, Elements elements) {
        d30.d.j(aVar);
        d30.d.j(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            c(aVar, it.next());
        }
    }
}
