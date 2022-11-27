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
        // カードの準備
        int[][] card = new int[5][5];
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <99; i++){
            list.add(i);
        }

        // リストをシャッフル
        Collections.shuffle(list);
        
        int n = 0;
        for (int j = 0; j < 5; j++){
            for(int i = 0; i < 5; i++){
                card[j][i] = list.get(n);
                n++;
            }
        }

        // カードのタイトル
        System.out.println("   B |  I  |  N  |  G  |  O");

        //　カード部分
        for (int row = 0; row < 5; row++){
            for (int cell = 0; cell < 5; cell++){
                // ど真ん中は最初から空けておく
                if (row == 2 && cell == 2){
                    System.out.print("  ☆  |");
                }else{
                    System.out.printf("%3d",card[cell][row]);

                    // 5列目の後ろは縦線つけない
                    if (cell != 4){
                        System.out.print("  |");
                    }
                }
            }
            System.out.println(LINE_SEPARATOR);
        }
    }
}
