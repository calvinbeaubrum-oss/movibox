package org.jsoup.parser;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
            } else {
                if (!token.i()) {
                    bVar.C0(HtmlTreeBuilderState.BeforeHtml);
                    return bVar.e(token);
                }
                Token.e eVarC = token.c();
                org.jsoup.nodes.f fVar = new org.jsoup.nodes.f(bVar.f73224h.b(eVarC.p()), eVarC.r(), eVarC.s());
                fVar.g0(eVarC.q());
                bVar.w().j0(fVar);
                if (eVarC.t()) {
                    bVar.w().l1(Document.QuirksMode.quirks);
                }
                bVar.C0(HtmlTreeBuilderState.BeforeHtml);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.V("html");
            bVar.C0(HtmlTreeBuilderState.BeforeHead);
            return bVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (token.h()) {
                bVar.O(token.b());
            } else {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    return true;
                }
                if (!token.l() || !token.e().D().equals("html")) {
                    if ((!token.k() || !d30.c.b(token.d().D(), TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "html", TtmlNode.TAG_BR)) && token.k()) {
                        bVar.p(this);
                        return false;
                    }
                    return anythingElse(token, bVar);
                }
                bVar.L(token.e());
                bVar.C0(HtmlTreeBuilderState.BeforeHead);
            }
            return true;
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
            } else {
                if (token.i()) {
                    bVar.p(this);
                    return false;
                }
                if (token.l() && token.e().D().equals("html")) {
                    return HtmlTreeBuilderState.InBody.process(token, bVar);
                }
                if (!token.l() || !token.e().D().equals(TtmlNode.TAG_HEAD)) {
                    if (token.k() && d30.c.b(token.d().D(), TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "html", TtmlNode.TAG_BR)) {
                        bVar.g(TtmlNode.TAG_HEAD);
                        return bVar.e(token);
                    }
                    if (token.k()) {
                        bVar.p(this);
                        return false;
                    }
                    bVar.g(TtmlNode.TAG_HEAD);
                    return bVar.e(token);
                }
                bVar.A0(bVar.L(token.e()));
                bVar.C0(HtmlTreeBuilderState.InHead);
            }
            return true;
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        private boolean anythingElse(Token token, i iVar) {
            iVar.f(TtmlNode.TAG_HEAD);
            return iVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            int i11 = a.f73109a[token.f73127a.ordinal()];
            if (i11 == 1) {
                bVar.O(token.b());
            } else {
                if (i11 == 2) {
                    bVar.p(this);
                    return false;
                }
                if (i11 == 3) {
                    Token.h hVarE = token.e();
                    String strD = hVarE.D();
                    if (strD.equals("html")) {
                        return HtmlTreeBuilderState.InBody.process(token, bVar);
                    }
                    if (d30.c.b(strD, "base", "basefont", "bgsound", "command", "link")) {
                        Element elementP = bVar.P(hVarE);
                        if (strD.equals("base") && elementP.z("href")) {
                            bVar.e0(elementP);
                        }
                    } else if (strD.equals("meta")) {
                        bVar.P(hVarE);
                    } else if (strD.equals(CampaignEx.JSON_KEY_TITLE)) {
                        HtmlTreeBuilderState.handleRcData(hVarE, bVar);
                    } else if (d30.c.b(strD, "noframes", TtmlNode.TAG_STYLE)) {
                        HtmlTreeBuilderState.handleRawtext(hVarE, bVar);
                    } else if (strD.equals("noscript")) {
                        bVar.L(hVarE);
                        bVar.C0(HtmlTreeBuilderState.InHeadNoscript);
                    } else {
                        if (!strD.equals("script")) {
                            if (!strD.equals(TtmlNode.TAG_HEAD)) {
                                return anythingElse(token, bVar);
                            }
                            bVar.p(this);
                            return false;
                        }
                        bVar.f73218b.u(TokeniserState.ScriptData);
                        bVar.d0();
                        bVar.C0(HtmlTreeBuilderState.Text);
                        bVar.L(hVarE);
                    }
                } else {
                    if (i11 != 4) {
                        return anythingElse(token, bVar);
                    }
                    String strD2 = token.d().D();
                    if (!strD2.equals(TtmlNode.TAG_HEAD)) {
                        if (d30.c.b(strD2, TtmlNode.TAG_BODY, "html", TtmlNode.TAG_BR)) {
                            return anythingElse(token, bVar);
                        }
                        bVar.p(this);
                        return false;
                    }
                    bVar.j0();
                    bVar.C0(HtmlTreeBuilderState.AfterHead);
                }
            }
            return true;
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.p(this);
            bVar.N(new Token.c().p(token.toString()));
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.i()) {
                bVar.p(this);
                return true;
            }
            if (token.l() && token.e().D().equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.k() && token.d().D().equals("noscript")) {
                bVar.j0();
                bVar.C0(HtmlTreeBuilderState.InHead);
                return true;
            }
            if (HtmlTreeBuilderState.isWhitespace(token) || token.h() || (token.l() && d30.c.b(token.e().D(), "basefont", "bgsound", "link", "meta", "noframes", TtmlNode.TAG_STYLE))) {
                return bVar.n0(token, HtmlTreeBuilderState.InHead);
            }
            if (token.k() && token.d().D().equals(TtmlNode.TAG_BR)) {
                return anythingElse(token, bVar);
            }
            if ((!token.l() || !d30.c.b(token.e().D(), TtmlNode.TAG_HEAD, "noscript")) && !token.k()) {
                return anythingElse(token, bVar);
            }
            bVar.p(this);
            return false;
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.g(TtmlNode.TAG_BODY);
            bVar.q(true);
            return bVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return true;
            }
            if (!token.l()) {
                if (!token.k()) {
                    anythingElse(token, bVar);
                    return true;
                }
                if (d30.c.b(token.d().D(), TtmlNode.TAG_BODY, "html")) {
                    anythingElse(token, bVar);
                    return true;
                }
                bVar.p(this);
                return false;
            }
            Token.h hVarE = token.e();
            String strD = hVarE.D();
            if (strD.equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (strD.equals(TtmlNode.TAG_BODY)) {
                bVar.L(hVarE);
                bVar.q(false);
                bVar.C0(HtmlTreeBuilderState.InBody);
                return true;
            }
            if (strD.equals("frameset")) {
                bVar.L(hVarE);
                bVar.C0(HtmlTreeBuilderState.InFrameset);
                return true;
            }
            if (!d30.c.b(strD, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", TtmlNode.TAG_STYLE, CampaignEx.JSON_KEY_TITLE)) {
                if (strD.equals(TtmlNode.TAG_HEAD)) {
                    bVar.p(this);
                    return false;
                }
                anythingElse(token, bVar);
                return true;
            }
            bVar.p(this);
            Element elementZ = bVar.z();
            bVar.o0(elementZ);
            bVar.n0(token, HtmlTreeBuilderState.InHead);
            bVar.s0(elementZ);
            return true;
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        public boolean anyOtherEndTag(Token token, org.jsoup.parser.b bVar) {
            String strB = bVar.f73224h.b(token.d().A());
            ArrayList<Element> arrayListB = bVar.B();
            for (int size = arrayListB.size() - 1; size >= 0; size--) {
                Element element = arrayListB.get(size);
                if (element.E().equals(strB)) {
                    bVar.t(strB);
                    if (!strB.equals(bVar.a().E())) {
                        bVar.p(this);
                    }
                    bVar.l0(strB);
                    break;
                }
                if (bVar.b0(element)) {
                    bVar.p(this);
                    return false;
                }
            }
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            Element element;
            int i11 = a.f73109a[token.f73127a.ordinal()];
            boolean z11 = true;
            if (i11 == 1) {
                bVar.O(token.b());
            } else {
                if (i11 == 2) {
                    bVar.p(this);
                    return false;
                }
                if (i11 == 3) {
                    Token.h hVarE = token.e();
                    String strD = hVarE.D();
                    if (strD.equals("a")) {
                        if (bVar.u("a") != null) {
                            bVar.p(this);
                            bVar.f("a");
                            Element elementY = bVar.y("a");
                            if (elementY != null) {
                                bVar.r0(elementY);
                                bVar.s0(elementY);
                            }
                        }
                        bVar.q0();
                        bVar.p0(bVar.L(hVarE));
                    } else if (d30.c.c(strD, b.f73118i)) {
                        bVar.q0();
                        bVar.P(hVarE);
                        bVar.q(false);
                    } else if (d30.c.c(strD, b.f73111b)) {
                        if (bVar.C(TtmlNode.TAG_P)) {
                            bVar.f(TtmlNode.TAG_P);
                        }
                        bVar.L(hVarE);
                    } else if (strD.equals(TtmlNode.TAG_SPAN)) {
                        bVar.q0();
                        bVar.L(hVarE);
                    } else if (strD.equals("li")) {
                        bVar.q(false);
                        ArrayList<Element> arrayListB = bVar.B();
                        for (int size = arrayListB.size() - 1; size > 0; size--) {
                            Element element2 = arrayListB.get(size);
                            if (element2.E().equals("li")) {
                                bVar.f("li");
                                break;
                            }
                            if (bVar.b0(element2) && !d30.c.c(element2.E(), b.f73114e)) {
                                break;
                            }
                        }
                        if (bVar.C(TtmlNode.TAG_P)) {
                            bVar.f(TtmlNode.TAG_P);
                        }
                        bVar.L(hVarE);
                    } else if (strD.equals("html")) {
                        bVar.p(this);
                        Element element3 = bVar.B().get(0);
                        for (org.jsoup.nodes.a aVar : hVarE.y()) {
                            if (!element3.z(aVar.getKey())) {
                                element3.j().H(aVar);
                            }
                        }
                    } else {
                        if (d30.c.c(strD, b.f73110a)) {
                            return bVar.n0(token, HtmlTreeBuilderState.InHead);
                        }
                        if (strD.equals(TtmlNode.TAG_BODY)) {
                            bVar.p(this);
                            ArrayList<Element> arrayListB2 = bVar.B();
                            if (arrayListB2.size() == 1 || (arrayListB2.size() > 2 && !arrayListB2.get(1).E().equals(TtmlNode.TAG_BODY))) {
                                return false;
                            }
                            bVar.q(false);
                            Element element4 = arrayListB2.get(1);
                            for (org.jsoup.nodes.a aVar2 : hVarE.y()) {
                                if (!element4.z(aVar2.getKey())) {
                                    element4.j().H(aVar2);
                                }
                            }
                        } else if (strD.equals("frameset")) {
                            bVar.p(this);
                            ArrayList<Element> arrayListB3 = bVar.B();
                            if (arrayListB3.size() == 1 || ((arrayListB3.size() > 2 && !arrayListB3.get(1).E().equals(TtmlNode.TAG_BODY)) || !bVar.r())) {
                                return false;
                            }
                            Element element5 = arrayListB3.get(1);
                            if (element5.L() != null) {
                                element5.O();
                            }
                            for (int i12 = 1; arrayListB3.size() > i12; i12 = 1) {
                                arrayListB3.remove(arrayListB3.size() - i12);
                            }
                            bVar.L(hVarE);
                            bVar.C0(HtmlTreeBuilderState.InFrameset);
                        } else {
                            String[] strArr = b.f73112c;
                            if (d30.c.c(strD, strArr)) {
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                if (d30.c.c(bVar.a().E(), strArr)) {
                                    bVar.p(this);
                                    bVar.j0();
                                }
                                bVar.L(hVarE);
                            } else if (d30.c.c(strD, b.f73113d)) {
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.L(hVarE);
                                bVar.f73217a.u("\n");
                                bVar.q(false);
                            } else {
                                if (strD.equals("form")) {
                                    if (bVar.x() != null) {
                                        bVar.p(this);
                                        return false;
                                    }
                                    if (bVar.C(TtmlNode.TAG_P)) {
                                        bVar.f(TtmlNode.TAG_P);
                                    }
                                    bVar.Q(hVarE, true);
                                    return true;
                                }
                                if (d30.c.c(strD, b.f73115f)) {
                                    bVar.q(false);
                                    ArrayList<Element> arrayListB4 = bVar.B();
                                    for (int size2 = arrayListB4.size() - 1; size2 > 0; size2--) {
                                        Element element6 = arrayListB4.get(size2);
                                        if (d30.c.c(element6.E(), b.f73115f)) {
                                            bVar.f(element6.E());
                                            break;
                                        }
                                        if (bVar.b0(element6) && !d30.c.c(element6.E(), b.f73114e)) {
                                            break;
                                        }
                                    }
                                    if (bVar.C(TtmlNode.TAG_P)) {
                                        bVar.f(TtmlNode.TAG_P);
                                    }
                                    bVar.L(hVarE);
                                } else if (strD.equals("plaintext")) {
                                    if (bVar.C(TtmlNode.TAG_P)) {
                                        bVar.f(TtmlNode.TAG_P);
                                    }
                                    bVar.L(hVarE);
                                    bVar.f73218b.u(TokeniserState.PLAINTEXT);
                                } else if (strD.equals("button")) {
                                    if (bVar.C("button")) {
                                        bVar.p(this);
                                        bVar.f("button");
                                        bVar.e(hVarE);
                                    } else {
                                        bVar.q0();
                                        bVar.L(hVarE);
                                        bVar.q(false);
                                    }
                                } else if (d30.c.c(strD, b.f73116g)) {
                                    bVar.q0();
                                    bVar.p0(bVar.L(hVarE));
                                } else if (strD.equals("nobr")) {
                                    bVar.q0();
                                    if (bVar.E("nobr")) {
                                        bVar.p(this);
                                        bVar.f("nobr");
                                        bVar.q0();
                                    }
                                    bVar.p0(bVar.L(hVarE));
                                } else if (d30.c.c(strD, b.f73117h)) {
                                    bVar.q0();
                                    bVar.L(hVarE);
                                    bVar.S();
                                    bVar.q(false);
                                } else if (strD.equals("table")) {
                                    if (bVar.w().k1() != Document.QuirksMode.quirks && bVar.C(TtmlNode.TAG_P)) {
                                        bVar.f(TtmlNode.TAG_P);
                                    }
                                    bVar.L(hVarE);
                                    bVar.q(false);
                                    bVar.C0(HtmlTreeBuilderState.InTable);
                                } else if (strD.equals("input")) {
                                    bVar.q0();
                                    if (!bVar.P(hVarE).g("type").equalsIgnoreCase("hidden")) {
                                        bVar.q(false);
                                    }
                                } else if (d30.c.c(strD, b.f73119j)) {
                                    bVar.P(hVarE);
                                } else if (strD.equals("hr")) {
                                    if (bVar.C(TtmlNode.TAG_P)) {
                                        bVar.f(TtmlNode.TAG_P);
                                    }
                                    bVar.P(hVarE);
                                    bVar.q(false);
                                } else if (strD.equals("image")) {
                                    if (bVar.y("svg") == null) {
                                        return bVar.e(hVarE.B("img"));
                                    }
                                    bVar.L(hVarE);
                                } else if (strD.equals("isindex")) {
                                    bVar.p(this);
                                    if (bVar.x() != null) {
                                        return false;
                                    }
                                    bVar.g("form");
                                    if (hVarE.f73144j.z("action")) {
                                        bVar.x().m0("action", hVarE.f73144j.x("action"));
                                    }
                                    bVar.g("hr");
                                    bVar.g("label");
                                    bVar.e(new Token.c().p(hVarE.f73144j.z("prompt") ? hVarE.f73144j.x("prompt") : "This is a searchable index. Enter search keywords: "));
                                    org.jsoup.nodes.b bVar2 = new org.jsoup.nodes.b();
                                    for (org.jsoup.nodes.a aVar3 : hVarE.f73144j) {
                                        if (!d30.c.c(aVar3.getKey(), b.f73120k)) {
                                            bVar2.H(aVar3);
                                        }
                                    }
                                    bVar2.G("name", "isindex");
                                    bVar.h("input", bVar2);
                                    bVar.f("label");
                                    bVar.g("hr");
                                    bVar.f("form");
                                } else if (strD.equals("textarea")) {
                                    bVar.L(hVarE);
                                    bVar.f73218b.u(TokeniserState.Rcdata);
                                    bVar.d0();
                                    bVar.q(false);
                                    bVar.C0(HtmlTreeBuilderState.Text);
                                } else if (strD.equals("xmp")) {
                                    if (bVar.C(TtmlNode.TAG_P)) {
                                        bVar.f(TtmlNode.TAG_P);
                                    }
                                    bVar.q0();
                                    bVar.q(false);
                                    HtmlTreeBuilderState.handleRawtext(hVarE, bVar);
                                } else if (strD.equals("iframe")) {
                                    bVar.q(false);
                                    HtmlTreeBuilderState.handleRawtext(hVarE, bVar);
                                } else if (strD.equals("noembed")) {
                                    HtmlTreeBuilderState.handleRawtext(hVarE, bVar);
                                } else if (strD.equals("select")) {
                                    bVar.q0();
                                    bVar.L(hVarE);
                                    bVar.q(false);
                                    HtmlTreeBuilderState htmlTreeBuilderStateB0 = bVar.B0();
                                    if (htmlTreeBuilderStateB0.equals(HtmlTreeBuilderState.InTable) || htmlTreeBuilderStateB0.equals(HtmlTreeBuilderState.InCaption) || htmlTreeBuilderStateB0.equals(HtmlTreeBuilderState.InTableBody) || htmlTreeBuilderStateB0.equals(HtmlTreeBuilderState.InRow) || htmlTreeBuilderStateB0.equals(HtmlTreeBuilderState.InCell)) {
                                        bVar.C0(HtmlTreeBuilderState.InSelectInTable);
                                    } else {
                                        bVar.C0(HtmlTreeBuilderState.InSelect);
                                    }
                                } else if (d30.c.c(strD, b.f73121l)) {
                                    if (bVar.a().E().equals("option")) {
                                        bVar.f("option");
                                    }
                                    bVar.q0();
                                    bVar.L(hVarE);
                                } else if (!d30.c.c(strD, b.f73122m)) {
                                    if (!strD.equals("math") && !strD.equals("svg") && d30.c.c(strD, b.f73123n)) {
                                        bVar.p(this);
                                        return false;
                                    }
                                    bVar.q0();
                                    bVar.L(hVarE);
                                } else if (bVar.E("ruby")) {
                                    bVar.s();
                                    if (!bVar.a().E().equals("ruby")) {
                                        bVar.p(this);
                                        bVar.k0("ruby");
                                    }
                                    bVar.L(hVarE);
                                }
                            }
                        }
                    }
                } else if (i11 == 4) {
                    Token.g gVarD = token.d();
                    String strD2 = gVarD.D();
                    if (d30.c.c(strD2, b.f73125p)) {
                        int i13 = 0;
                        while (i13 < 8) {
                            Element elementU = bVar.u(strD2);
                            if (elementU == null) {
                                return anyOtherEndTag(token, bVar);
                            }
                            if (!bVar.g0(elementU)) {
                                bVar.p(this);
                                bVar.r0(elementU);
                                return z11;
                            }
                            if (!bVar.E(elementU.E())) {
                                bVar.p(this);
                                return false;
                            }
                            if (bVar.a() != elementU) {
                                bVar.p(this);
                            }
                            ArrayList<Element> arrayListB5 = bVar.B();
                            int size3 = arrayListB5.size();
                            Element element7 = null;
                            int i14 = 0;
                            boolean z12 = false;
                            while (true) {
                                if (i14 >= size3 || i14 >= 64) {
                                    element = null;
                                    break;
                                }
                                element = arrayListB5.get(i14);
                                if (element != elementU) {
                                    if (z12 && bVar.b0(element)) {
                                        break;
                                    }
                                } else {
                                    element7 = arrayListB5.get(i14 - 1);
                                    z12 = true;
                                }
                                i14++;
                            }
                            if (element == null) {
                                bVar.l0(elementU.E());
                                bVar.r0(elementU);
                                return z11;
                            }
                            Element elementJ = element;
                            Element element8 = elementJ;
                            int i15 = 0;
                            for (int i16 = 3; i15 < i16; i16 = 3) {
                                if (bVar.g0(elementJ)) {
                                    elementJ = bVar.j(elementJ);
                                }
                                if (!bVar.Z(elementJ)) {
                                    bVar.s0(elementJ);
                                } else {
                                    if (elementJ == elementU) {
                                        break;
                                    }
                                    Element element9 = new Element(f.l(elementJ.E(), d.f73172d), bVar.v());
                                    bVar.u0(elementJ, element9);
                                    bVar.w0(elementJ, element9);
                                    if (element8.L() != null) {
                                        element8.O();
                                    }
                                    element9.j0(element8);
                                    elementJ = element9;
                                    element8 = elementJ;
                                }
                                i15++;
                            }
                            if (d30.c.c(element7.E(), b.f73126q)) {
                                if (element8.L() != null) {
                                    element8.O();
                                }
                                bVar.R(element8);
                            } else {
                                if (element8.L() != null) {
                                    element8.O();
                                }
                                element7.j0(element8);
                            }
                            Element element10 = new Element(elementU.W0(), bVar.v());
                            element10.j().g(elementU.j());
                            for (org.jsoup.nodes.g gVar : (org.jsoup.nodes.g[]) element.p().toArray(new org.jsoup.nodes.g[element.o()])) {
                                element10.j0(gVar);
                            }
                            element.j0(element10);
                            bVar.r0(elementU);
                            bVar.s0(elementU);
                            bVar.U(element, element10);
                            i13++;
                            z11 = true;
                        }
                    } else if (d30.c.c(strD2, b.f73124o)) {
                        if (!bVar.E(strD2)) {
                            bVar.p(this);
                            return false;
                        }
                        bVar.s();
                        if (!bVar.a().E().equals(strD2)) {
                            bVar.p(this);
                        }
                        bVar.l0(strD2);
                    } else {
                        if (strD2.equals(TtmlNode.TAG_SPAN)) {
                            return anyOtherEndTag(token, bVar);
                        }
                        if (strD2.equals("li")) {
                            if (!bVar.D(strD2)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.t(strD2);
                            if (!bVar.a().E().equals(strD2)) {
                                bVar.p(this);
                            }
                            bVar.l0(strD2);
                        } else if (strD2.equals(TtmlNode.TAG_BODY)) {
                            if (!bVar.E(TtmlNode.TAG_BODY)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.C0(HtmlTreeBuilderState.AfterBody);
                        } else if (strD2.equals("html")) {
                            if (bVar.f(TtmlNode.TAG_BODY)) {
                                return bVar.e(gVarD);
                            }
                        } else if (strD2.equals("form")) {
                            f30.b bVarX = bVar.x();
                            bVar.y0(null);
                            if (bVarX == null || !bVar.E(strD2)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.s();
                            if (!bVar.a().E().equals(strD2)) {
                                bVar.p(this);
                            }
                            bVar.s0(bVarX);
                        } else if (strD2.equals(TtmlNode.TAG_P)) {
                            if (!bVar.C(strD2)) {
                                bVar.p(this);
                                bVar.g(strD2);
                                return bVar.e(gVarD);
                            }
                            bVar.t(strD2);
                            if (!bVar.a().E().equals(strD2)) {
                                bVar.p(this);
                            }
                            bVar.l0(strD2);
                        } else if (!d30.c.c(strD2, b.f73115f)) {
                            String[] strArr2 = b.f73112c;
                            if (d30.c.c(strD2, strArr2)) {
                                if (!bVar.G(strArr2)) {
                                    bVar.p(this);
                                    return false;
                                }
                                bVar.t(strD2);
                                if (!bVar.a().E().equals(strD2)) {
                                    bVar.p(this);
                                }
                                bVar.m0(strArr2);
                            } else {
                                if (strD2.equals("sarcasm")) {
                                    return anyOtherEndTag(token, bVar);
                                }
                                if (!d30.c.c(strD2, b.f73117h)) {
                                    if (!strD2.equals(TtmlNode.TAG_BR)) {
                                        return anyOtherEndTag(token, bVar);
                                    }
                                    bVar.p(this);
                                    bVar.g(TtmlNode.TAG_BR);
                                    return false;
                                }
                                if (!bVar.E("name")) {
                                    if (!bVar.E(strD2)) {
                                        bVar.p(this);
                                        return false;
                                    }
                                    bVar.s();
                                    if (!bVar.a().E().equals(strD2)) {
                                        bVar.p(this);
                                    }
                                    bVar.l0(strD2);
                                    bVar.k();
                                }
                            }
                        } else {
                            if (!bVar.E(strD2)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.t(strD2);
                            if (!bVar.a().E().equals(strD2)) {
                                bVar.p(this);
                            }
                            bVar.l0(strD2);
                        }
                    }
                } else if (i11 == 5) {
                    Token.c cVarA = token.a();
                    if (cVarA.q().equals(HtmlTreeBuilderState.nullString)) {
                        bVar.p(this);
                        return false;
                    }
                    if (bVar.r() && HtmlTreeBuilderState.isWhitespace(cVarA)) {
                        bVar.q0();
                        bVar.N(cVarA);
                    } else {
                        bVar.q0();
                        bVar.N(cVarA);
                        bVar.q(false);
                    }
                }
            }
            return true;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.g()) {
                bVar.N(token.a());
                return true;
            }
            if (token.j()) {
                bVar.p(this);
                bVar.j0();
                bVar.C0(bVar.h0());
                return bVar.e(token);
            }
            if (!token.k()) {
                return true;
            }
            bVar.j0();
            bVar.C0(bVar.h0());
            return true;
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        public boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.p(this);
            if (!d30.c.b(bVar.a().E(), "table", "tbody", "tfoot", "thead", "tr")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            bVar.z0(true);
            boolean zN0 = bVar.n0(token, HtmlTreeBuilderState.InBody);
            bVar.z0(false);
            return zN0;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.g()) {
                bVar.f0();
                bVar.d0();
                bVar.C0(HtmlTreeBuilderState.InTableText);
                return bVar.e(token);
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (!token.l()) {
                if (!token.k()) {
                    if (!token.j()) {
                        return anythingElse(token, bVar);
                    }
                    if (bVar.a().E().equals("html")) {
                        bVar.p(this);
                    }
                    return true;
                }
                String strD = token.d().D();
                if (!strD.equals("table")) {
                    if (!d30.c.b(strD, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return anythingElse(token, bVar);
                    }
                    bVar.p(this);
                    return false;
                }
                if (!bVar.K(strD)) {
                    bVar.p(this);
                    return false;
                }
                bVar.l0("table");
                bVar.x0();
                return true;
            }
            Token.h hVarE = token.e();
            String strD2 = hVarE.D();
            if (strD2.equals("caption")) {
                bVar.n();
                bVar.S();
                bVar.L(hVarE);
                bVar.C0(HtmlTreeBuilderState.InCaption);
            } else if (strD2.equals("colgroup")) {
                bVar.n();
                bVar.L(hVarE);
                bVar.C0(HtmlTreeBuilderState.InColumnGroup);
            } else {
                if (strD2.equals("col")) {
                    bVar.g("colgroup");
                    return bVar.e(token);
                }
                if (d30.c.b(strD2, "tbody", "tfoot", "thead")) {
                    bVar.n();
                    bVar.L(hVarE);
                    bVar.C0(HtmlTreeBuilderState.InTableBody);
                } else {
                    if (d30.c.b(strD2, "td", "th", "tr")) {
                        bVar.g("tbody");
                        return bVar.e(token);
                    }
                    if (strD2.equals("table")) {
                        bVar.p(this);
                        if (bVar.f("table")) {
                            return bVar.e(token);
                        }
                    } else {
                        if (d30.c.b(strD2, TtmlNode.TAG_STYLE, "script")) {
                            return bVar.n0(token, HtmlTreeBuilderState.InHead);
                        }
                        if (strD2.equals("input")) {
                            if (!hVarE.f73144j.x("type").equalsIgnoreCase("hidden")) {
                                return anythingElse(token, bVar);
                            }
                            bVar.P(hVarE);
                        } else {
                            if (!strD2.equals("form")) {
                                return anythingElse(token, bVar);
                            }
                            bVar.p(this);
                            if (bVar.x() != null) {
                                return false;
                            }
                            bVar.Q(hVarE, false);
                        }
                    }
                }
            }
            return true;
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (a.f73109a[token.f73127a.ordinal()] == 5) {
                Token.c cVarA = token.a();
                if (cVarA.q().equals(HtmlTreeBuilderState.nullString)) {
                    bVar.p(this);
                    return false;
                }
                bVar.A().add(cVarA.q());
                return true;
            }
            if (bVar.A().size() > 0) {
                for (String str : bVar.A()) {
                    if (HtmlTreeBuilderState.isWhitespace(str)) {
                        bVar.N(new Token.c().p(str));
                    } else {
                        bVar.p(this);
                        if (d30.c.b(bVar.a().E(), "table", "tbody", "tfoot", "thead", "tr")) {
                            bVar.z0(true);
                            bVar.n0(new Token.c().p(str), HtmlTreeBuilderState.InBody);
                            bVar.z0(false);
                        } else {
                            bVar.n0(new Token.c().p(str), HtmlTreeBuilderState.InBody);
                        }
                    }
                }
                bVar.f0();
            }
            bVar.C0(bVar.h0());
            return bVar.e(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.k() && token.d().D().equals("caption")) {
                if (!bVar.K(token.d().D())) {
                    bVar.p(this);
                    return false;
                }
                bVar.s();
                if (!bVar.a().E().equals("caption")) {
                    bVar.p(this);
                }
                bVar.l0("caption");
                bVar.k();
                bVar.C0(HtmlTreeBuilderState.InTable);
                return true;
            }
            if ((token.l() && d30.c.b(token.e().D(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.k() && token.d().D().equals("table"))) {
                bVar.p(this);
                if (bVar.f("caption")) {
                    return bVar.e(token);
                }
                return true;
            }
            if (!token.k() || !d30.c.b(token.d().D(), TtmlNode.TAG_BODY, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            bVar.p(this);
            return false;
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        private boolean anythingElse(Token token, i iVar) {
            if (iVar.f("colgroup")) {
                return iVar.e(token);
            }
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            int i11 = a.f73109a[token.f73127a.ordinal()];
            if (i11 == 1) {
                bVar.O(token.b());
            } else if (i11 == 2) {
                bVar.p(this);
            } else if (i11 == 3) {
                Token.h hVarE = token.e();
                String strD = hVarE.D();
                strD.hashCode();
                if (!strD.equals("col")) {
                    return !strD.equals("html") ? anythingElse(token, bVar) : bVar.n0(token, HtmlTreeBuilderState.InBody);
                }
                bVar.P(hVarE);
            } else {
                if (i11 != 4) {
                    if (i11 == 6 && bVar.a().E().equals("html")) {
                        return true;
                    }
                    return anythingElse(token, bVar);
                }
                if (!token.d().f73137c.equals("colgroup")) {
                    return anythingElse(token, bVar);
                }
                if (bVar.a().E().equals("html")) {
                    bVar.p(this);
                    return false;
                }
                bVar.j0();
                bVar.C0(HtmlTreeBuilderState.InTable);
            }
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            return bVar.n0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean exitTableBody(Token token, org.jsoup.parser.b bVar) {
            if (!bVar.K("tbody") && !bVar.K("thead") && !bVar.E("tfoot")) {
                bVar.p(this);
                return false;
            }
            bVar.m();
            bVar.f(bVar.a().E());
            return bVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            int i11 = a.f73109a[token.f73127a.ordinal()];
            if (i11 == 3) {
                Token.h hVarE = token.e();
                String strD = hVarE.D();
                if (strD.equals("template")) {
                    bVar.L(hVarE);
                    return true;
                }
                if (strD.equals("tr")) {
                    bVar.m();
                    bVar.L(hVarE);
                    bVar.C0(HtmlTreeBuilderState.InRow);
                    return true;
                }
                if (!d30.c.b(strD, "th", "td")) {
                    return d30.c.b(strD, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? exitTableBody(token, bVar) : anythingElse(token, bVar);
                }
                bVar.p(this);
                bVar.g("tr");
                return bVar.e(hVarE);
            }
            if (i11 != 4) {
                return anythingElse(token, bVar);
            }
            String strD2 = token.d().D();
            if (!d30.c.b(strD2, "tbody", "tfoot", "thead")) {
                if (strD2.equals("table")) {
                    return exitTableBody(token, bVar);
                }
                if (!d30.c.b(strD2, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                    return anythingElse(token, bVar);
                }
                bVar.p(this);
                return false;
            }
            if (!bVar.K(strD2)) {
                bVar.p(this);
                return false;
            }
            bVar.m();
            bVar.j0();
            bVar.C0(HtmlTreeBuilderState.InTable);
            return true;
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            return bVar.n0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, i iVar) {
            if (iVar.f("tr")) {
                return iVar.e(token);
            }
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.l()) {
                Token.h hVarE = token.e();
                String strD = hVarE.D();
                if (strD.equals("template")) {
                    bVar.L(hVarE);
                    return true;
                }
                if (!d30.c.b(strD, "th", "td")) {
                    return d30.c.b(strD, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr") ? handleMissingTr(token, bVar) : anythingElse(token, bVar);
                }
                bVar.o();
                bVar.L(hVarE);
                bVar.C0(HtmlTreeBuilderState.InCell);
                bVar.S();
                return true;
            }
            if (!token.k()) {
                return anythingElse(token, bVar);
            }
            String strD2 = token.d().D();
            if (strD2.equals("tr")) {
                if (!bVar.K(strD2)) {
                    bVar.p(this);
                    return false;
                }
                bVar.o();
                bVar.j0();
                bVar.C0(HtmlTreeBuilderState.InTableBody);
                return true;
            }
            if (strD2.equals("table")) {
                return handleMissingTr(token, bVar);
            }
            if (!d30.c.b(strD2, "tbody", "tfoot", "thead")) {
                if (!d30.c.b(strD2, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html", "td", "th")) {
                    return anythingElse(token, bVar);
                }
                bVar.p(this);
                return false;
            }
            if (bVar.K(strD2)) {
                bVar.f("tr");
                return bVar.e(token);
            }
            bVar.p(this);
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            return bVar.n0(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(org.jsoup.parser.b bVar) {
            if (bVar.K("td")) {
                bVar.f("td");
            } else {
                bVar.f("th");
            }
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (!token.k()) {
                if (!token.l() || !d30.c.b(token.e().D(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return anythingElse(token, bVar);
                }
                if (bVar.K("td") || bVar.K("th")) {
                    closeCell(bVar);
                    return bVar.e(token);
                }
                bVar.p(this);
                return false;
            }
            String strD = token.d().D();
            if (!d30.c.b(strD, "td", "th")) {
                if (d30.c.b(strD, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html")) {
                    bVar.p(this);
                    return false;
                }
                if (!d30.c.b(strD, "table", "tbody", "tfoot", "thead", "tr")) {
                    return anythingElse(token, bVar);
                }
                if (bVar.K(strD)) {
                    closeCell(bVar);
                    return bVar.e(token);
                }
                bVar.p(this);
                return false;
            }
            if (!bVar.K(strD)) {
                bVar.p(this);
                bVar.C0(HtmlTreeBuilderState.InRow);
                return false;
            }
            bVar.s();
            if (!bVar.a().E().equals(strD)) {
                bVar.p(this);
            }
            bVar.l0(strD);
            bVar.k();
            bVar.C0(HtmlTreeBuilderState.InRow);
            return true;
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.p(this);
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            switch (a.f73109a[token.f73127a.ordinal()]) {
                case 1:
                    bVar.O(token.b());
                    return true;
                case 2:
                    bVar.p(this);
                    return false;
                case 3:
                    Token.h hVarE = token.e();
                    String strD = hVarE.D();
                    if (strD.equals("html")) {
                        return bVar.n0(hVarE, HtmlTreeBuilderState.InBody);
                    }
                    if (strD.equals("option")) {
                        if (bVar.a().E().equals("option")) {
                            bVar.f("option");
                        }
                        bVar.L(hVarE);
                    } else {
                        if (!strD.equals("optgroup")) {
                            if (strD.equals("select")) {
                                bVar.p(this);
                                return bVar.f("select");
                            }
                            if (!d30.c.b(strD, "input", "keygen", "textarea")) {
                                return strD.equals("script") ? bVar.n0(token, HtmlTreeBuilderState.InHead) : anythingElse(token, bVar);
                            }
                            bVar.p(this);
                            if (!bVar.H("select")) {
                                return false;
                            }
                            bVar.f("select");
                            return bVar.e(hVarE);
                        }
                        if (bVar.a().E().equals("option")) {
                            bVar.f("option");
                        } else if (bVar.a().E().equals("optgroup")) {
                            bVar.f("optgroup");
                        }
                        bVar.L(hVarE);
                    }
                    return true;
                case 4:
                    String strD2 = token.d().D();
                    strD2.hashCode();
                    switch (strD2) {
                        case "option":
                            if (bVar.a().E().equals("option")) {
                                bVar.j0();
                            } else {
                                bVar.p(this);
                            }
                            return true;
                        case "select":
                            if (!bVar.H(strD2)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.l0(strD2);
                            bVar.x0();
                            return true;
                        case "optgroup":
                            if (bVar.a().E().equals("option") && bVar.j(bVar.a()) != null && bVar.j(bVar.a()).E().equals("optgroup")) {
                                bVar.f("option");
                            }
                            if (bVar.a().E().equals("optgroup")) {
                                bVar.j0();
                            } else {
                                bVar.p(this);
                            }
                            return true;
                        default:
                            return anythingElse(token, bVar);
                    }
                case 5:
                    Token.c cVarA = token.a();
                    if (cVarA.q().equals(HtmlTreeBuilderState.nullString)) {
                        bVar.p(this);
                        return false;
                    }
                    bVar.N(cVarA);
                    return true;
                case 6:
                    if (!bVar.a().E().equals("html")) {
                        bVar.p(this);
                    }
                    return true;
                default:
                    return anythingElse(token, bVar);
            }
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.l() && d30.c.b(token.e().D(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                bVar.p(this);
                bVar.f("select");
                return bVar.e(token);
            }
            if (!token.k() || !d30.c.b(token.d().D(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                return bVar.n0(token, HtmlTreeBuilderState.InSelect);
            }
            bVar.p(this);
            if (!bVar.K(token.d().D())) {
                return false;
            }
            bVar.f("select");
            return bVar.e(token);
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (token.l() && token.e().D().equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.k() && token.d().D().equals("html")) {
                if (bVar.Y()) {
                    bVar.p(this);
                    return false;
                }
                bVar.C0(HtmlTreeBuilderState.AfterAfterBody);
                return true;
            }
            if (token.j()) {
                return true;
            }
            bVar.p(this);
            bVar.C0(HtmlTreeBuilderState.InBody);
            return bVar.e(token);
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
            } else if (token.h()) {
                bVar.O(token.b());
            } else {
                if (token.i()) {
                    bVar.p(this);
                    return false;
                }
                if (token.l()) {
                    Token.h hVarE = token.e();
                    String strD = hVarE.D();
                    strD.hashCode();
                    switch (strD) {
                        case "frameset":
                            bVar.L(hVarE);
                            break;
                        case "html":
                            return bVar.n0(hVarE, HtmlTreeBuilderState.InBody);
                        case "frame":
                            bVar.P(hVarE);
                            break;
                        case "noframes":
                            return bVar.n0(hVarE, HtmlTreeBuilderState.InHead);
                        default:
                            bVar.p(this);
                            return false;
                    }
                } else if (token.k() && token.d().D().equals("frameset")) {
                    if (bVar.a().E().equals("html")) {
                        bVar.p(this);
                        return false;
                    }
                    bVar.j0();
                    if (!bVar.Y() && !bVar.a().E().equals("frameset")) {
                        bVar.C0(HtmlTreeBuilderState.AfterFrameset);
                    }
                } else {
                    if (!token.j()) {
                        bVar.p(this);
                        return false;
                    }
                    if (!bVar.a().E().equals("html")) {
                        bVar.p(this);
                    }
                }
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (token.l() && token.e().D().equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.k() && token.d().D().equals("html")) {
                bVar.C0(HtmlTreeBuilderState.AfterAfterFrameset);
                return true;
            }
            if (token.l() && token.e().D().equals("noframes")) {
                return bVar.n0(token, HtmlTreeBuilderState.InHead);
            }
            if (token.j()) {
                return true;
            }
            bVar.p(this);
            return false;
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i() || HtmlTreeBuilderState.isWhitespace(token) || (token.l() && token.e().D().equals("html"))) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.j()) {
                return true;
            }
            bVar.p(this);
            bVar.C0(HtmlTreeBuilderState.InBody);
            return bVar.e(token);
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i() || HtmlTreeBuilderState.isWhitespace(token) || (token.l() && token.e().D().equals("html"))) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.j()) {
                return true;
            }
            if (token.l() && token.e().D().equals("noframes")) {
                return bVar.n0(token, HtmlTreeBuilderState.InHead);
            }
            bVar.p(this);
            return false;
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, org.jsoup.parser.b bVar) {
            return true;
        }
    };

    private static String nullString = String.valueOf((char) 0);

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f73109a;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            f73109a = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f73109a[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f73109a[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f73109a[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f73109a[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f73109a[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f73110a = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", TtmlNode.TAG_STYLE, CampaignEx.JSON_KEY_TITLE};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f73111b = {PlaceTypes.ADDRESS, "article", "aside", "blockquote", TtmlNode.CENTER, "details", "dir", TtmlNode.TAG_DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", TtmlNode.TAG_P, "section", "summary", "ul"};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f73112c = {"h1", "h2", "h3", "h4", "h5", "h6"};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String[] f73113d = {"listing", "pre"};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String[] f73114e = {PlaceTypes.ADDRESS, TtmlNode.TAG_DIV, TtmlNode.TAG_P};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String[] f73115f = {"dd", "dt"};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String[] f73116g = {DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "big", TrackingKey.CODE, "em", "font", "i", "s", "small", "strike", "strong", TtmlNode.TAG_TT, "u"};

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String[] f73117h = {"applet", "marquee", "object"};

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String[] f73118i = {"area", TtmlNode.TAG_BR, "embed", "img", "keygen", "wbr"};

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String[] f73119j = {"param", "source", "track"};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String[] f73120k = {"action", "name", "prompt"};

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String[] f73121l = {"optgroup", "option"};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String[] f73122m = {"rp", "rt"};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String[] f73123n = {"caption", "col", "colgroup", "frame", TtmlNode.TAG_HEAD, "tbody", "td", "tfoot", "th", "thead", "tr"};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String[] f73124o = {PlaceTypes.ADDRESS, "article", "aside", "blockquote", "button", TtmlNode.CENTER, "details", "dir", TtmlNode.TAG_DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String[] f73125p = {"a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "big", TrackingKey.CODE, "em", "font", "i", "nobr", "s", "small", "strike", "strong", TtmlNode.TAG_TT, "u"};

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String[] f73126q = {"table", "tbody", "tfoot", "thead", "tr"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.h hVar, org.jsoup.parser.b bVar) {
        bVar.f73218b.u(TokeniserState.Rawtext);
        bVar.d0();
        bVar.C0(Text);
        bVar.L(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.h hVar, org.jsoup.parser.b bVar) {
        bVar.f73218b.u(TokeniserState.Rcdata);
        bVar.d0();
        bVar.C0(Text);
        bVar.L(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return d30.c.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.g()) {
            return isWhitespace(token.a().q());
        }
        return false;
    }

    public abstract boolean process(Token token, org.jsoup.parser.b bVar);
}
