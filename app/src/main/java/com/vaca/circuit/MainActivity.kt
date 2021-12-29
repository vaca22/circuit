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

先来看看基尔霍夫定律
有电压 分压
有电流 分流


节点是分流的
杆子是分压的
节点流入和流出的 总和和0

环路的电压为0
两个节点之间任意一条路径， 电压压降都相等。
现在我们要计算各个的电压比例， 电流比例
从而求出总电阻的值
是总电压除以总电流。


Rec(Li,Red)
BEGIN

判断数组是否为0
Li是线数组

IF SIZE(Li)==0 THEN
RETURN 0;
END;




LOCAL Cu:={},He:={},Fu:={},Fux:=1;
LOCAL Fu2:={},Fu2x:=1;
LOCAL a,b,c:=1,d,f;
LOCAL s,ss;


找出Li中的最大值

1▶M;
FOR K FROM 1 TO SIZE(Li)  DO
FOR J FROM 1 TO 2 DO
IF M<Li(K,J) THEN
M:=Li(K,J);
END;
END;
END;


有最大值个元素
我怀疑是

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

等到手指抬起
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
小数点
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

中点
x:=(c+d)/2;

从D指向C的单位向量。
y:=(c-d)/ABS(c-d);

旋转90度
z:=y*;

a,b是矩形的长和宽
m(1):=x+y*a+z*b;
m(2):=x+y*a-z*b;
m(3):=x-y*a-z*b;
m(4):=x-y*a+z*b;

返回矩形的四个顶点
RETURN m;
END;



EXPORT Rex2()
BEGIN
R:=0;
输入电阻的10个数字
L5:={47,42,43,44,37,38,39,32,33,34};
双缓存界面
DIMGROB_P(G1,320,240);
DIMGROB_P(G2,320,240);

G2是背景， 顶部的紫色矩形。
RECT_P(G2,#FFFFFFh);
RECT_P(G2,(120,0),(200,26),#A000A0h);
ARC_P(G2,(100,15),15,{#FF0000h,#FF0000h});

Lib是一个32个元素的数组。不， 其实它是个电阻数组， 是可以扩充的


Po是一个节点数组， 最开始的两个节点是正极和负极。之后的是电阻节点。
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

触发紫色矩形
IF Tou(1,1)>120 AND Tou(1,1)<200  AND Tou(1,2)>0 AND Tou(1,2)<27 THEN
t:=1;
END;

触发选择电阻节点
ga:=(Tou(1,1),Tou(1,2));
IF ABS(ga-(100,15))≤15 THEN
NE:=1;
END;

收集当前触点与各个节点的距离。
IF NE==0 THEN
L1:=ABS(ga-Po);
N:=MIN(L1);
如果距离足够近
IF N≤15 THEN
找到它的位置
M:=POS(L1,N);
M▶R;

选了两个了
IF M≠Q AND X==1  THEN
    H:=H+1;
小的放前面。
这样统一， 方便POS查找
    IF M<Q THEN
    r:={M,Q};
    ELSE
    r:={Q,M};
    END;
如果这根线存在了
    IF (Y:=POS(Li,r))≠0 THEN
    删除
    Li:=SUPPRESS(Li,Y);
    之前提前加了一， 现在减去2
    H:=H-2;
    ELSE
    增加线
    Li(H):=r;
    END;
END;

当前有选择了。
X:=1;
ELSE
R:=0;
当前没选择节点了。
X:=0;
T:=SIZE(Li);
IF T≠0 THEN
遍历每根线找到中点
FOR K FROM 1 TO T DO
Lix(K):=(Po(Li(K,1))+Po(Li(K,2)))/2;
END;
L4:=ABS(ga-Lix);
D:=MIN(L4);
如果有选择电阻以便输入阻值
IF D<15 THEN
C:=POS(L4,D);
绘制一个圆形圈住电阻
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

绘制电阻， 一根线， 一个矩形
FOR K FROM 1 TO H DO
LINE_P(G1,Po(Li(K,1)),Po(Li(K,2)),#0h);
FILLPOLY_P(G1,ff(a,b,Po(Li(K,1)),Po(Li(K,2))),#FF00FFh)
END;


绘制正负级
ARC_P(G1,Po(1),10,{#FFFF00h,#FFFF00h});
TEXTOUT_P("+",G1,Po(1)-(5,13),7,#FFh);
ARC_P(G1,Po(2),10,{#FFFF00h,#FFFF00h});
TEXTOUT_P("-",G1,Po(2)-(5,13),7,#FFh);

绘制电阻节点
FOR K FROM 3 TO S DO
ARC_P(G1,Po(K),5,{#70FFh,#70FFh});
END;

绘制选择的小圈圈
IF R≠0 THEN
ARC_P(G1,Po(R),12,#0h);
END;

如果删除del,删除节点
IF A==19 AND R≠0 THEN
Po:=SUPPRESS(Po,R);
S:=S-1;
L:=SIZE(Li);
L2:={};
FOR K FROM 1 TO L DO
Z:=0;

遍历查找有此点的污染
FOR J FROM 1 TO 2 DO
IF Li(K,J)==R THEN
Z:=1;
END;
END;

添加到污染指标中
IF Z==1 THEN
L2(0):=K;
END;

END;
IF (F:=SIZE(L2))≠0 THEN
去除
Li:=SUPPRESS(Li,L2);
D:=SIZE(Li);

指标锐减
FOR K FROM 1 TO D DO
FOR J FROM 1 TO 2 DO
IF Li(K,J)>R THEN
Li(K,J):=Li(K,J)-1;
END;
END;
END;

总量
H:=H-F;
END;

R:=0;
END;

如果按了紫色， 好， 那就计算出来
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
