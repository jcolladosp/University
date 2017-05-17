# Tarea 2

*Jose Collado San Pedro* (jocolsan@inf.upv.es)

#### Resultados de ejecutar los siguientes comandos:
1. op size : Battery -> Nat .
```

  Maude> reduce in BATTERY-ALL : size(- ^ o ^ o ^ o) .
  reduce in BATTERY-ALL : size(- ^ o ^ o ^ o) .
  rewrites: 9 in 0ms cpu (0ms real) (~ rewrites/second)
  result NzNat: 4
  

  Maude> reduce in BATTERY-ALL : size(- ^ o ^ +) .
  reduce in BATTERY-ALL : size(- ^ o ^ +) .
  rewrites: 7 in 0ms cpu (0ms real) (~ rewrites/second)
  result NzNat: 3


  Maude> reduce in BATTERY-ALL : size(- ^ -) .
  reduce in BATTERY-ALL : size(- ^ -) .
  rewrites: 5 in 0ms cpu (0ms real) (~ rewrites/second)
  result NzNat: 2
  

  Maude> reduce in BATTERY-ALL : size(nil) .
  reduce in BATTERY-ALL : size(nil) .
  rewrites: 1 in 0ms cpu (0ms real) (~ rewrites/second)
  result Zero: 0
  
```
&nbsp;
![screenshot1](/home/jcolladosp/Dropbox/TERCER/2 cuatri/MFI/tarea2/screenshot1.png)

&nbsp;
 

2. op half-charge? : Battery -> Bool .
 ```
  Maude> reduce in BATTERY-ALL : half-charge?(- ^ o ^ o ^ o) .
  reduce in BATTERY-ALL : half-charge?(- ^ o ^ o ^ o) .
  rewrites: 19 in 0ms cpu (0ms real) (~ rewrites/second)
  result Bool: true

  Maude> reduce in BATTERY-ALL : half-charge?(- ^ o ^ - ^ -) .
  reduce in BATTERY-ALL : half-charge?(- ^ o ^ - ^ -) .
  rewrites: 15 in 0ms cpu (0ms real) (~ rewrites/second)
  result Bool: false

  Maude> reduce in BATTERY-ALL : half-charge?(- ^ o ^ + ^ -) .
  reduce in BATTERY-ALL : half-charge?(- ^ o ^ + ^ -) .
  rewrites: 17 in 0ms cpu (0ms real) (~ rewrites/second)
  result Bool: false

  Maude> reduce in BATTERY-ALL : half-charge?(- ^ o ^ + ^ +) .
  reduce in BATTERY-ALL : half-charge?(- ^ o ^ + ^ +) .
  rewrites: 19 in 0ms cpu (0ms real) (~ rewrites/second)
  result Bool: true
 ```

![screenshot2](/home/jcolladosp/Dropbox/TERCER/2 cuatri/MFI/tarea2/screenshot2.png)

&nbsp;
3. op consume-all : Battery -> Battery .
```
   Maude> search in BATTERY-ALL : consume-all(- ^ o ^ o) =>* EBt .
   search in BATTERY-ALL : consume-all(- ^ o ^ o) =>* EBt .

   Solution 1 (state 8)
   states: 9  rewrites: 12 in 0ms cpu (0ms real) (~ rewrites/second)
   EBt --> - ^ - ^ -
```
![screenshot3](/home/jcolladosp/Dropbox/TERCER/2 cuatri/MFI/tarea2/screenshot3.png)

4. show search graph .

   ```
   Maude> show search graph .
   state 0, Battery: consume-all(- ^ o ^ o)
   arc 0 ===> state 1 (rl consume-all(FirstBt ^ o ^ SecondBt) => consume-all(FirstBt ^
       + ^ SecondBt) .)
   arc 1 ===> state 2 (rl consume-all(FirstBt ^ o ^ SecondBt) => consume-all(FirstBt ^
       + ^ SecondBt) .)

   state 1, Battery: consume-all(- ^ + ^ o)
   arc 0 ===> state 3 (rl consume-all(FirstBt ^ o ^ SecondBt) => consume-all(FirstBt ^
       + ^ SecondBt) .)
   arc 1 ===> state 4 (rl consume-all(FirstBt ^ + ^ SecondBt) => consume-all(FirstBt ^
       - ^ SecondBt) .)

   state 2, Battery: consume-all(- ^ o ^ +)
   arc 0 ===> state 3 (rl consume-all(FirstBt ^ o ^ SecondBt) => consume-all(FirstBt ^
       + ^ SecondBt) .)
   arc 1 ===> state 5 (rl consume-all(FirstBt ^ + ^ SecondBt) => consume-all(FirstBt ^
       - ^ SecondBt) .)

   state 3, Battery: consume-all(- ^ + ^ +)
   arc 0 ===> state 6 (rl consume-all(FirstBt ^ + ^ SecondBt) => consume-all(FirstBt ^
       - ^ SecondBt) .)
   arc 1 ===> state 7 (rl consume-all(FirstBt ^ + ^ SecondBt) => consume-all(FirstBt ^
       - ^ SecondBt) .)

   state 4, Battery: consume-all(- ^ - ^ o)
   arc 0 ===> state 6 (rl consume-all(FirstBt ^ o ^ SecondBt) => consume-all(FirstBt ^
       + ^ SecondBt) .)

   state 5, Battery: consume-all(- ^ o ^ -)
   arc 0 ===> state 7 (rl consume-all(FirstBt ^ o ^ SecondBt) => consume-all(FirstBt ^
       + ^ SecondBt) .)

   state 6, Battery: consume-all(- ^ - ^ +)
   arc 0 ===> state 8 (rl consume-all(FirstBt ^ + ^ SecondBt) => consume-all(FirstBt ^
       - ^ SecondBt) .)

   state 7, Battery: consume-all(- ^ + ^ -)
   arc 0 ===> state 8 (rl consume-all(FirstBt ^ + ^ SecondBt) => consume-all(FirstBt ^
       - ^ SecondBt) .)

   state 8, EBattery: - ^ - ^ -

   ```

   â€‹



