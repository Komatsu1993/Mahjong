package bb;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Bb implements Serializable{
    private Integer[] pai = new Integer[34];   //入力された牌を格納する
    private String[] outputPai = new String[14];  //入力された牌を出力するための画像を指定する
    private Integer[][] paisi = new Integer[5][3];  //あがっていた場合のヘッドを面子を入れる 
    private Integer paiNum = 1;   // 今paisi に入っている面子の数
    private String[][] paisiGa = new String[5][3];  //paisi を画像として出力するための手段
    private String full = "入力してください。";   //入力された牌の数を判別する
    private String kekka = "あがっていません。";  //判定結果を出力
    private Integer[] manzu = new Integer[9]; //マンズを入れる
    private Integer[] pinzu = new Integer[9]; //ソウズを入れる
    private Integer[] souzu = new Integer[9]; //ピンズを入れる
    private Integer[] tupai = new Integer[7]; //字牌を入れる
    private Integer howPaisi = -1; //牌姿から面子を作れたか
    private String[] yakuName = new String[20];  //判定された役の名前を入れる
    
    // 初期値は画像はブランク、paiは全てない状態（０）、牌姿は上がっていない状態（－１）
    Bb() {
        for(int i = 0; i < pai.length; i++) {
            pai[i] = 0;
        }
        
        for(int i = 0; i < outputPai.length; i++) {
            outputPai[i] = "blank.png";
        }
        
        for(int i = 0; i < paisi.length; i++) {
            for(int j = 0; j < paisi[i].length; j++) {
                paisi[i][j] = -1;
                paisiGa[i][j] = "blank.png";
            }
        }
        
        for(int i = 0; i < yakuName.length; i++) {
            yakuName[i] = " ";
        }
        
        full = "入力してください。";
        paiNum = 1;
    }
    
    
    // クリックされた牌を表示する
    // 配列paiも形成する
    public void getNumber(Integer num) {
        pai[num]++ ;  //pai の形成
        
        Integer i = 0;
        Integer j = 0;
        
        while(i < 14) {
            if(outputPai[i].equals("blank.png")) {
                j = i; break;
            }
            i++;
        }
        
        // まだ牌姿が１４枚に到達していなければ outputPai を入力された牌画に書き換える
        // 到達していたら　入力がいっぱいです　と情報表示する
        if(i != 14) {
            switch(num) {
                case 0: outputPai[j] = "man1.gif"; break;
                case 1: outputPai[j] = "man2.gif"; break;
                case 2: outputPai[j] = "man3.gif"; break;
                case 3: outputPai[j] = "man4.gif"; break;
                case 4: outputPai[j] = "man5.gif"; break;
                case 5: outputPai[j] = "man6.gif"; break;
                case 6: outputPai[j] = "man7.gif"; break;
                case 7: outputPai[j] = "man8.gif"; break;
                case 8: outputPai[j] = "man9.gif"; break;
                case 9: outputPai[j] = "pin1.gif"; break;
                case 10: outputPai[j] = "pin2.gif"; break;
                case 11: outputPai[j] = "pin3.gif"; break;
                case 12: outputPai[j] = "pin4.gif"; break;
                case 13: outputPai[j] = "pin5.gif"; break;
                case 14: outputPai[j] = "pin6.gif"; break;
                case 15: outputPai[j] = "pin7.gif"; break;
                case 16: outputPai[j] = "pin8.gif"; break;
                case 17: outputPai[j] = "pin9.gif"; break;
                case 18: outputPai[j] = "sou1.gif"; break;
                case 19: outputPai[j] = "sou2.gif"; break;
                case 20: outputPai[j] = "sou3.gif"; break;
                case 21: outputPai[j] = "sou4.gif"; break;
                case 22: outputPai[j] = "sou5.gif"; break;
                case 23: outputPai[j] = "sou6.gif"; break;
                case 24: outputPai[j] = "sou7.gif"; break;
                case 25: outputPai[j] = "sou8.gif"; break;
                case 26: outputPai[j] = "sou9.gif"; break;
                case 27: outputPai[j] = "ji1-ton.gif"; break;
                case 28: outputPai[j] = "ji2-nan.gif"; break;
                case 29: outputPai[j] = "ji3-sha.gif"; break;
                case 30: outputPai[j] = "ji4-pei.gif"; break;
                case 31: outputPai[j] = "ji5-haku.gif"; break;
                case 32: outputPai[j] = "ji6-hatsu.gif"; break;
                case 33: outputPai[j] = "ji7-chun.gif"; break;
            }
        } else {
            full = "入力がいっぱいです。";
        }
    }
    
    //入力された牌姿を初期化する
    public void reset() {
        for(int i = 0; i < pai.length; i++) {
            pai[i] = 0;
        }
        
        for(int i = 0; i < outputPai.length; i++) {
            outputPai[i] = "blank.png";
        }
        
        for(int i = 0; i < paisi.length; i++) {
            for(int j = 0; j < paisi[i].length; j++) {
                paisi[i][j] = -1;
                paisiGa[i][j] = "blank.png";
            }
        }
        
        for(int i = 0; i < yakuName.length; i++) {
            yakuName[i] = " ";
        }
        
        full = "入力してください。";
        kekka = "あがっていません。";
        paiNum = 1;
    }
    
    // アガリが成立したかどうかを判定する
    public void howAgari() {
        System.out.println("探索開始");
        
        Integer agari = 0;  //アガリを判定する変数、１はあがり確定、－１はアガリ不成立確定
        
        // 牌姿をマンズ、ピンズ、ソウズ、字牌に分類する
        Integer[] man = new Integer[9];
        Integer[] pin = new Integer[9];
        Integer[] sou = new Integer[9];
        Integer[] ji = new Integer[7];
        
        Integer jiHead = 0;  //字牌にヘッドがあるか判別
        Integer jiNum = -1;  //字牌にヘッドがある場合その場所を入れる
        Integer[] jiPai = {-1, -1, -1, -1};   // 字牌に刻子がある場合は登録だけしておき、最後にpaisiに入れる
        Integer jiPaiNum = 0;  //字牌刻子の数
        
        // 色別に分類
        for(int i = 0; i < 9; i++) {
            man[i] = pai[i];   manzu[i] = pai[i];
            pin[i] = pai[i + 9];  pinzu[i] = pai[i + 9];
            sou[i] = pai[i + 18]; souzu[i] = pai[i + 18];
        }
        
        
        
        // 字牌を作る、ヘッドがただひとつなら確定、また字牌に0or2or3牌からなる部分があればあがり不成立
        for(int i = 0; i < 7; i++) {
            ji[i] = pai[i + 27];
            tupai[i] = pai[i + 27];
            if(pai[i + 27] == 2) {
                jiHead++; jiNum = i + 27;
            } else if(pai[i + 27] != 3 && pai[i + 27] != 0) {
                agari = -1;
            }
            
            if(pai[i + 27] == 3) {
                jiPai[jiPaiNum] = i + 27;
                jiPaiNum++;
            }
        }
        if(jiHead >=2) { agari = -1; }
        
        Integer now = 1;
        //まだアガリが否定されていなければ、ヘッドの候補を引いて、mentsuを使ってあがり判定とpaisiの構成をしていく
        if(agari == 0) {
            if(jiHead == 1) {
                System.out.println("字ヘッド確定");
                paisi[0][0] = jiNum; paisi[0][1] = jiNum;
                Integer[] ans = mentsu(man, 0, 1);
                if(ans[0] != -1) {
                    System.out.println("最初の返り血は" + ans[1]);
                    Integer[] ans2 = mentsu(pin, 9, ans[1]);
                    if(ans2[0] != -1) {
                        System.out.println("次の返り血は" + ans2[1]);
                        Integer[] ans3 = mentsu(sou, 18, ans2[1]);
                        if(ans3[0] != -1) {
                            agari = 1;
                            now = ans3[1];
                        }
                    }
                }
            } else {
                for(int i = 0; i < 9; i++) {
                    if(agari != 1) {
                        if(man[i] >= 2) {
                            man[i] -= 2;
                            System.out.println("マンズ探索：ヘッド :" + i);
                            paisi[0][0] = i; paisi[0][1] = i;
                            if(mentsu(man, 0, 1)[0] != -1) {
                                Integer x = mentsu(man, 0, 1)[1];
                                if(mentsu(pin, 9, x)[0] != -1) {
                                    Integer y = mentsu(pin, 9, x)[1];
                                    if(mentsu(sou, 18, y)[0] != -1) {
                                        agari = 1;
                                        now = mentsu(sou, 18, y)[1];
                                    }
                                }
                            }
                            man[i] += 2;
                        }
                    }
                    if(agari != 1) {
                        if(pin[i] >= 2) {
                            pin[i] -= 2;
                            System.out.println("ピンズ探索：ヘッド :" + (i + 9));
                            paisi[0][0] = i + 9; paisi[0][1] = i + 9;
                            if(mentsu(man, 0, 1)[0] != -1) {
                                Integer x = mentsu(man, 0, 1)[1];
                                if(mentsu(pin, 9, x)[0] != -1) {
                                    Integer y = mentsu(pin, 9, x)[1];
                                    if(mentsu(sou, 18, y)[0] != -1) {
                                        agari = 1;
                                        now = mentsu(sou, 18, y)[1];
                                    }
                                }
                            }
                            pin[i] += 2;
                        }
                    }
                    if(agari != 1) {
                        if(sou[i] >= 2) {
                            sou[i] -= 2;
                            System.out.println("ソウズ探索：ヘッド :" + (i + 18));
                            paisi[0][0] = i + 18; paisi[0][1] = i + 18;
                            if(mentsu(man, 0, 1)[0] != -1) {
                                Integer x = mentsu(man, 0, 1)[1];
                                if(mentsu(pin, 9, x)[0] != -1) {
                                    Integer y = mentsu(pin, 9, x)[1];
                                    if(mentsu(sou, 18, y)[0] != -1) {
                                        agari = 1;
                                        now = mentsu(sou, 18, y)[1];
                                    }
                                }
                            }
                            sou[i] += 2;
                        }
                    }
                }
            }
        }
        
        if(agari == 1) {
            kekka = "あがっています。";
            howPaisi = 0;
            
            for(int i = 0; i < jiPaiNum; i++) {
                paisi[now][0] = jiPai[i];
                paisi[now][1] = jiPai[i];
                paisi[now][2] = jiPai[i];
                now++;
            }
            
            // 出力、役判定ようの牌姿並べ替え
            Integer n1, n2, n3;
            for(int i = 1; i < 4; i++) {
                for(int j = i + 1; j < 5; j++) {
                    if(paisi[i][0] > paisi[j][0]) {
                        n1 = paisi[i][0];  n2 = paisi[i][1];  n3 = paisi[i][2];
                        paisi[i][0] = paisi[j][0]; paisi[i][1] = paisi[j][1]; paisi[i][2] = paisi[j][2];
                        paisi[j][0] = n1;  paisi[j][1] = n1;  paisi[j][2] = n1;
                    }
                }
            }
            
            System.out.println("paisiの値");
            for(int i = 0; i < paisi.length; i++) {
                for(int j = 0; j < paisi[i].length; j++) {
                    if(i != 0 || j != 2) {
                        System.out.println(paisi[i][j]);
                        switch(paisi[i][j]) {
                            case -1 : paisiGa[i][j] = "blank.png"; break;
                            case 0: paisiGa[i][j] = "man1.gif"; break;
                            case 1: paisiGa[i][j] = "man2.gif"; break;
                            case 2: paisiGa[i][j] = "man3.gif"; break;
                            case 3: paisiGa[i][j] = "man4.gif"; break;
                            case 4: paisiGa[i][j] = "man5.gif"; break;
                            case 5: paisiGa[i][j] = "man6.gif"; break;
                            case 6: paisiGa[i][j] = "man7.gif"; break;
                            case 7: paisiGa[i][j] = "man8.gif"; break;
                            case 8: paisiGa[i][j] = "man9.gif"; break;
                            case 9: paisiGa[i][j] = "pin1.gif"; break;
                            case 10: paisiGa[i][j] = "pin2.gif"; break;
                            case 11: paisiGa[i][j] = "pin3.gif"; break;
                            case 12: paisiGa[i][j] = "pin4.gif"; break;
                            case 13: paisiGa[i][j] = "pin5.gif"; break;
                            case 14: paisiGa[i][j] = "pin6.gif"; break;
                            case 15: paisiGa[i][j] = "pin7.gif"; break;
                            case 16: paisiGa[i][j] = "pin8.gif"; break;
                            case 17: paisiGa[i][j] = "pin9.gif"; break;
                            case 18: paisiGa[i][j] = "sou1.gif"; break;
                            case 19: paisiGa[i][j] = "sou2.gif"; break;
                            case 20: paisiGa[i][j] = "sou3.gif"; break;
                            case 21: paisiGa[i][j] = "sou4.gif"; break;
                            case 22: paisiGa[i][j] = "sou5.gif"; break;
                            case 23: paisiGa[i][j] = "sou6.gif"; break;
                            case 24: paisiGa[i][j] = "sou7.gif"; break;
                            case 25: paisiGa[i][j] = "sou8.gif"; break;
                            case 26: paisiGa[i][j] = "sou9.gif"; break;
                            case 27: paisiGa[i][j] = "ji1-ton.gif"; break;
                            case 28: paisiGa[i][j] = "ji2-nan.gif"; break;
                            case 29: paisiGa[i][j] = "ji3-sha.gif"; break;
                            case 30: paisiGa[i][j] = "ji4-pei.gif"; break;
                            case 31: paisiGa[i][j] = "ji5-haku.gif"; break;
                            case 32: paisiGa[i][j] = "ji6-hatsu.gif"; break;
                            case 33: paisiGa[i][j] = "ji7-chun.gif"; break;
                        }
                    }
                }
                System.out.println("次の面子");
            }
            yakus();
        } else {
            kekka = "あがっていません。";
        }
        
    }
    
    // ヘッドを除いた牌姿からアガリが４面子を作れるか判定する
    // mentsu の中では刻子と順子で分けて刻子の取り方で場合わけをする
    // 作れていなければー１を返す
    // 引数は色牌ごとの配列とその色牌を指定する数と今使っているpaisiの要素の数
    public Integer[] mentsu(Integer[] a, Integer iro, Integer pais) {
        Integer mentsu = -1;  //面子を作れるか判定した返り値
        Integer[] rtn = {-1, 0};
        
        Integer[] anko = {-1, -1, -1, -1}; // 刻子を入れる配列（最大４個）、初期値ー１
        Integer ankoNum = 0;   //刻子の数
        
        Integer[] b = new Integer[9];
        for(int i = 0; i < 9; i++) {
            b[i] = a[i];
        }
        
        // 刻子を数える
        for(int i = 0; i < b.length; i++) {
            if(b[i] >= 3) {
                anko[ankoNum] = i;
                ankoNum++;
            }
        }
        System.out.println("刻子は : " + ankoNum + "個あります。");
        System.out.println("場所は : " + anko[0] + " : " + anko[1] + " : " + anko[2] + " : " + anko[3]);
        System.out.println("入力は");
        System.out.println(a[0] + " ; " + a[1] + " ; " + a[2] + " ; " + a[3] + " ; " + a[4] + " ; " + a[5] + " ; " + a[6] +  " ; " + a[7] + " ; " + a[8]);
        
        // 刻子の数で場合わけをして、それぞれ順子成立の判定をするメソッドに送る
        // 順子も成立した場合、 paisi に入れて牌姿を確定させる
        if(ankoNum == 0) {
            if(shun(b, iro, pais)[0] == 0) {
                mentsu = 0;
                System.out.println("０刻子成功");
                pais = shun(b, iro, pais)[2];
            }
        } else if(ankoNum == 1) {
            while(mentsu != 0) {
                if(shun(b, iro, pais)[0] == 0) {
                    System.out.println("１刻子、１順子成功");
                    pais = shun(b, iro, pais)[2];
                    mentsu = 0; break;
                }
                b[anko[0]] -= 3;
                if(shun(b, iro, pais)[0] == 0) {
                    System.out.println("１刻子、１刻子成功");
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[0] + iro;
                    pais = shun(b, iro, pais)[2] + 1;
                    break;
                }
                System.out.println("１刻子失敗");
                break;
            }
        } else if(ankoNum == 2) {
            while(mentsu != 0) {
                Integer[] xyz = shun(b, iro, pais);
                if(xyz[0] == 0) {
                    System.out.println("２刻子、２順子成功");
                    pais = xyz[2];
                    mentsu = 0; break;
                }
                b[anko[0]] -= 3;
                Integer[] xyz1 = shun(b, iro, pais);
                if(xyz1[0] == 0) {
                    System.out.println("２刻子で、１刻子１順子成功");
                    mentsu = 0;
                    paisi[xyz1[2]][0] = anko[0] + iro;
                    paisi[xyz1[2]][1] = anko[0] + iro;
                    paisi[xyz1[2]][2] = anko[0] + iro;
                    pais = xyz1[2] + 1;
                    break;
                }
                b[anko[1]] -= 3;
                Integer[] xyz2 = shun(b, iro, pais);
                if(xyz2[0] == 0) {
                    mentsu = 0;
                    paisi[xyz2[2]][0] = anko[0] + iro;
                    paisi[xyz2[2]][1] = anko[0] + iro;
                    paisi[xyz2[2]][2] = anko[0] + iro;
                    paisi[xyz2[2] + 1][0] = anko[1] + iro;
                    paisi[xyz2[2] + 1][1] = anko[1] + iro;
                    paisi[xyz2[2] + 1][2] = anko[1] + iro;
                    System.out.println("入力成功時の返り血" + paisi[xyz2[2]][0] + " " + paisi[xyz2[2]][1] + " " + paisi[xyz2[2]][2] + " " + paisi[xyz2[2]][0] + " "  + paisi[xyz2[2]][0] + " " + paisi[xyz2[2]][2]);
                    pais = xyz2[2] + 2;
                    break;
                }
                b[anko[0]] += 3;
                if(shun(b, iro, pais)[0] == 0) {
                    System.out.println("２刻子で、１刻子１順子成功");
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[1] + iro;
                    pais = shun(b, iro, pais)[2] + 1;
                    break;
                }
                System.out.println("２刻子失敗");
                break;
            } 
        } else if(ankoNum == 3) {
            while(mentsu != 0) {
                if(shun(b, iro, pais)[0] == 0) {
                    pais = shun(b, iro, pais)[2];
                    mentsu = 0; break;
                }
                b[anko[0]] -= 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[0] + iro;
                    break;
                }
                b[anko[1]] -= 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][0] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][1] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][2] = anko[1] + iro;
                    break;
                }
                b[anko[0]] += 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[1] + iro;
                    break;
                }
                b[anko[2]] -= 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][0] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][1] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][2] = anko[1] + iro;
                    break;
                }
                b[anko[1]] += 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[1] + iro;
                    break;
                }
                b[anko[0]] -= 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][0] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][1] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][2] = anko[0] + iro;
                    break;
                }
                b[anko[1]] -= 3;
                if(shun(b, iro, pais)[0] == 0) {
                    mentsu = 0;
                    paisi[shun(b, iro, pais)[2]][0] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2]][1] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2]][2] = anko[2] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][0] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][1] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2] + 1][2] = anko[0] + iro;
                    paisi[shun(b, iro, pais)[2] + 2][0] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2] + 2][1] = anko[1] + iro;
                    paisi[shun(b, iro, pais)[2] + 2][2] = anko[1] + iro;
                    
                    break;
                }
                System.out.println("３刻子失敗");
                break;
            }
        }
        
        if(ankoNum == 4) {
            paisi[4][0] = anko[3]  + iro;
            paisi[4][1] = anko[3]  + iro;
            paisi[4][2] = anko[3]  + iro;
            paisi[3][0] = anko[0]  + iro;
            paisi[3][1] = anko[0]  + iro;
            paisi[3][2] = anko[0]  + iro;
            paisi[2][0] = anko[1]  + iro;
            paisi[2][1] = anko[1]  + iro;
            paisi[2][2] = anko[1]  + iro;
            paisi[1][0] = anko[2]  + iro;
            paisi[1][1] = anko[2]  + iro;
            paisi[1][2] = anko[2]  + iro;
            mentsu = 0;
        }
        rtn[0] = mentsu;
        rtn[1] = pais;
                
        return rtn;     
    }
    
    
    // 順子のみの候補からなる牌姿から順子のみを取り出せるか判定する
    // 引数は牌姿の配列とその色を判定する数
    // 返り値は順子のみから成立できたかをあらわす数（できたら０）と順子の数と今使っているpaisiの要素の数
    public Integer[] shun(Integer[] a, Integer iro, Integer pais) {
        Integer[] ans = {-1, 0, 0}; //返り値
        Integer x = pais;
        
        Integer[] b = new Integer[9];
        for(int i = 0; i < 9; i++) {
            b[i] = a[i];
        }
        ans[0] = zero(b);
        
        // 牌が存在するたびに３連続の順子として引いて、
        // 引いた部分を paisi にいれ、順子の数も増やす
        if(ans[0] != 0) {
            for(int i = 0; i < b.length - 2; i++) {
                while(b[i] > 0) {
                    b[i]--; b[i + 1]--; b[i + 2]--;
                    ans[1]++;
                    if(x < 5) {
                        paisi[x][0] = i + iro;
                        paisi[x][1] = i + 1 + iro;
                        paisi[x][2] = i + 2 + iro;
                    }
                    x++;
                }
            }
            ans[0] = zero(b);
            if(ans[0] != 0) {
                ans[2] = pais;
            } else {
                ans[2] = x;
            }
        } else {
            ans[2] = pais;
        }
        System.out.println("ans[0]の値 : " + ans[0]);
        System.out.println("ans[1]の値 : " + ans[1]);
        System.out.println("ans[2]の値 : " + ans[2]);
        return ans;
    }
    
    // ヘッド、順子、刻子全てを除いた配列を引数にとる
    // 配列の全ての値が０ならアガリが成立している
    // 返り値は上がり成立なら０そうでないならー１
    public Integer zero(Integer[] a) {
        Integer ans = 0;
        
        for(int i = 0; i < a.length; i++) {
            if(a[i] != 0) {
                ans = -1;
            }
        }
        
        return ans;
    }
    
    // class yaku を使ってあがり役の判定を行う
    public void yakus() {
        Yaku yaku = new Yaku(paisi[1], paisi[2], paisi[3], paisi[4], paisi[0][0], manzu, pinzu, souzu, tupai, pai);
        String[][] yakuS = yaku.Check();
        
        Integer x = 0;
        for(int i = 0; i < yakuS.length; i++) {
            if(!(yakuS[i][1].equals("0"))) {
                yakuName[x] = yakuS[i][0] + " : " + yakuS[i][1];
                x++;
            }
        }
    }

    public Integer[][] getPaisi() {
        return paisi;
    }

    public void setPaisi(Integer[][] paisi) {
        this.paisi = paisi;
    }
    
    public Integer[] getPai() {
        return pai;
    }

    public void setPai(Integer[] pai) {
        this.pai = pai;
    }

    public String[] getOutputPai() {
        return outputPai;
    }

    public void setOutputPai(String[] outputPai) {
        this.outputPai = outputPai;
    }
    
     public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
    
    public String getKekka() {
        return kekka;
    }

    public void setKekka(String kekka) {
        this.kekka = kekka;
    }
    
    public String[][] getPaisiGa() {
        return paisiGa;
    }

    public void setPaisiGa(String[][] paisiGa) {
        this.paisiGa = paisiGa;
    }
    
    public String[] getYakuName() {
        return yakuName;
    }

    public void setYakuName(String[] yakuName) {
        this.yakuName = yakuName;
    }
}
