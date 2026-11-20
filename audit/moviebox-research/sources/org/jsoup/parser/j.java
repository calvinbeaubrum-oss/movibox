package org.jsoup.parser;

import java.io.Reader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j extends i {

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f73227a;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            f73227a = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f73227a[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f73227a[Token.TokenType.Comment.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f73227a[Token.TokenType.Character.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f73227a[Token.TokenType.Doctype.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f73227a[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void n(org.jsoup.nodes.g gVar) {
        a().j0(gVar);
    }

    @Override // org.jsoup.parser.i
    public d b() {
        return d.f73172d;
    }

    @Override // org.jsoup.parser.i
    public void c(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        super.c(reader, str, parseErrorList, dVar);
        this.f73220d.add(this.f73219c);
        this.f73219c.j1().n(Document.OutputSettings.Syntax.xml);
    }

    @Override // org.jsoup.parser.i
    public boolean e(Token token) {
        switch (a.f73227a[token.f73127a.ordinal()]) {
            case 1:
                j(token.e());
                break;
            case 2:
                o(token.d());
                break;
            case 3:
                l(token.b());
                break;
            case 4:
                k(token.a());
                break;
            case 5:
                m(token.c());
                break;
            case 6:
                break;
            default:
                d30.d.a("Unexpected token type: " + token.f73127a);
                break;
        }
        return true;
    }

    public Element j(Token.h hVar) {
        f fVarL = f.l(hVar.A(), this.f73224h);
        Element element = new Element(fVarL, this.f73221e, this.f73224h.a(hVar.f73144j));
        n(element);
        if (!hVar.z()) {
            this.f73220d.add(element);
        } else if (!fVarL.f()) {
            fVarL.j();
        }
        return element;
    }

    public void k(Token.c cVar) {
        String strQ = cVar.q();
        n(cVar.f() ? new org.jsoup.nodes.c(strQ) : new org.jsoup.nodes.i(strQ));
    }

    public void l(Token.d dVar) {
        org.jsoup.nodes.d dVar2 = new org.jsoup.nodes.d(dVar.p());
        org.jsoup.nodes.g gVar = dVar2;
        if (dVar.f73130c) {
            String strF0 = dVar2.f0();
            if (strF0.length() > 1 && (strF0.startsWith("!") || strF0.startsWith("?"))) {
                gVar = dVar2;
                gVar = dVar2;
                gVar = dVar2;
                Document documentC = c30.a.c("<" + strF0.substring(1, strF0.length() - 1) + ">", this.f73221e, e.g());
                gVar = dVar2;
                if (documentC.o() > 0) {
                    Element elementP0 = documentC.p0(0);
                    org.jsoup.nodes.g jVar = new org.jsoup.nodes.j(this.f73224h.b(elementP0.X0()), strF0.startsWith("!"));
                    jVar.j().g(elementP0.j());
                    gVar = jVar;
                }
            }
        }
        gVar = dVar2;
        gVar = dVar2;
        gVar = dVar2;
        n(gVar);
    }

    public void m(Token.e eVar) {
        org.jsoup.nodes.f fVar = new org.jsoup.nodes.f(this.f73224h.b(eVar.p()), eVar.r(), eVar.s());
        fVar.g0(eVar.q());
        n(fVar);
    }

    public final void o(Token.g gVar) {
        Element element;
        String strB = this.f73224h.b(gVar.f73136b);
        int size = this.f73220d.size() - 1;
        while (true) {
            if (size < 0) {
                element = null;
                break;
            }
            element = this.f73220d.get(size);
            if (element.E().equals(strB)) {
                break;
            } else {
                size--;
            }
        }
        if (element == null) {
            return;
        }
        for (int size2 = this.f73220d.size() - 1; size2 >= 0; size2--) {
            Element element2 = this.f73220d.get(size2);
            this.f73220d.remove(size2);
            if (element2 == element) {
                return;
            }
        }
    }
}
