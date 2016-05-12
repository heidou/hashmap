package mengka.MessageFormat_01;

import java.text.MessageFormat;

public class MessageFormat_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MessageFormat form = new MessageFormat("西瓜地里种：  \"{1}\" + {0} ~！");
		
		
//		double[] aaIndexs = { 0, 1, 2 };
//		String[] aaStrings = { "白菜", "青菜", "{0,number}" };
//		
//		
//		ChoiceFormat fileform = new ChoiceFormat(aaIndexs, aaStrings);
//		form.setFormatByArgumentIndex(0, fileform);

		int fileCount = 1273;
		String diskName = "mengka";
		Object[] testArgs = { new Long(fileCount), diskName };

		System.out.println(form.format(testArgs));

	}

}
