package automationtest.aitest.navigator.factory;

import automationtest.aitest.navigator.INavigator;
/**
 * singleton design pattern
 * @author kai
 *
 */
public class NavigatorFactory {

	private static NavigatorFactory naviFactory = new NavigatorFactory();

	/**
	 * コンストラクタ
	 */
	private NavigatorFactory() {

	}

	/**
	 * ファクトリーのインスタンスを作成する
	 * @return
	 */
	public static NavigatorFactory getInstance() {
		return naviFactory;
	}

	/**
	 * 画面単位の遷移モジュールの作成
	 * @return
	 */
	public INavigator createNavigator() {
		// TODO 自動生成されたメソッド・スタブ
        INavigator navi= null;
        return navi;
	}

}
