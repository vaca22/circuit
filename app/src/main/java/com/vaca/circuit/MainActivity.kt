package com.vaca.circuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}



/*
Rec(Li,Red)
BEGIN
IF SIZE(Li)==0 THEN
RETURN 0;
END;
LOCAL Cu:={},He:={},Fu:={},Fux:=1;
LOCAL Fu2:={},Fu2x:=1;
LOCAL a,b,c:=1,d,f;
LOCAL s,ss;
1▶M;
FOR K FROM 1 TO SIZE(Li)  DO
FOR J FROM 1 TO 2 DO
IF M<Li(K,J) THEN
M:=Li(K,J);
END;
END;
END;
Cu:=MAKELIST({},K,1,M);
FOR K FROM 1 TO SIZE(Li)  DO
FOR J FROM 1 TO 2 DO
Cu(Li(K,J),0):=Li(K,3-J);
END;
END;
M1:=[[0]];
LOCAL v:=[0];
FOR K FROM 1 TO SIZE(Li) DO
v(K):=0;
END;
FOR K FROM 3 TO M DO
ss:=Cu(K);
s:=SIZE(ss);
FOR J FROM 1 TO s DO
IF K>ss(J) THEN
f:=POS(Li,{ss(J),K});
M1(c,f):=1;
ELSE
f:=POS(Li,{K,ss(J)});
M1(c,f):=−1;
END;
END;
c:=c+1;
END;
U:=0;
V:=1;
LOCAL Co:={1},Cox:={1},Te;
L1:={};
L2:={};
WHILE U≠V DO
U:=U+1;
Te:=Cu(Co(U));
FOR K FROM 1 TO SIZE(Te) DO
IF Te(K)≠Co(Cox(U)) THEN
IF POS(Co,Te(K))==0 THEN
V:=V+1;
Co(V):=Te(K);
Cox(V):=U;
ELSE
L2(0):=Te(K);
a:=POS(Co,Te(K));
Fu(Fux):={Co(a)};
b:=a;
REPEAT
b:=Cox(b);
Fu(Fux,0):=Co(b);
UNTIL b==1;
M1(c):=v;
FOR d FROM 1 TO SIZE(Fu(Fux))-1 DO
IF Fu(Fux,d)>Fu(Fux,d+1) THEN
f:=POS(Li,{Fu(Fux,d+1),Fu(Fux,d)});
M1(c,f):=M1(c,f)+Red(f);
ELSE
f:=POS(Li,{Fu(Fux,d),Fu(Fux,d+1)});
M1(c,f):=M1(c,f)-Red(f);
END;
END;
Fux:=Fux+1;
Fu2(Fu2x):={Te(K),Co(U)};
b:=U;
REPEAT
b:=Cox(b);
Fu2(Fu2x,0):=Co(b);
UNTIL b==1;
FOR d FROM 1 TO SIZE(Fu2(Fu2x))-1 DO
IF Fu2(Fu2x,d)>Fu2(Fu2x,d+1) THEN
f:=POS(Li,{Fu2(Fu2x,d+1),Fu2(Fu2x,d)});
M1(c,f):=M1(c,f)-Red(f);
ELSE
f:=POS(Li,{Fu2(Fu2x,d),Fu2(Fu2x,d+1)});
M1(c,f):=M1(c,f)+Red(f);
END;
END;
Fu2x:=Fu2x+1;
c:=c+1;
END;
L1(0):=Te(K);
END;
END;
END;
M1:=RREF(M1);
D:=SIZE(Li);
L1:=MAKELIST(−M1(K,D),K,1,D-1);
L1(D):=1;
I:=ΣLIST(L2:=MAKELIST(L1(POS(Li,{1,Cu(1,K)})),K,1,SIZE(Cu(1))));
d:=POS(Co,2);
c:=1;
L2:={2};
REPEAT
d:=Cox(d);
c:=c+1;
L2(c):=Co(d);
UNTIL d==1;
U:=0;
FOR K FROM 1 TO c-1 DO
IF L2(K)<L2(K+1) THEN
f:=POS(Li,{L2(K),L2(K+1)});
U:=U-Red(f)*L1(f);
ELSE
f:=POS(Li,{L2(K+1),L2(K)});
U:=U+Red(f)*L1(f);
END;
END;
IF U==0 THEN
RETURN 0;
END;
RETURN U/I;
END;
SE(a,b,d)
BEGIN
LOCAL c:=(a+b)/2;
IF ABS(d-c)<10 THEN
RETURN 1;
ELSE
RETURN 0;
END;
END;
SH(aa)
BEGIN
LOCAL Tou;
REPEAT
Tou:=MOUSE();
UNTIL SIZE(Tou(1))==0;
A:=−1;
RECT_P(G1,(120,0),(320,27),#A000A0h);
TEXTOUT_P(aa+"  Ω",G1,120,0,7,#FF00h,100,#A000A0h);
BLIT_P(G1);
LOCAL s:=0,m,z:=0,k:=1;
WHILE A≠30 DO
Tou:=MOUSE();
IF SIZE(Tou(1)) THEN
RETURN aa;
END;
A:=GETKEY;
IF (m:=POS(L5,A))≠0 THEN
IF z==1 THEN
k:=k/10;
s:=s+(m-1)*k;
RECT_P(G1,(120,0),(200,27),#A000A0h);
TEXTOUT_P(s+"  Ω",G1,120,0,7,#FF00h,100,#A000A0h);
BLIT_P(G1);
ELSE
s:=10*s+(m-1);
RECT_P(G1,(120,0),(200,27),#A000A0h);
TEXTOUT_P(s+"  Ω",G1,120,0,7,#FF00h,100,#A000A0h);
BLIT_P(G1);
END;
ELSE
IF A==48 THEN
z:=1;
END;
END;
END;
IF s==0 THEN
RETURN aa;
ELSE
RETURN s;
END;
END;
ff(a,b,c,d)
BEGIN
LOCAL m:={},x,y,z;
x:=(c+d)/2;
y:=(c-d)/ABS(c-d);
z:=y*;
m(1):=x+y*a+z*b;
m(2):=x+y*a-z*b;
m(3):=x-y*a-z*b;
m(4):=x-y*a+z*b;
RETURN m;
END;
EXPORT Rex2()
BEGIN
R:=0;
L5:={47,42,43,44,37,38,39,32,33,34};
DIMGROB_P(G1,320,240);
DIMGROB_P(G2,320,240);
RECT_P(G2,#FFFFFFh);
RECT_P(G2,(120,0),(200,26),#A000A0h);
ARC_P(G2,(100,15),15,{#FF0000h,#FF0000h});
LOCAL Po:={(280,120),(30,120)};
LOCAL Li:={},Lix:={},Lib:=MAKELIST(0,K,1,32);
LOCAL gg;
LOCAL a:=10,b:=5;
H:=0;
S:=2;
LOCAL Tou,ga,NE:=0,r,t:=0;
A:=0;
WHILE  A≠4 DO
A:=GETKEY;
Tou:=MOUSE();
IF SIZE(Tou(1)) THEN
IF Tou(1,1)>120 AND Tou(1,1)<200  AND Tou(1,2)>0 AND Tou(1,2)<27 THEN
t:=1;
END;
ga:=(Tou(1,1),Tou(1,2));
IF ABS(ga-(100,15))≤15 THEN
NE:=1;
END;
IF NE==0 THEN
L1:=ABS(ga-Po);
N:=MIN(L1);
IF N≤15 THEN
M:=POS(L1,N);
M▶R;
IF M≠Q AND X==1  THEN
H:=H+1;
IF M<Q THEN
r:={M,Q};
ELSE
r:={Q,M};
END;
IF (Y:=POS(Li,r))≠0 THEN
Li:=SUPPRESS(Li,Y);
H:=H-2;
ELSE
Li(H):=r;
END;
END;
X:=1;
ELSE
R:=0;
X:=0;
T:=SIZE(Li);
IF T≠0 THEN
FOR K FROM 1 TO T DO
Lix(K):=(Po(Li(K,1))+Po(Li(K,2)))/2;
END;
L4:=ABS(ga-Lix);
D:=MIN(L4);
IF D<15 THEN
C:=POS(L4,D);
ARC_P(G1,Lix(C),12,#0h);
Lib(C):=SH(Lib(C));
END;
END;
END;
M▶Q;
IF X==1 THEN
Po(M):=ga;
END;
END;
END;
BLIT_P(G1,G2);
IF NE==1 THEN
ARC_P(G1,ga,10,{#FF0000h,#FF0000h});
IF A==30 THEN
NE:=0;
S:=S+1;
Po(S):=ga;
END;
END;
FOR K FROM 1 TO H DO
LINE_P(G1,Po(Li(K,1)),Po(Li(K,2)),#0h);
FILLPOLY_P(G1,ff(a,b,Po(Li(K,1)),Po(Li(K,2))),#FF00FFh)
END;
ARC_P(G1,Po(1),10,{#FFFF00h,#FFFF00h});
TEXTOUT_P("+",G1,Po(1)-(5,13),7,#FFh);
ARC_P(G1,Po(2),10,{#FFFF00h,#FFFF00h});
TEXTOUT_P("-",G1,Po(2)-(5,13),7,#FFh);
FOR K FROM 3 TO S DO
ARC_P(G1,Po(K),5,{#70FFh,#70FFh});
END;
IF R≠0 THEN
ARC_P(G1,Po(R),12,#0h);
END;
IF A==19 AND R≠0 THEN
Po:=SUPPRESS(Po,R);
S:=S-1;
L:=SIZE(Li);
L2:={};
FOR K FROM 1 TO L DO
Z:=0;
FOR J FROM 1 TO 2 DO
IF Li(K,J)==R THEN
Z:=1;
END;
END;
IF Z==1 THEN
L2(0):=K;
END;
END;
IF (F:=SIZE(L2))≠0 THEN
Li:=SUPPRESS(Li,L2);
D:=SIZE(Li);
FOR K FROM 1 TO D DO
FOR J FROM 1 TO 2 DO
IF Li(K,J)>R THEN
Li(K,J):=Li(K,J)-1;
END;
END;
END;
H:=H-F;
END;
R:=0;
END;
IF t==1 THEN
gg:=Rec(Li,Lib);
t:=0;
END;
IF gg≠0 THEN
TEXTOUT_P("Σ: "+ROUND(gg,3)+"  Ω",G1,120,0,7,#FF00h,200,#A000A0h);
END;
BLIT_P(G1);
END;
RETURN 1;
END;*/
