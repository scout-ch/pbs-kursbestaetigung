package ch.smartness.pbs.reporting.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

import ch.smartness.pbs.reporting.core.PdfText.Style;

public class ListElementTest {

	@Test
	public void hasNoSubListElements() {
		PdfText pdfText = PdfText.create("hallo", Style.bold);
		ListElement testee = ListElement.create(pdfText);
		PdfText actual = testee.getValue();
		Assert.assertThat(actual, is(equalTo(pdfText)));
		Assert.assertFalse(testee.hasSubListElements());
	}

	@Test
	public void hasSubListElements() {
		PdfText pdfText = PdfText.create("hallo", Style.bold);
		ListElement testee = ListElement.create(pdfText, ListElement.create(PdfText.create("a", Style.bold)));
		PdfText actual = testee.getValue();
		Assert.assertThat(actual, is(equalTo(pdfText)));
		Assert.assertTrue(testee.hasSubListElements());
	}
}
