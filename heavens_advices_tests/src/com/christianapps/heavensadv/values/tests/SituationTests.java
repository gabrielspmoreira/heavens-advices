package com.christianapps.heavensadv.values.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.christianapps.heavensadv.values.BibleVerse;
import com.christianapps.heavensadv.values.Situation;
import java.util.ArrayList;

public class SituationTests {
	
	private final String VERSE_ID1 = "John 3:16";
	private final String VERSE_TEXT1 = "16 For God so loved the world that he gave his one and only Son, that whoever believes in him shall not perish but have eternal life.";
	
	private final String VERSE_ID2 = "Galatians 3:1";
	private final String VERSE_TEXT2 = "1 You foolish Galatians! Who has bewitched you? Before your very eyes Jesus Christ was clearly portrayed as crucified.";
	
	private final String SIT_ID1 = "temptation";
	private final String SIT_NAME1 = "... being tempted";
	private final String SIT_ID2 = "angry";
	private final String SIT_NAME2 = "... felling angry";
	
	private ArrayList<BibleVerse> testBibleVerses;
	
	private Situation testSituation;
	
	@Before
	public void setUp() throws Exception {
		testBibleVerses = new ArrayList<BibleVerse>();
		testBibleVerses.add(new BibleVerse(VERSE_ID1, VERSE_TEXT1));
		testBibleVerses.add(new BibleVerse(VERSE_ID2, VERSE_TEXT2));
		
		testSituation = new Situation(SIT_ID1, SIT_NAME1, testBibleVerses);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSituation() {
		assertEquals(SIT_ID1, testSituation.getId());
		assertEquals(SIT_NAME1, testSituation.getName());		
		assertArrayEquals(testBibleVerses.toArray(), testSituation.getBibleVerses().toArray());
	}

	@Test
	public void testSetGetId() {
		testSituation.setId(SIT_ID2);
		assertEquals(SIT_ID2, testSituation.getId());
	}
	
	@Test
	public void testSetGetName() {
		testSituation.setName(SIT_NAME2);
		assertEquals(SIT_NAME2, testSituation.getName());
	}

	@Test
	public void testSetGetBibleVerses() {
		ArrayList<BibleVerse> testBibleVerses2 = new ArrayList<BibleVerse>();
		testBibleVerses2.add(new BibleVerse(VERSE_ID2, VERSE_TEXT2));
		testSituation.setBibleVerses(testBibleVerses2);
		assertArrayEquals(testBibleVerses2.toArray(), testSituation.getBibleVerses().toArray());
	}

	@Test
	public void testToString() {
		assertEquals(SIT_NAME1, testSituation.getName());
	}

	@Test
	public void testParse() {
		Situation situation = Situation.parse(SIT_ID1 + "|" + SIT_NAME1, 
											  new String[] {VERSE_ID1 + "|" + VERSE_TEXT1, 
															VERSE_ID2 + "|" + VERSE_TEXT2});
		assertEquals(SIT_ID1, situation.getId());
		assertEquals(SIT_NAME1, situation.getName());		
		assertArrayEquals(testBibleVerses.toArray(), situation.getBibleVerses().toArray());
	}
}
