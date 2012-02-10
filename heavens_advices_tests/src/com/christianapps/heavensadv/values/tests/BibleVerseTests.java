package com.christianapps.heavensadv.values.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.christianapps.heavensadv.values.BibleVerse;

public class BibleVerseTests {
	private final String VERSE_ID1 = "John 3:16";
	private final String VERSE_TEXT1 = "16 For God so loved the world that he gave his one and only Son, that whoever believes in him shall not perish but have eternal life.";
	
	private final String VERSE_ID2 = "Galatians 3:1";
	private final String VERSE_TEXT2 = "1 You foolish Galatians! Who has bewitched you? Before your very eyes Jesus Christ was clearly portrayed as crucified.";
	
	private BibleVerse testBibleVerse;

	@Before
	public void setUp() throws Exception {
		testBibleVerse = new BibleVerse(VERSE_ID1, VERSE_TEXT1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBibleVerse() {
		assertEquals(VERSE_ID1, testBibleVerse.getVerseId());
		assertEquals(VERSE_TEXT1, testBibleVerse.getVerseText());
	}

	@Test
	public void testSetGetVerseId() {
		testBibleVerse.setVerseId(VERSE_ID2);
		assertEquals(VERSE_ID2, testBibleVerse.getVerseId());
	}

	@Test
	public void testGetSetVerseText() {
		testBibleVerse.setVerseText(VERSE_TEXT2);
		assertEquals(VERSE_TEXT2, testBibleVerse.getVerseText());
	}

	@Test
	public void testToString() {
		assertEquals(VERSE_ID1, testBibleVerse.toString());
	}
	
	@Test
	public void testParse() {
		BibleVerse bibleVerse = BibleVerse.parse(VERSE_ID1 + "|" + VERSE_TEXT1);
		assertEquals(VERSE_ID1, bibleVerse.getVerseId());
		assertEquals(VERSE_TEXT1, bibleVerse.getVerseText());
	}

}
