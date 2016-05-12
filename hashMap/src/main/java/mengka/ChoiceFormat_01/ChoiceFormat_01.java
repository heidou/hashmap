package mengka.ChoiceFormat_01;

import java.text.ChoiceFormat;
import java.text.ParsePosition;


/**
 * ChoiceFormat 允许将格式应用到某个范围的数。它通常用于在 MessageFormat 中处理复数
 * 
 * @author mengka.hyy
 *
 */
public class ChoiceFormat_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] limits = { 1, 2, 3, 4, 5, 6, 7 };
		String[] dayOfWeekNames = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri",
				"Sat" };

		ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);
		ParsePosition status = new ParsePosition(0);
		
		for (double i = 0.0; i <= 8.0; ++i) {
			status.setIndex(0);

			String aaString = form.format(i);
			Number bbString = form.parse(aaString, status);
			System.out.println("i = " + i + " <" + aaString + "," + bbString
					+ ">");
		}

	}

}
