package gradingTools.comp999junit.assignment1.testcases;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.BasicJUnitUtils;

import org.junit.Assert;
import org.junit.Test;

import util.annotations.MaxValue;
@MaxValue(3)
public class PointPrintTest extends AbstractPointTest{

	@Override
	protected void checkComputations(double aComputedAngle,
			double aComputedRadius, double aCorrectAngle, double aCorrectRadius) {
		// TODO Auto-generated method stub
		
	}
	@Test
	// all or nothing for radius
	public void test() {
		try {
			int anX = 5;
			int aY = 10;
			createPoint(anX, aY);
			BasicProjectExecution.redirectOutput();
//			String aHeader = "The point is:";
//			point.print(aHeader, point);
//			String aHeader = "The point is:";
			point.print();
			String anOutput = BasicProjectExecution.restoreOutputAndGetRedirectedOutput();
			Assert.assertTrue(anOutput + " Does not contain prints of " + anX + " " + aY, 
					anOutput.contains("" + anX) &&
					anOutput.contains("" + aY));
		} catch (Exception e) {
			BasicJUnitUtils.assertTrue(e, fractionComplete);
		}
	}

}
