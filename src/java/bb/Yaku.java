package bb;


public class Yaku {
    Integer[] yaku = new Integer[49];
    private Integer[] men1 = new Integer[3];
    private Integer[] men2 = new Integer[3];
    private Integer[] men3 = new Integer[3];
    private Integer[] men4 = new Integer[3];
    private Integer head;
    private Integer[] m = new Integer[9];
    private Integer[] p = new Integer[9];
    private Integer[] s = new Integer[9];
    private Integer[] j = new Integer[7];
    private Integer[] all = new Integer[34];
    
    Yaku(Integer[] m1, Integer[] m2, Integer[] m3, Integer[] m4, Integer h, Integer[] a, Integer[] b, Integer[] c, Integer[] d, Integer[] e) {
        for(int i = 0; i < yaku.length; i++) {
            yaku[i] = 0;
        }
        for(int i = 0; i < a.length; i++) {
            m[i] = a[i];
            p[i] = b[i];
            s[i] = c[i];
        }
        for(int i = 0; i < d.length; i++) {
            j[i] = d[i];
        }
        for(int i = 0; i < e.length; i++) {
            all[i] = e[i];
        }
        for(int i = 0; i < m1.length; i++) {
            men1[i] = m1[i];
            men2[i] = m2[i];
            men3[i] = m3[i];
            men4[i] = m4[i];
        }
        head = h;
    }
    
    public String[][] Check() {
        String[][] y = new String[49][2];
        y[0][0] = "大四喜";
        y[1][0] = "大三元";
        y[2][0] = "緑一色";
        y[3][0] = "清么九";
        y[4][0] = "小喜四";
        y[5][0] = "小三元";
        y[6][0] = "字一色";
        y[7][0] = "一色双龍会";
        y[8][0] = "一色四同順";
        y[9][0] = "一色四節高";
        y[10][0] = "一色四歩高";
        y[11][0] = "混么九";
        y[12][0] = "全双刻";
        y[13][0] = "清一";
        y[14][0] = "一色三同順";
        y[15][0] = "一色三節高";
        y[16][0] = "全大";
        y[17][0] = "全中";
        y[18][0] = "全小";
        y[19][0] = "清龍";
        y[20][0] = "三色双龍会";
        y[21][0] = "一色三歩高";
        y[22][0] = "全帯五";
        y[23][0] = "三同刻";
        y[24][0] = "大于五";
        y[25][0] = "小于五";
        y[26][0] = "三風刻";
        y[27][0] = "花龍";
        y[28][0] = "推不倒";
        y[29][0] = "三色三同順";
        y[30][0] = "三色三節高";
        y[31][0] = "碰碰和";
        y[32][0] = "混一色";
        y[33][0] = "三色三歩高";
        y[34][0] = "五門斉";
        y[35][0] = "双箭刻";
        y[36][0] = "全帯么";
        y[37][0] = "箭刻";
        y[38][0] = "平和";
        y[39][0] = "四帰一";
        y[40][0] = "断么";
        y[41][0] = "双同刻";
        y[42][0] = "一般高";
        y[43][0] = "喜相逢";
        y[44][0] = "連六";
        y[45][0] = "老少副";
        y[46][0] = "么九刻";
        y[47][0] = "缺一門";
        y[48][0] = "無字";
        
        Daisusi();  Daisangen(); Ryuiso(); Tinyao(); Shosusi(); Shosangen(); Tsuiso(); Isoshan(); Isosuton(); Isosuche(); Isosupu(); Hunyao(); Chenshan(); Tinitu();
        Isosanton(); Isosanche(); Chenta(); Chenchun(); Chenshao(); Tinron(); Sansoshan(); Isosampu(); Chentaiu(); Santonku(); Tayu(); Shaoyu(); Sanfonku(); Faron(); Toiputao();
        Sansosanton(); Sansosanche(); Ponponhu(); Huniso(); Sansosanpu(); Umenti(); Shanchenk(); Chanta(); Chenk(); Pinhu(); Sukui(); Tanyao(); Shantonku(); Ipankao();
        Sishanfon(); Renryu(); Raoshaohu(); Yaochu(); Cheimen(); Uzu();
        
        for(int i = 0; i < yaku.length; i++) {
            if(yaku[i] > 0) {
                y[i][1] = String.valueOf(yaku[i]);
            } else {
                y[i][1] = String.valueOf(0);
            }
        }
        
        return y;
    }
    
    public void Daisusi() {
        if(yaku[0] != -1) {
            if(all[27] >= 3 && all[28] >= 3 && all[29] >= 3 && all[30] >= 3) {
                yaku[0] = 1; yaku[4] = -1; yaku[26] = -1; yaku[31] = -1; yaku[46] = -1;
            } else {
                yaku[0] = -1;
            }
        }
    }
    
    public void Daisangen() {
        if(yaku[1] != -1) {
            if(all[31] >= 3 && all[32] >= 3 && all[33] >= 3) {
                yaku[1] = 1; yaku[5] = -1; yaku[35] = -1; yaku[37] = -1;
            } else {
                yaku[1] = -1;
            }
        }
    }
    
