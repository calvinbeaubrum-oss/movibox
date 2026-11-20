package com.transsion.subtitle_download.task;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.subtitle_download.utils.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subtitle_download.task.GetInStationSubtitleListTask$download$1", f = "GetInStationSubtitleListTask.kt", l = {62, 64, 69, 82}, m = "invokeSuspend")
public final class GetInStationSubtitleListTask$download$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $ep;
    final /* synthetic */ int $episode;
    final /* synthetic */ boolean $isStream;
    final /* synthetic */ int $resStreamType;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
    final /* synthetic */ int $se;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $subjectName;
    final /* synthetic */ String $videoResourceId;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GetInStationSubtitleListTask$download$1(boolean z11, String str, String str2, int i11, String str3, Function1<? super Boolean, Unit> function1, String str4, int i12, int i13, int i14, Continuation<? super GetInStationSubtitleListTask$download$1> continuation) {
        super(2, continuation);
        this.$isStream = z11;
        this.$subjectId = str;
        this.$videoResourceId = str2;
        this.$episode = i11;
        this.$resourceId = str3;
        this.$resultCallback = function1;
        this.$subjectName = str4;
        this.$resStreamType = i12;
        this.$ep = i13;
        this.$se = i14;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetInStationSubtitleListTask$download$1 getInStationSubtitleListTask$download$1 = new GetInStationSubtitleListTask$download$1(this.$isStream, this.$subjectId, this.$videoResourceId, this.$episode, this.$resourceId, this.$resultCallback, this.$subjectName, this.$resStreamType, this.$ep, this.$se, continuation);
        getInStationSubtitleListTask$download$1.L$0 = obj;
        return getInStationSubtitleListTask$download$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((GetInStationSubtitleListTask$download$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:66:0x01d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0216  */
    /* JADX WARN: Code duplicated, block: B:90:0x0269 A[RETURN] */
    /* JADX WARN: Instruction removed from duplicated block: B:88:0x0216, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        Continuation continuation;
        Object objM163constructorimpl;
        String str;
        String str2;
        int i11;
        boolean z11;
        Function1<Boolean, Unit> function1;
        Throwable thM166exceptionOrNullimpl;
        a2 a2VarC;
        GetInStationSubtitleListTask$download$1$2$1 getInStationSubtitleListTask$download$1$2$1;
        String str3;
        int i12;
        Object objA;
        boolean z12;
        int i13;
        int i14;
        String str4;
        String str5;
        int i15;
        String str6;
        Function1<Boolean, Unit> function2;
        int i16;
        Object objB;
        boolean z13;
        int i17;
        int i18;
        String str7;
        Function1<Boolean, Unit> function3;
        String str8;
        int i19;
        boolean z14;
        String str9;
        int i21;
        BaseDto baseDto;
        String str10;
        String str11;
        GetInStationSubtitleListTask getInStationSubtitleListTask;
        String str12;
        Function1<Boolean, Unit> function4;
        String str13;
        int i22;
        int i23;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i24 = this.label;
        String str14 = " -- isStream = ";
        String str15 = " -- episode = ";
        String str16 = " -- resourceId = ";
        String str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
        try {
            try {
                if (i24 == 0) {
                    ResultKt.b(obj);
                    boolean z15 = this.$isStream;
                    str3 = this.$subjectId;
                    String str18 = this.$videoResourceId;
                    int i25 = this.$episode;
                    String str19 = this.$resourceId;
                    Function1<Boolean, Unit> function5 = this.$resultCallback;
                    String str20 = this.$subjectName;
                    int i26 = this.$resStreamType;
                    i12 = this.$ep;
                    int i27 = this.$se;
                    Result.Companion companion = Result.Companion;
                    if (z15) {
                        try {
                            str14 = " -- isStream = ";
                            try {
                                ay.a aVarH = GetInStationSubtitleListTask.f58367a.h();
                                str15 = " -- episode = ";
                                try {
                                    String strA = cp.a.f62775a.a();
                                    this.L$0 = str3;
                                    this.L$1 = str19;
                                    this.L$2 = function5;
                                    this.L$3 = str20;
                                    this.Z$0 = z15;
                                    this.I$0 = i25;
                                    this.I$1 = i26;
                                    this.I$2 = i12;
                                    this.I$3 = i27;
                                    this.label = 1;
                                    objA = aVarH.a(strA, str3, str18, this);
                                    if (objA == objE) {
                                        return objE;
                                    }
                                    z12 = z15;
                                    i13 = i27;
                                    i14 = i26;
                                    str4 = str19;
                                    str5 = str20;
                                    i15 = i25;
                                    str6 = str3;
                                    function2 = function5;
                                    i16 = i12;
                                    String str21 = str6;
                                    i19 = i13;
                                    z14 = z12;
                                    str9 = str21;
                                    String str22 = str4;
                                    i21 = i14;
                                    baseDto = (BaseDto) objA;
                                    str10 = str22;
                                    Function1<Boolean, Unit> function6 = function2;
                                    str11 = str5;
                                    function3 = function6;
                                    b bVar = b.f58375a;
                                    getInStationSubtitleListTask = GetInStationSubtitleListTask.f58367a;
                                    String strI = getInStationSubtitleListTask.i();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(strI);
                                    sb2.append(" --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ");
                                    sb2.append(str9);
                                    sb2.append(str16);
                                    sb2.append(str10);
                                    str16 = str16;
                                    str15 = str15;
                                    sb2.append(str15);
                                    sb2.append(i15);
                                    str12 = str14;
                                    sb2.append(str12);
                                    sb2.append(z14);
                                    sb2.append(" --> subtitles = ");
                                    sb2.append(baseDto);
                                    bVar.a(sb2.toString());
                                    continuation = null;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.label = 3;
                                    str14 = str12;
                                    function4 = function3;
                                    str13 = str11;
                                    i22 = i21;
                                    i23 = i16;
                                    str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                                    obj2 = objE;
                                    if (getInStationSubtitleListTask.e(baseDto, function4, str10, str9, str13, i22, i23, i19, this) == obj2) {
                                        return obj2;
                                    }
                                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                                    str = this.$subjectId;
                                    str2 = this.$resourceId;
                                    i11 = this.$episode;
                                    z11 = this.$isStream;
                                    function1 = this.$resultCallback;
                                    thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                                    if (thM166exceptionOrNullimpl != null) {
                                        b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                                        a2VarC = w0.c();
                                        getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                                        this.L$0 = continuation;
                                        this.L$1 = continuation;
                                        this.L$2 = continuation;
                                        this.L$3 = continuation;
                                        this.label = 4;
                                        if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                                            return obj2;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str16 = str16;
                                    str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                                    obj2 = objE;
                                    str14 = str14;
                                    str15 = str15;
                                    continuation = null;
                                    Result.Companion companion2 = Result.Companion;
                                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                                    str = this.$subjectId;
                                    str2 = this.$resourceId;
                                    i11 = this.$episode;
                                    z11 = this.$isStream;
                                    function1 = this.$resultCallback;
                                    thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                                    if (thM166exceptionOrNullimpl != null) {
                                        b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                                        a2VarC = w0.c();
                                        getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                                        this.L$0 = continuation;
                                        this.L$1 = continuation;
                                        this.L$2 = continuation;
                                        this.L$3 = continuation;
                                        this.label = 4;
                                        if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                                            return obj2;
                                        }
                                    }
                                    return Unit.f68710a;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str16 = str16;
                                obj2 = objE;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str16 = str16;
                            str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                            obj2 = objE;
                        }
                    } else {
                        ay.a aVarH2 = GetInStationSubtitleListTask.f58367a.h();
                        String strA2 = cp.a.f62775a.a();
                        this.L$0 = str3;
                        this.L$1 = str19;
                        this.L$2 = function5;
                        this.L$3 = str20;
                        this.Z$0 = z15;
                        this.I$0 = i25;
                        this.I$1 = i26;
                        this.I$2 = i12;
                        this.I$3 = i27;
                        this.label = 2;
                        i16 = i12;
                        objB = aVarH2.b(strA2, str3, str18, i25, this);
                        if (objB == objE) {
                            return objE;
                        }
                        z13 = z15;
                        i17 = i26;
                        i15 = i25;
                        i18 = i27;
                        str7 = str20;
                        function3 = function5;
                        str8 = str19;
                        i21 = i17;
                        baseDto = (BaseDto) objB;
                        String str23 = str8;
                        i19 = i18;
                        z14 = z13;
                        str10 = str23;
                        String str24 = str3;
                        str11 = str7;
                        str9 = str24;
                        b bVar2 = b.f58375a;
                        getInStationSubtitleListTask = GetInStationSubtitleListTask.f58367a;
                        String strI2 = getInStationSubtitleListTask.i();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(strI2);
                        sb3.append(" --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ");
                        sb3.append(str9);
                        sb3.append(str16);
                        sb3.append(str10);
                        str16 = str16;
                        str15 = str15;
                        sb3.append(str15);
                        sb3.append(i15);
                        str12 = str14;
                        sb3.append(str12);
                        sb3.append(z14);
                        sb3.append(" --> subtitles = ");
                        sb3.append(baseDto);
                        bVar2.a(sb3.toString());
                        continuation = null;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        str14 = str12;
                        function4 = function3;
                        str13 = str11;
                        i22 = i21;
                        i23 = i16;
                        str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                        obj2 = objE;
                        if (getInStationSubtitleListTask.e(baseDto, function4, str10, str9, str13, i22, i23, i19, this) == obj2) {
                            return obj2;
                        }
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                        str = this.$subjectId;
                        str2 = this.$resourceId;
                        i11 = this.$episode;
                        z11 = this.$isStream;
                        function1 = this.$resultCallback;
                        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                        if (thM166exceptionOrNullimpl != null) {
                            b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                            a2VarC = w0.c();
                            getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                            this.L$0 = continuation;
                            this.L$1 = continuation;
                            this.L$2 = continuation;
                            this.L$3 = continuation;
                            this.label = 4;
                            if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                                return obj2;
                            }
                        }
                    }
                    str14 = str14;
                    continuation = null;
                    Result.Companion companion3 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    str = this.$subjectId;
                    str2 = this.$resourceId;
                    i11 = this.$episode;
                    z11 = this.$isStream;
                    function1 = this.$resultCallback;
                    thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                    if (thM166exceptionOrNullimpl != null) {
                        b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                        a2VarC = w0.c();
                        getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                        this.L$0 = continuation;
                        this.L$1 = continuation;
                        this.L$2 = continuation;
                        this.L$3 = continuation;
                        this.label = 4;
                        if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                            return obj2;
                        }
                    }
                } else if (i24 == 1) {
                    i13 = this.I$3;
                    i12 = this.I$2;
                    i14 = this.I$1;
                    i15 = this.I$0;
                    boolean z16 = this.Z$0;
                    String str25 = (String) this.L$3;
                    Function1<Boolean, Unit> function7 = (Function1) this.L$2;
                    String str26 = (String) this.L$1;
                    str6 = (String) this.L$0;
                    ResultKt.b(obj);
                    str4 = str26;
                    str14 = " -- isStream = ";
                    str15 = " -- episode = ";
                    function2 = function7;
                    str5 = str25;
                    z12 = z16;
                    objA = obj;
                    i16 = i12;
                    String str27 = str6;
                    i19 = i13;
                    z14 = z12;
                    str9 = str27;
                    String str28 = str4;
                    i21 = i14;
                    baseDto = (BaseDto) objA;
                    str10 = str28;
                    Function1<Boolean, Unit> function8 = function2;
                    str11 = str5;
                    function3 = function8;
                    b bVar3 = b.f58375a;
                    getInStationSubtitleListTask = GetInStationSubtitleListTask.f58367a;
                    String strI3 = getInStationSubtitleListTask.i();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(strI3);
                    sb4.append(" --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ");
                    sb4.append(str9);
                    sb4.append(str16);
                    sb4.append(str10);
                    str16 = str16;
                    str15 = str15;
                    sb4.append(str15);
                    sb4.append(i15);
                    str12 = str14;
                    sb4.append(str12);
                    sb4.append(z14);
                    sb4.append(" --> subtitles = ");
                    sb4.append(baseDto);
                    bVar3.a(sb4.toString());
                    continuation = null;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 3;
                    str14 = str12;
                    function4 = function3;
                    str13 = str11;
                    i22 = i21;
                    i23 = i16;
                    str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                    obj2 = objE;
                    if (getInStationSubtitleListTask.e(baseDto, function4, str10, str9, str13, i22, i23, i19, this) == obj2) {
                        return obj2;
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    str = this.$subjectId;
                    str2 = this.$resourceId;
                    i11 = this.$episode;
                    z11 = this.$isStream;
                    function1 = this.$resultCallback;
                    thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                    if (thM166exceptionOrNullimpl != null) {
                        b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                        a2VarC = w0.c();
                        getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                        this.L$0 = continuation;
                        this.L$1 = continuation;
                        this.L$2 = continuation;
                        this.L$3 = continuation;
                        this.label = 4;
                        if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                            return obj2;
                        }
                    }
                } else if (i24 == 2) {
                    i18 = this.I$3;
                    int i28 = this.I$2;
                    i17 = this.I$1;
                    i15 = this.I$0;
                    z13 = this.Z$0;
                    str7 = (String) this.L$3;
                    function3 = (Function1) this.L$2;
                    str8 = (String) this.L$1;
                    str3 = (String) this.L$0;
                    ResultKt.b(obj);
                    i16 = i28;
                    objB = obj;
                    i21 = i17;
                    baseDto = (BaseDto) objB;
                    String str29 = str8;
                    i19 = i18;
                    z14 = z13;
                    str10 = str29;
                    String str210 = str3;
                    str11 = str7;
                    str9 = str210;
                    b bVar4 = b.f58375a;
                    getInStationSubtitleListTask = GetInStationSubtitleListTask.f58367a;
                    String strI4 = getInStationSubtitleListTask.i();
                    try {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(strI4);
                        sb5.append(" --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ");
                        sb5.append(str9);
                        try {
                            sb5.append(str16);
                            sb5.append(str10);
                            str16 = str16;
                            str15 = str15;
                            try {
                                sb5.append(str15);
                                sb5.append(i15);
                                str12 = str14;
                                try {
                                    sb5.append(str12);
                                    sb5.append(z14);
                                    sb5.append(" --> subtitles = ");
                                    sb5.append(baseDto);
                                    bVar4.a(sb5.toString());
                                    continuation = null;
                                    try {
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 3;
                                        str14 = str12;
                                        function4 = function3;
                                        str13 = str11;
                                        i22 = i21;
                                        i23 = i16;
                                        str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                                        try {
                                            obj2 = objE;
                                            if (getInStationSubtitleListTask.e(baseDto, function4, str10, str9, str13, i22, i23, i19, this) == obj2) {
                                                return obj2;
                                            }
                                            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            obj2 = objE;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str14 = str12;
                                        str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    str14 = str12;
                                    str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                                    obj2 = objE;
                                    continuation = null;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                obj2 = objE;
                                str14 = str14;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            str16 = str16;
                            obj2 = objE;
                            str14 = str14;
                            str15 = str15;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                    }
                    str = this.$subjectId;
                    str2 = this.$resourceId;
                    i11 = this.$episode;
                    z11 = this.$isStream;
                    function1 = this.$resultCallback;
                    thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                    if (thM166exceptionOrNullimpl != null) {
                        b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                        a2VarC = w0.c();
                        getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                        this.L$0 = continuation;
                        this.L$1 = continuation;
                        this.L$2 = continuation;
                        this.L$3 = continuation;
                        this.label = 4;
                        if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                            return obj2;
                        }
                    }
                } else if (i24 == 3) {
                    ResultKt.b(obj);
                    obj2 = objE;
                    str16 = str16;
                    continuation = null;
                    str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
                    try {
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    } catch (Throwable th11) {
                        th = th11;
                        Result.Companion companion4 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th));
                    }
                    str = this.$subjectId;
                    str2 = this.$resourceId;
                    i11 = this.$episode;
                    z11 = this.$isStream;
                    function1 = this.$resultCallback;
                    thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                    if (thM166exceptionOrNullimpl != null) {
                        b.f58375a.b(GetInStationSubtitleListTask.f58367a.i() + str17 + str + str16 + str2 + str15 + i11 + str14 + z11 + " --> 请求接口发生异常 --> Throwable.it = " + thM166exceptionOrNullimpl);
                        a2VarC = w0.c();
                        getInStationSubtitleListTask$download$1$2$1 = new GetInStationSubtitleListTask$download$1$2$1(function1, continuation);
                        this.L$0 = continuation;
                        this.L$1 = continuation;
                        this.L$2 = continuation;
                        this.L$3 = continuation;
                        this.label = 4;
                        if (h.g(a2VarC, getInStationSubtitleListTask$download$1$2$1, this) == obj2) {
                            return obj2;
                        }
                    }
                } else {
                    if (i24 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (Throwable th12) {
                th = th12;
                obj2 = objE;
                str16 = str16;
                continuation = null;
                str17 = " --> download() --> 请求接口获取字幕列表并进行处理 --> subjectId = ";
            }
        } catch (Throwable th13) {
            th = th13;
        }
        return Unit.f68710a;
    }
}
