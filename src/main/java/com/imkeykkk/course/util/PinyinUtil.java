package com.imkeykkk.course.util;

import com.imkeykkk.course.service.UserService;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;

//为什么这个工具类不用@Component呢，实际上也可以，但是因为只有一个静态方法，所以不需要spring管理，详见笔记
public class PinyinUtil {


    public static String toPinyin(String chinese) {
        StringBuilder result = new StringBuilder();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        for (char c : chinese.toCharArray()) {
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]")) {
                try {
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    if (pinyinArray != null && pinyinArray.length > 0) {
                        result.append(pinyinArray[0]);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString().toLowerCase();
    }
}