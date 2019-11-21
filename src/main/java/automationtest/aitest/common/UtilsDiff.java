package automationtest.aitest.common;

import java.util.Arrays;
import java.util.List;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.algorithm.DiffException;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;
import com.github.difflib.patch.PatchFailedException;

public class UtilsDiff {

    public static void diffWithOriginal() throws DiffException, PatchFailedException {
        List<String> text1=Arrays.asList("this is a test","add1", "a test");
        List<String> text2=Arrays.asList("this is a testfile","a test");

        //generating diff information.
        Patch<String> diff = DiffUtils.diff(text1, text2);

        //generating unified diff format
        List<String> unifiedDiff = UnifiedDiffUtils.generateUnifiedDiff("original-file.txt", "new-file.txt", text1, diff, 0);

        unifiedDiff.forEach(System.out::println);

        //importing unified diff format from file or here from memory to a Patch
        Patch<String> importedPatch = UnifiedDiffUtils.parseUnifiedDiff(unifiedDiff);

        //apply patch to original list
        List<String> patchedText = DiffUtils.patch(text1, importedPatch);

        System.out.println(patchedText);


        Patch<String> patch = DiffUtils.diff(text1, text2);

      //simple output the computed patch to console
      for (AbstractDelta<String> delta : patch.getDeltas()) {
          System.out.println(delta);
      }
    }

}