    public void Ryuiso() {
        Integer x = 0;
        for(int i = 0; i < m.length; i++) {
            if(m[i] >= 1 || p[i] >= 1) {
                x++;
            }
        }
        if(s[0] != 0 || s[4] != 0 || s[6] != 0 || s[8] != 0 ) {
            x++;
        }
        if(j[0] != 0 || j[1] != 0 || j[2] != 0 || j[3] != 0 || j[4] != 0 || j[6] != 0) {
            x++;
        }
        if(x == 0 && yaku[2] != -1) {
            yaku[2] = 1; yaku[32] = -1;
        }
    }
    
    public void Tinyao() {
        Integer x = 0;
        for(int i = 1; i < m.length - 1; i++) {
            if(m[i] != 0 || s[i] != 0 || p[i] != 0) {
                x++;
            }
        }
        for(int i = 1; i < j.length; i++) {
            if(j[i] != 0) {
                x++;
            }
        }
        if(x == 0 && yaku[3] != -1) {
            yaku[3] = 1; yaku[31] = -1; yaku[36] = -1; yaku[46] = -1; yaku[48] = -1;
        }
    }
    
    public void Shosusi() {
        if(all[27] > 0 && all[28] > 0 && all[29] > 0 && all[30] > 0) {
            if(yaku[4] != -1) {
                yaku[4] = 1; yaku[26] = -1;
            }
        }
    }
    
    public void Shosangen() {
        if(all[31] > 0 && all[32] > 0 && all[33] > 0) {
            if(yaku[5] != -1) {
                yaku[5] = 1; yaku[35] = -1; yaku[37] = -1;
            }
        }
    }
    
    public void Tsuiso() {
        Integer x = 0;
        for(int i = 0; i < m.length; i++) {
            if(m[i] != 0 || p[i] != 0 || s[i] != 0) {
                x++;
            }
        }
        if(x == 0 && yaku[6] != -1) {
            yaku[6] = 1; yaku[31] = -1; yaku[36] = -1; yaku[46] = -1;
        }
    }
    
    public void Isoshan() {
        Integer x = -1;
        if((m[0] == 2 && m[1] == 2 && m[2] == 2 && m[4] == 2 && m[6] == 2 && m[7] == 2 && m[8] == 2) ||
           (p[0] == 2 && p[1] == 2 && p[2] == 2 && p[4] == 2 && p[6] == 2 && p[7] == 2 && p[8] == 2) ||
           (s[0] == 2 && s[1] == 2 && s[2] == 2 && s[4] == 2 && s[6] == 2 && s[7] == 2 && s[8] == 2)) {
            if(yaku[7] != -1) {
                yaku[7] = 1; yaku[13] = -1; yaku[38] = -1; yaku[42] = -1; yaku[45] = -1; yaku[48] = -1;
            }
        }
    }
    
    public void Isosuton() {
        if((men1[0] - men2[0] == 0) && (men2[0] - men3[0] == 0) && (men3[0] - men4[0] == 0)) {
            if(yaku[8] != -1) {
                yaku[8] = 1; yaku[14] = -1; yaku[39] = -1; yaku[42] = -1;
            }
        }
    }
    
    public void Isosuche() {
        if(men4[0] < 27) {
            if(men1[0] - men1[1] == 0 && men2[0] - men2[1] == 0 && men3[0] - men3[1] == 0 && men4[0] - men4[1] == 0) {
                if(men1[0] - men2[0] == -1 && men2[0] - men3[0] == -1 && men3[0] - men4[0] == -1) {
                    if(yaku[9] != -1) {
                        yaku[9] = 1; yaku[15] = -1; yaku[31] = -1;
                    }
                }
            }
        }
    }
    
    public void Isosupu() {
        if(men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1){
            if((men1[0] - men2[0] == -1 && men2[0] - men3[0] == -1 && men3[0] - men4[0] == -1) ||
               (men1[0] - men2[0] == -2 && men2[0] - men3[0] == -2 && men3[0] - men4[0] == -2)) {
                if(yaku[10] != -1) {
                    yaku[10] = 1; yaku[21] = -1; yaku[44] = -1; yaku[45] = -1;
                }
            }
        }
    }
    
    public void Hunyao() {
        Integer x = 0;
        for(int i = 1; i < m.length - 1; i++) {
            if(m[i] != 0 || s[i] != 0 || p[i] != 0) {
                x++;
            }
        }
        if(x == 0 && yaku[11] != -1) {
            yaku[11] = 1; yaku[31] = -1; yaku[36] = -1; yaku[46] = -1;
        }
    }
    
    public void Chenshan() {
        Integer x = 0;
        for(int i = 0; i < 4; i++) {
            if(m[i * 2] > 0 || p[i * 2] > 0 || s[i * 2] > 0) {
                x++;
            }
        }
        for(int i = 0; i < j.length; i++) {
            if(j[i] > 0) {
                x++;
            }
        }
        if(x == 0 && yaku[12] != -1) {
            yaku[12] = 1; yaku[31] = -1; yaku[40] = -1; yaku[48] = -1;
        }
    }
    
    public void Tinitu() {
        Integer mNum = 0;
        Integer pNum = 0;
        Integer sNum = 0;
        Integer jNum = 0;
        for(int i = 0; i < m.length; i++) {
            mNum += m[i]; pNum+= p[i]; sNum += s[i];
        }
        for(int i = 0; i < j.length; i++) {
            jNum += j[i];
        }
        if(jNum == 0 && ((mNum == 0 && pNum == 0) || (mNum == 0 && sNum == 0) || (pNum == 0 && sNum == 0))) {
            if(yaku[13] != -1) {
                yaku[13] = 1; yaku[48] = -1;
            }
        }
    }
    
