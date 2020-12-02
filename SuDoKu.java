package sudokuGUIvision;

import static sudokuGUIvision.DataClass.suDoKu;


public class SuDoKu {
    static int[][] shuDu = suDoKu;
    static int[][] shuDuArray = new int[9][9];

//    public static void main(String[] args) {
//        backTrace(0,0);
//    }
    public SuDoKu(){
        for(int i=0;i<shuDu.length;i++){
            System.arraycopy(shuDu[i],0,shuDuArray[i],0,shuDu[i].length);
        }
    }

    public  void backTrace(int line,int row){
        if (line==8 && row==9){
            System.out.println("解题成功，数独：");
            printArray(shuDuArray);
            System.out.println("的解为：");
            printArray(shuDu);
            return;
        }
        if (row==9){
            line++;
            row=0;
        }
        if (shuDu[line][row]==0){
            for (int k=1;k<=9;k++){
                if (!checkRepeat(line,row,k)){
                    shuDu[line][row] = k;
                    backTrace(line,row+1);
                    shuDu[line][row] = 0;
                }
            }
        }else {
            backTrace(line,row+1);
        }
    }

    /**
     * 检查同行同列同宫格中有没有重复的元素
     * @param line 行
     * @param row 列
     * @param k 值
     * @return 重返回true，没重返回false
     */
    static boolean checkRepeat(int line,int row,int k){
        // 判断同行
        for (int i=0;i<9;i++){
            if (k==shuDu[line][i] && row!=i){
                return true;
            }
        }
        // 判断同列
        for (int j=0;j<9;j++){
            if (k==shuDu[j][row] && line!=j){
                return true;
            }
        }
        // 判断九宫格
        for (int i=0;i<3;i++){
            int _line = line/3;
            int _row = row/3;
            for (int j=0;j<3;j++){
                if (k==shuDu[_line*3+i][_row*3+j] &&
                        !(line==_line+i && row==_row+j)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检查所有格子是否已满
     * @param shuDU 数独数组
     * @return 没满true,满false
     */
    static boolean checkOk(int[][] shuDU){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (shuDU[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 打印数组
     */
    static void printArray(int[][] shuDu){
        if (checkOk(shuDu)){
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    if (shuDu[i][j]==0){
                        System.out.print("X"+"  ");
                    }else {
                        System.out.print(shuDu[i][j]+"  ");
                    }
                }
                System.out.println();
            }
        }else {
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    System.out.print(shuDu[i][j]+"  ");
                }
                System.out.println();
            }
        }
    }
}