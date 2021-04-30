じゃんけんの手の出し方 

あなたはこれから友人と N 回じゃんけんをします。しかし、あなたは全てを見通す千里眼の持ち主なので、友人がこれから出す N 回のじゃんけんの手が全て分かってしまいました。 

ただただ全勝してしまうのは面白くないので、あなたは、N 回のじゃんけんで出した指の本数の合計がちょうど M 本になるようにじゃんけんをすることにしました。 
このとき、あなたは最高で何回じゃんけんに勝つことができるでしょうか。 

 

ここで、上の文中に出てくる「出した指の本数」というのは、じゃんけんで出した手の何本の指が立っていたか、ということであり、グー、チョキ、パーそれぞれ 
 

・グー　のとき ... 0 本 
・チョキのとき ... 2 本 
・パー　のとき ... 5 本 
 
の指を出していたということになります。 
 
 
例えば、あなたが 4 回のじゃんけんで グー、パー、チョキ、グー と出したとすると、出した指の本数の合計は、 
0 + 5 + 2 + 0 = 7 
で 7 本となります。 

 

入力される値  

入力は以下のフォーマットで与えられます。 
 
N M 
s 
 
1 行目にそれぞれじゃんけんを行う回数を表す整数 N、あなたが出す指の本数の合計を表す整数 M がこの順で半角スペース区切りで与えられます。 
 
続いて 2 行目に長さ N の文字列 s が与えられます。s の i 番目 (1 ≦ i ≦ N) の文字は i 回目のじゃんけんで相手が出す手を表し、それぞれグーが "G"、チョキが "C"、パーが "P" で表されます。 
 
入力は合計で 2 行となり、2 行目の末尾に改行が 1 つ入ります。 

 
入力値最終行の末尾に改行が１つ入ります。  
 

期待する出力 

あなたの勝つ回数の最大値を整数で出力してください。  
 
最後は改行し、余計な文字、空行を含んではいけません。 

入力例1 

4 7 CGPC 

出力例1 

4 

入力例2 

5 10 GPCPC 

出力例2 

3 