package gradingTools.comp999junit.assignment1.testcases;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.NotRunnableException;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.junit.NotesAndScore;

import org.junit.Assert;
import org.junit.Test;

import util.annotations.MaxValue;
@MaxValue(5)
public  class PointMainTest extends AbstractPointTest {
	
	protected  String runMain (String[] anArgs, String... anInput) throws Throwable {
		return BasicProjectExecution.callCorrespondingMain(Main.class, anArgs, anInput).out;

	}
	@Test
	public void test() {
		try {
			testMain(10, 10, 14.142, Math.PI/4);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 45 degree angle
	}
	protected  void testMain(int theX, int theY, double aCorrectRadius,
			double aCorrectAngle) throws Throwable {
		double fractionComplete = 0.0;
//		String anInput = theX + "\n" + theY;
//		String anOutput = runMain(new String[]{}, anInput);
		try {

		String anOutput = runMain(new String[]{}, "" + theX, "" + theY);
//		String anOutput2 = runMain(new String[]{}, "" + theX, "" + theY);

		
		String[] anOutputLines = anOutput.split("\n");
		if (anOutputLines.length != 2) {
			Assert.assertTrue("Expecting exactly two output lines" + NotesAndScore.PERCENTAGE_MARKER + fractionComplete, false);
		}
		fractionComplete += 0.1;
			Double aComputedRadius = Double.parseDouble (anOutputLines[0]);
			Double aComputedAngle = Double.parseDouble(anOutputLines[1]);
			checkComputations(aComputedAngle, aComputedRadius, aCorrectAngle, aCorrectRadius);		


		} catch (NotRunnableException e) {
			BasicJUnitUtils.assertTrue(e, fractionComplete);

		} catch (Exception e) {
			Assert.assertTrue("One or more output does not parse as a double:" + fractionComplete, false);
		}
		
	}
	@Override
	protected void checkComputations(double aComputedAngle,
			double aComputedRadius, double aCorrectAngle, double aCorrectRadius) {
		assertAngle(aComputedAngle, aCorrectAngle);
		assertRadius(aComputedRadius, aCorrectRadius);
		// TODO Auto-generated method stub
		
	}
	
}
