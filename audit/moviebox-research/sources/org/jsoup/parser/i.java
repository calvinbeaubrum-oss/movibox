package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f73217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f73218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Document f73219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<Element> f73220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f73221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Token f73222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ParseErrorList f73223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f73224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Token.h f73225i = new Token.h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Token.g f73226j = new Token.g();

    public Element a() {
        int size = this.f73220d.size();
        if (size > 0) {
            return this.f73220d.get(size - 1);
        }
        return null;
    }

    public abstract d b();

    public void c(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        d30.d.k(reader, "String input must not be null");
        d30.d.k(str, "BaseURI must not be null");
        this.f73219c = new Document(str);
        this.f73224h = dVar;
        this.f73217a = new a(reader);
        this.f73223g = parseErrorList;
        this.f73222f = null;
        this.f73218b = new h(this.f73217a, parseErrorList);
        this.f73220d = new ArrayList<>(32);
        this.f73221e = str;
    }

    public Document d(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        c(reader, str, parseErrorList, dVar);
        i();
        return this.f73219c;
    }

    public abstract boolean e(Token token);

    public boolean f(String str) {
        Token token = this.f73222f;
        Token.g gVar = this.f73226j;
        return token == gVar ? e(new Token.g().B(str)) : e(gVar.m().B(str));
    }

    public boolean g(String str) {
        Token token = this.f73222f;
        Token.h hVar = this.f73225i;
        return token == hVar ? e(new Token.h().B(str)) : e(hVar.m().B(str));
    }

    public boolean h(String str, org.jsoup.nodes.b bVar) {
        Token token = this.f73222f;
        Token.h hVar = this.f73225i;
        if (token == hVar) {
            return e(new Token.h().G(str, bVar));
        }
        hVar.m();
        this.f73225i.G(str, bVar);
        return e(this.f73225i);
    }

    public void i() {
        Token tokenT;
        do {
            tokenT = this.f73218b.t();
            e(tokenT);
            tokenT.m();
        } while (tokenT.f73127a != Token.TokenType.EOF);
    }
}
