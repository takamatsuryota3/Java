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
        for (int i = 1; i <99; i++){
            list.add(i);
        }
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

        for (int bingoNum = 1; bingoNum <= 10; bingoNum++){
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
        }
    }
}
