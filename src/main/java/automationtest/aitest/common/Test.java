package automationtest.aitest.common;

import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.PatchFailedException;

public class Test {
    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ

      try {
        UtilsDiff.diffWithOriginal();
      } catch (PatchFailedException | DiffException e) {
        // TODO 自動生成された catch ブロック
        e.printStackTrace();
      }
    }

}
