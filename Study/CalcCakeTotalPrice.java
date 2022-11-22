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
最終的な合計金額は以下のように表示する
    合計金額はXXX円です。
    お買い上げありがとうございます。
「数字　ケーキ名」もしくは「数字　数字」だった場合は、以下のように表示する
    ケーキ名、数量の順で注文してください。
    以下のように注文お願いいたします。
    ex. ショートケーキを２つ注文する場合
    ショートケーキ 2
「ケーキ名　ケーキ名」だった場合は、以下のように表示する
    input: 入力値 message: 個数は数字でお願いします。
ラインナップにない商品が注文された場合は、合計金額に含めず、以下のメッセージを表示する
（商品名と個数は出力する）
    input: 入力値　message: こちらの商品はラインナップにない商品です。
コマンドライン引数が、奇数だった場合、以下のように表示する
    注文を受付できませんでした。申し訳ございません。
    以下のように注文お願いいたします。
    ex. ショートケーキを２つ注文する場合
    ショートケーキ 2
コマンドライン引数なしで実行した場合、以下のように表示する
    お気に召す商品がなかったのですね。
    次回までに準備しておきます。申し訳ございません。
    またのご来店お待ちしております。
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
        int nowTotalPrice = 0;  // 合計金額の途中経過
        int payment = 0;        // 支払額

        if (args.length > 0){
            if (args.length % 2 == 0){
                // 支払額を計算する
                for (int i = 0; i < args.length; i += 2){
                    // 処理対象のケーキ名、ケーキの個数を確認する
                    boolean cakeNameIsNumeric = args[i].chars().allMatch(Character::isDigit);

                    // ケーキ名が数字かどうかを確認 (「数字、ケーキ名」「数字、数字」のパターンを確認)
                    if (cakeNameIsNumeric == true){
                        System.out.println("ケーキ名、数量の順で注文してください。"
                                        + LINE_SEPARATOR + "以下のように注文お願いいたします。"
                                        + LINE_SEPARATOR + "ex. ショートケーキを２つ注文する場合"
                                        + LINE_SEPARATOR + "ショートケーキ 2");
                        continue;
                    }else {
                        cakeName = args[i];
                    }
                    try {
                        cakeCount = Integer.parseInt(args[i+1]);
                    } catch (Exception e) {
                        // 数量が数字じゃない場合を確認（ここでは、「ケーキ名　ケーキ名」のパターンを確認）
                        System.out.println("input: " + args[i] + " " + args[i+1] + " message: 個数は数字でお願いします。");
                        continue;
                    }

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
                        default:
                        // ラインナップにない商品を注文した場合、合計金額に含めない
                        totalPrice += 0;
                    }
                    // 商品を読み上げる
                    System.out.println(cakeName + "が" + cakeCount + "点");
                    
                    if (totalPrice != nowTotalPrice){
                        // 現時点での合計金額を覚えておく
                        nowTotalPrice = totalPrice;
                    } else {
                        // 商品ラインナップにない商品が注文された場合の確認
                        System.out.println("input: " + args[i] + " " + args[i+1] + " message: こちらの商品はラインナップにない商品です。");
                    }
                }

                if (totalPrice >= DISCOUNT_PRICE){
                    payment = (int)(totalPrice * DISCOUNT_RATE * TAX);
                } else {
                    payment = (int)(totalPrice * TAX);
                }

                // メッセージを表示
                if (payment > 0){
                    System.out.println("合計金額は" + payment + "円です。"
                                        + LINE_SEPARATOR + "お買い上げありがとうございます。" );
                }
            } else {
                // コマンドライン引数が奇数だった場合
                System.out.println("注文を受付できませんでした。申し訳ございません。"
                + LINE_SEPARATOR + "以下のように注文お願いいたします。"
                + LINE_SEPARATOR + "ex. ショートケーキを２つ注文する場合"
                + LINE_SEPARATOR + "ショートケーキ 2");
            }
        } else {
            // コマンドライン引数指定なしで実行した場合
            System.out.println("お気に召す商品がなかったのですね。" 
            + LINE_SEPARATOR + "次回までに準備しておきます。申し訳ございません。"
            + LINE_SEPARATOR + "またのご来店お待ちしております。");
        }
    }
}