    public void Isosanton() {
        if(((men1[0] - men2[0] == 0) && (men2[0] - men3[0] == 0)) || ((men2[0] - men3[0] == 0) && (men3[0] - men4[0] == 0))) {
            if(yaku[14] != -1) {
                yaku[14] = 1; yaku[42] = -1;
            }
        }
    }
    
    public void Isosanche() {
        Integer x = 0;
        for(int i = 0; i < 25; i++) {
            if(all[i] >= 3) {
                if(all[i + 1] >= 3 && all[i + 2] >= 3) {
                    x = 1;
                }
            }
        }
        if(x == 1 && yaku[15] != -1) {
            yaku[15] = 1; 
        }
    }
    
    public void Chenta() {
        Integer x = 0;
        for(int i = 0; i < 6; i++) {
            if(m[i] > 0 || p[i] > 0 || s[i] > 0) {
                x++;
            }
        }
        for(int i = 0; i < 7; i++) {
            if(j[i] > 0 ) {
                x++;
            }
        }
        if(x == 0 && yaku[16] != -1) {
            yaku[16] = 1; yaku[24] = -1; yaku[48] = -1;
        }
    }
    
    public void Chenchun() {
        Integer x = 0;
        for(int i = 0; i < 3; i++) {
            if(m[i] > 0 || m[i + 6] > 0 || p[i] > 0 || p[i + 6] > 0 || s[i] > 0 || s[i + 6] > 0) {
                x++;
            }
        }
        for(int i = 0; i < 7; i++) {
            if(j[i] > 0 ) {
                x++;
            }
        }
        if(x == 0 && yaku[17] != -1) {
            yaku[17] = 1; yaku[40] = -1; yaku[48] = -1;
        }
    }
    
    public void Chenshao() {
        Integer x = 0;
        for(int i = 3; i < m.length; i++) {
            if(m[i] > 0 || p[i] > 0 || s[i] > 0) {
                x++;
            }
        }
        for(int i = 0; i < 7; i++) {
            if(j[i] > 0 ) {
                x++;
            }
        }
        if(x == 0 && yaku[18] != -1) {
            yaku[18] = 1; yaku[25] = -1; yaku[48] = -1;
        }
    }
    
    public void Tinron() {
        Integer x = -1;
        for(int i = 0; i < 3; i++) {
            if((men1[0] == 9 * i && men1[1] == 1 + 9 * i && men2[0] == 3 + 9 * i && men2[1] == 4 + 9 * i && men3[0] == 6 + 9 * i && men3[1] == 7 + 9 * i) ||
               (men1[0] == 9 * i && men1[1] == 1 + 9 * i && men2[0] == 3 + 9 * i && men2[1] == 4 + 9 * i && men4[0] == 6 + 9 * i && men4[1] == 7 + 9 * i) ||
               (men1[0] == 9 * i && men1[1] == 1 + 9 * i && men3[0] == 3 + 9 * i && men3[1] == 4 + 9 * i && men4[0] == 6 + 9 * i && men4[1] == 7 + 9 * i) ||
               (men2[0] == 9 * i && men2[1] == 1 + 9 * i && men3[0] == 3 + 9 * i && men3[1] == 4 + 9 * i && men4[0] == 6 + 9 * i && men4[1] == 7 + 9 * i)) {
                x = 0;
            }
        }
        if(x == 0 && yaku[19] != -1) {
            yaku[19] = 1; yaku[44] = -1; yaku[45] = -1;
        }
    }
    
    public void Sansoshan() {
        if((all[4] == 2 && all[9] * all[10] * all[11] * all[15] * all[16] * all[17] * all[18] * all[19] * all[20] * all[24] * all[25] * all[26] == 1) ||
           (all[13] == 2 && all[0] * all[1] * all[2] * all[6] * all[7] * all[8] * all[18] * all[19] * all[20] * all[24] * all[25] * all[26] == 1) ||
           (all[22] == 2 && all[0] * all[1] * all[2] * all[6] * all[7] * all[8] * all[9] * all[10] * all[11] * all[15] * all[16] * all[17] == 1)) {
            if(yaku[20] != -1) {
                yaku[20] = 1; yaku[38] = -1; yaku[42] = -1; yaku[45] = -1; yaku[48] = -1;
            }
        }
    }
    
