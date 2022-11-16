/* 
=====ケーキ屋プログラム=====
ケーキのラインナップは、以下の通り。
　-ショートケーキ　320円
　-モンブラン　350円
　-チョコレートケーキ　370円
　-いちごのタルト　400円
　-チーズケーキ　300円
ケーキ名、個数をコマンドライン引数として受け取って会計額の計算を行う。
特売期間なので、1000円以上の場合は２割引する。
消費税は８パーセントとし、小数点以下は切り捨てする。
プログラム実行時は、以下のようにコマンドライン引数を指定する
    - User$ チーズケーキ 2 モンブラン 1 イチゴのタルト 1
=========================
*/
public class CalcCakeTotalPrice {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");   // 改行コード
    public static void main(String[] args) {    
        //  定数
        final String CAKE_NAME_SHORT = "ショートケーキ";
        final int CAKE_PRICE_SHORT = 320;        
        final String CAKE_NAME_MON = "モンブラン";
        final int CAKE_PRICE_MON = 350;        
        final String CAKE_NAME_CHOCO = "チョコレートケーキ";
        final int CAKE_PRICE_CHOCO = 370;        
        final String CAKE_NAME_ICHIGO = "いちごのタルト";
        final int CAKE_PRICE_ICHIGO = 400;
        final String CAKE_NAME_CHEEZ = "チーズケーキ";
        final int CAKE_PRICE_CHEEZ = 300;

        int DISCOUNT_PRICE = 1000;   // 割引対象金額
        double DISCOUNT_RATE = 0.8;     // 割引率 
        double TAX = 1.08;  // 消費税
        
        // 変数
        String cakeName = "";   // ケーキ名
        int cakeCount = 0;      // ケーキの個数
        int totalPrice = 0;     // 合計金額
        int payment = 0;        // 支払額

        if (args.length > 0){
            // 支払額を計算する
            for (int i = 0; i < args.length; i += 2){

                // 処理対象のケーキ名、ケーキの個数を確認する
                cakeName = args[i];
                cakeCount = Integer.parseInt(args[i+1]);

                // 商品を読み上げる
                System.out.println(cakeName + "が" + cakeCount + "点");

                // 商品毎に合計金額を計算する
                switch (cakeName){
                    case CAKE_NAME_SHORT:
                        totalPrice += CAKE_PRICE_SHORT * cakeCount;
                        break;
                    case CAKE_NAME_MON:
                        totalPrice += CAKE_PRICE_MON * cakeCount;
                        break;
                    case CAKE_NAME_CHOCO:
                        totalPrice += CAKE_PRICE_CHOCO * cakeCount;
                        break;
                    case CAKE_NAME_ICHIGO:
                        totalPrice += CAKE_PRICE_ICHIGO * cakeCount;
                        break;
                    case CAKE_NAME_CHEEZ:
                        totalPrice += CAKE_PRICE_CHEEZ * cakeCount;
                        break;
                }
            }

            if (totalPrice >= DISCOUNT_PRICE){
                payment = (int)(totalPrice * DISCOUNT_RATE * TAX);
            } else {
                payment = (int)(totalPrice * TAX);
            }

            // メッセージを表示
            System.out.println("合計金額は" + payment + "円です。"
                                + LINE_SEPARATOR + "お買い上げありがとうございます。" );
        } else {
            System.out.println("お気に召す商品がなかったのですね。" 
            + LINE_SEPARATOR + "次回までに準備しておきます。申し訳ございません。"
            + LINE_SEPARATOR + "またのご来店お待ちしております。");

        }
    }
}
