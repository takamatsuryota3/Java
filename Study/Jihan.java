// 投入出来る硬貨は、10円玉、50円玉、100円玉、500円玉とする

public class Jihan {
    public static void main(String[] args) {
        int coinNum = args.length; // 投入された硬貨の枚数
        int coinChk = 0;    // 確認する硬貨
        int coinSum = 0;    //投入された硬貨の合計

        for (int i = 0; i < coinNum; i++){
            // 使用可能な硬貨か確認する
            try {
                coinChk = Integer.parseInt(args[i]);    // コマンドライン引数をint型に変換
            } catch (Exception e){

                System.out.println("硬貨以外を入れないでください。自動販売機が壊れます。");
                // 次のループに行く
                continue;
            }
            // 確認する硬貨が投入可能な硬貨か確認
            if (coinChk == 10 || coinChk == 50 || coinChk == 100 || coinChk == 500){
                System.out.println(coinChk +"円");
                coinSum += coinChk;
            } else if(coinChk == 1 || coinChk == 5){
                System.out.println(coinChk + "円は使えません。申し訳ございません。");
            }else {
                System.out.println("使用出来ない硬貨が投入されました。");
            }    
        }
        // 投入された合計金額を表示
        System.out.println("合計金額ば" + coinSum + "円です。");
    }
}