    public void Isosampu() {
        if((men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men1[0] - men2[0] == -1 && men2[0] - men3[0] == -1) ||
           (men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men1[0] - men2[0] == -2 && men2[0] - men3[0] == -2) ||
           (men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men2[0] == -1 && men2[0] - men4[0] == -1) ||
           (men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men2[0] == -2 && men2[0] - men4[0] == -2) ||
           (men1[0] - men1[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men3[0] == -1 && men3[0] - men4[0] == -1) ||
           (men1[0] - men1[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men3[0] == -2 && men3[0] - men4[0] == -2) ||
           (men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men3[0] == -1 && men3[0] - men4[0] == -1) ||
           (men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men3[0] == -2 && men3[0] - men4[0] == -2)) {
            if(yaku[21] != -1) {
                yaku[21] = 1;
            }
        }
    }
    
    public void Chentaiu() {
        Integer x = 0;
        if(head != 4 || head != 13 || head != 22) {
            x++;
        }
        if((men1[0] != 4 || men1[0] != 13 || men1[0] != 22) || (men1[1] != 4 || men1[1] != 13 || men1[1] != 22) || (men1[2] != 4 || men1[2] != 13 || men1[2] != 22)) {
            x++;
        }
        if((men2[0] != 4 || men2[0] != 13 || men2[0] != 22) || (men2[1] != 4 || men2[1] != 13 || men2[1] != 22) || (men2[2] != 4 || men2[2] != 13 || men2[2] != 22)) {
            x++;
        }
        if((men3[0] != 4 || men3[0] != 13 || men3[0] != 22) || (men3[1] != 4 || men3[1] != 13 || men3[1] != 22) || (men3[2] != 4 || men3[2] != 13 || men3[2] != 22)) {
            x++;
        }
        if((men4[0] != 4 || men4[0] != 13 || men4[0] != 22) || (men4[1] != 4 || men4[1] != 13 || men4[1] != 22) || (men4[2] != 4 || men4[2] != 13 || men4[2] != 22)) {
            x++;
        }
        if(x == 0 && yaku[22] != -1) {
            yaku[22] = 1; yaku[40] = -1;
        }
    }
    
    public void Santonku() {
       if((men1[0] - men1[1] == 0 && men2[0] - men2[1] == 0 && men3[0] - men3[1] == 0 && men1[0] - men2[0] == -9 && men2[0] - men3[0] == -9) ||
          (men1[0] - men1[1] == 0 && men2[0] - men2[1] == 0 && men4[0] - men4[1] == 0 && men1[0] - men2[0] == -9 && men2[0] - men4[0] == -9) ||
          (men1[0] - men1[1] == 0 && men3[0] - men3[1] == 0 && men4[0] - men4[1] == 0 && men1[0] - men3[0] == -9 && men3[0] - men4[0] == -9) ||
          (men2[0] - men2[1] == 0 && men3[0] - men3[1] == 0 && men4[0] - men4[1] == 0 && men2[0] - men3[0] == -9 && men3[0] - men4[0] == -9)) {    
            if(yaku[23] != -1) {
                yaku[23] = 1; yaku[41] = -1;
            }
        }
    }
    
    public void Tayu() {
        Integer x = 0;
        for(int i = 0; i < 5; i++) {
            if(m[i] > 0 || p[i] > 0 || s[i] > 0) {
                x++;
            }
        }
        for(int i = 0; i < j.length; i++) {
            if(j[i] > 0) {
                x++;
            }
        }
        if(x == 0 && yaku[24] != -1) {
            yaku[24] = 1; yaku[48] = -1;
        }
    }
    
    public void Shaoyu() {
        Integer x = 0;
        for(int i = 4; i < m.length; i++) {
            if(m[i] > 0 || p[i] > 0 || s[i] > 0) {
                x++;
            }
        }
        for(int i = 0; i < j.length; i++) {
            if(j[i] > 0) {
                x++;
            }
        }
        if(x == 0 && yaku[25] != -1) {
            yaku[25] = 1; yaku[48] = -1;
        }
    }
    
    public void Sanfonku() {
        if((all[27] >= 3 && all[28] >= 3 && all[29] >= 3) ||
           (all[27] >= 3 && all[28] >= 3 && all[30] >= 3) ||
           (all[28] >= 3 && all[29] >= 3 && all[30] >= 3) ||
           (all[27] >= 3 && all[29] >= 3 && all[30] >= 3) ) {
            if(yaku[26] != -1) {
                yaku[26] = 1; 
            }
        }
    }
    
    public void Faron() {
        System.out.println("きた");
        System.out.println(men2[0] + " " + men2[1] + " " + men3[0] + " " + men3[1] + " " + men4[0] + " " + men4[1]);
        Integer x = -1;
        if(men1[0] == 0 && men1[1] == 1) {
            if((men2[0] == 12 && men2[1] == 13 && men3[0] == 24 && men3[1] == 25) ||
               (men2[0] == 15 && men2[1] == 16 && men3[0] == 21 && men3[1] == 22) ||
               (men2[0] == 12 && men2[1] == 13 && men4[0] == 24 && men4[1] == 25) ||
               (men2[0] == 15 && men2[1] == 16 && men4[0] == 21 && men4[1] == 22) ||
               (men3[0] == 12 && men3[1] == 13 && men4[0] == 24 && men4[1] == 25) ||
               (men3[0] == 15 && men3[1] == 16 && men4[0] == 21 && men4[1] == 22)) {
                x = 0;
            }        
        } else if(men1[0] == 3 && men1[1] == 4) {
            if((men2[0] == 9 && men2[1] == 10 && men3[0] == 24 && men3[1] == 25) ||
               (men2[0] == 15 && men2[1] == 16 && men3[0] == 18 && men3[1] == 19) ||
               (men2[0] == 9 && men2[1] == 10 && men4[0] == 24 && men4[1] == 25) ||
               (men2[0] == 15 && men2[1] == 16 && men4[0] == 18 && men4[1] == 19) ||
               (men3[0] == 9 && men3[1] == 10 && men4[0] == 24 && men4[1] == 25) ||
               (men3[0] == 15 && men3[1] == 16 && men4[0] == 18 && men4[1] == 19)) {
                x = 0;
            }  
        } else if(men1[0] == 6 && men1[1] == 7) {
            if((men2[0] == 9 && men2[1] == 10 && men3[0] == 21 && men3[1] == 22) ||
               (men2[0] == 12 && men2[1] == 13 && men3[0] == 18 && men3[1] == 19) ||
               (men2[0] == 9 && men2[1] == 10 && men4[0] == 21 && men4[1] == 22) ||
               (men2[0] == 12 && men2[1] == 13 && men4[0] == 18 && men4[1] == 19) ||
               (men3[0] == 9 && men3[1] == 10 && men4[0] == 21 && men4[1] == 22) ||
               (men3[0] == 12 && men3[1] == 13 && men4[0] == 18 && men4[1] == 19)) {
                x = 0;
            }
        }
        if(men2[0] == 0 && men2[1] == 1) {
            if((men3[0] == 12 && men3[1] == 13 && men4[0] == 24 && men4[1] == 25) ||
               (men3[0] == 15 && men3[1] == 16 && men4[0] == 21 && men4[1] == 22)) {
                x = 0;
            }
        } else if(men2[0] == 3 && men2[1] == 4) {
            if((men3[0] == 9 && men3[1] == 10 && men4[0] == 24 && men4[1] == 25) ||
               (men3[0] == 15 && men3[1] == 16 && men4[0] == 18 && men4[1] == 19)) {
                x = 0;
            }
        } else if(men2[0] == 6 && men2[1] == 7) {
            if((men3[0] == 9 && men3[1] == 10 && men4[0] == 21 && men4[1] == 22) ||
               (men3[0] == 12 && men3[1] == 13 && men4[0] == 18 && men4[1] == 19)) {
                x = 0;
                System.out.println("ここ");
            }
        }
        
        System.out.println("x = " + x);
        if(x == 0 && yaku[27] != -1) {
            yaku[27] = 1;
        }
        System.out.println(yaku[27]);
    }
    
    public void Toiputao() {
        Integer x = 0;
        for(int i = 0; i < m.length; i++) {
            if(m[i] > 0) {
                x++;
            }
        }
        if(all[14] > 0 || all[15] > 0 || all[18] > 0 || all[20] > 0 || all[24] > 0 
                || all[27] > 0 || all[28] > 0 || all[29] > 0 || all[30] > 0 || all[32] > 0 || all[33] > 0 ){
            x++;
        }
        if(x == 0 && yaku[28] != -1) {
            yaku[28] = 1; yaku[47] = -1;
        }
    }
    
    public void Sansosanton() {
        if((men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men1[0] - men2[0] == -9 && men2[0] - men3[0] == -9) ||
           (men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men2[0] == -9 && men2[0] - men4[0] == -9) ||
           (men1[0] - men1[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1 && men1[0] - men3[0] == -9 && men3[0] - men4[0] == -9) ||
           (men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1 && men2[0] - men3[0] == -9 && men3[0] - men4[0] == -9)) {    
            if(yaku[29] != -1) {
                yaku[29] = 1; yaku[43] = -1;
            }
        }
    }
    
    public void Sansosanche() {
        Integer x = -1;
        
        if(men1[0] - men1[1] == 0 && men2[0] - men2[1] == 0 && men3[0] - men3[1] == 0) {
            if((men1[0] - men2[0] == -10 && men2[0] - men3[0] == -10) ||
               (men1[0] - men3[0] == -19 && men3[0] - men2[0] == 8) ||
               (men2[0] - men1[0] == 8 && men1[0] - men3[0] == -19) ||
               (men2[0] - men3[0] == -10 && men3[0] - men1[0] == 17) ||
               (men3[0] - men1[0] == 17 && men1[0] - men2[0] == -10) ||
               (men3[0] - men2[0] == 8 && men2[0] - men1[0] == 8)) {
                x = 0;
            }
        }
        if(men1[0] - men1[1] == 0 && men2[0] - men2[1] == 0 && men4[0] - men4[1] == 0) {
            if((men1[0] - men2[0] == -10 && men2[0] - men4[0] == -10) ||
               (men1[0] - men4[0] == -19 && men4[0] - men2[0] == 8) ||
               (men2[0] - men1[0] == 8 && men1[0] - men4[0] == -19) ||
               (men2[0] - men4[0] == -10 && men4[0] - men1[0] == 17) ||
               (men4[0] - men1[0] == 17 && men1[0] - men2[0] == -10) ||
               (men4[0] - men2[0] == 8 && men2[0] - men1[0] == 8)) {
                x = 0;
            }
        }
        if(men1[0] - men1[1] == 0 && men3[0] - men3[1] == 0 && men4[0] - men4[1] == 0) {
            if((men1[0] - men3[0] == -10 && men3[0] - men4[0] == -10) ||
               (men1[0] - men4[0] == -19 && men4[0] - men3[0] == 8) ||
               (men3[0] - men1[0] == 8 && men1[0] - men4[0] == -19) ||
               (men3[0] - men4[0] == -10 && men4[0] - men1[0] == 17) ||
               (men4[0] - men1[0] == 17 && men1[0] - men3[0] == -10) ||
               (men4[0] - men3[0] == 8 && men3[0] - men1[0] == 8)) {
                x = 0;
            }
        }
        if(men2[0] - men2[1] == 0 && men3[0] - men3[1] == 0 && men4[0] - men4[1] == 0) {
            if((men2[0] - men3[0] == -10 && men3[0] - men4[0] == -10) ||
               (men2[0] - men4[0] == -19 && men4[0] - men3[0] == 8) ||
               (men3[0] - men2[0] == 8 && men2[0] - men4[0] == -19) ||
               (men3[0] - men4[0] == -10 && men4[0] - men2[0] == 17) ||
               (men4[0] - men2[0] == 17 && men2[0] - men3[0] == -10) ||
               (men4[0] - men3[0] == 8 && men3[0] - men2[0] == 8)) {
                x = 0;
            }
        }
        if( x== 0 && yaku[30] != -1) {
            yaku[30] = 1;
        }
    }
    
    public void Ponponhu() {
        if((men1[0] - men1[1] == 0) && (men2[0] - men2[1] == 0) && (men3[0] - men3[1] == 0) && (men4[0] - men4[1] == 0)) {
            if(yaku[31] != -1) {
                yaku[31] = 1; 
            }
        }
    }
    
    public void Huniso() {
        Integer mNum = 0;
        Integer pNum = 0;
        Integer sNum = 0;
        Integer jNum = 0;
        for(int i = 0; i < m.length; i++) {
            mNum += m[i]; pNum+= p[i]; sNum += s[i];
        }
        for(int i = 0; i < j.length; i++) {
            jNum += j[i];
        }
        if(jNum != 0 && ((mNum == 0 && pNum == 0) || (mNum == 0 && sNum == 0) || (pNum == 0 && sNum == 0))) {
            if(yaku[32] != -1) {
                yaku[32] = 1; 
            }
        }
    }
    
    public void Sansosanpu() {
        Integer x = -1;
        
        if(men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1) {
            if((men1[0] - men2[0] == -10 && men2[0] - men3[0] == -10) ||
               (men1[0] - men3[0] == -19 && men3[0] - men2[0] == 8) ||
               (men2[0] - men1[0] == 8 && men1[0] - men3[0] == -19) ||
               (men2[0] - men3[0] == -10 && men3[0] - men1[0] == 17) ||
               (men3[0] - men1[0] == 17 && men1[0] - men2[0] == -10) ||
               (men3[0] - men2[0] == 8 && men2[0] - men1[0] == 8)) {
                x = 0;
            }
        }
        if(men1[0] - men1[1] == -1 && men2[0] - men2[1] == -1 && men4[0] - men4[1] == -1) {
            if((men1[0] - men2[0] == -10 && men2[0] - men4[0] == -10) ||
               (men1[0] - men4[0] == -19 && men4[0] - men2[0] == 8) ||
               (men2[0] - men1[0] == 8 && men1[0] - men4[0] == -19) ||
               (men2[0] - men4[0] == -10 && men4[0] - men1[0] == 17) ||
               (men4[0] - men1[0] == 17 && men1[0] - men2[0] == -10) ||
               (men4[0] - men2[0] == 8 && men2[0] - men1[0] == 8)) {
                x = 0;
            }
        }
        if(men1[0] - men1[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1) {
            if((men1[0] - men3[0] == -10 && men3[0] - men4[0] == -10) ||
               (men1[0] - men4[0] == -19 && men4[0] - men3[0] == 8) ||
               (men3[0] - men1[0] == 8 && men1[0] - men4[0] == -19) ||
               (men3[0] - men4[0] == -10 && men4[0] - men1[0] == 17) ||
               (men4[0] - men1[0] == 17 && men1[0] - men3[0] == -10) ||
               (men4[0] - men3[0] == 8 && men3[0] - men1[0] == 8)) {
                x = 0;
            }
        }
        if(men2[0] - men2[1] == -1 && men3[0] - men3[1] == -1 && men4[0] - men4[1] == -1) {
            if((men2[0] - men3[0] == -10 && men3[0] - men4[0] == -10) ||
               (men2[0] - men4[0] == -19 && men4[0] - men3[0] == 8) ||
               (men3[0] - men2[0] == 8 && men2[0] - men4[0] == -19) ||
               (men3[0] - men4[0] == -10 && men4[0] - men2[0] == 17) ||
               (men4[0] - men2[0] == 17 && men2[0] - men3[0] == -10) ||
               (men4[0] - men3[0] == 8 && men3[0] - men2[0] == 8)) {
                x = 0;
            }
        }
        
        if(x == 0 && yaku[33] != -1) {
            yaku[33] = 1;
        }
    }
    
    public void Umenti() {
        Integer mNum = 0;
        Integer pNum = 0;
        Integer sNum = 0;
        Integer kaze = 0;
        Integer san = 0;
        for(int i = 0; i < 9; i++) {
            mNum += all[i];
            pNum += all[i + 9];
            sNum += all[i + 18];
        }
        for(int i = 27; i < 31; i++){
            kaze += all[i];
        }
        for(int i = 31; i < 34; i++) {
            san += all[i];
        }
        if(mNum != 0 && pNum != 0 && sNum != 0 && kaze != 0 && san != 0) {
            if(yaku[34] != -1){
                yaku[34] = 1;
            }
        }
    }
    
    public void Shanchenk() {
        if((j[4] >= 3 && j[5] >= 3) || (j[6] >= 3 && j[5] >= 3) || (j[4] >= 3 && j[6] >= 3)) {
            if(yaku[35] != -1) {
                yaku[35] = 1; yaku[37] = -1;
            }
        }
    }
    
    public void Chanta() {
        Integer[] x = {-1, -1, -1, -1, -1};
        for(int i = 0; i < j.length; i++) {
            if(head == i + 27) { x[0] = 0; }
            if(men1[0] == i + 27) { x[1] = 0;}
            if(men2[0] == i + 27) { x[2] = 0;}
            if(men3[0] == i + 27) { x[3] = 0;}
            if(men4[0] == i + 27) { x[4] = 0;}
        }
        if(men1[0] == 0 || men1[0] == 9 || men1[0] == 18 || men1[2] == 8 || men1[2] == 17 || men1[2] == 26) { x[1] = 0;}
        if(men2[0] == 0 || men2[0] == 9 || men2[0] == 18 || men2[2] == 8 || men2[2] == 17 || men2[2] == 26) { x[2] = 0;}
        if(men3[0] == 0 || men3[0] == 9 || men3[0] == 18 || men3[2] == 8 || men3[2] == 17 || men3[2] == 26) { x[3] = 0;}
        if(men4[0] == 0 || men4[0] == 9 || men4[0] == 18 || men4[2] == 8 || men4[2] == 17 || men4[2] == 26) { x[4] = 0;}
        if(head == 0 || head == 9 || head == 18 || head == 8 || head == 17 || head == 26) { x[0] = 0;}
        
        if(x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 0) {
            if(yaku[36] != -1) {
                yaku[36] = 1;
            }
        }
    }
    
    public void Chenk() {
        if(yaku[37] != -1) {
            if(all[31] >= 3) {yaku[37]++;}
            if(all[32] >= 3) {yaku[37]++;}
            if(all[33] >= 3) {yaku[37]++;}
        }
    }
    
    public void Pinhu() {
        Integer x = 0;
        for(int i = 27; i < 34; i++) {
            if(head == i) {
                x++;
            }
        }
        if((men1[0] - men1[1] == 0) || (men2[0] - men2[1] == 0) || (men3[0] - men3[1] == 0) || (men4[0] - men4[1] == 0)) {
            x++;
        }
        if(x == 0 && yaku[38] != -1) {
            yaku[38] = 1; yaku[48] = -1;
        }
    }
    
    public void Sukui() {
        Integer x = -1;
        for(int i = 0; i < 34; i++) {
            if(all[i] == 4) {
                x = 0;
            }
        }
        if(x == 0 && yaku[39] != -1) {
            yaku[39] = 1;
        }
    }
    
    public void Tanyao() {
        Integer x = 0;
        for(int i = 0; i < j.length; i++) {
            if(j[i] > 0) {
                x++;
            }
        }
        if(m[0] > 0 || m[8] > 0 || p[0] > 0 || p[8] > 0 || s[0] > 0 || s[8] > 0) {
            x++;
        }
        if(x == 0 && yaku[40] != -1) {
            yaku[40] = 1; yaku[48] = -1;
        }
    }
    
    public void Shantonku() {
        if(yaku[41] != -1) {
            if(men2[0] <= 26 && (men1[0] - men1[1] == 0) && (men2[0] - men2[1] == 0) && ((men1[0] - men2[0] == -9) || (men1[0] - men2[0] == -18))) {yaku[41]++;}
            if(men3[0] <= 26 && (men1[0] - men1[1] == 0) && (men3[0] - men3[1] == 0) && ((men1[0] - men3[0] == -9) || (men1[0] - men3[0] == -18))) {yaku[41]++;}
            if(men4[0] <= 26 && (men1[0] - men1[1] == 0) && (men4[0] - men4[1] == 0) && ((men1[0] - men4[0] == -9) || (men1[0] - men4[0] == -18))) {yaku[41]++;}
            if(men3[0] <= 26 && (men2[0] - men2[1] == 0) && (men3[0] - men3[1] == 0) && ((men2[0] - men3[0] == -9) || (men2[0] - men3[0] == -18))) {yaku[41]++;}
            if(men4[0] <= 26 && (men2[0] - men2[1] == 0) && (men4[0] - men4[1] == 0) && ((men2[0] - men4[0] == -9) || (men2[0] - men4[0] == -18))) {yaku[41]++;}
            if(men4[0] <= 26 && (men3[0] - men3[1] == 0) && (men4[0] - men4[1] == 0) && ((men3[0] - men4[0] == -9) || (men3[0] - men4[0] == -18))) {yaku[41]++;}
        }
    }
    
    public void Ipankao() {
        if(yaku[42] != -1) {
            if((men1[0] - men1[1] == -1) && (men2[0] - men2[1] == -1) && (men1[0] - men2[0] == 0)){ yaku[42]++ ;}
            if((men2[0] - men2[1] == -1) && (men3[0] - men3[1] == -1) && (men2[0] - men3[0] == 0)){ yaku[42]++ ;}
            if((men3[0] - men3[1] == -1) && (men4[0] - men4[1] == -1) && (men3[0] - men4[0] == 0)){ yaku[42]++ ;}
        }
    }
    
    public void Sishanfon() {
        if(yaku[43] != -1) {
            if((men1[0] - men1[1] == -1) && (men2[0] - men2[1] == -1) && ((men1[0] - men2[0] == -9) || (men1[0] - men2[0] == -18))) { yaku[43]++; }
            if((men1[0] - men1[1] == -1) && (men3[0] - men3[1] == -1) && ((men1[0] - men3[0] == -9) || (men1[0] - men3[0] == -18))) { yaku[43]++; }
            if((men1[0] - men1[1] == -1) && (men4[0] - men4[1] == -1) && ((men1[0] - men4[0] == -9) || (men1[0] - men4[0] == -18))) { yaku[43]++; }
            if((men2[0] - men2[1] == -1) && (men3[0] - men3[1] == -1) && ((men2[0] - men3[0] == -9) || (men2[0] - men3[0] == -18))) { yaku[43]++; }
            if((men2[0] - men2[1] == -1) && (men4[0] - men4[1] == -1) && ((men2[0] - men4[0] == -9) || (men2[0] - men4[0] == -18))) { yaku[43]++; }
            if((men3[0] - men3[1] == -1) && (men4[0] - men4[1] == -1) && ((men3[0] - men4[0] == -9) || (men3[0] - men4[0] == -18))) { yaku[43]++; }
        }
    }
    
    public void Renryu() {
        if(yaku[44] != -1) {
            if((men1[0] - men1[1] == -1) && (men2[0] - men2[1] == -1) && (men2[0] - men1[0] == 3)) {yaku[44]++;}
            if((men1[0] - men1[1] == -1) && (men3[0] - men3[1] == -1) && (men3[0] - men1[0] == 3)) {yaku[44]++;}
            if((men1[0] - men1[1] == -1) && (men4[0] - men4[1] == -1) && (men4[0] - men1[0] == 3)) {yaku[44]++;}
            if((men2[0] - men2[1] == -1) && (men3[0] - men3[1] == -1) && (men3[0] - men2[0] == 3)) {yaku[44]++;}
            if((men2[0] - men2[1] == -1) && (men4[0] - men4[1] == -1) && (men4[0] - men2[0] == 3)) {yaku[44]++;}
            if((men3[0] - men3[1] == -1) && (men4[0] - men4[1] == -1) && (men4[0] - men3[0] == 3)) {yaku[44]++;}
        }
    }
    
    public void Raoshaohu() {
        if(yaku[45] != -1) {
            if((men1[0] - men1[1] == -1) && (men2[0] - men2[1] == -1) && (men2[0] - men1[0] == 6)) {yaku[45]++;}
            if((men1[0] - men1[1] == -1) && (men3[0] - men3[1] == -1) && (men3[0] - men1[0] == 6)) {yaku[45]++;}
            if((men1[0] - men1[1] == -1) && (men4[0] - men4[1] == -1) && (men4[0] - men1[0] == 6)) {yaku[45]++;}
            if((men2[0] - men2[1] == -1) && (men3[0] - men3[1] == -1) && (men3[0] - men2[0] == 6)) {yaku[45]++;}
            if((men2[0] - men2[1] == -1) && (men4[0] - men4[1] == -1) && (men4[0] - men2[0] == 6)) {yaku[45]++;}
            if((men3[0] - men3[1] == -1) && (men4[0] - men4[1] == -1) && (men4[0] - men3[0] == 6)) {yaku[45]++;}
        }
    }
    
    public void Yaochu() {
        if(yaku[46] != -1) {
            for(int i = 0; i < j.length - 3; i++) {
                if(j[i] >= 3) {
                    yaku[46]++;
                }
            }
            if(men1[0] - men1[1] == 0) {
                if(men1[0] == 0 || men1[0] == 8 || men1[0] == 9 || men1[0] == 17 || men1[0] == 18 || men1[0] == 26) {
                    yaku[46]++;
                }
            }
            if(men2[0] - men2[1] == 0) {
                if(men2[0] == 0 || men2[0] == 8 || men2[0] == 9 || men2[0] == 17 || men2[0] == 18 || men2[0] == 26) {
                    yaku[46]++;
                }
            }
            if(men3[0] - men3[1] == 0) {
                if(men3[0] == 0 || men3[0] == 8 || men3[0] == 9 || men3[0] == 17 || men3[0] == 18 || men3[0] == 26) {
                    yaku[46]++;
                }
            }
            if(men4[0] - men4[1] == 0) {
                if(men4[0] == 0 || men4[0] == 8 || men4[0] == 9 || men4[0] == 17 || men4[0] == 18 || men4[0] == 26) {
                    yaku[46]++;
                }
            }
        }
    }
    
    public void Cheimen() {
        Integer mNum = 0;
        Integer pNum = 0;
        Integer sNum = 0;
        for(int i = 0; i < 9; i++) {
            mNum += all[i]; pNum+= all[i + 9]; sNum += all[i + 18];
        }
        if((mNum == 0 && pNum != 0 && sNum != 0) || (mNum != 0 && pNum == 0 && sNum != 0) || (mNum != 0 && pNum != 0 && sNum == 0)) {
            if(yaku[47] != -1) {
                yaku[47] = 1; 
            }
        }
    }
    
    public void Uzu() {
        Integer jNum = 0;
        for(int i = 0; i < j.length; i++) {
            jNum += j[i];
        }
        if(jNum == 0 && yaku[48] != -1) {
            yaku[48] = 1;
        }
    }
}
