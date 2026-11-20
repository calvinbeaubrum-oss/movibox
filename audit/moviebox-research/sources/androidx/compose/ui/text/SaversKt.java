package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SaversKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<AnnotatedString, Object> f5716a = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, AnnotatedString annotatedString) {
            return kotlin.collections.g.h(SaversKt.x(annotatedString.i()), SaversKt.y(annotatedString.g(), SaversKt.f5717b, eVar), SaversKt.y(annotatedString.e(), SaversKt.f5717b, eVar), SaversKt.y(annotatedString.b(), SaversKt.f5717b, eVar));
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object obj) {
            List list;
            List list2;
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list3 = (List) obj;
            Object obj2 = list3.get(1);
            androidx.compose.runtime.saveable.d dVar = SaversKt.f5717b;
            Boolean bool = Boolean.FALSE;
            List list4 = null;
            List list5 = ((!Intrinsics.b(obj2, bool) || (dVar instanceof j)) && obj2 != null) ? (List) dVar.b(obj2) : null;
            Object obj3 = list3.get(2);
            androidx.compose.runtime.saveable.d dVar2 = SaversKt.f5717b;
            List list6 = ((!Intrinsics.b(obj3, bool) || (dVar2 instanceof j)) && obj3 != null) ? (List) dVar2.b(obj3) : null;
            Object obj4 = list3.get(0);
            String str = obj4 != null ? (String) obj4 : null;
            Intrinsics.d(str);
            if (list5 != null) {
                List list7 = list5;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list = list7;
            } else {
                list = null;
            }
            if (list6 != null) {
                List list8 = list6;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list2 = list8;
            } else {
                list2 = null;
            }
            Object obj5 = list3.get(3);
            androidx.compose.runtime.saveable.d dVar3 = SaversKt.f5717b;
            if ((!Intrinsics.b(obj5, bool) || (dVar3 instanceof j)) && obj5 != null) {
                list4 = (List) dVar3.b(obj5);
            }
            return new AnnotatedString(str, list, list2, list4);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<List<AnnotatedString.b<? extends Object>>, Object> f5717b = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, List<? extends AnnotatedString.b<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, List<? extends AnnotatedString.b<? extends Object>> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(SaversKt.y(list.get(i11), SaversKt.f5718c, eVar));
            }
            return arrayList;
        }
    }, new Function1<Object, List<? extends AnnotatedString.b<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List<? extends AnnotatedString.b<? extends Object>> invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj2 = list.get(i11);
                androidx.compose.runtime.saveable.d dVar = SaversKt.f5718c;
                AnnotatedString.b bVar = null;
                if ((!Intrinsics.b(obj2, Boolean.FALSE) || (dVar instanceof j)) && obj2 != null) {
                    bVar = (AnnotatedString.b) dVar.b(obj2);
                }
                Intrinsics.d(bVar);
                arrayList.add(bVar);
            }
            return arrayList;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<AnnotatedString.b<? extends Object>, Object> f5718c = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, AnnotatedString.b<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5738a;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f5738a = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, AnnotatedString.b<? extends Object> bVar) {
            AnnotationType annotationType;
            Object objY;
            Object objE = bVar.e();
            if (objE instanceof r) {
                annotationType = AnnotationType.Paragraph;
            } else if (objE instanceof y) {
                annotationType = AnnotationType.Span;
            } else if (objE instanceof i0) {
                annotationType = AnnotationType.VerbatimTts;
            } else if (objE instanceof h0) {
                annotationType = AnnotationType.Url;
            } else if (objE instanceof f.b) {
                annotationType = AnnotationType.Link;
            } else {
                annotationType = objE instanceof f.a ? AnnotationType.Clickable : AnnotationType.String;
            }
            switch (a.f5738a[annotationType.ordinal()]) {
                case 1:
                    Object objE2 = bVar.e();
                    Intrinsics.e(objE2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    objY = SaversKt.y((r) objE2, SaversKt.i(), eVar);
                    break;
                case 2:
                    Object objE3 = bVar.e();
                    Intrinsics.e(objE3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    objY = SaversKt.y((y) objE3, SaversKt.v(), eVar);
                    break;
                case 3:
                    Object objE4 = bVar.e();
                    Intrinsics.e(objE4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    objY = SaversKt.y((i0) objE4, SaversKt.f5719d, eVar);
                    break;
                case 4:
                    Object objE5 = bVar.e();
                    Intrinsics.e(objE5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    objY = SaversKt.y((h0) objE5, SaversKt.f5720e, eVar);
                    break;
                case 5:
                    Object objE6 = bVar.e();
                    Intrinsics.e(objE6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                    objY = SaversKt.y((f.b) objE6, SaversKt.f5721f, eVar);
                    break;
                case 6:
                    Object objE7 = bVar.e();
                    Intrinsics.e(objE7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                    objY = SaversKt.y((f.a) objE7, SaversKt.f5722g, eVar);
                    break;
                case 7:
                    objY = SaversKt.x(bVar.e());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return kotlin.collections.g.h(SaversKt.x(annotationType), objY, SaversKt.x(Integer.valueOf(bVar.f())), SaversKt.x(Integer.valueOf(bVar.d())), SaversKt.x(bVar.g()));
        }
    }, new Function1<Object, AnnotatedString.b<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5739a;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f5739a = iArr;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.b<? extends Object> invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            r rVarB = null;
            AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
            Intrinsics.d(annotationType);
            Object obj3 = list.get(2);
            Integer num = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.d(num);
            int iIntValue = num.intValue();
            Object obj4 = list.get(3);
            Integer num2 = obj4 != null ? (Integer) obj4 : null;
            Intrinsics.d(num2);
            int iIntValue2 = num2.intValue();
            Object obj5 = list.get(4);
            String str = obj5 != null ? (String) obj5 : null;
            Intrinsics.d(str);
            switch (a.f5739a[annotationType.ordinal()]) {
                case 1:
                    Object obj6 = list.get(1);
                    androidx.compose.runtime.saveable.d<r, Object> dVarI = SaversKt.i();
                    if ((!Intrinsics.b(obj6, Boolean.FALSE) || (dVarI instanceof j)) && obj6 != null) {
                        rVarB = dVarI.b(obj6);
                    }
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                case 2:
                    Object obj7 = list.get(1);
                    androidx.compose.runtime.saveable.d<y, Object> dVarV = SaversKt.v();
                    if ((!Intrinsics.b(obj7, Boolean.FALSE) || (dVarV instanceof j)) && obj7 != null) {
                        rVarB = dVarV.b(obj7);
                    }
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                case 3:
                    Object obj8 = list.get(1);
                    androidx.compose.runtime.saveable.d dVar = SaversKt.f5719d;
                    if ((!Intrinsics.b(obj8, Boolean.FALSE) || (dVar instanceof j)) && obj8 != null) {
                        rVarB = (i0) dVar.b(obj8);
                    }
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                case 4:
                    Object obj9 = list.get(1);
                    androidx.compose.runtime.saveable.d dVar2 = SaversKt.f5720e;
                    if ((!Intrinsics.b(obj9, Boolean.FALSE) || (dVar2 instanceof j)) && obj9 != null) {
                        rVarB = (h0) dVar2.b(obj9);
                    }
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                case 5:
                    Object obj10 = list.get(1);
                    androidx.compose.runtime.saveable.d dVar3 = SaversKt.f5721f;
                    if ((!Intrinsics.b(obj10, Boolean.FALSE) || (dVar3 instanceof j)) && obj10 != null) {
                        rVarB = (f.b) dVar3.b(obj10);
                    }
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                case 6:
                    Object obj11 = list.get(1);
                    androidx.compose.runtime.saveable.d dVar4 = SaversKt.f5722g;
                    if ((!Intrinsics.b(obj11, Boolean.FALSE) || (dVar4 instanceof j)) && obj11 != null) {
                        rVarB = (f.a) dVar4.b(obj11);
                    }
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                case 7:
                    Object obj12 = list.get(1);
                    rVarB = obj12 != null ? (String) obj12 : null;
                    Intrinsics.d(rVarB);
                    return new AnnotatedString.b<>(rVarB, iIntValue, iIntValue2, str);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<i0, Object> f5719d = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, i0, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, i0 i0Var) {
            return SaversKt.x(i0Var.a());
        }
    }, new Function1<Object, i0>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final i0 invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.d(str);
            return new i0(str);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<h0, Object> f5720e = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, h0, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, h0 h0Var) {
            return SaversKt.x(h0Var.a());
        }
    }, new Function1<Object, h0>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final h0 invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.d(str);
            return new h0(str);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<f.b, Object> f5721f = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, f.b, Object>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, f.b bVar) {
            return kotlin.collections.g.h(SaversKt.x(bVar.c()), SaversKt.y(bVar.b(), SaversKt.w(), eVar));
        }
    }, new Function1<Object, f.b>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final f.b invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            b0 b0VarB = null;
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.d(str);
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d<b0, Object> dVarW = SaversKt.w();
            if ((!Intrinsics.b(obj3, Boolean.FALSE) || (dVarW instanceof j)) && obj3 != null) {
                b0VarB = dVarW.b(obj3);
            }
            return new f.b(str, b0VarB, null, 4, null);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<f.a, Object> f5722g = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, f.a, Object>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, f.a aVar) {
            return kotlin.collections.g.h(SaversKt.x(aVar.c()), SaversKt.y(aVar.b(), SaversKt.w(), eVar));
        }
    }, new Function1<Object, f.a>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final f.a invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.d(str);
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d<b0, Object> dVarW = SaversKt.w();
            return new f.a(str, ((!Intrinsics.b(obj3, Boolean.FALSE) || (dVarW instanceof j)) && obj3 != null) ? dVarW.b(obj3) : null, null);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<r, Object> f5723h = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, r, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, r rVar) {
            return kotlin.collections.g.h(SaversKt.x(androidx.compose.ui.text.style.h.h(rVar.h())), SaversKt.x(androidx.compose.ui.text.style.j.g(rVar.i())), SaversKt.y(q2.w.b(rVar.e()), SaversKt.t(q2.w.f74257b), eVar), SaversKt.y(rVar.j(), SaversKt.q(androidx.compose.ui.text.style.n.f6130c), eVar));
        }
    }, new Function1<Object, r>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final r invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.ui.text.style.h hVar = obj2 != null ? (androidx.compose.ui.text.style.h) obj2 : null;
            Intrinsics.d(hVar);
            int iN = hVar.n();
            Object obj3 = list.get(1);
            androidx.compose.ui.text.style.j jVar = obj3 != null ? (androidx.compose.ui.text.style.j) obj3 : null;
            Intrinsics.d(jVar);
            int iM = jVar.m();
            Object obj4 = list.get(2);
            androidx.compose.runtime.saveable.d<q2.w, Object> dVarT = SaversKt.t(q2.w.f74257b);
            Boolean bool = Boolean.FALSE;
            q2.w wVarB = ((!Intrinsics.b(obj4, bool) || (dVarT instanceof j)) && obj4 != null) ? dVarT.b(obj4) : null;
            Intrinsics.d(wVarB);
            long jK = wVarB.k();
            Object obj5 = list.get(3);
            androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.n, Object> dVarQ = SaversKt.q(androidx.compose.ui.text.style.n.f6130c);
            return new r(iN, iM, jK, ((!Intrinsics.b(obj5, bool) || (dVarQ instanceof j)) && obj5 != null) ? dVarQ.b(obj5) : null, null, null, 0, 0, null, 496, null);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<y, Object> f5724i = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, y, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, y yVar) {
            w1 w1VarG = w1.g(yVar.g());
            w1.a aVar = w1.f4564b;
            q2.w wVarB = q2.w.b(yVar.k());
            q2.w.a aVar2 = q2.w.f74257b;
            return kotlin.collections.g.h(SaversKt.y(w1VarG, SaversKt.j(aVar), eVar), SaversKt.y(wVarB, SaversKt.t(aVar2), eVar), SaversKt.y(yVar.n(), SaversKt.m(androidx.compose.ui.text.font.u.f5860b), eVar), SaversKt.x(yVar.l()), SaversKt.x(yVar.m()), SaversKt.x(-1), SaversKt.x(yVar.j()), SaversKt.y(q2.w.b(yVar.o()), SaversKt.t(aVar2), eVar), SaversKt.y(yVar.e(), SaversKt.n(androidx.compose.ui.text.style.a.f6053b), eVar), SaversKt.y(yVar.u(), SaversKt.p(androidx.compose.ui.text.style.m.f6126c), eVar), SaversKt.y(yVar.p(), SaversKt.s(p2.i.f73512c), eVar), SaversKt.y(w1.g(yVar.d()), SaversKt.j(aVar), eVar), SaversKt.y(yVar.s(), SaversKt.o(androidx.compose.ui.text.style.i.f6110b), eVar), SaversKt.y(yVar.r(), SaversKt.k(b5.f3990d), eVar));
        }
    }, new Function1<Object, y>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final y invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            w1.a aVar = w1.f4564b;
            androidx.compose.runtime.saveable.d<w1, Object> dVarJ = SaversKt.j(aVar);
            Boolean bool = Boolean.FALSE;
            w1 w1VarB = ((!Intrinsics.b(obj2, bool) || (dVarJ instanceof j)) && obj2 != null) ? dVarJ.b(obj2) : null;
            Intrinsics.d(w1VarB);
            long jU = w1VarB.u();
            Object obj3 = list.get(1);
            q2.w.a aVar2 = q2.w.f74257b;
            androidx.compose.runtime.saveable.d<q2.w, Object> dVarT = SaversKt.t(aVar2);
            q2.w wVarB = ((!Intrinsics.b(obj3, bool) || (dVarT instanceof j)) && obj3 != null) ? dVarT.b(obj3) : null;
            Intrinsics.d(wVarB);
            long jK = wVarB.k();
            Object obj4 = list.get(2);
            androidx.compose.runtime.saveable.d<androidx.compose.ui.text.font.u, Object> dVarM = SaversKt.m(androidx.compose.ui.text.font.u.f5860b);
            androidx.compose.ui.text.font.u uVarB = ((!Intrinsics.b(obj4, bool) || (dVarM instanceof j)) && obj4 != null) ? dVarM.b(obj4) : null;
            Object obj5 = list.get(3);
            androidx.compose.ui.text.font.q qVar = obj5 != null ? (androidx.compose.ui.text.font.q) obj5 : null;
            Object obj6 = list.get(4);
            androidx.compose.ui.text.font.r rVar = obj6 != null ? (androidx.compose.ui.text.font.r) obj6 : null;
            Object obj7 = list.get(6);
            String str = obj7 != null ? (String) obj7 : null;
            Object obj8 = list.get(7);
            androidx.compose.runtime.saveable.d<q2.w, Object> dVarT2 = SaversKt.t(aVar2);
            q2.w wVarB2 = ((!Intrinsics.b(obj8, bool) || (dVarT2 instanceof j)) && obj8 != null) ? dVarT2.b(obj8) : null;
            Intrinsics.d(wVarB2);
            long jK2 = wVarB2.k();
            Object obj9 = list.get(8);
            androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.a, Object> dVarN = SaversKt.n(androidx.compose.ui.text.style.a.f6053b);
            androidx.compose.ui.text.style.a aVarB = ((!Intrinsics.b(obj9, bool) || (dVarN instanceof j)) && obj9 != null) ? dVarN.b(obj9) : null;
            Object obj10 = list.get(9);
            androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.m, Object> dVarP = SaversKt.p(androidx.compose.ui.text.style.m.f6126c);
            androidx.compose.ui.text.style.m mVarB = ((!Intrinsics.b(obj10, bool) || (dVarP instanceof j)) && obj10 != null) ? dVarP.b(obj10) : null;
            Object obj11 = list.get(10);
            androidx.compose.runtime.saveable.d<p2.i, Object> dVarS = SaversKt.s(p2.i.f73512c);
            p2.i iVarB = ((!Intrinsics.b(obj11, bool) || (dVarS instanceof j)) && obj11 != null) ? dVarS.b(obj11) : null;
            Object obj12 = list.get(11);
            androidx.compose.runtime.saveable.d<w1, Object> dVarJ2 = SaversKt.j(aVar);
            w1 w1VarB2 = ((!Intrinsics.b(obj12, bool) || (dVarJ2 instanceof j)) && obj12 != null) ? dVarJ2.b(obj12) : null;
            Intrinsics.d(w1VarB2);
            long jU2 = w1VarB2.u();
            Object obj13 = list.get(12);
            androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.i, Object> dVarO = SaversKt.o(androidx.compose.ui.text.style.i.f6110b);
            androidx.compose.ui.text.style.i iVarB2 = ((!Intrinsics.b(obj13, bool) || (dVarO instanceof j)) && obj13 != null) ? dVarO.b(obj13) : null;
            Object obj14 = list.get(13);
            androidx.compose.runtime.saveable.d<b5, Object> dVarK = SaversKt.k(b5.f3990d);
            return new y(jU, jK, uVarB, qVar, rVar, null, str, jK2, aVarB, mVarB, iVarB, jU2, iVarB2, ((!Intrinsics.b(obj14, bool) || (dVarK instanceof j)) && obj14 != null) ? dVarK.b(obj14) : null, null, null, 49184, null);
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<b0, Object> f5725j = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, b0, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, b0 b0Var) {
            return kotlin.collections.g.h(SaversKt.y(b0Var.d(), SaversKt.v(), eVar), SaversKt.y(b0Var.a(), SaversKt.v(), eVar), SaversKt.y(b0Var.b(), SaversKt.v(), eVar), SaversKt.y(b0Var.c(), SaversKt.v(), eVar));
        }
    }, new Function1<Object, b0>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final b0 invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.runtime.saveable.d<y, Object> dVarV = SaversKt.v();
            Boolean bool = Boolean.FALSE;
            y yVarB = null;
            y yVarB2 = ((!Intrinsics.b(obj2, bool) || (dVarV instanceof j)) && obj2 != null) ? dVarV.b(obj2) : null;
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d<y, Object> dVarV2 = SaversKt.v();
            y yVarB3 = ((!Intrinsics.b(obj3, bool) || (dVarV2 instanceof j)) && obj3 != null) ? dVarV2.b(obj3) : null;
            Object obj4 = list.get(2);
            androidx.compose.runtime.saveable.d<y, Object> dVarV3 = SaversKt.v();
            y yVarB4 = ((!Intrinsics.b(obj4, bool) || (dVarV3 instanceof j)) && obj4 != null) ? dVarV3.b(obj4) : null;
            Object obj5 = list.get(3);
            androidx.compose.runtime.saveable.d<y, Object> dVarV4 = SaversKt.v();
            if ((!Intrinsics.b(obj5, bool) || (dVarV4 instanceof j)) && obj5 != null) {
                yVarB = dVarV4.b(obj5);
            }
            return new b0(yVarB2, yVarB3, yVarB4, yVarB);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.i, Object> f5726k = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.i, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.i iVar) {
            return Integer.valueOf(iVar.e());
        }
    }, new Function1<Object, androidx.compose.ui.text.style.i>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.style.i invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Int");
            return new androidx.compose.ui.text.style.i(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.m, Object> f5727l = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.m, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.m mVar) {
            return kotlin.collections.g.h(Float.valueOf(mVar.b()), Float.valueOf(mVar.c()));
        }
    }, new Function1<Object, androidx.compose.ui.text.style.m>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.style.m invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
            List list = (List) obj;
            return new androidx.compose.ui.text.style.m(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.n, Object> f5728m = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.n, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.n nVar) {
            q2.w wVarB = q2.w.b(nVar.b());
            q2.w.a aVar = q2.w.f74257b;
            return kotlin.collections.g.h(SaversKt.y(wVarB, SaversKt.t(aVar), eVar), SaversKt.y(q2.w.b(nVar.c()), SaversKt.t(aVar), eVar));
        }
    }, new Function1<Object, androidx.compose.ui.text.style.n>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.style.n invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            q2.w.a aVar = q2.w.f74257b;
            androidx.compose.runtime.saveable.d<q2.w, Object> dVarT = SaversKt.t(aVar);
            Boolean bool = Boolean.FALSE;
            q2.w wVarB = null;
            q2.w wVarB2 = ((!Intrinsics.b(obj2, bool) || (dVarT instanceof j)) && obj2 != null) ? dVarT.b(obj2) : null;
            Intrinsics.d(wVarB2);
            long jK = wVarB2.k();
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d<q2.w, Object> dVarT2 = SaversKt.t(aVar);
            if ((!Intrinsics.b(obj3, bool) || (dVarT2 instanceof j)) && obj3 != null) {
                wVarB = dVarT2.b(obj3);
            }
            Intrinsics.d(wVarB);
            return new androidx.compose.ui.text.style.n(jK, wVarB.k(), null);
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.font.u, Object> f5729n = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.font.u, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.font.u uVar) {
            return Integer.valueOf(uVar.i());
        }
    }, new Function1<Object, androidx.compose.ui.text.font.u>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final androidx.compose.ui.text.font.u invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Int");
            return new androidx.compose.ui.text.font.u(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.a, Object> f5730o = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, androidx.compose.ui.text.style.a, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(androidx.compose.runtime.saveable.e eVar, androidx.compose.ui.text.style.a aVar) {
            return m78invoke8a2Sb4w(eVar, aVar.h());
        }

        /* JADX INFO: renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m78invoke8a2Sb4w(androidx.compose.runtime.saveable.e eVar, float f11) {
            return Float.valueOf(f11);
        }
    }, new Function1<Object, androidx.compose.ui.text.style.a>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final androidx.compose.ui.text.style.a invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Float");
            return androidx.compose.ui.text.style.a.b(androidx.compose.ui.text.style.a.c(((Float) obj).floatValue()));
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<c0, Object> f5731p = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, c0, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(androidx.compose.runtime.saveable.e eVar, c0 c0Var) {
            return m84invokeFDrldGo(eVar, c0Var.n());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m84invokeFDrldGo(androidx.compose.runtime.saveable.e eVar, long j11) {
            return kotlin.collections.g.h(SaversKt.x(Integer.valueOf(c0.k(j11))), SaversKt.x(Integer.valueOf(c0.g(j11))));
        }
    }, new Function1<Object, c0>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final c0 invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.d(num);
            int iIntValue = num.intValue();
            Object obj3 = list.get(1);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.d(num2);
            return c0.b(d0.b(iIntValue, num2.intValue()));
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<b5, Object> f5732q = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, b5, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, b5 b5Var) {
            return kotlin.collections.g.h(SaversKt.y(w1.g(b5Var.c()), SaversKt.j(w1.f4564b), eVar), SaversKt.y(y1.g.d(b5Var.d()), SaversKt.u(y1.g.f81070b), eVar), SaversKt.x(Float.valueOf(b5Var.b())));
        }
    }, new Function1<Object, b5>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final b5 invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.runtime.saveable.d<w1, Object> dVarJ = SaversKt.j(w1.f4564b);
            Boolean bool = Boolean.FALSE;
            w1 w1VarB = ((!Intrinsics.b(obj2, bool) || (dVarJ instanceof j)) && obj2 != null) ? dVarJ.b(obj2) : null;
            Intrinsics.d(w1VarB);
            long jU = w1VarB.u();
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d<y1.g, Object> dVarU = SaversKt.u(y1.g.f81070b);
            y1.g gVarB = ((!Intrinsics.b(obj3, bool) || (dVarU instanceof j)) && obj3 != null) ? dVarU.b(obj3) : null;
            Intrinsics.d(gVarB);
            long jV = gVarB.v();
            Object obj4 = list.get(2);
            Float f11 = obj4 != null ? (Float) obj4 : null;
            Intrinsics.d(f11);
            return new b5(jU, jV, f11.floatValue(), null);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final j<w1, Object> f5733r = a(new Function2<androidx.compose.runtime.saveable.e, w1, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(androidx.compose.runtime.saveable.e eVar, w1 w1Var) {
            return m80invoke4WTKRHQ(eVar, w1Var.u());
        }

        /* JADX INFO: renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m80invoke4WTKRHQ(androidx.compose.runtime.saveable.e eVar, long j11) {
            return j11 == 16 ? Boolean.FALSE : Integer.valueOf(y1.j(j11));
        }
    }, new Function1<Object, w1>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final w1 invoke(Object obj) {
            long jB;
            if (Intrinsics.b(obj, Boolean.FALSE)) {
                jB = w1.f4564b.e();
            } else {
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Int");
                jB = y1.b(((Integer) obj).intValue());
            }
            return w1.g(jB);
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j<q2.w, Object> f5734s = a(new Function2<androidx.compose.runtime.saveable.e, q2.w, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(androidx.compose.runtime.saveable.e eVar, q2.w wVar) {
            return m86invokempE4wyQ(eVar, wVar.k());
        }

        /* JADX INFO: renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m86invokempE4wyQ(androidx.compose.runtime.saveable.e eVar, long j11) {
            return q2.w.e(j11, q2.w.f74257b.a()) ? Boolean.FALSE : kotlin.collections.g.h(SaversKt.x(Float.valueOf(q2.w.h(j11))), SaversKt.x(q2.y.d(q2.w.g(j11))));
        }
    }, new Function1<Object, q2.w>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final q2.w invoke(Object obj) {
            if (Intrinsics.b(obj, Boolean.FALSE)) {
                return q2.w.b(q2.w.f74257b.a());
            }
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f11 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.d(f11);
            float fFloatValue = f11.floatValue();
            Object obj3 = list.get(1);
            q2.y yVar = obj3 != null ? (q2.y) obj3 : null;
            Intrinsics.d(yVar);
            return q2.w.b(q2.x.a(fFloatValue, yVar.j()));
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final j<y1.g, Object> f5735t = a(new Function2<androidx.compose.runtime.saveable.e, y1.g, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(androidx.compose.runtime.saveable.e eVar, y1.g gVar) {
            return m82invokeUv8p0NA(eVar, gVar.v());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m82invokeUv8p0NA(androidx.compose.runtime.saveable.e eVar, long j11) {
            return y1.g.j(j11, y1.g.f81070b.b()) ? Boolean.FALSE : kotlin.collections.g.h(SaversKt.x(Float.valueOf(y1.g.m(j11))), SaversKt.x(Float.valueOf(y1.g.n(j11))));
        }
    }, new Function1<Object, y1.g>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final y1.g invoke(Object obj) {
            if (Intrinsics.b(obj, Boolean.FALSE)) {
                return y1.g.d(y1.g.f81070b.b());
            }
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f11 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.d(f11);
            float fFloatValue = f11.floatValue();
            Object obj3 = list.get(1);
            Float f12 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.d(f12);
            return y1.g.d(y1.h.a(fFloatValue, f12.floatValue()));
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<p2.i, Object> f5736u = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, p2.i, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, p2.i iVar) {
            List<p2.h> listG = iVar.g();
            ArrayList arrayList = new ArrayList(listG.size());
            int size = listG.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(SaversKt.y(listG.get(i11), SaversKt.r(p2.h.f73510b), eVar));
            }
            return arrayList;
        }
    }, new Function1<Object, p2.i>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final p2.i invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj2 = list.get(i11);
                androidx.compose.runtime.saveable.d<p2.h, Object> dVarR = SaversKt.r(p2.h.f73510b);
                p2.h hVarB = null;
                if ((!Intrinsics.b(obj2, Boolean.FALSE) || (dVarR instanceof j)) && obj2 != null) {
                    hVarB = dVarR.b(obj2);
                }
                Intrinsics.d(hVarB);
                arrayList.add(hVarB);
            }
            return new p2.i(arrayList);
        }
    });

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<p2.h, Object> f5737v = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, p2.h, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, p2.h hVar) {
            return hVar.b();
        }
    }, new Function1<Object, p2.h>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final p2.h invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.String");
            return new p2.h((String) obj);
        }
    });

    /* JADX INFO: Add missing generic type declarations: [Saveable, Original] */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<Original, Saveable> implements j<Original, Saveable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<androidx.compose.runtime.saveable.e, Original, Saveable> f5740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Saveable, Original> f5741b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super androidx.compose.runtime.saveable.e, ? super Original, ? extends Saveable> function2, Function1<? super Saveable, ? extends Original> function1) {
            this.f5740a = function2;
            this.f5741b = function1;
        }

        @Override // androidx.compose.runtime.saveable.d
        public Saveable a(androidx.compose.runtime.saveable.e eVar, Original original) {
            return this.f5740a.invoke(eVar, original);
        }

        @Override // androidx.compose.runtime.saveable.d
        public Original b(Saveable saveable) {
            return this.f5741b.invoke(saveable);
        }
    }

    public static final <Original, Saveable> j<Original, Saveable> a(Function2<? super androidx.compose.runtime.saveable.e, ? super Original, ? extends Saveable> function2, Function1<? super Saveable, ? extends Original> function1) {
        return new a(function2, function1);
    }

    public static final androidx.compose.runtime.saveable.d<AnnotatedString, Object> h() {
        return f5716a;
    }

    public static final androidx.compose.runtime.saveable.d<r, Object> i() {
        return f5723h;
    }

    public static final androidx.compose.runtime.saveable.d<w1, Object> j(w1.a aVar) {
        return f5733r;
    }

    public static final androidx.compose.runtime.saveable.d<b5, Object> k(b5.a aVar) {
        return f5732q;
    }

    public static final androidx.compose.runtime.saveable.d<c0, Object> l(c0.a aVar) {
        return f5731p;
    }

    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.font.u, Object> m(androidx.compose.ui.text.font.u.a aVar) {
        return f5729n;
    }

    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.a, Object> n(androidx.compose.ui.text.style.a.C0064a c0064a) {
        return f5730o;
    }

    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.i, Object> o(androidx.compose.ui.text.style.i.a aVar) {
        return f5726k;
    }

    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.m, Object> p(androidx.compose.ui.text.style.m.a aVar) {
        return f5727l;
    }

    public static final androidx.compose.runtime.saveable.d<androidx.compose.ui.text.style.n, Object> q(androidx.compose.ui.text.style.n.a aVar) {
        return f5728m;
    }

    public static final androidx.compose.runtime.saveable.d<p2.h, Object> r(p2.h.a aVar) {
        return f5737v;
    }

    public static final androidx.compose.runtime.saveable.d<p2.i, Object> s(p2.i.a aVar) {
        return f5736u;
    }

    public static final androidx.compose.runtime.saveable.d<q2.w, Object> t(q2.w.a aVar) {
        return f5734s;
    }

    public static final androidx.compose.runtime.saveable.d<y1.g, Object> u(y1.g.a aVar) {
        return f5735t;
    }

    public static final androidx.compose.runtime.saveable.d<y, Object> v() {
        return f5724i;
    }

    public static final androidx.compose.runtime.saveable.d<b0, Object> w() {
        return f5725j;
    }

    public static final <T> T x(T t11) {
        return t11;
    }

    public static final <T extends androidx.compose.runtime.saveable.d<Original, Saveable>, Original, Saveable> Object y(Original original, T t11, androidx.compose.runtime.saveable.e eVar) {
        Object objA;
        return (original == null || (objA = t11.a(eVar, original)) == null) ? Boolean.FALSE : objA;
    }
}
