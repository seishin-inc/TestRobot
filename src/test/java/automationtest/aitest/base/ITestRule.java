package automationtest.aitest.base;

/***
 * テスト規則
 * @author kai
 *
 */
public interface ITestRule {
	/***
	 * テストデータの入力規則
	 */
	void input();

	/***
	 * テストケースの結果はNG・OKかの判断規則
	 */
	void resultJudgement();

}
