import java.util.ArrayList;
import java.util.Collections;

// ==========ビンゴゲーム==========
// ビンゴゲームの流れは、以下の通り
// 1. カードの準備
// 2. カードの表示
// 3. くじを引き、番号を表示
// 4. 表示された番号が、カードの中にあれば、番号部分を穴あけ
// 5. カードを表示
// 6. ビンゴか判定（ビンゴなら終了、ビンゴじゃなければ、3に戻り繰り返す）
// ==============================

public class Bingo {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");   // 改行コード
    public static void main(String[] args) {
        // 1. カードの準備
        int[][] card = new int[5][5];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 99; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        
        int n = 0;
        for (int j = 0; j < 5; j++){
            for(int i = 0; i < 5; i++){
                if (j == 2 && i == 2){
                    // 最初から空いている真ん中
                    card[j][i] = 0;
                }else{
                    card[j][i] = list.get(n);
                }
                n++;
            }
        }

        // カードのタイトル
        System.out.println("   B |  I  |  N  |  G  |  O");

        //　2. カードの表示
        for (int j = 0; j < 5; j++){
            for (int i = 0; i < 5; i++){
                // ど真ん中は最初から空けておく
                if (i == 2 && j == 2){
                    System.out.print("  ☆  |");
                }else{
                    System.out.printf("%3d",card[j][i]);

                    // 5列目の後ろは縦線つけない
                    if (i != 4){
                        System.out.print("  |");
                    }
                }
            }
            System.out.println(LINE_SEPARATOR);
        }

        int  bingo = 1;
        for (int bingoNum = 1; bingoNum < 99; bingoNum++){
            // 3. くじを引き、番号を表示
            Collections.shuffle(list);
            int number = list.get(bingoNum);
            System.out.println(bingoNum + "回目：" + number);

            // 4. 表示された番号が、カードの中にあれば、番号部分を穴あけ
            for ( int j = 0; j < 5; j++){
                for (int i = 0; i < 5; i++){
                    if(card[j][i] == number){
                        card[j][i] = 0;
                    }
                }
            }

            // カードのタイトル
            System.out.println("   B |  I  |  N  |  G  |  O");

            // 5. カードの表示
            for (int j = 0; j < 5; j++){
                for (int i = 0; i < 5; i++){
                    // ど真ん中は最初から空けておく
                    if (i == 2 && j == 2){
                        System.out.print("  ☆  |");
                    }else if (card[j][i] == 0){
                        if (i != 4){
                            System.out.print("  ●  |");
                        }else{
                            System.out.print("  ●  ");
                        }
                    }
                    else{
                        System.out.printf("%3d",card[j][i]);

                        // 5列目の後ろは縦線つけない
                        if (i != 4){
                            System.out.print("  |");
                        }
                    }
                }
                System.out.println(LINE_SEPARATOR);
            }

            // 判定
            // ビンゴ
            // 縦
            if (card[0][0] + card[1][0] + card[2][0] + card[3][0] + card[4][0] == 0) break;
            if (card[0][1] + card[1][1] + card[2][1] + card[3][1] + card[4][1] == 0) break;
            if (card[0][2] + card[1][2] + card[2][2] + card[3][2] + card[4][2] == 0) break;
            if (card[0][3] + card[1][3] + card[2][3] + card[3][3] + card[4][3] == 0) break;
            if (card[0][4] + card[1][4] + card[2][4] + card[3][4] + card[4][4] == 0) break;

            // 横
            if (card[0][0] + card[0][1] + card[0][2] + card[0][3] + card[0][4] == 0) break;
            if (card[1][0] + card[1][1] + card[1][2] + card[1][3] + card[1][4] == 0) break;
            if (card[2][0] + card[2][1] + card[2][2] + card[2][3] + card[2][4] == 0) break;
            if (card[3][0] + card[3][1] + card[3][2] + card[3][3] + card[3][4] == 0) break;
            if (card[4][0] + card[4][1] + card[4][2] + card[4][3] + card[4][4] == 0) break;
            // 斜め
            if (card[0][0] + card[1][1] + card[2][2] + card[3][3] + card[4][4] == 0) break;            
            if (card[0][4] + card[1][3] + card[2][2] + card[3][1] + card[4][0] == 0) break;
            
            bingo++;
        }
        if (bingo < 99){
            System.out.println("ビンゴ！！！");
        }
    }
}
