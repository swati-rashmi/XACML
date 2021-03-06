/*
 *                        AT&T - PROPRIETARY
 *          THIS FILE CONTAINS PROPRIETARY INFORMATION OF
 *        AT&T AND IS NOT TO BE DISCLOSED OR USED EXCEPT IN
 *             ACCORDANCE WITH APPLICABLE AGREEMENTS.
 *
 *          Copyright (c) 2018 AT&T Knowledge Ventures
 *              Unpublished and Not for Publication
 *                     All Rights Reserved
 */

package com.att.research.xacml.std.datatypes;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class PortRangeTest {

	@Test
	public void test() throws ParseException {
		PortRange range1 = new PortRange(0, 9998);
		assertNotEquals(range1, new Object());
		assertEquals("{portMin=0portMax=9998}", range1.toString());
		assertEquals(range1, range1);
		assertTrue(range1.hashCode() > 0);
		assertTrue(range1.contains(0));
		assertFalse(range1.contains(9999));
		assertFalse(range1.contains(-1));
		
		PortRange range2 = PortRange.newInstance("0-9998");
		assertEquals(range1, range2);
	
		assertEquals("0-9998", range2.stringValue());
		
		assertNull(PortRange.newInstance(null));
	}

	@Test(expected = ParseException.class)
	public void testParse00() throws ParseException {
		PortRange.newInstance("00-a");
	}

	@Test(expected = ParseException.class)
	public void testParse01() throws ParseException {
		PortRange.newInstance("00-09-99");
	}
}
