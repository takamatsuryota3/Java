import java.util.Random;

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
        // 乱数
        Random rnd = new Random();
        // カードのタイトル
        System.out.println("   B |  I  |  N  |  G  |  O");

        //　カード部分
        for (int row = 0; row < 5; row++){
            for (int cell = 0; cell < 5; cell++){
                // ど真ん中は最初から空けておく
                if (row == 2 && cell == 2){
                    System.out.print("  ☆  |");
                }else{
                    int val = (int)(rnd.nextDouble() * 100.0);
                    System.out.printf("%3d", val);

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
