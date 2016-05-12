package mengka.ChoiceFormat_01;

import java.text.ChoiceFormat;
import java.text.ParsePosition;


/**
 * ChoiceFormat ������ʽӦ�õ�ĳ����Χ��������ͨ�������� MessageFormat �д�����
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
