package e2;

import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.p;
import okhttp3.internal.ws.WebSocketProtocol;

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
@JvmInline
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f63780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0656a f63630b = new C0656a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f63636c = g.a(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f63642d = g.a(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f63648e = g.a(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f63654f = g.a(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f63660g = g.a(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f63666h = g.a(259);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f63672i = g.a(260);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f63678j = g.a(261);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f63684k = g.a(262);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f63690l = g.a(263);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f63696m = g.a(280);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f63702n = g.a(281);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f63708o = g.a(282);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f63714p = g.a(283);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f63720q = g.a(5);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f63726r = g.a(6);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f63732s = g.a(19);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f63738t = g.a(20);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f63744u = g.a(21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f63750v = g.a(22);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f63756w = g.a(23);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f63762x = g.a(268);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f63768y = g.a(269);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f63774z = g.a(270);
    public static final long A = g.a(271);
    public static final long B = g.a(24);
    public static final long C = g.a(25);
    public static final long D = g.a(26);
    public static final long E = g.a(27);
    public static final long F = g.a(28);
    public static final long G = g.a(7);
    public static final long H = g.a(8);
    public static final long I = g.a(9);
    public static final long J = g.a(10);
    public static final long K = g.a(11);
    public static final long L = g.a(12);
    public static final long M = g.a(13);
    public static final long N = g.a(14);
    public static final long O = g.a(15);
    public static final long P = g.a(16);
    public static final long Q = g.a(81);
    public static final long R = g.a(69);
    public static final long S = g.a(17);
    public static final long T = g.a(70);
    public static final long U = g.a(18);
    public static final long V = g.a(29);
    public static final long W = g.a(30);
    public static final long X = g.a(31);
    public static final long Y = g.a(32);
    public static final long Z = g.a(33);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final long f63625a0 = g.a(34);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final long f63631b0 = g.a(35);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final long f63637c0 = g.a(36);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final long f63643d0 = g.a(37);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final long f63649e0 = g.a(38);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final long f63655f0 = g.a(39);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final long f63661g0 = g.a(40);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final long f63667h0 = g.a(41);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final long f63673i0 = g.a(42);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final long f63679j0 = g.a(43);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final long f63685k0 = g.a(44);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final long f63691l0 = g.a(45);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final long f63697m0 = g.a(46);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final long f63703n0 = g.a(47);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final long f63709o0 = g.a(48);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final long f63715p0 = g.a(49);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final long f63721q0 = g.a(50);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final long f63727r0 = g.a(51);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final long f63733s0 = g.a(52);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final long f63739t0 = g.a(53);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final long f63745u0 = g.a(54);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final long f63751v0 = g.a(55);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final long f63757w0 = g.a(56);

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final long f63763x0 = g.a(57);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final long f63769y0 = g.a(58);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final long f63775z0 = g.a(59);
    public static final long A0 = g.a(60);
    public static final long B0 = g.a(61);
    public static final long C0 = g.a(62);
    public static final long D0 = g.a(63);
    public static final long E0 = g.a(64);
    public static final long F0 = g.a(65);
    public static final long G0 = g.a(66);
    public static final long H0 = g.a(67);
    public static final long I0 = g.a(112);
    public static final long J0 = g.a(111);
    public static final long K0 = g.a(113);
    public static final long L0 = g.a(114);
    public static final long M0 = g.a(115);
    public static final long N0 = g.a(116);
    public static final long O0 = g.a(117);
    public static final long P0 = g.a(118);
    public static final long Q0 = g.a(119);
    public static final long R0 = g.a(120);
    public static final long S0 = g.a(121);
    public static final long T0 = g.a(122);
    public static final long U0 = g.a(123);
    public static final long V0 = g.a(124);
    public static final long W0 = g.a(277);
    public static final long X0 = g.a(278);
    public static final long Y0 = g.a(279);
    public static final long Z0 = g.a(68);

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final long f63626a1 = g.a(71);

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final long f63632b1 = g.a(72);

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final long f63638c1 = g.a(76);

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final long f63644d1 = g.a(73);

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final long f63650e1 = g.a(74);

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final long f63656f1 = g.a(75);

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final long f63662g1 = g.a(77);

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final long f63668h1 = g.a(78);

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final long f63674i1 = g.a(79);

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final long f63680j1 = g.a(80);

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final long f63686k1 = g.a(82);

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final long f63692l1 = g.a(83);

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final long f63698m1 = g.a(84);

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final long f63704n1 = g.a(92);

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final long f63710o1 = g.a(93);

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final long f63716p1 = g.a(94);

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final long f63722q1 = g.a(95);

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final long f63728r1 = g.a(96);

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final long f63734s1 = g.a(97);

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final long f63740t1 = g.a(98);

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final long f63746u1 = g.a(99);

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final long f63752v1 = g.a(100);

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final long f63758w1 = g.a(101);

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final long f63764x1 = g.a(102);

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final long f63770y1 = g.a(Worker.WHAT_SYNC_DATA);

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final long f63776z1 = g.a(104);
    public static final long A1 = g.a(105);
    public static final long B1 = g.a(106);
    public static final long C1 = g.a(107);
    public static final long D1 = g.a(108);
    public static final long E1 = g.a(109);
    public static final long F1 = g.a(Worker.WHAT_QUIT);
    public static final long G1 = g.a(188);
    public static final long H1 = g.a(PsExtractor.PRIVATE_STREAM_1);
    public static final long I1 = g.a(190);
    public static final long J1 = g.a(191);
    public static final long K1 = g.a(PsExtractor.AUDIO_STREAM);
    public static final long L1 = g.a(193);
    public static final long M1 = g.a(194);
    public static final long N1 = g.a(195);
    public static final long O1 = g.a(196);
    public static final long P1 = g.a(197);
    public static final long Q1 = g.a(198);
    public static final long R1 = g.a(199);
    public static final long S1 = g.a(200);
    public static final long T1 = g.a(201);
    public static final long U1 = g.a(202);
    public static final long V1 = g.a(203);
    public static final long W1 = g.a(125);
    public static final long X1 = g.a(131);
    public static final long Y1 = g.a(132);
    public static final long Z1 = g.a(133);

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final long f63627a2 = g.a(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO);

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final long f63633b2 = g.a(TsExtractor.TS_STREAM_TYPE_E_AC3);

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final long f63639c2 = g.a(136);

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final long f63645d2 = g.a(137);

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final long f63651e2 = g.a(TsExtractor.TS_STREAM_TYPE_DTS);

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final long f63657f2 = g.a(139);

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final long f63663g2 = g.a(140);

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final long f63669h2 = g.a(141);

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final long f63675i2 = g.a(142);

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final long f63681j2 = g.a(143);

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static final long f63687k2 = g.a(144);

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final long f63693l2 = g.a(145);

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final long f63699m2 = g.a(146);

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final long f63705n2 = g.a(147);

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final long f63711o2 = g.a(148);

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final long f63717p2 = g.a(149);

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final long f63723q2 = g.a(150);

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final long f63729r2 = g.a(151);

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final long f63735s2 = g.a(152);

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final long f63741t2 = g.a(153);

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final long f63747u2 = g.a(154);

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final long f63753v2 = g.a(155);

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final long f63759w2 = g.a(156);

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final long f63765x2 = g.a(157);

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final long f63771y2 = g.a(158);

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final long f63777z2 = g.a(159);
    public static final long A2 = g.a(160);
    public static final long B2 = g.a(161);
    public static final long C2 = g.a(162);
    public static final long D2 = g.a(163);
    public static final long E2 = g.a(WebSocketProtocol.PAYLOAD_SHORT);
    public static final long F2 = g.a(127);
    public static final long G2 = g.a(85);
    public static final long H2 = g.a(86);
    public static final long I2 = g.a(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
    public static final long J2 = g.a(87);
    public static final long K2 = g.a(88);
    public static final long L2 = g.a(89);
    public static final long M2 = g.a(90);
    public static final long N2 = g.a(128);
    public static final long O2 = g.a(222);
    public static final long P2 = g.a(TsExtractor.TS_STREAM_TYPE_AC3);
    public static final long Q2 = g.a(226);
    public static final long R2 = g.a(272);
    public static final long S2 = g.a(273);
    public static final long T2 = g.a(274);
    public static final long U2 = g.a(275);
    public static final long V2 = g.a(91);
    public static final long W2 = g.a(164);
    public static final long X2 = g.a(165);
    public static final long Y2 = g.a(166);
    public static final long Z2 = g.a(167);

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public static final long f63628a3 = g.a(168);

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public static final long f63634b3 = g.a(169);

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public static final long f63640c3 = g.a(170);

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final long f63646d3 = g.a(171);

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public static final long f63652e3 = g.a(172);

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public static final long f63658f3 = g.a(173);

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public static final long f63664g3 = g.a(174);

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final long f63670h3 = g.a(175);

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final long f63676i3 = g.a(176);

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public static final long f63682j3 = g.a(177);

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public static final long f63688k3 = g.a(178);

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public static final long f63694l3 = g.a(179);

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public static final long f63700m3 = g.a(180);

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public static final long f63706n3 = g.a(181);

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public static final long f63712o3 = g.a(182);

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public static final long f63718p3 = g.a(183);

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public static final long f63724q3 = g.a(184);

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public static final long f63730r3 = g.a(185);

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public static final long f63736s3 = g.a(186);

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public static final long f63742t3 = g.a(187);

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public static final long f63748u3 = g.a(204);

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public static final long f63754v3 = g.a(205);

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public static final long f63760w3 = g.a(206);

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public static final long f63766x3 = g.a(207);

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public static final long f63772y3 = g.a(208);

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public static final long f63778z3 = g.a(209);
    public static final long A3 = g.a(210);
    public static final long B3 = g.a(211);
    public static final long C3 = g.a(212);
    public static final long D3 = g.a(213);
    public static final long E3 = g.a(214);
    public static final long F3 = g.a(215);
    public static final long G3 = g.a(216);
    public static final long H3 = g.a(217);
    public static final long I3 = g.a(218);
    public static final long J3 = g.a(219);
    public static final long K3 = g.a(220);
    public static final long L3 = g.a(221);
    public static final long M3 = g.a(223);
    public static final long N3 = g.a(224);
    public static final long O3 = g.a(276);
    public static final long P3 = g.a(225);
    public static final long Q3 = g.a(229);
    public static final long R3 = g.a(230);
    public static final long S3 = g.a(231);
    public static final long T3 = g.a(232);
    public static final long U3 = g.a(233);
    public static final long V3 = g.a(234);
    public static final long W3 = g.a(235);
    public static final long X3 = g.a(236);
    public static final long Y3 = g.a(237);
    public static final long Z3 = g.a(238);

    /* JADX INFO: renamed from: a4, reason: collision with root package name */
    public static final long f63629a4 = g.a(239);

    /* JADX INFO: renamed from: b4, reason: collision with root package name */
    public static final long f63635b4 = g.a(240);

    /* JADX INFO: renamed from: c4, reason: collision with root package name */
    public static final long f63641c4 = g.a(241);

    /* JADX INFO: renamed from: d4, reason: collision with root package name */
    public static final long f63647d4 = g.a(242);

    /* JADX INFO: renamed from: e4, reason: collision with root package name */
    public static final long f63653e4 = g.a(243);

    /* JADX INFO: renamed from: f4, reason: collision with root package name */
    public static final long f63659f4 = g.a(244);

    /* JADX INFO: renamed from: g4, reason: collision with root package name */
    public static final long f63665g4 = g.a(245);

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public static final long f63671h4 = g.a(246);

    /* JADX INFO: renamed from: i4, reason: collision with root package name */
    public static final long f63677i4 = g.a(247);

    /* JADX INFO: renamed from: j4, reason: collision with root package name */
    public static final long f63683j4 = g.a(248);

    /* JADX INFO: renamed from: k4, reason: collision with root package name */
    public static final long f63689k4 = g.a(249);

    /* JADX INFO: renamed from: l4, reason: collision with root package name */
    public static final long f63695l4 = g.a(250);

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    public static final long f63701m4 = g.a(251);

    /* JADX INFO: renamed from: n4, reason: collision with root package name */
    public static final long f63707n4 = g.a(252);

    /* JADX INFO: renamed from: o4, reason: collision with root package name */
    public static final long f63713o4 = g.a(253);

    /* JADX INFO: renamed from: p4, reason: collision with root package name */
    public static final long f63719p4 = g.a(254);

    /* JADX INFO: renamed from: q4, reason: collision with root package name */
    public static final long f63725q4 = g.a(255);

    /* JADX INFO: renamed from: r4, reason: collision with root package name */
    public static final long f63731r4 = g.a(256);

    /* JADX INFO: renamed from: s4, reason: collision with root package name */
    public static final long f63737s4 = g.a(InputDeviceCompat.SOURCE_KEYBOARD);

    /* JADX INFO: renamed from: t4, reason: collision with root package name */
    public static final long f63743t4 = g.a(258);

    /* JADX INFO: renamed from: u4, reason: collision with root package name */
    public static final long f63749u4 = g.a(264);

    /* JADX INFO: renamed from: v4, reason: collision with root package name */
    public static final long f63755v4 = g.a(265);

    /* JADX INFO: renamed from: w4, reason: collision with root package name */
    public static final long f63761w4 = g.a(266);

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    public static final long f63767x4 = g.a(267);

    /* JADX INFO: renamed from: y4, reason: collision with root package name */
    public static final long f63773y4 = g.a(284);

    /* JADX INFO: renamed from: z4, reason: collision with root package name */
    public static final long f63779z4 = g.a(285);
    public static final long A4 = g.a(286);
    public static final long B4 = g.a(287);
    public static final long C4 = g.a(288);

    /* JADX INFO: renamed from: e2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0656a {
        public C0656a() {
        }

        public /* synthetic */ C0656a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f63660g;
        }

        public final long b() {
            return a.f63756w;
        }

        public final long c() {
            return a.f63738t;
        }

        public final long d() {
            return a.f63744u;
        }

        public final long e() {
            return a.f63750v;
        }

        public final long f() {
            return a.f63732s;
        }

        public final long g() {
            return a.G0;
        }

        public final long h() {
            return a.J0;
        }

        public final long i() {
            return a.A2;
        }

        public final long j() {
            return a.f63710o1;
        }

        public final long k() {
            return a.f63704n1;
        }

        public final long l() {
            return a.B0;
        }
    }

    public /* synthetic */ a(long j11) {
        this.f63780a = j11;
    }

    public static final /* synthetic */ a m(long j11) {
        return new a(j11);
    }

    public static long n(long j11) {
        return j11;
    }

    public static boolean o(long j11, Object obj) {
        return (obj instanceof a) && j11 == ((a) obj).s();
    }

    public static final boolean p(long j11, long j12) {
        return j11 == j12;
    }

    public static int q(long j11) {
        return p.a(j11);
    }

    public static String r(long j11) {
        return "Key code: " + j11;
    }

    public boolean equals(Object obj) {
        return o(this.f63780a, obj);
    }

    public int hashCode() {
        return q(this.f63780a);
    }

    public final /* synthetic */ long s() {
        return this.f63780a;
    }

    public String toString() {
        return r(this.f63780a);
    }
}
